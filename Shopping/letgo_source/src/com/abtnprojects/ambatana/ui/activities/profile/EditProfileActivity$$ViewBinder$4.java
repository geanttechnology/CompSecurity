// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditProfileActivity

class a
    implements android.widget.ditProfileActivity..ViewBinder._cls4
{

    final EditProfileActivity a;
    final gUsername b;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        return a.onFinishEditingUsername(i);
    }

    ( , EditProfileActivity editprofileactivity)
    {
        b = ;
        a = editprofileactivity;
        super();
    }
}
