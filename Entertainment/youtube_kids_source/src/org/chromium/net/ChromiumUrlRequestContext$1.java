// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.Context;

// Referenced classes of package org.chromium.net:
//            NetworkChangeNotifier, ChromiumUrlRequestContext

class a
    implements Runnable
{

    private Context a;
    private ChromiumUrlRequestContext b;

    public void run()
    {
        NetworkChangeNotifier.init(a);
        NetworkChangeNotifier.a();
        ChromiumUrlRequestContext.a(b, ChromiumUrlRequestContext.a(b));
    }

    (ChromiumUrlRequestContext chromiumurlrequestcontext, Context context)
    {
        b = chromiumurlrequestcontext;
        a = context;
        super();
    }
}
