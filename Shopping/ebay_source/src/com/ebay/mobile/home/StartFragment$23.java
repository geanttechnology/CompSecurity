// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.SignInModalActivity;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements android.view.ner
{

    final StartFragment this$0;

    public void onClick(View view)
    {
        if (view.getId() == 0x7f10029e)
        {
            Intent intent = SignInModalActivity.getIntentForSignIn("HomePage", getActivity());
            intent.putExtra("fromHome", true);
            startActivityForResult(intent, 1);
        }
        if (view.getId() == 0x7f10029d)
        {
            startActivityForResult(getRegisterIntent(getActivity(), true), 1);
        }
    }

    Activity()
    {
        this$0 = StartFragment.this;
        super();
    }
}
