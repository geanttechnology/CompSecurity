// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.livemixtapes:
//            MainActivity, User, NowPlayingActivity, Login

class this._cls0
    implements android.view.tener
{

    final MainActivity this$0;

    public void onClick(View view)
    {
        User.logout();
        try
        {
            NowPlayingActivity.stop();
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        startActivity(new Intent(MainActivity.this, com/livemixtapes/Login));
    }

    ity()
    {
        this$0 = MainActivity.this;
        super();
    }
}
