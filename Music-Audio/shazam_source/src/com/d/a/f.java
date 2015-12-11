// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.DigestOutputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.d.a:
//            b, aj, p, o, 
//            ak, a, w, u, 
//            s, ai, g, h, 
//            v, e, y, aa, 
//            j, ah, t

public final class f
    implements LocationListener
{

    static final f a = new f();
    static String c;
    private static final String d[] = {
        "9774d56d682e549c", "dead00beef"
    };
    private static volatile String e = null;
    private static volatile String f = "http://data.flurry.com/aap.do";
    private static volatile String g = "https://data.flurry.com/aap.do";
    private static volatile String h = null;
    private static volatile String i = "http://ad.flurry.com/getCanvas.do";
    private static volatile String j = null;
    private static volatile String k = "http://ad.flurry.com/getAndroidApp.do";
    private static long l = 10000L;
    private static boolean m = true;
    private static boolean n = false;
    private static boolean o = false;
    private static boolean p = true;
    private static Criteria q = null;
    private static boolean r = false;
    private static b s = new b();
    private static AtomicInteger t = new AtomicInteger(0);
    private static AtomicInteger u = new AtomicInteger(0);
    private long A;
    private String B;
    private String C;
    private String D;
    private boolean E;
    private List F;
    private LocationManager G;
    private String H;
    private boolean I;
    private long J;
    private byte K[];
    private List L;
    private long M;
    private long N;
    private long O;
    private String P;
    private String Q;
    private byte R;
    private String S;
    private byte T;
    private Long U;
    private int V;
    private Location W;
    private Map X;
    private List Y;
    private boolean Z;
    private int aa;
    private List ab;
    private int ac;
    private aj ad;
    Map b;
    private final Handler v;
    private File w;
    private File x;
    private volatile boolean y;
    private volatile boolean z;

    private f()
    {
        x = null;
        y = false;
        z = false;
        b = new WeakHashMap();
        E = true;
        L = new ArrayList();
        P = "";
        Q = "";
        R = -1;
        S = "";
        T = -1;
        X = new HashMap();
        Y = new ArrayList();
        ab = new ArrayList();
        ad = new aj();
        HandlerThread handlerthread = new HandlerThread("FlurryAgent");
        handlerthread.start();
        v = new Handler(handlerthread.getLooper());
    }

    private static double a(double d1)
    {
        return (double)Math.round(d1 * 1000D) / 1000D;
    }

    static int a()
    {
        return u.incrementAndGet();
    }

    private static String a(String s1)
    {
        Object obj = s1;
        if (s1 != null)
        {
            obj = s1;
            if (s1.length() > 4)
            {
                obj = new StringBuilder();
                for (int i1 = 0; i1 < s1.length() - 4; i1++)
                {
                    ((StringBuilder) (obj)).append('*');
                }

                ((StringBuilder) (obj)).append(s1.substring(s1.length() - 4));
                obj = ((StringBuilder) (obj)).toString();
            }
        }
        return ((String) (obj));
    }

    private static HttpClient a(HttpParams httpparams)
    {
        Object obj;
        try
        {
            obj = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore) (obj)).load(null, null);
            obj = new p(((KeyStore) (obj)));
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
            obj = new DefaultHttpClient(new ThreadSafeClientConnManager(httpparams, schemeregistry), httpparams);
        }
        catch (Exception exception)
        {
            return new DefaultHttpClient(httpparams);
        }
        return ((HttpClient) (obj));
    }

    public static void a(Context context)
    {
        if (context == null)
        {
            throw new NullPointerException("Null context");
        }
        try
        {
            a.a(context, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.d.a.o.a("FlurryAgent", "", context);
        }
    }

    public static void a(Context context, String s1)
    {
        if (context == null)
        {
            throw new NullPointerException("Null context");
        }
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException("Api key not specified");
        }
        try
        {
            a.b(context, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.d.a.o.a("FlurryAgent", "", context);
        }
    }

    static void a(f f1, Context context)
    {
        f1.b(context);
    }

    static void a(f f1, Context context, boolean flag)
    {
        Location location;
        location = null;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        location = f1.e(context);
        f1;
        JVM INSTR monitorenter ;
        f1.W = location;
        f1;
        JVM INSTR monitorexit ;
        try
        {
            if (r)
            {
                f1.ad.a();
            }
            f1.K = f(context);
            (new StringBuilder("Fetching IMEI: ")).append(f1.K);
            f1.c(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            com.d.a.o.a("FlurryAgent", "", f1);
        }
        break MISSING_BLOCK_LABEL_81;
        context;
        f1;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void a(DataInputStream datainputstream)
    {
        HashMap hashmap;
        HashMap hashmap1;
        HashMap hashmap2;
        HashMap hashmap3;
        HashMap hashmap4;
        HashMap hashmap5;
        hashmap = new HashMap();
        hashmap1 = new HashMap();
        hashmap2 = new HashMap();
        hashmap3 = new HashMap();
        hashmap4 = new HashMap();
        hashmap5 = new HashMap();
_L19:
        int i1;
        int j1;
        j1 = datainputstream.readUnsignedShort();
        i1 = datainputstream.readInt();
        j1;
        JVM INSTR tableswitch 258 273: default 148
    //                   258 197
    //                   259 205
    //                   260 148
    //                   261 148
    //                   262 269
    //                   263 319
    //                   264 155
    //                   265 148
    //                   266 391
    //                   267 148
    //                   268 493
    //                   269 616
    //                   270 381
    //                   271 441
    //                   272 544
    //                   273 626;
           goto _L1 _L2 _L3 _L1 _L1 _L4 _L5 _L6 _L1 _L7 _L1 _L8 _L9 _L10 _L11 _L12 _L13
_L6:
        break; /* Loop/switch isn't completed */
_L1:
        datainputstream.skipBytes(i1);
_L17:
        if (j1 == 264)
        {
            if (r)
            {
                hashmap.isEmpty();
                ad.a(hashmap, hashmap3, hashmap4, hashmap1, hashmap2, hashmap5);
            }
            return;
        }
          goto _L14
_L2:
        datainputstream.readInt();
          goto _L15
_L3:
        byte byte0 = datainputstream.readByte();
        int k1 = datainputstream.readUnsignedShort();
        ak aak[] = new ak[k1];
        for (i1 = 0; i1 < k1; i1++)
        {
            aak[i1] = new ak(datainputstream);
        }

        hashmap.put(Byte.valueOf(byte0), aak);
          goto _L15
_L4:
        int l1 = datainputstream.readUnsignedShort();
        i1 = 0;
        while (i1 < l1) 
        {
            a a1 = new a(datainputstream);
            hashmap1.put(Long.valueOf(a1.a), a1);
            i1++;
        }
          goto _L15
_L5:
        int i2 = datainputstream.readInt();
        i1 = 0;
        while (i1 < i2) 
        {
            w w1 = new w(datainputstream);
            hashmap3.put(w1.a, w1);
            (new StringBuilder("Parsed hook: ")).append(w1);
            i1++;
        }
          goto _L15
_L10:
        datainputstream.skipBytes(i1);
          goto _L15
_L7:
        byte byte1 = datainputstream.readByte();
        i1 = 0;
        while (i1 < byte1) 
        {
            u u1 = new u(datainputstream);
            hashmap4.put(Byte.valueOf(u1.a), u1);
            i1++;
        }
          goto _L15
_L11:
        byte byte2 = datainputstream.readByte();
        i1 = 0;
        while (i1 < byte2) 
        {
            u u2 = (u)hashmap4.get(Byte.valueOf(datainputstream.readByte()));
            if (u2 != null)
            {
                u2.b(datainputstream);
            }
            i1++;
        }
          goto _L15
_L8:
        int j2 = datainputstream.readInt();
        i1 = 0;
        while (i1 < j2) 
        {
            long l2 = datainputstream.readLong();
            hashmap5.put(Short.valueOf(datainputstream.readShort()), Long.valueOf(l2));
            i1++;
        }
          goto _L15
_L12:
        long l3 = datainputstream.readLong();
        s s2 = (s)hashmap2.get(Long.valueOf(l3));
        s s1 = s2;
        if (s2 == null)
        {
            s1 = new s();
        }
        s1.a = datainputstream.readUTF();
        s1.c = datainputstream.readInt();
        hashmap2.put(Long.valueOf(l3), s1);
          goto _L15
_L9:
        datainputstream.skipBytes(i1);
          goto _L15
_L13:
        datainputstream.skipBytes(i1);
_L15:
        if (true) goto _L17; else goto _L16
_L16:
_L14:
        if (true) goto _L19; else goto _L18
_L18:
    }

    private void a(Runnable runnable)
    {
        v.post(runnable);
    }

    public static void a(boolean flag)
    {
        synchronized (a)
        {
            a.E = flag;
        }
        return;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static boolean a(f f1)
    {
        return f1.z;
    }

    private static boolean a(File file)
    {
        file = file.getParentFile();
        if (!file.mkdirs() && !file.exists())
        {
            com.d.a.o.a("FlurryAgent", (new StringBuilder("Unable to create persistent dir: ")).append(file).toString());
            return false;
        } else
        {
            return true;
        }
    }

    private boolean a(byte abyte0[])
    {
        Object obj = f();
        if (obj != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        String s1;
        boolean flag;
        try
        {
            flag = a(abyte0, ((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            (new StringBuilder("Sending report exception: ")).append(((Exception) (obj)).getMessage());
            flag = false;
        }
        flag1 = flag;
        if (flag) goto _L4; else goto _L3
_L3:
        flag1 = flag;
        if (e != null) goto _L4; else goto _L5
_L5:
        flag1 = flag;
        if (!n) goto _L4; else goto _L6
_L6:
        flag1 = flag;
        if (o) goto _L4; else goto _L7
_L7:
        obj = a;
        obj;
        JVM INSTR monitorenter ;
        o = true;
        s1 = f();
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        obj;
        JVM INSTR monitorexit ;
        boolean flag2;
        try
        {
            flag2 = a(abyte0, s1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return flag;
        }
        return flag2;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    private boolean a(byte abyte0[], String s1)
    {
        boolean flag1;
        flag1 = true;
        if ("local".equals(s1))
        {
            return true;
        }
        abyte0 = new ByteArrayEntity(abyte0);
        abyte0.setContentType("application/octet-stream");
        s1 = new HttpPost(s1);
        s1.setEntity(abyte0);
        abyte0 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(abyte0, 10000);
        HttpConnectionParams.setSoTimeout(abyte0, 15000);
        s1.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        abyte0 = a(((HttpParams) (abyte0))).execute(s1);
        int i1 = abyte0.getStatusLine().getStatusCode();
        this;
        JVM INSTR monitorenter ;
        if (i1 != 200) goto _L2; else goto _L1
_L1:
        I = true;
        L.removeAll(F);
        abyte0 = abyte0.getEntity();
        boolean flag;
        flag = flag1;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        long l1 = abyte0.getContentLength();
        flag = flag1;
        if (l1 == 0L)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        a(new DataInputStream(abyte0.getContent()));
        abyte0.consumeContent();
        flag = flag1;
_L4:
        F = null;
        this;
        JVM INSTR monitorexit ;
        return flag;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        s1;
        abyte0.consumeContent();
        throw s1;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static f b()
    {
        return a;
    }

    private void b(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        H = c(context);
        if (!x.exists()) goto _L2; else goto _L1
_L1:
        (new StringBuilder("loading persistent data: ")).append(x.getAbsolutePath());
        DataInputStream datainputstream1 = new DataInputStream(new FileInputStream(x));
        DataInputStream datainputstream = datainputstream1;
        if (datainputstream1.readUnsignedShort() != 46586)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        datainputstream = datainputstream1;
        b(datainputstream1);
        ai.a(datainputstream1);
_L3:
        if (!z && !x.delete())
        {
            com.d.a.o.a("FlurryAgent", "Cannot delete persistence file");
        }
_L2:
        if (!z)
        {
            I = false;
            J = M;
            z = true;
        }
        if (H == null)
        {
            long l1 = Double.doubleToLongBits(Math.random());
            long l2 = System.nanoTime();
            long l3 = B.hashCode() * 37;
            H = (new StringBuilder("ID")).append(Long.toString(l1 + 37L * (l2 + l3), 16)).toString();
        }
        ad.d = H;
        if (!H.startsWith("AND") && !w.exists())
        {
            c(context, H);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Throwable throwable1;
        throwable1;
        datainputstream1 = null;
_L5:
        datainputstream = datainputstream1;
        com.d.a.o.a("FlurryAgent", "Error when loading persistent file", throwable1);
        ai.a(datainputstream1);
          goto _L3
        context;
        throw context;
        context;
        datainputstream = null;
_L4:
        ai.a(datainputstream);
        throw context;
        Throwable throwable;
        throwable;
        com.d.a.o.a("FlurryAgent", "", throwable);
          goto _L2
        context;
          goto _L4
        throwable1;
          goto _L5
    }

    private void b(Context context, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (B != null && !B.equals(s1))
        {
            com.d.a.o.a("FlurryAgent", (new StringBuilder("onStartSession called with different api keys: ")).append(B).append(" and ").append(s1).toString());
        }
        b.put(context, context);
        if (y) goto _L2; else goto _L1
_L1:
        Context context1;
        long l1;
        t.set(0);
        u.set(0);
        B = s1;
        x = context.getFileStreamPath((new StringBuilder(".flurryagent.")).append(Integer.toString(B.hashCode(), 16)).toString());
        w = context.getFileStreamPath(".flurryb.");
        if (p)
        {
            Thread.setDefaultUncaughtExceptionHandler(new g());
        }
        context1 = context.getApplicationContext();
        if (D == null)
        {
            D = d(context1);
        }
        s1 = context1.getPackageName();
        if (C != null && !C.equals(s1))
        {
            com.d.a.o.a("FlurryAgent", (new StringBuilder("onStartSession called from different application packages: ")).append(C).append(" and ").append(s1).toString());
        }
        C = s1;
        l1 = SystemClock.elapsedRealtime();
        if (l1 - A <= l) goto _L4; else goto _L3
_L3:
        M = System.currentTimeMillis();
        N = l1;
        O = -1L;
        S = "";
        V = 0;
        W = null;
        Q = TimeZone.getDefault().getID();
        P = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("_").append(Locale.getDefault().getCountry()).toString();
        X = new HashMap();
        Y = new ArrayList();
        Z = true;
        ab = new ArrayList();
        aa = 0;
        ac = 0;
        if (!r) goto _L6; else goto _L5
_L5:
        if (ad.c) goto _L8; else goto _L7
_L7:
        h h1;
        h1 = new h();
        h1.a = B;
        h1.b = J;
        if (h == null) goto _L10; else goto _L9
_L9:
        s1 = h;
_L13:
        h1.c = s1;
        if (j == null) goto _L12; else goto _L11
_L11:
        s1 = j;
_L14:
        h1.d = s1;
        h1.e = v;
        ad.a(context, h1);
_L8:
        ad.a(M, N);
_L6:
        a(new v(this, context1, E));
_L16:
        y = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L10:
        s1 = i;
          goto _L13
_L12:
        s1 = k;
          goto _L14
_L4:
        if (L.isEmpty()) goto _L16; else goto _L15
_L15:
        L.remove(L.size() - 1);
          goto _L16
        context;
        throw context;
          goto _L13
    }

    static void b(f f1)
    {
        f1.e();
    }

    private void b(DataInputStream datainputstream)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        int j1 = datainputstream.readUnsignedShort();
        if (j1 <= 2)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        com.d.a.o.a("FlurryAgent", (new StringBuilder("Unknown agent file version: ")).append(j1).toString());
        throw new IOException((new StringBuilder("Unknown agent file version: ")).append(j1).toString());
        datainputstream;
        this;
        JVM INSTR monitorexit ;
        throw datainputstream;
        if (j1 < 2)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        Object obj;
        obj = datainputstream.readUTF();
        (new StringBuilder("Loading API key: ")).append(a(B));
        if (!((String) (obj)).equals(B))
        {
            break MISSING_BLOCK_LABEL_202;
        }
        H = datainputstream.readUTF();
        I = datainputstream.readBoolean();
        J = datainputstream.readLong();
_L1:
        j1 = datainputstream.readUnsignedShort();
        if (j1 == 0)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        obj = new byte[j1];
        datainputstream.readFully(((byte []) (obj)));
        L.add(0, obj);
        obj = new StringBuilder("Session report added: ");
        i1++;
        ((StringBuilder) (obj)).append(i1);
          goto _L1
        z = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        (new StringBuilder("Api keys do not match, old: ")).append(a(((String) (obj)))).append(", new: ").append(a(B));
          goto _L2
    }

    private byte[] b(boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        Object obj2;
        ByteArrayOutputStream bytearrayoutputstream;
        DigestOutputStream digestoutputstream;
        obj2 = new e();
        bytearrayoutputstream = new ByteArrayOutputStream();
        digestoutputstream = new DigestOutputStream(bytearrayoutputstream, ((java.security.MessageDigest) (obj2)));
        obj1 = new DataOutputStream(digestoutputstream);
        Object obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(22);
        obj = obj1;
        if (!r || !flag) goto _L2; else goto _L1
_L1:
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(1);
_L7:
        obj = obj1;
        if (!r) goto _L4; else goto _L3
_L3:
        obj = obj1;
        ((DataOutputStream) (obj1)).writeLong(ad.c());
        obj = obj1;
        Object obj3 = ad.d();
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(((Set) (obj3)).size());
        obj = obj1;
        obj3 = ((Set) (obj3)).iterator();
_L6:
        obj = obj1;
        if (!((Iterator) (obj3)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        long l1 = ((Long)((Iterator) (obj3)).next()).longValue();
        obj = obj1;
        ((DataOutputStream) (obj1)).writeByte(1);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeLong(l1);
        if (true) goto _L6; else goto _L5
        obj2;
_L12:
        obj = obj1;
        com.d.a.o.a("FlurryAgent", "Error when generating report", ((Throwable) (obj2)));
        ai.a(((java.io.Closeable) (obj1)));
        obj = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return ((byte []) (obj));
_L2:
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(0);
          goto _L7
        obj2;
        obj1 = obj;
        obj = obj2;
_L11:
        ai.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        obj = obj1;
        ((DataOutputStream) (obj1)).writeLong(0L);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(0);
_L5:
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(3);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(122);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeLong(System.currentTimeMillis());
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(B);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(D);
        obj = obj1;
        int i1;
        int j1;
        if (K == null)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(i1);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(0);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(H);
        if (i1 <= 1)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(5);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(K.length);
        obj = obj1;
        ((DataOutputStream) (obj1)).write(K);
        obj = obj1;
        (new StringBuilder("Sent IMEI: ")).append(Arrays.toString(K));
        obj = obj1;
        ((DataOutputStream) (obj1)).write(0);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeLong(J);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeLong(M);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(6);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF("device.model");
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(Build.MODEL);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF("build.brand");
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(Build.BRAND);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF("build.id");
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(Build.ID);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF("version.release");
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(android.os.Build.VERSION.RELEASE);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF("build.device");
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(Build.DEVICE);
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF("build.product");
        obj = obj1;
        ((DataOutputStream) (obj1)).writeUTF(Build.PRODUCT);
        obj = obj1;
        j1 = L.size();
        obj = obj1;
        ((DataOutputStream) (obj1)).writeShort(j1);
        i1 = ((flag1) ? 1 : 0);
_L9:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        ((DataOutputStream) (obj1)).write((byte[])L.get(i1));
        i1++;
        if (true) goto _L9; else goto _L8
_L8:
        obj = obj1;
        F = new ArrayList(L);
        obj = obj1;
        digestoutputstream.on(false);
        obj = obj1;
        ((DataOutputStream) (obj1)).write(((e) (obj2)).a());
        obj = obj1;
        ((DataOutputStream) (obj1)).close();
        obj = obj1;
        obj2 = bytearrayoutputstream.toByteArray();
        obj = obj2;
        ai.a(((java.io.Closeable) (obj1)));
          goto _L10
        obj;
        obj1 = null;
          goto _L11
        obj2;
        obj1 = null;
          goto _L12
    }

    static long c()
    {
        return l;
    }

    private String c(Context context)
    {
        Object obj;
        boolean flag1;
        obj = null;
        flag1 = false;
        if (H == null) goto _L2; else goto _L1
_L1:
        context = H;
_L10:
        return context;
_L2:
        Object obj1;
        boolean flag;
        obj1 = android.provider.Settings.System.getString(context.getContentResolver(), "android_id");
        flag = flag1;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (((String) (obj1)).length() <= 0) goto _L4; else goto _L5
_L5:
        if (!((String) (obj1)).equals("null")) goto _L7; else goto _L6
_L6:
        flag = flag1;
_L4:
        if (flag)
        {
            return (new StringBuilder("AND")).append(((String) (obj1))).toString();
        }
        break; /* Loop/switch isn't completed */
_L7:
        String as[] = d;
        int j1 = as.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            flag = flag1;
            if (((String) (obj1)).equals(as[i1]))
            {
                continue; /* Loop/switch isn't completed */
            }
        }

        flag = true;
        if (true) goto _L4; else goto _L8
_L8:
        obj1 = context.getFileStreamPath(".flurryb.");
        context = ((Context) (obj));
        if (!((File) (obj1)).exists()) goto _L10; else goto _L9
_L9:
        obj = new DataInputStream(new FileInputStream(((File) (obj1))));
        context = ((Context) (obj));
        ((DataInputStream) (obj)).readInt();
        context = ((Context) (obj));
        obj1 = ((DataInputStream) (obj)).readUTF();
        ai.a(((java.io.Closeable) (obj)));
        return ((String) (obj1));
        Object obj2;
        obj2;
        obj = null;
_L14:
        context = ((Context) (obj));
        com.d.a.o.a("FlurryAgent", "Error when loading b file", ((Throwable) (obj2)));
        ai.a(((java.io.Closeable) (obj)));
        return null;
        context;
        obj2 = null;
        obj = context;
_L12:
        ai.a(((java.io.Closeable) (obj2)));
        throw obj;
        obj;
        obj2 = context;
        if (true) goto _L12; else goto _L11
_L11:
        obj2;
        if (true) goto _L14; else goto _L13
_L13:
    }

    private void c(Context context, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        w = context.getFileStreamPath(".flurryb.");
        flag = a(w);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(w));
        context = dataoutputstream;
        dataoutputstream.writeInt(1);
        context = dataoutputstream;
        dataoutputstream.writeUTF(s1);
        ai.a(dataoutputstream);
          goto _L1
        context;
        throw context;
        Throwable throwable;
        throwable;
        s1 = null;
_L4:
        context = s1;
        com.d.a.o.a("FlurryAgent", "Error when saving b file", throwable);
        ai.a(s1);
          goto _L1
_L3:
        ai.a(context);
        throw s1;
        s1;
          goto _L3
        throwable;
        s1 = dataoutputstream;
          goto _L4
        s1;
        context = null;
          goto _L3
    }

    static void c(f f1)
    {
        f1.g();
    }

    private void c(boolean flag)
    {
        byte abyte0[] = b(flag);
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        StringBuilder stringbuilder;
        if (!a(abyte0))
        {
            break MISSING_BLOCK_LABEL_75;
        }
        stringbuilder = new StringBuilder("Done sending ");
        String s1;
        if (y)
        {
            s1 = "initial ";
        } else
        {
            s1 = "";
        }
        try
        {
            stringbuilder.append(s1).append("agent report");
            g();
            return;
        }
        catch (IOException ioexception) { }
        catch (Throwable throwable)
        {
            com.d.a.o.a("FlurryAgent", "", throwable);
            return;
        }
    }

    private static String d(Context context)
    {
        context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        if (((PackageInfo) (context)).versionName != null)
        {
            return ((PackageInfo) (context)).versionName;
        }
        if (((PackageInfo) (context)).versionCode == 0)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        context = Integer.toString(((PackageInfo) (context)).versionCode);
        return context;
        context;
        com.d.a.o.a("FlurryAgent", "", context);
        return "Unknown";
    }

    static void d(f f1)
    {
        boolean flag1 = false;
        f1;
        JVM INSTR monitorenter ;
        long l1;
        long l2;
        l1 = SystemClock.elapsedRealtime();
        l2 = f1.A;
        boolean flag = flag1;
        if (f1.y)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        flag = flag1;
        if (l1 - l2 <= l)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        flag = flag1;
        if (f1.L.size() > 0)
        {
            flag = true;
        }
        f1;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        f1.c(false);
        return;
        Exception exception;
        exception;
        f1;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            com.d.a.o.a("FlurryAgent", "", f1);
        }
        return;
    }

    static boolean d()
    {
        return r;
    }

    private Location e(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        context = (LocationManager)context.getSystemService("location");
        this;
        JVM INSTR monitorenter ;
        if (G != null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        G = context;
_L1:
        this;
        JVM INSTR monitorexit ;
        Criteria criteria = q;
        Object obj = criteria;
        if (criteria == null)
        {
            obj = new Criteria();
        }
        obj = context.getBestProvider(((Criteria) (obj)), true);
        if (obj != null)
        {
            context.requestLocationUpdates(((String) (obj)), 0L, 0.0F, this, Looper.getMainLooper());
            return context.getLastKnownLocation(((String) (obj)));
        }
        break MISSING_BLOCK_LABEL_106;
        context = G;
          goto _L1
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
        return null;
    }

    static Handler e(f f1)
    {
        return f1.v;
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = null;
        Object obj1;
        Object obj2;
        obj2 = new ByteArrayOutputStream();
        obj1 = new DataOutputStream(((java.io.OutputStream) (obj2)));
        ((DataOutputStream) (obj1)).writeShort(1);
        ((DataOutputStream) (obj1)).writeUTF(D);
        ((DataOutputStream) (obj1)).writeLong(M);
        ((DataOutputStream) (obj1)).writeLong(O);
        ((DataOutputStream) (obj1)).writeLong(0L);
        ((DataOutputStream) (obj1)).writeUTF(P);
        ((DataOutputStream) (obj1)).writeUTF(Q);
        ((DataOutputStream) (obj1)).writeByte(R);
        if (S != null) goto _L2; else goto _L1
_L1:
        obj = "";
_L8:
        ((DataOutputStream) (obj1)).writeUTF(((String) (obj)));
        if (W != null) goto _L4; else goto _L3
_L3:
        ((DataOutputStream) (obj1)).writeBoolean(false);
_L9:
        ((DataOutputStream) (obj1)).writeInt(ac);
        ((DataOutputStream) (obj1)).writeByte(-1);
        ((DataOutputStream) (obj1)).writeByte(-1);
        ((DataOutputStream) (obj1)).writeByte(T);
        if (U != null) goto _L6; else goto _L5
_L5:
        ((DataOutputStream) (obj1)).writeBoolean(false);
_L10:
        ((DataOutputStream) (obj1)).writeShort(X.size());
        java.util.Map.Entry entry;
        for (obj = X.entrySet().iterator(); ((Iterator) (obj)).hasNext(); ((DataOutputStream) (obj1)).writeInt(((y)entry.getValue()).a))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            ((DataOutputStream) (obj1)).writeUTF((String)entry.getKey());
        }

          goto _L7
        obj2;
        obj = obj1;
        obj1 = obj2;
_L13:
        com.d.a.o.a("FlurryAgent", "", ((Throwable) (obj1)));
        ai.a(((java.io.Closeable) (obj)));
_L11:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = S;
          goto _L8
_L4:
        ((DataOutputStream) (obj1)).writeBoolean(true);
        ((DataOutputStream) (obj1)).writeDouble(a(W.getLatitude()));
        ((DataOutputStream) (obj1)).writeDouble(a(W.getLongitude()));
        ((DataOutputStream) (obj1)).writeFloat(W.getAccuracy());
          goto _L9
        obj;
_L12:
        ai.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L6:
        ((DataOutputStream) (obj1)).writeBoolean(true);
        ((DataOutputStream) (obj1)).writeLong(U.longValue());
          goto _L10
_L7:
        ((DataOutputStream) (obj1)).writeShort(Y.size());
        for (obj = Y.iterator(); ((Iterator) (obj)).hasNext(); ((DataOutputStream) (obj1)).write(((aa)((Iterator) (obj)).next()).a())) { }
        ((DataOutputStream) (obj1)).writeBoolean(Z);
        ((DataOutputStream) (obj1)).writeInt(V);
        ((DataOutputStream) (obj1)).writeShort(ab.size());
        j j1;
        for (obj = ab.iterator(); ((Iterator) (obj)).hasNext(); ((DataOutputStream) (obj1)).writeUTF(j1.e))
        {
            j1 = (j)((Iterator) (obj)).next();
            ((DataOutputStream) (obj1)).writeShort(j1.a);
            ((DataOutputStream) (obj1)).writeLong(j1.b);
            ((DataOutputStream) (obj1)).writeUTF(j1.c);
            ((DataOutputStream) (obj1)).writeUTF(j1.d);
        }

        if (r)
        {
            obj = ad.e();
            ((DataOutputStream) (obj1)).writeShort(((List) (obj)).size());
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((ah)((Iterator) (obj)).next()).a(((java.io.DataOutput) (obj1)))) { }
            break MISSING_BLOCK_LABEL_552;
        }
        ((DataOutputStream) (obj1)).writeShort(0);
        ((DataOutputStream) (obj1)).writeShort(0);
        L.add(((ByteArrayOutputStream) (obj2)).toByteArray());
        ai.a(((java.io.Closeable) (obj1)));
          goto _L11
        obj;
        obj1 = null;
          goto _L12
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
          goto _L12
        obj1;
          goto _L13
    }

    static aj f(f f1)
    {
        return f1.ad;
    }

    private static String f()
    {
        if (e != null)
        {
            return e;
        }
        if (o)
        {
            return f;
        }
        if (n)
        {
            return g;
        } else
        {
            return f;
        }
    }

    private static byte[] f(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        context = (TelephonyManager)context.getSystemService("phone");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        context = context.getDeviceId();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        context = ai.b(context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (context.length == 20)
        {
            return context;
        }
        try
        {
            com.d.a.o.a("FlurryAgent", (new StringBuilder("sha1 is not 20 bytes long: ")).append(Arrays.toString(context)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        return null;
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a(x);
        if (flag) goto _L2; else goto _L1
_L1:
        ai.a(null);
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(x));
        Object obj = dataoutputstream;
        dataoutputstream.writeShort(46586);
        obj = dataoutputstream;
        dataoutputstream.writeShort(2);
        obj = dataoutputstream;
        dataoutputstream.writeUTF(B);
        obj = dataoutputstream;
        dataoutputstream.writeUTF(H);
        obj = dataoutputstream;
        dataoutputstream.writeBoolean(I);
        obj = dataoutputstream;
        dataoutputstream.writeLong(J);
        obj = dataoutputstream;
        int i1 = L.size() - 1;
_L4:
        if (i1 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = dataoutputstream;
        byte abyte0[] = (byte[])L.get(i1);
        obj = dataoutputstream;
        int j1 = abyte0.length;
        obj = dataoutputstream;
        if (j1 + 2 + dataoutputstream.size() > 50000)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = dataoutputstream;
        dataoutputstream.writeShort(j1);
        obj = dataoutputstream;
        dataoutputstream.write(abyte0);
        i1--;
        if (true) goto _L4; else goto _L3
_L3:
        obj = dataoutputstream;
        dataoutputstream.writeShort(0);
        ai.a(dataoutputstream);
          goto _L5
        obj;
        throw obj;
        Throwable throwable;
        throwable;
        dataoutputstream = null;
_L7:
        obj = dataoutputstream;
        com.d.a.o.a("FlurryAgent", "", throwable);
        ai.a(dataoutputstream);
          goto _L5
_L6:
        Exception exception;
        ai.a(((java.io.Closeable) (obj)));
        throw exception;
        exception;
          goto _L6
        throwable;
          goto _L7
        exception;
        obj = null;
          goto _L6
    }

    private void h()
    {
        this;
        JVM INSTR monitorenter ;
        if (G != null)
        {
            G.removeUpdates(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(Context context, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        b.remove(context);
        if (!y || !b.isEmpty()) goto _L2; else goto _L1
_L1:
        h();
        if (context != null) goto _L4; else goto _L3
_L3:
        Context context1 = null;
_L6:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        context = context1.getPackageName();
        if (!C.equals(context))
        {
            com.d.a.o.a("FlurryAgent", (new StringBuilder("onEndSession called from different application package, expected: ")).append(C).append(" actual: ").append(context).toString());
        }
        long l1 = SystemClock.elapsedRealtime();
        A = l1;
        O = l1 - N;
        if (H == null)
        {
            com.d.a.o.a("FlurryAgent", "Not creating report because of bad Android ID or generated ID is null");
        }
        a(((Runnable) (new t(this, flag, context1))));
        y = false;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        context1 = context.getApplicationContext();
        if (true) goto _L6; else goto _L5
_L5:
        context;
        throw context;
    }

    final void a(String s1, String s2, String s3)
    {
        this;
        JVM INSTR monitorenter ;
        if (ab != null) goto _L2; else goto _L1
_L1:
        com.d.a.o.a("FlurryAgent", (new StringBuilder("onError called before onStartSession.  Error: ")).append(s1).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        V = V + 1;
        if (ab.size() < 10)
        {
            j j1 = new j();
            j1.b = System.currentTimeMillis();
            j1.c = ai.a(s1, 255);
            j1.d = ai.a(s2, 512);
            j1.e = ai.a(s3, 255);
            ab.add(j1);
            (new StringBuilder("Error logged: ")).append(j1.c);
        }
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public final void onLocationChanged(Location location)
    {
        this;
        JVM INSTR monitorenter ;
        W = location;
        h();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        location;
        com.d.a.o.a("FlurryAgent", "", location);
        if (true) goto _L2; else goto _L1
_L1:
        location;
        throw location;
    }

    public final void onProviderDisabled(String s1)
    {
    }

    public final void onProviderEnabled(String s1)
    {
    }

    public final void onStatusChanged(String s1, int i1, Bundle bundle)
    {
    }

}
