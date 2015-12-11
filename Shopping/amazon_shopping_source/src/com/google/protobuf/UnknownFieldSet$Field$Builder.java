// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            UnknownFieldSet, ByteString

public static final class 
{

    private _cls00 result;

    private static  create()
    {
          = new <init>();
        .result = new result(null);
        return ;
    }

    public result addFixed32(int i)
    {
        if (_mth00(result) == null)
        {
            _mth02(result, new ArrayList());
        }
        _mth00(result).add(Integer.valueOf(i));
        return this;
    }

    public result addFixed64(long l)
    {
        if (_mth00(result) == null)
        {
            _mth02(result, new ArrayList());
        }
        _mth00(result).add(Long.valueOf(l));
        return this;
    }

    public result addGroup(UnknownFieldSet unknownfieldset)
    {
        if (_mth00(result) == null)
        {
            _mth02(result, new ArrayList());
        }
        _mth00(result).add(unknownfieldset);
        return this;
    }

    public result addLengthDelimited(ByteString bytestring)
    {
        if (_mth00(result) == null)
        {
            _mth02(result, new ArrayList());
        }
        _mth00(result).add(bytestring);
        return this;
    }

    public result addVarint(long l)
    {
        if (_mth00(result) == null)
        {
            _mth02(result, new ArrayList());
        }
        _mth00(result).add(Long.valueOf(l));
        return this;
    }

    public result build()
    {
        result result1;
        if (_mth00(result) == null)
        {
            _mth02(result, Collections.emptyList());
        } else
        {
            _mth02(result, Collections.unmodifiableList(_mth00(result)));
        }
        if (_mth00(result) == null)
        {
            _mth02(result, Collections.emptyList());
        } else
        {
            _mth02(result, Collections.unmodifiableList(_mth00(result)));
        }
        if (_mth00(result) == null)
        {
            _mth02(result, Collections.emptyList());
        } else
        {
            _mth02(result, Collections.unmodifiableList(_mth00(result)));
        }
        if (_mth00(result) == null)
        {
            _mth02(result, Collections.emptyList());
        } else
        {
            _mth02(result, Collections.unmodifiableList(_mth00(result)));
        }
        if (_mth00(result) == null)
        {
            _mth02(result, Collections.emptyList());
        } else
        {
            _mth02(result, Collections.unmodifiableList(_mth00(result)));
        }
        result1 = result;
        result = null;
        return result1;
    }

    public result mergeFrom(result result1)
    {
        if (!_mth00(result1).isEmpty())
        {
            if (_mth00(result) == null)
            {
                _mth02(result, new ArrayList());
            }
            _mth00(result).addAll(_mth00(result1));
        }
        if (!_mth00(result1).isEmpty())
        {
            if (_mth00(result) == null)
            {
                _mth02(result, new ArrayList());
            }
            _mth00(result).addAll(_mth00(result1));
        }
        if (!_mth00(result1).isEmpty())
        {
            if (_mth00(result) == null)
            {
                _mth02(result, new ArrayList());
            }
            _mth00(result).addAll(_mth00(result1));
        }
        if (!_mth00(result1).isEmpty())
        {
            if (_mth00(result) == null)
            {
                _mth02(result, new ArrayList());
            }
            _mth00(result).addAll(_mth00(result1));
        }
        if (!_mth00(result1).isEmpty())
        {
            if (_mth00(result) == null)
            {
                _mth02(result, new ArrayList());
            }
            _mth00(result).addAll(_mth00(result1));
        }
        return this;
    }


    private ()
    {
    }
}
