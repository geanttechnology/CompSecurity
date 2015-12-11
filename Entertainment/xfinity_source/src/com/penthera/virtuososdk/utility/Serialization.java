// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public final class Serialization
{

    public static Object deserializeObject(byte abyte0[])
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        obj = null;
        obj1 = null;
        abyte0 = new ObjectInputStream(new ByteArrayInputStream(abyte0));
        obj = abyte0.readObject();
        if (abyte0 != null)
        {
            try
            {
                abyte0.close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                CommonUtil.Log.e("deserializeObject", "io error2", abyte0);
            }
        }
_L2:
        return obj;
        obj;
        abyte0 = ((byte []) (obj1));
        obj1 = obj;
_L7:
        obj = abyte0;
        CommonUtil.Log.e("deserializeObject", "class not found error", ((Throwable) (obj1)));
        obj = obj2;
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            CommonUtil.Log.e("deserializeObject", "io error2", abyte0);
            return null;
        }
        return null;
        IOException ioexception;
        ioexception;
        abyte0 = obj3;
_L6:
        obj = abyte0;
        CommonUtil.Log.e("deserializeObject", "io error", ioexception);
        obj = obj2;
        if (abyte0 == null) goto _L2; else goto _L3
_L3:
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            CommonUtil.Log.e("deserializeObject", "io error2", abyte0);
            return null;
        }
        return null;
        abyte0;
_L5:
        if (obj != null)
        {
            try
            {
                ((ObjectInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                CommonUtil.Log.e("deserializeObject", "io error2", ((Throwable) (obj)));
            }
        }
        throw abyte0;
        ioexception;
        obj = abyte0;
        abyte0 = ioexception;
        if (true) goto _L5; else goto _L4
_L4:
        ioexception;
          goto _L6
        ioexception;
          goto _L7
    }

    public static byte[] serializeObject(Object obj)
    {
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = null;
        obj3 = null;
        obj2 = null;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            obj1 = new ObjectOutputStream(bytearrayoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = obj3;
        }
        ((ObjectOutput) (obj1)).writeObject(obj);
        obj = bytearrayoutputstream.toByteArray();
        if (obj1 != null)
        {
            try
            {
                ((ObjectOutput) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                CommonUtil.Log.e("serializeObject", "error2", ((Throwable) (obj1)));
            }
        }
        return ((byte []) (obj));
        obj;
_L4:
        obj1 = obj2;
        CommonUtil.Log.e("serializeObject", "error", ((Throwable) (obj)));
        if (obj2 != null)
        {
            try
            {
                ((ObjectOutput) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                CommonUtil.Log.e("serializeObject", "error2", ((Throwable) (obj)));
            }
        }
        return null;
        obj;
_L2:
        if (obj1 != null)
        {
            try
            {
                ((ObjectOutput) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                CommonUtil.Log.e("serializeObject", "error2", ((Throwable) (obj1)));
            }
        }
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        obj2 = obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
