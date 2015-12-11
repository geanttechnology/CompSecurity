// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.internal.RequestUtil;
import com.boldchat.visitor.api.json.JSONObject;
import java.util.Date;

// Referenced classes of package com.boldchat.visitor.api:
//            PersonType

public class Message
{

    private Date created;
    private long messageID;
    private String name;
    private long personID;
    private PersonType personType;
    private String text;

    protected Message(long l, JSONObject jsonobject)
    {
        messageID = l;
        created = RequestUtil.getDateFromISO8601(jsonobject.optString("Created"));
        text = jsonobject.optString("Text");
        personID = jsonobject.optLong("PersonID");
        personType = PersonType.getPersonType(jsonobject.optString("PersonType", ""));
        name = jsonobject.optString("Name");
    }

    protected Message(String s, long l, Date date, PersonType persontype, String s1)
    {
        text = s;
        messageID = l;
        created = date;
        personType = persontype;
        name = s1;
    }

    public Date getCreated()
    {
        return created;
    }

    public long getMessageID()
    {
        return messageID;
    }

    public String getName()
    {
        return name;
    }

    public long getPersonID()
    {
        return personID;
    }

    public PersonType getPersonType()
    {
        return personType;
    }

    public String getText()
    {
        return text;
    }
}
