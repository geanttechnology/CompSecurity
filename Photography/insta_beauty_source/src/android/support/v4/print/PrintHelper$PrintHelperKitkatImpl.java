// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

// Referenced classes of package android.support.v4.print:
//            PrintHelperKitkat

final class mPrintHelper
    implements 
{

    private final PrintHelperKitkat mPrintHelper;

    public int getColorMode()
    {
        return mPrintHelper.getColorMode();
    }

    public int getOrientation()
    {
        return mPrintHelper.getOrientation();
    }

    public int getScaleMode()
    {
        return mPrintHelper.getScaleMode();
    }

    public void printBitmap(String s, Bitmap bitmap, final mPrintHelper callback)
    {
        _cls1 _lcls1 = null;
        class _cls1
            implements PrintHelperKitkat.OnPrintFinishCallback
        {

            final PrintHelper.PrintHelperKitkatImpl this$0;
            final PrintHelper.OnPrintFinishCallback val$callback;

            public void onFinish()
            {
                callback.onFinish();
            }

            _cls1()
            {
                this$0 = PrintHelper.PrintHelperKitkatImpl.this;
                callback = onprintfinishcallback;
                super();
            }
        }

        if (callback != null)
        {
            _lcls1 = new _cls1();
        }
        mPrintHelper.printBitmap(s, bitmap, _lcls1);
    }

    public void printBitmap(String s, Uri uri, final lback callback)
    {
        _cls2 _lcls2 = null;
        class _cls2
            implements PrintHelperKitkat.OnPrintFinishCallback
        {

            final PrintHelper.PrintHelperKitkatImpl this$0;
            final PrintHelper.OnPrintFinishCallback val$callback;

            public void onFinish()
            {
                callback.onFinish();
            }

            _cls2()
            {
                this$0 = PrintHelper.PrintHelperKitkatImpl.this;
                callback = onprintfinishcallback;
                super();
            }
        }

        if (callback != null)
        {
            _lcls2 = new _cls2();
        }
        mPrintHelper.printBitmap(s, uri, _lcls2);
    }

    public void setColorMode(int i)
    {
        mPrintHelper.setColorMode(i);
    }

    public void setOrientation(int i)
    {
        mPrintHelper.setOrientation(i);
    }

    public void setScaleMode(int i)
    {
        mPrintHelper.setScaleMode(i);
    }

    _cls2(Context context)
    {
        mPrintHelper = new PrintHelperKitkat(context);
    }
}
