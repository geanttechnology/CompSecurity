// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a.a;

import android.content.res.Resources;
import com.shazam.a.a.a.f;
import com.shazam.a.a.a.g;
import com.shazam.a.a.a.h;
import com.shazam.android.analytics.TaggingStatus;
import com.shazam.android.analytics.orbit.OrbitErrorAnalytics;
import com.shazam.android.j.g.e;
import com.shazam.android.j.o.a;
import com.shazam.android.l.n;
import com.shazam.android.l.t;
import com.shazam.h.e.d;
import com.shazam.h.i;
import com.shazam.h.j;
import com.shazam.h.k;
import com.shazam.h.l;
import com.shazam.h.o;
import com.shazam.h.x;
import com.shazam.j.b;
import com.shazam.model.Tag;
import com.shazam.model.availability.GooglePlayAvailability;
import com.shazam.model.location.SimpleLocation;
import com.shazam.server.legacy.DoRecognitionResponse;
import com.shazam.server.legacy.ErrorBean;
import com.shazam.server.legacy.ErrorResponse;
import com.shazam.server.legacy.Json;
import com.shazam.server.legacy.Match;
import com.shazam.server.legacy.Recognition;
import com.shazam.server.legacy.RequestConfigResponse;
import com.shazam.server.legacy.RequestSmoid;
import com.shazam.server.legacy.RequestSmoidResponse;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import com.shazam.server.legacy.track.Track;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

// Referenced classes of package com.shazam.a.a:
//            d, b

