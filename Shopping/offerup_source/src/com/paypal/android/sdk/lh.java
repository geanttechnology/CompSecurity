// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.Closeable;
import java.io.Flushable;

// Referenced classes of package com.paypal.android.sdk:
//            lk, kq

public interface lh
    extends Closeable, Flushable
{

    public abstract lk a();

    public abstract void a_(kq kq, long l);

    public abstract void close();

    public abstract void flush();
}
