// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.GetSplashResponse;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            GetSplashResponseDeserializer

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, GetSplashResponse getsplashresponse)
        throws IOException
    {
        if ("splashText".equals(s))
        {
            getsplashresponse.setSplashText(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("splashId".equals(s))
        {
            getsplashresponse.setSplashId(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("url".equals(s))
        {
            getsplashresponse.setUrl(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (GetSplashResponse)obj);
    }

    ()
    {
    }
}
