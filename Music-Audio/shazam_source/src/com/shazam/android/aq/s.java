// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aq;

import android.support.v4.f.e;
import com.shazam.a.g;
import com.shazam.android.util.k;
import com.shazam.f.c.a;
import com.shazam.j.b;
import com.shazam.model.Provider;
import com.shazam.model.configuration.ExploreConfiguration;
import com.shazam.server.response.explore.TopTracks;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class s
    implements Provider
{

    private final g a;
    private final com.shazam.android.persistence.n.b b;
    private final b c;
    private final e d;
    private final k e;
    private final ExploreConfiguration f;

    public s(k k1, g g1, com.shazam.android.persistence.n.b b1, b b2, e e1, ExploreConfiguration exploreconfiguration)
    {
        e = k1;
        a = g1;
        b = b1;
        c = b2;
        d = e1;
        f = exploreconfiguration;
    }

    private Map b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!d() && d.get("topTracksMap") != null) goto _L2; else goto _L1
_L1:
        boolean flag = d();
        if (!flag) goto _L4; else goto _L3
_L3:
        Object obj = a.c(f.f());
        byte abyte0[] = c.a(obj).getBytes();
        e.a("top_tracks.txt", abyte0, abyte0.length);
_L6:
        b.a("pk_last_toptrack_version", ((TopTracks) (obj)).version);
_L7:
        if (obj == null) goto _L2; else goto _L5
_L5:
        d.put("topTracksMap", ((TopTracks) (obj)).topTracksMap);
_L2:
        obj = (Map)d.get("topTracksMap");
        this;
        JVM INSTR monitorexit ;
        return ((Map) (obj));
        Exception exception1;
        exception1;
        (new StringBuilder("Failed to save top tracks to file: ")).append(exception1);
          goto _L6
        obj;
        (new StringBuilder("Failed to load top tracks form network: ")).append(obj);
_L4:
        obj = c();
          goto _L7
        Exception exception;
        exception;
        throw exception;
          goto _L6
    }

    private TopTracks c()
    {
        byte abyte0[] = e.a("top_tracks.txt");
        TopTracks toptracks;
        try
        {
            toptracks = (TopTracks)c.a(new ByteArrayInputStream(abyte0), com/shazam/server/response/explore/TopTracks);
        }
        catch (Exception exception)
        {
            (new StringBuilder("Failed to load top tracks from file: ")).append(exception);
            return null;
        }
        return toptracks;
    }

    private boolean d()
    {
        if (f.f() != null)
        {
            long l = b.g("pk_last_toptrack_version");
            Date date = new Date();
            if (l < Long.parseLong((new SimpleDateFormat("yyyyMMdd", Locale.US)).format(date)))
            {
                return true;
            }
        }
        return false;
    }

    public final Object a()
    {
        return b();
    }
}
