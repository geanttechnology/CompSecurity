// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            LogUtil

public class ResourceManager
{

    private static final String DRAWABLE = "drawable";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String PRE_INSTALL_DRAWBLE_PATHS[] = {
        "drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable"
    };
    private static final String TAG = com/sina/weibo/sdk/utils/ResourceManager.getName();

    public ResourceManager()
    {
    }

    public static ColorStateList createColorStateList(int i, int j)
    {
        int ai1[] = {
            0x10100a7
        };
        int ai2[] = {
            0x101009c
        };
        int ai[] = StateSet.WILD_CARD;
        return new ColorStateList(new int[][] {
            ai1, new int[] {
                0x10100a1
            }, ai2, ai
        }, new int[] {
            j, j, j, i
        });
    }

    public static StateListDrawable createStateListDrawable(Context context, String s, String s1)
    {
        if (s.indexOf(".9") > -1)
        {
            s = getNinePatchDrawable(context, s);
        } else
        {
            s = getDrawable(context, s);
        }
        if (s1.indexOf(".9") > -1)
        {
            context = getNinePatchDrawable(context, s1);
        } else
        {
            context = getDrawable(context, s1);
        }
        s1 = new StateListDrawable();
        s1.addState(new int[] {
            0x10100a7
        }, context);
        s1.addState(new int[] {
            0x10100a1
        }, context);
        s1.addState(new int[] {
            0x101009c
        }, context);
        s1.addState(StateSet.WILD_CARD, s);
        return s1;
    }

    public static StateListDrawable createStateListDrawable(Context context, String s, String s1, String s2)
    {
        if (s.indexOf(".9") > -1)
        {
            s = getNinePatchDrawable(context, s);
        } else
        {
            s = getDrawable(context, s);
        }
        if (s2.indexOf(".9") > -1)
        {
            s2 = getNinePatchDrawable(context, s2);
        } else
        {
            s2 = getDrawable(context, s2);
        }
        if (s1.indexOf(".9") > -1)
        {
            context = getNinePatchDrawable(context, s1);
        } else
        {
            context = getDrawable(context, s1);
        }
        s1 = new StateListDrawable();
        s1.addState(new int[] {
            0x10100a7
        }, context);
        s1.addState(new int[] {
            0x10100a1
        }, context);
        s1.addState(new int[] {
            0x101009c
        }, context);
        s1.addState(new int[] {
            0x101000e
        }, s2);
        s1.addState(StateSet.WILD_CARD, s);
        return s1;
    }

    public static int dp2px(Context context, int i)
    {
        context = context.getResources().getDisplayMetrics();
        float f = i;
        return (int)((double)(((DisplayMetrics) (context)).density * f) + 0.5D);
    }

    private static Drawable extractDrawable(Context context, String s)
    {
        InputStream inputstream = context.getAssets().open(s);
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        TypedValue typedvalue = new TypedValue();
        typedvalue.density = displaymetrics.densityDpi;
        context = Drawable.createFromResourceStream(context.getResources(), typedvalue, inputstream, s);
        inputstream.close();
        return context;
    }

    private static View extractView(Context context, String s, ViewGroup viewgroup)
    {
        s = context.getAssets().openXmlResourceParser(s);
        return ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(s, viewgroup);
    }

    private static String getAppropriatePathOfDrawable(Context context, String s)
    {
        String s1;
        int i;
        int k;
        int l;
        if (TextUtils.isEmpty(s))
        {
            LogUtil.e(TAG, "id is NOT correct!");
            return null;
        }
        s1 = getCurrentDpiFolder(context);
        LogUtil.d(TAG, "find Appropriate path...");
        i = 0;
        l = -1;
        k = -1;
_L7:
        if (i < PRE_INSTALL_DRAWBLE_PATHS.length) goto _L2; else goto _L1
_L1:
        int j;
        int i1;
        j = -1;
        i1 = l;
_L6:
        if (k <= 0 || j <= 0) goto _L4; else goto _L3
_L3:
        i = k;
        if (Math.abs(i1 - j) <= Math.abs(i1 - k))
        {
            i = j;
        }
_L10:
        String s2;
        if (i < 0)
        {
            LogUtil.e(TAG, "Not find the appropriate path for drawable");
            return null;
        } else
        {
            return (new StringBuilder(String.valueOf(PRE_INSTALL_DRAWBLE_PATHS[i]))).append("/").append(s).toString();
        }
_L2:
        if (PRE_INSTALL_DRAWBLE_PATHS[i].equals(s1))
        {
            l = i;
        }
        s2 = (new StringBuilder(String.valueOf(PRE_INSTALL_DRAWBLE_PATHS[i]))).append("/").append(s).toString();
        j = k;
        if (!isFileExisted(context, s2))
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (l == i)
        {
            return s2;
        }
        j = i;
        i1 = l;
        if (l >= 0) goto _L6; else goto _L5
_L5:
        j = i;
        i++;
        k = j;
          goto _L7
_L4:
        if (k <= 0) goto _L9; else goto _L8
_L8:
        i = k;
        if (j < 0) goto _L10; else goto _L9
_L9:
        if (k < 0 && j > 0)
        {
            i = j;
        } else
        {
            LogUtil.e(TAG, "Not find the appropriate path for drawable");
            i = -1;
        }
          goto _L10
    }

