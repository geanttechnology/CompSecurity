// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.actions.FacebookHelper;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.ParentalControl;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.kindle.ftue.FTUEPrimeBenefitScreen;
import com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetricsHelper;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.SndsNoLinkedFacebookAccountException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

public class FacebookScreen extends FTUEPrimeBenefitScreen
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent FacebookPhotosImported;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/ftue/FacebookScreen$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            FacebookPhotosImported = new MetricsEvent("FacebookPhotosImported", 0);
            $VALUES = (new MetricsEvent[] {
                FacebookPhotosImported
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Source extends Enum
    {

        private static final Source $VALUES[];
        public static final Source AddPhotos;
        public static final Source FTUE;

        public static Source valueOf(String s)
        {
            return (Source)Enum.valueOf(com/amazon/gallery/thor/ftue/FacebookScreen$Source, s);
        }

        public static Source[] values()
        {
            return (Source[])$VALUES.clone();
        }

        static 
        {
            AddPhotos = new Source("AddPhotos", 0);
            FTUE = new Source("FTUE", 1);
            $VALUES = (new Source[] {
                AddPhotos, FTUE
            });
        }

        private Source(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/ftue/FacebookScreen.getName();
    private Button facebookButton;
    private android.content.DialogInterface.OnClickListener facebookDialogClickListener;
    private FacebookHelper facebookHelper;
    private final Runnable onSendNotificationFailure = new Runnable() ;
    private final Runnable onSendNotificationSuccess = new Runnable() ;
    private ParentalControl parentalControl;

    public FacebookScreen()
    {
        facebookDialogClickListener = new android.content.DialogInterface.OnClickListener() ;
    }

    private void resetButton()
    {
        spinnerDialog.hide();
        facebookButton.setText(activity.getString(0x7f0e00bd));
        enableButtons();
    }

    private void tryToImportPhotos()
    {
        disableButtons();
        spinnerDialog.show();
        try
        {
            facebookHelper.hasPhotosPermissions(restClient, new Runnable() , new Runnable() );
            return;
        }
        catch (InvalidParameterException invalidparameterexception)
        {
            GLogger.e(TAG, "Failed to initialize get facebook permissions operation", new Object[] {
                invalidparameterexception
            });
        }
        activity.runOnUiThread(new Runnable() );
    }

    public void disableButtons()
    {
        facebookButton.setClickable(false);
    }

    public void enableButtons()
    {
        facebookButton.setClickable(true);
    }

    protected int getBackgroundResource()
    {
        return 0x7f020185;
    }

    public int getLayout()
    {
        return 0x7f030095;
    }

    public com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent getShowScreenMetric()
    {
        return com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent.FacebookScreenDisplayed;
    }

    public void importFromFacebookHelper()
    {
        String s;
        NetworkExecutor networkexecutor;
        RestClient restclient;
        activity.runOnUiThread(new Runnable() );
        networkexecutor = NetworkExecutor.getInstance();
        restclient = restClient;
        if (!activity.isAddPhotosMode())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        s = Source.AddPhotos.name();
_L1:
        networkexecutor.executeForeground(restclient.importFacebookPhotos(s), new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final FacebookScreen this$0;

            public void onFailure(TerminalException terminalexception)
            {
                Throwable throwable;
                GLogger.wx(FacebookScreen.TAG, "Failed to import facebook photos?", terminalexception);
                throwable = terminalexception.getCause();
                if (!(terminalexception instanceof SndsNoLinkedFacebookAccountException)) goto _L2; else goto _L1
_L1:
                facebookHelper.unlinkFacebookFlagFromDevice(access$1500);
_L4:
                access$1500.runOnUiThread(new Runnable() );
                access$1500.runOnUiThread(onSendNotificationFailure);
                return;
_L2:
                if (throwable != null && (throwable.getCause() instanceof SndsNoLinkedFacebookAccountException))
                {
                    facebookHelper.unlinkFacebookFlagFromDevice(access$1500);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void onSuccess(Boolean boolean1)
            {
                ((AmazonInsightsHelper)access$1500.getApplicationBean(Keys.AMAZON_INSIGHTS_HELPER)).recordEvent(MetricsEvent.FacebookPhotosImported);
                access$1500.runOnUiThread(boolean1. new Runnable() );
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((Boolean)obj);
            }

            
            {
                this$0 = FacebookScreen.this;
                super();
            }
        });
        return;
        try
        {
            s = Source.FTUE.name();
        }
        catch (InvalidParameterException invalidparameterexception)
        {
            GLogger.e(com/amazon/gallery/thor/ftue/FacebookScreen.getSimpleName(), "Invalid parameter exception getting importFacebookPhotos from restclient", new Object[0]);
            return;
        }
          goto _L1
    }

    public void onEndpointEvent(EndpointLoadedEvent endpointloadedevent)
    {
        onEndpointLoaded(endpointloadedevent.endpoint);
    }

    public void onResume()
    {
        onResume();
        facebookButton = (Button)layout.findViewById(0x7f0c0164);
        facebookHelper = (FacebookHelper)activity.getApplicationBean(Keys.FACEBOOK_HELPER);
        parentalControl = (ParentalControl)activity.getApplicationBean(Keys.PARENTAL_CONTROL);
        facebookButton.setOnClickListener(new android.view.View.OnClickListener() {

            final FacebookScreen this$0;

            public void onClick(View view)
            {
                ((FTUEMetricsHelper)
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = FacebookScreen.this;
                super();
            }
        });
        layout.findViewById(0x7f0c0165).setOnClickListener(new android.view.View.OnClickListener() );
        layout.findViewById(0x7f0c0167).setOnClickListener(new android.view.View.OnClickListener() );
    }


















































    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$1$1

/* anonymous class */

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$10$1

/* anonymous class */

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$5$1$1

/* anonymous class */

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$5$2$1

/* anonymous class */
    class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final _cls2 this$2;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.dismiss();
        }

            
            {
                this$2 = _cls2.this;
                super();
            }
    }


    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$6$1

/* anonymous class */

    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$7$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        final _cls7 this$1;

        public void run()
        {
            importFromFacebookHelper();
        }

            
            {
                this$1 = _cls7.this;
                super();
            }
    }


    // Unreferenced inner class com/amazon/gallery/thor/ftue/FacebookScreen$8$1

/* anonymous class */
}
