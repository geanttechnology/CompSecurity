// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.util.Iterator;

// Referenced classes of package com.google.tagmanager.protobuf:
//            MessageLite, Parser, ByteString, ExtensionRegistryLite

class LazyField
{
    static class LazyEntry
        implements java.util.Map.Entry
    {

        private java.util.Map.Entry entry;

        public LazyField getField()
        {
            return (LazyField)entry.getValue();
        }

        public Object getKey()
        {
            return entry.getKey();
        }

        public Object getValue()
        {
            LazyField lazyfield = (LazyField)entry.getValue();
            if (lazyfield == null)
            {
                return null;
            } else
            {
                return lazyfield.getValue();
            }
        }

        public Object setValue(Object obj)
        {
            if (!(obj instanceof MessageLite))
            {
                throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            } else
            {
                return ((LazyField)entry.getValue()).setValue((MessageLite)obj);
            }
        }

        private LazyEntry(java.util.Map.Entry entry1)
        {
            entry = entry1;
        }

    }

    static class LazyIterator
        implements Iterator
    {

        private Iterator iterator;

        public boolean hasNext()
        {
            return iterator.hasNext();
        }

        public volatile Object next()
        {
            return next();
        }

        public java.util.Map.Entry next()
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Object obj = entry;
            if (entry.getValue() instanceof LazyField)
            {
                obj = new LazyEntry(entry);
            }
            return ((java.util.Map.Entry) (obj));
        }

        public void remove()
        {
            iterator.remove();
        }

        public LazyIterator(Iterator iterator1)
        {
            iterator = iterator1;
        }
    }


    private ByteString bytes;
    private final MessageLite defaultInstance;
    private final ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;
    private volatile MessageLite value;

    public LazyField(MessageLite messagelite, ExtensionRegistryLite extensionregistrylite, ByteString bytestring)
    {
        isDirty = false;
        defaultInstance = messagelite;
        extensionRegistry = extensionregistrylite;
        bytes = bytestring;
    }

    private void ensureInitialized()
    {
        if (value != null)
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        if (value == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        try
        {
            if (bytes != null)
            {
                value = (MessageLite)defaultInstance.getParserForType().parseFrom(bytes, extensionRegistry);
            }
        }
        catch (IOException ioexception) { }
        this;
        JVM INSTR monitorexit ;
    }

    public boolean equals(Object obj)
    {
        ensureInitialized();
        return value.equals(obj);
    }

    public int getSerializedSize()
    {
        if (isDirty)
        {
            return value.getSerializedSize();
        } else
        {
            return bytes.size();
        }
    }

    public MessageLite getValue()
    {
        ensureInitialized();
        return value;
    }

    public int hashCode()
    {
        ensureInitialized();
        return value.hashCode();
    }

    public MessageLite setValue(MessageLite messagelite)
    {
        MessageLite messagelite1 = value;
        value = messagelite;
        bytes = null;
        isDirty = true;
        return messagelite1;
    }

    public ByteString toByteString()
    {
        if (!isDirty)
        {
            return bytes;
        }
        this;
        JVM INSTR monitorenter ;
        ByteString bytestring;
        if (isDirty)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        bytestring = bytes;
        this;
        JVM INSTR monitorexit ;
        return bytestring;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        bytes = value.toByteString();
        isDirty = false;
        exception = bytes;
        this;
        JVM INSTR monitorexit ;
        return exception;
    }

    public String toString()
    {
        ensureInitialized();
        return value.toString();
    }
}
