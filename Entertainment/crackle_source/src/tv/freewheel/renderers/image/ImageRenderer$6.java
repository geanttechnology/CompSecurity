// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.image:
//            ImageRenderer

class this._cls0
    implements android.view.ener
{

    final ImageRenderer this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            ImageRenderer.access$1700(ImageRenderer.this).getImageMatrix().invert(ImageRenderer.access$2200(ImageRenderer.this));
            view = new float[2];
            view[0] = motionevent.getX();
            view[1] = motionevent.getY();
            ImageRenderer.access$2200(ImageRenderer.this).mapPoints(view);
            float f = view[0];
            float f1 = view[1];
            ImageRenderer.access$000(ImageRenderer.this).debug((new StringBuilder()).append("onTouch (").append(f).append(", ").append(f1).append(")").toString());
            if (f > 0.0F && f1 > 0.0F && f < (float)ImageRenderer.access$200(ImageRenderer.this) && f1 < (float)ImageRenderer.access$300(ImageRenderer.this))
            {
                ImageRenderer.access$700(ImageRenderer.this).dispatchEvent(ImageRenderer.access$500(ImageRenderer.this).EVENT_AD_CLICK());
                return true;
            }
            ImageRenderer.access$000(ImageRenderer.this).debug("touch event not in the image area.");
        }
        return false;
    }

    ntext()
    {
        this$0 = ImageRenderer.this;
        super();
    }
}
