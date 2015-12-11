// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            Descriptors, TextFormat, Message, MessageLite, 
//            ByteString

public static final class ptorProto
    implements r, , Comparable
{
    public static final class JavaType extends Enum
    {

        private static final JavaType $VALUES[];
        public static final JavaType BOOLEAN;
        public static final JavaType BYTE_STRING;
        public static final JavaType DOUBLE;
        public static final JavaType ENUM;
        public static final JavaType FLOAT;
        public static final JavaType INT;
        public static final JavaType LONG;
        public static final JavaType MESSAGE;
        public static final JavaType STRING;
        private final Object defaultDefault;

        public static JavaType valueOf(String s)
        {
            return (JavaType)Enum.valueOf(com/google/protobuf/Descriptors$FieldDescriptor$JavaType, s);
        }

        public static JavaType[] values()
        {
            return (JavaType[])$VALUES.clone();
        }

        static 
        {
            INT = new JavaType("INT", 0, Integer.valueOf(0));
            LONG = new JavaType("LONG", 1, Long.valueOf(0L));
            FLOAT = new JavaType("FLOAT", 2, Float.valueOf(0.0F));
            DOUBLE = new JavaType("DOUBLE", 3, Double.valueOf(0.0D));
            BOOLEAN = new JavaType("BOOLEAN", 4, Boolean.valueOf(false));
            STRING = new JavaType("STRING", 5, "");
            BYTE_STRING = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            ENUM = new JavaType("ENUM", 7, null);
            MESSAGE = new JavaType("MESSAGE", 8, null);
            $VALUES = (new JavaType[] {
                INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE
            });
        }


        private JavaType(String s, int i, Object obj)
        {
            super(s, i);
            defaultDefault = obj;
        }
    }

    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type BOOL;
        public static final Type BYTES;
        public static final Type DOUBLE;
        public static final Type ENUM;
        public static final Type FIXED32;
        public static final Type FIXED64;
        public static final Type FLOAT;
        public static final Type GROUP;
        public static final Type INT32;
        public static final Type INT64;
        public static final Type MESSAGE;
        public static final Type SFIXED32;
        public static final Type SFIXED64;
        public static final Type SINT32;
        public static final Type SINT64;
        public static final Type STRING;
        public static final Type UINT32;
        public static final Type UINT64;
        private JavaType javaType;

        public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type type1)
        {
            return values()[type1.getNumber() - 1];
        }

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/google/protobuf/Descriptors$FieldDescriptor$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        public JavaType getJavaType()
        {
            return javaType;
        }

        static 
        {
            DOUBLE = new Type("DOUBLE", 0, JavaType.DOUBLE);
            FLOAT = new Type("FLOAT", 1, JavaType.FLOAT);
            INT64 = new Type("INT64", 2, JavaType.LONG);
            UINT64 = new Type("UINT64", 3, JavaType.LONG);
            INT32 = new Type("INT32", 4, JavaType.INT);
            FIXED64 = new Type("FIXED64", 5, JavaType.LONG);
            FIXED32 = new Type("FIXED32", 6, JavaType.INT);
            BOOL = new Type("BOOL", 7, JavaType.BOOLEAN);
            STR