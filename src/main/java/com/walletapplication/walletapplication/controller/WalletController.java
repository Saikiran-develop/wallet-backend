package com.walletapplication.walletapplication.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walletapplication.walletapplication.dto.LoginWallet;
import com.walletapplication.walletapplication.dto.Wallet;
import com.walletapplication.walletapplication.dto.WalletDto;
import com.walletapplication.walletapplication.exception.WalletException;
import com.walletapplication.walletapplication.service.WalletService;
import com.walletapplication.walletapplication.service.WalletServiceImpl;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class WalletController {
    //private WalletService walletService=new WalletServiceImpl();
	private WalletService walletService = new WalletServiceImpl();
    
    @GetMapping("/")
    public String firstPage() {
        return "Welcome to wallet app";
    }
    @PostMapping("wallet/register")
	public Wallet addWallet(@RequestBody Wallet wallet) throws WalletException, SQLException {
		return this.walletService.registerWallet(wallet);
	}
	
	@GetMapping("wallet/{id}")
	public Double getWalletBalanceById(@PathVariable("id") Integer id) throws WalletException, SQLException {
		return this.walletService.showWalletBalance(id);
		
	}
	
	@PatchMapping("wallet")
	public Double addFundsToWallet(@RequestBody WalletDto walletDto) throws WalletException, SQLException {
		return this.walletService.addFundsToWallet(walletDto.getIdOne(),walletDto.getAmount());
		
	}
	
	@PostMapping("wallet/fund")
	public Boolean fundTransfer(@RequestBody WalletDto walletDto) throws WalletException, SQLException {
		return this.walletService.fundTransfer(walletDto.getIdOne(),walletDto.getIdTwo(),walletDto.getAmount());
		
	}
	@PostMapping("wallet/login")
	public boolean checkLogin(@RequestBody LoginWallet wallet) throws WalletException, SQLException {
		return this.walletService.login(wallet.getId(),wallet.getPassword());
	}
	@PostMapping("wallet/unregister")
	public Wallet unRegisterAccount(@RequestBody LoginWallet wallet) throws WalletException, SQLException {
		return this.walletService.unRegisterWallet(wallet.getId(), wallet.getPassword());
	}
}
