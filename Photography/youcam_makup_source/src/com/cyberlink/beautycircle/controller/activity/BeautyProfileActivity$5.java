// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import android.view.View;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserAtrribute;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.i;
import com.perfectcorp.model.Model;
import java.util.Calendar;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            BeautyProfileActivity

class a extends AsyncTask
{

    final BeautyProfileActivity a;

    protected transient UserInfo a(Void avoid[])
    {
        avoid = AccountManager.d();
        if (avoid == null) goto _L2; else goto _L1
_L1:
        BeautyProfileActivity.a(a, null);
        if (((UserInfo) (avoid)).birthDay != null && !((UserInfo) (avoid)).birthDay.isEmpty())
        {
            BeautyProfileActivity.a(a, ((UserInfo) (avoid)).birthDay);
        }
        BeautyProfileActivity.b(a, -1);
        if (((UserInfo) (avoid)).gender == null || ((UserInfo) (avoid)).gender.isEmpty()) goto _L4; else goto _L3
_L3:
        if (!((UserInfo) (avoid)).gender.equals("Female")) goto _L6; else goto _L5
_L5:
        BeautyProfileActivity.b(a, j.user_profile_sex_female);
_L4:
        BeautyProfileActivity.a(a, (UserAtrribute)Model.a(com/cyberlink/beautycircle/model/UserAtrribute, ((UserInfo) (avoid)).attribute));
        BeautyProfileActivity.b(a, new UserAtrribute());
        UserAtrribute.a(BeautyProfileActivity.h(a), com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a));
        BeautyProfileActivity.c(a, -1);
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.isEmpty())
        {
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.equals("Normal"))
            {
                BeautyProfileActivity.c(a, j.user_profile_skin_normal);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.equals("Oily"))
            {
                BeautyProfileActivity.c(a, j.user_profile_skin_oily);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.equals("Combination"))
            {
                BeautyProfileActivity.c(a, j.user_profile_skin_combo);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.equals("Dry"))
            {
                BeautyProfileActivity.c(a, j.user_profile_skin_dry);
            }
        }
        BeautyProfileActivity.d(a, -1);
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.isEmpty())
        {
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Fair"))
            {
                BeautyProfileActivity.d(a, j.user_profile_skintone_fair);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Light"))
            {
                BeautyProfileActivity.d(a, j.user_profile_skintone_light);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Medium"))
            {
                BeautyProfileActivity.d(a, j.user_profile_skintone_med);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Deep"))
            {
                BeautyProfileActivity.d(a, j.user_profile_skintone_deep);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Dark"))
            {
                BeautyProfileActivity.d(a, j.user_profile_skintone_dark);
            }
        }
        BeautyProfileActivity.e(a, -1);
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).isSensitive != null)
        {
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).isSensitive.booleanValue())
            {
                BeautyProfileActivity.e(a, j.user_profile_skinsensitivity_yes);
            } else
            {
                BeautyProfileActivity.e(a, j.user_profile_skinsensitivity_no);
            }
        }
        BeautyProfileActivity.f(a, -1);
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.isEmpty())
        {
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Blue"))
            {
                BeautyProfileActivity.f(a, j.user_profile_eyecolor_blue);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Green"))
            {
                BeautyProfileActivity.f(a, j.user_profile_eyecolor_green);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Hazel"))
            {
                BeautyProfileActivity.f(a, j.user_profile_eyecolor_hazel);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("DarkBrown"))
            {
                BeautyProfileActivity.f(a, j.user_profile_eyecolor_darkbrown);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Gray"))
            {
                BeautyProfileActivity.f(a, j.user_profile_eyecolor_gray);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Black"))
            {
                BeautyProfileActivity.f(a, j.user_profile_eyecolor_black);
            }
        }
        BeautyProfileActivity.g(a, -1);
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength.isEmpty())
        {
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength.equals("Short"))
            {
                BeautyProfileActivity.g(a, j.user_profile_lashlength_short);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength.equals("Medium"))
            {
                BeautyProfileActivity.g(a, j.user_profile_lashlength_medium);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength.equals("Long"))
            {
                BeautyProfileActivity.g(a, j.user_profile_lashlength_long);
            }
        }
        BeautyProfileActivity.h(a, -1);
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.isEmpty())
        {
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.equals("Fine"))
            {
                BeautyProfileActivity.h(a, j.user_profile_hairtexture_fine);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.equals("Medium"))
            {
                BeautyProfileActivity.h(a, j.user_profile_hairtexture_medium);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.equals("Thick"))
            {
                BeautyProfileActivity.h(a, j.user_profile_hairtexture_thick);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.equals("Coarse"))
            {
                BeautyProfileActivity.h(a, j.user_profile_hairtexture_coarse);
            }
        }
        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, -1);
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.isEmpty())
        {
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Blonde"))
            {
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_blonde);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Red"))
            {
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_red);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Brown"))
            {
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_brown);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("DarkBrown"))
            {
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_darkbrown);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Gray"))
            {
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_gray);
            } else
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Black"))
            {
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_black);
            }
        }
        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, -1);
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType == null || com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.isEmpty()) goto _L2; else goto _L7
_L7:
        if (!com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.equals("Straight")) goto _L9; else goto _L8
