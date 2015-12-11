// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.mobile.activities.BaseDialogFragment;

public class ChangeItemQuantityFragment extends BaseDialogFragment
    implements TextWatcher
{
    public static interface ChangeItemQuantityDialogListener
    {

        public abstract void onItemQuantityChanged(long l, int i);
    }


    private com.ebay.nautilus.domain.data.ShoppingCart.Item item;
    private ChangeItemQuantityDialogListener listener;
    private EditText quantity;

    public ChangeItemQuantityFragment()
    {
    }

    public static ChangeItemQuantityFragment newInstance(com.ebay.nautilus.domain.data.ShoppingCart.Item item1)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("shopping_cart_item", item1);
        item1 = new ChangeItemQuantityFragment();
        item1.setArguments(bundle);
        return item1;
    }

    public void afterTextChanged(Editable editable)
    {
        boolean flag = false;
        int i = Integer.parseInt(editable.toString());
        if (i <= 0) goto _L2; else goto _L1
_L1:
        int j = item.availableQuantity;
        if (i > j) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        ((AlertDialog)getDialog()).getButton(-1).setEnabled(flag);
        return;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
        editable;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            listener = (ChangeItemQuantityDialogListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement ChangeItemQuantityDialogListener").toString());
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        item = (com.ebay.nautilus.domain.data.ShoppingCart.Item)getArguments().getParcelable("shopping_cart_item");
        bundle = getActivity().getLayoutInflater().inflate(0x7f030244, null);
        quantity = (EditText)bundle.findViewById(0x7f1007bd);
        quantity.addTextChangedListener(this);
        ((TextView)bundle.findViewById(0x7f100326)).setText(String.format(getString(0x7f070a9f), new Object[] {
            Integer.valueOf(item.availableQuantity)
        }));
        return (new android.support.v7.app.AlertDialog.Builder(getActivity())).setView(bundle).setTitle(String.format(getString(0x7f070a96), new Object[] {
            Integer.valueOf(5)
        })).setNegativeButton(0x7f0701cc, null).setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

            final ChangeItemQuantityFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                i = 0;
                int j = Integer.parseInt(quantity.getText().toString());
                i = j;
_L2:
                if (i == 0 || i == item.requestedQuantity)
                {
                    dismiss();
                }
                if (i > item.availableQuantity)
                {
                    return;
                } else
                {
                    listener.onItemQuantityChanged(item.lineItemId.longValue(), i);
                    dismiss();
                    return;
                }
                dialoginterface;
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                this$0 = ChangeItemQuantityFragment.this;
                super();
            }
        }).create();
    }

    public void onStart()
    {
        super.onStart();
        ((AlertDialog)getDialog()).getButton(-1).setEnabled(false);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }



}
