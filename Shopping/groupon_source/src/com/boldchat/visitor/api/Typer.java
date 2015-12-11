// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.json.JSONObject;

// Referenced classes of package com.boldchat.visitor.api:
//            PersonType

public class Typer
{

    public String imageURL;
    public boolean isTyping;
    public String name;
    public long personID;
    public PersonType personType;

    protected Typer(long l, JSONObject jsonobject)
    {
        personID = l;
        update(jsonobject);
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public String getName()
    {
        return name;
    }

    public PersonType getPersonType()
    {
        return personType;
    }

    public boolean isTyping()
    {
        return isTyping;
    }

    protected void update(JSONObject jsonobject)
    {
        String s = jsonobject.optString("Name", null);
        String s1 = jsonobject.optString("PersonType", null);
        String s2 = jsonobject.optString("IsTyping", null);
        jsonobject = jsonobject.optString("ImageURL", null);
        if (s != null)
        {
            name = s;
        }
        if (s1 != null)
        {
            personType = PersonType.getPersonType(s1);
        }
        if (s2 != null)
        {
            isTyping = (new Boolean(s2)).booleanValue();
        }
        if (jsonobject != null)
        {
            imageURL = jsonobject;
        }
    }
}
