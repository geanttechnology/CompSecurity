// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.view.View;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class a
    implements d
{

    private FacebookWallPostActivity a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        Utils.a(FacebookWallPostActivity.a(a), "Post to Picsart Failed", 1);
        request = FacebookWallPostActivity.b();
        if (exception.getLocalizedMessage() != null)
        {
            exception = exception.getLocalizedMessage();
        } else
        {
            exception = " FbWallPost PicsArt upload -onFailure !!!";
        }
        com.socialin.android.d.c(new Object[] {
            request, exception
        });
        FacebookWallPostActivity.f(a);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        request = (ImageItem)obj;
        FacebookWallPostActivity.a(a, request);
        long l;
        if (request != null)
        {
            l = ((ImageItem) (request)).id;
        } else
        {
            l = -1L;
        }
        if (l < 0L)
        {
            FacebookWallPostActivity.f(a);
            return;
        }
        if (FacebookWallPostActivity.g(a) != null)
        {
            FacebookWallPostActivity.g(a).setVisibility(8);
        }
        String s;
        if (request == null)
        {
            obj = "";
        } else
        if (((ImageItem) (request)).url != null)
        {
            obj = ((ImageItem) (request)).url;
        } else
        if (request.getMidleUrl() != null)
        {
            obj = request.getMidleUrl();
        } else
        if (request.getSmallUrl() != null)
        {
            obj = request.getSmallUrl();
        } else
        {
            obj = request.getThumbUrl();
        }
        s = (new StringBuilder("http://picsart.com/i/")).append(l).toString();
        FacebookWallPostActivity.a(a, ((ImageItem) (request)).width);
        FacebookWallPostActivity.b(a, ((ImageItem) (request)).height);
        FacebookWallPostActivity.a(a, ((ImageItem) (request)).id);
        FacebookWallPostActivity.a(a, ((String) (obj)), s, Boolean.valueOf(true));
    }

    (FacebookWallPostActivity facebookwallpostactivity)
    {
        a = facebookwallpostactivity;
        super();
    }
}
