// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import cn.jpush.android.util.a;
import cn.jpush.android.util.x;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.a:
//            c, a

public final class b
{

    private static final String z[];
    private int a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private int f;
    private double g;
    private PhoneStateListener h;
    private double i;
    private int j;
    private int k;
    private int l;
    private int m;
    private TelephonyManager n;
    private boolean o;
    private String p;
    private ArrayList q;

    public b(Context context)
    {
        q = new ArrayList();
        if (!cn.jpush.android.util.a.c(context, z[2]))
        {
            return;
        } else
        {
            h = new c(this);
            n = (TelephonyManager)context.getSystemService(z[1]);
            n.listen(h, 18);
            return;
        }
    }

    static int a(b b1, int i1)
    {
        b1.a = i1;
        return i1;
    }

    static boolean a(b b1, boolean flag)
    {
        b1.o = false;
        return false;
    }

    private String h()
    {
        Object obj = n.getCellLocation();
        String s;
        int i1;
        s = n.getNetworkOperator();
        i1 = s.length();
        if (i1 == 5)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        if (i1 == 6);
_L1:
        if (n.getPhoneType() != 2)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        o = true;
        if (!(obj instanceof CdmaCellLocation) || obj == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        obj = (CdmaCellLocation)obj;
        g = (double)((CdmaCellLocation) (obj)).getBaseStationLatitude() / 14400D;
        i = (double)((CdmaCellLocation) (obj)).getBaseStationLongitude() / 14400D;
        m = ((CdmaCellLocation) (obj)).getSystemId();
        b = ((CdmaCellLocation) (obj)).getBaseStationId();
        l = ((CdmaCellLocation) (obj)).getNetworkId();
        (new StringBuilder()).append(m).toString();
        x.d();
        (new StringBuilder()).append(b).toString();
        x.d();
        (new StringBuilder()).append(l).toString();
        x.d();
        obj = new cn.jpush.android.a.a();
        ((cn.jpush.android.a.a) (obj)).a(b);
        ((cn.jpush.android.a.a) (obj)).d(l);
        ((cn.jpush.android.a.a) (obj)).c(m);
        ((cn.jpush.android.a.a) (obj)).b(Integer.parseInt(s.substring(0, 3)));
        ((cn.jpush.android.a.a) (obj)).a(z[0]);
        q.add(obj);
        (new StringBuilder()).append(((cn.jpush.android.a.a) (obj)).a()).toString();
        x.c();
        p = ((cn.jpush.android.a.a) (obj)).toString();
        return p;
        j = Integer.parseInt(s.substring(0, 3));
        k = Integer.parseInt(s.substring(3, i1));
          goto _L1
        Exception exception;
        exception;
        return null;
    }

    private int i()
    {
        if (!o)
        {
            j();
        }
        return c;
    }

    private void j()
    {
        Object obj;
        e = false;
        d = false;
        c = 0;
        f = 0;
        j = 0;
        k = 0;
        obj = n.getCellLocation();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        int j1;
        if (n.getPhoneType() == 1 && (obj instanceof GsmCellLocation))
        {
            e = true;
            GsmCellLocation gsmcelllocation = (GsmCellLocation)obj;
            int i1 = gsmcelllocation.getCid();
            if (i1 > 0 && i1 != 65535)
            {
                c = i1;
                f = gsmcelllocation.getLac();
            }
        }
        try
        {
            s = n.getNetworkOperator();
            j1 = s.length();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            x.j();
            return;
        }
        if (j1 == 5)
        {
            break MISSING_BLOCK_LABEL_385;
        }
        if (j1 == 6);
_L5:
        if (n.getPhoneType() != 2) goto _L1; else goto _L3
_L3:
        if (!(obj instanceof CdmaCellLocation))
        {
            break MISSING_BLOCK_LABEL_415;
        }
        if (obj == null) goto _L1; else goto _L4
_L4:
        obj = (CdmaCellLocation)obj;
        g = (double)((CdmaCellLocation) (obj)).getBaseStationLatitude() / 14400D;
        i = (double)((CdmaCellLocation) (obj)).getBaseStationLongitude() / 14400D;
        m = ((CdmaCellLocation) (obj)).getSystemId();
        b = ((CdmaCellLocation) (obj)).getBaseStationId();
        l = ((CdmaCellLocation) (obj)).getNetworkId();
        (new StringBuilder()).append(m).toString();
        x.d();
        (new StringBuilder()).append(b).toString();
        x.d();
        (new StringBuilder()).append(l).toString();
        x.d();
        obj = new cn.jpush.android.a.a();
        ((cn.jpush.android.a.a) (obj)).a(b);
        ((cn.jpush.android.a.a) (obj)).d(l);
        ((cn.jpush.android.a.a) (obj)).c(m);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        if (s.length() >= 3)
        {
            ((cn.jpush.android.a.a) (obj)).b(Integer.parseInt(s.substring(0, 3)));
        }
        ((cn.jpush.android.a.a) (obj)).a(z[0]);
        q.add(obj);
        (new StringBuilder()).append(((cn.jpush.android.a.a) (obj)).a()).toString();
        x.c();
        p = ((cn.jpush.android.a.a) (obj)).toString();
        d = true;
        return;
        j = Integer.parseInt(s.substring(0, 3));
        k = Integer.parseInt(s.substring(3, j1));
          goto _L5
        Object obj1 = obj.getClass();
        Class aclass[] = new Class[0];
        Method method = ((Class) (obj1)).getMethod(z[5], aclass);
        Method method1 = ((Class) (obj1)).getMethod(z[6], aclass);
        Method method2 = ((Class) (obj1)).getMethod(z[7], aclass);
        Object aobj[] = new Object[0];
        b = ((Integer)method.invoke(obj, aobj)).intValue();
        m = ((Integer)method1.invoke(obj, aobj)).intValue();
        l = ((Integer)method2.invoke(obj, aobj)).intValue();
        method = ((Class) (obj1)).getMethod(z[4], aclass);
        obj1 = ((Class) (obj1)).getMethod(z[3], aclass);
        g = ((Integer)method.invoke(obj, aobj)).intValue();
        i = ((Integer)((Method) (obj1)).invoke(obj, aobj)).intValue();
        d = true;
        return;
    }

    public final int a()
    {
        if (!o)
        {
            j();
        }
        return b;
    }

    public final JSONArray b()
    {
        Object obj = n.getCellLocation();
        String s;
        int i1;
        s = n.getNetworkOperator();
        i1 = s.length();
        if (i1 == 5)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        if (i1 == 6);
_L1:
        if (n.getPhoneType() != 2)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        o = true;
        if (!(obj instanceof CdmaCellLocation) || obj == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        obj = (CdmaCellLocation)obj;
        g = (double)((CdmaCellLocation) (obj)).getBaseStationLatitude() / 14400D;
        i = (double)((CdmaCellLocation) (obj)).getBaseStationLongitude() / 14400D;
        m = ((CdmaCellLocation) (obj)).getSystemId();
        b = ((CdmaCellLocation) (obj)).getBaseStationId();
        l = ((CdmaCellLocation) (obj)).getNetworkId();
        (new StringBuilder()).append(m).toString();
        x.d();
        (new StringBuilder()).append(b).toString();
        x.d();
        (new StringBuilder()).append(l).toString();
        x.d();
        obj = new cn.jpush.android.a.a();
        ((cn.jpush.android.a.a) (obj)).a(b);
        ((cn.jpush.android.a.a) (obj)).d(l);
        ((cn.jpush.android.a.a) (obj)).c(m);
        ((cn.jpush.android.a.a) (obj)).b(Integer.parseInt(s.substring(0, 3)));
        ((cn.jpush.android.a.a) (obj)).a(z[0]);
        q.add(obj);
        return ((cn.jpush.android.a.a) (obj)).b();
        j = Integer.parseInt(s.substring(0, 3));
        k = Integer.parseInt(s.substring(3, i1));
          goto _L1
        Exception exception;
        exception;
        return null;
    }

    public final JSONArray c()
    {
        double d1;
        Object obj;
        JSONArray jsonarray;
        int i1;
        int k1;
        int l1;
label0:
        {
            jsonarray = new JSONArray();
            int ai[] = d();
            if (!o)
            {
                j();
            }
            d1 = f;
            if (!o)
            {
                j();
            }
            k1 = j;
            if (!o)
            {
                j();
            }
            l1 = k;
            if (ai != null)
            {
                obj = ai;
                if (ai.length >= 2)
                {
                    break label0;
                }
            }
            obj = new int[2];
            obj[0] = c;
            obj[1] = -60;
        }
        i1 = 0;
_L2:
        if (i1 < obj.length && i1 <= 4)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        if (!e())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new JSONObject(h());
        obj = (new JSONArray()).put(obj);
        return ((JSONArray) (obj));
        int j1 = i1 + 1;
        if (j1 >= 0 && j1 <= 31)
        {
            j1 = j1 * 2 - 113;
        } else
        {
            j1 = 0;
        }
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put(z[13], obj[i1]);
            jsonobject.put(z[11], d1);
            jsonobject.put(z[12], k1);
            jsonobject.put(z[9], l1);
            jsonobject.put(z[8], j1);
            jsonobject.put(z[10], 0);
            jsonarray.put(jsonobject);
        }
        catch (Exception exception)
        {
            exception.getMessage();
            x.f();
        }
        i1 += 2;
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
_L1:
        return jsonarray;
    }

    public final int[] d()
    {
        if (i() == 0)
        {
            return new int[0];
        }
        Object obj = n.getNeighboringCellInfo();
        if (obj == null || ((List) (obj)).size() == 0)
        {
            return (new int[] {
                i()
            });
        }
        int ai[] = new int[((List) (obj)).size() * 2 + 2];
        ai[0] = i();
        ai[1] = a;
        obj = ((List) (obj)).iterator();
        int i1 = 2;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            NeighboringCellInfo neighboringcellinfo = (NeighboringCellInfo)((Iterator) (obj)).next();
            int k1 = neighboringcellinfo.getCid();
            if (k1 > 0 && k1 != 65535)
            {
                int j1 = i1 + 1;
                ai[i1] = k1;
                i1 = j1 + 1;
                ai[j1] = neighboringcellinfo.getRssi();
            }
        } while (true);
        int ai1[] = new int[i1];
        System.arraycopy(ai, 0, ai1, 0, i1);
        return ai1;
    }

