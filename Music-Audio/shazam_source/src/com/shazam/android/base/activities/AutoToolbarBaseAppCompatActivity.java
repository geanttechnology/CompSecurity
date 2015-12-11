// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.base.activities;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.shazam.android.base.activities:
//            BaseAppCompatActivity

public abstract class AutoToolbarBaseAppCompatActivity extends BaseAppCompatActivity
{

    public AutoToolbarBaseAppCompatActivity()
    {
    }

    public void setContentView(int i)
    {
        setContentView(getLayoutInflater().inflate(i, null));
    }

    public void setContentView(View view)
    {
        setContentView(view, null);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(0x7f030035);
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f1100c3);
        Toolbar toolbar = (Toolbar)findViewById(0x7f1100b0);
        if (view != null)
        {
            if (layoutparams == null)
            {
                viewgroup.addView(view);
            } else
            {
                viewgroup.addView(view, layoutparams);
            }
        }
        setupToolbar(toolbar);
    }

    public void setDefaultContentView()
    {
        setContentView(((View) (null)));
    }
}
