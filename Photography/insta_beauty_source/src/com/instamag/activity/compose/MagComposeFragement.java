// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.compose;

import aan;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anq;
import ant;
import anu;
import aoq;
import aos;
import aou;
import aov;
import aoy;
import apa;
import axw;
import ayo;
import ayr;
import ayu;
import bae;
import baf;
import bag;
import bai;
import baj;
import bak;
import bal;
import bao;
import bap;
import baq;
import bep;
import bff;
import bfg;
import bfi;
import bfj;
import bfs;
import bjd;
import bje;
import bku;
import bpn;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.comlib.ui.HorizontalListView;
import com.google.gson.Gson;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.view.TDecorateInfosLayerTextHelpView;
import com.instamag.activity.view.TDecorateInfosLayerView;
import com.instamag.activity.view.TMaskScrollImageView;
import com.wantu.ResourceOnlineLibrary.compose.FlipViewType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TDecorateInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMaskInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.view.ImagesMovingView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;

// Referenced classes of package com.instamag.activity.compose:
//            MagComposeActivity

public class MagComposeFragement extends Fragment
    implements android.view.SurfaceHolder.Callback, android.view.View.OnLongClickListener, anu, ayo, bff, bfs, bje, bpn
{

    private static final int KCropSourceBitMap = 1000;
    private int KMaxPix;
    private String TAG;
    private ImageView _backgroundImageView;
    private FrameLayout _composeFrameLayout;
    private TDecorateInfosLayerView _decorateInfosLayer;
    private ImageView _foregroundImageView;
    private List _gifLayoutInfoes;
    private List _layoutInfoes;
    private List _scrollViewArray;
    private FrameLayout _scrollViewContainer;
    private EditText _textEditor;
    private RelativeLayout _textEditorBar;
    private boolean bShouldProcessFilterWhenopenGlCreated;
    private RelativeLayout bannerLayout;
    bjd cropImagsTask;
    private aoq curGeocoderItem;
    private aou curPlacemark;
    private String dateTime;
    private TDecorateInfosLayerTextHelpView editHelpView;
    private FlipViewType flipOrientation;
    private apa geometry;
    private boolean haveLocation;
    private boolean haveTime;
    private boolean haveWeather;
    private boolean isShowAnimation;
    private boolean isShowLongPressHelp;
    private boolean isUsingHeightAsRef;
    private int lastImageIndex;
    private float lastX;
    private float lastY;
    private FrameLayout mActionBarLayout;
    public MagComposeActivity mActivity;
    private View mContainer;
    private TMaskScrollImageView mCurSelectedMaskView;
    HorizontalListView mFilterListView;
    private TImageFilterManager mFilterManager;
    private ImageGLSurfaceView mSurfaceView;
    private ImageButton mbeautyEditButton;
    private float mergeX;
    private float mergeY;
    private FrameLayout mfilterFrameLayout;
    private Handler mhandler;
    private float modifyScale;
    ImagesMovingView movingView;
    private boolean openGlCreated;
    private ayr weatherManager;

    public MagComposeFragement()
    {
        TAG = "MainComposeFragement";
        KMaxPix = 612;
        _scrollViewArray = new ArrayList();
        _layoutInfoes = new ArrayList();
        _gifLayoutInfoes = new ArrayList();
        isShowLongPressHelp = false;
        haveLocation = false;
        haveWeather = false;
        haveTime = false;
        openGlCreated = false;
        bShouldProcessFilterWhenopenGlCreated = false;
        geometry = new apa();
        curGeocoderItem = null;
        curPlacemark = null;
        isShowAnimation = false;
        modifyScale = 1.0F;
    }

    private void changeImageByMovingView()
    {
        if (movingView != null && movingView.getVisibility() == 0)
        {
            Object obj = movingView.getStartRect();
            Object obj1 = movingView.getTargetRect();
            if (!rectIsEqual(((Rect) (obj)), ((Rect) (obj1))) && obj != null && obj1 != null)
            {
                obj = getImageViewByRect(((Rect) (obj)));
                obj1 = getImageViewByRect(((Rect) (obj1)));
                if (obj != null && obj1 != null)
                {
                    int i = ((Integer)((TMaskScrollImageView) (obj)).getTag()).intValue();
                    int j = ((Integer)((TMaskScrollImageView) (obj1)).getTag()).intValue();
                    if (mActivity != null && mActivity.f().size() > Math.max(i, j))
                    {
                        TPhotoMaskInfo tphotomaskinfo = ((TMaskScrollImageView) (obj)).getMaskInfo();
                        TPhotoMaskInfo tphotomaskinfo1 = ((TMaskScrollImageView) (obj1)).getMaskInfo();
                        if (!tphotomaskinfo.is3DTransform() && !tphotomaskinfo1.is3DTransform())
                        {
                            Bitmap bitmap = ((TMaskScrollImageView) (obj)).getCenterBitmap();
                            Bitmap bitmap2 = ((TMaskScrollImageView) (obj1)).getCenterBitmap();
                            if (openGlCreated && mSurfaceView != null && tphotomaskinfo.isPIP)
                            {
                                ((TMaskScrollImageView) (obj)).changeMaskScrollViewImage(bitmap2, mSurfaceView);
                            } else
                            {
                                ((TMaskScrollImageView) (obj)).updateCenterViewImage(bitmap2);
                            }
                            if (openGlCreated && mSurfaceView != null && tphotomaskinfo1.isPIP)
                            {
                                ((TMaskScrollImageView) (obj1)).changeMaskScrollViewImage(bitmap, mSurfaceView);
                            } else
                            {
                                ((TMaskScrollImageView) (obj1)).updateCenterViewImage(bitmap);
                            }
                        } else
                        {
                            Bitmap bitmap1 = (Bitmap)mActivity.f().get(i);
                            Bitmap bitmap3 = (Bitmap)mActivity.f().get(j);
                            if (tphotomaskinfo1.is3DTransform())
                            {
                                ((TMaskScrollImageView) (obj1)).updateCenter3dTransformImage(bitmap1, false);
                            } else
                            if (openGlCreated && mSurfaceView != null && tphotomaskinfo1.isPIP)
                            {
                                ((TMaskScrollImageView) (obj1)).changeMaskScrollViewImage(bitmap1, mSurfaceView);
                            } else
                            {
                                ((TMaskScrollImageView) (obj1)).updateCenterViewImage(bitmap1);
                            }
                            if (tphotomaskinfo.is3DTransform())
                            {
                                ((TMaskScrollImageView) (obj)).updateCenter3dTransformImage(bitmap3, false);
                            } else
                            if (openGlCreated && mSurfaceView != null && tphotomaskinfo.isPIP)
                            {
                                ((TMaskScrollImageView) (obj)).changeMaskScrollViewImage(bitmap3, mSurfaceView);
                            } else
                            {
                                ((TMaskScrollImageView) (obj)).updateCenterViewImage(bitmap3);
                            }
                        }
                        ((TMaskScrollImageView) (obj)).setTag(Integer.valueOf(j));
                        ((TMaskScrollImageView) (obj1)).setTag(Integer.valueOf(i));
                    }
                }
            }
            movingView.setVisibility(4);
            movingView.setStartRectAndBitmap(null, null);
            setAllImageViewsScroolEnable(true);
        }
    }

    private float computeModifyScale()
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f = displaymetrics.widthPixels;
        float f1 = axw.a(mActivity, 150F);
        float f2 = (float)displaymetrics.widthPixels / (float)displaymetrics.heightPixels;
        float f3 = mActivity.d().width / mActivity.d().height;
        f /= mActivity.d().width;
        if (f2 > f3)
        {
            Log.v(TAG, "Using height as scale referance");
            f = (float)displaymetrics.heightPixels / mActivity.d().height;
        }
        f *= mActivity.d().height;
        if (f + f1 > (float)displaymetrics.heightPixels)
        {
            f = ((float)displaymetrics.heightPixels - f1) / f;
        } else
        {
            f = 1.0F;
        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" ModifyScale :").append(f).toString());
        return f;
    }

    private aoq createGeocoderItemFromBDLaction()
    {
        return null;
    }

    private boolean existFilterName(String s)
    {
        for (Iterator iterator = getFilterManger().getmKeyOderArray().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            Log.v(TAG, (new StringBuilder()).append(TAG).append("manager filterName :").append(s1).toString());
            if (s1.equalsIgnoreCase(s))
            {
                return true;
            }
        }

        return false;
    }

    private int getCropMaxPix()
    {
        char c = '\u0264';
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f = displaymetrics.density;
        int i = displaymetrics.densityDpi;
        float f1 = displaymetrics.xdpi;
        float f2 = displaymetrics.ydpi;
        float f3 = displaymetrics.widthPixels;
        float f4 = displaymetrics.heightPixels;
        Log.e((new StringBuilder()).append(TAG).append("  DisplayMetrics").toString(), (new StringBuilder()).append("xdpi=").append(f1).append("; ydpi=").append(f2).toString());
        Log.e((new StringBuilder()).append(TAG).append("  DisplayMetrics").toString(), (new StringBuilder()).append("density=").append(f).append("; densityDPI=").append(i).toString());
        Log.v((new StringBuilder()).append(TAG).append("  screenWidth ").toString(), String.format("%f", new Object[] {
            Float.valueOf(f3)
        }));
        Log.v((new StringBuilder()).append(TAG).append("  screenHeight ").toString(), String.format("%f", new Object[] {
            Float.valueOf(f4)
        }));
        if (f1 < 160F || f3 < 400F)
        {
            c = '\u019A';
        }
        return c;
    }

    private TImageFilterManager getFilterManger()
    {
        if (mFilterManager == null)
        {
            mFilterManager = new TImageFilterManager();
        }
        return mFilterManager;
    }

    private TMaskScrollImageView getImageViewByRect(Rect rect)
    {
        for (int i = 0; i < _scrollViewArray.size(); i++)
        {
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)_scrollViewArray.get(i);
            if (tmaskscrollimageview == null)
            {
                continue;
            }
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)tmaskscrollimageview.getLayoutParams();
            int j = layoutparams.leftMargin;
            int k = layoutparams.topMargin;
            int l = layoutparams.width;
            int i1 = layoutparams.height;
            if (rect.left == j && rect.top == k && rect.width() == l && rect.height() == i1)
            {
                return tmaskscrollimageview;
            }
        }

        return null;
    }

    private bep getOptimizedPhotoSize(TPhotoComposeInfo tphotocomposeinfo)
    {
        char c1 = '\u0280';
        char c = '\u01C0';
        int i;
        int j;
        if (tphotocomposeinfo.width == tphotocomposeinfo.height)
        {
            if (InstaBeautyApplication.b)
            {
                c1 = '\u01C0';
            } else
            {
                c = '\u0280';
            }
        } else
        if (tphotocomposeinfo.width > tphotocomposeinfo.height)
        {
            c = '\u0282';
            if (InstaBeautyApplication.b)
            {
                c = '\u01C1';
                c1 = '\u02A0';
            } else
            {
                c1 = '\u03C0';
            }
        } else
        if (InstaBeautyApplication.b)
        {
            c1 = '\u01C0';
            c = '\u02A0';
        } else
        {
            c = '\u03C0';
        }
        j = c;
        i = c1;
        if (_composeFrameLayout.getWidth() > c1)
        {
            j = c;
            i = c1;
            if (_composeFrameLayout.getHeight() > c)
            {
                i = (int)((float)_composeFrameLayout.getWidth() / modifyScale);
                j = (int)((float)_composeFrameLayout.getHeight() / modifyScale);
            }
        }
        tphotocomposeinfo = new bep();
        tphotocomposeinfo.a = i;
        tphotocomposeinfo.b = j;
        Log.v("optimized", (new StringBuilder()).append("widht:").append(i).append("height:").append(j).toString());
        return tphotocomposeinfo;
    }

    private ayr getWeatherManager()
    {
        if (weatherManager == null)
        {
            weatherManager = ayr.a();
            weatherManager.a(this);
        }
        return weatherManager;
    }

    private void handelWeather(ayu ayu1)
    {
        if (ayu1 != null)
        {
            Log.v(TAG, (new StringBuilder()).append(TAG).append("getWeatherModel weather:").append(getWeatherManager().b().d).toString());
            Log.v(TAG, (new StringBuilder()).append(TAG).append("getWeatherModel wind_string :").append(getWeatherManager().b().i).toString());
            if (_decorateInfosLayer != null)
            {
                _decorateInfosLayer.setWeather(getWeatherManager().b());
                return;
            }
        }
    }

    private void handleDateTime()
    {
        if (!haveTime || dateTime == null || dateTime.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append("update before dateTime :").append(dateTime).toString());
        Object obj = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        try
        {
            obj = ((DateFormat) (obj)).parse(dateTime);
        }
        catch (ParseException parseexception)
        {
            parseexception.printStackTrace();
            Crashlytics.logException(parseexception);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        if (_decorateInfosLayer != null)
        {
            _decorateInfosLayer.setDateText(((java.util.Date) (obj)));
        }
    }

    private Bitmap makeResultImage(int i, int j)
    {
        Object obj = getResources().getDisplayMetrics();
        float f = ((DisplayMetrics) (obj)).widthPixels;
        f = (float)i / f;
        float f1 = 1.0F / modifyScale;
        Canvas canvas;
        Object obj1;
        if (isUsingHeightAsRef)
        {
            f = (float)(j / ((DisplayMetrics) (obj)).heightPixels) * f1;
        } else
        {
            f *= f1;
        }
        obj = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(((Bitmap) (obj)));
        canvas.scale(f, f);
        _backgroundImageView.draw(canvas);
        renderScrollViews(canvas);
        _decorateInfosLayer.drawLayer(canvas);
        _foregroundImageView.draw(canvas);
        return ((Bitmap) (obj));
        obj1;
        obj = null;
_L4:
        Crashlytics.logException(((Throwable) (obj1)));
        return ((Bitmap) (obj));
        obj1;
        obj = null;
_L2:
        Crashlytics.logException(((Throwable) (obj1)));
        return ((Bitmap) (obj));
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void maskScrollViewClicked(View view)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" maskScrollViewClicked:").toString());
        if (mfilterFrameLayout != null)
        {
            scaleMaskView((TMaskScrollImageView)view);
            mfilterFrameLayout.setVisibility(0);
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)mActionBarLayout.getLayoutParams();
            int j = layoutparams1.leftMargin;
            int i = layoutparams1.topMargin;
            int j1 = layoutparams1.width;
            int k = layoutparams1.height;
            int k1 = layoutparams.width;
            int l = layoutparams.height;
            int i1 = _composeFrameLayout.getHeight();
            int l1 = _composeFrameLayout.getWidth();
            if (j1 / 2 + j < k1 / 2)
            {
                if (i + k + l > i1)
                {
                    float f;
                    float f1;
                    DisplayMetrics displaymetrics;
                    if (i > l)
                    {
                        i -= l;
                    } else
                    {
                        i = i1 - l;
                    }
                    j = 0;
                } else
                {
                    i = k + i;
                    j = 0;
                }
            } else
            if (l1 - (j1 / 2 + j) < k1 / 2)
            {
                if (i + k + l > i1)
                {
                    j = l1 - k1;
                    if (i > l)
                    {
                        i -= l;
                    } else
                    {
                        i = i1 - l;
                    }
                } else
                {
                    j = l1 - k1;
                    i = k + i;
                }
            } else
            if (i + k + l > i1)
            {
                j = (j1 / 2 + j) - k1 / 2;
                if (i > l)
                {
                    i -= l;
                } else
                {
                    i = i1 - l;
                }
            } else
            {
                j = (j + j1 / 2) - k1 / 2;
                i = k + i;
            }
            displaymetrics = getResources().getDisplayMetrics();
            f = displaymetrics.widthPixels;
            f1 = displaymetrics.heightPixels;
            layoutparams.setMargins(j + (int)((f - (float)_composeFrameLayout.getWidth()) / 2.0F), i + (int)((f1 - (float)_composeFrameLayout.getHeight()) / 2.0F), 0, 0);
            mActionBarLayout.setLayoutParams(layoutparams);
            mActionBarLayout.setVisibility(0);
        }
        if (view instanceof TMaskScrollImageView)
        {
            mCurSelectedMaskView = (TMaskScrollImageView)view;
        }
    }

    private void processFilterImages()
    {
        for (int i = 0; i < _scrollViewArray.size(); i++)
        {
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)_scrollViewArray.get(i);
            if (tmaskscrollimageview.getMaskInfo() == null)
            {
                continue;
            }
            Object obj = tmaskscrollimageview.getMaskInfo();
            if (((TPhotoMaskInfo) (obj)).isPIP)
            {
                obj = bku.c(mActivity, ((TPhotoMaskInfo) (obj)).backFilterName);
                Log.v(TAG, (new StringBuilder()).append(TAG).append("backfilter:").append(((String) (obj))).toString());
                tmaskscrollimageview.processBackgroundGaussianCenterView(mSurfaceView, tmaskscrollimageview.getCenterBitmap(), ((String) (obj)), true);
            }
        }

    }

    private void recordUserInputInfo(String s, int i)
    {
        if (i != 5 && i != 10 && i != 9 || s == null || s.length() <= 0) goto _L2; else goto _L1
_L1:
        if (curPlacemark == null)
        {
            curPlacemark = new aou();
        }
        if (i != 5) goto _L4; else goto _L3
_L3:
        curPlacemark.a = s;
_L2:
        return;
_L4:
        if (i != 10)
        {
            continue; /* Loop/switch isn't completed */
        }
        curPlacemark.c = s;
        if (_decorateInfosLayer != null)
        {
            s = _decorateInfosLayer.getPlaceCity();
            if (s != null && s.length() > 0)
            {
                curPlacemark.a = String.format("%s,%s", new Object[] {
                    s, curPlacemark.c
                });
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (i != 9) goto _L2; else goto _L5
_L5:
        curPlacemark.b = s;
        if (_decorateInfosLayer != null)
        {
            s = _decorateInfosLayer.getPlaceCountry();
            if (s != null && s.length() > 0)
            {
                curPlacemark.a = String.format("%s,%s", new Object[] {
                    curPlacemark.b, s
                });
                return;
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    private boolean rectIsEqual(Rect rect, Rect rect1)
    {
        while (rect == null || rect1 == null || rect.left != rect1.left || rect.top != rect1.top || rect.bottom != rect1.bottom || rect.right != rect1.right) 
        {
            return false;
        }
        return true;
    }

    private void relayoutTextEditorBar()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)_textEditorBar.getLayoutParams();
        if (TPhotoComposeInfo.getInstaMagType(mActivity.d()) == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            layoutparams.bottomMargin = axw.a(mActivity, 50F);
        } else
        {
            layoutparams.bottomMargin = axw.a(mActivity, 75F);
        }
        _textEditorBar.requestLayout();
    }

    private void renderScrollViews(Canvas canvas)
    {
        for (Iterator iterator = _scrollViewArray.iterator(); iterator.hasNext(); canvas.restore())
        {
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)iterator.next();
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)tmaskscrollimageview.getLayoutParams();
            canvas.translate(layoutparams.leftMargin, layoutparams.topMargin);
            tmaskscrollimageview.renderInCanvas(canvas);
        }

    }

    private apa requestGeometryByImageUris()
    {
        double d;
        double d1;
        apa apa1;
        List list;
        int i;
        apa1 = new apa();
        Log.v(TAG, (new StringBuilder()).append(TAG).append("requestGeometryByImageUris beggin ").toString());
        if (mActivity == null)
        {
            break MISSING_BLOCK_LABEL_404;
        }
        list = mActivity.e();
        i = 0;
        d = 0.0D;
        d1 = 0.0D;
_L6:
        double d2;
        double d3;
        d2 = d;
        d3 = d1;
        if (i >= list.size()) goto _L2; else goto _L1
_L1:
        Uri uri;
        uri = Uri.parse((String)list.get(i));
        d2 = d;
        d3 = d1;
        HashMap hashmap = aan.a(getActivity(), uri);
        d2 = d;
        d3 = d1;
        dateTime = (String)hashmap.get("TAG_DATETIME");
        d2 = d;
        d3 = d1;
        d1 = Float.parseFloat((String)hashmap.get("TAG_GPS_LATITUDE"));
        d2 = d;
        d3 = d1;
        d = Float.parseFloat((String)hashmap.get("TAG_GPS_LONGITUDE"));
        d2 = d;
        d3 = d1;
        Log.v(TAG, (new StringBuilder()).append(TAG).append("requestGeometryByImageUris ").append("DAte Time :").append(dateTime).append(" selectedImageUri:").append(uri).toString());
        d2 = d;
        d3 = d1;
        Log.v(TAG, (new StringBuilder()).append(TAG).append("requestGeometryByImageUris ").append(" selectedImageUri:").append(uri).append("lat :").append(d1).append(" long:").append(d).toString());
        d2 = d;
        d3 = d1;
        if (d1 != 0.0D) goto _L2; else goto _L3
_L3:
        d2 = d;
        d3 = d1;
        if (d == 0.0D) goto _L5; else goto _L4
_L4:
        d3 = d1;
        d2 = d;
_L2:
        Log.v(TAG, (new StringBuilder()).append(TAG).append("requestGeometryByImageUris end ").toString());
        apa1.a(d3);
        apa1.b(d2);
        return apa1;
        Exception exception;
        exception;
_L5:
        i++;
        d = d2;
        d1 = d3;
          goto _L6
        d2 = 0.0D;
        d3 = 0.0D;
          goto _L2
    }

    private void requestLocationByGeometry(apa apa1)
    {
        ant ant1 = anq.a(this);
        if (ant1 != null)
        {
            ant1.a(InstaBeautyApplication.a, apa1);
            return;
        } else
        {
            requestLocationByGeometryFromGoogle(apa1);
            return;
        }
    }

    private void requestLocationByGeometryFromGoogle(apa apa1)
    {
        if (apa1.a() == 0.0D)
        {
            return;
        } else
        {
            aov aov1 = new aov(mActivity, new baf(this));
            aos aos1 = new aos();
            Object obj = Locale.getDefault();
            String s = ((Locale) (obj)).getLanguage();
            obj = ((Locale) (obj)).getCountry();
            Log.v(TAG, (new StringBuilder()).append(TAG).append("langcode:").append(s).append(" countryCode:").append(((String) (obj))).toString());
            aos1.a(aoy.a());
            aov1.a(aos1);
            aov1.a(apa1.a(), apa1.b());
            return;
        }
    }

    private void requestWeatherByGeometry(apa apa1)
    {
        while (apa1.a() == 0.0D || apa1.a() == 0.0D) 
        {
            return;
        }
        getWeatherManager().a(apa1.a(), apa1.b());
    }

    private void reverBackgroundAndForeground(FlipViewType flipviewtype)
    {
        boolean flag = false;
        int i;
        if (_backgroundImageView.getDrawable() != null)
        {
            Bitmap bitmap = ((BitmapDrawable)_backgroundImageView.getDrawable()).getBitmap();
            if (bitmap != null)
            {
                Bitmap bitmap1;
                if (flipviewtype == FlipViewType.FLIP_HORIZONTAL)
                {
                    i = 0;
                } else
                {
                    i = 1;
                }
                bitmap1 = reverseBitmap(bitmap, i);
                if (bitmap1 != bitmap && !bitmap.isRecycled())
                {
                    Log.v(TAG, (new StringBuilder()).append(TAG).append("reverBackgroundAndForeground recycle bgBitmap").toString());
                    bitmap.recycle();
                }
                _backgroundImageView.setImageBitmap(bitmap1);
            }
        }
        if (_foregroundImageView.getDrawable() != null)
        {
            bitmap = ((BitmapDrawable)_foregroundImageView.getDrawable()).getBitmap();
            if (bitmap != null)
            {
                if (flipviewtype == FlipViewType.FLIP_HORIZONTAL)
                {
                    i = ((flag) ? 1 : 0);
                } else
                {
                    i = 1;
                }
                flipviewtype = reverseBitmap(bitmap, i);
                if (flipviewtype != bitmap && !bitmap.isRecycled())
                {
                    Log.v(TAG, (new StringBuilder()).append(TAG).append("reverBackgroundAndForeground recycle foreBitmap").toString());
                    bitmap.recycle();
                }
                _foregroundImageView.setImageBitmap(flipviewtype);
            }
        }
    }

    private Bitmap reverseBitmap(Bitmap bitmap, int i)
    {
        Object obj = null;
        i;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 110
    //                   1 161;
           goto _L1 _L2 _L3
_L1:
        float af[] = null;
_L5:
        if (af != null)
        {
            obj = new Matrix();
            ((Matrix) (obj)).setValues(af);
            Log.v(TAG, (new StringBuilder()).append(TAG).append("matrix isIndesity: ").append(((Matrix) (obj)).isIdentity()).toString());
            obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        }
        return ((Bitmap) (obj));
_L2:
        af = new float[9];
        af;
        af[0] = -1F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = 0.0F;
        af[4] = 1.0F;
        af[5] = 0.0F;
        af[6] = 0.0F;
        af[7] = 0.0F;
        af[8] = 1.0F;
        continue; /* Loop/switch isn't completed */
_L3:
        af = new float[9];
        af;
        af[0] = 1.0F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = 0.0F;
        af[4] = -1F;
        af[5] = 0.0F;
        af[6] = 0.0F;
        af[7] = 0.0F;
        af[8] = 1.0F;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void setAllImageViewsScroolEnable(boolean flag)
    {
        for (int i = 0; i < _scrollViewArray.size(); i++)
        {
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)_scrollViewArray.get(i);
            if (tmaskscrollimageview != null)
            {
                tmaskscrollimageview.setImageTouchViewScrollEnabled(flag);
            }
        }

    }

    private void setChangePositionAlert()
    {
        if (getActivity() != null && !isShowLongPressHelp)
        {
            Object obj = getActivity().getSharedPreferences("config", 0);
            int i = ((SharedPreferences) (obj)).getInt("change_positonhelp_number", 0);
            if (i < 2)
            {
                obj = ((SharedPreferences) (obj)).edit();
                ((android.content.SharedPreferences.Editor) (obj)).putInt("change_positonhelp_number", i + 1);
                ((android.content.SharedPreferences.Editor) (obj)).commit();
                obj = new android.app.AlertDialog.Builder(getActivity());
                ((android.app.AlertDialog.Builder) (obj)).setTitle(getResources().getString(0x7f0602ae));
                ((android.app.AlertDialog.Builder) (obj)).setMessage(getResources().getString(0x7f0600af));
                ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(getResources().getString(0x7f060055), new bae(this));
                ((android.app.AlertDialog.Builder) (obj)).show();
                isShowLongPressHelp = true;
            }
        }
    }

    private void setDecorateTextEidtHelpViewParameters()
    {
        if (_layoutInfoes == null || _layoutInfoes.size() <= 0) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        arraylist = new ArrayList(_layoutInfoes.size());
        for (int i = 0; i < _layoutInfoes.size(); i++)
        {
            bfg bfg1 = (bfg)_layoutInfoes.get(i);
            if (bfg1.r && bfg1.A)
            {
                Rect rect = new Rect();
                TPhotoComposeInfo.getScaledRect(bfg1.h).round(rect);
                arraylist.add(rect);
            }
        }

        if (editHelpView == null) goto _L4; else goto _L3
_L3:
        if (arraylist.size() <= 0) goto _L6; else goto _L5
_L5:
        editHelpView.setTargetRects(arraylist);
_L4:
        return;
_L6:
        editHelpView.setTargetRects(null);
        return;
_L2:
        if (editHelpView != null)
        {
            editHelpView.setTargetRects(null);
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    private void setupOpenGLView(View view)
    {
        mSurfaceView = (ImageGLSurfaceView)view.findViewById(0x7f0d0256);
        mSurfaceView.getHolder().addCallback(this);
    }

    private void showEditHelpView()
    {
        if (editHelpView != null)
        {
            setDecorateTextEidtHelpViewParameters();
            editHelpView.setVisibility(0);
            editHelpViewfadeanimation(editHelpView);
        }
    }

    private void updateDecorateLocationByUserPlaceMark(aou aou1)
    {
        while (aou1 == null || _decorateInfosLayer == null) 
        {
            return;
        }
        _decorateInfosLayer.setLocationTextByTTCLPlacemark(aou1);
    }

    private void updateTMaskViewByBitmap(TMaskScrollImageView tmaskscrollimageview, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        }
        if (tmaskscrollimageview.getMaskInfo() != null)
        {
            Object obj = tmaskscrollimageview.getMaskInfo();
            if (((TPhotoMaskInfo) (obj)).filterName != null && ((TPhotoMaskInfo) (obj)).filterName.length() > 0)
            {
                Log.v(TAG, (new StringBuilder()).append(TAG).append(" filterNem : ").append(((TPhotoMaskInfo) (obj)).filterName).toString());
                String s = ((TPhotoMaskInfo) (obj)).filterName;
                obj = s;
                if (s.equalsIgnoreCase("B&W"))
                {
                    obj = "BW";
                }
                obj = bku.c(mActivity, ((String) (obj)));
                if (existFilterName(((String) (obj))))
                {
                    mSurfaceView.fastProcessImage(bitmap, ((String) (obj)), new baq(this, tmaskscrollimageview));
                    return;
                } else
                {
                    tmaskscrollimageview.updateCenterViewImage(bitmap);
                    return;
                }
            } else
            {
                tmaskscrollimageview.updateCenterViewImage(bitmap);
                return;
            }
        } else
        {
            tmaskscrollimageview.updateCenterViewImage(bitmap);
            return;
        }
    }

    public void DidProcessed(ArrayList arraylist, int i)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" DidProcessed").toString());
        if (mActivity != null && isAdded())
        {
            mActivity.b();
        }
        if (arraylist.size() > 0)
        {
            if (1000 == i)
            {
                mActivity.a(arraylist);
            }
            generateComposeView();
            geometry = requestGeometryByImageUris();
            if (geometry.a() == 0.0D && InstaBeautyApplication.d != null && InstaBeautyApplication.d.a() != 0.0D)
            {
                geometry.a(InstaBeautyApplication.d.a());
                geometry.b(InstaBeautyApplication.d.b());
            }
            if (haveLocation || haveWeather)
            {
                if (haveLocation)
                {
                    requestLocationByGeometry(geometry);
                }
                if (haveWeather)
                {
                    requestWeatherByGeometry(geometry);
                }
            }
            if (haveTime)
            {
                handleDateTime();
            }
            Log.v(TAG, (new StringBuilder()).append(TAG).append(" DidProcessed openGlCreated : ").append(openGlCreated).toString());
            if (openGlCreated)
            {
                processFilterImages();
                Log.v(TAG, (new StringBuilder()).append(TAG).append(" filter process end").toString());
            }
            if (arraylist.size() > 1)
            {
                setChangePositionAlert();
            }
            arraylist = mActivity.getSharedPreferences("config", 0);
            if (!arraylist.getBoolean("isShowStyleHelp", false))
            {
                arraylist = arraylist.edit();
                arraylist.putBoolean("isShowStyleHelp", true);
                arraylist.commit();
                mActivity.h();
            }
        }
    }

    public void ImageMovingTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 37
    //                   1 132
    //                   2 54;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        lastX = motionevent.getX();
        lastY = motionevent.getY();
        return;
