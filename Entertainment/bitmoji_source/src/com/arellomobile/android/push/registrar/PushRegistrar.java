// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.registrar;

import android.content.Context;

public interface PushRegistrar
{

    public abstract void checkDevice(Context context)
        throws Exception;

    public abstract void registerPW(Context context);

    public abstract void unregisterPW(Context context);
}
