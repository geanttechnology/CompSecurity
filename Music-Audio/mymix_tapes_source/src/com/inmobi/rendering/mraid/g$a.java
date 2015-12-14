// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import java.lang.reflect.Field;

// Referenced classes of package com.inmobi.rendering.mraid:
//            g

static class a extends MediaController
{

    Context a;

    public void show(int i)
    {
        super.show(i);
        if (android.os.d.VERSION.SDK_INT >= 19)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        int ai[];
        try
        {
            obj = android/widget/MediaController.getDeclaredField("mAnchor");
            ((Field) (obj)).setAccessible(true);
            obj = (View)((Field) (obj)).get(this);
            obj1 = android/widget/MediaController.getDeclaredField("mDecor");
            ((Field) (obj1)).setAccessible(true);
            obj1 = (View)((Field) (obj1)).get(this);
            obj2 = android/widget/MediaController.getDeclaredField("mDecorLayoutParams");
            ((Field) (obj2)).setAccessible(true);
            obj2 = (android.view.owManager.LayoutParams)((Field) (obj2)).get(this);
            obj3 = android/widget/MediaController.getDeclaredField("mWindowManager");
            ((Field) (obj3)).setAccessible(true);
            obj3 = (WindowManager)((Field) (obj3)).get(this);
            ai = new int[2];
            ((View) (obj)).getLocationOnScreen(ai);
            ((View) (obj1)).measure(android.view..MeasureSpec.makeMeasureSpec(((View) (obj)).getWidth(), 0x80000000), android.view..MeasureSpec.makeMeasureSpec(((View) (obj)).getHeight(), 0x80000000));
            ((View) (obj1)).setPadding(0, 0, 0, 0);
            obj2.verticalMargin = 0.0F;
            obj2.horizontalMargin = 0.0F;
            obj2.width = ((View) (obj)).getWidth();
            obj2.gravity = 0x800033;
            obj2.x = ai[0];
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        i = ai[1];
        obj2.y = (((View) (obj)).getHeight() + i) - ((View) (obj1)).getMeasuredHeight();
        ((WindowManager) (obj3)).updateViewLayout(((View) (obj1)), ((android.view.Group.LayoutParams) (obj2)));
    }

    public utParams(Context context)
    {
        super(context);
        a = context;
    }
}
