// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ListIterator;

// Referenced classes of package com.twinprime.msgpack.type:
//            ArrayValue, Value, ValueType

class ArrayValueImpl extends AbstractList
    implements ArrayValue
{

    private static ArrayValueImpl emptyInstance = new ArrayValueImpl(new Value[0], true);
    private Value array[];

    ArrayValueImpl(Value avalue[], boolean flag)
    {
        if (flag)
        {
            array = avalue;
            return;
        } else
        {
            array = new Value[avalue.length];
            System.arraycopy(avalue, 0, array, 0, avalue.length);
            return;
        }
    }

    private boolean equals(ArrayValueImpl arrayvalueimpl)
    {
        if (array.length == arrayvalueimpl.array.length) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= array.length)
                {
                    break label1;
                }
                if (!array[i].equals(arrayvalueimpl.array[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static ArrayValue getEmptyInstance()
    {
        return emptyInstance;
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag2;
        if (!(obj instanceof Value)) goto _L4; else goto _L3
_L3:
        obj = (Value)obj;
        flag = flag2;
        if (((Value) (obj)).getType() != ValueType.ARRAY) goto _L4; else goto _L5
_L5:
        int i;
        if (obj.getClass() == com/twinprime/msgpack/type/ArrayValueImpl)
        {
            return equals((ArrayValueImpl)obj);
        }
        obj = ((ArrayValue)((Value) (obj)).getValue()).listIterator();
        i = 0;
_L8:
        if (i >= array.length)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        flag = flag2;
        if (!((ListIterator) (obj)).hasNext()) goto _L4; else goto _L6
_L6:
        flag = flag2;
        if (!array[i].equals(((ListIterator) (obj)).next())) goto _L4; else goto _L7
_L7:
        i++;
          goto _L8
        boolean flag1;
        if (!((ListIterator) (obj)).hasNext())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag1;
    }

    public Value get(int i)
    {
        if (i < 0 || array.length <= i)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return array[i];
        }
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public ValueType getType()
    {
        return ValueType.ARRAY;
    }

    public ArrayValue getValue()
    {
        return this;
    }

    public volatile Value getValue()
    {
        return getValue();
    }

    public int hashCode()
    {
        int j = 1;
        for (int i = 0; i < array.length; i++)
        {
            j = j * 31 + array[i].hashCode();
        }

        return j;
    }

    public int indexOf(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= array.length)
                {
                    break label1;
                }
                j = i;
                if (array[i].equals(obj))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public boolean isEmpty()
    {
        return array.length == 0;
    }

    public int lastIndexOf(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i = array.length - 1;
label0:
        do
        {
label1:
            {
                if (i < 0)
                {
                    break label1;
                }
                j = i;
                if (array[i].equals(obj))
                {
                    break label0;
                }
                i--;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public int size()
    {
        return array.length;
    }

    public String toString()
    {
        return toString(new StringBuilder()).toString();
    }

    public StringBuilder toString(StringBuilder stringbuilder)
    {
        if (array.length == 0)
        {
            return stringbuilder.append("[]");
        }
        stringbuilder.append("[");
        stringbuilder.append(array[0]);
        for (int i = 1; i < array.length; i++)
        {
            stringbuilder.append(",");
            array[i].toString(stringbuilder);
        }

        stringbuilder.append("]");
        return stringbuilder;
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.writeArrayBegin(array.length);
        for (int i = 0; i < array.length; i++)
        {
            array[i].writeTo(packer);
        }

        packer.writeArrayEnd();
    }

}
