// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.print;

import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;

// Referenced classes of package android.support.v4.print:
//            PrintHelper, PrintHelperKitkat

private static final class mPrintHelper
    implements 
{

    private final PrintHelperKitkat mPrintHelper;

    public void printBitmap(String s, Uri uri, final  callback)
        throws FileNotFoundException
    {
        lback lback = null;
        if (callback != null)
        {
            lback = new PrintHelperKitkat.OnPrintFinishCallback() {

                final PrintHelper.PrintHelperKitkatImpl this$0;
                final PrintHelper.OnPrintFinishCallback val$callback;

                public void onFinish()
                {
                    callback.onFinish();
                }

            
            {
                this$0 = PrintHelper.PrintHelperKitkatImpl.this;
                callback = onprintfinishcallback;
                super();
            }
            };
        }
        mPrintHelper.printBitmap(s, uri, lback);
    }

    _cls2.val.callback(Context context)
    {
        mPrintHelper = new PrintHelperKitkat(context);
    }
}
