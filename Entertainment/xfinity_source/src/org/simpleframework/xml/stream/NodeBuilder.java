// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

// Referenced classes of package org.simpleframework.xml.stream:
//            ProviderFactory, Provider, NodeReader, Format, 
//            NodeWriter, InputNode, EventReader, OutputNode

public final class NodeBuilder
{

    private static Provider provider = ProviderFactory.getInstance();

    public NodeBuilder()
    {
    }

    public static InputNode read(InputStream inputstream)
        throws Exception
    {
        return read(provider.provide(inputstream));
    }

    public static InputNode read(Reader reader)
        throws Exception
    {
        return read(provider.provide(reader));
    }

    private static InputNode read(EventReader eventreader)
        throws Exception
    {
        return (new NodeReader(eventreader)).readRoot();
    }

    public static OutputNode write(Writer writer)
        throws Exception
    {
        return write(writer, new Format());
    }

    public static OutputNode write(Writer writer, Format format)
        throws Exception
    {
        return (new NodeWriter(writer, format)).writeRoot();
    }

}
