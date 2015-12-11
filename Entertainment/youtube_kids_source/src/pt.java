// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.HttpResponseException;

public final class pt
{

    private static final Set a = a.b(new String[] {
        "YT:ADSENSE", "ADSENSE", "ADSENSE/ADX"
    });
    private static final Set b = a.b(new String[] {
        "YT:DOUBLECLICK", "GDFP", "DART", "DART_DFA", "DART_DFP"
    });
    private static final Set c = a.b(new String[] {
        "YT:FREEWHEEL", "FREEWHEEL"
    });
    private final crb d;
    private final crb e;
    private final bmi f;
    private final cub g;
    private final bgm h;
    private final bdc i;
    private final bje j;
    private final bfo k;

    public pt(bmi bmi1, bje bje1, bdc bdc1, cub cub1, bgm bgm1, oy oy1, bns bns, 
            bfo bfo1)
    {
        f = (bmi)b.a(bmi1);
        j = (bje)b.a(bje1);
        i = (bdc)b.a(bdc1);
        g = (cub)b.a(cub1);
        h = (bgm)b.a(bgm1);
        d = oy1.a(new bdh(bdc1.a), new bdw(bns, bmi1, new bdp(bns)), false);
        e = oy1.a(new bdh(bdc1.a), new bdw(bns, bmi1, new bdp(bns)), true);
        k = (bfo)b.a(bfo1);
    }

