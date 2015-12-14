// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.comlib.ui.HorizontalListView;
import com.fotoable.exifutil.ImageInfo;
import com.fotoable.geocoderlib.enums.GeocodingStatus;
import com.instamag.activity.model.FilterListArrayAdapter;
import com.instamag.activity.view.ImagesMovingView;
import com.instamag.activity.view.TDecorateInfosLayerTextHelpView;
import com.instamag.activity.view.TDecorateInfosLayerView;
import com.instamag.activity.view.TMaskScrollImageView;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.CollageType;
import com.wantu.ResourceOnlineLibrary.compose.FlipViewType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TDecorateInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMaskInfo;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagerender.ImageGLSurfaceView;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jl;
import jm;
import jn;
import jp;
import jq;
import js;
import ju;
import pb;
import pj;
import pm;
import pp;
import rb;
import rd;
import re;
import ri;
import rj;
import rl;
import rm;
import rs;
import so;
import sp;
import va;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeActivity

public class MagComposeFragement extends Fragment
    implements android.view.SurfaceHolder.Callback, android.view.View.OnLongClickListener, android.widget.AdapterView.OnItemClickListener, pj, re, ri, rs, sp
{

    private FrameLayout A;
    private TMaskScrollImageView B;
    private float C;
    private float D;
    private float E;
    private float F;
    private boolean G;
    private boolean H;
    private FlipViewType I;
    private FilterListArrayAdapter J;
    private float K;
    private TDecorateInfosLayerTextHelpView L;
    protected MagComposeActivity a;
    HorizontalListView b;
    ImagesMovingView c;
    private String d;
    private int e;
    private ImageGLSurfaceView f;
    private ImageView g;
    private ImageView h;
    private FrameLayout i;
    private TDecorateInfosLayerView j;
    private FrameLayout k;
    private List l;
    private List m;
    private EditText n;
    private RelativeLayout o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private String t;
    private TImageFilterManager u;
    private boolean v;
    private ju w;
    private jl x;
    private jp y;
    private pm z;

    public MagComposeFragement()
    {
        d = "MainComposeFragement";
        e = 612;
        l = new ArrayList();
        m = new ArrayList();
        p = false;
        q = false;
        r = false;
        s = false;
        v = false;
        w = new ju();
        x = null;
        y = null;
        H = false;
        K = 1.0F;
    }

    private Bitmap a(int i1, int j1)
    {
        Object obj = getResources().getDisplayMetrics();
        float f1 = ((DisplayMetrics) (obj)).widthPixels;
        f1 = (float)i1 / f1;
        float f2 = 1.0F / K;
        Canvas canvas;
        Object obj1;
        if (G)
        {
            f1 = (float)(j1 / ((DisplayMetrics) (obj)).heightPixels) * f2;
        } else
        {
            f1 *= f2;
        }
        obj = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(((Bitmap) (obj)));
        canvas.scale(f1, f1);
        g.draw(canvas);
        a(canvas);
        j.drawLayer(canvas);
        h.draw(canvas);
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

    private Bitmap a(Bitmap bitmap, int i1)
    {
        Object obj = null;
        i1;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 109
    //                   1 160;
           goto _L1 _L2 _L3
_L1:
        float af[] = null;
_L5:
        if (af != null)
        {
            obj = new Matrix();
            ((Matrix) (obj)).setValues(af);
            Log.v(d, (new StringBuilder()).append(d).append("matrix isIndesity: ").append(((Matrix) (obj)).isIdentity()).toString());
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

    static FrameLayout a(MagComposeFragement magcomposefragement)
    {
        return magcomposefragement.A;
    }

    private TMaskScrollImageView a(Rect rect)
    {
        for (int i1 = 0; i1 < l.size(); i1++)
        {
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)l.get(i1);
            if (tmaskscrollimageview == null)
            {
                continue;
            }
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)tmaskscrollimageview.getLayoutParams();
            int j1 = layoutparams.leftMargin;
            int k1 = layoutparams.topMargin;
            int l1 = layoutparams.width;
            int i2 = layoutparams.height;
            if (rect.left == j1 && rect.top == k1 && rect.width() == l1 && rect.height() == i2)
            {
                return tmaskscrollimageview;
            }
        }

        return null;
    }

    static jl a(MagComposeFragement magcomposefragement, jl jl1)
    {
        magcomposefragement.x = jl1;
        return jl1;
    }

    private rb a(TPhotoComposeInfo tphotocomposeinfo)
    {
        char c2 = '\u0280';
        char c1 = '\u01C0';
        int i1;
        int j1;
        if (tphotocomposeinfo.width == tphotocomposeinfo.height)
        {
            if (PIPCameraApplication.b)
            {
                c2 = '\u01C0';
            } else
            {
                c1 = '\u0280';
            }
        } else
        if (tphotocomposeinfo.width > tphotocomposeinfo.height)
        {
            c1 = '\u0282';
            if (PIPCameraApplication.b)
            {
                c1 = '\u01C1';
                c2 = '\u02A0';
            } else
            {
                c2 = '\u03C0';
            }
        } else
        if (PIPCameraApplication.b)
        {
            c2 = '\u01C0';
            c1 = '\u02A0';
        } else
        {
            c1 = '\u03C0';
        }
        j1 = c1;
        i1 = c2;
        if (k.getWidth() > c2)
        {
            j1 = c1;
            i1 = c2;
            if (k.getHeight() > c1)
            {
                i1 = (int)((float)k.getWidth() / K);
                j1 = (int)((float)k.getHeight() / K);
            }
        }
        tphotocomposeinfo = new rb();
        tphotocomposeinfo.a = i1;
        tphotocomposeinfo.b = j1;
        return tphotocomposeinfo;
    }

    private void a(Canvas canvas)
    {
        for (Iterator iterator = l.iterator(); iterator.hasNext(); canvas.restore())
        {
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)iterator.next();
            canvas.save();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)tmaskscrollimageview.getLayoutParams();
            canvas.translate(layoutparams.leftMargin, layoutparams.topMargin);
            tmaskscrollimageview.renderInCanvas(canvas);
        }

    }

    static void a(MagComposeFragement magcomposefragement, String s1, int i1)
    {
        magcomposefragement.a(s1, i1);
    }

    private void a(FlipViewType flipviewtype)
    {
        boolean flag = false;
        int i1;
        if (g.getDrawable() != null)
        {
            Bitmap bitmap = ((BitmapDrawable)g.getDrawable()).getBitmap();
            if (bitmap != null)
            {
                Bitmap bitmap1;
                if (flipviewtype == FlipViewType.FLIP_HORIZONTAL)
                {
                    i1 = 0;
                } else
                {
                    i1 = 1;
                }
                bitmap1 = a(bitmap, i1);
                if (bitmap1 != bitmap && !bitmap.isRecycled())
                {
                    Log.v(d, (new StringBuilder()).append(d).append("reverBackgroundAndForeground recycle bgBitmap").toString());
                    bitmap.recycle();
                }
                g.setImageBitmap(bitmap1);
            }
        }
        if (h.getDrawable() != null)
        {
            bitmap = ((BitmapDrawable)h.getDrawable()).getBitmap();
            if (bitmap != null)
            {
                if (flipviewtype == FlipViewType.FLIP_HORIZONTAL)
                {
                    i1 = ((flag) ? 1 : 0);
                } else
                {
                    i1 = 1;
                }
                flipviewtype = a(bitmap, i1);
                if (flipviewtype != bitmap && !bitmap.isRecycled())
                {
                    Log.v(d, (new StringBuilder()).append(d).append("reverBackgroundAndForeground recycle foreBitmap").toString());
                    bitmap.recycle();
                }
                h.setImageBitmap(flipviewtype);
            }
        }
    }

    private void a(String s1, int i1)
    {
        if (i1 != 5 && i1 != 10 && i1 != 9 || s1 == null || s1.length() <= 0) goto _L2; else goto _L1
_L1:
        if (y == null)
        {
            y = new jp();
        }
        if (i1 != 5) goto _L4; else goto _L3
_L3:
        y.a = s1;
_L2:
        return;
_L4:
        if (i1 != 10)
        {
            continue; /* Loop/switch isn't completed */
        }
        y.c = s1;
        if (j != null)
        {
            s1 = j.getPlaceCity();
            if (s1 != null && s1.length() > 0)
            {
                y.a = String.format("%s,%s", new Object[] {
                    s1, y.c
                });
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (i1 != 9) goto _L2; else goto _L5
_L5:
        y.b = s1;
        if (j != null)
        {
            s1 = j.getPlaceCountry();
            if (s1 != null && s1.length() > 0)
            {
                y.a = String.format("%s,%s", new Object[] {
                    y.b, s1
                });
                return;
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    private void a(jl jl1)
    {
        Log.v(d, (new StringBuilder()).append(d).append(" updateDecorateLocation dateTime:").append(t).toString());
        Log.v(d, (new StringBuilder()).append(d).append(" updateDecorateLocation Location:").append(jl1.a()).toString());
        if (j != null)
        {
            j.setLocationText(jl1);
        }
    }

    private void a(jp jp1)
    {
        while (jp1 == null || j == null) 
        {
            return;
        }
        j.setLocationTextByTTCLPlacemark(jp1);
    }

    private void a(ju ju1)
    {
        jq jq1 = new jq(a, new jm() {

            final MagComposeFragement a;

            public void a()
            {
                Log.v(MagComposeFragement.e(a), (new StringBuilder()).append(MagComposeFragement.e(a)).append(" onAddressZeroResult").toString());
            }

            public void a(GeocodingStatus geocodingstatus)
            {
                Log.v(MagComposeFragement.e(a), (new StringBuilder()).append(MagComposeFragement.e(a)).append(" onAddressGotStatus").toString());
                if (geocodingstatus == GeocodingStatus.OVER_QUERY_LIMIT)
                {
                    FlurryAgent.logEvent("requestLocationByGeometry_OVER_QUERY_LIMIT");
                }
                if (geocodingstatus == GeocodingStatus.INVALID_REQUEST)
                {
                    FlurryAgent.logEvent("requestLocationByGeometry_INVALID_REQUEST");
                }
                if (geocodingstatus == GeocodingStatus.REQUEST_DENIED)
                {
                    FlurryAgent.logEvent("requestLocationByGeometry_REQUEST_DENIED");
                }
            }

            public void a(String s2)
            {
            }

            public void a(jl jl1)
            {
                Log.v(MagComposeFragement.e(a), (new StringBuilder()).append(MagComposeFragement.e(a)).append(" onAddressGotResult").toString());
                if (jl1 != null)
                {
                    MagComposeFragement.a(a, jl1);
                    MagComposeFragement.b(a, jl1);
                }
            }

            public void b()
            {
                Log.v(MagComposeFragement.e(a), (new StringBuilder()).append(MagComposeFragement.e(a)).append(" onConnectionFailed").toString());
            }

            
            {
                a = MagComposeFragement.this;
                super();
            }
        });
        jn jn1 = new jn();
        Object obj = Locale.getDefault();
        String s1 = ((Locale) (obj)).getLanguage();
        obj = ((Locale) (obj)).getCountry();
        Log.v(d, (new StringBuilder()).append(d).append("langcode:").append(s1).append(" countryCode:").append(((String) (obj))).toString());
        jn1.a(js.a());
        jq1.a(jn1);
        jq1.a(ju1.a(), ju1.b());
    }

    private void a(pp pp1)
    {
        if (pp1 != null)
        {
            Log.v(d, (new StringBuilder()).append(d).append("getWeatherModel weather:").append(u().b().d).toString());
            Log.v(d, (new StringBuilder()).append(d).append("getWeatherModel wind_string :").append(u().b().i).toString());
            if (j != null)
            {
                j.setWeather(u().b());
                return;
            }
        }
    }

    private void a(boolean flag)
    {
        for (int i1 = 0; i1 < l.size(); i1++)
        {
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)l.get(i1);
            if (tmaskscrollimageview != null)
            {
                tmaskscrollimageview.setImageTouchViewScrollEnabled(flag);
            }
        }

    }

    private boolean a(Rect rect, Rect rect1)
    {
        while (rect == null || rect1 == null || rect.left != rect1.left || rect.top != rect1.top || rect.bottom != rect1.bottom || rect.right != rect1.right) 
        {
            return false;
        }
        return true;
    }

    private boolean a(String s1)
    {
        for (Iterator iterator = o().getmKeyOderArray().iterator(); iterator.hasNext();)
        {
            String s2 = (String)iterator.next();
            Log.v(d, (new StringBuilder()).append(d).append("manager filterName :").append(s2).toString());
            if (s2.equalsIgnoreCase(s1))
            {
                return true;
            }
        }

        return false;
    }

    static EditText b(MagComposeFragement magcomposefragement)
    {
        return magcomposefragement.n;
    }

    private void b(int i1)
    {
        if (b != null && b.getAdapter() != null)
        {
            FilterListArrayAdapter filterlistarrayadapter = (FilterListArrayAdapter)b.getAdapter();
            if (i1 < filterlistarrayadapter.getCount())
            {
                filterlistarrayadapter.setSelectPosition(i1);
            }
        }
    }

    static void b(MagComposeFragement magcomposefragement, jl jl1)
    {
        magcomposefragement.a(jl1);
    }

    private void b(ju ju1)
    {
        while (ju1.a() == 0.0D || ju1.a() == 0.0D) 
        {
            return;
        }
        u().a(ju1.a(), ju1.b());
    }

    static TDecorateInfosLayerView c(MagComposeFragement magcomposefragement)
    {
        return magcomposefragement.j;
    }

    static RelativeLayout d(MagComposeFragement magcomposefragement)
    {
        return magcomposefragement.o;
    }

    private void d(View view)
    {
        f = (ImageGLSurfaceView)view.findViewById(0x7f0c0147);
        f.getHolder().addCallback(this);
    }

    static String e(MagComposeFragement magcomposefragement)
    {
        return magcomposefragement.d;
    }

    private void e(View view)
    {
        Log.v(d, (new StringBuilder()).append(d).append(" maskScrollViewClicked:").toString());
        if (A != null)
        {
            A.setVisibility(0);
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)b.getLayoutParams();
            int j1 = layoutparams1.leftMargin;
            int i1 = layoutparams1.topMargin;
            int j2 = layoutparams1.width;
            int l1 = layoutparams1.height;
            int k2 = layoutparams.width;
            int k1 = layoutparams.height;
            int i2 = k.getHeight();
            int l2 = k.getWidth();
            if (j2 / 2 + j1 < k2 / 2)
            {
                if (i1 + l1 + k1 > i2)
                {
                    float f1;
                    float f2;
                    DisplayMetrics displaymetrics;
                    if (i1 > k1)
                    {
                        i1 -= k1;
                    } else
                    {
                        i1 = i2 - k1 * 2;
                    }
                    j1 = 0;
                } else
                {
                    i1 = (l1 + i1) - k1;
                    j1 = 0;
                }
            } else
            if (l2 - (j2 / 2 + j1) < k2 / 2)
            {
                if (i1 + l1 + k1 > i2)
                {
                    j1 = l2 - k2;
                    if (i1 > k1)
                    {
                        i1 -= k1;
                    } else
                    {
                        i1 = i2 - k1 * 2;
                    }
                } else
                {
                    j1 = l2 - k2;
                    i1 = (l1 + i1) - k1;
                }
            } else
            if (i1 + l1 + k1 > i2)
            {
                j1 = (j2 / 2 + j1) - k2 / 2;
                if (i1 > k1)
                {
                    i1 -= k1;
                } else
                {
                    i1 = i2 - k1 * 2;
                }
            } else
            {
                j1 = (j1 + j2 / 2) - k2 / 2;
                i1 = (l1 + i1) - k1;
            }
            displaymetrics = getResources().getDisplayMetrics();
            f1 = displaymetrics.widthPixels;
            f2 = displaymetrics.heightPixels;
            layoutparams.setMargins(j1 + (int)((f1 - (float)k.getWidth()) / 2.0F), i1 + (int)((f2 - (float)k.getHeight()) / 2.0F + (float)pb.a(getActivity(), 30F)), 0, 0);
            b.setLayoutParams(layoutparams);
        }
        if (view instanceof TMaskScrollImageView)
        {
            B = (TMaskScrollImageView)view;
        }
    }

    private float j()
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f1 = displaymetrics.widthPixels;
        float f2 = pb.a(a, 150F);
        float f3 = (float)displaymetrics.widthPixels / (float)displaymetrics.heightPixels;
        float f4 = a.g().width / a.g().height;
        f1 /= a.g().width;
        if (f3 > f4)
        {
            Log.v(d, "Using height as scale referance");
            f1 = (float)displaymetrics.heightPixels / a.g().height;
        }
        f1 *= a.g().height;
        if (f1 + f2 > (float)displaymetrics.heightPixels)
        {
            f1 = ((float)displaymetrics.heightPixels - f2) / f1;
        } else
        {
            f1 = 1.0F;
        }
        Log.v(d, (new StringBuilder()).append(d).append(" ModifyScale :").append(f1).toString());
        return f1;
    }

    private void k()
    {
        if (getActivity() != null && !p)
        {
            Object obj = getActivity().getSharedPreferences("config", 0);
            int i1 = ((SharedPreferences) (obj)).getInt("change_positonhelp_number", 0);
            if (i1 < 2)
            {
                obj = ((SharedPreferences) (obj)).edit();
                ((android.content.SharedPreferences.Editor) (obj)).putInt("change_positonhelp_number", i1 + 1);
                ((android.content.SharedPreferences.Editor) (obj)).commit();
                obj = new android.app.AlertDialog.Builder(getActivity());
                ((android.app.AlertDialog.Builder) (obj)).setTitle(getResources().getString(0x7f060277));
                ((android.app.AlertDialog.Builder) (obj)).setMessage(getResources().getString(0x7f0600a4));
                ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(getResources().getString(0x7f06002f), new android.content.DialogInterface.OnClickListener() {

                    final MagComposeFragement a;

                    public void onClick(DialogInterface dialoginterface, int j1)
                    {
                    }

            
            {
                a = MagComposeFragement.this;
                super();
            }
                });
                ((android.app.AlertDialog.Builder) (obj)).show();
                p = true;
            }
        }
    }

    private void l()
    {
        List list;
        TImageFilterInfo atimagefilterinfo[];
        if (a.g().getInfoCollageType() == CollageType.COLLAGE_COMIC)
        {
            list = o().filterNamesByCatalogeName("comic-filter");
        } else
        {
            list = o().filterNamesByCatalogeName("default-filter");
        }
        atimagefilterinfo = new TImageFilterInfo[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            Object obj = (String)list.get(i1);
            obj = o().getFilterByName(((String) (obj)));
            if (obj != null)
            {
                atimagefilterinfo[i1] = ((TImageFilterInfo) (obj));
                Log.v(d, (new StringBuilder()).append(d).append("Config filerView ").append(((TImageFilterInfo) (obj)).filterName).toString());
            }
        }

        J = new FilterListArrayAdapter(getActivity(), atimagefilterinfo);
        b.setAdapter(J);
        b.setOnItemClickListener(this);
    }

    private int m()
    {
        char c1 = '\u0264';
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f1 = displaymetrics.density;
        int i1 = displaymetrics.densityDpi;
        float f2 = displaymetrics.xdpi;
        float f3 = displaymetrics.ydpi;
        float f4 = displaymetrics.widthPixels;
        float f5 = displaymetrics.heightPixels;
        Log.e((new StringBuilder()).append(d).append("  DisplayMetrics").toString(), (new StringBuilder()).append("xdpi=").append(f2).append("; ydpi=").append(f3).toString());
        Log.e((new StringBuilder()).append(d).append("  DisplayMetrics").toString(), (new StringBuilder()).append("density=").append(f1).append("; densityDPI=").append(i1).toString());
        Log.v((new StringBuilder()).append(d).append("  screenWidth ").toString(), String.format("%f", new Object[] {
            Float.valueOf(f4)
        }));
        Log.v((new StringBuilder()).append(d).append("  screenHeight ").toString(), String.format("%f", new Object[] {
            Float.valueOf(f5)
        }));
        if (f2 < 160F || f4 < 400F)
        {
            c1 = '\u019A';
        }
        return c1;
    }

    private ju n()
    {
        double d3;
        double d4;
        ju ju1;
        List list;
        int i1;
        d3 = 0.0D;
        ju1 = new ju();
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        list = a.h();
        i1 = 0;
        d4 = 0.0D;
_L6:
        double d1;
        double d2;
        d1 = d4;
        d2 = d3;
        if (i1 >= list.size()) goto _L2; else goto _L1
_L1:
        Object obj = Uri.parse((String)list.get(i1));
        obj = new ImageInfo(a, ((Uri) (obj)));
        if (obj == null) goto _L4; else goto _L3
_L3:
        float af[];
        t = ((ImageInfo) (obj)).getDateTime();
        Log.v(d, (new StringBuilder()).append(d).append("requestGeometryByImageUris ").append("DAte Time :").append(t).toString());
        af = new float[2];
        af;
        af[0] = 0.0F;
        af[1] = 0.0F;
        ((ImageInfo) (obj)).getLatLong(af);
        Log.v(d, (new StringBuilder()).append(d).append("requestGeometryByImageUris ").append("lat :").append(af[0]).append(" long:").append(af[1]).toString());
        if (af[0] == 0.0F) goto _L4; else goto _L5
_L5:
        d1 = af[0];
        float f1 = af[1];
        d2 = f1;
_L2:
        ju1.a(d1);
        ju1.b(d2);
        return ju1;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        Crashlytics.logException(ioexception);
_L4:
        i1++;
          goto _L6
        d1 = 0.0D;
        d2 = d3;
          goto _L2
    }

    private TImageFilterManager o()
    {
        if (u == null)
        {
            u = new TImageFilterManager();
        }
        return u;
    }

    private void p()
    {
        for (int i1 = 0; i1 < l.size(); i1++)
        {
            TMaskScrollImageView tmaskscrollimageview = (TMaskScrollImageView)l.get(i1);
            if (tmaskscrollimageview.getMaskInfo() == null)
            {
                continue;
            }
            TPhotoMaskInfo tphotomaskinfo = tmaskscrollimageview.getMaskInfo();
            if (tphotomaskinfo.filterName != null && tphotomaskinfo.filterName.length() > 0)
            {
                Log.v(d, (new StringBuilder()).append(d).append(" filterNem : ").append(tphotomaskinfo.filterName).toString());
                String s3 = tphotomaskinfo.filterName;
                String s1 = s3;
                if (s3.equalsIgnoreCase("B&W"))
                {
                    s1 = "BW";
                }
                s1 = va.c(a, s1);
                if (a(s1))
                {
                    f.fastProcessImage(tmaskscrollimageview.getCenterBitmap(), s1, new Handler(tmaskscrollimageview) {

                        final TMaskScrollImageView a;
                        final MagComposeFragement b;

                        public void handleMessage(Message message)
                        {
                            if (message != null)
                            {
                                message = (Bitmap)message.obj;
                                if (message != null)
                                {
                                    a.updateCenterViewImage(message);
                                }
                            }
                        }

            
            {
                b = MagComposeFragement.this;
                a = tmaskscrollimageview;
                super();
            }
                    });
                }
            }
            if (tphotomaskinfo.isPIP)
            {
                String s2 = va.c(a, tphotomaskinfo.backFilterName);
                tmaskscrollimageview.processBackgroundGaussianCenterView(f, tmaskscrollimageview.getCenterBitmap(), s2, false);
            }
        }

    }

    private void q()
    {
        if (L != null)
        {
            r();
            L.setVisibility(0);
            c(L);
        }
    }

    private void r()
    {
        if (m == null || m.size() <= 0) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        arraylist = new ArrayList(m.size());
        for (int i1 = 0; i1 < m.size(); i1++)
        {
            rj rj1 = (rj)m.get(i1);
            if (rj1.r && rj1.A)
            {
                Rect rect = new Rect();
                TPhotoComposeInfo.getScaledRect(rj1.h).round(rect);
                arraylist.add(rect);
            }
        }

        if (L == null) goto _L4; else goto _L3
_L3:
        if (arraylist.size() <= 0) goto _L6; else goto _L5
_L5:
        L.setTargetRects(arraylist);
_L4:
        return;
_L6:
        L.setTargetRects(null);
        return;
_L2:
        if (L != null)
        {
            L.setTargetRects(null);
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    private void s()
    {
        if (c != null && c.getVisibility() == 0)
        {
            Object obj = c.getStartRect();
            Object obj1 = c.getTargetRect();
            if (!a(((Rect) (obj)), ((Rect) (obj1))) && obj != null && obj1 != null)
            {
                obj = a(((Rect) (obj)));
                obj1 = a(((Rect) (obj1)));
                if (obj != null && obj1 != null)
                {
                    int i1 = ((Integer)((TMaskScrollImageView) (obj)).getTag()).intValue();
                    int j1 = ((Integer)((TMaskScrollImageView) (obj1)).getTag()).intValue();
                    if (a != null && a.i().size() > Math.max(i1, j1))
                    {
                        TPhotoMaskInfo tphotomaskinfo = ((TMaskScrollImageView) (obj)).getMaskInfo();
                        TPhotoMaskInfo tphotomaskinfo1 = ((TMaskScrollImageView) (obj1)).getMaskInfo();
                        if (!tphotomaskinfo.is3DTransform() && !tphotomaskinfo1.is3DTransform())
                        {
                            Bitmap bitmap = ((TMaskScrollImageView) (obj)).getCenterBitmap();
                            Bitmap bitmap2 = ((TMaskScrollImageView) (obj1)).getCenterBitmap();
                            if (v && f != null && tphotomaskinfo.isPIP)
                            {
                                ((TMaskScrollImageView) (obj)).changeMaskScrollViewImage(bitmap2, f);
                            } else
                            {
                                ((TMaskScrollImageView) (obj)).updateCenterViewImage(bitmap2);
                            }
                            if (v && f != null && tphotomaskinfo1.isPIP)
                            {
                                ((TMaskScrollImageView) (obj1)).changeMaskScrollViewImage(bitmap, f);
                            } else
                            {
                                ((TMaskScrollImageView) (obj1)).updateCenterViewImage(bitmap);
                            }
                        } else
                        {
                            Bitmap bitmap1 = (Bitmap)a.i().get(i1);
                            Bitmap bitmap3 = (Bitmap)a.i().get(j1);
                            if (tphotomaskinfo1.is3DTransform())
                            {
                                ((TMaskScrollImageView) (obj1)).updateCenter3dTransformImage(bitmap1, false);
                            } else
                            if (v && f != null && tphotomaskinfo1.isPIP)
                            {
                                ((TMaskScrollImageView) (obj1)).changeMaskScrollViewImage(bitmap1, f);
                            } else
                            {
                                ((TMaskScrollImageView) (obj1)).updateCenterViewImage(bitmap1);
                            }
                            if (tphotomaskinfo.is3DTransform())
                            {
                                ((TMaskScrollImageView) (obj)).updateCenter3dTransformImage(bitmap3, false);
                            } else
                            if (v && f != null && tphotomaskinfo.isPIP)
                            {
                                ((TMaskScrollImageView) (obj)).changeMaskScrollViewImage(bitmap3, f);
                            } else
                            {
                                ((TMaskScrollImageView) (obj)).updateCenterViewImage(bitmap3);
                            }
                        }
                        ((TMaskScrollImageView) (obj)).setTag(Integer.valueOf(j1));
                        ((TMaskScrollImageView) (obj1)).setTag(Integer.valueOf(i1));
                    }
                }
            }
            c.setVisibility(4);
            c.setStartRectAndBitmap(null, null);
            a(true);
        }
    }

    private void t()
    {
        if (!s || t == null || t.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        Log.v(d, (new StringBuilder()).append(d).append("update before dateTime :").append(t).toString());
        Object obj = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        try
        {
            obj = ((DateFormat) (obj)).parse(t);
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
        if (j != null)
        {
            j.setDateText(((java.util.Date) (obj)));
        }
    }

    private pm u()
    {
        if (z == null)
        {
            z = pm.a();
            z.a(this);
        }
        return z;
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
        C = motionevent.getX();
        D = motionevent.getY();
        return;
_L4:
        if (c.getVisibility() != 4 && c != null)
        {
            float f1 = motionevent.getX();
            float f2 = motionevent.getY();
            int i1 = (int)(motionevent.getX() + E);
            int j1 = (int)(motionevent.getY() + F);
            c.movePosition((int)(f1 - C), (int)(f2 - D), i1, j1);
            return;
        }
          goto _L1
_L3:
        s();
        return;
    }

    public rj a(TDecorateInfo tdecorateinfo, int i1)
    {
        float f3 = 0.0F;
        Object obj;
        if (tdecorateinfo == null)
        {
            obj = null;
        } else
        {
            float f1;
            float f2;
            float f4;
            rj rj1;
            int j1;
            if (i1 < m.size())
            {
                rj1 = (rj)m.get(i1);
            } else
            {
                rj1 = new rj();
            }
            obj = new Matrix();
            f4 = (float)((double)(tdecorateinfo.rotation * 180F) / 3.1415926535897931D);
            if (tdecorateinfo.frame == null)
            {
                tdecorateinfo.frame = new RectF(0.0F, 0.0F, 1.0F, 1.0F);
            }
            if (tdecorateinfo.frame != null && f4 != 0.0F)
            {
                f1 = tdecorateinfo.frame.width() / 2.0F;
                f2 = TPhotoComposeInfo.scale * f1;
                f1 = (tdecorateinfo.frame.height() / 2.0F) * TPhotoComposeInfo.scale;
            } else
            {
                f1 = 0.0F;
                f2 = 0.0F;
            }
            ((Matrix) (obj)).postRotate(f4, f2, f1);
            rj1.n = ((Matrix) (obj));
            if (tdecorateinfo.imagePath != null && tdecorateinfo.imagePath.length() > 0)
            {
                rj1.a = tdecorateinfo.getBitmapByPath(tdecorateinfo.imagePath);
            }
            rj1.h = tdecorateinfo.frame;
            rj1.g = new RectF(0.0F, 0.0F, tdecorateinfo.frame.width(), tdecorateinfo.frame.height());
            rj1.d = 0x106000d;
            rj1.e = 0.0F;
            rj1.f = 0.0F;
            rj1.C = tdecorateinfo.backgroundAlpha;
            rj1.c = tdecorateinfo.backgroundColor;
            rj1.b = null;
            rj1.o = false;
            rj1.p = true;
            rj1.r = tdecorateinfo.isText();
            rj1.q = tdecorateinfo.type;
            rj1.s = true;
            rj1.t = tdecorateinfo.isBold;
            rj1.u = tdecorateinfo.fontSize;
            rj1.w = tdecorateinfo.fontMaxCount;
            rj1.x = tdecorateinfo.text;
            rj1.v = tdecorateinfo.fontFamily;
            rj1.y = tdecorateinfo.textColor;
            rj1.B = tdecorateinfo.isShadow;
            rj1.F = tdecorateinfo.textAlignment;
            rj1.D = tdecorateinfo.isOutline;
            rj1.E = tdecorateinfo.isItalic;
            rj1.G = tdecorateinfo.lines;
            rj1.H = tdecorateinfo.letterSpace;
            rj1.z = tdecorateinfo.movable;
            rj1.A = tdecorateinfo.editable;
            rj1.J = tdecorateinfo.isBubbleText();
            rj1.K = tdecorateinfo.bubbleTextFrame;
            rj1.L = tdecorateinfo.scale;
            rj1.N = tdecorateinfo.isFlipV;
            rj1.M = tdecorateinfo.isFlipH;
            j1 = tdecorateinfo.fontMaxCount;
            if (tdecorateinfo.text != null)
            {
                i1 = tdecorateinfo.text.length();
            } else
            {
                i1 = 0;
            }
            rj1.I = Math.max(j1, i1);
            obj = rj1;
            if (rj1.q == 19)
            {
                obj = rj1;
                if ((double)tdecorateinfo.scale != 1.0D)
                {
                    obj = rj1;
                    if ((double)tdecorateinfo.scale != 0.0D)
                    {
                        Matrix matrix = new Matrix();
                        if (tdecorateinfo.frame != null)
                        {
                            f1 = (tdecorateinfo.frame.width() / 2.0F) * TPhotoComposeInfo.scale;
                            f2 = (tdecorateinfo.frame.height() / 2.0F) * TPhotoComposeInfo.scale;
                        } else
                        {
                            f1 = 0.0F;
                            f2 = f3;
                        }
                        matrix.postScale(tdecorateinfo.scale, tdecorateinfo.scale, f1, f2);
                        rj1.j = matrix;
                        return rj1;
                    }
                }
            }
        }
        return ((rj) (obj));
    }

    public void a()
    {
        if (u() != null && u().b() != null)
        {
            Log.v(d, (new StringBuilder()).append(d).append("getWeatherModel weather:").append(u().b().d).toString());
            Log.v(d, (new StringBuilder()).append(d).append("getWeatherModel wind_string :").append(u().b().i).toString());
            a(u().b());
        }
    }

    public void a(int i1)
    {
        if (a != null)
        {
            a.a(getResources().getString(0x7f0601a4));
        }
    }

    public void a(View view)
    {
        if (view.requestFocus())
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public void a(TMaskScrollImageView tmaskscrollimageview)
    {
        if (tmaskscrollimageview != null)
        {
            b(tmaskscrollimageview);
        }
    }

    public void a(ArrayList arraylist, int i1)
    {
        Log.v(d, (new StringBuilder()).append(d).append(" DidProcessed").toString());
        if (a != null && isAdded())
        {
            a.d();
        }
        if (arraylist.size() > 0)
        {
            if (1000 == i1)
            {
                a.a(arraylist);
            }
            e();
            w = n();
            if (w.a() == 0.0D && PIPCameraApplication.d != null && PIPCameraApplication.d.a() != 0.0D)
            {
                w.a(PIPCameraApplication.d.a());
                w.b(PIPCameraApplication.d.b());
            }
            if ((q || r) && w.a() != 0.0D)
            {
                if (q)
                {
                    a(w);
                }
                if (r)
                {
                    b(w);
                }
            }
            if (s)
            {
                t();
            }
            Log.v(d, (new StringBuilder()).append(d).append(" DidProcessed openGlCreated : ").append(v).toString());
            if (v)
            {
                p();
                Log.v(d, (new StringBuilder()).append(d).append(" filter process end").toString());
            }
            if (arraylist.size() > 1)
            {
                k();
            }
            arraylist = a.getSharedPreferences("config", 0);
            if (!arraylist.getBoolean("isShowStyleHelp", false))
            {
                arraylist = arraylist.edit();
                arraylist.putBoolean("isShowStyleHelp", true);
                arraylist.commit();
                a.j();
            }
        }
    }

    public void a(rl rl)
    {
        if (rl instanceof rm)
        {
            o.setVisibility(0);
            rj rj1 = new rj();
            if (rl instanceof rm)
            {
                n.setText(((rm)rl).g());
                ((rm)rl).a();
            }
            if (rj1 != null && rj1.a())
            {
                n.setTag(Integer.valueOf(rj1.q));
            } else
            {
                n.setTag(Integer.valueOf(-1));
            }
            if (a != null)
            {
                a.a(false);
            }
            a(((View) (n)));
        }
    }

    public void b()
    {
        ArrayList arraylist = new ArrayList();
        if (a != null)
        {
            List list = a.h();
            if (list == null)
            {
                return;
            }
            for (int i1 = 0; i1 < list.size(); i1++)
            {
                arraylist.add(Uri.parse((String)list.get(i1)));
            }

        }
        Log.v(d, (new StringBuilder()).append(d).append("crop item size:").append(arraylist.size()).toString());
        so so1 = new so();
        so1.a(arraylist);
        e = m();
        if (PIPCameraApplication.b && arraylist.size() > 3 || arraylist.size() >= 5)
        {
            e = 410;
        }
        if ((float)getResources().getDisplayMetrics().widthPixels > 960F || PIPCameraApplication.c >= 64)
        {
            if (arraylist.size() < 5)
            {
                e = 960;
            } else
            {
                e = 612;
            }
        }
        if (!PIPCameraApplication.b && arraylist.size() == 1)
        {
            e = 980;
        }
        Log.v(d, (new StringBuilder()).append(d).append(" KMaxPix :").append(e).toString());
        so1.b(e);
        so1.a(this);
        so1.a(1000);
        so1.c(new ArrayList[0]);
    }

    public void b(View view)
    {
        if (view != null)
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void b(TMaskScrollImageView tmaskscrollimageview)
    {
        if (a != null)
        {
            B = tmaskscrollimageview;
            if (a.g().getInfoCollageType() == CollageType.COLLAGE_MAGZINE)
            {
                e(tmaskscrollimageview);
            }
        }
    }

    public void c()
    {
        if (a != null)
        {
            if (l != null)
            {
                l.clear();
            }
            if (i != null)
            {
                i.removeAllViews();
            }
            if (m != null)
            {
                m.clear();
            }
            if (g != null)
            {
                g.setImageBitmap(null);
            }
            if (h != null)
            {
                h.setImageBitmap(null);
            }
            q = false;
            s = false;
            r = false;
            d();
            e();
            if (w.a() != 0.0D)
            {
                if (q)
                {
                    if (x != null)
                    {
                        a(x);
                    } else
                    {
                        a(w);
                    }
                }
                if (r)
                {
                    b(w);
                }
            }
            if (y != null)
            {
                a(y);
            }
            if (s)
            {
                t();
            }
            if (v)
            {
                p();
                Log.v(d, (new StringBuilder()).append(d).append(" filter process end").toString());
                return;
            }
        }
    }

    public void c(View view)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setStartOffset(1000L);
        alphaanimation.setDuration(1000L);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(alphaanimation);
        animationset.setRepeatCount(0);
        animationset.setFillEnabled(true);
        animationset.setFillAfter(false);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener(view) {

            final View a;
            final MagComposeFragement b;

            public void onAnimationEnd(Animation animation)
            {
                a.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                b = MagComposeFragement.this;
                a = view;
                super();
            }
        });
        view.startAnimation(animationset);
    }

    public void d()
    {
        float f1;
        float f2;
        float f3;
        float f4;
        Object obj;
        Object obj1;
        obj = getResources().getDisplayMetrics();
        f2 = ((DisplayMetrics) (obj)).widthPixels;
        f3 = (float)((DisplayMetrics) (obj)).widthPixels / (float)((DisplayMetrics) (obj)).heightPixels;
        f4 = a.g().width / a.g().height;
        f1 = f2 / a.g().width;
        K = 1.0F;
        obj1 = TPhotoComposeInfo.getInstaMagType(a.g());
        if (obj1 != InstaMagType.RECT_LIB_SIZE_TYPE) goto _L2; else goto _L1
_L1:
        K = j();
_L4:
        f1 *= K;
        TPhotoComposeInfo.scale = f1;
        G = false;
        if (f3 > f4)
        {
            Log.v(d, "Using height as scale referance");
            f1 = ((float)((DisplayMetrics) (obj)).heightPixels / a.g().height) * K;
            TPhotoComposeInfo.scale = f1;
            G = true;
        }
        obj1 = (android.widget.FrameLayout.LayoutParams)k.getLayoutParams();
        obj1.width = (int)(f2 * K);
        obj1.height = (int)(a.g().height * f1);
        if (G)
        {
            obj1.width = (int)(f1 * a.g().width);
            obj1.height = (int)((float)((DisplayMetrics) (obj)).heightPixels * K);
        }
        Log.v(d, (new StringBuilder()).append(d).append(" width:").append(((android.widget.FrameLayout.LayoutParams) (obj1)).width).append(" height:").append(((android.widget.FrameLayout.LayoutParams) (obj1)).height).append(" top:").append(((android.widget.FrameLayout.LayoutParams) (obj1)).topMargin).append(" left:").append(((android.widget.FrameLayout.LayoutParams) (obj1)).leftMargin).toString());
        obj1.gravity = 17;
        k.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        obj = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (obj1)).width, ((android.widget.FrameLayout.LayoutParams) (obj1)).height);
        if (j != null)
        {
            k.removeView(j);
            j = null;
        }
        j = new TDecorateInfosLayerView(getActivity());
        obj.gravity = 51;
        k.addView(j, 2, ((android.view.ViewGroup.LayoutParams) (obj)));
        j.setTextClickListener(this);
        return;
_L2:
        if (obj1 == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            K = 0.9F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void e()
    {
        TPhotoComposeInfo tphotocomposeinfo;
        Object obj;
        boolean flag;
label0:
        {
            flag = false;
            Log.v(d, (new StringBuilder()).append(d).append(" generateComposeView").toString());
            if (a != null && a.g() != null)
            {
                tphotocomposeinfo = a.g();
                g.setBackgroundColor(tphotocomposeinfo.backgroundColor);
                if (tphotocomposeinfo.backgoundImagePath != null && tphotocomposeinfo.backgoundImagePath.length() > 0)
                {
                    try
                    {
                        g.setImageBitmap(tphotocomposeinfo.getBitmapByPath(tphotocomposeinfo.backgoundImagePath));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((Exception) (obj)).printStackTrace();
                        Crashlytics.logException(((Throwable) (obj)));
                    }
                }
                obj = a.i();
                if (obj != null)
                {
                    break label0;
                }
            }
            return;
        }
        Log.v(d, (new StringBuilder()).append(d).append("imageBitmaps size :").append(((ArrayList) (obj)).size()).toString());
        for (int i1 = 0; i1 < ((ArrayList) (obj)).size(); i1++)
        {
            Object obj2 = (Bitmap)((ArrayList) (obj)).get(i1);
            if (tphotocomposeinfo.photoMaskInfoArray != null && i1 < tphotocomposeinfo.photoMaskInfoArray.size())
            {
                TPhotoMaskInfo tphotomaskinfo = (TPhotoMaskInfo)tphotocomposeinfo.photoMaskInfoArray.get(i1);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(Math.round(TPhotoComposeInfo.getScaledValue(tphotomaskinfo.backgroundFrame.width())), Math.round(TPhotoComposeInfo.getScaledValue(tphotomaskinfo.backgroundFrame.height())));
                layoutparams.setMargins(Math.round(TPhotoComposeInfo.getScaledValue(tphotomaskinfo.backgroundFrame.left)), Math.round(TPhotoComposeInfo.getScaledValue(tphotomaskinfo.backgroundFrame.top)), 0, 0);
                layoutparams.gravity = 51;
                obj2 = new TMaskScrollImageView(a, tphotomaskinfo, ((Bitmap) (obj2)));
                i.addView(((View) (obj2)), layoutparams);
                l.add(obj2);
                ((TMaskScrollImageView) (obj2)).setLongClickDelegate(this);
                ((TMaskScrollImageView) (obj2)).setImageMovingDelegate(this);
                ((TMaskScrollImageView) (obj2)).setMaskDelegate(this);
                ((TMaskScrollImageView) (obj2)).setTag(Integer.valueOf(i1));
            }
        }

        m.clear();
        if (tphotocomposeinfo.decorateInfoArray != null)
        {
            for (int j1 = ((flag) ? 1 : 0); j1 < tphotocomposeinfo.decorateInfoArray.size(); j1++)
            {
                Object obj1 = (TDecorateInfo)tphotocomposeinfo.decorateInfoArray.get(j1);
                if (((TDecorateInfo) (obj1)).isLocation())
                {
                    q = true;
                }
                if (((TDecorateInfo) (obj1)).isTime())
                {
                    s = true;
                }
                if (((TDecorateInfo) (obj1)).isWeather())
                {
                    r = true;
                }
                obj1 = a(((TDecorateInfo) (obj1)), j1);
                m.add(obj1);
            }

        }
        j.configByInfos(m);
        h.setBackgroundColor(tphotocomposeinfo.foregroundColor);
        if (tphotocomposeinfo.foregroundImagePath != null && tphotocomposeinfo.foregroundImagePath.length() > 0)
        {
            try
            {
                h.setImageBitmap(tphotocomposeinfo.getBitmapByPath(tphotocomposeinfo.foregroundImagePath));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                Crashlytics.logException(exception);
            }
        }
        q();
    }

    public void f()
    {
        if (A != null)
        {
            A.setVisibility(4);
        }
    }

    public void g()
    {
        if (A != null)
        {
            A.setVisibility(4);
        }
        if (a != null)
        {
            a.a(a.getResources().getString(0x7f0601a4));
        }
        Object obj = a.g();
        int i1;
        int j1;
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("resId", String.format("%d", new Object[] {
                Integer.valueOf(((TPhotoComposeInfo) (obj)).resId)
            }));
            FlurryAgent.logEvent("useMag", hashmap);
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        a.e().updateUseCountByResId(((TPhotoComposeInfo) (obj)).resId, ((TPhotoComposeInfo) (obj)).useCount + 1);
        obj = a(((TPhotoComposeInfo) (obj)));
        i1 = (int)((rb) (obj)).a;
        j1 = (int)((rb) (obj)).b;
        Log.v(d, (new StringBuilder()).append(d).append("makeResultImage before").toString());
        obj = a(i1, j1);
        if (obj == null)
        {
            a.d();
        }
        Log.v(d, (new StringBuilder()).append(d).append("makeResultImage end").toString());
        (new Thread(new Runnable(((Bitmap) (obj))) {

            final Bitmap a;
            final MagComposeFragement b;

            public void run()
            {
                if (b.a == null)
                {
                    return;
                }
                Object obj1 = rd.a(a);
                if (obj1 == null)
                {
                    b.a.d();
                    b.a.runOnUiThread(new Runnable(this) {

                        final _cls4 a;

                        public void run()
                        {
                            Toast.makeText(a.b.a, a.b.a.getResources().getString(0x7f060196), 0).show();
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                    return;
                } else
                {
                    rd.a(((File) (obj1)).getAbsolutePath(), b.a);
                    obj1 = Uri.fromFile(((File) (obj1)));
                    b.a.runOnUiThread(new Runnable(this, ((Uri) (obj1))) {

                        final Uri a;
                        final _cls4 b;

                        public void run()
                        {
                            if (b.b.a != null)
                            {
                                b.b.a.d();
                                Log.v(MagComposeFragement.e(b.b), (new StringBuilder()).append(MagComposeFragement.e(b.b)).append("write ResultImage end").toString());
                                if (b.a != null && !b.a.isRecycled())
                                {
                                    b.a.recycle();
                                }
                                if (a != null)
                                {
                                    Intent intent = new Intent(b.b.getActivity(), com/pipcamera/activity/NewPhotoShareActivity);
                                    intent.putExtra("PhotoShareActivity_ToShareImageUri", a.toString());
                                    if (b.b.a.g().isShouldFirst())
                                    {
                                        String s1 = b.b.a.g().shareTag;
                                        if (s1 != null && s1.length() > 0)
                                        {
                                            intent.putExtra("share_tag", s1);
                                        }
                                    }
                                    b.b.startActivity(intent);
                                    b.b.a.overridePendingTransition(0x7f040007, 0);
                                    return;
                                }
                            }
                        }

            
            {
                b = _pcls4;
                a = uri;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                b = MagComposeFragement.this;
                a = bitmap;
                super();
            }
        })).start();
    }

    public void h()
    {
        if (l != null && l.size() > 0)
        {
            int j1 = l.size();
            ArrayList arraylist = new ArrayList(j1);
            for (int i1 = 0; i1 < j1; i1++)
            {
                Rect rect = new Rect();
                android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)((TMaskScrollImageView)l.get(i1)).getLayoutParams();
                int k1 = layoutparams.leftMargin;
                int l1 = layoutparams.topMargin;
                int i2 = layoutparams.width;
                int j2 = layoutparams.height;
                rect.left = k1;
                rect.right = k1 + i2;
                rect.top = l1;
                rect.bottom = j2 + l1;
                arraylist.add(rect);
            }

            c.setTargetRects(arraylist);
            c.setDelegate(this);
        }
    }

    public void i()
    {
        TPhotoComposeInfo tphotocomposeinfo = a.g();
        if (!tphotocomposeinfo.isHFlip || !tphotocomposeinfo.isVFlip) goto _L2; else goto _L1
_L1:
        Object obj;
        android.widget.FrameLayout.LayoutParams layoutparams;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if (I == FlipViewType.FLIP_NORMAL)
        {
            obj = FlipViewType.FLIP_HORIZONTAL;
        } else
        if (I == FlipViewType.FLIP_HORIZONTAL)
        {
            obj = FlipViewType.FLIP_HORIZONTAL_AND_VERTICAL;
        } else
        if (I == FlipViewType.FLIP_HORIZONTAL_AND_VERTICAL)
        {
            obj = FlipViewType.FLIP_VERTICAL;
        } else
        {
            obj = FlipViewType.FLIP_NORMAL;
        }
_L22:
        I = ((FlipViewType) (obj));
_L10:
        j2 = k.getWidth();
        k2 = k.getHeight();
        k1 = l.size() - 1;
_L9:
        if (k1 < 0) goto _L4; else goto _L3
_L3:
        obj = (TMaskScrollImageView)l.get(k1);
        layoutparams = (android.widget.FrameLayout.LayoutParams)((TMaskScrollImageView) (obj)).getLayoutParams();
        l1 = layoutparams.leftMargin;
        i2 = layoutparams.topMargin;
        i1 = layoutparams.width;
        l2 = layoutparams.height;
        if (!tphotocomposeinfo.isHFlip || !tphotocomposeinfo.isVFlip) goto _L6; else goto _L5
_L5:
        if (I != FlipViewType.FLIP_HORIZONTAL && I != FlipViewType.FLIP_VERTICAL) goto _L8; else goto _L7
_L7:
        j1 = j2 - i1 - l1;
        i1 = i2;
_L13:
        layoutparams.setMargins(j1, i1, 0, 0);
        ((TMaskScrollImageView) (obj)).setLayoutParams(layoutparams);
        k1--;
          goto _L9
_L2:
        if (tphotocomposeinfo.isHFlip)
        {
            FlipViewType flipviewtype;
            if (I == FlipViewType.FLIP_NORMAL)
            {
                flipviewtype = FlipViewType.FLIP_HORIZONTAL;
            } else
            {
                flipviewtype = FlipViewType.FLIP_NORMAL;
            }
            I = flipviewtype;
        } else
        if (tphotocomposeinfo.isVFlip)
        {
            FlipViewType flipviewtype1;
            if (I == FlipViewType.FLIP_NORMAL)
            {
                flipviewtype1 = FlipViewType.FLIP_VERTICAL;
            } else
            {
                flipviewtype1 = FlipViewType.FLIP_NORMAL;
            }
            I = flipviewtype1;
        }
          goto _L10
_L8:
        if (I == FlipViewType.FLIP_NORMAL) goto _L12; else goto _L11
_L11:
        i1 = i2;
        j1 = l1;
        if (I != FlipViewType.FLIP_HORIZONTAL_AND_VERTICAL) goto _L13; else goto _L12
_L12:
        i1 = k2 - l2 - i2;
        j1 = l1;
          goto _L13
_L6:
        if (tphotocomposeinfo.isHFlip)
        {
            j1 = j2 - i1 - l1;
            i1 = i2;
        } else
        {
            i1 = i2;
            j1 = l1;
            if (tphotocomposeinfo.isVFlip)
            {
                i1 = k2 - l2 - i2;
                j1 = l1;
            }
        }
          goto _L13
_L4:
        Log.d(d, (new StringBuilder()).append(d).append(" _decorateInfosLayer flipOrientation type:").append(I).toString());
        if (!tphotocomposeinfo.isHFlip || !tphotocomposeinfo.isVFlip) goto _L15; else goto _L14
_L14:
        if (I != FlipViewType.FLIP_HORIZONTAL && I != FlipViewType.FLIP_VERTICAL) goto _L17; else goto _L16
_L16:
        if (j != null)
        {
            j.setLayerFlipType(FlipViewType.FLIP_HORIZONTAL);
        }
        a(FlipViewType.FLIP_HORIZONTAL);
_L19:
        return;
_L17:
        if (I != FlipViewType.FLIP_NORMAL && I != FlipViewType.FLIP_HORIZONTAL_AND_VERTICAL) goto _L19; else goto _L18
_L18:
        j.setLayerFlipType(FlipViewType.FLIP_VERTICAL);
        a(FlipViewType.FLIP_VERTICAL);
        return;
_L15:
        if (tphotocomposeinfo.isHFlip)
        {
            j.setLayerFlipType(FlipViewType.FLIP_HORIZONTAL);
            a(FlipViewType.FLIP_HORIZONTAL);
            return;
        }
        if (!tphotocomposeinfo.isVFlip) goto _L19; else goto _L20
_L20:
        j.setLayerFlipType(FlipViewType.FLIP_VERTICAL);
        a(FlipViewType.FLIP_VERTICAL);
        return;
        if (true) goto _L22; else goto _L21
_L21:
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = (MagComposeActivity)activity;
        Log.d(d, (new StringBuilder()).append(d).append(": ").append("onAttach").toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.v(d, (new StringBuilder()).append(d).append(" onCreateView ").toString());
        layoutinflater = layoutinflater.inflate(0x7f030048, viewgroup, false);
        b = (HorizontalListView)layoutinflater.findViewById(0x7f0c0150);
        l();
        A = (FrameLayout)layoutinflater.findViewById(0x7f0c014f);
        A.setOnTouchListener(new android.view.View.OnTouchListener() {

            final MagComposeFragement a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                MagComposeFragement.a(a).setVisibility(4);
                return true;
            }

            
            {
                a = MagComposeFragement.this;
                super();
            }
        });
        c = (ImagesMovingView)layoutinflater.findViewById(0x7f0c014c);
        g = (ImageView)layoutinflater.findViewById(0x7f0c0149);
        i = (FrameLayout)layoutinflater.findViewById(0x7f0c014a);
        h = (ImageView)layoutinflater.findViewById(0x7f0c014b);
        k = (FrameLayout)layoutinflater.findViewById(0x7f0c0148);
        o = (RelativeLayout)layoutinflater.findViewById(0x7f0c014d);
        n = (EditText)layoutinflater.findViewById(0x7f0c00ce);
        n.clearFocus();
        getActivity().getWindow().setSoftInputMode(0);
        ((Button)layoutinflater.findViewById(0x7f0c014e)).setOnClickListener(new android.view.View.OnClickListener() {

            final MagComposeFragement a;

            public void onClick(View view)
            {
                MagComposeFragement.c(a).setCurSelectedDecorateText(MagComposeFragement.b(a).getText().toString());
                if (MagComposeFragement.b(a).getTag() != null && (MagComposeFragement.b(a).getTag() instanceof Integer) && (((Integer)MagComposeFragement.b(a).getTag()).intValue() == 5 || ((Integer)MagComposeFragement.b(a).getTag()).intValue() == 10 || ((Integer)MagComposeFragement.b(a).getTag()).intValue() == 9))
                {
                    MagComposeFragement.a(a, MagComposeFragement.b(a).getText().toString(), ((Integer)MagComposeFragement.b(a).getTag()).intValue());
                }
                if (a.a != null)
                {
                    a.a.a(true);
                }
                a.b(MagComposeFragement.b(a));
                MagComposeFragement.b(a).clearFocus();
                MagComposeFragement.d(a).setVisibility(4);
            }

            
            {
                a = MagComposeFragement.this;
                super();
            }
        });
        viewgroup = getResources().getDisplayMetrics();
        float f2 = ((DisplayMetrics) (viewgroup)).widthPixels;
        float f3 = (float)((DisplayMetrics) (viewgroup)).widthPixels / (float)((DisplayMetrics) (viewgroup)).heightPixels;
        float f4 = a.g().width / a.g().height;
        float f1 = f2 / a.g().width;
        K = 1.0F;
        bundle = TPhotoComposeInfo.getInstaMagType(a.g());
        if (bundle == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            K = j();
        } else
        if (bundle == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            K = 0.9F;
        }
        f1 *= K;
        TPhotoComposeInfo.scale = f1;
        if (f3 > f4)
        {
            Log.v(d, "Using height as scale referance");
            f1 = ((float)((DisplayMetrics) (viewgroup)).heightPixels / a.g().height) * K;
            TPhotoComposeInfo.scale = f1;
            G = true;
        }
        bundle = (android.widget.FrameLayout.LayoutParams)k.getLayoutParams();
        bundle.width = (int)(f2 * K);
        bundle.height = (int)(a.g().height * f1);
        if (G)
        {
            bundle.width = (int)(f1 * a.g().width);
            bundle.height = (int)((float)((DisplayMetrics) (viewgroup)).heightPixels * K);
        }
        k.setLayoutParams(bundle);
        viewgroup = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (bundle)).width, ((android.widget.FrameLayout.LayoutParams) (bundle)).height);
        j = new TDecorateInfosLayerView(getActivity());
        viewgroup.gravity = 51;
        k.addView(j, 2, viewgroup);
        j.setTextClickListener(this);
        viewgroup = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (bundle)).width, ((android.widget.FrameLayout.LayoutParams) (bundle)).height);
        L = new TDecorateInfosLayerTextHelpView(getActivity());
        L.setClickable(false);
        L.setFocusable(false);
        L.setEnabled(false);
        L.setVisibility(4);
        k.addView(L, 3, viewgroup);
        if (a.i() == null)
        {
            b();
        } else
        {
            c();
        }
        d(layoutinflater);
        return layoutinflater;
    }

    public void onDestroy()
    {
        Log.v(d, (new StringBuilder()).append(d).append(" onDestroy").toString());
        super.onDestroy();
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        if (J != null && J.getItem(i1) != null && (J.getItem(i1) instanceof TImageFilterInfo))
        {
            int j1 = b.getLastVisiblePosition() - 1;
            int k1 = b.getFirstVisiblePosition() + 1;
            Log.v(d, (new StringBuilder()).append("selected : ").append(i1).append(" first:").append(k1).append(" last : ").append(j1).append(" count: ").append(b.getAdapter().getCount()).toString());
            if (i1 >= j1 && i1 != b.getAdapter().getCount() - 1)
            {
                b.scrollTo(pb.a(getActivity(), 54F) * (i1 - 3));
            } else
            if (i1 <= k1 && i1 != 0)
            {
                b.scrollTo(pb.a(getActivity(), 54F) * (i1 - 1));
            }
            b(i1);
            adapterview = (TImageFilterInfo)J.getItem(i1);
            if (B != null && f != null && a != null)
            {
                i1 = ((Integer)B.getTag()).intValue();
                if (i1 < a.i().size())
                {
                    adapterview = ((TImageFilterInfo) (adapterview)).filterName;
                    Log.v(d, (new StringBuilder()).append(d).append("filter Selected  filterName:").append(adapterview).toString());
                    view = (Bitmap)a.i().get(i1);
                    B.processImageByFilterName(f, adapterview, view);
                    return;
                }
            }
        }
    }

    public boolean onLongClick(View view)
    {
        if (l.size() < 2)
        {
            return false;
        }
        if (c != null)
        {
            h();
            a(false);
            c.setVisibility(0);
        }
        if (view instanceof MaskScrollImageViewTouch)
        {
            view = (android.widget.FrameLayout.LayoutParams)((TMaskScrollImageView)((MaskScrollImageViewTouch)view).getParent()).getLayoutParams();
            int i1 = ((android.widget.FrameLayout.LayoutParams) (view)).leftMargin;
            int j1 = ((android.widget.FrameLayout.LayoutParams) (view)).topMargin;
            int k1 = ((android.widget.FrameLayout.LayoutParams) (view)).width;
            int l1 = ((android.widget.FrameLayout.LayoutParams) (view)).height;
            view = new Rect();
            view.left = i1;
            view.right = k1 + i1;
            view.top = j1;
            view.bottom = l1 + j1;
            E = i1;
            F = j1;
            if (c != null)
            {
                c.setStartRectAndBitmap(view, null);
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
        if (f != null)
        {
            f.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (f != null && f.getRender() != null)
        {
            f.onResume();
        }
        Log.d(d, (new StringBuilder()).append(d).append(": ").append("onResume").toString());
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        Log.v(d, (new StringBuilder()).append(d).append("surfaceChanged").toString());
        v = true;
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.v(d, (new StringBuilder()).append(d).append("surfaceCreated").toString());
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        v = false;
        Log.v(d, (new StringBuilder()).append(d).append("surfaceDestroyed").toString());
    }
}
