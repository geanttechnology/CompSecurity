// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import java.io.Serializable;

public class NetworkInfo
    implements Serializable
{

    private String displayName;
    private boolean isPremium;
    private int networkId;

    public NetworkInfo()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (NetworkInfo)obj;
            if (isPremium != ((NetworkInfo) (obj)).isPremium)
            {
                return false;
            }
            if (networkId != ((NetworkInfo) (obj)).networkId)
            {
                return false;
            }
            if (displayName == null ? ((NetworkInfo) (obj)).displayName != null : !displayName.equals(((NetworkInfo) (obj)).displayName))
            {
                return false;
            }
        }
        return true;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public int getNetworkId()
    {
        return networkId;
    }

    public int hashCode()
    {
        int j = 0;
        int k = networkId;
        int i;
        if (isPremium)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (displayName != null)
        {
            j = displayName.hashCode();
        }
        return (k * 31 + i) * 31 + j;
    }

    public boolean isPremium()
    {
        return isPremium;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setNetworkId(int i)
    {
        networkId = i;
    }

    public void setisPremium(boolean flag)
    {
        isPremium = flag;
    }
}
