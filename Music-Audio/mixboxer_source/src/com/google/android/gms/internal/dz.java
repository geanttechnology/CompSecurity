// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

public class dz
{

    private static final Uri pK;
    private static final Uri pL;

    public static Intent Q(String s)
    {
        s = Uri.fromParts("package", s, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(s);
        return intent;
    }

    private static Uri R(String s)
    {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", s).build();
    }

    public static Intent S(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(R(s));
        intent.setPackage("com.android.vending");
        intent.addFlags(0x80000);
        return intent;
    }

    public static Intent T(String s)
    {
        s = Uri.parse((new StringBuilder()).append("bazaar://search?q=pname:").append(s).toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(s);
        intent.setFlags(0x80000);
        return intent;
    }

    public static Intent bX()
    {
        return new Intent("android.settings.DATE_SETTINGS");
    }

    static 
    {
        pK = Uri.parse("http://plus.google.com/");
        pL = pK.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
