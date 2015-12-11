// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.ebay.common.Preferences;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.sell.widget.TextImageButton;
import com.ebay.mobile.util.ScanResult;
import com.ebay.nautilus.domain.EbaySite;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity

public class AddEditTrackingInfoActivity extends CoreActivity
    implements android.view.View.OnClickListener
{
    private static class ButtonEnabler
        implements TextWatcher
    {

        View button;
        EditText carrier;
        EditText number;

        private void setEnabled()
        {
            String s = number.getText().toString().trim();
            String s1 = carrier.getText().toString().trim();
            View view = button;
            boolean flag;
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setEnabled(flag);
        }

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            setEnabled();
        }

        ButtonEnabler(View view, EditText edittext, EditText edittext1)
        {
            button = view;
            number = edittext;
            carrier = edittext1;
            setEnabled();
        }
    }


    public static final String EXTRA_CARRIER = "carrier";
    public static final String EXTRA_ENTER_VS_EDIT = "enter_vs_edit";
    public static final String EXTRA_INDEX = "index";
    public static final String EXTRA_NUMBER = "number";
    public static final String EXTRA_SHOW_REMOVE_WARNING = "showRemoveWarning";
    public static final String EXTRA_STATE = "state";
    public static final int STATE_REMOVE = 0;
    public static final int STATE_SAVE = 2;
    public static final int STATE_UPDATE = 1;
    private EditText carrierField;
    private EditText numberField;
    private boolean removable;
    private boolean showRemoveWarning;

    public AddEditTrackingInfoActivity()
    {
        removable = false;
        showRemoveWarning = false;
    }

    private String barcodeToCarrier(String s, String s1)
    {
        if (s != null)
        {
            if (s.startsWith("1Z") && s1.equals("128"))
            {
                return "UPS";
            }
            if (s.startsWith("91") || s.startsWith("94"))
            {
                return "USPS";
            }
            if (s.startsWith("C1") && s.length() == 15)
            {
                return "OnTrac";
            }
            if (s.length() == 15 || s.length() == 12 || s.startsWith("3") && s.length() == 32)
            {
                return "FedEx";
            }
        }
        return null;
    }

    private void remove()
    {
        Intent intent = new Intent();
        intent.putExtra("state", 0);
        intent.putExtra("index", getIntent().getIntExtra("index", 0));
        setResult(-1, intent);
        finish();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            return;

        case 58: // ':'
            break;
        }
        if (j == -1)
        {
            String s = intent.getStringExtra("productid");
            intent = intent.getStringExtra("productidtype");
            if (s != null && s.length() > 0)
            {
                String as[] = s.split(new String("\\u001d"));
                intent = new ScanResult(as[as.length - 1], intent);
                numberField.setText(((ScanResult) (intent)).productId);
                if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
                {
                    carrierField.setText(barcodeToCarrier(((ScanResult) (intent)).productId, ((ScanResult) (intent)).productIdType));
                }
            }
        }
        MimsUtil.releaseProvider(MimsUtil.PROVIDER_ID_REDLASER);
    }

    public void onClick(View view)
    {
        int i = 1;
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131755149: 224
    //                   2131755156: 49
    //                   2131755157: 150
    //                   2131755158: 54;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L3:
        finish();
        return;
_L5:
        view = numberField.getText().toString();
        String s = carrierField.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("number", view);
        intent.putExtra("carrier", s);
        intent.putExtra("index", getIntent().getIntExtra("index", 0));
        if (!removable)
        {
            i = 2;
        }
        intent.putExtra("state", i);
        setResult(-1, intent);
        finish();
        return;
_L4:
        if (showRemoveWarning)
        {
            view = new android.support.v7.app.AlertDialog.Builder(this);
            view.setIcon(0x1080027).setTitle(getString(0x7f070b81)).setMessage(getString(0x7f070b80)).setPositiveButton(0x7f070cc7, new android.content.DialogInterface.OnClickListener() {

                final AddEditTrackingInfoActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    remove();
                }

            
            {
                this$0 = AddEditTrackingInfoActivity.this;
                super();
            }
            }).setNegativeButton(0x7f070655, null).create();
            view.show();
            return;
        } else
        {
            remove();
            return;
        }
_L2:
        if ((view = ScanResult.getScanActivityIntent(this)) != null)
        {
            view.putExtra("code128", true);
            MimsUtil.useProvider(MimsUtil.PROVIDER_ID_REDLASER);
            startActivityForResult(view, 58);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001d);
        bundle = getIntent();
        String s;
        String s1;
        int i;
        if (bundle.getBooleanExtra("enter_vs_edit", false))
        {
            i = 0x7f0703cd;
        } else
        {
            i = 0x7f0703a4;
        }
        setTitle(i);
        s = bundle.getStringExtra("number");
        s1 = bundle.getStringExtra("carrier");
        showRemoveWarning = bundle.getBooleanExtra("showRemoveWarning", false);
        numberField = (EditText)findViewById(0x7f100090);
        if (!TextUtils.isEmpty(s))
        {
            numberField.setText(s);
            removable = true;
        }
        carrierField = (EditText)findViewById(0x7f100092);
        if (!TextUtils.isEmpty(s1))
        {
            carrierField.setText(s1);
            removable = true;
        }
        bundle = findViewById(0x7f100095);
        if (removable)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        bundle.setVisibility(i);
        findViewById(0x7f100094).setOnClickListener(this);
        findViewById(0x7f100096).setOnClickListener(this);
        findViewById(0x7f100095).setOnClickListener(this);
        bundle = (TextImageButton)findViewById(0x7f10008d);
        if (ScanResult.getScanActivityIntent(this) != null)
        {
            bundle.setOnClickListener(this);
            bundle.setButtonDrawable(0x7f02025d);
        } else
        {
            bundle.setVisibility(8);
            findViewById(0x7f10008e).setVisibility(8);
        }
        bundle = new ButtonEnabler(findViewById(0x7f100096), numberField, carrierField);
        numberField.addTextChangedListener(bundle);
        carrierField.addTextChangedListener(bundle);
    }

}
