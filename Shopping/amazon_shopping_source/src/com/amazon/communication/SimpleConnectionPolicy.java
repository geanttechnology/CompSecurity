// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.connection.ConnectionPolicy;
import amazon.communication.connection.Priority;

public class SimpleConnectionPolicy
    implements ConnectionPolicy
{

    protected amazon.communication.connection.ConnectionPolicy.CompressionOption mCompressionOption;
    protected boolean mIsAnonymousCredentialsAllowed;
    protected boolean mIsClearText;
    protected boolean mIsInstanceLocked;
    protected boolean mIsLowLatencyNecessary;
    protected boolean mIsRequestResponseOnly;
    protected boolean mIsRoamingAllowed;
    protected boolean mIsShortLived;
    protected boolean mIsWiFiNecessary;
    protected Priority mPriority;

    public SimpleConnectionPolicy()
    {
        mIsRoamingAllowed = true;
        mIsShortLived = true;
        mIsLowLatencyNecessary = false;
        mIsRequestResponseOnly = false;
        mPriority = Priority.PRIORITY_NORMAL;
        mIsInstanceLocked = false;
        mIsClearText = false;
        mIsWiFiNecessary = false;
        mIsAnonymousCredentialsAllowed = false;
        mCompressionOption = amazon.communication.connection.ConnectionPolicy.CompressionOption.ALLOWED;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (SimpleConnectionPolicy)obj;
            if (mIsRoamingAllowed != ((SimpleConnectionPolicy) (obj)).mIsRoamingAllowed || mIsShortLived != ((SimpleConnectionPolicy) (obj)).mIsShortLived || mIsLowLatencyNecessary != ((SimpleConnectionPolicy) (obj)).mIsLowLatencyNecessary || mIsRequestResponseOnly != ((SimpleConnectionPolicy) (obj)).mIsRequestResponseOnly || mIsInstanceLocked != ((SimpleConnectionPolicy) (obj)).mIsInstanceLocked || mIsClearText != ((SimpleConnectionPolicy) (obj)).mIsClearText || mIsWiFiNecessary != ((SimpleConnectionPolicy) (obj)).mIsWiFiNecessary || mIsAnonymousCredentialsAllowed != ((SimpleConnectionPolicy) (obj)).mIsAnonymousCredentialsAllowed || mPriority != ((SimpleConnectionPolicy) (obj)).mPriority || (mCompressionOption != null || ((SimpleConnectionPolicy) (obj)).mCompressionOption != null) && (mCompressionOption == null || !mCompressionOption.equals(((SimpleConnectionPolicy) (obj)).mCompressionOption)))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l1 = 1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int i2;
        if (mIsRoamingAllowed)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (mIsShortLived)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (mIsLowLatencyNecessary)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (mIsRequestResponseOnly)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (mIsInstanceLocked)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i2 = mCompressionOption.hashCode();
        if (mIsClearText)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (mIsWiFiNecessary)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (!mIsAnonymousCredentialsAllowed)
        {
            l1 = 0;
        }
        return (((((((((i + 217) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + i2) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + mPriority.hashCode();
    }

    public void setCompressionOption(amazon.communication.connection.ConnectionPolicy.CompressionOption compressionoption)
    {
        mCompressionOption = compressionoption;
    }

    public void setIsClearText(boolean flag)
    {
        mIsClearText = flag;
    }

    public void setIsInstanceLocked(boolean flag)
    {
        mIsInstanceLocked = flag;
    }

    public void setIsLowLatencyNecessary(boolean flag)
    {
        mIsLowLatencyNecessary = flag;
    }

    public void setIsRequestResponseOnly(boolean flag)
    {
        mIsRequestResponseOnly = flag;
    }

    public void setIsRoamingAllowed(boolean flag)
    {
        mIsRoamingAllowed = flag;
    }

    public void setIsShortLived(boolean flag)
    {
        mIsShortLived = flag;
    }

    public void setIsWiFiNecessary(boolean flag)
    {
        mIsWiFiNecessary = flag;
    }

    public void setPriority(Priority priority)
    {
        mPriority = priority;
    }

    public String toString()
    {
        return (new StringBuilder("{ Roaming: ")).append(mIsRoamingAllowed).append(", ShortLived: ").append(mIsShortLived).append(", LowLatency: ").append(mIsLowLatencyNecessary).append(", RequestResponseOnly: ").append(mIsRequestResponseOnly).append(", Priority: ").append(mPriority).append(", CompressionOption: ").append(mCompressionOption).append(", IsClearText: ").append(mIsClearText).append(", IsWiFiNecessary: ").append(mIsWiFiNecessary).append(", IsAnonymousCredentialsAllowed: ").append(mIsAnonymousCredentialsAllowed).append(" }").toString();
    }
}
