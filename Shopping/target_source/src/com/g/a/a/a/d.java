// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.a.a.a;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.lang.ref.WeakReference;
import java.nio.Buffer;

// Referenced classes of package com.g.a.a.a:
//            e, f

public abstract class d extends Structure
    implements e, Comparable
{

    transient WeakReference dependency;

    protected d()
    {
    }

    protected d(Pointer pointer)
    {
        super(pointer);
    }

    public static d[] newArray(Class class1, int i)
    {
        d ad[];
        Memory memory;
        d d2;
        int j;
        int k;
        try
        {
            d d1 = (d)class1.newInstance();
            k = d1.size();
            memory = new Memory(i * k);
            d1.use(memory);
            ad = (d[])d1.castToArray(i);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException(class1);
        }
        j = 1;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        d2 = (d)class1.newInstance();
        d2.use(memory, j * k);
        ad[j] = d2;
        j++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_45;
_L1:
        return ad;
    }

    public d byReference()
    {
        return setupClone(newByReference(), this);
    }

    public d byValue()
    {
        return setupClone(newByValue(), this);
    }

    public d[] castToArray()
    {
        return castToArray(1);
    }

    public d[] castToArray(int i)
    {
        return (d[])(d[])super.toArray(i);
    }

    public d[] castToArray(Structure astructure[])
    {
        return (d[])(d[])super.toArray(astructure);
    }

    public d[] castToReferenceArray()
    {
        return castToReferenceArray(1);
    }

    public d[] castToReferenceArray(int i)
    {
        return (d[])byReference().toArray(i);
    }

    public d[] castToValueArray()
    {
        return castToValueArray(1);
    }

    public d[] castToValueArray(int i)
    {
        return (d[])byValue().toArray(i);
    }

    public d clone()
    {
        return setupClone(newInstance(), this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public int compareTo(d d1)
    {
        boolean flag = true;
        if (d1 != this) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        i = ((flag) ? 1 : 0);
        if (!(d1 instanceof d))
        {
            continue; /* Loop/switch isn't completed */
        }
        int j = size();
        i = j - d1.size();
        if (i != 0)
        {
            return i;
        }
        if (getPointer().equals(d1.getPointer()))
        {
            return 0;
        }
        write();
        d1.write();
        byte abyte0[] = getPointer().getByteArray(0L, j);
        d1 = d1.getPointer().getByteArray(0L, j);
        i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            byte byte0 = abyte0[i];
            byte byte1 = d1[i];
            if (byte0 != byte1)
            {
                i = ((flag) ? 1 : 0);
                if (byte0 < byte1)
                {
                    return -1;
                }
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while (true);
        return 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((d)obj);
    }

    protected abstract d newByReference();

    protected abstract d newByValue();

    protected abstract d newInstance();

    public void read()
    {
        super.read();
        readDependency();
    }

    protected void readDependency()
    {
        e e1;
label0:
        {
            if (dependency != null)
            {
                e1 = (e)dependency.get();
                if (e1 != null)
                {
                    break label0;
                }
            }
            return;
        }
        e1.read();
    }

    public void setDependency(e e1)
    {
        if (e1 == null)
        {
            e1 = null;
        } else
        {
            e1 = new WeakReference(e1);
        }
        dependency = e1;
    }

    protected d setupClone(d d1, e e1)
    {
        write();
        d1.use(getPointer());
        d1.setDependency(this);
        return d1;
    }

    protected f setupClone(f f1)
    {
        write();
        f1.a(getPointer());
        return f1;
    }

    public d[] toArray()
    {
        return toArray(1);
    }

    public d[] toArray(int i)
    {
        return (d[])(d[])super.toArray(i);
    }

    public d[] toArray(Structure astructure[])
    {
        return (d[])(d[])super.toArray(astructure);
    }

    public volatile Structure[] toArray(int i)
    {
        return toArray(i);
    }

    public volatile Structure[] toArray(Structure astructure[])
    {
        return toArray(astructure);
    }

    public d[] toReferenceArray()
    {
        return toReferenceArray(1);
    }

    public d[] toReferenceArray(int i)
    {
        return (d[])byReference().toArray(i);
    }

    public d[] toValueArray()
    {
        return toValueArray(1);
    }

    public d[] toValueArray(int i)
    {
        return (d[])byValue().toArray(i);
    }

    public d use(Pointer pointer)
    {
        return use(pointer, 0L);
    }

    public d use(Pointer pointer, long l)
    {
        useMemory(pointer, (int)l);
        read();
        return this;
    }

    public d use(Buffer buffer)
    {
        return use(buffer, 0L);
    }

    public d use(Buffer buffer, long l)
    {
        useMemory(Native.getDirectBufferPointer(buffer), (int)l);
        return this;
    }

    public volatile e use(Pointer pointer)
    {
        return use(pointer);
    }

    public void write()
    {
        super.write();
        readDependency();
    }

    // Unreferenced inner class com/g/a/a/a/d$a
    /* block-local class not found */
    class a {}


    // Unreferenced inner class com/g/a/a/a/d$b
    /* block-local class not found */
    class b {}

}
