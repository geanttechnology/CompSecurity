// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.util;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.utils.g;
import com.picsart.studio.utils.h;
import com.socialin.android.NoProGuard;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.b;
import com.socialin.android.util.Utils;
import com.socialin.android.util.a;
import com.socialin.android.util.aa;
import com.socialin.android.util.n;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import myobfuscated.cv.c;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.util:
//            a

public class StudioManager
    implements NoProGuard
{

    private static final String CLASS_NAME_STUDIO_ACTIVITY = "com.socialin.android.photo.picsinphoto.StudioActivity";
    private static boolean hookHandled = false;
    private static boolean linkHandled = false;

    private StudioManager()
    {
    }

    public static void assignStudioButtonActions(View view, Activity activity, com.socialin.android.picsart.profile.adapter.d d1)
    {
        if (view == null)
        {
            return;
        } else
        {
            clickFX(activity, view, d1);
            clickEdit(activity, view, d1);
            clickCollage(activity, view, d1);
            clickCamera(activity, view, d1);
            clickDraw(activity, view, d1);
            return;
        }
    }

    public static void checkForRecommendedSizeAndDoAction(Activity activity, String s1, Map map, Runnable runnable, Runnable runnable1)
    {
        a a1;
label0:
        {
            a1 = new a(activity.getApplicationContext());
            if (!a1.b("prefs.rec.size.donotshow"))
            {
                boolean flag;
                if (m.e())
                {
                    flag = false;
                } else
                if (w.a(s1, map).c <= PicsartContext.a.getRecomendedImageSizePixel())
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (flag)
                {
                    break label0;
                }
            }
            runnable.run();
            return;
        }
        map = w.a(s1, map);
        s1 = w.a(map, PicsartContext.a.getRecomendedImageSizePixel());
        map = w.a(map, PicsartContext.a.getMaxImageSizePixel());
        int i = PicsartContext.a(activity);
        b b1 = (new b()).a(0, 0x7f0c0181);
        b1.f = 0x7f0300a0;
        b1.a = activity.getResources().getString(0x7f0800c3);
        b1.h = false;
        b1 = b1.a(activity.getResources().getString(0x7f080311));
        b1.g = true;
        b1.m = new _cls7(runnable1);
        runnable1 = b1.a();
        s1 = new h(s1, map, i);
        map = new g(runnable, a1);
        try
        {
            runnable1.a(s1);
            runnable1.e = map;
            runnable1.show(activity.getFragmentManager(), "dialogChoosePhotoSize");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            d.a(activity.getMessage(), activity);
        }
    }

    private static void clickCamera(Activity activity, View view, com.socialin.android.picsart.profile.adapter.d d1)
    {
        view = view.findViewById(0x7f10026b);
        if (view != null)
        {
            view.setOnClickListener(new _cls5(activity, d1));
        }
    }

    private static void clickCollage(Activity activity, View view, com.socialin.android.picsart.profile.adapter.d d1)
    {
        view = view.findViewById(0x7f10026a);
        if (view != null)
        {
            view.setOnClickListener(new _cls4(activity, d1));
        }
    }

    private static void clickDraw(Activity activity, View view, com.socialin.android.picsart.profile.adapter.d d1)
    {
        view = view.findViewById(0x7f10026c);
        if (view != null)
        {
            view.setOnClickListener(new _cls6(activity, d1));
        }
    }

    private static void clickEdit(Activity activity, View view, com.socialin.android.picsart.profile.adapter.d d1)
    {
        view = view.findViewById(0x7f100269);
        if (view != null)
        {
            view.setOnClickListener(new _cls3(activity, d1));
        }
    }

    private static void clickFX(Activity activity, View view, com.socialin.android.picsart.profile.adapter.d d1)
    {
        view = view.findViewById(0x7f100268);
        if (view != null)
        {
            view.setOnClickListener(new _cls2(activity, d1));
        }
    }

    public static boolean isHookHandled()
    {
        return hookHandled;
    }

    public static boolean isLinkHandled()
    {
        return linkHandled;
    }

    public static void openCollage(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.socialin.android.photo.picsinphoto.StudioActivity");
        intent.putExtra("dialog.type", 6);
        activity.startActivity(intent);
    }

    public static void openCollageDialog(Activity activity)
    {
        openCollageDialog(activity, null);
    }

    public static void openCollageDialog(Activity activity, String s1)
    {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.socialin.android.photo.picsinphoto.StudioActivity");
        intent.putExtra("dialog.type", 2);
        intent.putExtra("session_id", s1);
        activity.startActivity(intent);
    }

    public static void openDraw(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.socialin.android.photo.picsinphoto.StudioActivity");
        intent.putExtra("dialog.type", 7);
        activity.startActivity(intent);
    }

    public static void openDrawDialog(Activity activity)
    {
        openDrawDialog(activity, null);
    }

    public static void openDrawDialog(Activity activity, String s1)
    {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.socialin.android.photo.picsinphoto.StudioActivity");
        intent.putExtra("dialog.type", 1);
        intent.putExtra("session_id", s1);
        activity.startActivity(intent);
    }

    public static void openEffects(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.socialin.android.photo.picsinphoto.StudioActivity");
        intent.setFlags(0x4000000);
        intent.putExtra("dialog.type", 4);
        activity.startActivity(intent);
    }

    public static void openImageInEditor(Activity activity, String s1, com.picsart.studio.util.a a1, ImageItem imageitem, String s2, String s3, Runnable runnable)
    {
        openImageInEditor(activity, s1, a1, imageitem, s2, s3, runnable, null);
    }

    public static void openImageInEditor(Activity activity, String s1, com.picsart.studio.util.a a1, ImageItem imageitem, String s2, String s3, Runnable runnable, Runnable runnable1)
    {
        if (activity == null || activity.isFinishing() || android.os.Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())
        {
            return;
        } else
        {
            checkForRecommendedSizeAndDoAction(activity, s1, null, new _cls1(new Intent(), activity, s1, a1, s2, s3, imageitem, runnable1), runnable);
            return;
        }
    }

    public static void openPhotoEditor(Activity activity)
    {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.socialin.android.photo.picsinphoto.StudioActivity");
        intent.setFlags(0x4000000);
        intent.putExtra("dialog.type", 5);
        activity.startActivity(intent);
    }

    public static void openShop(Activity activity, Map map)
    {
        if (!s.a(activity))
        {
            DialogUtils.showNoNetworkDialog(activity, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(activity, "com.picsart.shop.ShopActivity");
        if (map != null)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); intent.putExtra((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        c.a(intent, activity);
        activity.startActivity(intent);
    }

    public static void setHookHandled(boolean flag)
    {
        hookHandled = flag;
    }

    public static void setLinkHandled(boolean flag)
    {
        linkHandled = flag;
    }

    public static boolean startCamera(Activity activity)
    {
        return startCamera(activity, null);
    }

    public static boolean startCamera(Activity activity, String s1)
    {
        boolean flag = aa.a(activity);
        if (!flag)
        {
            Utils.b(activity, activity.getString(0x7f080294));
            return flag;
        } else
        {
            AnalyticUtils.getInstance(activity).trackLocalAction("start:camera");
            Intent intent = new Intent();
            intent.setClassName(activity, "com.socialin.picsin.camera.CameraMainActivity");
            intent.putExtra("session_id", s1);
            intent.putExtra("from.where.opened", "from.launcher");
            activity.startActivity(intent);
            return flag;
        }
    }


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
