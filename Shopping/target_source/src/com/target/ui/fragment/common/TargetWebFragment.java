// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import com.c.a.b;
import com.target.mothership.util.o;
import com.target.ui.fragment.webview.TargetBaseWebViewFragment;

public class TargetWebFragment extends TargetBaseWebViewFragment
{

    private static final String ARG_UP_BUTTON = "upButton";
    private static final String ARG_WEB_URL = "store";
    private static final String ARG_WEB_VIEW_TITLE = "title";
    private static final String STATIC_CONTENT = "file:///android_asset/htmls/";
    public static final String TAG = com/target/ui/fragment/common/TargetWebFragment.getSimpleName();

    public TargetWebFragment()
    {
    }

    public static TargetWebFragment a(boolean flag, String s, String s1)
    {
        return (TargetWebFragment)com.c.a.b.a(new TargetWebFragment()).a("upButton", flag).a("store", s).a("title", s1).a();
    }

    private boolean n()
    {
        return getArguments().getBoolean("upButton");
    }

    private String o()
    {
        return getArguments().getString("store");
    }

    private String v()
    {
        return getArguments().getString("title");
    }

    public int a()
    {
        return 0x7f03008c;
    }

    public int b()
    {
        return 0x7f100233;
    }

    public int c()
    {
        return 0x7f100230;
    }

    public int d()
    {
        return 0x7f100232;
    }

    public int e()
    {
        return 0x7f100234;
    }

    public int f()
    {
        return 0x7f100231;
    }

    protected boolean i()
    {
        return false;
    }

    protected boolean j()
    {
        return !o().contains("file:///android_asset/htmls/");
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        }
        String s = v();
        if (com.target.mothership.util.o.g(s))
        {
            j(s);
        }
        boolean flag;
        if (!n())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b(flag);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public void onResume()
    {
        super.onResume();
        e(o());
    }

}
