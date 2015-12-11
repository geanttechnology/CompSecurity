// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.db.models.CouponDetail;
import com.groupon.service.LocationService;
import com.groupon.service.coupondetails.CouponDetailResponse;
import com.groupon.service.coupondetails.CouponDetailService;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            CouponDetails

private class coupon extends AsyncTask
{

    private CouponDetail coupon;
    private String eventId;
    final CouponDetails this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        double d;
        double d1;
        Location location;
        try
        {
            avoid = MediaType.parse("application/x-www-form-urlencoded");
            location = CouponDetails.access$600(CouponDetails.this).getLocation();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Ln.e(avoid);
            return null;
        }
        d = 0.0D;
        d1 = 0.0D;
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        d = location.getLatitude();
        d1 = location.getLongitude();
        avoid = RequestBody.create(avoid, String.format("coupon_uuid=%s&bcookie=%s&event_id=%s&locn=%s,%s&source=android", new Object[] {
            coupon.remoteId, CouponDetails.access$700(CouponDetails.this).getBcookie(), eventId, Double.toString(d), Double.toString(d1)
        }));
        avoid = ((CouponDetailResponse)(new CouponDetailService(CouponDetails.this, avoid)).call()).targetUrl;
        return avoid;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (!Strings.notEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        byte byte0;
        CouponDetails.access$800(CouponDetails.this, eventId);
        s2 = "";
        String s3 = CouponDetails.access$900(CouponDetails.this).displayType;
        s1 = s3;
        if (s3 == null)
        {
            s1 = "";
        }
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 5: default 100
    //                   -997631434: 232
    //                   -27932576: 202
    //                   814094796: 247
    //                   1494517706: 217
    //                   1932946569: 262;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        byte0;
        JVM INSTR tableswitch 0 4: default 136
    //                   0 277
    //                   1 277
    //                   2 277
    //                   3 309
    //                   4 309;
           goto _L9 _L10 _L10 _L10 _L11 _L11
_L9:
        s1 = getString(0x7f080106);
_L14:
        if (!Strings.notEmpty(s)) goto _L13; else goto _L12
_L12:
        new URL(s);
        try
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                Toast.makeText(CouponDetails.this, getString(0x7f0800cc), 1).show();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Toast.makeText(CouponDetails.this, getString(0x7f0800da), 1).show();
                return;
            }
        }
        if (Strings.notEmpty(s1))
        {
            Toast.makeText(CouponDetails.this, s1, 1).show();
        }
_L13:
        return;
_L5:
        if (s1.equals("instore_promo_code"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (s1.equals("instore_sale"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s1.equals("online_instore_sale"))
        {
            byte0 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s1.equals("online_instore_promo_code"))
        {
            byte0 = 3;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (s1.equals("online_promo_code"))
        {
            byte0 = 4;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (Strings.notEmpty(coupon.productImageUrl))
        {
            s1 = getString(0x7f080106);
        } else
        {
            s1 = "";
        }
        continue; /* Loop/switch isn't completed */
_L11:
        s1 = s2;
        if (Strings.notEmpty(CouponDetails.access$900(CouponDetails.this).code))
        {
            s1 = getString(0x7f080105);
            ((ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Coupon Code", CouponDetails.access$900(CouponDetails.this).code));
        }
        if (true) goto _L14; else goto _L2
_L2:
        Toast.makeText(CouponDetails.this, getString(0x7f0800da), 1).show();
        return;
        if (true) goto _L3; else goto _L15
_L15:
    }

    public (CouponDetail coupondetail)
    {
        this$0 = CouponDetails.this;
        super();
        eventId = UUID.randomUUID().toString();
        coupon = coupondetail;
    }
}
