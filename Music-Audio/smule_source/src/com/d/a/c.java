// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.d.a:
//            b

class c extends View
{

    private ArrayList a;

    public c(Context context)
    {
        super(context);
    }

    public void a(ArrayList arraylist)
    {
        a = arraylist;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i = 0;
        do
        {
            if (i >= a.size())
            {
                return;
            }
            ((b)a.get(i)).a(canvas);
            i++;
        } while (true);
    }
}
