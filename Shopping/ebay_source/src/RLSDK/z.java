// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

public final class z
{

    public static final z a = new z("OTHER");
    public static final z b = new z("ORIENTATION");
    public static final z c = new z("BYTE_SEGMENTS");
    public static final z d = new z("ERROR_CORRECTION_LEVEL");
    public static final z e = new z("ISSUE_NUMBER");
    public static final z f = new z("SUGGESTED_PRICE");
    public static final z g = new z("POSSIBLE_COUNTRY");
    private static final Hashtable h = new Hashtable();
    private final String i;

    private z(String s)
    {
        i = s;
        h.put(s, this);
    }

    public final String toString()
    {
        return i;
    }

}
