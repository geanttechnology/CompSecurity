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
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            bk

final class bl
    implements d
{

    private bk a;

    bl(bk bk1)
    {
        a = bk1;
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
            if (bk.b(a) != null)
            {
                bk.b(a).setClickable(true);
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
        if (bk.b(a) != null)
        {
            bk.b(a).setClickable(true);
        }
        SocialinV3.getInstance().getUser().name = bk.c(a).name;
        if (!com.socialin.android.picsart.profile.fragment.bk.d(a).equals("")) goto _L2; else goto _L1
_L1:
        if (a.getTargetFragment() == null) goto _L4; else goto _L3
_L3:
        a.getTargetFragment().onActivityResult(a.getTargetRequestCode(), -1, a.getActivity().getIntent());
_L2:
        a.dismiss();
        return;
_L4:
        try
        {
            ((FragmentActionsListener)obj).onFragmentFinishWithResultOK(115);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(bk.a(), "onSuccess", ((Throwable) (obj)));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
