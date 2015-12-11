// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import com.target.mothership.services.o;

public abstract class a
    implements com.target.ui.view.common.h.b
{

    private o requestRetryable;

    public a(o o1)
    {
        requestRetryable = o1;
    }

    public void a()
    {
        if (requestRetryable != null)
        {
            c();
            requestRetryable.a();
        }
    }

    public void b()
    {
    }

    public abstract void c();
}
