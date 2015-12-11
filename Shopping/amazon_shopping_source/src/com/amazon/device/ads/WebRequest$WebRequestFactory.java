// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            WebRequest, HttpClientWebRequest, HttpURLConnectionWebRequest

static class 
{

    public WebRequest createWebRequest()
    {
        if (android.os.estFactory < 8)
        {
            return new HttpClientWebRequest();
        } else
        {
            return new HttpURLConnectionWebRequest();
        }
    }

    ()
    {
    }
}
