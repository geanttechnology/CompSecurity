// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.livemixtapes:
//            ProfileFragment, User, NowPlayingActivity, MainActivity, 
//            Login

class this._cls0
    implements android.view.er
{

    final ProfileFragment this$0;

    public void onClick(View view)
    {
        User.logout();
        try
        {
            NowPlayingActivity.stop();
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        MainActivity.activity.startActivity(new Intent(MainActivity.activity, com/livemixtapes/Login));
        MainActivity.activity.finish();
    }

    ()
    {
        this$0 = ProfileFragment.this;
        super();
    }
}
