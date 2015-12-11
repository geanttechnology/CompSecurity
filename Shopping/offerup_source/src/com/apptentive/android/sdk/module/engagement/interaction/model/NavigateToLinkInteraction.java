// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import android.app.Activity;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            Interaction, InteractionConfiguration

public class NavigateToLinkInteraction extends Interaction
{

    public static final String EVENT_KEY_SUCCESS = "success";
    public static final String EVENT_NAME_NAVIGATE = "navigate";
    public static final String KEY_TARGET = "target";
    public static final String KEY_URL = "url";

    public NavigateToLinkInteraction(String s)
    {
        super(s);
    }

    public Target getTarget()
    {
        InteractionConfiguration interactionconfiguration = getConfiguration();
        if (interactionconfiguration != null && !interactionconfiguration.isNull("target"))
        {
            return Target.parse(interactionconfiguration.optString("target", null));
        } else
        {
            return Target.New;
        }
    }

    public String getUrl()
    {
        Object obj = null;
        InteractionConfiguration interactionconfiguration = getConfiguration();
        String s = obj;
        if (interactionconfiguration != null)
        {
            s = obj;
            if (!interactionconfiguration.isNull("url"))
            {
                s = interactionconfiguration.optString("url", null);
            }
        }
        return s;
    }

    public void sendLaunchEvent(Activity activity)
    {
    }

    private class Target extends Enum
    {

        private static final Target $VALUES[];
        public static final Target New;
        public static final Target Self;

        public static Target parse(String s)
        {
            if (s == null) goto _L2; else goto _L1
_L1:
            Target atarget[];
            Target target;
            int i;
            int j;
            boolean flag;
            try
            {
                atarget = values();
                j = atarget.length;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                break; /* Loop/switch isn't completed */
            }
            i = 0;
_L3:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            target = atarget[i];
            flag = target.name().equalsIgnoreCase(s);
            if (flag)
            {
                return target;
            }
            i++;
            continue; /* Loop/switch isn't completed */
            if (true) goto _L3; else goto _L2
_L2:
            return New;
        }

        public static Target valueOf(String s)
        {
            return (Target)Enum.valueOf(com/apptentive/android/sdk/module/engagement/interaction/model/NavigateToLinkInteraction$Target, s);
        }

        public static Target[] values()
        {
            return (Target[])$VALUES.clone();
        }

        public final String lowercaseName()
        {
            return name().toLowerCase(Locale.US);
        }

        static 
        {
            New = new Target("New", 0);
            Self = new Target("Self", 1);
            $VALUES = (new Target[] {
                New, Self
            });
        }

        private Target(String s, int i)
        {
            super(s, i);
        }
    }

}
