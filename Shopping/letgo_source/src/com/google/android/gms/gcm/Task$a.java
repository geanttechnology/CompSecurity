// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.gcm:
//            Task, a

public static abstract class rnal.x
{

    protected int a;
    protected String b;
    protected String c;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    protected Bundle g;

    protected void b()
    {
        boolean flag;
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "Must provide an endpoint for this task by calling setService(ComponentName).");
        com.google.android.gms.gcm.a.a(c);
        if (e)
        {
            Task.b(g);
        }
    }

    public rnal.x()
    {
    }
}
