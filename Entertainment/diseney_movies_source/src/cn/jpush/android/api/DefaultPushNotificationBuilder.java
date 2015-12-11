// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.app.Notification;
import android.widget.RemoteViews;
import cn.jpush.android.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.util.Map;

// Referenced classes of package cn.jpush.android.api:
//            PushNotificationBuilder

public class DefaultPushNotificationBuilder
    implements PushNotificationBuilder
{

    private static final String z[];
    protected String b;

    public DefaultPushNotificationBuilder()
    {
    }

    public final Notification a(String s, Map map)
    {
        if (ai.a(s))
        {
            x.d(z[2], z[0]);
            return null;
        }
        if (map.containsKey(z[1]))
        {
            b = (String)map.get(z[1]);
        }
        if (b == null)
        {
            b = a.c;
        }
        map = new Notification(a.a, s, System.currentTimeMillis());
        a(((Notification) (map)));
        if (b == null)
        {
            b = a.c;
        }
        RemoteViews remoteviews = b(s);
        if (remoteviews != null)
        {
            map.contentView = remoteviews;
            return map;
        } else
        {
            map.setLatestEventInfo(a.d, b, s, null);
            return map;
        }
    }

    public String a()
    {
        return null;
    }

    void a(Notification notification)
    {
    }

    RemoteViews b(String s)
    {
        return null;
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "ajgU0[l!R<Nq.T1\017f(U+Jk3\033+@%4S0X+g|6Y`gN/\001";
        i = -1;
        j = 0;
_L10:
        Object obj;
        String as[];
        int k;
        int l;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        k = obj1.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        l = 0;
        as = ((String []) (obj));
        i1 = j;
        obj = obj1;
        j1 = i;
_L9:
        j = l;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[l];
        j % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 260
    //                   2 266
    //                   3 273;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 95;
_L11:
label0:
        {
            obj1[l] = (char)(i ^ k1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        i = k;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        k = i;
        l = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "LkiQ/Zv/\025>Aa5T6K+\tt\013fC\016x\036{L\bu\000lJ\to\032aQ\030o\026{I\002";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            j = 2;
            obj1 = "k`!Z*Cq\027N,GK(O6Il$Z+Fj)y*Fi#^-";
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 47;
          goto _L11
_L3:
        i = 5;
          goto _L11
_L4:
        i = 71;
          goto _L11
_L5:
        i = 59;
          goto _L11
        boolean flag = false;
        k1 = i;
        l1 = j;
        as1 = ((String []) (obj));
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
