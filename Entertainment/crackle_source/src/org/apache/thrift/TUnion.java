// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package org.apache.thrift:
//            TBase, TException

public abstract class TUnion
    implements TBase
{

    protected int setField_;
    protected Object value_;

    protected TUnion()
    {
        setField_ = 0;
        value_ = null;
    }

    protected TUnion(int i, Object obj)
    {
        setFieldValue(i, obj);
    }

    protected TUnion(TUnion tunion)
    {
        if (!tunion.getClass().equals(getClass()))
        {
            throw new ClassCastException();
        } else
        {
            setField_ = tunion.setField_;
            value_ = a(tunion.value_);
            return;
        }
    }

    private static Object a(Object obj)
    {
        Object obj1;
        if (obj instanceof TBase)
        {
            obj1 = ((TBase)obj).deepCopy();
        } else
        {
            if (obj instanceof byte[])
            {
                obj = (byte[])obj;
                obj1 = new byte[obj.length];
                System.arraycopy(obj, 0, obj1, 0, obj.length);
                return obj1;
            }
            if (obj instanceof List)
            {
                obj1 = (List)obj;
                obj = new ArrayList(((List) (obj1)).size());
                for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(a(((Iterator) (obj1)).next()))) { }
                return obj;
            }
            if (obj instanceof Set)
            {
                return a((Set)obj);
            }
            obj1 = obj;
            if (obj instanceof Map)
            {
                return a((Map)obj);
            }
        }
        return obj1;
    }

    private static Map a(Map map)
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); hashmap.put(a(entry.getKey()), a(entry.getValue())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return hashmap;
    }

    private static Set a(Set set)
    {
        HashSet hashset = new HashSet();
        for (set = set.iterator(); set.hasNext(); hashset.add(a(set.next()))) { }
        return hashset;
    }

    protected abstract void checkType(short word0, Object obj)
        throws ClassCastException;

    protected abstract TField getFieldDesc(int i);

    public Object getFieldValue()
    {
        return value_;
    }

    public Object getFieldValue(int i)
    {
        if (i != setField_)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot get the value of field ").append(i).append(" because union's set field is ").append(setField_).toString());
        } else
        {
            return getFieldValue();
        }
    }

    public int getSetField()
    {
        return setField_;
    }

    protected abstract TStruct getStructDesc();

    public boolean isSet()
    {
        return setField_ != 0;
    }

    public boolean isSet(int i)
    {
        return setField_ == i;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        setField_ = 0;
        value_ = null;
        tprotocol.readStructBegin();
        TField tfield = tprotocol.readFieldBegin();
        value_ = readValue(tprotocol, tfield);
        if (value_ != null)
        {
            setField_ = tfield.id;
        }
        tprotocol.readFieldEnd();
        tprotocol.readFieldBegin();
        tprotocol.readStructEnd();
    }

    protected abstract Object readValue(TProtocol tprotocol, TField tfield)
        throws TException;

    public void setFieldValue(int i, Object obj)
    {
        checkType((short)i, obj);
        setField_ = (short)i;
        value_ = obj;
    }

    public String toString()
    {
        Object obj = getFieldValue();
        if (obj instanceof byte[])
        {
            byte abyte0[] = (byte[])obj;
            StringBuilder stringbuilder = new StringBuilder();
            int j = Math.min(abyte0.length, 128);
            int i = 0;
            while (i < j) 
            {
                if (i != 0)
                {
                    stringbuilder.append(" ");
                }
                obj = Integer.toHexString(abyte0[i]);
                if (((String) (obj)).length() <= 1)
                {
                    obj = (new StringBuilder()).append("0").append(((String) (obj))).toString();
                }
                stringbuilder.append(((String) (obj)));
                i++;
            }
            if (abyte0.length > 128)
            {
                stringbuilder.append(" ...");
            }
            obj = stringbuilder.toString();
        } else
        {
            obj = obj.toString();
        }
        return (new StringBuilder()).append("<").append(getClass().getSimpleName()).append(" ").append(getFieldDesc(getSetField()).name).append(":").append(((String) (obj))).append(">").toString();
    }

    public void write(TProtocol tprotocol)
        throws TException
    {
        if (getSetField() == 0 || getFieldValue() == null)
        {
            throw new TProtocolException("Cannot write a TUnion with no set value!");
        } else
        {
            tprotocol.writeStructBegin(getStructDesc());
            tprotocol.writeFieldBegin(getFieldDesc(setField_));
            writeValue(tprotocol, (short)setField_, value_);
            tprotocol.writeFieldEnd();
            tprotocol.writeFieldStop();
            tprotocol.writeStructEnd();
            return;
        }
    }

    protected abstract void writeValue(TProtocol tprotocol, short word0, Object obj)
        throws TException;
}
