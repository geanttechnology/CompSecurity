// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.activities:
//            UserDetailActivity

class val.pictureUrls
    implements android.content.ckListener
{

    final UserDetailActivity this$0;
    final String val$body;
    final ArrayList val$pictureUrls;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (val$body != null)
        {
            askQuestion(val$body, val$pictureUrls);
        }
    }

    ()
    {
        this$0 = final_userdetailactivity;
        val$body = s;
        val$pictureUrls = ArrayList.this;
        super();
    }
}
