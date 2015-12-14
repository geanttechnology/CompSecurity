// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            NativeNativeAdapter

class this._cls1
    implements Runnable
{

    final terListener.initFailed this$1;

    public void run()
    {
        if (NativeNativeAdapter.access$000(_fld0))
        {
            NativeNativeAdapter.access$100(_fld0).initSucceeded();
            return;
        } else
        {
            NativeNativeAdapter.access$100(_fld0).initFailed(new RuntimeException("Component info not loaded"));
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/adadapters/NativeNativeAdapter$1

/* anonymous class */
    class NativeNativeAdapter._cls1
        implements com.millennialmedia.internal.adcontrollers.NativeController.NativeControllerListener
    {

        final NativeNativeAdapter this$0;

        public void initFailed(Throwable throwable)
        {
            NativeNativeAdapter.access$100(NativeNativeAdapter.this).initFailed(throwable);
        }

        public void initSucceeded()
        {
            ThreadUtils.runOnWorkerThread(new NativeNativeAdapter._cls1._cls1());
        }

            
            {
                this$0 = NativeNativeAdapter.this;
                super();
            }
    }

}
