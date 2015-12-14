// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.GlideException;
import com.picsart.effectnew.RectangleF;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.photo.imgop.a;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import myobfuscated.ag.f;
import myobfuscated.ah.e;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            h, c

public final class Mask
{

    public static final HashMap a = new HashMap() {
            private class ResourceType extends Enum
            {

                private static final ResourceType $VALUES[];
                public static final ResourceType DOWNLOADABLE;
                public static final ResourceType RESOURCE;

                public static ResourceType valueOf(String s1)
                {
                    return (ResourceType)Enum.valueOf(com/picsart/studio/editor/custommasks/Mask$ResourceType, s1);
                }

                public static ResourceType[] values()
                {
                    return (ResourceType[])$VALUES.clone();
                }

                static 
                {
                    RESOURCE = new ResourceType("RESOURCE", 0);
                    DOWNLOADABLE = new ResourceType("DOWNLOADABLE", 1);
                    $VALUES = (new ResourceType[] {
                        RESOURCE, DOWNLOADABLE
                    });
                }

                private ResourceType(String s1, int i1)
                {
                    super(s1, i1);
                }
            }


            
            {
                put("type_downloadable", ResourceType.DOWNLOADABLE);
                put("type_res", ResourceType.RESOURCE);
            }
    };
    private static String l;
    private static final HashMap m = new HashMap() {
            private class BlendMode extends Enum
            {

                private static final BlendMode $VALUES[];
                public static final BlendMode ADD;
                public static final BlendMode DARKEN;
                public static final BlendMode LIGHTEN;
                public static final BlendMode MULTIPLY;
                public static final BlendMode NORMAL;
                public static final BlendMode OVERLAY;
                public static final BlendMode SCREEN;
                private String mBlendModeName;

                public static BlendMode valueOf(String s1)
                {
                    return (BlendMode)Enum.valueOf(com/picsart/studio/editor/custommasks/Mask$BlendMode, s1);
                }

                public static BlendMode[] values()
                {
                    return (BlendMode[])$VALUES.clone();
                }

                public final String toString()
                {
                    return mBlendModeName;
                }

                static 
                {
                    NORMAL = new BlendMode("NORMAL", 0, "Normal");
                    SCREEN = new BlendMode("SCREEN", 1, "Screen");
                    OVERLAY = new BlendMode("OVERLAY", 2, "Overlay");
                    MULTIPLY = new BlendMode("MULTIPLY", 3, "Multiply");
                    DARKEN = new BlendMode("DARKEN", 4, "Darken");
                    LIGHTEN = new BlendMode("LIGHTEN", 5, "Lighten");
                    ADD = new BlendMode("ADD", 6, "Add");
                    $VALUES = (new BlendMode[] {
                        NORMAL, SCREEN, OVERLAY, MULTIPLY, DARKEN, LIGHTEN, ADD
                    });
                }

                private BlendMode(String s1, int i1, String s2)
                {
                    super(s1, i1);
                    mBlendModeName = s2;
                }
            }


            
            {
                put("normal", BlendMode.NORMAL);
                put("screen", BlendMode.SCREEN);
                put("overlay", BlendMode.OVERLAY);
                put("multiply", BlendMode.MULTIPLY);
                put("darken", BlendMode.DARKEN);
                put("lighten", BlendMode.LIGHTEN);
                put("add", BlendMode.ADD);
            }
    };
    private static final HashMap n = new HashMap() {
            private class MaskOrientation extends Enum
            {

                private static final MaskOrientation $VALUES[];
                public static final MaskOrientation BOTH;
                public static final MaskOrientation LANDSCAPE;
                public static final MaskOrientation PORTRAIT;

                public static MaskOrientation valueOf(String s1)
                {
                    return (MaskOrientation)Enum.valueOf(com/picsart/studio/editor/custommasks/Mask$MaskOrientation, s1);
                }

                public static MaskOrientation[] values()
                {
                    return (MaskOrientation[])$VALUES.clone();
                }

                static 
                {
                    LANDSCAPE = new MaskOrientation("LANDSCAPE", 0);
                    PORTRAIT = new MaskOrientation("PORTRAIT", 1);
                    BOTH = new MaskOrientation("BOTH", 2);
                    $VALUES = (new MaskOrientation[] {
                        LANDSCAPE, PORTRAIT, BOTH
                    });
                }

                private MaskOrientation(String s1, int i1)
                {
                    super(s1, i1);
                }
            }


            
            {
                put("horizontal_vertical", MaskOrientation.BOTH);
                put("horizontal", MaskOrientation.LANDSCAPE);
                put("vertical", MaskOrientation.PORTRAIT);
            }
    };
    private static String o;
    public String b;
    public String c;
    public String d;
    public String e;
    public ResourceType f;
    public BlendMode g;
    public h h;
    public int i;
    public int j;
    volatile boolean k;
    private MaskOrientation p;
    private BlendMode q;
    private Bitmap r;
    private File s;
    private String t;
    private boolean u;

