// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            UnknownFieldSet, CodedOutputStream, ByteString

public static final class <init>
{
    public static final class Builder
    {

        private UnknownFieldSet.Field result;

        private static Builder create()
        {
            Builder builder = new Builder();
            builder.result = new UnknownFieldSet.Field(null);
            return builder;
        }

        public Builder addFixed32(int i)
        {
            if (result.fixed32 == null)
            {
                result.fixed32 = new ArrayList();
            }
            result.fixed32.add(Integer.valueOf(i));
            return this;
        }

        public Builder addFixed64(long l)
        {
            if (result.fixed64 == null)
            {
                result.fixed64 = new ArrayList();
            }
            result.fixed64.add(Long.valueOf(l));
            return this;
        }

        public Builder addGroup(UnknownFieldSet unknownfieldset)
        {
            if (result.group == null)
            {
                result.group = new ArrayList();
            }
            result.group.add(unknownfieldset);
            return this;
        }

        public Builder addLengthDelimited(ByteString bytestring)
        {
            if (result.lengthDelimited == null)
            {
                result.lengthDelimited = new ArrayList();
            }
            result.lengthDelimited.add(bytestring);
            return this;
        }

        public Builder addVarint(long l)
        {
            if (result.varint == null)
            {
                result.varint = new ArrayList();
            }
            result.varint.add(Long.valueOf(l));
            return this;
        }

        public UnknownFieldSet.Field build()
        {
            UnknownFieldSet.Field field;
            if (result.varint == null)
            {
                result.varint = Collections.emptyList();
            } else
            {
                result.varint = Collections.unmodifiableList(result.varint);
            }
            if (result.fixed32 == null)
            {
                result.fixed32 = Collections.emptyList();
            } else
            {
                result.fixed32 = Collections.unmodifiableList(result.fixed32);
            }
            if (result.fixed64 == null)
            {
                result.fixed64 = Collections.emptyList();
            } else
            {
                result.fixed64 = Collections.unmodifiableList(result.fixed64);
            }
            if (result.lengthDelimited == null)
            {
                result.lengthDelimited = Collections.emptyList();
            } else
            {
                result.lengthDelimited = Collections.unmodifiableList(result.lengthDelimited);
            }
            if (result.group == null)
            {
                result.group = Collections.emptyList();
            } else
            {
                result.group = Collections.unmodifiableList(result.group);
            }
            field = result;
            result = null;
            return field;
        }

        public Builder mergeFrom(UnknownFieldSet.Field field)
        {
            if (!field.varint.isEmpty())
            {
                if (result.varint == null)
                {
                    result.varint = new ArrayList();
                }
                result.varint.addAll(field.varint);
            }
            if (!field.fixed32.isEmpty())
            {
                if (result.fixed32 == null)
                {
                    result.fixed32 = new ArrayList();
                }
                result.fixed32.addAll(field.f