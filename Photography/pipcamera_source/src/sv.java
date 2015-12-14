// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import com.fotoable.comlib.util.AsyncTask;
import com.pipcamera.activity.pip.Pip2FragmentActivity;
import com.pipcamera.activity.pip.fragment.Pip2ProcessFragment;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.model.res.pip.TDFSceneInfo;
import wantu.sephiroth.android.library.imagezoom.MaskScrollImageViewTouch;

public class sv extends AsyncTask
{

    Bitmap a;
    Bitmap b;
    Bitmap c;
    final Pip2ProcessFragment d;

    private sv(Pip2ProcessFragment pip2processfragment)
    {
        d = pip2processfragment;
        super();
    }

    public sv(Pip2ProcessFragment pip2processfragment, com.pipcamera.activity.pip.fragment.Pip2ProcessFragment._cls1 _pcls1)
    {
        this(pip2processfragment);
    }

    protected transient Void a(TDFSceneInfo atdfsceneinfo[])
    {
        atdfsceneinfo = atdfsceneinfo[0];
        b = Pip2ProcessFragment.a(d).b(atdfsceneinfo);
        c = Pip2ProcessFragment.a(d).i();
        a = Pip2ProcessFragment.a(d).g();
        return null;
    }

    protected void a(Void void1)
    {
        if (b != null)
        {
            Pip2ProcessFragment.b(d).setMask(b);
        }
        if (a == null)
        {
            Pip2ProcessFragment.a(d).b();
            Log.e("pip2processFragment bgsrcBmp is null", "pip2processFragment bgsrcBmp is null");
        }
        Pip2ProcessFragment.c(d).setSourceBitmap(a);
        Pip2ProcessFragment.d(d).setImageBitmap(c);
        Pip2ProcessFragment.e(d);
        if (!Pip2ProcessFragment.f(d).booleanValue())
        {
            Pip2ProcessFragment.b(d, a);
        } else
        {
            Pip2ProcessFragment.a(d).b();
        }
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
        Pip2ProcessFragment.a(d).a();
        super.onPreExecute();
    }
}
