// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.h;
import com.facebook.i;
import com.facebook.k;
import com.facebook.login.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook.b:
//            t

public final class p
{
    private static final class a extends c
    {

        protected final String a()
        {
            return "com.facebook.katana";
        }

        private a()
        {
            super((byte)0);
        }

        a(byte byte0)
        {
            this();
        }
    }

    private static final class b extends c
    {

        protected final String a()
        {
            return "com.facebook.orca";
        }

        private b()
        {
            super((byte)0);
        }

        b(byte byte0)
        {
            this();
        }
    }

    private static abstract class c
    {

        private static final HashSet b;
        TreeSet a;

        static void a(c c1)
        {
            c1.a(true);
        }

        public static boolean a(Context context, String s)
        {
            String s1;
            int j;
            s1 = Build.BRAND;
            j = context.getApplicationInfo().flags;
            if (!s1.startsWith("generic") || (j & 2) == 0) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            int l;
            int i1;
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 64);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            context = ((PackageInfo) (context)).signatures;
            i1 = context.length;
            l = 0;
label0:
            do
            {
label1:
                {
                    if (l >= i1)
                    {
                        break label1;
                    }
                    s = com.facebook.b.t.a(context[l].toByteArray());
                    if (b.contains(s))
                    {
                        break label0;
                    }
                    l++;
                }
            } while (true);
            if (true) goto _L1; else goto _L3
_L3:
            return false;
        }

        protected abstract String a();

        final void a(boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            if (a != null)
            {
                break MISSING_BLOCK_LABEL_21;
            }
            a = com.facebook.b.p.a(this);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        static 
        {
            HashSet hashset = new HashSet();
            hashset.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
            hashset.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
            hashset.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
            b = hashset;
        }

        private c()
        {
        }

        c(byte byte0)
        {
            this();
        }
    }

    private static final class d extends c
    {

        protected final String a()
        {
            return "com.facebook.wakizashi";
        }

        private d()
        {
            super((byte)0);
        }

        d(byte byte0)
        {
            this();
        }
    }


    private static final c a;
    private static List b;
    private static Map c;
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static final List e = Arrays.asList(new Integer[] {
        Integer.valueOf(0x13354a2), Integer.valueOf(0x1335433), Integer.valueOf(0x13353e4), Integer.valueOf(0x13353c9), Integer.valueOf(0x133529d), Integer.valueOf(0x1335124), Integer.valueOf(0x13350ac), Integer.valueOf(0x1332d23), Integer.valueOf(0x1332b3a), Integer.valueOf(0x1332ac6), 
        Integer.valueOf(0x133060d)
    });

    public static final int a()
    {
        return ((Integer)e.get(0)).intValue();
    }

    public static int a(String s, int ai[])
    {
        return a((List)c.get(s), ai);
    }

    private static int a(List list, int ai[])
    {
        b();
        if (list != null) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        list = list.iterator();
_L4:
        if (!list.hasNext()) goto _L1; else goto _L3
_L3:
        int j;
        Object obj = (c)list.next();
        if (((c) (obj)).a == null)
        {
            ((c) (obj)).a(false);
        }
        obj = ((c) (obj)).a;
        int i1 = a();
        j = ai.length;
        obj = ((TreeSet) (obj)).descendingIterator();
        int l = -1;
        j--;
        int j1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_164;
            }
            j1 = ((Integer)((Iterator) (obj)).next()).intValue();
            l = Math.max(l, j1);
            for (; j >= 0 && ai[j] > j1; j--) { }
            if (j < 0)
            {
                break MISSING_BLOCK_LABEL_164;
            }
        } while (ai[j] != j1);
        if (j % 2 == 0)
        {
            j = Math.min(l, i1);
        } else
        {
            j = -1;
        }
