// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ehk extends eha
{

    private static final long serialVersionUID = 0L;
    private transient int c;

    private ehk()
    {
        super(new HashMap());
        c = 2;
    }

    public static ehk h()
    {
        return new ehk();
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        c = objectinputstream.readInt();
        int i = a.a(objectinputstream);
        Object obj = ejr.a(i);
        super.a = ((Map) (obj));
        super.b = 0;
        obj = ((Map) (obj)).values().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            Collection collection = (Collection)((Iterator) (obj)).next();
            int j;
            boolean flag;
            if (!collection.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.a(flag);
            j = super.b;
            super.b = collection.size() + j;
        }
        a.a(this, objectinputstream, i);
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeInt(c);
        a.a(this, objectoutputstream);
    }

    final Collection a()
    {
        return a.h(c);
    }

    public final volatile boolean a(Object obj)
    {
        return super.a(obj);
    }

    public final volatile boolean a(Object obj, Object obj1)
    {
        return super.a(obj, obj1);
    }

    public final volatile void b()
    {
        super.b();
    }

    public final volatile Set c(Object obj)
    {
        return super.c(obj);
    }

    public final volatile Set e()
    {
        return super.e();
    }

    public final volatile boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public final volatile Map f()
    {
        return super.f();
    }

    final Set g()
    {
        return a.h(c);
    }

    public final volatile int hashCode()
    {
        return super.hashCode();
    }

    public final volatile String toString()
    {
        return super.toString();
    }
}
