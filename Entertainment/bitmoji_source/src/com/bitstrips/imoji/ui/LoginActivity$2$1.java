// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.DialogInterface;
import retrofit.RetrofitError;

// Referenced classes of package com.bitstrips.imoji.ui:
//            LoginActivity

class this._cls1
    implements android.content.ClickListener
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        LoginActivity.access$100(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/bitstrips/imoji/ui/LoginActivity$2

/* anonymous class */
    class LoginActivity._cls2
        implements com.bitstrips.imoji.manager.TemplatesManager.FailureCallback
    {

        final LoginActivity this$0;

        public void failure(RetrofitError retrofiterror)
        {
            LoginActivity.access$200(LoginActivity.this, false, new LoginActivity._cls2._cls1());
        }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
    }

}
