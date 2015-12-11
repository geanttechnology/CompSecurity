// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.widget.CompoundButton;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditProfileActivity

class a
    implements android.widget.ener
{

    final EditProfileActivity a;
    final a b;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        a.onKmChecked(flag);
    }

    ( , EditProfileActivity editprofileactivity)
    {
        b = ;
        a = editprofileactivity;
        super();
    }
}
