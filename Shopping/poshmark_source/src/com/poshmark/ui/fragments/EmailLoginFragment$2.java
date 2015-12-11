// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.poshmark.ui.customviews.PMEditText;

// Referenced classes of package com.poshmark.ui.fragments:
//            EmailLoginFragment

class this._cls0
    implements android.view.inFragment._cls2
{

    final EmailLoginFragment this$0;

    public void onClick(View view)
    {
        view = "https://www.poshmark.com/user/password/reset";
        if (userHandleEditText.getText().toString().length() > 0)
        {
            view = (new StringBuilder()).append("https://www.poshmark.com/user/password/reset").append("?username=").append(userHandleEditText.getText().toString()).toString();
        }
        view = new Intent("android.intent.action.VIEW", Uri.parse(view));
        startActivity(view);
    }

    ()
    {
        this$0 = EmailLoginFragment.this;
        super();
    }
}
