// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.json;


public abstract class JSONResponse
{

    public String status;

    public JSONResponse()
    {
    }

    public abstract Object getData();
}
