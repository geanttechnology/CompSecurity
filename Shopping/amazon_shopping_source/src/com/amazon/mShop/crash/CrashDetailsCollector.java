// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.crash;

import android.content.Context;
import android.util.Log;
import com.amazon.device.crashmanager.CrashDetailsCollectable;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.util.BuildUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.crash:
//            WebViewLogger

public class CrashDetailsCollector
    implements CrashDetailsCollectable
{

    static final String TAG = com/amazon/mShop/crash/CrashDetailsCollector.getName();
    private final Context mContext;

    public CrashDetailsCollector(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            mContext = context;
            return;
        }
    }

    public Map collect(Throwable throwable)
    {
        throwable = new HashMap();
        throwable.put("SelectedMarketplace", AppLocale.getInstance().getCurrentLocaleName());
        throwable.put("PublicHttpCookies", CookieBridge.getCookiesOfCurrentLocale(mContext, false));
        putBrazilVersion(throwable);
        putLogCat(throwable);
        putWebViewHistory(throwable);
        if (BuildUtils.getRevisionNumber(mContext) != null)
        {
            throwable.put("packageVersionName", BuildUtils.getRevisionNumber(mContext));
        }
        return throwable;
    }

    void putBrazilVersion(Map map)
    {
        String s1 = BuildUtils.getRevisionNumber(mContext);
        String s = s1;
        if (s1 == null)
        {
            s = mContext.getString(com.amazon.mShop.android.lib.R.string.about_missing_placeholder);
        }
        map.put("BrazilVersion", s);
    }

    void putLogCat(Map map)
    {
        String s = "";
        Object obj;
        StringBuilder stringbuilder;
        byte abyte0[];
        obj = Runtime.getRuntime().exec(new String[] {
            "logcat", "-d", "-v", "threadtime"
        }).getInputStream();
        stringbuilder = new StringBuilder();
        abyte0 = new byte[8192];
_L3:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i < 0) goto _L2; else goto _L1
_L1:
        stringbuilder.append(new String(abyte0, 0, i));
          goto _L3
        Exception exception;
        exception;
        Log.e(TAG, "collectLogCat encountered an exception: ", exception);
_L5:
        map.put("LogCat", s);
        return;
_L2:
        exception = stringbuilder.toString();
        s = exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    void putWebViewHistory(Map map)
    {
        map.put("WebViewHistory", WebViewLogger.getWebViewHistory());
    }

}
