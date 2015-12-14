// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.social.activity;

import android.support.v7.widget.SearchView;
import android.view.View;

// Referenced classes of package com.socialin.android.social.activity:
//            SocialMainActivity

final class a
    implements android.view.ty.SocialMainActivity._cls2
{

    private SocialMainActivity a;

    public final void onClick(View view)
    {
        SocialMainActivity.a(a);
        SocialMainActivity.b(a).setQuery("", false);
    }

    (SocialMainActivity socialmainactivity)
    {
        a = socialmainactivity;
        super();
    }
}
