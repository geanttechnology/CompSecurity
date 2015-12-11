// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.shazam.android.k.h;
import com.shazam.c.i;
import com.shazam.model.Actions;
import com.shazam.model.Factory;
import java.util.List;

// Referenced classes of package com.shazam.android.widget.c:
//            a, d

public final class c
    implements a
{

    private final Factory a;
    private final com.shazam.android.k.i b;
    private final d c;

    public c(Factory factory, com.shazam.android.k.i j, d d1)
    {
        a = factory;
        b = j;
        c = d1;
    }

    private void a(Context context, Actions actions, com.shazam.android.k.f.i j, Bundle bundle)
    {
        if (actions != null)
        {
            if ((actions = h.a((List)((i)a.create(actions.urlParams)).a(actions.actions), b)) != null)
            {
                c.a(context, actions, j, bundle);
                return;
            }
        }
    }

    public final void a(Context context, Actions actions)
    {
        a(context, actions, (new com.shazam.android.k.f.i.a()).a());
    }

    public final void a(Context context, Actions actions, com.shazam.android.k.f.i j)
    {
        a(context, actions, j, null);
    }

    public final void a(View view, Actions actions, com.shazam.android.k.f.i j)
    {
        Bundle bundle = null;
        if (view.getContext() instanceof Activity)
        {
            bundle = android.support.v4.app.c.a((Activity)view.getContext(), view, "coverArt").a();
        }
        a(view.getContext(), actions, j, bundle);
    }
}