public final class c
    implements com.shazam.a.a.d
{

    private final i a;
    private final com.shazam.e.a b;
    private final a c;
    private final com.shazam.android.j.o.b d;
    private final e e;
    private final com.shazam.android.persistence.i.a f;
    private final com.shazam.android.j.g.j g;
    private final com.shazam.a.a.b h;
    private final t i;
    private final com.shazam.android.j.g.a j;
    private final com.shazam.android.j.g.d k;
    private final com.shazam.android.u.c l;
    private final com.shazam.android.advert.c m;
    private final com.shazam.android.p.i n;
    private final com.shazam.android.j.g.f o;
    private final b p;
    private final com.shazam.h.e.a.b q;
    private final OrbitErrorAnalytics r;
    private final GooglePlayAvailability s;

    public c(i i1, com.shazam.e.a a1, a a2, com.shazam.android.j.o.b b1, e e1, com.shazam.android.persistence.i.a a3, com.shazam.android.j.g.j j1, 
            com.shazam.a.a.b b2, t t1, com.shazam.android.j.g.d d1, com.shazam.android.j.g.a a4, com.shazam.android.u.c c1, com.shazam.android.advert.c c2, com.shazam.android.p.i k1, 
            com.shazam.android.j.g.f f1, b b3, com.shazam.h.e.a.b b4, OrbitErrorAnalytics orbiterroranalytics, GooglePlayAvailability googleplayavailability)
    {
        a = i1;
        b = a1;
        c = a2;
        d = b1;
        e = e1;
        f = a3;
        g = j1;
        h = b2;
        i = t1;
        k = d1;
        j = a4;
        l = c1;
        m = c2;
        n = k1;
        o = f1;
        p = b3;
        q = b4;
        r = orbiterroranalytics;
        s = googleplayavailability;
    }

    private List a(com.shazam.android.ay.b.d d1, int i1, TaggingStatus taggingstatus)
    {
        List list = c();
        list.add(new d("service", c.b()));
        a(list, "tagDate", com.shazam.o.d.a(new Date(d1.a())));
        if (d1.b() != null)
        {
            list.add(new com.shazam.h.e.c(d1, i1, taggingstatus));
        }
        a(list, "tagId", d1.d());
        a(list, "tagTime", String.valueOf(d1.a()));
        a(list, "tagTimezone", TimeZone.getDefault().getID());
        a(list, "coverartSize", e.b());
        a(list, "addoniconSize", e.a());
        taggingstatus = d1.e();
        if (taggingstatus != null)
        {
            a(list, "tagLatitude", String.valueOf(((SimpleLocation) (taggingstatus)).latitude));
            a(list, "tagLongitude", String.valueOf(((SimpleLocation) (taggingstatus)).longitude));
            if (((SimpleLocation) (taggingstatus)).altitude != null)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                a(list, "tagAltitude", String.valueOf(((SimpleLocation) (taggingstatus)).altitude));
            }
        }
        if (d1.f() != null)
        {
            try
            {
                a(list, "context", p.a(d1.f().b()));
            }
            // Misplaced declaration of an exception variable
            catch (com.shazam.android.ay.b.d d1)
            {
                throw new RuntimeException(d1);
            }
        }
        return list;
    }

    private void a(URL url, ErrorBean errorbean)
    {
        r.sendInternalServerError(url.toString(), errorbean.getCode());
    }

    private void a(List list, String s1, String s2)
    {
        if (com.shazam.b.e.a.c(s2))
        {
            list.add(new d(s1, (String)b.a(s2)));
        }
    }

    private void b(List list, String s1, String s2)
    {
        list.add(new d(s1, (String)b.a(s2)));
    }

    private List c()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new d("language", c.a()));
        b(arraylist, "applicationIdentifier", c.c());
        b(arraylist, "deviceId", c.d());
        b(arraylist, "deviceModel", c.e());
        b(arraylist, "cryptToken", c.f());
        b(arraylist, "deviceFingerprint", c.g());
        b(arraylist, "deviceOS", c.h());
        return arraylist;
    }

    public final g a(com.shazam.android.ay.b.d d1, int i1, x x, TaggingStatus taggingstatus)
    {
        Object obj;
        x x1;
        obj = null;
        x1 = a.a();
        Object obj1;
        x = (new com.shazam.h.d.a()).a(x1).a(x).a();
        a.a(x);
        x = d.b();
        taggingstatus = (DoRecognitionResponse)a.a(x, a(d1, i1, taggingstatus), com/shazam/server/legacy/DoRecognitionResponse);
        obj1 = taggingstatus.getErrorBean();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        try
        {
            a(((URL) (x)), ((ErrorBean) (obj1)));
            throw com.shazam.android.l.n.a(((ErrorBean) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (com.shazam.android.ay.b.d d1) { }
        finally
        {
            a.a(x1);
        }
        throw new com.shazam.android.service.a.a(d1);
        throw d1;
        x = h;
        obj1 = taggingstatus.getRecognition();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        throw new com.shazam.android.service.a.a("no Recognition in the response!");
        t t1;
        String s1;
        t1 = ((com.shazam.a.a.b) (x)).a;
        t1.a = d1.a();
        x = new Date(t1.a);
        s1 = com.shazam.o.d.a(x);
        if (((Recognition) (obj1)).getTracks() == null || ((Recognition) (obj1)).getTracks().isEmpty()) goto _L2; else goto _L1
_L1:
        Track track;
        taggingstatus = com.shazam.model.Tag.Builder.a();
        taggingstatus.eventId = ((Recognition) (obj1)).getEventId();
        if (((Recognition) (obj1)).getMatches() != null && !((Recognition) (obj1)).getMatches().isEmpty())
        {
            Match match = (Match)((Recognition) (obj1)).getMatches().get(0);
            taggingstatus.lyricOffset = match.getOffset();
            taggingstatus.lyricSkew = match.getSkew();
            taggingstatus.frequencySkew = match.getFrequency();
        }
        track = (Track)((Recognition) (obj1)).getTracks().get(0);
        taggingstatus.requestId = d1.d();
        taggingstatus.timestamp = t1.a;
        taggingstatus.dateTime = s1;
        taggingstatus.shortDateTime = com.shazam.o.d.b(x);
        x = track.getJson();
        if (x != null) goto _L4; else goto _L3
_L3:
        x = null;
_L8:
        taggingstatus.json = x;
        taggingstatus.track = t1.a(track);
        x = taggingstatus;
          goto _L5
_L9:
        taggingstatus = ((Recognition) (obj1)).getRetryDelay();
        if (taggingstatus == null || x == null) goto _L7; else goto _L6
_L6:
        x.status = com.shazam.model.Tag.Status.SUCCESSFUL;
        d1 = new com.shazam.a.a.a.i(d1, x, taggingstatus.longValue());
_L10:
        a.a(x1);
        return d1;
_L4:
        x = x.getJsonString();
          goto _L8
_L12:
        x = x.b();
          goto _L9
_L7:
        if (taggingstatus != null || x == null)
        {
            break MISSING_BLOCK_LABEL_481;
        }
        x.status = com.shazam.model.Tag.Status.SUCCESSFUL;
        d1 = new com.shazam.a.a.a.e(d1, x);
          goto _L10
        if (taggingstatus == null)
        {
            break MISSING_BLOCK_LABEL_503;
        }
        d1 = new h(d1, taggingstatus.longValue());
          goto _L10
        d1 = new f(d1);
          goto _L10
_L2:
        x = null;
_L5:
        if (x != null) goto _L12; else goto _L11
_L11:
        x = obj;
          goto _L9
    }

    public final com.shazam.model.Track a(URL url)
    {
        Object obj;
        ErrorBean errorbean;
        obj = (RequestSmoidResponse)a.a(url, com/shazam/server/legacy/RequestSmoidResponse);
        errorbean = ((RequestSmoidResponse) (obj)).getErrorBean();
        if (errorbean != null)
        {
            try
            {
                a(url, errorbean);
                throw com.shazam.android.l.n.a(errorbean);
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                obj = url.a();
            }
            int i1 = ((o) (obj)).a;
            if (i1 == 302 || i1 == 307)
            {
                throw new com.shazam.f.h.a(i1, ((o) (obj)).a("Location"));
            } else
            {
                throw new com.shazam.android.service.a.a(url);
            }
        }
        url = ((RequestSmoidResponse) (obj)).getRequestSmoid();
        if (url == null) goto _L2; else goto _L1
_L1:
        url = url.getTrack();
_L4:
        if (url != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        throw new com.shazam.android.service.a.a("no track in smoid response");
        url = i.a(url);
        return url;
_L2:
        url = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final OrbitConfig a(boolean flag, String s1)
    {
        String s2;
        URL url;
        com.shazam.h.l.a a1;
        List list;
        url = d.a();
        a1 = new com.shazam.h.l.a();
        a1.e = k.b;
        a1.a = url;
        list = c();
        list.add(new d("service", e.a.getString(0x7f090214)));
        s2 = o.a.b();
        Object obj;
        obj = s2;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = s2;
        if (s2.length() < 6)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = s2;
        if (!"unknown".equals(s2))
        {
            obj = s2.substring(0, 6);
        }
        a(list, "imsi", ((String) (obj)));
        a(list, "architecture", j.a());
        a(list, "imei", k.a());
        a(list, "androidId", k.c());
        a(list, "androidAdvertId", m.a());
        obj = m.b();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L8:
        a(list, "dc_lat", ((String) (obj)));
        a(list, "addoniconSize", e.a());
        obj = "phone";
        if (!n.b) goto _L4; else goto _L3
_L3:
        obj = "tablet_large";
_L6:
        a(list, "deviceType", ((String) (obj)));
        a(list, "fbappuserid", l.a());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        a(list, "trigger", "update");
        obj = Boolean.valueOf(s.a());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_363;
        }
        list.add(new d("playservicesavailable", (String)b.a(String.valueOf(obj))));
        obj = new com.shazam.h.a.a();
        obj.b = list;
        obj.a = q;
        obj = a1.b(((com.shazam.h.a.a) (obj)).a());
        obj.f = "multipart/form-data;boundary=A3r_ISAAC_eQeY2Bh";
        if (com.shazam.b.e.a.c(s1))
        {
            ((com.shazam.h.l.a) (obj)).a(com.shazam.o.k.a("X-Shazam-AMPKey", s1));
        }
        s1 = (RequestConfigResponse)a.a(((com.shazam.h.l.a) (obj)).a(), com/shazam/server/legacy/RequestConfigResponse);
        obj = s1.getErrorBean();
        if (obj != null)
        {
            try
            {
                a(url, ((ErrorBean) (obj)));
                throw com.shazam.android.l.n.a(((ErrorBean) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            throw new com.shazam.android.service.a.a(s1);
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (((Boolean) (obj)).booleanValue())
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (n.a)
        {
            obj = "tablet_small";
        }
        if (true) goto _L6; else goto _L5
_L5:
        s1 = s1.getOrbitConfig();
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        throw new com.shazam.android.service.a.a("No requestConfig2 in the response");
        return s1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a()
    {
        ErrorBean errorbean = ((ErrorResponse)a.a(b(), com/shazam/server/legacy/ErrorResponse)).getErrorBean();
        if (errorbean == null) goto _L2; else goto _L1
_L1:
        a(d.c(), errorbean);
        throw com.shazam.android.l.n.a(errorbean);
        Object obj;
        obj;
_L4:
        throw new com.shazam.android.service.a.a(((Throwable) (obj)));
_L2:
        f.a(true);
        return;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final l b()
    {
        com.shazam.h.l.a a1 = new com.shazam.h.l.a();
        a1.e = k.b;
        a1.a = d.c();
        com.shazam.h.a.a a2 = new com.shazam.h.a.a();
        a2.a = q;
        List list = c();
        list.add(new d("service", g.b.a().b().getStringConfigEntry("service")));
        a(list, "emailAddress", g.a.h("pk_re"));
        a(list, "devicePushToken", f.a());
        a2.b = list;
        a1 = a1.b(a2.a());
        a1.f = "multipart/form-data;boundary=A3r_ISAAC_eQeY2Bh";
        return a1.a();
    }
}
