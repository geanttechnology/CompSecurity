// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.GetConversationMessagesService;
import com.abtnprojects.ambatana.datasource.api.c;
import com.abtnprojects.ambatana.models.chat.ApiConversation;

// Referenced classes of package android.support.v7:
//            aqo

public class dg
{

    private boolean a;
    private GetConversationMessagesService b;

    public dg(String s)
    {
        b = (GetConversationMessagesService)c.a(s, com/abtnprojects/ambatana/datasource/api/GetConversationMessagesService);
    }

    public ApiConversation a(String s, String s1, int i, int j)
    {
        if (a)
        {
            return null;
        }
        a = true;
        ApiConversation apiconversation;
        try
        {
            apiconversation = b.getConversations(s, s1, i, j);
            a = false;
        }
        catch (Exception exception)
        {
            aqo.b(exception, "getConversations : productId: %s, buyer: %s, page : %d, numResults : %d", new Object[] {
                s, s1, Integer.valueOf(i), Integer.valueOf(j)
            });
            a = false;
            return null;
        }
        return apiconversation;
    }
}
