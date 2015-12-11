// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue

class val.tcs
    implements ct
{

    final ParsePinningEventuallyQueue this$0;
    final android.support.v7. val$tcs;
    final String val$uuid;

    public cu then(cu cu1)
        throws Exception
    {
        synchronized (ParsePinningEventuallyQueue.access$900(ParsePinningEventuallyQueue.this))
        {
            ParsePinningEventuallyQueue.access$1000(ParsePinningEventuallyQueue.this).remove(val$uuid);
            ParsePinningEventuallyQueue.access$1100(ParsePinningEventuallyQueue.this).remove(val$uuid);
            ParsePinningEventuallyQueue.access$1200(ParsePinningEventuallyQueue.this).remove(val$uuid);
        }
        obj = cu1.f();
        if (obj != null)
        {
            val$tcs.(((Exception) (obj)));
        } else
        if (cu1.c())
        {
            val$tcs.();
        } else
        {
            val$tcs.(cu1.e());
        }
        return val$tcs.();
        cu1;
        obj;
        JVM INSTR monitorexit ;
        throw cu1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$uuid = s;
        val$tcs = android.support.v7..this;
        super();
    }
}
