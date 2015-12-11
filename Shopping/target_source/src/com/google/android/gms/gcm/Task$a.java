// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import com.google.android.gms.common.internal.u;

// Referenced classes of package com.google.android.gms.gcm:
//            Task, a

public static abstract class rnal.u
{

    protected int a;
    protected String b;
    protected String c;
    protected boolean d;
    protected boolean e;
    protected boolean f;

    protected void a()
    {
        boolean flag;
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.b(flag, "Must provide an endpoint for this task by calling setService(ComponentName).");
        com.google.android.gms.gcm.a.a(c);
    }

    public rnal.u()
    {
    }
}
