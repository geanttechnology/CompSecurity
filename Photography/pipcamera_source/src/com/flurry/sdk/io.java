// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.CRC32;

// Referenced classes of package com.flurry.sdk:
//            jz, js, lk, ll, 
//            kg, lt, ip, in, 
//            jl, kn, kx, jq, 
//            jo, jt, jf, hu, 
//            jn, ih, le, la, 
//            lb

public class io
{

    private static final String b = com/flurry/sdk/io.getName();
    private static io c = null;
    private String a;
    private jz d;
    private List e;
    private boolean f;

    private io()
    {
    }

    public static io a()
    {
        com/flurry/sdk/io;
        JVM INSTR monitorenter ;
        io io1;
        if (c == null)
        {
            c = new io();
            c.e();
        }
        io1 = c;
        com/flurry/sdk/io;
        JVM INSTR monitorexit ;
        return io1;
        Exception exception;
        exception;
        throw exception;
    }

    static List a(io io1)
    {
        return io1.e;
    }

    static jz b(io io1)
    {
        return io1.d;
    }

    static String d()
    {
        return b;
    }

    private void e()
    {
        d = new jz(js.a().c().getFileStreamPath(f()), ".yflurrypulselogging.", 1, new le() {

            final io a;

            public lb a(int i)
            {
                return new la(new ip.a());
            }

            
            {
                a = io.this;
                super();
            }
        });
        f = ((Boolean)lk.a().a("UseHttps")).booleanValue();
        kg.a(4, b, (new StringBuilder()).append("initSettings, UseHttps = ").append(f).toString());
        e = (List)d.a();
        if (e == null)
        {
            e = new ArrayList();
        }
    }

    private String f()
    {
        return (new StringBuilder()).append(".yflurrypulselogging.").append(Long.toString(lt.i(js.a().d()), 16)).toString();
    }

    private String g()
    {
        if (a != null)
        {
            return a;
        }
        if (f)
        {
            return "https://data.flurry.com/pcr.do";
        } else
        {
            return "https://data.flurry.com/pcr.do";
        }
    }

    public void a(in in1)
    {
        this;
        JVM INSTR monitorenter ;
        in1 = new ip(in1.h());
        e.add(in1);
        kg.a(4, b, "Saving persistent Pulse logging data.");
        d.a(e);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        in1;
        kg.a(6, b, "Error when generating pulse log report in addReport part");
        if (true) goto _L2; else goto _L1
_L1:
        in1;
        throw in1;
    }

