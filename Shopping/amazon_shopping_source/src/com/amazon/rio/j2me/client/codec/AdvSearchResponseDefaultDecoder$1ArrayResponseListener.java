// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;


// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            StreamedResponseListener, AdvSearchResponseDefaultDecoder

final class val.fieldPath
    implements StreamedResponseListener
{

    private final int path[];
    final AdvSearchResponseDefaultDecoder this$0;
    final StreamedResponseListener val$callback;
    final int val$fieldPath[];

    public void aboutToReceiveArrayOfSize(int i, int ai[])
    {
        val$callback.aboutToReceiveArrayOfSize(i, val$fieldPath);
    }

    public void receivedObject(Object obj, int ai[])
    {
        if (ai.length > 0)
        {
            path[1] = ai[0];
            val$callback.receivedObject(obj, path);
        }
    }

    ()
    {
        this$0 = final_advsearchresponsedefaultdecoder;
        val$fieldPath = ai;
        val$callback = StreamedResponseListener.this;
        super();
        path = (new int[] {
            val$fieldPath[0], -1
        });
    }
}
