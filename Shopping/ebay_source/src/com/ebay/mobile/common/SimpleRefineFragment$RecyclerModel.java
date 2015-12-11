// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;


// Referenced classes of package com.ebay.mobile.common:
//            SimpleRefineFragment

protected static abstract class 
{

    public boolean equals(Object obj)
    {
        if (!(obj instanceof ))
        {
            return false;
        } else
        {
            return (()obj).getTitle().equals(getTitle());
        }
    }

    public abstract String getTitle();

    public int hashCode()
    {
        return getTitle().hashCode();
    }

    protected ()
    {
    }
}
