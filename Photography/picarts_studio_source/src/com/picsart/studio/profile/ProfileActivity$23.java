// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.picsart.profile.fragment.y;
import com.socialin.android.picsart.profile.fragment.z;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a extends BroadcastReceiver
{

    private ProfileActivity a;

    public final void onReceive(Context context, Intent intent)
    {
        if (ProfileActivity.c(a) == null) goto _L2; else goto _L1
_L1:
        byte byte0;
        context = intent.getAction();
        byte0 = -1;
        context.hashCode();
        JVM INSTR lookupswitch 5: default 72
    //                   -1555240915: 116
    //                   -842164364: 144
    //                   -643138436: 158
    //                   -337176445: 130
    //                   1200538861: 172;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        byte0;
        JVM INSTR tableswitch 0 4: default 108
    //                   0 186
    //                   1 226
    //                   2 279
    //                   3 337
    //                   4 358;
           goto _L9 _L10 _L11 _L12 _L13 _L14
_L9:
        a.b();
_L2:
        return;
_L4:
        if (context.equals("com.picsart.studio.action.follow_from_followers"))
        {
            byte0 = 0;
        }
          goto _L3
_L7:
        if (context.equals("com.picsart.studio.action.unfollow_from_followings"))
        {
            byte0 = 1;
        }
          goto _L3
_L5:
        if (context.equals("com.picsart.studio.action.unfollow_from_followers"))
        {
            byte0 = 2;
        }
          goto _L3
_L6:
        if (context.equals("com.picsart.studio.action.update.tabs.create.membox"))
        {
            byte0 = 3;
        }
          goto _L3
_L8:
        if (context.equals("com.picsart.studio.action.update.tabs.delete.membox"))
        {
            byte0 = 4;
        }
          goto _L3
_L10:
        context = ProfileActivity.d(a);
        if (context != null)
        {
            context.a(true, false, false);
        }
        context = ProfileActivity.c(a);
        context.followingsCount = ((ViewerUser) (context)).followingsCount + 1;
          goto _L9
_L11:
        context = ProfileActivity.e(a);
        if (context != null)
        {
            context.a(true, false, false);
        }
        if (ProfileActivity.c(a).followingsCount > 0)
        {
            context = ProfileActivity.c(a);
            context.followingsCount = ((ViewerUser) (context)).followingsCount - 1;
        }
          goto _L9
_L12:
        context = intent.getStringExtra("com.picsart.studio.action.update.username");
        intent = ProfileActivity.d(a);
        if (intent != null)
        {
            intent.b(context);
        }
        if (ProfileActivity.c(a).followingsCount > 0)
        {
            context = ProfileActivity.c(a);
            context.followingsCount = ((ViewerUser) (context)).followingsCount - 1;
        }
          goto _L9
_L13:
        context = ProfileActivity.c(a);
        context.streamsCount = ((ViewerUser) (context)).streamsCount + 1;
          goto _L9
_L14:
        if (ProfileActivity.c(a).streamsCount > 0)
        {
            context = ProfileActivity.c(a);
            context.streamsCount = ((ViewerUser) (context)).streamsCount - 1;
        }
          goto _L9
    }

    y(ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
