// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.GetBannersController;
import com.socialin.android.apiv3.model.BannersResponse;
import com.socialin.android.picsart.profile.activity.WebViewActivity;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.ArrayList;
import java.util.Iterator;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.photo.util:
//            b

public final class a
    implements d
{

    private static a c;
    public boolean a;
    long b;
    private Context d;

    public a()
    {
        new GetBannersController();
        new Handler();
        d = null;
        a = false;
        b = 0L;
    }

    public static a a(Context context)
    {
        if (c == null)
        {
            c = new a();
        }
        c.d = context;
        return c;
    }

    static void a(ImageView imageview, com.socialin.android.apiv3.model.BannersResponse.BannerItem banneritem)
    {
        boolean flag = false;
        if (imageview != null && banneritem != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = null;
        if (!TextUtils.isEmpty(banneritem.activityName))
        {
            obj = new Intent();
            ((Intent) (obj)).setClassName(imageview.getContext().getApplicationContext(), banneritem.activityName);
            myobfuscated.cv.c.a(((Intent) (obj)), (Activity)imageview.getContext());
        }
        if (TextUtils.isEmpty(banneritem.actionUrl)) goto _L4; else goto _L3
_L3:
        Object obj1;
        int i;
        if (banneritem.actionUrl.contains("facebook") || banneritem.actionUrl.contains("fb"))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj1 = obj;
        if (!TextUtils.isEmpty(banneritem.activityName) || i == 0) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        banneritem.activityName = "com.facebook.katana";
        obj1 = obj;
        banneritem.actionUrl = (new StringBuilder("fb://page/")).append(imageview.getContext().getString(0x7f0808e3)).toString();
        obj1 = obj;
        obj = new Intent("android.intent.action.VIEW", Uri.parse(banneritem.actionUrl));
_L8:
        obj1 = obj;
        if (TextUtils.isEmpty(banneritem.activityName) || i == 0) goto _L4; else goto _L7
_L7:
        obj1 = obj;
        imageview.getContext().getPackageManager().getPackageInfo(banneritem.activityName, 0);
          goto _L4
_L6:
        obj1 = obj;
        if (!banneritem.useWebview)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        obj1 = obj;
        obj = new Intent(imageview.getContext().getApplicationContext(), com/socialin/android/picsart/profile/activity/WebViewActivity);
        ((Intent) (obj)).putExtra("url", banneritem.actionUrl);
          goto _L8
        obj1 = obj;
        obj = new Intent("android.intent.action.VIEW");
        ((Intent) (obj)).setData(Uri.parse(banneritem.actionUrl));
          goto _L8
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        obj = obj1;
_L10:
        namenotfoundexception.printStackTrace();
_L4:
        if (banneritem.activityParams != null)
        {
            i = ((flag) ? 1 : 0);
            while (i < banneritem.activityParams.size()) 
            {
                obj1 = (com.socialin.android.apiv3.model.BannersResponse.ActivityParams)banneritem.activityParams.get(i);
                if (obj1 != null && !TextUtils.isEmpty(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value))
                {
                    if ("int".equalsIgnoreCase(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).type))
                    {
                        ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, Long.parseLong(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value));
                    } else
                    if ("boolean".equalsIgnoreCase(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).type))
                    {
                        ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, Boolean.parseBoolean(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value));
                    } else
                    {
                        ((Intent) (obj)).putExtra(((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).name, ((com.socialin.android.apiv3.model.BannersResponse.ActivityParams) (obj1)).value);
                    }
                }
                i++;
            }
        }
        try
        {
            imageview.getContext().startActivity(((Intent) (obj)));
            return;
        }
        catch (Exception exception)
        {
            if (TextUtils.isEmpty(banneritem.activityName))
            {
                exception.printStackTrace();
                return;
            }
        }
        try
        {
            if (banneritem.activityName != null && banneritem.activityName.contains("facebook"))
            {
                banneritem = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://facebook.com/")).append(imageview.getContext().getString(0x7f0808e4)).toString()));
                banneritem.putExtra("client_id", imageview.getContext().getString(0x7f0808e2));
                imageview.getContext().startActivity(banneritem);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ImageView imageview)
        {
            imageview.printStackTrace();
            return;
        }
        if (banneritem.activityName == null || !banneritem.activityName.contains("twitter")) goto _L1; else goto _L9
_L9:
        banneritem = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/#!")).append(imageview.getContext().getString(0x7f080978)).toString()));
        imageview.getContext().startActivity(banneritem);
        return;
        namenotfoundexception;
          goto _L10
        namenotfoundexception;
          goto _L10
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        exception.printStackTrace();
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        BannersResponse bannersresponse = (BannersResponse)obj;
        if (bannersresponse == null || bannersresponse.response == null || bannersresponse.response.isEmpty())
        {
            return;
        }
        request = com.picsart.studio.utils.c.d(d);
        b = 0L;
        obj = new ArrayList();
        Iterator iterator = bannersresponse.response.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.socialin.android.apiv3.model.BannersResponse.ItemData itemdata = (com.socialin.android.apiv3.model.BannersResponse.ItemData)iterator.next();
            if ((!"reg_user".equals(itemdata.data.visible) || SocialinV3.getInstance().isRegistered()) && (!"nonreg_user".equals(itemdata.data.visible) || !SocialinV3.getInstance().isRegistered()) && (itemdata.data.country.equalsIgnoreCase(request) || itemdata.data.country.equals("")))
            {
                ((ArrayList) (obj)).add(new b(itemdata.data));
            }
        } while (true);
        throw new NullPointerException();
    }

    // Unreferenced inner class com/socialin/android/photo/util/a$1

