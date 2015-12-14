// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.appbar;


// Referenced classes of package my.googlemusic.play.utils.appbar:
//            AppBar

public static interface Action
{
    public static final class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action BACK;
        public static final Action CLOSE;
        public static final Action COMMENTS;
        public static final Action DRAWER;
        public static final Action INSTAGRAM;
        public static final Action LOADING;
        public static final Action PROFILE;
        public static final Action SEARCH;
        public static final Action SETTINGS;
        public static final Action SHARE;
        public static final Action TWITTER;

        public static Action valueOf(String s)
        {
            return (Action)Enum.valueOf(my/googlemusic/play/utils/appbar/AppBar$OnAppBarListener$Action, s);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        static 
        {
            DRAWER = new Action("DRAWER", 0);
            BACK = new Action("BACK", 1);
            INSTAGRAM = new Action("INSTAGRAM", 2);
            TWITTER = new Action("TWITTER", 3);
            SHARE = new Action("SHARE", 4);
            SEARCH = new Action("SEARCH", 5);
            SETTINGS = new Action("SETTINGS", 6);
            PROFILE = new Action("PROFILE", 7);
            LOADING = new Action("LOADING", 8);
            COMMENTS = new Action("COMMENTS", 9);
            CLOSE = new Action("CLOSE", 10);
            $VALUES = (new Action[] {
                DRAWER, BACK, INSTAGRAM, TWITTER, SHARE, SEARCH, SETTINGS, PROFILE, LOADING, COMMENTS, 
                CLOSE
            });
        }

        private Action(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void onAppBarClick(Action action);
}
