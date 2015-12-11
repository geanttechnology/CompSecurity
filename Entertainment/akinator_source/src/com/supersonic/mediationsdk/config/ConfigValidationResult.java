// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.config;

import com.supersonic.mediationsdk.logger.SupersonicError;

public class ConfigValidationResult
{

    private boolean mIsValid;
    private SupersonicError mSupersonicError;

    public ConfigValidationResult()
    {
        mIsValid = true;
        mSupersonicError = null;
    }

    public SupersonicError getSupersonicError()
    {
        return mSupersonicError;
    }

    public boolean isValid()
    {
        return mIsValid;
    }

    public void setInvalid(SupersonicError supersonicerror)
    {
        mIsValid = false;
        mSupersonicError = supersonicerror;
    }

    public void setValid()
    {
        mIsValid = true;
        mSupersonicError = null;
    }

    public String toString()
    {
        if (isValid())
        {
            return (new StringBuilder()).append("valid:").append(mIsValid).toString();
        } else
        {
            return (new StringBuilder()).append("valid:").append(mIsValid).append(", SupersonicError:").append(mSupersonicError).toString();
        }
    }
}
