// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.layer;

import android.graphics.Paint;
import com.socialin.android.brushlib.layer.BlendMode;
import java.io.Serializable;

public class LayerConfig
    implements Serializable
{

    private static final long serialVersionUID = 0x9c02cc46268885caL;
    private BlendMode blendMode;
    private int opacity;
    private boolean visibility;

    public LayerConfig()
    {
        setBlendMode(BlendMode.NORMAL);
        setOpacity(255);
        setVisibility(true);
    }

    public LayerConfig(BlendMode blendmode, int i, boolean flag)
    {
        blendMode = blendmode;
        opacity = i;
        visibility = flag;
    }

    public LayerConfig duplicateLayerConfig()
    {
        return new LayerConfig(getBlendMode(), getOpacity(), isVisibility());
    }

    public BlendMode getBlendMode()
    {
        return blendMode;
    }

    public int getOpacity()
    {
        return opacity;
    }

    public boolean isOpacityChanged(int i)
    {
        return opacity != i;
    }

    public boolean isVisibility()
    {
        return visibility;
    }

    public void setBlendMode(BlendMode blendmode)
    {
        blendMode = blendmode;
    }

    public void setOpacity(int i)
    {
        opacity = i;
    }

    public void setVisibility(boolean flag)
    {
        visibility = flag;
    }

    public Paint toPaint()
    {
        Paint paint = new Paint();
        paint.setAlpha(getOpacity());
        paint.setXfermode(getBlendMode().getXfermode());
        return paint;
    }

    public String toString()
    {
        return (new StringBuilder("Configs Blend Mode")).append(blendMode.getDisplayName()).append(" Visilbility:").append(visibility).append(" Opacity:").append(opacity).toString();
    }
}
