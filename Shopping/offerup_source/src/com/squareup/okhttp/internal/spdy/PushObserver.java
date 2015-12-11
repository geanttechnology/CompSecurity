// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import d.j;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            ErrorCode

public interface PushObserver
{

    public static final PushObserver CANCEL = new _cls1();

    public abstract boolean onData(int i, j j, int k, boolean flag);

    public abstract boolean onHeaders(int i, List list, boolean flag);

    public abstract boolean onRequest(int i, List list);

    public abstract void onReset(int i, ErrorCode errorcode);


    private class _cls1
        implements PushObserver
    {

        public final boolean onData(int i, j j1, int k, boolean flag)
        {
            j1.f(k);
            return true;
        }

        public final boolean onHeaders(int i, List list, boolean flag)
        {
            return true;
        }

        public final boolean onRequest(int i, List list)
        {
            return true;
        }

        public final void onReset(int i, ErrorCode errorcode)
        {
        }

        _cls1()
        {
        }
    }

}
