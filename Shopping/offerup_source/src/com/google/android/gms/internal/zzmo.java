// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.database.CharArrayBuffer;
import android.text.TextUtils;

public final class zzmo
{

    public static void zzb(String s, CharArrayBuffer chararraybuffer)
    {
        if (TextUtils.isEmpty(s))
        {
            chararraybuffer.sizeCopied = 0;
        } else
        if (chararraybuffer.data == null || chararraybuffer.data.length < s.length())
        {
            chararraybuffer.data = s.toCharArray();
        } else
        {
            s.getChars(0, s.length(), chararraybuffer.data, 0);
        }
        chararraybuffer.sizeCopied = s.length();
    }
}
