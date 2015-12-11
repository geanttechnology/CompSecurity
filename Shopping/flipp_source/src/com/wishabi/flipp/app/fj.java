// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.au;
import com.wishabi.flipp.b.t;

// Referenced classes of package com.wishabi.flipp.app:
//            fg

final class fj
    implements android.content.DialogInterface.OnClickListener
{

    final SharedPreferences a;
    final ViewGroup b;
    final fg c;

    fj(fg fg1, SharedPreferences sharedpreferences, ViewGroup viewgroup)
    {
        c = fg1;
        a = sharedpreferences;
        b = viewgroup;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        Object obj = fg.b(c).getText();
        Object obj1 = fg.c(c).getText();
        dialoginterface = fg.d(c).getText();
        if (obj == null || obj1 == null || dialoginterface == null)
        {
            return;
        }
        obj = obj.toString();
        obj1 = obj1.toString();
        dialoginterface = dialoginterface.toString();
        if (!((String) (obj1)).isEmpty())
        {
            a.edit().putString("email", ((String) (obj1))).commit();
        }
        if (!dialoginterface.isEmpty())
        {
            a.edit().putString("twitter_handle", dialoginterface).commit();
        }
        (new au(((String) (obj)), ((String) (obj1)), dialoginterface, ((CheckBox)b.findViewById(0x7f0b013a)).isChecked(), ((CheckBox)b.findViewById(0x7f0b013e)).isChecked())).execute(new Void[0]);
        a.a.a(((String) (obj)), t.a);
    }
}
