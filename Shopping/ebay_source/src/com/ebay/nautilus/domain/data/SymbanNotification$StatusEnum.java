// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            SymbanNotification

public static final class A extends Enum
{

    private static final DELETED $VALUES[];
    public static final DELETED DELETED;
    public static final DELETED NEW;
    public static final DELETED READ;

    public static A factory(String s)
    {
        A aa[] = values();
        int j = aa.length;
        for (int i = 0; i < j; i++)
        {
            A a = aa[i];
            if (TextUtils.equals(a.name(), s))
            {
                return a;
            }
        }

        return null;
    }

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$StatusEnum, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        READ = new <init>("READ", 0);
        NEW = new <init>("NEW", 1);
        DELETED = new <init>("DELETED", 2);
        $VALUES = (new .VALUES[] {
            READ, NEW, DELETED
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
