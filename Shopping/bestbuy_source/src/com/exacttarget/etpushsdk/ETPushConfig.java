// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.Application;
import android.net.Uri;

public class ETPushConfig
{

    protected final Application a;
    protected String b;
    protected String c;
    protected String d;
    protected boolean e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected boolean i;
    protected Class j;
    protected Class k;
    protected Class l;
    protected String m;
    protected Uri n;
    protected int o;
    protected int p;

    private ETPushConfig(Application application)
    {
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        o = 5;
        a = application;
    }

    ETPushConfig(Application application, _cls1 _pcls1)
    {
        this(application);
    }
}
