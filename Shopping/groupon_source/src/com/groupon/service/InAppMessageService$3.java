// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.inappmessage.InAppMessage;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.DivisionUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            InAppMessageService, LocationService, LoginService

class val.onFinally extends Http
{

    final InAppMessageService this$0;
    final Function0 val$onFinally;
    final Function1 val$onMessageAvailable;

    public com.groupon.models.inappmessage.y call()
        throws Exception
    {
        if (InAppMessageService.access$000(InAppMessageService.this).getCurrentDivision() == null)
        {
            Ln.i("Division empty - cannot retrieve messages", new Object[0]);
            return null;
        }
        if (Strings.isEmpty(InAppMessageService.access$100(InAppMessageService.this)))
        {
            Ln.w("Device Id empty - cannot retrieve messages", new Object[0]);
            return null;
        }
        android.location.Location location = ((LocationService)InAppMessageService.access$200(InAppMessageService.this).get()).getLocation();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "page", Integer.valueOf(1), "per_page", Integer.valueOf(1)
        }));
        if (InAppMessageService.access$300(InAppMessageService.this).isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "user_id", InAppMessageService.access$300(InAppMessageService.this).getUserId()
            }));
        }
        arraylist.addAll(((DivisionUtil)InAppMessageService.access$400(InAppMessageService.this).get()).getDivisionNameValuePairs(location));
        arraylist.addAll(Arrays.asList(new String[] {
            "version_number", InAppMessageService.access$500(InAppMessageService.this)
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "device_id", InAppMessageService.access$100(InAppMessageService.this)
        }));
        nvps(arraylist.toArray());
        return (com.groupon.models.inappmessage.s)super.call();
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    protected void onException(Exception exception)
    {
        Ln.w(exception);
    }

    protected void onFinally()
    {
        if (val$onFinally != null)
        {
            val$onFinally.execute();
        }
    }

    protected void onSuccess(com.groupon.models.inappmessage.y y)
        throws Exception
    {
        try
        {
            if (y.pMessages != null && !y.pMessages.isEmpty())
            {
                InAppMessageService.access$600(InAppMessageService.this, (InAppMessage)y.pMessages.get(0), val$onMessageAvailable);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.groupon.models.inappmessage.y y)
        {
            Ln.e(y);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((com.groupon.models.inappmessage.eAvailable)obj);
    }

    ge.List(String s, Function1 function1, Function0 function0)
    {
        this$0 = final_inappmessageservice;
        val$onMessageAvailable = function1;
        val$onFinally = function0;
        super(final_context, Class.this, s);
    }
}
