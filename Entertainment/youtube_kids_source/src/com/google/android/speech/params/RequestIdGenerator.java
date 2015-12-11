// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import java.util.UUID;

public class RequestIdGenerator
{

    public static final RequestIdGenerator INSTANCE = new RequestIdGenerator();

    private RequestIdGenerator()
    {
    }

    public String newRequestId()
    {
        return UUID.randomUUID().toString();
    }

}
