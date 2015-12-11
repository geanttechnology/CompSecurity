// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;


// Referenced classes of package com.target.ui.view.common:
//            c

public interface b
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ERROR_DEFAULT;
        public static final a ERROR_NO_NETWORK;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/view/common/b$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            ERROR_NO_NETWORK = new a("ERROR_NO_NETWORK", 0);
            ERROR_DEFAULT = new a("ERROR_DEFAULT", 1);
            $VALUES = (new a[] {
                ERROR_NO_NETWORK, ERROR_DEFAULT
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void a(a a1, boolean flag);

    public abstract void a(String s, String s1, boolean flag);

    public abstract void setClickListener(c c);
}
