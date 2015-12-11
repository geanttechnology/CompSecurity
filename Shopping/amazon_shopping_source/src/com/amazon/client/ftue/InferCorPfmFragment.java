// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.ftue;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazon.android.dagger.DaggerAndroid;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPInit;
import com.amazon.logging.Logger;
import com.amazon.mas.client.authentication.AuthCookie;
import com.amazon.mas.client.authentication.InferredCorPfm;
import com.amazon.mas.client.authentication.MASClientCustomerAttributeStore;
import com.amazon.mas.client.device.DeviceInspector;
import com.amazon.mas.client.device.hardware.HardwareEvaluator;
import com.amazon.mas.client.device.software.opengl.OpenGlActivityInterrogator;
import com.amazon.mcc.resources.ResourceCache;
import com.amazon.venezia.concurrent.AsyncTasks;
import com.amazon.venezia.logging.Loggers;
import com.amazon.venezia.web.AuthCookieHelper;
import com.amazon.venezia.web.Marketplace;
import com.amazon.venezia.web.PageUrlFactory;
import com.amazon.venezia.web.SSRStack;
import com.amazon.venezia.web.WebViewBuilder;
import com.amazon.venezia.web.client.SSRDialogErrorComponent;
import com.amazon.venezia.web.client.SSRDialogLinkComponent;
import com.amazon.venezia.web.client.WebViewClientComponent;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.amazon.client.ftue:
//            InferenceResponseReceiver

