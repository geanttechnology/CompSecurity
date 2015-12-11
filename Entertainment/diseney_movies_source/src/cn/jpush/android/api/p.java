// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.a;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;

final class p extends Handler
{

    private static final String z[];
    private NotificationManager a;
    private Notification b;

    public p(Looper looper, Notification notification, NotificationManager notificationmanager)
    {
        super(looper);
        b = notification;
        a = notificationmanager;
    }

    public final void handleMessage(Message message)
    {
        Object obj;
        Object obj1;
        boolean flag;
        super.handleMessage(message);
        obj = message.getData();
        flag = ((Bundle) (obj)).getBoolean(z[0]);
        obj1 = ((Bundle) (obj)).getString(z[2]);
        if (!flag || TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L2; else goto _L1
_L1:
        obj1 = BitmapFactory.decodeFile(((String) (obj1)));
        if (obj1 != null)
        {
            try
            {
                b.contentView.setImageViewBitmap(0x1020006, ((android.graphics.Bitmap) (obj1)));
            }
            catch (Exception exception)
            {
                x.j();
            }
        }
_L4:
        obj = ((Bundle) (obj)).getString(z[1]);
        if (!ai.a(((String) (obj))))
        {
            ServiceInterface.a(((String) (obj)), 1018, a.d);
        }
        a.notify(message.what, b);
        return;
_L2:
        x.b();
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "\005\017@cT\017";
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
            break MISSING_BLOCK_LABEL_281;
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
    //                   2 267
    //                   3 274;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 55;
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
            obj1 = "\001\031`eV\013\031Zr";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            j = 2;
            obj1 = "\n\025\177sg\r\b{";
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 108;
          goto _L11
_L3:
        i = 124;
          goto _L11
_L4:
        i = 19;
          goto _L11
_L5:
        i = 22;
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
