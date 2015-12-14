// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.imagelib.decorator.sprite.ImageTransformPanel;

public class bkq extends gn
{

    final ImageTransformPanel a;

    private bkq(ImageTransformPanel imagetransformpanel)
    {
        a = imagetransformpanel;
        super();
    }

    public bkq(ImageTransformPanel imagetransformpanel, bko bko)
    {
        this(imagetransformpanel);
    }

    public boolean a(gl gl1)
    {
        ImageTransformPanel.b(a, ImageTransformPanel.b(a) - gl1.b());
        return true;
    }
}
