// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.a;

import java.util.List;

// Referenced classes of package com.target.ui.util.validation.a:
//            l

public final class j
    implements l
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a STATE_INVALID;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/validation/a/j$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            STATE_INVALID = new a("STATE_INVALID", 0);
            $VALUES = (new a[] {
                STATE_INVALID
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final boolean isValid;
    public final List reasons;
    public final String state;

    public j(String s, boolean flag, List list)
    {
        state = s;
        isValid = flag;
        reasons = list;
    }

    public boolean a()
    {
        return isValid;
    }
}
