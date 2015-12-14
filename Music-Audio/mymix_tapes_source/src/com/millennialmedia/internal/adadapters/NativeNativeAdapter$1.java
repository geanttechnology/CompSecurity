// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            NativeNativeAdapter

class this._cls0
    implements com.millennialmedia.internal.adcontrollers.eControllerListener
{

    final NativeNativeAdapter this$0;

    public void initFailed(Throwable throwable)
    {
        NativeNativeAdapter.access$100(NativeNativeAdapter.this).initFailed(throwable);
    }

    public void initSucceeded()
    {
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final NativeNativeAdapter._cls1 this$1;

            public void run()
            {
                if (NativeNativeAdapter.access$000(this$0))
                {
                    NativeNativeAdapter.access$100(this$0).initSucceeded();
                    return;
                } else
                {
                    NativeNativeAdapter.access$100(this$0).initFailed(new RuntimeException("Component info not loaded"));
                    return;
                }
            }

            
            {
                this$1 = NativeNativeAdapter._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = NativeNativeAdapter.this;
        super();
    }
}
