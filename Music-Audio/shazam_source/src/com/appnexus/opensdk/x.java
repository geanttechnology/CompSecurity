// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.f;
import com.appnexus.opensdk.b.k;
import com.appnexus.opensdk.b.l;
import com.appnexus.opensdk.b.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.appnexus.opensdk:
//            y, m, k, d, 
//            AdActivity, z

final class x
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        private static final a h[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/appnexus/opensdk/x$a, s1);
        }

        public static a[] values()
        {
            return (a[])h.clone();
        }

        static 
        {
            a = new a("top_left", 0);
            b = new a("top_right", 1);
            c = new a("center", 2);
            d = new a("bottom_left", 3);
            e = new a("bottom_right", 4);
            f = new a("top_center", 5);
            g = new a("bottom_center", 6);
            h = (new a[] {
                a, b, c, d, e, f, g
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    protected static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        private static final b c[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/appnexus/opensdk/x$b, s1);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("STARTING_DEFAULT", 0);
            b = new b("STARTING_EXPANDED", 1);
            c = (new b[] {
                a, b
            });
        }

        private b(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    protected static final String a[] = {
        "default", "expanded"
    };
    protected final com.appnexus.opensdk.m b;
    boolean c;
    boolean d;
    int e;
    int f;
    int g;
    boolean h;
    boolean i;
    Activity j;
    ViewGroup k;
    boolean l;
    int m;
    private boolean n;
    private int o;
    private int p;
    private int q[];
    private boolean r;
    private y s;

    public x(com.appnexus.opensdk.m m1)
    {
        n = false;
        c = false;
        d = false;
        h = false;
        i = false;
        q = new int[4];
        r = false;
        s = null;
        b = m1;
    }

    private static AdActivity.b a(String s1)
    {
        AdActivity.b b1 = AdActivity.b.c;
        if (s1.equals("landscape"))
        {
            b1 = com.appnexus.opensdk.AdActivity.b.b;
        } else
        if (s1.equals("portrait"))
        {
            return AdActivity.b.a;
        }
        return b1;
    }

    static y a(x x1)
    {
        return x1.s;
    }

    private void a(ArrayList arraylist)
    {
        Object obj;
        Iterator iterator;
        int i1;
        int j1;
        boolean flag;
        boolean flag1;
        flag1 = false;
        AdActivity.b b1 = AdActivity.b.c;
        iterator = arraylist.iterator();
        i1 = -1;
        flag = true;
        obj = null;
        j1 = -1;
        arraylist = b1;
_L2:
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_197;
        }
        obj1 = (BasicNameValuePair)iterator.next();
        if (!((BasicNameValuePair) (obj1)).getName().equals("w"))
        {
            break MISSING_BLOCK_LABEL_75;
        }
        int k1 = Integer.parseInt(((BasicNameValuePair) (obj1)).getValue());
        i1 = k1;
        continue; /* Loop/switch isn't completed */
        if (((BasicNameValuePair) (obj1)).getName().equals("h"))
        {
            DisplayMetrics displaymetrics;
            int l1;
            try
            {
                l1 = Integer.parseInt(((BasicNameValuePair) (obj1)).getValue());
            }
            catch (NumberFormatException numberformatexception)
            {
                continue; /* Loop/switch isn't completed */
            }
            j1 = l1;
            continue; /* Loop/switch isn't completed */
        } else
        {
            if (((BasicNameValuePair) (obj1)).getName().equals("useCustomClose"))
            {
                flag1 = Boolean.parseBoolean(((BasicNameValuePair) (obj1)).getValue());
            } else
            if (((BasicNameValuePair) (obj1)).getName().equals("url"))
            {
                obj = Uri.decode(((BasicNameValuePair) (obj1)).getValue());
            } else
            if (((BasicNameValuePair) (obj1)).getName().equals("allow_orientation_change"))
            {
                flag = Boolean.parseBoolean(((BasicNameValuePair) (obj1)).getValue());
            } else
            if (((BasicNameValuePair) (obj1)).getName().equals("force_orientation"))
            {
                arraylist = a(((BasicNameValuePair) (obj1)).getValue());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!com.appnexus.opensdk.b.k.a(((String) (obj))))
        {
            s = new y(b.b, this);
            (new m._cls1(s, ((String) (obj)))).execute(new Void[0]);
            b.b.a(((com.appnexus.opensdk.m) (s)).d, flag1, new m.b(flag, arraylist) {

                final boolean a;
                final AdActivity.b b;
                final x c;

                public final void a()
                {
                    if (c.j != null)
                    {
                        x.a(c);
                        y.a(c.j, a, b);
                        k.o = null;
                    }
                }

            
            {
                c = x.this;
                a = flag;
                b = b1;
                super();
            }
            });
        } else
        {
            obj = b;
            displaymetrics = new DisplayMetrics();
            ((WindowManager)((com.appnexus.opensdk.m) (obj)).getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
            obj1 = new android.widget.FrameLayout.LayoutParams(((com.appnexus.opensdk.m) (obj)).getLayoutParams());
            if (!((com.appnexus.opensdk.m) (obj)).d.d)
            {
                obj.e = ((android.widget.FrameLayout.LayoutParams) (obj1)).width;
                obj.f = ((android.widget.FrameLayout.LayoutParams) (obj1)).height;
            }
            if (j1 == -1 && i1 == -1 && ((com.appnexus.opensdk.m) (obj)).b != null)
            {
                obj.g = true;
            }
            l1 = j1;
            if (j1 != -1)
            {
                l1 = (int)((double)((float)j1 * displaymetrics.density) + 0.5D);
            }
            if (i1 != -1)
            {
                i1 = (int)((double)((float)i1 * displaymetrics.density) + 0.5D);
            }
            obj1.height = l1;
            obj1.width = i1;
            obj1.gravity = 17;
            NumberFormatException numberformatexception1;
            if (((com.appnexus.opensdk.m) (obj)).g)
            {
                arraylist = new m._cls3(((com.appnexus.opensdk.m) (obj)), this, flag, arraylist);
            } else
            {
                arraylist = null;
            }
            if (((com.appnexus.opensdk.m) (obj)).b != null)
            {
                ((com.appnexus.opensdk.m) (obj)).b.a(i1, l1, flag1, this, arraylist);
                ((com.appnexus.opensdk.m) (obj)).b.g();
            }
            ((com.appnexus.opensdk.m) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        }
        b.loadUrl("javascript:window.mraid.util.stateChangeEvent('expanded');");
        c = true;
        if (!b.b.f())
        {
            b.b.getAdDispatcher().a();
        }
        return;
        numberformatexception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(boolean flag)
    {
        if (!n)
        {
            return;
        } else
        {
            l = flag;
            b.loadUrl((new StringBuilder("javascript:window.mraid.util.setIsViewable(")).append(flag).append(")").toString());
            return;
        }
    }

    private boolean a(Intent intent)
    {
        boolean flag = false;
        if (b.getContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0)
        {
            flag = true;
        }
        return flag;
    }

    private static void b(WebView webview, String s1)
    {
        webview.loadUrl(String.format("javascript:window.mraid.util.setSupports('%s', %s)", new Object[] {
            s1, "true"
        }));
    }

    private void b(ArrayList arraylist)
    {
        Object obj = null;
        Iterator iterator = arraylist.iterator();
        arraylist = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BasicNameValuePair basicnamevaluepair = (BasicNameValuePair)iterator.next();
            if (basicnamevaluepair.getName().equals("uri"))
            {
                arraylist = Uri.decode(basicnamevaluepair.getValue());
            }
        } while (true);
        if (!com.appnexus.opensdk.b.k.a(arraylist))
        {
            b.c(arraylist);
            b.a();
        }
    }

    private void c(ArrayList arraylist)
    {
        Object obj = null;
        Iterator iterator = arraylist.iterator();
        arraylist = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BasicNameValuePair basicnamevaluepair = (BasicNameValuePair)iterator.next();
            if (basicnamevaluepair.getName().equals("uri"))
            {
                arraylist = basicnamevaluepair.getValue();
            }
        } while (true);
        if (arraylist == null)
        {
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
            return;
        } else
        {
            arraylist = Uri.decode(arraylist);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(com.appnexus.opensdk.b.l.b(b));
            builder.setTitle(an.d.store_picture_title);
            builder.setMessage(an.d.store_picture_message);
            builder.setPositiveButton(an.d.store_picture_accept, new android.content.DialogInterface.OnClickListener(arraylist) {

                final String a;
                final x b;

                public final void onClick(DialogInterface dialoginterface, int i1)
                {
                    i1 = 1;
                    if (!a.startsWith("data:")) goto _L2; else goto _L1
_L1:
                    dialoginterface = ".png";
                    Object obj1;
                    File file;
                    byte abyte0[];
                    if (a.contains("image/gif"))
                    {
                        dialoginterface = ".gif";
                    } else
                    if (a.contains("image/jpeg") || a.contains("image/pjpeg"))
                    {
                        dialoginterface = ".jpg";
                    } else
                    if (a.contains("image/png"))
                    {
                        dialoginterface = ".png";
                    } else
                    if (a.contains("image/tiff"))
                    {
                        dialoginterface = ".tif";
                    } else
                    if (a.contains("image/svg+xml"))
                    {
                        dialoginterface = ".svg";
                    }
                    Exception exception;
                    if (!a.contains("base64"))
                    {
                        i1 = 0;
                    }
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), (new StringBuilder()).append(System.currentTimeMillis()).append(dialoginterface).toString());
                    dialoginterface = null;
                    obj1 = new FileOutputStream(file);
                    dialoginterface = ((DialogInterface) (obj1));
                    if (!file.canWrite()) goto _L4; else goto _L3
_L3:
                    if (i1 != 0) goto _L6; else goto _L5
_L5:
                    dialoginterface = ((DialogInterface) (obj1));
                    abyte0 = com.appnexus.opensdk.b.f.a(a.substring(a.lastIndexOf(",") + 1, a.length()));
_L7:
                    dialoginterface = ((DialogInterface) (obj1));
                    ((FileOutputStream) (obj1)).write(abyte0);
_L4:
                    try
                    {
                        ((FileOutputStream) (obj1)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (DialogInterface dialoginterface)
                    {
                        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                    }
_L8:
                    b.b.a();
                    return;
_L6:
                    dialoginterface = ((DialogInterface) (obj1));
                    abyte0 = Base64.decode(a.substring(a.lastIndexOf(",") + 1, a.length()), 0);
                      goto _L7
                    dialoginterface;
                    obj1 = null;
_L12:
                    dialoginterface = ((DialogInterface) (obj1));
                    com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                    if (obj1 != null)
                    {
                        try
                        {
                            ((FileOutputStream) (obj1)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                        }
                    }
                      goto _L8
                    dialoginterface;
                    obj1 = null;
_L11:
                    dialoginterface = ((DialogInterface) (obj1));
                    com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                    if (obj1 != null)
                    {
                        try
                        {
                            ((FileOutputStream) (obj1)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                        }
                    }
                      goto _L8
                    dialoginterface;
                    obj1 = null;
_L10:
                    dialoginterface = ((DialogInterface) (obj1));
                    com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                    if (obj1 != null)
                    {
                        try
                        {
                            ((FileOutputStream) (obj1)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                        }
                    }
                      goto _L8
                    exception;
                    obj1 = dialoginterface;
                    dialoginterface = exception;
_L9:
                    if (obj1 != null)
                    {
                        try
                        {
                            ((FileOutputStream) (obj1)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                        }
                    }
                    throw dialoginterface;
_L2:
                    dialoginterface = (DownloadManager)b.b.getContext().getSystemService("download");
                    obj1 = new android.app.DownloadManager.Request(Uri.parse(a));
                    if (b.b.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", b.b.getContext().getPackageName()) != 0)
                    {
                        break MISSING_BLOCK_LABEL_579;
                    }
                    ((android.app.DownloadManager.Request) (obj1)).setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, a.split("/")[a.split("/").length - 1]);
                    ((android.app.DownloadManager.Request) (obj1)).allowScanningByMediaScanner();
                    ((android.app.DownloadManager.Request) (obj1)).setNotificationVisibility(1);
                    dialoginterface.enqueue(((android.app.DownloadManager.Request) (obj1)));
                      goto _L8
                    dialoginterface;
                    com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.store_picture_error));
                      goto _L8
                    exception;
                    obj1 = dialoginterface;
                    dialoginterface = exception;
                      goto _L9
                    dialoginterface;
                      goto _L10
                    dialoginterface;
                      goto _L11
                    dialoginterface;
                      goto _L12
                }

            
            {
                b = x.this;
                a = s1;
                super();
            }
            });
            builder.setNegativeButton(an.d.store_picture_decline, new android.content.DialogInterface.OnClickListener() {

                final x a;

                public final void onClick(DialogInterface dialoginterface, int i1)
                {
                }

            
            {
                a = x.this;
                super();
            }
            });
            builder.create().show();
            return;
        }
    }

    private void d(ArrayList arraylist)
    {
        Object obj = null;
        Iterator iterator = arraylist.iterator();
        arraylist = ((ArrayList) (obj));
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (BasicNameValuePair)iterator.next();
            if (((BasicNameValuePair) (obj)).getName().equals("uri"))
            {
                arraylist = ((BasicNameValuePair) (obj)).getValue();
            }
        } while (true);
        if (arraylist == null)
        {
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.play_vide_no_uri));
            return;
        }
        obj = new Intent("android.intent.action.VIEW");
        ((Intent) (obj)).setFlags(0x10000000);
        try
        {
            ((Intent) (obj)).setDataAndType(Uri.parse(URLDecoder.decode(arraylist, "UTF-8")), "video/mp4");
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.unsupported_encoding));
            return;
        }
        try
        {
            b.getContext().startActivity(((Intent) (obj)));
            b.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            return;
        }
    }

    private void e(ArrayList arraylist)
    {
        Object obj;
        int i1;
label0:
        {
            i1 = 1;
            obj = AdActivity.b.c;
            Iterator iterator = arraylist.iterator();
            arraylist = ((ArrayList) (obj));
            boolean flag = true;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (BasicNameValuePair)iterator.next();
                if (((BasicNameValuePair) (obj)).getName().equals("allow_orientation_change"))
                {
                    flag = Boolean.parseBoolean(((BasicNameValuePair) (obj)).getValue());
                } else
                if (((BasicNameValuePair) (obj)).getName().equals("force_orientation"))
                {
                    arraylist = a(((BasicNameValuePair) (obj)).getValue());
                }
            } while (true);
            if (c)
            {
                if (b.g)
                {
                    obj = j;
                } else
                {
                    obj = (Activity)com.appnexus.opensdk.b.l.b(b);
                }
                if (!flag)
                {
                    break label0;
                }
                com.appnexus.opensdk.AdActivity.b(((Activity) (obj)));
            }
            return;
        }
        static final class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[AdActivity.b.values().length];
                try
                {
                    a[com.appnexus.opensdk.AdActivity.b.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AdActivity.b.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AdActivity.b.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4.a[arraylist.ordinal()];
        JVM INSTR tableswitch 1 2: default 160
    //                   1 170
    //                   2 163;
           goto _L1 _L2 _L3
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = 0;
_L5:
        AdActivity.a(((Activity) (obj)), i1);
        return;
_L2:
        i1 = 2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void f(ArrayList arraylist)
    {
        Object obj1;
        int i1;
        int j1;
        int k1;
        int l1;
        boolean flag;
        i1 = 0;
        l1 = -1;
        String s1 = "top-right";
        obj1 = arraylist.iterator();
        flag = true;
        j1 = 0;
        k1 = -1;
        arraylist = s1;
_L2:
        Object obj;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_203;
        }
        obj = (BasicNameValuePair)((Iterator) (obj1)).next();
        if (((BasicNameValuePair) (obj)).getName().equals("w"))
        {
            k1 = Integer.parseInt(((BasicNameValuePair) (obj)).getValue());
            continue; /* Loop/switch isn't completed */
        }
        if (((BasicNameValuePair) (obj)).getName().equals("h"))
        {
            l1 = Integer.parseInt(((BasicNameValuePair) (obj)).getValue());
            continue; /* Loop/switch isn't completed */
        }
        if (((BasicNameValuePair) (obj)).getName().equals("offset_x"))
        {
            j1 = Integer.parseInt(((BasicNameValuePair) (obj)).getValue());
            continue; /* Loop/switch isn't completed */
        }
        try
        {
label0:
            {
                if (!((BasicNameValuePair) (obj)).getName().equals("offset_y"))
                {
                    break label0;
                }
                i1 = Integer.parseInt(((BasicNameValuePair) (obj)).getValue());
            }
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.number_format));
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (((BasicNameValuePair) (obj)).getName().equals("custom_close_position"))
        {
            arraylist = ((BasicNameValuePair) (obj)).getValue();
            continue; /* Loop/switch isn't completed */
        }
        if (((BasicNameValuePair) (obj)).getName().equals("allow_offscreen"))
        {
            flag = Boolean.parseBoolean(((BasicNameValuePair) (obj)).getValue());
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (k1 > o && l1 > p)
        {
            b.loadUrl("javascript:mraid.util.errorEvent('Resize called with resizeProperties larger than the screen.', 'mraid.resize()')");
            return;
        }
        obj = com.appnexus.opensdk.a.b;
        obj1 = a.valueOf(arraylist.replace('-', '_'));
        obj = obj1;
_L4:
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.resize, k1, l1, j1, i1, arraylist, flag));
        arraylist = b;
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)arraylist.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(arraylist.getLayoutParams());
        if (!((com.appnexus.opensdk.m) (arraylist)).d.d)
        {
            arraylist.e = layoutparams.width;
            arraylist.f = layoutparams.height;
        }
        i1 = (int)((double)((float)l1 * displaymetrics.density) + 0.5D);
        j1 = (int)((double)((float)k1 * displaymetrics.density) + 0.5D);
        layoutparams.height = i1;
        layoutparams.width = j1;
        layoutparams.gravity = 17;
        if (((com.appnexus.opensdk.m) (arraylist)).b != null)
        {
            ((com.appnexus.opensdk.m) (arraylist)).b.a(j1, i1, ((a) (obj)), ((com.appnexus.opensdk.m) (arraylist)).d);
        }
        if (((com.appnexus.opensdk.m) (arraylist)).b != null)
        {
            ((com.appnexus.opensdk.m) (arraylist)).b.g();
        }
        arraylist.setLayoutParams(layoutparams);
        b.a();
        b.loadUrl("javascript:window.mraid.util.stateChangeEvent('resized');");
        d = true;
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void a()
    {
        if (c || d || r)
        {
            Object obj = new android.widget.FrameLayout.LayoutParams(b.getLayoutParams());
            obj.height = f;
            obj.width = e;
            if (b.b.getMediaType().equals(z.a))
            {
                obj.gravity = g;
            } else
            {
                obj.gravity = 17;
            }
            b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            b.h();
            b.loadUrl("javascript:window.mraid.util.stateChangeEvent('default');");
            if (!b.b.f() && !r)
            {
                b.b.getAdDispatcher().b();
            }
            obj = (Activity)b.getContext();
            if (obj != null)
            {
                ((Activity) (obj)).setRequestedOrientation(-1);
            }
            c = false;
            d = false;
            s = null;
        } else
        {
            com.appnexus.opensdk.m m1 = b;
            if (m1.b != null)
            {
                m1.b.c();
                return;
            }
        }
    }

    final void a(int i1, int j1, int k1, int l1)
    {
        if (q[0] == i1 && q[1] == j1 && q[2] == k1 && q[3] == l1)
        {
            return;
        } else
        {
            q[0] = i1;
            q[1] = j1;
            q[2] = k1;
            q[3] = l1;
            Activity activity = (Activity)b.getContext();
            int i2 = activity.getWindow().findViewById(0x1020002).getTop();
            int ai[] = new int[4];
            ai[0] = i1;
            ai[1] = j1 - i2;
            ai[2] = k1;
            ai[3] = l1;
            com.appnexus.opensdk.b.l.a(activity, ai);
            i1 = ai[0];
            j1 = ai[1];
            k1 = ai[2];
            l1 = ai[3];
            b.loadUrl(String.format("javascript:window.mraid.util.setCurrentPosition(%d, %d, %d, %d)", new Object[] {
                Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1)
            }));
            b.loadUrl(String.format("javascript:window.mraid.util.sizeChangeEvent(%d, %d)", new Object[] {
                Integer.valueOf(k1), Integer.valueOf(l1)
            }));
            return;
        }
    }

    final void a(WebView webview, String s1)
    {
        if (n) goto _L2; else goto _L1
_L1:
        Object obj;
        int ai[];
        int ai1[];
        int i1;
        int j1;
        if (b.b.e())
        {
            obj = "inline";
        } else
        {
            obj = "interstitial";
        }
        r = s1.equals(a[com.appnexus.opensdk.b.b.ordinal()]);
        b.g = r;
        webview.loadUrl((new StringBuilder("javascript:window.mraid.util.setPlacementType('")).append(((String) (obj))).append("')").toString());
        if (r) goto _L4; else goto _L3
_L3:
        if (a(new Intent("android.intent.action.VIEW", Uri.parse("sms:5555555555"))))
        {
            b(webview, "sms");
        }
        if (a(new Intent("android.intent.action.VIEW", Uri.parse("tel:5555555555"))))
        {
            b(webview, "tel");
        }
        if (android.os.Build.VERSION.SDK_INT < 14) goto _L6; else goto _L5
_L5:
        if (!a((new Intent("android.intent.action.EDIT")).setData(android.provider.CalendarContract.Events.CONTENT_URI))) goto _L8; else goto _L7
_L7:
        b(webview, "calendar");
        i = true;
_L6:
        if (b.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", b.getContext().getPackageName()) == 0 && android.os.Build.VERSION.SDK_INT >= 11)
        {
            b(webview, "storePicture");
            h = true;
        }
        b(webview, "inlineVideo");
        c();
        b();
        if (n)
        {
            obj = (Activity)b.getContext();
            ai = new int[2];
            b.getLocationOnScreen(ai);
            i1 = ((Activity) (obj)).getWindow().findViewById(0x1020002).getTop();
            ai[1] = ai[1] - i1;
            b.measure(0, 0);
            i1 = b.getMeasuredWidth();
            j1 = b.getMeasuredHeight();
            ai1 = new int[2];
            ai1[0] = i1;
            ai1[1] = j1;
            com.appnexus.opensdk.b.l.a(((Activity) (obj)), ai1);
            b.loadUrl(String.format("javascript:window.mraid.util.setDefaultPosition(%d, %d, %d, %d)", new Object[] {
                Integer.valueOf(ai[0]), Integer.valueOf(ai[1]), Integer.valueOf(ai1[0]), Integer.valueOf(ai1[1])
            }));
        }
_L4:
        b.i();
        webview.loadUrl((new StringBuilder("javascript:window.mraid.util.stateChangeEvent('")).append(s1).append("')").toString());
        webview.loadUrl("javascript:window.mraid.util.readyEvent();");
        e = b.getLayoutParams().width;
        f = b.getLayoutParams().height;
        if (b.b.getMediaType().equals(z.a))
        {
            g = ((android.widget.FrameLayout.LayoutParams)b.getLayoutParams()).gravity;
        }
        n = true;
        a(b.j());
_L2:
        return;
_L8:
        if (a((new Intent("android.intent.action.EDIT")).setType("vnd.android.cursor.item/event")))
        {
            b(webview, "calendar");
            i = true;
            m.j = true;
        }
        if (true) goto _L6; else goto _L9
_L9:
    }

    final void a(String s1, boolean flag)
    {
        ArrayList arraylist;
        String s2;
        s1 = s1.replaceFirst("mraid://", "");
        String as[] = s1.split("\\?");
        s2 = as[0].replaceAll("/", "");
        arraylist = new ArrayList();
        if (as.length > 1)
        {
            String as1[] = s1.substring(s1.indexOf("?") + 1).split("&");
            int j1 = as1.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                String as2[] = as1[i1].split("=");
                if (as2.length >= 2 && !com.appnexus.opensdk.b.k.a(as2[1]) && !"undefined".equals(as2[1]))
                {
                    arraylist.add(new BasicNameValuePair(as2[0], as2[1]));
                }
            }

        }
        if (!s2.equals("expand")) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        a(arraylist);
_L6:
        return;
_L4:
        com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
        return;
_L2:
        if (s2.equals("close"))
        {
            a();
            return;
        }
        if (s2.equals("resize"))
        {
            if (flag)
            {
                f(arraylist);
                return;
            } else
            {
                com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
                return;
            }
        }
        if (s2.equals("setOrientationProperties"))
        {
            e(arraylist);
            return;
        }
        if (i && s2.equals("createCalendarEvent"))
        {
            if (flag)
            {
                s1 = null;
                try
                {
                    if (arraylist.size() > 0)
                    {
                        s1 = com.appnexus.opensdk.b.m.a(URLDecoder.decode(((BasicNameValuePair)arraylist.get(0)).getValue(), "UTF-8"));
                    }
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    return;
                }
                if (s1 != null)
                {
                    try
                    {
                        s1 = s1.a();
                        s1.setFlags(0x10000000);
                        b.getContext().startActivity(s1);
                        b.a();
                        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.create_calendar_event));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s1)
                    {
                        return;
                    }
                }
            } else
            {
                com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
                return;
            }
        }
        while (false) 
        {
            if (s2.equals("playVideo"))
            {
                if (flag)
                {
                    d(arraylist);
                    return;
                } else
                {
                    com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
                    return;
                }
            }
            if (h && s2.equals("storePicture"))
            {
                if (flag)
                {
                    c(arraylist);
                    return;
                } else
                {
                    com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
                    return;
                }
            }
            if (s2.equals("open"))
            {
                if (flag)
                {
                    b(arraylist);
                    return;
                } else
                {
                    com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
                    return;
                }
            }
            if (!s2.equals("enable"))
            {
                com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.i, com.appnexus.opensdk.b.b.a(an.d.unsupported_mraid, s2));
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    final void b()
    {
        if (b.getContext() instanceof Activity)
        {
            Activity activity = (Activity)b.getContext();
            int ai[] = com.appnexus.opensdk.b.l.a(activity);
            int i1 = ai[0];
            int j1 = ai[1];
            int k1 = activity.getWindow().findViewById(0x1020002).getTop();
            float f1 = activity.getResources().getDisplayMetrics().density;
            j1 = (int)((float)(j1 - k1) / f1 + 0.5F);
            i1 = (int)((float)i1 / f1 + 0.5F);
            b.loadUrl((new StringBuilder("javascript:window.mraid.util.setMaxSize(")).append(i1).append(", ").append(j1).append(")").toString());
        }
    }

    final void c()
    {
        if (b.getContext() instanceof Activity)
        {
            Activity activity = (Activity)b.getContext();
            int ai[] = com.appnexus.opensdk.b.l.a(activity);
            com.appnexus.opensdk.b.l.a(activity, ai);
            o = ai[0];
            p = ai[1];
            b.loadUrl((new StringBuilder("javascript:window.mraid.util.setScreenSize(")).append(o).append(", ").append(p).append(")").toString());
        }
    }

    final void d()
    {
        boolean flag = b.j();
        if (l != flag)
        {
            a(flag);
        }
    }

}
