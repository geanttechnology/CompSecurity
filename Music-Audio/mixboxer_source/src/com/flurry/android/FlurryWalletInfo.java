// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


public class FlurryWalletInfo
{

    String iv;
    float iw;

    public FlurryWalletInfo()
    {
    }

    public float getCurrencyAmount()
    {
        return iw;
    }

    public String getCurrencyKey()
    {
        return iv;
    }
}
