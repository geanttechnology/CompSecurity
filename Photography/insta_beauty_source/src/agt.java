// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class agt
{

    static final int a[];

    static 
    {
        a = new int[com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN.values().length];
        try
        {
            a[com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN.KEYBOARD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN.FONT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar.COMBOTTOMBTN.STYLE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
