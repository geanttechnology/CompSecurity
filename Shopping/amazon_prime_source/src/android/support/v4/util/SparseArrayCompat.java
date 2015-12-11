// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.util;


// Referenced classes of package android.support.v4.util:
//            ContainerHelpers

public class SparseArrayCompat
    implements Cloneable
{

    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int mKeys[];
    private int mSize;
    private Object mValues[];

    public SparseArrayCompat()
    {
        this(10);
    }

    public SparseArrayCompat(int i)
    {
        mGarbage = false;
        if (i == 0)
        {
            mKeys = ContainerHelpers.EMPTY_INTS;
            mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else
        {
            i = ContainerHelpers.idealIntArraySize(i);
            mKeys = new int[i];
            mValues = new Object[i];
        }
        mSize = 0;
    }

    private void gc()
    {
        int l = mSize;
        int j = 0;
        int ai[] = mKeys;
        Object aobj[] = mValues;
        for (int i = 0; i < l;)
        {
            Object obj = aobj[i];
            int k = j;
            if (obj != DELETED)
            {
                if (i != j)
                {
                    ai[j] = ai[i];
                    aobj[j] = obj;
                    aobj[i] = null;
                }
                k = j + 1;
            }
            i++;
            j = k;
        }

        mGarbage = false;
        mSize = j;
    }

    public void clear()
    {
        int j = mSize;
        Object aobj[] = mValues;
        for (int i = 0; i < j; i++)
        {
            aobj[i] = null;
        }

        mSize = 0;
        mGarbage = false;
    }

    public SparseArrayCompat clone()
    {
        SparseArrayCompat sparsearraycompat = null;
        SparseArrayCompat sparsearraycompat1;
        try
        {
            sparsearraycompat1 = (SparseArrayCompat)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return sparsearraycompat;
        }
        sparsearraycompat = sparsearraycompat1;
        sparsearraycompat1.mKeys = (int[])mKeys.clone();
        sparsearraycompat = sparsearraycompat1;
        sparsearraycompat1.mValues = (Object[])((Object []) (mValues)).clone();
        return sparsearraycompat1;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public int keyAt(int i)
    {
        if (mGarbage)
        {
            gc();
        }
        return mKeys[i];
    }

    public int size()
    {
        if (mGarbage)
        {
            gc();
        }
        return mSize;
    }

    public String toString()
    {
        if (size() <= 0)
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder(mSize * 28);
        stringbuilder.append('{');
        int i = 0;
        while (i < mSize) 
        {
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(keyAt(i));
            stringbuilder.append('=');
            Object obj = valueAt(i);
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
            i++;
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public Object valueAt(int i)
    {
        if (mGarbage)
        {
            gc();
        }
        return mValues[i];
    }

}
