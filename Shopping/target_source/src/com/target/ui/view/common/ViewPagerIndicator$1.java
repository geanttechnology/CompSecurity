// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.content.res.Resources;
import android.support.v4.view.a;
import android.support.v4.view.a.d;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

// Referenced classes of package com.target.ui.view.common:
//            ViewPagerIndicator

class this._cls0 extends a
{

    final ViewPagerIndicator this$0;

    private String a()
    {
        int i = ViewPagerIndicator.b(ViewPagerIndicator.this);
        return getResources().getString(0x7f090480, new Object[] {
            Integer.valueOf(i + 1), Integer.valueOf(com.target.ui.view.common.ViewPagerIndicator.a(ViewPagerIndicator.this))
        });
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.setItemCount(com.target.ui.view.common.ViewPagerIndicator.a(ViewPagerIndicator.this));
        accessibilityevent.setCurrentItemIndex(ViewPagerIndicator.b(ViewPagerIndicator.this));
    }

    public void onInitializeAccessibilityNodeInfo(View view, d d1)
    {
        super.onInitializeAccessibilityNodeInfo(view, d1);
        String s = a();
        view = s;
        if (!TextUtils.isEmpty(ViewPagerIndicator.c(ViewPagerIndicator.this)))
        {
            view = (new StringBuilder()).append(s).append((String)ViewPagerIndicator.c(ViewPagerIndicator.this)).toString();
        }
        d1.c(view);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        super.onPopulateAccessibilityEvent(view, accessibilityevent);
        accessibilityevent.getText().add(a());
        if (!TextUtils.isEmpty(ViewPagerIndicator.c(ViewPagerIndicator.this)))
        {
            accessibilityevent.getText().add(ViewPagerIndicator.c(ViewPagerIndicator.this));
        }
    }

    ()
    {
        this$0 = ViewPagerIndicator.this;
        super();
    }
}