_L5:
        if (j != -1)
        {
            return j;
        }
          goto _L4
          goto _L1
        j = -1;
          goto _L5
    }

    public static Intent a(Context context)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            Object obj = (c)iterator.next();
            obj = (new Intent("com.facebook.platform.PLATFORM_SERVICE")).setPackage(((c) (obj)).a()).addCategory("android.intent.category.DEFAULT");
            if (obj == null)
            {
                obj = null;
            } else
            {
                ResolveInfo resolveinfo = context.getPackageManager().resolveService(((Intent) (obj)), 0);
                if (resolveinfo == null)
                {
                    obj = null;
                } else
                if (!com.facebook.b.c.a(context, resolveinfo.serviceInfo.packageName))
                {
                    obj = null;
                }
            }
            if (obj != null)
            {
                return ((Intent) (obj));
            }
        }

        return null;
    }

    private static Intent a(Context context, Intent intent)
    {
        if (intent == null)
        {
            intent = null;
        } else
        {
            ResolveInfo resolveinfo = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveinfo == null)
            {
                return null;
            }
            if (!com.facebook.b.c.a(context, resolveinfo.activityInfo.packageName))
            {
                return null;
            }
        }
        return intent;
    }

    public static Intent a(Context context, String s, String s1, int j, Bundle bundle)
    {
        Object obj = (List)c.get(s1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        Intent intent;
        Iterator iterator;
        if (obj == null)
        {
            return null;
        } else
        {
            a(((Intent) (obj)), s, s1, j, bundle);
            return ((Intent) (obj));
        }
_L2:
        iterator = ((List) (obj)).iterator();
        obj = null;
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        obj = (c)iterator.next();
        intent = a(context, (new Intent()).setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(((c) (obj)).a()).addCategory("android.intent.category.DEFAULT"));
        obj = intent;
        if (intent == null) goto _L6; else goto _L5
_L5:
        obj = intent;
          goto _L4
    }

    public static Intent a(Context context, String s, Collection collection, String s1, boolean flag, boolean flag1, com.facebook.login.a a1)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            Object obj = (c)iterator.next();
            obj = (new Intent()).setClassName(((c) (obj)).a(), "com.facebook.katana.ProxyAuth").putExtra("client_id", s);
            if (!com.facebook.b.t.a(collection))
            {
                ((Intent) (obj)).putExtra("scope", TextUtils.join(",", collection));
            }
            if (!com.facebook.b.t.a(s1))
            {
                ((Intent) (obj)).putExtra("e2e", s1);
            }
            ((Intent) (obj)).putExtra("response_type", "token,signed_request");
            ((Intent) (obj)).putExtra("return_scopes", "true");
            if (flag1)
            {
                ((Intent) (obj)).putExtra("default_audience", a1.e);
            }
            ((Intent) (obj)).putExtra("legacy_override", "v2.5");
            if (flag)
            {
                ((Intent) (obj)).putExtra("auth_type", "rerequest");
            }
            obj = a(context, ((Intent) (obj)));
            if (obj != null)
            {
                return ((Intent) (obj));
            }
        }

        return null;
    }

    public static Intent a(Intent intent, Bundle bundle, h h1)
    {
        UUID uuid = b(intent);
        if (uuid == null)
        {
            intent = null;
        } else
        {
            Intent intent1 = new Intent();
            intent1.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0));
            intent = new Bundle();
            intent.putString("action_id", uuid.toString());
            if (h1 != null)
            {
                intent.putBundle("error", a(h1));
            }
            intent1.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", intent);
            intent = intent1;
            if (bundle != null)
            {
                intent1.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
                return intent1;
            }
        }
        return intent;
    }

    public static Bundle a(Intent intent)
    {
        if (!a(intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0)))
        {
            return intent.getExtras();
        } else
        {
            return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        }
    }

    public static Bundle a(h h1)
    {
        Bundle bundle;
        if (h1 == null)
        {
            bundle = null;
        } else
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("error_description", h1.toString());
            bundle = bundle1;
            if (h1 instanceof i)
            {
                bundle1.putString("error_type", "UserCanceled");
                return bundle1;
            }
        }
        return bundle;
    }

    public static h a(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        }
        String s1 = bundle.getString("error_type");
        String s = s1;
        if (s1 == null)
        {
            s = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String s2 = bundle.getString("error_description");
        s1 = s2;
        if (s2 == null)
        {
            s1 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (s != null && s.equalsIgnoreCase("UserCanceled"))
        {
            return new i(s1);
        } else
        {
            return new h(s1);
        }
    }

    static TreeSet a(c c1)
    {
        return b(c1);
    }

    public static void a(Intent intent, String s, String s1, int j, Bundle bundle)
    {
        String s3 = k.j();
        String s2 = k.k();
        intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", j).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", s1).putExtra("com.facebook.platform.extra.APPLICATION_ID", s3);
        if (a(j))
        {
            s1 = new Bundle();
            s1.putString("action_id", s);
            com.facebook.b.t.a(s1, "app_name", s2);
            intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", s1);
            s = bundle;
            if (bundle == null)
            {
                s = new Bundle();
            }
            intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", s);
            return;
        }
        intent.putExtra("com.facebook.platform.protocol.CALL_ID", s);
        if (!com.facebook.b.t.a(s2))
        {
            intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", s2);
        }
        intent.putExtras(bundle);
    }

    public static boolean a(int j)
    {
        return e.contains(Integer.valueOf(j)) && j >= 0x133529d;
    }

    public static int b(int j)
    {
        return a(b, new int[] {
            j
        });
    }

    private static TreeSet b(c c1)
    {
        Object obj;
        Object obj1;
        TreeSet treeset;
        Uri uri;
        obj1 = null;
        treeset = new TreeSet();
        obj = k.g().getContentResolver();
        uri = Uri.parse((new StringBuilder("content://")).append(c1.a()).append(".provider.PlatformProvider/versions").toString());
        if (k.g().getPackageManager().resolveContentProvider((new StringBuilder()).append(c1.a()).append(".provider.PlatformProvider").toString(), 0) == null) goto _L2; else goto _L1
_L1:
        c1 = ((ContentResolver) (obj)).query(uri, new String[] {
            "version"
        }, null, null, null);
        obj = c1;
        if (c1 == null) goto _L4; else goto _L3
_L3:
        obj = c1;
        if (!c1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        treeset.add(Integer.valueOf(c1.getInt(c1.getColumnIndex("version"))));
        if (true) goto _L3; else goto _L4
        obj;
_L6:
        if (c1 != null)
        {
            c1.close();
        }
        throw obj;
_L2:
        obj = null;
_L4:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return treeset;
        obj;
        c1 = obj1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static UUID b(Intent intent)
    {
        if (intent != null)
        {
            if (a(intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0)))
            {
                intent = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                if (intent != null)
                {
                    intent = intent.getString("action_id");
                } else
                {
                    intent = null;
                }
            } else
            {
                intent = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
            }
            if (intent != null)
            {
                try
                {
                    intent = UUID.fromString(intent);
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    return null;
                }
                return intent;
            }
        }
        return null;
    }

    public static void b()
    {
        if (!d.compareAndSet(false, true))
        {
            return;
        } else
        {
            k.e().execute(new Runnable() {

                public final void run()
                {
                    for (Iterator iterator = p.c().iterator(); iterator.hasNext(); com.facebook.b.c.a((c)iterator.next())) { }
                    break MISSING_BLOCK_LABEL_43;
                    Exception exception;
                    exception;
                    p.d().set(false);
                    throw exception;
                    p.d().set(false);
                    return;
                }

            });
            return;
        }
    }

    static List c()
    {
        return b;
    }

    static AtomicBoolean d()
    {
        return d;
    }

    static 
    {
        a = new a((byte)0);
        Object obj = new ArrayList();
        ((List) (obj)).add(a);
        ((List) (obj)).add(new d((byte)0));
        b = ((List) (obj));
        obj = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new b((byte)0));
        ((Map) (obj)).put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", b);
        ((Map) (obj)).put("com.facebook.platform.action.request.FEED_DIALOG", b);
        ((Map) (obj)).put("com.facebook.platform.action.request.LIKE_DIALOG", b);
        ((Map) (obj)).put("com.facebook.platform.action.request.APPINVITES_DIALOG", b);
        ((Map) (obj)).put("com.facebook.platform.action.request.MESSAGE_DIALOG", arraylist);
        ((Map) (obj)).put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arraylist);
        c = ((Map) (obj));
    }
}
