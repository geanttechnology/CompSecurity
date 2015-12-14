// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.picsart.profile.util.p;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            aa

final class ac extends BroadcastReceiver
{

    private aa a;

    private ac(aa aa1)
    {
        a = aa1;
        super();
    }

    ac(aa aa1, byte byte0)
    {
        this(aa1);
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (a.isVisible()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        long l;
        context = intent.getAction();
        l = intent.getLongExtra("extra.item.id", -1L);
        if (context == null || l == -1L || aa.n(a) == null) goto _L1; else goto _L3
_L3:
        intent = aa.a(a, l);
        if (intent == null) goto _L1; else goto _L4
_L4:
        byte byte0 = -1;
        context.hashCode();
        JVM INSTR lookupswitch 8: default 144
    //                   -439576719: 318
    //                   144422676: 233
    //                   238496625: 289
    //                   413247412: 303
    //                   683773336: 275
    //                   734055697: 247
    //                   1561324152: 219
    //                   1730233005: 261;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L5:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_318;
_L14:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
        case 1: // '\001'
            intent.isReposted = true;
            intent.repostsCount = ((ImageItem) (intent)).repostsCount + 1;
            a.g.c();
            return;

        case 2: // '\002'
        case 3: // '\003'
            intent.isReposted = false;
            intent.repostsCount = ((ImageItem) (intent)).repostsCount - 1;
            a.g.c();
            return;

        case 4: // '\004'
            intent.isLiked = true;
            intent.likesCount = ((ImageItem) (intent)).likesCount + 1;
            a.g.b();
            return;

        case 5: // '\005'
            intent.isLiked = false;
            intent.likesCount = ((ImageItem) (intent)).likesCount - 1;
            a.g.b();
            return;

        case 6: // '\006'
            intent.commentsCount = ((ImageItem) (intent)).commentsCount + 1;
            a.d();
            return;

        case 7: // '\007'
            intent.commentsCount = ((ImageItem) (intent)).commentsCount - 1;
            break;
        }
        break MISSING_BLOCK_LABEL_439;
_L12:
        if (context.equals("com.picsart.studio.action.repost.gallery"))
        {
            byte0 = 0;
        }
          goto _L14
_L7:
        if (context.equals("com.picsart.studio.action.repost"))
        {
            byte0 = 1;
        }
          goto _L14
_L11:
        if (context.equals("com.picsart.studio.action.unrepost.gallery"))
        {
            byte0 = 2;
        }
          goto _L14
_L13:
        if (context.equals("com.picsart.studio.action.unrepost"))
        {
            byte0 = 3;
        }
          goto _L14
_L10:
        if (context.equals("com.picsart.studio.action.like"))
        {
            byte0 = 4;
        }
          goto _L14
_L8:
        if (context.equals("com.picsart.studio.action.unlike"))
        {
            byte0 = 5;
        }
          goto _L14
_L9:
        if (context.equals("com.picsart.studio.action.comment.remove"))
        {
            byte0 = 6;
        }
          goto _L14
        if (context.equals("com.picsart.studio.action.comment.add"))
        {
            byte0 = 7;
        }
          goto _L14
        a.d();
        return;
    }
}
