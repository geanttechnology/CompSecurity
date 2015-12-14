// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.hardware.Camera;
import android.view.ScaleGestureDetector;
import com.socialin.camera.opengl.a;
import com.socialin.picsin.camera.b;
import java.util.List;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraFocusRectView

public interface c
{

    public abstract void A();

    public abstract boolean B();

    public abstract boolean C();

    public abstract boolean D();

    public abstract int E();

    public abstract int F();

    public abstract String[] G();

    public abstract String H();

    public abstract String[] I();

    public abstract String J();

    public abstract String[] K();

    public abstract String L();

    public abstract boolean N();

    public abstract int O();

    public abstract int P();

    public abstract int Q();

    public abstract boolean R();

    public abstract boolean S();

    public abstract int T();

    public abstract int U();

    public abstract List V();

    public abstract boolean W();

    public abstract ScaleGestureDetector X();

    public abstract void a(android.hardware.Camera.PictureCallback picturecallback, android.hardware.Camera.PictureCallback picturecallback1);

    public abstract void a(android.hardware.Camera.ShutterCallback shuttercallback, android.hardware.Camera.PictureCallback picturecallback);

    public abstract void a(CameraFocusRectView camerafocusrectview, b b1);

    public abstract void a(boolean flag);

    public abstract String b();

    public abstract Camera c();

    public abstract boolean d();

    public abstract int e();

    public abstract int f();

    public abstract boolean g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract boolean k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract boolean o();

    public abstract int p();

    public abstract String[] q();

    public abstract String r();

    public abstract boolean s();

    public abstract void setBrightness(int i1);

    public abstract void setCameraIndex(int i1);

    public abstract void setContrast(int i1);

    public abstract void setDefaultProperties();

    public abstract void setEffect(String s1);

    public abstract void setEffectOnSurfaceChanged(boolean flag, int i1, int j1, int k1);

    public abstract void setEffectsController(a a1);

    public abstract void setFlashMode(int i1);

    public abstract void setIso(String s1);

    public abstract void setPictureSize(int i1, int j1);

    public abstract void setPictureTaking(boolean flag);

    public abstract void setPlayShutter(boolean flag);

    public abstract void setSaturation(int i1);

    public abstract void setSceneMode(String s1);

    public abstract void setSharpness(int i1);

    public abstract void setSurfaceChangeCallback(android.view.SurfaceHolder.Callback callback);

    public abstract void setWhiteBalance(String s1);

    public abstract void setZoom(int i1);

    public abstract boolean t();

    public abstract int u();

    public abstract int v();

    public abstract boolean w();

    public abstract int x();

    public abstract void y();

    public abstract boolean z();
}
