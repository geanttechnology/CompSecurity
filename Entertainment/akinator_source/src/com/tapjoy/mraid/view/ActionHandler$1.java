// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import com.tapjoy.mraid.listener.Player;

// Referenced classes of package com.tapjoy.mraid.view:
//            ActionHandler

final class a
    implements Player
{

    final ActionHandler a;

    public final void onComplete()
    {
        a.finish();
    }

    public final void onError()
    {
        a.finish();
    }

    public final void onPrepared()
    {
    }

    (ActionHandler actionhandler)
    {
        a = actionhandler;
        super();
    }
}
