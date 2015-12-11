// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.sym;

import com.flurry.org.codehaus.jackson.util.InternCache;
import java.util.Arrays;

public final class CharsToNameCanonicalizer
{
    static final class Bucket
    {

        private final String _symbol;
        private final Bucket mNext;

        public String find(char ac[], int i, int j)
        {
            Bucket bucket;
            String s;
            s = _symbol;
            bucket = mNext;
_L7:
            int k;
            if (s.length() != j)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            k = 0;
_L5:
            if (s.charAt(k) == ac[i + k]) goto _L2; else goto _L1
_L1:
            if (k == j)
            {
                return s;
            }
            break MISSING_BLOCK_LABEL_72;
_L2:
            int l = k + 1;
            k = l;
            if (l < j)
            {
                break; /* Loop/switch isn't completed */
            }
            k = l;
            if (true) goto _L1; else goto _L3
_L3:
            if (true) goto _L5; else goto _L4
_L4:
            if (bucket == null)
            {
                return null;
            }
            s = bucket.getSymbol();
            bucket = bucket.getNext();
            if (true) goto _L7; else goto _L6
_L6:
        }

        public Bucket getNext()
        {
            return mNext;
        }

        public String getSymbol()
        {
            return _symbol;
        }

        public Bucket(String s, Bucket bucket)
        {
            _symbol = s;
            mNext = bucket;
        }
    }


    protected static final int DEFAULT_TABLE_SIZE = 64;
    static final int MAX_ENTRIES_FOR_REUSE = 12000;
    protected static final int MAX_TABLE_SIZE = 0x10000;
    static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
    protected Bucket _buckets[];
    protected final boolean _canonicalize;
    protected boolean _dirty;
    protected int _indexMask;
    protected final boolean _intern;
    protected CharsToNameCanonicalizer _parent;
    protected int _size;
    protected int _sizeThreshold;
    protected String _symbols[];

    private CharsToNameCanonicalizer()
    {
        _canonicalize = true;
        _intern = true;
        _dirty = true;
        initTables(64);
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charstonamecanonicalizer, boolean flag, boolean flag1, String as[], Bucket abucket[], int i)
    {
        _parent = charstonamecanonicalizer;
        _canonicalize = flag;
        _intern = flag1;
        _symbols = as;
        _buckets = abucket;
        _size = i;
        i = as.length;
        _sizeThreshold = i - (i >> 2);
        _indexMask = i - 1;
        _dirty = false;
    }

    public static int calcHash(String s)
    {
        int j = s.charAt(0);
        int i = 1;
        for (int k = s.length(); i < k; i++)
        {
            j = j * 31 + s.charAt(i);
        }

        return j;
    }

    public static int calcHash(char ac[], int i, int j)
    {
        int k = ac[0];
        for (i = 1; i < j; i++)
        {
            k = k * 31 + ac[i];
        }

        return k;
    }

    private void copyArrays()
    {
        Object aobj[] = _symbols;
        int i = aobj.length;
        _symbols = new String[i];
        System.arraycopy(((Object) (aobj)), 0, _symbols, 0, i);
        aobj = _buckets;
        i = aobj.length;
        _buckets = new Bucket[i];
        System.arraycopy(((Object) (aobj)), 0, _buckets, 0, i);
    }

    public static CharsToNameCanonicalizer createRoot()
    {
        return sBootstrapSymbolTable.makeOrphan();
    }

    private void initTables(int i)
    {
        _symbols = new String[i];
        _buckets = new Bucket[i >> 1];
        _indexMask = i - 1;
        _size = 0;
        _sizeThreshold = i - (i >> 2);
    }

    private CharsToNameCanonicalizer makeOrphan()
    {
        return new CharsToNameCanonicalizer(null, true, true, _symbols, _buckets, _size);
    }

    private void mergeChild(CharsToNameCanonicalizer charstonamecanonicalizer)
    {
        this;
        JVM INSTR monitorenter ;
        if (charstonamecanonicalizer.size() <= 12000) goto _L2; else goto _L1
_L1:
        initTables(64);
_L5:
        _dirty = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (charstonamecanonicalizer.size() <= size()) goto _L4; else goto _L3
_L3:
        _symbols = charstonamecanonicalizer._symbols;
        _buckets = charstonamecanonicalizer._buckets;
        _size = charstonamecanonicalizer._size;
        _sizeThreshold = charstonamecanonicalizer._sizeThreshold;
        _indexMask = charstonamecanonicalizer._indexMask;
          goto _L5
        charstonamecanonicalizer;
        throw charstonamecanonicalizer;
    }

