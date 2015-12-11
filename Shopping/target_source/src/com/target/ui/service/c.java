// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.coupons.params.CouponsSignUpParams;
import com.target.mothership.model.d;
import com.target.mothership.util.b;
import com.target.ui.fragment.mcoupons.a;
import java.util.ArrayList;
import java.util.Iterator;

public class c
{

    private static final String TAG = com/target/ui/service/c.getSimpleName();
    private static c sInstance;
    private ArrayList mCouponConnectivityListeners;
    private com.target.mothership.model.coupons.c mCouponManager;

    private c()
    {
        mCouponManager = new com.target.mothership.model.coupons.c();
        mCouponConnectivityListeners = new ArrayList();
    }

    public static c a()
    {
        if (sInstance == null)
        {
            sInstance = new c();
        }
        return sInstance;
    }

    private boolean b()
    {
        return com.target.mothership.util.b.a().b();
    }

    private void c()
    {
        Iterator iterator = mCouponConnectivityListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a a1 = (a)iterator.next();
            if (a1 != null)
            {
                a1.b();
            }
        } while (true);
    }

    public void a(CompletedSignUp completedsignup, d d)
    {
        if (!b())
        {
            c();
            return;
        } else
        {
            mCouponManager.a(completedsignup, d);
            return;
        }
    }

    public void a(CompletedSignUp completedsignup, String s, d d)
    {
        if (!b())
        {
            c();
            return;
        } else
        {
            mCouponManager.a(completedsignup, s, d);
            return;
        }
    }

    public void a(RegisteredPhone registeredphone, String s, CouponsSignUpParams couponssignupparams, d d)
    {
        if (!b())
        {
            c();
            return;
        } else
        {
            mCouponManager.a(registeredphone, s, couponssignupparams, d);
            return;
        }
    }

    public void a(a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("listener must not be null");
        } else
        {
            mCouponConnectivityListeners.add(a1);
            return;
        }
    }

    public void a(String s, d d)
    {
        if (!b() && mCouponConnectivityListeners != null)
        {
            c();
            return;
        } else
        {
            mCouponManager.a(s, d);
            return;
        }
    }

    public void b(CompletedSignUp completedsignup, d d)
    {
        if (!b())
        {
            c();
            return;
        } else
        {
            mCouponManager.b(completedsignup, d);
            return;
        }
    }

    public void b(a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("listener must not be null");
        } else
        {
            mCouponConnectivityListeners.remove(a1);
            return;
        }
    }

}
