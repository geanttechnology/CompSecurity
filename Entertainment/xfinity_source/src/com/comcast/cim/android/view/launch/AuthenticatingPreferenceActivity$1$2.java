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

class this._cls1
    implements android.content.ferenceActivity._cls1._cls2
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        AuthenticatingPreferenceActivity.access$100(_fld0).exitApp(_fld0);
    }

    <init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1

/* anonymous class */
    class AuthenticatingPreferenceActivity._cls1 extends DefaultTaskExecutionListener
    {

        final AuthenticatingPreferenceActivity this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
        }

        public void onPostExecute(Integer integer)
        {
            if (integer.intValue() > AuthenticatingPreferenceActivity.access$000(AuthenticatingPreferenceActivity.this))
            {
                integer = new android.app.AlertDialog.Builder(AuthenticatingPreferenceActivity.this);
                integer.setMessage(com.comcast.cim.android.R.string.version_too_low_desc).setTitle(com.comcast.cim.android.R.string.version_too_low_title).setPositiveButton(com.comcast.cim.android.R.string.dlg_btn_ok, new AuthenticatingPreferenceActivity._cls1._cls2()).setOnCancelListener(new AuthenticatingPreferenceActivity._cls1._cls1());
                integer.create().show();
            }
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((Integer)obj);
        }

            
            {
                this$0 = AuthenticatingPreferenceActivity.this;
                super();
            }

        // Unreferenced inner class com/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity$1$1

/* anonymous class */
        class AuthenticatingPreferenceActivity._cls1._cls1
            implements android.content.DialogInterface.OnCancelListener
        {

            final AuthenticatingPreferenceActivity._cls1 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                AuthenticatingPreferenceActivity.access$100(this$0).exitApp(this$0);
            }

                    
                    {
                        this$1 = AuthenticatingPreferenceActivity._cls1.this;
                        super();
                    }
        }

    }

}
