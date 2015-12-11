// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.Toast;
import com.groupon.Channel;
import com.groupon.adapter.widget.DealImageAdapter;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            DealImageCarousel

public class CouponDetailsDealImageCarousel extends DealImageCarousel
    implements com.groupon.view.imagezoom.ImageViewTouch.OnImageViewTouchSingleTapListener
{

    String toastMessage;

    public CouponDetailsDealImageCarousel()
    {
    }

    protected DealImageAdapter getDealImageAdapter(List list)
    {
        list = new DealImageAdapter(this, list, dealId, channel.name());
        list.setSingleTapListener(this);
        return list;
    }

    public void onSingleTapConfirmed()
    {
        Toast.makeText(this, toastMessage, 1).show();
    }
}
