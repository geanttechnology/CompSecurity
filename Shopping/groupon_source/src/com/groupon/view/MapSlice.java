// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.groupon.activity.IntentFactory;
import com.groupon.animation.DropDownAnimation;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Location;
import com.groupon.db.models.Merchant;
import com.groupon.service.AddressService;
import com.groupon.service.DrivingDirectionsService;
import com.groupon.service.LocationService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.MapUtils;
import com.groupon.util.RedemptionUtils;
import com.squareup.picasso.Transformation;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            UrlImageView, DrivingDirectionsView

public class MapSlice extends FrameLayout
{

    private static final int ANIMATION_DURATION = 250;
    private Activity activity;
    protected AddressService addressService;
    private boolean animated;
    private String callNumber;
    private View click;
    private DeviceInfoUtil deviceInfoUtil;
    private DrivingDirectionsView directionsContainer;
    private DrivingDirectionsService drivingDirectionsService;
    private View expandAnimator;
    private View expandContent;
    private boolean handledInitialSizeChange;
    private UrlImageView image;
    protected View imageContainer;
    protected IntentFactory intentFactory;
    private boolean isExpanded;
    protected Location location;
    protected LocationService locationService;
    protected View locationsContainer;
    private Logger logger;
    protected TextView mapLocations;
    private TextView message;
    private View phoneUrlDivider;
    protected RedemptionUtils redemptionUtils;
    protected boolean useLargeSlice;
    private View vendorAddressContainer;
    private TextView vendorAddressView;
    private View vendorPhoneContainer;
    private TextView vendorPhoneView;
    private View vendorUrlContainer;
    private TextView vendorUrlView;

    public MapSlice(Context context)
    {
        this(context, null);
    }

