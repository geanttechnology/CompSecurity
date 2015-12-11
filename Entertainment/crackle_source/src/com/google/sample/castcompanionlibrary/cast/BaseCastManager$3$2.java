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

class this._cls1
    implements android.content.ickListener
{

    final viceSelected this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        witchMap.com.google.sample.castcompanionlibrary.cast.BaseCastManager.ReconnectionStatus[mReconnectionStatus.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 93
    //                   2 93
    //                   3 93;
           goto _L1 _L2 _L2 _L2
_L1:
        mReconnectionStatus = nnectionStatus.INACTIVE;
        if (g != null)
        {
            g.cancel();
        }
        mReconnectionTask.cancel(true);
        return;
_L2:
        mReconnectionStatus = nnectionStatus.INACTIVE;
        onDeviceSelected(null);
        if (true) goto _L1; else goto _L3
_L3:
    }

    l.timeoutInSeconds()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/sample/castcompanionlibrary/cast/BaseCastManager$3

/* anonymous class */
    class BaseCastManager._cls3 extends AsyncTask
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
            while (i < timeoutInSeconds) 
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
            if (showDialog && dlg != null)
            {
                dlg.dismiss();
            }
            if (integer != null && integer.intValue() == 2)
            {
                mReconnectionStatus = BaseCastManager.ReconnectionStatus.INACTIVE;
                onDeviceSelected(null);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Integer)obj);
        }

        protected void onPreExecute()
        {
            if (!showDialog)
            {
                return;
            } else
            {
                dlg = new ProgressDialog(context);
                dlg.setMessage(context.getString(com.google.sample.castcompanionlibrary.R.string.session_reconnection_attempt));
                dlg.setIndeterminate(true);
                dlg.setCancelable(true);
                dlg.setOnCancelListener(new BaseCastManager._cls3._cls1());
                dlg.setButton(-2, "Cancel", new BaseCastManager._cls3._cls2());
                dlg.show();
                return;
            }
        }


            
            {
                this$0 = final_basecastmanager;
                showDialog = flag;
                context = context1;
                timeoutInSeconds = I.this;
                super();
            }

        // Unreferenced inner class com/google/sample/castcompanionlibrary/cast/BaseCastManager$3$1

/* anonymous class */
        class BaseCastManager._cls3._cls1
            implements android.content.DialogInterface.OnCancelListener
        {

            final BaseCastManager._cls3 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                BaseCastManager._cls7.$SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[mReconnectionStatus.ordinal()];
                JVM INSTR tableswitch 1 3: default 44
            //                           1 93
            //                           2 93
            //                           3 93;
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
        }

    }

}
