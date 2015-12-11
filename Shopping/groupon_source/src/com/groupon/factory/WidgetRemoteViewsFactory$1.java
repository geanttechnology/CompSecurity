// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.factory;

import android.content.Context;
import android.location.Location;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.dealsearch.DealSearchResponseWrapper;
import com.groupon.service.LocationService;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.factory:
//            WidgetRemoteViewsFactory

class this._cls0 extends SyncHttp
{

    final WidgetRemoteViewsFactory this$0;

    public DealSearchResponseWrapper call()
        throws Exception
    {
        ArrayList arraylist = WidgetRemoteViewsFactory.access$100(WidgetRemoteViewsFactory.this).getDivisionNameValuePairs(WidgetRemoteViewsFactory.access$000(WidgetRemoteViewsFactory.this));
        Location location = WidgetRemoteViewsFactory.access$200(WidgetRemoteViewsFactory.this).getLocation();
        arraylist.addAll(Arrays.asList(new String[] {
            "source", "widget"
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
        }));
        if (location != null)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lat", Double.valueOf(location.getLatitude()), "lng", Double.valueOf(location.getLongitude())
            }));
        }
        if (Strings.notEmpty(WidgetRemoteViewsFactory.access$300(WidgetRemoteViewsFactory.this)))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", WidgetRemoteViewsFactory.access$300(WidgetRemoteViewsFactory.this)
            }));
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(0), "limit", Integer.valueOf(4)
        }));
        nvps(arraylist.toArray());
        Ln.i("Loading deal for uri %s", new Object[] {
            getFullURI()
        });
        return (DealSearchResponseWrapper)super.call();
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    eWrapper(Context context, Class class1, String s)
    {
        this$0 = WidgetRemoteViewsFactory.this;
        super(context, class1, s);
    }
}
