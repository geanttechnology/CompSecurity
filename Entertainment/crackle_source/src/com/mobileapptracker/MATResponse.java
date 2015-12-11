// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import org.json.JSONObject;

public interface MATResponse
{

    public abstract void didFailWithError(JSONObject jsonobject);

    public abstract void didSucceedWithData(JSONObject jsonobject);

    public abstract void enqueuedActionWithRefId(String s);
}
