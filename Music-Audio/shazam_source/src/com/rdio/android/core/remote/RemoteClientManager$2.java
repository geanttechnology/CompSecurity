// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.remote;


// Referenced classes of package com.rdio.android.core.remote:
//            RemoteClientManager

class this._cls0
    implements Runnable
{

    final RemoteClientManager this$0;

    public void run()
    {
        RemoteClientManager.access$102(RemoteClientManager.this, false);
        onMasterQueryComplete(getStatus());
    }

    ()
    {
        this$0 = RemoteClientManager.this;
        super();
    }
}
