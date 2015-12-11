// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.text.TextUtils;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MultipleAccountManager

public static abstract class mValue
{

    private final String mType;
    private final String mValue;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (mValue)obj;
            if (!TextUtils.equals(mType, ((mType) (obj)).mType) || !TextUtils.equals(mValue, ((mValue) (obj)).mValue))
            {
                return false;
            }
        }
        return true;
    }

    public String getAccountMappingType()
    {
        return mType;
    }

    public String getAccountMappingValue()
    {
        return mValue;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (mType == null)
        {
            i = 0;
        } else
        {
            i = mType.hashCode();
        }
        if (mValue != null)
        {
            j = mValue.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    (String s, String s1)
    {
        mType = s;
        mValue = s1;
    }
}
