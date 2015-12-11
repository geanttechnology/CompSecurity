// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;
import java.util.List;

public class ErrorData
    implements Serializable
{

    private List errors;

    public ErrorData()
    {
        errors = null;
    }

    public List getErrors()
    {
        return errors;
    }
}
