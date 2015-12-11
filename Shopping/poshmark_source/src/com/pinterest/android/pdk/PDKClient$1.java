// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import android.content.Context;
import java.util.List;

// Referenced classes of package com.pinterest.android.pdk:
//            PDKCallback, PDKClient, PDKResponse, PDKException

class <init> extends PDKCallback
{

    final PDKClient this$0;
    final Context val$context;
    final List val$permissions;

    public void onFailure(PDKException pdkexception)
    {
        PDKClient.access$300(PDKClient.this, val$context, val$permissions);
    }

    public void onSuccess(PDKResponse pdkresponse)
    {
        if (PDKClient.access$000(PDKClient.this, pdkresponse.getData()))
        {
            boolean _tmp = PDKClient.access$102(true);
            PDKClient.getInstance().getMe(PDKClient.access$200(PDKClient.this));
            return;
        } else
        {
            PDKClient.access$300(PDKClient.this, val$context, val$permissions);
            return;
        }
    }

    ()
    {
        this$0 = final_pdkclient;
        val$context = context1;
        val$permissions = List.this;
        super();
    }
}
