// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.app.LocalActivityManager;

// Referenced classes of package com.livemixtapes:
//            MainActivity

class this._cls0
    implements android.widget.angeListener
{

    final MainActivity this$0;

    public void onTabChanged(String s)
    {
        Activity activity = getLocalActivityManager().getActivity(s);
        if (activity != null)
        {
            activity.onWindowFocusChanged(true);
            s.equals("Profile");
        }
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
