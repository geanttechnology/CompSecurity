// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.view:
//            UgcTipsSection

public class 
    implements butterknife.nder
{

    public void bind(butterknife.nder nder, UgcTipsSection ugctipssection, Object obj)
    {
        ugctipssection.header = (View)nder.iredView(obj, 0x7f100576, "field 'header'");
        ugctipssection.recommendText = (TextView)nder.((View)nder.iredView(obj, 0x7f100579, "field 'recommendText'"), 0x7f100579, "field 'recommendText'");
        ugctipssection.expandButton = (View)nder.iredView(obj, 0x7f100578, "field 'expandButton'");
        ugctipssection.tipsList = (LinearLayout)nder.((View)nder.iredView(obj, 0x7f10057a, "field 'tipsList'"), 0x7f10057a, "field 'tipsList'");
    }

    public volatile void bind(butterknife.nder nder, Object obj, Object obj1)
    {
        bind(nder, (UgcTipsSection)obj, obj1);
    }

    public void unbind(UgcTipsSection ugctipssection)
    {
        ugctipssection.header = null;
        ugctipssection.recommendText = null;
        ugctipssection.expandButton = null;
        ugctipssection.tipsList = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((UgcTipsSection)obj);
    }

    public ()
    {
    }
}
