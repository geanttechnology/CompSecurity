// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Paint;
import android.view.View;
import android.widget.Adapter;
import com.aviary.android.feather.sdk.widget.AviaryAdapterView;
import com.aviary.android.feather.sdk.widget.AviaryGallery;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            DrawingPanel

class this._cls0
    implements com.aviary.android.feather.sdk.widget.nItemsScrollListener
{

    final DrawingPanel this$0;

    public void onScroll(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        mLogger.log((new StringBuilder()).append("onScroll: ").append(i).toString());
        DrawingPanel.access$102(DrawingPanel.this, i);
        DrawingPanel.access$500(DrawingPanel.this);
        mGallerySize.invalidateViews();
    }

    public void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        DrawingPanel.access$002(DrawingPanel.this, Math.max(4, mBrushSizes[i]));
        DrawingPanel.access$102(DrawingPanel.this, i);
        DrawingPanel.access$200(DrawingPanel.this).setStrokeWidth(DrawingPanel.access$000(DrawingPanel.this) * 2);
        mGallerySize.invalidateViews();
        if (mGalleryColor.getAdapter().getItemViewType(mGalleryColor.getSelectedItemPosition()) == 2)
        {
            DrawingPanel.access$300(DrawingPanel.this, awinTool.Erase);
            return;
        } else
        {
            DrawingPanel.access$300(DrawingPanel.this, awinTool.Draw);
            return;
        }
    }

    public void onScrollStarted(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        if (DrawingPanel.access$400(DrawingPanel.this) == awinTool.Zoom)
        {
            DrawingPanel.access$300(DrawingPanel.this, awinTool.Draw);
        }
    }

    ew()
    {
        this$0 = DrawingPanel.this;
        super();
    }
}
