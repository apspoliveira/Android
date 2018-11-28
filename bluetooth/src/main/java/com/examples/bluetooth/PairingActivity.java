package com.examples.bluetooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.bluetooth.BluetoothDevice;
import com.google.android.things.bluetooth.BluetoothConnectionManager;
import com.google.android.things.bluetooth.BluetoothPairingCallback;
import com.google.android.things.bluetooth.PairingParams;

public class PairingActivity extends AppCompatActivity {

    BluetoothConnectionManager mBluetoothConnectionManager;
    
    @Override 
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	mBluetoothConnectionManager = BluetoothConnectionManager.getInstance();
	mBluetoothConnectionManager.registerPairingCallback(mBluetoothPairingCallback);
    }

    /*@Override 
	protected void onDestroy() {
	super.onDestroy();
	//mBluetoothConnectionManager.unregisterPairingCallback(mBluetoothPairingCallback);
	}*/

    private void startPairing(BluetoothDevice remoteDevice) {
	mBluetoothConnectionManager.initiatePairing(remoteDevice);
    }

    private BluetoothPairingCallback mBluetoothPairingCallback = new BluetoothPairingCallback() {
	    
	    /*@Override 
		public void onPairingInitiated(BluetoothDevice bluetoothDevice,
					       PairingParams pairingParams) {
		// Handle incoming pairing request or confirmation of outgoing pairing request
		//handlePairingRequest(bluetoothDevice, pairingParams);
	    }

	    @Override 
		public void onPaired(BluetoothDevice bluetoothDevice) {
		// Device pairing complete 
	    }

	    @Override 
		public void onUnpaired(BluetoothDevice bluetoothDevice) {
		// Device unpaired
	    }

	    @Override 
		public void onPairingError(BluetoothDevice bluetoothDevice, 
					   BluetoothPairingCallback.PairingError pairingError) {
		// Something went wrong 
		}*/
	};

    /*private void handlePairingRequest(BluetoothDevice bluetoothDevice, PairingParams pairingParams) {
	switch (pairingParams.getPairingType()) {
	case PairingParams.PAIRING_VARIANT_DISPLAY_PIN:
	case PairingParams.PAIRING_VARIANT_DISPLAY_PASSKEY:
	    // Display the required PIN to the user 
	    //Log.d(TAG, "Display Passkey - " + pairingParams.getPairingPin());
	    break;
	case PairingParams.PAIRING_VARIANT_PIN:
	case PairingParams.PAIRING_VARIANT_PIN_16_DIGITS:
	    // Obtain PIN from the user
	    String pin = "";
	    // Pass the result to complete pairing
	    mBluetoothConnectionManager.finishPairing(bluetoothDevice, pin);
	    break;
	case PairingParams.PAIRING_VARIANT_CONSENT:
	case PairingParams.PAIRING_VARIANT_PASSKEY_CONFIRMATION:
	    // Show confirmation of pairing to the user
	    
	    // Complete the pairing process
	    mBluetoothConnectionManager.finishPairing(bluetoothDevice);
	    break;
	}
	}*/
}