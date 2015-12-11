// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.app.Notification;
import android.content.Context;
import cn.jpush.android.a;

// Referenced classes of package cn.jpush.android.api:
//            DefaultPushNotificationBuilder, CustomPushNotificationBuilder, PushNotificationBuilder

public class BasicPushNotificationBuilder extends DefaultPushNotificationBuilder
{

    private static final String z[];
    protected Context a;
    public String developerArg0;
    public int notificationDefaults;
    public int notificationFlags;
    public int statusBarDrawable;

    public BasicPushNotificationBuilder(Context context)
    {
        notificationDefaults = -1;
        notificationFlags = 16;
        statusBarDrawable = a.a;
        developerArg0 = "";
        if (context == null)
        {
            throw new IllegalArgumentException(z[1]);
        } else
        {
            a = context;
            return;
        }
    }

    static PushNotificationBuilder a(String s)
    {
        String as[] = s.split(z[0]);
        s = as[0];
        if (z[3].equals(s))
        {
            s = new BasicPushNotificationBuilder(a.d);
        } else
        if (z[4].equals(s))
        {
            s = new CustomPushNotificationBuilder(a.d);
        } else
        {
            s = new BasicPushNotificationBuilder(a.d);
        }
        s.a(as);
        return s;
    }

    public final String a()
    {
        return developerArg0;
    }

    final void a(Notification notification)
    {
        notification.defaults = notificationDefaults;
        notification.flags = notificationFlags;
        notification.icon = statusBarDrawable;
    }

    void a(String as[])
    {
        notificationDefaults = Integer.parseInt(as[1]);
        notificationFlags = Integer.parseInt(as[2]);
        statusBarDrawable = Integer.parseInt(as[3]);
        developerArg0 = as[4];
    }

    String b()
    {
        return (new StringBuilder()).append(notificationDefaults).append(z[0]).append(notificationFlags).append(z[0]).append(statusBarDrawable).append(z[0]).append(developerArg0).toString();
    }

    public String toString()
    {
        return (new StringBuilder(z[2])).append(b()).toString();
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[5];
        i = 0;
        obj1 = "\037C,K\037";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 322
    //                   1 329
    //                   2 336
    //                   3 343;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_343;
_L3:
        byte0 = 64;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "\016I?X`#s\035`%8h";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "\"}\000}#\037C,K\037";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "\"}\000}#";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "#i\000`/-";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 64;
          goto _L13
_L5:
        byte0 = 28;
          goto _L13
_L6:
        byte0 = 115;
          goto _L13
        byte0 = 20;
          goto _L13
    }
}
