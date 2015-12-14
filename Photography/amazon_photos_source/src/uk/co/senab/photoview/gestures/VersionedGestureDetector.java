// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.gestures;

import android.content.Context;

// Referenced classes of package uk.co.senab.photoview.gestures:
//            CupcakeGestureDetector, GestureDetector, EclairGestureDetector, FroyoGestureDetector, 
//            OnGestureListener

public final class VersionedGestureDetector
{

    public static GestureDetector newInstance(Context context, OnGestureListener ongesturelistener)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 5)
        {
            context = new CupcakeGestureDetector(context);
        } else
        if (i < 8)
        {
            context = new EclairGestureDetector(context);
        } else
        {
            context = new FroyoGestureDetector(context);
        }
        context.setOnGestureListener(ongesturelistener);
        return context;
    }
}
