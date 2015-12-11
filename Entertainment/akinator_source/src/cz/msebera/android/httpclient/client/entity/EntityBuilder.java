// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.FileEntity;
import cz.msebera.android.httpclient.entity.InputStreamEntity;
import cz.msebera.android.httpclient.entity.SerializableEntity;
import cz.msebera.android.httpclient.entity.StringEntity;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.client.entity:
//            GzipCompressingEntity, UrlEncodedFormEntity

public class EntityBuilder
{

    private byte binary[];
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    EntityBuilder()
    {
    }

    private void clearContent()
    {
        text = null;
        binary = null;
        stream = null;
        parameters = null;
        serializable = null;
        file = null;
    }

    public static EntityBuilder create()
    {
        return new EntityBuilder();
    }

    private ContentType getContentOrDefault(ContentType contenttype)
    {
        if (contentType != null)
        {
            contenttype = contentType;
        }
        return contenttype;
    }

    public HttpEntity build()
    {
        Object obj;
        Object obj1;
        if (text != null)
        {
            obj = new StringEntity(text, getContentOrDefault(ContentType.DEFAULT_TEXT));
        } else
        if (binary != null)
        {
            obj = new ByteArrayEntity(binary, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else
        if (stream != null)
        {
            obj = new InputStreamEntity(stream, 1L, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else
        if (parameters != null)
        {
            List list = parameters;
            if (contentType != null)
            {
                obj = contentType.getCharset();
            } else
            {
                obj = null;
            }
            obj = new UrlEncodedFormEntity(list, ((java.nio.charset.Charset) (obj)));
        } else
        if (serializable != null)
        {
            obj = new SerializableEntity(serializable);
            ((AbstractHttpEntity) (obj)).setContentType(ContentType.DEFAULT_BINARY.toString());
        } else
        if (file != null)
        {
            obj = new FileEntity(file, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else
        {
            obj = new BasicHttpEntity();
        }
        if (((AbstractHttpEntity) (obj)).getContentType() != null && contentType != null)
        {
            ((AbstractHttpEntity) (obj)).setContentType(contentType.toString());
        }
        ((AbstractHttpEntity) (obj)).setContentEncoding(contentEncoding);
        ((AbstractHttpEntity) (obj)).setChunked(chunked);
        obj1 = obj;
        if (gzipCompress)
        {
            obj1 = new GzipCompressingEntity(((HttpEntity) (obj)));
        }
        return ((HttpEntity) (obj1));
    }

    public EntityBuilder chunked()
    {
        chunked = true;
        return this;
    }

    public byte[] getBinary()
    {
        return binary;
    }

    public String getContentEncoding()
    {
        return contentEncoding;
    }

    public ContentType getContentType()
    {
        return contentType;
    }

    public File getFile()
    {
        return file;
    }

    public List getParameters()
    {
        return parameters;
    }

    public Serializable getSerializable()
    {
        return serializable;
    }

    public InputStream getStream()
    {
        return stream;
    }

    public String getText()
    {
        return text;
    }

    public EntityBuilder gzipCompress()
    {
        gzipCompress = true;
        return this;
    }

    public boolean isChunked()
    {
        return chunked;
    }

    public boolean isGzipCompress()
    {
        return gzipCompress;
    }

    public EntityBuilder setBinary(byte abyte0[])
    {
        clearContent();
        binary = abyte0;
        return this;
    }

    public EntityBuilder setContentEncoding(String s)
    {
        contentEncoding = s;
        return this;
    }

    public EntityBuilder setContentType(ContentType contenttype)
    {
        contentType = contenttype;
        return this;
    }

    public EntityBuilder setFile(File file1)
    {
        clearContent();
        file = file1;
        return this;
    }

    public EntityBuilder setParameters(List list)
    {
        clearContent();
        parameters = list;
        return this;
    }

    public transient EntityBuilder setParameters(NameValuePair anamevaluepair[])
    {
        return setParameters(Arrays.asList(anamevaluepair));
    }

    public EntityBuilder setSerializable(Serializable serializable1)
    {
        clearContent();
        serializable = serializable1;
        return this;
    }

    public EntityBuilder setStream(InputStream inputstream)
    {
        clearContent();
        stream = inputstream;
        return this;
    }

    public EntityBuilder setText(String s)
    {
        clearContent();
        text = s;
        return this;
    }
}
