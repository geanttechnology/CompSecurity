// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import com.socialin.android.apiv3.model.ImageItem;

final class a
{

    private ImageItem a;
    private final String b;

    private a(ImageItem imageitem, String s)
    {
        a = imageitem;
        b = s;
    }

    a(ImageItem imageitem, String s, byte byte0)
    {
        this(imageitem, s);
    }

    private a(String s)
    {
        b = s;
    }

    a(String s, String s1)
    {
        this(s1);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof a)
        {
            obj = (a)obj;
            flag = flag1;
            if (a.equals(((a) (obj)).a))
            {
                flag = flag1;
                if (b.equals(((a) (obj)).b))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return a.hashCode() * 31 + b.hashCode();
    }
}
