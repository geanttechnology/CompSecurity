// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;


public final class mIsSelectable extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];
    private boolean mIsSelectable;

    public static mIsSelectable valueOf(String s)
    {
        return (mIsSelectable)Enum.valueOf(com/cyberlink/you/widgetpool/tokenautocomplete/TokenCompleteTextView$TokenClickStyle, s);
    }

    public static mIsSelectable[] values()
    {
        return (mIsSelectable[])e.clone();
    }

    public boolean a()
    {
        return mIsSelectable;
    }

    static 
    {
        a = new <init>("None", 0, false);
        b = new <init>("Delete", 1, false);
        c = new <init>("Select", 2, true);
        d = new <init>("SelectDeselect", 3, true);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i, boolean flag)
    {
        super(s, i);
        mIsSelectable = false;
        mIsSelectable = flag;
    }
}
