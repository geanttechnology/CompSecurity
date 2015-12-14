// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.storage;

import android.os.Looper;

// Referenced classes of package com.tencent.mm.sdk.storage:
//            MStorageEvent

public abstract class MStorage
{

    private final MStorageEvent bM = new _cls1();
    private final MStorageEvent bN = new _cls2();

    public MStorage()
    {
    }

    static void a(IOnStorageChange ionstoragechange, String s)
    {
        ionstoragechange.onNotifyChange(s);
    }

    static void a(IOnStorageLoaded ionstorageloaded)
    {
        ionstorageloaded.onNotifyLoaded();
    }

    public void add(IOnStorageChange ionstoragechange)
    {
        bM.add(ionstoragechange, Looper.getMainLooper());
    }

    public void addLoadedListener(IOnStorageLoaded ionstorageloaded)
    {
        bN.add(ionstorageloaded, Looper.getMainLooper());
    }

    public void doNotify()
    {
        bM.event("*");
        bM.doNotify();
    }

    public void doNotify(String s)
    {
        bM.event(s);
        bM.doNotify();
    }

    public void lock()
    {
        bM.lock();
    }

    public void remove(IOnStorageChange ionstoragechange)
    {
        bM.remove(ionstoragechange);
    }

    public void removeLoadedListener(IOnStorageLoaded ionstorageloaded)
    {
        bN.remove(ionstorageloaded);
    }

    public void unlock()
    {
        bM.unlock();
    }

    private class _cls1 extends MStorageEvent
    {

        final MStorage bO;

        protected void processEvent(Object obj, Object obj1)
        {
            obj = (IOnStorageChange)obj;
            obj1 = (String)obj1;
            MStorage mstorage = bO;
            MStorage.a(((IOnStorageChange) (obj)), ((String) (obj1)));
        }

        _cls1()
        {
            bO = MStorage.this;
            super();
        }
    }


    private class _cls2 extends MStorageEvent
    {

        final MStorage bO;

        protected void processEvent(Object obj, Object obj1)
        {
            obj = (IOnStorageLoaded)obj;
            obj1 = bO;
            MStorage.a(((IOnStorageLoaded) (obj)));
        }

        _cls2()
        {
            bO = MStorage.this;
            super();
        }
    }


    private class IOnStorageChange
    {

        public abstract void onNotifyChange(String s);
    }


    private class IOnStorageLoaded
    {

        public abstract void onNotifyLoaded();
    }

}
