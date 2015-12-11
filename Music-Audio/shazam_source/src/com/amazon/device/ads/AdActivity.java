// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.amazon.device.ads:
//            co, w, x, cn

public class AdActivity extends Activity
{
    static final class a
    {

        private final cn a = co.a(AdActivity.a());

        final b a(Intent intent)
        {
            intent = intent.getStringExtra("adapter");
            if (intent == null)
            {
                a.d("Unable to launch the AdActivity due to an internal error.", null);
                return null;
            }
            try
            {
                intent = Class.forName(intent);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                a.d("Unable to get the adapter class.", null);
                return null;
            }
            try
            {
                intent = intent.getDeclaredConstructor(new Class[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                a.d("Security exception when trying to get the default constructor.", null);
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                a.d("No default constructor exists for the adapter.", null);
                return null;
            }
            try
            {
                intent = (b)intent.newInstance(new Object[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                a.d("Illegal arguments given to the default constructor.", null);
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                a.d("Instantiation exception when instantiating the adapter.", null);
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                a.d("Illegal access exception when instantiating the adapter.", null);
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                a.d("Invocation target exception when instantiating the adapter.", null);
                return null;
            }
            return intent;
        }

        public a()
        {
        }
    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(Activity activity);

        public abstract void b();

        public abstract void c();

        public abstract void d();

        public abstract void e();

        public abstract void f();

        public abstract boolean g();
    }


    private static final String a = com/amazon/device/ads/AdActivity.getSimpleName();
    private b b;
    private cn c;
    private x d;
    private a e;

    public AdActivity()
    {
        co co1 = new co();
        x x1 = w.a();
        new co();
        this(co1, x1, new a());
    }

    AdActivity(co co1, x x1, a a1)
    {
        c = co.a(a);
        d = x1;
        e = a1;
    }

    static String a()
    {
        return a;
    }

    public void onBackPressed()
    {
        if (!b.g())
        {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        b.f();
    }

    public void onCreate(Bundle bundle)
    {
        if (c == null)
        {
            new co();
            c = co.a(a);
        }
        if (d == null)
        {
            d = w.a();
        }
        if (e == null)
        {
            new co();
            e = new a();
        }
        d.a(getApplicationContext());
        b = e.a(getIntent());
        if (b == null)
        {
            super.onCreate(bundle);
            finish();
            return;
        } else
        {
            b.a(this);
            b.a();
            super.onCreate(bundle);
            b.b();
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        b.c();
    }

    public void onResume()
    {
        super.onResume();
        b.d();
    }

    public void onStop()
    {
        b.e();
        super.onStop();
    }

}
