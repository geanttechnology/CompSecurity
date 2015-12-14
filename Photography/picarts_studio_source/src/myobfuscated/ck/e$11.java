// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.util.Utils;
import com.socialin.android.util.o;
import com.socialin.android.util.x;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import myobfuscated.cm.n;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.ck:
//            e, c

final class t>
    implements Observer
{

    private e a;

    public final void update(Observable observable, Object obj)
    {
        Activity activity = e.d(a);
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        obj = ((n)obj).c;
        if (obj != null)
        {
            if (SocialinV3.getInstance().isRegistered())
            {
                observable = String.valueOf(SocialinV3.getInstance().getUser().id);
            } else
            {
                observable = null;
            }
            m.a(((String) (obj)), observable, e.a(a).q.c().toString());
            x.a(((String) (obj)), e.a(a).i().size(), e.a(a).b);
            new o(activity, ((String) (obj)), "image/*");
        }
        e.a(a, ((String) (obj)), "local");
        Utils.a(activity, ((String) (obj)));
        e.b(activity, "savetogallery");
    }

    util.Utils(e e1)
    {
        a = e1;
        super();
    }
}