_L4:
        if (movingView.getVisibility() != 4 && movingView != null)
        {
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            int i = (int)(motionevent.getX() + mergeX);
            int j = (int)(motionevent.getY() + mergeY);
            movingView.movePosition((int)(f - lastX), (int)(f1 - lastY), i, j);
            return;
        }
          goto _L1
_L3:
        changeImageByMovingView();
        return;
    }

    public void MaskInfoScrollViewClicked(TMaskScrollImageView tmaskscrollimageview)
    {
        if (tmaskscrollimageview != null)
        {
            maskScrollViewClicked(tmaskscrollimageview);
        }
    }

    public void ProcessFailed(int i)
    {
        if (mActivity != null && isAdded())
        {
            mActivity.b();
        }
    }

    public void StartProcessing(int i)
    {
        if (mActivity != null)
        {
            mActivity.a(getResources().getString(0x7f0601c6));
        }
    }

    public void animation(View view, boolean flag)
    {
        if (flag)
        {
            view.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f040027));
            view.setVisibility(0);
            return;
        } else
        {
            view.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f040028));
            view.setVisibility(4);
            return;
        }
    }

    public boolean checkConnection(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnectedOrConnecting();
    }

    public void clearImagesViews()
    {
        Iterator iterator = _scrollViewArray.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)iterator.next();
            if (tmaskscrollimageview != null && tmaskscrollimageview.getCenterView() != null)
            {
                tmaskscrollimageview.getCenterView().setImageBitmap(null);
            }
        } while (true);
        if (_composeFrameLayout != null)
        {
            _composeFrameLayout.removeAllViewsInLayout();
        }
    }

    public void cropSelecteImags()
    {
        ArrayList arraylist = new ArrayList();
        if (mActivity != null)
        {
            List list = mActivity.e();
            if (list == null)
            {
                return;
            }
            for (int i = 0; i < list.size(); i++)
            {
                arraylist.add(Uri.parse((String)list.get(i)));
            }

        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append("crop item size:").append(arraylist.size()).toString());
        cropImagsTask = new bjd();
        cropImagsTask.a(arraylist);
        KMaxPix = getCropMaxPix();
        if (InstaBeautyApplication.b && arraylist.size() > 3 || arraylist.size() >= 5)
        {
            KMaxPix = 410;
        }
        if ((float)getResources().getDisplayMetrics().widthPixels > 960F || InstaBeautyApplication.h >= 64)
        {
            if (arraylist.size() < 5)
            {
                KMaxPix = 1080;
            } else
            {
                KMaxPix = 960;
            }
        }
        if (!InstaBeautyApplication.b && arraylist.size() == 1)
        {
            KMaxPix = 1280;
        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" KMaxPix :").append(KMaxPix).toString());
        cropImagsTask.b(KMaxPix);
        cropImagsTask.a(this);
        cropImagsTask.a(1000);
        cropImagsTask.d(new ArrayList[0]);
    }

    public void editHelpViewfadeanimation(View view)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setStartOffset(1000L);
        alphaanimation.setDuration(1000L);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(alphaanimation);
        animationset.setRepeatCount(0);
        animationset.setFillEnabled(true);
        animationset.setFillAfter(false);
        animationset.setAnimationListener(new bao(this, view));
        view.startAnimation(animationset);
    }

    public void flipInfo()
    {
        TPhotoComposeInfo tphotocomposeinfo = mActivity.d();
        if (!tphotocomposeinfo.isHFlip || !tphotocomposeinfo.isVFlip) goto _L2; else goto _L1
_L1:
        Object obj;
        android.widget.FrameLayout.LayoutParams layoutparams;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if (flipOrientation == FlipViewType.FLIP_NORMAL)
        {
            obj = FlipViewType.FLIP_HORIZONTAL;
        } else
        if (flipOrientation == FlipViewType.FLIP_HORIZONTAL)
        {
            obj = FlipViewType.FLIP_HORIZONTAL_AND_VERTICAL;
        } else
        if (flipOrientation == FlipViewType.FLIP_HORIZONTAL_AND_VERTICAL)
        {
            obj = FlipViewType.FLIP_VERTICAL;
        } else
        {
            obj = FlipViewType.FLIP_NORMAL;
        }
_L22:
        flipOrientation = ((FlipViewType) (obj));
_L10:
        j1 = _composeFrameLayout.getWidth();
        k1 = _composeFrameLayout.getHeight();
        k = _scrollViewArray.size() - 1;
_L9:
        if (k < 0) goto _L4; else goto _L3
_L3:
        obj = (TMaskScrollImageView)_scrollViewArray.get(k);
        layoutparams = (android.widget.FrameLayout.LayoutParams)((TMaskScrollImageView) (obj)).getLayoutParams();
        l = layoutparams.leftMargin;
        i1 = layoutparams.topMargin;
        i = layoutparams.width;
        l1 = layoutparams.height;
        if (!tphotocomposeinfo.isHFlip || !tphotocomposeinfo.isVFlip) goto _L6; else goto _L5
_L5:
        if (flipOrientation != FlipViewType.FLIP_HORIZONTAL && flipOrientation != FlipViewType.FLIP_VERTICAL) goto _L8; else goto _L7
_L7:
        j = j1 - i - l;
        i = i1;
_L13:
        layoutparams.setMargins(j, i, 0, 0);
        ((TMaskScrollImageView) (obj)).setLayoutParams(layoutparams);
        k--;
          goto _L9
_L2:
        if (tphotocomposeinfo.isHFlip)
        {
            FlipViewType flipviewtype;
            if (flipOrientation == FlipViewType.FLIP_NORMAL)
            {
                flipviewtype = FlipViewType.FLIP_HORIZONTAL;
            } else
            {
                flipviewtype = FlipViewType.FLIP_NORMAL;
            }
            flipOrientation = flipviewtype;
        } else
        if (tphotocomposeinfo.isVFlip)
        {
            FlipViewType flipviewtype1;
            if (flipOrientation == FlipViewType.FLIP_NORMAL)
            {
                flipviewtype1 = FlipViewType.FLIP_VERTICAL;
            } else
            {
                flipviewtype1 = FlipViewType.FLIP_NORMAL;
            }
            flipOrientation = flipviewtype1;
        }
          goto _L10
_L8:
        if (flipOrientation == FlipViewType.FLIP_NORMAL) goto _L12; else goto _L11
_L11:
        i = i1;
        j = l;
        if (flipOrientation != FlipViewType.FLIP_HORIZONTAL_AND_VERTICAL) goto _L13; else goto _L12
_L12:
        i = k1 - l1 - i1;
        j = l;
          goto _L13
_L6:
        if (tphotocomposeinfo.isHFlip)
        {
            j = j1 - i - l;
            i = i1;
        } else
        {
            i = i1;
            j = l;
            if (tphotocomposeinfo.isVFlip)
            {
                i = k1 - l1 - i1;
                j = l;
            }
        }
          goto _L13
_L4:
        Log.d(TAG, (new StringBuilder()).append(TAG).append(" _decorateInfosLayer flipOrientation type:").append(flipOrientation).toString());
        if (!tphotocomposeinfo.isHFlip || !tphotocomposeinfo.isVFlip) goto _L15; else goto _L14
_L14:
        if (flipOrientation != FlipViewType.FLIP_HORIZONTAL && flipOrientation != FlipViewType.FLIP_VERTICAL) goto _L17; else goto _L16
_L16:
        if (_decorateInfosLayer != null)
        {
            _decorateInfosLayer.setLayerFlipType(FlipViewType.FLIP_HORIZONTAL);
        }
        reverBackgroundAndForeground(FlipViewType.FLIP_HORIZONTAL);
_L19:
        return;
_L17:
        if (flipOrientation != FlipViewType.FLIP_NORMAL && flipOrientation != FlipViewType.FLIP_HORIZONTAL_AND_VERTICAL) goto _L19; else goto _L18
_L18:
        _decorateInfosLayer.setLayerFlipType(FlipViewType.FLIP_VERTICAL);
        reverBackgroundAndForeground(FlipViewType.FLIP_VERTICAL);
        return;
_L15:
        if (tphotocomposeinfo.isHFlip)
        {
            _decorateInfosLayer.setLayerFlipType(FlipViewType.FLIP_HORIZONTAL);
            reverBackgroundAndForeground(FlipViewType.FLIP_HORIZONTAL);
            return;
        }
        if (!tphotocomposeinfo.isVFlip) goto _L19; else goto _L20
_L20:
        _decorateInfosLayer.setLayerFlipType(FlipViewType.FLIP_VERTICAL);
        reverBackgroundAndForeground(FlipViewType.FLIP_VERTICAL);
        return;
        if (true) goto _L22; else goto _L21
_L21:
    }

    public void generateComposeView()
    {
        TPhotoComposeInfo tphotocomposeinfo;
        Object obj;
        boolean flag;
label0:
        {
            flag = false;
            Log.v(TAG, (new StringBuilder()).append(TAG).append(" generateComposeView").toString());
            if (mActivity != null && mActivity.d() != null)
            {
                tphotocomposeinfo = mActivity.d();
                _backgroundImageView.setBackgroundColor(tphotocomposeinfo.backgroundColor);
                if (tphotocomposeinfo.backgoundImagePath != null && tphotocomposeinfo.backgoundImagePath.length() > 0)
                {
                    try
                    {
                        _backgroundImageView.setImageBitmap(tphotocomposeinfo.getBitmapByPath(tphotocomposeinfo.backgoundImagePath));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((Exception) (obj)).printStackTrace();
                        Crashlytics.logException(((Throwable) (obj)));
                    }
                }
                obj = mActivity.f();
                if (obj != null)
                {
                    break label0;
                }
            }
            return;
        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append("imageBitmaps size :").append(((ArrayList) (obj)).size()).toString());
        for (int i = 0; i < ((ArrayList) (obj)).size(); i++)
        {
            Object obj2 = (Bitmap)((ArrayList) (obj)).get(i);
            if (tphotocomposeinfo.photoMaskInfoArray != null && i < tphotocomposeinfo.photoMaskInfoArray.size())
            {
                TPhotoMaskInfo tphotomaskinfo = (TPhotoMaskInfo)tphotocomposeinfo.photoMaskInfoArray.get(i);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(Math.round(TPhotoComposeInfo.getScaledValue(tphotomaskinfo.backgroundFrame.width())), Math.round(TPhotoComposeInfo.getScaledValue(tphotomaskinfo.backgroundFrame.height())));
                layoutparams.setMargins(Math.round(TPhotoComposeInfo.getScaledValue(tphotomaskinfo.backgroundFrame.left)), Math.round(TPhotoComposeInfo.getScaledValue(tphotomaskinfo.backgroundFrame.top)), 0, 0);
                layoutparams.gravity = 51;
                obj2 = new TMaskScrollImageView(mActivity, tphotomaskinfo, ((Bitmap) (obj2)));
                _scrollViewContainer.addView(((View) (obj2)), layoutparams);
                _scrollViewArray.add(obj2);
                ((TMaskScrollImageView) (obj2)).setLongClickDelegate(this);
                ((TMaskScrollImageView) (obj2)).setImageMovingDelegate(this);
                ((TMaskScrollImageView) (obj2)).setMaskDelegate(this);
                ((TMaskScrollImageView) (obj2)).setTag(Integer.valueOf(i));
            }
        }

        _layoutInfoes.clear();
        _gifLayoutInfoes.clear();
        if (tphotocomposeinfo.decorateInfoArray != null)
        {
            for (int j = ((flag) ? 1 : 0); j < tphotocomposeinfo.decorateInfoArray.size(); j++)
            {
                Object obj1 = (TDecorateInfo)tphotocomposeinfo.decorateInfoArray.get(j);
                if (((TDecorateInfo) (obj1)).isLocation())
                {
                    haveLocation = true;
                }
                if (((TDecorateInfo) (obj1)).isTime())
                {
                    haveTime = true;
                }
                if (((TDecorateInfo) (obj1)).isWeather())
                {
                    haveWeather = true;
                }
                obj1 = infoWithStyleInfo(((TDecorateInfo) (obj1)), j);
                _layoutInfoes.add(obj1);
            }

        }
        _decorateInfosLayer.configByInfos(_layoutInfoes);
        _foregroundImageView.setBackgroundColor(tphotocomposeinfo.foregroundColor);
        if (tphotocomposeinfo.foregroundImagePath != null && tphotocomposeinfo.foregroundImagePath.length() > 0)
        {
            try
            {
                _foregroundImageView.setImageBitmap(tphotocomposeinfo.getBitmapByPath(tphotocomposeinfo.foregroundImagePath));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                Crashlytics.logException(exception);
            }
        }
        showEditHelpView();
    }

    public FrameLayout getMainComposeLayout()
    {
        return _composeFrameLayout;
    }

    public void goNext()
    {
        if (mfilterFrameLayout != null)
        {
            mfilterFrameLayout.setVisibility(4);
        }
        if (mActivity.d() != null)
        {
            FotoCustomReport.addStringToArray(FotoCustomReport.userSavedFunction, "instamag");
        }
        mActivity.a(mActivity.getResources().getString(0x7f0601c6));
        TPhotoComposeInfo tphotocomposeinfo = mActivity.d();
        mActivity.c().updateUseCountByResId(tphotocomposeinfo.resId, tphotocomposeinfo.useCount + 1);
        Object obj = (new Gson()).toJson(tphotocomposeinfo);
        android.content.SharedPreferences.Editor editor = getActivity().getSharedPreferences("saveAndShareInfo", 0).edit();
        editor.putString("gsonString", ((String) (obj)));
        editor.commit();
        obj = getOptimizedPhotoSize(tphotocomposeinfo);
        int i = (int)((bep) (obj)).a;
        int j = (int)((bep) (obj)).b;
        Log.v(TAG, (new StringBuilder()).append(TAG).append("makeResultImage before").toString());
        obj = makeResultImage(i, j);
        if (obj == null)
        {
            mActivity.b();
        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append("makeResultImage end").toString());
        if (mActivity != null)
        {
            mActivity.a(getResources().getString(0x7f0601c6));
        }
        (new Thread(new bal(this, ((Bitmap) (obj)), tphotocomposeinfo))).start();
    }

    public void hideFilterListView()
    {
        if (mfilterFrameLayout != null)
        {
            mfilterFrameLayout.setVisibility(4);
        }
    }

    public void hideSoftKeyborad(View view)
    {
        if (view != null)
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public bfg infoWithStyleInfo(TDecorateInfo tdecorateinfo, int i)
    {
        if (tdecorateinfo == null)
        {
            return null;
        }
        bfg bfg1 = new bfg();
        Matrix matrix = new Matrix();
        float f2 = (float)((double)(tdecorateinfo.rotation * 180F) / 3.1415926535897931D);
        if (tdecorateinfo.frame == null)
        {
            tdecorateinfo.frame = new RectF(0.0F, 0.0F, 1.0F, 1.0F);
        }
        float f;
        float f1;
        int j;
        if (tdecorateinfo.frame != null && f2 != 0.0F)
        {
            f = tdecorateinfo.frame.width() / 2.0F;
            f1 = TPhotoComposeInfo.scale * f;
            f = (tdecorateinfo.frame.height() / 2.0F) * TPhotoComposeInfo.scale;
        } else
        {
            f = 0.0F;
            f1 = 0.0F;
        }
        matrix.postRotate(f2, f1, f);
        bfg1.n = matrix;
        if (tdecorateinfo.imagePath != null && tdecorateinfo.imagePath.length() > 0)
        {
            bfg1.a = tdecorateinfo.getBitmapByPath(tdecorateinfo.imagePath);
        }
        bfg1.h = tdecorateinfo.frame;
        bfg1.g = new RectF(0.0F, 0.0F, tdecorateinfo.frame.width(), tdecorateinfo.frame.height());
        bfg1.d = 0x106000d;
        bfg1.e = 0.0F;
        bfg1.f = 0.0F;
        bfg1.C = tdecorateinfo.backgroundAlpha;
        bfg1.c = tdecorateinfo.backgroundColor;
        bfg1.b = null;
        bfg1.o = false;
        bfg1.p = true;
        bfg1.r = tdecorateinfo.isText();
        bfg1.q = tdecorateinfo.type;
        bfg1.s = true;
        bfg1.t = tdecorateinfo.isBold;
        bfg1.u = tdecorateinfo.fontSize;
        bfg1.w = tdecorateinfo.fontMaxCount;
        bfg1.x = tdecorateinfo.text;
        bfg1.v = tdecorateinfo.fontFamily;
        bfg1.y = tdecorateinfo.textColor;
        bfg1.B = tdecorateinfo.isShadow;
        bfg1.F = tdecorateinfo.textAlignment;
        bfg1.D = tdecorateinfo.isOutline;
        bfg1.E = tdecorateinfo.isItalic;
        bfg1.G = tdecorateinfo.lines;
        bfg1.H = tdecorateinfo.letterSpace;
        bfg1.z = tdecorateinfo.movable;
        bfg1.A = tdecorateinfo.editable;
        j = tdecorateinfo.fontMaxCount;
        if (tdecorateinfo.text != null)
        {
            i = tdecorateinfo.text.length();
        } else
        {
            i = 0;
        }
        bfg1.I = Math.max(j, i);
        return bfg1;
    }

    public void movingPosition(int i, int j)
    {
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        j;
        JVM INSTR tableswitch -1 -1: default 20
    //                   -1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if ((intent = BitmapFactory.decodeFile(intent.getStringExtra("FotoBeautyActivity_ReturnImageUri").substring(6))) != null)
        {
            try
            {
                mCurSelectedMaskView.updateCenterViewImageWithSameScale(intent);
                i = ((Integer)mCurSelectedMaskView.getTag()).intValue();
                if (i < mActivity.f().size())
                {
                    mActivity.f().set(i, intent);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Crashlytics.logException(intent);
                intent.printStackTrace();
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mActivity = (MagComposeActivity)activity;
        Log.d(TAG, (new StringBuilder()).append(TAG).append(": ").append("onAttach").toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" onCreateView ").toString());
        layoutinflater = layoutinflater.inflate(0x7f030073, viewgroup, false);
        mContainer = layoutinflater.findViewById(0x7f0d0157);
        mActionBarLayout = (FrameLayout)layoutinflater.findViewById(0x7f0d025d);
        mbeautyEditButton = (ImageButton)layoutinflater.findViewById(0x7f0d025e);
        mbeautyEditButton.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        mbeautyEditButton.setOnClickListener(new bag(this));
        mhandler = new bai(this);
        mfilterFrameLayout = (FrameLayout)layoutinflater.findViewById(0x7f0d0206);
        mfilterFrameLayout.setOnTouchListener(new baj(this));
        movingView = (ImagesMovingView)layoutinflater.findViewById(0x7f0d024a);
        _backgroundImageView = (ImageView)layoutinflater.findViewById(0x7f0d0258);
        _scrollViewContainer = (FrameLayout)layoutinflater.findViewById(0x7f0d0259);
        _foregroundImageView = (ImageView)layoutinflater.findViewById(0x7f0d025a);
        _composeFrameLayout = (FrameLayout)layoutinflater.findViewById(0x7f0d0257);
        _textEditorBar = (RelativeLayout)layoutinflater.findViewById(0x7f0d025b);
        _textEditor = (EditText)layoutinflater.findViewById(0x7f0d0167);
        getActivity().getWindow().setSoftInputMode(0);
        ((Button)layoutinflater.findViewById(0x7f0d025c)).setOnClickListener(new bak(this));
        bundle = getResources().getDisplayMetrics();
        float f1 = ((DisplayMetrics) (bundle)).widthPixels;
        float f2 = (float)((DisplayMetrics) (bundle)).widthPixels / (float)((DisplayMetrics) (bundle)).heightPixels;
        float f3 = mActivity.d().width / mActivity.d().height;
        float f = f1 / mActivity.d().width;
        modifyScale = 1.0F;
        InstaMagType instamagtype = TPhotoComposeInfo.getInstaMagType(mActivity.d());
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            modifyScale = computeModifyScale();
        } else
        if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            modifyScale = 0.9F;
        }
        f *= modifyScale;
        TPhotoComposeInfo.scale = f;
        if (f2 > f3)
        {
            Log.v(TAG, "Using height as scale referance");
            f = ((float)((DisplayMetrics) (bundle)).heightPixels / mActivity.d().height) * modifyScale;
            TPhotoComposeInfo.scale = f;
            isUsingHeightAsRef = true;
        }
        viewgroup = (android.widget.FrameLayout.LayoutParams)_composeFrameLayout.getLayoutParams();
        viewgroup.width = (int)(f1 * modifyScale);
        viewgroup.height = (int)(mActivity.d().height * f);
        if (isUsingHeightAsRef)
        {
            viewgroup.width = (int)(f * mActivity.d().width);
            viewgroup.height = (int)((float)((DisplayMetrics) (bundle)).heightPixels * modifyScale);
        }
        if (instamagtype != InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            viewgroup.topMargin = -axw.a(mActivity, 20F);
        }
        _composeFrameLayout.setLayoutParams(viewgroup);
        bundle = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (viewgroup)).width, ((android.widget.FrameLayout.LayoutParams) (viewgroup)).height);
        _decorateInfosLayer = new TDecorateInfosLayerView(getActivity());
        bundle.gravity = 51;
        _composeFrameLayout.addView(_decorateInfosLayer, 2, bundle);
        _decorateInfosLayer.setTextClickListener(this);
        viewgroup = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (viewgroup)).width, ((android.widget.FrameLayout.LayoutParams) (viewgroup)).height);
        editHelpView = new TDecorateInfosLayerTextHelpView(getActivity());
        editHelpView.setClickable(false);
        editHelpView.setFocusable(false);
        editHelpView.setEnabled(false);
        editHelpView.setVisibility(4);
        _composeFrameLayout.addView(editHelpView, 3, viewgroup);
        if (mActivity.f() == null)
        {
            cropSelecteImags();
        } else
        {
            reloadNewInfo();
        }
        setupOpenGLView(layoutinflater);
        bannerLayout = (RelativeLayout)layoutinflater.findViewWithTag("bannerRelative");
        return layoutinflater;
    }

    public void onDecorateClicked(bfi bfi)
    {
        if (bfi instanceof bfj)
        {
            relayoutTextEditorBar();
            _textEditorBar.setVisibility(0);
            bfg bfg1 = new bfg();
            if (bfi instanceof bfj)
            {
                _textEditor.setText(((bfj)bfi).g());
                ((bfj)bfi).a();
            }
            if (bfg1 != null && bfg1.a())
            {
                _textEditor.setTag(Integer.valueOf(bfg1.q));
            } else
            {
                _textEditor.setTag(Integer.valueOf(-1));
            }
            if (mActivity != null)
            {
                mActivity.a(false);
            }
            showSoftKeyboard(_textEditor);
        }
    }

    public void onDestroy()
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" onDestroy").toString());
        super.onDestroy();
        if (cropImagsTask != null)
        {
            cropImagsTask.a(null);
        }
    }

    public boolean onLongClick(View view)
    {
        if (_scrollViewArray.size() < 2)
        {
            return false;
        }
        if (movingView != null)
        {
            setMovingViewParamters();
            setAllImageViewsScroolEnable(false);
            movingView.setVisibility(0);
        }
        if (view instanceof MaskScrollImageViewTouch)
        {
            view = (android.widget.FrameLayout.LayoutParams)((TMaskScrollImageView)((MaskScrollImageViewTouch)view).getParent()).getLayoutParams();
            int i = ((android.widget.FrameLayout.LayoutParams) (view)).leftMargin;
            int j = ((android.widget.FrameLayout.LayoutParams) (view)).topMargin;
            int k = ((android.widget.FrameLayout.LayoutParams) (view)).width;
            int l = ((android.widget.FrameLayout.LayoutParams) (view)).height;
            view = new Rect();
            view.left = i;
            view.right = k + i;
            view.top = j;
            view.bottom = l + j;
            mergeX = i;
            mergeY = j;
            if (movingView != null)
            {
                movingView.setStartRectAndBitmap(view, null);
            }
            return true;
        } else
        {
            return true;
        }
    }

    public void onPause()
    {
        super.onPause();
        if (mSurfaceView != null)
        {
            mSurfaceView.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (mSurfaceView != null && mSurfaceView.getRender() != null)
        {
            mSurfaceView.onResume();
        }
        Log.d(TAG, (new StringBuilder()).append(TAG).append(": ").append("onResume").toString());
    }

    public void reLayouComposeView()
    {
        float f;
        float f1;
        float f2;
        float f3;
        Object obj;
        InstaMagType instamagtype;
        obj = getResources().getDisplayMetrics();
        f1 = ((DisplayMetrics) (obj)).widthPixels;
        f2 = (float)((DisplayMetrics) (obj)).widthPixels / (float)((DisplayMetrics) (obj)).heightPixels;
        f3 = mActivity.d().width / mActivity.d().height;
        f = f1 / mActivity.d().width;
        modifyScale = 1.0F;
        instamagtype = TPhotoComposeInfo.getInstaMagType(mActivity.d());
        if (instamagtype != InstaMagType.RECT_LIB_SIZE_TYPE) goto _L2; else goto _L1
_L1:
        modifyScale = computeModifyScale();
_L4:
        f *= modifyScale;
        TPhotoComposeInfo.scale = f;
        isUsingHeightAsRef = false;
        if (f2 > f3)
        {
            Log.v(TAG, "Using height as scale referance");
            f = ((float)((DisplayMetrics) (obj)).heightPixels / mActivity.d().height) * modifyScale;
            TPhotoComposeInfo.scale = f;
            isUsingHeightAsRef = true;
        }
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)_composeFrameLayout.getLayoutParams();
        layoutparams.width = (int)(f1 * modifyScale);
        layoutparams.height = (int)(mActivity.d().height * f);
        if (isUsingHeightAsRef)
        {
            layoutparams.width = (int)(f * mActivity.d().width);
            layoutparams.height = (int)((float)((DisplayMetrics) (obj)).heightPixels * modifyScale);
        }
        if (instamagtype != InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            layoutparams.topMargin = -axw.a(mActivity, 20F);
        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" width:").append(layoutparams.width).append(" height:").append(layoutparams.height).append(" top:").append(layoutparams.topMargin).append(" left:").append(layoutparams.leftMargin).toString());
        layoutparams.gravity = 17;
        _composeFrameLayout.setLayoutParams(layoutparams);
        obj = new android.widget.FrameLayout.LayoutParams(layoutparams.width, layoutparams.height);
        if (_decorateInfosLayer != null)
        {
            _composeFrameLayout.removeView(_decorateInfosLayer);
            _decorateInfosLayer = null;
        }
        _decorateInfosLayer = new TDecorateInfosLayerView(getActivity());
        obj.gravity = 51;
        _composeFrameLayout.addView(_decorateInfosLayer, 2, ((android.view.ViewGroup.LayoutParams) (obj)));
        _decorateInfosLayer.setTextClickListener(this);
        return;
