// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package org.lucasr.smoothie:
//            ItemManager, ItemManaged

private class <init>
    implements android.view.racker
{

    final ItemManager this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag2 = true;
        boolean flag1 = false;
        int i = motionevent.getAction();
        Object obj = ItemManager.this;
        boolean flag = flag2;
        if (i != 1)
        {
            if (i == 3)
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
        }
        ItemManager.access$602(((ItemManager) (obj)), flag);
        if (ItemManager.access$600(ItemManager.this) && ItemManager.access$400(ItemManager.this) != 2)
        {
            postUpdateItems();
        }
        obj = ItemManager.access$800(ItemManager.this).getOnTouchListener();
        flag = flag1;
        if (obj != null)
        {
            flag = ((android.view.uchListener) (obj)).ch(view, motionevent);
        }
        return flag;
    }

    private ()
    {
        this$0 = ItemManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
