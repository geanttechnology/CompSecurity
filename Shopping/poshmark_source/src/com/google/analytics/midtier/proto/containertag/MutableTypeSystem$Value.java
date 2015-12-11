// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.midtier.proto.containertag;

import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.analytics.midtier.proto.containertag:
//            MutableTypeSystem

public static final class escaping_ extends com.google.tagmanager.protobuf.ite.ExtendableMutableMessage
    implements MutableMessageLite
{
    public static final class Escaping extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final Escaping $VALUES[];
        public static final Escaping CONVERT_JS_VALUE_TO_EXPRESSION;
        public static final int CONVERT_JS_VALUE_TO_EXPRESSION_VALUE = 16;
        public static final Escaping ESCAPE_CSS_STRING;
        public static final int ESCAPE_CSS_STRING_VALUE = 10;
        public static final Escaping ESCAPE_HTML;
        public static final Escaping ESCAPE_HTML_ATTRIBUTE;
        public static final Escaping ESCAPE_HTML_ATTRIBUTE_NOSPACE;
        public static final int ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE = 4;
        public static final int ESCAPE_HTML_ATTRIBUTE_VALUE = 3;
        public static final Escaping ESCAPE_HTML_RCDATA;
        public static final int ESCAPE_HTML_RCDATA_VALUE = 2;
        public static final int ESCAPE_HTML_VALUE = 1;
        public static final Escaping ESCAPE_JS_REGEX;
        public static final int ESCAPE_JS_REGEX_VALUE = 9;
        public static final Escaping ESCAPE_JS_STRING;
        public static final int ESCAPE_JS_STRING_VALUE = 7;
        public static final Escaping ESCAPE_JS_VALUE;
        public static final int ESCAPE_JS_VALUE_VALUE = 8;
        public static final Escaping ESCAPE_URI;
        public static final int ESCAPE_URI_VALUE = 12;
        public static final Escaping FILTER_CSS_VALUE;
        public static final int FILTER_CSS_VALUE_VALUE = 11;
        public static final Escaping FILTER_HTML_ATTRIBUTES;
        public static final int FILTER_HTML_ATTRIBUTES_VALUE = 6;
        public static final Escaping FILTER_HTML_ELEMENT_NAME;
        public static final int FILTER_HTML_ELEMENT_NAME_VALUE = 5;
        public static final Escaping FILTER_NORMALIZE_URI;
        public static final int FILTER_NORMALIZE_URI_VALUE = 14;
        public static final Escaping NORMALIZE_URI;
        public static final int NORMALIZE_URI_VALUE = 13;
        public static final Escaping NO_AUTOESCAPE;
        public static final int NO_AUTOESCAPE_VALUE = 15;
        public static final Escaping TEXT;
        public static final int TEXT_VALUE = 17;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public Escaping findValueByNumber(int i)
            {
                return Escaping.valueOf(i);
            }

            public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
            {
                return findValueByNumber(i);
            }

        };
        private final int value;

        public static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalGetValueMap()
        {
            return internalValueMap;
        }

        public static Escaping valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return ESCAPE_HTML;

            case 2: // '\002'
                return ESCAPE_HTML_RCDATA;

            case 3: // '\003'
                return ESCAPE_HTML_ATTRIBUTE;

            case 4: // '\004'
                return ESCAPE_HTML_ATTRIBUTE_NOSPACE;

            case 5: // '\005'
                return FILTER_HTML_ELEMENT_NAME;

            case 6: // '\006'
                return FILTER_HTML_ATTRIBUTES;

            case 7: // '\007'
                return ESCAPE_JS_STRING;

            case 8: // '\b'
                return ESCAPE_JS_VALUE;

            case 9: // '\t'
                return ESCAPE_JS_REGEX;

            case 10: // '\n'
                return ESCAPE_CSS_STRING;

            case 11: // '\013'
                return FILTER_CSS_VALUE;

            case 12: // '\f'
                return ESCAPE_URI;

            case 13: // '\r'
                return NORMALIZE_URI;

            case 14: // '\016'
                return FILTER_NORMALIZE_URI;

            case 15: // '\017'
                return NO_AUTOESCAPE;

            case 17: // '\021'
                return TEXT;

            case 16: // '\020'
                return CONVERT_JS_VALUE_TO_EXPRESSION;
            }
        }

        public static Escaping valueOf(String s)
        {
            return (Escaping)Enum.valueOf(com/google/analytics/midtier/proto/containertag/MutableTypeSystem$Value$Escaping, s);
        }

        public static Escaping[] values()
        {
            return (Escaping[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            ESCAPE_HTML = new Escaping("ESCAPE_HTML", 0, 0, 1);
            ESCAPE_HTML_RCDATA = new Escaping("ESCAPE_HTML_RCDATA", 1, 1, 2);
            ESCAPE_HTML_ATTRIBUTE = new Escaping("ESCAPE_HTML_ATTRIBUTE", 2, 2, 3);
            ESCAPE_HTML_ATTRIBUTE_NOSPACE = new Escaping("ESCAPE_HTML_ATTRIBUTE_NOSPACE", 3, 3, 4);
            FILTER_HTML_ELEMENT_NAME = new Escaping("FILTER_HTML_ELEMENT_NAME", 4, 4, 5);
            FILTER_HTML_ATTRIBUTES = new Escaping("FILTER_HTML_ATTRIBUTES", 5, 5, 6);
            ESCAPE_JS_STRING = new Escaping("ESCAPE_JS_STRING", 6, 6, 7);
            ESCAPE_JS_VALUE = new Escaping("ESCAPE_JS_VALUE", 7, 7, 8);
            ESCAPE_JS_REGEX = new Escaping("ESCAPE_JS_REGEX", 8, 8, 9);
            ESCAPE_CSS_STRING = new Escaping("ESCAPE_CSS_STRING", 9, 9, 10);
            FILTER_CSS_VALUE = new Escaping("FILTER_CSS_VALUE", 10, 10, 11);
            ESCAPE_URI = new Escaping("ESCAPE_URI", 11, 11, 12);
            NORMALIZE_URI = new Escaping("NORMALIZE_URI", 12, 12, 13);
            FILTER_NORMALIZE_URI = new Escaping("FILTER_NORMALIZE_URI", 13, 13, 14);
            NO_AUTOESCAPE = new Escaping("NO_AUTOESCAPE", 14, 14, 15);
            TEXT = new Escaping("TEXT", 15, 15, 17);
            CONVERT_JS_VALUE_TO_EXPRESSION = new Escaping("CONVERT_JS_VALUE_TO_EXPRESSION", 16, 16, 16);
            $VALUES = (new Escaping[] {
                ESCAPE_HTML, ESCAPE_HTML_RCDATA, ESCAPE_HTML_ATTRIBUTE, ESCAPE_HTML_ATTRIBUTE_NOSPACE, FILTER_HTML_ELEMENT_NAME, FILTER_HTML_ATTRIBUTES, ESCAPE_JS_STRING, ESCAPE_JS_VALUE, ESCAPE_JS_REGEX, ESCAPE_CSS_STRING, 
                FILTER_CSS_VALUE, ESCAPE_URI, NORMALIZE_URI, FILTER_NORMALIZE_URI, NO_AUTOESCAPE, TEXT, CONVERT_JS_VALUE_TO_EXPRESSION
            });
        }

        private Escaping(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }

    public static final class Type extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final Type $VALUES[];
        public static final Type BOOLEAN;
        public static final int BOOLEAN_VALUE = 8;
        public static final Type FUNCTION_ID;
        public static final int FUNCTION_ID_VALUE = 5;
        public static final Type INTEGER;
        public 