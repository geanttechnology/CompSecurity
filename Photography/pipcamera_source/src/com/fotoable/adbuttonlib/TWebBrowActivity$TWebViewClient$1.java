// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;


// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class val.errCallBack
    implements Runnable
{

    final is._cls0 this$1;
    final String val$callBackFuc;
    final String val$callParam;
    final String val$errCallBack;
    final String val$funName;
    final String val$param;

    public void run()
    {
        try
        {
            llOcFuc(val$funName, val$param, val$callBackFuc, val$callParam, val$errCallBack);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        runOnUiThread(new Runnable() {

            final TWebBrowActivity.TWebViewClient._cls1 this$2;

            public void run()
            {
                TWebBrowActivity.access$600(this$0);
            }

            
            {
                this$2 = TWebBrowActivity.TWebViewClient._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls2()
    {
        this$1 = final__pcls2;
        val$funName = s;
        val$param = s1;
        val$callBackFuc = s2;
        val$callParam = s3;
        val$errCallBack = String.this;
        super();
    }
}
