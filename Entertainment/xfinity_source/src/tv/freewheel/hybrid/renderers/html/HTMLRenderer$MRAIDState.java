// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;


// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            HTMLRenderer

private static final class  extends Enum
{

    private static final HIDDEN $VALUES[];
    public static final HIDDEN DEFAULT;
    public static final HIDDEN EXPANDED;
    public static final HIDDEN HIDDEN;
    public static final HIDDEN LOADING;
    public static final HIDDEN RESIZED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(tv/freewheel/hybrid/renderers/html/HTMLRenderer$MRAIDState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOADING = new <init>("LOADING", 0);
        DEFAULT = new <init>("DEFAULT", 1);
        EXPANDED = new <init>("EXPANDED", 2);
        RESIZED = new <init>("RESIZED", 3);
        HIDDEN = new <init>("HIDDEN", 4);
        $VALUES = (new .VALUES[] {
            LOADING, DEFAULT, EXPANDED, RESIZED, HIDDEN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
