// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;


public final class  extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(w/panzoomview/ViewSetting$SettingAction, s);
    }

    public static [] values()
    {
        return ([])e.clone();
    }

    static 
    {
        a = new <init>("BYPASS_TOUCH_EVENT", 0);
        b = new <init>("SET_TOUCH_EVENT_HANDLER", 1);
        c = new <init>("ADD_OVERLAY_DRAWABLE", 2);
        d = new <init>("REMOVE_OVERLAY_DRAWABLE", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
