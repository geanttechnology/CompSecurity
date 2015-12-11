// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils.renderer;

import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

public class ParamParser
{

    private IRendererContext context;
    private Logger logger;
    private String paramNamespace;

    public ParamParser(IRendererContext irenderercontext, String s)
    {
        logger = Logger.getLogger(this, true);
        context = irenderercontext;
        paramNamespace = s;
    }
}
