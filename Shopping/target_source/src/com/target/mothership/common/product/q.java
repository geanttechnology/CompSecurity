// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class q extends Enum
{

    private static final q $VALUES[];
    public static final q CHILD;
    public static final q NONE;
    public static final q PARENT;
    private String mValue;

    private q(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static q a(String s)
    {
        if (s != null)
        {
            q aq[] = values();
            int j = aq.length;
            for (int i = 0; i < j; i++)
            {
                q q1 = aq[i];
                if (s.equalsIgnoreCase(q1.mValue))
                {
                    return q1;
                }
            }

        }
        return NONE;
    }

    public static q valueOf(String s)
    {
        return (q)Enum.valueOf(com/target/mothership/common/product/q, s);
    }

    public static q[] values()
    {
        return (q[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        PARENT = new q("PARENT", 0, "VAP");
        CHILD = new q("CHILD", 1, "SA");
        NONE = new q("NONE", 2, "");
        $VALUES = (new q[] {
            PARENT, CHILD, NONE
        });
    }
}
