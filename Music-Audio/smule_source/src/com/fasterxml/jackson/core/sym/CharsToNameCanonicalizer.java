// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;

public final class CharsToNameCanonicalizer
{

    static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
    protected Bucket _buckets[];
    protected boolean _canonicalize;
    protected boolean _dirty;
    protected final int _flags;
    private final int _hashSeed;
    protected int _indexMask;
    protected int _longestCollisionList;
    protected BitSet _overflows;
    protected CharsToNameCanonicalizer _parent;
    protected int _size;
    protected int _sizeThreshold;
    protected String _symbols[];

    private CharsToNameCanonicalizer()
    {
        _canonicalize = true;
        _flags = -1;
        _dirty = true;
        _hashSeed = 0;
        _longestCollisionList = 0;
        initTables(64);
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charstonamecanonicalizer, int i, String as[], Bucket abucket[], int j, int k, int l)
    {
        _parent = charstonamecanonicalizer;
        _flags = i;
        _canonicalize = com.fasterxml.jackson.core.JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i);
        _symbols = as;
        _buckets = abucket;
        _size = j;
        _hashSeed = k;
        i = as.length;
        _sizeThreshold = _thresholdSize(i);
        _indexMask = i - 1;
        _longestCollisionList = l;
        _dirty = false;
    }

    private String _addSymbol(char ac[], int i, int j, int k, int l)
    {
        if (_dirty) goto _L2; else goto _L1
_L1:
        copyArrays();
        _dirty = true;
_L4:
        String s = new String(ac, i, j);
        ac = s;
        if (com.fasterxml.jackson.core.JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(_flags))
        {
            ac = InternCache.instance.intern(s);
        }
        _size = _size + 1;
        if (_symbols[l] == null)
        {
            _symbols[l] = ac;
            return ac;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (_size >= _sizeThreshold)
        {
            rehash();
            l = _hashToIndex(calcHash(ac, i, j));
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = l >> 1;
        Bucket bucket = new Bucket(ac, _buckets[i]);
        j = bucket.length;
        if (j > 100)
        {
            _handleSpillOverflow(i, bucket);
            return ac;
        } else
        {
            _buckets[i] = bucket;
            _longestCollisionList = Math.max(j, _longestCollisionList);
            return ac;
        }
    }

    private String _findSymbol2(char ac[], int i, int j, Bucket bucket)
    {
        for (; bucket != null; bucket = bucket.next)
        {
            String s = bucket.has(ac, i, j);
            if (s != null)
            {
                return s;
            }
        }

        return null;
    }

    private void _handleSpillOverflow(int i, Bucket bucket)
    {
        if (_overflows == null)
        {
            _overflows = new BitSet();
            _overflows.set(i);
        } else
        if (_overflows.get(i))
        {
            if (com.fasterxml.jackson.core.JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(_flags))
            {
                reportTooManyCollisions(100);
            }
            _canonicalize = false;
        } else
        {
            _overflows.set(i);
        }
        _symbols[i + i] = bucket.symbol;
        _buckets[i] = null;
        _size = _size - bucket.length;
        _longestCollisionList = -1;
    }

    private static int _thresholdSize(int i)
    {
        return i - (i >> 2);
    }

    private void copyArrays()
    {
        Object aobj[] = _symbols;
        _symbols = (String[])Arrays.copyOf(aobj, aobj.length);
        aobj = _buckets;
        _buckets = (Bucket[])Arrays.copyOf(aobj, aobj.length);
    }

    public static CharsToNameCanonicalizer createRoot()
    {
        long l = System.currentTimeMillis();
        int i = (int)l;
        return createRoot((int)(l >>> 32) + i | 1);
    }

    protected static CharsToNameCanonicalizer createRoot(int i)
    {
        return sBootstrapSymbolTable.makeOrphan(i);
    }

    private void initTables(int i)
    {
        _symbols = new String[i];
        _buckets = new Bucket[i >> 1];
        _indexMask = i - 1;
        _size = 0;
        _longestCollisionList = 0;
        _sizeThreshold = _thresholdSize(i);
    }

    private CharsToNameCanonicalizer makeOrphan(int i)
    {
        return new CharsToNameCanonicalizer(null, -1, _symbols, _buckets, _size, i, _longestCollisionList);
    }

    private void mergeChild(CharsToNameCanonicalizer charstonamecanonicalizer)
    {
        if (charstonamecanonicalizer.size() <= 12000)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        this;
        JVM INSTR monitorenter ;
        initTables(256);
        _dirty = false;
        this;
        JVM INSTR monitorexit ;
        return;
        charstonamecanonicalizer;
        this;
        JVM INSTR monitorexit ;
        throw charstonamecanonicalizer;
        if (charstonamecanonicalizer.size() <= size())
        {
            break MISSING_BLOCK_LABEL_106;
        }
        this;
        JVM INSTR monitorenter ;
        _symbols = charstonamecanonicalizer._symbols;
        _buckets = charstonamecanonicalizer._buckets;
        _size = charstonamecanonicalizer._size;
        _sizeThreshold = charstonamecanonicalizer._sizeThreshold;
        _indexMask = charstonamecanonicalizer._indexMask;
        _longestCollisionList = charstonamecanonicalizer._longestCollisionList;
        _dirty = false;
        this;
        JVM INSTR monitorexit ;
        return;
        charstonamecanonicalizer;
        this;
        JVM INSTR monitorexit ;
        throw charstonamecanonicalizer;
    }

    private void rehash()
    {
        int l1 = _symbols.length;
        int i = l1 + l1;
        if (i > 0x10000)
        {
            _size = 0;
            _canonicalize = false;
            _symbols = new String[64];
            _buckets = new Bucket[32];
            _indexMask = 63;
            _dirty = true;
        } else
        {
            String as[] = _symbols;
            Bucket abucket[] = _buckets;
            _symbols = new String[i];
            _buckets = new Bucket[i >> 1];
            _indexMask = i - 1;
            _sizeThreshold = _thresholdSize(i);
            int l = 0;
            i = 0;
            int j = 0;
            while (l < l1) 
            {
                Object obj = as[l];
                int i1 = i;
                int k1 = j;
                if (obj != null)
                {
                    k1 = j + 1;
                    j = _hashToIndex(calcHash(((String) (obj))));
                    if (_symbols[j] == null)
                    {
                        _symbols[j] = ((String) (obj));
                        i1 = i;
                    } else
                    {
                        j >>= 1;
                        obj = new Bucket(((String) (obj)), _buckets[j]);
                        _buckets[j] = ((Bucket) (obj));
                        i1 = Math.max(i, ((Bucket) (obj)).length);
                    }
                }
                l++;
                i = i1;
                j = k1;
            }
            boolean flag = false;
            l = j;
            for (int k = ((flag) ? 1 : 0); k < l1 >> 1; k++)
            {
                Bucket bucket = abucket[k];
                while (bucket != null) 
                {
                    l++;
                    Object obj1 = bucket.symbol;
                    int j1 = _hashToIndex(calcHash(((String) (obj1))));
                    if (_symbols[j1] == null)
                    {
                        _symbols[j1] = ((String) (obj1));
                    } else
                    {
                        j1 >>= 1;
                        obj1 = new Bucket(((String) (obj1)), _buckets[j1]);
                        _buckets[j1] = ((Bucket) (obj1));
                        i = Math.max(i, ((Bucket) (obj1)).length);
                    }
                    bucket = bucket.next;
                }
            }

            _longestCollisionList = i;
            _overflows = null;
            if (l != _size)
            {
                throw new Error((new StringBuilder()).append("Internal error on SymbolTable.rehash(): had ").append(_size).append(" entries; now have ").append(l).append(".").toString());
            }
        }
    }

    public int _hashToIndex(int i)
    {
        return (i >>> 15) + i & _indexMask;
    }

    public int calcHash(String s)
    {
        int l = s.length();
        int i = _hashSeed;
        for (int j = 0; j < l;)
        {
            char c = s.charAt(j);
            j++;
            i = c + i * 33;
        }

        int k = i;
        if (i == 0)
        {
            k = 1;
        }
        return k;
    }

    public int calcHash(char ac[], int i, int j)
    {
        int k = _hashSeed;
        for (int l = i; l < i + j; l++)
        {
            k = k * 33 + ac[l];
        }

        i = k;
        if (k == 0)
        {
            i = 1;
        }
        return i;
    }

    public String findSymbol(char ac[], int i, int j, int k)
    {
        if (j >= 1) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        return s;
_L2:
        String s1;
        Bucket bucket;
        int j1;
label0:
        {
            if (!_canonicalize)
            {
                return new String(ac, i, j);
            }
            j1 = _hashToIndex(k);
            s = _symbols[j1];
            if (s == null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (s.length() != j)
            {
                break label0;
            }
            int l = 0;
            int i1;
            do
            {
                if (s.charAt(l) != ac[i + l])
                {
                    break label0;
                }
                i1 = l + 1;
                l = i1;
            } while (i1 != j);
            return s;
        }
        bucket = _buckets[j1 >> 1];
        if (bucket == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = bucket.has(ac, i, j);
        s = s1;
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s1 = _findSymbol2(ac, i, j, bucket.next);
        s = s1;
        if (s1 != null) goto _L4; else goto _L5
_L5:
        return _addSymbol(ac, i, j, k, j1);
    }

    public int hashSeed()
    {
        return _hashSeed;
    }

    public CharsToNameCanonicalizer makeChild(int i)
    {
        this;
        JVM INSTR monitorenter ;
        String as[];
        Bucket abucket[];
        int j;
        int k;
        int l;
        as = _symbols;
        abucket = _buckets;
        j = _size;
        k = _hashSeed;
        l = _longestCollisionList;
        this;
        JVM INSTR monitorexit ;
        return new CharsToNameCanonicalizer(this, i, as, abucket, j, k, l);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean maybeDirty()
    {
        return _dirty;
    }

    public void release()
    {
        while (!maybeDirty() || _parent == null || !_canonicalize) 
        {
            return;
        }
        _parent.mergeChild(this);
        _dirty = false;
    }

    protected void reportTooManyCollisions(int i)
    {
        throw new IllegalStateException((new StringBuilder()).append("Longest collision chain in symbol table (of size ").append(_size).append(") now exceeds maximum, ").append(i).append(" -- suspect a DoS attack based on hash collisions").toString());
    }

    public int size()
    {
        return _size;
    }


    private class Bucket
    {

        private final int length;
        private final Bucket next;
        private final String symbol;

        public String has(char ac[], int i, int j)
        {
            if (symbol.length() != j)
            {
                return null;
            }
            int k = 0;
            int l;
            do
            {
                if (symbol.charAt(k) != ac[i + k])
                {
                    return null;
                }
                l = k + 1;
                k = l;
            } while (l < j);
            return symbol;
        }




        public Bucket(String s, Bucket bucket)
        {
            symbol = s;
            next = bucket;
            int i;
            if (bucket == null)
            {
                i = 1;
            } else
            {
                i = bucket.length + 1;
            }
            length = i;
        }
    }

}
