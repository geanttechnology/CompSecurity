// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.invite;


// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            InviteActivity

final class <init> extends android.support.v4.view.nPageChangeListener
{

    private InviteActivity a;

    public final void onPageSelected(int i)
    {
        super.onPageSelected(i);
        InviteActivity.a(a, i);
    }

    (InviteActivity inviteactivity)
    {
        a = inviteactivity;
        super();
    }
}
