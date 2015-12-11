// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.groupon.fragment:
//            PoGCoachmarkDialog

public class _cls9
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, PoGCoachmarkDialog pogcoachmarkdialog, Object obj)
    {
        pogcoachmarkdialog.coachmarkImage = (ImageView)ewbinder.chmarkImage((View)ewbinder.View(obj, 0x7f10047a, "field 'coachmarkImage'"), 0x7f10047a, "field 'coachmarkImage'");
        pogcoachmarkdialog.coachmarkMessage = (TextView)ewbinder.chmarkMessage((View)ewbinder.View(obj, 0x7f10047c, "field 'coachmarkMessage'"), 0x7f10047c, "field 'coachmarkMessage'");
        pogcoachmarkdialog.actionButton = (Button)ewbinder.ionButton((View)ewbinder.View(obj, 0x7f10047d, "field 'actionButton'"), 0x7f10047d, "field 'actionButton'");
        pogcoachmarkdialog.cancelButton = (ImageView)ewbinder.celButton((View)ewbinder.View(obj, 0x7f10047b, "field 'cancelButton'"), 0x7f10047b, "field 'cancelButton'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (PoGCoachmarkDialog)obj, obj1);
    }

    public void unbind(PoGCoachmarkDialog pogcoachmarkdialog)
    {
        pogcoachmarkdialog.coachmarkImage = null;
        pogcoachmarkdialog.coachmarkMessage = null;
        pogcoachmarkdialog.actionButton = null;
        pogcoachmarkdialog.cancelButton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((PoGCoachmarkDialog)obj);
    }

    public _cls9()
    {
    }
}
