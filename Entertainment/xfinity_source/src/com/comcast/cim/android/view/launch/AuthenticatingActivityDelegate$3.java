// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticatingActivityDelegate, LaunchStrategy

class ner extends DefaultTaskExecutionListener
{

    final AuthenticatingActivityDelegate this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
    }

    public void onPostExecute(Integer integer)
    {
        AuthenticatingActivityDelegate.access$200(AuthenticatingActivityDelegate.this).debug((new StringBuilder()).append("Min Version Check: Current App Version is ").append(AuthenticatingActivityDelegate.access$100(AuthenticatingActivityDelegate.this)).append(", Server Minimum Version is ").append(integer).toString());
        if (integer.intValue() > AuthenticatingActivityDelegate.access$100(AuthenticatingActivityDelegate.this))
        {
            integer = new Bundle();
            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("messageDlg");
            integer.putString("description", AuthenticatingActivityDelegate.access$000(AuthenticatingActivityDelegate.this).getResources().getString(com.comcast.cim.android.yDelegate));
            integer.putString("title", AuthenticatingActivityDelegate.access$000(AuthenticatingActivityDelegate.this).getResources().getString(com.comcast.cim.android.yDelegate));
            caldialogfragment.addArguments(integer);
            caldialogfragment.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                final AuthenticatingActivityDelegate._cls3 this$1;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    AuthenticatingActivityDelegate.access$300(this$0).exitApp(AuthenticatingActivityDelegate.access$000(this$0));
                }

            
            {
                this$1 = AuthenticatingActivityDelegate._cls3.this;
                super();
            }
            });
            caldialogfragment.show(AuthenticatingActivityDelegate.access$000(AuthenticatingActivityDelegate.this).getFragmentManager(), "caldialogfragment");
        }
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Integer)obj);
    }

    _cls1.this._cls1()
    {
        this$0 = AuthenticatingActivityDelegate.this;
        super();
    }
}
