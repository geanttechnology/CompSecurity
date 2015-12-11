// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;


// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class BuildFeatures
{
    public static final class BUILD_TYPE extends Enum
    {

        public static final BUILD_TYPE EGold;
        private static final BUILD_TYPE ENUM$VALUES[];
        public static final BUILD_TYPE ESilver;

        public static BUILD_TYPE valueOf(String s)
        {
            return (BUILD_TYPE)Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE, s);
        }

        public static BUILD_TYPE[] values()
        {
            BUILD_TYPE abuild_type[] = ENUM$VALUES;
            int i = abuild_type.length;
            BUILD_TYPE abuild_type1[] = new BUILD_TYPE[i];
            System.arraycopy(abuild_type, 0, abuild_type1, 0, i);
            return abuild_type1;
        }

        static 
        {
            ESilver = new BUILD_TYPE("ESilver", 0);
            EGold = new BUILD_TYPE("EGold", 1);
            ENUM$VALUES = (new BUILD_TYPE[] {
                ESilver, EGold
            });
        }

        private BUILD_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class BuildFeatures
    {

        public static boolean isFlagSet(int i)
        {
            return (6L & (long)i) > 0L;
        }
    }


    public static final BUILD_TYPE BUILD;

    static 
    {
        BUILD = BUILD_TYPE.EGold;
    }
}
