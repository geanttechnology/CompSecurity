// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.html:
//            MRAIDWebView

class this._cls0
    implements oggerBridge
{

    private static final String LOGGER_PREFIX = "-console-";
    final MRAIDWebView this$0;

    public void debug(String s)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug((new StringBuilder()).append("-console-").append(s).toString());
    }

    public void log(String s)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).info((new StringBuilder()).append("-console-").append(s).toString());
    }

    oggerBridge()
    {
        this$0 = MRAIDWebView.this;
        super();
    }
}
