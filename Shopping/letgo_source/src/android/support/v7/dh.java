// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.GetConversationsService;
import com.abtnprojects.ambatana.datasource.api.c;
import java.util.List;

// Referenced classes of package android.support.v7:
//            aqo

public class dh
{

    private boolean a;
    private GetConversationsService b;

    public dh(String s)
    {
        b = (GetConversationsService)c.a(s, com/abtnprojects/ambatana/datasource/api/GetConversationsService);
    }

    public List a(int i, int j)
    {
        if (a)
        {
            return null;
        }
        a = true;
        List list;
        try
        {
            list = b.getConversations(i, j);
            a = false;
        }
        catch (Exception exception)
        {
            aqo.b(exception, "getConversations", new Object[0]);
            a = false;
            return null;
        }
        return list;
    }
}
