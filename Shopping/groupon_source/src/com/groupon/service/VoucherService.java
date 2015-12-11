// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.groupon.http.Http;
import com.groupon.network.HttpResponseException;
import com.groupon.util.Function0;
import com.groupon.util.Function1;

public class VoucherService
{

    private Context context;

    public VoucherService()
    {
    }

    public void getVoucherBarcodeImage(String s, View view, Function1 function1, Function1 function1_1, Function0 function0)
    {
        ((Http)(new Http(function1, function1_1, function0) {

            final VoucherService this$0;
            final Function1 val$onException;
            final Function1 val$onSuccess;
            final Function0 val$onUserCancelRetry;

            public Bitmap call()
                throws Exception
            {
                Bitmap bitmap;
                try
                {
                    bitmap = (Bitmap)super.call();
                }
                catch (HttpResponseException httpresponseexception)
                {
                    if (httpresponseexception.getStatusCode() != 404)
                    {
                        throw httpresponseexception;
                    } else
                    {
                        return null;
                    }
                }
                return bitmap;
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            protected void onException(Exception exception)
            {
                super.onException(exception);
                if (onException != null)
                {
                    onException.execute(exception);
                }
            }

            protected void onSuccess(Bitmap bitmap)
                throws Exception
            {
                if (onSuccess != null)
                {
                    onSuccess.execute(bitmap);
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((Bitmap)obj);
            }

            public void onUserCancelRetry()
            {
                if (onUserCancelRetry != null)
                {
                    onUserCancelRetry.execute();
                }
            }

            
            {
                this$0 = VoucherService.this;
                onSuccess = function1;
                onException = function1_1;
                onUserCancelRetry = function0;
                super(final_context1, final_class1, final_s);
            }
        }).forceFullSizeBitmapDownload(true).progressView(view)).execute();
    }
}
