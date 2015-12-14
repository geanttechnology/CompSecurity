// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.widget.lickListener
{

    private DrawingActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            DrawingActivity.W(a);
            return;

        case 1: // '\001'
            DrawingActivity.X(a);
            break;
        }
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
