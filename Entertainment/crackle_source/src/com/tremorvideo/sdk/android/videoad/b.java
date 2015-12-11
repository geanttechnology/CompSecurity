// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.Dictionary;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            a, n, ae, aw, 
//            an, w, bv, ad, 
//            ab

public class b extends com.tremorvideo.sdk.android.videoad.a
{
    class a extends AsyncTask
    {

        final an a;
        final b b;

        private String a(Context context, Uri uri)
        {
            context = context.getContentResolver().query(uri, new String[] {
                "_data"
            }, null, null, null);
            int i = context.getColumnIndexOrThrow("_data");
            context.moveToFirst();
            uri = context.getString(i);
            if (context != null)
            {
                context.close();
            }
            return uri;
            uri;
            context = null;
_L2:
            if (context != null)
            {
                context.close();
            }
            throw uri;
            uri;
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected transient Boolean a(Void avoid[])
        {
            boolean flag;
            boolean flag1;
            flag1 = true;
            flag = true;
            String s = b.e(b).a(b.c);
            if (s == null) goto _L2; else goto _L1
_L1:
            int i = s.length();
            if (i <= 0) goto _L2; else goto _L3
_L3:
            if (ad.q() < 8) goto _L5; else goto _L4
_L4:
            avoid = b.c;
            s = a(((Context) (b.c)), Uri.parse(s));
            android.media.MediaScannerConnection.OnScanCompletedListener onscancompletedlistener = new android.media.MediaScannerConnection.OnScanCompletedListener(this) {

                final a a;

                public void onScanCompleted(String s, Uri uri)
                {
                    ad.d((new StringBuilder()).append("Storage Scan Completed uri = ").append(uri).toString());
                }

            
            {
                a = a1;
                super();
            }
            };
            MediaScannerConnection.scanFile(avoid, new String[] {
                s
            }, null, onscancompletedlistener);
_L8:
            return Boolean.valueOf(flag);
_L5:
            try
            {
                b.c.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse((new StringBuilder()).append("file://").append(Environment.getExternalStorageDirectory()).toString())));
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                flag = flag1;
            }
_L6:
            ad.a(avoid);
            continue; /* Loop/switch isn't completed */
            avoid;
            flag = false;
            if (true) goto _L6; else goto _L2
_L2:
            flag = false;
            if (true) goto _L8; else goto _L7
_L7:
        }

        protected void a(Boolean boolean1)
        {
            a.dismiss();
            ab ab1 = new ab(b.c, b.a, ab.a.a, new ab.b(this) {

                final a a;

                public void a(boolean flag)
                {
                }

            
            {
                a = a1;
                super();
            }
            });
            if (boolean1.booleanValue())
            {
                ab1.a("The coupon has been saved to the gallery.");
                ab1.setTitle("Save Complete");
            } else
            {
                ab1.a("An error occurred while saving.");
                ab1.setTitle("Save Error");
            }
            ab1.a("Ok", "");
            ab1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener(this) {

                final a a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    b.b(a.b, false);
                    if (b.f(a.b))
                    {
                        b.a(a.b, false);
                    }
                }

            
            {
                a = a1;
                super();
            }
            });
            ab1.setCanceledOnTouchOutside(false);
            ab1.show();
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Boolean)obj);
        }

        a(an an1)
        {
            b = b.this;
            a = an1;
            super();
        }
    }


    bv a;
    private ae b;
    private boolean e;
    private boolean f;
    private boolean g;

    public b(a.a a1, Activity activity, n n1, boolean flag)
    {
        super(a1, activity);
        g = false;
        f = flag;
        b = n1.p();
        e = false;
        a = n1.q();
    }

    static void a(b b1)
    {
        b1.h();
    }

    static void a(b b1, boolean flag)
    {
        b1.a(flag);
    }

    private void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (g || e) goto _L2; else goto _L1
_L1:
        e = true;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (!f) goto _L6; else goto _L5
_L5:
        int i = d.a(b.a(aw.b.D));
_L9:
        if (i == -1) goto _L4; else goto _L7
_L7:
        d.a(i);
_L4:
        d.a(this);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        i = d.a(b.a(aw.b.E));
        if (true) goto _L9; else goto _L8