_L8:
        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, j.user_profile_hairtype_straight);
_L2:
        return avoid;
_L6:
        if (((UserInfo) (avoid)).gender.equals("Male"))
        {
            BeautyProfileActivity.b(a, j.user_profile_sex_male);
        } else
        if (((UserInfo) (avoid)).gender.equals("Unspecified"))
        {
            BeautyProfileActivity.b(a, j.user_profile_sex_unspecified);
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.equals("Wavy"))
        {
            com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, j.user_profile_hairtype_wavy);
            return avoid;
        }
        if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.equals("Curly"))
        {
            com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, j.user_profile_hairtype_curly);
            return avoid;
        }
        if (!com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.equals("Coils")) goto _L2; else goto _L10
_L10:
        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, j.user_profile_hairtype_coils);
        return avoid;
        if (true) goto _L4; else goto _L11
_L11:
    }

    protected void a(UserInfo userinfo)
    {
        if (userinfo != null)
        {
            if (BeautyProfileActivity.a(a) == 1)
            {
                userinfo = a.findViewById(j.user_profile_private_info);
                if (userinfo != null)
                {
                    userinfo.setVisibility(8);
                }
            } else
            {
                BeautyProfileActivity.a(a, userinfo);
            }
        }
        userinfo = i.a(com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a));
        if (userinfo != null)
        {
            BeautyProfileActivity.k(a).setTime(userinfo);
            BeautyProfileActivity.l(a);
        }
        BeautyProfileActivity.a(a, com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.m(a), BeautyProfileActivity.n(a));
        BeautyProfileActivity.b(a, BeautyProfileActivity.o(a), BeautyProfileActivity.p(a));
        BeautyProfileActivity.a(a, BeautyProfileActivity.q(a), BeautyProfileActivity.r(a));
        BeautyProfileActivity.b(a, BeautyProfileActivity.s(a), BeautyProfileActivity.t(a));
        BeautyProfileActivity.a(a, BeautyProfileActivity.u(a), BeautyProfileActivity.v(a));
        BeautyProfileActivity.b(a, BeautyProfileActivity.w(a), BeautyProfileActivity.x(a));
        BeautyProfileActivity.b(a, BeautyProfileActivity.y(a), BeautyProfileActivity.z(a));
        BeautyProfileActivity.a(a, BeautyProfileActivity.A(a), BeautyProfileActivity.B(a));
        BeautyProfileActivity.b(a, BeautyProfileActivity.C(a), BeautyProfileActivity.D(a));
        BeautyProfileActivity.a(a, BeautyProfileActivity.p(a), j.bc_beauty_profile_skin_title_text, m.bc_beauty_profile_skin_title);
        BeautyProfileActivity.a(a, BeautyProfileActivity.r(a), j.bc_beauty_profile_skintone_title_text, m.bc_beauty_profile_skintone_title);
        BeautyProfileActivity.a(a, BeautyProfileActivity.t(a), j.bc_beauty_profile_skinsensitivity_title_text, m.bc_beauty_profile_skinsensitivity_title);
        BeautyProfileActivity.a(a, BeautyProfileActivity.v(a), j.bc_beauty_profile_eyecolor_title_text, m.bc_beauty_profile_eyecolor_title);
        BeautyProfileActivity.a(a, BeautyProfileActivity.x(a), j.bc_beauty_profile_lashlength_title_text, m.bc_beauty_profile_lashlength_title);
        BeautyProfileActivity.a(a, BeautyProfileActivity.z(a), j.bc_beauty_profile_hairtexture_title_text, m.bc_beauty_profile_hairtexture_title);
        BeautyProfileActivity.a(a, BeautyProfileActivity.B(a), j.bc_beauty_profile_haircolor_title_text, m.bc_beauty_profile_haircolor_title);
        BeautyProfileActivity.a(a, BeautyProfileActivity.D(a), j.bc_beauty_profile_hairtype_title_text, m.bc_beauty_profile_hairtype_title);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((UserInfo)obj);
    }

    (BeautyProfileActivity beautyprofileactivity)
    {
        a = beautyprofileactivity;
        super();
    }
}
