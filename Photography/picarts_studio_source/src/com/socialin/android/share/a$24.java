// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements d
{

    private a a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        m.b(a.getActivity(), com.socialin.android.share.a.l(a));
        Utils.a(a.getActivity(), 0x7f0802c9);
        a.getActivity().finish();
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        a.getActivity().sendBroadcast((new Intent()).setAction("com.picsart.studio.action.unrepost").putExtra("extra.item.id", com.socialin.android.share.a.f(a).id));
        obj = com.socialin.android.share.a.q(a).findViewWithTag("picsartRepost");
        if (obj != null)
        {
            obj = (ImageView)((View) (obj)).findViewById(0x7f100a6b);
            if (obj != null)
            {
                ((ImageView) (obj)).setImageDrawable(a.getResources().getDrawable(0x7f0205f2));
            }
        }
        com.socialin.android.share.a.f(a).isReposted = false;
        m.b(a.getActivity(), com.socialin.android.share.a.l(a));
        Utils.a(a.getActivity(), 0x7f080650);
        a.getActivity().finish();
    }

    .ImageItem(a a1)
    {
        a = a1;
        super();
    }
}