    public final boolean e()
    {
        if (!o)
        {
            j();
        }
        return d;
    }

    public final boolean f()
    {
        if (!o)
        {
            j();
        }
        return e;
    }

    public final float g()
    {
        while (e() || !f()) 
        {
            return 1.065353E+09F;
        }
        d();
        return 1.065353E+09F;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[14];
        i1 = 0;
        obj1 = "{['B";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j1;
        int k1;
        int l1;
        int i2;
        byte byte2;
        int j2;
        ac = ((String) (obj1)).toCharArray();
        j1 = ac.length;
        i2 = 0;
        k1 = 0;
        byte2 = byte0;
        obj1 = ac;
        j2 = i1;
        as1 = ((String []) (obj));
        l1 = j1;
        if (j1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l1 = k1;
_L9:
        obj1 = obj;
        i2 = obj1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 544
    //                   1 551
    //                   2 558
    //                   3 565;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_565;
_L3:
        byte0 = 12;
_L13:
label0:
        {
            obj1[k1] = (char)(byte0 ^ i2);
            l1++;
            if (j1 != 0)
            {
                break label0;
            }
            k1 = j1;
        }
        if (true) goto _L9; else goto _L8
        i2 = l1;
        l1 = j1;
        as1 = as2;
        j2 = i1;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i1 = j2;
        as2 = as1;
        j1 = l1;
        k1 = i2;
        if (l1 > i2) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j2] = ((String) (obj));
            i1 = 1;
            obj1 = "hW%Mi";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "yQ.Qcq[dSijR#P\177qP$\rM[|\017p_G|\005b^Kz\025oC[~\036jCV";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "\177Z>amkZ\031WmlV%M@wQ-Jxm[/";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "\177Z>amkZ\031WmlV%M@yK#Wy|Z";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "\177Z>amkZ\031WmlV%ME|";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "\177Z>pukK/NE|";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            i1 = 7;
            obj1 = "\177Z>milH%QgQ[";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j2] = ((String) (obj));
            i1 = 8;
            obj1 = "kV-Mmt`9W~}Q-Wd";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j2] = ((String) (obj));
            i1 = 9;
            obj1 = "uP(J`}`$FxoP8HS{P.F";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j2] = ((String) (obj));
            i1 = 10;
            obj1 = "yX/";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j2] = ((String) (obj));
            i1 = 11;
            obj1 = "tP)BxqP$|mjZ+|ow[/";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j2] = ((String) (obj));
            i1 = 12;
            obj1 = "uP(J`}`)LyvK8ZS{P.F";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j2] = ((String) (obj));
            i1 = 13;
            obj1 = "{Z&OSq[";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j2] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 24;
          goto _L13
_L5:
        byte0 = 63;
          goto _L13
_L6:
        byte0 = 74;
          goto _L13
        byte0 = 35;
          goto _L13
    }
}
