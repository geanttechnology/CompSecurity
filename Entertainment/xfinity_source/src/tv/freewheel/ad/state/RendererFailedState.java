// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;


// Referenced classes of package tv.freewheel.ad.state:
//            RendererState

public class RendererFailedState extends RendererState
{

    private static final RendererFailedState instance = new RendererFailedState();

    public RendererFailedState()
    {
    }

    public static RendererState Instance()
    {
        return instance;
    }

}
