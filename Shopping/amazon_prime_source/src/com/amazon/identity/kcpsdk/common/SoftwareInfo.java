// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;


public final class SoftwareInfo
{

    private final String mSoftwareComponentId;
    private final Integer mSoftwareVersion;

    public SoftwareInfo(Integer integer, String s)
    {
        mSoftwareVersion = integer;
        mSoftwareComponentId = s;
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = false;
        boolean flag1;
        if (this == obj)
        {
            flag1 = true;
        } else
        {
            flag1 = flag2;
            if (obj != null)
            {
                flag1 = flag2;
                if (obj instanceof SoftwareInfo)
                {
                    obj = (SoftwareInfo)obj;
                    boolean flag;
                    if (mSoftwareComponentId == null)
                    {
                        if (((SoftwareInfo) (obj)).getSoftwareComponentId() == null)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = mSoftwareComponentId.equals(((SoftwareInfo) (obj)).mSoftwareComponentId);
                    }
                    flag1 = flag2;
                    if (flag)
                    {
                        if (mSoftwareVersion == null)
                        {
                            if (((SoftwareInfo) (obj)).getSoftwareComponentId() == null)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                        } else
                        {
                            flag = mSoftwareComponentId.equals(((SoftwareInfo) (obj)).mSoftwareComponentId);
                        }
                        return flag;
                    }
                }
            }
        }
        return flag1;
    }

    public String getSoftwareComponentId()
    {
        return mSoftwareComponentId;
    }

    public Integer getSoftwareVersion()
    {
        return mSoftwareVersion;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (mSoftwareComponentId == null)
        {
            i = 0;
        } else
        {
            i = mSoftwareComponentId.hashCode();
        }
        if (mSoftwareVersion != null)
        {
            j = mSoftwareVersion.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public String toString()
    {
        String s;
        if (mSoftwareVersion == null)
        {
            s = "None";
        } else
        {
            s = mSoftwareVersion.toString();
        }
        return String.format("Version: %s, ComponentId: %s", new Object[] {
            s, mSoftwareComponentId
        });
    }
}
