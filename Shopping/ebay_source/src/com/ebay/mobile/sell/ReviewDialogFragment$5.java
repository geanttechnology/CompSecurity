// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowWebViewActivity;

// Referenced classes of package com.ebay.mobile.sell:
//            ReviewDialogFragment

class val.url extends ClickableSpan
{

    final ReviewDialogFragment this$0;
    final String val$url;

    public void onClick(View view)
    {
        if (MyApp.getPrefs().getUserIsPpa())
        {
            getActivity().showDialog(0x7f0707aa);
            return;
        } else
        {
            view = getActivity();
            Intent intent = new Intent(view, com/ebay/mobile/activities/ShowWebViewActivity);
            intent.putExtra("url", val$url);
            intent.putExtra("android.intent.extra.TITLE", getString(0x7f070a5c));
            intent.putExtra("use_sso", true);
            view.startActivity(intent);
            return;
        }
    }

    ty()
    {
        this$0 = final_reviewdialogfragment;
        val$url = String.this;
        super();
    }
}
