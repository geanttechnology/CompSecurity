// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension;

import tv.freewheel.hybrid.ad.interfaces.IAdContext;
import tv.freewheel.hybrid.utils.Logger;

public class ParamParser
{

    private IAdContext context;
    private Logger logger;
    private String paramNamespace;

    public ParamParser(IAdContext iadcontext, String s)
    {
        context = iadcontext;
        paramNamespace = s;
        logger = Logger.getLogger(this);
    }

    private Object getNamespacedParam(String s)
    {
        Object obj = context.getParameter((new StringBuilder()).append(paramNamespace).append(".").append(s).toString());
        if (obj != null)
        {
            return obj;
        } else
        {
            return context.getParameter(s);
        }
    }

    private String getNamespacedParamStr(String s)
    {
        return (String)getNamespacedParam(s);
    }

    public Boolean parseBoolean(String s, Boolean boolean1)
    {
        String s1;
        s1 = getNamespacedParamStr(s);
        s = boolean1;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.trim().toLowerCase();
        if (!s1.equals("true") && !s1.equals("on") && !s1.equals("yes")) goto _L4; else goto _L3
_L3:
        s = Boolean.valueOf(true);
_L2:
        return s;
_L4:
        if (s1.equals("false") || s1.equals("off"))
        {
            break; /* Loop/switch isn't completed */
        }
        s = boolean1;
        if (!s1.equals("no")) goto _L2; else goto _L5
_L5:
        return Boolean.valueOf(false);
    }
}
