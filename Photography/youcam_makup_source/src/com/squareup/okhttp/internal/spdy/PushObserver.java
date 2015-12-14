// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.List;
import okio.f;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            ErrorCode

public interface PushObserver
{

    public static final PushObserver CANCEL = new PushObserver() {

        public boolean onData(int i, f f1, int j, boolean flag)
        {
            f1.g(j);
            return true;
        }

        public boolean onHeaders(int i, List list, boolean flag)
        {
            return true;
        }

        public boolean onRequest(int i, List list)
        {
            return true;
        }

        public void onReset(int i, ErrorCode errorcode)
        {
        }

    };

    public abstract boolean onData(int i, f f, int j, boolean flag);

    public abstract boolean onHeaders(int i, List list, boolean flag);

    public abstract boolean onRequest(int i, List list);

    public abstract void onReset(int i, ErrorCode errorcode);

}
