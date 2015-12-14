// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.appboy.Appboy;
import com.appboy.AppboyUser;
import com.appboy.enums.NotificationSubscriptionType;
import com.socialin.android.constants.EventParam;
import com.socialin.android.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import myobfuscated.h.a;

public class b
{

    private static android.content.SharedPreferences.Editor c;
    private static SharedPreferences d;
    private static HashMap e = new HashMap();
    private static Set f = new HashSet();
    private static b g = null;
    public Appboy a;
    private final String b = com/socialin/android/util/b.getSimpleName();

    private b(Context context)
    {
        if (context == null)
        {
            return;
        }
        context = context.getApplicationContext();
        try
        {
            a = Appboy.getInstance(context);
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
        }
        e.put("edit_tools_apply", "Used Tools");
        e.put("effect_apply", "Used Effects");
        e.put("edit_mask", "Used Masks");
        e.put("draw_save", "Used Draw");
        e.put("edit_text", "Used Text");
        e.put("edit_callout_apply", "Used Callout");
        e.put("edit_lensflare_apply", "Used LensFlare");
        e.put("edit_sticker_apply", "Used Sticker");
        e.put("edit_clipart_apply", "Used Clipart");
        e.put("edit_frame_apply", "Used Frame");
        e.put("shape_mask_apply", "Used Shape Mask");
        e.put("edit_border_apply", "Used Border");
        e.put("explorer_photo_open", "Clicked on Explorer Photo");
        e.put("contest_open", "Contests Entered");
        e.put("contest_vote", "Contests Voted");
        e.put("photo_like", "Photo Likes");
        e.put("photo_comment", "Photo Comments");
        e.put("edit_photo_apply", "Used \"Add Photo\"");
        f.add("edit_open");
        f.add("effect_open");
        f.add("export_img");
        f.add("effect_done");
        f.add("explore_open");
        f.add("edit_tools_apply");
        f.add("collage_open");
        f.add("effect_apply");
        f.add("draw_open");
        f.add("collage_done");
        f.add("export_open");
        context = context.getSharedPreferences("CUSTOM_EVENTS", 4);
        d = context;
        c = context.edit();
    }

    public static b a(Context context)
    {
        if (g == null)
        {
            g = new b(context.getApplicationContext());
        }
        return g;
    }

    public static void a()
    {
        c.putBoolean("edit_open", false);
        c.putBoolean("effect_open", false);
        c.putBoolean("export_img", false);
        c.putBoolean("effect_done", false);
        c.putBoolean("explore_open", false);
        c.putBoolean("edit_tools_apply", false);
        c.putBoolean("collage_open", false);
        c.putBoolean("effect_apply", false);
        c.putBoolean("draw_open", false);
        c.putBoolean("collage_done", false);
        c.putBoolean("export_open", false);
        c.commit();
    }

    public final void a(long l)
    {
        if (l <= 1L || a == null)
        {
            return;
        } else
        {
            a.changeUser(String.valueOf(l));
            com.socialin.android.d.b(b, new Object[] {
                "changeUser - ", Long.valueOf(l)
            });
            a.requestFeedRefresh();
            a.requestInAppMessageRefresh();
            return;
        }
    }

    public final void a(String s)
    {
        if (TextUtils.isEmpty(s) || a == null)
        {
            return;
        } else
        {
            a.getCurrentUser().setEmail(s);
            com.socialin.android.d.b(b, new Object[] {
                "setEmail - ", s
            });
            return;
        }
    }

    public final void a(String s, int i)
    {
        if (a == null)
        {
            return;
        } else
        {
            a.getCurrentUser().setCustomUserAttribute(s, i);
            a.getCurrentUser().setCustomUserAttributeToNow((new StringBuilder("LastDate ")).append(s).toString());
            return;
        }
    }

    public final void a(String s, long l)
    {
        if (a == null)
        {
            return;
        } else
        {
            a.getCurrentUser().setCustomUserAttribute(s, l);
            a.getCurrentUser().setCustomUserAttributeToNow((new StringBuilder("LastDate ")).append(s).toString());
            return;
        }
    }

    public final void a(String s, boolean flag)
    {
        if (a == null)
        {
            return;
        } else
        {
            a.getCurrentUser().setCustomUserAttribute(s, flag);
            a.getCurrentUser().setCustomUserAttributeToNow((new StringBuilder("LastDate ")).append(s).toString());
            return;
        }
    }

    public final void a(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        if (a == null)
        {
            return;
        } else
        {
            a a1 = new a();
            a1.a(EventParam.STEP.getName(), s);
            a1.a(EventParam.PASSWORD.getName(), flag);
            a1.a(EventParam.DISPLAY_NAME.getName(), flag1);
            a1.a(EventParam.USERNAME.getName(), flag2);
            a1.a(EventParam.EMAIL.getName(), flag3);
            a1.a(EventParam.ABOUT.getName(), flag4);
            a.logCustomEvent("registration_step", a1);
            return;
        }
    }

    public final boolean a(NotificationSubscriptionType notificationsubscriptiontype)
    {
        return a != null && a.getCurrentUser().setPushNotificationSubscriptionType(notificationsubscriptiontype);
    }

    public final void b(String s)
    {
        boolean flag = false;
        if (!d.getBoolean(s, false))
        {
            flag = true;
        }
        if (flag && f.contains(s) && a != null && a.logCustomEvent(s))
        {
            c.putBoolean(s, true);
            c.commit();
        }
        if (e.containsKey(s))
        {
            b((String)e.get(s), 1);
        }
    }

    public final void b(String s, int i)
    {
        if (a == null)
        {
            return;
        } else
        {
            a.getCurrentUser().incrementCustomUserAttribute(s, i);
            a.getCurrentUser().setCustomUserAttributeToNow((new StringBuilder("LastDate ")).append(s).toString());
            return;
        }
    }

}
