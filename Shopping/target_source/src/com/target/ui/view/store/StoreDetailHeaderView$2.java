// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.target.ui.view.store:
//            StoreDetailHeaderView

class val.navAddress
    implements android.view.eaderView._cls2
{

    final StoreDetailHeaderView this$0;
    final String val$navAddress;

    public void onClick(View view)
    {
        try
        {
            view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://maps.google.com/maps?&daddr=").append(URLEncoder.encode(val$navAddress, "UTF-8")).toString()));
            getContext().startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    ()
    {
        this$0 = final_storedetailheaderview;
        val$navAddress = String.this;
        super();
    }
}
