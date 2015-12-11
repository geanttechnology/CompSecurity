// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Debug

public static final class unknownFields extends GeneratedMessageLite
    implements rBuilder
{
    public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements Debug.DebugEventsOrBuilder
    {

        private int bitField0_;
        private List event_;

        private static Builder create()
        {
            return new Builder();
        }

        private void ensureEventIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                event_ = new ArrayList(event_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Builder addAllEvent(Iterable iterable)
        {
            ensureEventIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, event_);
            return this;
        }

        public Builder addEvent(int i, Debug.EventInfo.Builder builder)
        {
            ensureEventIsMutable();
            event_.add(i, builder.build());
            return this;
        }

        public Builder addEvent(int i, Debug.EventInfo eventinfo)
        {
            if (eventinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEventIsMutable();
                event_.add(i, eventinfo);
                return this;
            }
        }

        public Builder addEvent(Debug.EventInfo.Builder builder)
        {
            ensureEventIsMutable();
            event_.add(builder.build());
            return this;
        }

        public Builder addEvent(Debug.EventInfo eventinfo)
        {
            if (eventinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEventIsMutable();
                event_.add(eventinfo);
                return this;
            }
        }

        public Debug.DebugEvents build()
        {
            Debug.DebugEvents debugevents = buildPartial();
            if (!debugevents.isInitialized())
            {
                throw newUninitializedMessageException(debugevents);
            } else
            {
                return debugevents;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Debug.DebugEvents buildPartial()
        {
            Debug.DebugEvents debugevents = new Debug.DebugEvents(this, null);
            int i = bitField0_;
            if ((bitField0_ & 1) == 1)
            {
                event_ = Collections.unmodifiableList(event_);
                bitField0_ = bitField0_ & -2;
            }
            debugevents.event_ = event_;
            return debugevents;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Builder clear()
        {
            super.clear();
            event_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder clear()
        {
            return clear();
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder clear()
        {
            return clear();
        }

        public Builder clearEvent()
        {
            event_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile com.google.tagmanager.protobuf.AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public Debug.DebugEvents getDefaultInstanceForType()
        {
            return Debug.DebugEvents.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Debug.EventInfo getEvent(int i)
        {
            return (Debug.EventInfo)event_.get(i);
        }

        public int getEventCount()
        {
            return event_.size();
        }

        public List getEventList()
        {
            return Collections.unmodifiableList(event_);
        }

        public final boolean isInitialized()
        {
            for (int i = 0; i < getEventCount(); i++)
            {
                if (!getEvent(i).isInitialized())
                {
                    return false;
                }
            }

            return true;
        }

        public Builder mergeFrom(Debug.DebugEvents debugevents)
        {
            if (debugevents == Debug.DebugEvents.getDefaultInstance())
            {
                return this;
            }
            if (!debugevents.event_.isEmpty())
            {
                if (event_.isEmpty())
                {
                    event_ = debugevents.event_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureEventIsMutable();
                    event_.addAll(debugevents.event_);
                }
            }
            setUnknownFields(getUnknownFields().concat(debugevents.unknownFields));
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (Debug.DebugEvents)Debug.DebugEvents.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((Debug.DebugEvents) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (Debug.DebugEvents)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((Debug.DebugEvents) (codedinputstream1)));
            }
            throw codedinputstream;
        }

        public volatile com.google.tagmanager.protobuf.AbstractMessa