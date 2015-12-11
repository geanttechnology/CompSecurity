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
import com.google.tagmanager.protobuf.Internal;
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
        implements Serving.ContainerOrBuilder
    {

        private int bitField0_;
        private Object containerId_;
        private Serving.Resource jsResource_;
        private Serving.ResourceState state_;
        private Object version_;

        private static Builder create()
        {
            return new Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Serving.Container build()
        {
            Serving.Container container = buildPartial();
            if (!container.isInitialized())
            {
                throw newUninitializedMessageException(container);
            } else
            {
                return container;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Serving.Container buildPartial()
        {
            Serving.Container container = new Serving.Container(this, null);
            int k = bitField0_;
            int j = 0;
            if ((k & 1) == 1)
            {
                j = false | true;
            }
            container.jsResource_ = jsResource_;
            int i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            container.containerId_ = containerId_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            container.state_ = state_;
            i = j;
            if ((k & 8) == 8)
            {
                i = j | 8;
            }
            container.version_ = version_;
            container.bitField0_ = i;
            return container;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Builder clear()
        {
            super.clear();
            jsResource_ = Serving.Resource.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            containerId_ = "";
            bitField0_ = bitField0_ & -3;
            state_ = Serving.ResourceState.PREVIEW;
            bitField0_ = bitField0_ & -5;
            version_ = "";
            bitField0_ = bitField0_ & -9;
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

        public Builder clearContainerId()
        {
            bitField0_ = bitField0_ & -3;
            containerId_ = Serving.Container.getDefaultInstance().getContainerId();
            return this;
        }

        public Builder clearJsResource()
        {
            jsResource_ = Serving.Resource.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public Builder clearState()
        {
            bitField0_ = bitField0_ & -5;
            state_ = Serving.ResourceState.PREVIEW;
            return this;
        }

        public Builder clearVersion()
        {
            bitField0_ = bitField0_ & -9;
            version_ = Serving.Container.getDefaultInstance().getVersion();
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

        public String getContainerId()
        {
            Object obj = containerId_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    containerId_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getContainerIdBytes()
        {
            Object obj = containerId_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                containerId_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Serving.Container getDefaultInstanceForType()
        {
            return Serving.Container.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Serving.Resource getJsResource()
        {
            return jsResource_;
        }

        public Serving.ResourceState getState()
        {
            return state_;
        }

        public String getVersion()
        {
            Object obj = version_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    version_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getVersionBytes()
        {
            Object obj = version_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                version_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public boolean hasContainerId()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasJsResource()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasState()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasVersion()
        {
            return (bitField0_ & 8) == 8;
        }

        public final boolean isInitialized()
        {
            while (!hasJsResource() || !hasContainerId() || !hasState() || !getJsResource().isInitialized()) 
            {
                return false;
            }
            return true;
        }

        public Builder mergeFrom(Serving.Container container)
        {
            if (container == Serving.Container.getDefaultInstance())
            {
                return this;
            }
            if (container.hasJsResource())
            {
                mergeJsResource(container.getJsResource());
            }
            if (container.hasContainerId())
            {
                bitField0_ = bitField0_ | 2;
                containerId_ = container.containerId_;
            }
            if (container.hasState())
            {
                setState(container.getState());
            }
            if (container.hasVersion())
            {
                bitField0_ = bitField0_ | 8;
                version_ = container.version_;
            }
            setUnknownFields(getUnknownFields().concat(container.unknownFields));
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (Serving.Container)Serving.Container.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((Serving.Container) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (Serving.Container)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((Serving.Container) (codedinputstream1)));
            }
            throw codedinputstream;
        }

        public volatile com.google.tagmanager.protobuf.AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedmessagelite)
        {
            return mergeFrom((Serving.Container)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder mergeJsResource(Serving.Resource resource)
        {
            if ((bitField0_ & 1) == 1 && jsResource_ != Serving.Resource.getDefaultInstance())
            {
                jsResource_ = Serving.Resource.newBuilder(jsResource_).mergeFrom(resource).buildPartial();
            } else
            {
                jsResource_ = resource;
            }
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public Builder setContainerId(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                containerId_ = s;
                return this;
            }
        }

        public Builder setContainerIdBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                containerId_ = bytestring;
                return this;
            }
        }

        public Builder setJsResource(Serving.Resource.Builder builder)
        {
            jsResource_ = builder.build();
            bitField0_ = bitField0_ | 1;
            return 