_L8:
        Exception exception;
        exception;
        throw exception;
    }

    static void b(b b1)
    {
        b1.g();
    }

    static boolean b(b b1, boolean flag)
    {
        b1.g = flag;
        return flag;
    }

    static boolean c(b b1)
    {
        return b1.e;
    }

    static boolean d(b b1)
    {
        return b1.f;
    }

    static ae e(b b1)
    {
        return b1.b;
    }

    private boolean e()
    {
        return b.a(aw.b.M) == null;
    }

    private int f()
    {
        return ((WindowManager)c.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    static boolean f(b b1)
    {
        return b1.e();
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        Dictionary dictionary;
        Intent intent;
        f = false;
        aw aw1 = b.a(aw.b.M);
        dictionary = aw1.f();
        if (dictionary.get("subject") == null && dictionary.get("message") == null)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        int i = d.a(aw1);
        d.a(i);
        intent = new Intent("android.intent.action.SEND");
        if (dictionary.get("subject") != null)
        {
            intent.putExtra("android.intent.extra.SUBJECT", (String)dictionary.get("subject"));
        }
        String s = "";
        if (dictionary.get("message") != null)
        {
            s = (new StringBuilder()).append("").append((String)dictionary.get("message")).toString();
        }
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s).append("\n\n").append(b.c()).toString());
        intent.setType("text/plain");
        c.startActivityForResult(Intent.createChooser(intent, "Share"), 11);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void h()
    {
        this;
        JVM INSTR monitorenter ;
        if (!g)
        {
            f = false;
            g = true;
            int i = d.a(b.a(aw.b.A));
            d.a(i);
            an an1 = an.a(c);
            an1.setMessage("Saving...");
            an1.show();
            (new a(an1)).execute(new Void[0]);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a()
    {
        Object obj;
        if (!f)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj = b.a(aw.b.C);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        int i = d.a(((aw) (obj)));
        d.a(i);
        if (b.a(aw.b.M) != null)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        obj = new aw.b[1];
        obj[0] = aw.b.A;
_L1:
        obj = new w(c, new android.view.View.OnClickListener() {

            final b a;

            public void onClick(View view)
            {
                if (view.getTag().equals(aw.b.A.c()))
                {
                    b.a(a);
                    return;
                }
                if (view.getTag().equals(aw.b.M.c()))
                {
                    b.b(a);
                    return;
                } else
                {
                    b.a(a, true);
                    return;
                }
            }

            
            {
                a = b.this;
                super();
            }
        }, ((aw.b []) (obj)), a, true, "Done", f());
        Bitmap bitmap = bv.a(b.b());
        Object obj1 = new ImageView(c);
        ((ImageView) (obj1)).setImageBitmap(bitmap);
        ((ImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        ((ImageView) (obj1)).setFocusable(false);
        FrameLayout framelayout = new FrameLayout(c);
        framelayout.addView(((View) (obj1)), new android.widget.FrameLayout.LayoutParams(-1, -1));
        obj1 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        obj1.gravity = 80;
        framelayout.addView(((w) (obj)).d(), ((android.view.ViewGroup.LayoutParams) (obj1)));
        c.setContentView(framelayout);
        if (b.a() > 0 && f)
        {
            framelayout.postDelayed(new Runnable() {

                final b a;

                public void run()
                {
                    if (!b.c(a) && b.d(a))
                    {
                        b.a(a, true);
                    }
                }

            
            {
                a = b.this;
                super();
            }
            }, b.a());
        }
        if (bitmap.getWidth() > bitmap.getHeight())
        {
            ad.d(c);
            return;
        }
        break MISSING_BLOCK_LABEL_303;
        try
        {
            obj = new aw.b[2];
            obj[0] = aw.b.A;
            obj[1] = aw.b.M;
        }
        catch (Exception exception)
        {
            ad.a(exception);
            d.a(this);
            return;
        }
          goto _L1
        ad.c(c);
        return;
    }

    public boolean a(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            a(true);
            return true;
        } else
        {
            return super.a(i, keyevent);
        }
    }

    public a.b n()
    {
        return a.b.d;
    }
}
