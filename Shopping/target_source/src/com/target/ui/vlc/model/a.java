// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc.model;


public class a
{

    private String mFloorSpaceName;
    private String mSiteName;

    public a(String s, String s1)
    {
        mSiteName = s;
        mFloorSpaceName = s1;
    }

    public String a()
    {
        return mSiteName;
    }

    public String b()
    {
        return mFloorSpaceName;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (a)obj;
            if (mSiteName == null ? ((a) (obj)).mSiteName != null : !mSiteName.equals(((a) (obj)).mSiteName))
            {
                return false;
            }
            if (mFloorSpaceName == null ? ((a) (obj)).mFloorSpaceName != null : !mFloorSpaceName.equals(((a) (obj)).mFloorSpaceName))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (mSiteName != null)
        {
            i = mSiteName.hashCode();
        } else
        {
            i = 0;
        }
        if (mFloorSpaceName != null)
        {
            j = mFloorSpaceName.hashCode();
        }
        return i * 31 + j;
    }
}
