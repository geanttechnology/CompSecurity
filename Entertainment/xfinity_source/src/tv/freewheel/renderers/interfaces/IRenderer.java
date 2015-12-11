// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.interfaces;


// Referenced classes of package tv.freewheel.renderers.interfaces:
//            IRendererContext

public interface IRenderer
{

    public abstract void dispose();

    public abstract double getDuration();

    public abstract void load(IRendererContext irenderercontext);

    public abstract void start();

    public abstract void stop();
}
