// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditProfileActivity

class a extends DebouncingOnClickListener
{

    final EditProfileActivity a;
    final a b;

    public void doClick(View view)
    {
        a.onLogoutTap();
    }

    ( , EditProfileActivity editprofileactivity)
    {
        b = ;
        a = editprofileactivity;
        super();
    }
}
