// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


final class n
{

    public static final int SDK_INT;

    n()
    {
    }

    static 
    {
        SDK_INT = Integer.parseInt(android.os.Build.VERSION.SDK);
    }
}
