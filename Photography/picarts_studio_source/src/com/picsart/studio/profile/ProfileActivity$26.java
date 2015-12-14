// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.view.View;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements android.support.v4.widget.Listener
{

    private ProfileActivity a;

    public final void onDrawerClosed(View view)
    {
        ProfileActivity.g(a);
    }

    public final void onDrawerOpened(View view)
    {
    }

    public final void onDrawerSlide(View view, float f)
    {
        ProfileActivity.a(a, f);
    }

    public final void onDrawerStateChanged(int i)
    {
    }

    istener(ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
