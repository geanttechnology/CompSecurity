// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.common:
//            PhotoGalleryWidget

private static class widget extends Handler
    implements Runnable
{

    private final WeakReference widget;

    public void run()
    {
        PhotoGalleryWidget photogallerywidget = (PhotoGalleryWidget)widget.get();
        if (photogallerywidget == null || !PhotoGalleryWidget.access$1900(photogallerywidget)) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        boolean flag;
        flag = false;
        j = PhotoGalleryWidget.access$2000(photogallerywidget);
        i = 0;
_L8:
        int k = ((flag) ? 1 : 0);
        if (i >= PhotoGalleryWidget.access$2100(photogallerywidget).size()) goto _L4; else goto _L3
_L3:
        int l = (()PhotoGalleryWidget.access$2100(photogallerywidget).get(i)).dthPlusFramePadding();
        k = l;
        if (i < PhotoGalleryWidget.access$2100(photogallerywidget).size() - 1)
        {
            k = l + PhotoGalleryWidget.access$2200(photogallerywidget);
        }
        j += k;
        if (PhotoGalleryWidget.access$1700(photogallerywidget) + PhotoGalleryWidget.access$2300(photogallerywidget) >= j) goto _L6; else goto _L5
_L5:
        k = 1;
_L4:
        if (!PhotoGalleryWidget.access$2400(photogallerywidget) || k != 0)
        {
            PhotoGalleryWidget.access$2500(photogallerywidget, Boolean.valueOf(true));
            postDelayed(this, PhotoGalleryWidget.access$2600(photogallerywidget));
        }
_L2:
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public (PhotoGalleryWidget photogallerywidget)
    {
        widget = new WeakReference(photogallerywidget);
    }
}