    private void rehash()
    {
        int j1 = _symbols.length;
        int i = j1 + j1;
        if (i > 0x10000)
        {
            _size = 0;
            Arrays.fill(_symbols, null);
            Arrays.fill(_buckets, null);
            _dirty = true;
        } else
        {
            String as[] = _symbols;
            Bucket abucket[] = _buckets;
            _symbols = new String[i];
            _buckets = new Bucket[i >> 1];
            _indexMask = i - 1;
            _sizeThreshold = _sizeThreshold + _sizeThreshold;
            i = 0;
            int j = 0;
            while (j < j1) 
            {
                String s = as[j];
                int l = i;
                if (s != null)
                {
                    l = i + 1;
                    i = calcHash(s) & _indexMask;
                    if (_symbols[i] == null)
                    {
                        _symbols[i] = s;
                    } else
                    {
                        i >>= 1;
                        _buckets[i] = new Bucket(s, _buckets[i]);
                    }
                }
                j++;
                i = l;
            }
            for (int k = 0; k < j1 >> 1; k++)
            {
                Bucket bucket = abucket[k];
                while (bucket != null) 
                {
                    i++;
                    String s1 = bucket.getSymbol();
                    int i1 = calcHash(s1) & _indexMask;
                    if (_symbols[i1] == null)
                    {
                        _symbols[i1] = s1;
                    } else
                    {
                        i1 >>= 1;
                        _buckets[i1] = new Bucket(s1, _buckets[i1]);
                    }
                    bucket = bucket.getNext();
                }
            }

            if (i != _size)
            {
                throw new Error((new StringBuilder()).append("Internal error on SymbolTable.rehash(): had ").append(_size).append(" entries; now have ").append(i).append(".").toString());
            }
        }
    }

    public String findSymbol(char ac[], int i, int j, int k)
    {
        if (j >= 1) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L6:
        return ((String) (obj));
_L2:
        int i1;
        if (!_canonicalize)
        {
            return new String(ac, i, j);
        }
        i1 = k & _indexMask;
        obj = _symbols[i1];
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).length() != j)
        {
            break; /* Loop/switch isn't completed */
        }
        k = 0;
_L9:
        if (((String) (obj)).charAt(k) == ac[i + k]) goto _L4; else goto _L3
_L3:
        if (k == j) goto _L6; else goto _L5
_L5:
        String s1;
        obj = _buckets[i1 >> 1];
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = ((Bucket) (obj)).find(ac, i, j);
        obj = s1;
        if (s1 != null) goto _L6; else goto _L7
_L7:
        String s;
        int l;
        if (!_dirty)
        {
            copyArrays();
            _dirty = true;
            k = i1;
        } else
        {
            k = i1;
            if (_size >= _sizeThreshold)
            {
                rehash();
                k = calcHash(ac, i, j) & _indexMask;
            }
        }
        _size = _size + 1;
        s = new String(ac, i, j);
        ac = s;
        if (_intern)
        {
            ac = InternCache.instance.intern(s);
        }
        if (_symbols[k] == null)
        {
            _symbols[k] = ac;
        } else
        {
            i = k >> 1;
            _buckets[i] = new Bucket(ac, _buckets[i]);
        }
        return ac;
_L4:
        l = k + 1;
        k = l;
        if (l < j) goto _L9; else goto _L8
_L8:
        k = l;
          goto _L3
    }

    public CharsToNameCanonicalizer makeChild(boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        CharsToNameCanonicalizer charstonamecanonicalizer = new CharsToNameCanonicalizer(this, flag, flag1, _symbols, _buckets, _size);
        this;
        JVM INSTR monitorexit ;
        return charstonamecanonicalizer;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean maybeDirty()
    {
        return _dirty;
    }

    public void release()
    {
        while (!maybeDirty() || _parent == null) 
        {
            return;
        }
        _parent.mergeChild(this);
        _dirty = false;
    }

    public int size()
    {
        return _size;
    }

}
