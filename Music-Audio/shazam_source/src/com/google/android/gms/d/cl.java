// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.e;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ce, dv, gn, he, 
//            hf, cg, gi, gl, 
//            o, gm

public final class cl
    implements ce
{
    public static final class a extends gi
    {

        private final String a = "play.google.com";
        private final String b = "market";
        private final int c = 10;
        private final String d;
        private final he e;

        public final void a()
        {
            Object obj;
            int i;
            i = 0;
            obj = d;
_L11:
            if (i >= 10) goto _L2; else goto _L1
_L1:
            Object obj1;
            boolean flag;
            obj1 = new URL(((String) (obj)));
            flag = "play.google.com".equalsIgnoreCase(((URL) (obj1)).getHost());
            if (!flag) goto _L3; else goto _L2
_L2:
            obj = Uri.parse(((String) (obj)));
            obj1 = new Intent("android.intent.action.VIEW");
            ((Intent) (obj1)).addFlags(0x10000000);
            ((Intent) (obj1)).setData(((Uri) (obj)));
            e.getContext().startActivity(((Intent) (obj1)));
            return;
_L3:
            if (!"market".equalsIgnoreCase(((URL) (obj1)).getProtocol())) goto _L4; else goto _L2
_L4:
            HttpURLConnection httpurlconnection = (HttpURLConnection)((URL) (obj1)).openConnection();
            Map map;
            int j;
            p.e().a(e.getContext(), e.l().b, false, httpurlconnection);
            j = httpurlconnection.getResponseCode();
            map = httpurlconnection.getHeaderFields();
            if (j < 300 || j > 399)
            {
                break MISSING_BLOCK_LABEL_327;
            }
            obj1 = null;
            if (!map.containsKey("Location")) goto _L6; else goto _L5
_L5:
            obj1 = (List)map.get("Location");
_L10:
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_327;
            }
            if (((List) (obj1)).size() <= 0)
            {
                break MISSING_BLOCK_LABEL_327;
            }
            obj1 = (String)((List) (obj1)).get(0);
_L15:
            if (!TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L8; else goto _L7
_L7:
            com.google.android.gms.ads.internal.util.client.b.a(5);
            httpurlconnection.disconnect();
              goto _L2
_L6:
            if (!map.containsKey("location")) goto _L10; else goto _L9
_L9:
            obj1 = (List)map.get("location");
              goto _L10
_L8:
            httpurlconnection.disconnect();
            i++;
            obj = obj1;
              goto _L11
            obj1;
            httpurlconnection.disconnect();
            throw obj1;
            obj1;
_L14:
            com.google.android.gms.ads.internal.util.client.b.a(5);
              goto _L2
            obj1;
_L13:
            com.google.android.gms.ads.internal.util.client.b.a(5);
              goto _L2
            obj1;
_L12:
            com.google.android.gms.ads.internal.util.client.b.a(5);
              goto _L2
            obj;
            obj = obj1;
              goto _L12
            obj;
            obj = obj1;
              goto _L13
            IndexOutOfBoundsException indexoutofboundsexception;
            indexoutofboundsexception;
            indexoutofboundsexception = ((IndexOutOfBoundsException) (obj1));
              goto _L14
            obj1 = "";
              goto _L15
        }

        public final void b()
        {
        }

        public a(he he1, String s)
        {
            e = he1;
            d = s;
        }
    }

    public static final class b
    {

        public static Intent a(Context context, Map map)
        {
            Object obj;
            Object obj2;
            Object obj3;
            obj = null;
            obj2 = (ActivityManager)context.getSystemService("activity");
            obj3 = (String)map.get("u");
            if (!TextUtils.isEmpty(((CharSequence) (obj3)))) goto _L2; else goto _L1
_L1:
            map = obj;
_L4:
            return map;
_L2:
            Object obj1 = Uri.parse(((String) (obj3)));
            boolean flag = Boolean.parseBoolean((String)map.get("use_first_package"));
            boolean flag1 = Boolean.parseBoolean((String)map.get("use_running_process"));
            Intent intent;
            if ("http".equalsIgnoreCase(((Uri) (obj1)).getScheme()))
            {
                map = ((Uri) (obj1)).buildUpon().scheme("https").build();
            } else
            if ("https".equalsIgnoreCase(((Uri) (obj1)).getScheme()))
            {
                map = ((Uri) (obj1)).buildUpon().scheme("http").build();
            } else
            {
                map = null;
            }
            obj3 = new ArrayList();
            intent = a(((Uri) (obj1)));
            map = a(((Uri) (map)));
            obj1 = a(context, intent, ((ArrayList) (obj3)));
            if (obj1 != null)
            {
                return a(intent, ((ResolveInfo) (obj1)));
            }
            if (map == null)
            {
                break; /* Loop/switch isn't completed */
            }
            map = a(context, ((Intent) (map)));
            if (map == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = a(intent, ((ResolveInfo) (map)));
            map = ((Map) (obj1));
            if (a(context, ((Intent) (obj1))) != null) goto _L4; else goto _L3
_L3:
            if (((ArrayList) (obj3)).size() == 0)
            {
                return intent;
            }
            if (!flag1 || obj2 == null)
            {
                break MISSING_BLOCK_LABEL_301;
            }
            context = ((ActivityManager) (obj2)).getRunningAppProcesses();
            if (context == null)
            {
                break MISSING_BLOCK_LABEL_301;
            }
            map = ((ArrayList) (obj3)).iterator();
_L6:
            if (!map.hasNext())
            {
                break MISSING_BLOCK_LABEL_301;
            }
            obj1 = (ResolveInfo)map.next();
            obj2 = context.iterator();
_L8:
            if (!((Iterator) (obj2)).hasNext()) goto _L6; else goto _L5
_L5:
            if (!((android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj2)).next()).processName.equals(((ResolveInfo) (obj1)).activityInfo.packageName)) goto _L8; else goto _L7
_L7:
            return a(intent, ((ResolveInfo) (obj1)));
            if (flag)
            {
                return a(intent, (ResolveInfo)((ArrayList) (obj3)).get(0));
            } else
            {
                return intent;
            }
        }

        private static Intent a(Intent intent, ResolveInfo resolveinfo)
        {
            intent = new Intent(intent);
            intent.setClassName(resolveinfo.activityInfo.packageName, resolveinfo.activityInfo.name);
            return intent;
        }

        private static Intent a(Uri uri)
        {
            if (uri == null)
            {
                return null;
            } else
            {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(0x10000000);
                intent.setData(uri);
                intent.setAction("android.intent.action.VIEW");
                return intent;
            }
        }

        private static ResolveInfo a(Context context, Intent intent)
        {
            return a(context, intent, new ArrayList());
        }

        private static ResolveInfo a(Context context, Intent intent, ArrayList arraylist)
        {
            List list;
            int i;
            context = context.getPackageManager();
            if (context == null)
            {
                return null;
            }
            list = context.queryIntentActivities(intent, 0x10000);
            context = context.resolveActivity(intent, 0x10000);
            if (list == null || context == null)
            {
                break MISSING_BLOCK_LABEL_102;
            }
            i = 0;
_L3:
            if (i >= list.size())
            {
                break MISSING_BLOCK_LABEL_102;
            }
            intent = (ResolveInfo)list.get(i);
            if (context == null || !((ResolveInfo) (context)).activityInfo.name.equals(((ResolveInfo) (intent)).activityInfo.name)) goto _L2; else goto _L1
_L1:
            arraylist.addAll(list);
            return context;
_L2:
            i++;
              goto _L3
            context = null;
              goto _L1
        }

        public b()
        {
        }
    }


    private final cg a;
    private final e b;
    private final dv c;

    public cl(cg cg1, e e1, dv dv1)
    {
        a = cg1;
        b = e1;
        c = dv1;
    }

    private void a(boolean flag)
    {
        if (c != null)
        {
            c.a(flag);
        }
    }

    private static boolean a(Map map)
    {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map map)
    {
        map = (String)map.get("o");
        if (map != null)
        {
            if ("p".equalsIgnoreCase(map))
            {
                return p.g().b();
            }
            if ("l".equalsIgnoreCase(map))
            {
                return p.g().a();
            }
            if ("c".equalsIgnoreCase(map))
            {
                return p.g().c();
            }
        }
        return -1;
    }

    public final void a(he he1, Map map)
    {
        String s = (String)map.get("a");
        if (s == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        } else
        {
            if (b != null && !b.a())
            {
                b.a((String)map.get("u"));
                return;
            }
            hf hf1 = he1.i();
            if ("expand".equalsIgnoreCase(s))
            {
                if (he1.m())
                {
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                    return;
                } else
                {
                    a(false);
                    hf1.a(a(map), b(map));
                    return;
                }
            }
            if ("webapp".equalsIgnoreCase(s))
            {
                he1 = (String)map.get("u");
                a(false);
                if (he1 != null)
                {
                    hf1.a(a(map), b(map), he1);
                    return;
                } else
                {
                    hf1.a(a(map), b(map), (String)map.get("html"), (String)map.get("baseurl"));
                    return;
                }
            }
            if ("in_app_purchase".equalsIgnoreCase(s))
            {
                he1 = (String)map.get("product_id");
                map = (String)map.get("report_urls");
                if (a != null)
                {
                    if (map != null && !map.isEmpty())
                    {
                        map = map.split(" ");
                        a.a(he1, new ArrayList(Arrays.asList(map)));
                        return;
                    } else
                    {
                        a.a(he1, new ArrayList());
                        return;
                    }
                }
            } else
            {
                if ("app".equalsIgnoreCase(s) && "true".equalsIgnoreCase((String)map.get("play_store")))
                {
                    map = (String)map.get("u");
                    if (TextUtils.isEmpty(map))
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(5);
                        return;
                    } else
                    {
                        gl.a(((gi) (new a(he1, map))).i);
                        return;
                    }
                }
                if ("app".equalsIgnoreCase(s) && "true".equalsIgnoreCase((String)map.get("system_browser")))
                {
                    he1 = he1.getContext();
                    if (TextUtils.isEmpty((String)map.get("u")))
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(5);
                        return;
                    }
                    new b();
                    map = b.a(he1, map);
                    try
                    {
                        he1.startActivity(map);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (he he1)
                    {
                        he1.getMessage();
                    }
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                    return;
                }
                a(true);
                o o1 = he1.k();
                s = (String)map.get("u");
                if (!TextUtils.isEmpty(s))
                {
                    String s1 = s;
                    if (o1 != null)
                    {
                        s1 = s;
                        if (o1.a(Uri.parse(s)))
                        {
                            p.e();
                            s1 = com.google.android.gms.d.gm.b(he1.getContext(), s, he1.r());
                        }
                    }
                    p.e();
                    he1 = gm.a(he1.getContext(), he1.k(), s1);
                } else
                {
                    he1 = s;
                }
                hf1.a(new AdLauncherIntentInfoParcel((String)map.get("i"), he1, (String)map.get("m"), (String)map.get("p"), (String)map.get("c"), (String)map.get("f"), (String)map.get("e")));
                return;
            }
        }
    }
}
