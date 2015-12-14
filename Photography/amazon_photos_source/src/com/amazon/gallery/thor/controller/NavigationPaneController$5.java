// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.controller;

import android.app.Activity;
import com.amazon.gallery.framework.kindle.activity.Page;
import com.amazon.gallery.framework.kindle.widget.DebugPopup;
import java.util.EnumSet;

// Referenced classes of package com.amazon.gallery.thor.controller:
//            NavigationPaneController

static final class ricsEvent extends Page
{

    public boolean onClick(Activity activity)
    {
        (new DebugPopup(activity)).show();
        return true;
    }

    ricsEvent(com.amazon.gallery.framework.kindle.metrics. , EnumSet enumset)
    {
        super(, enumset);
    }
}
