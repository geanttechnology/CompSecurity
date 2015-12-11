// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter.json;

import java.io.IOException;
import java.nio.charset.Charset;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class MappingJacksonHttpMessageConverter extends AbstractHttpMessageConverter
{

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private ObjectMapper objectMapper;
    private boolean prefixJson;

    public MappingJacksonHttpMessageConverter()
    {
        super(new MediaType("application", "json", DEFAULT_CHARSET));
        objectMapper = new ObjectMapper();
        prefixJson = false;
    }

    public boolean canRead(Class class1, MediaType mediatype)
    {
        class1 = getJavaType(class1);
        return objectMapper.canDeserialize(class1) && canRead(mediatype);
    }

    public boolean canWrite(Class class1, MediaType mediatype)
    {
        return objectMapper.canSerialize(class1) && canWrite(mediatype);
    }

    protected JavaType getJavaType(Class class1)
    {
        return objectMapper.getTypeFactory().constructType(class1);
    }

    protected JsonEncoding getJsonEncoding(MediaType mediatype)
    {
        if (mediatype != null && mediatype.getCharSet() != null)
        {
            mediatype = mediatype.getCharSet();
            JsonEncoding ajsonencoding[] = JsonEncoding.values();
            int j = ajsonencoding.length;
            for (int i = 0; i < j; i++)
            {
                JsonEncoding jsonencoding = ajsonencoding[i];
                if (mediatype.name().equals(jsonencoding.getJavaName()))
                {
                    return jsonencoding;
                }
            }

        }
        return JsonEncoding.UTF8;
    }

    protected Object readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        class1 = getJavaType(class1);
        try
        {
            class1 = ((Class) (objectMapper.readValue(httpinputmessage.getBody(), class1)));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new HttpMessageNotReadableException((new StringBuilder()).append("Could not read JSON: ").append(class1.getMessage()).toString(), class1);
        }
        return class1;
    }

    protected boolean supports(Class class1)
    {
        throw new UnsupportedOperationException();
    }

    protected void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        JsonEncoding jsonencoding = getJsonEncoding(httpoutputmessage.getHeaders().getContentType());
        httpoutputmessage = objectMapper.getJsonFactory().createJsonGenerator(httpoutputmessage.getBody(), jsonencoding);
        try
        {
            if (prefixJson)
            {
                httpoutputmessage.writeRaw("{} && ");
            }
            objectMapper.writeValue(httpoutputmessage, obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new HttpMessageNotWritableException((new StringBuilder()).append("Could not write JSON: ").append(((JsonProcessingException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
        }
    }

}
