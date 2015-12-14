// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class xi
{

    public static final int a[];

    static 
    {
        a = new int[com.fotoable.beautyui.other.ArcMenu.Position.values().length];
        try
        {
            a[com.fotoable.beautyui.other.ArcMenu.Position.LEFT_TOP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.fotoable.beautyui.other.ArcMenu.Position.LEFT_BOTTOM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.fotoable.beautyui.other.ArcMenu.Position.RIGHT_TOP.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.fotoable.beautyui.other.ArcMenu.Position.RIGHT_BOTTOM.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.fotoable.beautyui.other.ArcMenu.Position.BOTTOM_CENTER.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
