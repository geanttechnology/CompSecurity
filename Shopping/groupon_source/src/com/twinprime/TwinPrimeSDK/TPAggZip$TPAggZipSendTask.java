// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.os.AsyncTask;
import android.util.Log;
import java.nio.ByteBuffer;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPAggZip, TPLog, TPControlChannelStateMachine

class this._cls0 extends AsyncTask
{

    final TPAggZip this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((byte[][])aobj);
    }

    protected transient Void doInBackground(byte abyte0[][])
    {
        if (TPLog.LOG13.isLoggable("TPAggZip"))
        {
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - Requesting sending xcp msg - ").append(abyte0[0].length).append(" bytes").toString());
        }
        TPControlChannelStateMachine.writeMessage(ByteBuffer.wrap(abyte0[0]));
        return null;
    }

    ne()
    {
        this$0 = TPAggZip.this;
        super();
    }
}
