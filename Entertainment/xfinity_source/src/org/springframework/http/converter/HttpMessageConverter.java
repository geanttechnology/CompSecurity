// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter;

import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;

// Referenced classes of package org.springframework.http.converter:
//            HttpMessageNotReadableException, HttpMessageNotWritableException

public interface HttpMessageConverter
{

    public abstract boolean canRead(Class class1, MediaType mediatype);

    public abstract boolean canWrite(Class class1, MediaType mediatype);

    public abstract List getSupportedMediaTypes();

    public abstract Object read(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException;

    public abstract void write(Object obj, MediaType mediatype, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException;
}
