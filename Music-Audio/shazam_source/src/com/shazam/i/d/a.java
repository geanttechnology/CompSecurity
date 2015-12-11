// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.d;

import android.content.Context;
import com.shazam.android.ax.i;
import com.shazam.android.k.f.ac;
import com.shazam.android.k.f.ad;
import com.shazam.android.k.f.ah;
import com.shazam.android.k.f.ai;
import com.shazam.android.k.f.aj;
import com.shazam.android.l.aa;
import com.shazam.android.l.e;
import com.shazam.android.l.f.a.b;
import com.shazam.android.l.k;
import com.shazam.android.l.m;
import com.shazam.android.l.x;
import com.shazam.android.l.z;
import com.shazam.i.b.ah.c.d;
import com.shazam.i.b.c;
import com.shazam.model.ActionType;
import com.shazam.model.configuration.StreamingConfiguration;
import java.util.EnumMap;
import java.util.Map;

// Referenced classes of package com.shazam.i.d:
//            d

public final class a
{

    private static com.shazam.b.a.a a()
    {
        return new m(com.shazam.i.b.e.a.a(), d.a());
    }

    public static com.shazam.b.a.a a(ac ac)
    {
        return new aa(ac);
    }

    private static com.shazam.b.a.a a(StreamingConfiguration streamingconfiguration, com.shazam.android.activities.streaming.b b1, com.shazam.android.activities.streaming.b b2)
    {
        return new com.shazam.android.l.f.a.a(c.a(), streamingconfiguration, b1, b2);
    }

    private static transient com.shazam.b.a.a a(com.shazam.b.a.a aa1[])
    {
        return new com.shazam.c.d(aa1);
    }

    public static Map a(Map map)
    {
        EnumMap enummap = new EnumMap(com/shazam/model/ActionType);
        enummap.put(ActionType.INTENT, new k(a(new com.shazam.b.a.a[] {
            a(), b(map)
        }), new com.shazam.android.ab.a()));
        enummap.put(ActionType.ARTIST, new e(com.shazam.i.d.d.c()));
        enummap.put(ActionType.TRACK, new com.shazam.android.l.c());
        enummap.put(ActionType.DETAILS, new com.shazam.android.l.f.a.c(new ad("details"), c.a().getPackageName()));
        enummap.put(ActionType.DISCOGRAPHY, new com.shazam.android.l.f.a.c(new ai(), c.a().getPackageName()));
        enummap.put(ActionType.URI, new x(a(new com.shazam.b.a.a[] {
            a(), b(map)
        })));
        enummap.put(ActionType.WEBVIEW, new com.shazam.android.l.ad(a(new com.shazam.b.a.a[] {
            a(((ac) (new aj()))), a()
        })));
        enummap.put(ActionType.VIDEO, new b(c.a()));
        enummap.put(ActionType.YOUTUBE_PLAY, new com.shazam.android.l.f.a.d(c.a(), new i(c.a())));
        enummap.put(ActionType.CAST, new com.shazam.android.l.f.a.c(new ah(), c.a().getPackageName()));
        enummap.put(ActionType.RDIO_PLAY, a(((StreamingConfiguration) (com.shazam.i.b.n.b.h())), com.shazam.android.activities.streaming.b.a, null));
        enummap.put(ActionType.RDIO_CONNECT, a(((StreamingConfiguration) (com.shazam.i.b.n.b.h())), com.shazam.android.activities.streaming.b.a, com.shazam.i.b.b.a.a.a().a()));
        enummap.put(ActionType.SPOTIFY_PLAY, a(((StreamingConfiguration) (com.shazam.i.b.n.b.G())), com.shazam.android.activities.streaming.b.b, null));
        return enummap;
    }

    private static com.shazam.b.a.a b(Map map)
    {
        return new z(map);
    }
}
