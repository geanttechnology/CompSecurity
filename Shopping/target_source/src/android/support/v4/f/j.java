// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.f;

import java.util.Map;

// Referenced classes of package android.support.v4.f:
//            b, a

public class j
{

    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object mBaseCache[];
    static int mBaseCacheSize;
    static Object mTwiceBaseCache[];
    static int mTwiceBaseCacheSize;
    Object mArray[];
    int mHashes[];
    int mSize;

    public j()
    {
        mHashes = b.a;
        mArray = b.c;
        mSize = 0;
    }

    public j(int i)
    {
        if (i == 0)
        {
            mHashes = b.a;
            mArray = b.c;
        } else
        {
            e(i);
        }
        mSize = 0;
    }

    private static void a(int ai[], Object aobj[], int i)
    {
        if (ai.length != 8) goto _L2; else goto _L1
_L1:
        android/support/v4/f/a;
        JVM INSTR monitorenter ;
        if (mTwiceBaseCacheSize < 10)
        {
            aobj[0] = ((Object) (mTwiceBaseCache));
            break MISSING_BLOCK_LABEL_24;
        }
          goto _L3
_L8:
        mTwiceBaseCache = aobj;
        mTwiceBaseCacheSize++;
_L3:
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
        return;
        ai;
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
        throw ai;
_L2:
        if (ai.length != 4) goto _L5; else goto _L4
_L4:
        android/support/v4/f/a;
        JVM INSTR monitorenter ;
        if (mBaseCacheSize >= 10) goto _L7; else goto _L6
_L6:
        aobj[0] = ((Object) (mBaseCache));
        aobj[1] = ai;
        i = (i << 1) - 1;
        break MISSING_BLOCK_LABEL_134;
_L9:
        mBaseCache = aobj;
        mBaseCacheSize++;
_L7:
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
        return;
        ai;
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
        throw ai;
        aobj[1] = ai;
        i = (i << 1) - 1;
        while (i >= 2) 
        {
            aobj[i] = null;
            i--;
        }
          goto _L8
_L5:
        return;
        while (i >= 2) 
        {
            aobj[i] = null;
            i--;
        }
          goto _L9
    }

