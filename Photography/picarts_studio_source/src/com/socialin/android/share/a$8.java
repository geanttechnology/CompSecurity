// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.text.TextUtils;
import com.flurry.android.tumblr.PostListener;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements PostListener
{

    private a a;

    public final void onPostFailure(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            String s1 = s;
            if (s.trim().toLowerCase().equals("internalerror"))
            {
                s1 = a.getString(0x7f08047d);
            }
            Utils.a(a.getActivity(), s1, 0);
            return;
        } else
        {
            Utils.a(a.getActivity(), a.getString(0x7f0805ca), 0);
            return;
        }
    }

    public final void onPostSuccess(Long long1)
    {
        Utils.a(a.getActivity(), a.getString(0x7f0805e9), 0);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
