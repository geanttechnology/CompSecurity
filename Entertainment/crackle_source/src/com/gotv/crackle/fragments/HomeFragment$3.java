// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.content.DialogInterface;
import com.gotv.crackle.helpers.SharedPrefsManager;

// Referenced classes of package com.gotv.crackle.fragments:
//            HomeFragment

class this._cls0
    implements android.content..OnClickListener
{

    final HomeFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        SharedPrefsManager.setIsPushEnabled(false);
        SharedPrefsManager.setPushQuestionAsked(true);
        dialoginterface.dismiss();
    }

    r()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
