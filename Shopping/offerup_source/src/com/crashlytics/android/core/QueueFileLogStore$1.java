// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import c.a.a.a.a.b.af;
import java.io.InputStream;

// Referenced classes of package com.crashlytics.android.core:
//            QueueFileLogStore

class val.offsetHolder
    implements af
{

    final QueueFileLogStore this$0;
    final byte val$logBytes[];
    final int val$offsetHolder[];

    public void read(InputStream inputstream, int i)
    {
        int ai[];
        inputstream.read(val$logBytes, val$offsetHolder[0], i);
        ai = val$offsetHolder;
        ai[0] = ai[0] + i;
        inputstream.close();
        return;
        Exception exception;
        exception;
        inputstream.close();
        throw exception;
    }

    ()
    {
        this$0 = final_queuefilelogstore;
        val$logBytes = abyte0;
        val$offsetHolder = _5B_I.this;
        super();
    }
}
