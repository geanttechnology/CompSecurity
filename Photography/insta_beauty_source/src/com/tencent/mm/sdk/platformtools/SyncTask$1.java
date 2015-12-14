// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;


// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            SyncTask, Util

class be
    implements Runnable
{

    final SyncTask be;

    public void run()
    {
        SyncTask.a(be, Util.ticksToNow(SyncTask.a(be)));
        be.setResult(be.run());
    }

    (SyncTask synctask)
    {
        be = synctask;
        super();
    }
}
