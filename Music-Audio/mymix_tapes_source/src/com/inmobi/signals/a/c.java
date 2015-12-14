// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.a;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.signals.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.signals.a:
//            a, b

public class c
{

    private static final String a = com/inmobi/signals/a/c.getSimpleName();

    public c()
    {
    }

    public static com.inmobi.signals.a.a a()
    {
        if (!o.a().e().n())
        {
            return null;
        }
        int i = o.a().e().m();
        boolean flag = a(i, 2);
        boolean flag1 = a(i, 1);
        com.inmobi.signals.a.a a1 = new com.inmobi.signals.a.a();
        TelephonyManager telephonymanager = (TelephonyManager)com.inmobi.commons.a.a.b().getSystemService("phone");
        if (!flag)
        {
            int ai1[] = a(telephonymanager.getNetworkOperator());
            a1.a(ai1[0]);
            a1.b(ai1[1]);
        }
        if (!flag1)
        {
            int ai[] = a(telephonymanager.getSimOperator());
            a1.c(ai[0]);
            a1.d(ai[1]);
        }
        return a1;
    }

    private static boolean a(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 3: // '\003'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 15: // '\017'
            return true;
        }
    }

    private static boolean a(int i, int j)
    {
        return (i & j) == j;
    }

    private static int[] a(String s)
    {
        int ai[] = new int[2];
        ai[0] = -1;
        ai[1] = -1;
        if (s == null || s.equals(""))
        {
            return ai;
        }
        int i;
        int j;
        try
        {
            i = Integer.parseInt(s.substring(0, 3));
            j = Integer.parseInt(s.substring(3));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while collecting cell info.", s);
            return ai;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while collecting cell info.", s);
            return ai;
        }
        ai[0] = i;
        ai[1] = j;
        return ai;
    }

    public static b b()
    {
        if (!o.a().e().p() || !f())
        {
            return null;
        } else
        {
            return g();
        }
    }

    public static Map c()
    {
        b b1 = b();
        HashMap hashmap = new HashMap();
        if (b1 != null)
        {
            hashmap.put("c-sc", b1.a().toString());
        }
        return hashmap;
    }

    public static Map d()
    {
        List list = e();
        HashMap hashmap = new HashMap();
        if (list != null && !list.isEmpty())
        {
            JSONArray jsonarray = new JSONArray();
            jsonarray.put(((b)list.get(list.size() - 1)).a());
            hashmap.put("v-sc", jsonarray.toString());
        }
        return hashmap;
    }

    public static List e()
    {
        if (!h() || !o.a().e().o())
        {
            return null;
        }
        Object obj = (TelephonyManager)com.inmobi.commons.a.a.b().getSystemService("phone");
        ArrayList arraylist = new ArrayList();
        int ai[] = a(((TelephonyManager) (obj)).getNetworkOperator());
        String s = String.valueOf(ai[0]);
        String s1 = String.valueOf(ai[1]);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            Object obj1 = ((TelephonyManager) (obj)).getAllCellInfo();
            if (obj1 != null)
            {
                obj1 = ((List) (obj1)).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    CellInfo cellinfo = (CellInfo)((Iterator) (obj1)).next();
                    if (!cellinfo.isRegistered())
                    {
                        arraylist.add(new b(cellinfo, s, s1, ((TelephonyManager) (obj)).getNetworkType()));
                    }
                } while (true);
                return arraylist;
            }
        }
        obj = ((TelephonyManager) (obj)).getNeighboringCellInfo();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return null;
        }
        obj = ((List) (obj)).iterator();
        if (((Iterator) (obj)).hasNext())
        {
            obj = (NeighboringCellInfo)((Iterator) (obj)).next();
            b b1 = new b();
            int i = ((NeighboringCellInfo) (obj)).getNetworkType();
            b1.a(i);
            if (((NeighboringCellInfo) (obj)).getRssi() == 99)
            {
                b1.b(0x7fffffff);
            } else
            if (a(i))
            {
                b1.b(((NeighboringCellInfo) (obj)).getRssi() - 116);
            } else
            {
                b1.b(((NeighboringCellInfo) (obj)).getRssi() * 2 - 113);
            }
            b1.a(b1.a(s, s1, ((NeighboringCellInfo) (obj)).getLac(), ((NeighboringCellInfo) (obj)).getCid(), -1, 0x7fffffff));
            arraylist.add(b1);
            return arraylist;
        } else
        {
            return null;
        }
    }

    private static boolean f()
    {
        Context context = com.inmobi.commons.a.a.b();
        boolean flag;
        boolean flag1;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        return flag || flag1;
    }

    private static b g()
    {
        TelephonyManager telephonymanager = (TelephonyManager)com.inmobi.commons.a.a.b().getSystemService("phone");
        int ai[] = a(telephonymanager.getNetworkOperator());
        String s = String.valueOf(ai[0]);
        Object obj = String.valueOf(ai[1]);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            List list = telephonymanager.getAllCellInfo();
            if (list != null)
            {
                int i = 0;
                CellInfo cellinfo = null;
label0:
                do
                {
label1:
                    {
                        if (i < list.size())
                        {
                            cellinfo = (CellInfo)list.get(i);
                            if (!cellinfo.isRegistered())
                            {
                                break label1;
                            }
                        }
                        if (cellinfo != null)
                        {
                            return new b(cellinfo, s, ((String) (obj)), telephonymanager.getNetworkType());
                        }
                        break label0;
                    }
                    i++;
                } while (true);
            }
        }
        android.telephony.CellLocation celllocation = telephonymanager.getCellLocation();
        if (celllocation == null || ai[0] == -1)
        {
            return null;
        }
        b b1 = new b();
        if (celllocation instanceof CdmaCellLocation)
        {
            obj = (CdmaCellLocation)celllocation;
            b1.b(0x7fffffff);
            b1.a(telephonymanager.getNetworkType());
            b1.a(b1.a(s, ((CdmaCellLocation) (obj)).getSystemId(), ((CdmaCellLocation) (obj)).getNetworkId(), ((CdmaCellLocation) (obj)).getBaseStationId()));
            return b1;
        } else
        {
            GsmCellLocation gsmcelllocation = (GsmCellLocation)celllocation;
            b1.b(0x7fffffff);
            b1.a(telephonymanager.getNetworkType());
            b1.a(b1.a(s, ((String) (obj)), gsmcelllocation.getLac(), gsmcelllocation.getCid(), gsmcelllocation.getPsc(), 0x7fffffff));
            return b1;
        }
    }

    private static boolean h()
    {
        return com.inmobi.commons.a.a.b().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

}
