// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering;


// Referenced classes of package com.inmobi.rendering:
//            RenderView

private final class <init>
    implements com.inmobi.rendering.mraid.cessor.a.a
{

    String a;
    final RenderView b;

    public void a(double d)
    {
        String s = (new StringBuilder()).append("broadcastEvent('micIntensityChange',").append(d).append(")").toString();
        b.a(a, s);
    }

    public void a(String s)
    {
        a = s;
    }

    private diaProcessor.a.a(RenderView renderview)
    {
        b = renderview;
        super();
    }

    b(RenderView renderview, b b1)
    {
        this(renderview);
    }
}
