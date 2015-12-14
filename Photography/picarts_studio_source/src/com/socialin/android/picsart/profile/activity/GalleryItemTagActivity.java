// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.GetUserRecentTagsController;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.RecentTagsResponse;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.ParamWithUserData;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.views.PredicateLayout;
import com.socialin.asyncnet.b;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            e

public class GalleryItemTagActivity extends BaseActivity
{

    private static final String a = (new StringBuilder()).append(com/socialin/android/picsart/profile/activity/GalleryItemTagActivity.getSimpleName()).append(" - ").toString();
    private List b;
    private List c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private GetUserRecentTagsController j;
    private ParamWithUserData k;
    private PredicateLayout l;

    public GalleryItemTagActivity()
    {
        b = new ArrayList();
        c = new ArrayList();
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        i = 0;
        j = new GetUserRecentTagsController();
        k = new ParamWithUserData();
    }

    static String a(GalleryItemTagActivity galleryitemtagactivity, String s)
    {
        galleryitemtagactivity.d = s;
        return s;
    }

    static List a(GalleryItemTagActivity galleryitemtagactivity)
    {
        return galleryitemtagactivity.b;
    }

    private void a()
    {
        Object obj;
        boolean flag;
        flag = false;
        obj = Environment.getExternalStorageDirectory();
        obj = new File((new StringBuilder()).append(((File) (obj)).getAbsolutePath()).append("/").append(g).toString());
        ((File) (obj)).mkdir();
        obj = new File(((File) (obj)), h);
        if (((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ArrayList arraylist;
        ArrayList arraylist1;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        BufferedReader bufferedreader;
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_432;
        }
        obj = new InputStreamReader(new DataInputStream(new FileInputStream(((File) (obj)))));
        bufferedreader = new BufferedReader(((java.io.Reader) (obj)));
        int i1 = 0;
_L4:
        String s1 = bufferedreader.readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s1.trim();
        arraylist.add(s1.substring(0, s1.lastIndexOf("=")));
        arraylist1.add(Integer.valueOf(Integer.parseInt(s1.substring(s1.lastIndexOf("=") + 1))));
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        ((InputStreamReader) (obj)).close();
_L7:
        int j1 = 0;
_L8:
        int k1 = ((flag) ? 1 : 0);
        if (j1 >= i1) goto _L6; else goto _L5
        Exception exception;
        exception;
        i1 = 0;
_L9:
        com.socialin.android.d.c(new Object[] {
            a, exception, "can't read tags used by user"
        });
          goto _L7
_L5:
        for (k1 = 0; k1 < i1; k1++)
        {
            if (((Integer)arraylist1.get(j1)).intValue() > ((Integer)arraylist1.get(k1)).intValue())
            {
                int l1 = ((Integer)arraylist1.get(j1)).intValue();
                arraylist1.set(j1, arraylist1.get(k1));
                arraylist1.set(k1, Integer.valueOf(l1));
                String s = (String)arraylist.get(j1);
                arraylist.set(j1, arraylist.get(k1));
                arraylist.set(j1, s);
            }
        }

        j1++;
          goto _L8
_L6:
        while (k1 < i1) 
        {
            a((String)arraylist.get(k1));
            k1++;
        }
          goto _L1
        exception;
          goto _L9
        i1 = 0;
          goto _L7
    }

    static void a(GalleryItemTagActivity galleryitemtagactivity, View view)
    {
        if (galleryitemtagactivity.b.size() + galleryitemtagactivity.i >= 6 && !view.isSelected())
        {
            Utils.a(galleryitemtagactivity, 0x7f080247);
            return;
        }
        String s = ((TextView)view.findViewById(0x7f10097a)).getText().toString();
        boolean flag;
        if (view.isSelected())
        {
            galleryitemtagactivity.b.remove(s);
        } else
        {
            galleryitemtagactivity.b.add(s);
        }
        if (!view.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setSelected(flag);
    }

    static void a(GalleryItemTagActivity galleryitemtagactivity, RecentTagsResponse recenttagsresponse)
    {
        if (recenttagsresponse != null && recenttagsresponse.tags != null)
        {
            GalleryUtils.a(galleryitemtagactivity.g, recenttagsresponse.tags);
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("getUserRecentTags:Success   ")).append(recenttagsresponse.tags.toString()).toString()
            });
            for (recenttagsresponse = recenttagsresponse.tags.iterator(); recenttagsresponse.hasNext(); galleryitemtagactivity.a((String)recenttagsresponse.next())) { }
        }
        StringBuilder stringbuilder = (new StringBuilder()).append(galleryitemtagactivity.f);
        if ("".equals(galleryitemtagactivity.e))
        {
            recenttagsresponse = "";
        } else
        {
            recenttagsresponse = (new StringBuilder(",")).append(galleryitemtagactivity.e).toString();
        }
        galleryitemtagactivity.e = stringbuilder.append(recenttagsresponse).toString();
    }

