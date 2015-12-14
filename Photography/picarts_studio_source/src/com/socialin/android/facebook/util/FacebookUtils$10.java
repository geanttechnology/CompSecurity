// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import com.firegnom.rat.util.DialogUtils;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class a
    implements Runnable
{

    private Activity a;

    public final void run()
    {
        DialogUtils.showNoNetworkDialog(a, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
    }

    _cls9(Activity activity)
    {
        a = activity;
        super();
    }
}
