// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TimerTask;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            MaintainSession, EPStream, FeedsManagerAPI

private class <init> extends TimerTask
{

    final MaintainSession this$0;

    public void run()
    {
        String s1;
        try
        {
            String s = (new StringBuilder(String.valueOf(stream.getMaintainUrl()))).append("?token=").append(URLEncoder.encode(stream.getToken(), "UTF-8")).append("&v=2.0.0").toString();
            (new FeedsManagerAPI(listener)).getMaintianSessionResponse(s);
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            if ((new StringBuilder("MaintainSessionTask error: ")).append(unsupportedencodingexception.getMessage()).toString() != null)
            {
                s1 = unsupportedencodingexception.getMessage();
            } else
            {
                s1 = "";
            }
        }
        Utils.sdkLog(s1, 5, unsupportedencodingexception);
    }

    private ()
    {
        this$0 = MaintainSession.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
