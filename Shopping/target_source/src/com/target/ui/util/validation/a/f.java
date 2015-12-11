// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.a;

import java.util.List;

// Referenced classes of package com.target.ui.util.validation.a:
//            l

public final class f
    implements l
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a REQ_CAP_NUM_SPECIAL;
        public static final a REQ_NOT_ALL_NUMBERS;
        public static final a REQ_NOT_ALL_SPECIAL_CHARS;
        public static final a REQ_NO_GREATERTHAN_LESSTHAN;
        public static final a TOO_LONG;
        public static final a TOO_SHORT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/validation/a/f$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            TOO_LONG = new a("TOO_LONG", 0);
            TOO_SHORT = new a("TOO_SHORT", 1);
            REQ_CAP_NUM_SPECIAL = new a("REQ_CAP_NUM_SPECIAL", 2);
            REQ_NOT_ALL_NUMBERS = new a("REQ_NOT_ALL_NUMBERS", 3);
            REQ_NOT_ALL_SPECIAL_CHARS = new a("REQ_NOT_ALL_SPECIAL_CHARS", 4);
            REQ_NO_GREATERTHAN_LESSTHAN = new a("REQ_NO_GREATERTHAN_LESSTHAN", 5);
            $VALUES = (new a[] {
                TOO_LONG, TOO_SHORT, REQ_CAP_NUM_SPECIAL, REQ_NOT_ALL_NUMBERS, REQ_NOT_ALL_SPECIAL_CHARS, REQ_NO_GREATERTHAN_LESSTHAN
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final boolean isValid;
    public final String password;
    public final List reasons;

    public f(String s, boolean flag, List list)
    {
        password = s;
        isValid = flag;
        reasons = list;
    }

    public boolean a()
    {
        return isValid;
    }
}
