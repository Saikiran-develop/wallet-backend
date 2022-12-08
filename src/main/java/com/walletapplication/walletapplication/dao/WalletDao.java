package com.walletapplication.walletapplication.dao;

import java.sql.SQLException;

import com.walletapplication.walletapplication.dto.Wallet;
import com.walletapplication.walletapplication.exception.WalletException;

public interface WalletDao {
	//CRUD
	Wallet addWallet(Wallet newWallet)throws WalletException,SQLException;
	Wallet getWalletById(Integer walletId)throws WalletException,SQLException;
	Wallet updateWallet(Wallet updateWallet)throws WalletException,SQLException;
	Wallet deleteWalletById(Integer walletID)throws WalletException,SQLException;
}
