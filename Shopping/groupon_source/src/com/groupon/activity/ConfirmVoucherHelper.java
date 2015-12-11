// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.db.models.Location;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.service.LocationService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GeoPoint;
import com.groupon.util.RedemptionUtils;
import com.groupon.view.MapSlice;
import com.squareup.picasso.Callback;
import java.util.ArrayList;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            IntentFactory

public class ConfirmVoucherHelper
    implements Callback
{

    private Activity activity;
    private IntentFactory intentFactory;
    private LocationService locationService;
    private Logger logger;
    private RedemptionUtils redemptionUtils;

    public ConfirmVoucherHelper()
    {
    }

    private void drawMapSection(final ArrayList locations, final MapSlice mapSlice, final int closest, final String merchantName)
    {
        byte byte1 = 8;
        mapSlice.setOnImageClickListener(new android.view.View.OnClickListener() {

            final ConfirmVoucherHelper this$0;
            final int val$closest;
            final ArrayList val$locations;
            final MapSlice val$mapSlice;
            final String val$merchantName;

            public void onClick(View view)
            {
                view = (MapSlice)view;
                if (view.isExpanded())
                {
                    activity.startActivity(intentFactory.newShowOnMapIntent(locations, merchantName, closest));
                    return;
                }
                MapSlice mapslice = mapSlice;
                boolean flag;
                if (view == mapSlice)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                mapslice.setExpanded(flag);
            }

            
            {
                this$0 = ConfirmVoucherHelper.this;
                locations = arraylist;
                merchantName = s;
                closest = i;
                mapSlice = mapslice;
                super();
            }
        });
        byte byte0 = byte1;
        if (locations != null)
        {
            byte0 = byte1;
            if (locations.size() > 0)
            {
                byte0 = 0;
                mapSlice.setUseLargeSlice(true);
                mapSlice.setLocationAndVendorInfo((Location)locations.get(closest));
                mapSlice.setExpanded(true);
            }
        }
        mapSlice.setVisibility(byte0);
    }

    public void onError(ImageView imageview)
    {
    }

    public void onSuccess(final ImageView view)
    {
        Ln.d("PAGER: onImageLoaded %s, size=%s x %s", new Object[] {
            view, Integer.valueOf(view.getWidth()), Integer.valueOf(view.getHeight())
        });
        final Bitmap bitmap = ((BitmapDrawable)view.getDrawable()).getBitmap();
        if (bitmap == null)
        {
            return;
        } else
        {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final ConfirmVoucherHelper this$0;
                final Bitmap val$bitmap;
                final ImageView val$view;

                public void onGlobalLayout()
                {
                    Object obj = new DisplayMetrics();
                    activity.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
                    int i = ((DisplayMetrics) (obj)).widthPixels;
                    int j = Math.min(((DisplayMetrics) (obj)).heightPixels / 2, (int)Math.floor((bitmap.getHeight() * i) / bitmap.getWidth()));
                    Ln.d("PAGER: bm = %s x %s, new = %s x %s", new Object[] {
                        Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(j)
                    });
                    obj = view.getLayoutParams();
                    obj.width = i;
                    obj.height = j;
                    view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                    view.requestLayout();
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }

            
            {
                this$0 = ConfirmVoucherHelper.this;
                bitmap = bitmap1;
                view = imageview;
                super();
            }
            });
            return;
        }
    }

    protected void refreshMapSection(final MyGrouponItem voucher, final ArrayList locations, MapSlice mapslice, String s, TextView textview, final String loggerSpecifier)
    {
        Object obj;
        int i;
        final int closest;
        if (locations.size() > 0)
        {
            obj = locationService.getLocation();
            RedemptionUtils redemptionutils = redemptionUtils;
            if (obj != null)
            {
                obj = new GeoPoint((int)(((android.location.Location) (obj)).getLatitude() * 1000000D), (int)(((android.location.Location) (obj)).getLongitude() * 1000000D));
            } else
            {
                obj = null;
            }
            closest = redemptionutils.findClosestLocationTo(((GeoPoint) (obj)), locations);
            obj = (Location)locations.get(closest);
            if (((Location) (obj)).lat != 0.0D && ((Location) (obj)).lng != 0.0D)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            closest = 0;
            i = 0;
            obj = new Location();
        }
        mapslice.setOnLocationsClickListener(new android.view.View.OnClickListener() {

            final ConfirmVoucherHelper this$0;
            final int val$closest;
            final ArrayList val$locations;
            final String val$loggerSpecifier;
            final MyGrouponItem val$voucher;

            public void onClick(View view)
            {
                logger.logClick("", "small_map_click", loggerSpecifier, "");
                activity.startActivity(intentFactory.newShowOnMapIntent(locations, voucher.name, closest));
            }

            
            {
                this$0 = ConfirmVoucherHelper.this;
                loggerSpecifier = s;
                locations = arraylist;
                voucher = mygrouponitem;
                closest = i;
                super();
            }
        });
        if (i != 0)
        {
            drawMapSection(locations, mapslice, closest, s);
        }
        if (textview != null)
        {
            textview.setText(((Location) (obj)).name);
            if (Strings.notEmpty(textview.getText()))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            textview.setVisibility(i);
        }
    }



}
