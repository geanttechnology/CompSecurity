// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.giftcard;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYButton;
import ho;
import mf;
import nb;

public class ManualEnterGiftCardDetailsFragment extends BBYBaseFragment
{

    private View a;
    private View b;
    private boolean c;
    private String g;
    private String h;
    private EditText i;
    private EditText j;
    private BBYButton k;
    private boolean l;
    private boolean m;
    private LinearLayout n;

    public ManualEnterGiftCardDetailsFragment()
    {
        c = false;
        l = false;
        m = false;
    }

    static BBYButton a(ManualEnterGiftCardDetailsFragment manualentergiftcarddetailsfragment)
    {
        return manualentergiftcarddetailsfragment.k;
    }

    static boolean a(ManualEnterGiftCardDetailsFragment manualentergiftcarddetailsfragment, boolean flag)
    {
        manualentergiftcarddetailsfragment.l = flag;
        return flag;
    }

    private void b()
    {
        String s = i.getText().toString();
        String s1 = j.getText().toString();
        (new ho(d, this, b, s, s1)).executeOnExecutor(nb.h, new Void[0]);
    }

    static void b(ManualEnterGiftCardDetailsFragment manualentergiftcarddetailsfragment)
    {
        manualentergiftcarddetailsfragment.b();
    }

    static boolean b(ManualEnterGiftCardDetailsFragment manualentergiftcarddetailsfragment, boolean flag)
    {
        manualentergiftcarddetailsfragment.m = flag;
        return flag;
    }

    static String c(ManualEnterGiftCardDetailsFragment manualentergiftcarddetailsfragment)
    {
        return manualentergiftcarddetailsfragment.h;
    }

    static boolean d(ManualEnterGiftCardDetailsFragment manualentergiftcarddetailsfragment)
    {
        return manualentergiftcarddetailsfragment.l;
    }

    static boolean e(ManualEnterGiftCardDetailsFragment manualentergiftcarddetailsfragment)
    {
        return manualentergiftcarddetailsfragment.m;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        f = nb.a();
        String s = ((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle();
        f.i(s);
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(" Gift Card Balance");
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f030065, viewgroup, false);
        b = a.findViewById(0x7f0c0064);
        n = (LinearLayout)a.findViewById(0x7f0c0161);
        layoutinflater = getArguments();
        if (layoutinflater != null)
        {
            if (layoutinflater.containsKey("gift_id"))
            {
                g = layoutinflater.getString("gift_id");
                if (g.equals("0"))
                {
                    c = true;
                }
            }
            if (layoutinflater.containsKey("screen_title"))
            {
                h = layoutinflater.getString("screen_title");
            }
        }
        i = (EditText)a.findViewById(0x7f0c0166);
        j = (EditText)a.findViewById(0x7f0c0168);
        k = (BBYButton)a.findViewById(0x7f0c0169);
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final ManualEnterGiftCardDetailsFragment a;

            public void onClick(View view)
            {
                ((InputMethodManager)a.d.getSystemService("input_method")).hideSoftInputFromWindow(ManualEnterGiftCardDetailsFragment.a(a).getWindowToken(), 2);
                ManualEnterGiftCardDetailsFragment.b(a);
            }

            
            {
                a = ManualEnterGiftCardDetailsFragment.this;
                super();
            }
        });
        if (d.getPackageManager().hasSystemFeature("android.hardware.camera"))
        {
            n.setOnClickListener(new android.view.View.OnClickListener() {

                final ManualEnterGiftCardDetailsFragment a;

                public void onClick(View view)
                {
                    (new mf()).a(a.d, "GIFT_CARD", ManualEnterGiftCardDetailsFragment.c(a));
                }

            
            {
                a = ManualEnterGiftCardDetailsFragment.this;
                super();
            }
            });
        }
        if (!c)
        {
            i.setText(g);
            l = true;
        }
        i.addTextChangedListener(new TextWatcher() {

            final ManualEnterGiftCardDetailsFragment a;

            public void afterTextChanged(Editable editable)
            {
                if (editable.toString().length() == 16)
                {
                    ManualEnterGiftCardDetailsFragment.a(a, true);
                } else
                {
                    ManualEnterGiftCardDetailsFragment.a(a, false);
                }
                if (ManualEnterGiftCardDetailsFragment.d(a) && ManualEnterGiftCardDetailsFragment.e(a))
                {
                    ManualEnterGiftCardDetailsFragment.a(a).setEnabled(true);
                    return;
                } else
                {
                    ManualEnterGiftCardDetailsFragment.a(a).setEnabled(false);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = ManualEnterGiftCardDetailsFragment.this;
                super();
            }
        });
        j.addTextChangedListener(new TextWatcher() {

            final ManualEnterGiftCardDetailsFragment a;

            public void afterTextChanged(Editable editable)
            {
                if (editable.toString().length() == 4)
                {
                    ManualEnterGiftCardDetailsFragment.b(a, true);
                } else
                {
                    ManualEnterGiftCardDetailsFragment.b(a, false);
                }
                if (ManualEnterGiftCardDetailsFragment.d(a) && ManualEnterGiftCardDetailsFragment.e(a))
                {
                    ManualEnterGiftCardDetailsFragment.a(a).setEnabled(true);
                    return;
                } else
                {
                    ManualEnterGiftCardDetailsFragment.a(a).setEnabled(false);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = ManualEnterGiftCardDetailsFragment.this;
                super();
            }
        });
        return a;
    }

    public void onDestroy()
    {
        super.onDestroy();
        InputMethodManager inputmethodmanager = (InputMethodManager)d.getSystemService("input_method");
        inputmethodmanager.hideSoftInputFromWindow(i.getWindowToken(), 0);
        inputmethodmanager.hideSoftInputFromWindow(j.getWindowToken(), 0);
        ((BBYBaseFragmentActivity)d).showActionBarHome();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(f.T());
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(" Gift Card Balance");
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
    }
}
