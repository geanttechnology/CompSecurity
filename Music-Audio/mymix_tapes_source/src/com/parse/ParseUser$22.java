// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseException

static final class 
    implements cationProvider.ParseAuthenticationCallback
{

    final bolts.letionSource val$tcs;

    public void onCancel()
    {
        val$tcs.setCancelled();
    }

    public void onError(Throwable throwable)
    {
        val$tcs.setError(new ParseException(throwable));
    }

    public void onSuccess(JSONObject jsonobject)
    {
        val$tcs.setResult(jsonobject);
    }

    onSource(bolts.letionSource letionsource)
    {
        val$tcs = letionsource;
        super();
    }
}
