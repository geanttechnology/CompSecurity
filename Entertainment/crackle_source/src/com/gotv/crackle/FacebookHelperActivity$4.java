// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.Toast;
import com.facebook.Session;
import com.facebook.SessionState;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.SocialOnAPI;
import com.gotv.crackle.util.Log;
import java.util.List;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class this._cls0
    implements com.facebook.y._cls4
{

    final FacebookHelperActivity this$0;

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        Log.d("FACEBOOK TEST", (new StringBuilder()).append("FACEBOOK TEST = ").append(session.isOpened()).toString());
        if (exception == null) goto _L2; else goto _L1
_L1:
        Toast.makeText(getThis().getApplicationContext(), exception.getLocalizedMessage(), 1).show();
        getThis().finish();
_L4:
        return;
_L2:
        if (!session.getPermissions().contains("email") || CrackleAccountManager.isLoggedIn())
        {
            continue; /* Loop/switch isn't completed */
        }
        FacebookHelperActivity.access$102(FacebookHelperActivity.this, new SocialOnAPI());
        sessionstate = CrackleAccountManager.getUserID();
        FacebookHelperActivity.access$100(FacebookHelperActivity.this).callSSOService(getThis(), session.getAccessToken(), sessionstate);
        while (!FacebookHelperActivity.mThreadDone) ;
        if (FacebookHelperActivity.mEmail == null) goto _L4; else goto _L3
_L3:
        setUpRegisterView();
        return;
        if (sessionstate != SessionState.OPENED && sessionstate != SessionState.OPENED_TOKEN_UPDATED) goto _L4; else goto _L5
_L5:
        if (!session.getPermissions().contains("email"))
        {
            FacebookHelperActivity.access$300(FacebookHelperActivity.this, session);
            return;
        } else
        {
            handleSuccess(session);
            return;
        }
    }

    r()
    {
        this$0 = FacebookHelperActivity.this;
        super();
    }
}
