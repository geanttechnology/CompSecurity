// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.content.Context;
import android.net.Uri;
import com.target.ui.util.n;

// Referenced classes of package com.target.ui.fragment.account:
//            a

public class ExternalUrlLauncherImpl
    implements a
{

    private Context mContext;

    public ExternalUrlLauncherImpl(Context context)
    {
        mContext = context;
    }

    public void a(String s)
    {
        n.a(mContext, Uri.parse(s), null);
    }
}
