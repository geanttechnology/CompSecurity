// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;


// Referenced classes of package co.vine.android.provider:
//            ExclusiveHybridCursor

public static final class _cls9 extends Enum
{

    private static final LIST $VALUES[];
    public static final LIST CURSOR;
    public static final LIST LIST;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(co/vine/android/provider/ExclusiveHybridCursor$Mode, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        CURSOR = new <init>("CURSOR", 0);
        LIST = new <init>("LIST", 1);
        $VALUES = (new .VALUES[] {
            CURSOR, LIST
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
