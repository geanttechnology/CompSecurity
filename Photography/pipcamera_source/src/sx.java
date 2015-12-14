// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.comlib.util.AsyncTask;
import com.pipcamera.activity.pip.PipStyleBaseActivity;
import com.pipcamera.activity.pip.fragment.PipProcessFragment;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.model.res.pip.TDFSceneInfo;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;

public class sx extends AsyncTask
{

    Bitmap a;
    Bitmap b;
    Bitmap c;
    Bitmap d;
    final PipProcessFragment e;

    private sx(PipProcessFragment pipprocessfragment)
    {
        e = pipprocessfragment;
        super();
    }

    public sx(PipProcessFragment pipprocessfragment, com.pipcamera.activity.pip.fragment.PipProcessFragment._cls1 _pcls1)
    {
        this(pipprocessfragment);
    }

    protected transient Void a(TDFSceneInfo atdfsceneinfo[])
    {
        atdfsceneinfo = atdfsceneinfo[0];
        a = PipProcessFragment.a(e).e();
        b = PipProcessFragment.a(e).f();
        c = PipProcessFragment.a(e).a(atdfsceneinfo);
        d = PipProcessFragment.a(e).l();
        return null;
    }

    protected void a(Void void1)
    {
        if (PipProcessFragment.c(e) == PipProcessFragment.d(e))
        {
            PipProcessFragment.b(e).setImageBitmap(a, true, PipProcessFragment.a(e).g());
        }
        PipProcessFragment.b(e).setMask(c);
        PipProcessFragment.e(e).setSourceBitmap(b);
        PipProcessFragment.f(e).setImageBitmap(d);
        c = null;
        b = null;
        d = null;
        PipProcessFragment.g(e);
        PipProcessFragment.a(e).b();
        super.onPostExecute(void1);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((TDFSceneInfo[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        PipProcessFragment.a(e).a();
        super.onPreExecute();
    }
}
