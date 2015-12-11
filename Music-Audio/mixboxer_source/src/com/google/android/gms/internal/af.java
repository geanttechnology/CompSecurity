// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            cs

public final class af
{
    public static final class a
    {

        private Date d;
        private int eL;
        private Location eM;
        private boolean eN;
        private String eP;
        private int eR;
        private final HashSet eT = new HashSet();
        private final HashMap eU = new HashMap();
        private final HashSet eV = new HashSet();

        static Date a(a a1)
        {
            return a1.d;
        }

        static int b(a a1)
        {
            return a1.eL;
        }

        static HashSet c(a a1)
        {
            return a1.eT;
        }

        static Location d(a a1)
        {
            return a1.eM;
        }

        static boolean e(a a1)
        {
            return a1.eN;
        }

        static HashMap f(a a1)
        {
            return a1.eU;
        }

        static String g(a a1)
        {
            return a1.eP;
        }

        static int h(a a1)
        {
            return a1.eR;
        }

        static HashSet i(a a1)
        {
            return a1.eV;
        }

        public void a(Location location)
        {
            eM = location;
        }

        public void a(NetworkExtras networkextras)
        {
            eU.put(networkextras.getClass(), networkextras);
        }

        public void a(Date date)
        {
            d = date;
        }

        public void d(int j)
        {
            eL = j;
        }

        public void d(boolean flag)
        {
            eN = flag;
        }

        public void e(boolean flag)
        {
            int j;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            eR = j;
        }

        public void g(String s)
        {
            eT.add(s);
        }

        public void h(String s)
        {
            eV.add(s);
        }

        public void i(String s)
        {
            eP = s;
        }

        public a()
        {
            eL = -1;
            eN = false;
            eR = -1;
        }
    }


    public static final String DEVICE_ID_EMULATOR = cs.q("emulator");
    private final Date d;
    private final int eL;
    private final Location eM;
    private final boolean eN;
    private final Map eO;
    private final String eP;
    private final SearchAdRequest eQ;
    private final int eR;
    private final Set eS;
    private final Set f;

    public af(a a1)
    {
        this(a1, null);
    }

    public af(a a1, SearchAdRequest searchadrequest)
    {
        d = a.a(a1);
        eL = a.b(a1);
        f = Collections.unmodifiableSet(a.c(a1));
        eM = a.d(a1);
        eN = a.e(a1);
        eO = Collections.unmodifiableMap(a.f(a1));
        eP = a.g(a1);
        eQ = searchadrequest;
        eR = a.h(a1);
        eS = Collections.unmodifiableSet(a.i(a1));
    }

    public SearchAdRequest Q()
    {
        return eQ;
    }

    public Map R()
    {
        return eO;
    }

    public int S()
    {
        return eR;
    }

    public Date getBirthday()
    {
        return d;
    }

    public int getGender()
    {
        return eL;
    }

    public Set getKeywords()
    {
        return f;
    }

    public Location getLocation()
    {
        return eM;
    }

    public boolean getManualImpressionsEnabled()
    {
        return eN;
    }

    public NetworkExtras getNetworkExtras(Class class1)
    {
        return (NetworkExtras)eO.get(class1);
    }

    public String getPublisherProvidedId()
    {
        return eP;
    }

    public boolean isTestDevice(Context context)
    {
        return eS.contains(cs.l(context));
    }

}
