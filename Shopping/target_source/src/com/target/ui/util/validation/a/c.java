// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.a;

import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.ui.util.validation.a:
//            l

public final class c
    implements l
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a PATTERN_MISMATCH;
        public static final a TOO_LONG;
        public static final a TOO_SHORT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/validation/a/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            TOO_SHORT = new a("TOO_SHORT", 0);
            TOO_LONG = new a("TOO_LONG", 1);
            PATTERN_MISMATCH = new a("PATTERN_MISMATCH", 2);
            $VALUES = (new a[] {
                TOO_SHORT, TOO_LONG, PATTERN_MISMATCH
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final com.target.mothership.common.tender.a cardTypeGuess;
    public final String input;
    public final boolean isValid;
    public final a reason;

    public c(boolean flag, a a1, com.target.mothership.common.tender.a a2, String s)
    {
        isValid = flag;
        reason = a1;
        cardTypeGuess = a2;
        input = s;
    }

    public boolean a()
    {
        return isValid;
    }
}
