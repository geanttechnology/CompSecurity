// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;

import android.content.Context;
import java.util.Date;

public final class l
{

    public final long a;
    public final Context b;
    public Date c;

    public l(Context context)
    {
        this(context, (byte)0);
    }

    private l(Context context, byte byte0)
    {
        b = context;
        a = 5L;
        c = new Date((new Date()).getTime() - 5000L);
    }
}
