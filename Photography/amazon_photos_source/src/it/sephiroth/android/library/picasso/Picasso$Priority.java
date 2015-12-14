// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;


// Referenced classes of package it.sephiroth.android.library.picasso:
//            Picasso

public static final class  extends Enum
{

    private static final HIGH $VALUES[];
    public static final HIGH HIGH;
    public static final HIGH LOW;
    public static final HIGH NORMAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(it/sephiroth/android/library/picasso/Picasso$Priority, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOW = new <init>("LOW", 0);
        NORMAL = new <init>("NORMAL", 1);
        HIGH = new <init>("HIGH", 2);
        $VALUES = (new .VALUES[] {
            LOW, NORMAL, HIGH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
