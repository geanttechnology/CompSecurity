// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.app.Activity;
import android.util.Log;
import com.cyberlink.you.a;
import com.cyberlink.you.utility.d;
import java.util.Arrays;
import java.util.List;

public final class r
{

    private static final String a[] = {
        "chat.listScheduleSend", "backup.listAlbum", "friend.listSuggestions", "group.listGroupMembers", "group.listAlbum"
    };

    private static void a(Activity activity, String s, String s1, String s2)
    {
        com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_server_response));
    }

    public static void a(Activity activity, String s, String s1, String s2, String s3)
    {
        a(activity, s, s1, ((List) (null)), s2, s3);
    }

    public static void a(Activity activity, String s, String s1, String s2, String s3, boolean flag)
    {
        if (activity != null)
        {
            if (flag)
            {
                if (!s2.equals("200"))
                {
                    com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_click_deleted_album));
                    return;
                }
            } else
            {
                a(activity, s, s1, s2, s3);
                return;
            }
        }
    }

    private static void a(Activity activity, String s, String s1, List list, String s2)
    {
        if (!s1.equals("registerPhone") || !s2.equals("400"))
        {
            if (s1.equals("registerPhone") && s2.equals("429"))
            {
                com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_user_registerPhone_429));
                return;
            }
            if (s1.equals("verifyPhone") && s2.equals("400"))
            {
                com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_user_verifyPhone_400));
                return;
            }
            if (s1.equals("verifyPhone") && s2.equals("429"))
            {
                com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_user_verifyPhone_429));
                return;
            }
            if ((!s1.equals("checkPhone") || !s2.equals("400")) && (!s1.equals("bindLoginURL") || !s2.equals("404")) && !s1.equals("userInfo") && (!s1.equals("bindAccount") || !s2.equals("400")) && !s2.equals("200"))
            {
                a(activity, s, s1, s2);
                return;
            }
        }
    }

    public static void a(Activity activity, String s, String s1, List list, String s2, String s3)
    {
_L2:
        return;
        if (activity == null || a(s, s1)) goto _L2; else goto _L1
_L1:
        if (!com.cyberlink.you.a.a().c())
        {
            com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_no_network));
        } else
        {
            if (s2 != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            a(activity, s, s1, s2);
        }
_L4:
        Log.e("ServerErrorResponse", (new StringBuilder()).append("statuscode is ").append(s2).append(" : ").append(s).append(".").append(s1).toString());
        return;
        if (s2.equals("200")) goto _L2; else goto _L3
_L3:
        if (s.equals("user"))
        {
            a(activity, s, s1, list, s2);
        } else
        if (s.equals("friend"))
        {
            c(activity, s, s1, s2);
        } else
        if (s.equals("chat"))
        {
            b(activity, s, s1, s2);
        } else
        if (s.equals("media"))
        {
            d(activity, s, s1, s2);
        } else
        if (s.equals("invite"))
        {
            e(activity, s, s1, s2);
        } else
        if (s.equals("misc"))
        {
            f(activity, s, s1, s2);
        } else
        if (!s2.equals("200"))
        {
            a(activity, s, s1, s2);
        }
          goto _L4
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static boolean a(String s, String s1)
    {
        s = (new StringBuilder()).append(s).append(".").append(s1).toString();
        return Arrays.asList(a).contains(s);
    }

    private static void b(Activity activity, String s, String s1, String s2)
    {
        while (s1.equals("cancelScheduleSend") && s2.equals("400") || s2.equals("200")) 
        {
            return;
        }
        a(activity, s, s1, s2);
    }

    private static void c(Activity activity, String s, String s1, String s2)
    {
        if (s1.equals("friendInfoViaPublicID") && s2.equals("404"))
        {
            com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_friend_friendInfoViaPublicID_404));
        } else
        {
            if (s1.equals("add") && s2.equals("400"))
            {
                com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_friend_add_400));
                return;
            }
            if (!s2.equals("200"))
            {
                a(activity, s, s1, s2);
                return;
            }
        }
    }

    private static void d(Activity activity, String s, String s1, String s2)
    {
        if (s1.equals("mediaInfo") && s2.equals("404"))
        {
            com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_media_mediaInfo_404));
        } else
        if (!s2.equals("200"))
        {
            a(activity, s, s1, s2);
            return;
        }
    }

    private static void e(Activity activity, String s, String s1, String s2)
    {
        if (s1.equals("inviteFriend") && s2.equals("400"))
        {
            com.cyberlink.you.utility.d.a(activity, activity.getString(com.cyberlink.you.r.u_error_invite_inviteFriend_400));
        } else
        if (!s2.equals("200"))
        {
            a(activity, s, s1, s2);
            return;
        }
    }

    private static void f(Activity activity, String s, String s1, String s2)
    {
        while (s1.equals("adUnitInfo") && s2.equals("400") || s2.equals("200")) 
        {
            return;
        }
        a(activity, s, s1, s2);
    }

}
