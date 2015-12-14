// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.adapter;

import android.os.Handler;
import com.amazon.boombox.file.LenticularArchive;
import com.amazon.boombox.internal.util.IoUtil;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.amazon.boombox.internal.adapter:
//            LenticularArchiveDrawableAdapter

private class mListener
    implements Runnable
{

    private int mCount;
    private File mFile;
    private mCount mListener;
    final LenticularArchiveDrawableAdapter this$0;

    public void run()
    {
        Object obj1;
        Object obj3;
        obj3 = null;
        obj1 = null;
        Object obj = new LenticularArchive(mFile);
        mCount = ((LenticularArchive) (obj)).getFrameCount();
        LenticularArchiveDrawableAdapter.access$400(LenticularArchiveDrawableAdapter.this).post(new Runnable() {

            final LenticularArchiveDrawableAdapter.GetCountRunnable this$1;

            public void run()
            {
                mListener.onCountReady(mCount);
            }

            
            {
                this$1 = LenticularArchiveDrawableAdapter.GetCountRunnable.this;
                super();
            }
        });
        IoUtil.closeSilently(((java.io.Closeable) (obj)));
        return;
        obj;
        obj = obj1;
_L4:
        IoUtil.closeSilently(((java.io.Closeable) (obj)));
        return;
        Object obj2;
        obj2;
        obj = obj3;
_L2:
        IoUtil.closeSilently(((java.io.Closeable) (obj)));
        throw obj2;
        obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }



    public _cls1.this._cls1(File file, _cls1.this._cls1 _pcls1)
    {
        this$0 = LenticularArchiveDrawableAdapter.this;
        super();
        mFile = file;
        mListener = _pcls1;
    }
}
