// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

// Referenced classes of package com.groupon.activity:
//            BugReport, GrouponActivity

public class inder extends inder
{

    public void bind(butterknife.ewBinder ewbinder, BugReport bugreport, Object obj)
    {
        super.bind(ewbinder, bugreport, obj);
        bugreport.senderEmail = (EditText)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f10011d, "field 'senderEmail'"), 0x7f10011d, "field 'senderEmail'");
        bugreport.bugDescription = (EditText)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f10011e, "field 'bugDescription'"), 0x7f10011e, "field 'bugDescription'");
        bugreport.screenshotView = (ImageView)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f10011f, "field 'screenshotView'"), 0x7f10011f, "field 'screenshotView'");
        bugreport.removeButton = (Button)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f100120, "field 'removeButton'"), 0x7f100120, "field 'removeButton'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (BugReport)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (BugReport)obj, obj1);
    }

    public void unbind(BugReport bugreport)
    {
        super.unbind(bugreport);
        bugreport.senderEmail = null;
        bugreport.bugDescription = null;
        bugreport.screenshotView = null;
        bugreport.removeButton = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((BugReport)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((BugReport)obj);
    }

    public inder()
    {
    }
}
