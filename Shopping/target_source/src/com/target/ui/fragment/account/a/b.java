// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account.a;

import com.target.ui.fragment.account.a;

public class b
    implements com.target.ui.view.account.AccountExternalLaunchView.a
{

    private final a mExtrrnalUrlLauncher;

    public b(a a1)
    {
        mExtrrnalUrlLauncher = a1;
    }

    public void a()
    {
        mExtrrnalUrlLauncher.a("https://mrcam.target.com");
    }

    public void b()
    {
        mExtrrnalUrlLauncher.a("https://m-secure.target.com/gam-findorder");
    }
}
