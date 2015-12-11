// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.z;

import android.content.Context;
import android.os.Handler;
import com.shazam.i.b.c;

public final class a
{

    public static Handler a()
    {
        return new Handler(c.a().getMainLooper());
    }
}
