// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model.parsers;

import com.socialin.android.apiv3.model.NewsResponse;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.model.parsers:
//            IStreamParser, StringParser

public class NewsResponseParser
    implements IStreamParser
{

    private static NewsResponseParser instance = null;

    public NewsResponseParser()
    {
    }

    public static final NewsResponseParser getInstance()
    {
        if (instance == null)
        {
            instance = new NewsResponseParser();
        }
        return instance;
    }

    public NewsResponse parse(InputStream inputstream)
    {
        NewsResponse newsresponse = new NewsResponse();
        try
        {
            inputstream = new JSONObject(StringParser.instance().parse(inputstream));
            newsresponse.status = inputstream.getString("status");
            newsresponse.message = inputstream.optString("message", "");
            newsresponse.reason = inputstream.optString("reason", null);
            newsresponse.response = inputstream.optJSONArray("response");
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return newsresponse;
        }
        return newsresponse;
    }

    public volatile Object parse(InputStream inputstream)
    {
        return parse(inputstream);
    }

}
