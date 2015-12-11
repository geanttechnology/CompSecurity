// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, MessageOrBuilder

public class SingleFieldBuilder
    implements GeneratedMessage.BuilderParent
{

    private GeneratedMessage.Builder builder;
    private boolean isClean;
    private GeneratedMessage message;
    private GeneratedMessage.BuilderParent parent;

    public SingleFieldBuilder(GeneratedMessage generatedmessage, GeneratedMessage.BuilderParent builderparent, boolean flag)
    {
        if (generatedmessage == null)
        {
            throw new NullPointerException();
        } else
        {
            message = generatedmessage;
            parent = builderparent;
            isClean = flag;
            return;
        }
    }

    private void onChanged()
    {
        if (builder != null)
        {
            message = null;
        }
        if (isClean && parent != null)
        {
            parent.markDirty();
            isClean = false;
        }
    }

    public GeneratedMessage build()
    {
        isClean = true;
        return getMessage();
    }

    public SingleFieldBuilder clear()
    {
        Message message1;
        if (message != null)
        {
            message1 = message.getDefaultInstanceForType();
        } else
        {
            message1 = builder.getDefaultInstanceForType();
        }
        message = (GeneratedMessage)(GeneratedMessage)message1;
        if (builder != null)
        {
            builder.dispose();
            builder = null;
        }
        onChanged();
        return this;
    }

    public void dispose()
    {
        parent = null;
    }

    public GeneratedMessage.Builder getBuilder()
    {
        if (builder == null)
        {
            builder = (GeneratedMessage.Builder)message.newBuilderForType(this);
            builder.mergeFrom(message);
            builder.markClean();
        }
        return builder;
    }

    public GeneratedMessage getMessage()
    {
        if (message == null)
        {
            message = (GeneratedMessage)builder.buildPartial();
        }
        return message;
    }

    public MessageOrBuilder getMessageOrBuilder()
    {
        if (builder != null)
        {
            return builder;
        } else
        {
            return message;
        }
    }

    public void markDirty()
    {
        onChanged();
    }

    public SingleFieldBuilder mergeFrom(GeneratedMessage generatedmessage)
    {
        if (builder == null && message == message.getDefaultInstanceForType())
        {
            message = generatedmessage;
        } else
        {
            getBuilder().mergeFrom(generatedmessage);
        }
        onChanged();
        return this;
    }
}
