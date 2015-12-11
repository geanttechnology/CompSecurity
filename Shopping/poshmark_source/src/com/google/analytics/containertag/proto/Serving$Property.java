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

// Referenced classes of package com.google.analytics.containertag.proto:
//            Serving

public static final class unknownFields extends GeneratedMessageLite
    implements rBuilder
{
    public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements Serving.PropertyOrBuilder
    {

        private int bitField0_;
        private int key_;
        private int value_;

        private static Builder create()
        {
            return new Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Serving.Property build()
        {
            Serving.Property property = buildPartial();
            if (!property.isInitialized())
            {
                throw newUninitializedMessageException(property);
            } else
            {
                return property;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Serving.Property buildPartial()
        {
            Serving.Property property = new Serving.Property(this, null);
            int k = bitField0_;
            int i = 0;
            if ((k & 1) == 1)
            {
                i = false | true;
            }
            property.key_ = key_;
            int j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            property.value_ = value_;
            property.bitField0_ = j;
            return property;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Builder clear()
        {
            super.clear();
            key_ = 0;
            bitField0_ = bitField0_ & -2;
            value_ = 0;
            bitField0_ = bitField0_ & -3;
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

        public Builder clearKey()
        {
            bitField0_ = bitField0_ & -2;
            key_ = 0;
            return this;
        }

        public Builder clearValue()
        {
            bitField0_ = bitField0_ & -3;
            value_ = 0;
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

        public Serving.Property getDefaultInstanceForType()
        {
            return Serving.