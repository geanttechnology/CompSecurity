// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;

public class SlotTrait
{

    private String mName;
    private String mType;

    public SlotTrait()
    {
    }

    public SlotTrait(String s, String s1)
    {
        mName = s;
        mType = s1;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof SlotTrait)
        {
            obj = (SlotTrait)obj;
            flag = flag1;
            if (Objects.equal(mType, ((SlotTrait) (obj)).mType))
            {
                flag = flag1;
                if (Objects.equal(mName, ((SlotTrait) (obj)).mName))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final String getName()
    {
        return mName;
    }

    public final String getType()
    {
        return mType;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mName, mType
        });
    }

    public final void setName(String s)
    {
        mName = s;
    }

    public final void setType(String s)
    {
        mType = s;
    }
}
