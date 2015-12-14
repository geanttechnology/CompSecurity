// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.view.View;
import android.widget.TextView;
import com.amazon.gallery.framework.model.TimelineEntry;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DividerViewFactory

public static class monthText extends android.support.v7.widget.ry.DividerHolder
{

    private TimelineEntry entry;
    final TextView monthText;
    final TextView yearText;

    public int getMonth()
    {
        return entry.getMonth();
    }

    public int getYear()
    {
        return entry.getYear();
    }

    void updateEntry(TimelineEntry timelineentry)
    {
        entry = timelineentry;
    }

    public Q(View view)
    {
        super(view);
        yearText = (TextView)view.findViewById(0x7f0c012b);
        monthText = (TextView)view.findViewById(0x7f0c012c);
    }
}