    public void a(String s)
    {
        if (s != null && !s.endsWith(".do"))
        {
            kg.a(5, b, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        a = s;
    }

    public void a(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (jl.a().c()) goto _L2; else goto _L1
_L1:
        kg.a(5, b, "Reports were not sent! No Internet connection!");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        if (abyte0.length != 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        kg.a(3, b, "No report need be sent");
          goto _L3
        abyte0;
        throw abyte0;
        String s = g();
        kg.a(4, b, (new StringBuilder()).append("PulseLoggingManager: start upload data ").append(Arrays.toString(abyte0)).append(" to ").append(s).toString());
        kn kn1 = new kn();
        kn1.a(s);
        kn1.d(0x186a0);
        kn1.a(kp.a.c);
        kn1.b(true);
        kn1.a("Content-Type", "application/octet-stream");
        kn1.a(new kx());
        kn1.a(abyte0);
        kn1.a(new kn.a() {

            final io a;

            public volatile void a(kn kn2, Object obj)
            {
                a(kn2, (Void)obj);
            }

            public void a(kn kn2, Void void1)
            {
                int i = kn2.h();
                if (i > 0)
                {
                    if (i >= 200 && i < 300)
                    {
                        kg.a(3, io.d(), (new StringBuilder()).append("Pulse logging report sent successfully HTTP response:").append(i).toString());
                        io.a(a).clear();
                        io.b(a).a(io.a(a));
                        return;
                    } else
                    {
                        kg.a(3, io.d(), (new StringBuilder()).append("Pulse logging report sent unsuccessfully, HTTP response:").append(i).toString());
                        return;
                    }
                } else
                {
                    kg.e(io.d(), (new StringBuilder()).append("Server Error: ").append(i).toString());
                    return;
                }
            }

            
            {
                a = io.this;
                super();
            }
        });
        jq.a().a(this, kn1);
          goto _L3
    }

    public byte[] b()
    {
        Object obj = null;
        Object obj1;
        Object obj2;
        obj2 = new ByteArrayOutputStream();
        obj1 = new DataOutputStream(((java.io.OutputStream) (obj2)));
        if (e != null && !e.isEmpty())
        {
            break MISSING_BLOCK_LABEL_49;
        }
        obj = ((ByteArrayOutputStream) (obj2)).toByteArray();
        lt.a(((java.io.Closeable) (obj1)));
        return ((byte []) (obj));
        Iterator iterator;
        ((DataOutputStream) (obj1)).writeShort(1);
        ((DataOutputStream) (obj1)).writeShort(1);
        ((DataOutputStream) (obj1)).writeLong(System.currentTimeMillis());
        ((DataOutputStream) (obj1)).writeUTF(js.a().d());
        ((DataOutputStream) (obj1)).writeUTF(jo.a().e());
        ((DataOutputStream) (obj1)).writeShort(jt.a());
        ((DataOutputStream) (obj1)).writeShort(3);
        ((DataOutputStream) (obj1)).writeUTF(jo.a().d());
        ((DataOutputStream) (obj1)).writeBoolean(jf.a().e());
        obj = new ArrayList();
        iterator = jf.a().h().entrySet().iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry;
        hu hu2;
        entry = (java.util.Map.Entry)iterator.next();
        hu2 = new hu();
        hu2.a = ((jn)entry.getKey()).d;
        if (!((jn)entry.getKey()).e) goto _L4; else goto _L3
_L3:
        hu2.b = new String((byte[])entry.getValue());
_L6:
        ((List) (obj)).add(hu2);
          goto _L5
        obj2;
        obj = obj1;
        obj1 = obj2;
_L8:
        kg.a(6, b, "Error when generating report", ((Throwable) (obj1)));
        throw obj1;
        obj2;
        obj1 = obj;
        obj = obj2;
_L7:
        lt.a(((java.io.Closeable) (obj1)));
        throw obj;
_L4:
        hu2.b = lt.b((byte[])entry.getValue());
          goto _L6
_L2:
        ((DataOutputStream) (obj1)).writeShort(((List) (obj)).size());
        byte abyte0[];
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((DataOutputStream) (obj1)).write(abyte0))
        {
            hu hu1 = (hu)((Iterator) (obj)).next();
            ((DataOutputStream) (obj1)).writeShort(hu1.a);
            abyte0 = hu1.b.getBytes();
            ((DataOutputStream) (obj1)).writeShort(abyte0.length);
        }

        ((DataOutputStream) (obj1)).writeShort(6);
        ((DataOutputStream) (obj1)).writeShort(ih.b.a());
        ((DataOutputStream) (obj1)).writeUTF(Build.MODEL);
        ((DataOutputStream) (obj1)).writeShort(ih.c.a());
        ((DataOutputStream) (obj1)).writeUTF(Build.BOARD);
        ((DataOutputStream) (obj1)).writeShort(ih.d.a());
        ((DataOutputStream) (obj1)).writeUTF(Build.ID);
        ((DataOutputStream) (obj1)).writeShort(ih.e.a());
        ((DataOutputStream) (obj1)).writeUTF(Build.DEVICE);
        ((DataOutputStream) (obj1)).writeShort(ih.f.a());
        ((DataOutputStream) (obj1)).writeUTF(Build.PRODUCT);
        ((DataOutputStream) (obj1)).writeShort(ih.g.a());
        ((DataOutputStream) (obj1)).writeUTF(android.os.Build.VERSION.RELEASE);
        ((DataOutputStream) (obj1)).writeShort(e.size());
        for (obj = e.iterator(); ((Iterator) (obj)).hasNext(); ((DataOutputStream) (obj1)).write(((ip)((Iterator) (obj)).next()).a())) { }
        obj = ((ByteArrayOutputStream) (obj2)).toByteArray();
        CRC32 crc32 = new CRC32();
        crc32.update(((byte []) (obj)));
        ((DataOutputStream) (obj1)).writeInt((int)crc32.getValue());
        obj = ((ByteArrayOutputStream) (obj2)).toByteArray();
        lt.a(((java.io.Closeable) (obj1)));
        return ((byte []) (obj));
        obj;
        obj1 = null;
          goto _L7
        obj1;
          goto _L8
        obj;
          goto _L7
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        a(b());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        kg.a(6, b, "Report not send due to exception in generate data");
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

}
