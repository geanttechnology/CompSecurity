// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.StartupMetricsObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.ResourcesUtils;
import com.amazon.mShop.util.UIUtils;

// Referenced classes of package com.amazon.mShop.publicurl:
//            PublicURLProcessException, PublicURLProcessorFactory, PublicURLProcessor

public class PublicURLActivity extends AmazonActivity
{

    private PublicURLProcessor mProcessor;

    public PublicURLActivity()
    {
    }

    private void processURL()
    {
        Uri uri = getIntent().getData();
        if (uri == null) goto _L2; else goto _L1
_L1:
        mProcessor = PublicURLProcessorFactory.getInstance(uri);
        com.amazon.mShop.net.StartupMetricsObserver.StartupType startuptype;
        String s1;
        boolean flag;
        if (com.amazon.mShop.platform.Platform.Factory.getInstance().getAppStartCountForAllLocales() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            mProcessor.process(this);
            s1 = (new StringBuilder()).append("client-Android-Amazon_URL_").append(mProcessor.getMetricIdentity()).toString();
        }
        catch (PublicURLProcessException publicurlprocessexception)
        {
            static class _cls3
            {

                static final int $SwitchMap$com$amazon$mShop$publicurl$PublicURLProcessException$PublicURLErrorCode[];

                static 
                {
                    $SwitchMap$com$amazon$mShop$publicurl$PublicURLProcessException$PublicURLErrorCode = new int[PublicURLProcessException.PublicURLErrorCode.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$mShop$publicurl$PublicURLProcessException$PublicURLErrorCode[PublicURLProcessException.PublicURLErrorCode.ERROR_CODE_ERROR_PATH.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$mShop$publicurl$PublicURLProcessException$PublicURLErrorCode[PublicURLProcessException.PublicURLErrorCode.ERROR_CODE_ERROR_HOSTNAME.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$mShop$publicurl$PublicURLProcessException$PublicURLErrorCode[PublicURLProcessException.PublicURLErrorCode.ERROR_CODE_NEED_SWITCH_LOCALE.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            String s;
            switch (_cls3..SwitchMap.com.amazon.mShop.publicurl.PublicURLProcessException.PublicURLErrorCode[publicurlprocessexception.errorCode().ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                UIUtils.alert(this, getString(com.amazon.mShop.android.lib.R.string.public_url_host_unavailable, new Object[] {
                    (new StringBuilder()).append(uri.getAuthority()).append(uri.getPath()).toString()
                }), new android.content.DialogInterface.OnDismissListener() {

                    final PublicURLActivity this$0;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        finish();
                    }

            
            {
                this$0 = PublicURLActivity.this;
                super();
            }
                });
                return;

            case 2: // '\002'
                UIUtils.alert(this, getString(com.amazon.mShop.android.lib.R.string.public_url_host_unavailable, new Object[] {
                    mProcessor.getHost()
                }), new android.content.DialogInterface.OnDismissListener() {

                    final PublicURLActivity this$0;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        finish();
                    }

            
            {
                this$0 = PublicURLActivity.this;
                super();
            }
                });
                return;

            case 3: // '\003'
                s = ResourcesUtils.getStringOfSpecificLocale(this, "country_name", mProcessor.getLocaleName());
                break;
            }
            s = getString(com.amazon.mShop.android.lib.R.string.public_url_switch_locale_message, new Object[] {
                s
            });
            Intent intent = new Intent(this, com/amazon/mShop/publicurl/PublicURLActivity);
            intent.setData(uri);
            AppUtils.showSwitchLocaleDialog(this, mProcessor.getLocaleName(), s, intent);
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        startuptype = com.amazon.mShop.net.StartupMetricsObserver.StartupType.PUBLIC_URL_FIRST_START;
_L4:
        StartupMetricsObserver.logStartupMetrics(s1, startuptype);
_L2:
        finish();
        return;
        startuptype = com.amazon.mShop.net.StartupMetricsObserver.StartupType.PUBLIC_URL_START;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        processURL();
    }
}
