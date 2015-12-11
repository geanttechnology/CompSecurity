// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            BaseCastManager

class val.timeoutInSeconds extends AsyncTask
{

    private final int FAILED = 2;
    private final int SUCCESS = 1;
    private ProgressDialog dlg;
    final BaseCastManager this$0;
    final Context val$context;
    final boolean val$showDialog;
    final int val$timeoutInSeconds;

    protected transient Integer doInBackground(Void avoid[])
    {
        int i = 0;
        while (i < val$timeoutInSeconds) 
        {
            if (mReconnectionTask.isCancelled())
            {
                if (dlg != null)
                {
                    dlg.dismiss();
                }
                return Integer.valueOf(1);
            }
            try
            {
                if (isConnected())
                {
                    cancel(true);
                }
                Thread.sleep(1000L);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            i++;
        }
        return Integer.valueOf(2);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        if (dlg != null)
        {
            dlg.dismiss();
        }
        super.onCancelled();
    }

    protected void onPostExecute(Integer integer)
    {
        if (val$showDialog && dlg != null)
        {
            dlg.dismiss();
        }
        if (integer != null && integer.intValue() == 2)
        {
            mReconnectionStatus = connectionStatus.INACTIVE;
            onDeviceSelected(null);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Integer)obj);
    }

    protected void onPreExecute()
    {
        if (!val$showDialog)
        {
            return;
        } else
        {
            dlg = new ProgressDialog(val$context);
            dlg.setMessage(val$context.getString(com.google.sample.castcompanionlibrary.econnection_attempt));
            dlg.setIndeterminate(true);
            dlg.setCancelable(true);
            dlg.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final BaseCastManager._cls3 this$1;

                public void onCancel(DialogInterface dialoginterface)
                {
                    BaseCastManager._cls7.$SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[mReconnectionStatus.ordinal()];
                    JVM INSTR tableswitch 1 3: default 44
                //                               1 93
                //                               2 93
                //                               3 93;
                       goto _L1 _L2 _L2 _L2
_L1:
                    mReconnectionStatus = BaseCastManager.ReconnectionStatus.INACTIVE;
                    if (dlg != null)
                    {
                        dlg.dismiss();
                    }
                    mReconnectionTask.cancel(true);
                    return;
_L2:
                    mReconnectionStatus = BaseCastManager.ReconnectionStatus.INACTIVE;
                    onDeviceSelected(null);
                    if (true) goto _L1; else goto _L3
_L3:
                }

            
            {
                this$1 = BaseCastManager._cls3.this;
                super();
            }
            });
            dlg.setButton(-2, "Cancel", new android.content.DialogInterface.OnClickListener() {

                final BaseCastManager._cls3 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    BaseCastManager._cls7.$SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[mReconnectionStatus.ordinal()];
                    JVM INSTR tableswitch 1 3: default 44
                //                               1 93
                //                               2 93
                //                               3 93;
                       goto _L1 _L2 _L2 _L2
_L1:
                    mReconnectionStatus = BaseCastManager.ReconnectionStatus.INACTIVE;
                    if (dlg != null)
                    {
                        dlg.cancel();
                    }
                    mReconnectionTask.cancel(true);
                    return;
_L2:
                    mReconnectionStatus = BaseCastManager.ReconnectionStatus.INACTIVE;
                    onDeviceSelected(null);
                    if (true) goto _L1; else goto _L3
_L3:
                }

            
            {
                this$1 = BaseCastManager._cls3.this;
                super();
            }
            });
            dlg.show();
            return;
        }
    }


    _cls2.this._cls1()
    {
        this$0 = final_basecastmanager;
        val$showDialog = flag;
        val$context = context1;
        val$timeoutInSeconds = I.this;
        super();
    }
}
