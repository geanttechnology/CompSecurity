// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping;

import com.ebay.nautilus.domain.datamapping.gson.FieldAnnotationInclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.ebay.nautilus.domain.datamapping:
//            BaseDataMapped, ExposeForToString, ExposeForEquality

public class ImmutableDataMapped extends BaseDataMapped
{

    private static final Gson equalityMapper = (new GsonBuilder()).addSerializationExclusionStrategy(new FieldAnnotationInclusionStrategy(com/ebay/nautilus/domain/datamapping/ExposeForEquality)).create();
    private static final Gson toStringMapper = (new GsonBuilder()).addSerializationExclusionStrategy(new FieldAnnotationInclusionStrategy(com/ebay/nautilus/domain/datamapping/ExposeForToString)).create();
    private volatile byte _digest[];
    private volatile String _equalsStr;
    private final transient boolean _fullCompare;
    private volatile int _hashCode;
    private final String className;

    public ImmutableDataMapped()
    {
        this(false);
    }

    protected ImmutableDataMapped(boolean flag)
    {
        className = getClass().getName();
        _fullCompare = flag;
    }

    private boolean ensurePreparedForEquals()
    {
        if (_digest != null || _equalsStr != null) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        String s;
        abyte0 = null;
        s = equalityMapper.toJson(this);
        if (_fullCompare)
        {
            throw new NoSuchAlgorithmException();
        }
          goto _L3
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        int i;
        _equalsStr = s;
        i = s.hashCode();
_L5:
        _digest = abyte0;
        _hashCode = i;
_L2:
        return true;
_L3:
        byte abyte1[];
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
        messagedigest.update(s.getBytes());
        abyte1 = messagedigest.digest();
        i = abyte1[0];
        byte byte0 = abyte1[1];
        byte byte1 = abyte1[2];
        byte byte2 = abyte1[3];
        i = i & 0xff | (byte0 & 0xff) << 8 | (byte1 & 0xff) << 16 | (byte2 & 0xff) << 24;
        abyte0 = abyte1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (getClass().equals(obj.getClass()))
                {
                    obj = (ImmutableDataMapped)obj;
                    flag = flag1;
                    if (ensurePreparedForEquals())
                    {
                        flag = flag1;
                        if (((ImmutableDataMapped) (obj)).ensurePreparedForEquals())
                        {
                            flag = flag1;
                            if (_hashCode == ((ImmutableDataMapped) (obj))._hashCode)
                            {
                                if (_digest == null)
                                {
                                    flag = flag1;
                                    if (((ImmutableDataMapped) (obj))._digest == null)
                                    {
                                        return _equalsStr.equals(((ImmutableDataMapped) (obj))._equalsStr);
                                    }
                                } else
                                {
                                    return MessageDigest.isEqual(_digest, ((ImmutableDataMapped) (obj))._digest);
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        ensurePreparedForEquals();
        return _hashCode;
    }

    public String toString()
    {
        return toStringMapper.toJson(this);
    }

}
