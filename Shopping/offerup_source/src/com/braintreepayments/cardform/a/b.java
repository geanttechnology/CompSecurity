// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.a;

import android.text.TextUtils;
import java.util.Calendar;

public final class b
{

    private static final b a = new b(Calendar.getInstance());
    private final Calendar b;

    private b(Calendar calendar)
    {
        b = calendar;
    }

    public static boolean a(String s, String s1)
    {
        b b1;
        b1 = a;
        break MISSING_BLOCK_LABEL_4;
_L2:
        int i;
        int j;
        int k;
        do
        {
            do
            {
                return false;
            } while (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || !TextUtils.isDigitsOnly(s) || !TextUtils.isDigitsOnly(s1));
            j = Integer.parseInt(s);
        } while (j <= 0 || j > 12);
        k = b1.b.get(1) % 100;
        i = s1.length();
        if (i != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = Integer.parseInt(s1);
_L4:
        if (i == k && j < b1.b.get(2) + 1 || i < k && (i + 100) - k > 20) goto _L2; else goto _L1
_L1:
        return true;
        if (i != 4) goto _L2; else goto _L3
_L3:
        i = Integer.parseInt(s1) & 0x64;
          goto _L4
    }

}
