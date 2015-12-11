// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.db.models.Location;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.MapUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Transformation;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class BusinessMapSlice extends FrameLayout
{

    private DeviceInfoUtil deviceInfoUtil;
    private int height;
    private Location location;
    private UrlImageView mapImage;
    private TextView noMapMessage;
    private ProgressBar progressBar;
    private ImageView progressView;
    private boolean showMapPlaceholder;
    private int width;

    public BusinessMapSlice(Context context)
    {
        this(context, null, 0);
    }

    public BusinessMapSlice(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BusinessMapSlice(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        deviceInfoUtil = (DeviceInfoUtil)RoboGuice.getInjector(context).getInstance(com/groupon/util/DeviceInfoUtil);
        inflate(context, 0x7f03015a, this);
        noMapMessage = (TextView)findViewById(0x7f10027c);
        mapImage = (UrlImageView)findViewById(0x7f100076);
        progressBar = (ProgressBar)findViewById(0x7f10010b);
        progressView = (ImageView)findViewById(0x7f1003fd);
        progressView.setImageBitmap(MapUtils.drawMapWithGreenPin(context, BitmapFactory.decodeResource(context.getResources(), 0x7f020278)));
    }

    protected void hideMapViewAndShowErrorMessage()
    {
        boolean flag = false;
        mapImage.setVisibility(8);
        Object obj = noMapMessage;
        int i;
        if (showMapPlaceholder)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        progressView.setVisibility(8);
        obj = progressBar;
        if (showMapPlaceholder)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((ProgressBar) (obj)).setVisibility(i);
    }

    public void setLocation(Location location1)
    {
        if (location1 == null)
        {
            hideMapViewAndShowErrorMessage();
            return;
        } else
        {
            location = location1;
            width = 150;
            height = 150;
            updateImage();
            return;
        }
    }

    public void setLocationWithImageSize(Location location1, int i, int j)
    {
        if (location1 == null)
        {
            hideMapViewAndShowErrorMessage();
            return;
        } else
        {
            location = location1;
            width = i;
            height = j;
            updateImage();
            return;
        }
    }

    public void setShowMapPlaceholder(boolean flag)
    {
        boolean flag1 = false;
        showMapPlaceholder = flag;
        Object obj = progressBar;
        int i;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((ProgressBar) (obj)).setVisibility(i);
        obj = progressView;
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((ImageView) (obj)).setVisibility(i);
    }

    protected void showMapView()
    {
        mapImage.setVisibility(0);
        noMapMessage.setVisibility(8);
        progressView.setVisibility(8);
        progressBar.setVisibility(8);
    }

    protected void updateImage()
    {
        final String url = Double.valueOf(location.lat);
        Double double1 = Double.valueOf(location.lng);
        if (Strings.notEmpty(url) && Strings.notEmpty(double1))
        {
            float f = deviceInfoUtil.getDensity();
            url = String.format("https://mapproxy.groupon.com/maps/api/staticmap?maptype=roadmap&sensor=true&zoom=%s&size=%sx%s&center=%s,%s", new Object[] {
                Integer.valueOf(16), Integer.valueOf((int)((float)width * f)), Integer.valueOf((int)((float)height * f)), url, double1
            });
            mapImage.setCallback(new Callback() {

                final BusinessMapSlice this$0;

                public void onError(ImageView imageview)
                {
                    hideMapViewAndShowErrorMessage();
                }

                public void onSuccess(ImageView imageview)
                {
                    showMapView();
                }

            
            {
                this$0 = BusinessMapSlice.this;
                super();
            }
            });
            mapImage.setImageUrl(url, new Transformation() {

                final BusinessMapSlice this$0;
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
                this$0 = BusinessMapSlice.this;
                url = s;
                super();
            }
            });
            return;
        } else
        {
            hideMapViewAndShowErrorMessage();
            return;
        }
    }
}
