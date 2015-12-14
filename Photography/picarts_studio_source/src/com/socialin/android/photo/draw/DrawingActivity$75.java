// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class c
    implements Observer
{

    private String a;
    private String b;
    private String c;
    private DrawingActivity d;

    public final void update(Observable observable, Object obj)
    {
        if (!a.equalsIgnoreCase(".png"))
        {
            DrawingActivity.b(d, (new StringBuilder()).append(b).append("/").append(c).append(a).toString());
        }
    }

    (DrawingActivity drawingactivity, String s, String s1, String s2)
    {
        d = drawingactivity;
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
