// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.Toast;
import com.facebook.Session;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.SocialOnAPI;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class val.session
    implements Runnable
{

    final FacebookHelperActivity this$0;
    final Session val$session;

    public void run()
    {
        switch (FacebookHelperActivity.access$000(FacebookHelperActivity.this))
        {
        case 3: // '\003'
        default:
            return;

        case 0: // '\0'
            String s = CrackleAccountManager.getUserID();
            FacebookHelperActivity.access$102(FacebookHelperActivity.this, new SocialOnAPI());
            FacebookHelperActivity.access$100(FacebookHelperActivity.this).updateSocialSettings(getThis(), s, true, true);
            return;

        case 1: // '\001'
            postDialog(val$session, FacebookHelperActivity.access$200(FacebookHelperActivity.this));
            return;

        case 2: // '\002'
            postSilent(val$session, FacebookHelperActivity.access$200(FacebookHelperActivity.this));
            return;

        case 4: // '\004'
            Toast.makeText(getThis(), getThis().getString(0x7f0b0083), 0).show();
            break;
        }
        getThis().finish();
    }

    r()
    {
        this$0 = final_facebookhelperactivity;
        val$session = Session.this;
        super();
    }
}
