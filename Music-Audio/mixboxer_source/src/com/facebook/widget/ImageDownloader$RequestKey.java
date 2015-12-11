// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import java.net.URL;

class tag
{

    private static final int HASH_MULTIPLIER = 37;
    private static final int HASH_SEED = 29;
    Object tag;
    URL url;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (obj instanceof tag)
            {
                obj = (tag)obj;
                flag = flag1;
                if (((tag) (obj)).url == url)
                {
                    flag = flag1;
                    if (((url) (obj)).tag == tag)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (url.hashCode() + 1073) * 37 + tag.hashCode();
    }

    (URL url1, Object obj)
    {
        url = url1;
        tag = obj;
    }
}
