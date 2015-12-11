// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

// Referenced classes of package com.google.common.collect:
//            AbstractMapEntry, Hashing, HashBiMap

class delegate extends AbstractMapEntry
{

    delegate _flddelegate;
    final delegate this$1;

    public Object getKey()
    {
        return _flddelegate.;
    }

    public Object getValue()
    {
        return _flddelegate.ue;
    }

    public Object setValue(Object obj)
    {
        Object obj1 = _flddelegate.ue;
        int i = Hashing.smearedHash(obj);
        if (i == _flddelegate.ueHash && Objects.equal(obj, obj1))
        {
            return obj;
        }
        boolean flag;
        if (HashBiMap.access$400(ueHash, obj, i) == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "value already present: %s", new Object[] {
            obj
        });
        HashBiMap.access$200(ent, _flddelegate);
        obj = new it>(_flddelegate., _flddelegate.Hash, obj, i);
        HashBiMap.access$500(Hash, ((Hash) (obj)), _flddelegate);
        _flddelegate.vInKeyInsertionOrder = null;
        _flddelegate.tInKeyInsertionOrder = null;
        odCount = HashBiMap.access$100(odCount);
        if (odCount == _flddelegate)
        {
            this._cls1.this._flddelegate = ((this._cls1) (obj));
        }
        _flddelegate = ((delegate) (obj));
        return obj1;
    }

    ( 1)
    {
        this$1 = this._cls1.this;
        super();
        _flddelegate = 1;
    }

    // Unreferenced inner class com/google/common/collect/HashBiMap$1

/* anonymous class */
    class HashBiMap._cls1 extends HashBiMap.Itr
    {

        final HashBiMap this$0;

        volatile Object output(HashBiMap.BiEntry bientry)
        {
            return output(bientry);
        }

        java.util.Map.Entry output(HashBiMap.BiEntry bientry)
        {
            return new HashBiMap._cls1.MapEntry(bientry);
        }

            
            {
                this$0 = HashBiMap.this;
                super(HashBiMap.this);
            }
    }

}
