// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.service.AddressService;
import com.squareup.picasso.Callback;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class MapSliceRedesign extends FrameLayout
{

    private Activity activity;
    private String address;
    private AddressService addressService;
    private View click;
    private boolean handledInitialSizeChange;
    private UrlImageView image;
    private View imageContainer;
    private Double lat;
    private Double lng;
    private TextView message;
    private String phone;
    private View phoneUrlDivider;
    private View vendorAddressContainer;
    private TextView vendorAddressView;
    private View vendorPhoneContainer;
    private TextView vendorPhoneView;
    private View vendorUrlContainer;
    private TextView vendorUrlView;
    private String website;

    public MapSliceRedesign(Context context)
    {
        this(context, null);
    }

    public MapSliceRedesign(final Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        handledInitialSizeChange = false;
        RoboGuice.getInjector(context).injectMembers(this);
        inflate(context, 0x7f03015b, this);
        imageContainer = findViewById(0x7f1002c5);
        message = (TextView)findViewById(0x7f10027c);
        image = (UrlImageView)findViewById(0x7f100076);
        image.setCallback(new Callback() {

            final MapSliceRedesign this$0;

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

            
            {
                this$0 = MapSliceRedesign.this;
                super();
            }
        });
        click = findViewById(0x7f1003fe);
        vendorAddressContainer = findViewById(0x7f1003f4);
        vendorPhoneContainer = findViewById(0x7f1003f9);
        vendorUrlContainer = findViewById(0x7f1003fc);
        vendorAddressView = (TextView)findViewById(0x7f1003f5);
        vendorPhoneView = (TextView)findViewById(0x7f1003fa);
        vendorUrlView = (TextView)findViewById(0x7f100351);
        phoneUrlDivider = findViewById(0x7f1003fb);
        vendorAddressView.setOnClickListener(new android.view.View.OnClickListener() {

            final MapSliceRedesign this$0;

            public void onClick(View view)
            {
                view = String.format("https://maps.google.com/maps?f=d&daddr=%s", new Object[] {
                    Uri.encode(address)
                });
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
            }

            
            {
                this$0 = MapSliceRedesign.this;
                super();
            }
        });
        vendorPhoneView.setOnClickListener(new android.view.View.OnClickListener() {

            final MapSliceRedesign this$0;
            final Context val$context;

            public void onClick(View view)
            {
                try
                {
                    view = ((TextView)view).getText().toString();
                    getContext().startActivity(Intent.createChooser(new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] {
                        view
                    }))), context.getString(0x7f080083)));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Ln.d(view, "Formatting phone number failed", new Object[0]);
                }
            }

            
            {
                this$0 = MapSliceRedesign.this;
                context = context1;
                super();
            }
        });
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

    public void setLocationAddress(String s, String s1, String s2, String s3, String s4, String s5)
    {
        address = addressService.getFormattedAddress(s, s1, s2, s3, s4);
    }

    public void setLocationCoordinates(double d, double d1)
    {
        lat = Double.valueOf(d);
        lng = Double.valueOf(d1);
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

            final MapSliceRedesign this$0;
            final android.view.View.OnClickListener val$listener;

            public void onClick(View view1)
            {
                if (listener != null)
                {
                    listener.onClick(MapSliceRedesign.this);
                }
            }

            
            {
                this$0 = MapSliceRedesign.this;
                listener = onclicklistener;
                super();
            }
        });
    }

    public void setVendorInfo(String s, String s1)
    {
        phone = s;
        website = s1;
    }

    public void show()
    {
        boolean flag1 = true;
        boolean flag = false;
        View view = vendorAddressContainer;
        int i;
        if (Strings.notEmpty(address))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (Strings.notEmpty(address))
        {
            vendorAddressView.setText(address);
        }
        view = vendorPhoneContainer;
        if (Strings.notEmpty(phone))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (Strings.notEmpty(phone))
        {
            final Uri websiteUri;
            String s;
            if (((TelephonyManager)activity.getSystemService("phone")).getPhoneType() == 0)
            {
                flag1 = false;
            }
            vendorPhoneView.setEnabled(flag1);
            vendorPhoneView.setText(phone);
        }
        websiteUri = vendorUrlContainer;
        if (Strings.notEmpty(website))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        websiteUri.setVisibility(i);
        if (Strings.notEmpty(website))
        {
            try
            {
                websiteUri = Uri.parse(website);
                s = String.format(getResources().getString(0x7f0800bd), new Object[] {
                    website
                });
                vendorUrlView.setText(s);
                vendorUrlView.setOnClickListener(new android.view.View.OnClickListener() {

                    final MapSliceRedesign this$0;
                    final Uri val$websiteUri;

                    public void onClick(View view1)
                    {
                        getContext().startActivity(new Intent("android.intent.action.VIEW", websiteUri));
                    }

            
            {
                this$0 = MapSliceRedesign.this;
                websiteUri = uri;
                super();
            }
                });
            }
            catch (Exception exception)
            {
                vendorUrlContainer.setVisibility(8);
            }
        }
        websiteUri = phoneUrlDivider;
        if (Strings.notEmpty(phone) && Strings.notEmpty(website))
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        websiteUri.setVisibility(i);
        updateImage();
    }

    protected void updateImage()
    {
        if (lat == null || lng == null || image.getMeasuredWidth() == 0)
        {
            return;
        } else
        {
            String s = String.format("http://maps.google.com/maps/api/staticmap?maptype=roadmap&sensor=true&zoom=%s&size=%sx%s&markers=color:red%%7C%s,%s", new Object[] {
                Integer.valueOf(16), Integer.valueOf(imageContainer.getMeasuredWidth()), Integer.valueOf(imageContainer.getMeasuredHeight()), lat, lng
            });
            message.setVisibility(8);
            image.setVisibility(0);
            image.setImageUrl(s);
            return;
        }
    }



}
