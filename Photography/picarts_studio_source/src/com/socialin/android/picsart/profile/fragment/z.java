// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.picsart.profile.adapter.aw;
import com.socialin.android.util.Utils;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cr.a;
import myobfuscated.cr.f;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            UserConnectionsFragment

public final class z extends UserConnectionsFragment
{

    public z()
    {
    }

    private void g()
    {
label0:
        {
            if (c.isEmpty())
            {
                if (!d)
                {
                    break label0;
                }
                android.app.Activity activity = getActivity();
                boolean flag;
                if (Utils.e(getActivity()) > 380F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a(m.a(activity, 0x7f080635, flag));
            }
            return;
        }
        a(m.a(getActivity(), 0x7f0803f7));
    }

    protected final a a(RecyclerViewAdapter recyclerviewadapter, long l)
    {
        return myobfuscated.cr.a.a(RequestControllerFactory.createGetViewerFollowingsController(l), recyclerviewadapter);
    }

    public final void a()
    {
        super.a();
        n = true;
        g();
    }

    public final void b(String s)
    {
        aw aw1 = c;
        Iterator iterator = aw1.itemsList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ViewerUser vieweruser = (ViewerUser)iterator.next();
            if (!vieweruser.username.equals(s))
            {
                continue;
            }
            aw1.remove(vieweruser);
            break;
        } while (true);
        g();
    }

    public final void onResume()
    {
        super.onResume();
        if (c.isEmpty() && !n)
        {
            a(false, true, true);
        }
    }
}
