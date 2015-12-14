// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.controller;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.framework.kindle.activity.IntentPage;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import java.util.EnumSet;

// Referenced classes of package com.amazon.gallery.thor.controller:
//            NavigationPaneController

static final class ricsEvent extends IntentPage
{

    public boolean onClick(Activity activity)
    {
        GalleryWebViewHelper.startManageStorage(activity);
        return true;
    }

    ricsEvent(com.amazon.gallery.framework.kindle.metrics. , Intent intent, EnumSet enumset)
    {
        super(, intent, enumset);
    }
}
