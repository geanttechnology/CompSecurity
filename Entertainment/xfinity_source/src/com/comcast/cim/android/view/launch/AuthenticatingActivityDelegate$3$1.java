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

class this._cls1
    implements android.content.ctivityDelegate._cls3._cls1
{

    final is._cls0 this$1;

    public void onDismiss(DialogInterface dialoginterface)
    {
        AuthenticatingActivityDelegate.access$300(_fld0).exitApp(AuthenticatingActivityDelegate.access$000(_fld0));
    }

    r()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$3

/* anonymous class */
    class AuthenticatingActivityDelegate._cls3 extends DefaultTaskExecutionListener
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
                integer.putString("description", AuthenticatingActivityDelegate.access$000(AuthenticatingActivityDelegate.this).getResources().getString(com.comcast.cim.android.R.string.version_too_low_desc));
                integer.putString("title", AuthenticatingActivityDelegate.access$000(AuthenticatingActivityDelegate.this).getResources().getString(com.comcast.cim.android.R.string.version_too_low_title));
                caldialogfragment.addArguments(integer);
                caldialogfragment.setOnDismissListener(new AuthenticatingActivityDelegate._cls3._cls1());
                caldialogfragment.show(AuthenticatingActivityDelegate.access$000(AuthenticatingActivityDelegate.this).getFragmentManager(), "caldialogfragment");
            }
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((Integer)obj);
        }

            
            {
                this$0 = AuthenticatingActivityDelegate.this;
                super();
            }
    }

}
