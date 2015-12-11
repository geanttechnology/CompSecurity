// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.webkit.URLUtil;
import com.tapjoy.TapjoyLog;

// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class a
    implements Runnable
{

    final String a;
    final MraidView b;

    public final void run()
    {
        if (URLUtil.isValidUrl(a))
        {
            if (a.startsWith("javascript:"))
            {
                if (android.os.N.SDK_INT >= 19)
                {
                    try
                    {
                        String s = a.replaceFirst("javascript:", "");
                        MraidView.a(b, s);
                        return;
                    }
                    catch (Exception exception)
                    {
                        TapjoyLog.e("MRAIDView", (new StringBuilder("Exception in evaluateJavascript. Device not supported. ")).append(exception.toString()).toString());
                    }
                    return;
                } else
                {
                    MraidView.b(b, a);
                    return;
                }
            } else
            {
                (new <init>(b, (byte)0)).execute(new String[] {
                    a
                });
                return;
            }
        } else
        {
            b.loadDataWithBaseURL(null, "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Connection not Established</title></head><h2>Connection Not Properly Established</h2><body></body></html>", "text/html", "utf-8", null);
            return;
        }
    }

    (MraidView mraidview, String s)
    {
        b = mraidview;
        a = s;
        super();
    }
}
