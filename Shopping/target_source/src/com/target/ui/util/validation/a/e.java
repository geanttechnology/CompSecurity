// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.a;

import java.util.List;

// Referenced classes of package com.target.ui.util.validation.a:
//            l

public final class e
    implements l
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a EMPTY;
        public static final a ONLY_SPACES;
        public static final a SPECIAL_CHAR_NOT_ALLOWED;
        public static final a TOO_LONG;
        public static final a TOO_SHORT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/validation/a/e$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            TOO_LONG = new a("TOO_LONG", 0);
            TOO_SHORT = new a("TOO_SHORT", 1);
            ONLY_SPACES = new a("ONLY_SPACES", 2);
            EMPTY = new a("EMPTY", 3);
            SPECIAL_CHAR_NOT_ALLOWED = new a("SPECIAL_CHAR_NOT_ALLOWED", 4);
            $VALUES = (new a[] {
                TOO_LONG, TOO_SHORT, ONLY_SPACES, EMPTY, SPECIAL_CHAR_NOT_ALLOWED
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final boolean isValid;
    public final String name;
    public final List reasons;

    public e(String s, boolean flag, List list)
    {
        name = s;
        isValid = flag;
        reasons = list;
    }

    public boolean a()
    {
        return isValid;
    }
}
