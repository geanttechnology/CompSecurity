// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView, MMVideoView

class this._cls0
    implements com.millennialmedia.internal.ewListener
{

    final VASTVideoView this$0;

    public void close()
    {
    }

    public boolean expand(com.millennialmedia.internal.er.ExpandParams expandparams)
    {
        return false;
    }

    public void onAdLeftApplication()
    {
    }

    public void onClicked()
    {
        VASTVideoView.access$100(VASTVideoView.this);
    }

    public void onFailed()
    {
    }

    public void onLoaded()
    {
    }

    public void onReady()
    {
        VASTVideoView.access$2100(VASTVideoView.this).callJavascript("MmJsBridge.vast.enableWebOverlay", new Object[0]);
        VASTVideoView.access$2100(VASTVideoView.this).callJavascript("MmJsBridge.vast.setDuration", new Object[] {
            Integer.valueOf(VASTVideoView.access$300(VASTVideoView.this).getDuration())
        });
        VASTVideoView.access$2100(VASTVideoView.this).callJavascript("MmJsBridge.vast.setState", new Object[] {
            "complete"
        });
    }

    public boolean resize(com.millennialmedia.internal.er.ResizeParams resizeparams)
    {
        return false;
    }

    public void setOrientation(int i)
    {
    }

    public void showCloseIndicator(boolean flag)
    {
    }

    izeParams()
    {
        this$0 = VASTVideoView.this;
        super();
    }
}
