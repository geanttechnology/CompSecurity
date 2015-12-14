// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.model.ImageItem;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            aa

final class ai extends BroadcastReceiver
{

    private aa a;

    private ai(aa aa1)
    {
        a = aa1;
        super();
    }

    ai(aa aa1, byte byte0)
    {
        this(aa1);
    }

    public final void onReceive(Context context, Intent intent)
    {
        byte byte0;
        byte0 = 0;
        a.a().loaded = false;
        aa.a(a, aa.o(a));
        context = intent.getAction();
        context.hashCode();
        JVM INSTR lookupswitch 3: default 72
    //                   -249376863: 111
    //                   700809531: 137
    //                   1035246301: 123;
           goto _L1 _L2 _L3 _L4
_L1:
        byte0 = -1;
          goto _L5
_L2:
        if (!context.equals("action.apply.after.like")) goto _L1; else goto _L5
_L4:
        if (!context.equals("action.apply.after.repost")) goto _L1; else goto _L6
_L6:
        byte0 = 1;
          goto _L5
_L3:
        if (!context.equals("action.apply.after.follow")) goto _L1; else goto _L7
_L7:
        byte0 = 2;
_L5:
        switch (byte0)
        {
        default:
            aa.a(a, "");
            return;

        case 0: // '\0'
            aa.a(a, "action.apply.after.like");
            return;

        case 1: // '\001'
            aa.a(a, "action.apply.after.repost");
            return;

        case 2: // '\002'
            aa.a(a, "action.apply.after.follow");
            break;
        }
        return;
    }
}
