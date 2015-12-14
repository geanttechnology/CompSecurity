// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.livemixtapes:
//            NowPlayingActivity

class this._cls0
    implements android.view.y._cls4
{

    final NowPlayingActivity this$0;

    public void onClick(View view)
    {
        try
        {
            (new Intent("com.livemixtapes.action.STOP")).setPackage("com.livemixtapes");
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        NowPlayingActivity.previousTrack();
    }

    ()
    {
        this$0 = NowPlayingActivity.this;
        super();
    }
}
