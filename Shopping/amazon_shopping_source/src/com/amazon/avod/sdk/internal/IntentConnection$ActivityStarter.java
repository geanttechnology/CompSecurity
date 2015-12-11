// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            IntentConnection

private static class <init>
{

    public void startActivity(Context context, Intent intent)
    {
        if (context instanceof Activity)
        {
            intent.setFlags(0x24000000);
            intent.setAction("android.intent.action.VIEW");
            ((Activity)context).startActivityForResult(intent, 0);
            return;
        } else
        {
            intent.setFlags(0x34000000);
            context.startActivity(intent);
            return;
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
