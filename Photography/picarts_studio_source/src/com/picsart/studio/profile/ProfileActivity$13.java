// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.widget.TextView;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements Runnable
{

    private String a;
    private ProfileActivity b;

    public final void run()
    {
        ProfileActivity.s(b).setText(a);
    }

    (ProfileActivity profileactivity, String s)
    {
        b = profileactivity;
        a = s;
        super();
    }
}
