// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import aos;
import aov;
import aoy;
import apa;
import axw;
import bim;
import bin;
import biq;
import bir;
import bit;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.activity.link.model.TMetaInfo;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.wantu.activity.link.view:
//            UILabel, CityLabel, CityAndCountryLabel, CountryLabel, 
//            LinkImageView, LocationLabel, CaptionLabel, LatitudeView, 
//            TempLabel

public class LinkBaseView extends FrameLayout
{

    private String TAG;
    public bin linkImage1;
    public bin linkImage2;
    public bit textClickListener;

    public LinkBaseView(Context context)
    {
        super(context);
        TAG = "LinkBaseView";
    }

    private String getImageIndexStr()
    {
        bim.a();
        int i = bim.a;
        if (i < 10)
        {
            return String.format("0%d", new Object[] {
                Integer.valueOf(i)
            });
        } else
        {
            return String.format("%d", new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    private void handleImageIndex()
    {
        UILabel uilabel = subCountLabel();
        UILabel uilabel1 = subCountLabel();
        if (linkImage1 != null && uilabel != null)
        {
            bim.a();
            bim.a++;
            uilabel.setText(getImageIndexStr());
        }
        if (linkImage2 != null && uilabel1 != null)
        {
            bim.a();
            bim.a++;
            uilabel.setText(getImageIndexStr());
        }
    }

    private void handleLocation(TMetaInfo tmetainfo)
    {
        if (hasLocation())
        {
            requestLocation(tmetainfo);
        }
    }

    private void requestLocation(TMetaInfo tmetainfo)
    {
        if (tmetainfo != null)
        {
            apa apa1 = new apa();
            if (tmetainfo.getLatitude() != 0.0D || tmetainfo.getLongtitude() != 0.0D)
            {
                double d = tmetainfo.getLatitude();
                double d1 = tmetainfo.getLongtitude();
                apa1.a(d);
                apa1.b(d1);
            }
            if (apa1.a() == 0.0D && InstaBeautyApplication.d != null)
            {
                apa1.a(InstaBeautyApplication.d.a());
                apa1.b(InstaBeautyApplication.d.b());
            }
            if (apa1.a() != 0.0D)
            {
                requestLocationByGeometry(apa1);
            }
        }
    }

    private void requestLocationByGeometry(apa apa1)
    {
        aov aov1 = new aov(getContext(), new bir(this));
        aos aos1 = new aos();
        Object obj = Locale.getDefault();
        String s = ((Locale) (obj)).getLanguage();
        obj = ((Locale) (obj)).getCountry();
        Log.v(TAG, (new StringBuilder()).append(TAG).append("langcode:").append(s).append(" countryCode:").append(((String) (obj))).toString());
        aos1.a(aoy.a());
        aov1.a(aos1);
        aov1.a(apa1.a(), apa1.b());
    }

    public Bitmap getBitmapByAssetPath(String s)
    {
        Object obj;
        Bitmap bitmap;
        Object obj1;
        obj1 = null;
        obj = null;
        bitmap = ((Bitmap) (obj));
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() != 0) goto _L4; else goto _L3
_L3:
        bitmap = ((Bitmap) (obj));
_L2:
        return bitmap;
_L4:
        obj = InstaBeautyApplication.a().b().getAssets();
        s = ((AssetManager) (obj)).open(s);
        String s1;
        obj = obj1;
        s1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        obj = BitmapFactory.decodeStream(s);
        s1 = s;
_L6:
        bitmap = ((Bitmap) (obj));
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return ((Bitmap) (obj));
            }
            return ((Bitmap) (obj));
        }
        if (true) goto _L2; else goto _L5
_L5:
        IOException ioexception;
        ioexception;
        s = null;
_L7:
        ioexception.printStackTrace();
        ioexception = obj1;
        s1 = s;
          goto _L6
        ioexception;
          goto _L7
    }

    public int getOriHeight()
    {
        return 0;
    }

    public int getOriWith()
    {
        return 0;
    }

