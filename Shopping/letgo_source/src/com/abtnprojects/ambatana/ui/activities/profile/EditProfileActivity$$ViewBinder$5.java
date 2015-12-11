// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.view.View;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditProfileActivity

class a
    implements android.view..EditProfileActivity..ViewBinder._cls5
{

    final EditProfileActivity a;
    final sChanged b;

    public void onFocusChange(View view, boolean flag)
    {
        a.onUsernameFocusChanged(flag);
    }

    ( , EditProfileActivity editprofileactivity)
    {
        b = ;
        a = editprofileactivity;
        super();
    }
}
