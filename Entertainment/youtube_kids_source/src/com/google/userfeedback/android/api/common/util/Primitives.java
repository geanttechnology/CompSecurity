// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.util;


public class Primitives
{

    private static PrimitiveConverter converter;

    private Primitives()
    {
    }

    static void injectConverter(PrimitiveConverter primitiveconverter)
    {
        converter = primitiveconverter;
    }

    static void resetConverter()
    {
        converter = new J2meConverter(null);
    }

    public static Integer toInteger(int i)
    {
        return converter.toInteger(i);
    }

    public static Long toLong(long l)
    {
        return converter.toLong(l);
    }

    static 
    {
        resetConverter();
    }

    private class J2meConverter extends PrimitiveConverter
    {
        private class PrimitiveConverter
        {

            public abstract Integer toInteger(int i);

            public abstract Long toLong(long l);

            public PrimitiveConverter()
            {
            }
        }


        private Integer SMALL_INTS[] = {
            Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), 
            Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15)
        };
        private Long SMALL_LONGS[] = {
            new Long(0L), new Long(1L), new Long(2L), new Long(3L), new Long(4L), new Long(5L), new Long(6L), new Long(7L), new Long(8L), new Long(9L), 
            new Long(10L), new Long(11L), new Long(12L), new Long(13L), new Long(14L), new Long(15L)
        };

        public Integer toInteger(int i)
        {
            if (i >= 0 && i < SMALL_INTS.length)
            {
                return SMALL_INTS[i];
            } else
            {
                return Integer.valueOf(i);
            }
        }

        public Long toLong(long l)
        {
            if (l >= 0L && l < (long)SMALL_LONGS.length)
            {
                return SMALL_LONGS[(int)l];
            } else
            {
                return new Long(l);
            }
        }

        private J2meConverter()
        {
        }

        J2meConverter(_cls1 _pcls1)
        {
            this();
        }
    }

}
