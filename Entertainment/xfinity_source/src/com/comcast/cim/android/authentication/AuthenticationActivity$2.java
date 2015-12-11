// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import android.os.AsyncTask;
import com.comcast.cim.model.user.XipUser;
import com.comcast.cim.model.user.XipUserManager;

// Referenced classes of package com.comcast.cim.android.authentication:
//            AuthenticationActivity

class this._cls0 extends AsyncTask
{

    final AuthenticationActivity this$0;

    protected transient XipUser doInBackground(Void avoid[])
    {
        return AuthenticationActivity.access$000(AuthenticationActivity.this);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(XipUser xipuser)
    {
        if (xipuser == null)
        {
            hideSigningInSpinner();
            return;
        }
        if (xipuser.equals(getUserManager().getUser()))
        {
            AuthenticationActivity.access$100(AuthenticationActivity.this, xipuser);
            setResult(1);
            finish();
            return;
        } else
        {
            AuthenticationActivity.access$100(AuthenticationActivity.this, xipuser);
            setResult(2);
            finish();
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((XipUser)obj);
    }

    ()
    {
        this$0 = AuthenticationActivity.this;
        super();
    }
}
