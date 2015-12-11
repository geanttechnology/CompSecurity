// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import com.c.a.b.a.a;
import com.c.a.b.a.d;
import com.c.a.b.a.f;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.a.x;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.pianoandroid.utils:
//            j

public class s
    implements d
{

    private static final String a = com/smule/pianoandroid/utils/s.getName();
    private static f b;
    private static s g = null;
    private Boolean c;
    private Boolean d;
    private Bitmap e;
    private Context f;
    private Observer h;
    private AtomicBoolean i;

    public s()
    {
        e = null;
        i = new AtomicBoolean(false);
    }

    public static s a()
    {
        if (g == null)
        {
            g = new s();
        }
        return g;
    }

    static AtomicBoolean a(s s1)
    {
        return s1.i;
    }

    static void a(s s1, Boolean boolean1)
    {
        s1.a(boolean1);
    }

    private void a(Boolean boolean1)
    {
        android.content.SharedPreferences.Editor editor = f.getSharedPreferences("magic_piano_prefs", 0).edit();
        editor.putBoolean("PREF_NEEDS_IMAGE_DOWNLOAD", boolean1.booleanValue());
        p.a(editor);
        c = boolean1;
    }

    private Boolean b(Bitmap bitmap)
    {
        Object obj;
        Boolean boolean1;
        e = bitmap;
        boolean1 = Boolean.valueOf(false);
        obj = null;
        FileOutputStream fileoutputstream = new FileOutputStream(new File(b(f)));
        obj = fileoutputstream;
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 70, fileoutputstream);
        bitmap = boolean1;
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj = fileoutputstream;
        fileoutputstream.flush();
        bitmap = Boolean.valueOf(true);
        Exception exception;
        try
        {
            fileoutputstream.close();
        }
        catch (Throwable throwable)
        {
            return bitmap;
        }
        return bitmap;
        exception;
        bitmap = null;
_L4:
        obj = bitmap;
        exception.printStackTrace();
        try
        {
            bitmap.close();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return boolean1;
        }
        return boolean1;
        bitmap;
_L2:
        try
        {
            ((FileOutputStream) (obj)).close();
        }
        catch (Throwable throwable1) { }
        throw bitmap;
        bitmap;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        bitmap = fileoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String b(Context context)
    {
        return (new StringBuilder()).append(context.getFilesDir()).append(File.separator).append("profile.png").toString();
    }

    static void b(s s1, Boolean boolean1)
    {
        s1.b(boolean1);
    }

    private void b(Boolean boolean1)
    {
        android.content.SharedPreferences.Editor editor = f.getSharedPreferences("magic_piano_prefs", 0).edit();
        editor.putBoolean("PREF_NEEDS_IMAGE_UPLOAD", boolean1.booleanValue());
        p.a(editor);
        d = boolean1;
    }

    private void c()
    {
        SharedPreferences sharedpreferences = f.getSharedPreferences("magic_piano_prefs", 0);
        c = Boolean.valueOf(sharedpreferences.getBoolean("PREF_NEEDS_IMAGE_DOWNLOAD", false));
        d = Boolean.valueOf(sharedpreferences.getBoolean("PREF_NEEDS_IMAGE_UPLOAD", false));
    }

    private void c(Bitmap bitmap)
    {
        if (i.getAndSet(true))
        {
            return;
        } else
        {
            com.smule.android.network.core.b.a(new Runnable(bitmap) {

                final Bitmap a;
                final s b;

                public void run()
                {
                    o o1 = x.a(a);
                    if (o1 == null) goto _L2; else goto _L1
_L1:
                    if (!o1.a() || o1.j == null) goto _L2; else goto _L3
_L3:
                    UserManager.n().a(o1);
                    com.smule.pianoandroid.utils.s.b(b, Boolean.valueOf(false));
_L5:
                    com.smule.pianoandroid.utils.s.a(b).set(false);
                    return;
_L2:
                    com.smule.android.f.h.a().a("IMAGE_UPLOAD_ERROR", null);
                    if (true) goto _L5; else goto _L4
_L4:
                    Object obj;
                    obj;
                    com.smule.android.f.h.a().a("IMAGE_UPLOAD_ERROR", null);
                    com.smule.pianoandroid.utils.s.a(b).set(false);
                    return;
                    obj;
                    com.smule.pianoandroid.utils.s.a(b).set(false);
                    throw obj;
                }

            
            {
                b = s.this;
                a = bitmap;
                super();
            }
            });
            return;
        }
    }

    public void a(Context context)
    {
        f = context;
        b = new f(com.smule.pianoandroid.utils.j.a(45, f), com.smule.pianoandroid.utils.j.a(45, f));
        c();
        if (!UserManager.n().h())
        {
            h = new Observer() {

                final s a;

                public void update(Observable observable, Object obj)
                {
                    if (((String)obj).compareTo("LOGIN_TYPE_EXISTING") == 0)
                    {
                        com.smule.android.f.h.a().b("USER_LOGGED_IN_EVENT", this);
                        if (UserManager.n().d() != null)
                        {
                            com.smule.pianoandroid.utils.s.a(a, Boolean.valueOf(true));
                            com.smule.android.network.core.b.a(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    com.c.a.b.f.a().a(UserManager.n().d(), a.a);
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }
                    }
                }

            
            {
                a = s.this;
                super();
            }
            };
            com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", h);
        }
    }

    public void a(Bitmap bitmap)
    {
        b(Boolean.valueOf(true));
        b(bitmap);
        c(bitmap);
        com.smule.android.f.h.a().a("IMAGE_UPDATED", new Object[0]);
    }

    public void a(Uri uri)
    {
        b(Boolean.valueOf(true));
        uri = com.c.a.b.f.a().a(uri.toString(), b);
        b(uri);
        c(uri);
        com.smule.android.f.h.a().a("IMAGE_UPDATED", new Object[0]);
    }

    public void a(String s1, View view)
    {
    }

    public void a(String s1, View view, Bitmap bitmap)
    {
        b(bitmap);
        a(Boolean.valueOf(false));
        com.smule.android.f.h.a().b("USER_LOGGED_IN_EVENT", h);
        h = null;
        com.smule.android.f.h.a().a("IMAGE_UPDATED", new Object[0]);
    }

    public void a(String s1, View view, a a1)
    {
    }

    public Bitmap b()
    {
        if (e == null)
        {
            e = com.c.a.b.f.a().a((new StringBuilder()).append("file://").append(b(f)).toString(), b);
        }
        if (e == null)
        {
            e = BitmapFactory.decodeResource(f.getResources(), 0x7f020152);
        }
        if (c.booleanValue())
        {
            com.c.a.b.f.a().a(UserManager.n().d(), b, this);
        }
        if (d.booleanValue())
        {
            c(e);
        }
        return e;
    }

    public void b(String s1, View view)
    {
    }

}
