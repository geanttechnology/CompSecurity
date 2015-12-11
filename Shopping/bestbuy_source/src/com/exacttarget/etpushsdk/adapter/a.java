// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.adapter;


// Referenced classes of package com.exacttarget.etpushsdk.adapter:
//            CloudPageListAdapter

class a
    implements Runnable
{

    final CloudPageListAdapter a;

    a(CloudPageListAdapter cloudpagelistadapter)
    {
        a = cloudpagelistadapter;
        super();
    }

    public void run()
    {
        a.notifyDataSetChanged();
    }
}
