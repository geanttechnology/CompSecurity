// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            AppCompatProgressDialog

public static class context
{

    protected boolean cancellable;
    protected final Context context;
    protected boolean indeterminate;
    protected int max;
    protected String message;
    private android.content. onCancelListener;
    protected Style progressStyle;
    protected String title;

    public AppCompatProgressDialog build()
    {
        return new AppCompatProgressDialog(this);
    }

    public context setCancellable(boolean flag)
    {
        cancellable = flag;
        return this;
    }

    public cancellable setIndeterminate(boolean flag)
    {
        indeterminate = flag;
        return this;
    }

    public indeterminate setMax(int i)
    {
        max = i;
        return this;
    }

    public max setMessage(String s)
    {
        message = s;
        return this;
    }

    public Style setStyle(Style style)
    {
        progressStyle = style;
        return this;
    }

    public AppCompatProgressDialog show()
    {
        AppCompatProgressDialog appcompatprogressdialog = build();
        appcompatprogressdialog.show();
        return appcompatprogressdialog;
    }


    public Style(Context context1)
    {
        progressStyle = Style.SPINNER;
        indeterminate = true;
        max = 1;
        context = context1;
    }
}
