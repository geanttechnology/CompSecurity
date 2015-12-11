// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;

import org.json.JSONObject;

public interface RdioApiCallback
{

    public abstract void onApiFailure(String s, Exception exception);

    public abstract void onApiSuccess(JSONObject jsonobject);
}
