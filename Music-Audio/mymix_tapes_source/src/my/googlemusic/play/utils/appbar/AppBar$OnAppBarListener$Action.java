// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.appbar;


// Referenced classes of package my.googlemusic.play.utils.appbar:
//            AppBar

public static final class  extends Enum
{

    private static final CLOSE $VALUES[];
    public static final CLOSE BACK;
    public static final CLOSE CLOSE;
    public static final CLOSE COMMENTS;
    public static final CLOSE DRAWER;
    public static final CLOSE INSTAGRAM;
    public static final CLOSE LOADING;
    public static final CLOSE PROFILE;
    public static final CLOSE SEARCH;
    public static final CLOSE SETTINGS;
    public static final CLOSE SHARE;
    public static final CLOSE TWITTER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(my/googlemusic/play/utils/appbar/AppBar$OnAppBarListener$Action, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAWER = new <init>("DRAWER", 0);
        BACK = new <init>("BACK", 1);
        INSTAGRAM = new <init>("INSTAGRAM", 2);
        TWITTER = new <init>("TWITTER", 3);
        SHARE = new <init>("SHARE", 4);
        SEARCH = new <init>("SEARCH", 5);
        SETTINGS = new <init>("SETTINGS", 6);
        PROFILE = new <init>("PROFILE", 7);
        LOADING = new <init>("LOADING", 8);
        COMMENTS = new <init>("COMMENTS", 9);
        CLOSE = new <init>("CLOSE", 10);
        $VALUES = (new .VALUES[] {
            DRAWER, BACK, INSTAGRAM, TWITTER, SHARE, SEARCH, SETTINGS, PROFILE, LOADING, COMMENTS, 
            CLOSE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
