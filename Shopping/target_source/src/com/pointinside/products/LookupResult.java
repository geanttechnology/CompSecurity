// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;


// Referenced classes of package com.pointinside.products:
//            BaseProduct

public class LookupResult
{
    public static final class LookupStatus extends Enum
    {

        private static final LookupStatus $VALUES[];
        public static final LookupStatus FOUND;
        public static final LookupStatus NOT_FOUND;

        public static LookupStatus valueOf(String s)
        {
            return (LookupStatus)Enum.valueOf(com/pointinside/products/LookupResult$LookupStatus, s);
        }

        public static LookupStatus[] values()
        {
            return (LookupStatus[])$VALUES.clone();
        }

        static 
        {
            NOT_FOUND = new LookupStatus("NOT_FOUND", 0);
            FOUND = new LookupStatus("FOUND", 1);
            $VALUES = (new LookupStatus[] {
                NOT_FOUND, FOUND
            });
        }

        private LookupStatus(String s, int i)
        {
            super(s, i);
        }
    }


    public String lookupKey;
    public LookupStatus lookupStatus;
    public BaseProduct product;

    public LookupResult()
    {
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("-- Lookup Status -- \n").append(lookupStatus.toString()).append("\n");
        String s;
        if (lookupStatus == LookupStatus.FOUND)
        {
            s = product.toString();
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }
}
