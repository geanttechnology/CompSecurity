// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net.http;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.sessionm.net.http:
//            a

class gl
    implements ThreadFactory
{

    final a gl;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable);
        runnable.setName((new StringBuilder()).append("SessionM Thread-").append(a.bv()).toString());
        return runnable;
    }

    dFactory(a a1)
    {
        gl = a1;
        super();
    }
}
