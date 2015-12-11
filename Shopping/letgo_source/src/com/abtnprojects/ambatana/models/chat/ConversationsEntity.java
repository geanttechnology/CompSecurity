// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import android.content.Context;
import android.support.v7.aqo;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.ProductEntity;
import com.abtnprojects.ambatana.models.user.User;
import com.abtnprojects.ambatana.services.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.models.chat:
//            DateFormatter, MessageEntity, ApiConversation, Conversation

public class ConversationsEntity
{

    private final Context context;
    private final DateFormatter dateFormatter = new DateFormatter();
    private final CountryCurrencyInfo info;
    private final MessageEntity messageEntity = new MessageEntity();
    private final List prepositions;

    public ConversationsEntity(List list, CountryCurrencyInfo countrycurrencyinfo, Context context1)
    {
        prepositions = list;
        info = countrycurrencyinfo;
        context = context1;
    }

    public Conversation transform(ApiConversation apiconversation, String s)
    {
        User user;
        User user1;
        User user2;
        java.util.Date date;
        Product product;
        if (apiconversation == null)
        {
            return null;
        }
        aqo.a("will parse : %s", new Object[] {
            apiconversation.toString()
        });
        date = dateFormatter.getFormattedDate(apiconversation.getUpdatedAt());
        aqo.a("formattedUpdatedAt %s", new Object[] {
            date
        });
        product = (new ProductEntity(prepositions, info, context, new b(), null, null)).transform(apiconversation.getProduct());
        user = apiconversation.getUserFrom();
        user1 = apiconversation.getUserTo();
        user2 = product.getOwner();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.equals(user.getId())) goto _L4; else goto _L3
_L3:
        s = user1;
_L6:
        List list;
        if (user.getId().equals(user2.getId()))
        {
            user2 = user1;
        } else
        {
            user2 = user;
        }
        list = apiconversation.getMessages();
        list = messageEntity.transform(list, user, user1);
        return new Conversation(apiconversation.getId(), product, apiconversation.getUnreadCount(), date, list, user, user1, s, user2);
_L4:
        if (s.equals(user1.getId()))
        {
            s = user;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public List transform(List list, String s)
    {
        if (list == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Conversation conversation = transform((ApiConversation)list.next(), s);
            if (conversation != null)
            {
                arraylist.add(conversation);
            }
        } while (true);
        return arraylist;
    }
}
