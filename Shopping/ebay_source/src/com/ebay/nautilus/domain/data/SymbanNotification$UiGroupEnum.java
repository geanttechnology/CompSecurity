// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            SymbanNotification

public static final class  extends Enum
{

    private static final UI_6 $VALUES[];
    public static final UI_6 UI_1;
    public static final UI_6 UI_2;
    public static final UI_6 UI_3;
    public static final UI_6 UI_4;
    public static final UI_6 UI_5;
    public static final UI_6 UI_6;

    public static  factory(String s)
    {
         a[] = values();
        int j = a.length;
        for (int i = 0; i < j; i++)
        {
              = a[i];
            if (TextUtils.equals(.name(), s))
            {
                return ;
            }
        }

        return null;
    }

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$UiGroupEnum, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        UI_1 = new <init>("UI_1", 0);
        UI_2 = new <init>("UI_2", 1);
        UI_3 = new <init>("UI_3", 2);
        UI_4 = new <init>("UI_4", 3);
        UI_5 = new <init>("UI_5", 4);
        UI_6 = new <init>("UI_6", 5);
        $VALUES = (new .VALUES[] {
            UI_1, UI_2, UI_3, UI_4, UI_5, UI_6
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
