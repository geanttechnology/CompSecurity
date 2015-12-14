// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cy;

import android.content.Context;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package myobfuscated.cy:
//            a

final class it>
    implements Runnable
{

    private Context a;

    public final void run()
    {
        AnalyticUtils.getInstance(a).trackDeviceContactInfo("device_contact", myobfuscated.cy.a.d(a));
    }

    ext(Context context)
    {
        a = context;
        super();
    }
}
