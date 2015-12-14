// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            HttpRedirection, OverlaySettings, AdViewOverlayActivity, VideoAd, 
//            MMLog

final class a
    implements Runnable
{

    private WeakReference a;

    public final void run()
    {
        directionListenerImpl directionlistenerimpl = (directionListenerImpl)a.get();
        if (directionlistenerimpl == null) goto _L2; else goto _L1
_L1:
        Object obj = HttpRedirection.a(directionlistenerimpl.a);
        if (obj == null) goto _L2; else goto _L3
_L3:
        Object obj1;
        Context context;
        directionlistenerimpl.c = Uri.parse(((String) (obj)));
        if (directionlistenerimpl.c == null)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        obj1 = null;
        context = (Context)directionlistenerimpl.b.get();
        if (context == null) goto _L2; else goto _L4
_L4:
        String s;
        s = directionlistenerimpl.c.getScheme();
        obj = obj1;
        if (s == null) goto _L6; else goto _L5
_L5:
        if (s.equalsIgnoreCase("mmvideo")) goto _L8; else goto _L7
_L7:
        obj = a(directionlistenerimpl);
_L6:
        if (obj == null) goto _L2; else goto _L9
_L9:
        obj1 = directionlistenerimpl.getOverlaySettings();
        if (obj != null && obj1 != null)
        {
            if (directionlistenerimpl.d != null)
            {
                obj1.f = directionlistenerimpl.d;
            }
            ((Intent) (obj)).putExtra("settings", ((android.os.Parcelable) (obj1)));
        }
        obj1 = ((Intent) (obj)).getStringExtra("class");
        if (obj1 != null && ((String) (obj1)).equals(com/millennialmedia/android/AdViewOverlayActivity.getCanonicalName())) goto _L2; else goto _L10
_L10:
        if (directionlistenerimpl.isActivityStartable(directionlistenerimpl.c))
        {
            c(context, ((Intent) (obj)));
            directionlistenerimpl.startingActivity(directionlistenerimpl.c);
        }
_L2:
        return;
_L8:
        obj = obj1;
        if (!directionlistenerimpl.isHandlingMMVideo(directionlistenerimpl.c))
        {
            VideoAd.playAd(context, directionlistenerimpl.c.getHost(), directionlistenerimpl);
            obj = obj1;
        }
        if (true) goto _L6; else goto _L11
_L11:
        obj;
        MMLog.a("HttpRedirection", String.format("No activity found for %s", new Object[] {
            directionlistenerimpl.c
        }), ((Throwable) (obj)));
        return;
        MMLog.e("HttpRedirection", String.format("Could not start activity for %s", new Object[] {
            obj
        }));
        return;
    }

    ity(WeakReference weakreference)
    {
        a = weakreference;
        super();
    }
}
