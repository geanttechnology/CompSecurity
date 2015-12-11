// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account.a;

import android.content.Context;
import com.target.ui.fragment.common.TargetWebFragment;

public class c
    implements com.target.ui.view.account.AccountInternalLaunchView.a
{

    private final Context mContext;
    private final com.target.ui.f.c mNavigationFragmentManager;

    public c(Context context, com.target.ui.f.c c1)
    {
        mContext = context;
        mNavigationFragmentManager = c1;
    }

    public void a()
    {
        mNavigationFragmentManager.b(TargetWebFragment.a(false, "file:///android_asset/htmls/privacy.html", mContext.getString(0x7f09030c)), TargetWebFragment.TAG);
    }

    public void b()
    {
        mNavigationFragmentManager.b(TargetWebFragment.a(false, "file:///android_asset/htmls/ca-privacy.html", mContext.getString(0x7f090307)), TargetWebFragment.TAG);
    }

    public void c()
    {
        mNavigationFragmentManager.b(TargetWebFragment.a(false, "file:///android_asset/htmls/ca-supply-chain-act.html", mContext.getString(0x7f090308)), TargetWebFragment.TAG);
    }

    public void d()
    {
        mNavigationFragmentManager.b(TargetWebFragment.a(false, "file:///android_asset/htmls/terms.html", mContext.getString(0x7f090313)), TargetWebFragment.TAG);
    }
}
