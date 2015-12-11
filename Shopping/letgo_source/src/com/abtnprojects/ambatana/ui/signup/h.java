// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.os.Bundle;

public class h
{

    final String a;
    final String b;

    public h(Bundle bundle)
    {
        Object obj = null;
        super();
        String s;
        String s1;
        if (bundle != null && bundle.containsKey("login_type"))
        {
            s = bundle.getString("login_type");
        } else
        {
            s = null;
        }
        s1 = obj;
        if (bundle != null)
        {
            s1 = obj;
            if (bundle.containsKey("product_id"))
            {
                s1 = bundle.getString("product_id");
            }
        }
        a = s;
        b = s1;
    }
}
