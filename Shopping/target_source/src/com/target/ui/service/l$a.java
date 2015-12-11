// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.google.a.a.e;
import com.target.mothership.model.a.c.a;

// Referenced classes of package com.target.ui.service:
//            l

public static class mRequesting
{

    private e mDepartmentAdjacency;
    private boolean mRequesting;

    public boolean a()
    {
        return mRequesting;
    }

    public e b()
    {
        return mDepartmentAdjacency;
    }

    public l.a.c.a(boolean flag, a a1)
    {
        mDepartmentAdjacency = e.e();
        mDepartmentAdjacency = e.c(a1);
        mRequesting = flag;
    }
}
