// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;

// Referenced classes of package com.groupon.fragment:
//            FilterSheetViewFragment

public class adersListView
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, FilterSheetViewFragment filtersheetviewfragment, Object obj)
    {
        filtersheetviewfragment.filterList = (ExpandableStickyListHeadersListView)ewbinder.ckyListHeadersListView((View)ewbinder.ckyListHeadersListView(obj, 0x7f100290, "field 'filterList'"), 0x7f100290, "field 'filterList'");
        filtersheetviewfragment.filterSheetView = (LinearLayout)ewbinder.terSheetView((View)ewbinder.terSheetView(obj, 0x7f10028d, "field 'filterSheetView'"), 0x7f10028d, "field 'filterSheetView'");
        filtersheetviewfragment.dealCount = (TextView)ewbinder.lCount((View)ewbinder.lCount(obj, 0x7f10028f, "field 'dealCount'"), 0x7f10028f, "field 'dealCount'");
        filtersheetviewfragment.resetButton = (TextView)ewbinder.etButton((View)ewbinder.etButton(obj, 0x7f100216, "field 'resetButton'"), 0x7f100216, "field 'resetButton'");
        filtersheetviewfragment.closeButton = (ImageButton)ewbinder.seButton((View)ewbinder.seButton(obj, 0x7f100214, "field 'closeButton'"), 0x7f100214, "field 'closeButton'");
        filtersheetviewfragment.shade = (View)ewbinder.de(obj, 0x7f100213, "field 'shade'");
        filtersheetviewfragment.progressBar = (ProgressBar)ewbinder.gressBar((View)ewbinder.gressBar(obj, 0x7f10010b, "field 'progressBar'"), 0x7f10010b, "field 'progressBar'");
        ewbinder = ewbinder.gressBar(obj).getResources();
        filtersheetviewfragment.default_reset_text_color = ewbinder.getColor(0x7f0e00e1);
        filtersheetviewfragment.modified_reset_text_color = ewbinder.getColor(0x7f0e0004);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (FilterSheetViewFragment)obj, obj1);
    }

    public void unbind(FilterSheetViewFragment filtersheetviewfragment)
    {
        filtersheetviewfragment.filterList = null;
        filtersheetviewfragment.filterSheetView = null;
        filtersheetviewfragment.dealCount = null;
        filtersheetviewfragment.resetButton = null;
        filtersheetviewfragment.closeButton = null;
        filtersheetviewfragment.shade = null;
        filtersheetviewfragment.progressBar = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((FilterSheetViewFragment)obj);
    }

    public adersListView()
    {
    }
}
