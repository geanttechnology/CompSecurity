// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class s
{

    public s()
    {
    }

    public static Object a(String s1)
    {
        if (s1 == null || s1.length() == 0)
        {
            return null;
        }
        try
        {
            s1 = ((String) ((new ObjectInputStream(new ByteArrayInputStream(b(s1)))).readObject()));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        return s1;
    }

    public static String a(Serializable serializable)
    {
        if (serializable == null)
        {
            return "";
        }
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
            objectoutputstream.writeObject(serializable);
            objectoutputstream.close();
            serializable = a(bytearrayoutputstream.toByteArray());
        }
        // Misplaced declaration of an exception variable
        catch (Serializable serializable)
        {
            serializable.printStackTrace();
            return null;
        }
        return serializable;
    }

    public static String a(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return stringbuffer.toString();
            }
            stringbuffer.append((char)((abyte0[i] >> 4 & 0xf) + 97));
            stringbuffer.append((char)((abyte0[i] & 0xf) + 97));
            i++;
        } while (true);
    }

    public static byte[] b(String s1)
    {
        byte abyte0[] = new byte[s1.length() / 2];
        int i = 0;
        do
        {
            if (i >= s1.length())
            {
                return abyte0;
            }
            char c = s1.charAt(i);
            abyte0[i / 2] = (byte)(c - 97 << 4);
            c = s1.charAt(i + 1);
            int j = i / 2;
            abyte0[j] = (byte)((c - 97) + abyte0[j]);
            i += 2;
        } while (true);
    }
}
