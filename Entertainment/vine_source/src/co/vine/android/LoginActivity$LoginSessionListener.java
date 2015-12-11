// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.api.VineLogin;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;

// Referenced classes of package co.vine.android:
//            LoginActivity

class this._cls0 extends AppSessionListener
{

    final LoginActivity this$0;

    public void onLoginComplete(Session session, String s, int i, String s1, int j, VineLogin vinelogin)
    {
        completeLogin(i, s1, j);
        mAppController.getEditions();
        dismissDialog();
    }

    ()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
