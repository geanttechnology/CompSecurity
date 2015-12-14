// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.DialogInterface;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity

final class a
    implements android.content.istener
{

    private DrawingGalleryActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        DrawingGalleryActivity.e(a).cancel(true);
        a.finish();
    }

    ener(DrawingGalleryActivity drawinggalleryactivity)
    {
        a = drawinggalleryactivity;
        super();
    }
}
