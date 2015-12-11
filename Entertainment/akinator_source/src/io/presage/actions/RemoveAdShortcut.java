// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.Context;
import io.presage.ads.NewAd;
import io.presage.utils.e;
import io.presage.utils.h;
import io.presage.utils.l;

// Referenced classes of package io.presage.actions:
//            NewAction

public class RemoveAdShortcut extends NewAction
{

    private NewAd a;
    private h c;

    public RemoveAdShortcut(Context context, NewAd newad)
    {
        super(context);
        a = newad;
        c = new h(context, "set_shortcut");
    }

    public String execute()
    {
        String s = (String)a.getOverridedParameterValue("identifier", java/lang/String);
        if (s == null)
        {
            e.c(new String[] {
                "Icon not installed. No identifier provided."
            });
            return null;
        }
        String s1 = (String)a.getOverridedParameterValue("icon_name", java/lang/String);
        if (s1 == null)
        {
            e.c(new String[] {
                "Icon not installed. No icon name provided."
            });
            return null;
        }
        if (c.contains(s))
        {
            l.a(b, s1);
            c.remove(s);
            return null;
        } else
        {
            e.c(new String[] {
                "Unable to remove an icon shortcut. Shortcut not installed."
            });
            return null;
        }
    }
}
