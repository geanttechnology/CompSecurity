// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack;

import com.twinprime.msgpack.packer.MessagePackPacker;
import com.twinprime.msgpack.packer.Packer;
import com.twinprime.msgpack.template.Template;
import com.twinprime.msgpack.template.TemplateRegistry;
import com.twinprime.msgpack.unpacker.MessagePackUnpacker;
import com.twinprime.msgpack.unpacker.Unpacker;
import java.io.InputStream;
import java.io.OutputStream;

public class MessagePack
{

    private static final MessagePack globalMessagePack = new MessagePack();
    private TemplateRegistry registry;

    public MessagePack()
    {
        registry = new TemplateRegistry(null);
    }

    public Packer createPacker(OutputStream outputstream)
    {
        return new MessagePackPacker(this, outputstream);
    }

    public Unpacker createUnpacker(InputStream inputstream)
    {
        return new MessagePackUnpacker(this, inputstream);
    }

    public Template lookup(Class class1)
    {
        return registry.lookup(class1);
    }

}
