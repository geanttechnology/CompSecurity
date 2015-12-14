// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.print;

import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;

// Referenced classes of package android.support.v4.print:
//            PrintHelperKitkat

public final class PrintHelper
{
    public static interface OnPrintFinishCallback
    {

        public abstract void onFinish();
    }

    private static final class PrintHelperKitkatImpl
        implements PrintHelperVersionImpl
    {

        private final PrintHelperKitkat mPrintHelper;

        public void printBitmap(String s, Uri uri, OnPrintFinishCallback onprintfinishcallback)
            throws FileNotFoundException
        {
            PrintHelperKitkat.OnPrintFinishCallback onprintfinishcallback1 = null;
            if (onprintfinishcallback != null)
            {
                onprintfinishcallback1 = onprintfinishcallback. new PrintHelperKitkat.OnPrintFinishCallback() {

                    final PrintHelperKitkatImpl this$0;
                    final OnPrintFinishCallback val$callback;

                    public void onFinish()
                    {
                        callback.onFinish();
                    }

            
            {
                this$0 = final_printhelperkitkatimpl;
                callback = OnPrintFinishCallback.this;
                super();
            }
                };
            }
            mPrintHelper.printBitmap(s, uri, onprintfinishcallback1);
        }

        PrintHelperKitkatImpl(Context context)
        {
            mPrintHelper = new PrintHelperKitkat(context);
        }
    }

    private static final class PrintHelperStubImpl
        implements PrintHelperVersionImpl
    {

        int mColorMode;
        int mOrientation;
        int mScaleMode;

        public void printBitmap(String s, Uri uri, OnPrintFinishCallback onprintfinishcallback)
        {
        }

        private PrintHelperStubImpl()
        {
            mScaleMode = 2;
            mColorMode = 2;
            mOrientation = 1;
        }

    }

    static interface PrintHelperVersionImpl
    {

        public abstract void printBitmap(String s, Uri uri, OnPrintFinishCallback onprintfinishcallback)
            throws FileNotFoundException;
    }


    PrintHelperVersionImpl mImpl;

    public PrintHelper(Context context)
    {
        if (systemSupportsPrint())
        {
            mImpl = new PrintHelperKitkatImpl(context);
            return;
        } else
        {
            mImpl = new PrintHelperStubImpl();
            return;
        }
    }

    public static boolean systemSupportsPrint()
    {
        return android.os.Build.VERSION.SDK_INT >= 19;
    }

    public void printBitmap(String s, Uri uri)
        throws FileNotFoundException
    {
        mImpl.printBitmap(s, uri, null);
    }
}
