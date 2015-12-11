// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJOffersListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TJViewListener;
import java.util.Hashtable;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            eh

public abstract class ef
{

    private static final ef b;
    private static ef c;
    protected volatile boolean a;

    ef()
    {
        a = false;
    }

    public static ef a()
    {
        return c;
    }

    public abstract void a(float f1);

    public abstract void a(int i);

    public abstract void a(int i, TJAwardCurrencyListener tjawardcurrencylistener);

    public abstract void a(int i, TJSpendCurrencyListener tjspendcurrencylistener);

    public abstract void a(int i, String s);

    public abstract void a(Activity activity);

    public abstract void a(GLSurfaceView glsurfaceview);

    public abstract void a(TJEarnedCurrencyListener tjearnedcurrencylistener);

    public abstract void a(TJGetCurrencyBalanceListener tjgetcurrencybalancelistener);

    public abstract void a(TJOffersListener tjofferslistener);

    public abstract void a(TJVideoListener tjvideolistener);

    public abstract void a(TJViewListener tjviewlistener);

    public abstract void a(String s);

    public abstract void a(String s, long l);

    public abstract void a(String s, String s1);

    public abstract void a(String s, String s1, double d1, String s2);

    public abstract void a(String s, String s1, long l);

    public abstract void a(String s, String s1, String s2, String s3);

    public abstract void a(String s, String s1, String s2, String s3, long l);

    public abstract void a(String s, String s1, String s2, String s3, String s4, long l);

    public abstract void a(String s, String s1, String s2, String s3, String s4, long l, 
            String s5, long l1);

    public abstract void a(String s, String s1, String s2, String s3, String s4, long l, 
            String s5, long l1, String s6, long l2);

    public abstract void a(String s, String s1, String s2, String s3, Map map);

    public abstract void a(String s, boolean flag);

    public abstract void a(String s, boolean flag, TJOffersListener tjofferslistener);

    public abstract void a(boolean flag);

    public abstract boolean a(Context context, String s);

    public abstract boolean a(Context context, String s, Hashtable hashtable, TJConnectListener tjconnectlistener);

    public abstract String b();

    public abstract void b(int i);

    public abstract void b(Activity activity);

    public abstract void b(String s);

    public abstract void b(String s, String s1, String s2, String s3);

    public abstract void b(boolean flag);

    public abstract void c();

    public abstract void c(String s);

    public abstract float d();

    public abstract void d(String s);

    public abstract void e();

    public abstract void e(String s);

    public abstract void f();

    public abstract void f(String s);

    public abstract boolean g();

    public abstract boolean h();

    static 
    {
        eh eh1 = new eh();
        b = eh1;
        c = eh1;
    }
}
