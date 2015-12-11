// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.support.v7.hf;
import android.support.v7.iv;
import android.widget.Toast;
import com.parse.ParseException;
import com.parse.SaveCallback;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditProfileActivity

class a
    implements SaveCallback
{

    final EditProfileActivity a;

    public void done(ParseException parseexception)
    {
        iv.a(EditProfileActivity.a(a));
        if (parseexception == null)
        {
            EditProfileActivity.b(a).c(a);
            a.setResult(-1);
            a.finish();
            return;
        } else
        {
            Toast.makeText(a, 0x7f090072, 1).show();
            return;
        }
    }

    public volatile void done(Throwable throwable)
    {
        done((ParseException)throwable);
    }

    (EditProfileActivity editprofileactivity)
    {
        a = editprofileactivity;
        super();
    }
}
