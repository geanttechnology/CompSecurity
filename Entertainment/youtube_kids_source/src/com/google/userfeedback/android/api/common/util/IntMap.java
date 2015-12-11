// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.util;

import java.util.Enumeration;
import java.util.Hashtable;

// Referenced classes of package com.google.userfeedback.android.api.common.util:
//            Primitives

public class IntMap
{

    private static final int INITIAL_LOWER_BUFFER_SIZE = 16;
    private static final int MAX_LOWER_BUFFER_SIZE = 128;
    private Hashtable higher;
    private Object lower[];
    private int lowerCount;
    private int maxKey;
    private int maxLowerKey;

    public IntMap()
    {
        this(16);
    }

    IntMap(int i)
    {
        int j = 16;
        if (i > 0)
        {
            j = Math.min(i, 128);
        }
        lower = new Object[j];
        lowerCount = 0;
        maxKey = 0x80000000;
        maxLowerKey = 0x80000000;
    }

    private static boolean compareHashtable(Hashtable hashtable, Hashtable hashtable1)
    {
        if (hashtable != hashtable1) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (hashtable == null || hashtable1 == null)
        {
            return false;
        }
        if (hashtable.size() != hashtable1.size())
        {
            return false;
        }
        Enumeration enumeration = hashtable.keys();
        Object obj;
        do
        {
            if (!enumeration.hasMoreElements())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = enumeration.nextElement();
        } while (hashtable.get(obj).equals(hashtable1.get(obj)));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    private boolean compareLowerBuffer(Object aobj[], Object aobj1[])
    {
        int i = Math.min(aobj.length, aobj1.length);
        for (int j = 0; j < i; j++)
        {
            if (aobj[j] == null && aobj1[j] != null || aobj[j] != null && !aobj[j].equals(aobj1[j]))
            {
                return false;
            }
        }

        if (aobj.length > aobj1.length)
        {
            for (; i < aobj.length; i++)
            {
                if (aobj[i] != null)
                {
                    return false;
                }
            }

        } else
        if (aobj.length < aobj1.length)
        {
            for (; i < aobj1.length; i++)
            {
                if (aobj1[i] != null)
                {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean expandLowerIfNecessary(int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (i < 128)
        {
            flag = flag1;
            if (i >= lower.length)
            {
                flag = flag1;
                if (i > 0)
                {
                    int j = lower.length;
                    int k;
                    do
                    {
                        k = j << 1;
                        j = k;
                    } while (k <= i);
                    Object aobj[] = new Object[Math.min(k, 128)];
                    System.arraycopy(((Object) (lower)), 0, ((Object) (aobj)), 0, lower.length);
                    lower = aobj;
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void clear()
    {
        for (int i = 0; i < lower.length; i++)
        {
            lower[i] = null;
        }

        if (higher != null)
        {
            higher.clear();
        }
        maxKey = 0x80000000;
        maxLowerKey = 0x80000000;
        lowerCount = 0;
    }

    public boolean containsKey(int i)
    {
        boolean flag = false;
        if (i >= 0 && i < lower.length)
        {
            if (lower[i] != null)
            {
                flag = true;
            }
        } else
        if (higher != null)
        {
            return higher.containsKey(Primitives.toInteger(i));
        }
        return flag;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof IntMap))
            {
                return false;
            }
            obj = (IntMap)obj;
            if (size() != ((IntMap) (obj)).size())
            {
                return false;
            }
            if (!compareLowerBuffer(lower, ((IntMap) (obj)).lower) || !compareHashtable(higher, ((IntMap) (obj)).higher))
            {
                return false;
            }
        }
        return true;
    }

    public Object get(int i)
    {
        Object obj1 = null;
        Object obj;
        if (i <= maxLowerKey && i >= 0)
        {
            obj = lower[i];
        } else
        {
            obj = obj1;
            if (i <= maxKey)
            {
                obj = obj1;
                if (higher != null)
                {
                    return higher.get(Primitives.toInteger(i));
                }
            }
        }
        return obj;
    }

    public int getNumBytesOverhead()
    {
        int i = 0;
        int k = lower.length;
        int j;
        if (higher != null)
        {
            j = higher.size() << 2;
            i = (higher.size() << 2 << 2) / 3;
        } else
        {
            j = 0;
        }
        return i + (j + (k << 2));
    }

    public int hashCode()
    {
        int j = 1;
        for (int i = 0; i < lower.length;)
        {
            Object obj = lower[i];
            int k = j;
            if (obj != null)
            {
                k = j * 31 + obj.hashCode() + i;
            }
            i++;
            j = k;
        }

        if (higher == null)
        {
            return j;
        } else
        {
            return j + higher.size();
        }
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public KeyIterator keys()
    {
        return new KeyIterator();
    }

    public int maxKey()
    {
        return maxKey;
    }

    public IntMap newIntMapWithSameBufferSize()
    {
        return new IntMap(maxLowerKey);
    }

    public void put(int i, Object obj)
    {
        if (obj == null)
        {
            remove(i);
            return;
        }
        if (i > maxKey)
        {
            maxKey = i;
        }
        if ((i < 0 || i >= lower.length) && !expandLowerIfNecessary(i)) goto _L2; else goto _L1
_L1:
        if (i <= maxLowerKey) goto _L4; else goto _L3
_L3:
        maxLowerKey = i;
        lowerCount = lowerCount + 1;
_L5:
        lower[i] = obj;
        return;
_L4:
        if (lower[i] == null)
        {
            lowerCount = lowerCount + 1;
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (higher == null)
        {
            higher = new Hashtable();
        }
        higher.put(Primitives.toInteger(i), obj);
        return;
    }

    public Object remove(int i)
    {
        if (i >= 0 && i < lower.length)
        {
            Object obj = lower[i];
            if (obj != null)
            {
                lowerCount = lowerCount - 1;
            }
            lower[i] = null;
            return obj;
        }
        if (higher != null)
        {
            return higher.remove(Primitives.toInteger(i));
        } else
        {
            return null;
        }
    }

    public int size()
    {
        if (higher == null)
        {
            return lowerCount;
        } else
        {
            return lowerCount + higher.size();
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("IntMap{lower:");
        for (int i = 0; i < lower.length; i++)
        {
            if (lower[i] != null)
            {
                stringbuffer.append(i);
                stringbuffer.append("=>");
                stringbuffer.append(lower[i]);
                stringbuffer.append(", ");
            }
        }

        String s = String.valueOf(higher);
        stringbuffer.append((new StringBuilder(String.valueOf(s).length() + 10)).append(", higher:").append(s).append("}").toString());
        return stringbuffer.toString();
    }




    private class KeyIterator
    {

        private int currentKey;
        private Enumeration higherKeyEnumerator;
        private int oneAheadIndex;
        final IntMap this$0;

        public boolean hasNext()
        {
            if (currentKey != 0x80000000)
            {
                return true;
            }
            if (oneAheadIndex <= maxLowerKey)
            {
                for (; oneAheadIndex <= maxLowerKey; oneAheadIndex = oneAheadIndex + 1)
                {
                    if (lower[oneAheadIndex] != null)
                    {
                        int i = oneAheadIndex;
                        oneAheadIndex = i + 1;
                        currentKey = i;
                        return true;
                    }
                }

            }
            if (higher != null)
            {
                if (higherKeyEnumerator == null)
                {
                    higherKeyEnumerator = higher.keys();
                }
                if (higherKeyEnumerator.hasMoreElements())
                {
                    currentKey = ((Integer)higherKeyEnumerator.nextElement()).intValue();
                    return true;
                }
            }
            return false;
        }

        public int next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            } else
            {
                int i = currentKey;
                currentKey = 0x80000000;
                return i;
            }
        }

        public KeyIterator()
        {
            this$0 = IntMap.this;
            super();
            oneAheadIndex = 0;
            currentKey = 0x80000000;
            higherKeyEnumerator = null;
        }
    }

}
