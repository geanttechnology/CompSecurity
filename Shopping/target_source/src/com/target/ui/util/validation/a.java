// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import com.target.ui.util.validation.a.f;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.util.validation:
//            h

public class a
{

    private static final String ALLOWED_NAME_CHARACTERS = (new StringBuilder()).append("- '.ABCDEFGHIJKLMNOPQRSTUVWXYZ").append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase()).toString();
    private static final String CAPS_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LAST_NAME_MAX_LENGTH = 40;
    private static final String NAME_SPECIAL_CHARACTERS = "- '.";
    private static final int PASSWORD_MAX_LENGTH = 20;
    private static final int PASSWORD_MIN_LENGTH = 8;

    public static f a(String s)
    {
        boolean flag2 = true;
        boolean flag3 = h.b(s, 20);
        ArrayList arraylist;
        boolean flag;
        boolean flag1;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        if (!flag3 && h.a(s, 8))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag4 = com.target.ui.util.validation.h.f(s);
        flag5 = h.g(s);
        flag6 = h.b(s);
        if (!flag6 && !flag4 && h.d(s))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag6 || flag5 || !h.e(s))
        {
            flag2 = false;
        }
        flag7 = h.h(s);
        arraylist = new ArrayList(com.target.ui.util.validation.a.f.a.values().length);
        if (flag)
        {
            arraylist.add(com.target.ui.util.validation.a.f.a.TOO_SHORT);
        }
        if (flag3)
        {
            arraylist.add(com.target.ui.util.validation.a.f.a.TOO_LONG);
        }
        if (!flag6 && !flag4 && !flag5)
        {
            arraylist.add(com.target.ui.util.validation.a.f.a.REQ_CAP_NUM_SPECIAL);
        }
        if (flag1)
        {
            arraylist.add(com.target.ui.util.validation.a.f.a.REQ_NOT_ALL_NUMBERS);
        }
        if (flag2)
        {
            arraylist.add(com.target.ui.util.validation.a.f.a.REQ_NOT_ALL_SPECIAL_CHARS);
        }
        if (flag7)
        {
            arraylist.add(com.target.ui.util.validation.a.f.a.REQ_NO_GREATERTHAN_LESSTHAN);
        }
        return new f(s, arraylist.isEmpty(), arraylist);
    }

}
