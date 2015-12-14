// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appboy.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.appboy.Appboy;
import myobfuscated.f.m;
import myobfuscated.i.e;

// Referenced classes of package com.appboy.ui:
//            b

public class AppboyFeedbackFragment extends Fragment
{

    public b a;
    private Button b;
    private Button c;
    private CheckBox d;
    private EditText e;
    private EditText f;
    private TextWatcher g;
    private android.view.View.OnClickListener h;
    private android.view.View.OnClickListener i;
    private int j;
    private boolean k;

    public AppboyFeedbackFragment()
    {
    }

    static boolean a(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        return appboyfeedbackfragment.k;
    }

    static boolean b(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        boolean flag2 = true;
        boolean flag;
        boolean flag1;
        if (appboyfeedbackfragment.e.getText() != null && !m.a(appboyfeedbackfragment.e.getText().toString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            appboyfeedbackfragment.e.setError(null);
        } else
        {
            appboyfeedbackfragment.e.setError(appboyfeedbackfragment.getResources().getString(0x7f0800e1));
        }
        if (appboyfeedbackfragment.f.getText() != null && !m.a(appboyfeedbackfragment.f.getText().toString()) && myobfuscated.i.e.a(appboyfeedbackfragment.f.getText().toString()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (appboyfeedbackfragment.f.getText() == null || !m.a(appboyfeedbackfragment.f.getText().toString()))
        {
            flag2 = false;
        }
        if (flag1)
        {
            appboyfeedbackfragment.f.setError(null);
        } else
        if (flag2)
        {
            appboyfeedbackfragment.f.setError(appboyfeedbackfragment.getResources().getString(0x7f0800df));
        } else
        {
            appboyfeedbackfragment.f.setError(appboyfeedbackfragment.getResources().getString(0x7f0800e0));
        }
        return flag1 & flag;
    }

    static void c(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = appboyfeedbackfragment.getActivity();
        fragmentactivity.getWindow().setSoftInputMode(appboyfeedbackfragment.j);
        if (fragmentactivity.getCurrentFocus() != null)
        {
            ((InputMethodManager)fragmentactivity.getSystemService("input_method")).hideSoftInputFromWindow(fragmentactivity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    static b d(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        return appboyfeedbackfragment.a;
    }

    static void e(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        appboyfeedbackfragment.f.setText("");
        appboyfeedbackfragment.e.setText("");
        appboyfeedbackfragment.d.setChecked(false);
        appboyfeedbackfragment.k = false;
        appboyfeedbackfragment.f.setError(null);
        appboyfeedbackfragment.e.setError(null);
    }

    static CheckBox f(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        return appboyfeedbackfragment.d;
    }

    static EditText g(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        return appboyfeedbackfragment.e;
    }

    static EditText h(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        return appboyfeedbackfragment.f;
    }

    static boolean i(AppboyFeedbackFragment appboyfeedbackfragment)
    {
        appboyfeedbackfragment.k = true;
        return true;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        g = new _cls1();
        h = new _cls2();
        i = new _cls3();
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03007e, viewgroup, false);
        b = (Button)layoutinflater.findViewById(0x7f1002ef);
        c = (Button)layoutinflater.findViewById(0x7f1002f0);
        d = (CheckBox)layoutinflater.findViewById(0x7f1002f3);
        e = (EditText)layoutinflater.findViewById(0x7f1002f1);
        f = (EditText)layoutinflater.findViewById(0x7f1002f2);
        e.addTextChangedListener(g);
        f.addTextChangedListener(g);
        b.setOnClickListener(h);
        c.setOnClickListener(i);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        e.removeTextChangedListener(g);
        f.removeTextChangedListener(g);
    }

    public void onResume()
    {
        super.onResume();
        Appboy.getInstance(getActivity()).logFeedbackDisplayed();
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        Window window = fragmentactivity.getWindow();
        j = window.getAttributes().softInputMode;
        window.setSoftInputMode(16);
        Appboy.getInstance(fragmentactivity).logFeedbackDisplayed();
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
