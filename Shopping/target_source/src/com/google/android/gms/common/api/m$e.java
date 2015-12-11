// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.DeadObjectException;

// Referenced classes of package com.google.android.gms.common.api:
//            m, Status

static interface us
{

    public abstract void a(Status status);

    public abstract void a(us us)
        throws DeadObjectException;

    public abstract void a(us us);

    public abstract void c();

    public abstract void c(Status status);

    public abstract us e();

    public abstract int f();
}
