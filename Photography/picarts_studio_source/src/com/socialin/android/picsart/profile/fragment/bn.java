// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.widget.Button;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.SocialinApiException;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.util.Utils;
import com.socialin.android.util.b;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            bm

final class bn
    implements d
{

    private bm a;

    bn(bm bm1)
    {
        a = bm1;
        super();
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        Activity activity = a.getActivity();
        if (activity != null && !activity.isFinishing())
        {
            if (com.socialin.android.picsart.profile.fragment.bm.b(a) != null)
            {
                com.socialin.android.picsart.profile.fragment.bm.b(a).setClickable(true);
            }
            if (exception.getLocalizedMessage() != null)
            {
                request = exception.getLocalizedMessage();
            } else
            {
                request = activity.getString(0x7f080529);
            }
            Utils.c(activity, request);
            if ("user_not_found".equals(((SocialinApiException)exception).getReason()))
            {
                SocialinV3.getInstance().removeDevice();
                return;
            }
        }
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = a.getActivity();
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            return;
        }
        if (com.socialin.android.picsart.profile.fragment.bm.b(a) != null)
        {
            com.socialin.android.picsart.profile.fragment.bm.b(a).setClickable(true);
        }
        SocialinV3.getInstance().getUser().email = bm.c(a).email;
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            b.a(a.getActivity()).a(bm.c(a).email);
        }
        if (a.getTargetFragment() == null) goto _L2; else goto _L1
_L1:
        a.getTargetFragment().onActivityResult(a.getTargetRequestCode(), -1, a.getActivity().getIntent());
_L4:
        a.dismiss();
        return;
_L2:
        try
        {
            ((FragmentActionsListener)obj).onFragmentFinishWithResultOK(117);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(bm.a(), "onSuccess", ((Throwable) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
