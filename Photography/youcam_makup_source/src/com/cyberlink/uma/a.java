// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma;

import android.util.Base64;

final class a
{

    private static final char a[] = "0123456789ABCDEF".toCharArray();

    public static String a(byte abyte0[])
    {
        return Base64.encodeToString(abyte0, 10).replace('=', '~');
    }

}
