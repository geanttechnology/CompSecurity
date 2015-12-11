// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticatingPreferenceActivity, LaunchStrategy

class r extends DefaultTaskExecutionListener
{

    final AuthenticatingPreferenceActivity this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
    }

    public void onPostExecute(Integer integer)
    {
        if (integer.intValue() > AuthenticatingPreferenceActivity.access$000(AuthenticatingPreferenceActivity.this))
        {
            integer = new android.app.ingPreferenceActivity(AuthenticatingPreferenceActivity.this);
            integer.ingPreferenceActivity(com.comcast.cim.android.eActivity).w_desc(com.comcast.cim.android.eActivity).on(com.comcast.cim.android.eActivity, new android.content.DialogInterface.OnClickListener() {

                final AuthenticatingPreferenceActivity._cls1 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    AuthenticatingPreferenceActivity.access$100(this$0).exitApp(this$0);
                }

            
            {
                this$1 = AuthenticatingPreferenceActivity._cls1.this;
                super();
            }
            }).ener(new android.content.DialogInterface.OnCancelListener() {

                final AuthenticatingPreferenceActivity._cls1 this$1;

                public void onCancel(DialogInterface dialoginterface)
                {
                    AuthenticatingPreferenceActivity.access$100(this$0).exitApp(this$0);
                }

            
            {
                this$1 = AuthenticatingPreferenceActivity._cls1.this;
                super();
            }
            });
            integer._mth1().show();
        }
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Integer)obj);
    }

    _cls2.this._cls1()
    {
        this$0 = AuthenticatingPreferenceActivity.this;
        super();
    }
}
