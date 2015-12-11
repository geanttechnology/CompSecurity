// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.appstore;

import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;

public class UninstalledActivity extends AmazonActivity
{

    public UninstalledActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        pushView(com.amazon.mShop.android.lib.R.layout.appstore_uninstalled_activity);
    }
}
