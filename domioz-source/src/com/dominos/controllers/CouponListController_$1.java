// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dominos.controllers;

import org.androidannotations.api.c;

// Referenced classes of package com.dominos.controllers:
//            CouponListController_

class val.couponCode extends c
{

    final CouponListController_ this$0;
    final String val$couponCode;

    public void execute()
    {
        try
        {
            CouponListController_.access$001(CouponListController_.this, val$couponCode);
            return;
        }
        catch (Throwable throwable)
        {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), throwable);
        }
    }

    (int i, String s1, String s2)
    {
        this$0 = final_couponlistcontroller_;
        val$couponCode = s2;
        super(String.this, i, s1);
    }
}
