// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            WebRequest

static final class val.url
    implements Runnable
{

    final String val$url;

    public void run()
    {
        WebRequest webrequest = WebRequest.createNewWebRequest();
        webrequest.enableLog(true);
        webrequest.setUrlString(val$url);
        try
        {
            webrequest.makeCall();
            return;
        }
        catch (bRequestException brequestexception)
        {
            return;
        }
    }

    bRequestException(String s)
    {
        val$url = s;
        super();
    }
}
