// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.b;

import com.target.mothership.model.cart.interfaces.PromoCode;
import java.util.StringTokenizer;

public class b
{

    public static String a(PromoCode promocode)
    {
        if (promocode == null)
        {
            return "";
        } else
        {
            return promocode.b();
        }
    }

    public static String b(PromoCode promocode)
    {
        if (promocode == null)
        {
            return "";
        }
        promocode = new StringTokenizer(promocode.a(), " ");
        if (promocode.hasMoreElements())
        {
            return promocode.nextElement().toString();
        } else
        {
            return "";
        }
    }
}
