// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.exacttarget.etpushsdk.event:
//            IEventFactory

public class CloudPagesResponse
    implements IEventFactory
{

    protected static final String JF_MESSAGES = "messages";
    private static final String TAG = "~!CloudPagesResponse";
    private ArrayList messages;

    public CloudPagesResponse()
    {
    }

    public CloudPagesResponse fromJson(String s)
    {
        ArrayList arraylist;
        int i;
        int j;
        try
        {
            s = (new JSONObject(s)).getJSONArray("messages");
            arraylist = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!CloudPagesResponse", s.getMessage(), s);
            return null;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        j = s.length();
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(new Message(s.optJSONObject(i)));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        setMessages(arraylist);
        return this;
    }

    public volatile Object fromJson(String s)
    {
        return fromJson(s);
    }

    public ArrayList getMessages()
    {
        return messages;
    }

    public void setDatabaseIds(CloudPagesResponse cloudpagesresponse, List list)
    {
    }

    public volatile void setDatabaseIds(Object obj, List list)
    {
        setDatabaseIds((CloudPagesResponse)obj, list);
    }

    public void setMessages(ArrayList arraylist)
    {
        messages = arraylist;
    }
}
