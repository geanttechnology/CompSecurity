// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            ActivityChooserView

class ner extends android.support.v7.widget.dingListener
{

    final ActivityChooserView a;

    public ListPopupWindow getPopup()
    {
        return ActivityChooserView.b(a);
    }

    protected boolean onForwardingStarted()
    {
        a.a();
        return true;
    }

    protected boolean onForwardingStopped()
    {
        a.b();
        return true;
    }

    ner(ActivityChooserView activitychooserview, View view)
    {
        a = activitychooserview;
        super(view);
    }
}
