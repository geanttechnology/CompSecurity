// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.database.ContentObserver;
import android.os.Handler;
import com.socialin.android.dialog.g;

// Referenced classes of package com.socialin.android.photo.clipart:
//            SelectClipArtFrameActivity, g, f

final class i extends ContentObserver
{

    private SelectClipArtFrameActivity a;

    public i(SelectClipArtFrameActivity selectclipartframeactivity, Handler handler)
    {
        a = selectclipartframeactivity;
        super(handler);
    }

    public final void onChange(boolean flag)
    {
        super.onChange(flag);
        if (SelectClipArtFrameActivity.a(a) != null && (SelectClipArtFrameActivity.a(a).getItem(0) instanceof f))
        {
            ((f)SelectClipArtFrameActivity.a(a).getItem(0)).g.show();
        }
    }
}