/* anonymous class */
    final class _cls1 extends com.socialin.android.net.d
    {

        private String a;
        private ImageView b;
        private b c;
        private View d;
        private TextView e;
        private long f;
        private a g;

        protected final transient Integer a(String as[])
        {
            int j = super.a(as).intValue();
            if (j == 1) goto _L2; else goto _L1
_L1:
            int i = j;
            if (j != 2) goto _L3; else goto _L2
_L2:
            android.graphics.BitmapFactory.Options options;
            com.socialin.android.util.c.a = true;
            options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            com.socialin.android.util.c.a(a, options);
            if (options.outWidth <= 1024 && options.outHeight <= 1024) goto _L5; else goto _L4
_L4:
            i = Math.max(options.outWidth / 1024, options.outHeight / 1024);
_L8:
            options.inSampleSize = i;
            as = new DisplayMetrics();
            if (b != null && b.getContext() != null)
            {
                ((Activity)b.getContext()).getWindowManager().getDefaultDisplay().getMetrics(as);
            }
            if (((DisplayMetrics) (as)).widthPixels <= 480)
            {
                options.inSampleSize = 2;
            }
            options.inJustDecodeBounds = false;
            as = com.socialin.android.util.c.a(a, options);
            if (as == null)
            {
                i = -1;
            } else
            {
                i = j;
            }
            com.socialin.android.util.c.a = false;
            c.a = as;
_L3:
            return Integer.valueOf(i);
            as;
            i = 1;
_L6:
            options.inJustDecodeBounds = false;
            options.inSampleSize = i * 2;
            com.socialin.android.util.c.a = false;
            as = com.socialin.android.util.c.a(a, options);
            i = 1;
            if (true)
            {
                break MISSING_BLOCK_LABEL_178;
            }
            as;
            if (true) goto _L6; else goto _L5
_L5:
            i = 1;
            if (true) goto _L8; else goto _L7
_L7:
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (Integer)obj;
            super.onPostExecute(obj);
            if (com.socialin.android.d.b)
            {
                (new StringBuilder("File downloaded result ")).append(obj).append(", path: ").append(c.a);
            }
            if (c.a != null && b != null && (((Integer) (obj)).intValue() == 1 || ((Integer) (obj)).intValue() == 2))
            {
                myobfuscated.b.a.setDrawable(b, new myobfuscated.cd.a(b.getContext().getResources(), c.a));
                d.setVisibility(8);
                if (e != null && !TextUtils.isEmpty(c.data.message))
                {
                    e.setVisibility(0);
                    e.setText(c.data.message);
                    return;
                } else
                {
                    e.setVisibility(8);
                    return;
                }
            } else
            {
                g.b = f;
                return;
            }
        }

            
            {
                g = a.this;
                a = s;
                b = imageview;
                c = b1;
                d = view;
                e = textview;
                f = l;
                super();
            }
    }

}
