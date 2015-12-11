// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            az

private static final class  extends Enum
{

    public static final Vu Vs;
    public static final Vu Vt;
    public static final Vu Vu;
    private static final Vu Vv[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/tagmanager/az$a, s);
    }

    public static [] values()
    {
        return ([])Vv.clone();
    }

    static 
    {
        Vs = new <init>("NONE", 0);
        Vt = new <init>("URL", 1);
        Vu = new <init>("BACKSLASH", 2);
        Vv = (new Vv[] {
            Vs, Vt, Vu
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
