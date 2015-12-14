// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.tencent.connect.a;
import com.tencent.tauth.c;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            s

public class QQUtils
{

    private static final String a;
    private c b;

    public QQUtils(Context context)
    {
        b = c.a(a, context);
    }

    public static void a(QQUserInfoResult qquserinforesult, UserInfo userinfo)
    {
        if (qquserinforesult != null && userinfo != null)
        {
            userinfo.displayName = qquserinforesult.nickname;
            userinfo.description = qquserinforesult.msg;
            if (qquserinforesult.gender != null)
            {
                if (qquserinforesult.gender.equals("\u7537"))
                {
                    userinfo.gender = "Male";
                    return;
                }
                if (qquserinforesult.gender.equals("\u5973"))
                {
                    userinfo.gender = "Female";
                    return;
                }
            }
        }
    }

    public void a(Activity activity, s s)
    {
        b.a(activity, "all", s);
    }

    public void a(Context context, s s)
    {
        (new a(context, b.c())).a(s);
    }

    public boolean a()
    {
        return b.a();
    }

    static 
    {
        a = Globals.n().getResources().getString(m.share_qq_app_id);
    }

    private class QQUserInfoResult extends Model
    {

        public String city;
        public Uri figureurl;
        public Uri figureurl_1;
        public Uri figureurl_2;
        public Uri figureurl_qq_1;
        public Uri figureurl_qq_2;
        public String gender;
        public Integer is_lost;
        public String is_yellow_vip;
        public String is_yellow_year_vip;
        public String level;
        public String msg;
        public String nickname;
        public String province;
        public Integer ret;
        public String vip;
        public String yellow_vip_level;

        public QQUserInfoResult()
        {
        }
    }

}
