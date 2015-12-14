// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import java.util.Observable;
import java.util.Observer;
import myobfuscated.cm.n;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.ck:
//            e, c

final class it>
    implements Observer
{

    private e a;

    public final void update(Observable observable, Object obj)
    {
        obj = ((n)obj).c;
        for (observable = e.d(a); observable == null || observable.isFinishing() || obj == null;)
        {
            return;
        }

        if (SocialinV3.getInstance().isRegistered())
        {
            observable = String.valueOf(SocialinV3.getInstance().getUser().id);
        } else
        {
            observable = null;
        }
        m.a(((String) (obj)), observable, e.a(a).q.c().toString());
        e.a(a, c.a(e.d(a), ((String) (obj))), "instagram");
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
