// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;


// Referenced classes of package tv.freewheel.renderers.html:
//            MRAIDWebView

public interface IMRAIDPresentation
{

    public static final String FW_ASSET_CONTENT_HTML_BASE_URL = "http://m1.fwmrm.net/ad/mraid/start/";

    public abstract void close();

    public abstract void collapse();

    public abstract void dispose();

    public abstract void expand(String s, int i, int j);

    public abstract String getAbsoluteURL(String s);

    public abstract MRAIDWebView getCurrentView();

    public abstract void getDefaultPositionOnScreen(int ai[]);

    public abstract void loadCreativeWithScript(String s, String s1, String s2);

    public abstract void refresh();

    public abstract void resize(int i, int j, int k, int l, String s, boolean flag);

    public abstract void runJavaScript(String s);

    public abstract void setCloseButtonVisibility(boolean flag);

    public abstract void show();

    public abstract boolean supportsInlineVideo();
}
