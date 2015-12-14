// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.content.Intent;
import java.util.Map;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class b extends Thread
{

    private Map a;
    private Intent b;
    private ProfileActivity c;

    public final void run()
    {
        ProfileActivity.a(c, a, b);
    }

    (ProfileActivity profileactivity, Map map, Intent intent)
    {
        c = profileactivity;
        a = map;
        b = intent;
        super();
    }
}
