// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.notifications;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.bl;
import android.support.v4.e.a;
import com.b.a.a.j;
import com.offerup.android.e.e;
import com.squareup.otto.Bus;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.notifications.DefaultNotificationFactory;
import org.apache.commons.lang3.StringUtils;

public final class b extends DefaultNotificationFactory
{

    public b(Context context)
    {
        super(context);
    }

    public final Notification createNotification(PushMessage pushmessage, int i)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Context context;
        android.content.res.Resources resources;
        j j1;
        obj2 = null;
        UAirship.shared();
        context = UAirship.getApplicationContext();
        obj1 = pushmessage.getTitle();
        obj = pushmessage.getAlert();
        resources = context.getResources();
        i = a.a(pushmessage);
        j1 = j.a();
        pushmessage = ((PushMessage) (obj1));
        i;
        JVM INSTR tableswitch 0 7: default 92
    //                   0 328
    //                   1 287
    //                   2 95
    //                   3 421
    //                   4 95
    //                   5 255
    //                   6 389
    //                   7 258;
           goto _L1 _L2 _L3 _L4 _L5 _L4 _L6 _L7 _L8
_L1:
        pushmessage = ((PushMessage) (obj1));
_L4:
        obj1 = BitmapFactory.decodeResource(resources, 0x7f030000);
        obj2 = obj;
        i = 0;
        obj = pushmessage;
        pushmessage = ((PushMessage) (obj2));
_L9:
        obj2 = obj;
        if (StringUtils.isEmpty(((CharSequence) (obj))))
        {
            obj2 = context.getString(0x7f0900fe);
        }
        obj = pushmessage;
        if (StringUtils.isEmpty(pushmessage))
        {
            obj = context.getString(0x7f0900fd);
        }
        pushmessage = ((PushMessage) (obj1));
        if (obj1 == null)
        {
            pushmessage = BitmapFactory.decodeResource(resources, 0x7f030000);
        }
        obj = (new bl(context)).a(((CharSequence) (obj2))).b(((CharSequence) (obj))).a(0x7f020172);
        obj.e = pushmessage;
        pushmessage = ((bl) (obj)).a(Uri.parse((new StringBuilder("android.resource://")).append(context.getPackageName()).append("/2131230725").toString())).a();
        obj2 = pushmessage;
        if (i > 0)
        {
            com.offerup.android.b.a.getNonUIInstance().post(new e(i));
            obj2 = pushmessage;
        }
_L6:
        return ((Notification) (obj2));
_L8:
        i = j1.T() + 1;
        j1.k(i);
        Object obj3 = null;
        pushmessage = ((PushMessage) (obj));
        obj = obj1;
        obj1 = obj3;
        continue; /* Loop/switch isn't completed */
_L3:
        i = j1.T() + 1;
        j1.k(i);
        a.j();
        a.i();
        android.graphics.Bitmap bitmap = BitmapFactory.decodeResource(resources, 0x7f020172);
        pushmessage = ((PushMessage) (obj));
        obj = obj1;
        obj1 = bitmap;
        continue; /* Loop/switch isn't completed */
_L2:
        i = j1.T() + 1;
        j1.k(i);
        a.j();
        a.i();
        Object obj4;
        if (i > 1)
        {
            obj = context.getString(0x7f090168);
            pushmessage = String.format(context.getString(0x7f090167), new Object[] {
                Integer.valueOf(i)
            });
            obj1 = null;
        } else
        {
            Object obj5 = null;
            pushmessage = ((PushMessage) (obj));
            obj = obj1;
            obj1 = obj5;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        i = j1.T() + 1;
        j1.k(i);
        a.j();
        obj4 = null;
        pushmessage = ((PushMessage) (obj));
        obj = obj1;
        obj1 = obj4;
        if (true) goto _L9; else goto _L5
_L5:
        pushmessage = context.getString(0x7f0900fa);
        if (true) goto _L4; else goto _L10
_L10:
    }

    public final int getNextId(PushMessage pushmessage)
    {
        if (a.a(pushmessage) == 0)
        {
            return 101;
        } else
        {
            return super.getNextId(pushmessage);
        }
    }
}
