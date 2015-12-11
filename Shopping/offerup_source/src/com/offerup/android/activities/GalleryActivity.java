// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.dto.Photo;
import com.offerup.android.g.a.o;
import com.offerup.android.tracker.PhotoGalleryUserInteractionRecord;
import com.offerup.android.tracker.a;
import com.offerup.android.views.GalleryViewPager;

// Referenced classes of package com.offerup.android.activities:
//            k, ck, cl, cm, 
//            cj

public class GalleryActivity extends k
    implements o, uk.co.senab.photoview.PhotoViewAttacher.OnFlingListener, uk.co.senab.photoview.PhotoViewAttacher.OnPhotoTapListener
{

    private GalleryViewPager a;
    private Toolbar b;
    private View c;
    private TextView d;
    private boolean j;
    private boolean k;
    private int l;
    private Photo m[];
    private PhotoGalleryUserInteractionRecord n;

    public GalleryActivity()
    {
    }

    static int a(GalleryActivity galleryactivity, int i)
    {
        galleryactivity.l = i;
        return i;
    }

    private void a(Bundle bundle)
    {
        l = bundle.getInt("photo_index", 0);
        android.os.Parcelable aparcelable[] = bundle.getParcelableArray("photos");
        if (aparcelable != null)
        {
            m = new Photo[aparcelable.length];
            for (int i = 0; i < aparcelable.length; i++)
            {
                m[i] = (Photo)aparcelable[i];
            }

        }
        n = PhotoGalleryUserInteractionRecord.a(bundle);
        n.b(m.length);
        bundle = a;
        bundle.setAdapter(new ck(this, getSupportFragmentManager()));
        bundle.a(new cl(this));
        bundle.setCurrentItem(l);
        n.a(l);
        g();
    }

    static Photo[] a(GalleryActivity galleryactivity)
    {
        return galleryactivity.m;
    }

    static PhotoGalleryUserInteractionRecord b(GalleryActivity galleryactivity)
    {
        return galleryactivity.n;
    }

    static void c(GalleryActivity galleryactivity)
    {
        galleryactivity.g();
    }

    static GalleryViewPager d(GalleryActivity galleryactivity)
    {
        return galleryactivity.a;
    }

    private void g()
    {
label0:
        {
            if (m != null)
            {
                if (m.length >= 2)
                {
                    break label0;
                }
                c.setVisibility(8);
            }
            return;
        }
        c.setVisibility(0);
        d.setText(String.format("%d of %d", new Object[] {
            Integer.valueOf(l + 1), Integer.valueOf(m.length)
        }));
    }

    public final void a()
    {
        k = true;
        a.setSwipeble(k);
        b.setVisibility(0);
    }

    final String b()
    {
        return "item_details_image_viewer";
    }

    public final void f()
    {
        k = false;
        a.setSwipeble(k);
        b.setVisibility(4);
    }

    public void onBackPressed()
    {
        if (j)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        j = true;
        b.setVisibility(8);
        com.offerup.android.tracker.a.a(n);
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f05000f);
        animation.setAnimationListener(new cm(this));
        a.startAnimation(animation);
        return;
        Exception exception;
        exception;
        com.b.a.a.g.a(this, exception);
        finish();
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040023);
        c = findViewById(0x7f1000d7);
        d = (TextView)findViewById(0x7f1000d8);
        b = (Toolbar)findViewById(0x7f1000d6);
        b.setNavigationOnClickListener(new cj(this));
        a = (GalleryViewPager)findViewById(0x7f1000d5);
        if (bundle != null)
        {
            a(bundle);
            return;
        } else
        {
            a(getIntent().getExtras());
            return;
        }
    }

    protected void onDestroy()
    {
        a.setAdapter(null);
        super.onDestroy();
    }

    public void onFling(float f1, float f2)
    {
        if (f2 < -5000F && Math.abs(f1 / f2) < 1.0F && k)
        {
            onBackPressed();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPause()
    {
        n.a();
        super.onPause();
        com.offerup.android.tracker.a.a(n);
        finish();
    }

    public void onPhotoTap(View view, float f1, float f2)
    {
label0:
        {
            if (k)
            {
                if (b.getVisibility() != 0)
                {
                    break label0;
                }
                b.setVisibility(4);
            }
            return;
        }
        b.setVisibility(0);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        a(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        n.b();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("photo_index", l);
        bundle.putParcelableArray("photos", m);
        bundle.putParcelable("PhotoGalleryUserInteractionRecord", n);
        super.onSaveInstanceState(bundle);
    }
}
