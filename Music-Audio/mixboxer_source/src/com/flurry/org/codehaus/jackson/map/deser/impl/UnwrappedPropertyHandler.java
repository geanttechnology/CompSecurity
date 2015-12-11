// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import com.flurry.org.codehaus.jackson.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;

public class UnwrappedPropertyHandler
{

    protected final ArrayList _properties = new ArrayList();

    public UnwrappedPropertyHandler()
    {
    }

    public void addProperty(SettableBeanProperty settablebeanproperty)
    {
        _properties.add(settablebeanproperty);
    }

    public Object processUnwrapped(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj, TokenBuffer tokenbuffer)
        throws IOException, JsonProcessingException
    {
        int i = 0;
        for (int j = _properties.size(); i < j; i++)
        {
            jsonparser = (SettableBeanProperty)_properties.get(i);
            JsonParser jsonparser1 = tokenbuffer.asParser();
            jsonparser1.nextToken();
            jsonparser.deserializeAndSet(jsonparser1, deserializationcontext, obj);
        }

        return obj;
    }
}
