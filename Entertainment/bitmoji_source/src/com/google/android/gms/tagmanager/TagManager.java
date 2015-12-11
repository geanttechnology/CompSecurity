// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.google.android.gms.tagmanager:
//            DataLayer, d, r, n, 
//            bh, v, ce, o

public class TagManager
{
    static interface a
    {

        public abstract o a(Context context, TagManager tagmanager, Looper looper, String s, int i, r r1);
    }


    private static TagManager XB;
    private final DataLayer TN;
    private final r Wj;
    private final ConcurrentMap XA;
    private final a Xz;
    private final Context mContext;

    TagManager(Context context, a a1, DataLayer datalayer)
    {
        if (context == null)
        {
            throw new NullPointerException("context cannot be null");
        } else
        {
            mContext = context.getApplicationContext();
            Xz = a1;
            XA = new ConcurrentHashMap();
            TN = datalayer;
            TN.a(new DataLayer.b() {

                final TagManager XC;

                public void v(Map map)
                {
                    map = ((Map) (map.get("event")));
                    if (map != null)
                    {
                        TagManager.a(XC, map.toString());
                    }
                }

            
            {
                XC = TagManager.this;
                super();
            }
            });
            TN.a(new d(mContext));
            Wj = new r();
            return;
        }
    }

    static void a(TagManager tagmanager, String s)
    {
        tagmanager.bE(s);
    }

    private void bE(String s)
    {
        for (Iterator iterator = XA.keySet().iterator(); iterator.hasNext(); ((n)iterator.next()).ba(s)) { }
    }

    public static TagManager getInstance(Context context)
    {
        com/google/android/gms/tagmanager/TagManager;
        JVM INSTR monitorenter ;
        if (XB != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        bh.t("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
        context;
        com/google/android/gms/tagmanager/TagManager;
        JVM INSTR monitorexit ;
        throw context;
        XB = new TagManager(context, new a() {

            public o a(Context context1, TagManager tagmanager, Looper looper, String s, int i, r r1)
            {
                return new o(context1, tagmanager, looper, s, i, r1);
            }

        }, new DataLayer(new v(context)));
        context = XB;
        com/google/android/gms/tagmanager/TagManager;
        JVM INSTR monitorexit ;
        return context;
    }

    void a(n n1)
    {
        XA.put(n1, Boolean.valueOf(true));
    }

    boolean b(n n1)
    {
        return XA.remove(n1) != null;
    }

    boolean f(Uri uri)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = ce.ju();
        if (!((ce) (obj)).f(uri)) goto _L2; else goto _L1
_L1:
        int i;
        uri = ((ce) (obj)).getContainerId();
        static class _cls3
        {

            static final int XD[];

            static 
            {
                XD = new int[ce.a.values().length];
                try
                {
                    XD[ce.a.VW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    XD[ce.a.VX.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    XD[ce.a.VY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        i = _cls3.XD[((ce) (obj)).jv().ordinal()];
        i;
        JVM INSTR tableswitch 1 3: default 60
    //                   1 68
    //                   2 130
    //                   3 130;
           goto _L3 _L4 _L5 _L5
_L3:
        boolean flag = true;
_L9:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        obj = XA.keySet().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            n n1 = (n)((Iterator) (obj)).next();
            if (n1.getContainerId().equals(uri))
            {
                n1.bc(null);
                n1.refresh();
            }
        }
          goto _L3
        uri;
        throw uri;
_L5:
        Iterator iterator = XA.keySet().iterator();
_L7:
        n n2;
        while (iterator.hasNext()) 
        {
            n2 = (n)iterator.next();
            if (!n2.getContainerId().equals(uri))
            {
                continue; /* Loop/switch isn't completed */
            }
            n2.bc(((ce) (obj)).jw());
            n2.refresh();
        }
          goto _L3
        if (n2.iF() == null) goto _L7; else goto _L6
_L6:
        n2.bc(null);
        n2.refresh();
        if (true) goto _L7; else goto _L8
_L8:
          goto _L3
_L2:
        flag = false;
          goto _L9
    }

    public DataLayer getDataLayer()
    {
        return TN;
    }

    public PendingResult loadContainerDefaultOnly(String s, int i)
    {
        s = Xz.a(mContext, this, null, s, i, Wj);
        s.iI();
        return s;
    }

    public PendingResult loadContainerDefaultOnly(String s, int i, Handler handler)
    {
        s = Xz.a(mContext, this, handler.getLooper(), s, i, Wj);
        s.iI();
        return s;
    }

    public PendingResult loadContainerPreferFresh(String s, int i)
    {
        s = Xz.a(mContext, this, null, s, i, Wj);
        s.iK();
        return s;
    }

    public PendingResult loadContainerPreferFresh(String s, int i, Handler handler)
    {
        s = Xz.a(mContext, this, handler.getLooper(), s, i, Wj);
        s.iK();
        return s;
    }

    public PendingResult loadContainerPreferNonDefault(String s, int i)
    {
        s = Xz.a(mContext, this, null, s, i, Wj);
        s.iJ();
        return s;
    }

    public PendingResult loadContainerPreferNonDefault(String s, int i, Handler handler)
    {
        s = Xz.a(mContext, this, handler.getLooper(), s, i, Wj);
        s.iJ();
        return s;
    }

    public void setVerboseLoggingEnabled(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 5;
        }
        bh.setLogLevel(byte0);
    }
}
