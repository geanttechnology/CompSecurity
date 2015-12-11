// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout.d.a;


public final class a
    implements com.target.ui.view.checkout.ContactView.a
{

    public String email;
    public boolean isValid;
    public String phone;

    public a()
    {
    }

    public void a()
    {
        isValid = false;
    }

    public void a(String s, String s1)
    {
        email = s;
        phone = s1;
        isValid = true;
    }
}
