// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;


public final class a
{

    protected static String[] a(String as[], int i, int j)
    {
        j -= i;
        String as1[] = new String[j];
        System.arraycopy(as, i, as1, 0, j);
        return as1;
    }
}
