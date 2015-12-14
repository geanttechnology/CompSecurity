// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            UserProfileActivity

class a extends AsyncTask
{

    final UserProfileActivity a;

    protected transient UserInfo a(Void avoid[])
    {
        avoid = AccountManager.d();
        if (avoid != null)
        {
            avoid.email = AccountManager.e();
        }
        return avoid;
    }

    protected void a(UserInfo userinfo)
    {
        String s;
        Uri uri;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        if (userinfo != null)
        {
            uri = userinfo.avatarUrl;
        } else
        {
            uri = null;
        }
        if (userinfo != null && userinfo.displayName != null)
        {
            s1 = userinfo.displayName;
        } else
        {
            s1 = a.getResources().getString(m.bc_me_anonymous);
        }
        if (userinfo != null && userinfo.description != null)
        {
            s2 = userinfo.description;
        } else
        {
            s2 = "";
        }
        if (userinfo != null && userinfo.email != null)
        {
            s3 = userinfo.email;
        } else
        {
            s3 = "";
        }
        if (userinfo != null && userinfo.receiveEmail != null)
        {
            s4 = userinfo.receiveEmail;
        } else
        {
            s4 = "";
        }
        if (userinfo != null && userinfo.region != null)
        {
            s = userinfo.region;
        } else
        {
            s = "";
        }
        if (!s.isEmpty())
        {
            s5 = s;
            if (s.length() < 5)
            {
                s5 = Locale.getDefault().toString();
            }
            com.cyberlink.beautycircle.utility.Source source;
            if (!AccountManager.a(s5))
            {
                s = a.getResources().getString(m.bc_user_profile_other_country);
            } else
            {
                s = i.b(s5);
            }
        } else
        {
            s = "";
        }
        if (userinfo != null)
        {
            s5 = String.valueOf(userinfo.id);
        } else
        {
            s5 = "null";
        }
        s6 = AccountManager.b();
        if (s6 == null)
        {
            s6 = "null";
        }
        if (userinfo != null && userinfo.userType != null)
        {
            s7 = userinfo.userType;
        } else
        {
            s7 = "null";
        }
        if (userinfo != null && userinfo.lastModified != null)
        {
            s8 = i.b(userinfo.lastModified);
        } else
        {
            s8 = "null";
        }
        if (userinfo != null && userinfo.avatarUrl != null)
        {
            s9 = userinfo.avatarUrl.toString();
        } else
        {
            s9 = "null";
        }
        if (userinfo != null && userinfo.coverUrl != null)
        {
            userinfo = userinfo.coverUrl.toString();
        } else
        {
            userinfo = "null";
        }
        source = AccountManager.f();
        UserProfileActivity.e(a).setImageURI(uri);
        UserProfileActivity.f(a).setText(s1);
        UserProfileActivity.g(a).setText(s2);
        if (source == com.cyberlink.beautycircle.utility.Source.a)
        {
            UserProfileActivity.h(a).setText(s3);
        } else
        {
            UserProfileActivity.h(a).setText(s4);
        }
        com.cyberlink.beautycircle.controller.activity.UserProfileActivity.i(a).setText(s);
        UserProfileActivity.j(a).setText(Globals.c());
        UserProfileActivity.k(a).setText(s5);
        UserProfileActivity.l(a).setText(s6);
        com.cyberlink.beautycircle.controller.activity.UserProfileActivity.m(a).setText(s7);
        if (source != null)
        {
            UserProfileActivity.n(a).setText(source.toString());
        }
        UserProfileActivity.o(a).setText(s8);
        UserProfileActivity.p(a).setText(s9);
        UserProfileActivity.q(a).setText(userinfo);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((UserInfo)obj);
    }

    (UserProfileActivity userprofileactivity)
    {
        a = userprofileactivity;
        super();
    }
}
