// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.exception;

import com.comcast.cim.cmasl.utils.exceptions.CimException;

public class CimUpgradeException extends CimException
{

    public CimUpgradeException()
    {
    }

    public CimUpgradeException(String s, Exception exception)
    {
        super(s, exception);
    }
}
