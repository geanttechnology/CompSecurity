// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.view.View;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            AndroidNavigationPane

private class <init>
    implements android.support.v4.widget.ener
{

    boolean isDragging;
    final AndroidNavigationPane this$0;

    public void onDrawerClosed(View view)
    {
    }

    public void onDrawerOpened(View view)
    {
    }

    public void onDrawerSlide(View view, float f)
    {
        if (!isDragging && AndroidNavigationPane.access$300(AndroidNavigationPane.this) != null)
        {
            isDragging = true;
            for (view = AndroidNavigationPane.access$300(AndroidNavigationPane.this).iterator(); view.hasNext(); ((com.amazon.gallery.thor.view.r.this._cls0)view.next()).ged()) { }
        }
    }

    public void onDrawerStateChanged(int i)
    {
        if (i == 0)
        {
            isDragging = false;
            for (Iterator iterator = AndroidNavigationPane.access$300(AndroidNavigationPane.this).iterator(); iterator.hasNext();)
            {
                com.amazon.gallery.thor.view.r r = (com.amazon.gallery.thor.view.r.this._cls0)iterator.next();
                if (isDrawerOpen(0x800003))
                {
                    r.ed();
                } else
                {
                    r.ed();
                }
            }

        }
    }

    private Q()
    {
        this$0 = AndroidNavigationPane.this;
        super();
        isDragging = false;
    }

    isDragging(isDragging isdragging)
    {
        this();
    }
}
