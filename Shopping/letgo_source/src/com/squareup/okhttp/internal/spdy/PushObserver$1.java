// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apx;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            PushObserver, ErrorCode

static final class 
    implements PushObserver
{

    public boolean onData(int i, apx apx1, int j, boolean flag)
        throws IOException
    {
        apx1.g(j);
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

    ()
    {
    }
}
