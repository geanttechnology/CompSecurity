// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;


// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements android.support.v4.view.angeListener
{

    final ShareInActivity a;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        ShareInActivity.a(a, i);
        ShareInActivity.y(a);
    }

    (ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}
