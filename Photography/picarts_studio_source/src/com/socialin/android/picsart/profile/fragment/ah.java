// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.text.TextUtils;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            aa

final class ah
    implements d
{

    private ImageItem a;
    private aa b;

    public ah(aa aa1, ImageItem imageitem)
    {
        b = aa1;
        super();
        a = imageitem;
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        if (!TextUtils.isEmpty(exception.getLocalizedMessage()))
        {
            exception = exception.getLocalizedMessage();
        } else
        {
            exception = b.getString(0x7f0805cb);
        }
        com.socialin.android.d.b(aa.a, (new StringBuilder("removeStreamItem: onFailure-  ")).append(exception).toString());
        Utils.a(b.getActivity(), 0x7f0805cb);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        aa.c(b, a);
    }
}
