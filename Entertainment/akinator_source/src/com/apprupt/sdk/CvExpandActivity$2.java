// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

// Referenced classes of package com.apprupt.sdk:
//            CvExpandActivity, CvInlineAdWrapper, CvMediator

static final class val.wrapper
    implements Runnable
{

    final CvInlineAdWrapper val$wrapper;

    public void run()
    {
        Context context = val$wrapper.getMediator().getContext();
        int i = CvExpandActivity.access$104();
        CvExpandActivity.access$200().put(Integer.valueOf(i), val$wrapper);
        Bundle bundle = new Bundle();
        bundle.putInt("mraidId", i);
        Intent intent = new Intent(context, com/apprupt/sdk/CvExpandActivity);
        intent.setFlags(0x10000000);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    (CvInlineAdWrapper cvinlineadwrapper)
    {
        val$wrapper = cvinlineadwrapper;
        super();
    }
}
