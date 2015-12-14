// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.preference.CheckBoxPreference;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.preference:
//            a

final class a
    implements d
{

    private boolean a;
    private a b;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        DialogUtils.dismissDialog(b.getActivity(), com.socialin.android.preference.a.a(b));
        com.socialin.android.preference.a.b(b).setEnabled(true);
        if (exception.getLocalizedMessage() == null || exception.getLocalizedMessage().equals(""))
        {
            exception = b.getString(0x7f080237);
        } else
        {
            exception = exception.getLocalizedMessage();
        }
        Utils.b(b.getActivity(), exception);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        boolean flag = true;
        DialogUtils.dismissDialog(b.getActivity(), com.socialin.android.preference.a.a(b));
        SocialinV3.getInstance().getUser().mature = a;
        com.socialin.android.preference.a.b(b).setEnabled(true);
        obj = com.socialin.android.preference.a.b(b);
        if (a)
        {
            flag = false;
        }
        ((CheckBoxPreference) (obj)).setChecked(flag);
    }

    r(a a1, boolean flag)
    {
        b = a1;
        a = flag;
        super();
    }
}
