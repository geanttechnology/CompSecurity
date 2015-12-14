// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import bj;

// Referenced classes of package android.support.v7.internal.widget:
//            ActivityChooserView

public class a extends DataSetObserver
{

    final ActivityChooserView a;

    public void onChanged()
    {
        super.onChanged();
        ActivityChooserView.access$000(a).notifyDataSetChanged();
    }

    public void onInvalidated()
    {
        super.onInvalidated();
        ActivityChooserView.access$000(a).notifyDataSetInvalidated();
    }

    (ActivityChooserView activitychooserview)
    {
        a = activitychooserview;
        super();
    }
}
