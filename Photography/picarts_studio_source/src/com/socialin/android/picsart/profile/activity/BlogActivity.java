// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.BlogsResponse;
import com.socialin.android.apiv3.request.ParamWithPageLimit;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.util.c;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.List;
import myobfuscated.cd.a;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            b, a

public class BlogActivity extends BaseActivity
    implements d
{

    private static final String a = com/socialin/android/picsart/profile/activity/BlogActivity.getSimpleName();
    private static final String b = (new StringBuilder()).append(a).append("_Blog_").append(System.currentTimeMillis()).toString();
    private BaseSocialinApiRequestController c;
    private ParamWithPageLimit d;
    private android.widget.AbsListView.OnScrollListener e;
    private com.socialin.android.picsart.profile.activity.a f;
    private ListView g;
    private View h;
    private View i;
    private View j;
    private boolean k;

    public BlogActivity()
    {
        c = RequestControllerFactory.createBlogsController();
        d = new ParamWithPageLimit();
        k = false;
    }

    static int a(String s1, ImageView imageview, com.socialin.android.apiv3.model.BlogsResponse.Blog blog)
    {
        return b(s1, imageview, blog);
    }

    static ListView a(BlogActivity blogactivity)
    {
        return blogactivity.g;
    }

    static String a()
    {
        return a;
    }

    static void a(BlogActivity blogactivity, ImageView imageview, com.socialin.android.apiv3.model.BlogsResponse.Blog blog, String s1)
    {
        if (imageview != null && blog != null)
        {
            boolean flag;
            if (blog.bitmap != null && !blog.bitmap.isRecycled())
            {
                imageview.setImageDrawable(new a(imageview.getContext().getResources(), blog.bitmap));
                flag = false;
            } else
            if (blog.resId > 0)
            {
                imageview.setImageDrawable(new a(blogactivity.getResources(), com.socialin.android.util.c.a(blogactivity.getResources(), blog.resId, null, s1)));
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag && !TextUtils.isEmpty(blog.photo))
            {
                s1 = GalleryUtils.a(imageview.getContext(), blog.photo);
                (new b(blogactivity, imageview, blog, s1)).a(new String[] {
                    blog.photo, s1
                });
                return;
            }
        }
    }

    private static int b(String s1, ImageView imageview, com.socialin.android.apiv3.model.BlogsResponse.Blog blog)
    {
        android.graphics.BitmapFactory.Options options;
        c.a = true;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        com.socialin.android.util.c.a(s1, options);
        if (options.outWidth <= 1024 && options.outHeight <= 1024) goto _L2; else goto _L1
_L1:
        int l = Math.max(options.outWidth / 1024, options.outHeight / 1024);
_L7:
        options.inSampleSize = l;
        DisplayMetrics displaymetrics = new DisplayMetrics();
        if (imageview.getContext() != null)
        {
            ((Activity)imageview.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        }
        if (displaymetrics.widthPixels <= 480)
        {
            options.inSampleSize = 2;
        }
        options.inJustDecodeBounds = false;
        imageview = com.socialin.android.util.c.a(s1, options);
        if (imageview != null);
        s1 = imageview;
        l = -1;
_L4:
        c.a = false;
        blog.bitmap = s1;
        return l;
        imageview;
        l = 1;
_L5:
        com.socialin.android.d.a(a, imageview);
        options.inJustDecodeBounds = false;
        options.inSampleSize = l * 2;
        c.a = false;
        s1 = com.socialin.android.util.c.a(s1, options);
        l = 1;
        if (true) goto _L4; else goto _L3
_L3:
        imageview;
          goto _L5
_L2:
        l = 1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static String b()
    {
        return b;
    }

    static void b(BlogActivity blogactivity)
    {
        blogactivity.c();
    }

    static View c(BlogActivity blogactivity)
    {
        return blogactivity.i;
    }

    private void c()
    {
        h.setVisibility(0);
        g.setVisibility(8);
        d.offset = 0;
        d.limit = 30;
        c.setRequestParams(d);
        c.setRequestCompleteListener(this);
        c.doRequest("get_blog_list", d);
    }

    private void d()
    {
        Object obj;
        int l;
        if (f != null)
        {
            l = f.getCount();
        } else
        {
            l = 0;
        }
        obj = findViewById(0x7f100974);
        if (l > 0)
        {
            l = 8;
        } else
        {
            l = 0;
        }
        ((View) (obj)).setVisibility(l);
        j.setVisibility(0);
        obj = (TextView)findViewById(0x7f100978);
        if (!s.a(this)) goto _L2; else goto _L1
_L1:
        ((TextView) (obj)).setText(0x7f0805bd);
_L4:
        ((TextView) (obj)).setVisibility(0);
        return;
_L2:
        ((TextView) (obj)).setText(0x7f080424);
        if (findViewById(0x7f100975) != null)
        {
            findViewById(0x7f100975).setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean d(BlogActivity blogactivity)
    {
        return blogactivity.k;
    }

    static com.socialin.android.picsart.profile.activity.a e(BlogActivity blogactivity)
    {
        return blogactivity.f;
    }

    static void f(BlogActivity blogactivity)
    {
        if (blogactivity.c.getRequestStatus() != 0)
        {
            if (blogactivity.f != null)
            {
                blogactivity.d.offset = blogactivity.f.getCount();
            }
            blogactivity.c.doRequest("get_blog_list", blogactivity.d);
        }
    }

    public void onCancelRequest(Object obj, Request request)
    {
        com.socialin.android.d.a(a, "setImage: onCancelRequest:");
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (f != null)
        {
            f.a();
            f.notifyDataSetChanged();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030208);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setTitle(getString(0x7f0805fa));
            bundle.setDisplayShowHomeEnabled(false);
            bundle.setDisplayHomeAsUpEnabled(true);
        }
        h = findViewById(0x7f100959);
        g = (ListView)findViewById(0x7f100958);
        bundle = g;
        if (e == null)
        {
            e = new android.widget.AbsListView.OnScrollListener() {

                private BlogActivity a;

                public final void onScroll(AbsListView abslistview, int l, int i1, int j1)
                {
                    if (com.socialin.android.picsart.profile.activity.BlogActivity.c(a) != null)
                    {
                        abslistview = com.socialin.android.picsart.profile.activity.BlogActivity.c(a);
                        if (l > 5)
                        {
                            j1 = 0;
                        } else
                        {
                            j1 = 8;
                        }
                        abslistview.setVisibility(j1);
                    }
                    if (!com.socialin.android.picsart.profile.activity.BlogActivity.d(a) && BlogActivity.e(a) != null && (l + i1) - 1 == BlogActivity.e(a).getCount() - 1)
                    {
                        BlogActivity.f(a);
                    }
                }

                public final void onScrollStateChanged(AbsListView abslistview, int l)
                {
                    com.socialin.android.d.c(new Object[] {
                        com.socialin.android.picsart.profile.activity.BlogActivity.a(), (new StringBuilder("setOnScrollListener: ")).append(l).toString()
                    });
                }

            
            {
                a = BlogActivity.this;
                super();
            }
            };
        }
        bundle.setOnScrollListener(e);
        i = findViewById(0x7f1001f2);
        i.setVisibility(8);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            private BlogActivity a;

            public final void onClick(View view)
            {
                if (com.socialin.android.picsart.profile.activity.BlogActivity.a(a) != null)
                {
                    com.socialin.android.picsart.profile.activity.BlogActivity.a(a).smoothScrollToPosition(0);
                }
            }

            
            {
                a = BlogActivity.this;
                super();
            }
        });
        j = findViewById(0x7f100979);
        j.setOnClickListener(new android.view.View.OnClickListener() {

            private BlogActivity a;

            public final void onClick(View view)
            {
                BlogActivity.b(a);
            }

            
            {
                a = BlogActivity.this;
                super();
            }
        });
        if (f == null || f.isEmpty())
        {
            c();
        }
    }

    protected void onDestroy()
    {
        if (c != null)
        {
            c.setRequestCompleteListener(null);
        }
        if (f != null)
        {
            com.socialin.android.picsart.profile.activity.a a1 = f;
            com.socialin.android.util.c.b(b);
            a1.clear();
        }
        super.onDestroy();
    }

    public void onFailure(Exception exception, Request request)
    {
        com.socialin.android.d.c(new Object[] {
            a, (new StringBuilder("onFailure: ")).append(exception.getLocalizedMessage()).toString()
        });
        h.setVisibility(8);
        d();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return true;
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
        com.socialin.android.d.a(a, "setImage: onProgressUpdate:");
    }

    public void onSuccess(Object obj, Request request)
    {
        boolean flag = false;
        obj = ((BlogsResponse)obj).response;
        if (obj == null || g == null)
        {
            return;
        }
        if (f == null)
        {
            f = new com.socialin.android.picsart.profile.activity.a(this, this, ((List) (obj)));
        } else
        {
            f.addAll(((java.util.Collection) (obj)));
        }
        if (g.getAdapter() == null)
        {
            g.setAdapter(f);
        }
        h.setVisibility(8);
        d();
        if (f.getCount() > 0)
        {
            int l = getResources().getColor(0x7f0f008e);
            findViewById(0x7f100954).setBackgroundColor(l);
            g.setBackgroundColor(l);
            g.setVisibility(0);
        } else
        {
            g.setVisibility(8);
        }
        if (((List) (obj)).isEmpty() || ((List) (obj)).size() < 30)
        {
            flag = true;
        }
        k = flag;
    }

}
