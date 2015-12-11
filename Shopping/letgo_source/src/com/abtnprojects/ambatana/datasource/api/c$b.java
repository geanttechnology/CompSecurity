// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import android.support.v7.aqo;
import android.util.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

// Referenced classes of package com.abtnprojects.ambatana.datasource.api:
//            c

public static class 
    implements Converter
{

    private void a(TypedInput typedinput)
    {
        try
        {
            typedinput.in().close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TypedInput typedinput)
        {
            typedinput.printStackTrace();
        }
    }

    public Object fromBody(TypedInput typedinput, Type type)
        throws ConversionException
    {
        (new JsonReader(new InputStreamReader(typedinput.in()))).setLenient(true);
        type = ((Type) (new Object()));
        a(typedinput);
        return type;
        typedinput;
        aqo.b(typedinput, "fromBody", new Object[0]);
        return null;
        typedinput;
        throw typedinput;
    }

    public TypedOutput toBody(Object obj)
    {
        return null;
    }

    public ()
    {
    }
}
