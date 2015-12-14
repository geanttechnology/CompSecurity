// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;


// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            UserPhotosActivity

final class  extends android.support.v4.view.eChangeListener
{

    private UserPhotosActivity a;

    public final void onPageSelected(int i)
    {
        super.onPageSelected(i);
        UserPhotosActivity.a(a, i);
    }

    (UserPhotosActivity userphotosactivity)
    {
        a = userphotosactivity;
        super();
    }
}
