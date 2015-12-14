// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.facebook;

import android.content.Context;
import android.os.AsyncTask;
import com.amazon.identity.snds.api.SNDSClient;

// Referenced classes of package com.amazon.gallery.thor.facebook:
//            FacebookHelperImpl

class ack extends AsyncTask
{

    final FacebookHelperImpl this$0;
    final String val$accountId;
    final com.amazon.gallery.framework.gallery.actions.tectCallback val$callback;
    final Context val$context;

    protected transient Boolean doInBackground(Void avoid[])
    {
        return Boolean.valueOf((new SNDSClient(val$context)).isSocialNetworkAccountLinked(val$context, val$accountId, com.amazon.identity.snds.api.etworkType.FACEBOOK));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        val$callback.onResult(boolean1.booleanValue());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    ack()
    {
        this$0 = final_facebookhelperimpl;
        val$context = context1;
        val$accountId = s;
        val$callback = com.amazon.gallery.framework.gallery.actions.tectCallback.this;
        super();
    }
}
