// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity

class a
    implements android.view.ersActivity._cls1
{

    final SelectUsersActivity a;

    public void onClick(View view)
    {
        view = new Intent();
        a.setResult(0, view);
        a.finish();
    }

    (SelectUsersActivity selectusersactivity)
    {
        a = selectusersactivity;
        super();
    }
}
