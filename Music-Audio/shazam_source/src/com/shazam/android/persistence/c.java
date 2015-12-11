// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence;

import android.content.Context;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.net.Uri;
import com.shazam.android.k.a.b;
import com.shazam.b.a.d;
import com.shazam.b.e.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.shazam.android.persistence:
//            b, a

public final class c
    implements com.shazam.android.persistence.b
{

    final Map b = new LinkedHashMap();
    final UriMatcher c = new UriMatcher(-1);
    private final Map d = new LinkedHashMap();
    private final Context e;

    public c(Context context)
    {
        e = context;
    }

    private void a(com.shazam.android.persistence.a a1)
    {
        Object obj = e;
        String s = a1.a;
        com.shazam.b.a.d.a(obj, "Context must not be null");
        com.shazam.b.a.d.a(s, "Path must not be null");
        obj = ((Context) (obj)).getResources().getString(0x7f090245);
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("content").authority(((String) (obj))).appendPath(s);
        a1.b = builder.build();
        d.put(a1.a, a1);
        s = e.getResources().getString(0x7f090245);
        a.a a2;
        for (a1 = a1.c.values().iterator(); a1.hasNext(); c.addURI(s, a2.a, a2.b))
        {
            a2 = (a.a)a1.next();
            b.put(Integer.valueOf(a2.b), a2);
        }

    }

    public final transient Uri a(String s, String as[])
    {
        com.shazam.android.persistence.a a1 = (com.shazam.android.persistence.a)d.get(s);
        if (a1 == null)
        {
            throw new b((new StringBuilder("Content category not found: ")).append(s).toString());
        }
        s = a1.b;
        int j = as.length;
        for (int i = 0; i < j;)
        {
            String s1 = as[i];
            if (com.shazam.b.e.a.c(s1))
            {
                s = Uri.withAppendedPath(s, s1);
                i++;
            } else
            {
                throw new b("Empty identifiers not allowed in \"identifiers\" varargs parameter.");
            }
        }

        return s;
    }

    public final void a()
    {
        a((new com.shazam.android.persistence.a("tracks", Integer.valueOf(3), "vnd.android.cursor.dir/vnd.shazam.library")).a("/#", Integer.valueOf(4), "vnd.android.cursor.item/vnd.shazam.library").a("/*/addons", Integer.valueOf(5), "vnd.android.cursor.dir/vnd.shazam.library").a("/*/addons/#", Integer.valueOf(6), "vnd.android.cursor.item/vnd.shazam.library.addon"));
        a((new com.shazam.android.persistence.a("track", Integer.valueOf(17), "vnd.android.cursor.dir/vnd.shazam.library")).a("/*", Integer.valueOf(17), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("unread_tags", Integer.valueOf(20), "vnd.android.cursor.dir/vnd.shazam.library")).a("/*", Integer.valueOf(21), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("my_tags", Integer.valueOf(7), "vnd.android.cursor.dir/vnd.shazam.library.mytags")).a("/*", Integer.valueOf(8), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("auto_tags", Integer.valueOf(26), "vnd.android.cursor.dir/vnd.shazam.library.autotags")).a("/*", Integer.valueOf(27), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("news_feed_tracks", Integer.valueOf(10), "vnd.android.cursor.item/vnd.shazam.library")).a("/*", Integer.valueOf(10), "vnd.android.cursor.item/vnd.shazam.library"));
        a(new com.shazam.android.persistence.a("news_feed", Integer.valueOf(23), "vnd.android.cursor.dir/vnd.shazam.library.newsfeed"));
        a((new com.shazam.android.persistence.a("explore", Integer.valueOf(24), "vnd.android.cursor.dir/vnd.shazam.library.explore")).a("/*/*", Integer.valueOf(25), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("deep_link_tag", Integer.valueOf(11), "vnd.android.cursor.item/vnd.shazam.library")).a("/*", Integer.valueOf(11), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("chart", Integer.valueOf(12), "vnd.android.cursor.dir/vnd.shazam.library.charts")).a("/*", Integer.valueOf(13), "vnd.android.cursor.item/vnd.shazam.library"));
        a(new com.shazam.android.persistence.a("getJsonSmoidEndpoint", Integer.valueOf(22), "vnd.android.cursor.item/vnd.shazam.library"));
        a(new com.shazam.android.persistence.a("myshazam", Integer.valueOf(29), "vnd.android.cursor.dir/vnd.shazam.library.myshazam"));
        a((new com.shazam.android.persistence.a("artist_follow_status", Integer.valueOf(30), "vnd.android.cursor.item/vnd.shazam.library")).a("/*", Integer.valueOf(30), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("follow_artist", Integer.valueOf(31), "vnd.android.cursor.item/vnd.shazam.library")).a("/*", Integer.valueOf(31), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("unfollow_artist", Integer.valueOf(32), "vnd.android.cursor.item/vnd.shazam.library")).a("/*", Integer.valueOf(32), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("like", Integer.valueOf(33), "vnd.android.cursor.item/vnd.shazam.library")).a("/*", Integer.valueOf(33), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("unlike", Integer.valueOf(34), "vnd.android.cursor.item/vnd.shazam.library")).a("/*", Integer.valueOf(34), "vnd.android.cursor.item/vnd.shazam.library"));
        a((new com.shazam.android.persistence.a("artist_followers_count", Integer.valueOf(35), "vnd.android.cursor.item/vnd.shazam.library")).a("/*", Integer.valueOf(35), "vnd.android.cursor.item/vnd.shazam.library"));
        a(new com.shazam.android.persistence.a("streaming_provider", Integer.valueOf(36), null));
        a(new com.shazam.android.persistence.a("social_setup", Integer.valueOf(37), null));
        a(new com.shazam.android.persistence.a("follow_artist_status", Integer.valueOf(31), null));
    }
}
