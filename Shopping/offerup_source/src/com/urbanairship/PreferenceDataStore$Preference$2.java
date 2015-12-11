// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package com.urbanairship:
//            Logger, PreferenceDataStore

class this._cls1 extends ContentObserver
{

    final _cls1 this$1;

    public void onChange(boolean flag)
    {
        super.onChange(flag);
        Logger.verbose((new StringBuilder("PreferenceDataStore - Preference updated:")).append(cess._mth300(this._cls1.this)).toString());
        class _cls1
            implements Runnable
        {

            final PreferenceDataStore.Preference._cls2 this$2;

            public void run()
            {
                syncValue();
            }

            _cls1()
            {
                this$2 = PreferenceDataStore.Preference._cls2.this;
                super();
            }
        }

        executor.execute(new _cls1());
    }

    _cls1(Handler handler)
    {
        this$1 = this._cls1.this;
        super(handler);
    }
}
