// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;


public class e
{

    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public e()
    {
        a = true;
        b = false;
        c = false;
        d = false;
    }

    public String toString()
    {
        return (new StringBuilder()).append("bShowEditViewBottomBar = ").append(String.valueOf(a)).append("bRemovePanel = ").append(String.valueOf(b)).append("bShowBasicEditMenu = ").append(String.valueOf(c)).append("bShowBasicBeautifierMenu = ").append(String.valueOf(d)).toString();
    }
}
