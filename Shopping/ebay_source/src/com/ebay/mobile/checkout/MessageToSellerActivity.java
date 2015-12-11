// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;

public class MessageToSellerActivity extends ModalActivity
    implements TextWatcher, android.view.View.OnClickListener
{

    static final String EXTRA_EDIT_TEXT_HINT = "edit_text_hint";
    static final String EXTRA_IS_EBAY_NOW = "is_ebay_now";
    static final String EXTRA_MESSAGE_TO_SELLER = "message_to_seller";
    static final String EXTRA_SELLER_ID = "seller_id";
    static final String EXTRA_TITLE = "title";
    private EditText messageToSeller;
    private String sellerUserIdentifier;
    private boolean textChanged;

    public MessageToSellerActivity()
    {
        textChanged = false;
    }

    public void afterTextChanged(Editable editable)
    {
        textChanged = true;
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    void createUI()
    {
        setContentView(0x7f0302ca);
        setTitle(0x7f070c49);
        setDoneButtonOnClickListener(this);
        messageToSeller = (EditText)findViewById(0x7f100997);
        messageToSeller.addTextChangedListener(this);
        boolean flag = getResources().getBoolean(0x7f0b0006);
        int i = 5;
        if (flag)
        {
            i = 5 | 0x30;
        }
        getWindow().setSoftInputMode(i);
    }

    public String getTrackingEventName()
    {
        return "CheckoutMessageSent";
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755943: 
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            break;
        }
        if (textChanged)
        {
            view = new Intent();
            view.putExtra("message_to_seller", messageToSeller.getText().toString());
            view.putExtra("seller_id", sellerUserIdentifier);
            view.putExtra("is_ebay_now", getIntent().getBooleanExtra("is_ebay_now", false));
            setResult(-1, view);
            (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            finish();
        } else
        {
            setResult(0);
            createUI();
            Object obj = getIntent();
            String s = ((Intent) (obj)).getStringExtra("title");
            if (s != null)
            {
                setTitle(s);
            }
            obj = ((Intent) (obj)).getStringExtra("edit_text_hint");
            if (obj != null)
            {
                messageToSeller.setHint(((CharSequence) (obj)));
            }
            if (bundle != null)
            {
                sellerUserIdentifier = bundle.getString("seller_id");
                bundle = bundle.getString("message_to_seller");
            } else
            {
                sellerUserIdentifier = getIntent().getStringExtra("seller_id");
                bundle = getIntent().getStringExtra("message_to_seller");
            }
            if (!TextUtils.isEmpty(bundle))
            {
                messageToSeller.setText(bundle);
                messageToSeller.setSelection(bundle.length());
                return;
            }
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("message_to_seller", messageToSeller.getText().toString());
        bundle.putString("seller_id", sellerUserIdentifier);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
