// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;


// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            MRAIDWebView

public interface IMRAIDPresentation
{

    public abstract void close();

    public abstract void collapse();

    public abstract void dispose();

    public abstract void expand(String s, int i, int j);

    public abstract String getAbsoluteURL(String s);

    public abstract MRAIDWebView getCurrentView();

    public abstract void getDefaultPositionOnScreen(int ai[]);

    public abstract void loadContent(String s);

    public abstract void loadURL(String s);

    public abstract void resize(int i, int j, int k, int l, String s, boolean flag);

    public abstract void runJavaScript(String s);

    public abstract void setCloseButtonVisibility(boolean flag);

    public abstract void show();

    public abstract boolean supportsInlineVideo();
}