    private buz a(Uri uri, buz buz1, bnb bnb1, int l)
    {
        j.d(new csi(l, buz1.h() + 1));
        if (buz1.O != null)
        {
            if (buz1.O.e())
            {
                return null;
            } else
            {
                uri = buz1.O.a();
                buz1 = buz1.a();
                buz1.ad = null;
                uri.ae = buz1.a();
                return uri.a();
            }
        }
        bhw bhw1 = bhw.a();
        long l1 = f.a();
        long l2 = bnb1.a();
        if (l2 <= 0L)
        {
            throw new TimeoutException();
        }
        bnb1 = k.a();
        if (bnb1 != null && bnb1.matcher(uri.toString()).find())
        {
            bnb1 = e;
        } else
        {
            bnb1 = d;
        }
        bnb1.a(uri, bhw1);
        try
        {
            bnb1 = (List)bhw1.get(l2, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (bnb bnb1)
        {
            Throwable throwable = bnb1.getCause();
            if ((throwable instanceof HttpResponseException) || (throwable instanceof IllegalStateException))
            {
                bnb1 = crx.k;
            } else
            {
                bnb1 = crx.i;
            }
            if (throwable instanceof bnp)
            {
                throw new bff(String.format("BadXML u:%s", new Object[] {
                    uri.toString()
                }), throwable, buz1, bnb1);
            } else
            {
                throw new bff(String.format("BadReq u:%s", new Object[] {
                    uri.toString()
                }), throwable, buz1, bnb1);
            }
        }
        if (bnb1 == null || bnb1.isEmpty())
        {
            return null;
        } else
        {
            uri = ((buz)bnb1.get(0)).a();
            uri.Z = l1;
            uri.ae = buz1;
            return uri.a();
        }
    }

    private buz a(buz buz1, long l, bnb bnb1, int i1, int j1)
    {
        buz buz2 = buz1;
_L8:
        if (!buz2.N) goto _L2; else goto _L1
_L1:
        int k1;
        k1 = j1;
        if (j1 == 2)
        {
            k1 = j1;
            if (!"ADSENSE/ADX".equals(buz2.h))
            {
                k1 = j1 - 1;
            }
        }
        if (k1 <= 0)
        {
            throw new bff(null, buz2, crx.l);
        }
        buz1 = a(buz2.M, buz2, bnb1, i1);
_L6:
        if (buz1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        return buz1;
_L2:
        buz1 = buz2;
        if (buz2.G == null) goto _L4; else goto _L3
_L3:
        Object obj = a(buz2.G, buz2, bnb1, i1);
        buz1 = ((buz) (obj));
        k1 = j1;
        if (obj != null)
        {
            buz1 = ((buz) (obj));
            k1 = j1;
            if (((buz) (obj)).P != null)
            {
                buz1 = ((buz) (obj));
                k1 = j1;
                if (((buz) (obj)).P.G != null)
                {
                    buz1 = ((buz) (obj)).P;
                    obj = ((buz) (obj)).a();
                    if (!buz1.G.toString().contains("dfaexp=1"))
                    {
                        obj.w = buz1.p;
                        obj.s = buz1.l;
                        obj.t = buz1.m;
                        obj.u = buz1.n;
                        obj.j = buz1.c;
                        obj.l = buz1.b();
                        obj.r = buz1.k;
                        obj.V = buz1.K;
                    }
                    buz1 = ((bvd) (obj)).a();
                    k1 = j1;
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        bvd bvd1 = buz1.a();
        bvd1.p = a(buz1);
        if (buz1.J == 0L)
        {
            long l1;
            if (buz2 != null && buz2.J > 0L)
            {
                l1 = buz2.J;
            } else
            {
                l1 = l;
            }
            bvd1.S = l1;
        }
        buz2 = bvd1.a();
        j1 = k1 - 1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private buz a(buz buz1, List list, bfz bfz1)
    {
        Object obj;
        if (buz1.P != null)
        {
            buz buz2 = buz1.P;
            obj = buz1;
            buz buz3;
            for (; buz2.P != null; buz2 = buz3)
            {
                buz3 = buz2.P;
                obj = buz2;
            }

        } else
        {
            obj = buz1;
        }
        obj = a(((buz) (obj)));
        bvd bvd1 = buz1.a();
        bvd1.c = bfz1.c;
        bvd1.h = bfz1.b;
        bvd1.p = ((bvc) (obj));
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(((bvc) (obj)).e);
        stringbuilder.append("_2");
        if (buz1.f())
        {
            stringbuilder.append("_1");
        }
        bvd1.q = stringbuilder.toString();
        bvd1.g = bfz1.d;
        bvd1.b = new ArrayList(buz1.b);
        for (buz1 = list.iterator(); buz1.hasNext();)
        {
            list = ((buz)buz1.next()).b.iterator();
            while (list.hasNext()) 
            {
                bvd1.a((Uri)list.next());
            }
        }

        return bvd1.a();
    }

    private buz a(buz buz1, byte abyte0[], bnb bnb1, Map map)
    {
        ctx ctx1;
        b.b();
        ctx1 = g.a(buz1);
        if (map.containsKey(buz1.c))
        {
            abyte0 = (bxb)map.get(buz1.c);
            break MISSING_BLOCK_LABEL_44;
        }
        long l = bnb1.a();
        if (l > 0L)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        throw new TimeoutException();
_L1:
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        try
        {
            throw new pu(buz1, "null playerResponse");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            bmo.a("Error retrieving streams for ad video", abyte0);
            throw new pu(buz1, abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            bmo.a("Error retrieving streams for ad video", abyte0);
        }
        throw new pu(buz1, abyte0);
        abyte0 = (bxb)ctx1.a(buz1.c, abyte0, "", "", -1, -1).get(l, TimeUnit.MILLISECONDS);
          goto _L1
        if (!abyte0.f().a())
        {
            throw new pu(buz1, String.format("unplayable. status: %d", new Object[] {
                Integer.valueOf(abyte0.f().b)
            }));
        }
        map = buz1.a();
        map.s = ((bxb) (abyte0)).d;
        map.t = abyte0.g();
        map.u = abyte0.h();
        map.v = abyte0.l();
        map.k = abyte0.c();
        map.r = abyte0.e();
        if (((bxb) (abyte0)).a.h.length <= 0)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        bnb1 = ((bxb) (abyte0)).a.h[0].b;
_L2:
        map.X = bnb1;
        map.Y = abyte0.i();
        map.f = ((bxb) (abyte0)).a.o;
        abyte0 = map.a();
        return abyte0;
        bnb1 = null;
          goto _L2
    }

    private bvc a(buz buz1)
    {
        Uri uri;
        if (buz1.P == null)
        {
            uri = null;
        } else
        {
            uri = buz1.P.M;
        }
        if (a(uri, buz1.h))
        {
            return bvc.a;
        }
        String s = buz1.h;
        boolean flag;
        if (s != null && b.contains(s.toUpperCase(Locale.US)))
        {
            flag = true;
        } else
        if (uri != null && uri.getAuthority() != null && uri.getAuthority().endsWith(".doubleclick.net") && !a(uri, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return bvc.b;
        }
        buz1 = buz1.h;
        if (buz1 != null && c.contains(buz1.toUpperCase(Locale.US)))
        {
            flag = true;
        } else
        if (uri != null && uri.getAuthority() != null && uri.getAuthority().endsWith(".fwmrm.net"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return bvc.c;
        } else
        {
            return bvc.d;
        }
    }

    private static String a(Uri uri)
    {
        Object obj1;
        if (!"https".equals(uri.getScheme()))
        {
            break MISSING_BLOCK_LABEL_670;
        }
        obj1 = uri.buildUpon().scheme("http").build();
_L6:
        if (!"vnd.youtube".equals(((Uri) (obj1)).getScheme())) goto _L2; else goto _L1
_L1:
        Object obj2 = ((Uri) (obj1)).getSchemeSpecificPart();
        Object obj;
        obj = obj2;
        try
        {
            if (((String) (obj2)).startsWith("//"))
            {
                obj = ((String) (obj2)).substring(2);
            }
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                obj = String.valueOf(obj1);
                throw new ParseException((new StringBuilder(String.valueOf(obj).length() + 24)).append("No video id in the Uri: ").append(((String) (obj))).toString(), 0);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            uri = String.valueOf(uri);
            bmo.c((new StringBuilder(String.valueOf(uri).length() + 38)).append("Unable to parse watch uri from VastAd ").append(uri).toString());
            return null;
        }
        int l = ((String) (obj)).indexOf('?');
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        obj = ((String) (obj)).substring(0, l);
        obj1 = crk.a(((Uri) (obj1)));
        obj = new crk(((String) (obj)), ((Map) (obj1)), crk.a((String)((Map) (obj1)).get("t")));
_L5:
        if (((crk) (obj)).a.size() > 0) goto _L4; else goto _L3
_L3:
        obj = String.valueOf(uri);
        bmo.c((new StringBuilder(String.valueOf(obj).length() + 49)).append("Unable to find video id in watch uri from VastAd ").append(((String) (obj))).toString());
        return null;
_L2:
label0:
        {
            if (!"youtu.be".equalsIgnoreCase(((Uri) (obj1)).getHost()))
            {
                break label0;
            }
            obj = ((Uri) (obj1)).getPathSegments();
            if (((List) (obj)).isEmpty() || TextUtils.isEmpty((CharSequence)((List) (obj)).get(0)))
            {
                obj = String.valueOf(obj1);
                throw new ParseException((new StringBuilder(String.valueOf(obj).length() + 29)).append("No video id in the Uri path: ").append(((String) (obj))).toString(), 0);
            }
            obj2 = crk.a(((Uri) (obj1)));
            obj = new crk(((List) (obj)).subList(0, 1), crk.a(((Map) (obj2))), crk.a(((Uri) (obj1)), ((Map) (obj2))));
        }
          goto _L5
label1:
        {
            obj = ((Uri) (obj1)).getPath();
            obj2 = ((Uri) (obj1)).getFragment();
            if (!((String) (obj)).startsWith("/watch") && !((String) (obj)).startsWith("/movie"))
            {
                break label1;
            }
            obj = crk.b(((Uri) (obj1)));
        }
          goto _L5
label2:
        {
            if (!((String) (obj)).startsWith("/get_video"))
            {
                break MISSING_BLOCK_LABEL_516;
            }
            obj = crk.a(((Uri) (obj1)));
            obj2 = (String)((Map) (obj)).get("video_id");
            if (TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                break label2;
            }
            obj = new crk(((String) (obj2)), crk.a(((Map) (obj))), crk.a(((Uri) (obj1)), ((Map) (obj))));
        }
          goto _L5
        obj = String.valueOf(obj1);
        throw new ParseException((new StringBuilder(String.valueOf(obj).length() + 24)).append("No id found in the uri: ").append(((String) (obj))).toString(), 0);
        if (!((String) (obj)).startsWith("/v/"))
        {
            break MISSING_BLOCK_LABEL_534;
        }
        obj = crk.c(((Uri) (obj1)));
          goto _L5
label3:
        {
            if (!((String) (obj)).startsWith("/e/") && !((String) (obj)).startsWith("/embed/"))
            {
                break label3;
            }
            obj = new crk(((Uri) (obj1)).getLastPathSegment(), crk.a(((Uri) (obj1))), crk.a(((Uri) (obj1)).getQueryParameter("start")));
        }
          goto _L5
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_642;
        }
        if (!((String) (obj2)).startsWith("/watch") && !((String) (obj2)).startsWith("watch"))
        {
            break MISSING_BLOCK_LABEL_642;
        }
        obj = ((Uri) (obj1)).getFragment();
        obj = crk.b(Uri.parse(((Uri) (obj1)).buildUpon().encodedPath(((String) (obj))).fragment("").build().toString()));
          goto _L5
        throw new ParseException("Unrecognised URI", 0);
_L4:
        obj = (String)((crk) (obj)).a.get(0);
        return ((String) (obj));
        obj1 = uri;
          goto _L6
    }

    private void a(crx crx1, String s, bfz bfz1, buz buz1, String s1)
    {
        bgm bgm1 = h;
        if (buz1 == null)
        {
            buz1 = buz.a.a();
            buz1.S = 0x7fffffffffffffffL;
            buz1 = buz1.a();
        }
        bgm1.a(bfz1, buz1, s1).b(new crw(crx1, s));
    }

    private boolean a(Uri uri, String s)
    {
        while (s != null && a.contains(s.toUpperCase(Locale.US)) || uri != null && i.a.a(uri)) 
        {
            return true;
        }
        return false;
    }

    public final buz a(bfz bfz1, String s, long l, bnb bnb1, Map map)
    {
        Object obj;
        ArrayList arraylist;
        Iterator iterator;
        int i1;
        long l1;
        b.a(bfz1);
        b.b();
        arraylist = new ArrayList();
        l1 = f.a();
        i1 = 1;
        iterator = bfz1.e.iterator();
        obj = null;
_L3:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj1;
        int j1;
        obj1 = (buz)iterator.next();
        j1 = i1 + 1;
        obj1 = a(((buz) (obj1)), l1 + l, bnb1, i1, 3);
label0:
        {
            obj = obj1;
            if (obj != null)
            {
                break label0;
            }
            i1 = j1;
        }
          goto _L3
        Object obj2;
        obj2 = obj;
        obj1 = obj;
        if (!((buz) (obj)).d()) goto _L5; else goto _L4
_L4:
        obj2 = obj;
        obj1 = obj;
        arraylist.add(obj);
        Object obj3;
        obj3 = obj;
        obj2 = obj;
        obj1 = obj;
        if (bvc.b != ((buz) (obj)).i) goto _L7; else goto _L6
_L6:
        obj2 = obj;
        obj1 = obj;
        boolean flag = ((buz) (obj)).I;
        obj3 = obj;
        if (flag) goto _L7; else goto _L2
_L2:
        if (!arraylist.isEmpty()) goto _L9; else goto _L8
_L8:
        obj3 = null;
_L11:
        return ((buz) (obj3));
_L5:
        obj2 = obj;
        obj1 = obj;
        if (((buz) (obj)).V != bup.a)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        obj2 = obj;
        obj1 = obj;
        a(crx.h, "Invalid survey XML", bfz1, ((buz) (obj)), s);
        i1 = j1;
          goto _L3
        obj2 = obj;
        obj1 = obj;
        obj = a(((buz) (obj)), ((List) (arraylist)), bfz1);
        obj2 = obj;
        obj1 = obj;
        byte abyte0[] = bfz1.d;
        obj3 = obj;
        obj2 = obj;
        obj1 = obj;
        if (!buz.a(((buz) (obj)).g())) goto _L11; else goto _L10
_L10:
        obj2 = obj;
        obj1 = obj;
        j.d(new csj());
        obj2 = obj;
        obj1 = obj;
        obj3 = a(((buz) (obj)).g());
        obj2 = obj;
        obj1 = obj;
        if (!TextUtils.isEmpty(((CharSequence) (obj3)))) goto _L13; else goto _L12
_L12:
        obj2 = obj;
        obj1 = obj;
        throw new pu(((buz) (obj)), "no video-id in url");
        obj3;
        obj2 = obj;
        obj1 = obj;
        a(crx.j, cxd.a(obj3, true), bfz1, ((buz) (obj)), s);
        obj2 = obj;
        obj1 = obj;
        bmo.a("Error retrieving ad video info", ((Throwable) (obj3)));
        obj3 = obj;
_L7:
        obj = obj3;
        i1 = j1;
          goto _L3
_L13:
        obj2 = obj;
        obj1 = obj;
        bvd bvd1 = ((buz) (obj)).a();
        obj2 = obj;
        obj1 = obj;
        bvd1.j = ((String) (obj3));
        obj2 = obj;
        obj1 = obj;
        obj3 = a(bvd1.a(), abyte0, bnb1, map);
        return ((buz) (obj3));
        obj1;
        obj = obj2;
_L15:
        crx crx1;
        if (((bff) (obj1)).b != null)
        {
            crx1 = ((bff) (obj1)).b;
        } else
        {
            crx1 = crx.i;
        }
        a(crx1, cxd.a(obj1, true), bfz1, ((bff) (obj1)).a, s);
        bmo.a("Error resolving VAST Wrapper", ((Throwable) (obj1)));
        i1 = j1;
          goto _L3
        bnb1;
_L14:
        a(crx.k, cxd.a(bnb1, true), bfz1, ((buz) (obj1)), s);
        bmo.a("Timeout error while retrieving ad video info", bnb1);
          goto _L2
_L9:
        return a((buz)arraylist.remove(arraylist.size() - 1), ((List) (arraylist)), bfz1);
        bnb1;
        obj1 = obj;
          goto _L14
        obj1;
          goto _L15
    }

}
