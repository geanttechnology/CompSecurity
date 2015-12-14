// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import com.socialin.android.c;
import com.socialin.gson.Gson;

public class Response
{

    public String message;
    public String reason;
    public String status;

    public Response()
    {
        status = "";
        message = "";
        reason = "";
    }

    public String toString()
    {
        return c.a().toJson(this);
    }
}