    public MapSlice(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        location = new Location();
        handledInitialSizeChange = false;
        isExpanded = false;
        animated = true;
        RoboGuice.getInjector(context).injectMembers(this);
        inflate(context, 0x7f03015c, this);
        imageContainer = findViewById(0x7f1002c5);
        message = (TextView)findViewById(0x7f10027c);
        image = (UrlImageView)findViewById(0x7f100076);
        click = findViewById(0x7f1003fe);
        callNumber = context.getString(0x7f080083);
        expandAnimator = findViewById(0x7f1003ff);
        expandContent = findViewById(0x7f1003f3);
        vendorAddressContainer = findViewById(0x7f1003f4);
        vendorAddressView = (TextView)findViewById(0x7f1003f5);
        vendorPhoneContainer = findViewById(0x7f1003f9);
        vendorPhoneView = (TextView)findViewById(0x7f1003fa);
        vendorUrlContainer = findViewById(0x7f1003fc);
        vendorUrlView = (TextView)findViewById(0x7f100351);
        phoneUrlDivider = findViewById(0x7f1003fb);
        directionsContainer = (DrivingDirectionsView)findViewById(0x7f100401);
        locationsContainer = findViewById(0x7f1003f6);
        mapLocations = (TextView)findViewById(0x7f100400);
        vendorPhoneView.setOnClickListener(new android.view.View.OnClickListener() {

            final MapSlice this$0;

            public void onClick(View view)
            {
                onPhoneContainerClicked();
                try
                {
                    view = ((TextView)view).getText().toString();
                    getContext().startActivity(Intent.createChooser(new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] {
                        view
                    }))), callNumber));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = MapSlice.this;
                super();
            }
        });
    }

    protected void animateIn()
    {
        if (animated)
        {
            expandAnimator.setVisibility(0);
            int i = getMeasuredWidth();
            expandContent.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), 0);
            doAnimation(expandContent.getMeasuredHeight(), new Function0() {

                final MapSlice this$0;

                public void execute()
                {
                    updateImage();
                }

            
            {
                this$0 = MapSlice.this;
                super();
            }
            });
        }
    }

    protected void animateOut()
    {
        if (animated)
        {
            doAnimation(0, new Function0() {

                final MapSlice this$0;

                public void execute()
                {
                    expandAnimator.setVisibility(8);
                }

            
            {
                this$0 = MapSlice.this;
                super();
            }
            });
        }
    }

    protected void doAnimation(int i, final Function0 endCallback)
    {
        Ln.d("DETAILS: doAnimation: orig height = %s, new height = %s", new Object[] {
            Integer.valueOf(expandAnimator.getLayoutParams().height), Integer.valueOf(i)
        });
        if (expandAnimator.getLayoutParams().height == i)
        {
            if (endCallback != null)
            {
                endCallback.execute();
            }
            return;
        } else
        {
            endCallback = new android.view.animation.Animation.AnimationListener() {

                final MapSlice this$0;
                final Function0 val$endCallback;

                public void onAnimationEnd(Animation animation)
                {
                    if (endCallback != null)
                    {
                        endCallback.execute();
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                this$0 = MapSlice.this;
                endCallback = function0;
                super();
            }
            };
            DropDownAnimation dropdownanimation = new DropDownAnimation(expandAnimator, i, 250);
            dropdownanimation.setAnimationListener(endCallback);
            expandAnimator.startAnimation(dropdownanimation);
            return;
        }
    }

    public boolean isExpanded()
    {
        return isExpanded;
    }

    protected void onAddressContainerClicked()
    {
    }

    protected void onMapViewClicked()
    {
    }

    protected void onPhoneContainerClicked()
    {
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (!handledInitialSizeChange)
        {
            handledInitialSizeChange = true;
            updateImage();
            if (isExpanded())
            {
                showDirectionsOrHideContainer();
            }
        }
    }

    protected void onUrlContainerClicked()
    {
    }

    public void setAnimated(boolean flag)
    {
        animated = flag;
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }

    public void setExpanded(boolean flag)
    {
        isExpanded = flag;
        if (isExpanded)
        {
            showDirectionsOrHideContainer();
            return;
        } else
        {
            animateOut();
            return;
        }
    }

    protected void setLocation(Location location1)
    {
        Location location2 = new Location();
        location2.lat = location1.lat;
        location2.lng = location1.lng;
        location = location2;
    }

    public void setLocationAndVendorInfo(Location location1)
    {
        setLocation(location1);
        setLocationAndVendorInfo(addressService.getAddressFromLocation(location1), location1.phoneNumber, "", true);
    }

    public void setLocationAndVendorInfo(Location location1, Deal deal)
    {
        location = location1;
        String s = addressService.getAddressFromLocation(location1);
        String s1 = location1.phoneNumber;
        if (deal.merchant == null)
        {
            location1 = "";
        } else
        {
            location1 = deal.merchant.websiteUrl;
        }
        setLocationAndVendorInfo(s, s1, ((String) (location1)), false);
    }

    protected void setLocationAndVendorInfo(final String address, String s, final String vendorUrl, final boolean logGrouponNst)
    {
        Object obj;
        byte byte0;
        int i;
        if (location.lat != 0.0D || location.lng != 0.0D)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        obj = null;
        if (Strings.notEmpty(address))
        {
            vendorAddressView.setText(address);
            obj = vendorAddressContainer;
        }
        if (vendorAddressContainer != null)
        {
            vendorAddressView.setOnClickListener(new android.view.View.OnClickListener() {

                final MapSlice this$0;
                final String val$address;
                final boolean val$logGrouponNst;

                public void onClick(View view1)
                {
                    onAddressContainerClicked();
                    if (logGrouponNst)
                    {
                        logger.logClick("", "get_directions_click", "mygroupons", "");
                    }
                    view1 = String.format("https://maps.google.com/maps?f=d&daddr=%s", new Object[] {
                        Uri.encode(address)
                    });
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view1)));
                }

            
            {
                this$0 = MapSlice.this;
                logGrouponNst = flag;
                address = s;
                super();
            }
            });
            View view = vendorAddressContainer;
            if (Strings.notEmpty(address))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        } else
        {
            TextView textview = vendorAddressView;
            if (Strings.notEmpty(address))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            textview.setVisibility(i);
        }
        address = ((String) (obj));
        if (Strings.notEmpty(s))
        {
            if (((TelephonyManager)activity.getSystemService("phone")).getPhoneType() != 0)
            {
                logGrouponNst = true;
            } else
            {
                logGrouponNst = false;
            }
            vendorPhoneView.setEnabled(logGrouponNst);
            if (vendorPhoneContainer == null)
            {
                address = vendorPhoneView;
                if (logGrouponNst)
                {
                    i = 0x7f020107;
                } else
                {
                    i = 0x7f020185;
                }
                address.setBackgroundResource(i);
                address = vendorPhoneView;
                if (logGrouponNst)
                {
                    i = 18;
                } else
                {
                    i = 9;
                }
                address.setPadding(i, 10, 18, 18);
            }
            vendorPhoneView.setText(s);
            address = ((String) (obj));
            if (obj == null)
            {
                address = vendorPhoneContainer;
            }
        }
        if (vendorPhoneContainer != null)
        {
            obj = vendorPhoneContainer;
            if (Strings.notEmpty(s))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((View) (obj)).setVisibility(i);
        } else
        {
            obj = vendorPhoneView;
            if (Strings.notEmpty(s))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((TextView) (obj)).setVisibility(i);
        }
        obj = address;
        if (Strings.notEmpty(vendorUrl))
        {
            if (vendorUrlContainer != null)
            {
                obj = getResources().getString(0x7f080416);
            } else
            {
                obj = String.format(getResources().getString(0x7f0800bd), new Object[] {
                    vendorUrl
                });
            }
            vendorUrlView.setText(((CharSequence) (obj)));
            vendorUrlView.setOnClickListener(new android.view.View.OnClickListener() {

                final MapSlice this$0;
                final String val$vendorUrl;

                public void onClick(View view1)
                {
                    onUrlContainerClicked();
                    try
                    {
                        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(vendorUrl)));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view1)
                    {
                        return;
                    }
                }

            
            {
                this$0 = MapSlice.this;
                vendorUrl = s;
                super();
            }
            });
            obj = address;
            if (address == null)
            {
                obj = vendorUrlContainer;
            }
        }
        if (vendorUrlContainer != null)
        {
            address = vendorUrlContainer;
            if (Strings.notEmpty(vendorUrl))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            address.setVisibility(i);
        } else
        {
            address = vendorUrlView;
            if (Strings.notEmpty(vendorUrl))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            address.setVisibility(i);
        }
        if (phoneUrlDivider != null)
        {
            address = phoneUrlDivider;
            if (Strings.notEmpty(s) && Strings.notEmpty(vendorUrl))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            address.setVisibility(i);
        }
        updateImage();
        if (byte0 == 0 && obj != null)
        {
            address = ((View) (obj)).findViewById(0x7f10009e);
            if (address != null)
            {
                address.setVisibility(8);
            }
        }
        address = expandAnimator;
        if (animated)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        address.setVisibility(byte0);
    }

    public void setOnImageClickListener(final android.view.View.OnClickListener listener)
    {
        View view = click;
        boolean flag;
        if (listener != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setFocusable(flag);
        click.setOnClickListener(new android.view.View.OnClickListener() {

            final MapSlice this$0;
            final android.view.View.OnClickListener val$listener;

            public void onClick(View view1)
            {
                onMapViewClicked();
                if (listener != null)
                {
                    listener.onClick(MapSlice.this);
                }
            }

            
            {
                this$0 = MapSlice.this;
                listener = onclicklistener;
                super();
            }
        });
    }

    public void setOnLocationsClickListener(final android.view.View.OnClickListener listener)
    {
        boolean flag1 = true;
        View view = locationsContainer;
        boolean flag;
        if (listener != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setFocusable(flag);
        locationsContainer.setOnClickListener(new android.view.View.OnClickListener() {

            final MapSlice this$0;
            final android.view.View.OnClickListener val$listener;

            public void onClick(View view1)
            {
                onMapViewClicked();
                if (listener != null)
                {
                    listener.onClick(MapSlice.this);
                }
            }

            
            {
                this$0 = MapSlice.this;
                listener = onclicklistener;
                super();
            }
        });
        view = locationsContainer;
        if (listener != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        view.setFocusable(flag);
        locationsContainer.setOnClickListener(new android.view.View.OnClickListener() {

            final MapSlice this$0;
            final android.view.View.OnClickListener val$listener;

            public void onClick(View view1)
            {
                if (listener != null)
                {
                    listener.onClick(MapSlice.this);
                }
            }

            
            {
                this$0 = MapSlice.this;
                listener = onclicklistener;
                super();
            }
        });
    }

    public void setUseLargeSlice(boolean flag)
    {
        useLargeSlice = flag;
    }

    protected void showDirectionsContainer(boolean flag)
    {
        DrivingDirectionsView drivingdirectionsview = directionsContainer;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        drivingdirectionsview.setVisibility(i);
        animateIn();
    }

    public void showDirectionsOrHideContainer()
    {
        if (!handledInitialSizeChange)
        {
            return;
        }
        if (!drivingDirectionsService.isEnabled())
        {
            Ln.d("DETAILS: bail on show directions 1", new Object[0]);
            showDirectionsContainer(false);
            return;
        }
        Double double1 = Double.valueOf(location.lat);
        Double double2 = Double.valueOf(location.lng);
        if (Strings.isEmpty(double1) || Strings.isEmpty(double2))
        {
            Ln.d("DETAILS: bail on show directions 2", new Object[0]);
            showDirectionsContainer(false);
            return;
        }
        android.location.Location location1 = locationService.getLocation();
        if (location1 != null)
        {
            double d = location1.getLatitude();
            double d1 = location1.getLongitude();
            Ln.d("DETAILS: show directions: %s,%s --> %s,%s", new Object[] {
                Double.valueOf(d), Double.valueOf(d1), double1, double2
            });
            directionsContainer.getDirections(d, d1, double1.doubleValue(), double2.doubleValue(), new Function1() {

                final MapSlice this$0;

                public void execute(Boolean boolean1)
                {
                    Ln.d("DETAILS: directions success = %s", new Object[] {
                        boolean1
                    });
                    animateIn();
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((Boolean)obj);
                }

            
            {
                this$0 = MapSlice.this;
                super();
            }
            });
        }
        Ln.d("DETAILS: show directions 1", new Object[0]);
        showDirectionsContainer(true);
    }

    public void toggleMapViewVisibility(boolean flag)
    {
        View view = imageContainer;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void toggleVendorAddressVisibility(boolean flag)
    {
        TextView textview = vendorAddressView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    protected void updateImage()
    {
        double d = location.lat;
        double d1 = location.lng;
        if (d == 0.0D && d1 == 0.0D || image.getMeasuredWidth() == 0)
        {
            return;
        }
        float f = deviceInfoUtil.getDensity();
        int j = image.getMeasuredWidth();
        final String url;
        int i;
        if (useLargeSlice)
        {
            i = 150;
        } else
        {
            i = 60;
        }
        i = (int)((float)i * f);
        imageContainer.getLayoutParams().height = i;
        imageContainer.requestLayout();
        url = String.format("https://mapproxy.groupon.com/maps/api/staticmap?maptype=roadmap&sensor=true&zoom=%s&size=%sx%s&center=%s,%s", new Object[] {
            Integer.valueOf(18), Integer.valueOf(j), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d1)
        });
        message.setVisibility(8);
        image.setVisibility(0);
        image.setImageUrl(url, new Transformation() {

            final MapSlice this$0;
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
                this$0 = MapSlice.this;
                url = s;
                super();
            }
        });
    }




}
