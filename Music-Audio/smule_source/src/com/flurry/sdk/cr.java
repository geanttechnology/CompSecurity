// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdReportedId;
import com.flurry.android.impl.ads.protocol.v13.AdSpaceLayout;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.Callback;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapRequestInfo;
import com.flurry.android.impl.ads.protocol.v13.Location;
import com.flurry.android.impl.ads.protocol.v13.ScreenOrientationType;
import com.flurry.android.impl.ads.protocol.v13.SdkAdEvent;
import com.flurry.android.impl.ads.protocol.v13.SdkAdLog;
import com.flurry.android.impl.ads.protocol.v13.StreamInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.flurry.sdk:
//            b, aw, hp, a, 
//            at, as, hn, fh, 
//            fr, fe, fl, i, 
//            ba, az, bc, bb

public class cr
{

    private static final AtomicInteger a = new AtomicInteger(0);

    public static int a()
    {
        return a.incrementAndGet();
    }

    public static AdCreative a(AdSpaceLayout adspacelayout)
    {
        if (adspacelayout == null)
        {
            return null;
        } else
        {
            return new AdCreative(adspacelayout.adHeight, adspacelayout.adWidth, adspacelayout.format, adspacelayout.fix, adspacelayout.alignment);
        }
    }

    public static AdCreative a(AdUnit adunit)
    {
        if (adunit == null)
        {
            return null;
        }
        adunit = adunit.adFrames;
        if (adunit == null || adunit.isEmpty())
        {
            return null;
        }
        adunit = (AdFrame)adunit.get(0);
        if (adunit == null)
        {
            return null;
        }
        adunit = ((AdFrame) (adunit)).adSpaceLayout;
        if (adunit == null)
        {
            return null;
        } else
        {
            return a(((AdSpaceLayout) (adunit)));
        }
    }

    public static List a(AdFrame adframe, b b1)
    {
        ArrayList arraylist = new ArrayList();
        adframe = adframe.callbacks;
        String s2 = b1.a.a();
        Iterator iterator = adframe.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            adframe = (Callback)iterator.next();
            if (((Callback) (adframe)).event.equals(s2))
            {
                Iterator iterator1 = ((Callback) (adframe)).actions.iterator();
                while (iterator1.hasNext()) 
                {
                    adframe = (CharSequence)iterator1.next();
                    HashMap hashmap = new HashMap();
                    String s1 = adframe.toString();
                    int j = s1.indexOf('?');
                    adframe = s1;
                    if (j != -1)
                    {
                        String s = s1.substring(0, j);
                        s1 = s1.substring(j + 1);
                        adframe = s1;
                        if (s1.contains("%{eventParams}"))
                        {
                            adframe = s1.replace("%{eventParams}", "");
                            hashmap.putAll(b1.b);
                        }
                        hashmap.putAll(hp.h(adframe));
                        adframe = s;
                    }
                    arraylist.add(new a(com.flurry.sdk.a.c(adframe), hashmap, b1));
                }
            }
        } while (true);
        return arraylist;
    }

    public static List a(List list)
    {
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        if (list == null)
        {
            return arraylist;
        }
        iterator = list.iterator();
_L2:
        at at1;
        SdkAdLog sdkadlog;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        at1 = (at)iterator.next();
        sdkadlog = new SdkAdLog();
        sdkadlog.sessionId = at1.c();
        Iterator iterator1;
        SdkAdEvent sdkadevent;
        Object obj;
        HashMap hashmap;
        if (at1.b() == null)
        {
            list = "";
        } else
        {
            list = at1.b();
        }
        sdkadlog.adLogGUID = list;
        list = new ArrayList();
        at1;
        JVM INSTR monitorenter ;
        iterator1 = at1.d().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            obj = (as)iterator1.next();
            if (((as) (obj)).b())
            {
                sdkadevent = new SdkAdEvent();
                sdkadevent.type = ((as) (obj)).a();
                sdkadevent.timeOffset = ((as) (obj)).c();
                obj = ((as) (obj)).d();
                hashmap = new HashMap();
                hashmap.putAll(((Map) (obj)));
                sdkadevent.params = hashmap;
                list.add(sdkadevent);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_211;
        list;
        at1;
        JVM INSTR monitorexit ;
        throw list;
        at1;
        JVM INSTR monitorexit ;
        sdkadlog.sdkAdEvents = list;
        if (list.size() > 0)
        {
            arraylist.add(sdkadlog);
        }
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    public static ScreenOrientationType b()
    {
        int j = hn.j();
        if (j == 1)
        {
            return ScreenOrientationType.PORTRAIT;
        }
        if (j == 2)
        {
            return ScreenOrientationType.LANDSCAPE;
        } else
        {
            return ScreenOrientationType.UNKNOWN;
        }
    }

    public static Location c()
    {
        Location location = new Location();
        android.location.Location location1 = fh.a().e();
        if (location1 != null)
        {
            double d1 = (float)location1.getLatitude();
            double d2 = (float)location1.getLongitude();
            location.lat = (float)hp.a(d1, 3);
            location.lon = (float)hp.a(d2, 3);
        }
        return location;
    }

    public static List d()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = fr.a().c();
        if (obj != null && !((HashMap) (obj)).isEmpty())
        {
            for (obj = ((HashMap) (obj)).keySet().iterator(); ((Iterator) (obj)).hasNext(); arraylist.add((String)((Iterator) (obj)).next())) { }
        }
        return arraylist;
    }

    public static List e()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = fe.a().h().entrySet().iterator();
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            AdReportedId adreportedid = new AdReportedId();
            adreportedid.type = ((fl)entry.getKey()).d;
            if (((fl)entry.getKey()).e)
            {
                adreportedid.id = new String((byte[])entry.getValue());
            } else
            {
                adreportedid.id = hp.b((byte[])entry.getValue());
            }
            arraylist.add(adreportedid);
        }
        return arraylist;
    }

    public static List f()
    {
        ArrayList arraylist = new ArrayList();
        i.a().k().b();
        FrequencyCapRequestInfo frequencycaprequestinfo;
        for (Iterator iterator = i.a().k().a().iterator(); iterator.hasNext(); arraylist.add(frequencycaprequestinfo))
        {
            az az1 = (az)iterator.next();
            frequencycaprequestinfo = new FrequencyCapRequestInfo();
            frequencycaprequestinfo.capType = az1.b();
            frequencycaprequestinfo.id = az1.c();
            frequencycaprequestinfo.expirationTime = az1.e();
            frequencycaprequestinfo.serveTime = az1.d();
            frequencycaprequestinfo.lastViewedTime = az1.k();
            frequencycaprequestinfo.streamCapDurationMillis = az1.f();
            frequencycaprequestinfo.views = az1.j();
            frequencycaprequestinfo.capRemaining = az1.g();
            frequencycaprequestinfo.totalCap = az1.h();
            frequencycaprequestinfo.capDurationType = az1.i();
        }

        return arraylist;
    }

    public static List g()
    {
        ArrayList arraylist = new ArrayList();
        i.a().n().b();
        StreamInfo streaminfo;
        for (Iterator iterator = i.a().n().a().iterator(); iterator.hasNext(); arraylist.add(streaminfo))
        {
            bb bb1 = (bb)iterator.next();
            streaminfo = new StreamInfo();
            streaminfo.adId = bb1.a();
            streaminfo.lastEvent = bb1.e();
            streaminfo.renderedTime = bb1.c();
        }

        return arraylist;
    }

}
