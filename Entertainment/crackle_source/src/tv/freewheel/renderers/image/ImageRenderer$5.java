// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.view.View;
import android.widget.ImageView;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.image:
//            ImageRenderer

class this._cls0
    implements android.view.archyChangeListener
{

    final ImageRenderer this$0;

    public void onChildViewAdded(View view, View view1)
    {
        ImageRenderer.access$000(ImageRenderer.this).debug("onChildViewAdded");
        if (ImageRenderer.access$1700(ImageRenderer.this) != null && ImageRenderer.access$1700(ImageRenderer.this) != view1)
        {
            ImageRenderer.access$1700(ImageRenderer.this).bringToFront();
        }
    }

    public void onChildViewRemoved(View view, View view1)
    {
        ImageRenderer.access$000(ImageRenderer.this).debug("onChildViewRemoved, do nothing");
    }

    ner()
    {
        this$0 = ImageRenderer.this;
        super();
    }
}
