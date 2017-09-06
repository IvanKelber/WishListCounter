package com.ivankelber.wishlistcounter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by ivankelber on 9/6/17.
 */
public class NewItemDialog extends DialogFragment{

    String positive_text;
    String negative_text;
    DialogInterface.OnClickListener positive;
    DialogInterface.OnClickListener negative;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Add a new item?");
        builder.setPositiveButton(positive_text, positive);

        builder.setNegativeButton(negative_text, negative);

        return builder.create();
    }

    public void setPositive(String text, DialogInterface.OnClickListener listener) {
        this.positive = listener;
        this.positive_text=text;
    }

    public void setNegative(String text, DialogInterface.OnClickListener listener) {
        this.negative = listener;
        this.negative_text=text;
    }


}
