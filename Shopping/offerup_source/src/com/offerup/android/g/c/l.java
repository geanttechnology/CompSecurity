// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.an;
import android.support.v4.app.t;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.b.a.a.g;
import com.offerup.android.activities.k;
import com.offerup.android.c.a;
import com.offerup.android.dto.ItemPost;
import com.offerup.android.dto.ItemPostPhoto;
import com.offerup.android.g.aa;
import com.offerup.android.g.ac;
import com.offerup.android.g.p;
import com.offerup.android.g.r;
import com.offerup.android.utils.al;
import com.offerup.android.utils.d;
import com.offerup.android.utils.n;
import com.offerup.android.views.PhotoStripView;
import com.offerup.android.views.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.offerup.android.g.c:
//            a, p, q, m, 
//            r, n, o, s

public final class l extends com.offerup.android.g.c.a
    implements ac, r, b
{

    private EditText b;
    private FrameLayout c;
    private RelativeLayout d;
    private RelativeLayout e;
    private ImageView f;
    private ArrayList g;
    private PhotoStripView h;
    private String i;
    private Long j;
    private com.b.a.a.a k;
    private d l;

    public l()
    {
    }

    public static l a(String s1, ArrayList arraylist, Long long1)
    {
        l l1 = new l();
        Bundle bundle = new Bundle();
        bundle.putString("title", s1);
        bundle.putParcelableArrayList("photos", arraylist);
        if (long1 != null)
        {
            bundle.putLong("itemId", long1.longValue());
        }
        l1.setArguments(bundle);
        return l1;
    }

    private void a(Uri uri)
    {
        ((k)getActivity()).a(0x7f0901b1);
        l.a(uri, g.size(), new com.offerup.android.g.c.p(this));
    }

    static void a(l l1)
    {
        l1.l();
    }

    static void a(l l1, Bitmap bitmap)
    {
        l1.f.setImageBitmap(bitmap);
        l1.c.setVisibility(0);
        if (com.offerup.android.c.a.a() > 1)
        {
            l1.d.setVisibility(0);
        }
        l1.e.setVisibility(4);
        ((k)l1.getActivity()).i();
    }

    static void a(l l1, Uri uri)
    {
        l1.g.add(new ItemPostPhoto(uri));
        if (l1.g.size() == 1)
        {
            l1.p();
            return;
        } else
        {
            l1.h.a(uri);
            return;
        }
    }

    static void b(l l1)
    {
        l1.m();
    }

    static void c(l l1)
    {
        l1.q();
    }

    static void d(l l1)
    {
        com.offerup.android.tracker.a.b("PostItem_DeleteCover-Button_click");
        l1.h(0);
        l1.o();
    }

    private void h(int i1)
    {
        g.remove(i1);
        l.a(i1);
    }

    private int k()
    {
        CameraManager cameramanager;
        cameramanager = (CameraManager)getActivity().getSystemService("camera");
        if (cameramanager == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        int i1 = cameramanager.getCameraIdList().length;
        return i1;
        CameraAccessException cameraaccessexception;
        cameraaccessexception;
        cameraaccessexception.printStackTrace();
        return 0;
    }

    private void l()
    {
        try
        {
            getActivity().getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", n());
            startActivityForResult(intent, 4083);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
        com.offerup.android.utils.n.a(getActivity(), 0x7f090109, 0x7f090119);
    }

    private void m()
    {
        startActivityForResult(new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 4381);
    }

    private Uri n()
    {
        return Uri.fromFile(new File(getActivity().getApplicationContext().getExternalFilesDir(null), "capture.jpg"));
    }

    private void o()
    {
        if (g != null && g.size() > 0)
        {
            p();
            ArrayList arraylist = new ArrayList(com.offerup.android.c.a.a());
            for (int i1 = 1; i1 < g.size(); i1++)
            {
                arraylist.add(((ItemPostPhoto)g.get(i1)).getImageUri());
            }

            h.setImages(arraylist);
            return;
        } else
        {
            r();
            return;
        }
    }

    private void p()
    {
        ItemPostPhoto itempostphoto;
        if (g.size() > 0)
        {
            itempostphoto = (ItemPostPhoto)g.get(0);
        } else
        {
            itempostphoto = null;
        }
        ((k)getActivity()).a(0x7f0901b1);
        if (itempostphoto != null && itempostphoto.getImageUri() != null)
        {
            int i1 = (int)Math.ceil(TypedValue.applyDimension(1, 120F, getResources().getDisplayMetrics()));
            l.a(itempostphoto.getImageUri(), getResources().getDisplayMetrics().widthPixels, i1, new q(this));
            return;
        } else
        {
            q();
            return;
        }
    }

    private void q()
    {
        r();
        ((k)getActivity()).i();
    }

    private void r()
    {
        if (g != null)
        {
            g.clear();
        }
        h.a();
        f.setImageBitmap(null);
        e.setVisibility(0);
        c.setVisibility(4);
        d.setVisibility(4);
    }

    final void a()
    {
        ((k)getActivity()).a(0x7f0901b1);
        b();
        Object obj = new ItemPost();
        ((ItemPost) (obj)).setId(j);
        ((ItemPost) (obj)).setTitle(i);
        ((ItemPost) (obj)).setItemPostPhotos(g);
        obj = new al(((ItemPost) (obj)));
        l.a(((al) (obj)), new m(this));
    }

    public final void a(int i1)
    {
        int j1 = i1 + 1;
        com.offerup.android.tracker.a.e(this, j1);
        h(j1);
        h.a(i1);
    }

    final void a(Bundle bundle)
    {
        if (i != null)
        {
            bundle.putString("title", i);
        } else
        {
            bundle.remove("title");
        }
        if (g != null)
        {
            bundle.putParcelableArrayList("photos", g);
        } else
        {
            bundle.remove("photos");
        }
        if (j != null)
        {
            bundle.putLong("itemId", j.longValue());
            return;
        } else
        {
            bundle.remove("itemId");
            return;
        }
    }

    final void a(View view)
    {
        d = (RelativeLayout)view.findViewById(0x7f10025b);
        h = (PhotoStripView)view.findViewById(0x7f10025d);
        h.setAddPhotoClickListener(this);
        b = (EditText)view.findViewById(0x7f1000b3);
        f = (ImageView)view.findViewById(0x7f100259);
        c = (FrameLayout)view.findViewById(0x7f100258);
        e = (RelativeLayout)view.findViewById(0x7f10025a);
        ((ImageButton)view.findViewById(0x7f100181)).setOnClickListener(new com.offerup.android.g.c.r(this));
        Button button = (Button)view.findViewById(0x7f100121);
        button.setOnClickListener(new com.offerup.android.g.c.n(this));
        int i1;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            i1 = k();
        } else
        {
            i1 = Camera.getNumberOfCameras();
        }
        if (i1 <= 0)
        {
            button.setVisibility(8);
        }
        ((Button)view.findViewById(0x7f100122)).setOnClickListener(new o(this));
    }

    final void a(List list)
    {
        int i1 = 0;
        while (i1 < list.size()) 
        {
            String s1 = (String)list.get(i1);
            if ("Please give your item a title.".equals(s1) || "Please limit the title to 150 letters.".equals(s1))
            {
                b.setError(s1);
            } else
            {
                "Please attach a picture of the item.".equals(s1);
                Toast.makeText(getActivity(), s1, 0).show();
            }
            i1++;
        }
    }

    final void b()
    {
        String s1;
        if (b.getText() == null)
        {
            s1 = i;
        } else
        {
            s1 = b.getText().toString();
        }
        i = s1;
        k.a(l);
    }

    public final void b(int i1)
    {
        com.offerup.android.tracker.a.d(this, i1 + 1);
        int j1 = i1 + 1;
        if (g != null && g.size() > j1)
        {
            l.a(0, j1);
            Collections.swap(g, 0, j1);
            Object obj = (ItemPostPhoto)g.get(j1);
            PhotoStripView photostripview = h;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((ItemPostPhoto) (obj)).getImageUri();
            }
            photostripview.a(i1, ((Uri) (obj)));
            p();
        }
    }

    final void b(Bundle bundle)
    {
        if (bundle.containsKey("title"))
        {
            i = bundle.getString("title");
        } else
        {
            i = null;
        }
        g = new ArrayList(com.offerup.android.c.a.a());
        if (bundle.containsKey("photos"))
        {
            ArrayList arraylist = bundle.getParcelableArrayList("photos");
            if (arraylist != null)
            {
                for (int i1 = 0; i1 < arraylist.size(); i1++)
                {
                    ItemPostPhoto itempostphoto = (ItemPostPhoto)arraylist.get(i1);
                    if (itempostphoto != null && itempostphoto.getImageUri() != null)
                    {
                        g.add(arraylist.get(i1));
                    }
                }

            }
        }
        if (bundle.containsKey("itemId"))
        {
            j = Long.valueOf(bundle.getLong("itemId"));
        } else
        {
            j = null;
        }
        l = k.a(j);
    }

    final void c()
    {
        o();
        if (i != null)
        {
            b.setText(i);
            return;
        } else
        {
            b.setText("");
            return;
        }
    }

    public final void c(int i1)
    {
        com.offerup.android.tracker.a.a(this, i1 + 1);
        l();
    }

    final String d()
    {
        return "item_post_1";
    }

    public final void d(int i1)
    {
        com.offerup.android.tracker.a.b(this, i1 + 1);
        m();
    }

    final int e()
    {
        return j == null ? 0x7f0901af : 0x7f0901b0;
    }

    public final void e(int i1)
    {
        com.offerup.android.tracker.a.c(this, i1 + 1);
    }

    final int f()
    {
        return 0x7f09017e;
    }

    public final void f(int i1)
    {
        com.offerup.android.tracker.a.b("PostItem_ImageThumbnail-Button_click");
        aa aa1 = aa.a(i1, this);
        getChildFragmentManager().a().a(null).a(aa1, null).b();
    }

    final int g()
    {
        return 0x7f040097;
    }

    public final void g(int i1)
    {
        com.offerup.android.tracker.a.b("PostItem_CameraPlus-Button_click");
        p p1 = com.offerup.android.g.p.a(i1, this);
        getChildFragmentManager().a().a(null).a(p1, null).b();
    }

    final int h()
    {
        return 0x7f0201b2;
    }

    final List i()
    {
        return new ArrayList(0);
    }

    final Object j()
    {
        return new s(i, g);
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 == -1)
        {
            if (i1 == 4083)
            {
                a(n());
            } else
            if (i1 == 4381)
            {
                intent = intent.getData();
                if (intent.toString().contains("picasa/item"))
                {
                    com.offerup.android.utils.n.a(getActivity(), 0x7f090136, 0x7f090135);
                    return;
                } else
                {
                    a(intent);
                    return;
                }
            }
        }
    }

    public final void onAttach(Context context)
    {
        super.onAttach(context);
        k = com.b.a.a.a.a(context.getApplicationContext());
    }

    public final void onDetach()
    {
        d d1 = l;
        d1.e();
        d1.c();
        d1.d();
        super.onDetach();
    }
}
