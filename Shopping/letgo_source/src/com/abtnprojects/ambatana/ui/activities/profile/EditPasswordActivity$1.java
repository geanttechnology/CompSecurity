// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.widget.Toast;
import com.parse.ParseException;
import com.parse.SaveCallback;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditPasswordActivity

class a
    implements SaveCallback
{

    final EditPasswordActivity a;

    public void done(ParseException parseexception)
    {
        if (parseexception == null)
        {
            Toast.makeText(a, a.getString(0x7f0901c0), 1).show();
            a.setResult(-1);
            a.finish();
            return;
        } else
        {
            Toast.makeText(a, 0x7f090072, 0).show();
            return;
        }
    }

    public volatile void done(Throwable throwable)
    {
        done((ParseException)throwable);
    }

    (EditPasswordActivity editpasswordactivity)
    {
        a = editpasswordactivity;
        super();
    }
}
