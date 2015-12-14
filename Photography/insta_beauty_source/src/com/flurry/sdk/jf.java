// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            kc, js, lt, kg, 
//            ls, jg, jh, lu, 
//            lq, jn, jp, kb

public class jf
{

    private static final String a = com/flurry/sdk/jf.getSimpleName();
    private static jf b;
    private final Set c = v();
    private final Map d = new HashMap();
    private final kb e = new _cls1();
    private a f;
    private jp g;
    private String h;
    private byte i[];

    private jf()
    {
        f = a.a;
        kc.a().a("com.flurry.android.sdk.FlurrySessionEvent", e);
        js.a().b(new _cls2());
    }

    public static jf a()
    {
        com/flurry/sdk/jf;
        JVM INSTR monitorenter ;
        jf jf1;
        if (b == null)
        {
            b = new jf();
        }
        jf1 = b;
        com/flurry/sdk/jf;
        JVM INSTR monitorexit ;
        return jf1;
        Exception exception;
        exception;
        throw exception;
    }

    private String a(DataInput datainput)
    {
        if (1 != datainput.readInt())
        {
            return null;
        } else
        {
            return datainput.readUTF();
        }
    }

    static void a(jf jf1)
    {
        jf1.j();
    }

    private void a(String s1, DataOutput dataoutput)
    {
        dataoutput.writeInt(1);
        dataoutput.writeUTF(s1);
    }

    private void a(String s1, File file)
    {
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));
        file = dataoutputstream;
        a(s1, ((DataOutput) (dataoutputstream)));
        lt.a(dataoutputstream);
        return;
        Throwable throwable;
        throwable;
        s1 = null;
_L4:
        file = s1;
        kg.a(6, a, "Error when saving deviceId", throwable);
        lt.a(s1);
        return;
        s1;
        file = null;
_L2:
        lt.a(file);
        throw s1;
        s1;
        if (true) goto _L2; else goto _L1
