// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload;


// Referenced classes of package amazon.android.dexload:
//            SupplementalDexLoader

public static final class  extends Enum
{

    private static final NO $VALUES[];
    public static final NO NO;
    public static final NO YES;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(amazon/android/dexload/SupplementalDexLoader$MultiThreaded, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        YES = new <init>("YES", 0);
        NO = new <init>("NO", 1);
        $VALUES = (new .VALUES[] {
            YES, NO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
