// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.f;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.GLES10;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import bo.app.eo;
import com.appboy.enums.ErrorType;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.internal.l;
import com.photo.effect.Effect;
import com.photo.effect.EffectParameter;
import com.picsart.collages.SPArrow;
import com.picsart.effectnew.EffectsDrawHistoryController;
import com.picsart.effects.clone.CloneActivity;
import com.picsart.effects.clone.CloneActivityMainProcess;
import com.picsart.effects.colorsplash.ColorSplashActivity;
import com.picsart.effects.colorsplash.ColorSplashActivityMainProcess;
import com.picsart.studio.ItemType;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.ads.c;
import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.ads.AdProviders;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.model.card.Card;
import com.socialin.android.billing.Base64DecoderException;
import com.socialin.android.billing.b;
import com.socialin.android.d;
import com.socialin.android.photo.draw.DrawingActivity;
import com.socialin.android.photo.draw.DrawingActivityMainProcess;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.imgop.ImageResize;
import com.socialin.android.picsart.profile.util.g;
import com.socialin.android.picsart.profile.util.j;
import com.socialin.android.picsart.profile.util.k;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ac;
import com.socialin.android.util.e;
import com.socialin.android.util.h;
import com.socialin.android.util.t;
import com.socialin.android.util.w;
import com.socialin.asyncnet.Request;
import com.socialin.gson.Gson;
import com.stripe.android.picsart.StripeIAPController;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Set;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import myobfuscated.ao.p;
import myobfuscated.cr.f;
import myobfuscated.df.a;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;

public class m
{

    public static String c;
    public static String d;
    public static String e;
    public final ErrorType a;
    public final String b;

    public m(ErrorType errortype, String s)
    {
        a = errortype;
        b = s;
    }

    public m(JSONObject jsonobject)
    {
        a = (ErrorType)eo.a(jsonobject, "type", com/appboy/enums/ErrorType);
        b = jsonobject.getString("message");
    }

    public static float a(SPArrow sparrow, SPArrow sparrow1, SPArrow sparrow2)
    {
        sparrow = sparrow.subtractArrow(sparrow1);
        sparrow1 = sparrow2.subtractArrow(sparrow1);
        float f1 = sparrow.getLength();
        float f2 = sparrow1.getLength();
        if (0.0F == f1 || 0.0F == f2)
        {
            return 0.0F;
        } else
        {
            return (float)((Math.sin(SPArrow.angleBetweenArrows(sparrow, sparrow1)) * (double)f1 * (double)f2) / 2D);
        }
    }

    public static int a()
    {
        byte byte0 = -1;
        int i1;
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            android.opengl.EGLDisplay egldisplay = EGL14.eglGetDisplay(0);
            Object aobj[] = new int[2];
            EGL14.eglInitialize(egldisplay, ((int []) (aobj)), 0, ((int []) (aobj)), 1);
            aobj = new EGLConfig[1];
            int ai[] = new int[1];
            EGL14.eglChooseConfig(egldisplay, new int[] {
                12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344
            }, 0, ((EGLConfig []) (aobj)), 0, 1, ai, 0);
            if (ai[0] == 0)
            {
                i1 = -1;
            } else
            {
                Object obj = aobj[0];
                android.opengl.EGLSurface eglsurface = EGL14.eglCreatePbufferSurface(egldisplay, ((EGLConfig) (obj)), new int[] {
                    12375, 64, 12374, 64, 12344
                }, 0);
                obj = EGL14.eglCreateContext(egldisplay, ((EGLConfig) (obj)), EGL14.EGL_NO_CONTEXT, new int[] {
                    12440, 2, 12344
                }, 0);
                EGL14.eglMakeCurrent(egldisplay, eglsurface, eglsurface, ((android.opengl.EGLContext) (obj)));
                int ai1[] = new int[1];
                GLES20.glGetIntegerv(3379, ai1, 0);
                EGL14.eglDestroySurface(egldisplay, eglsurface);
                EGL14.eglDestroyContext(egldisplay, ((android.opengl.EGLContext) (obj)));
                EGL14.eglTerminate(egldisplay);
                i1 = ai1[0];
            }
        } else
        {
            i1 = -1;
        }
        if (i1 <= 0)
        {
            EGL10 egl10 = (EGL10)EGLContext.getEGL();
            javax.microedition.khronos.egl.EGLDisplay egldisplay1 = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(egldisplay1, new int[2]);
            javax.microedition.khronos.egl.EGLConfig aeglconfig[] = new javax.microedition.khronos.egl.EGLConfig[1];
            int ai2[] = new int[1];
            egl10.eglChooseConfig(egldisplay1, new int[] {
                12351, 12430, 12329, 0, 12339, 1, 12344
            }, aeglconfig, 1, ai2);
            i1 = byte0;
            if (ai2[0] != 0)
            {
                Object obj1 = aeglconfig[0];
                javax.microedition.khronos.egl.EGLSurface eglsurface1 = egl10.eglCreatePbufferSurface(egldisplay1, ((javax.microedition.khronos.egl.EGLConfig) (obj1)), new int[] {
                    12375, 64, 12374, 64, 12344
                });
                obj1 = egl10.eglCreateContext(egldisplay1, ((javax.microedition.khronos.egl.EGLConfig) (obj1)), EGL10.EGL_NO_CONTEXT, new int[] {
                    12440, 1, 12344
                });
                egl10.eglMakeCurrent(egldisplay1, eglsurface1, eglsurface1, ((EGLContext) (obj1)));
                int ai3[] = new int[1];
                GLES10.glGetIntegerv(3379, ai3, 0);
                egl10.eglMakeCurrent(egldisplay1, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroySurface(egldisplay1, eglsurface1);
                egl10.eglDestroyContext(egldisplay1, ((EGLContext) (obj1)));
                egl10.eglTerminate(egldisplay1);
                return ai3[0];
            }
        }
        return i1;
    }

    public static int a(int i1)
    {
        return (int)Math.pow(2D, Math.ceil(Math.log(i1) / Math.log(2D)));
    }

    private static int a(int i1, String s)
    {
        i1 = GLES20.glCreateShader(i1);
        if (i1 != 0)
        {
            GLES20.glShaderSource(i1, s);
            GLES20.glCompileShader(i1);
        }
        return i1;
    }

