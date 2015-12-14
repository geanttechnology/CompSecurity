// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cy;

import android.app.Activity;
import com.firegnom.rat.util.DialogUtils;

// Referenced classes of package myobfuscated.cy:
//            d

final class it>
    implements Runnable
{

    private Activity a;

    public final void run()
    {
        DialogUtils.showNoNetworkDialog(a, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
    }

    (Activity activity)
    {
        a = activity;
        super();
    }
}
