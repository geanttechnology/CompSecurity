// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import com.amazon.profiling.Profiler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            EncryptionManager, DataStoreException, Logger

public class EncryptionManagerImpl
    implements EncryptionManager
{

    private final String encryptionAlgorithm;
    private final String key;
    private final SecretKeySpec secretKeySpec;

    public EncryptionManagerImpl(String s, String s1)
    {
        encryptionAlgorithm = s;
        key = s1;
        try
        {
            secretKeySpec = new SecretKeySpec(s1.getBytes("UTF-8"), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new DataStoreException(s);
        }
    }

    public String decrypt(byte abyte0[])
    {
        Object obj;
        Object obj1;
        Object obj4;
        Object obj5;
        com.amazon.profiling.ProfilerScope profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/EncryptionManagerImpl, "decrypt");
        Object obj8 = null;
        obj = null;
        Object obj9 = null;
        Object obj6 = null;
        obj5 = null;
        Object obj10 = null;
        Object obj7 = null;
        obj1 = null;
        Object obj2 = obj8;
        Object obj3 = obj10;
        obj4 = obj9;
        Exception exception;
        Cipher cipher;
        int i;
        try
        {
            cipher = Cipher.getInstance(encryptionAlgorithm);
        }
        catch (Exception exception1)
        {
            abyte0 = ((byte []) (obj));
            obj = exception1;
            obj4 = obj5;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj = obj3;
            abyte0 = ((byte []) (obj2));
        }
        obj2 = obj8;
        obj3 = obj10;
        obj4 = obj9;
        cipher.init(2, secretKeySpec);
        obj2 = obj8;
        obj3 = obj10;
        obj4 = obj9;
        abyte0 = new ByteArrayInputStream(cipher.doFinal(abyte0));
        try
        {
            obj = new GZIPInputStream(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj4 = obj5;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj = obj7;
            obj4 = obj6;
            continue; /* Loop/switch isn't completed */
        }
        obj1 = new ByteArrayOutputStream(1024);
        obj2 = new byte[1024];
_L3:
        i = ((GZIPInputStream) (obj)).read(((byte []) (obj2)));
        if (i <= 0) goto _L2; else goto _L1
_L1:
        ((ByteArrayOutputStream) (obj1)).write(((byte []) (obj2)), 0, i);
          goto _L3
        obj2;
        obj4 = obj1;
        obj1 = obj;
        obj = obj2;
_L9:
        obj2 = abyte0;
        obj3 = obj1;
        throw new DataStoreException(((Throwable) (obj)));
_L7:
        safelyClose(((Closeable) (obj)), "GZIPInputStream");
        safelyClose(abyte0, "ByteArrayInputStream");
        safelyClose(((Closeable) (obj4)), "GZuipOutputStream");
        throw obj1;
        abyte0;
_L5:
        Profiler.scopeEnd(profilerscope);
        throw abyte0;
_L2:
        obj2 = new String(((ByteArrayOutputStream) (obj1)).toByteArray(), "UTF-8");
        safelyClose(((Closeable) (obj)), "GZIPInputStream");
        safelyClose(abyte0, "ByteArrayInputStream");
        safelyClose(((Closeable) (obj1)), "GZuipOutputStream");
        Profiler.scopeEnd(profilerscope);
        return ((String) (obj2));
        abyte0;
        if (true) goto _L5; else goto _L4
_L4:
        break MISSING_BLOCK_LABEL_109;
        obj1;
        obj4 = obj6;
        continue; /* Loop/switch isn't completed */
        exception;
        obj4 = obj1;
        obj1 = exception;
        if (true) goto _L7; else goto _L6
        Exception exception2;
        exception2;
        obj1 = obj;
        obj = exception2;
        obj4 = obj5;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public byte[] encrypt(JSONObject jsonobject)
    {
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        com.amazon.profiling.ProfilerScope profilerscope;
        profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/EncryptionManagerImpl, "encrypt");
        obj1 = null;
        obj5 = null;
        obj2 = null;
        obj4 = null;
        obj3 = null;
        Object obj = new ByteArrayOutputStream(1024);
        try
        {
            obj1 = new GZIPOutputStream(((java.io.OutputStream) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            jsonobject = ((JSONObject) (obj));
            obj = obj1;
            obj2 = obj3;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = obj;
            obj2 = obj4;
            continue; /* Loop/switch isn't completed */
        }
        ((GZIPOutputStream) (obj1)).write(jsonobject.toString().getBytes("UTF-8"));
        ((GZIPOutputStream) (obj1)).close();
        jsonobject = Cipher.getInstance(encryptionAlgorithm);
        jsonobject.init(1, secretKeySpec);
        jsonobject = jsonobject.doFinal(((ByteArrayOutputStream) (obj)).toByteArray());
        safelyClose(((Closeable) (obj)), "ByteArrayOutputStream");
        safelyClose(((Closeable) (obj1)), "GZipOutputStream");
        Profiler.scopeEnd(profilerscope);
        return jsonobject;
        obj;
        obj2 = obj3;
        jsonobject = obj5;
_L6:
        obj1 = jsonobject;
        throw new DataStoreException(((Throwable) (obj)));
        jsonobject;
_L4:
        safelyClose(((Closeable) (obj1)), "ByteArrayOutputStream");
        safelyClose(((Closeable) (obj2)), "GZipOutputStream");
        throw jsonobject;
        jsonobject;
_L2:
        Profiler.scopeEnd(profilerscope);
        throw jsonobject;
        jsonobject;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject;
        obj2 = obj1;
        obj1 = obj;
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        jsonobject = ((JSONObject) (obj));
        obj = exception;
        exception = ((Exception) (obj1));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getEncryptionAlgorithm()
    {
        return encryptionAlgorithm;
    }

    public String getKey()
    {
        return key;
    }

    protected void safelyClose(Closeable closeable, String s)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        Logger.w((new StringBuilder()).append("Error closing ").append(s).toString(), closeable);
        return;
    }
}
