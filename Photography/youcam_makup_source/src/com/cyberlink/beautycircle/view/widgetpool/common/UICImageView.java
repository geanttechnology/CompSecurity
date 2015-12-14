// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.n;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.b.b;
import com.nostra13.universalimageloader.core.d;
import com.nostra13.universalimageloader.core.d.a;
import com.nostra13.universalimageloader.core.e;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.utility.h;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            e, d, q

public class UICImageView extends ImageView
    implements a
{

    private static final int g;
    private static int v = 0;
    private a A;
    protected q a;
    private String b;
    private Bitmap c;
    private int d;
    private Rect e;
    private RectF f;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private com.cyberlink.beautycircle.view.widgetpool.common.e l;
    private boolean m;
    private com.cyberlink.beautycircle.view.widgetpool.common.d n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private ConnectivityManager s;
    private boolean t;
    private d u;
    private boolean w;
    private boolean x;
    private boolean y;
    private float z;

    public UICImageView(Context context)
    {
        this(context, null, 0);
    }

    public UICImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public UICImageView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        b = null;
        c = null;
        d = 0;
        e = null;
        f = null;
        h = 0xff000000;
        i = 0;
        j = g;
        k = false;
        l = null;
        m = false;
        n = null;
        o = 3000;
        p = 0;
        q = 0;
        r = false;
        s = null;
        t = true;
        u = null;
        w = false;
        x = true;
        y = false;
        z = 1.0F;
        a = null;
        A = null;
        if (!isInEditMode())
        {
            a(context, attributeset, i1);
            s = (ConnectivityManager)context.getSystemService("connectivity");
            setOnTouchListener(new android.view.View.OnTouchListener() {

                final UICImageView a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return false;
                }

            
            {
                a = UICImageView.this;
                super();
            }
            });
        }
    }

    static d a(UICImageView uicimageview)
    {
        return uicimageview.u;
    }

    private void a(Context context, AttributeSet attributeset, int i1)
    {
        attributeset = context.obtainStyledAttributes(attributeset, n.UICImageViewArgs, i1, 0);
        d = attributeset.getInteger(n.UICImageViewArgs_auto_resize_mode, 0);
        h = attributeset.getColor(n.UICImageViewArgs_bc_circle_border_color, 0xff000000);
        i = attributeset.getDimensionPixelSize(n.UICImageViewArgs_bc_circle_border_width, 0);
        j = attributeset.getResourceId(n.UICImageViewArgs_bc_default_image, g);
        k = attributeset.getBoolean(n.UICImageViewArgs_bc_circle_bitmap, false);
        m = attributeset.getBoolean(n.UICImageViewArgs_bc_fade_In_displayer, false);
        o = attributeset.getInteger(n.UICImageViewArgs_bc_fade_In_duration, 3000);
        r = attributeset.getBoolean(n.UICImageViewArgs_bc_is_cl_multi_column, false);
        y = attributeset.getBoolean(n.UICImageViewArgs_bc_adjudge_portrait_center_crop, false);
        z = attributeset.getFloat(n.UICImageViewArgs_bc_adjudge_portrait_center_crop_scale, 1.0F);
        context = new Rect();
        context.top = attributeset.getDimensionPixelSize(n.UICImageViewArgs_bc_crop_top, 0);
        context.bottom = attributeset.getDimensionPixelSize(n.UICImageViewArgs_bc_crop_bottom, 0);
        context.left = attributeset.getDimensionPixelSize(n.UICImageViewArgs_bc_crop_left, 0);
        context.right = attributeset.getDimensionPixelSize(n.UICImageViewArgs_bc_crop_right, 0);
        if (((Rect) (context)).top > 0 || ((Rect) (context)).bottom > 0 || ((Rect) (context)).left > 0 || ((Rect) (context)).right > 0)
        {
            e = context;
        }
        context = new RectF();
        context.top = attributeset.getFloat(n.UICImageViewArgs_bc_crop_proportion_top, 0.0F);
        context.bottom = attributeset.getFloat(n.UICImageViewArgs_bc_crop_proportion_bottom, 0.0F);
        context.left = attributeset.getFloat(n.UICImageViewArgs_bc_crop_proportion_left, 0.0F);
        context.right = attributeset.getFloat(n.UICImageViewArgs_bc_crop_proportion_right, 0.0F);
        if (((RectF) (context)).top > 0.0F || ((RectF) (context)).bottom > 0.0F || ((RectF) (context)).left > 0.0F || ((RectF) (context)).right > 0.0F)
        {
            f = context;
        }
        boolean flag = attributeset.getBoolean(n.UICImageViewArgs_bc_cache_on_disk, true);
        if (k)
        {
            l = new com.cyberlink.beautycircle.view.widgetpool.common.e(h, i);
            u = (new e()).a(true).b(true).c(flag).a(l).d(true).a(new Handler()).a();
        } else
        {
            if (m)
            {
                n = new com.cyberlink.beautycircle.view.widgetpool.common.d(o, true, true, false);
            }
            e e1 = (new e()).a(true).b(true).c(flag).d(true);
            if (!m)
            {
                context = new b();
            } else
            {
                context = n;
            }
            u = e1.a(context).a(new Handler()).a();
        }
        attributeset.recycle();
    }

    private boolean a(int i1, int j1)
    {
        int k1;
        int l1;
        if (p != 0 && q != 0)
        {
            l1 = p;
            k1 = q;
        } else
        if (c != null)
        {
            if (c != null)
            {
                l1 = c.getWidth();
            } else
            {
                l1 = 0;
            }
            if (c != null)
            {
                k1 = c.getHeight();
            } else
            {
                k1 = 0;
            }
        } else
        {
            Object obj = getDrawable();
            float f1;
            if (obj instanceof BitmapDrawable)
            {
                obj = ((BitmapDrawable)obj).getBitmap();
                int i2;
                if (obj != null)
                {
                    k1 = ((Bitmap) (obj)).getWidth();
                } else
                {
                    k1 = 0;
                }
                if (obj != null)
                {
                    l1 = ((Bitmap) (obj)).getHeight();
                } else
                {
                    l1 = 0;
                }
                i2 = l1;
                l1 = k1;
                k1 = i2;
            } else
            {
                k1 = 0;
                l1 = 0;
            }
        }
        if (l1 != 0 && k1 != 0)
        {
            if (d == 1)
            {
                i1 = android.view.View.MeasureSpec.getSize(i1);
                f1 = i1;
                setMeasuredDimension(i1, (int)Math.ceil(((float)k1 * f1) / (float)l1));
                return true;
            }
            if (d == 2)
            {
                i1 = android.view.View.MeasureSpec.getSize(j1);
                f1 = i1;
                setMeasuredDimension((int)Math.ceil(((float)l1 * f1) / (float)k1), i1);
                return true;
            }
            if (d == 3)
            {
                i1 = android.view.View.MeasureSpec.getSize(i1);
                setMeasuredDimension(i1, android.view.View.MeasureSpec.getSize(j1));
                setScaleType(android.widget.ImageView.ScaleType.MATRIX);
                obj = getImageMatrix();
                f1 = (float)i1 / (float)l1;
                ((Matrix) (obj)).setScale(f1, f1, 0.0F, 0.0F);
                setImageMatrix(((Matrix) (obj)));
                return true;
            }
        }
        return false;
    }

    static String b(UICImageView uicimageview)
    {
        return uicimageview.b;
    }

    private void b()
    {
        if (v >= 4 || b == null)
        {
            return;
        }
        v++;
        if (!k && !m)
        {
            postDelayed(new Runnable() {

                final UICImageView a;

                public void run()
                {
                    if (com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.a(a) == null)
                    {
                        return;
                    } else
                    {
                        com.nostra13.universalimageloader.core.f.b().a(com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.b(a), com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.a(a), a);
                        return;
                    }
                }

            
            {
                a = UICImageView.this;
                super();
            }
            }, 500L);
            return;
        } else
        {
            com.nostra13.universalimageloader.core.f.b().a(b, this, u, this);
            return;
        }
    }

    private void b(Bitmap bitmap)
    {
        float f2 = 0.0F;
        if (bitmap == null || !y)
        {
            return;
        }
        int i1 = bitmap.getWidth();
        int j1 = bitmap.getHeight();
        bitmap = getImageMatrix();
        int k1 = getWidth() - getPaddingLeft() - getPaddingRight();
        int l1 = getHeight() - getPaddingTop() - getPaddingBottom();
        float f1;
        float f3;
        if (i1 * l1 > k1 * j1)
        {
            f1 = (float)l1 / (float)j1;
            f3 = ((float)k1 - (float)i1 * f1) * 0.5F;
        } else
        {
            f2 = (float)k1 / (float)i1;
            float f4 = l1;
            float f5 = j1;
            float f6 = z;
            f1 = f2;
            f3 = 0.0F;
            f2 = (f4 - f5 * f2) * 0.5F * f6;
        }
        bitmap.setScale(f1, f1);
        bitmap.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
        setImageMatrix(bitmap);
    }

    private Bitmap c(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            if (e != null)
            {
                return Bitmap.createBitmap(bitmap, e.left, e.top, bitmap.getWidth() - e.right - e.left, bitmap.getHeight() - e.bottom - e.top);
            }
            if (f != null)
            {
                int i1 = (int)((float)bitmap.getWidth() * f.left);
                int j1 = (int)((float)bitmap.getHeight() * f.top);
                return Bitmap.createBitmap(bitmap, i1, j1, (int)((float)bitmap.getWidth() * (1.0F - f.right) - (float)i1), (int)((float)bitmap.getHeight() * (1.0F - f.bottom) - (float)j1));
            }
        }
        return bitmap;
    }

    static ConnectivityManager c(UICImageView uicimageview)
    {
        return uicimageview.s;
    }

    private void c()
    {
        boolean flag;
        boolean flag1 = false;
        flag = flag1;
        if (s != null)
        {
            NetworkInfo networkinfo = s.getActiveNetworkInfo();
            flag = flag1;
            if (networkinfo != null)
            {
                flag = flag1;
                if (networkinfo.isConnectedOrConnecting())
                {
                    flag = true;
                }
            }
        }
        if (t == flag) goto _L2; else goto _L1
_L1:
        t = flag;
        if (!t) goto _L4; else goto _L3
_L3:
        b();
_L6:
        return;
_L4:
        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            final UICImageView a;

            public void onReceive(Context context1, Intent intent)
            {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && UICImageView.c(a) != null)
                {
                    intent = UICImageView.c(a).getActiveNetworkInfo();
                    boolean flag2;
                    if (intent != null && intent.isConnectedOrConnecting())
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (flag2)
                    {
                        if (context1 != null)
                        {
                            context1.unregisterReceiver(this);
                        }
                        com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.d(a);
                    }
                }
            }

            
            {
                a = UICImageView.this;
                super();
            }
        };
        IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Context context = getContext();
        if (context != null)
        {
            context.registerReceiver(broadcastreceiver, intentfilter);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag)
        {
            b();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void d()
    {
        if (c != null)
        {
            if (r)
            {
                setImageBitmap(c);
                if (m && n != null && c != null)
                {
                    clearAnimation();
                    n.a(this);
                }
                if (a != null)
                {
                    a.a(c);
                }
            } else
            {
                post(new Runnable() {

                    final UICImageView a;

                    public void run()
                    {
                        a.setImageBitmap(com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.e(a));
                        if (com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.f(a) && com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.g(a) != null && com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.e(a) != null)
                        {
                            a.clearAnimation();
                            com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.g(a).a(a);
                        }
                        if (a.a != null)
                        {
                            a.a.a(com.cyberlink.beautycircle.view.widgetpool.common.UICImageView.e(a));
                        }
                    }

            
            {
                a = UICImageView.this;
                super();
            }
                });
            }
        }
        if (k && l != null)
        {
            int i1 = getWidth();
            int j1 = getHeight();
            if (i1 > 0 && j1 > 0)
            {
                l.a(i1);
            }
        }
    }

    static void d(UICImageView uicimageview)
    {
        uicimageview.b();
    }

    static Bitmap e(UICImageView uicimageview)
    {
        return uicimageview.c;
    }

    static boolean f(UICImageView uicimageview)
    {
        return uicimageview.m;
    }

    static com.cyberlink.beautycircle.view.widgetpool.common.d g(UICImageView uicimageview)
    {
        return uicimageview.n;
    }

    public void a(Bitmap bitmap)
    {
        c = bitmap;
        setImageBitmap(bitmap);
    }

    public void a(Uri uri, Integer integer, Integer integer1)
    {
        a(uri, null, null, null);
    }

    public void a(Uri uri, Integer integer, Integer integer1, String s1)
    {
        boolean flag = false;
        if (uri != null)
        {
            v = 0;
            if (b != null && b.equals(uri.toString()) && (c != null || k && l != null))
            {
                if (m && n != null)
                {
                    n.a(false);
                }
                d();
                return;
            }
        }
        if (m && n != null)
        {
            n.a(true);
        }
        int i1;
        int j1;
        int k1;
        if (x || c == null)
        {
            if (s1 == null)
            {
                setImageResource(j);
            } else
            {
                try
                {
                    setImageDrawable(new ColorDrawable(Color.parseColor(s1)));
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    setImageResource(j);
                }
            }
        }
        j1 = p;
        k1 = q;
        if (integer != null)
        {
            i1 = integer.intValue();
        } else
        {
            i1 = 0;
        }
        p = i1;
        i1 = ((flag) ? 1 : 0);
        if (integer1 != null)
        {
            i1 = integer1.intValue();
        }
        q = i1;
        if (j1 != p || k1 != q)
        {
            requestLayout();
        }
        c = null;
        if (uri != null)
        {
            uri = com.perfectcorp.utility.h.a(uri);
        } else
        {
            uri = null;
        }
        if (uri != null)
        {
            b = uri.toString();
            if (k)
            {
                com.nostra13.universalimageloader.core.f.b().a(b, this, u, this);
                return;
            } else
            {
                com.nostra13.universalimageloader.core.f.b().a(b, u, this);
                return;
            }
        } else
        {
            b = null;
            return;
        }
    }

    public void a(String s1, View view)
    {
        if (A != null)
        {
            A.a(s1, view);
        }
    }

    public void a(String s1, View view, Bitmap bitmap)
    {
        if (!k && b != null && b.equals(s1))
        {
            c = bitmap;
            d();
        }
        if (A != null)
        {
            A.a(s1, view, bitmap);
        }
    }

    public void a(String s1, View view, FailReason failreason)
    {
        com.nostra13.universalimageloader.core.assist.FailReason.FailType failtype;
        if (A != null)
        {
            A.a(s1, view, failreason);
        }
        failtype = failreason.a();
        if (!w) goto _L2; else goto _L1
_L1:
        class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[com.nostra13.universalimageloader.core.assist.FailReason.FailType.values().length];
                try
                {
                    a[com.nostra13.universalimageloader.core.assist.FailReason.FailType.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.nostra13.universalimageloader.core.assist.FailReason.FailType.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.nostra13.universalimageloader.core.assist.FailReason.FailType.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.nostra13.universalimageloader.core.assist.FailReason.FailType.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.nostra13.universalimageloader.core.assist.FailReason.FailType.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.cyberlink.beautycircle.view.widgetpool.common._cls5.a[failtype.ordinal()];
        JVM INSTR tableswitch 1 5: default 76
    //                   1 107
    //                   2 138
    //                   3 169
    //                   4 200
    //                   5 231;
           goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        if (A != null)
        {
            A.a(s1, view, failreason);
        }
        if (!s1.equals(b))
        {
            return;
        }
        break; /* Loop/switch isn't completed */
_L3:
        com.perfectcorp.utility.e.c(new Object[] {
            String.format(Locale.getDefault(), "onLoadingFailed:NETWORK_DENIED url=%s", new Object[] {
                s1
            })
        });
        continue; /* Loop/switch isn't completed */
_L4:
        com.perfectcorp.utility.e.c(new Object[] {
            String.format(Locale.getDefault(), "onLoadingFailed:IO_ERROR url=%s", new Object[] {
                s1
            })
        });
        continue; /* Loop/switch isn't completed */
_L5:
        com.perfectcorp.utility.e.c(new Object[] {
            String.format(Locale.getDefault(), "onLoadingFailed:DECODING_ERROR url=%s", new Object[] {
                s1
            })
        });
        continue; /* Loop/switch isn't completed */
_L6:
        com.perfectcorp.utility.e.c(new Object[] {
            String.format(Locale.getDefault(), "onLoadingFailed:OUT_OF_MEMORY url=%s", new Object[] {
                s1
            })
        });
        continue; /* Loop/switch isn't completed */
_L7:
        com.perfectcorp.utility.e.c(new Object[] {
            String.format(Locale.getDefault(), "onLoadingFailed:UNKNOWN url=%s", new Object[] {
                s1
            })
        });
        if (true) goto _L2; else goto _L8
_L8:
        switch (com.cyberlink.beautycircle.view.widgetpool.common._cls5.a[failtype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            c();
            return;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            b();
            break;
        }
        return;
    }

    public boolean a()
    {
        return c != null;
    }

    public void b(String s1, View view)
    {
        if (w)
        {
            com.perfectcorp.utility.e.c(new Object[] {
                String.format(Locale.getDefault(), "onLoadingCancelled url=%s", new Object[] {
                    s1
                })
            });
        }
        if (A != null)
        {
            A.b(s1, view);
        }
        if (!s1.equals(b))
        {
            return;
        } else
        {
            b();
            return;
        }
    }

    public int getBitmapHeight()
    {
        if (c == null)
        {
            return 0;
        } else
        {
            return c.getHeight();
        }
    }

    public int getBitmapWidth()
    {
        if (c == null)
        {
            return 0;
        } else
        {
            return c.getWidth();
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        if (d == 0 || !a(i1, j1))
        {
            super.onMeasure(i1, j1);
        }
        d();
    }

    public void setDrawDefaultWhenChangingImage(boolean flag)
    {
        x = flag;
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        bitmap = c(bitmap);
        b(bitmap);
        super.setImageBitmap(bitmap);
    }

    public void setImageLoadingListener(a a1)
    {
        A = a1;
    }

    public void setImageURI(Uri uri)
    {
        a(uri, null, null, null);
    }

    public void setOnBitmapSetListener(q q1)
    {
        a = q1;
    }

    static 
    {
        g = g.bc_issue_image_background;
    }
}
