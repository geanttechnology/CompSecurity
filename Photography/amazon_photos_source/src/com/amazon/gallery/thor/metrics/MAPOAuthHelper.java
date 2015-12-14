// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.metrics;

import android.content.Context;
import com.amazon.client.metrics.transport.OAuthHelper;
import com.amazon.gallery.thor.app.authentication.BlockingTokenAccessor;

public class MAPOAuthHelper
    implements OAuthHelper, com.amazon.device.utils.OAuthHelper
{

    private Context context;

    public MAPOAuthHelper(Context context1)
    {
        context = context1;
    }

    public String getAccessToken()
        throws Exception
    {
        return (new BlockingTokenAccessor(context)).getAccessToken();
    }
}
