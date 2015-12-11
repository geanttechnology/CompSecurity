// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.widget.PriceView;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity

public class PriceRangeActivity extends CoreActivity
    implements TextWatcher, android.view.View.OnClickListener, android.view.View.OnKeyListener
{
    private static final class DisplayKeyboard extends Handler
        implements android.view.View.OnFocusChangeListener, Runnable
    {

        InputMethodManager inputManager;
        View view;

        public void onFocusChange(View view1, boolean flag)
        {
            view = view1;
            if (flag)
            {
                postDelayed(this, 100L);
            }
        }

        public void run()
        {
            inputManager.showSoftInput(view, 1);
        }

        public DisplayKeyboard(Context context)
        {
            inputManager = (InputMethodManager)context.getSystemService("input_method");
        }
    }


    public static final String EXTRA_CURRENCY_CODE = "currency_code";
    public static final String EXTRA_CURRENCY_SYMBOL = "currency_symbol";
    public static final String EXTRA_MAX_PRICE = "max_price";
    public static final String EXTRA_MIN_PRICE = "min_price";
    private String currencyCode;
    private Button mClearBtn;
    private PriceView mMaxPriceEditView;
    private PriceView mMinPriceEditView;
    private Button mOkBtn;
    private String maxPrice;
    private String minPrice;

    public PriceRangeActivity()
    {
    }

    public static void StartActivity(Activity activity, String s, String s1, String s2)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/activities/PriceRangeActivity);
        intent.putExtra("currency_code", s);
        if (!TextUtils.isEmpty(s1))
        {
            intent.putExtra("min_price", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            intent.putExtra("max_price", s2);
        }
        activity.startActivityForResult(intent, 54);
    }

    public static void StartActivity(Fragment fragment, String s, String s1, String s2)
    {
        Intent intent = new Intent(fragment.getActivity(), com/ebay/mobile/activities/PriceRangeActivity);
        intent.putExtra("currency_code", s);
        if (!TextUtils.isEmpty(s1))
        {
            intent.putExtra("min_price", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            intent.putExtra("max_price", s2);
        }
        fragment.startActivityForResult(intent, 54);
    }

    private void createUI()
    {
        mMinPriceEditView = (PriceView)findViewById(0x7f1004f0);
        mMaxPriceEditView = (PriceView)findViewById(0x7f1004f2);
        mOkBtn = setup_button(0x7f1004f4);
        mClearBtn = setup_button(0x7f1004f3);
        DisplayKeyboard displaykeyboard = new DisplayKeyboard(this);
        mMinPriceEditView.setOnKeyListener(this);
        mMinPriceEditView.addTextChangedListener(this);
        mMinPriceEditView.setOnFocusChangeListener(displaykeyboard);
        mMinPriceEditView.setCurrency(currencyCode);
        mMaxPriceEditView.setOnKeyListener(this);
        mMaxPriceEditView.addTextChangedListener(this);
        mMaxPriceEditView.setOnFocusChangeListener(displaykeyboard);
        mMaxPriceEditView.setCurrency(currencyCode);
    }

    private void do_it()
    {
        Util.hideSoftInput(this, mMaxPriceEditView);
        if (!is_valid())
        {
            return;
        }
        Intent intent = getIntent();
        Double double1 = mMinPriceEditView.getPriceAsBoxedDouble();
        Double double2 = mMaxPriceEditView.getPriceAsBoxedDouble();
        if (double1 == null)
        {
            intent.removeExtra("min_price");
        } else
        {
            intent.putExtra("min_price", double1.toString());
        }
        if (double2 == null)
        {
            intent.removeExtra("max_price");
        } else
        {
            intent.putExtra("max_price", double2.toString());
        }
        setResult(-1, intent);
        finish();
    }

    private void enable_ok_button()
    {
        boolean flag = is_valid();
        mOkBtn.setEnabled(flag);
        mOkBtn.setFocusable(flag);
    }

    private boolean is_valid()
    {
        Double double1 = mMinPriceEditView.getPriceAsBoxedDouble();
        Double double2 = mMaxPriceEditView.getPriceAsBoxedDouble();
        return double1 == null || double2 == null || double1.doubleValue() <= double2.doubleValue();
    }

    private Button setup_button(int i)
    {
        Button button = (Button)findViewById(i);
        button.setOnClickListener(this);
        return button;
    }

    private void update_prices()
    {
        double d;
        if (!TextUtils.isEmpty(minPrice))
        {
            d = Double.parseDouble(minPrice);
        } else
        {
            d = 0.0D;
        }
        mMinPriceEditView.setPrice(Double.valueOf(d));
        if (!TextUtils.isEmpty(maxPrice))
        {
            d = Double.parseDouble(maxPrice);
        } else
        {
            d = 0.0D;
        }
        mMaxPriceEditView.setPrice(Double.valueOf(d));
    }

    public void afterTextChanged(Editable editable)
    {
        enable_ok_button();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onClick(View view)
    {
        if (view.getId() == mOkBtn.getId())
        {
            do_it();
        } else
        if (view.getId() == mClearBtn.getId())
        {
            mMinPriceEditView.clear();
            mMaxPriceEditView.clear();
            enable_ok_button();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301a9);
        bundle = getIntent();
        currencyCode = bundle.getStringExtra("currency_code");
        minPrice = bundle.getStringExtra("min_price");
        maxPrice = bundle.getStringExtra("max_price");
        createUI();
        update_prices();
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (Util.IsTabOrReturnOrKnob(i, keyevent) && (view.getId() == mMinPriceEditView.getId() || view.getId() == mMaxPriceEditView.getId()))
        {
            Util.hideSoftInput(this, mMaxPriceEditView);
        }
        enable_ok_button();
        if (keyevent.getAction() == 0 && i == 4)
        {
            finish();
            return true;
        } else
        {
            return false;
        }
    }

    protected void onStop()
    {
        Util.hideSoftInput(this, mMaxPriceEditView);
        super.onStop();
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
