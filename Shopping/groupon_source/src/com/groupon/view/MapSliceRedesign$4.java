// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.groupon.view:
//            MapSliceRedesign

class val.websiteUri
    implements android.view.r
{

    final MapSliceRedesign this$0;
    final Uri val$websiteUri;

    public void onClick(View view)
    {
        getContext().startActivity(new Intent("android.intent.action.VIEW", val$websiteUri));
    }

    ()
    {
        this$0 = final_mapsliceredesign;
        val$websiteUri = Uri.this;
        super();
    }
}