    public void handleCity(String s)
    {
        CityLabel citylabel = subCityLabel();
        if (citylabel != null && s != null && s.length() > 0)
        {
            citylabel.setText(s);
        }
    }

    public void handleCityAndCountry(String s)
    {
        CityAndCountryLabel cityandcountrylabel = subCityAndCountryLabel();
        if (cityandcountrylabel != null && s != null && s.length() > 0)
        {
            cityandcountrylabel.setText(s);
        }
    }

    public void handleCountry(String s)
    {
        CountryLabel countrylabel = subCountryLabel();
        if (countrylabel != null && s != null && s.length() > 0)
        {
            countrylabel.setText(s);
        }
    }

    public void handleData(TMetaInfo tmetainfo, TMetaInfo tmetainfo1)
    {
        if (tmetainfo == null) goto _L2; else goto _L1
_L1:
        Object obj = tmetainfo.getDateTime();
        if (obj == null || ((String) (obj)).length() <= 0) goto _L4; else goto _L3
_L3:
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        obj = simpledateformat.parse(((String) (obj)));
        if (obj != null)
        {
            try
            {
                handleTime(((Date) (obj)), 1);
            }
            catch (ParseException parseexception)
            {
                parseexception.printStackTrace();
            }
        }
_L7:
        if (tmetainfo1 == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        tmetainfo1 = tmetainfo1.getDateTime();
        if (tmetainfo1 == null || tmetainfo1.length() <= 0) goto _L6; else goto _L5
_L5:
        obj = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        tmetainfo1 = ((DateFormat) (obj)).parse(tmetainfo1);
        if (tmetainfo1 != null)
        {
            try
            {
                handleTime(tmetainfo1, 2);
            }
            // Misplaced declaration of an exception variable
            catch (TMetaInfo tmetainfo1)
            {
                tmetainfo1.printStackTrace();
            }
        }
_L8:
        handleLocation(tmetainfo);
        return;
_L4:
        handleTime(new Date(), 1);
          goto _L7
_L2:
        handleTime(new Date(), 1);
          goto _L7
_L6:
        handleTime(new Date(), 2);
          goto _L8
        handleTime(new Date(), 2);
          goto _L8
    }

    public void handleImage(bin bin1, bin bin2, boolean flag)
    {
        linkImage1 = bin1;
        linkImage2 = bin2;
        LinkImageView linkimageview1 = subImage1();
        LinkImageView linkimageview = subImage2();
        float f2;
        Object obj;
        Object obj1;
        if (linkimageview1 != null)
        {
            bin1 = (android.widget.FrameLayout.LayoutParams)((FrameLayout)findViewById(0x7f0d0284)).getLayoutParams();
            float f = ((android.widget.FrameLayout.LayoutParams) (bin1)).leftMargin;
            float f3 = ((android.widget.FrameLayout.LayoutParams) (bin1)).topMargin;
            float f8 = ((android.widget.FrameLayout.LayoutParams) (bin1)).leftMargin + ((android.widget.FrameLayout.LayoutParams) (bin1)).width;
            int i = ((android.widget.FrameLayout.LayoutParams) (bin1)).topMargin;
            bin1 = new RectF(f, f3, f8, ((android.widget.FrameLayout.LayoutParams) (bin1)).height + i);
        } else
        {
            bin1 = null;
        }
        if (linkimageview != null)
        {
            bin2 = (android.widget.FrameLayout.LayoutParams)((FrameLayout)findViewById(0x7f0d0285)).getLayoutParams();
            float f1 = ((android.widget.FrameLayout.LayoutParams) (bin2)).leftMargin;
            float f4 = ((android.widget.FrameLayout.LayoutParams) (bin2)).topMargin;
            float f9 = ((android.widget.FrameLayout.LayoutParams) (bin2)).leftMargin + ((android.widget.FrameLayout.LayoutParams) (bin2)).width;
            int j = ((android.widget.FrameLayout.LayoutParams) (bin2)).topMargin;
            bin2 = new RectF(f1, f4, f9, ((android.widget.FrameLayout.LayoutParams) (bin2)).height + j);
        } else
        {
            bin2 = null;
        }
        if (linkImage1 != null)
        {
            obj = new biq(linkImage1.a.getWidth(), linkImage1.a.getHeight());
        } else
        {
            obj = null;
        }
        if (linkImage2 != null)
        {
            obj1 = new biq(linkImage2.a.getWidth(), linkImage2.a.getHeight());
        } else
        {
            obj1 = null;
        }
        if (linkImage1 != null && linkImage2 != null)
        {
            float f5;
            if (((biq) (obj)).b == ((biq) (obj1)).b)
            {
                obj = new biq(Math.min(((biq) (obj)).a, ((biq) (obj1)).a), ((biq) (obj)).b);
            } else
            {
                obj = new biq((((biq) (obj)).a + ((biq) (obj1)).a) / 2.0F, (((biq) (obj)).b + ((biq) (obj1)).b) / 2.0F);
            }
            bin1.bottom = ((RectF) (bin1)).top + (bin1.width() / ((biq) (obj)).a) * ((biq) (obj)).b;
            f2 = ((RectF) (bin2)).top;
            f5 = bin2.width() / ((biq) (obj)).a;
            bin2.bottom = ((biq) (obj)).b * f5 + f2;
            if (bin1.height() > bin2.height())
            {
                f2 = ((RectF) (bin1)).top;
            } else
            {
                f2 = ((RectF) (bin2)).top;
            }
            f2 += Math.max(bin1.height(), bin2.height());
        } else
        if (linkImage1 != null)
        {
            f2 = ((RectF) (bin1)).top;
            float f6 = bin1.width() / ((biq) (obj)).a;
            bin1.bottom = ((biq) (obj)).b * f6 + f2;
            f2 = bin1.height();
        } else
        {
            f2 = ((RectF) (bin2)).top;
            float f7 = bin2.width() / ((biq) (obj1)).a;
            bin2.bottom = f2 + ((biq) (obj1)).b * f7;
            f2 = bin2.height();
        }
        obj = (android.widget.FrameLayout.LayoutParams)getLayoutParams();
        obj1 = new RectF(((android.widget.FrameLayout.LayoutParams) (obj)).leftMargin, ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin, ((android.widget.FrameLayout.LayoutParams) (obj)).leftMargin + ((android.widget.FrameLayout.LayoutParams) (obj)).width, ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin + ((android.widget.FrameLayout.LayoutParams) (obj)).height);
        obj1.bottom = f2 + subOffsetY() + ((RectF) (obj1)).top;
        obj.leftMargin = (int)((RectF) (obj1)).left;
        obj.topMargin = (int)((RectF) (obj1)).top;
        obj.height = (int)((RectF) (obj1)).height();
        obj.width = (int)((RectF) (obj1)).width();
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        if (linkImage1 != null && linkimageview1 != null)
        {
            obj = (FrameLayout)findViewById(0x7f0d0284);
            obj1 = (android.widget.FrameLayout.LayoutParams)((FrameLayout) (obj)).getLayoutParams();
            obj1.gravity = 51;
            obj1.leftMargin = (int)((RectF) (bin1)).left;
            obj1.topMargin = (int)((RectF) (bin1)).top;
            obj1.height = (int)bin1.height();
            obj1.width = (int)bin1.width();
            ((FrameLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            if (flag && linkImage1.a != null && !linkImage1.a.isRecycled())
            {
                linkimageview1.setImageBitmap(linkImage1.a);
            }
        }
        if (linkImage2 != null && linkimageview != null)
        {
            bin1 = (FrameLayout)findViewById(0x7f0d0285);
            obj = (android.widget.FrameLayout.LayoutParams)bin1.getLayoutParams();
            obj.leftMargin = (int)((RectF) (bin2)).left;
            obj.topMargin = (int)((RectF) (bin2)).top;
            obj.height = (int)bin2.height();
            obj.width = (int)bin2.width();
            bin1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            if (flag && linkImage2.a != null && !linkImage2.a.isRecycled())
            {
                linkimageview.setImageBitmap(linkImage2.a);
            }
        }
        if (linkImage1 == null || linkImage2 == null) goto _L2; else goto _L1
_L1:
        handleData(linkImage1.b, linkImage2.b);
_L4:
        handleImageIndex();
        return;
_L2:
        if (linkImage1 != null)
        {
            handleData(linkImage1.b, null);
        } else
        if (linkImage2 != null)
        {
            handleData(null, linkImage2.b);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void handleImageTag(int i, int j)
    {
        LinkImageView linkimageview = subImage1();
        LinkImageView linkimageview1 = subImage2();
        if (linkimageview != null)
        {
            linkimageview.setTag(Integer.valueOf(i));
        }
        if (linkimageview1 != null)
        {
            linkimageview1.setTag(Integer.valueOf(j));
        }
    }

    public void handleIpadLayout()
    {
    }

    public void handleTime(Date date, int i)
    {
        Object obj;
        UILabel uilabel;
        Object obj1;
        Object obj2;
        Object obj3;
        UILabel uilabel1;
        UILabel uilabel2;
        UILabel uilabel3;
        UILabel uilabel4;
        UILabel uilabel5;
        UILabel uilabel6;
        UILabel uilabel7;
        if (date == null)
        {
            date = new Date();
        }
        if (i == 1)
        {
            obj2 = subYearLabel();
        } else
        {
            obj2 = subYearLabel2();
        }
        if (i == 1)
        {
            obj3 = subMonthLabel();
        } else
        {
            obj3 = subMonthLabel2();
        }
        if (i == 1)
        {
            uilabel2 = subDayLabel();
        } else
        {
            uilabel2 = subDayLabel2();
        }
        if (i == 1)
        {
            uilabel5 = subWeekLabel();
        } else
        {
            uilabel5 = subWeekLabel2();
        }
        if (i == 1)
        {
            uilabel4 = subTimeLabel();
        } else
        {
            uilabel4 = subTimeLabel2();
        }
        if (i == 1)
        {
            uilabel7 = sub24TimeLabel();
        } else
        {
            uilabel7 = sub24TimeLabel2();
        }
        if (i == 1)
        {
            obj = subDateTimeLabel();
        } else
        {
            obj = subDateTimeLabel2();
        }
        if (i == 1)
        {
            uilabel3 = subDateLabel();
        } else
        {
            uilabel3 = subDateLabel2();
        }
        if (i == 1)
        {
            uilabel6 = subSimpleDateLabel();
        } else
        {
            uilabel6 = subSimpleDateLabel2();
        }
        if (i == 1)
        {
            obj1 = subDateTimeAndYearLabel();
        } else
        {
            obj1 = subDateTimeAndYearLabel2();
        }
        if (i == 1)
        {
            uilabel1 = subMonthAndDayLabel();
        } else
        {
            uilabel1 = subMonthAndDayLabel2();
        }
        if (i == 1)
        {
            uilabel = subMonthAndDayAndWeekLabel();
        } else
        {
            uilabel = subMonthAndDayAndWeekLabel2();
        }
        if (obj2 != null)
        {
            ((UILabel) (obj2)).setText(axw.a(date, "yyyy"));
        }
        if (obj3 != null)
        {
            ((UILabel) (obj3)).setText(axw.a(date, "MMM"));
        }
        if (uilabel2 != null)
        {
            uilabel2.setText(axw.a(date, "dd"));
        }
        if (uilabel5 != null)
        {
            uilabel5.setText(axw.a(date, "EEE"));
        }
        if (uilabel4 != null)
        {
            if (axw.a())
            {
                obj2 = "a h:mm";
            } else
            {
                obj2 = "h:mm a";
            }
            uilabel4.setText(axw.a(date, ((String) (obj2))));
        }
        if (uilabel7 != null)
        {
            uilabel7.setText(axw.a(date, "HH:mm"));
        }
        if (uilabel3 != null)
        {
            if (axw.a())
            {
                obj2 = "MMMd";
            } else
            {
                obj2 = "MMM d";
            }
            obj3 = axw.a(date, ((String) (obj2)));
            if (axw.a())
            {
                obj2 = "\u65E5";
            } else
            {
                obj2 = "";
            }
            uilabel3.setText(String.format("%s, %s", new Object[] {
                String.format("%s%s", new Object[] {
                    obj3, obj2
                }), axw.a(date, "yyyy")
            }));
        }
        if (uilabel6 != null)
        {
            uilabel6.setText(axw.a(date, "dd/MM"));
        }
        if (uilabel1 != null)
        {
            if (axw.a())
            {
                obj2 = "MMMd";
            } else
            {
                obj2 = "MMM d";
            }
            obj3 = axw.a(date, ((String) (obj2)));
            if (axw.a())
            {
                obj2 = "\u65E5";
            } else
            {
                obj2 = "";
            }
            uilabel1.setText(String.format("%s%s", new Object[] {
                obj3, obj2
            }));
        }
        if (obj != null)
        {
            if (axw.a())
            {
                obj2 = "a h:mm, MMMd";
            } else
            {
                obj2 = "h:mm a, MMM d";
            }
            obj3 = axw.a(date, ((String) (obj2)));
            if (axw.a())
            {
                obj2 = "\u65E5";
            } else
            {
                obj2 = "";
            }
            ((UILabel) (obj)).setText(String.format("%s%s", new Object[] {
                obj3, obj2
            }));
        }
        if (obj1 != null)
        {
            if (axw.a())
            {
                obj1 = "a h:mm, MMMd\u65E5, yyyy";
            } else
            {
                obj1 = "h:mm a, MMM d, yyyy";
            }
            ((UILabel) (obj)).setText(axw.a(date, ((String) (obj1))));
        }
        if (uilabel != null)
        {
            if (axw.a())
            {
                obj = "MMMd\u65E5, EEE";
            } else
            {
                obj = "MMM d, EEE";
            }
            uilabel.setText(axw.a(date, ((String) (obj))));
        }
    }

    public boolean hasLocation()
    {
        return subCityLabel() != null || subCountryLabel() != null || subCityAndCountryLabel() != null;
    }

    protected void resizeChildRecursive(ViewGroup viewgroup, float f, float f1)
    {
        int j = viewgroup.getChildCount();
        for (int i = 0; i < j; i++)
        {
            Object obj = viewgroup.getChildAt(i);
            if (!(obj instanceof View))
            {
                continue;
            }
            android.view.ViewGroup.LayoutParams layoutparams = ((View) (obj)).getLayoutParams();
            if (layoutparams.width >= 0)
            {
                layoutparams.width = (int)((double)((float)layoutparams.width * f) + 0.5D);
            }
            if (layoutparams.height >= 0)
            {
                layoutparams.height = (int)((double)((float)layoutparams.height * f1) + 0.5D);
            }
            if (layoutparams instanceof android.widget.FrameLayout.LayoutParams)
            {
                android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)layoutparams;
                int k = (int)((double)((float)layoutparams1.leftMargin * f) + 0.5D);
                int i1 = (int)((double)((float)layoutparams1.rightMargin * f) + 0.5D);
                layoutparams1.setMargins(k, (int)((double)((float)layoutparams1.topMargin * f1) + 0.5D), i1, (int)((double)((float)layoutparams1.bottomMargin * f1) + 0.5D));
            }
            if (layoutparams instanceof android.widget.RelativeLayout.LayoutParams)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams2 = (android.widget.RelativeLayout.LayoutParams)layoutparams;
                int l = (int)((double)((float)layoutparams2.leftMargin * f) + 0.5D);
                int j1 = (int)((double)((float)layoutparams2.rightMargin * f) + 0.5D);
                layoutparams2.setMargins(l, (int)((double)((float)layoutparams2.topMargin * f1) + 0.5D), j1, (int)((double)((float)layoutparams2.bottomMargin * f1) + 0.5D));
            }
            ((View) (obj)).setLayoutParams(layoutparams);
            if (!(obj instanceof ViewGroup))
            {
                continue;
            }
            obj = (ViewGroup)obj;
            if (((ViewGroup) (obj)).getChildCount() > 0)
            {
                resizeChildRecursive(((ViewGroup) (obj)), f, f1);
            }
        }

    }

    public void setTextClickListener(bit bit)
    {
        textClickListener = bit;
    }

    public UILabel sub24TimeLabel()
    {
        return null;
    }

    public UILabel sub24TimeLabel2()
    {
        return null;
    }

    public UILabel subAltitudeLabel()
    {
        return null;
    }

    public LocationLabel subBusinessNameLabel()
    {
        return null;
    }

    public CaptionLabel subCaptionLabel()
    {
        return null;
    }

    public CityAndCountryLabel subCityAndCountryLabel()
    {
        return null;
    }

    public CityLabel subCityLabel()
    {
        return null;
    }

    public UILabel subCountLabel()
    {
        return null;
    }

    public UILabel subCountLabel2()
    {
        return null;
    }

    public CountryLabel subCountryLabel()
    {
        return null;
    }

    public UILabel subDateLabel()
    {
        return null;
    }

    public UILabel subDateLabel2()
    {
        return null;
    }

    public UILabel subDateTimeAndYearLabel()
    {
        return null;
    }

    public UILabel subDateTimeAndYearLabel2()
    {
        return null;
    }

    public UILabel subDateTimeLabel()
    {
        return null;
    }

    public UILabel subDateTimeLabel2()
    {
        return null;
    }

    public UILabel subDayLabel()
    {
        return null;
    }

    public UILabel subDayLabel2()
    {
        return null;
    }

    public LinkImageView subImage1()
    {
        return null;
    }

    public LinkImageView subImage1MaskView()
    {
        return null;
    }

    public LinkImageView subImage2()
    {
        return null;
    }

    public LinkImageView subImage2MaskView()
    {
        return null;
    }

    public LatitudeView subLatitudeView()
    {
        return null;
    }

    public LocationLabel subLocationNameLabel()
    {
        return null;
    }

    public UILabel subMonthAndDayAndWeekLabel()
    {
        return null;
    }

    public UILabel subMonthAndDayAndWeekLabel2()
    {
        return null;
    }

    public UILabel subMonthAndDayLabel()
    {
        return null;
    }

    public UILabel subMonthAndDayLabel2()
    {
        return null;
    }

    public UILabel subMonthLabel()
    {
        return null;
    }

    public UILabel subMonthLabel2()
    {
        return null;
    }

    public float subOffsetY()
    {
        return 4F;
    }

    public UILabel subSimpleDateLabel()
    {
        return null;
    }

    public UILabel subSimpleDateLabel2()
    {
        return null;
    }

    public UILabel subTimeLabel()
    {
        return null;
    }

    public UILabel subTimeLabel2()
    {
        return null;
    }

    public UILabel subWeatherDetail()
    {
        return null;
    }

    public UILabel subWeatherHumidity()
    {
        return null;
    }

    public ImageView subWeatherIcon()
    {
        return null;
    }

    public UILabel subWeatherPrecip()
    {
        return null;
    }

    public UILabel subWeatherPressure()
    {
        return null;
    }

    public UILabel subWeatherTemp()
    {
        return null;
    }

    public TempLabel subWeatherTempFormatLogo()
    {
        return null;
    }

    public UILabel subWeatherTempWithoutCentigrade()
    {
        return null;
    }

    public UILabel subWeatherUV()
    {
        return null;
    }

    public UILabel subWeatherWind()
    {
        return null;
    }

    public UILabel subWeekLabel()
    {
        return null;
    }

    public UILabel subWeekLabel2()
    {
        return null;
    }

    public UILabel subYearLabel()
    {
        return null;
    }

    public UILabel subYearLabel2()
    {
        return null;
    }

}