    public Mask()
    {
        t = null;
        u = true;
        r = null;
        s = null;
        k = false;
        b();
    }

    static Bitmap a(Mask mask, Bitmap bitmap)
    {
        mask.r = bitmap;
        return bitmap;
    }

    private static PorterDuffXfermode a(BlendMode blendmode)
    {
        final class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[BlendMode.values().length];
                try
                {
                    a[BlendMode.MULTIPLY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[BlendMode.OVERLAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[BlendMode.SCREEN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BlendMode.ADD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BlendMode.LIGHTEN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BlendMode.DARKEN.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.picsart.studio.editor.custommasks._cls5.a[blendmode.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY);

        case 2: // '\002'
            return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY);

        case 3: // '\003'
            return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SCREEN);

        case 4: // '\004'
            return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.ADD);

        case 5: // '\005'
            return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.LIGHTEN);

        case 6: // '\006'
            return new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DARKEN);
        }
    }

    static File a(Mask mask)
    {
        return mask.s;
    }

    public static void a(Bitmap bitmap, Bitmap bitmap1, BlendMode blendmode, Canvas canvas)
    {
        Paint paint1 = new Paint(2);
        Paint paint = new Paint(2);
        Rect rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect = new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight());
        Rect rect1 = new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight());
        canvas.drawBitmap(bitmap, rect2, rect1, paint1);
        paint.setAlpha(255);
        bitmap = new ColorMatrix();
        com.socialin.android.photo.imgop.a.a(7, 0, bitmap);
        paint.setColorFilter(new ColorMatrixColorFilter(bitmap));
        paint.setXfermode(a(blendmode));
        canvas.drawBitmap(bitmap1, rect, rect1, paint);
    }

    private String b(Context context)
    {
        if (t == null)
        {
            if (h.e)
            {
                return (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808dc)).append("/").append(context.getString(0x7f0808dd)).append("/").append(h.b).toString();
            }
            t = (new StringBuilder("masks/")).append(h.b).append("/").append(c).toString();
        }
        return t;
    }

    private void b()
    {
        com.socialin.android.util.c.a(r);
        r = null;
        i = 255;
        j = 0;
        g = q;
    }

    private String c()
    {
        StringBuilder stringbuilder = new StringBuilder(d);
        if (p == MaskOrientation.BOTH && !u)
        {
            stringbuilder.append("_vertical");
        }
        stringbuilder.append(e);
        return stringbuilder.toString();
    }

    public final Bitmap a(Context context)
    {
        if (h.e)
        {
            context = com.picsart.shop.a.a(context).c(b(context), c);
            return com.socialin.android.util.c.a(context, 0, context.length, null, b);
        }
        InputStream inputstream;
        inputstream = context.getAssets().open(b(context));
        context = com.socialin.android.util.c.a(inputstream, null, null, b);
        inputstream.close();
        return context;
        IOException ioexception;
        ioexception;
_L2:
        ioexception.printStackTrace();
        return context;
        ioexception;
        context = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final BlendMode a(boolean flag)
    {
        if (flag)
        {
            return q;
        } else
        {
            return g;
        }
    }

    public final void a(float f1)
    {
        Matrix matrix = new Matrix();
        matrix.setRotate(f1, r.getWidth() / 2, r.getHeight() / 2);
        r = com.socialin.android.util.c.a(r, 0, 0, r.getWidth(), r.getHeight(), matrix, false);
    }

    public final void a(Activity activity, int i1, int j1, com.picsart.studio.editor.custommasks.c c1)
    {
        if (a())
        {
            c1.a(this);
        } else
        if (f != ResourceType.RESOURCE)
        {
            boolean flag;
            if (i1 > j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            u = flag;
            if (s == null)
            {
                Object obj = new StringBuilder();
                if (o == null)
                {
                    o = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(activity.getString(0x7f0808fb)).append("/").append(activity.getString(0x7f0808dc)).append("/masks_ver2/").toString();
                }
                obj = ((StringBuilder) (obj)).append(o).append(h.b).append("/").toString();
                File file = new File(((String) (obj)));
                if (!file.exists())
                {
                    file.mkdirs();
                }
                s = new File(((String) (obj)), c());
            }
            if (s.exists() || h.e)
            {
                if (h.e)
                {
                    com.picsart.shop.a a1 = com.picsart.shop.a.a(activity);
                    h h1 = h;
                    activity = a1.c((new StringBuilder()).append((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(activity.getString(0x7f0808fb)).append("/").append(activity.getString(0x7f0808dc)).append("/").append(activity.getString(0x7f0808dd)).append("/").toString()).append(h1.b).toString(), c());
                    if (activity == null)
                    {
                        c1.a(null);
                        return;
                    }
                    r = com.socialin.android.util.c.a(activity, 0, activity.length, null, b);
                } else
                {
                    if (s == null || !s.exists())
                    {
                        c1.a(null);
                        return;
                    }
                    r = BitmapFactory.decodeFile(s.getAbsolutePath());
                }
                c1.a(this);
                return;
            }
            StringBuilder stringbuilder = (new StringBuilder()).append(l).append("/").append(h.b).append("/");
            String s1;
            if (PicsartContext.a.getMaxImageSizeMegapixel() >= 4)
            {
                s1 = "2048";
            } else
            {
                s1 = "1024";
            }
            activity.runOnUiThread(new Runnable(activity, stringbuilder.append(s1).append("/").append(c()).toString(), c1) {

                final com.picsart.studio.editor.custommasks.c a;
                final Mask b;
                private Activity c;
                private String d;

                public final void run()
                {
                    com.bumptech.glide.b.a(c).j().a(d).a(new f(this) {

                        private _cls4 a;

                        public final void a(Object obj, e e1)
                        {
                            obj = (File)obj;
                            if (com.picsart.studio.editor.custommasks.Mask.a(a.b) != null)
                            {
                                FileUtils.b(((File) (obj)), com.picsart.studio.editor.custommasks.Mask.a(a.b));
                            }
                            com.picsart.studio.editor.custommasks.Mask.a(a.b, BitmapFactory.decodeFile(((File) (obj)).getAbsolutePath()));
                            if (a.a != null)
                            {
                                a.a.a(a.b);
                            }
                        }

                        public final void c(Drawable drawable)
                        {
                            super.c(drawable);
                            if (a.a != null)
                            {
                                a.a.a(new GlideException("Error"));
                            }
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                }

            
            {
                b = Mask.this;
                c = activity;
                d = s1;
                a = c1;
                super();
            }
            });
            return;
        }
    }

    public final void a(Context context, Bitmap bitmap, Canvas canvas)
    {
        while (context == null || bitmap == null || bitmap.isRecycled() || !k || r == null || r.isRecycled()) 
        {
            return;
        }
        context = new RectangleF();
        context.set(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        Paint paint = new Paint(2);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), context, paint);
        bitmap = new Rect(0, 0, r.getWidth(), r.getHeight());
        ColorMatrix colormatrix = new ColorMatrix();
        com.socialin.android.photo.imgop.a.a(7, j, colormatrix);
        paint = new Paint(2);
        paint.setAlpha(i);
        paint.setColorFilter(new ColorMatrixColorFilter(colormatrix));
        if (g == BlendMode.MULTIPLY)
        {
            Paint paint1 = new Paint(2);
            paint1.setXfermode(a(g));
            paint.setXfermode(a(BlendMode.NORMAL));
            canvas.saveLayer(context, paint1, 31);
            canvas.drawColor(Color.argb(255, 255, 255, 255));
            canvas.drawBitmap(r, bitmap, context, paint);
            canvas.restore();
            return;
        } else
        {
            (new StringBuilder("blendMode is: ")).append(g);
            paint.setXfermode(a(g));
            canvas.drawBitmap(r, bitmap, context, paint);
            return;
        }
    }

    public final void a(String s1)
    {
        p = (MaskOrientation)n.get(s1);
        if (p == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s1).append(": invalid resource type").toString());
        } else
        {
            return;
        }
    }

    public final void a(String s1, boolean flag)
    {
        BlendMode blendmode = (BlendMode)m.get(s1);
        if (blendmode == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s1).append(": blend mode not found").toString());
        }
        if (flag)
        {
            q = blendmode;
            return;
        } else
        {
            g = blendmode;
            return;
        }
    }

    public final void a(boolean flag, boolean flag1)
    {
        float f2 = -1F;
        Matrix matrix = new Matrix();
        float f1;
        if (flag)
        {
            f1 = -1F;
        } else
        {
            f1 = 1.0F;
        }
        if (!flag1)
        {
            f2 = 1.0F;
        }
        matrix.setScale(f1, f2, r.getWidth() / 2, r.getHeight() / 2);
        r = com.socialin.android.util.c.a(r, 0, 0, r.getWidth(), r.getHeight(), matrix, false);
    }

    public final boolean a()
    {
        return r != null && !r.isRecycled();
    }

    public final void b(boolean flag)
    {
        if (!flag)
        {
            b();
        }
        k = flag;
    }

    public final String toString()
    {
        return b;
    }

    static 
    {
        l = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("masks_ver2").toString();
    }
}
