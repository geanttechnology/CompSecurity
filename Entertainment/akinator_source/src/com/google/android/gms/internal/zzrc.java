// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzrc
{

    public static final Integer zzbaB = Integer.valueOf(0);
    public static final Integer zzbaC = Integer.valueOf(1);
    private final Context mContext;
    private final ExecutorService zzaYr;

    public zzrc(Context context)
    {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzrc(Context context, ExecutorService executorservice)
    {
        mContext = context;
        zzaYr = executorservice;
    }

}
