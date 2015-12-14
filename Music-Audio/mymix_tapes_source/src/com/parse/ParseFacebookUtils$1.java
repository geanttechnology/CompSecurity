// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFacebookUtils, SaveCallback, ParseException, FacebookAuthenticationProvider, 
//            ParseUser, Parse

static final class val.callback
    implements ovider.ParseAuthenticationCallback
{

    final SaveCallback val$callback;
    final ParseUser val$user;

    public void onCancel()
    {
        if (val$callback != null)
        {
            val$callback.internalDone(null, null);
        }
    }

    public void onError(Throwable throwable)
    {
        if (val$callback != null)
        {
            val$callback.internalDone(null, new ParseException(throwable));
        }
    }

    public void onSuccess(JSONObject jsonobject)
    {
        Parse.callbackOnMainThreadAsync(val$user.linkWithAsync(ParseFacebookUtils.provider.getAuthType(), jsonobject), val$callback, true);
    }

    nProvider(ParseUser parseuser, SaveCallback savecallback)
    {
        val$user = parseuser;
        val$callback = savecallback;
        super();
    }
}
