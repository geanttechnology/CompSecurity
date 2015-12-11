// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdSpaceLayout;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapResponseInfo;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapType;
import com.flurry.android.impl.ads.protocol.v13.NativeAdInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            aq, ar, ek, ax, 
//            ag, at, cy, dt

public final class ap
    implements Comparable
{

    private static int a;
    private final int b;
    private final AdUnit c;
    private final List d = new ArrayList();
    private final Map e = new HashMap();
    private final LinkedList f = new LinkedList();
    private int g;
    private boolean h;
    private boolean i;
    private String j;

    public ap(AdUnit adunit)
    {
        h = false;
        i = false;
        int i1 = a + 1;
        a = i1;
        b = i1;
        c = adunit;
        for (int j1 = 0; j1 < adunit.adFrames.size(); j1++)
        {
            d.add(new aq());
            String s1 = ((AdFrame)adunit.adFrames.get(j1)).adGuid;
            e.put(s1, new ar(s1));
        }

    }

    private boolean b(ek ek1)
    {
        if (f.size() > 0)
        {
            ek ek2 = (ek)f.peek();
            if (ek2 != null && ek2.equals(ek1))
            {
                return false;
            }
        }
        return true;
    }

    private String h(int i1)
    {
        AdFrame adframe = b(i1);
        if (adframe != null)
        {
            return adframe.adSpaceLayout.format;
        } else
        {
            return null;
        }
    }

    public int a(ap ap1)
    {
        if (ap1 == null)
        {
            throw new NullPointerException("another cannot be null");
        }
        if (b > ap1.b)
        {
            return 1;
        }
        return b >= ap1.b ? 0 : -1;
    }

    public AdUnit a()
    {
        return c;
    }

    public at a(String s1)
    {
        return ((ar)e.get(s1)).a();
    }

    public void a(int i1)
    {
        g = i1;
    }

    public void a(int i1, cy cy)
    {
        if (i1 < 0 || i1 > d.size())
        {
            return;
        } else
        {
            ((aq)d.get(i1)).a(cy);
            return;
        }
    }

    public void a(int i1, dt dt)
    {
        if (i1 < 0 || i1 > d.size())
        {
            return;
        } else
        {
            ((aq)d.get(i1)).a(dt);
            return;
        }
    }

    public void a(int i1, List list)
    {
        if (i1 < 0 || i1 > d.size())
        {
            return;
        } else
        {
            ((aq)d.get(i1)).a(list);
            return;
        }
    }

    public void a(dt dt)
    {
        a(g, dt);
    }

    public void a(ek ek1)
    {
        synchronized (f)
        {
            if (b(ek1))
            {
                f.push(ek1);
            }
        }
        return;
        ek1;
        linkedlist;
        JVM INSTR monitorexit ;
        throw ek1;
    }

    public void a(boolean flag)
    {
        h = flag;
    }

    public AdFrame b(int i1)
    {
        List list = c.adFrames;
        if (list != null && list.size() >= i1)
        {
            return (AdFrame)list.get(i1);
        } else
        {
            return null;
        }
    }

    public at b()
    {
        return a(e());
    }

    public void b(String s1)
    {
        j = s1;
    }

    public void b(boolean flag)
    {
        i = flag;
    }

    public int c()
    {
        return g;
    }

    public ax c(int i1)
    {
        ax aax[] = ax.values();
        int k1 = aax.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            ax ax1 = aax[j1];
            if (ax1.toString().equals(h(i1)))
            {
                return ax1;
            }
        }

        return ax.e;
    }

    public int compareTo(Object obj)
    {
        return a((ap)obj);
    }

    public ax d()
    {
        return c(c());
    }

    public cy d(int i1)
    {
        if (i1 < 0 || i1 > d.size())
        {
            return null;
        } else
        {
            return ((aq)d.get(i1)).a();
        }
    }

    public dt e(int i1)
    {
        if (i1 < 0 || i1 > d.size())
        {
            return null;
        } else
        {
            return ((aq)d.get(i1)).b();
        }
    }

    public String e()
    {
        return ((AdFrame)c.adFrames.get(g)).adGuid;
    }

    public FrequencyCapResponseInfo f()
    {
        Object obj = c.frequencyCapResponseInfoList;
        if (obj == null)
        {
            return null;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            FrequencyCapResponseInfo frequencycapresponseinfo = (FrequencyCapResponseInfo)((Iterator) (obj)).next();
            if (FrequencyCapType.STREAM.equals(frequencycapresponseinfo.capType))
            {
                return frequencycapresponseinfo;
            }
        }

        return null;
    }

    public List f(int i1)
    {
        if (i1 < 0 || i1 > d.size())
        {
            return Collections.emptyList();
        } else
        {
            return ((aq)d.get(i1)).c();
        }
    }

    public cy g()
    {
        return d(g);
    }

    public boolean g(int i1)
    {
        return !f(i1).isEmpty();
    }

    public NativeAdInfo h()
    {
        return c.nativeAdInfo;
    }

    public List i()
    {
        if (c.nativeAdInfo != null)
        {
            return c.nativeAdInfo.assets;
        } else
        {
            return Collections.emptyList();
        }
    }

    public AdFrame j()
    {
        if (c != null)
        {
            return b(g);
        } else
        {
            return null;
        }
    }

    public ax k()
    {
        if (c != null)
        {
            return c(g);
        } else
        {
            return ax.e;
        }
    }

    public boolean l()
    {
        return k().equals(ax.b);
    }

    public dt m()
    {
        return e(g);
    }

    public boolean n()
    {
        boolean flag1 = false;
        List list = c.adFrames;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < list.size())
                {
                    ag ag1 = ag.a(((AdFrame)list.get(i1)).cachingEnum);
                    if (!ag.b.equals(ag1) && !ag.c.equals(ag1) || !g(i1))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    public boolean o()
    {
        boolean flag1 = false;
        List list = c.adFrames;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < list.size())
                {
                    ag ag1 = ag.a(((AdFrame)list.get(i1)).cachingEnum);
                    if (!ag.b.equals(ag1) || !g(i1))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    public String p()
    {
        return c.adSpace;
    }

    public boolean q()
    {
        return h;
    }

    public boolean r()
    {
        return i;
    }

    public ek s()
    {
        this;
        JVM INSTR monitorenter ;
        LinkedList linkedlist = f;
        linkedlist;
        JVM INSTR monitorenter ;
        if (f.size() <= 0) goto _L2; else goto _L1
_L1:
        ek ek1 = (ek)f.pop();
_L4:
        this;
        JVM INSTR monitorexit ;
        return ek1;
_L2:
        ek1 = null;
        linkedlist;
        JVM INSTR monitorexit ;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        linkedlist;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ek t()
    {
        this;
        JVM INSTR monitorenter ;
        LinkedList linkedlist = f;
        linkedlist;
        JVM INSTR monitorenter ;
        if (f.size() <= 0) goto _L2; else goto _L1
_L1:
        ek ek1 = (ek)f.peek();
_L4:
        this;
        JVM INSTR monitorexit ;
        return ek1;
_L2:
        ek1 = null;
        linkedlist;
        JVM INSTR monitorexit ;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        linkedlist;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void u()
    {
        synchronized (f)
        {
            f.clear();
        }
        a(0);
        return;
        exception;
        linkedlist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String v()
    {
        return j;
    }
}
