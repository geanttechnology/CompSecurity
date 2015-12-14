// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class cer
    implements cep
{

    private static cer a;

    public cer()
    {
    }

    public static cer a()
    {
        if (a == null)
        {
            a = new cer();
        }
        return a;
    }

    public Object a(InputStream inputstream)
    {
        inputstream = new ObjectInputStream(inputstream);
        Object obj = inputstream.readObject();
        inputstream.close();
        return obj;
        Object obj1;
        obj1;
        ((ClassNotFoundException) (obj1)).printStackTrace();
        inputstream.close();
        return null;
        obj1;
        inputstream.close();
        throw obj1;
    }

    public void a(OutputStream outputstream, Object obj)
    {
        outputstream = new ObjectOutputStream(outputstream);
        outputstream.writeObject(obj);
        outputstream.close();
    }
}
