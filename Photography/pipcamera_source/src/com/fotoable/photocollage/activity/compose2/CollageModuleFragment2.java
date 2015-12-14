// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.compose2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import com.fotoable.photocollage.view.ImageCollageView;
import com.wantu.model.res.TFrameItemInfo;
import ew;
import java.util.List;
import lh;
import lz;
import mh;

// Referenced classes of package com.fotoable.photocollage.activity.compose2:
//            ComposePhotoesActivity2

public class CollageModuleFragment2 extends Fragment
    implements lz
{

    ImageCollageView a;
    int b;
    int c;
    int d;
    int e;
    TPhotoCollageComposeInfo f;
    TFrameItemInfo g;
    boolean h;
    lh i;
    private boolean j;
    private List k;

    public CollageModuleFragment2()
    {
        j = false;
    }

    private void a(float f1, boolean flag)
    {
        int l = ew.d(getActivity());
        float f3 = (float)b / (float)l;
        float f2 = f1;
        if (f1 > 1.0F)
        {
            f2 = 1.333333F;
        }
        int i1;
        if (f2 > f3)
        {
            i1 = b;
            l = (int)((float)b / f2);
        } else
        {
            i1 = (int)((float)l * f2);
        }
        if (flag && a != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
            layoutparams.height = i1;
            layoutparams.width = l;
            a.requestLayout();
        }
        d = l;
        e = i1;
    }

    public Bitmap a()
    {
        return a.getOutputImage();
    }

    public void a(int l)
    {
        if (a != null)
        {
            a.changeCornerRadius(l);
        }
    }

    public void a(int l, int i1)
    {
        b = i1;
        c = l;
    }

    public void a(Bitmap bitmap)
    {
        if (a != null)
        {
            a.setSelectBitmap(bitmap, true);
        }
    }

    public void a(Bitmap bitmap, int l)
    {
        if (l < k.size())
        {
            k.set(l, bitmap);
        }
        if (a != null)
        {
            a.setSelectBitmap(bitmap, false);
        }
    }

    public void a(View view, View view1)
    {
        int l = ((Integer)view.getTag()).intValue();
        int i1 = ((Integer)view1.getTag()).intValue();
        Log.e("********", (new StringBuilder()).append("start ").append(l).append(", target ").append(i1).toString());
        if (k != null)
        {
            view = (Bitmap)k.get(l);
            view1 = (Bitmap)k.get(i1);
            if (i1 < l)
            {
                k.remove(l);
                k.remove(i1);
                k.add(i1, view);
                k.add(l, view1);
            } else
            {
                k.remove(i1);
                k.remove(l);
                k.add(l, view1);
                k.add(i1, view);
            }
            if (a != null)
            {
                a.setCollageWithRepleacedImages(k);
            }
        }
    }

    public void a(TPhotoCollageComposeInfo tphotocollagecomposeinfo)
    {
        if (tphotocollagecomposeinfo == null)
        {
            return;
        }
        if (a != null)
        {
            if (f == null || (double)Math.abs(tphotocollagecomposeinfo.getAspectRatio() - f.getAspectRatio()) > 0.10000000000000001D)
            {
                a(tphotocollagecomposeinfo.getAspectRatio(), true);
            }
            a.setCollageStyle(tphotocollagecomposeinfo, e, d);
        }
        f = tphotocollagecomposeinfo;
    }

    public void a(TFrameItemInfo tframeiteminfo)
    {
        if (a != null)
        {
            a.setCollageBackGroup(tframeiteminfo, getActivity());
        }
        g = tframeiteminfo;
    }

    public void a(List list)
    {
        k = list;
        if (a != null)
        {
            a.setIsUseShade(false);
            a.setCollageImages(list, false);
        }
    }

    public void a(lh lh1)
    {
        i = lh1;
    }

    public void a(boolean flag)
    {
        if (a != null)
        {
            a.setIsUseShade(flag);
        }
    }

    public void a(boolean flag, boolean flag1)
    {
        if (i != null)
        {
            i.a(flag, flag1);
        }
    }

    public int b()
    {
        return a.getSelectIndex();
    }

    public void b(int l)
    {
        if (a != null)
        {
            a.changeEdge(l);
        }
    }

    public void b(boolean flag)
    {
        if (a != null)
        {
            a.setIsUseBK(flag);
        }
    }

    public void c()
    {
        if (a != null)
        {
            a.cancelSelected();
        }
    }

    public void c(boolean flag)
    {
        h = flag;
        if (a != null)
        {
            a.setIsTransForm(flag);
        }
    }

    public float d()
    {
        return a.getRadius();
    }

    public boolean e()
    {
        return a.isUseShadow();
    }

    public float f()
    {
        return a.getEdge();
    }

    public boolean g()
    {
        return a.isUseBK();
    }

    protected ComposePhotoesActivity2 h()
    {
        return (ComposePhotoesActivity2)getActivity();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03003f, viewgroup, false);
        layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

            final CollageModuleFragment2 a;

            public void onClick(View view)
            {
            }

            
            {
                a = CollageModuleFragment2.this;
                super();
            }
        });
        a = (ImageCollageView)layoutinflater.findViewById(0x7f0c012a);
        a.setItemOnClickListener(this);
        if (k == null || k.size() == 0)
        {
            k = h().q;
            a(k);
        } else
        {
            a(k);
        }
        if (f != null)
        {
            a(f.getAspectRatio(), true);
            a(f);
        } else
        {
            f = mh.a(h().I, k.size());
            c = h().r;
            b = h().s;
            a(f.getAspectRatio(), true);
            a(f);
        }
        if (g != null)
        {
            a(g);
            return layoutinflater;
        } else
        {
            g = mh.b();
            a(g);
            return layoutinflater;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        k = null;
        a.clearResource(true);
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null && (fragmentactivity instanceof ComposePhotoesActivity2))
        {
            ((ComposePhotoesActivity2)fragmentactivity).b(true);
        }
    }
}
