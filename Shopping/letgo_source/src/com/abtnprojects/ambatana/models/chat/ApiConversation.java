// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import com.abtnprojects.ambatana.models.product.ApiProduct;
import com.abtnprojects.ambatana.models.user.User;
import java.util.List;

public class ApiConversation
{

    private final String id;
    private final List messages;
    private final ApiProduct product;
    private final int unreadCount;
    private final String updatedAt;
    private final User userFrom;
    private final User userTo;

    public ApiConversation(String s, ApiProduct apiproduct, int i, String s1, List list, User user, User user1)
    {
        id = s;
        product = apiproduct;
        unreadCount = i;
        updatedAt = s1;
        messages = list;
        userFrom = user;
        userTo = user1;
    }

    public String getId()
    {
        return id;
    }

    public List getMessages()
    {
        return messages;
    }

    public ApiProduct getProduct()
    {
        return product;
    }

    public int getUnreadCount()
    {
        return unreadCount;
    }

    public String getUpdatedAt()
    {
        return updatedAt;
    }

    public User getUserFrom()
    {
        return userFrom;
    }

    public User getUserTo()
    {
        return userTo;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ApiConversation{id='").append(id).append('\'').append(", product=").append(product).append(", unreadCount=").append(unreadCount).append(", updatedAt='").append(updatedAt).append('\'').append(", messages='").append(messages).append('\'').append(", userFrom=").append(userFrom).append(", userTo=").append(userTo).append('}').toString();
    }
}
