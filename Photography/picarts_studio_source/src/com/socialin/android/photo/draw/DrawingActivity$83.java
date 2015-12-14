// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class c
    implements Runnable
{

    private String a;
    private HashMap b;
    private int c;
    private DrawingActivity d;

    public final void run()
    {
        DrawingActivity.a(d, a, b, c);
    }

    (DrawingActivity drawingactivity, String s, HashMap hashmap, int i)
    {
        d = drawingactivity;
        a = s;
        b = hashmap;
        c = i;
        super();
    }
}
