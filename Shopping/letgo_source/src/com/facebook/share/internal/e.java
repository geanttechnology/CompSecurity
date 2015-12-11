// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.os.Bundle;
import android.support.v7.ji;
import com.facebook.f;
import com.facebook.h;

public abstract class e
{

    private f a;

    public e(f f1)
    {
        a = f1;
    }

    public void a(ji ji)
    {
        if (a != null)
        {
            a.onCancel();
        }
    }

    public abstract void a(ji ji, Bundle bundle);

    public void a(ji ji, h h)
    {
        if (a != null)
        {
            a.onError(h);
        }
    }
}
