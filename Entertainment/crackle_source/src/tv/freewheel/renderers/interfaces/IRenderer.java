// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.interfaces;

import java.util.HashMap;

// Referenced classes of package tv.freewheel.renderers.interfaces:
//            IRendererContext

public interface IRenderer
{

    public abstract void dispose();

    public abstract double getDuration();

    public abstract HashMap getModuleInfo();

    public abstract double getPlayheadTime();

    public abstract void load(IRendererContext irenderercontext);

    public abstract void pause();

    public abstract void resize();

    public abstract void resume();

    public abstract void start();

    public abstract void stop();
}
