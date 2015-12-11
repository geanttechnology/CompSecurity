// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.a;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.x;
import java.util.Calendar;

// Referenced classes of package cn.jpush.android.service:
//            PushService

public class AlarmReceiver extends BroadcastReceiver
{

    private static final String z[];

    public AlarmReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        x.c();
        if (a.a(context.getApplicationContext()))
        {
            intent = PendingIntent.getBroadcast(context, 0, intent, 0);
            boolean flag = ae.a(context, z[0], z[3]).equals(z[3]);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            if (flag)
            {
                int i = ae.a(context, z[2], PushService.i);
                calendar.add(13, i);
                String.format(z[5], new Object[] {
                    Integer.valueOf(i)
                });
                x.d();
                ((AlarmManager)context.getSystemService(z[4])).set(0, calendar.getTimeInMillis(), intent);
                intent = new Intent(context, cn/jpush/android/service/PushService);
                intent.putExtra(z[1], z[1]);
                context.startService(intent);
                cn.jpush.android.util.a.m(context);
                return;
            }
        }
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[6];
        i = 0;
        obj1 = "I+\nx6T9*i\027T;";
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
    //                   0 345
    //                   1 352
    //                   2 359
    //                   3 366;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_366;
_L3:
        byte0 = 69;
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
            obj1 = "R,;";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "M\0216i R.9q";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "T*-x";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "A49o(";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "a49o(\000+,|7T=<=$G91seW1,ueI6,x7V94'e\005<+";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 32;
          goto _L13
_L5:
        byte0 = 88;
          goto _L13
_L6:
        byte0 = 88;
          goto _L13
        byte0 = 29;
          goto _L13
    }
}
