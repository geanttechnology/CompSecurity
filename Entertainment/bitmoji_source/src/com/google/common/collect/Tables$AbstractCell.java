// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Objects;

// Referenced classes of package com.google.common.collect:
//            Tables

static abstract class 
    implements 
{

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof )
            {
                if (!Objects.equal(getRowKey(), ((getRowKey) (obj = (getRowKey)obj)).()) || !Objects.equal(getColumnKey(), ((getColumnKey) (obj)).Key()) || !Objects.equal(getValue(), ((getValue) (obj)).getValue()))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            getRowKey(), getColumnKey(), getValue()
        });
    }

    public String toString()
    {
        String s = String.valueOf(getRowKey());
        String s1 = String.valueOf(getColumnKey());
        String s2 = String.valueOf(getValue());
        return (new StringBuilder(String.valueOf(s).length() + 4 + String.valueOf(s1).length() + String.valueOf(s2).length())).append("(").append(s).append(",").append(s1).append(")=").append(s2).toString();
    }

    ()
    {
    }
}
