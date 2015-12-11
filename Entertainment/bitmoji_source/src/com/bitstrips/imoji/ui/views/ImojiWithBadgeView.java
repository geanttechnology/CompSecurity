// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.bitstrips.imoji.models.Imoji;

// Referenced classes of package com.bitstrips.imoji.ui.views:
//            ImojiView

public class ImojiWithBadgeView extends ImojiView
{

    private static Rect destRect;
    private static Rect sourceRect;
    private static Bitmap unpurchasedIcon;

    public ImojiWithBadgeView(Context context)
    {
        super(context);
    }

    public ImojiWithBadgeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void drawPurchasedStateIcon(Canvas canvas)
    {
        if (getContext().getResources().getBoolean(0x7f080007))
        {
            if (unpurchasedIcon == null)
            {
                unpurchasedIcon = BitmapFactory.decodeResource(getContext().getResources(), 0x7f0200bf);
            }
            if (sourceRect == null)
            {
                sourceRect = new Rect(0, 0, unpurchasedIcon.getWidth(), unpurchasedIcon.getHeight());
            }
            if (destRect == null)
            {
                float f = getWidth();
                float f1 = getHeight();
                TypedValue typedvalue = new TypedValue();
                getResources().getValue(0x7f0a005b, typedvalue, true);
                float f2 = typedvalue.getFloat();
                destRect = new Rect((int)(f * f2), (int)(f1 * f2), (int)f, (int)f1);
            }
            if (imoji != null && imoji.isUnpurchased())
            {
                canvas.drawBitmap(unpurchasedIcon, sourceRect, destRect, null);
                return;
            }
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawPurchasedStateIcon(canvas);
    }
}
