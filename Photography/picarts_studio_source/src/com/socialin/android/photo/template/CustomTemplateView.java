// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.graphics.Canvas;
import android.view.View;

// Referenced classes of package com.socialin.android.photo.template:
//            f

public class CustomTemplateView extends View
{

    private f a;

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        a.draw(canvas);
    }

    public void setTemplateDrawable(f f1)
    {
        a = f1;
    }
}
