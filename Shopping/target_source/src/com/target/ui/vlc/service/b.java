// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc.service;

import com.target.ui.vlc.c;
import com.target.ui.vlc.model.a;

abstract class b
{

    protected String mDeviceId;
    protected a mSiteInfo;
    protected c mVlcListener;

    protected b(String s, c c)
    {
        mDeviceId = s;
        mVlcListener = c;
    }

    public abstract void a();

    public abstract void a(a a1);

    public abstract void b();
}
