// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.sym;

import java.util.Arrays;
import org.codehaus.jackson.util.InternCache;

// Referenced classes of package org.codehaus.jackson.sym:
//            Name1, Name2, Name3, NameN, 
//            Name

public final class BytesToNameCanonicalizer
{
    static final class Bucket
    {

        protected final Name _name;
        protected final Bucket _next;

        public Name find(int i, int j, int k)
        {
            if (_name.hashCode() != i || !_name.equals(j, k)) goto _L2; else goto _L1
_L1:
            Name name = _name;
_L6:
            return name;
_L2:
            Bucket bucket = _next;
_L7:
            if (bucket == null) goto _L4; else goto _L3
_L3:
            Name name1;
            name1 = bucket._name;
            if (name1.hashCode() != i)
            {
                continue; /* Loop/switch isn't completed */
            }
            name = name1;
            if (name1.equals(j, k)) goto _L6; else goto _L5
_L5:
            bucket = bucket._next;
              goto _L7
_L4:
            return null;
        }

        public Name find(int i, int ai[], int j)
        {
            if (_name.hashCode() != i || !_name.equals(ai, j)) goto _L2; else goto _L1
_L1:
            Name name = _name;
_L6:
            return name;
_L2:
            Bucket bucket = _next;
_L7:
            if (bucket == null) goto _L4; else goto _L3
_L3:
            Name name1;
            name1 = bucket._name;
            if (name1.hashCode() != i)
            {
                continue; /* Loop/switch isn't completed */
            }
            name = name1;
            if (name1.equals(ai, j)) goto _L6; else goto _L5
_L5:
            bucket = bucket._next;
              goto _L7
_L4:
            return null;
        }

        public int length()
        {
            int i = 1;
            for (Bucket bucket = _next; bucket != null; bucket = bucket._next)
            {
                i++;
            }

            return i;
        }

        Bucket(Name name, Bucket bucket)
        {
            _name = name;
            _next = bucket;
        }
    }


    private int _collCount;
    private int _collEnd;
    private Bucket _collList[];
    private boolean _collListShared;
    private int _count;
    final boolean _intern;
    private int _mainHash[];
    private int _mainHashMask;
    private boolean _mainHashShared;
    private Name _mainNames[];
    private boolean _mainNamesShared;
    private transient boolean _needRehash;
    final BytesToNameCanonicalizer _parent;

