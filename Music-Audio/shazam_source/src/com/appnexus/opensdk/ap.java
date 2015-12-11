// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.b.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.appnexus.opensdk:
//            z, at, j

public final class ap
{

    static HashSet s = null;
    z a;
    String b;
    boolean c;
    int d;
    int e;
    int f;
    int g;
    boolean h;
    float i;
    String j;
    k.c k;
    public ArrayList l;
    Context m;
    public int n;
    public int o;
    boolean p;
    ArrayList q;
    String r;

    ap(Context context)
    {
        c = false;
        d = -1;
        e = -1;
        f = -1;
        g = -1;
        h = false;
        i = 0.0F;
        k = k.c.a;
        l = new ArrayList();
        n = -1;
        o = -1;
        p = false;
        m = context;
    }

    final int a()
    {
        if (a == z.a)
        {
            return d;
        } else
        {
            return -1;
        }
    }

    final int b()
    {
        if (a == z.a)
        {
            return e;
        } else
        {
            return -1;
        }
    }

    final boolean c()
    {
        return a == z.a && p;
    }

    final int d()
    {
        if (a == z.a)
        {
            return n;
        } else
        {
            return f;
        }
    }

    final int e()
    {
        if (a == z.a)
        {
            return o;
        } else
        {
            return g;
        }
    }

    final ArrayList f()
    {
        if (a == com.appnexus.opensdk.z.b)
        {
            return q;
        } else
        {
            return null;
        }
    }

    final at g()
    {
        return new at(j, k, l, com.appnexus.opensdk.b.j.a().r);
    }

