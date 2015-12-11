// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.Closeable;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            hn, jb, kq

public interface hq
    extends Closeable
{

    public abstract void a();

    public abstract void a(int i, long l);

    public abstract void a(int i, hn hn);

    public abstract void a(int i, hn hn, byte abyte0[]);

    public abstract void a(jb jb);

    public abstract void a(boolean flag, int i, int j);

    public abstract void a(boolean flag, int i, kq kq, int j);

    public abstract void a(boolean flag, boolean flag1, int i, int j, List list);

    public abstract void b();

    public abstract void b(jb jb);

    public abstract int c();
}
