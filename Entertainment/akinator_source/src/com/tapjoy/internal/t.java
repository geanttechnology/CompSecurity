// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;

public abstract class t
{

    public t()
    {
    }

    protected abstract void a(int i);

    protected abstract void a(Context context, String s);

    protected abstract void a(String s);

    protected abstract boolean a(Context context, Intent intent);

    protected boolean b(String s)
    {
        return true;
    }

    protected boolean c(String s)
    {
        return false;
    }
}
