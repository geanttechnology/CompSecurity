// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.app.IntentService;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.auth.AmazonAuthorizationConnectionFactory;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            AospPreferences, BlockingTokenAccessor

public class FetchCustomerEmailService extends IntentService
{
    public static interface CustomerEmailListener
    {

        public abstract void onCustomerEmailFetched();
    }


    private static final String TAG = com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService.getName();
    private static ArrayList mListeners;

    public FetchCustomerEmailService()
    {
        super(com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService.getSimpleName());
    }

    public FetchCustomerEmailService(String s)
    {
        super(s);
    }

    public static void addListener(CustomerEmailListener customeremaillistener)
    {
        com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService;
        JVM INSTR monitorenter ;
        if (mListeners == null)
        {
            mListeners = new ArrayList();
        }
        mListeners.add(customeremaillistener);
        com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService;
        JVM INSTR monitorexit ;
        return;
        customeremaillistener;
        throw customeremaillistener;
    }

    public static void notifyListeners()
    {
        com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService;
        JVM INSTR monitorenter ;
        if (mListeners != null)
        {
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((CustomerEmailListener)iterator.next()).onCustomerEmailFetched()) { }
        }
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        throw exception;
        com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService;
        JVM INSTR monitorexit ;
    }

    public static void removeListener(CustomerEmailListener customeremaillistener)
    {
        com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService;
        JVM INSTR monitorenter ;
        if (mListeners != null)
        {
            mListeners.remove(customeremaillistener);
        }
        com/amazon/gallery/thor/app/authentication/FetchCustomerEmailService;
        JVM INSTR monitorexit ;
        return;
        customeremaillistener;
        throw customeremaillistener;
    }

    protected void onHandleIntent(Intent intent)
    {
        Object obj;
        Object obj1;
        BufferedReader bufferedreader;
        AospPreferences aosppreferences;
        GLogger.d(TAG, (new StringBuilder()).append("onHandleIntent: ").append(intent.toString()).toString(), new Object[0]);
        if (!((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).isNetworkConnected())
        {
            return;
        }
        aosppreferences = new AospPreferences(this);
        if ((new MAPAccountManager(this)).getAccount() == null)
        {
            aosppreferences.setEmail(null);
            return;
        }
        bufferedreader = null;
        obj1 = null;
        obj = obj1;
        intent = bufferedreader;
        Object obj2 = (new BlockingTokenAccessor(this)).getAccessToken();
        if (obj2 == null)
        {
            IOUtils.closeQuietly(null);
            return;
        }
        obj = obj1;
        intent = bufferedreader;
        obj2 = new URL("https://api.amazon.com/user/profile?access_token=%s".replace("%s", URLEncoder.encode(((String) (obj2)), "UTF-8")));
        obj = obj1;
        intent = bufferedreader;
        obj1 = (new AmazonAuthorizationConnectionFactory()).createHttpURLConnection(((URL) (obj2))).getInputStream();
        obj = obj1;
        intent = ((Intent) (obj1));
        bufferedreader = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj1))));
        obj = obj1;
        intent = ((Intent) (obj1));
        obj2 = new StringBuilder();
_L2:
        obj = obj1;
        intent = ((Intent) (obj1));
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        intent = ((Intent) (obj1));
        ((StringBuilder) (obj2)).append(s);
        if (true) goto _L2; else goto _L1
        obj1;
        intent = ((Intent) (obj));
        GLogger.e(TAG, "Exception occurred trying to fetch the customer's email", new Object[] {
            obj1
        });
        intent = ((Intent) (obj));
        aosppreferences.setEmail(null);
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
_L4:
        notifyListeners();
        return;
_L1:
        obj = obj1;
        intent = ((Intent) (obj1));
        aosppreferences.setEmail((new JSONObject(((StringBuilder) (obj2)).toString())).getString("email"));
        IOUtils.closeQuietly(((java.io.InputStream) (obj1)));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        IOUtils.closeQuietly(intent);
        throw exception;
    }

}
