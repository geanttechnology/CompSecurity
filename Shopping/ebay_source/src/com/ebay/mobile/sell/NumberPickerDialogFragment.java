// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.NumberPicker;

public class NumberPickerDialogFragment extends DialogFragment
{
    public static interface NumberPickerListener
    {

        public abstract void onNumberSelected(int i);
    }


    private String captions[];
    protected NumberPicker numberPicker;
    protected NumberPickerListener numberPickerListener;
    private int startOffset;

    public NumberPickerDialogFragment()
    {
        startOffset = 0;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.support.v7.app.AlertDialog.Builder(getActivity());
        bundle.setTitle(0x7f0709a6);
        numberPicker = new NumberPicker(getActivity());
        numberPicker.setMaxValue(captions.length - 1);
        numberPicker.setMinValue(0);
        numberPicker.setDisplayedValues(captions);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(0x60000);
        numberPicker.setValue(startOffset);
        bundle.setView(numberPicker);
        bundle.setPositiveButton(getString(0x7f070738), new android.content.DialogInterface.OnClickListener() {

            final NumberPickerDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (numberPickerListener != null)
                {
                    numberPickerListener.onNumberSelected(numberPicker.getValue());
                }
                dialoginterface.dismiss();
            }

            
            {
                this$0 = NumberPickerDialogFragment.this;
                super();
            }
        });
        bundle.setNegativeButton(getString(0x7f0701cc), new android.content.DialogInterface.OnClickListener() {

            final NumberPickerDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = NumberPickerDialogFragment.this;
                super();
            }
        });
        return bundle.create();
    }

    public void setCaptionsAndStartOffset(String as[], Integer integer)
    {
        captions = as;
        if (integer != null)
        {
            startOffset = integer.intValue();
        }
    }

    public void setNumberPickerListener(NumberPickerListener numberpickerlistener)
    {
        numberPickerListener = numberpickerlistener;
    }
}
