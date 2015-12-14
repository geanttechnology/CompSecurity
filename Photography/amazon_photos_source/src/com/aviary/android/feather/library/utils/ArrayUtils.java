// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import java.util.List;

public final class ArrayUtils
{

    public static final float EMPTY_FLOAT_ARRAY[] = new float[0];

    private ArrayUtils()
    {
    }

    public static transient CharSequence[] concat(CharSequence acharsequence[], CharSequence acharsequence1[][])
        throws IllegalAccessException
    {
        CharSequence acharsequence2[];
        if (acharsequence1.length > 0)
        {
            int k = acharsequence.length;
            for (int i = 0; i < acharsequence1.length; i++)
            {
                k += acharsequence1[i].length;
            }

            acharsequence2 = new CharSequence[k];
            System.arraycopy(acharsequence, 0, acharsequence2, 0, acharsequence.length);
            k = acharsequence.length;
            int l = acharsequence1.length;
            for (int j = 0; j < l; j++)
            {
                acharsequence = acharsequence1[j];
                System.arraycopy(acharsequence, 0, acharsequence2, k, acharsequence.length);
                k += acharsequence.length;
            }

        } else
        {
            throw new IllegalAccessException("at least two arguments are required");
        }
        return acharsequence2;
    }

    public static float[] toPrimitive(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        float af[] = null;
_L4:
        return af;
_L2:
        if (list.size() == 0)
        {
            return EMPTY_FLOAT_ARRAY;
        }
        float af1[] = new float[list.size()];
        int i = 0;
        do
        {
            af = af1;
            if (i >= list.size())
            {
                continue;
            }
            af1[i] = ((Float)list.get(i)).floatValue();
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
