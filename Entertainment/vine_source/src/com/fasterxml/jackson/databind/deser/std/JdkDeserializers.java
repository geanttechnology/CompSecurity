// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            UUIDDeserializer, InetAddressDeserializer, InetSocketAddressDeserializer, CharsetDeserializer, 
//            ClassDeserializer, StackTraceElementDeserializer, AtomicBooleanDeserializer, ByteBufferDeserializer, 
//            FromStringDeserializer

public class JdkDeserializers
{
    public static class CurrencyDeserializer extends FromStringDeserializer
    {

        public static final CurrencyDeserializer instance = new CurrencyDeserializer();

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return _deserialize(s, deserializationcontext);
        }

        protected Currency _deserialize(String s, DeserializationContext deserializationcontext)
            throws IllegalArgumentException
        {
            return Currency.getInstance(s);
        }


        public CurrencyDeserializer()
        {
            super(java/util/Currency);
        }
    }

    public static class FileDeserializer extends FromStringDeserializer
    {

        public static final FileDeserializer instance = new FileDeserializer();

        protected File _deserialize(String s, DeserializationContext deserializationcontext)
        {
            return new File(s);
        }

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return _deserialize(s, deserializationcontext);
        }


        public FileDeserializer()
        {
            super(java/io/File);
        }
    }

    protected static class LocaleDeserializer extends FromStringDeserializer
    {

        public static final LocaleDeserializer instance = new LocaleDeserializer();

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return _deserialize(s, deserializationcontext);
        }

        protected Locale _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            int i = s.indexOf('_');
            if (i < 0)
            {
                return new Locale(s);
            }
            deserializationcontext = s.substring(0, i);
            s = s.substring(i + 1);
            i = s.indexOf('_');
            if (i < 0)
            {
                return new Locale(deserializationcontext, s);
            } else
            {
                return new Locale(deserializationcontext, s.substring(0, i), s.substring(i + 1));
            }
        }


        public LocaleDeserializer()
        {
            super(java/util/Locale);
        }
    }

    public static class PatternDeserializer extends FromStringDeserializer
    {

        public static final PatternDeserializer instance = new PatternDeserializer();

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return _deserialize(s, deserializationcontext);
        }

        protected Pattern _deserialize(String s, DeserializationContext deserializationcontext)
            throws IllegalArgumentException
        {
            return Pattern.compile(s);
        }


        public PatternDeserializer()
        {
            super(java/util/regex/Pattern);
        }
    }

    public static class URIDeserializer extends FromStringDeserializer
    {

        public static final URIDeserializer instance = new URIDeserializer();

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return _deserialize(s, deserializationcontext);
        }

        protected URI _deserialize(String s, DeserializationContext deserializationcontext)
            throws IllegalArgumentException
        {
            return URI.create(s);
        }

        protected volatile Object _deserializeFromEmptyString()
        {
            return _deserializeFromEmptyString();
        }

        protected URI _deserializeFromEmptyString()
        {
            return URI.create("");
        }


        public URIDeserializer()
        {
            super(java/net/URI);
        }
    }

    public static class URLDeserializer extends FromStringDeserializer
    {

        public static final URLDeserializer instance = new URLDeserializer();

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return _deserialize(s, deserializationcontext);
        }

        protected URL _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return new URL(s);
        }


        public URLDeserializer()
        {
            super(java/net/URL);
        }
    }


    private static final HashSet _classNames;

    public JdkDeserializers()
    {
    }

    public static JsonDeserializer find(Class class1, String s)
    {
        if (!_classNames.contains(s))
        {
            return null;
        }
        if (class1 == java/net/URI)
        {
            return URIDeserializer.instance;
        }
        if (class1 == java/net/URL)
        {
            return URLDeserializer.instance;
        }
        if (class1 == java/io/File)
        {
            return FileDeserializer.instance;
        }
        if (class1 == java/util/UUID)
        {
            return UUIDDeserializer.instance;
        }
        if (class1 == java/util/Currency)
        {
            return CurrencyDeserializer.instance;
        }
        if (class1 == java/util/regex/Pattern)
        {
            return PatternDeserializer.instance;
        }
        if (class1 == java/util/Locale)
        {
            return LocaleDeserializer.instance;
        }
        if (class1 == java/net/InetAddress)
        {
            return InetAddressDeserializer.instance;
        }
        if (class1 == java/net/InetSocketAddress)
        {
            return InetSocketAddressDeserializer.instance;
        }
        if (class1 == java/nio/charset/Charset)
        {
            return new CharsetDeserializer();
        }
        if (class1 == java/lang/Class)
        {
            return ClassDeserializer.instance;
        }
        if (class1 == java/lang/StackTraceElement)
        {
            return StackTraceElementDeserializer.instance;
        }
        if (class1 == java/util/concurrent/atomic/AtomicBoolean)
        {
            return AtomicBooleanDeserializer.instance;
        }
        if (class1 == java/nio/ByteBuffer)
        {
            return new ByteBufferDeserializer();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Internal error: can't find deserializer for ").append(s).toString());
        }
    }

    static 
    {
        int i = 0;
        _classNames = new HashSet();
        Class aclass[] = new Class[14];
        aclass[0] = java/util/UUID;
        aclass[1] = java/net/URL;
        aclass[2] = java/net/URI;
        aclass[3] = java/io/File;
        aclass[4] = java/util/Currency;
        aclass[5] = java/util/regex/Pattern;
        aclass[6] = java/util/Locale;
        aclass[7] = java/net/InetAddress;
        aclass[8] = java/net/InetSocketAddress;
        aclass[9] = java/nio/charset/Charset;
        aclass[10] = java/util/concurrent/atomic/AtomicBoolean;
        aclass[11] = java/lang/Class;
        aclass[12] = java/lang/StackTraceElement;
        aclass[13] = java/nio/ByteBuffer;
        for (int j = aclass.length; i < j; i++)
        {
            Class class1 = aclass[i];
            _classNames.add(class1.getName());
        }

    }
}
