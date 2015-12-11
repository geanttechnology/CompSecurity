// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Base64;

public class bbb
{

    bbb()
    {
    }

    public String a(byte abyte0[], boolean flag)
    {
        return Base64.encodeToString(abyte0, 11);
    }

    public byte[] a(String s, boolean flag)
    {
        return Base64.decode(s, 2);
    }
}
