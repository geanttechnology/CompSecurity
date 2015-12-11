// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch.threads;


// Referenced classes of package com.flow.android.engine.library.impl.servermatch.threads:
//            FlowServerRequestThread

public interface ThreadPoolManagerInterface
{

    public abstract void onFinish(int i);

    public abstract void onRun(int i, FlowServerRequestThread flowserverrequestthread);
}
