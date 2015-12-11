// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class cbm
{

    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
        "http://gdata.youtube.com/schemas/2007#user.uploads", "http://gdata.youtube.com/schemas/2007#user.favorites", "http://gdata.youtube.com/schemas/2007#user.subscriptions", "http://gdata.youtube.com/schemas/2007#user.watchhistory", "http://gdata.youtube.com/schemas/2007#user.watchlater", "http://gdata.youtube.com/schemas/2007#user.playlists", "http://gdata.youtube.com/schemas/2007#user.recentactivity"
    })));

    static Set a()
    {
        return a;
    }

    public static void a(bnr bnr1)
    {
        a.d(bnr1, "");
        bnr1.a("/entry", new cbg());
        b(bnr1, "");
    }

    public static void a(bnr bnr1, String s)
    {
        a.d(bnr1, s);
        bnr1.a(String.valueOf(s).concat("/entry"), new cbf());
        b(bnr1, s);
    }

    private static void b(bnr bnr1, String s)
    {
        bnr1.a(String.valueOf(s).concat("/entry/yt:username"), new cbp()).a(String.valueOf(s).concat("/entry/yt:channelId"), new cbo()).a(String.valueOf(s).concat("/entry/yt:googlePlusUserId"), new cbx()).a(String.valueOf(s).concat("/entry/author/email"), new cbw()).a(String.valueOf(s).concat("/entry/yt:age"), new cbv()).a(String.valueOf(s).concat("/entry/yt:gender"), new cbu()).a(String.valueOf(s).concat("/entry/media:thumbnail"), new cbt()).a(String.valueOf(s).concat("/entry/yt:incomplete"), new cbs()).a(String.valueOf(s).concat("/entry/yt:eligibleForChannel"), new cbr()).a(String.valueOf(s).concat("/entry/yt:statistics"), new cbq()).a(String.valueOf(s).concat("/entry/gd:feedLink"), new cbn()).a();
    }

}
