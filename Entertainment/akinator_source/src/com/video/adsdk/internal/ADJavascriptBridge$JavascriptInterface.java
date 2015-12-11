// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.internal;

import android.util.Log;
import com.video.adsdk.interfaces.JavascriptBridgeListener;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.video.adsdk.internal:
//            ADJavascriptBridge

class this._cls0
{

    final ADJavascriptBridge this$0;

    public void _SetBackgroundColorOfNativePlayer(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Log.i("js->native", (new StringBuilder()).append("_SetBackgroundColorOfNativePlayer() color:").append(i).toString());
        for (Iterator iterator = m_listeners.iterator(); iterator.hasNext(); ((JavascriptBridgeListener)iterator.next()).onSetBackgroundColor(i)) { }
        break MISSING_BLOCK_LABEL_72;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void _nativeCall(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Log.i("js->native", (new StringBuilder()).append("_nativeCall() action:").append(s).append(", params:").append(s1).toString());
        if (s.startsWith("playMovie"))
        {
            ADJavascriptBridge.access$000(ADJavascriptBridge.this);
            for (s = m_listeners.iterator(); s.hasNext(); ((JavascriptBridgeListener)s.next()).onPlayMovie(s1)) { }
            break MISSING_BLOCK_LABEL_294;
        }
        break MISSING_BLOCK_LABEL_97;
        s;
        throw s;
        if (s.startsWith("display"))
        {
            for (s = m_listeners.iterator(); s.hasNext(); ((JavascriptBridgeListener)s.next()).onDisplay()) { }
            break MISSING_BLOCK_LABEL_294;
        }
        if (s.startsWith("finish"))
        {
            for (s = m_listeners.iterator(); s.hasNext(); ((JavascriptBridgeListener)s.next()).onFinish(Integer.parseInt(s1))) { }
            break MISSING_BLOCK_LABEL_294;
        }
        if (s.startsWith("track"))
        {
            for (s = m_listeners.iterator(); s.hasNext(); ((JavascriptBridgeListener)s.next()).onTrack(s1)) { }
            break MISSING_BLOCK_LABEL_294;
        }
        if (s.startsWith("showSkip"))
        {
            for (s = m_listeners.iterator(); s.hasNext(); ((JavascriptBridgeListener)s.next()).onShowSkip()) { }
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void _nativeLog(String s)
    {
        Log.i("js->native", (new StringBuilder()).append("_nativeLog() params:").append(s).toString());
    }

    public void _nativePrefetchCall(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        Log.i("js->native", (new StringBuilder()).append("_nativePrefetchCall() url:").append(s).append(", timestamp:").append(l).toString());
        for (Iterator iterator = m_listeners.iterator(); iterator.hasNext(); ((JavascriptBridgeListener)iterator.next()).onPrefetchURL(s, l)) { }
        break MISSING_BLOCK_LABEL_85;
        s;
        throw s;
        this;
        JVM INSTR monitorexit ;
    }

    public void jsError(String s, String s1)
    {
        Log.e("js->native", (new StringBuilder()).append("jsError() message:").append(s).append(", failingUrl:").append(s1).toString());
        for (Iterator iterator = m_listeners.iterator(); iterator.hasNext(); ((JavascriptBridgeListener)iterator.next()).onPageError(-8, s, s1)) { }
    }

    public void openURL(String s, boolean flag)
    {
        Log.i("js->native", (new StringBuilder()).append("openURL() url:").append(s).append(", inAppBrowser:").append(flag).toString());
        for (Iterator iterator = m_listeners.iterator(); iterator.hasNext(); ((JavascriptBridgeListener)iterator.next()).onOpenURLInBrowser(s, flag)) { }
    }

    public void showHTML(String s)
    {
        Log.i("js->native", (new StringBuilder()).append("showHTML() html:").append(s).toString());
    }

    ()
    {
        this$0 = ADJavascriptBridge.this;
        super();
    }
}