    private static String getCurrentDpiFolder(Context context)
    {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i <= 120)
        {
            return "drawable-ldpi";
        }
        if (i > 120 && i <= 160)
        {
            return "drawable-mdpi";
        }
        if (i > 160 && i <= 240)
        {
            return "drawable-hdpi";
        }
        if (i > 240 && i <= 320)
        {
            return "drawable-xhdpi";
        } else
        {
            return "drawable-xxhdpi";
        }
    }

    public static Drawable getDrawable(Context context, String s)
    {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, s), false);
    }

    private static Drawable getDrawableFromAssert(Context context, String s, boolean flag)
    {
        Object obj = context.getAssets();
        s = ((AssetManager) (obj)).open(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        DisplayMetrics displaymetrics;
        obj = BitmapFactory.decodeStream(s);
        displaymetrics = context.getResources().getDisplayMetrics();
        if (!flag) goto _L4; else goto _L3
_L3:
        android.content.res.Configuration configuration = context.getResources().getConfiguration();
        context = new NinePatchDrawable(new Resources(context.getAssets(), displaymetrics, configuration), ((Bitmap) (obj)), ((Bitmap) (obj)).getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
_L9:
        IOException ioexception;
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return context;
            }
        }
        return context;
_L4:
        try
        {
            ((Bitmap) (obj)).setDensity(displaymetrics.densityDpi);
            context = new BitmapDrawable(context.getResources(), ((Bitmap) (obj)));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            context = s;
            s = ioexception;
        }
        finally
        {
            continue; /* Loop/switch isn't completed */
        }
_L7:
        s.printStackTrace();
        Exception exception;
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
            return null;
        } else
        {
            return null;
        }
        context;
        s = null;
_L6:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        throw context;
        exception;
        s = context;
        context = exception;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        context = null;
        if (true) goto _L7; else goto _L2
_L2:
        context = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static Locale getLanguage()
    {
        Locale locale = Locale.getDefault();
        if (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale))
        {
            return locale;
        } else
        {
            return Locale.ENGLISH;
        }
    }

    public static Drawable getNinePatchDrawable(Context context, String s)
    {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, s), true);
    }

    public static String getString(Context context, String s, String s1, String s2)
    {
        context = getLanguage();
        if (Locale.SIMPLIFIED_CHINESE.equals(context))
        {
            return s1;
        }
        if (Locale.TRADITIONAL_CHINESE.equals(context))
        {
            return s2;
        } else
        {
            return s;
        }
    }

    private static boolean isFileExisted(Context context, String s)
    {
        if (context != null && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj;
        Object obj1;
        obj1 = context.getAssets();
        obj = null;
        context = null;
        obj1 = ((AssetManager) (obj1)).open(s);
        context = ((Context) (obj1));
        obj = obj1;
        LogUtil.d(TAG, (new StringBuilder("file [")).append(s).append("] existed").toString());
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
        }
        return true;
        obj;
        obj = context;
        LogUtil.d(TAG, (new StringBuilder("file [")).append(s).append("] NOT existed").toString());
        if (context == null) goto _L1; else goto _L3
_L3:
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return false;
        context;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        throw context;
    }

    public static String readCountryFromAsset(Context context, String s)
    {
        String s1 = "";
        Object obj = s1;
        byte abyte0[];
        try
        {
            s = context.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return ((String) (obj));
        }
        context = s1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        obj = s1;
        context = new DataInputStream(s);
        obj = s1;
        abyte0 = new byte[context.available()];
        obj = s1;
        context.read(abyte0);
        obj = s1;
        context = EncodingUtils.getString(abyte0, "UTF-8");
        obj = context;
        s.close();
        return context;
    }

}
