// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            AdUnit, AdFrame, bi, fl, 
//            FlurryAdSize, FlurryAds, bl, ca, 
//            AdSpaceLayout

final class aa
{

    private static String bm = com/flurry/android/aa.getSimpleName();
    private final Map bn = new HashMap();
    private bi bo;

    aa()
    {
    }

    private static boolean a(List list)
    {
        return list == null || list.size() == 0 || ((AdUnit)list.get(0)).getAdFrames().size() == 0 || ((AdFrame)((AdUnit)list.get(0)).getAdFrames().get(0)).getAdSpaceLayout() == null;
    }

    private boolean b(List list)
    {
        this;
        JVM INSTR monitorenter ;
        if (list == null) goto _L2; else goto _L1
_L1:
        if (list.size() >= 2) goto _L3; else goto _L2
_L2:
        if (bo == null) goto _L5; else goto _L4
_L4:
        boolean flag = bo.getStatus().equals(android.os.AsyncTask.Status.FINISHED);
        if (!flag) goto _L3; else goto _L5
_L5:
        flag = true;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        if (bo != null)
        {
            bo.getStatus().equals(android.os.AsyncTask.Status.FINISHED);
        }
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
        list;
        throw list;
    }

    private void c(Context context, String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        obj = Pair.create(s, Integer.valueOf(fl.u(context)));
        obj1 = (List)bn.get(obj);
        obj = FlurryAdSize.BANNER_BOTTOM;
        if (!a(((List) (obj1))))
        {
            obj = FlurryAdSize.a(((AdFrame)((AdUnit)((List) (obj1)).get(0)).getAdFrames().get(0)).getAdSpaceLayout());
        }
        if (!b(((List) (obj1)))) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder = (new StringBuilder()).append("Starting AsyncAdTask from EnsureCacheNotEmpty size: ");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        obj1 = Integer.toString(((List) (obj1)).size());
_L3:
        stringbuilder.append(((String) (obj1))).append(" wait: ").append(Integer.toString(0)).toString();
        obj1 = FlurryAds.getInstance();
        obj1.getClass();
        bo = new bi(((FlurryAds) (obj1)), context, s, ((FlurryAdSize) (obj)));
        bo.execute(new Void[0]);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        obj1 = "";
          goto _L3
        context;
        throw context;
    }

    final void a(Context context, String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        Pair pair;
        List list;
        pair = Pair.create(s, Integer.valueOf(fl.u(context)));
        list = (List)bn.get(pair);
        if (list == null) goto _L2; else goto _L1
_L1:
        if (i <= -1) goto _L4; else goto _L3
_L3:
        if (i <= list.size()) goto _L5; else goto _L4
_L4:
        bn.put(pair, new ArrayList());
_L2:
        c(context, s, 0);
        this;
        JVM INSTR monitorexit ;
        return;
_L5:
        if (i <= 0) goto _L2; else goto _L6
_L6:
        list.subList(0, i).clear();
        bn.put(pair, list);
          goto _L2
        context;
        throw context;
    }

    final void a(Context context, String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = Pair.create(s, Integer.valueOf(fl.u(context)));
        obj = (List)bn.get(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            if (((AdUnit)((Iterator) (obj)).next()).getGroupId().toString().equals(s1))
            {
                ((Iterator) (obj)).remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_93;
        context;
        throw context;
        c(context, s, 0);
        this;
        JVM INSTR monitorexit ;
    }

    final void a(Context context, List list)
    {
        Map map = bn;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator;
        int i;
        i = fl.u(context);
        (new StringBuilder()).append("putting ").append(list.size()).append(" orientation: ").append(i).toString();
        iterator = list.iterator();
_L1:
        AdUnit adunit;
        Pair pair;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_231;
        }
        adunit = (AdUnit)iterator.next();
        if (adunit.getIdHash().length() > 0)
        {
            context = new bl(adunit.getIdHash().toString(), adunit.getServeTime().longValue(), adunit.getExpirationTime().longValue(), adunit.getNewCap().intValue(), adunit.getPreviousCap().intValue(), adunit.getPreviousCapType().intValue());
            ca.aq().a(context);
        }
        pair = Pair.create(adunit.getAdSpace().toString(), Integer.valueOf(i));
        list = (List)bn.get(pair);
        context = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        context = new ArrayList();
        context.add(adunit);
        bn.put(pair, context);
          goto _L1
        context;
        map;
        JVM INSTR monitorexit ;
        throw context;
        map;
        JVM INSTR monitorexit ;
    }

    final AdUnit b(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        int i;
        i = fl.u(context);
        Pair pair = Pair.create(s, Integer.valueOf(i));
        list = (List)bn.get(pair);
        Object obj = list;
        if (!a(list)) goto _L2; else goto _L1
_L1:
        (new StringBuilder()).append("no valid ad units in cache for current orientation for ").append(s).toString();
        if (i == 1)
        {
            i = 2;
        } else
        {
            i = 1;
        }
        obj = new Pair(s, Integer.valueOf(i));
        list = (List)bn.get(obj);
        if (a(list)) goto _L4; else goto _L3
_L3:
        obj = list;
        if (((AdFrame)((AdUnit)list.get(0)).getAdFrames().get(0)).getAdSpaceLayout().getFormat().equals("takeover")) goto _L2; else goto _L4
_L4:
        (new StringBuilder()).append("no valid ad units in cache for other orientation for ").append(s).toString();
        context = null;
_L6:
        this;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (a(((List) (obj))))
        {
            break MISSING_BLOCK_LABEL_291;
        }
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_291;
            }
            obj = (AdUnit)iterator.next();
        } while (!fl.g(((AdUnit) (obj)).getExpiration().longValue()) || ((AdUnit) (obj)).getAdFrames().size() <= 0);
        iterator.remove();
        (new StringBuilder()).append("found valid ad unit for ").append(s).toString();
        c(context, s, 0);
        context = ((Context) (obj));
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
        (new StringBuilder()).append("no valid ad units for ").append(s).toString();
        c(context, s, 0);
        context = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    final List b(Context context, String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        obj = Pair.create(s, Integer.valueOf(fl.u(context)));
        obj1 = (List)bn.get(obj);
        obj = new ArrayList();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext() || ((List) (obj)).size() > i)
            {
                break;
            }
            AdUnit adunit = (AdUnit)((Iterator) (obj1)).next();
            if (fl.g(adunit.getExpiration().longValue()) && adunit.getCombinable().intValue() == 1 && adunit.getAdFrames().size() > 0)
            {
                ((List) (obj)).add(adunit);
                ((Iterator) (obj1)).remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_151;
        context;
        throw context;
        c(context, s, 0);
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    final boolean c(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        context = Pair.create(s, Integer.valueOf(fl.u(context)));
        context = (List)bn.get(context);
        if (a(context)) goto _L2; else goto _L1
_L1:
        context = context.iterator();
_L5:
        if (!context.hasNext()) goto _L2; else goto _L3
_L3:
        boolean flag = fl.g(((AdUnit)context.next()).getExpiration().longValue());
        if (!flag) goto _L5; else goto _L4
_L4:
        flag = true;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
        context;
        throw context;
    }

}
