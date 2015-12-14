// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;


// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private boolean a;
    private DrawingActivity b;

    public final void run()
    {
        b.a();
        DrawingActivity.M(b);
        if (!a)
        {
            DrawingActivity.e(b);
        }
    }

    (DrawingActivity drawingactivity, boolean flag)
    {
        b = drawingactivity;
        a = flag;
        super();
    }
}
