// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.groupon.view:
//            CircleRatingBar

public class 
    implements butterknife.nder
{

    public void bind(butterknife.nder nder, CircleRatingBar circleratingbar, Object obj)
    {
        circleratingbar.circle_one = (ImageView)nder.one((View)nder.redView(obj, 0x7f100196, "field 'circle_one'"), 0x7f100196, "field 'circle_one'");
        circleratingbar.circle_two = (ImageView)nder.two((View)nder.redView(obj, 0x7f100197, "field 'circle_two'"), 0x7f100197, "field 'circle_two'");
        circleratingbar.circle_three = (ImageView)nder.three((View)nder.redView(obj, 0x7f100198, "field 'circle_three'"), 0x7f100198, "field 'circle_three'");
        circleratingbar.circle_four = (ImageView)nder.four((View)nder.redView(obj, 0x7f100199, "field 'circle_four'"), 0x7f100199, "field 'circle_four'");
        circleratingbar.circle_five = (ImageView)nder.five((View)nder.redView(obj, 0x7f10019a, "field 'circle_five'"), 0x7f10019a, "field 'circle_five'");
    }

    public volatile void bind(butterknife.nder nder, Object obj, Object obj1)
    {
        bind(nder, (CircleRatingBar)obj, obj1);
    }

    public void unbind(CircleRatingBar circleratingbar)
    {
        circleratingbar.circle_one = null;
        circleratingbar.circle_two = null;
        circleratingbar.circle_three = null;
        circleratingbar.circle_four = null;
        circleratingbar.circle_five = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((CircleRatingBar)obj);
    }

    public ()
    {
    }
}
