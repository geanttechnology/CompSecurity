// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.a.e;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.android.network.managers:
//            UserManager, ak

public class i
{

    private static final String a = com/smule/android/network/managers/i.getName();
    private static i b;
    private e c;
    private Set d;
    private Set e;
    private Context f;
    private AtomicBoolean g;
    private long h;
    private long i;
    private boolean j;
    private final LinkedList k = new LinkedList();

    public i()
    {
        d = new HashSet();
        e = new HashSet();
        g = new AtomicBoolean(false);
        h = 0L;
        i = 0L;
    }

    public static i a()
    {
        com/smule/android/network/managers/i;
        JVM INSTR monitorenter ;
        i l;
        if (b == null)
        {
            b = new i();
        }
        l = b;
        com/smule/android/network/managers/i;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(o o1)
    {
        this;
        JVM INSTR monitorenter ;
        b(o1);
        a(true);
        h = SystemClock.elapsedRealtime();
        i = UserManager.n().b();
        this;
        JVM INSTR monitorexit ;
        return;
        o1;
        throw o1;
    }

    static void a(i l)
    {
        l.g();
    }

    private void a(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = f.getSharedPreferences("ENTITLEMENTS_SETTINGS", 0).edit();
        String s = TextUtils.join(",", d);
        String s1 = TextUtils.join(",", e);
        editor.putString("entitlements", s);
        editor.putString("arrangements", s1);
        editor.putString("digest", e((new StringBuilder()).append(s).append(":").append(s1).toString()));
        editor.putString("version", com.smule.android.network.core.b.d().h());
        p.a(editor);
        if (flag)
        {
            i();
        }
    }

    private void b(o o1)
    {
        JsonNode jsonnode = o1.b().get("products");
        if (jsonnode != null)
        {
            d.clear();
            e.clear();
            ak.a();
            o1 = jsonnode.iterator();
            do
            {
                if (!o1.hasNext())
                {
                    break;
                }
                JsonNode jsonnode1 = (JsonNode)o1.next();
                if (jsonnode1.get("entityType").textValue().equals("SONG"))
                {
                    d.add(jsonnode1.get("entityId").textValue());
                } else
                if (jsonnode1.get("entityType").textValue().equals("ARR"))
                {
                    e.add(jsonnode1.get("entityId").textValue());
                }
            } while (true);
            d.addAll(com.smule.android.network.core.b.d().k());
            return;
        } else
        {
            aa.b(a, (new StringBuilder()).append("Missing products in entitlements response ").append(o1.h).toString());
            return;
        }
    }

    static void b(i l)
    {
        l.j();
    }

    private String e(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            messagedigest.update(s.getBytes());
            s = new String(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    private boolean f()
    {
        long l = UserManager.n().b();
        boolean flag;
        if (i == 0L && l == 0L || i != 0L && i == l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return SystemClock.elapsedRealtime() - h < 0x927c0L && flag;
    }

    private void g()
    {
        o o1 = c.b();
        if (o1.b == 0)
        {
            a(o1);
        }
        g.set(false);
        return;
        Exception exception;
        exception;
        g.set(false);
        throw exception;
    }

    private void h()
    {
        int l = 0;
        this;
        JVM INSTR monitorenter ;
        String s;
        String as[];
        int i1;
        Object obj = f.getSharedPreferences("ENTITLEMENTS_SETTINGS", 0);
        String s1 = ((SharedPreferences) (obj)).getString("entitlements", "");
        s = ((SharedPreferences) (obj)).getString("arrangements", "");
        obj = ((SharedPreferences) (obj)).getString("digest", "");
        String s3 = e((new StringBuilder()).append(s1).append(":").append(s).toString());
        if (j && !((String) (obj)).equals("") && !((String) (obj)).equals(s3))
        {
            aa.b(a, (new StringBuilder()).append("Calculated digest [").append(s3).append("] is different from stored one [").append(((String) (obj))).append("]. Loaded entitlements: ").append(s1).toString());
        }
        d.clear();
        as = TextUtils.split(s1, ",");
        i1 = as.length;
_L2:
        String s2;
        if (l >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = as[l];
        d.add(ak.a().k(s2));
        l++;
        if (true) goto _L2; else goto _L1
_L1:
        if (d.isEmpty())
        {
            d.addAll(com.smule.android.network.core.b.d().k());
            aa.c(a, (new StringBuilder()).append("Added bundled entitlements ").append(d).toString());
            a(false);
        }
        e.clear();
        e.addAll(Arrays.asList(TextUtils.split(s, ",")));
        aa.c(a, "Entitlements loaded.");
        i();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void i()
    {
        com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", new Object[] {
            "ACTION", "ENTITLEMENTS_UPDATED_ACTION"
        });
    }

    private void j()
    {
        LinkedList linkedlist1;
        synchronized (k)
        {
            linkedlist1 = new LinkedList(k);
            k.clear();
        }
        for (; linkedlist1.size() > 0; ((Runnable)linkedlist1.remove(0)).run()) { }
        break MISSING_BLOCK_LABEL_56;
        exception;
        linkedlist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Context context, boolean flag)
    {
        a(context, flag, true);
    }

    public void a(Context context, boolean flag, boolean flag1)
    {
        f = context;
        j = flag;
        c = com.smule.android.network.a.e.a();
        if (flag1)
        {
            h();
        }
    }

    public boolean a(Runnable runnable)
    {
        if (runnable != null)
        {
            synchronized (k)
            {
                k.addLast(runnable);
            }
        }
        if (f())
        {
            j();
        } else
        if (!g.getAndSet(true))
        {
            com.smule.android.network.core.b.a(new Runnable() {

                final i a;

                public void run()
                {
                    i.a(a);
                    com.smule.android.network.managers.i.b(a);
                }

            
            {
                a = i.this;
                super();
            }
            });
            return true;
        }
        return false;
        runnable;
        linkedlist;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public boolean a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d.contains(s);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public void b()
    {
        h();
        HashSet hashset = new HashSet();
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!s.startsWith("_"))
            {
                hashset.add(ak.a().k(s));
                iterator.remove();
            }
        } while (true);
        d.addAll(hashset);
        a(false);
    }

    public boolean b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = e.contains(s);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public Set c()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        StringBuilder stringbuilder;
        if (d.size() == 0 && com.smule.android.network.core.b.d().j().size() > 0)
        {
            e();
            aa.b(a, "Entitlements error!  Did the app just crash?");
        }
        s = a;
        stringbuilder = (new StringBuilder()).append("getOwnedProducts() returning ");
        if (d != null) goto _L2; else goto _L1
_L1:
        Object obj = "0";
_L4:
        aa.a(s, stringbuilder.append(obj).append(" product UIDs").toString());
        obj = new HashSet(d.size());
        ((Set) (obj)).addAll(d);
        this;
        JVM INSTR monitorexit ;
        return ((Set) (obj));
_L2:
        int l = d.size();
        obj = Integer.valueOf(l);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean c(String s)
    {
        return a(s) || b(s);
    }

    public void d(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        if (!c(s))
        {
            d.add(s);
            a(true);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public boolean d()
    {
        return a(((Runnable) (null)));
    }

    public void e()
    {
        if (g.getAndSet(true))
        {
            return;
        } else
        {
            com.smule.android.network.core.b.a(new Runnable() {

                final i a;

                public void run()
                {
                    i.a(a);
                }

            
            {
                a = i.this;
                super();
            }
            });
            return;
        }
    }

}
