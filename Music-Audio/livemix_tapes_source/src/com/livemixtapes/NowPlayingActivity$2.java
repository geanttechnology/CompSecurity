// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.livemixtapes.ui.FadeImageButton;

// Referenced classes of package com.livemixtapes:
//            NowPlayingActivity, App

class this._cls0
    implements android.view.y._cls2
{

    final NowPlayingActivity this$0;

    public void onClick(View view)
    {
        boolean flag;
        if (NowPlayingActivity.access$0().booleanValue())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        NowPlayingActivity.access$1(Boolean.valueOf(flag));
        if (NowPlayingActivity.access$0().booleanValue())
        {
            try
            {
                view = new Intent("com.livemixtapes.action.PLAY");
                view.setPackage("com.livemixtapes");
                App.context.startService(view);
            }
            // Misplaced declaration of an exception variable
            catch (View view) { }
            NowPlayingActivity.playOrPause.setImageResource(0x7f02008e);
            return;
        }
        try
        {
            view = new Intent("com.livemixtapes.action.PAUSE");
            view.setPackage("com.livemixtapes");
            App.context.startService(view);
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        NowPlayingActivity.playOrPause.setImageResource(0x7f02008f);
    }

    ()
    {
        this$0 = NowPlayingActivity.this;
        super();
    }
}