    final String h()
    {
        Object obj;
        Object obj2;
        Object obj4;
        Object obj6;
        StringBuilder stringbuilder;
        j j1;
        int i1;
        int k1;
        j1 = com.appnexus.opensdk.b.j.a();
        stringbuilder = new StringBuilder(j.z);
        stringbuilder.append("id=");
        if (b != null)
        {
            stringbuilder.append(Uri.encode(b));
        } else
        {
            stringbuilder.append("NO-PLACEMENT-ID");
        }
        if (!com.appnexus.opensdk.b.k.a(j1.a))
        {
            stringbuilder.append("&md5udid=").append(Uri.encode(j1.a));
        }
        if (!com.appnexus.opensdk.b.k.a(j1.b))
        {
            stringbuilder.append("&sha1udid=").append(Uri.encode(j1.b));
        }
        if (!com.appnexus.opensdk.b.k.a(j1.d))
        {
            stringbuilder.append("&aaid=").append(Uri.encode(j1.d));
            double d1;
            String s2;
            int l1;
            int i2;
            if (j1.e)
            {
                obj = "&LimitAdTrackingEnabled=1";
            } else
            {
                obj = "&LimitAdTrackingEnabled=0";
            }
            stringbuilder.append(((String) (obj)));
        }
        if (!com.appnexus.opensdk.b.k.a(j1.f))
        {
            stringbuilder.append("&devmake=").append(Uri.encode(j1.f));
        }
        if (!com.appnexus.opensdk.b.k.a(j1.g))
        {
            stringbuilder.append("&devmodel=").append(Uri.encode(j1.g));
        }
        if (j1.c == null)
        {
            obj = (TelephonyManager)m.getSystemService("phone");
            try
            {
                j1.c = ((TelephonyManager) (obj)).getNetworkOperatorName();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                j1.c = "";
            }
        }
        if (!com.appnexus.opensdk.b.k.a(j1.c))
        {
            stringbuilder.append("&carrier=").append(Uri.encode(j1.c));
        }
        stringbuilder.append("&appid=");
        if (!com.appnexus.opensdk.b.k.a(j1.h))
        {
            stringbuilder.append(Uri.encode(j1.h));
        } else
        {
            stringbuilder.append("NO-APP-ID");
        }
        if (j1.k)
        {
            stringbuilder.append("&firstlaunch=true");
        }
        obj4 = com.appnexus.opensdk.b.j.a().r;
        if (!com.appnexus.opensdk.b.j.a().q) goto _L2; else goto _L1
_L1:
        if (obj4 != null)
        {
            obj = obj4;
        } else
        {
label0:
            {
                if (m.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && m.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
                {
                    break label0;
                }
                obj6 = (LocationManager)m.getSystemService("location");
                Iterator iterator = ((LocationManager) (obj6)).getProviders(true).iterator();
                obj = null;
                while (iterator.hasNext()) 
                {
                    obj2 = ((LocationManager) (obj6)).getLastKnownLocation((String)iterator.next());
                    if (obj2 != null)
                    {
                        if (obj == null)
                        {
                            obj = obj2;
                        } else
                        if (((Location) (obj2)).getTime() > 0L && ((Location) (obj)).getTime() > 0L && ((Location) (obj2)).getTime() > ((Location) (obj)).getTime())
                        {
                            obj = obj2;
                        }
                    }
                }
            }
        }
_L7:
        if (obj4 != obj)
        {
            if (com.appnexus.opensdk.b.j.a().q)
            {
                if (com.appnexus.opensdk.b.j.a().s != -1 && obj != null)
                {
                    d1 = Math.pow(10D, com.appnexus.opensdk.b.j.a().s);
                    ((Location) (obj)).setLatitude((double)Math.round(((Location) (obj)).getLatitude() * d1) / d1);
                    ((Location) (obj)).setLongitude((double)Math.round(((Location) (obj)).getLongitude() * d1) / d1);
                }
                com.appnexus.opensdk.b.j.a().r = ((Location) (obj));
            } else
            {
                com.appnexus.opensdk.b.j.a().r = null;
            }
        }
        if (obj != null)
        {
            if (com.appnexus.opensdk.b.j.a().s < 0)
            {
                obj2 = (new StringBuilder()).append(((Location) (obj)).getLatitude()).toString();
                obj4 = (new StringBuilder()).append(((Location) (obj)).getLongitude()).toString();
            } else
            {
                obj2 = String.format(Locale.ENGLISH, (new StringBuilder("%.")).append(com.appnexus.opensdk.b.j.a().s).append("f").toString(), new Object[] {
                    Double.valueOf(((Location) (obj)).getLatitude())
                });
                obj4 = String.format(Locale.ENGLISH, (new StringBuilder("%.")).append(com.appnexus.opensdk.b.j.a().s).append("f").toString(), new Object[] {
                    Double.valueOf(((Location) (obj)).getLongitude())
                });
            }
            obj6 = (new StringBuilder()).append(((Location) (obj)).getAccuracy()).toString();
            s2 = (new StringBuilder()).append(Math.max(0L, System.currentTimeMillis() - ((Location) (obj)).getTime())).toString();
            obj = obj6;
            obj6 = obj2;
            obj2 = s2;
        } else
        {
            obj6 = "";
            obj4 = "";
            obj2 = "";
            obj = "";
        }
        if (!com.appnexus.opensdk.b.k.a(((String) (obj6))) && !com.appnexus.opensdk.b.k.a(((String) (obj4))))
        {
            stringbuilder.append("&loc=").append(((String) (obj6))).append(",").append(((String) (obj4)));
        }
        if (!com.appnexus.opensdk.b.k.a(((String) (obj2))))
        {
            stringbuilder.append("&loc_age=").append(((String) (obj2)));
        }
        if (!com.appnexus.opensdk.b.k.a(((String) (obj))))
        {
            stringbuilder.append("&loc_prec=").append(((String) (obj)));
        }
        if (j1.i)
        {
            stringbuilder.append("&istest=true");
        }
        if (!com.appnexus.opensdk.b.k.a(j1.j))
        {
            stringbuilder.append("&ua=").append(Uri.encode(j1.j));
        }
        if (m.getResources().getConfiguration().orientation == 2)
        {
            obj = "h";
        } else
        {
            obj = "v";
        }
        r = ((String) (obj));
        if (!com.appnexus.opensdk.b.k.a(r))
        {
            stringbuilder.append("&orientation=").append(r);
        }
        if (d > 0 && e > 0)
        {
            stringbuilder.append("&size=").append(d).append("x").append(e);
        }
        if (p)
        {
label1:
            {
                l1 = e();
                i2 = d();
                if (i2 > 0)
                {
                    i1 = l1;
                    k1 = i2;
                    if (l1 > 0)
                    {
                        break label1;
                    }
                }
                com.appnexus.opensdk.b.b.d(b.e, com.appnexus.opensdk.b.b.a(an.d.max_size_not_set));
                k1 = i2;
                i1 = l1;
            }
        } else
        {
            i1 = g;
            k1 = f;
        }
_L27:
        if (i1 > 0 && k1 > 0)
        {
            if (!a.equals(com.appnexus.opensdk.z.b) && (d < 0 || e < 0))
            {
                stringbuilder.append("&max_size=").append(k1).append("x").append(i1);
            } else
            if (a.equals(com.appnexus.opensdk.z.b))
            {
                stringbuilder.append("&size=").append(k1).append("x").append(i1);
            }
        }
        if (!a.equals(com.appnexus.opensdk.z.b)) goto _L4; else goto _L3
_L3:
        obj2 = f();
        obj4 = ((ArrayList) (obj2)).iterator();
        obj = "";
        do
        {
            if (!((Iterator) (obj4)).hasNext())
            {
                break;
            }
            obj6 = (com.appnexus.opensdk.j)((Iterator) (obj4)).next();
            obj = (new StringBuilder()).append(((String) (obj))).append(((com.appnexus.opensdk.j) (obj6)).a).append("x").append(((com.appnexus.opensdk.j) (obj6)).b).toString();
            if (((ArrayList) (obj2)).indexOf(obj6) != ((ArrayList) (obj2)).size() - 1)
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(",").toString();
            }
        } while (true);
        if (false) goto _L6; else goto _L5
_L6:
        com.appnexus.opensdk.b.b.d(b.e, com.appnexus.opensdk.b.b.a(an.d.permissions_missing_location));
_L2:
        obj = null;
          goto _L7
_L5:
        if (!com.appnexus.opensdk.b.k.a(((String) (obj))))
        {
            stringbuilder.append("&promo_sizes=").append(((String) (obj)));
        }
_L4:
        if (!com.appnexus.opensdk.b.k.a(j1.m))
        {
            stringbuilder.append("&mcc=").append(Uri.encode(j1.m));
        }
        if (!com.appnexus.opensdk.b.k.a(j1.n))
        {
            stringbuilder.append("&mnc=").append(Uri.encode(j1.n));
        }
        if (!com.appnexus.opensdk.b.k.a(j1.p))
        {
            stringbuilder.append("&language=").append(Uri.encode(j1.p));
        }
        Object obj1 = (new StringBuilder()).append(com.appnexus.opensdk.b.j.a().o).toString();
        if (!com.appnexus.opensdk.b.k.a(((String) (obj1))))
        {
            stringbuilder.append("&devtz=").append(Uri.encode(((String) (obj1))));
        }
        obj1 = (new StringBuilder()).append(System.currentTimeMillis()).toString();
        if (!com.appnexus.opensdk.b.k.a(((String) (obj1))))
        {
            stringbuilder.append("&devtime=").append(Uri.encode(((String) (obj1))));
        }
        obj1 = ((ConnectivityManager)m.getSystemService("connectivity")).getNetworkInfo(1);
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.appnexus.opensdk.k.c.values().length];
                try
                {
                    a[k.c.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.appnexus.opensdk.k.c.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[k.c.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        Object obj3;
        Exception exception;
        Object obj5;
        String s1;
        HashSet hashset;
        boolean flag;
        if (obj1 != null)
        {
            if (((NetworkInfo) (obj1)).isConnected())
            {
                obj1 = "wifi";
            } else
            {
                obj1 = "wan";
            }
        } else
        {
            obj1 = null;
        }
        if (!com.appnexus.opensdk.b.k.a(((String) (obj1))))
        {
            stringbuilder.append("&connection_type=").append(Uri.encode(((String) (obj1))));
        }
        if (c)
        {
            obj1 = "1";
        } else
        {
            obj1 = "0";
        }
        if (!com.appnexus.opensdk.b.k.a(((String) (obj1))))
        {
            stringbuilder.append("&native_browser=").append(((String) (obj1)));
        }
        if (i <= 0.0F) goto _L9; else goto _L8
_L8:
        stringbuilder.append("&reserve=").append(i);
_L21:
        obj1 = "0";
_L22:
        if (!com.appnexus.opensdk.b.k.a(((String) (obj1))))
        {
            stringbuilder.append("&psa=").append(((String) (obj1)));
        }
        if (!com.appnexus.opensdk.b.k.a(j))
        {
            stringbuilder.append("&age=").append(Uri.encode(j));
        }
        if (k == null) goto _L11; else goto _L10
_L10:
        obj1 = null;
        _cls1.a[k.ordinal()];
        JVM INSTR tableswitch 1 3: default 1812
    //                   1 1966
    //                   2 1971
    //                   3 1978;
           goto _L12 _L13 _L14 _L15
_L12:
        if (!com.appnexus.opensdk.b.k.a(((String) (obj1))))
        {
            stringbuilder.append("&gender=").append(Uri.encode(((String) (obj1))));
        }
_L11:
        obj3 = new StringBuilder();
        obj1 = a;
        com.appnexus.opensdk.b.j._cls1.a[((z) (obj1)).ordinal()];
        JVM INSTR tableswitch 1 3: default 1884
    //                   1 1985
    //                   2 1994
    //                   3 2003;
           goto _L16 _L17 _L18 _L19
_L19:
        break MISSING_BLOCK_LABEL_2003;
_L16:
        obj1 = null;
_L23:
        for (obj1 = ((HashSet) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuilder) (obj3)).append(((String) (obj5))))
        {
            obj5 = (String)((Iterator) (obj1)).next();
            if (((StringBuilder) (obj3)).length() > 0)
            {
                ((StringBuilder) (obj3)).append(",");
            }
        }

        break MISSING_BLOCK_LABEL_2012;
_L9:
        if (!h) goto _L21; else goto _L20
_L20:
        obj1 = "1";
          goto _L22
_L13:
        obj1 = null;
          goto _L12
_L14:
        obj1 = "m";
          goto _L12
_L15:
        obj1 = "f";
          goto _L12
_L17:
        obj1 = j1.u;
          goto _L23
_L18:
        obj1 = j1.v;
          goto _L23
        obj1 = j1.w;
          goto _L23
        obj1 = ((StringBuilder) (obj3)).toString();
        if (!com.appnexus.opensdk.b.k.a(((String) (obj1))))
        {
            stringbuilder.append("&nonet=").append(Uri.encode(((String) (obj1))));
        }
        stringbuilder.append("&format=json");
        stringbuilder.append("&st=mobile_app");
        obj1 = stringbuilder.append("&sdkver=");
        com.appnexus.opensdk.b.j.a().getClass();
        ((StringBuilder) (obj1)).append(Uri.encode("2.6"));
        if (l == null) goto _L25; else goto _L24
_L24:
        obj1 = l;
        obj1;
        JVM INSTR monitorenter ;
        obj3 = l.iterator();
_L26:
        do
        {
            if (!((Iterator) (obj3)).hasNext())
            {
                break MISSING_BLOCK_LABEL_2580;
            }
            obj5 = (Pair)((Iterator) (obj3)).next();
        } while (com.appnexus.opensdk.b.k.a((String)((Pair) (obj5)).first) || ((Pair) (obj5)).second == null);
        s1 = (String)((Pair) (obj5)).first;
        if (s == null)
        {
            hashset = new HashSet();
            s = hashset;
            hashset.add("id");
            s.add("aaid");
            s.add("md5udid");
            s.add("sha1udid");
            s.add("devmake");
            s.add("devmodel");
            s.add("carrier");
            s.add("appid");
            s.add("firstlaunch");
            s.add("loc");
            s.add("loc_age");
            s.add("loc_prec");
            s.add("istest");
            s.add("ua");
            s.add("orientation");
            s.add("size");
            s.add("max_size");
            s.add("promo_sizes");
            s.add("mcc");
            s.add("mnc");
            s.add("language");
            s.add("devtz");
            s.add("devtime");
            s.add("connection_type");
            s.add("native_browser");
            s.add("psa");
            s.add("reserve");
            s.add("format");
            s.add("st");
            s.add("sdkver");
        }
        if (!s.contains(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_2557;
        }
        stringbuilder.append("&").append((String)((Pair) (obj5)).first).append("=").append(Uri.encode((String)((Pair) (obj5)).second));
          goto _L26
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        com.appnexus.opensdk.b.b.d(b.e, com.appnexus.opensdk.b.b.a(an.d.request_parameter_override_attempt, (String)((Pair) (obj5)).first));
          goto _L26
        obj1;
        JVM INSTR monitorexit ;
_L25:
        return stringbuilder.toString();
          goto _L27
    }

}
