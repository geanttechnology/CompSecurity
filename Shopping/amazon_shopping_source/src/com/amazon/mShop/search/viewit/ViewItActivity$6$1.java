// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.res.Resources;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.WebUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.RecognizeAuthenticityCodeResponse;
import com.amazon.rio.j2me.client.services.mShop.RecognizeAuthenticityCodeResponseListener;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItPhotoCaptureView, ViewItDialogHelper, ViewItMetricHelper

class DialogType
    implements Runnable
{

    final val.errorDialogType this$1;
    final DialogType val$errorDialogType;
    final String val$errorMsg;

    public void run()
    {
        ViewItActivity.access$000(_fld0).getViewItDialogHelper().showDialog(null, val$errorMsg, val$errorDialogType);
    }

    DialogType()
    {
        this$1 = final_dialogtype;
        val$errorMsg = s;
        val$errorDialogType = DialogType.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/search/viewit/ViewItActivity$6

/* anonymous class */
    class ViewItActivity._cls6
        implements RecognizeAuthenticityCodeResponseListener
    {

        final ViewItActivity this$0;

        public void cancelled(ServiceCall servicecall)
        {
            enableLoading();
        }

        public void completed(RecognizeAuthenticityCodeResponse recognizeauthenticitycoderesponse, ServiceCall servicecall)
        {
            servicecall = recognizeauthenticitycoderesponse.getCodeType();
            if ("public".equalsIgnoreCase(servicecall))
            {
                UIUtils.vibrate(ViewItActivity.this, 100L);
                ViewItActivity.access$502(ViewItActivity.this, true);
                ViewItActivity.access$100(ViewItActivity.this).logCountMetricsPerSession("PublicCodeSession", 1);
                ViewItActivity.access$000(ViewItActivity.this).getViewItDialogHelper().clearErrorWindow();
                ViewItActivity.access$600(ViewItActivity.this);
            } else
            if ("private".equalsIgnoreCase(servicecall))
            {
                UIUtils.vibrate(ViewItActivity.this, 100L);
                ViewItActivity.access$702(ViewItActivity.this, true);
                ViewItActivity.access$100(ViewItActivity.this).logCountMetricsPerSession("PrivateCodeSession", 1);
                RefMarkerObserver.logRefMarker("fl_dm_pri_succ");
                recognizeauthenticitycoderesponse = recognizeauthenticitycoderesponse.getLandingUrl();
                WebUtils.openWebview(ViewItActivity.this, recognizeauthenticitycoderesponse);
            } else
            {
                ViewItActivity.access$100(ViewItActivity.this).logCountMetricsPerSession("UnknownCodeSession", 1);
            }
            ViewItActivity.access$802(ViewItActivity.this, null);
        }

        public void error(final Exception errorMsg, ServiceCall servicecall)
        {
            enableLoading();
            errorMsg = getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_server_return_error);
            servicecall = ViewItDialogHelper.DialogType.ERROR_FLOW_SERVER;
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(servicecall. new ViewItActivity._cls6._cls1());
        }

            
            {
                this$0 = ViewItActivity.this;
                super();
            }
    }

}
