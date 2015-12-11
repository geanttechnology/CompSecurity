// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager, AppStateBuffer

private static abstract class <init> extends <init>
{

    public Result e(Status status)
    {
        return f(status);
    }

    public ateListResult f(Status status)
    {
        return new AppStateManager.StateListResult(status) {

            final Status jP;
            final AppStateManager.c jV;

            public AppStateBuffer getStateBuffer()
            {
                return new AppStateBuffer(null);
            }

            public Status getStatus()
            {
                return jP;
            }

            
            {
                jV = AppStateManager.c.this;
                jP = status;
                super();
            }
        };
    }

    private _cls1.jP()
    {
    }

    _cls1.jP(_cls1.jP jp)
    {
        this();
    }
}
