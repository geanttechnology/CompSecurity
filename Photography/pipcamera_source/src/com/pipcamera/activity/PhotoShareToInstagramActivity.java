// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;
import java.util.ArrayList;
import oc;
import od;
import rd;
import so;
import sp;

// Referenced classes of package com.pipcamera.activity:
//            NewPhotoShareActivity

public class PhotoShareToInstagramActivity extends InstagramPhotoShareActivity
{

    so u;
    sp v;

    public PhotoShareToInstagramActivity()
    {
        v = new sp() {

            final PhotoShareToInstagramActivity a;

            public void a(int i)
            {
            }

            public void a(ArrayList arraylist, int i)
            {
                arraylist = (Bitmap)arraylist.get(0);
                if (arraylist == null)
                {
                    a.a();
                    return;
                } else
                {
                    a.a(arraylist);
                    return;
                }
            }

            
            {
                a = PhotoShareToInstagramActivity.this;
                super();
            }
        };
    }

    private void a(ArrayList arraylist)
    {
        int i;
        u = new so();
        u.a(v);
        u.a(arraylist);
        i = d();
        int j;
        if (PIPCameraApplication.b && arraylist.size() > 3 || arraylist.size() >= 5)
        {
            i = 410;
        }
        if ((float)getResources().getDisplayMetrics().widthPixels > 960F || PIPCameraApplication.c >= 64)
        {
            if (arraylist.size() < 5)
            {
                i = 960;
            } else
            {
                i = 612;
            }
        }
        j = i;
        if (PIPCameraApplication.b)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        j = i;
        if (arraylist.size() == 1)
        {
            j = 980;
        }
        try
        {
            u.b(j);
            u.c(new ArrayList[] {
                arraylist
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
        }
        return;
    }

    private int d()
    {
        char c = '\u0264';
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f = displaymetrics.density;
        int i = displaymetrics.densityDpi;
        f = displaymetrics.xdpi;
        float f1 = displaymetrics.ydpi;
        f1 = displaymetrics.widthPixels;
        float f2 = displaymetrics.heightPixels;
        if (f < 160F || f1 < 400F)
        {
            c = '\u019A';
        }
        return c;
    }

    public void a()
    {
        finish();
    }

    public void b()
    {
        Bitmap bitmap;
        bitmap = c();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (a)
        {
            oc.c(this, bitmap, "sync_instagram", null, "", new od() {

                final PhotoShareToInstagramActivity a;

                public void a(boolean flag, boolean flag1)
                {
                }

            
            {
                a = PhotoShareToInstagramActivity.this;
                super();
            }
            });
            return;
        }
        try
        {
            (new Thread(new Runnable(bitmap) {

                final Bitmap a;
                final PhotoShareToInstagramActivity b;

                public void run()
                {
                    File file = rd.a(a);
                    b.runOnUiThread(new Runnable(this, file) {

                        final File a;
                        final _cls2 b;

                        public void run()
                        {
                            if (a == null)
                            {
                                Toast.makeText(b.b, b.b.getResources().getString(0x7f060196), 0).show();
                            } else
                            {
                                rd.a(a.getAbsolutePath(), b.b);
                                Uri uri = Uri.fromFile(a);
                                if (uri != null)
                                {
                                    Intent intent = new Intent(b.b, com/pipcamera/activity/NewPhotoShareActivity);
                                    intent.putExtra("PhotoShareActivity_ToShareImageUri", uri.toString());
                                    b.b.startActivity(intent);
                                    b.b.overridePendingTransition(0x7f040007, 0);
                                    return;
                                }
                            }
                        }

            
            {
                b = _pcls2;
                a = file;
                super();
            }
                    });
                }

            
            {
                b = PhotoShareToInstagramActivity.this;
                a = bitmap;
                super();
            }
            })).start();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getIntent() != null)
        {
            Intent intent = getIntent();
            bundle = intent.getStringExtra("kimageuri");
            a = intent.getBooleanExtra("KSHARETOINSTAGRAM", false);
            if (bundle != null)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(Uri.parse(bundle));
                a(arraylist);
            }
        }
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, PIPCameraApplication.h);
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
    }
}
