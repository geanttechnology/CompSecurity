// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatWebHistory

class val.buffer
    implements Runnable
{

    final BoldChatWebHistory this$0;
    final StringBuilder val$buffer;

    public void run()
    {
        String s1 = val$buffer.toString();
        String s = s1;
        if (android.os. >= 19)
        {
            try
            {
                s = URLEncoder.encode(s1, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                Log.e("BOLD", "UTF-8 Encoding not supported", unsupportedencodingexception);
                unsupportedencodingexception = s1;
            }
        }
        loadUrl((new StringBuilder()).append("javascript:").append(s).toString());
    }

    ()
    {
        this$0 = final_boldchatwebhistory;
        val$buffer = StringBuilder.this;
        super();
    }
}
