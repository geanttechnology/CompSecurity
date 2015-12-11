// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.android.a;

import com.gimbal.internal.d.b;
import com.gimbal.internal.d.d;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;

public final class a extends AbstractHttpMessageConverter
{

    private final b a;

    public a(b b1)
    {
        a = b1;
        b1 = new ArrayList();
        b1.add(MediaType.APPLICATION_JSON);
        setSupportedMediaTypes(b1);
    }

    private Object a(Class class1, String s)
    {
        try
        {
            class1 = ((Class) (a.a(class1, s)));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IOException(class1.getMessage());
        }
        return class1;
    }

    protected final Object readInternal(Class class1, HttpInputMessage httpinputmessage)
    {
        char ac[];
        StringBuilder stringbuilder;
        httpinputmessage = new InputStreamReader(httpinputmessage.getBody());
        ac = new char[8192];
        stringbuilder = new StringBuilder();
_L1:
        int i = httpinputmessage.read(ac);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                stringbuilder.append(new String(ac, 0, i));
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new HttpMessageNotWritableException("Object json mapping failed", class1);
            }
        }
          goto _L1
        class1 = ((Class) (a(class1, stringbuilder.toString().trim())));
        return class1;
    }

    protected final boolean supports(Class class1)
    {
        return true;
    }

    protected final void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
    {
        try
        {
            obj = a.a(obj);
            httpoutputmessage.getBody().write(((String) (obj)).getBytes("UTF-8"));
            httpoutputmessage.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new HttpMessageNotWritableException("Object json mapping failed", ((Throwable) (obj)));
        }
    }
}
