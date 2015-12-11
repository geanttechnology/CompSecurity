// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.ICameraUpdateDelegate;

public final class CameraUpdate
{

    private final ICameraUpdateDelegate mDelegate;

    CameraUpdate(ICameraUpdateDelegate icameraupdatedelegate)
    {
        mDelegate = icameraupdatedelegate;
        icameraupdatedelegate.setWrapper(this);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (CameraUpdate)obj;
        if (mDelegate != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((CameraUpdate) (obj)).mDelegate == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mDelegate.equals(((CameraUpdate) (obj)).mDelegate)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int i;
        if (mDelegate == null)
        {
            i = 0;
        } else
        {
            i = mDelegate.hashCode();
        }
        return i + 31;
    }

    public Object id()
    {
        return mDelegate;
    }
}
