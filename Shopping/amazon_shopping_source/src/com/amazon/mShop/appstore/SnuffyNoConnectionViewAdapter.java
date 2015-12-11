// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.appstore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.mShop.error.AmazonErrorBox;
import com.amazon.mShop.util.UIUtils;
import com.amazon.venezia.web.NoConnectionViewAdapter;

public class SnuffyNoConnectionViewAdapter
    implements NoConnectionViewAdapter
{

    private final AmazonErrorBox errorBox;
    private android.view.View.OnClickListener listener;

    SnuffyNoConnectionViewAdapter(View view, int i)
    {
        listener = null;
        Object obj = view.getContext();
        String s = UIUtils.formatErrorMessage(((Context) (obj)).getString(com.amazon.mShop.android.lib.R.string.error_network_no_connection_message), 1);
        errorBox = new AmazonErrorBox(((Context) (obj)));
        obj = (ViewGroup)view;
        view = view.findViewById(i);
        i = ((ViewGroup) (obj)).indexOfChild(view);
        ((ViewGroup) (obj)).removeView(view);
        errorBox.setVisibility(8);
        ((ViewGroup) (obj)).addView(errorBox, i);
        errorBox.setMessage(s);
        errorBox.setBackgroundColor(-1);
        errorBox.bringToFront();
    }

    public View getView()
    {
        return errorBox;
    }

    public void setOnReloadListener(android.view.View.OnClickListener onclicklistener)
    {
        listener = onclicklistener;
        errorBox.setButtonOnClick(1, listener);
    }

    public void setReloadEnabled(boolean flag)
    {
        AmazonErrorBox amazonerrorbox = errorBox;
        android.view.View.OnClickListener onclicklistener;
        if (flag)
        {
            onclicklistener = listener;
        } else
        {
            onclicklistener = null;
        }
        amazonerrorbox.setButtonOnClick(1, onclicklistener);
    }
}
