// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelPreviewFragment, ShippingLabelActivity

class output extends PrintDocumentAdapter
{

    InputStream input;
    FileOutputStream output;
    final ShippingLabelPreviewFragment this$0;
    final ShippingLabelActivity val$activity;

    public void onLayout(PrintAttributes printattributes, PrintAttributes printattributes1, CancellationSignal cancellationsignal, android.print.ltCallback ltcallback, Bundle bundle)
    {
        if (cancellationsignal.isCanceled())
        {
            ltcallback.onLayoutCancelled();
            return;
        }
        cancellationsignal = (new android.print.>(val$activity.getLabelFileName())).ntentType(0).geCount(1).();
        if (!printattributes.equals(printattributes1))
        {
            ltcallback.onLayoutFinished(cancellationsignal, true);
            return;
        } else
        {
            ltcallback.onLayoutFinished(cancellationsignal, false);
            return;
        }
    }

    public void onWrite(PageRange apagerange[], ParcelFileDescriptor parcelfiledescriptor, CancellationSignal cancellationsignal, android.print.tCallback tcallback)
    {
        input = new FileInputStream(val$activity.pdfFile);
        output = new FileOutputStream(parcelfiledescriptor.getFileDescriptor());
        apagerange = new byte[1024];
_L1:
        int i = input.read(apagerange);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        output.write(apagerange, 0, i);
          goto _L1
        apagerange;
        tcallback.onWriteFailed(getString(0x7f070255));
        StreamUtil.closeQuietly(input);
        StreamUtil.closeQuietly(output);
        tcallback.onWriteFinished(new PageRange[] {
            PageRange.ALL_PAGES
        });
        return;
        StreamUtil.closeQuietly(input);
        StreamUtil.closeQuietly(output);
        tcallback.onWriteFinished(new PageRange[] {
            PageRange.ALL_PAGES
        });
        return;
        apagerange;
        StreamUtil.closeQuietly(input);
        StreamUtil.closeQuietly(output);
        tcallback.onWriteFinished(new PageRange[] {
            PageRange.ALL_PAGES
        });
        throw apagerange;
    }

    ()
    {
        this$0 = final_shippinglabelpreviewfragment;
        val$activity = ShippingLabelActivity.this;
        super();
        input = null;
        output = null;
    }
}
