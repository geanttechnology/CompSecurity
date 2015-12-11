// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

final class cu
{

    cu()
    {
    }

    public static boolean a(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }
}
