// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.utils.ViewUtils;

public class ListingStatusView extends View
{

    private com.poshmark.data_model.models.inner_models.Inventory.ListingStatus listingStatus;
    private Paint paint;
    private Bitmap statusBitmap;
    private boolean statusBool;
    private String statusString;

    public ListingStatusView(Context context)
    {
        super(context);
        statusBitmap = null;
        paint = new Paint();
        statusString = null;
        initInternal();
    }

    public ListingStatusView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        statusBitmap = null;
        paint = new Paint();
        statusString = null;
        initInternal();
    }

    private void initInternal()
    {
        paint.setColor(-1);
        float f = ViewUtils.dipToPixels(getContext(), 12F);
        paint.setTextSize(f);
        paint.setAntiAlias(true);
        paint.setShadowLayer(1.0F, 0.0F, -1F, 0xff000000);
        paint.setFlags(1);
    }

    public int getSuggestedMinimumHeight()
    {
        if (statusBitmap != null)
        {
            return statusBitmap.getHeight();
        } else
        {
            return 0;
        }
    }

    public int getSuggestedMinimumWidth()
    {
        if (statusBitmap != null)
        {
            return statusBitmap.getWidth();
        } else
        {
            return 0;
        }
    }

    public void onDraw(Canvas canvas)
    {
        if (statusString == null || statusBitmap == null)
        {
            return;
        }
        canvas.drawBitmap(statusBitmap, 0.0F, 0.0F, paint);
        Rect rect;
        if (statusBool)
        {
            paint.setColor(-1);
        } else
        {
            paint.setColor(0xff000000);
        }
        rect = new Rect();
        paint.getTextBounds(statusString, 0, statusString.length(), rect);
        canvas.drawText(statusString, (getWidth() / 2 - rect.width() / 2) + 5, getHeight() / 2 + rect.height() / 2, paint);
    }

    public void onMeasure(int i, int j)
    {
        if (statusBitmap != null)
        {
            setMeasuredDimension(statusBitmap.getWidth(), statusBitmap.getHeight());
            return;
        } else
        {
            setMeasuredDimension(0, 0);
            return;
        }
    }

    public void setListingStatus(com.poshmark.data_model.models.inner_models.Inventory.ListingStatus listingstatus)
    {
        listingStatus = listingstatus;
        if (listingStatus == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.RESERVED)
        {
            statusBitmap = BitmapFactoryInstrumentation.decodeResource(getResources(), 0x7f02013a);
            statusString = getResources().getString(0x7f06022b).toUpperCase();
            statusBool = true;
        } else
        if (listingStatus == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD)
        {
            statusBitmap = BitmapFactoryInstrumentation.decodeResource(getResources(), 0x7f02013c);
            statusString = getResources().getString(0x7f060285).toUpperCase();
            statusBool = true;
        } else
        if (listingStatus == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.NOT_FOR_SALE)
        {
            statusBitmap = BitmapFactoryInstrumentation.decodeResource(getResources(), 0x7f02012b);
            statusString = getResources().getString(0x7f0601d4).toUpperCase();
            statusBool = false;
        } else
        {
            statusBitmap = null;
            statusString = null;
        }
        requestLayout();
        invalidate();
    }
}
