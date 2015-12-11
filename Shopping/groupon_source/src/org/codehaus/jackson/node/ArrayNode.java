// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

// Referenced classes of package org.codehaus.jackson.node:
//            ContainerNode, BaseJsonNode, JsonNodeFactory

public final class ArrayNode extends ContainerNode
{

    protected ArrayList _children;

    public ArrayNode(JsonNodeFactory jsonnodefactory)
    {
        super(jsonnodefactory);
    }

    private void _add(JsonNode jsonnode)
    {
        if (_children == null)
        {
            _children = new ArrayList();
        }
        _children.add(jsonnode);
    }

    private boolean _sameChildren(ArrayList arraylist)
    {
        int j = arraylist.size();
        if (size() != j)
        {
            return false;
        }
        for (int i = 0; i < j; i++)
        {
            if (!((JsonNode)_children.get(i)).equals(arraylist.get(i)))
            {
                return false;
            }
        }

        return true;
    }

    public void add(JsonNode jsonnode)
    {
        Object obj = jsonnode;
        if (jsonnode == null)
        {
            obj = nullNode();
        }
        _add(((JsonNode) (obj)));
    }

    public JsonToken asToken()
    {
        return JsonToken.START_ARRAY;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj.getClass() != getClass())
            {
                return false;
            }
            obj = (ArrayNode)obj;
            if (_children == null || _children.size() == 0)
            {
                if (((ArrayNode) (obj)).size() != 0)
                {
                    return false;
                }
            } else
            {
                return ((ArrayNode) (obj))._sameChildren(_children);
            }
        }
        return true;
    }

    public JsonNode get(String s)
    {
        return null;
    }

    public Iterator getElements()
    {
        if (_children == null)
        {
            return ContainerNode.NoNodesIterator.instance();
        } else
        {
            return _children.iterator();
        }
    }

    public int hashCode()
    {
        if (_children != null) goto _L2; else goto _L1
_L1:
        int j = 1;
_L4:
        return j;
_L2:
        int i = _children.size();
        Iterator iterator = _children.iterator();
        do
        {
            j = i;
            if (!iterator.hasNext())
            {
                continue;
            }
            JsonNode jsonnode = (JsonNode)iterator.next();
            if (jsonnode != null)
            {
                i ^= jsonnode.hashCode();
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isArray()
    {
        return true;
    }

    public final void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeStartArray();
        if (_children != null)
        {
            for (Iterator iterator = _children.iterator(); iterator.hasNext(); ((BaseJsonNode)(JsonNode)iterator.next()).serialize(jsongenerator, serializerprovider)) { }
        }
        jsongenerator.writeEndArray();
    }

    public void serializeWithType(JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        typeserializer.writeTypePrefixForArray(this, jsongenerator);
        if (_children != null)
        {
            for (Iterator iterator = _children.iterator(); iterator.hasNext(); ((BaseJsonNode)(JsonNode)iterator.next()).serialize(jsongenerator, serializerprovider)) { }
        }
        typeserializer.writeTypeSuffixForArray(this, jsongenerator);
    }

    public int size()
    {
        if (_children == null)
        {
            return 0;
        } else
        {
            return _children.size();
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((size() << 4) + 16);
        stringbuilder.append('[');
        if (_children != null)
        {
            int i = 0;
            for (int j = _children.size(); i < j; i++)
            {
                if (i > 0)
                {
                    stringbuilder.append(',');
                }
                stringbuilder.append(((JsonNode)_children.get(i)).toString());
            }

        }
        stringbuilder.append(']');
        return stringbuilder.toString();
    }
}
