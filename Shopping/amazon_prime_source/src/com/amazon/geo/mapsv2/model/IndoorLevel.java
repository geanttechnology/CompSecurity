// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.model.internal.IIndoorLevelDelegate;

public final class IndoorLevel
{

    IIndoorLevelDelegate mDelegate;

    public IndoorLevel(IIndoorLevelDelegate iindoorleveldelegate)
    {
        mDelegate = iindoorleveldelegate;
        mDelegate.setWrapper(this);
    }

    public void activate()
    {
        mDelegate.activate();
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
        obj = (IndoorLevel)obj;
        if (mDelegate != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((IndoorLevel) (obj)).mDelegate == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mDelegate.equals(((IndoorLevel) (obj)).mDelegate)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public String getName()
    {
        return mDelegate.getName();
    }

    public String getShortName()
    {
        return mDelegate.getShortName();
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
}
