// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableDebug

public static final class event_ extends GeneratedMutableMessageLite
    implements MutableMessageLite
{

    public static final int EVENT_FIELD_NUMBER = 1;
    public static Parser PARSER;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private List event_;

    private void ensureEventInitialized()
    {
        if (event_ == null)
        {
            event_ = new ArrayList();
        }
    }

    public static event_ getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
    }

    public static defaultInstance newMessage()
    {
        return new <init>();
    }

    public <init> addAllEvent(Iterable iterable)
    {
        assertMutable();
        ensureEventInitialized();
        AbstractMutableMessageLite.addAll(iterable, event_);
        return this;
    }

    public event_ addEvent(event_ event_1)
    {
        assertMutable();
        if (event_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureEventInitialized();
            event_.add(event_1);
            return this;
        }
    }

    public event_ addEvent()
    {
        assertMutable();
        ensureEventInitialized();
        event_ event_1 = wMessage();
        event_.add(event_1);
        return event_1;
    }

    public event_ clear()
    {
        assertMutable();
        super.clear();
        event_ = null;
        return this;
    }

    public volatile GeneratedMutableMessageLite clear()
    {
        return clear();
    }

    public volatile MutableMessageLite clear()
    {
        return clear();
    }

    public clear clearEvent()
    {
        assertMutable();
        event_ = null;
        return this;
    }

    public event_ clone()
    {
        return newMessageForType().mergeFrom(this);
    }

    public volatile MutableMessageLite clone()
    {
        return clone();
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof clone))
        {
            return super.equals(obj);
        }
        obj = (clone)obj;
        boolean flag;
        if (true && getEventList().equals(((getEventList) (obj)).getEventList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public final getEventList getDefaultInstanceForType()
    {
        return defaultInstance;
    }

    public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public volatile MessageLite getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public getDefaultInstanceForType getEvent(int i)
    {
        return (getDefaultInstanceForType)event_.get(i);
    }

    public int getEventCount()
    {
        if (event_ == null)
        {
            return 0;
        } else
        {
            return event_.size();
        }
    }

    public List getEventList()
    {
        if (event_ == null)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.unmodifiableList(event_);
        }
    }

    public event_ getMutableEvent(int i)
    {
        return (event_)event_.get(i);
    }

    public List getMutableEventList()
    {
        assertMutable();
        ensureEventInitialized();
        return event_;
    }

    public Parser getParserForType()
    {
        return PARSER;
    }

    public int getSerializedSize()
    {
        int k = 0;
        int i = 0;
        if (event_ != null)
        {
            int j = 0;
            do
            {
                k = i;
                if (j >= event_.size())
                {
                    break;
                }
                i += CodedOutputStream.computeMessageSize(1, (MessageLite)event_.get(j));
                j++;
            } while (true);
        }
        i = k + unknownFields.size();
        cachedSize = i;
        return i;
    }

    public int hashCode()
    {
        int i = 41;
        if (getEventCount() > 0)
        {
            i = 0x13a46 + getEventList().hashCode();
        }
        return i * 29 + unknownFields.hashCode();
    }

    protected MessageLite internalImmutableDefault()
    {
        if (immutableDefault == null)
        {
            immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DebugEvents");
        }
        return immutableDefault;
    }

    public final boolean isInitialized()
    {
        for (int i = 0; i < getEventCount(); i++)
        {
            if (!getEvent(i).Initialized())
            {
                return false;
            }
        }

        return true;
    }

    public Initialized mergeFrom(Initialized initialized)
    {
        if (this == initialized)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (initialized == getDefaultInstance())
        {
            return this;
        }
        if (initialized.event_ != null && !initialized.event_.isEmpty())
        {
            ensureEventInitialized();
            AbstractMutableMessageLite.addAll(initialized.event_, event_);
        }
        unknownFields = unknownFields.concat(initialized.unknownFields);
        return this;
    }

    public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
    {
        return mergeFrom((mergeFrom)generatedmutablemessagelite);
    }

    public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
    {
        assertMutable();
        com.google.tagmanager.protobuf.ugEvents ugevents;
        CodedOutputStream codedoutputstream;
        boolean flag;
        int i;
        try
        {
            ugevents = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(ugevents);
        }
        // Misplaced declaration of an exception variable
        catch (CodedInputStream codedinputstream)
        {
            return false;
        }
        flag = false;
        if (flag) goto _L2; else goto _L1
_L1:
        i = codedinputstream.readTag();
        i;
        JVM INSTR lookupswitch 2: default 102
    //                   0: 105
    //                   10: 75;
           goto _L3 _L4 _L5
_L3:
        if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        codedinputstream.readMessage(addEvent(), extensionregistrylite);
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = ugevents.tring();
        return true;
_L4:
        flag = true;
        if (true) goto _L7; else goto _L6
_L7:
        break MISSING_BLOCK_LABEL_17;
_L6:
    }

    public unknownFields newMessageForType()
    {
        return new <init>();
    }

    public volatile MutableMessageLite newMessageForType()
    {
        return newMessageForType();
    }

    public newMessageForType setEvent(int i, newMessageForType newmessagefortype)
    {
        assertMutable();
        if (newmessagefortype == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureEventInitialized();
            event_.set(i, newmessagefortype);
            return this;
        }
    }

    protected Object writeReplace()
        throws ObjectStreamException
    {
        return super.writeReplace();
    }

    public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
        throws IOException
    {
        int k = codedoutputstream.getTotalBytesWritten();
        if (event_ != null)
        {
            for (int i = 0; i < event_.size(); i++)
            {
                codedoutputstream.writeMessageWithCachedSizes(1, (MutableMessageLite)event_.get(i));
            }

        }
        codedoutputstream.writeRawBytes(unknownFields);
        int j = codedoutputstream.getTotalBytesWritten();
        if (getCachedSize() != j - k)
        {
            throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
        } else
        {
            return;
        }
    }

    static 
    {
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
        defaultInstance.makeImmutable();
        PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    }

    private ()
    {
        event_ = null;
        initFields();
    }

    private initFields(boolean flag)
    {
        event_ = null;
    }
}
