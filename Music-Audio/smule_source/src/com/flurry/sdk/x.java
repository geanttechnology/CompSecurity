// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapResponseInfo;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

// Referenced classes of package com.flurry.sdk:
//            fz, ap, hp, gd, 
//            az, fp, fy, ab, 
//            fx, ay, hq, i, 
//            aa

public class x
{

    private static final String a = com/flurry/sdk/x.getSimpleName();
    private final fy b = new fy() {

        final x a;

        public void a(ab ab1)
        {
            if (ab.a.e.equals(ab1.a))
            {
                a.d();
            }
        }

        public void notify(fx fx)
        {
            a((ab)fx);
        }

            
            {
                a = x.this;
                super();
            }
    };
    private final fy c = new fy() {

        final x a;

        public void a(ay ay1)
        {
            a.a(ay1.a);
        }

        public void notify(fx fx)
        {
            a((ay)fx);
        }

            
            {
                a = x.this;
                super();
            }
    };
    private final TreeSet d = new TreeSet();
    private final String e;

    public x(String s)
    {
        e = s;
        fz.a().a("com.flurry.android.sdk.AssetCacheManagerStatusEvent", b);
        fz.a().a("com.flurry.android.impl.ads.FreqCapEvent", c);
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ap ap1 = (ap)iterator.next();
            if (!hp.a(ap1.a().expiration))
            {
                gd.a(3, a, (new StringBuilder()).append("Removed expired ad unit -- adspace: ").append(ap1.p()).toString());
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_85;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        d.clear();
        fz.a().a(b);
        fz.a().a(c);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(az az1)
    {
        this;
        JVM INSTR monitorenter ;
        if (az1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = d.iterator();
_L4:
        ap ap1;
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            ap1 = (ap)iterator.next();
            obj = ap1.a().frequencyCapResponseInfoList;
        } while (obj == null);
        obj = ((List) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            FrequencyCapResponseInfo frequencycapresponseinfo = (FrequencyCapResponseInfo)((Iterator) (obj)).next();
            if (az1.b().equals(frequencycapresponseinfo.capType) && az1.c().equals(frequencycapresponseinfo.id))
            {
                gd.a(3, a, (new StringBuilder()).append("Removed frequency capped ad unit -- adspace: ").append(ap1.p()).toString());
                iterator.remove();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        az1;
        throw az1;
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = d.iterator();
        while (iterator.hasNext()) 
        {
            ap ap1 = (ap)iterator.next();
            if (ap1.a().groupId.equals(s))
            {
                gd.a(3, a, (new StringBuilder()).append("Removed grouped ad unit -- adspace: ").append(ap1.p()).toString());
                iterator.remove();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public void a(Collection collection)
    {
        this;
        JVM INSTR monitorenter ;
        if (collection != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d.addAll(collection);
        if (true) goto _L1; else goto _L3
_L3:
        collection;
        throw collection;
    }

    public int b()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        e();
        i = d.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public List c()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Object obj;
        arraylist = new ArrayList();
        obj = (ap)d.pollFirst();
        if (obj == null) goto _L2; else goto _L1
_L1:
        arraylist.add(obj);
        obj = ((ap) (obj)).a().groupId;
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L3
_L3:
        Iterator iterator = d.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L4
_L4:
        ap ap1;
        boolean flag;
        ap1 = (ap)iterator.next();
        flag = ((String) (obj)).equals(ap1.a().groupId);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_99;
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        arraylist.add(ap1);
        iterator.remove();
          goto _L5
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(d);
        fp.a().b(new hq(arraylist) {

            final List a;
            final x b;

            public void safeRun()
            {
                i.a().l().a(a);
            }

            
            {
                b = x.this;
                a = list;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
