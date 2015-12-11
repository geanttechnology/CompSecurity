// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

private final class _dispatcher
    implements Runnable
{

    private final Object _args[];
    private final _args _dispatcher;
    private final Method _method;
    final _args this$0;

    public void run()
    {
        ArrayList arraylist = _dispatcher(this._cls0.this);
        arraylist;
        JVM INSTR monitorenter ;
        if (_dispatcher == null) goto _L2; else goto _L1
_L1:
        if (_dispatcher(this._cls0.this).contains(_dispatcher))
        {
            _dispatcher._dispatcher(_method, _args);
        }
_L4:
        return;
_L2:
        if (_args(this._cls0.this).isEmpty()) goto _L4; else goto _L3
_L3:
        Object obj;
        Iterator iterator;
        obj = new ArrayList(this._mth0(this._cls0.this).size());
        iterator = this._mth0(this._cls0.this).iterator();
_L5:
        _dispatcher _ldispatcher;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_165;
            }
            _ldispatcher = (this._cls0)iterator.next();
            if (!(_ldispatcher._fld0 instanceof this._cls0) || ((this._cls0)_ldispatcher._fld0)._mth0())
            {
                break MISSING_BLOCK_LABEL_155;
            }
            iterator.remove();
        } while (true);
        obj;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj;
        ((ArrayList) (obj)).add(_ldispatcher);
          goto _L5
        obj = ((ArrayList) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            ((this._cls0)((Iterator) (obj)).next())._mth0(_method, _args);
        }
          goto _L4
    }

    public ( 1, Method method, Object aobj[])
    {
        this$0 = this._cls0.this;
        super();
        _method = method;
        _args = aobj;
        _dispatcher = 1;
    }

    public _dispatcher(Method method, Object aobj[])
    {
        this$0 = this._cls0.this;
        super();
        _method = method;
        _args = aobj;
        _dispatcher = null;
    }
}
