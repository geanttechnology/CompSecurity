// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.app.Activity;
import android.content.res.Resources;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            TitleUpdater, VideoTrimmerContextBar

private static class activity
    implements TitleUpdater
{

    private final Activity activity;

    public String getSubTitle(int i)
    {
        return "";
    }

    public String getTitle()
    {
        return activity.getResources().getString(0x7f0e0224);
    }

    public (Activity activity1)
    {
        activity = activity1;
    }
}
