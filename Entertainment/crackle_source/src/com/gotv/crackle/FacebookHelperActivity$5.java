// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.SocialOnAPI;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class this._cls0
    implements android.content.stener
{

    final FacebookHelperActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s = CrackleAccountManager.getUserID();
        FacebookHelperActivity.access$100(FacebookHelperActivity.this).updateSocialSettings(getThis(), s, true, true);
        dialoginterface.dismiss();
    }

    r()
    {
        this$0 = FacebookHelperActivity.this;
        super();
    }
}
