// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            DescriptorProtos, CodedOutputStream, MessageLite, UnknownFieldSet, 
//            Message, RepeatedFieldBuilder, GeneratedMessage, CodedInputStream, 
//            ExtensionRegistryLite

public static final class memoizedSerializedSize extends ge
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.ExtendableBuilder
        implements DescriptorProtos.MessageOptionsOrBuilder
    {

        private int bitField0_;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private RepeatedFieldBuilder uninterpretedOptionBuilder_;
        private List uninterpretedOption_;

        private static Builder create()
        {
            return new Builder();
        }

        private void ensureUninterpretedOptionIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                uninterpretedOption_ = new ArrayList(uninterpretedOption_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                List list = uninterpretedOption_;
                boolean flag;
                if ((bitField0_ & 4) == 4)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                uninterpretedOption_ = null;
            }
            return uninterpretedOptionBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getUninterpretedOptionFieldBuilder();
            }
        }

        public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption uninterpretedoption)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                if (uninterpretedoption == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.add(uninterpretedoption);
                    onChanged();
                    return this;
                }
            } else
            {
                uninterpretedOptionBuilder_.addMessage(uninterpretedoption);
                return this;
            }
        }

        public DescriptorProtos.MessageOptions build()
        {
            DescriptorProtos.MessageOptions messageoptions = buildPartial();
            if (!messageoptions.isInitialized())
            {
                throw newUninitializedMessageException(messageoptions);
            } else
            {
                return messageoptions;
            }
        }

        public volatile Message build()
        {
            return build();
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public DescriptorProtos.MessageOptions buildPartial()
        {
            int i = 1;
            DescriptorProtos.MessageOptions messageoptions = new DescriptorProtos.MessageOptions(this, null);
            int k = bitField0_;
            int j;
            if ((k & 1) != 1)
            {
                i = 0;
            }
            messageoptions.messageSetWireFormat_ = messageSetWireFormat_;
            j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            messageoptions.noStandardDescriptorAccessor_ = noStandardDescriptorAccessor_;
            if (uninterpretedOptionBuilder_ == null)
            {
                if ((bitField0_ & 4) == 4)
                {
                    uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
                    bitField0_ = bitField0_ & -5;
                }
                messageoptions.uninterpretedOption_ = uninterpretedOption_;
            } else
            {
                messageoptions.uninterpretedOption_ = uninterpretedOptionBuilder_.build();
            }
            messageoptions.bitField0_ = j;
            onBuilt();
            return messageoptions;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public Builder clear()
        {
            super.clear();
            messageSetWireFormat_ = false;
            bitField0_ = bitField0_ & -2;
            noStandardDescriptorAccessor_ = false;
            bitField0_ = bitField0_ & -3;
            if (uninterpretedOptionBuilder_ == null)
            {
                uninterpretedOption_ = Collections.emptyList();
                bitField0_ = bitField0_ & -5;
                return this;
            } else
            {
                uninterpretedOptionBuilder_.clear();
                return this;
            }
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile GeneratedMessage.ExtendableBuilder clear()
        {
            return clear();
        }

        public volatile Message.Builder clear()
        {
            return clear();
        }

        public volatile MessageLite.Builder clear()
        {
            return clear();
        }

        public volatile AbstractMessage.Builder clone()
        {
            return clone();
        }

        public volatile AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile GeneratedMessage.ExtendableBuilder clone()
        {
            return clone();
        }

        public volatile Message.Builder clone()
        {
            return clone();
        }

        public volatile MessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public DescriptorProtos.MessageOptions getDefaultInstanceForType()
        {
            return DescriptorProtos.MessageOptions.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.MessageOptions.getDescriptor();
        }

        public DescriptorProtos.UninterpretedOption getUninterpretedOption(int i)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(i);
            } else
            {
                return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(i);
            }
        }

        public int getUninterpretedOptionCount()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return uninterpretedOption_.size();
            } else
            {
                return uninterpretedOptionBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$11900();
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getUninterpretedOptionCount()) goto _L2; else goto _L1
_L1:
            if (getUninterpretedOption(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!extensionsAreInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public volatile AbstractMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile AbstractMessage.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
            do
            {
                int i = codedinputstream.readTag();
                switch (i)
                {
                default:
                    if (!parseUnknownField(codedinputstream, builder, extensionregistrylite, i))
                    {
                        setUnknownFields(builder.build());
                        onChanged();
                        return this;
                    }
                    break;

                case 0: // '\0'
                    setUnknownFields(builder.build());
                    onChanged();
                    return this;

                case 8: // '\b'
                    bitField0_ = bitField0_ | 1;
                    messageSetWireFormat_ = codedinputstream.readBool();
                    break;

                case 16: // '\020'
                    bitField0_ = bitField0_ | 2;
                    noStandardDescriptorAccessor_ = codedinputstream.readBool();
                    break;

                case 7994: 
                    DescriptorProtos.UninterpretedOption.Builder builder1 = DescriptorProtos.UninterpretedOption.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addUninterpretedOption(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public Builder mergeFrom(DescriptorProtos.MessageOptions messageoptions)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (messageoptions == DescriptorProtos.MessageOptions.getDefaultInstance())
            {
                return this;
            }
            if (messageoptions.hasMessageSetWireFormat())
            {
                setMessageSetWireFormat(messageoptions.getMessageSetWireFormat());
            }
            if (messageoptions.hasNoStandardDescriptorAccessor())
            {
                setNoStandardDescriptorAccessor(messageoptions.getNoStandardDescriptorAccessor());
            }
            if (uninterpretedOptionBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!messageoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOption_.isEmpty())
                {
                    uninterpretedOption_ = messageoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -5;
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.addAll(messageoptions.uninterpretedOption_);
                }
                onChanged();
            }
_L4:
            mergeExtensionFields(messageoptions);
            mergeUnknownFields(messageoptions.getUnknownFields());
            return this;
_L2:
            if (!messageoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOptionBuilder_.isEmpty())
                {
                    uninterpretedOptionBuilder_.dispose();
                    uninterpretedOptionBuilder_ = null;
                    uninterpretedOption_ = messageoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -5;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getUninterpretedOptionFieldBuilder();
                    }
                    uninterpretedOptionBuilder_ = repeatedfieldbuilder;
                } else
                {
                    uninterpretedOptionBuilder_.addAllMessages(messageoptions.uninterpretedOption_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.MessageOptions)
            {
                return mergeFrom((DescriptorProtos.MessageOptions)message);
            } else
            {
                super.mergeFrom(message);
                return this;
            }
        }

        public volatile Message.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder setMessageSetWireFormat(boolean flag)
        {
            bitField0_ = bitField0_ | 1;
            messageSetWireFormat_ = flag;
            onChanged();
            return this;
        }

        public Builder setNoStandardDescriptorAccessor(boolean flag)
        {
            bitField0_ = bitField0_ | 2;
            noStandardDescriptorAccessor_ = flag;
            onChanged();
            return this;
        }


        private Builder()
        {
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }


    private static final initFields defaultInstance;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean messageSetWireFormat_;
    private boolean noStandardDescriptorAccessor_;
    private List uninterpretedOption_;

    public static Builder.onChanged getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
    {
        return DescriptorProtos.access$11800();
    }

    private void initFields()
    {
        messageSetWireFormat_ = false;
        noStandardDescriptorAccessor_ = false;
        uninterpretedOption_ = Collections.emptyList();
    }

    public static Builder newBuilder()
    {
        return Builder.create();
    }

    public static Builder newBuilder(Builder.create create)
    {
        return newBuilder().mergeFrom(create);
    }

    public Builder.mergeFrom getDefaultInstanceForType()
    {
        return defaultInstance;
    }

    public volatile Message getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public boolean getMessageSetWireFormat()
    {
        return messageSetWireFormat_;
    }

    public boolean getNoStandardDescriptorAccessor()
    {
        return noStandardDescriptorAccessor_;
    }

    public int getSerializedSize()
    {
        boolean flag = false;
        int i = memoizedSerializedSize;
        if (i != -1)
        {
            return i;
        }
        int j;
        if ((bitField0_ & 1) == 1)
        {
            i = CodedOutputStream.computeBoolSize(1, messageSetWireFormat_) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if ((bitField0_ & 2) == 2)
        {
            j = i + CodedOutputStream.computeBoolSize(2, noStandardDescriptorAccessor_);
        }
        i = j;
        for (int k = ((flag) ? 1 : 0); k < uninterpretedOption_.size();)
        {
            int l = CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(k));
            k++;
            i = l + i;
        }

        i = extensionsSerializedSize() + i + getUnknownFields().getSerializedSize();
        memoizedSerializedSize = i;
        return i;
    }

    public tion getUninterpretedOption(int i)
    {
        return (tion)uninterpretedOption_.get(i);
    }

    public int getUninterpretedOptionCount()
    {
        return uninterpretedOption_.size();
    }

    public boolean hasMessageSetWireFormat()
    {
        return (bitField0_ & 1) == 1;
    }

    public boolean hasNoStandardDescriptorAccessor()
    {
        return (bitField0_ & 2) == 2;
    }

    protected ble internalGetFieldAccessorTable()
    {
        return DescriptorProtos.access$11900();
    }

    public final boolean isInitialized()
    {
        byte byte0 = memoizedIsInitialized;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        for (int i = 0; i < getUninterpretedOptionCount(); i++)
        {
            if (!getUninterpretedOption(i).isInitialized())
            {
                memoizedIsInitialized = 0;
                return false;
            }
        }

        if (!extensionsAreInitialized())
        {
            memoizedIsInitialized = 0;
            return false;
        } else
        {
            memoizedIsInitialized = 1;
            return true;
        }
    }

    public Builder newBuilderForType()
    {
        return newBuilder();
    }

    protected Builder newBuilderForType(newBuilder newbuilder)
    {
        return new Builder(newbuilder, null);
    }

    public volatile Builder newBuilderForType()
    {
        return newBuilderForType();
    }

    protected volatile newBuilderForType newBuilderForType(newBuilderForType newbuilderfortype)
    {
        return newBuilderForType(newbuilderfortype);
    }

    public Builder toBuilder()
    {
        return newBuilder(this);
    }

    public volatile newBuilder toBuilder()
    {
        return toBuilder();
    }

    protected Object writeReplace()
        throws ObjectStreamException
    {
        return super.writeReplace();
    }

    public void writeTo(CodedOutputStream codedoutputstream)
        throws IOException
    {
        getSerializedSize();
        ge.ExtensionWriter extensionwriter = newExtensionWriter();
        if ((bitField0_ & 1) == 1)
        {
            codedoutputstream.writeBool(1, messageSetWireFormat_);
        }
        if ((bitField0_ & 2) == 2)
        {
            codedoutputstream.writeBool(2, noStandardDescriptorAccessor_);
        }
        for (int i = 0; i < uninterpretedOption_.size(); i++)
        {
            codedoutputstream.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
        }

        extensionwriter.writeUntil(0x20000000, codedoutputstream);
        getUnknownFields().writeTo(codedoutputstream);
    }

    static 
    {
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }


/*
    static boolean access$12402(Builder builder, boolean flag)
    {
        builder.messageSetWireFormat_ = flag;
        return flag;
    }

*/


/*
    static boolean access$12502(messageSetWireFormat_ messagesetwireformat_, boolean flag)
    {
        messagesetwireformat_.noStandardDescriptorAccessor_ = flag;
        return flag;
    }

*/



/*
    static List access$12602(noStandardDescriptorAccessor_ nostandarddescriptoraccessor_, List list)
    {
        nostandarddescriptoraccessor_.uninterpretedOption_ = list;
        return list;
    }

*/


/*
    static int access$12702(uninterpretedOption_ uninterpretedoption_, int i)
    {
        uninterpretedoption_.bitField0_ = i;
        return i;
    }

*/

    private er(Builder builder)
    {
        super(builder);
        memoizedIsInitialized = -1;
        memoizedSerializedSize = -1;
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }

    private Builder(boolean flag)
    {
        memoizedIsInitialized = -1;
        memoizedSerializedSize = -1;
    }
}
