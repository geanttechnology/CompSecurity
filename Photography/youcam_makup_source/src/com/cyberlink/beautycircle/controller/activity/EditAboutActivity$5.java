// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditAboutActivity

class a
    implements android.view.
{

    final EditAboutActivity a;

    public void onClick(View view)
    {
        if (EditAboutActivity.c(a) != null)
        {
            EditAboutActivity.c(a).setText("");
        }
    }

    (EditAboutActivity editaboutactivity)
    {
        a = editaboutactivity;
        super();
    }
}
