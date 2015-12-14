// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cy;

import android.content.Context;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.instagram.h;
import com.socialin.android.twitter.TwitterSessionManager;

// Referenced classes of package myobfuscated.cy:
//            a

final class it>
    implements Runnable
{

    private Context a;

    public final void run()
    {
        try
        {
            h.a(a, false);
            TwitterSessionManager.sendFriendsAnal(a, false);
            FacebookUtils.sendFriendsAnal(a, false);
            return;
        }
        catch (Exception exception)
        {
            ExceptionReportService.report(a, exception, String.valueOf(SocialinV3.getInstance().getUser().id));
        }
    }

    ext(Context context)
    {
        a = context;
        super();
    }
}
