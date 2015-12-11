// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import com.groupon.db.dao.DaoCouponDetail;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.events.CouponUpdateEvent;
import com.groupon.db.models.CouponDetail;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.loader:
//            CouponLoaderCallbacks

public static class dbChannel extends EntityLoader
{

    protected String couponId;
    DaoCouponDetail daoCouponDetail;
    DaoCouponMerchant daoCouponMerchant;
    protected String dbChannel;

    public CouponDetail loadInBackground()
    {
        CouponDetail coupondetail;
        try
        {
            coupondetail = daoCouponDetail.getByCouponId(couponId);
        }
        catch (Exception exception)
        {
            Ln.e(exception);
            return null;
        }
        if (coupondetail == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        coupondetail.couponMerchant = daoCouponMerchant.getCouponMerchant(coupondetail.merchantUuid, dbChannel);
        return coupondetail;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    protected boolean shouldReload(CouponUpdateEvent couponupdateevent)
    {
        return couponupdateevent.getCouponId().equalsIgnoreCase(couponId);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((CouponUpdateEvent)updateevent);
    }

    public (Class class1, Class class2, Context context, String s, String s1)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        couponId = s;
        dbChannel = s1;
    }
}
