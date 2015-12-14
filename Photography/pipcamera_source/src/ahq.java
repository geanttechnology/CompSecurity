// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ahq
    implements aho
{

    private static ahq a;

    public ahq()
    {
    }

    public static ahq a()
    {
        if (a == null)
        {
            a = new ahq();
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
        Crashlytics.logException(((Throwable) (obj1)));
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
