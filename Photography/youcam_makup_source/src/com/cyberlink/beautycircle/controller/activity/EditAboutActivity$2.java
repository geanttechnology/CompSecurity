// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import android.widget.EditText;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditAboutActivity

class c extends AsyncTask
{

    final boolean a;
    final boolean b;
    final boolean c;
    final EditAboutActivity d;

    protected transient UserInfo a(Void avoid[])
    {
        avoid = AccountManager.d();
        if (avoid != null)
        {
            String s = ((UserInfo) (avoid)).displayName;
            if (s == null || s.isEmpty())
            {
                String s1 = AccountManager.e();
                if (s1 != null && !s1.isEmpty())
                {
                    avoid.displayName = s1.split("@")[0];
                }
            }
        }
        return avoid;
    }

    protected void a(UserInfo userinfo)
    {
        String s;
        if (a)
        {
            Object obj = d;
            if (userinfo != null && userinfo.displayName != null)
            {
                s = userinfo.displayName;
            } else
            {
                s = "";
            }
            EditAboutActivity.a(((EditAboutActivity) (obj)), s);
            EditAboutActivity.c(d).setText(EditAboutActivity.b(d));
            if (EditAboutActivity.b(d).length() > 0)
            {
                EditAboutActivity.c(d).setHint(EditAboutActivity.b(d));
            }
        }
        if (b)
        {
            obj = EditAboutActivity.d(d);
            if (userinfo != null && userinfo.description != null)
            {
                s = userinfo.description;
            } else
            {
                s = "";
            }
            ((EmojiconEditText) (obj)).setText(s);
        }
        if (c && userinfo != null && userinfo.avatarUrl != null)
        {
            EditAboutActivity.e(d).setImageURI(userinfo.avatarUrl);
        }
        if (userinfo != null && userinfo.websiteUrl != null)
        {
            EditAboutActivity.f(d).setText(userinfo.websiteUrl);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((UserInfo)obj);
    }

    (EditAboutActivity editaboutactivity, boolean flag, boolean flag1, boolean flag2)
    {
        d = editaboutactivity;
        a = flag;
        b = flag1;
        c = flag2;
        super();
    }
}
