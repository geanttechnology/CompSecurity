// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jackson.JsonNode;

// Referenced classes of package org.codehaus.jackson.node:
//            BaseJsonNode, JsonNodeFactory, NullNode

public abstract class ContainerNode extends BaseJsonNode
{
    protected static class NoNodesIterator
        implements Iterator
    {

        static final NoNodesIterator instance = new NoNodesIterator();

        public static NoNodesIterator instance()
        {
            return instance;
        }

        public boolean hasNext()
        {
            return false;
        }

        public volatile Object next()
        {
            return next();
        }

        public JsonNode next()
        {
            throw new NoSuchElementException();
        }

        public void remove()
        {
            throw new IllegalStateException();
        }


        private NoNodesIterator()
        {
        }
    }


    JsonNodeFactory _nodeFactory;

    protected ContainerNode(JsonNodeFactory jsonnodefactory)
    {
        _nodeFactory = jsonnodefactory;
    }

    public String asText()
    {
        return "";
    }

    public final NullNode nullNode()
    {
        return _nodeFactory.nullNode();
    }

    public abstract int size();
}
