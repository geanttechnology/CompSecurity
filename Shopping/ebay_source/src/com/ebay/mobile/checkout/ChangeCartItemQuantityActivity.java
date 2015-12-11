// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ModalActivity;

public class ChangeCartItemQuantityActivity extends ModalActivity
    implements TextWatcher, android.view.View.OnClickListener
{

    public static final String EXTRA_CART_LINE_ITEM_ID = "ebay_item_id";
    public static final String EXTRA_QUANTITY_AVAILABLE = "quantity_available";
    public static final String EXTRA_QUANTITY_SELECTED = "quantity_selected";
    String cartLineItemId;
    int quantityAvailable;
    EditText quantityInput;

    public ChangeCartItemQuantityActivity()
    {
    }

    private void done(int i)
    {
        Intent intent = new Intent();
        intent.putExtra("quantity_selected", i);
        intent.putExtra("ebay_item_id", cartLineItemId);
        setResult(-1, intent);
        finish();
    }

    public void afterTextChanged(Editable editable)
    {
        boolean flag = false;
        int i = Integer.parseInt(editable.toString());
        if (i <= 0) goto _L2; else goto _L1
_L1:
        int j = quantityAvailable;
        if (i > j) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        findViewById(0x7f100967).setEnabled(flag);
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

    void createUI()
    {
        setContentView(0x7f0302b7);
        setTitle(String.format(getString(0x7f070a96), new Object[] {
            Integer.valueOf(5)
        }));
        hideCloseButton();
        showBackButton();
        findViewById(0x7f100967).setEnabled(false);
        findViewById(0x7f100967).setOnClickListener(this);
        findViewById(0x7f1001bf).setOnClickListener(this);
        quantityInput = (EditText)findViewById(0x7f1007bd);
        quantityInput.addTextChangedListener(this);
        quantityInput.setOnKeyListener(new android.view.View.OnKeyListener() {

            final ChangeCartItemQuantityActivity this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if (keyevent.getKeyCode() == 66)
                {
                    i = Integer.parseInt(quantityInput.getText().toString());
                    if (i > 0 && i <= quantityAvailable)
                    {
                        done(i);
                    }
                }
                return false;
            }

            
            {
                this$0 = ChangeCartItemQuantityActivity.this;
                super();
            }
        });
        ((TextView)findViewById(0x7f100326)).setText(String.format(getString(0x7f070a9f), new Object[] {
            Integer.valueOf(quantityAvailable)
        }));
        getWindow().setSoftInputMode(5);
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 2: default 32
    //                   2131755455: 33
    //                   2131757415: 38;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        finish();
        return;
_L3:
        view = (EditText)findViewById(0x7f1007bd);
        int i;
        try
        {
            i = Integer.parseInt(view.getText().toString());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            i = -1;
        }
        if (i != -1 && i <= quantityAvailable)
        {
            done(i);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            finish();
            return;
        }
        if (bundle != null)
        {
            quantityAvailable = bundle.getInt("quantity_available");
            cartLineItemId = bundle.getString("ebay_item_id");
        } else
        {
            quantityAvailable = getIntent().getIntExtra("quantity_available", 0);
            cartLineItemId = getIntent().getStringExtra("ebay_item_id");
        }
        setResult(0);
        createUI();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.findItem(0x7f1009e6).setEnabled(false);
        menu.findItem(0x7f1009e6).setVisible(false);
        return true;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("quantity_available", quantityAvailable);
        bundle.putString("ebay_item_id", cartLineItemId);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

}