    public static int a(Activity activity, int i1)
    {
        android.hardware.Camera.CameraInfo camerainfo;
        boolean flag;
        flag = false;
        camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i1, camerainfo);
        i1 = ((flag) ? 1 : 0);
        activity.getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 60
    //                   0 62
    //                   1 89
    //                   2 95
    //                   3 102;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_102;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = ((flag) ? 1 : 0);
_L6:
        if (camerainfo.facing == 1)
        {
            return (360 - (i1 + camerainfo.orientation) % 360) % 360;
        } else
        {
            return ((camerainfo.orientation - i1) + 360) % 360;
        }
_L3:
        i1 = 90;
          goto _L6
_L4:
        i1 = 180;
          goto _L6
        i1 = 270;
          goto _L6
    }

    public static int a(EffectParameter effectparameter)
    {
        int i1 = ((Integer)effectparameter.c()).intValue();
        int j1 = ((Integer)effectparameter.d()).intValue();
        int k1 = ((Integer)effectparameter.b()).intValue();
        int l1 = c(effectparameter);
        return (int)(((float)(k1 - i1) / (float)(j1 - i1)) * (float)l1);
    }

    public static int a(String s, int i1)
    {
        int ai[] = new int[1];
        i1 = GLES20.glCreateShader(i1);
        GLES20.glShaderSource(i1, s);
        GLES20.glCompileShader(i1);
        GLES20.glGetShaderiv(i1, 35713, ai, 0);
        if (ai[0] == 0)
        {
            (new StringBuilder("Compilation\n")).append(GLES20.glGetShaderInfoLog(i1));
            return 0;
        } else
        {
            return i1;
        }
    }

    private static android.hardware.Camera.Size a(ArrayList arraylist, float f1, float f2)
    {
        float f3 = 3.402823E+38F;
        android.hardware.Camera.Size size = null;
        for (int i1 = 0; i1 < arraylist.size(); i1++)
        {
            android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)arraylist.get(i1);
            float f4 = Math.abs((float)size1.width / (float)size1.height - f1);
            if (f4 <= f2 && f4 <= f3)
            {
                f3 = f4;
                size = size1;
            }
        }

        return size;
    }

    private static android.hardware.Camera.Size a(ArrayList arraylist, int i1, float f1)
    {
        float f4 = i1;
        android.hardware.Camera.Size size = null;
        int j1 = 0;
        for (float f2 = 0.0F; j1 < 2; f2 += 0.2F * f4)
        {
            ArrayList arraylist1 = new ArrayList(arraylist.size());
            for (int k1 = 0; k1 < arraylist.size(); k1++)
            {
                android.hardware.Camera.Size size1 = ((a)arraylist.get(k1)).b;
                int i2 = size1.width;
                int j2 = size1.height;
                if ((float)i2 <= (float)i1 + f2 && (float)j2 <= (float)i1 + f2 && ((float)Math.abs(i2 - i1) <= f2 || (float)Math.abs(j2 - i1) <= f2))
                {
                    arraylist1.add(size1);
                }
            }

            int l1 = 0;
            for (float f3 = 0.0F; l1 < 3; f3 = 0.1F + f3)
            {
                size = a(arraylist1, f1, f3);
                if (size != null)
                {
                    return size;
                }
                l1++;
            }

            j1++;
        }

        return size;
    }

    private static android.hardware.Camera.Size a(ArrayList arraylist, int i1, int j1)
    {
        double d1;
        double d3;
        int k1;
        d1 = j1 / 4;
        d3 = j1 / 3;
        k1 = 0;
_L8:
        if (k1 >= 3) goto _L2; else goto _L1
_L1:
        double d5;
        int l1;
        d5 = (new double[] {
            0.050000000000000003D, 0.10000000000000001D, 0.14999999999999999D
        })[k1];
        l1 = 0;
_L7:
        if (l1 >= 2) goto _L4; else goto _L3
_L3:
        android.hardware.Camera.Size size = a(arraylist, i1, j1, d5, (new double[] {
            d1, d3
        })[l1]);
        if (size == null) goto _L6; else goto _L5
_L5:
        return size;
_L6:
        l1++;
          goto _L7
_L4:
        k1++;
          goto _L8
_L2:
        android.hardware.Camera.Size size2;
        size2 = b(arraylist, i1, j1, 0.050000000000000003D, 1.7976931348623157E+308D);
        size = size2;
        if (size2 != null) goto _L5; else goto _L9
_L9:
        size2 = b(arraylist, i1, j1, 0.10000000000000001D, 1.7976931348623157E+308D);
        size = size2;
        if (size2 != null) goto _L5; else goto _L10
_L10:
        size2 = a(arraylist, i1, j1, 0.050000000000000003D, 1.7976931348623157E+308D);
        size = size2;
        if (size2 != null) goto _L5; else goto _L11
_L11:
        if (size2 == null)
        {
            double d2 = 1.7976931348623157E+308D;
            android.hardware.Camera.Size size1 = size2;
            i1 = 0;
            do
            {
                size2 = size1;
                if (i1 >= arraylist.size())
                {
                    break;
                }
                size2 = ((a)arraylist.get(i1)).a;
                double d4 = d2;
                if ((double)Math.abs(size2.height - j1) < d2)
                {
                    d4 = Math.abs(size2.height - j1);
                    size1 = size2;
                }
                i1++;
                d2 = d4;
            } while (true);
        }
        return size2;
          goto _L7
    }

    private static android.hardware.Camera.Size a(ArrayList arraylist, int i1, int j1, double d1, double d2)
    {
        double d3 = (double)i1 / (double)j1;
        android.hardware.Camera.Size size = null;
        for (i1 = 0; i1 < arraylist.size(); i1++)
        {
            android.hardware.Camera.Size size1 = ((a)arraylist.get(i1)).a;
            if (Math.abs((double)size1.width / (double)size1.height - d3) <= d1 && (double)Math.abs(size1.height - j1) < d2)
            {
                d2 = Math.abs(size1.height - j1);
                size = size1;
            }
        }

        return size;
    }

    private static android.hardware.Camera.Size a(ArrayList arraylist, int i1, int j1, Point point, Point point1, int k1)
    {
        Object obj = null;
        float f1 = (float)i1 / (float)j1;
        j1 = Math.max(0, point.x - k1);
        int l1 = Math.max(0, point.y - k1);
        int i2 = point1.x;
        int j2 = point1.y;
        i1 = 0;
        point = obj;
        for (; i1 < arraylist.size(); i1++)
        {
            point1 = ((a)arraylist.get(i1)).b;
            if (((android.hardware.Camera.Size) (point1)).width >= j1 && ((android.hardware.Camera.Size) (point1)).width <= i2 + k1 && ((android.hardware.Camera.Size) (point1)).height >= l1 && ((android.hardware.Camera.Size) (point1)).height <= j2 + k1 && Math.abs((float)((android.hardware.Camera.Size) (point1)).width / (float)((android.hardware.Camera.Size) (point1)).height - f1) < 3.402823E+38F)
            {
                point = point1;
            }
        }

        return point;
    }

    public static Bundle a(Map map)
    {
        Bundle bundle = new Bundle();
        if (map != null)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); bundle.putString((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        return bundle;
    }

    public static View a(Activity activity, int i1, boolean flag)
    {
        return a(activity, i1, flag, Integer.valueOf(0x7f0300e6));
    }

    public static View a(Activity activity, int i1, boolean flag, Integer integer)
    {
        integer = activity.getLayoutInflater().inflate(integer.intValue(), null, false);
        ((Button)integer.findViewById(0x7f1004c1)).setText(activity.getString(0x7f0805b4));
        if (flag)
        {
            ((TextView)integer.findViewById(0x7f1004c0)).setText(activity.getString(i1));
        } else
        {
            integer.findViewById(0x7f1004c0).setVisibility(8);
        }
        if (integer.findViewById(0x7f1004c1).getLayoutParams() instanceof android.widget.RelativeLayout.LayoutParams)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(Utils.c(activity), (int)Utils.a(48F, activity));
            layoutparams.addRule(14);
            layoutparams.addRule(12);
            integer.findViewById(0x7f1004c1).setLayoutParams(layoutparams);
        }
        integer.findViewById(0x7f1004c1).setOnClickListener(new k(activity));
        return integer;
    }

    public static View a(Context context, int i1)
    {
        if (context == null)
        {
            return null;
        } else
        {
            TextView textview = new TextView(context);
            textview.setGravity(17);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            layoutparams.gravity = 17;
            textview.setText(context.getString(i1));
            textview.setTextColor(context.getResources().getColor(0x7f0f0091));
            textview.setTextSize(2, 18F);
            textview.setLayoutParams(layoutparams);
            return textview;
        }
    }

    public static View a(Context context, com.socialin.android.adapter.a a1, ViewGroup viewgroup)
    {
        if (context == null)
        {
            return null;
        } else
        {
            context = LayoutInflater.from(context).inflate(0x7f030201, viewgroup, false);
            context.findViewById(0x7f1004c1).setOnClickListener(new j(a1));
            return context;
        }
    }

    public static View a(f f1)
    {
        View view = f1.getActivity().getLayoutInflater().inflate(0x7f03020b, null, false);
        view.findViewById(0x7f100979).setOnClickListener(new g(f1));
        return view;
    }

    public static TextView a(Activity activity)
    {
        return (TextView)activity.findViewById(0x7f100399);
    }

    public static TextView a(Dialog dialog)
    {
        return (TextView)dialog.findViewById(0x7f100399);
    }

    public static Toast a(int i1, Context context)
    {
        return a(context.getResources().getString(i1), context, 0);
    }

    public static Toast a(String s, Context context, int i1)
    {
        s = Toast.makeText(context, s, i1);
        s.setGravity(17, 0, 0);
        return s;
    }

    public static GoogleApiClient a(Context context)
    {
        return (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(AppIndex.APP_INDEX_API).build();
    }

    public static SPArrow a(SPArrow sparrow, SPArrow sparrow1, SPArrow sparrow2, SPArrow sparrow3)
    {
        float f2 = (sparrow.getX() - sparrow1.getX()) * (sparrow2.getY() - sparrow3.getY()) - (sparrow.getY() - sparrow1.getY()) * (sparrow2.getX() - sparrow3.getX());
        if (f2 == 0.0F)
        {
            return null;
        }
        if (sparrow.isEquivalent(sparrow2) || sparrow.isEquivalent(sparrow3))
        {
            return SPArrow.getInstance().setXY(sparrow.getX(), sparrow.getY());
        }
        if (sparrow1.isEquivalent(sparrow2) || sparrow1.isEquivalent(sparrow3))
        {
            return SPArrow.getInstance().setXY(sparrow1.getX(), sparrow1.getY());
        } else
        {
            float f1 = ((sparrow2.getX() - sparrow3.getX()) * (sparrow.getX() * sparrow1.getY() - sparrow.getY() * sparrow1.getX()) - (sparrow.getX() - sparrow1.getX()) * (sparrow2.getX() * sparrow3.getY() - sparrow2.getY() * sparrow3.getX())) / f2;
            f2 = ((sparrow2.getY() - sparrow3.getY()) * (sparrow.getX() * sparrow1.getY() - sparrow.getY() * sparrow1.getX()) - (sparrow.getY() - sparrow1.getY()) * (sparrow2.getX() * sparrow3.getY() - sparrow2.getY() * sparrow3.getX())) / f2;
            return SPArrow.getInstance().setXY(f1, f2);
        }
    }

    public static com.picsart.studio.ads.g a(Context context, RecyclerViewAdapter recyclerviewadapter)
    {
        if (!SocialinV3.getInstance().getSettings().isNativeAdEnabled())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        context = (com.picsart.studio.ads.g)Class.forName("com.picsart.studio.ads.MoPubRecyclerAdapter").asSubclass(com/picsart/studio/ads/g).getConstructor(new Class[] {
            android/content/Context, com/socialin/android/adapter/RecyclerViewAdapter
        }).newInstance(new Object[] {
            context, recyclerviewadapter
        });
        return context;
        context;
        return null;
    }

    public static com.picsart.studio.ads.i a(Context context, AdProviders adproviders, String s)
    {
        c c1 = k();
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        adproviders = c1.fetchAd(context, adproviders.toString(), s, null);
        return adproviders;
        adproviders;
        adproviders.printStackTrace();
        FlurryAgent.onError("dex_loader", adproviders.getMessage(), adproviders);
        return new com.picsart.studio.ads.a(context);
    }

    public static com.socialin.android.billing.d a(Activity activity, String s)
    {
        if (activity.getString(0x7f0808c8).equals(activity.getString(0x7f0808cc)))
        {
            return StripeIAPController.getInstance(activity, s);
        } else
        {
            return com.socialin.android.billing.b.a(activity, s);
        }
    }

    public static File a(char c1)
    {
        String s;
        File file1;
        try
        {
            File file = Environment.getExternalStorageDirectory();
            file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append("/").append(c).toString());
            boolean flag = file1.mkdirs();
            com.socialin.android.d.a((new StringBuilder("getCachedFile: success= ")).append(flag).toString());
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a("getCachedFile", exception);
            return null;
        }
        if ('@' != c1) goto _L2; else goto _L1
_L1:
        s = e;
_L4:
        return new File(file1, s);
_L2:
        s = d;
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_67;
    }

    public static Writer a(Appendable appendable)
    {
        if (appendable instanceof Writer)
        {
            return (Writer)appendable;
        } else
        {
            return new l(appendable, (byte)0);
        }
    }

    public static Object a(Object obj, String s)
    {
        if (obj == null)
        {
            throw new NullPointerException(s);
        } else
        {
            return obj;
        }
    }

    public static String a(int i1, Context context, String s, boolean flag, ItemType itemtype)
    {
        context = a(context, s, flag, itemtype);
        if (i1 < context.size())
        {
            return ((File)context.get(i1)).getAbsolutePath();
        } else
        {
            return null;
        }
    }

    public static String a(Context context, int i1, String s, boolean flag, ItemType itemtype)
    {
        File file = new File(s);
        if (file.exists())
        {
            boolean flag1 = s.contains(context.getResources().getString(0x7f0800b6));
            context = file.listFiles(new com.socialin.android.photo.c(itemtype));
            if (flag1)
            {
                a(((File []) (context)));
                context = new ArrayList(Arrays.asList(context));
            } else
            {
                context = com.socialin.android.photo.f.a(s, itemtype, flag);
            }
        } else
        {
            context = new ArrayList(0);
        }
        if (i1 < context.size())
        {
            return ((File)context.get(i1)).getAbsolutePath();
        } else
        {
            return null;
        }
    }

    public static String a(Intent intent, String s)
    {
        if (intent == null)
        {
            intent = null;
        } else
        {
            intent = intent.getExtras();
        }
        if (intent != null && intent.containsKey(s))
        {
            return intent.getString(s);
        } else
        {
            return "default";
        }
    }

    private static String a(InputStream inputstream)
    {
        Object obj;
        char ac1[];
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj = new StringWriter();
        ac1 = new char[1024];
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, e.a));
_L1:
        int i1 = bufferedreader.read(ac1);
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((Writer) (obj)).write(ac1, 0, i1);
          goto _L1
        obj;
        inputstream.close();
        throw obj;
        inputstream.close();
        return obj.toString();
        return "";
    }

    public static String a(Object obj)
    {
        if (obj == null)
        {
            return "null";
        }
        if (obj instanceof String)
        {
            return "\"" + j((String)obj) + "\"";
        }
        if (obj instanceof Double)
        {
            if (((Double)obj).isInfinite() || ((Double)obj).isNaN())
            {
                return "null";
            } else
            {
                return obj.toString();
            }
        }
        if (obj instanceof Float)
        {
            if (((Float)obj).isInfinite() || ((Float)obj).isNaN())
            {
                return "null";
            } else
            {
                return obj.toString();
            }
        }
        if (obj instanceof Number)
        {
            return obj.toString();
        }
        if (obj instanceof Boolean)
        {
            return obj.toString();
        }
        if (obj instanceof org.json.simple.a)
        {
            return ((org.json.simple.a)obj).toJSONString();
        }
        if (obj instanceof Map)
        {
            return org.json.simple.JSONObject.toJSONString((Map)obj);
        }
        if (obj instanceof List)
        {
            return JSONArray.toJSONString((List)obj);
        } else
        {
            return obj.toString();
        }
    }

    public static String a(JSONObject jsonobject)
    {
        JSONObject jsonobject1 = jsonobject;
        if (jsonobject == null)
        {
            jsonobject1 = new JSONObject();
        }
        try
        {
            jsonobject1.put("source", "android");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
        return jsonobject1.toString();
    }

    public static String a(byte abyte0[])
    {
        byte byte0 = 2;
        io.branch.referral.d d1;
        int j1;
        int k1;
        k1 = abyte0.length;
        d1 = new io.branch.referral.d(2);
        j1 = (k1 / 3) * 4;
        if (!d1.c) goto _L2; else goto _L1
_L1:
        int i1;
        i1 = j1;
        if (k1 % 3 > 0)
        {
            i1 = j1 + 4;
        }
_L8:
        if (!d1.d || k1 <= 0) goto _L4; else goto _L3
_L3:
        j1 = (k1 - 1) / 57;
        if (!d1.e)
        {
            byte0 = 1;
        }
        i1 = byte0 * (j1 + 1) + i1;
          goto _L5
_L4:
        try
        {
            d1.a = new byte[i1];
            d1.a(abyte0, 0, k1);
            return new String(d1.a, "US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
_L2:
        i1 = j1;
        switch (k1 % 3)
        {
        default:
            i1 = j1;
            break;

        case 1: // '\001'
            i1 = j1 + 2;
            break;

        case 2: // '\002'
            i1 = j1 + 3;
            break;

        case 0: // '\0'
            break;
        }
          goto _L6
_L5:
        if (true) goto _L4; else goto _L6
_L6:
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static String a(byte abyte0[], String s)
    {
        if (abyte0 == null)
        {
            return null;
        }
        try
        {
            abyte0 = new String(abyte0, s);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalStateException(s + ": " + abyte0);
        }
        return abyte0;
    }

    public static String a(Object aobj[])
    {
        if (aobj == null)
        {
            return "null";
        }
        int j1 = aobj.length - 1;
        if (j1 == -1)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append('[');
        int i1 = 0;
        do
        {
            stringbuilder.append(String.valueOf(aobj[i1]));
            if (i1 == j1)
            {
                return stringbuilder.append(']').toString();
            }
            stringbuilder.append(", ");
            i1++;
        } while (true);
    }

    public static ByteBuffer a(Effect effect, Point point, Point point1, ArrayList arraylist, ByteBuffer bytebuffer, ByteBuffer bytebuffer1, ByteBuffer bytebuffer2)
    {
        if (arraylist.size() != 0) goto _L2; else goto _L1
_L1:
        int i1 = 1;
_L4:
        if (i1 != 0 && bytebuffer1 != null)
        {
            Log.e("ex1", "multiplyWithAlphaChannel START");
            ImageOpCommon.multiplyWithAlphaChannel(bytebuffer1, bytebuffer2, bytebuffer1, point1.x, point1.y);
            Log.e("ex1", "multiplyWithAlphaChannel END");
        }
        return bytebuffer1;
_L2:
label0:
        {
            com.picsart.effectnew.m m1;
            int j1;
            int k1;
            int l1;
label1:
            {
                i1 = point.x;
                l1 = point.y;
                m1 = new com.picsart.effectnew.m();
                m1.b = false;
                Bitmap bitmap = EffectsDrawHistoryController.a(null, i1, l1, arraylist);
                if (bitmap == null || bitmap.isRecycled())
                {
                    break label0;
                }
                j1 = point1.x;
                k1 = point1.y;
                if (bitmap != null)
                {
                    point = bitmap;
                    if (!bitmap.isRecycled())
                    {
                        break label1;
                    }
                }
                point = EffectsDrawHistoryController.a(null, i1, l1, arraylist);
            }
            if (point != null)
            {
                ByteBuffer bytebuffer3 = myobfuscated.ay.e.a(i1 * l1 * 4);
                bytebuffer3.position(0);
                point.copyPixelsToBuffer(bytebuffer3);
                com.socialin.android.util.c.a(point);
                arraylist = a(bytebuffer3, i1, l1, j1, k1);
                myobfuscated.ay.e.a(bytebuffer3);
                if (effect.a().compareTo("Motion") == 0 && effect.b("Colorize"))
                {
                    point = myobfuscated.ay.e.a(bytebuffer.capacity());
                    Object obj = new Point(j1, k1);
                    com.photo.effect.a a1 = new com.photo.effect.a();
                    a1.a = null;
                    a1.d = bytebuffer;
                    a1.e = point;
                    a1.m = null;
                    a1.i = ((Point) (obj));
                    a1.h = 1.0F;
                    a1.f = false;
                    a1.g = -1;
                    a1.n = com.photo.effect.Effect.EffectApplyType.EffectApplyTypeNative;
                    effect = effect.b();
                    Log.e("ex1", "applyMotionOrigEffect");
                    int i2 = EffectParameter.b(effect, "Fade");
                    boolean flag = EffectParameter.d(effect, "Colorize");
                    i1 = 100;
                    if (flag)
                    {
                        i1 = EffectParameter.b(effect, "Hue");
                    }
                    Log.e("ex1", (new StringBuilder("distance = 0")).toString());
                    Log.e("ex1", (new StringBuilder("angle = 0")).toString());
                    Log.e("ex1", (new StringBuilder("colorize = ")).append(flag).toString());
                    Log.e("ex1", (new StringBuilder("fade = ")).append(i2).toString());
                    Log.e("ex1", (new StringBuilder("hue = ")).append(i1).toString());
                    effect = new com.photo.effect.c();
                    Log.e("ex1", "applyMotionOrigEffect native");
                    obj = a1.d;
                    ByteBuffer bytebuffer4 = a1.e;
                    Point point2 = a1.i;
                    int j2 = point2.x;
                    int k2 = point2.y;
                    boolean flag1 = a1.f;
                    int l2 = a1.g;
                    Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag1).toString());
                    Log.e("ex1", (new StringBuilder("taskId = ")).append(l2).toString());
                    Log.e("ex1", (new StringBuilder("width = ")).append(j2).toString());
                    Log.e("ex1", (new StringBuilder("height = ")).append(k2).toString());
                    ImageOp.motionblur4buf(((java.nio.Buffer) (obj)), bytebuffer4, j2, k2, j2, k2, 0, 0, flag, i1, 50, 30, 0, i2, flag1, l2);
                    effect.a = true;
                    effect = point;
                } else
                {
                    effect = bytebuffer;
                }
                point = myobfuscated.ay.e.a(effect.capacity());
                ImageOp.blend4buf(effect, bytebuffer1, arraylist, 0, j1, k1, point, j1, k1);
                m1.b = true;
                m1.a = point;
                myobfuscated.ay.e.a(arraylist);
                if (effect != null && effect != bytebuffer)
                {
                    myobfuscated.ay.e.a(effect);
                }
            }
        }
        if (m1.b && m1.a != null)
        {
            bytebuffer1 = m1.a;
            i1 = 1;
        } else
        {
            bytebuffer1 = null;
            i1 = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ByteBuffer a(ByteBuffer bytebuffer, int i1, int j1, int k1, int l1)
    {
        ByteBuffer bytebuffer1 = myobfuscated.ay.e.a(k1 * l1 * 4);
        ImageResize.resize(bytebuffer, i1, j1, bytebuffer1, k1, l1, 4);
        return bytebuffer1;
    }

    public static Collection a(Collection collection)
    {
        if (collection.isEmpty())
        {
            throw new IllegalArgumentException("Must not be empty.");
        } else
        {
            return collection;
        }
    }

    public static List a(Context context, String s, boolean flag, ItemType itemtype)
    {
        File file = new File(s);
        if (file.exists())
        {
            if (s.contains(context.getResources().getString(0x7f0800b6)))
            {
                context = file.listFiles(new com.socialin.android.photo.d(itemtype));
                a(((File []) (context)));
                return new ArrayList(Arrays.asList(context));
            } else
            {
                return com.socialin.android.photo.f.a(s, itemtype, flag);
            }
        } else
        {
            return new ArrayList(0);
        }
    }

    public static a a(android.hardware.Camera.Parameters parameters, int i1, int j1, int k1, int l1, int i2, Point point, Point point1)
    {
        a a1 = new a();
        List list = parameters.getSupportedPreviewSizes();
        List list1 = parameters.getSupportedPictureSizes();
        Object obj = null;
        parameters = obj;
        if (list != null)
        {
            parameters = obj;
            if (list1 != null)
            {
                parameters = new ArrayList();
                for (int j2 = 0; j2 < list.size(); j2++)
                {
                    android.hardware.Camera.Size size = (android.hardware.Camera.Size)list.get(j2);
                    float f1 = (float)size.width / (float)size.height;
                    for (int k2 = 0; k2 < list1.size(); k2++)
                    {
                        android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)list1.get(k2);
                        if (f1 == (float)size1.width / (float)size1.height)
                        {
                            a a2 = new a();
                            a2.b = size1;
                            a2.a = size;
                            parameters.add(a2);
                        }
                    }

                }

            }
        }
        a1.b = a(((ArrayList) (parameters)), i2, (float)k1 / (float)l1);
        if (a1.b == null)
        {
            a1.b = b(parameters, i1, j1);
        }
        if (a1.b == null)
        {
            a1.b = a(((ArrayList) (parameters)), i1, j1, point, point1, 0);
        }
        if (a1.b == null)
        {
            a1.b = a(((ArrayList) (parameters)), i1, j1, point, point1, 250);
        }
        if (a1.b == null)
        {
            a1.b = a(((ArrayList) (parameters)), i1, j1, point, point1, 500);
        }
        if (a1.b == null)
        {
            a1.b = a(((ArrayList) (parameters)), i1, j1, point, point1, 800);
        }
        if (a1.b == null)
        {
            a1.b = ((a)parameters.get(0)).b;
        }
        point = new ArrayList();
        for (i1 = 0; i1 < parameters.size(); i1++)
        {
            if (((a)parameters.get(i1)).b.width == a1.b.width && ((a)parameters.get(i1)).b.height == a1.b.height)
            {
                point.add(parameters.get(i1));
            }
        }

        a1.a = a(((ArrayList) (point)), k1, l1);
        if (a1.a == null)
        {
            a1.a = ((a)point.get(0)).a;
        }
        return a1;
    }

    public static myobfuscated.j.c a(Context context, String s)
    {
        if (!a(s))
        {
            Uri uri = Uri.parse(s);
            if (myobfuscated.j.e.a().contains(uri.getScheme()))
            {
                return new myobfuscated.j.e(s, null);
            }
            if ("intent".equals(uri.getScheme()))
            {
                return new myobfuscated.j.a(context.getPackageName(), uri, null);
            } else
            {
                return new myobfuscated.j.d(uri, null);
            }
        } else
        {
            return null;
        }
    }

    private static JSONObject a(ViewerUser vieweruser)
    {
        try
        {
            vieweruser = new JSONObject(com.socialin.android.c.a().toJson(vieweruser));
        }
        // Misplaced declaration of an exception variable
        catch (ViewerUser vieweruser)
        {
            com.socialin.android.d.a("getUserJSON", vieweruser);
            return null;
        }
        return vieweruser;
    }

    public static JSONObject a(Card card)
    {
        if (card == null)
        {
            return null;
        }
        card = new JSONObject(com.socialin.android.c.a().toJson(card));
        card.remove("data");
        return card;
        Exception exception;
        exception;
_L2:
        exception.printStackTrace();
        return card;
        exception;
        card = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void a(Activity activity, Dialog dialog)
    {
        if (!activity.isFinishing() && dialog != null && !dialog.isShowing())
        {
            activity.runOnUiThread(new com.socialin.android.util.g(dialog));
        }
    }

    public static void a(Activity activity, Dialog dialog, boolean flag)
    {
label0:
        {
            if (!activity.isFinishing() && dialog != null && !dialog.isShowing())
            {
                if (!flag)
                {
                    break label0;
                }
                activity.runOnUiThread(new h(dialog));
            }
            return;
        }
        try
        {
            dialog.show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
    }

    public static void a(Activity activity, Bitmap bitmap, String s, String s1, String s2, Observer observer)
    {
        if (w.a(activity))
        {
            (new ac(s1, s2, bitmap, s, activity, true, observer)).start();
            return;
        } else
        {
            Utils.a(activity, 0x7f0805a0);
            observer.update(null, null);
            return;
        }
    }

    public static void a(Activity activity, EditText edittext)
    {
        if (activity != null && !activity.isFinishing())
        {
            ((InputMethodManager)activity.getSystemService("input_method")).showSoftInput(edittext, 0);
        }
    }

    public static void a(Context context, android.view.View.OnClickListener onclicklistener)
    {
        try
        {
            (new com.socialin.android.dialog.f(context)).a(context.getString(0x7f080527)).a(true).a(context.getString(0x7f08006d), onclicklistener).a().show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static void a(Context context, LinearLayout linearlayout, android.view.ViewGroup.LayoutParams layoutparams)
    {
        linearlayout.setLayoutParams(layoutparams);
        linearlayout.setOrientation(1);
        int i1 = (int)Utils.a(20F, context);
        linearlayout.setPadding(i1, 0, i1, 0);
    }

    public static void a(Context context, String s, String s1, String s2, int i1, PendingIntent pendingintent)
    {
        s1 = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(i1).setContentTitle(s1).setContentText(s2);
        s1.setContentIntent(pendingintent);
        context = NotificationManagerCompat.from(context);
        s1 = s1.build();
        s1.flags = ((Notification) (s1)).flags | 0x18;
        s1.defaults = 1;
        context.notify(s.hashCode(), s1);
    }

    public static void a(View view)
    {
        if (view != null && (view.getParent() instanceof ViewGroup))
        {
            ((ViewGroup)view.getParent()).removeView(view);
        }
    }

    public static void a(View view, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(ongloballayoutlistener);
            return;
        } else
        {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(ongloballayoutlistener);
            return;
        }
    }

    public static void a(GoogleApiClient googleapiclient, String s, String s1, String s2)
    {
        if (googleapiclient == null)
        {
            return;
        }
        try
        {
            s = Action.newAction(s, s1, Uri.parse(s2));
            AppIndex.AppIndexApi.start(googleapiclient, s).setResultCallback(new com.picsart.studio.a(s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            Log.e("AppIndexing", (new StringBuilder("App Indexing API: ")).append(googleapiclient.getMessage()).toString());
        }
    }

    public static void a(com.millennialmedia.google.gson.e e1, com.millennialmedia.google.gson.stream.b b1)
    {
        p.y.a(b1, e1);
    }

    public static void a(EffectParameter effectparameter, SeekBar seekbar)
    {
        int i1;
        seekbar.setMax(c(effectparameter));
        i1 = 0;
        if (effectparameter.a() != com.photo.effect.EffectParameter.ParameterType.ParameterTypeInt) goto _L2; else goto _L1
_L1:
        i1 = a(effectparameter);
_L4:
        seekbar.setProgress(i1);
        return;
_L2:
        if (effectparameter.a() == com.photo.effect.EffectParameter.ParameterType.ParameterTypeFloat)
        {
            i1 = b(effectparameter);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        throw closeable;
        closeable;
    }

    public static void a(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IllegalArgumentException((new StringBuilder("not a directory: ")).append(file).toString());
        }
        int j1 = afile.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            file = afile[i1];
            if (file.isDirectory())
            {
                a(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder("failed to delete file: ")).append(file).toString());
            }
        }

    }

    public static void a(Object obj, Writer writer)
    {
        if (obj == null)
        {
            writer.write("null");
            return;
        }
        if (obj instanceof String)
        {
            writer.write(34);
            writer.write(j((String)obj));
            writer.write(34);
            return;
        }
        if (obj instanceof Double)
        {
            if (((Double)obj).isInfinite() || ((Double)obj).isNaN())
            {
                writer.write("null");
                return;
            } else
            {
                writer.write(obj.toString());
                return;
            }
        }
        if (obj instanceof Float)
        {
            if (((Float)obj).isInfinite() || ((Float)obj).isNaN())
            {
                writer.write("null");
                return;
            } else
            {
                writer.write(obj.toString());
                return;
            }
        }
        if (obj instanceof Number)
        {
            writer.write(obj.toString());
            return;
        }
        if (obj instanceof Boolean)
        {
            writer.write(obj.toString());
            return;
        }
        if (obj instanceof org.json.simple.b)
        {
            ((org.json.simple.b)obj).writeJSONString(writer);
            return;
        }
        if (obj instanceof org.json.simple.a)
        {
            writer.write(((org.json.simple.a)obj).toJSONString());
            return;
        }
        if (obj instanceof Map)
        {
            org.json.simple.JSONObject.writeJSONString((Map)obj, writer);
            return;
        }
        if (obj instanceof List)
        {
            JSONArray.writeJSONString((List)obj, writer);
            return;
        } else
        {
            writer.write(obj.toString());
            return;
        }
    }

    public static void a(String s, String s1)
    {
        s = new File(s);
        if (s.exists())
        {
            s = s.listFiles();
            int j1 = s.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                File file = s[i1];
                String s2 = file.getAbsolutePath();
                s2 = s2.substring(s2.lastIndexOf(File.separator) + 1);
                s2 = s2.substring(s2.lastIndexOf("i_") + 2);
                if (!(new File((new StringBuilder()).append(s1).append("/").append(s2).toString())).exists())
                {
                    file.delete();
                }
            }

        }
    }

    public static void a(String s, String s1, int i1)
    {
        s1 = new File(s1);
        if (s1.exists())
        {
            s1 = s1.listFiles(new com.socialin.android.photo.e(i1));
            int j1 = s1.length;
            for (i1 = 0; i1 < j1; i1++)
            {
                File file = s1[i1];
                String s2 = file.getAbsolutePath();
                s2 = s2.substring(s2.lastIndexOf(File.separator) + 1);
                if (!(new File((new StringBuilder()).append(s).append("/i_").append(s2).toString())).exists())
                {
                    file.delete();
                }
            }

        }
    }

    public static void a(String s, String s1, String s2)
    {
        if (s != null && FileUtils.d(s) == com.socialin.android.util.FileUtils.ImageFileFormat.JPEG)
        {
            ExifTool.a(s, "Exif.Image.Software", "PicsArt Photo Studio");
            if (s1 != null && ExifTool.a(s, "Exif.Image.Artist") == null)
            {
                ExifTool.a(s, "Exif.Image.Artist", s1);
            }
            ExifTool.a(s, "Exif.Image.Orientation", "0");
            if (s2 != null)
            {
                ExifTool.a(s, "Exif.Photo.UserComment", s2);
            }
        }
    }

    public static void a(String s, String s1, String s2, com.socialin.asyncnet.d d1)
    {
        String s3 = s1;
        if (!s1.startsWith(File.separator))
        {
            s3 = (new StringBuilder()).append(File.separator).append(s1).toString();
        }
        s1 = s3;
        if (!s3.endsWith(File.separator))
        {
            s1 = (new StringBuilder()).append(s3).append(File.separator).toString();
        }
        s1 = (new StringBuilder("https://api-content.dropbox.com/1/files/dropbox")).append(s1).toString();
        s = new File(s);
        s1 = new Request(s1, null, "POST");
        s1.c();
        s1.a("file", s.getName(), "image/*", s);
        s1.a("overwrite", "false");
        s1.a("access_token", s2);
        com.socialin.asyncnet.b.a().a(s1, d1);
    }

    public static void a(String s, StringBuffer stringbuffer)
    {
        int i1 = 0;
_L11:
        char c1;
        if (i1 >= s.length())
        {
            break MISSING_BLOCK_LABEL_291;
        }
        c1 = s.charAt(i1);
        c1;
        JVM INSTR lookupswitch 8: default 96
    //                   8: 204
    //                   9: 248
    //                   10: 226
    //                   12: 215
    //                   13: 237
    //                   34: 176
    //                   47: 259
    //                   92: 193;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        break; /* Loop/switch isn't completed */
_L7:
        stringbuffer.append("\\\"");
_L12:
        i1++;
        if (true) goto _L11; else goto _L10
_L10:
        stringbuffer.append("\\\\");
          goto _L12
_L2:
        stringbuffer.append("\\b");
          goto _L12
_L5:
        stringbuffer.append("\\f");
          goto _L12
_L4:
        stringbuffer.append("\\n");
          goto _L12
_L6:
        stringbuffer.append("\\r");
          goto _L12
_L3:
        stringbuffer.append("\\t");
          goto _L12
_L8:
        stringbuffer.append("\\/");
          goto _L12
_L1:
        if ((c1 < 0 || c1 > '\037') && (c1 < '\177' || c1 > '\237') && (c1 < '\u2000' || c1 > '\u20FF'))
        {
            break MISSING_BLOCK_LABEL_282;
        }
        String s1 = Integer.toHexString(c1);
        stringbuffer.append("\\u");
        for (int j1 = 0; j1 < 4 - s1.length(); j1++)
        {
            stringbuffer.append('0');
        }

        stringbuffer.append(s1.toUpperCase());
        break; /* Loop/switch isn't completed */
        stringbuffer.append(c1);
          goto _L12
    }

    public static void a(ByteBuffer bytebuffer, Bitmap bitmap)
    {
        Log.e("ex1", "changeBitmapAlphaChannelWithBuffer START");
        Log.e("ex1", (new StringBuilder("bitmap w = ")).append(bitmap.getWidth()).append(" h = ").append(bitmap.getHeight()).toString());
        int i1 = bitmap.getWidth();
        int j1 = bitmap.getHeight();
        ByteBuffer bytebuffer1 = myobfuscated.ay.e.a(i1 * j1 * 4);
        bytebuffer1.position(0);
        bitmap.copyPixelsToBuffer(bytebuffer1);
        ImageOpCommon.multiplyWithAlphaChannel(bytebuffer1, bytebuffer, bytebuffer1, i1, j1);
        bytebuffer1.position(0);
        bitmap.copyPixelsFromBuffer(bytebuffer1);
        myobfuscated.ay.e.a(bytebuffer1);
        Log.e("ex1", "changeBitmapAlphaChannelWithBuffer END");
    }

    public static void a(List list)
    {
        File file = a('@');
        org.json.JSONArray jsonarray;
label0:
        {
            if (file != null)
            {
                try
                {
                    jsonarray = new org.json.JSONArray();
                    for (list = list.iterator(); list.hasNext(); jsonarray.put(a((ViewerUser)list.next()))) { }
                    break label0;
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    com.socialin.android.d.a("writeUsersToFile", list);
                }
            }
            return;
        }
        list = new JSONObject();
        list.put("data", jsonarray);
        FileUtils.a(file, list);
        return;
    }

    public static boolean a(int i1, int j1)
    {
        return i1 <= 512 && j1 <= 384;
    }

    public static boolean a(Context context, String s, String s1)
    {
        return context.getResources().getIdentifier(s1, s, context.getPackageName()) != 0;
    }

    public static boolean a(Uri uri)
    {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean a(SPArrow sparrow, SPArrow sparrow1)
    {
        return sparrow.getX() * sparrow1.getY() - sparrow1.getX() * sparrow.getY() >= 0.0F;
    }

    public static boolean a(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    private static boolean a(PublicKey publickey, String s, String s1)
    {
label0:
        {
            try
            {
                Signature signature = Signature.getInstance("SHA1withRSA");
                signature.initVerify(publickey);
                signature.update(s.getBytes());
                if (signature.verify(com.socialin.android.billing.a.a(s1)))
                {
                    break label0;
                }
                Log.e("IABUtil/Security", "Signature verification failed.");
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                Log.e("IABUtil/Security", "Invalid key specification.");
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                Log.e("IABUtil/Security", "Signature exception.");
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (PublicKey publickey)
            {
                Log.e("IABUtil/Security", "Base64 decoding failed.");
                return false;
            }
            return false;
        }
        return true;
    }

    public static byte[] a(String s, String s1, t t1)
    {
        if (s == null)
        {
            return null;
        }
        RandomAccessFile randomaccessfile = new RandomAccessFile(s, "r");
        if (!t.c(s))
        {
            t1 = new t();
            t1.a(randomaccessfile, s);
            s1 = t1.a(s1);
            t.a(t1, s);
            s = s1;
        } else
        {
            t1.a(randomaccessfile, s);
            s = t1.a(s1);
        }
        try
        {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return s;
        }
        return s;
    }

    private static File[] a(File afile[])
    {
        Arrays.sort(afile, new com.socialin.android.photo.a());
        return afile;
    }

    public static float b(SPArrow sparrow, SPArrow sparrow1, SPArrow sparrow2)
    {
        float f2 = SPArrow.distanceFromArrowToArrow(sparrow1, sparrow2);
        float f1 = f2;
        if (f2 != 0.0F)
        {
            f1 = (2.0F * a(sparrow, sparrow1, sparrow2)) / f2;
        }
        return f1;
    }

    public static int b(Context context, String s, String s1)
    {
        return context.getResources().getIdentifier(s1, s, context.getPackageName());
    }

    public static int b(EffectParameter effectparameter)
    {
        float f1 = ((Float)effectparameter.c()).floatValue();
        float f2 = ((Float)effectparameter.d()).floatValue();
        float f3 = ((Float)effectparameter.b()).floatValue();
        int i1 = c(effectparameter);
        return (int)(((f3 - f1) / (f2 - f1)) * (float)i1);
    }

    private static android.hardware.Camera.Size b(ArrayList arraylist, int i1, int j1)
    {
        int k1;
        int l1;
        l1 = 0;
        k1 = 0;
_L8:
        android.hardware.Camera.Size size;
        if (k1 >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_364;
        }
        size = ((a)arraylist.get(k1)).b;
        if (size.width != i1) goto _L2; else goto _L1
_L1:
        int i2 = size.height;
        if (i2 != j1) goto _L2; else goto _L3
_L3:
        k1 = 1;
_L13:
        android.hardware.Camera.Size size1 = size;
        if (k1 != 0) goto _L5; else goto _L4
_L4:
        float f1;
        android.hardware.Camera.Size size2;
        f1 = (float)i1 / (float)j1;
        i2 = 0x7fffffff;
        l1 = 0;
        j1 = 0;
        size1 = null;
        size2 = size;
        size = size1;
_L7:
        android.hardware.Camera.Size size4 = size2;
        if (l1 >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        size4 = size2;
        float f2;
        android.hardware.Camera.Size size3;
        int j2;
        try
        {
            size3 = ((a)arraylist.get(l1)).b;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            return size4;
        }
        size4 = size2;
        f2 = (float)size3.width / (float)size3.height;
        size1 = size2;
        j2 = i2;
        size4 = size2;
        if (Math.abs(f2 - f1) >= 0.01F)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        size1 = size2;
        j2 = i2;
        size4 = size2;
        if (size3.width < i1)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        size1 = size2;
        j2 = i2;
        size4 = size2;
        if (size3.width >= i2)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        size4 = size2;
        j2 = size3.width;
        size1 = size3;
        size4 = size1;
        if (Math.abs(f2 - f1) >= 0.01F)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        size4 = size1;
        if (size3.width < j1)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        size4 = size1;
        if (size3.width >= i1)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        size4 = size1;
        j1 = size3.width;
        size = size3;
        l1++;
        size2 = size1;
        i2 = j2;
        if (true) goto _L7; else goto _L6
_L2:
        k1++;
          goto _L8
_L6:
        if (i2 != 0x7fffffff)
        {
            i1 = 1;
        } else
        {
            i1 = k1;
        }
        if (j1 <= 0) goto _L10; else goto _L9
_L9:
        size1 = size;
        if (i1 == 0) goto _L5; else goto _L11
_L11:
        if (i2 <= 2048) goto _L10; else goto _L12
_L12:
        size1 = size;
_L5:
        return size1;
        arraylist;
        return null;
_L10:
        return size2;
        size = null;
        k1 = l1;
          goto _L13
    }

    private static android.hardware.Camera.Size b(ArrayList arraylist, int i1, int j1, double d1, double d2)
    {
        double d3 = (double)i1 / (double)j1;
        android.hardware.Camera.Size size = null;
        for (i1 = 0; i1 < arraylist.size(); i1++)
        {
            android.hardware.Camera.Size size1 = ((a)arraylist.get(i1)).a;
            if ((float)size1.height >= ((float)j1 * 2.0F) / 3F && (float)size1.height <= ((float)j1 * 3F) / 2.0F && Math.abs((double)size1.width / (double)size1.height - d3) <= d1 && (double)Math.abs(size1.height - j1) < d2)
            {
                d2 = Math.abs(size1.height - j1);
                size = size1;
            }
        }

        return size;
    }

    public static TextView b(View view)
    {
        return (TextView)view.findViewById(0x7f100399);
    }

    public static Effect b(Context context, String s)
    {
        context = FileUtils.a(context, s);
        try
        {
            context = new Effect(new JSONObject(context));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    public static com.picsart.studio.ads.h b(Context context, AdProviders adproviders, String s)
    {
        c c1 = k();
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        context = c1.fetchInterstitialAd(context, adproviders.toString(), s, null);
        return context;
        context;
        context.printStackTrace();
        FlurryAgent.onError("dex_loader", context.getMessage(), context);
        return new com.picsart.studio.ads.b();
    }

    public static com.socialin.android.net.a b(Context context)
    {
        return new com.socialin.android.net.c(context);
    }

    public static Class b()
    {
        if (SocialinV3.getInstance().getAppProps() != null && SocialinV3.getInstance().getAppProps().getProcess().equals("multy"))
        {
            return com/picsart/effects/colorsplash/ColorSplashActivity;
        } else
        {
            return com/picsart/effects/colorsplash/ColorSplashActivityMainProcess;
        }
    }

    public static String b(Context context, int i1, String s, boolean flag, ItemType itemtype)
    {
        context = a(context, s, flag, itemtype);
        if (i1 < context.size())
        {
            return ((File)context.get(i1)).getAbsolutePath();
        } else
        {
            return null;
        }
    }

    public static String b(File file)
    {
        String s;
        Object obj1;
        s = "";
        obj1 = s;
        if (file == null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = s;
        obj1 = s;
        if (!file.exists()) goto _L2; else goto _L3
_L3:
        obj = s;
        obj1 = s;
        if (!FileUtils.b()) goto _L2; else goto _L4
_L4:
        obj = s;
        char ac1[] = new char[100];
        obj = s;
        InputStreamReader inputstreamreader = new InputStreamReader(new FileInputStream(file));
        file = s;
_L5:
        obj = file;
        int i1 = inputstreamreader.read(ac1);
        obj1 = file;
        if (i1 <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = file;
        s = String.copyValueOf(ac1, 0, i1);
        obj = file;
        file = (new StringBuilder()).append(file).append(s).toString();
        ac1 = new char[100];
        if (true) goto _L5; else goto _L2
        file;
_L7:
        com.socialin.android.d.a("readFromFile", file);
        obj1 = obj;
_L2:
        return ((String) (obj1));
        Exception exception;
        exception;
        obj = file;
        file = exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static String b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Must not be null or empty");
        } else
        {
            return s;
        }
    }

    public static String b(byte abyte0[])
    {
        return a(abyte0, "UTF-8");
    }

    public static JSONObject b(JSONObject jsonobject)
    {
        JSONObject jsonobject1 = new JSONObject();
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = jsonobject.keys();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        String s = (String)iterator.next();
        if (jsonobject.has(s) && jsonobject.get(s).getClass().equals(java/lang/String))
        {
            jsonobject1.put(s, jsonobject.getString(s).replace("\n", "\\n").replace("\r", "\\r").replace("\"", "\\\""));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (jsonobject.has(s))
            {
                jsonobject1.put(s, jsonobject.get(s));
            }
        }
        catch (JSONException jsonexception) { }
        continue; /* Loop/switch isn't completed */
_L2:
        return jsonobject1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void b(Activity activity)
    {
        activity.getWindow().setFlags(1024, 1024);
    }

    public static void b(Activity activity, Dialog dialog)
    {
        while (activity == null || activity.isFinishing() || dialog == null || !dialog.isShowing()) 
        {
            return;
        }
        activity.runOnUiThread(new com.socialin.android.util.j(dialog));
    }

    public static void b(GoogleApiClient googleapiclient, String s, String s1, String s2)
    {
        if (googleapiclient == null)
        {
            return;
        }
        try
        {
            s = Action.newAction(s, s1, Uri.parse(s2));
            AppIndex.AppIndexApi.end(googleapiclient, s).setResultCallback(new com.picsart.studio.b(s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            Log.e("AppIndexing", (new StringBuilder("App Indexing API: ")).append(googleapiclient.getMessage()).toString());
        }
    }

    public static boolean b(Uri uri)
    {
        return uri.getPathSegments().contains("video");
    }

    public static boolean b(String s, String s1, String s2)
    {
        if (s1 == null)
        {
            Log.e("IABUtil/Security", "data is null");
            return false;
        }
        if (!TextUtils.isEmpty(s2) && !a(k(s), s1, s2))
        {
            Log.w("IABUtil/Security", "signature does not match data.");
            return false;
        } else
        {
            return true;
        }
    }

    public static byte[] b(String s, String s1)
    {
        RandomAccessFile randomaccessfile = new RandomAccessFile(s, "r");
        t t1 = new t();
        t1.a(randomaccessfile, s);
        s1 = t1.a(s1);
        t.a(t1, s);
        try
        {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return s1;
        }
        return s1;
    }

    public static int c(Context context, String s, String s1)
    {
        String s2;
        Object obj;
        String s3;
        String s4;
        s4 = "";
        s3 = "";
        obj = s3;
        s2 = s4;
        InputStream inputstream = context.getAssets().open(s);
        obj = s3;
        s2 = s4;
        s = a(inputstream);
        obj = s3;
        s2 = s;
        inputstream.close();
        obj = s3;
        s2 = s;
        s1 = context.getAssets().open(s1);
        obj = s3;
        s2 = s;
        context = a(s1);
        obj = context;
        s2 = s;
        int i1;
        int k1;
        try
        {
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("GraphicsUtil", "Could not load requested shader");
            context = ((Context) (obj));
            s = s2;
        }
        k1 = a(35633, s);
        if (k1 == 0)
        {
            i1 = 0;
        } else
        {
            int l1 = a(35632, context);
            if (l1 == 0)
            {
                return 0;
            }
            int j1 = GLES20.glCreateProgram();
            i1 = j1;
            if (j1 != 0)
            {
                GLES20.glAttachShader(j1, k1);
                GLES20.glAttachShader(j1, l1);
                GLES20.glLinkProgram(j1);
                return j1;
            }
        }
        return i1;
    }

    public static int c(View view)
    {
        if (view.getParent() == view.getRootView())
        {
            return view.getTop();
        } else
        {
            int i1 = view.getTop();
            return c((View)view.getParent()) + i1;
        }
    }

    public static int c(EffectParameter effectparameter)
    {
        if (effectparameter.a() == com.photo.effect.EffectParameter.ParameterType.ParameterTypeInt)
        {
            int i1 = ((Integer)effectparameter.c()).intValue();
            return ((Integer)effectparameter.d()).intValue() - i1;
        } else
        {
            effectparameter = com.photo.effect.EffectParameter.ParameterType.ParameterTypeFloat;
            return 100;
        }
    }

    public static Class c()
    {
        if (SocialinV3.getInstance().getAppProps() != null && SocialinV3.getInstance().getAppProps().getProcess().equals("multy"))
        {
            return com/picsart/effects/clone/CloneActivity;
        } else
        {
            return com/picsart/effects/clone/CloneActivityMainProcess;
        }
    }

    public static String c(String s)
    {
        String s1 = null;
        Object obj;
        try
        {
            obj = new ExifInterface(s);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = null;
        }
        if (obj != null && ((ExifInterface) (obj)).getAttribute("UserComment") != null)
        {
            obj = ((ExifInterface) (obj)).getAttribute("UserComment");
        } else
        {
            obj = null;
        }
        if (ExifTool.a(s, "Exif.Photo.UserComment") != null)
        {
            s1 = ExifTool.a(s, "Exif.Photo.UserComment");
        }
        if (obj == null || s1 == null) goto _L2; else goto _L1
_L1:
        if (((String) (obj)).length() <= s1.length()) goto _L4; else goto _L3
_L3:
        return ((String) (obj));
_L4:
        return s1;
_L2:
        if (obj == null)
        {
            return s1;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static void c(Context context, String s)
    {
        if (context != null && !TextUtils.isEmpty(s))
        {
            NotificationManagerCompat.from(context).cancel(s.hashCode());
        }
    }

    public static boolean c(Context context)
    {
        boolean flag = false;
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (((ApplicationInfo) (context)).metaData != null)
            {
                flag = ((ApplicationInfo) (context)).metaData.getBoolean("io.branch.sdk.TestMode", false);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return flag;
    }

    public static int d(String s)
    {
        if (s != null)
        {
            if ((s = com.picsart.studio.utils.ExifUtils.ExifOrientation.fromString(ExifTool.a(s, "Exif.Image.Orientation"))) != null)
            {
                return ((com.picsart.studio.utils.ExifUtils.ExifOrientation) (s)).degree;
            }
        }
        return 0;
    }

    public static Object d(Context context, String s)
    {
        try
        {
            context = ((Context) (context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(s)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static boolean d()
    {
        boolean flag = false;
        c c1;
        try
        {
            c1 = k();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        if (c1 != null)
        {
            flag = true;
        }
        return flag;
    }

    public static int e(Context context, String s)
    {
        return context.getResources().getIdentifier(s, "string", context.getPackageName());
    }

    public static String e(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, e.a.name()).replace("+", "%20");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            com.socialin.android.d.b("Dropbox", "encode", unsupportedencodingexception);
            return s;
        }
        return s1;
    }

    public static boolean e()
    {
        return PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.LOW || PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.NORMAL || PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.NORMAL_PLUS || PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.HIGH;
    }

    public static String f(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (s.contains("feature"))
            {
                return "featured";
            }
            if (s.contains("top"))
            {
                return "top";
            }
            if (s.contains("trending"))
            {
                return "trending";
            } else
            {
                return "favorites";
            }
        } else
        {
            return null;
        }
    }

    public static myobfuscated.bw.a f()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new myobfuscated.bw.b();
        } else
        {
            return new myobfuscated.bw.c();
        }
    }

    public static Class g()
    {
        if (SocialinV3.getInstance().getAppProps() != null && SocialinV3.getInstance().getAppProps().getProcess().equals("multy"))
        {
            return com/socialin/android/photo/draw/DrawingActivity;
        } else
        {
            return com/socialin/android/photo/draw/DrawingActivityMainProcess;
        }
    }

    public static String g(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (s.contains("feature"))
            {
                return "featured";
            }
            if (s.contains("top"))
            {
                return "top";
            }
            if (s.contains("trending"))
            {
                return "trending";
            } else
            {
                return "favorites";
            }
        } else
        {
            return null;
        }
    }

    public static String h(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (s.contains("feature"))
            {
                return "featured";
            }
            if (s.contains("popular"))
            {
                return "popular";
            } else
            {
                return "recent";
            }
        } else
        {
            return null;
        }
    }

    public static List h()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Integer.valueOf(-1));
        arraylist.add(Integer.valueOf(0));
        arraylist.add(Integer.valueOf(1));
        arraylist.add(Integer.valueOf(3));
        arraylist.add(Integer.valueOf(4));
        if (i())
        {
            arraylist.add(Integer.valueOf(2));
        }
        if (j())
        {
            arraylist.add(Integer.valueOf(5));
        }
        return arraylist;
    }

    public static void i(String s)
    {
        do
        {
            int i1 = GLES20.glGetError();
            if (i1 != 0)
            {
                Log.e("ex", (new StringBuilder()).append(s).append(": glError ").append(i1).toString());
            } else
            {
                return;
            }
        } while (true);
    }

    public static boolean i()
    {
        try
        {
            PorterDuffXfermode porterduffxfermode = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY);
            (new Paint()).setXfermode(porterduffxfermode);
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return false;
        }
        return true;
    }

    public static String j(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            a(s, stringbuffer);
            return stringbuffer.toString();
        }
    }

    public static boolean j()
    {
        try
        {
            PorterDuffXfermode porterduffxfermode = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.ADD);
            (new Paint()).setXfermode(porterduffxfermode);
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return false;
        }
        return true;
    }

    private static c k()
    {
        c c1;
        try
        {
            c1 = (c)Class.forName("com.picsart.studio.ads.lib.AdsFactoryImpl").newInstance();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return null;
        }
        return c1;
    }

    private static PublicKey k(String s)
    {
        try
        {
            s = com.socialin.android.billing.a.a(s);
            s = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("IABUtil/Security", "Invalid key specification.");
            throw new IllegalArgumentException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            throw new IllegalArgumentException(s);
        }
        return s;
    }
}
