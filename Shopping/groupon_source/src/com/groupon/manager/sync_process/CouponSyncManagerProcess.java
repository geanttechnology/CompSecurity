// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import android.location.Location;
import com.groupon.db.dao.DaoCouponDetail;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.models.CouponDetail;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponPlace;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.UniversalInfo;
import com.groupon.models.division.Division;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.GeoPoint;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonFactory;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class CouponSyncManagerProcess extends AbstractSyncManagerProcess
{
    private static class CouponListContainer
    {

        public List coupons;
        public List merchants;

        private CouponListContainer()
        {
            coupons = new ArrayList();
            merchants = new ArrayList();
        }
    }

    private static class CouponNearbyLocationContainer
    {

        public List places;

        private CouponNearbyLocationContainer()
        {
            places = new ArrayList();
        }
    }


    protected static final int DEFAULT_LIMIT = 10;
    protected static final int FIVE_THOUSAND_METERS = 5000;
    protected String couponId;
    protected CurrentDivisionManager currentDivisionManager;
    protected DaoCouponDetail daoCouponDetail;
    protected DaoCouponMerchant daoCouponMerchant;
    protected LocationService locationService;

    public CouponSyncManagerProcess(Context context, String s, String s1)
    {
        super(context, s1);
        this.context = context;
        couponId = s;
    }

    protected Object[] getPlacesSyncQueryParams(double d, double d1, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "limit", Integer.valueOf(10), "lat", Double.valueOf(d), "lng", Double.valueOf(d1), "merchant_slug", s, "radius", Integer.valueOf(5000), 
            "view", "android"
        }));
        return arraylist.toArray();
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        universalinfo = new ArrayList();
        universalinfo.addAll(Arrays.asList(new String[] {
            "view", "android"
        }));
        return universalinfo.toArray();
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return String.format("https:/freebies/coupons/%s", new Object[] {
            couponId
        });
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return 0L;
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = new HashMap();
        obj = (CouponListContainer)obj;
        CouponMerchant couponmerchant;
        for (universalinfo = ((CouponListContainer) (obj)).merchants.iterator(); universalinfo.hasNext(); inputstream.put(couponmerchant.getRemoteId(), couponmerchant))
        {
            couponmerchant = (CouponMerchant)universalinfo.next();
            couponmerchant.channel = dbChannel;
            daoCouponMerchant.saveCouponMerchant(couponmerchant);
        }

        for (obj = ((CouponListContainer) (obj)).coupons.iterator(); ((Iterator) (obj)).hasNext(); daoCouponDetail.replace(universalinfo))
        {
            universalinfo = (CouponDetail)((Iterator) (obj)).next();
            universalinfo.couponMerchant = (CouponMerchant)inputstream.get(((CouponDetail) (universalinfo)).merchantUuid);
        }

    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        Object obj;
        inputstream = jsonFactory.createJsonParser(inputstream);
        inputstream = (CouponListContainer)mapper.readValue(inputstream, com/groupon/manager/sync_process/CouponSyncManagerProcess$CouponListContainer);
        universalinfo = locationService.getLocation();
        obj = currentDivisionManager.getCurrentDivision().geoPoint;
        for (Iterator iterator1 = ((CouponListContainer) (inputstream)).coupons.iterator(); iterator1.hasNext(); ((CouponDetail)iterator1.next()).afterJsonDeserializationPostProcessor()) { }
        if (universalinfo == null && obj == null || ((CouponListContainer) (inputstream)).merchants == null || ((CouponListContainer) (inputstream)).merchants.isEmpty() || ((CouponListContainer) (inputstream)).coupons.isEmpty() || !((CouponDetail)((CouponListContainer) (inputstream)).coupons.get(0)).instoreOffer) goto _L2; else goto _L1
_L1:
        JsonFactory jsonfactory;
        Context context;
        jsonfactory = new JsonFactory();
        context = this.context;
        if (universalinfo != null) goto _L4; else goto _L3
_L3:
        double d = ((GeoPoint) (obj)).getLatitudeDegrees();
_L12:
        if (universalinfo != null) goto _L6; else goto _L5
_L5:
        double d1 = ((GeoPoint) (obj)).getLongitudeDegrees();
_L10:
        universalinfo = jsonfactory.createJsonParser((InputStream)(new SyncHttp(context, java/io/InputStream, "https:/freebies/places", getPlacesSyncQueryParams(d, d1, ((CouponMerchant)((CouponListContainer) (inputstream)).merchants.get(0)).getSlug()))).call());
        obj = ((CouponNearbyLocationContainer)mapper.readValue(universalinfo, com/groupon/manager/sync_process/CouponSyncManagerProcess$CouponNearbyLocationContainer)).places;
        if (obj == null) goto _L2; else goto _L7
_L7:
        if (((List) (obj)).size() <= 0) goto _L2; else goto _L8
_L8:
        universalinfo = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); universalinfo.add(((CouponPlace)((Iterator) (obj)).next()).getLocation())) { }
          goto _L9
_L4:
        d = universalinfo.getLatitude();
        continue; /* Loop/switch isn't completed */
_L6:
        d1 = universalinfo.getLongitude();
          goto _L10
_L9:
        try
        {
            for (Iterator iterator = ((CouponListContainer) (inputstream)).merchants.iterator(); iterator.hasNext(); ((CouponMerchant)iterator.next()).setMerchantLocations(universalinfo)) { }
        }
        // Misplaced declaration of an exception variable
        catch (UniversalInfo universalinfo) { }
_L2:
        return inputstream;
        if (true) goto _L12; else goto _L11
_L11:
    }
}
