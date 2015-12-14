// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;

// Referenced classes of package com.facebook.drawee.drawable:
//            ForwardingDrawable

public class SettableDrawable extends ForwardingDrawable
{

    public SettableDrawable(Drawable drawable)
    {
        super((Drawable)Preconditions.checkNotNull(drawable));
    }

    public Drawable getDrawable()
    {
        return getCurrent();
    }

    public void setDrawable(Drawable drawable)
    {
        Preconditions.checkNotNull(drawable);
        setCurrent(drawable);
    }
}
