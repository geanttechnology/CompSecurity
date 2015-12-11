// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;


// Referenced classes of package com.comcast.playerplatform.util.android:
//            XrestHelper, AbstractResponseEventListener

class val.responseString
    implements Runnable
{

    final XrestHelper this$0;
    final String val$responseString;

    public void run()
    {
label0:
        {
            if (XrestHelper.access$000(XrestHelper.this) != null)
            {
                if (!val$responseString.contains("Network Error on request to"))
                {
                    break label0;
                }
                XrestHelper.access$000(XrestHelper.this).requestFailed(val$responseString);
            }
            return;
        }
        if (XrestHelper.access$100(XrestHelper.this).equals("HEAD"))
        {
            XrestHelper.access$000(XrestHelper.this).redirectUrlFound(val$responseString);
            return;
        } else
        {
            XrestHelper.access$000(XrestHelper.this).responseReceived(val$responseString);
            return;
        }
    }

    seEventListener()
    {
        this$0 = final_xresthelper;
        val$responseString = String.this;
        super();
    }
}
