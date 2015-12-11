// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.flurry.android.impl.ads.protocol.v13.NativeAsset;
import com.flurry.android.impl.ads.protocol.v13.NativeAssetType;
import java.io.File;

// Referenced classes of package com.flurry.sdk:
//            gd, i, aa, gk, 
//            ck, fn, fp, hq

public class m
{

    private static final String a = com/flurry/sdk/m.getSimpleName();

    public m()
    {
    }

    static String a()
    {
        return a;
    }

    private void a(NativeAsset nativeasset, View view)
    {
        if (nativeasset == null || !NativeAssetType.STRING.equals(nativeasset.type))
        {
            return;
        }
        if (view == null || !(view instanceof TextView))
        {
            gd.e(a, "The view must be an instance of TextView in order to load the asset");
            return;
        } else
        {
            ((TextView)view).setText(nativeasset.value);
            return;
        }
    }

    private void b(NativeAsset nativeasset, View view, int j)
    {
        if (nativeasset == null || TextUtils.isEmpty(nativeasset.value) || !NativeAssetType.IMAGE.equals(nativeasset.type))
        {
            return;
        }
        if (view == null || !(view instanceof ImageView))
        {
            gd.e(a, "The view must be an instance of ImageView in order to load the asset");
            return;
        }
        view = (ImageView)view;
        Object obj = i.a().l().a(j, nativeasset.value);
        if (obj == null)
        {
            gd.a(3, a, (new StringBuilder()).append("Cached asset not available for image:").append(nativeasset.value).toString());
            obj = new gk();
            ((gk) (obj)).a(nativeasset.value);
            ((gk) (obj)).a(40000);
            ((gk) (obj)).a(gl.a.b);
            ((gk) (obj)).b(new ck());
            ((gk) (obj)).a(new gk.a(view) {

                final ImageView a;
                final m b;

                public void a(gk gk1, Bitmap bitmap)
                {
                    gd.a(3, m.a(), (new StringBuilder()).append("Image request -- HTTP status code is:").append(gk1.e()).toString());
                    if (gk1.c())
                    {
                        fp.a().a(new hq(this, bitmap) {

                            final Bitmap a;
                            final _cls1 b;

                            public void safeRun()
                            {
                                b.a.setImageBitmap(a);
                            }

            
            {
                b = _pcls1;
                a = bitmap;
                super();
            }
                        });
                    }
                }

                public volatile void a(gk gk1, Object obj1)
                {
                    a(gk1, (Bitmap)obj1);
                }

            
            {
                b = m.this;
                a = imageview;
                super();
            }
            });
            fn.a().a(this, ((hr) (obj)));
            return;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append("Cached asset present for image:").append(nativeasset.value).toString());
            nativeasset = ((File) (obj)).getAbsolutePath();
            fp.a().a(new hq(view, nativeasset) {

                final ImageView a;
                final String b;
                final m c;

                public void safeRun()
                {
                    a.setImageBitmap(BitmapFactory.decodeFile(b));
                }

            
            {
                c = m.this;
                a = imageview;
                b = s;
                super();
            }
            });
            return;
        }
    }

    public View a(Context context, NativeAsset nativeasset, int j)
    {
        Object obj;
        obj = null;
        if (context == null || nativeasset == null)
        {
            return null;
        }
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[NativeAssetType.values().length];
                try
                {
                    a[NativeAssetType.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[NativeAssetType.IMAGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[NativeAssetType.VIDEO.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[NativeAssetType.VAST_VIDEO.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[NativeAssetType.RICH_MEDIA.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3.a[nativeasset.type.ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 60
    //                   2 72;
           goto _L1 _L2 _L3
_L1:
        context = obj;
_L5:
        a(nativeasset, ((View) (context)), j);
        return context;
_L2:
        context = new TextView(context);
        continue; /* Loop/switch isn't completed */
_L3:
        context = new ImageView(context);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public String a(NativeAsset nativeasset, int j)
    {
        File file = i.a().l().a(j, nativeasset.value);
        if (file == null)
        {
            return nativeasset.value;
        } else
        {
            return (new StringBuilder()).append("file://").append(file.getAbsolutePath()).toString();
        }
    }

    public void a(NativeAsset nativeasset, View view, int j)
    {
        if (nativeasset == null || view == null)
        {
            return;
        }
        switch (_cls3.a[nativeasset.type.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a(nativeasset, view);
            return;

        case 2: // '\002'
            b(nativeasset, view, j);
            break;
        }
    }

}
