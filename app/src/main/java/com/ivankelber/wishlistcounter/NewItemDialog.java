package com.ivankelber.wishlistcounter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ivankelber on 9/6/17.
 */
public class NewItemDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("lol sup?");
        builder.setPositiveButton("hi :3", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("POSITIVE:", "hi :3");
            }
        });

        builder.setNegativeButton("bye >:(", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("NEGATIVE:", "bye >:(");
            }
        });

        return builder.create();
    }
}