public class InferCorPfmFragment extends Fragment
    implements InferenceResponseReceiver.Listener
{
    class CookieSetterTask extends AsyncTask
    {

        final InferCorPfmFragment this$0;
        private final String url;

        private void setUpIdentityCookies()
        {
            if (authCookieHelper != null && stack != null)
            {
                Object obj = new ArrayList();
                ((List) (obj)).add(AuthCookie.X_MAIN);
                obj = ((AuthCookieHelper)authCookieHelper.get()).getMapCookies(((List) (obj)), stack.getMapCompliantDomain(), false);
                ((AuthCookieHelper)authCookieHelper.get()).setDomainCompliantCookie(((java.util.Map) (obj)), url, stack);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            setUpIdentityCookies();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            webview.loadUrl(url);
        }

        public CookieSetterTask(String s)
        {
            this$0 = InferCorPfmFragment.this;
            super();
            url = s;
        }
    }

    class CustomerAttributeStoreFetcherTask extends AsyncTask
    {

        private final MASClientCustomerAttributeStore masClientCustomerAttributeStore;
        final InferCorPfmFragment this$0;
        private String url;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            String s1;
            if (accountManager == null || accountManager.getAccount() == null)
            {
                break MISSING_BLOCK_LABEL_189;
            }
            s1 = accountManager.getAccount();
            avoid = masClientCustomerAttributeStore.getAttribute("PFM", s1, false);
            String s = masClientCustomerAttributeStore.getAttribute("COR", s1, false);
            s1 = masClientCustomerAttributeStore.getAttribute("com.amazon.dcp.sso.token.device.accountpool", s1);
            marketplace = Marketplace.fromEMID(avoid);
            stack = marketplace.getStack();
            url = pageUrlFactory.getPfmCorUrl(stack);
            if (!TextUtils.isEmpty(s1))
            {
                url = (new StringBuilder()).append(url).append("&").append("accountPool").append("=").append(s1).toString();
            }
            avoid = buildMinifiedMasDeviceInfoCookie(avoid, s);
            return avoid;
            avoid;
            InferCorPfmFragment.LOG.e("Failed to obtain pfm and cor", avoid);
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (s != null)
            {
                setMasDeviceInfoCookie(url, s);
                cookieSetterTask = new CookieSetterTask(url);
                AsyncTasks.executeInParallel(cookieSetterTask, new Void[0]);
                return;
            } else
            {
                setInferenceFailed();
                return;
            }
        }

        public CustomerAttributeStoreFetcherTask(MASClientCustomerAttributeStore masclientcustomerattributestore)
        {
            this$0 = InferCorPfmFragment.this;
            super();
            masClientCustomerAttributeStore = masclientcustomerattributestore;
        }
    }

    public static interface Listener
    {

        public abstract void onInferenceComplete();

        public abstract void onInferenceRequiresInteraction();
    }


    private static final Logger LOG = Loggers.logger(com/amazon/client/ftue/InferCorPfmFragment);
    MAPAccountManager accountManager;
    Lazy authCookieHelper;
    private CookieSetterTask cookieSetterTask;
    private CustomerAttributeStoreFetcherTask customerAttributeStoreFetcherTask;
    DeviceInspector deviceInspector;
    private TextView fadText;
    HardwareEvaluator hardware;
    private InferenceResponseReceiver inferenceResponseReceiver;
    InferredCorPfm inferredCorPfm;
    private Listener listener;
    private Marketplace marketplace;
    OpenGlActivityInterrogator openglInterrogator;
    PageUrlFactory pageUrlFactory;
    ResourceCache resourceCache;
    private SSRStack stack;
    WebViewBuilder webViewFactory;
    private WebView webview;

    public InferCorPfmFragment()
    {
    }

    private String buildMinifiedMasDeviceInfoCookie(String s, String s1)
    {
        DisplayMetrics displaymetrics = hardware.getDisplayMetrics();
        s = (new StringBuilder()).append("masclient-device-info=dpi:").append(displaymetrics.density).append("|w:").append(displaymetrics.widthPixels).append("|h:").append(displaymetrics.heightPixels).append("|xdpi:").append(displaymetrics.xdpi).append("|ydpi:").append(displaymetrics.ydpi).append("|cor:").append(s1).append("|pfm:").append(s).append("|layout:").append(getResources().getConfiguration().screenLayout).append("|deviceType:").append(deviceInspector.getDeviceType()).append("|androidTargetSdkVersion:").append(getActivity().getApplicationInfo().targetSdkVersion).toString();
        LOG.d((new StringBuilder()).append("Minified version of mas-device-info cookie :").append(s).toString());
        return s;
    }

    private com.amazon.mas.client.authentication.InferredCorPfm.InferenceStatus getInferenceStatus(String s)
    {
        com.amazon.mas.client.authentication.InferredCorPfm.InferenceStatus inferencestatus1 = com.amazon.mas.client.authentication.InferredCorPfm.InferenceStatus.FAILED;
        com.amazon.mas.client.authentication.InferredCorPfm.InferenceStatus inferencestatus = inferencestatus1;
        if (s != null)
        {
            try
            {
                inferencestatus = com.amazon.mas.client.authentication.InferredCorPfm.InferenceStatus.valueOf(s);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                LOG.e((new StringBuilder()).append("Unknown Mapping for status:").append(s).toString());
                return inferencestatus1;
            }
        }
        return inferencestatus;
    }

    private void mapAuthenticatedInferenceExperience()
    {
        if (accountManager != null && accountManager.getAccount() != null)
        {
            customerAttributeStoreFetcherTask = new CustomerAttributeStoreFetcherTask(new MASClientCustomerAttributeStore(getActivity()));
            AsyncTasks.executeInParallel(customerAttributeStoreFetcherTask, new Void[0]);
        }
    }

    private void setInferenceFailed()
    {
        inferredCorPfm.setInferenceResults(null, null, null, null, com.amazon.mas.client.authentication.InferredCorPfm.InferenceStatus.FAILED);
        listener.onInferenceComplete();
    }

    private void setMasDeviceInfoCookie(String s, String s1)
    {
        CookieManager.getInstance().setCookie(s, s1);
    }

    private void setUpWebView()
    {
        webview = webViewFactory.createWebViewWithoutCookies(getActivity(), this, null, Arrays.asList(new WebViewClientComponent[] {
            new SSRDialogErrorComponent(getActivity()), new SSRDialogLinkComponent(getActivity())
        })).getWebView();
        webview.setBackgroundColor(0);
        webview.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    private void unAuthenticatedInferenceExperience()
    {
        marketplace = Marketplace.getMarketplaceByLocale();
        stack = marketplace.getStack();
        String s = pageUrlFactory.getPfmCorUrl(stack);
        setMasDeviceInfoCookie(s, buildMinifiedMasDeviceInfoCookie(marketplace.getEMID(), marketplace.getCor()));
        webview.loadUrl(s);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof Listener)
        {
            listener = (Listener)activity;
            DaggerAndroid.inject(this);
            CookieSyncManager.createInstance(activity);
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
            MAPInit.getInstance(activity).initialize();
            openglInterrogator.interrogate(activity);
            return;
        } else
        {
            throw new ClassCastException((new StringBuilder()).append(activity.getClass().getSimpleName()).append(" must implement ").append(com/amazon/client/ftue/InferCorPfmFragment$Listener.getSimpleName()).toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(com.amazon.venezia.R.layout.infercorpfm_fragment, null);
        fadText = (TextView)layoutinflater.findViewById(com.amazon.venezia.R.id.fad);
        fadText.setText(Html.fromHtml(resourceCache.getText("title_WelcomeMotto").toString()));
        setUpWebView();
        ((FrameLayout)layoutinflater.findViewById(com.amazon.venezia.R.id.inference_page_container)).addView(webview);
        if (accountManager != null && accountManager.getAccount() == null)
        {
            unAuthenticatedInferenceExperience();
            return layoutinflater;
        } else
        {
            mapAuthenticatedInferenceExperience();
            return layoutinflater;
        }
    }

    public void onInferenceComplete(Intent intent)
    {
        Object obj1 = intent.getExtras();
        if (obj1 != null)
        {
            intent = ((Bundle) (obj1)).getString("InferredCorPfm.PFM");
            String s = ((Bundle) (obj1)).getString("InferredCorPfm.COR");
            Object obj = ((Bundle) (obj1)).getString("InferredCorPfm.STATUS");
            String s1 = ((Bundle) (obj1)).getString("InferredCorPfm.AUTHPORTAL_DOMAIN");
            obj1 = ((Bundle) (obj1)).getString("InferredCorPfm.AUTHPORTAL_ASSOCIATION_HANDLE");
            LOG.d((new StringBuilder()).append("FTUE Parameters Received from SSR:Pfm:").append(intent).append(":Cor:").append(s).append(":Status:").append(((String) (obj))).append(":Domain:").append(s1).append(":associationHandle:").append(((String) (obj1))).toString());
            obj = getInferenceStatus(((String) (obj)));
            LOG.d((new StringBuilder()).append("Setting FTUE Inference Status:").append(obj).toString());
            inferredCorPfm.setInferenceResults(s, intent, s1, ((String) (obj1)), ((com.amazon.mas.client.authentication.InferredCorPfm.InferenceStatus) (obj)));
        } else
        {
            LOG.d("No Extras Received from SSR");
            setInferenceFailed();
        }
        listener.onInferenceComplete();
    }

    public void onInferenceRequiresInteraction(Intent intent)
    {
        listener.onInferenceRequiresInteraction();
    }

    public void onStart()
    {
        super.onStart();
        if (inferenceResponseReceiver == null)
        {
            inferenceResponseReceiver = new InferenceResponseReceiver(this);
            getActivity().registerReceiver(inferenceResponseReceiver, inferenceResponseReceiver.getIntentFilter());
        }
    }

    public void onStop()
    {
        super.onStop();
        if (inferenceResponseReceiver != null)
        {
            getActivity().unregisterReceiver(inferenceResponseReceiver);
            inferenceResponseReceiver = null;
        }
        if (cookieSetterTask != null)
        {
            cookieSetterTask.cancel(true);
            cookieSetterTask = null;
        }
        if (customerAttributeStoreFetcherTask != null)
        {
            customerAttributeStoreFetcherTask.cancel(true);
            customerAttributeStoreFetcherTask = null;
        }
    }




/*
    static Marketplace access$002(InferCorPfmFragment infercorpfmfragment, Marketplace marketplace1)
    {
        infercorpfmfragment.marketplace = marketplace1;
        return marketplace1;
    }

*/



/*
    static SSRStack access$102(InferCorPfmFragment infercorpfmfragment, SSRStack ssrstack)
    {
        infercorpfmfragment.stack = ssrstack;
        return ssrstack;
    }

*/






/*
    static CookieSetterTask access$502(InferCorPfmFragment infercorpfmfragment, CookieSetterTask cookiesettertask)
    {
        infercorpfmfragment.cookieSetterTask = cookiesettertask;
        return cookiesettertask;
    }

*/


}
