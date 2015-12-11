// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import android.os.AsyncTask;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

private class mMessageId
    implements mMessageId
{

    private final String mMessageId;
    private final String mNode;
    final MShopWearListenerService this$0;

    private void asyncReply(final String path, final String data)
    {
        (new AsyncTask() {

            final MShopWearListenerService.MySpeechResultHandler this$1;
            final String val$data;
            final String val$path;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                MShopWearListenerService.access$1400(mNode, mMessageId, path, data);
                return null;
            }

            
            {
                this$1 = MShopWearListenerService.MySpeechResultHandler.this;
                path = s;
                data = s1;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void onError()
    {
        asyncReply("/error/asr", "Error during speech regocnition");
    }

    public void onSuccess(String s)
    {
        asyncReply("/speech/recognize/result", s);
    }



    _cls1.val.data(String s, String s1)
    {
        this$0 = MShopWearListenerService.this;
        super();
        mNode = s;
        mMessageId = s1;
    }
}
