// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Paint;
import android.view.View;
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
        DrawingPanel.access$500(DrawingPanel.this);
        DrawingPanel.access$602(DrawingPanel.this, mBrushColors[i]);
        DrawingPanel.access$702(DrawingPanel.this, i);
        DrawingPanel.access$200(DrawingPanel.this).setColor(DrawingPanel.access$600(DrawingPanel.this));
        mGalleryColor.invalidateViews();
    }

    public void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        DrawingPanel.access$602(DrawingPanel.this, mBrushColors[i]);
        DrawingPanel.access$702(DrawingPanel.this, i);
        DrawingPanel.access$200(DrawingPanel.this).setColor(DrawingPanel.access$600(DrawingPanel.this));
        if (DrawingPanel.access$600(DrawingPanel.this) == 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (DrawingPanel.access$400(DrawingPanel.this) != awinTool.Zoom) goto _L2; else goto _L1
_L1:
        if (i != 0)
        {
            DrawingPanel.access$300(DrawingPanel.this, awinTool.Erase);
        } else
        {
            DrawingPanel.access$300(DrawingPanel.this, awinTool.Draw);
        }
_L4:
        mGalleryColor.invalidateViews();
        return;
_L2:
        if (i != 0 && DrawingPanel.access$400(DrawingPanel.this) != awinTool.Erase)
        {
            DrawingPanel.access$300(DrawingPanel.this, awinTool.Erase);
        } else
        if (i == 0 && DrawingPanel.access$400(DrawingPanel.this) != awinTool.Draw)
        {
            DrawingPanel.access$300(DrawingPanel.this, awinTool.Draw);
        }
        if (true) goto _L4; else goto _L3
_L3:
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
