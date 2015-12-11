// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.content.Context;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            AivConnection, IntentConnection, BindingConnection

public static class 
{

    public static AivConnection newConnection(Context context)
    {
        IntentConnection intentconnection = new IntentConnection(context);
        context = new BindingConnection(context, intentconnection);
        if (context.tryConnect())
        {
            return context;
        }
        if (intentconnection.tryConnect())
        {
            return intentconnection;
        } else
        {
            throw new IllegalStateException("Cannot communicate with AIV. Verify the app is installed");
        }
    }

    public ()
    {
    }
}
