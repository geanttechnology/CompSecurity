// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;

import android.os.AsyncTask;
import com.digidust.elokence.akinator.factories.AkLog;

// Referenced classes of package com.digidust.elokence.akinator.billing:
//            InappManagerImpl, AkInappManager

class this._cls0 extends AsyncTask
{

    final InappManagerImpl this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            Thread.sleep(3000L);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        AkLog.d("AkInappManagerImpl", "Timeout thread !");
        AkInappManager.getInstance().signalInitialised(isInitImpl());
        return null;
    }

    ()
    {
        this$0 = InappManagerImpl.this;
        super();
    }
}
