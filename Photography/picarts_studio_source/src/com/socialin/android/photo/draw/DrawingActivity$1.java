// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a extends BroadcastReceiver
{

    private DrawingActivity a;

    public final void onReceive(Context context, Intent intent)
    {
        a.finish();
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
