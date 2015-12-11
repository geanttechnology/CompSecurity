// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit.converter;

import android.support.v7.aeu;
import android.support.v7.afe;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

// Referenced classes of package retrofit.converter:
//            Converter, ConversionException

public class GsonConverter
    implements Converter
{
    private static class JsonTypedOutput
        implements TypedOutput
    {

        private final byte jsonBytes[];
        private final String mimeType;

        public String fileName()
        {
            return null;
        }

        public long length()
        {
            return (long)jsonBytes.length;
        }

        public String mimeType()
        {
            return mimeType;
        }

        public void writeTo(OutputStream outputstream)
            throws IOException
        {
            outputstream.write(jsonBytes);
        }

        JsonTypedOutput(byte abyte0[], String s)
        {
            jsonBytes = abyte0;
            mimeType = (new StringBuilder()).append("application/json; charset=").append(s).toString();
        }
    }


    private String charset;
    private final aeu gson;

    public GsonConverter(aeu aeu1)
    {
        this(aeu1, "UTF-8");
    }

    public GsonConverter(aeu aeu1, String s)
    {
        gson = aeu1;
        charset = s;
    }

    public Object fromBody(TypedInput typedinput, Type type)
        throws ConversionException
    {
        Object obj;
        String s;
        Object obj1;
        obj = charset;
        s = ((String) (obj));
        if (typedinput.mimeType() != null)
        {
            s = MimeUtil.parseCharset(typedinput.mimeType(), ((String) (obj)));
        }
        obj = null;
        obj1 = null;
        typedinput = new InputStreamReader(typedinput.in(), s);
        obj = typedinput;
        type = ((Type) (gson.a(typedinput, type)));
        if (typedinput != null)
        {
            try
            {
                typedinput.close();
            }
            // Misplaced declaration of an exception variable
            catch (TypedInput typedinput)
            {
                return type;
            }
        }
        return type;
        type;
        typedinput = null;
_L4:
        obj = typedinput;
        throw new ConversionException(type);
        typedinput;
_L1:
        if (obj != null)
        {
            try
            {
                ((InputStreamReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Type type) { }
        }
        throw typedinput;
        typedinput;
        obj = obj1;
_L2:
        throw new ConversionException(typedinput);
        typedinput;
          goto _L1
        type;
        obj = typedinput;
        typedinput = type;
          goto _L2
        type;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public TypedOutput toBody(Object obj)
    {
        try
        {
            obj = new JsonTypedOutput(gson.a(obj).getBytes(charset), charset);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AssertionError(obj);
        }
        return ((TypedOutput) (obj));
    }
}
