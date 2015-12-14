// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

interface ParseAuthenticationProvider
{
    public static interface ParseAuthenticationCallback
    {

        public abstract void onCancel();

        public abstract void onError(Throwable throwable);

        public abstract void onSuccess(JSONObject jsonobject);
    }


    public abstract void authenticate(ParseAuthenticationCallback parseauthenticationcallback);

    public abstract void cancel();

    public abstract void deauthenticate();

    public abstract String getAuthType();

    public abstract boolean restoreAuthentication(JSONObject jsonobject);
}
