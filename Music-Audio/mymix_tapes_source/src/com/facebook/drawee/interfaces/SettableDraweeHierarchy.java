// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.facebook.drawee.interfaces:
//            DraweeHierarchy

public interface SettableDraweeHierarchy
    extends DraweeHierarchy
{

    public abstract void reset();

    public abstract void setControllerOverlay(Drawable drawable);

    public abstract void setFailure(Throwable throwable);

    public abstract void setImage(Drawable drawable, float f, boolean flag);

    public abstract void setProgress(float f, boolean flag);

    public abstract void setRetry(Throwable throwable);
}
