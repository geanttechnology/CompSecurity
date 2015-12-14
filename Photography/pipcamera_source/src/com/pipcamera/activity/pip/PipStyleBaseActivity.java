// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.activity.FullscreenActivity;
import com.wantu.model.res.pip.TDFSceneInfo;
import jw;
import yf;

public abstract class PipStyleBaseActivity extends FullscreenActivity
{

    public static PipStyleBaseActivity i = null;
    protected int a;
    protected ProgressDialog b;
    protected yf c;
    protected Matrix d;
    protected Bitmap e;
    protected Bitmap f;
    protected Bitmap g;
    protected String h;
    protected jw j;
    protected ProgressDialog k;
    protected TDFSceneInfo l;

    public PipStyleBaseActivity()
    {
        a = 0;
        h = "";
    }

    public Bitmap a(TDFSceneInfo tdfsceneinfo)
    {
        return null;
    }

    public void a()
    {
    }

    public void a(int i1)
    {
        a = i1;
    }

    public void a(Bitmap bitmap)
    {
    }

    public void a(Matrix matrix)
    {
    }

    public void a(yf yf)
    {
    }

    public Bitmap b(TDFSceneInfo tdfsceneinfo)
    {
        return null;
    }

    public void b()
    {
    }

    public void b(Bitmap bitmap)
    {
    }

    public void c()
    {
    }

    public void c(Bitmap bitmap)
    {
    }

    public void c(TDFSceneInfo tdfsceneinfo)
    {
    }

    public void d()
    {
    }

    public Bitmap e()
    {
        return null;
    }

    public Bitmap f()
    {
        return null;
    }

    public void finalize()
    {
        Log.v("PIPStyleAcitivity finalize", "PIPStyleAcitivity finalize");
        try
        {
            super.finalize();
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            Crashlytics.logException(throwable);
            return;
        }
    }

    public Matrix g()
    {
        return null;
    }

    public yf h()
    {
        return null;
    }

    public TDFSceneInfo i()
    {
        return null;
    }

    public jw j()
    {
        return null;
    }

    public Bitmap l()
    {
        return g;
    }

    public void m()
    {
    }

    public void n()
    {
    }

    public void o()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected Dialog onCreateDialog(int i1)
    {
        return null;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        return super.onKeyDown(i1, keyevent);
    }

    public void onOptionsBtnClicked(View view)
    {
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

    public void p()
    {
    }

    public void q()
    {
        f = null;
    }

    public void r()
    {
        e = null;
    }

}