    private BytesToNameCanonicalizer(int i, boolean flag)
    {
        _parent = null;
        _intern = flag;
        if (i >= 16) goto _L2; else goto _L1
_L1:
        int j = 16;
_L4:
        initTables(j);
        return;
_L2:
        j = i;
        if ((i - 1 & i) != 0)
        {
            j = 16;
            while (j < i) 
            {
                j += j;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private BytesToNameCanonicalizer(BytesToNameCanonicalizer bytestonamecanonicalizer, boolean flag)
    {
        _parent = bytestonamecanonicalizer;
        _intern = flag;
        _count = bytestonamecanonicalizer._count;
        _mainHashMask = bytestonamecanonicalizer._mainHashMask;
        _mainHash = bytestonamecanonicalizer._mainHash;
        _mainNames = bytestonamecanonicalizer._mainNames;
        _collList = bytestonamecanonicalizer._collList;
        _collCount = bytestonamecanonicalizer._collCount;
        _collEnd = bytestonamecanonicalizer._collEnd;
        _needRehash = false;
        _mainHashShared = true;
        _mainNamesShared = true;
        _collListShared = true;
    }

    private void _addSymbol(int i, Name name)
    {
        if (_mainHashShared)
        {
            unshareMain();
        }
        if (_needRehash)
        {
            rehash();
        }
        _count = _count + 1;
        int k = i & _mainHashMask;
        if (_mainNames[k] == null)
        {
            _mainHash[k] = i << 8;
            if (_mainNamesShared)
            {
                unshareNames();
            }
            _mainNames[k] = name;
        } else
        {
            if (_collListShared)
            {
                unshareCollision();
            }
            _collCount = _collCount + 1;
            int l = _mainHash[k];
            i = l & 0xff;
            if (i == 0)
            {
                if (_collEnd <= 254)
                {
                    j = _collEnd;
                    _collEnd = _collEnd + 1;
                    i = j;
                    if (j >= _collList.length)
                    {
                        expandCollision();
                        i = j;
                    }
                } else
                {
                    i = findBestBucket();
                }
                _mainHash[k] = l & 0xffffff00 | i + 1;
            } else
            {
                i--;
            }
            _collList[i] = new Bucket(name, _collList[i]);
        }
        i = _mainHash.length;
        if (_count > i >> 1)
        {
            int j = i >> 2;
            if (_count > i - j)
            {
                _needRehash = true;
            } else
            if (_collCount >= j)
            {
                _needRehash = true;
                return;
            }
        }
    }

    public static final int calcHash(int i)
    {
        i ^= i >>> 16;
        return i ^ i >>> 8;
    }

    public static final int calcHash(int i, int j)
    {
        i = i * 31 + j;
        i ^= i >>> 16;
        return i ^ i >>> 8;
    }

    public static final int calcHash(int ai[], int i)
    {
        int k = ai[0];
        for (int j = 1; j < i; j++)
        {
            k = k * 31 + ai[j];
        }

        i = k ^ k >>> 16;
        return i ^ i >>> 8;
    }

    private static Name constructName(int i, String s, int ai[], int j)
    {
        if (j >= 4) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 64
    //                   2 77
    //                   3 93;
           goto _L2 _L3 _L4 _L5
_L2:
        int ai1[];
        ai1 = new int[j];
        for (int k = 0; k < j; k++)
        {
            ai1[k] = ai[k];
        }

        break; /* Loop/switch isn't completed */
_L3:
        return new Name1(s, i, ai[0]);
_L4:
        return new Name2(s, i, ai[0], ai[1]);
_L5:
        return new Name3(s, i, ai[0], ai[1], ai[2]);
        return new NameN(s, i, ai1, j);
    }

    public static BytesToNameCanonicalizer createRoot()
    {
        return new BytesToNameCanonicalizer(64, true);
    }

    private void expandCollision()
    {
        Bucket abucket[] = _collList;
        int i = abucket.length;
        _collList = new Bucket[i + i];
        System.arraycopy(abucket, 0, _collList, 0, i);
    }

    private int findBestBucket()
    {
        Bucket abucket[] = _collList;
        int j = 0x7fffffff;
        int k = -1;
        int i = 0;
        for (int j1 = _collEnd; i < j1;)
        {
            int i1 = abucket[i].length();
            int l = j;
            if (i1 < j)
            {
                if (i1 == 1)
                {
                    return i;
                }
                l = i1;
                k = i;
            }
            i++;
            j = l;
        }

        return k;
    }

    public static Name getEmptyName()
    {
        return Name1.getEmptyName();
    }

    private void initTables(int i)
    {
        _count = 0;
        _mainHash = new int[i];
        _mainNames = new Name[i];
        _mainHashShared = false;
        _mainNamesShared = false;
        _mainHashMask = i - 1;
        _collListShared = true;
        _collList = null;
        _collEnd = 0;
        _needRehash = false;
    }

    private void markAsShared()
    {
        _mainHashShared = true;
        _mainNamesShared = true;
        _collListShared = true;
    }

    private void mergeChild(BytesToNameCanonicalizer bytestonamecanonicalizer)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = bytestonamecanonicalizer._count;
        j = _count;
        if (i > j) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (bytestonamecanonicalizer.size() <= 6000)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        initTables(64);
          goto _L1
        bytestonamecanonicalizer;
        throw bytestonamecanonicalizer;
        _count = bytestonamecanonicalizer._count;
        _mainHash = bytestonamecanonicalizer._mainHash;
        _mainNames = bytestonamecanonicalizer._mainNames;
        _mainHashShared = true;
        _mainNamesShared = true;
        _mainHashMask = bytestonamecanonicalizer._mainHashMask;
        _collList = bytestonamecanonicalizer._collList;
        _collCount = bytestonamecanonicalizer._collCount;
        _collEnd = bytestonamecanonicalizer._collEnd;
          goto _L1
    }

    private void nukeSymbols()
    {
        _count = 0;
        Arrays.fill(_mainHash, 0);
        Arrays.fill(_mainNames, null);
        Arrays.fill(_collList, null);
        _collCount = 0;
        _collEnd = 0;
    }

    private void rehash()
    {
        _needRehash = false;
        _mainNamesShared = false;
        int j1 = _mainHash.length;
        int i = j1 + j1;
        if (i > 0x10000)
        {
            nukeSymbols();
        } else
        {
            _mainHash = new int[i];
            _mainHashMask = i - 1;
            Name aname[] = _mainNames;
            _mainNames = new Name[i];
            i = 0;
            for (int j = 0; j < j1;)
            {
                Name name = aname[j];
                int l = i;
                if (name != null)
                {
                    l = i + 1;
                    i = name.hashCode();
                    int l1 = i & _mainHashMask;
                    _mainNames[l1] = name;
                    _mainHash[l1] = i << 8;
                }
                j++;
                i = l;
            }

            int i2 = _collEnd;
            if (i2 != 0)
            {
                _collCount = 0;
                _collEnd = 0;
                _collListShared = false;
                Bucket abucket[] = _collList;
                _collList = new Bucket[abucket.length];
                for (int k = 0; k < i2; k++)
                {
                    Bucket bucket = abucket[k];
                    while (bucket != null) 
                    {
                        int i1 = i + 1;
                        Name name1 = bucket._name;
                        i = name1.hashCode();
                        int j2 = i & _mainHashMask;
                        int k2 = _mainHash[j2];
                        if (_mainNames[j2] == null)
                        {
                            _mainHash[j2] = i << 8;
                            _mainNames[j2] = name1;
                        } else
                        {
                            _collCount = _collCount + 1;
                            i = k2 & 0xff;
                            if (i == 0)
                            {
                                if (_collEnd <= 254)
                                {
                                    int k1 = _collEnd;
                                    _collEnd = _collEnd + 1;
                                    i = k1;
                                    if (k1 >= _collList.length)
                                    {
                                        expandCollision();
                                        i = k1;
                                    }
                                } else
                                {
                                    i = findBestBucket();
                                }
                                _mainHash[j2] = k2 & 0xffffff00 | i + 1;
                            } else
                            {
                                i--;
                            }
                            _collList[i] = new Bucket(name1, _collList[i]);
                        }
                        bucket = bucket._next;
                        i = i1;
                    }
                }

                if (i != _count)
                {
                    throw new RuntimeException((new StringBuilder()).append("Internal error: count after rehash ").append(i).append("; should be ").append(_count).toString());
                }
            }
        }
    }

    private void unshareCollision()
    {
        Bucket abucket[] = _collList;
        if (abucket == null)
        {
            _collList = new Bucket[32];
        } else
        {
            int i = abucket.length;
            _collList = new Bucket[i];
            System.arraycopy(abucket, 0, _collList, 0, i);
        }
        _collListShared = false;
    }

    private void unshareMain()
    {
        int ai[] = _mainHash;
        int i = _mainHash.length;
        _mainHash = new int[i];
        System.arraycopy(ai, 0, _mainHash, 0, i);
        _mainHashShared = false;
    }

    private void unshareNames()
    {
        Name aname[] = _mainNames;
        int i = aname.length;
        _mainNames = new Name[i];
        System.arraycopy(aname, 0, _mainNames, 0, i);
        _mainNamesShared = false;
    }

    public Name addName(String s, int ai[], int i)
    {
        String s1 = s;
        if (_intern)
        {
            s1 = InternCache.instance.intern(s);
        }
        int j = calcHash(ai, i);
        s = constructName(j, s1, ai, i);
        _addSymbol(j, s);
        return s;
    }

    public Name findName(int i)
    {
        int j;
        int k;
        int i1;
        j = calcHash(i);
        k = j & _mainHashMask;
        i1 = _mainHash[k];
        if ((i1 >> 8 ^ j) << 8 != 0) goto _L2; else goto _L1
_L1:
        Name name1 = _mainNames[k];
        if (name1 != null) goto _L4; else goto _L3
_L3:
        Name name = null;
_L6:
        return name;
_L4:
        name = name1;
        if (name1.equals(i)) goto _L6; else goto _L5
_L5:
        int l = i1 & 0xff;
        if (l > 0)
        {
            Bucket bucket = _collList[l - 1];
            if (bucket != null)
            {
                return bucket.find(j, i, 0);
            }
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (i1 == 0)
        {
            return null;
        }
        if (true) goto _L5; else goto _L7
_L7:
        return null;
    }

    public Name findName(int i, int j)
    {
        int k;
        int l;
        int j1;
        k = calcHash(i, j);
        l = k & _mainHashMask;
        j1 = _mainHash[l];
        if ((j1 >> 8 ^ k) << 8 != 0) goto _L2; else goto _L1
_L1:
        Name name1 = _mainNames[l];
        if (name1 != null) goto _L4; else goto _L3
_L3:
        Name name = null;
_L6:
        return name;
_L4:
        name = name1;
        if (name1.equals(i, j)) goto _L6; else goto _L5
_L5:
        int i1 = j1 & 0xff;
        if (i1 > 0)
        {
            Bucket bucket = _collList[i1 - 1];
            if (bucket != null)
            {
                return bucket.find(k, i, j);
            }
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (j1 == 0)
        {
            return null;
        }
        if (true) goto _L5; else goto _L7
_L7:
        return null;
    }

    public Name findName(int ai[], int i)
    {
        int j = calcHash(ai, i);
        int k = j & _mainHashMask;
        int l = _mainHash[k];
        if ((l >> 8 ^ j) << 8 == 0)
        {
            Name name = _mainNames[k];
            if (name == null || name.equals(ai, i))
            {
                return name;
            }
        } else
        if (l == 0)
        {
            return null;
        }
        k = l & 0xff;
        if (k > 0)
        {
            Bucket bucket = _collList[k - 1];
            if (bucket != null)
            {
                return bucket.find(j, ai, i);
            }
        }
        return null;
    }

    public BytesToNameCanonicalizer makeChild(boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        BytesToNameCanonicalizer bytestonamecanonicalizer = new BytesToNameCanonicalizer(this, flag1);
        this;
        JVM INSTR monitorexit ;
        return bytestonamecanonicalizer;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean maybeDirty()
    {
        return !_mainHashShared;
    }

    public void release()
    {
        if (maybeDirty() && _parent != null)
        {
            _parent.mergeChild(this);
            markAsShared();
        }
    }

    public int size()
    {
        return _count;
    }
}
