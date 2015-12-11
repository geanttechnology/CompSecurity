// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

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
import com.facebook.f;
import com.facebook.g;
import com.facebook.i;
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

// Referenced classes of package com.facebook.internal:
//            o

public final class k
{
    private static class a extends c
    {

        protected String a()
        {
            return "com.facebook.katana";
        }

        private a()
        {
        }

    }

    private static class b extends c
    {

        protected String a()
        {
            return "com.facebook.orca";
        }

        private b()
        {
        }

    }

    private static abstract class c
    {

        private static final HashSet a = c();
        private TreeSet b;

        static void a(c c1, boolean flag)
        {
            c1.a(flag);
        }

        private void a(boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            if (b != null)
            {
                break MISSING_BLOCK_LABEL_21;
            }
            b = com.facebook.internal.k.a(this);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private static HashSet c()
        {
            HashSet hashset = new HashSet();
            hashset.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
            hashset.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
            hashset.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
            return hashset;
        }

        protected abstract String a();

        public boolean a(Context context, String s)
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
                    s = com.facebook.internal.o.a(context[l].toByteArray());
                    if (a.contains(s))
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

        public TreeSet b()
        {
            if (b == null)
            {
                a(false);
            }
            return b;
        }


        private c()
        {
        }

    }

    private static class d extends c
    {

        protected String a()
        {
            return "com.facebook.wakizashi";
        }

        private d()
        {
        }

    }


    private static final c a = new a();
    private static List b = e();
    private static Map c = f();
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static final List e = Arrays.asList(new Integer[] {
        Integer.valueOf(0x13354a2), Integer.valueOf(0x1335433), Integer.valueOf(0x13353e4), Integer.valueOf(0x13353c9), Integer.valueOf(0x133529d), Integer.valueOf(0x1335124), Integer.valueOf(0x13350ac), Integer.valueOf(0x1332d23), Integer.valueOf(0x1332b3a), Integer.valueOf(0x1332ac6), 
        Integer.valueOf(0x133060d)
    });

    public static final int a()
    {
        return ((Integer)e.get(0)).intValue();
    }

    public static int a(Intent intent)
    {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    private static int a(List list, int ai[])
    {
        b();
        if (list == null)
        {
            return -1;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            int j = a(((c)list.next()).b(), a(), ai);
            if (j != -1)
            {
                return j;
            }
        }

        return -1;
    }

    public static int a(TreeSet treeset, int j, int ai[])
    {
        int l;
        int i1;
        l = ai.length;
        treeset = treeset.descendingIterator();
        i1 = -1;
        l--;
_L2:
        int j1;
        if (treeset.hasNext())
        {
            j1 = ((Integer)treeset.next()).intValue();
            i1 = Math.max(i1, j1);
            for (; l >= 0 && ai[l] > j1; l--) { }
            if (l >= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
_L3:
        return -1;
        if (ai[l] != j1) goto _L2; else goto _L1
_L1:
        if (l % 2 == 0)
        {
            return Math.min(i1, j);
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static Intent a(Context context)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            Object obj = (c)iterator.next();
            obj = b(context, (new Intent("com.facebook.platform.PLATFORM_SERVICE")).setPackage(((c) (obj)).a()).addCategory("android.intent.category.DEFAULT"), ((c) (obj)));
            if (obj != null)
            {
                return ((Intent) (obj));
            }
        }

        return null;
    }

    static Intent a(Context context, Intent intent, c c1)
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
            if (!c1.a(context, resolveinfo.activityInfo.packageName))
            {
                return null;
            }
        }
        return intent;
    }

    public static Intent a(Context context, String s, Collection collection, String s1, boolean flag, boolean flag1, com.facebook.login.a a1)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            Object obj = (c)iterator.next();
            Intent intent = (new Intent()).setClassName(((c) (obj)).a(), "com.facebook.katana.ProxyAuth").putExtra("client_id", s);
            if (!com.facebook.internal.o.a(collection))
            {
                intent.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!com.facebook.internal.o.a(s1))
            {
                intent.putExtra("e2e", s1);
            }
            intent.putExtra("response_type", "token,signed_request");
            intent.putExtra("return_scopes", "true");
            if (flag1)
            {
                intent.putExtra("default_audience", a1.a());
            }
            intent.putExtra("legacy_override", "v2.5");
            if (flag)
            {
                intent.putExtra("auth_type", "rerequest");
            }
            obj = a(context, intent, ((c) (obj)));
            if (obj != null)
            {
                return ((Intent) (obj));
            }
        }

        return null;
    }

    public static Intent a(Intent intent, Bundle bundle, f f1)
    {
        UUID uuid = b(intent);
        if (uuid == null)
        {
            intent = null;
        } else
        {
            Intent intent1 = new Intent();
            intent1.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", a(intent));
            intent = new Bundle();
            intent.putString("action_id", uuid.toString());
            if (f1 != null)
            {
                intent.putBundle("error", a(f1));
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

    public static Bundle a(f f1)
    {
        Bundle bundle;
        if (f1 == null)
        {
            bundle = null;
        } else
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("error_description", f1.toString());
            bundle = bundle1;
            if (f1 instanceof g)
            {
                bundle1.putString("error_type", "UserCanceled");
                return bundle1;
            }
        }
        return bundle;
    }

    public static f a(Bundle bundle)
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
            return new g(s1);
        } else
        {
            return new f(s1);
        }
    }

    static TreeSet a(c c1)
    {
        return b(c1);
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

    static Intent b(Context context, Intent intent, c c1)
    {
        if (intent == null)
        {
            intent = null;
        } else
        {
            ResolveInfo resolveinfo = context.getPackageManager().resolveService(intent, 0);
            if (resolveinfo == null)
            {
                return null;
            }
            if (!c1.a(context, resolveinfo.serviceInfo.packageName))
            {
                return null;
            }
        }
        return intent;
    }

    private static TreeSet b(c c1)
    {
        Object obj;
        Object obj1;
        TreeSet treeset;
        Uri uri;
        obj1 = null;
        treeset = new TreeSet();
        obj = i.f().getContentResolver();
        uri = c(c1);
        if (i.f().getPackageManager().resolveContentProvider((new StringBuilder()).append(c1.a()).append(".provider.PlatformProvider").toString(), 0) == null) goto _L2; else goto _L1
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

    public static UUID b(Intent intent)
    {
        if (intent != null)
        {
            if (a(a(intent)))
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
            i.d().execute(new Runnable() {

                public void run()
                {
                    for (Iterator iterator = k.c().iterator(); iterator.hasNext(); com.facebook.internal.c.a((c)iterator.next(), true)) { }
                    break MISSING_BLOCK_LABEL_44;
                    Exception exception;
                    exception;
                    k.d().set(false);
                    throw exception;
                    k.d().set(false);
                    return;
                }

            });
            return;
        }
    }

    private static Uri c(c c1)
    {
        return Uri.parse((new StringBuilder()).append("content://").append(c1.a()).append(".provider.PlatformProvider/versions").toString());
    }

    public static Bundle c(Intent intent)
    {
        if (!a(a(intent)))
        {
            return intent.getExtras();
        } else
        {
            return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
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

    private static List e()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a);
        arraylist.add(new d());
        return arraylist;
    }

    private static Map f()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new b());
        hashmap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", b);
        hashmap.put("com.facebook.platform.action.request.FEED_DIALOG", b);
        hashmap.put("com.facebook.platform.action.request.LIKE_DIALOG", b);
        hashmap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", b);
        hashmap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arraylist);
        hashmap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arraylist);
        return hashmap;
    }

}
