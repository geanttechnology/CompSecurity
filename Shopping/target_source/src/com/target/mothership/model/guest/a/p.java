// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.google.a.a.e;
import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.a.c;
import com.target.mothership.util.k;

class p extends b
    implements c
{

    private String mAlternateErrorMessage;

    p()
    {
    }

    public void a(String s)
    {
        mAlternateErrorMessage = s;
    }

    public com.target.mothership.model.guest.interfaces.a.c.a[] a()
    {
        return com.target.mothership.model.guest.interfaces.a.c.a.values();
    }

    public e b()
    {
        return k.a(mAlternateErrorMessage);
    }

    public j[] c()
    {
        return a();
    }
}
