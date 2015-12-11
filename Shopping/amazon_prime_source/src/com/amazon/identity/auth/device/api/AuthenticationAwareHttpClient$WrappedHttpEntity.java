// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.utils.StreamUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticationAwareHttpClient

private static class mContentBytes
    implements Cloneable, HttpEntity
{

    private static Object sSyncObj[] = new Object[0];
    private byte mContentBytes[];
    private final HttpEntity mInnerHttpEntity;

    public Object clone()
        throws CloneNotSupportedException
    {
        if (!(mInnerHttpEntity instanceof Cloneable))
        {
            return super.clone();
        }
        HttpEntity httpentity;
        try
        {
            httpentity = (HttpEntity)mInnerHttpEntity.getClass().getMethod("clone", new Class[0]).invoke(mInnerHttpEntity, new Object[0]);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return super.clone();
        }
        catch (SecurityException securityexception)
        {
            return super.clone();
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            return super.clone();
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            return super.clone();
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return super.clone();
        }
        return new <init>(httpentity, mContentBytes);
    }

    public void consumeContent()
        throws IOException
    {
        mInnerHttpEntity.consumeContent();
    }

    public InputStream getContent()
        throws IOException
    {
label0:
        {
            InputStream inputstream;
            synchronized (sSyncObj)
            {
                if (!isRepeatable())
                {
                    break label0;
                }
                inputstream = mInnerHttpEntity.getContent();
            }
            return inputstream;
        }
        ByteArrayInputStream bytearrayinputstream;
        if (mContentBytes == null)
        {
            mContentBytes = StreamUtils.readInputStream(mInnerHttpEntity.getContent());
        }
        bytearrayinputstream = new ByteArrayInputStream(mContentBytes);
        aobj;
        JVM INSTR monitorexit ;
        return bytearrayinputstream;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Header getContentEncoding()
    {
        return mInnerHttpEntity.getContentEncoding();
    }

    public long getContentLength()
    {
        return mInnerHttpEntity.getContentLength();
    }

    public Header getContentType()
    {
        return mInnerHttpEntity.getContentType();
    }

    public boolean isChunked()
    {
        return mInnerHttpEntity.isChunked();
    }

    public boolean isRepeatable()
    {
        return mInnerHttpEntity.isRepeatable();
    }

    public boolean isStreaming()
    {
        return mInnerHttpEntity.isStreaming();
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        mInnerHttpEntity.writeTo(outputstream);
    }


    public Y(HttpEntity httpentity)
    {
        mInnerHttpEntity = httpentity;
    }

    private mInnerHttpEntity(HttpEntity httpentity, byte abyte0[])
    {
        mInnerHttpEntity = httpentity;
        mContentBytes = abyte0;
    }
}