_L2:
        if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            modifyScale = 0.9F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void reloadNewInfo()
    {
        if (mActivity == null)
        {
            return;
        }
        if (_scrollViewArray != null)
        {
            _scrollViewArray.clear();
        }
        if (_scrollViewContainer != null)
        {
            _scrollViewContainer.removeAllViews();
        }
        if (_layoutInfoes != null)
        {
            _layoutInfoes.clear();
        }
        if (_backgroundImageView != null)
        {
            _backgroundImageView.setImageBitmap(null);
        }
        if (_foregroundImageView != null)
        {
            _foregroundImageView.setImageBitmap(null);
        }
        if (_gifLayoutInfoes != null)
        {
            _gifLayoutInfoes.clear();
        }
        haveLocation = false;
        haveTime = false;
        haveWeather = false;
        reLayouComposeView();
        generateComposeView();
        if (haveLocation)
        {
            if (curGeocoderItem != null)
            {
                updateDecorateLocation(curGeocoderItem);
            } else
            {
                requestLocationByGeometry(geometry);
            }
        }
        if (geometry.a() != 0.0D && haveWeather)
        {
            if (getWeatherManager() != null && getWeatherManager().b() != null)
            {
                handelWeather(getWeatherManager().b());
            } else
            {
                requestWeatherByGeometry(geometry);
            }
        }
        if (curPlacemark != null)
        {
            updateDecorateLocationByUserPlaceMark(curPlacemark);
        }
        if (haveTime)
        {
            handleDateTime();
        }
        if (openGlCreated)
        {
            processFilterImages();
            Log.v(TAG, (new StringBuilder()).append(TAG).append(" filter process end").toString());
            return;
        } else
        {
            bShouldProcessFilterWhenopenGlCreated = true;
            return;
        }
    }

    public void requestCurrentConditionWithLocationFailed()
    {
    }

    public void requestCurrentConditionWithLocationFinished()
    {
        if (getWeatherManager() != null && getWeatherManager().b() != null)
        {
            Log.v(TAG, (new StringBuilder()).append(TAG).append("getWeatherModel weather:").append(getWeatherManager().b().d).toString());
            Log.v(TAG, (new StringBuilder()).append(TAG).append("getWeatherModel wind_string :").append(getWeatherManager().b().i).toString());
            handelWeather(getWeatherManager().b());
        }
    }

    public void scaleMaskView(TMaskScrollImageView tmaskscrollimageview)
    {
        if (isShowAnimation)
        {
            return;
        } else
        {
            ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, (float)tmaskscrollimageview.getWidth() * 0.5F, (float)tmaskscrollimageview.getHeight() * 0.5F);
            scaleanimation.setDuration(150L);
            scaleanimation.setInterpolator(new DecelerateInterpolator());
            scaleanimation.setFillEnabled(true);
            scaleanimation.setFillAfter(false);
            scaleanimation.setAnimationListener(new bap(this));
            tmaskscrollimageview.startAnimation(scaleanimation);
            return;
        }
    }

    public void setMovingViewParamters()
    {
        if (_scrollViewArray != null && _scrollViewArray.size() > 0)
        {
            int j = _scrollViewArray.size();
            ArrayList arraylist = new ArrayList(j);
            for (int i = 0; i < j; i++)
            {
                Rect rect = new Rect();
                android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)((TMaskScrollImageView)_scrollViewArray.get(i)).getLayoutParams();
                int k = layoutparams.leftMargin;
                int l = layoutparams.topMargin;
                int i1 = layoutparams.width;
                int j1 = layoutparams.height;
                rect.left = k;
                rect.right = k + i1;
                rect.top = l;
                rect.bottom = j1 + l;
                arraylist.add(rect);
            }

            movingView.setTargetRects(arraylist);
            movingView.setDelegate(this);
        }
    }

    public void showSoftKeyboard(View view)
    {
        if (view.requestFocus())
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append("surfaceChanged").toString());
        openGlCreated = true;
        if (bShouldProcessFilterWhenopenGlCreated)
        {
            bShouldProcessFilterWhenopenGlCreated = false;
            processFilterImages();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append("surfaceCreated").toString());
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        openGlCreated = false;
        Log.v(TAG, (new StringBuilder()).append(TAG).append("surfaceDestroyed").toString());
    }

    public void updateDecorateLocation(aoq aoq1)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" updateDecorateLocation dateTime:").append(dateTime).toString());
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" updateDecorateLocation Location:").append(aoq1.a()).toString());
        if (_decorateInfosLayer != null)
        {
            _decorateInfosLayer.setLocationText(aoq1);
        }
    }




/*
    public static boolean access$1002(MagComposeFragement magcomposefragement, boolean flag)
    {
        magcomposefragement.isShowAnimation = flag;
        return flag;
    }

*/


/*
    public static aoq access$1102(MagComposeFragement magcomposefragement, aoq aoq1)
    {
        magcomposefragement.curGeocoderItem = aoq1;
        return aoq1;
    }

*/








}
