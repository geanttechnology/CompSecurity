// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.livemixtapes:
//            MainActivity, NowPlayingActivity

class this._cls0
    implements android.view.tener
{

    final MainActivity this$0;

    public void onClick(View view)
    {
        try
        {
            if (MainActivity.isPlaying)
            {
                MainActivity.fromWidget = true;
                startActivity(new Intent(MainActivity.this, com/livemixtapes/NowPlayingActivity));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    ity()
    {
        this$0 = MainActivity.this;
        super();
    }
}
