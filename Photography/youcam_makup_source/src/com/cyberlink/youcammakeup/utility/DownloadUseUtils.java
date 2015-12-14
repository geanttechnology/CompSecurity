// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            PanelDataCenter

public class DownloadUseUtils
{

    private static boolean a = false;

    public static UseTemplate a(Activity activity)
    {
        if (activity == null || activity.getIntent() == null || a())
        {
            return null;
        } else
        {
            return (UseTemplate)activity.getIntent().getSerializableExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE");
        }
    }

    public static void a(Intent intent, Intent intent1)
    {
        if (intent == null || intent1 == null)
        {
            return;
        } else
        {
            intent1.putExtra("SHOULD_CONSUME_USE_TEMPLATE", intent.getBooleanExtra("SHOULD_CONSUME_USE_TEMPLATE", false));
            return;
        }
    }

    public static void a(Intent intent, boolean flag)
    {
        if (intent == null)
        {
            return;
        } else
        {
            intent.putExtra("SHOULD_CONSUME_USE_TEMPLATE", flag);
            return;
        }
    }

    public static void a(boolean flag)
    {
        a = flag;
    }

    public static boolean a()
    {
        return a;
    }

    public static boolean a(UseTemplate usetemplate)
    {
        return PanelDataCenter.f(usetemplate.typeGUID);
    }

    public static void b(Activity activity)
    {
        if (activity != null && activity.getIntent() != null)
        {
            if ((activity = activity.getIntent()).getBooleanExtra("SHOULD_CONSUME_USE_TEMPLATE", false))
            {
                activity.removeExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE");
                return;
            }
        }
    }

    public static boolean b(UseTemplate usetemplate)
    {
        return PanelDataCenter.d(usetemplate.typeGUID);
    }

    public static void c(Activity activity)
    {
        UseTemplate usetemplate;
        if (activity != null && activity.getIntent() != null)
        {
            if ((usetemplate = a(activity)) != null && !a(usetemplate) && !b(usetemplate) && !c(usetemplate))
            {
                activity.getIntent().removeExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE");
                return;
            }
        }
    }

    public static boolean c(UseTemplate usetemplate)
    {
        return PanelDataCenter.e(usetemplate.typeGUID);
    }


    private class UseTemplate
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public BeautyMode beautyMode;
        public final MakeupMode makeupMode;
        public final long tid;
        public final String typeGUID;

        public UseTemplate(long l, String s, MakeupMode makeupmode, BeautyMode beautymode)
        {
            tid = l;
            typeGUID = s;
            makeupMode = makeupmode;
            beautyMode = beautymode;
        }
    }

}
