// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.renderscript.RenderScript;
import android.util.Log;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.EffectsDrawHistoryController;
import java.nio.ByteBuffer;
import myobfuscated.ay.e;
import myobfuscated.ck.a;
import myobfuscated.ck.c;
import myobfuscated.cl.d;

public class b
{

    public Activity a;
    public a b;

    public b(a a1, Activity activity)
    {
        b = a1;
        a = activity;
        super();
    }

    public void a(Bitmap bitmap, Bitmap bitmap1, ByteBuffer bytebuffer, boolean flag)
    {
        b.j();
        if (flag && bitmap != null && bitmap1 != null)
        {
            myobfuscated.ck.a.a(b).d = true;
            myobfuscated.ck.a.a(b, bitmap);
            myobfuscated.ck.a.a(bitmap1);
            myobfuscated.ck.a.a(b, new Point(myobfuscated.ck.a.b(b).getWidth(), myobfuscated.ck.a.b(b).getHeight()));
            myobfuscated.ck.a.a(b).a = myobfuscated.ck.a.c(b);
            myobfuscated.ck.a.a(b, bytebuffer);
            Log.e("ex1", (new StringBuilder("origSize = ")).append(myobfuscated.ck.a.c(b).x).append(" : ").append(myobfuscated.ck.a.c(b).y).toString());
            Log.e("ex1", (new StringBuilder("thumbSize = ")).append(bitmap1.getWidth()).append(" : ").append(bitmap1.getHeight()).toString());
            if (bitmap1 != null)
            {
                myobfuscated.ck.a.b(b, e.a(bitmap, myobfuscated.ck.a.d(b)));
                Log.e("ex1", (new StringBuilder("previewSize = ")).append(myobfuscated.ck.a.e(b).x).append(" : ").append(myobfuscated.ck.a.e(b).y).toString());
                myobfuscated.ck.a.b(b, com.socialin.android.util.c.a(myobfuscated.ck.a.b(b), myobfuscated.ck.a.e(b).x, myobfuscated.ck.a.e(b).y, false));
                if (myobfuscated.ck.a.f(b) != null)
                {
                    myobfuscated.ck.a.c(b, com.socialin.android.util.c.a(myobfuscated.ck.a.f(b), android.graphics.Bitmap.Config.ARGB_8888));
                }
                bitmap = myobfuscated.ck.a.a(b).o;
                if (bitmap != null && myobfuscated.ck.a.f(b) != null && myobfuscated.ck.a.g(b) != null)
                {
                    myobfuscated.ck.a.d(b, e.a(bitmap, myobfuscated.ck.a.e(b).x, myobfuscated.ck.a.e(b).y));
                    if (myobfuscated.ck.a.h(b) != null)
                    {
                        e.a(myobfuscated.ck.a.b(b), myobfuscated.ck.a.h(b), myobfuscated.ck.a.f(b));
                        e.a(myobfuscated.ck.a.b(b), myobfuscated.ck.a.h(b), myobfuscated.ck.a.g(b));
                    }
                }
                if (myobfuscated.ck.a.f(b) != null && myobfuscated.ck.a.g(b) != null && (bitmap == null || bitmap != null && myobfuscated.ck.a.h(b) != null))
                {
                    myobfuscated.ck.a.a(b).j = new com.socialin.android.photo.effects.draw.a(a.getApplicationContext(), myobfuscated.ck.a.f(b), myobfuscated.ck.a.g(b));
                    bitmap = myobfuscated.ck.a.a(b).j;
                    boolean flag1;
                    if (((com.socialin.android.photo.effects.draw.a) (bitmap)).c != null && ((com.socialin.android.photo.effects.draw.a) (bitmap)).c.j())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1)
                    {
                        myobfuscated.ck.a.i(b);
                        myobfuscated.ck.a.a(b).j.n = b;
                        myobfuscated.ck.a.a(b).j.r = null;
                        myobfuscated.ck.a.a(b).j.c.n.b = b;
                        myobfuscated.ck.a.a(b).j.c.q = b;
                        myobfuscated.ck.a.j(b).b = bitmap1;
                        myobfuscated.ck.a.j(b).notifyDataSetChanged();
                        bitmap = myobfuscated.cj.a.a();
                        myobfuscated.ck.a.b(b, bitmap.a(myobfuscated.ck.a.c(b).x * myobfuscated.ck.a.c(b).y * 4));
                        myobfuscated.ck.a.c(b, bitmap.a(myobfuscated.ck.a.c(b).x * myobfuscated.ck.a.c(b).y * 4));
                        myobfuscated.ck.a.k(b).position(0);
                        myobfuscated.ck.a.b(b).copyPixelsToBuffer(myobfuscated.ck.a.k(b));
                        myobfuscated.ck.a.l(b).position(0);
                        myobfuscated.ck.a.b(b).copyPixelsToBuffer(myobfuscated.ck.a.l(b));
                        myobfuscated.ck.a.d(b, bitmap.a(myobfuscated.ck.a.e(b).x * myobfuscated.ck.a.e(b).y * 4));
                        if (myobfuscated.ck.a.m(b))
                        {
                            myobfuscated.ck.a.a(b, RenderScript.create(a));
                            Log.e("ex1", " rs = RenderScript.create(activity);");
                        }
                        myobfuscated.ck.a.a(b).d = true;
                        bitmap = b.getActivity();
                        if (bitmap != null && !bitmap.isFinishing())
                        {
                            bitmap = myobfuscated.ck.a.n(b);
                            myobfuscated.ck.a.a(b, bitmap);
                            myobfuscated.ck.a.o(b);
                            myobfuscated.ck.a.i(b);
                            if (myobfuscated.ck.a.p(b) != null)
                            {
                                myobfuscated.ck.a.a(b, myobfuscated.ck.a.q(b), myobfuscated.ck.a.r(b), myobfuscated.ck.a.p(b));
                                myobfuscated.ck.a.s(b);
                            }
                            if (myobfuscated.ck.a.t(b) != null)
                            {
                                myobfuscated.ck.a.u(b);
                            }
                        }
                        return;
                    } else
                    {
                        myobfuscated.ck.a.v(b);
                        return;
                    }
                } else
                {
                    myobfuscated.ck.a.v(b);
                    return;
                }
            } else
            {
                myobfuscated.ck.a.v(b);
                return;
            }
        } else
        {
            myobfuscated.ck.a.v(b);
            return;
        }
    }
}
