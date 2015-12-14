// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements android.widget.lickListener
{

    private String a;
    private ProfileActivity b;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        ProfileActivity.a(b, a, i);
    }

    (ProfileActivity profileactivity, String s)
    {
        b = profileactivity;
        a = s;
        super();
    }
}
