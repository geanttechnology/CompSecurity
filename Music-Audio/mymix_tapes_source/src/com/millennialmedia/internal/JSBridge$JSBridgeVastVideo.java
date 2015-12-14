// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class this._cls0
{

    final JSBridge this$0;

    public void close(String s)
    {
        s = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (s instanceof com.millennialmedia.internal.video.iew)
        {
            ((com.millennialmedia.internal.video.iew)s).close();
            return;
        } else
        {
            MMLog.e(JSBridge.access$000(), "Close cannot be called on a WebView that is not part of a VAST Video creative.");
            return;
        }
    }

    public void pause(String s)
    {
        s = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (s instanceof com.millennialmedia.internal.video.iew)
        {
            ((com.millennialmedia.internal.video.iew)s).pause();
            return;
        } else
        {
            MMLog.e(JSBridge.access$000(), "Pause cannot be called on a WebView that is not part of a VAST Video creative.");
            return;
        }
    }

    public void play(String s)
    {
        s = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (s instanceof com.millennialmedia.internal.video.iew)
        {
            ((com.millennialmedia.internal.video.iew)s).play();
            return;
        } else
        {
            MMLog.e(JSBridge.access$000(), "Play cannot be called on a WebView that is not part of a VAST Video creative.");
            return;
        }
    }

    public void restart(String s)
    {
        s = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (s instanceof com.millennialmedia.internal.video.iew)
        {
            ((com.millennialmedia.internal.video.iew)s).restart();
            return;
        } else
        {
            MMLog.e(JSBridge.access$000(), "Restart cannot be called on a WebView that is not part of a VAST Video creative.");
            return;
        }
    }

    public void seek(String s)
        throws JSONException
    {
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview instanceof com.millennialmedia.internal.video.iew)
        {
            int i = (new JSONObject(s)).getInt("seekTime");
            ((com.millennialmedia.internal.video.iew)mmwebview).seek(i);
            return;
        } else
        {
            MMLog.e(JSBridge.access$000(), "Seek cannot be called on a WebView that is not part of a VAST Video creative.");
            return;
        }
    }

    public void setTimeInterval(String s)
        throws JSONException
    {
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview instanceof com.millennialmedia.internal.video.iew)
        {
            int i = (new JSONObject(s)).optInt("timeInterval", -1);
            ((com.millennialmedia.internal.video.iew)mmwebview).setTimeInterval(i);
            return;
        } else
        {
            MMLog.e(JSBridge.access$000(), "SetTimeInterval can't be called on a WebView that is not part of a VAST Video creative.");
            return;
        }
    }

    public void skip(String s)
    {
        s = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (s instanceof com.millennialmedia.internal.video.iew)
        {
            ((com.millennialmedia.internal.video.iew)s).skip();
        }
    }

    public void triggerTimeUpdate(String s)
    {
        s = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (s instanceof com.millennialmedia.internal.video.iew)
        {
            ((com.millennialmedia.internal.video.iew)s).triggerTimeUpdate();
            return;
        } else
        {
            MMLog.e(JSBridge.access$000(), "TriggerTimeUpdate can't be called on a WebView that is not part of a VAST Video creative.");
            return;
        }
    }

    eoWebView()
    {
        this$0 = JSBridge.this;
        super();
    }
}
