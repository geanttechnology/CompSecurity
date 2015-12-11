// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class Template
{
    public static final class Template extends Enum
    {

        private static final Template $VALUES[];
        public static final Template FULLSCREEN;
        public static final Template MINI;

        public static Template valueOf(String s)
        {
            return (Template)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$SignIn$Template, s);
        }

        public static Template[] values()
        {
            return (Template[])$VALUES.clone();
        }

        static 
        {
            FULLSCREEN = new Template("FULLSCREEN", 0);
            MINI = new Template("MINI", 1);
            $VALUES = (new Template[] {
                FULLSCREEN, MINI
            });
        }

        private Template(String s, int i)
        {
            super(s, i);
        }
    }


    public Template template;

    public Template()
    {
    }
}
