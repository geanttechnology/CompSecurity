// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, SingleFieldBuilder, Message, MessageOrBuilder

public class RepeatedFieldBuilder
    implements GeneratedMessage.BuilderParent
{
    private static class BuilderExternalList extends AbstractList
        implements List
    {

        RepeatedFieldBuilder builder;

        public GeneratedMessage.Builder get(int i)
        {
            return builder.getBuilder(i);
        }

        public volatile Object get(int i)
        {
            return get(i);
        }

        void incrementModCount()
        {
            modCount = modCount + 1;
        }

        public int size()
        {
            return builder.getCount();
        }

        BuilderExternalList(RepeatedFieldBuilder repeatedfieldbuilder)
        {
            builder = repeatedfieldbuilder;
        }
    }

    private static class MessageExternalList extends AbstractList
        implements List
    {

        RepeatedFieldBuilder builder;

        public GeneratedMessage get(int i)
        {
            return builder.getMessage(i);
        }

        public volatile Object get(int i)
        {
            return get(i);
        }

        void incrementModCount()
        {
            modCount = modCount + 1;
        }

        public int size()
        {
            return builder.getCount();
        }

        MessageExternalList(RepeatedFieldBuilder repeatedfieldbuilder)
        {
            builder = repeatedfieldbuilder;
        }
    }

    private static class MessageOrBuilderExternalList extends AbstractList
        implements List
    {

        RepeatedFieldBuilder builder;

        public MessageOrBuilder get(int i)
        {
            return builder.getMessageOrBuilder(i);
        }

        public volatile Object get(int i)
        {
            return get(i);
        }

        void incrementModCount()
        {
            modCount = modCount + 1;
        }

        public int size()
        {
            return builder.getCount();
        }

        MessageOrBuilderExternalList(RepeatedFieldBuilder repeatedfieldbuilder)
        {
            builder = repeatedfieldbuilder;
        }
    }


    private List builders;
    private BuilderExternalList externalBuilderList;
    private MessageExternalList externalMessageList;
    private MessageOrBuilderExternalList externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List messages;
    private GeneratedMessage.BuilderParent parent;

    public RepeatedFieldBuilder(List list, boolean flag, GeneratedMessage.BuilderParent builderparent, boolean flag1)
    {
        messages = list;
        isMessagesListMutable = flag;
        parent = builderparent;
        isClean = flag1;
    }

    private void ensureBuilders()
    {
        if (builders == null)
        {
            builders = new ArrayList(messages.size());
            for (int i = 0; i < messages.size(); i++)
            {
                builders.add(null);
            }

        }
    }

    private void ensureMutableMessageList()
    {
        if (!isMessagesListMutable)
        {
            messages = new ArrayList(messages);
            isMessagesListMutable = true;
        }
    }

    private GeneratedMessage getMessage(int i, boolean flag)
    {
        if (builders == null)
        {
            return (GeneratedMessage)messages.get(i);
        }
        SingleFieldBuilder singlefieldbuilder = (SingleFieldBuilder)builders.get(i);
        if (singlefieldbuilder == null)
        {
            return (GeneratedMessage)messages.get(i);
        }
        if (flag)
        {
            return singlefieldbuilder.build();
        } else
        {
            return singlefieldbuilder.getMessage();
        }
    }

    private void incrementModCounts()
    {
        if (externalMessageList != null)
        {
            externalMessageList.incrementModCount();
        }
        if (externalBuilderList != null)
        {
            externalBuilderList.incrementModCount();
        }
        if (externalMessageOrBuilderList != null)
        {
            externalMessageOrBuilderList.incrementModCount();
        }
    }

    private void onChanged()
    {
        if (isClean && parent != null)
        {
            parent.markDirty();
            isClean = false;
        }
    }

    public RepeatedFieldBuilder addAllMessages(Iterable iterable)
    {
        for (Iterator iterator = iterable.iterator(); iterator.hasNext();)
        {
            if ((GeneratedMessage)iterator.next() == null)
            {
                throw new NullPointerException();
            }
        }

        if (iterable instanceof Collection)
        {
            if (((Collection)iterable).size() == 0)
            {
                return this;
            }
            ensureMutableMessageList();
            for (iterable = iterable.iterator(); iterable.hasNext(); addMessage((GeneratedMessage)iterable.next())) { }
        } else
        {
            ensureMutableMessageList();
            for (iterable = iterable.iterator(); iterable.hasNext(); addMessage((GeneratedMessage)iterable.next())) { }
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public GeneratedMessage.Builder addBuilder(int i, GeneratedMessage generatedmessage)
    {
        ensureMutableMessageList();
        ensureBuilders();
        generatedmessage = new SingleFieldBuilder(generatedmessage, this, isClean);
        messages.add(i, null);
        builders.add(i, generatedmessage);
        onChanged();
        incrementModCounts();
        return generatedmessage.getBuilder();
    }

    public GeneratedMessage.Builder addBuilder(GeneratedMessage generatedmessage)
    {
        ensureMutableMessageList();
        ensureBuilders();
        generatedmessage = new SingleFieldBuilder(generatedmessage, this, isClean);
        messages.add(null);
        builders.add(generatedmessage);
        onChanged();
        incrementModCounts();
        return generatedmessage.getBuilder();
    }

    public RepeatedFieldBuilder addMessage(int i, GeneratedMessage generatedmessage)
    {
        if (generatedmessage == null)
        {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        messages.add(i, generatedmessage);
        if (builders != null)
        {
            builders.add(i, null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder addMessage(GeneratedMessage generatedmessage)
    {
        if (generatedmessage == null)
        {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        messages.add(generatedmessage);
        if (builders != null)
        {
            builders.add(null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public List build()
    {
        isClean = true;
        if (!isMessagesListMutable && builders == null)
        {
            return messages;
        }
        if (isMessagesListMutable) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        Message message;
        SingleFieldBuilder singlefieldbuilder;
        if (i >= messages.size())
        {
            break MISSING_BLOCK_LABEL_168;
        }
        message = (Message)messages.get(i);
        singlefieldbuilder = (SingleFieldBuilder)builders.get(i);
        if (singlefieldbuilder == null || singlefieldbuilder.build() == message) goto _L4; else goto _L3
_L3:
        i = 0;
_L6:
        if (i != 0)
        {
            return messages;
        }
          goto _L2
_L4:
        i++;
          goto _L5
_L2:
        ensureMutableMessageList();
        for (i = 0; i < messages.size(); i++)
        {
            messages.set(i, getMessage(i, true));
        }

        messages = Collections.unmodifiableList(messages);
        isMessagesListMutable = false;
        return messages;
        i = 1;
          goto _L6
    }

    public void clear()
    {
        messages = Collections.emptyList();
        isMessagesListMutable = false;
        if (builders != null)
        {
            Iterator iterator = builders.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                SingleFieldBuilder singlefieldbuilder = (SingleFieldBuilder)iterator.next();
                if (singlefieldbuilder != null)
                {
                    singlefieldbuilder.dispose();
                }
            } while (true);
            builders = null;
        }
        onChanged();
        incrementModCounts();
    }

    public void dispose()
    {
        parent = null;
    }

    public GeneratedMessage.Builder getBuilder(int i)
    {
        ensureBuilders();
        SingleFieldBuilder singlefieldbuilder1 = (SingleFieldBuilder)builders.get(i);
        SingleFieldBuilder singlefieldbuilder = singlefieldbuilder1;
        if (singlefieldbuilder1 == null)
        {
            singlefieldbuilder = new SingleFieldBuilder((GeneratedMessage)messages.get(i), this, isClean);
            builders.set(i, singlefieldbuilder);
        }
        return singlefieldbuilder.getBuilder();
    }

    public List getBuilderList()
    {
        if (externalBuilderList == null)
        {
            externalBuilderList = new BuilderExternalList(this);
        }
        return externalBuilderList;
    }

    public int getCount()
    {
        return messages.size();
    }

    public GeneratedMessage getMessage(int i)
    {
        return getMessage(i, false);
    }

    public List getMessageList()
    {
        if (externalMessageList == null)
        {
            externalMessageList = new MessageExternalList(this);
        }
        return externalMessageList;
    }

    public MessageOrBuilder getMessageOrBuilder(int i)
    {
        if (builders == null)
        {
            return (MessageOrBuilder)messages.get(i);
        }
        SingleFieldBuilder singlefieldbuilder = (SingleFieldBuilder)builders.get(i);
        if (singlefieldbuilder == null)
        {
            return (MessageOrBuilder)messages.get(i);
        } else
        {
            return singlefieldbuilder.getMessageOrBuilder();
        }
    }

    public List getMessageOrBuilderList()
    {
        if (externalMessageOrBuilderList == null)
        {
            externalMessageOrBuilderList = new MessageOrBuilderExternalList(this);
        }
        return externalMessageOrBuilderList;
    }

    public boolean isEmpty()
    {
        return messages.isEmpty();
    }

    public void markDirty()
    {
        onChanged();
    }

    public void remove(int i)
    {
        ensureMutableMessageList();
        messages.remove(i);
        if (builders != null)
        {
            SingleFieldBuilder singlefieldbuilder = (SingleFieldBuilder)builders.remove(i);
            if (singlefieldbuilder != null)
            {
                singlefieldbuilder.dispose();
            }
        }
        onChanged();
        incrementModCounts();
    }

    public RepeatedFieldBuilder setMessage(int i, GeneratedMessage generatedmessage)
    {
        if (generatedmessage == null)
        {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        messages.set(i, generatedmessage);
        if (builders != null)
        {
            generatedmessage = (SingleFieldBuilder)builders.set(i, null);
            if (generatedmessage != null)
            {
                generatedmessage.dispose();
            }
        }
        onChanged();
        incrementModCounts();
        return this;
    }
}
