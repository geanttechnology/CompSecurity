// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import cn.jpush.android.util.ai;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class JPushLocalNotification
    implements Serializable
{

    private static final String z[];
    private int a;
    private String b;
    private String c;
    private String d;
    private long e;
    private String f;
    private String g;
    private String h;
    private long i;
    private long j;
    private int k;
    private String l;
    private String m;

    public JPushLocalNotification()
    {
        a = 1;
        b = "";
        c = z[0];
        d = z[0];
        e = 0L;
        j = 1L;
        k = 1;
        l = "";
        m = "";
    }

    private static void a(String s, String s1, JSONObject jsonobject)
    {
        if (!ai.a(s1))
        {
            jsonobject.put(s, s1);
        }
    }

    public boolean equals(Object obj)
    {
        return j == ((JPushLocalNotification)obj).j;
    }

    public long getBroadcastTime()
    {
        return e;
    }

    public long getBuilderId()
    {
        return i;
    }

    public String getContent()
    {
        return f;
    }

    public String getExtras()
    {
        return h;
    }

    public long getNotificationId()
    {
        return j;
    }

    public String getTitle()
    {
        return g;
    }

    public int hashCode()
    {
        return (new StringBuilder()).append(j).toString().hashCode();
    }

    public void setBroadcastTime(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        Object obj;
        boolean flag;
        flag = false;
        obj = Calendar.getInstance();
        if (i1 > ((Calendar) (obj)).get(1)) goto _L2; else goto _L1
_L1:
        i1 = ((Calendar) (obj)).get(1);
        if (j1 - 1 > ((Calendar) (obj)).get(2)) goto _L4; else goto _L3
_L3:
        int k2 = ((Calendar) (obj)).get(2);
        long l3;
        if (k1 <= ((Calendar) (obj)).get(5))
        {
            j1 = ((Calendar) (obj)).get(5);
            k1 = k2;
        } else
        {
            j1 = k1;
            k1 = k2;
        }
_L7:
        int l2;
        int i3;
        if (l1 <= 0)
        {
            l1 = 0;
        }
        if (i2 <= 0)
        {
            i2 = 0;
        }
        k2 = ((flag) ? 1 : 0);
        if (j2 > 0)
        {
            k2 = j2;
        }
        ((Calendar) (obj)).set(i1, k1, j1, l1, i2, k2);
        obj = ((Calendar) (obj)).getTime();
        l3 = System.currentTimeMillis();
        if (((Date) (obj)).getTime() < l3)
        {
            e = l3;
            return;
        } else
        {
            e = ((Date) (obj)).getTime();
            return;
        }
_L4:
        j1--;
        l2 = j1;
        i3 = i1;
        if (k1 > 0)
        {
            l2 = k1;
            k1 = j1;
            j1 = l2;
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
_L2:
        if (j1 <= 0)
        {
            j1 = 0;
        }
        l2 = j1;
        i3 = i1;
        if (k1 > 0)
        {
            l2 = k1;
            k1 = j1;
            j1 = l2;
            continue; /* Loop/switch isn't completed */
        }
_L5:
        j1 = 0;
        i1 = i3;
        k1 = l2;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void setBroadcastTime(long l1)
    {
        e = l1;
    }

    public void setBroadcastTime(Date date)
    {
        e = date.getTime();
    }

    public void setBuilderId(long l1)
    {
        i = l1;
    }

    public void setContent(String s)
    {
        f = s;
    }

    public void setExtras(String s)
    {
        h = s;
    }

    public void setNotificationId(long l1)
    {
        j = l1;
    }

    public void setTitle(String s)
    {
        g = s;
    }

    public String toJSON()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            JSONObject jsonobject1 = new JSONObject();
            if (!ai.a(h))
            {
                JSONObject jsonobject2 = new JSONObject(h);
                jsonobject1.put(z[9], jsonobject2);
            }
            a(z[11], f, jsonobject1);
            a(z[3], g, jsonobject1);
            a(z[11], f, jsonobject1);
            jsonobject1.put(z[10], 0);
            jsonobject.put(z[6], jsonobject1);
            a(z[5], (new StringBuilder()).append(j).toString(), jsonobject);
            a(z[8], m, jsonobject);
            a(z[2], l, jsonobject);
            jsonobject.put(z[12], k);
            jsonobject.put(z[7], i);
            jsonobject.put(z[4], 3);
            jsonobject.put(z[1], 1);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        return jsonobject.toString();
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[13];
        i1 = 0;
        obj1 = "\002?";
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
    //                   0 519
    //                   1 526
    //                   2 533
    //                   3 540;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_540;
_L3:
        byte0 = 91;
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
            obj1 = "\\`\036\177=[l\013\1774\\P\036o+W";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "]y\017d)[k\017I6Ah5\177?";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "\\P\036\177/^j";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "Ag\005a\004Fv\032s";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "_|\rI2V";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "_P\ty5Fj\004b";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            i1 = 7;
            obj1 = "\\P\bc2^k\017d\004[k";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j2] = ((String) (obj));
            i1 = 8;
            obj1 = "Q`\004b>\\{5b\"Bj";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j2] = ((String) (obj));
            i1 = 9;
            obj1 = "\\P\017n/@n\031";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j2] = ((String) (obj));
            i1 = 10;
            obj1 = "Sk5b";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j2] = ((String) (obj));
            i1 = 11;
            obj1 = "\\P\ty5Fj\004b";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j2] = ((String) (obj));
            i1 = 12;
            obj1 = "\\P\005x7K";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j2] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 50;
          goto _L13
_L5:
        byte0 = 15;
          goto _L13
_L6:
        byte0 = 106;
          goto _L13
        byte0 = 22;
          goto _L13
    }
}