    private void a(String s)
    {
        boolean flag = false;
        if (s != null && !"".equals(s.trim()))
        {
            if (!"".equals(s))
            {
                String s1;
                if (s.length() > 55)
                {
                    s1 = s.substring(0, 54);
                } else
                {
                    s1 = s;
                }
                s1 = s1.replaceAll(" ", "sp").replaceAll(",", "cm").replaceAll("&", "amp");
                flag = Pattern.compile("^[a-zA-Z0-9_-]{1,55}$").matcher(s1).matches();
            }
            if (flag)
            {
                runOnUiThread(new Runnable(s) {

                    final GalleryItemTagActivity a;
                    private String b;

                    public final void run()
                    {
                        View view = a.getLayoutInflater().inflate(0x7f03020d, null);
                        ((TextView)view.findViewById(0x7f10097a)).setText(b);
                    /* block-local class not found */
                    class _cls1 {}

                        view.findViewById(0x7f10084f).setOnClickListener(new _cls1());
                        view.setTag(b);
                        GalleryItemTagActivity.c(a).addView(view);
                        GalleryItemTagActivity.c(a).invalidate();
                    }

            
            {
                a = GalleryItemTagActivity.this;
                b = s;
                super();
            }
                });
            }
        }
    }

    static String b(GalleryItemTagActivity galleryitemtagactivity)
    {
        return galleryitemtagactivity.d;
    }

    static PredicateLayout c(GalleryItemTagActivity galleryitemtagactivity)
    {
        return galleryitemtagactivity.l;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().setSoftInputMode(3);
        g = (new StringBuilder()).append(getString(0x7f0808fb)).append("/cache").toString();
        h = getResources().getString(0x7f08097c);
        setContentView(0x7f030206);
        l = (PredicateLayout)findViewById(0x7f10094a);
        a();
        bundle = getIntent();
        if (bundle != null)
        {
            i = bundle.getIntExtra("selectedTagsCount", 0);
            if (bundle.hasExtra("popularTags"))
            {
                e = bundle.getStringExtra("popularTags");
            }
            if (TextUtils.isEmpty(e))
            {
                e = SocialinV3.getInstance().getAppProps().getGalleryPromoTags();
            }
            if (bundle.hasExtra("userRecentTags"))
            {
                f = bundle.getStringExtra("userRecentTags");
                StringBuilder stringbuilder = (new StringBuilder()).append(f);
                if ("".equals(e))
                {
                    bundle = "";
                } else
                {
                    bundle = (new StringBuilder(",")).append(e).toString();
                }
                e = stringbuilder.append(bundle).toString();
            } else
            {
                f = GalleryUtils.a(g);
                if (TextUtils.isEmpty(f))
                {
                    k.userId = SocialinV3.getInstance().getUser().id;
                    j.setRequestParams(k);
                    j.setRequestCompleteListener(new e(this, (byte)0));
                    j.doRequest(a, k);
                } else
                {
                    StringBuilder stringbuilder1 = (new StringBuilder()).append(f);
                    if ("".equals(e))
                    {
                        bundle = "";
                    } else
                    {
                        bundle = (new StringBuilder(",")).append(e).toString();
                    }
                    e = stringbuilder1.append(bundle).toString();
                }
            }
        }
        findViewById(0x7f10094b).setOnClickListener(new android.view.View.OnClickListener() {

            private GalleryItemTagActivity a;

            public final void onClick(View view)
            {
                a.setResult(0);
                a.finish();
            }

            
            {
                a = GalleryItemTagActivity.this;
                super();
            }
        });
        findViewById(0x7f10094c).setOnClickListener(new android.view.View.OnClickListener() {

            private GalleryItemTagActivity a;

            public final void onClick(View view)
            {
                GalleryItemTagActivity galleryitemtagactivity = a;
                if (GalleryItemTagActivity.a(a) == null)
                {
                    view = "";
                } else
                {
                    view = TextUtils.join(",", GalleryItemTagActivity.a(a));
                }
                GalleryItemTagActivity.a(galleryitemtagactivity, view);
                view = new Intent();
                view.putExtra("itemTags", com.socialin.android.picsart.profile.activity.GalleryItemTagActivity.b(a));
                a.setResult(-1, view);
                a.finish();
            }

            
            {
                a = GalleryItemTagActivity.this;
                super();
            }
        });
    }

    protected void onDestroy()
    {
        com.socialin.asyncnet.b.a().a(a);
        j.setRequestCompleteListener(null);
        super.onDestroy();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        String s = e;
        bundle = c;
        if (!TextUtils.isEmpty(s))
        {
            String as[] = s.split(",");
            if (as.length > 0)
            {
                bundle.clear();
                int j1 = as.length;
                for (int i1 = 0; i1 < j1; i1++)
                {
                    String s1 = as[i1];
                    if (!"null".equals(s1) && !bundle.contains(s1))
                    {
                        bundle.add(s1);
                    }
                }

            }
        }
        Collections.sort(c, String.CASE_INSENSITIVE_ORDER);
        for (bundle = c.iterator(); bundle.hasNext(); a((String)bundle.next())) { }
    }

}
