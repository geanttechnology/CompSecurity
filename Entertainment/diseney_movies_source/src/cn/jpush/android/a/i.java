// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import cn.jpush.android.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package cn.jpush.android.a:
//            j

public final class i
{

    private static final String z;
    private WifiManager a;

    public i(Context context)
    {
        a = (WifiManager)context.getSystemService(z);
    }

    private List d()
    {
        if (!a())
        {
            return new ArrayList();
        }
        Object obj = a.getConnectionInfo();
        ArrayList arraylist;
        Object obj1;
        if (obj != null)
        {
            obj = new j(this, ((WifiInfo) (obj)).getBSSID(), ((WifiInfo) (obj)).getRssi(), ((WifiInfo) (obj)).getSSID());
        } else
        {
            obj = null;
        }
        arraylist = new ArrayList();
        if (obj != null)
        {
            arraylist.add(obj);
        }
        obj1 = a.getScanResults();
        if (obj1 != null && ((List) (obj1)).size() > 0)
        {
            obj1 = ((List) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                j j1 = new j(this, (ScanResult)((Iterator) (obj1)).next());
                if (!j1.c.equals(((j) (obj)).c))
                {
                    arraylist.add(j1);
                }
            } while (true);
        }
        return arraylist;
    }

    public final boolean a()
    {
        boolean flag;
        try
        {
            flag = a.isWifiEnabled();
        }
        catch (Exception exception)
        {
            x.j();
            return false;
        }
        return flag;
    }

    public final WifiManager b()
    {
        return a;
    }

    public final JSONArray c()
    {
        JSONArray jsonarray = new JSONArray();
        Iterator iterator = d().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return jsonarray;
            }
            try
            {
                jsonarray.put(((j)iterator.next()).a());
            }
            catch (Exception exception)
            {
                x.j();
                return jsonarray;
            }
        } while (true);
    }

    static 
    {
        char ac[];
        char ac1[];
        int k;
        int l;
        int i1;
        int j1;
        ac = "2MR\017".toCharArray();
        l = ac.length;
        j1 = 0;
        k = 0;
        ac1 = ac;
        i1 = l;
        if (l > 1) goto _L2; else goto _L1
_L1:
        j1 = k;
        i1 = k;
_L9:
        char c1;
        ac1 = ac;
        c1 = ac1[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 135
    //                   1 141
    //                   2 147
    //                   3 153;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_153;
_L3:
        k = 25;
_L10:
label0:
        {
            ac1[i1] = (char)(k ^ c1);
            j1++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        ac1 = ac;
_L2:
        ac = ac1;
        l = i1;
        k = j1;
        if (i1 <= j1)
        {
            z = (new String(ac1)).intern();
            return;
        }
          goto _L1
_L8:
        k = 69;
          goto _L10
_L5:
        k = 36;
          goto _L10
_L6:
        k = 52;
          goto _L10
        k = 102;
          goto _L10
    }
}
