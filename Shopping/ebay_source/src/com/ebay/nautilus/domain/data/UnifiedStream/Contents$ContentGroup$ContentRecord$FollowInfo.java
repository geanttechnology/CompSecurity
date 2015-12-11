// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static class Visibility
{
    public static final class Visibility extends Enum
    {

        private static final Visibility $VALUES[];
        public static final Visibility PRIVATE;
        public static final Visibility PUBLIC;

        public static Visibility valueOf(String s)
        {
            return (Visibility)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$FollowInfo$Visibility, s);
        }

        public static Visibility[] values()
        {
            return (Visibility[])$VALUES.clone();
        }

        static 
        {
            PUBLIC = new Visibility("PUBLIC", 0);
            PRIVATE = new Visibility("PRIVATE", 1);
            $VALUES = (new Visibility[] {
                PUBLIC, PRIVATE
            });
        }

        private Visibility(String s, int i)
        {
            super(s, i);
        }
    }


    public com.ebay.nautilus.domain.data.rd.FollowInfo.Visibility followDate;
    public boolean hidden;
    public Visibility visibility;

    public Visibility()
    {
    }
}
