// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class cce
{

    private static final Map a;
    private static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
        "edit", "http://gdata.youtube.com/schemas/2007#video.captionTracks", "http://gdata.youtube.com/schemas/2007#live.event"
    })));

    static Map a()
    {
        return a;
    }

    public static void a(bnr bnr1, String s)
    {
        b.a(bnr1);
        s = String.valueOf(s).concat("/entry");
        d(bnr1, s);
        bnr1.a(s, new ccf());
    }

    static Set b()
    {
        return b;
    }

    public static void b(bnr bnr1, String s)
    {
        b.a(bnr1);
        s = String.valueOf(s).concat("/entry");
        d(bnr1, s);
        bnr1.a(s, new ccq());
    }

    public static void c(bnr bnr1, String s)
    {
        b.a(bnr1);
        s = String.valueOf(s).concat("/entry");
        d(bnr1, s);
        bnr1.a(s, new cdb());
        bnr1.a(String.valueOf(s).concat("/batch:status"), new cdc());
    }

    public static void d(bnr bnr1, String s)
    {
        bnr1.a(String.valueOf(s).concat("/media:group/media:content"), new cda()).a(String.valueOf(s).concat("/media:group/media:thumbnail"), new ccz()).a(String.valueOf(s).concat("/media:group/media:player"), new ccy()).a(String.valueOf(s).concat("/media:group/yt:duration"), new ccx()).a(String.valueOf(s).concat("/media:group/media:rating"), new ccw()).a(String.valueOf(s).concat("/media:group/yt:videoid"), new ccv()).a(String.valueOf(s).concat("/media:group/media:credit"), new ccu()).a(String.valueOf(s).concat("/author/uri"), new cct()).a(String.valueOf(s).concat("/media:group/media:description"), new ccs()).a(String.valueOf(s).concat("/media:group/media:keywords"), new ccr()).a(String.valueOf(s).concat("/yt:statistics"), new ccp()).a(String.valueOf(s).concat("/link"), new cco()).a(String.valueOf(s).concat("/category"), new ccn()).a(String.valueOf(s).concat("/yt:rating"), new ccm()).a(String.valueOf(s).concat("/yt:accessControl"), new ccl()).a(String.valueOf(s).concat("/media:group/yt:private"), new cck()).a(String.valueOf(s).concat("/yt:location"), new ccj()).a(String.valueOf(s).concat("/georss:where/gml:Point/gml:pos"), new cci()).a(String.valueOf(s).concat("/app:control/yt:state"), new cch()).a(String.valueOf(s).concat("/published"), new ccg()).a(String.valueOf(s).concat("/media:group/yt:uploaded"), new cdg()).a(String.valueOf(s).concat("/title"), new cdf()).a(String.valueOf(s).concat("/yt:threed"), new cde()).a(String.valueOf(s).concat("/yt:paidContent"), new cdd());
    }

    static 
    {
        HashMap hashmap = new HashMap(20);
        hashmap.put(null, ceh.a);
        hashmap.put("processing", ceh.b);
        hashmap.put("deleted", ceh.c);
        hashmap.put("requesterRegion", ceh.d);
        hashmap.put("limitedSyndication", ceh.e);
        hashmap.put("private", ceh.f);
        hashmap.put("copyright", ceh.h);
        hashmap.put("inappropriate", ceh.i);
        hashmap.put("duplicate", ceh.j);
        hashmap.put("termsOfUse", ceh.k);
        hashmap.put("suspended", ceh.l);
        hashmap.put("tooLong", ceh.m);
        hashmap.put("blocked", ceh.n);
        hashmap.put("clientRestrict", ceh.g);
        hashmap.put("cantProcess", ceh.o);
        hashmap.put("invalidFormat", ceh.p);
        hashmap.put("unsupportedCodec", ceh.q);
        hashmap.put("empty", ceh.r);
        hashmap.put("tooSmall", ceh.s);
        a = Collections.unmodifiableMap(hashmap);
    }
}
