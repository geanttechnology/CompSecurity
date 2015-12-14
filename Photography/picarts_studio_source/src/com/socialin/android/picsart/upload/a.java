// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.upload;

import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.picsart.upload:
//            PicsartUploadEditActivity, e

final class a
    implements d
{

    private PicsartUploadEditActivity a;

    private a(PicsartUploadEditActivity picsartuploadeditactivity)
    {
        a = picsartuploadeditactivity;
        super();
    }

    a(PicsartUploadEditActivity picsartuploadeditactivity, byte byte0)
    {
        this(picsartuploadeditactivity);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        com.socialin.android.d.b(PicsartUploadEditActivity.a(), (new StringBuilder("getItem:onFailure  ")).append(exception.getLocalizedMessage()).toString());
        DialogUtils.dismissDialog(a, PicsartUploadEditActivity.b(a));
        com.socialin.android.picsart.upload.PicsartUploadEditActivity.d(a);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (ImageItem)obj;
        if (!a.isFinishing())
        {
            DialogUtils.dismissDialog(a, PicsartUploadEditActivity.b(a));
            if (obj == null)
            {
                com.socialin.android.picsart.upload.PicsartUploadEditActivity.d(a);
            } else
            {
                PicsartUploadEditActivity.a(a, ((ImageItem) (obj)));
                PicsartUploadEditActivity.a(a, ((ImageItem) (obj)).id);
            }
            PicsartUploadEditActivity.e(a).c(PicsartUploadEditActivity.f(a).getMidleUrl());
            if (PicsartUploadEditActivity.g(a))
            {
                PicsartUploadEditActivity.e(a).a(PicsartUploadEditActivity.f(a));
            }
        }
    }
}
