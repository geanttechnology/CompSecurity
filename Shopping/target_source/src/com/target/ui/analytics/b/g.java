// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;


// Referenced classes of package com.target.ui.analytics.b:
//            a

public class g extends com.target.ui.analytics.b.a
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a Add;
        public static final a Remove;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/b/g$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            Add = new a("Add", 0);
            Remove = new a("Remove", 1);
            $VALUES = (new a[] {
                Add, Remove
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final String itemName;
    public final a listEventType;
    public final int numItems;

    private g(a a1, String s, int i)
    {
        listEventType = a1;
        itemName = s;
        numItems = i;
    }

    public static g a(a a1, String s, int i)
    {
        return new g(a1, s, i);
    }
}