    private void e(int i)
    {
        if (i != 8) goto _L2; else goto _L1
_L1:
        android/support/v4/f/a;
        JVM INSTR monitorenter ;
        Object aobj[];
        if (mTwiceBaseCache == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        aobj = mTwiceBaseCache;
        mArray = aobj;
        mTwiceBaseCache = (Object[])(Object[])aobj[0];
        mHashes = (int[])(int[])aobj[1];
        aobj[1] = null;
        aobj[0] = null;
        mTwiceBaseCacheSize--;
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
        return;
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
_L4:
        mHashes = new int[i];
        mArray = new Object[i << 1];
        return;
        Exception exception;
        exception;
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (i != 4) goto _L4; else goto _L3
_L3:
        android/support/v4/f/a;
        JVM INSTR monitorenter ;
        if (mBaseCache == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        exception = ((Exception) (mBaseCache));
        mArray = exception;
        mBaseCache = (Object[])(Object[])exception[0];
        mHashes = (int[])(int[])exception[1];
        exception[1] = null;
        exception[0] = null;
        mBaseCacheSize--;
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
        return;
        exception;
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
        throw exception;
        android/support/v4/f/a;
        JVM INSTR monitorexit ;
          goto _L4
    }

    int a()
    {
        int i1 = mSize;
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        return i;
_L2:
        int l;
        int k = android.support.v4.f.b.a(mHashes, i1, 0);
        i = k;
        if (k >= 0)
        {
            i = k;
            if (mArray[k << 1] != null)
            {
                for (l = k + 1; l < i1 && mHashes[l] == 0; l++)
                {
                    if (mArray[l << 1] == null)
                    {
                        return l;
                    }
                }

                k--;
label0:
                do
                {
label1:
                    {
                        if (k < 0 || mHashes[k] != 0)
                        {
                            break label1;
                        }
                        i = k;
                        if (mArray[k << 1] == null)
                        {
                            break label0;
                        }
                        k--;
                    }
                } while (true);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        return ~l;
    }

    public int a(Object obj)
    {
        if (obj == null)
        {
            return a();
        } else
        {
            return a(obj, obj.hashCode());
        }
    }

    int a(Object obj, int i)
    {
        int j1 = mSize;
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        int k = -1;
_L4:
        return k;
_L2:
        int i1;
        int l = android.support.v4.f.b.a(mHashes, j1, i);
        k = l;
        if (l >= 0)
        {
            k = l;
            if (!obj.equals(mArray[l << 1]))
            {
                for (i1 = l + 1; i1 < j1 && mHashes[i1] == i; i1++)
                {
                    if (obj.equals(mArray[i1 << 1]))
                    {
                        return i1;
                    }
                }

                l--;
label0:
                do
                {
label1:
                    {
                        if (l < 0 || mHashes[l] != i)
                        {
                            break label1;
                        }
                        k = l;
                        if (obj.equals(mArray[l << 1]))
                        {
                            break label0;
                        }
                        l--;
                    }
                } while (true);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        return ~i1;
    }

    public Object a(int i, Object obj)
    {
        i = (i << 1) + 1;
        Object obj1 = mArray[i];
        mArray[i] = obj;
        return obj1;
    }

    public void a(int i)
    {
        if (mHashes.length < i)
        {
            int ai[] = mHashes;
            Object aobj[] = mArray;
            e(i);
            if (mSize > 0)
            {
                System.arraycopy(ai, 0, mHashes, 0, mSize);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (mArray)), 0, mSize << 1);
            }
            a(ai, aobj, mSize);
        }
    }

    int b(Object obj)
    {
        Object aobj[];
        int i;
        boolean flag;
        int k;
        i = 1;
        flag = true;
        k = mSize * 2;
        aobj = mArray;
        if (obj != null) goto _L2; else goto _L1
_L1:
        for (i = ((flag) ? 1 : 0); i < k; i += 2)
        {
            if (aobj[i] == null)
            {
                return i >> 1;
            }
        }

          goto _L3
_L4:
        i += 2;
_L2:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj.equals(aobj[i]))
        {
            return i >> 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public Object b(int i)
    {
        return mArray[i << 1];
    }

    public Object c(int i)
    {
        return mArray[(i << 1) + 1];
    }

    public void clear()
    {
        if (mSize != 0)
        {
            a(mHashes, mArray, mSize);
            mHashes = b.a;
            mArray = b.c;
            mSize = 0;
        }
    }

    public boolean containsKey(Object obj)
    {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj)
    {
        return b(obj) >= 0;
    }

    public Object d(int i)
    {
        int k = 8;
        Object obj = mArray[(i << 1) + 1];
        if (mSize <= 1)
        {
            a(mHashes, mArray, mSize);
            mHashes = b.a;
            mArray = b.c;
            mSize = 0;
        } else
        if (mHashes.length > 8 && mSize < mHashes.length / 3)
        {
            if (mSize > 8)
            {
                k = mSize + (mSize >> 1);
            }
            int ai[] = mHashes;
            Object aobj[] = mArray;
            e(k);
            mSize = mSize - 1;
            if (i > 0)
            {
                System.arraycopy(ai, 0, mHashes, 0, i);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (mArray)), 0, i << 1);
            }
            if (i < mSize)
            {
                System.arraycopy(ai, i + 1, mHashes, i, mSize - i);
                System.arraycopy(((Object) (aobj)), i + 1 << 1, ((Object) (mArray)), i << 1, mSize - i << 1);
                return obj;
            }
        } else
        {
            mSize = mSize - 1;
            if (i < mSize)
            {
                System.arraycopy(mHashes, i + 1, mHashes, i, mSize - i);
                System.arraycopy(((Object) (mArray)), i + 1 << 1, ((Object) (mArray)), i << 1, mSize - i << 1);
            }
            mArray[mSize << 1] = null;
            mArray[(mSize << 1) + 1] = null;
            return obj;
        }
        return obj;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int i;
        if (!(obj instanceof Map))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        obj = (Map)obj;
        if (size() != ((Map) (obj)).size())
        {
            return false;
        }
        i = 0;
_L4:
        Object obj1;
        Object obj2;
        Object obj3;
        if (i >= mSize)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = b(i);
        obj2 = c(i);
        obj3 = ((Map) (obj)).get(obj1);
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (obj3 != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (!((Map) (obj)).containsKey(obj1))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        break MISSING_BLOCK_LABEL_106;
        boolean flag;
        try
        {
            flag = obj2.equals(obj3);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (!flag)
        {
            return false;
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        return false;
        return false;
    }

    public Object get(Object obj)
    {
        int i = a(obj);
        if (i >= 0)
        {
            return mArray[(i << 1) + 1];
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        int ai[] = mHashes;
        Object aobj[] = mArray;
        int j1 = mSize;
        int i = 1;
        int k = 0;
        int l = 0;
        while (k < j1) 
        {
            Object obj = aobj[i];
            int k1 = ai[k];
            int i1;
            if (obj == null)
            {
                i1 = 0;
            } else
            {
                i1 = obj.hashCode();
            }
            l += i1 ^ k1;
            k++;
            i += 2;
        }
        return l;
    }

    public boolean isEmpty()
    {
        return mSize <= 0;
    }

    public Object put(Object obj, Object obj1)
    {
        int l;
        byte byte0;
        int i1;
        byte0 = 8;
        int i;
        if (obj == null)
        {
            i = a();
            l = 0;
        } else
        {
            l = obj.hashCode();
            i = a(obj, l);
        }
        if (i >= 0)
        {
            i = (i << 1) + 1;
            obj = mArray[i];
            mArray[i] = obj1;
            return obj;
        }
        i1 = ~i;
        if (mSize < mHashes.length) goto _L2; else goto _L1
_L1:
        if (mSize < 8) goto _L4; else goto _L3
_L3:
        int k = mSize + (mSize >> 1);
_L6:
        int ai[] = mHashes;
        Object aobj[] = mArray;
        e(k);
        if (mHashes.length > 0)
        {
            System.arraycopy(ai, 0, mHashes, 0, ai.length);
            System.arraycopy(((Object) (aobj)), 0, ((Object) (mArray)), 0, aobj.length);
        }
        a(ai, aobj, mSize);
_L2:
        if (i1 < mSize)
        {
            System.arraycopy(mHashes, i1, mHashes, i1 + 1, mSize - i1);
            System.arraycopy(((Object) (mArray)), i1 << 1, ((Object) (mArray)), i1 + 1 << 1, mSize - i1 << 1);
        }
        mHashes[i1] = l;
        mArray[i1 << 1] = obj;
        mArray[(i1 << 1) + 1] = obj1;
        mSize = mSize + 1;
        return null;
_L4:
        k = byte0;
        if (mSize < 4)
        {
            k = 4;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Object remove(Object obj)
    {
        int i = a(obj);
        if (i >= 0)
        {
            return d(i);
        } else
        {
            return null;
        }
    }

    public int size()
    {
        return mSize;
    }

    public String toString()
    {
        if (isEmpty())
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
            Object obj = b(i);
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
            stringbuilder.append('=');
            obj = c(i);
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
}
