// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.groupon.view.FixedPositionListView;

// Referenced classes of package com.groupon.fragment:
//            DateTimeFilterDialog

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, DateTimeFilterDialog datetimefilterdialog, Object obj)
    {
        datetimefilterdialog.resetButton = (TextView)ewbinder.etButton((View)ewbinder.ew(obj, 0x7f100216, "field 'resetButton'"), 0x7f100216, "field 'resetButton'");
        datetimefilterdialog.closeButton = (ImageButton)ewbinder.seButton((View)ewbinder.ew(obj, 0x7f100214, "field 'closeButton'"), 0x7f100214, "field 'closeButton'");
        datetimefilterdialog.background = (View)ewbinder.ew(obj, 0x7f10020c, "field 'background'");
        datetimefilterdialog.list1 = (FixedPositionListView)ewbinder.t1((View)ewbinder.ew(obj, 0x7f10020f, "field 'list1'"), 0x7f10020f, "field 'list1'");
        datetimefilterdialog.list2 = (FixedPositionListView)ewbinder.t2((View)ewbinder.ew(obj, 0x7f100210, "field 'list2'"), 0x7f100210, "field 'list2'");
        datetimefilterdialog.list3 = (FixedPositionListView)ewbinder.t3((View)ewbinder.ew(obj, 0x7f100211, "field 'list3'"), 0x7f100211, "field 'list3'");
        ewbinder = ewbinder.ew(obj).getResources();
        datetimefilterdialog.default_reset_text_color = ewbinder.getColor(0x7f0e00e1);
        datetimefilterdialog.modified_reset_text_color = ewbinder.getColor(0x7f0e0004);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (DateTimeFilterDialog)obj, obj1);
    }

    public void unbind(DateTimeFilterDialog datetimefilterdialog)
    {
        datetimefilterdialog.resetButton = null;
        datetimefilterdialog.closeButton = null;
        datetimefilterdialog.background = null;
        datetimefilterdialog.list1 = null;
        datetimefilterdialog.list2 = null;
        datetimefilterdialog.list3 = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((DateTimeFilterDialog)obj);
    }

    public ()
    {
    }
}
