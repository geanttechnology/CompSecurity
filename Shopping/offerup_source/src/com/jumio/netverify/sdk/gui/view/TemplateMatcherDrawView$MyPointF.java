// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.gui.view;

import android.graphics.PointF;

// Referenced classes of package com.jumio.netverify.sdk.gui.view:
//            TemplateMatcherDrawView

public class this._cls0 extends PointF
{

    final TemplateMatcherDrawView this$0;

    public void setX(float f)
    {
        set(f, y);
    }

    public void setY(float f)
    {
        set(x, f);
    }

    public (PointF pointf)
    {
        this$0 = TemplateMatcherDrawView.this;
        super(pointf.x, pointf.y);
    }
}
