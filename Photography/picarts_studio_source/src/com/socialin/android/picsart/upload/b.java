// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.upload;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.SocialinApiException;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.StatusObj;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.socialin.android.picsart.upload:
//            PicsartUploadEditActivity, e

final class b
    implements d
{

    private boolean a;
    private boolean b;
    private PicsartUploadEditActivity c;

    public b(PicsartUploadEditActivity picsartuploadeditactivity, boolean flag, boolean flag1)
    {
        c = picsartuploadeditactivity;
        super();
        a = flag;
        b = flag1;
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        boolean flag = true;
        com.socialin.android.d.a(PicsartUploadEditActivity.a(), new Object[] {
            "item_update: onFailure", exception.getLocalizedMessage()
        });
        request = c;
        com.socialin.android.dialog.g g = PicsartUploadEditActivity.b(c);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
            flag = false;
        }
        DialogUtils.dismissDialog(request, g, flag);
        if ("user_not_found".equals(((SocialinApiException)exception).getReason()))
        {
            SocialinV3.getInstance().removeDevice();
            com.socialin.android.picsart.upload.PicsartUploadEditActivity.d(c);
            return;
        } else
        {
            Utils.a(c, 0x7f0805cb);
            return;
        }
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (StatusObj)obj;
        request = c;
        Object obj1 = PicsartUploadEditActivity.b(c);
        boolean flag;
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DialogUtils.dismissDialog(request, ((android.app.Dialog) (obj1)), flag);
        if (obj != null)
        {
            request = ((StatusObj) (obj)).message;
        } else
        {
            request = null;
        }
        com.socialin.android.d.a(PicsartUploadEditActivity.a(), new Object[] {
            "item_update: onSuccess", request
        });
        if (request == null || !request.matches("Your photo submitted to #[a-zA-Z]* contest")) goto _L2; else goto _L1
_L1:
        obj = Pattern.compile("#[a-zA-Z]*").matcher(request);
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_176;
        }
        obj = ((Matcher) (obj)).group();
_L3:
        obj1 = AnalyticUtils.getInstance(c);
        if (obj == null)
        {
            obj = null;
        }
        ((AnalyticUtils) (obj1)).track(new com.socialin.android.apiv3.events.EventsFactory.ContestSubmitEvent(((String) (obj)), "picsart", true));
_L2:
        if (!TextUtils.isEmpty(request))
        {
            Utils.c(c, request);
            c.finish();
            return;
        } else
        {
            obj = e.a(PicsartUploadEditActivity.e(c).a);
            PicsartUploadEditActivity.f(c).isPublic = a;
            PicsartUploadEditActivity.f(c).isMature = b;
            PicsartUploadEditActivity.f(c).title = PicsartUploadEditActivity.e(c).a;
            PicsartUploadEditActivity.f(c).address = PicsartUploadEditActivity.e(c).c;
            PicsartUploadEditActivity.f(c).tags = (String[])((List) (obj)).toArray(new String[((List) (obj)).size()]);
            obj = c.getIntent();
            ((Intent) (obj)).putExtra("item", PicsartUploadEditActivity.f(c));
            c.setResult(-1, ((Intent) (obj)));
            c.finish();
            return;
        }
        obj;
        com.socialin.android.d.b(PicsartUploadEditActivity.a(), "item_update: onSuccess", ((Throwable) (obj)));
        obj = null;
          goto _L3
    }
}
