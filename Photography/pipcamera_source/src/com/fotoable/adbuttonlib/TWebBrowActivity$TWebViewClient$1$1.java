// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;


// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class this._cls2
    implements Runnable
{

    final ._cls0 this$2;

    public void run()
    {
        TWebBrowActivity.access$600(_fld0);
    }

    l.errCallBack()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/fotoable/adbuttonlib/TWebBrowActivity$TWebViewClient$1

/* anonymous class */
    class TWebBrowActivity.TWebViewClient._cls1
        implements Runnable
    {

        final TWebBrowActivity.TWebViewClient this$1;
        final String val$callBackFuc;
        final String val$callParam;
        final String val$errCallBack;
        final String val$funName;
        final String val$param;

        public void run()
        {
            try
            {
                callOcFuc(funName, param, callBackFuc, callParam, errCallBack);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            runOnUiThread(new TWebBrowActivity.TWebViewClient._cls1._cls1());
        }

            
            {
                this$1 = final_twebviewclient;
                funName = s;
                param = s1;
                callBackFuc = s2;
                callParam = s3;
                errCallBack = String.this;
                super();
            }
    }

}
