// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.a;

import java.util.List;

// Referenced classes of package com.target.ui.util.validation.a:
//            l

public final class b
    implements l
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a SPECIAL_CHAR_NOT_ALLOWED;
        public static final a TOO_LONG;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/validation/a/b$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            TOO_LONG = new a("TOO_LONG", 0);
            SPECIAL_CHAR_NOT_ALLOWED = new a("SPECIAL_CHAR_NOT_ALLOWED", 1);
            $VALUES = (new a[] {
                TOO_LONG, SPECIAL_CHAR_NOT_ALLOWED
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final String apartment;
    public final boolean isValid;
    public final List reasons;

    public b(String s, boolean flag, List list)
    {
        apartment = s;
        isValid = flag;
        reasons = list;
    }

    public boolean a()
    {
        return isValid;
    }
}
