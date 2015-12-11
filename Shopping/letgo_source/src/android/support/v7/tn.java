// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

// Referenced classes of package android.support.v7:
//            tl

public final class tn
{
    private static abstract class a extends tl
    {

        public void onStop()
        {
        }

        private a()
        {
        }

    }

    public static interface b
    {

        public abstract void a(Bundle bundle);
    }


    static SharedPreferences a(Context context)
    {
        return b(context);
    }

    public static Future a(Context context, int i)
    {
        return (new a(context, i) {

            final Context a;
            final int b;

            public void zzdG()
            {
                android.content.SharedPreferences.Editor editor = tn.a(a).edit();
                editor.putInt("webview_cache_version", b);
                editor.apply();
            }

            
            {
                a = context;
                b = i;
                super();
            }
        }).zzgn();
    }

    public static Future a(Context context, b b1)
    {
        return (new a(context, b1) {

            final Context a;
            final b b;

            public void zzdG()
            {
                SharedPreferences sharedpreferences = tn.a(a);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", sharedpreferences.getBoolean("use_https", true));
                if (b != null)
                {
                    b.a(bundle);
                }
            }

            
            {
                a = context;
                b = b1;
                super();
            }
        }).zzgn();
    }

    public static Future a(Context context, boolean flag)
    {
        return (new a(context, flag) {

            final Context a;
            final boolean b;

            public void zzdG()
            {
                android.content.SharedPreferences.Editor editor = tn.a(a).edit();
                editor.putBoolean("use_https", b);
                editor.apply();
            }

            
            {
                a = context;
                b = flag;
                super();
            }
        }).zzgn();
    }

    private static SharedPreferences b(Context context)
    {
        return context.getSharedPreferences("admob", 0);
    }

    public static Future b(Context context, b b1)
    {
        return (new a(context, b1) {

            final Context a;
            final b b;

            public void zzdG()
            {
                SharedPreferences sharedpreferences = tn.a(a);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", sharedpreferences.getInt("webview_cache_version", 0));
                if (b != null)
                {
                    b.a(bundle);
                }
            }

            
            {
                a = context;
                b = b1;
                super();
            }
        }).zzgn();
    }
}
