// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.social.activity;


// Referenced classes of package com.socialin.android.social.activity:
//            SocialMainActivity

final class a
    implements android.support.v7.widget.tListener
{

    private SocialMainActivity a;

    public final boolean onQueryTextChange(String s)
    {
        return false;
    }

    public final boolean onQueryTextSubmit(String s)
    {
        return SocialMainActivity.a(a, s);
    }

    (SocialMainActivity socialmainactivity)
    {
        a = socialmainactivity;
        super();
    }
}
