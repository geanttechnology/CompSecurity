// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.util.Log;
import com.medialets.thrift.AdEvent;
import com.medialets.thrift.Event;
import com.medialets.thrift.MMAdEventBreadcrumb;
import com.medialets.thrift.MMAdEventURL;
import com.medialets.thrift.MMNumberData;
import com.medialets.thrift.MMStringData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.medialets.analytics:
//            e

public class MMEvent
{
    static final class a
    {

        private final String a;
        private final Date b;

        static String a(a a1)
        {
            return a1.a;
        }

        static Date b(a a1)
        {
            return a1.b;
        }

        public final String toString()
        {
            return a;
        }

        public a(String s, Date date)
        {
            a = s;
            b = date;
        }
    }


    Map a;
    Map b;
    Map c;
    private Map d;
    private List e;
    protected String mKey;
    protected String slotName;

    public MMEvent(String s)
    {
        mKey = s;
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        d = new HashMap();
        e = new ArrayList();
    }

    private List a()
    {
        ArrayList arraylist = new ArrayList(a.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); arraylist.add(new MMStringData((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return arraylist;
    }

    private List b()
    {
        ArrayList arraylist = new ArrayList(b.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = b.entrySet().iterator(); iterator.hasNext(); arraylist.add(new MMNumberData((String)entry.getKey(), ((Double)entry.getValue()).doubleValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return arraylist;
    }

    private void b(AdEvent adevent)
    {
        ArrayList arraylist = new ArrayList();
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Iterator iterator = e.iterator();
        MMAdEventBreadcrumb mmadeventbreadcrumb = null;
        long l = 0L;
        Date date = null;
        int i = 1;
        do
        {
            while (iterator.hasNext()) 
            {
                a a1 = (a)iterator.next();
                if (a.a(a1).equals("MMEmbeddedBrowserClosed"))
                {
                    if (!arraylist.isEmpty())
                    {
                        mmadeventbreadcrumb = (MMAdEventBreadcrumb)arraylist.get(arraylist.size() - 1);
                    }
                    if (mmadeventbreadcrumb != null)
                    {
                        long l1 = a.b(a1).getTime() - date.getTime();
                        mmadeventbreadcrumb.setDuration((double)l1 / 1000D);
                        l = l1 / 1000L + l;
                    }
                    date = a.b(a1);
                } else
                {
                    MMAdEventURL mmadeventurl;
                    MMAdEventBreadcrumb mmadeventbreadcrumb1;
                    if (!linkedhashmap.containsKey(a.a(a1)))
                    {
                        mmadeventurl = new MMAdEventURL((short)i, a.a(a1), (short)1);
                        linkedhashmap.put(a.a(a1), mmadeventurl);
                        i++;
                    } else
                    {
                        mmadeventurl = (MMAdEventURL)linkedhashmap.get(a.a(a1));
                        mmadeventurl.setVisitCount((short)(mmadeventurl.getVisitCount() + 1));
                    }
                    if (!arraylist.isEmpty())
                    {
                        mmadeventbreadcrumb = (MMAdEventBreadcrumb)arraylist.get(arraylist.size() - 1);
                    }
                    mmadeventbreadcrumb1 = new MMAdEventBreadcrumb();
                    mmadeventbreadcrumb1.setUrlID(mmadeventurl.getId());
                    mmadeventbreadcrumb1.setViewStart(simpledateformat.format(a.b(a1)));
                    if (mmadeventbreadcrumb != null && !mmadeventbreadcrumb.isSetDuration())
                    {
                        long l2 = a.b(a1).getTime() - date.getTime();
                        mmadeventbreadcrumb.setDuration((double)l2 / 1000D);
                        l += l2 / 1000L;
                    }
                    date = a.b(a1);
                    arraylist.add(mmadeventbreadcrumb1);
                }
            }
            adevent.setVisitedAdEventLinks(new ArrayList(linkedhashmap.values()));
            adevent.setBreadcrumbs(arraylist);
            Log.v("MMT.MMEvent", (new StringBuilder()).append("Total browser duration: ").append(l).toString());
            return;
        } while (true);
    }

    private List c()
    {
        ArrayList arraylist = new ArrayList(c.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); arraylist.add(new MMNumberData((String)entry.getKey(), ((Double)entry.getValue()).doubleValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return arraylist;
    }

    final void a(AdEvent adevent)
    {
        adevent.setKey(mKey);
        adevent.setStringValues(a());
        adevent.setNumericValues(b());
        adevent.setDurationValues(c());
        Double double1 = (Double)b.get("MMUserCount");
        if (double1 != null)
        {
            adevent.setUCount(double1.shortValue());
        }
        double1 = (Double)c.get("MMUserDuration");
        if (double1 != null)
        {
            adevent.setUDur(double1.shortValue());
        }
        if (!adevent.getKey().equals("MMAdViewed"))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        adevent.setAdID((String)a.get("MMAdID"));
        Object obj = (String)a.get("MMAdExit");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        adevent.setAdExit(Integer.parseInt(((String) (obj))));
        obj = (Double)c.get("MMAdViewDuration");
        if (obj != null)
        {
            try
            {
                adevent.setUDur(((Double) (obj)).shortValue());
                adevent.setTime(com.medialets.analytics.e.a(new Date(System.currentTimeMillis() - Math.round(((Double) (obj)).doubleValue() * 1000D))));
            }
            catch (Exception exception)
            {
                Log.d("MMT.MMEvent", (new StringBuilder()).append("Exception caught:: ").append(exception.toString()).toString());
            }
        }
        b(adevent);
        if (!adevent.isSetTime())
        {
            adevent.setTime(com.medialets.analytics.e.a(new Date()));
        }
    }

    final void a(Event event)
    {
        event.setKey(mKey);
        Double double1 = (Double)b.get("MMUserCount");
        if (double1 != null)
        {
            event.setUCount(double1.shortValue());
        }
        event.setStringValues(a());
        event.setNumericValues(b());
        event.setDurationValues(c());
        if (!event.isSetTime())
        {
            event.setTime(com.medialets.analytics.e.a(new Date()));
        }
    }

    public void addBreadCrumbUrl(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Log.d("MMT.MMEvent", (new StringBuilder()).append("Adding breadcrumb... ").append(s).toString());
        s = new a(s, new Date());
        e.add(s);
        Log.d("MMT.MMEvent", (new StringBuilder()).append("Breadcrumbs size: ").append(e.size()).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void addDurationsFromMap(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        c.putAll(map);
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    public void addNumbersFromMap(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        b.putAll(map);
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    public void addStringsFromMap(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        a.putAll(map);
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    public Double endTimerForKey(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = (Date)d.remove(s);
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = new Double((double)(System.currentTimeMillis() - ((Date) (obj)).getTime()) / 1000D);
        c.put(s, obj);
        s = ((String) (obj));
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Double getDurationForKey(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Double)c.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public Double getNumberForKey(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Double)b.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public String getStringForKey(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (String)a.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void incrementNumberForKey(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Double double1 = (Double)b.get(s);
        if (double1 != null) goto _L2; else goto _L1
_L1:
        setNumberForKey(s, new Double(1.0D));
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        setNumberForKey(s, Double.valueOf(double1.doubleValue() + 1.0D));
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void setDurationForKey(String s, Double double1)
    {
        this;
        JVM INSTR monitorenter ;
        c.put(s, double1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setNumberForKey(String s, Double double1)
    {
        this;
        JVM INSTR monitorenter ;
        if (b.containsKey(s))
        {
            b.remove(s);
        }
        b.put(s, double1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setSlotName(String s)
    {
        slotName = s;
    }

    public void setStringForKey(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a.put(s, s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void startTimerForKey(String s)
    {
        this;
        JVM INSTR monitorenter ;
        d.put(s, new Date());
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }
}
