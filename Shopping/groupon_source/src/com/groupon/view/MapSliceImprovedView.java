// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.callbacks.OnMapSliceClickListener;
import com.groupon.util.MapUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Transformation;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class MapSliceImprovedView extends FrameLayout
{
    private class ImageRequestCallback
        implements Callback
    {

        final MapSliceImprovedView this$0;

        public void onError(ImageView imageview)
        {
        }

        public void onSuccess(ImageView imageview)
        {
            if (((BitmapDrawable)imageview.getDrawable()).getBitmap() == null)
            {
                message.setVisibility(0);
            }
        }

        private ImageRequestCallback()
        {
            this$0 = MapSliceImprovedView.this;
            super();
        }

    }

    public static final class MapSliceViewType extends Enum
    {

        private static final MapSliceViewType $VALUES[];
        public static final MapSliceViewType ADDRESS;
        public static final MapSliceViewType MAP;
        public static final MapSliceViewType MULTIPLE_LOCATIONS;
        public static final MapSliceViewType PHONE;
        public static final MapSliceViewType WEBSITE;

        public static MapSliceViewType valueOf(String s)
        {
            return (MapSliceViewType)Enum.valueOf(com/groupon/view/MapSliceImprovedView$MapSliceViewType, s);
        }

        public static MapSliceViewType[] values()
        {
            return (MapSliceViewType[])$VALUES.clone();
        }

        static 
        {
            MAP = new MapSliceViewType("MAP", 0);
            ADDRESS = new MapSliceViewType("ADDRESS", 1);
            MULTIPLE_LOCATIONS = new MapSliceViewType("MULTIPLE_LOCATIONS", 2);
            PHONE = new MapSliceViewType("PHONE", 3);
            WEBSITE = new MapSliceViewType("WEBSITE", 4);
            $VALUES = (new MapSliceViewType[] {
                MAP, ADDRESS, MULTIPLE_LOCATIONS, PHONE, WEBSITE
            });
        }

        private MapSliceViewType(String s, int i)
        {
            super(s, i);
        }
    }

    private class OnMapViewClickListener
        implements android.view.View.OnClickListener
    {

        final MapSliceImprovedView this$0;

        public void onClick(View view)
        {
            if (onMapSliceClickListener == null) goto _L2; else goto _L1
_L1:
            view.getId();
            JVM INSTR lookupswitch 5: default 64
        //                       2131755717: 65
        //                       2131755857: 133
        //                       2131756021: 82
        //                       2131756023: 99
        //                       2131756026: 116;
               goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
            return;
_L3:
            onMapSliceClickListener.onViewClicked(view, MapSliceViewType.MAP);
            return;
_L5:
            onMapSliceClickListener.onViewClicked(view, MapSliceViewType.ADDRESS);
            return;
_L6:
            onMapSliceClickListener.onViewClicked(view, MapSliceViewType.MULTIPLE_LOCATIONS);
            return;
_L7:
            onMapSliceClickListener.onViewClicked(view, MapSliceViewType.PHONE);
            return;
_L4:
            onMapSliceClickListener.onViewClicked(view, MapSliceViewType.WEBSITE);
            return;
        }

        private OnMapViewClickListener()
        {
            this$0 = MapSliceImprovedView.this;
            super();
        }

    }


    private static final int DEFAULT_MAP_ZOOM = 18;
    private String address;
    private float deviceScreenDensity;
    private boolean handledInitialSizeChange;
    UrlImageView image;
    View imageContainer;
    private double lat;
    private double lng;
    private int locationsCount;
    TextView message;
    View multipleLocationsContainer;
    TextView multipleLocationsCountView;
    View multipleLocationsView;
    private OnMapSliceClickListener onMapSliceClickListener;
    private String phone;
    View phoneUrlDivider;
    private boolean shouldShowMapView;
    private boolean useLargeSlice;
    View vendorAddressContainer;
    TextView vendorAddressView;
    View vendorPhoneContainer;
    TextView vendorPhoneView;
    View vendorUrlContainer;
    TextView vendorUrlView;
    private String website;

    public MapSliceImprovedView(Context context)
    {
        this(context, null);
    }

    public MapSliceImprovedView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        handledInitialSizeChange = false;
        useLargeSlice = true;
        inflate(context, 0x7f030159, this);
        RoboGuice.getInjector(context).injectMembers(this);
        ButterKnife.bind(this);
        image.setCallback(new ImageRequestCallback());
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (!handledInitialSizeChange)
        {
            handledInitialSizeChange = true;
            updateImage();
        }
    }

    public void setDeviceScreenDensity(float f)
    {
        deviceScreenDensity = f;
    }

    public void setLocationAddress(String s)
    {
        address = s;
    }

    public void setLocationCoordinates(double d, double d1)
    {
        lat = d;
        lng = d1;
    }

    public void setLocationsCount(int i)
    {
        locationsCount = i;
    }

    public void setOnMapSliceClickListener(OnMapSliceClickListener onmapsliceclicklistener)
    {
        onMapSliceClickListener = onmapsliceclicklistener;
    }

    public void setShouldShowMapView(boolean flag)
    {
        shouldShowMapView = flag;
    }

    public void setUseLargeSlice(boolean flag)
    {
        useLargeSlice = flag;
    }

    public void setVendorInfo(String s, String s1)
    {
        phone = s;
        website = s1;
    }

    public void show()
    {
        int i = 0;
        View view;
        if (shouldShowMapView && lat != 0.0D && lng != 0.0D)
        {
            imageContainer.setVisibility(0);
            imageContainer.setOnClickListener(new OnMapViewClickListener());
            updateImage();
        } else
        {
            imageContainer.setVisibility(8);
        }
        if (Strings.notEmpty(address))
        {
            vendorAddressContainer.setVisibility(0);
            vendorAddressView.setText(address);
            vendorAddressView.setOnClickListener(new OnMapViewClickListener());
        } else
        {
            vendorAddressContainer.setVisibility(8);
        }
        if (locationsCount > 1)
        {
            multipleLocationsCountView.setText(String.format(getContext().getString(0x7f08027c), new Object[] {
                Integer.valueOf(locationsCount)
            }));
            multipleLocationsContainer.setVisibility(0);
            multipleLocationsView.setOnClickListener(new OnMapViewClickListener());
        } else
        {
            multipleLocationsContainer.setVisibility(8);
        }
        if (Strings.notEmpty(phone))
        {
            vendorPhoneContainer.setVisibility(0);
            vendorPhoneView.setEnabled(true);
            vendorPhoneView.setText(phone);
            vendorPhoneView.setOnClickListener(new OnMapViewClickListener());
        } else
        {
            vendorPhoneContainer.setVisibility(8);
        }
        if (Strings.notEmpty(website))
        {
            vendorUrlContainer.setVisibility(0);
            vendorUrlView.setOnClickListener(new OnMapViewClickListener());
        } else
        {
            vendorUrlContainer.setVisibility(8);
        }
        view = phoneUrlDivider;
        if (!Strings.notEmpty(phone) || !Strings.notEmpty(website))
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    protected void updateImage()
    {
        int j;
label0:
        {
            if (lat != 0.0D || lng != 0.0D)
            {
                j = image.getMeasuredWidth();
                if (j != 0)
                {
                    break label0;
                }
            }
            return;
        }
        final String url;
        int i;
        if (useLargeSlice)
        {
            i = 150;
        } else
        {
            i = 60;
        }
        i = (int)((float)i * deviceScreenDensity);
        imageContainer.getLayoutParams().height = i;
        imageContainer.requestLayout();
        url = String.format("https://mapproxy.groupon.com/maps/api/staticmap?maptype=roadmap&sensor=true&zoom=%s&size=%sx%s&center=%s,%s", new Object[] {
            Integer.valueOf(18), Integer.valueOf(j), Integer.valueOf(i), Double.valueOf(lat), Double.valueOf(lng)
        });
        message.setVisibility(8);
        image.setVisibility(0);
        image.setImageUrl(url, new Transformation() {

            final MapSliceImprovedView this$0;
            final String val$url;

            public String key()
            {
                return url;
            }

            public Bitmap transform(Bitmap bitmap)
            {
                return MapUtils.drawMapWithGreenPin(getContext(), bitmap);
            }

            
            {
                this$0 = MapSliceImprovedView.this;
                url = s;
                super();
            }
        });
    }

}
