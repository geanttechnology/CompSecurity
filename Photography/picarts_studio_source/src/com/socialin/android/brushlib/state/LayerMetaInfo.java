// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.state;

import com.socialin.android.NoProGuard;
import com.socialin.android.brushlib.layer.BlendMode;
import java.io.Serializable;
import myobfuscated.ar.b;

public class LayerMetaInfo
    implements NoProGuard, Serializable
{

    private static final long serialVersionUID = 0x627639a39d027997L;
    private Object blendMode;
    public int color;
    public String currentBufferKey;
    public int height;
    public boolean isColorLayer;
    public boolean isVisible;
    public String key;
    public int opacity;
    public String origBufferKey;
    public int width;

    public LayerMetaInfo(int i, int j, String s, int k, int l, boolean flag, BlendMode blendmode)
    {
        key = s;
        isColorLayer = true;
        color = k;
        opacity = l;
        isVisible = flag;
        blendMode = blendmode;
        width = i;
        height = j;
    }

    public LayerMetaInfo(int i, int j, String s, String s1, String s2, int k, boolean flag, 
            BlendMode blendmode)
    {
        key = s;
        origBufferKey = s1;
        currentBufferKey = s2;
        opacity = k;
        isVisible = flag;
        isColorLayer = false;
        blendMode = blendmode;
        width = i;
        height = j;
    }

    public BlendMode getBlendMode()
    {
        if (blendMode instanceof BlendMode)
        {
            return (BlendMode)blendMode;
        } else
        {
            return BlendMode.convertFromObfuscatedVersion((b)blendMode);
        }
    }

    public String toString()
    {
        return (new StringBuilder("[Key: ")).append(key).append(", bufferKey: ").append(currentBufferKey).append(", origBufferKey: ").append(currentBufferKey).append("]").toString();
    }
}