_L1:
        throwable;
        s1 = dataoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean a(String s1)
    {
        while (TextUtils.isEmpty(s1) || c(s1.toLowerCase(Locale.US))) 
        {
            return false;
        }
        return true;
    }

    private String b(DataInput datainput)
    {
        while (46586 != datainput.readUnsignedShort() || 2 != datainput.readUnsignedShort()) 
        {
            return null;
        }
        datainput.readUTF();
        return datainput.readUTF();
    }

    public static void b()
    {
        b = null;
    }

    static void b(jf jf1)
    {
        jf1.i();
    }

    private void b(String s1)
    {
        File file;
        if (!TextUtils.isEmpty(s1))
        {
            if (ls.a(file = js.a().c().getFileStreamPath(u())))
            {
                a(s1, file);
                return;
            }
        }
    }

    private boolean c(String s1)
    {
        return c.contains(s1);
    }

    private void i()
    {
_L13:
        if (a.f.equals(f))
        {
            break; /* Loop/switch isn't completed */
        }
        _cls4.b[f.ordinal()];
        JVM INSTR tableswitch 1 5: default 60
    //                   1 149
    //                   2 159
    //                   3 169
    //                   4 179
    //                   5 189;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        _cls4.b[f.ordinal()];
        JVM INSTR tableswitch 2 5: default 236
    //                   2 100
    //                   3 199
    //                   4 206
    //                   5 213;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        if (false)
        {
        }
        continue; /* Loop/switch isn't completed */
_L8:
        Exception exception;
        j();
        continue; /* Loop/switch isn't completed */
_L2:
        f = a.b;
          goto _L1
_L3:
        f = a.c;
          goto _L1
_L4:
        f = a.d;
          goto _L1
_L5:
        f = a.e;
          goto _L1
_L6:
        f = a.f;
          goto _L1
_L9:
        try
        {
            k();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            kg.a(4, a, (new StringBuilder()).append("Exception during id fetch:").append(f).append(", ").append(exception).toString());
        }
        continue; /* Loop/switch isn't completed */
_L10:
        l();
        continue; /* Loop/switch isn't completed */
_L11:
        x();
        if (true) goto _L13; else goto _L12
_L12:
        jg jg1 = new jg();
        kc.a().a(jg1);
        return;
    }

    private void j()
    {
        lt.b();
        if (m())
        {
            g = n();
            if (c())
            {
                x();
                jh jh1 = new jh();
                kc.a().a(jh1);
                return;
            }
        }
    }

    private void k()
    {
        lt.b();
        h = o();
    }

    private void l()
    {
        if (js.a().c().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
        {
            return;
        } else
        {
            w();
            return;
        }
    }

    private boolean m()
    {
        return lu.a(js.a().c());
    }

    private jp n()
    {
        return lu.b(js.a().c());
    }

    private String o()
    {
        String s1 = p();
        if (!TextUtils.isEmpty(s1))
        {
            return s1;
        } else
        {
            return q();
        }
    }

    private String p()
    {
        String s1 = android.provider.Settings.Secure.getString(js.a().c().getContentResolver(), "android_id");
        if (!a(s1))
        {
            return null;
        } else
        {
            return (new StringBuilder()).append("AND").append(s1).toString();
        }
    }

    private String q()
    {
        String s2 = s();
        String s1 = s2;
        if (TextUtils.isEmpty(s2))
        {
            String s3 = t();
            s1 = s3;
            if (TextUtils.isEmpty(s3))
            {
                s1 = r();
            }
            b(s1);
        }
        return s1;
    }

    private String r()
    {
        long l1 = Double.doubleToLongBits(Math.random());
        long l2 = System.nanoTime();
        long l3 = lt.i(lq.c(js.a().c()));
        return (new StringBuilder()).append("ID").append(Long.toString(l1 + (l2 + l3 * 37L) * 37L, 16)).toString();
    }

    private String s()
    {
        Object obj;
        obj = js.a().c().getFileStreamPath(u());
        if (obj == null || !((File) (obj)).exists())
        {
            return null;
        }
        Object obj1 = new DataInputStream(new FileInputStream(((File) (obj))));
        obj = obj1;
        Object obj2 = a(((DataInput) (obj1)));
        lt.a(((java.io.Closeable) (obj1)));
        return ((String) (obj2));
        Object obj3;
        obj3;
        obj1 = null;
_L4:
        obj = obj1;
        kg.a(6, a, "Error when loading deviceId", ((Throwable) (obj3)));
        lt.a(((java.io.Closeable) (obj1)));
        return null;
        obj;
        obj3 = null;
        obj1 = obj;
_L2:
        lt.a(((java.io.Closeable) (obj3)));
        throw obj1;
        obj1;
        obj3 = obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj3;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String t()
    {
        Object obj = js.a().c().getFilesDir();
        if (obj != null) goto _L2; else goto _L1
_L1:
        String as[];
        return null;
_L2:
        if ((as = ((File) (obj)).list(new _cls3())) == null || as.length == 0) goto _L1; else goto _L3
_L3:
        as = as[0];
        as = js.a().c().getFileStreamPath(as);
        if (as == null || !as.exists()) goto _L1; else goto _L4
_L4:
        Object obj1 = new DataInputStream(new FileInputStream(as));
        as = ((String []) (obj1));
        Object obj2 = b(((DataInput) (obj1)));
        lt.a(((java.io.Closeable) (obj1)));
        return ((String) (obj2));
        Object obj3;
        obj3;
        obj1 = null;
_L8:
        as = ((String []) (obj1));
        kg.a(6, a, "Error when loading deviceId", ((Throwable) (obj3)));
        lt.a(((java.io.Closeable) (obj1)));
        return null;
        as;
        obj3 = null;
        obj1 = as;
_L6:
        lt.a(((java.io.Closeable) (obj3)));
        throw obj1;
        obj1;
        obj3 = as;
        if (true) goto _L6; else goto _L5
_L5:
        obj3;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private String u()
    {
        return ".flurryb.";
    }

    private Set v()
    {
        HashSet hashset = new HashSet();
        hashset.add("null");
        hashset.add("9774d56d682e549c");
        hashset.add("dead00beef");
        return Collections.unmodifiableSet(hashset);
    }

    private void w()
    {
        Object obj = (TelephonyManager)js.a().c().getSystemService("phone");
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((obj = ((TelephonyManager) (obj)).getDeviceId()) == null || ((String) (obj)).trim().length() <= 0) goto _L1; else goto _L3
_L3:
        try
        {
            obj = lt.f(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            kg.a(6, a, "Exception in generateHashedImei()");
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (obj.length == 20)
        {
            i = ((byte []) (obj));
            return;
        }
        kg.a(6, a, (new StringBuilder()).append("sha1 is not ").append(20).append(" bytes long: ").append(Arrays.toString(((byte []) (obj)))).toString());
        return;
    }

    private void x()
    {
        String s1 = d();
        if (s1 != null)
        {
            kg.a(3, a, "Fetched advertising id");
            d.put(jn.c, lt.e(s1));
        }
        s1 = f();
        if (s1 != null)
        {
            kg.a(3, a, "Fetched device id");
            d.put(jn.a, lt.e(s1));
        }
        byte abyte0[] = g();
        if (abyte0 != null)
        {
            kg.a(3, a, "Fetched hashed IMEI");
            d.put(jn.b, abyte0);
        }
    }

    public boolean c()
    {
        return a.f.equals(f);
    }

    public String d()
    {
        if (g == null)
        {
            return null;
        } else
        {
            return g.a();
        }
    }

    public boolean e()
    {
        while (g == null || !g.b()) 
        {
            return true;
        }
        return false;
    }

    public String f()
    {
        return h;
    }

    public byte[] g()
    {
        return i;
    }

    public Map h()
    {
        return Collections.unmodifiableMap(d);
    }


    private class _cls1
        implements kb
    {

        final jf a;

        public volatile void a(ka ka)
        {
            a((lg)ka);
        }

        public void a(lg lg1)
        {
            _cls4.a[lg1.c.ordinal()];
            JVM INSTR tableswitch 1 1: default 28
        //                       1 29;
               goto _L1 _L2
_L1:
            return;
_L2:
            if (a.c())
            {
                class _cls1 extends ly
                {

                    final _cls1 a;

                    public void a()
                    {
                        jf.a(a.a);
                    }

                _cls1()
                {
                    a = _cls1.this;
                    super();
                }
                }

                js.a().b(new _cls1());
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        _cls1()
        {
            a = jf.this;
            super();
        }
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        private static final a g[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/flurry/sdk/jf$a, s1);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("NONE", 0);
            b = new a("ADVERTISING", 1);
            c = new a("DEVICE", 2);
            d = new a("HASHED_IMEI", 3);
            e = new a("REPORTED_IDS", 4);
            f = new a("FINISHED", 5);
            g = (new a[] {
                a, b, c, d, e, f
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class _cls2 extends ly
    {

        final jf a;

        public void a()
        {
            jf.b(a);
        }

        _cls2()
        {
            a = jf.this;
            super();
        }
    }


    private class _cls4
    {

        static final int a[];
        static final int b[];

        static 
        {
            b = new int[a.values().length];
            try
            {
                b[a.a.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                b[a.b.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                b[a.c.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                b[a.d.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                b[a.e.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            a = new int[lg.a.values().length];
            try
            {
                a[lg.a.a.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls3
        implements FilenameFilter
    {

        final jf a;

        public boolean accept(File file, String s1)
        {
            return s1.startsWith(".flurryagent.");
        }

        _cls3()
        {
            a = jf.this;
            super();
        }
    }

}
