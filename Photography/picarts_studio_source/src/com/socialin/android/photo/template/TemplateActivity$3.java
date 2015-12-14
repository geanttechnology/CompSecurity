// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import java.util.Observable;
import java.util.Observer;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity

final class a
    implements Observer
{

    private String a;

    public final void update(Observable observable, Object obj)
    {
        if (SocialinV3.getInstance().getSettings().isExifEnabled())
        {
            obj = a;
            if (SocialinV3.getInstance().isRegistered())
            {
                observable = SocialinV3.getInstance().getUser().username;
            } else
            {
                observable = null;
            }
            m.a(((String) (obj)), observable, null);
        }
    }

    (String s)
    {
        a = s;
        super();
    }
}
