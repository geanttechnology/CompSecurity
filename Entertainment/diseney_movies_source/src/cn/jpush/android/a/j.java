// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.net.wifi.ScanResult;
import cn.jpush.android.util.x;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.a:
//            i

public final class j
    implements Comparable
{

    private static final String z[];
    public final String a;
    public final int b;
    public final String c;
    final i d;

    public j(i i, ScanResult scanresult)
    {
        d = i;
        super();
        a = scanresult.BSSID;
        b = scanresult.level;
        c = scanresult.SSID;
    }

    public j(i i, String s, int k, String s1)
    {
        d = i;
        super();
        a = s;
        b = k;
        c = s1;
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            String s = a;
            jsonobject.put(z[1], s);
            int i = b;
            jsonobject.put(z[2], i);
            jsonobject.put(z[0], 0);
        }
        catch (Exception exception)
        {
            x.j();
            return jsonobject;
        }
        return jsonobject;
    }

    public final volatile int compareTo(Object obj)
    {
        return ((j)obj).b - b;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof j) || (((j) (obj = (j)obj)).b != b || !((j) (obj)).a.equals(a)))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return b ^ a.hashCode();
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int k;
        as2 = new String[3];
        obj1 = "-Z|";
        i = -1;
        k = 0;
_L10:
        Object obj;
        String as[];
        int l;
        int i1;
        int j1;
        int k1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        l = obj1.length;
        if (l > 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        i1 = 0;
        as = ((String []) (obj));
        j1 = k;
        obj = obj1;
        k1 = i;
_L9:
        k = i1;
_L7:
        int l1;
        obj1 = obj;
        l1 = obj1[i1];
        k % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 260
    //                   2 267
    //                   3 274;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 57;
_L11:
label0:
        {
            obj1[i1] = (char)(i ^ l1);
            k++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int i2;
        i = l;
        as1 = as;
        i2 = j1;
        obj1 = obj;
        l1 = k1;
_L12:
        k1 = l1;
        obj = obj1;
        j1 = i2;
        as = as1;
        l = i;
        i1 = k;
        if (i > k) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (l1)
        {
        default:
            as1[i2] = ((String) (obj));
            obj1 = "!\\z\"X(Yk\030J?";
            k = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            k = 2;
            obj1 = "?T~\023X bj\tK)S~\tQ";
            i = 1;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 76;
          goto _L11
_L3:
        i = 61;
          goto _L11
_L4:
        i = 25;
          goto _L11
_L5:
        i = 125;
          goto _L11
        boolean flag = false;
        l1 = i;
        i2 = k;
        as1 = ((String []) (obj));
        i = l;
        k = ((flag) ? 1 : 0);
          goto _L12
    }
}
