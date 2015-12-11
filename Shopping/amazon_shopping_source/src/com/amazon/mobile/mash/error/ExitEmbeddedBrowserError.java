// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class ExitEmbeddedBrowserError extends Enum
{

    private static final ExitEmbeddedBrowserError $VALUES[];
    public static final ExitEmbeddedBrowserError TARGET_URL_NOT_ALLOWED;
    private int mErrorCode;

    private ExitEmbeddedBrowserError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static ExitEmbeddedBrowserError valueOf(String s)
    {
        return (ExitEmbeddedBrowserError)Enum.valueOf(com/amazon/mobile/mash/error/ExitEmbeddedBrowserError, s);
    }

    public static ExitEmbeddedBrowserError[] values()
    {
        return (ExitEmbeddedBrowserError[])$VALUES.clone();
    }

    public JSONObject toJSONObejct()
    {
        JSONObject jsonobject;
        ExitEmbeddedBrowserError aexitembeddedbrowsererror[];
        ExitEmbeddedBrowserError exitembeddedbrowsererror;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            aexitembeddedbrowsererror = values();
            j = aexitembeddedbrowsererror.length;
        }
        catch (JSONException jsonexception)
        {
            Log.e("ExitEmbeddedBrowser", (new StringBuilder()).append("Bad JSON ").append(jsonexception.getMessage()).toString());
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        exitembeddedbrowsererror = aexitembeddedbrowsererror[i];
        jsonobject.put(exitembeddedbrowsererror.name(), exitembeddedbrowsererror.mErrorCode);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_19;
_L1:
        jsonobject.put("code", mErrorCode);
        return jsonobject;
    }

    static 
    {
        TARGET_URL_NOT_ALLOWED = new ExitEmbeddedBrowserError("TARGET_URL_NOT_ALLOWED", 0, 1);
        $VALUES = (new ExitEmbeddedBrowserError[] {
            TARGET_URL_NOT_ALLOWED
        });
    }
}
