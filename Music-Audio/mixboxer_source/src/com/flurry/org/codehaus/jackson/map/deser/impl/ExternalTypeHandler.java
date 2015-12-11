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
import java.util.HashMap;

public class ExternalTypeHandler
{
    public static class Builder
    {

        private final HashMap _nameToPropertyIndex = new HashMap();
        private final ArrayList _properties = new ArrayList();

        public void addExternal(SettableBeanProperty settablebeanproperty, String s)
        {
            Integer integer = Integer.valueOf(_properties.size());
            _properties.add(new ExtTypedProperty(settablebeanproperty, s));
            _nameToPropertyIndex.put(settablebeanproperty.getName(), integer);
            _nameToPropertyIndex.put(s, integer);
        }

        public ExternalTypeHandler build()
        {
            return new ExternalTypeHandler((ExtTypedProperty[])_properties.toArray(new ExtTypedProperty[_properties.size()]), _nameToPropertyIndex, null, null);
        }

        public Builder()
        {
        }
    }

    private static final class ExtTypedProperty
    {

        private final SettableBeanProperty _property;
        private final String _typePropertyName;

        public SettableBeanProperty getProperty()
        {
            return _property;
        }

        public String getTypePropertyName()
        {
            return _typePropertyName;
        }

        public boolean hasTypePropertyName(String s)
        {
            return s.equals(_typePropertyName);
        }

        public ExtTypedProperty(SettableBeanProperty settablebeanproperty, String s)
        {
            _property = settablebeanproperty;
            _typePropertyName = s;
        }
    }


    private final HashMap _nameToPropertyIndex;
    private final ExtTypedProperty _properties[];
    private final TokenBuffer _tokens[];
    private final String _typeIds[];

    protected ExternalTypeHandler(ExternalTypeHandler externaltypehandler)
    {
        _properties = externaltypehandler._properties;
        _nameToPropertyIndex = externaltypehandler._nameToPropertyIndex;
        int i = _properties.length;
        _typeIds = new String[i];
        _tokens = new TokenBuffer[i];
    }

    protected ExternalTypeHandler(ExtTypedProperty aexttypedproperty[], HashMap hashmap, String as[], TokenBuffer atokenbuffer[])
    {
        _properties = aexttypedproperty;
        _nameToPropertyIndex = hashmap;
        _typeIds = as;
        _tokens = atokenbuffer;
    }

    protected final void _deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj, int i)
        throws IOException, JsonProcessingException
    {
        TokenBuffer tokenbuffer = new TokenBuffer(jsonparser.getCodec());
        tokenbuffer.writeStartArray();
        tokenbuffer.writeString(_typeIds[i]);
        JsonParser jsonparser1 = _tokens[i].asParser(jsonparser);
        jsonparser1.nextToken();
        tokenbuffer.copyCurrentStructure(jsonparser1);
        tokenbuffer.writeEndArray();
        jsonparser = tokenbuffer.asParser(jsonparser);
        jsonparser.nextToken();
        _properties[i].getProperty().deserializeAndSet(jsonparser, deserializationcontext, obj);
    }

    public Object complete(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        int i;
        int j;
        i = 0;
        j = _properties.length;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (_typeIds[i] != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (_tokens[i] != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        throw deserializationcontext.mappingException((new StringBuilder()).append("Missing external type id property '").append(_properties[i].getTypePropertyName()).toString());
        if (_tokens[i] == null)
        {
            jsonparser = _properties[i].getProperty();
            throw deserializationcontext.mappingException((new StringBuilder()).append("Missing property '").append(jsonparser.getName()).append("' for external type id '").append(_properties[i].getTypePropertyName()).toString());
        }
        _deserialize(jsonparser, deserializationcontext, obj, i);
          goto _L3
        return obj;
    }

    public boolean handleToken(JsonParser jsonparser, DeserializationContext deserializationcontext, String s, Object obj)
        throws IOException, JsonProcessingException
    {
        boolean flag1;
        boolean flag2;
        int i;
        flag2 = false;
        flag1 = false;
        Integer integer = (Integer)_nameToPropertyIndex.get(s);
        if (integer == null)
        {
            return false;
        }
        i = integer.intValue();
        if (!_properties[i].hasTypePropertyName(s)) goto _L2; else goto _L1
_L1:
        boolean flag;
        _typeIds[i] = jsonparser.getText();
        jsonparser.skipChildren();
        flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (_tokens[i] != null)
            {
                flag = true;
            }
        }
_L4:
        if (flag)
        {
            _deserialize(jsonparser, deserializationcontext, obj, i);
            _typeIds[i] = null;
            _tokens[i] = null;
        }
        return true;
_L2:
        s = new TokenBuffer(jsonparser.getCodec());
        s.copyCurrentStructure(jsonparser);
        _tokens[i] = s;
        flag = flag2;
        if (obj != null)
        {
            flag = flag2;
            if (_typeIds[i] != null)
            {
                flag = true;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ExternalTypeHandler start()
    {
        return new ExternalTypeHandler(this);
    }
}
