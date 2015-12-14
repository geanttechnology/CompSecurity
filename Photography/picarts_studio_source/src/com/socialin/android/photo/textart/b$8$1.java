// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.widget.GridView;
import android.widget.ViewFlipper;
import com.socialin.android.d;
import com.socialin.android.photo.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.textart:
//            b, TextArtStyle, c

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        boolean flag = false;
        int i = 0;
        if (a.a.getView() != null)
        {
            Object obj = a.a.getView().findViewById(0x7f10082e);
            if (obj != null)
            {
                obj = (ViewFlipper)obj;
                if (a.a.size() == 0)
                {
                    ((ViewFlipper) (obj)).setDisplayedChild(1);
                } else
                {
                    ((ViewFlipper) (obj)).setDisplayedChild(0);
                    if (!b.k(a.a))
                    {
                        b.a(a.a, new ArrayList());
                        for (; i < a.a.size(); i++)
                        {
                            b.l(a.a).add(TextArtStyle.getPreviewStyleObj(true, (String)a.a.get(i)));
                        }

                        b.n(a.a).setAdapter(new c(a.a, a.a.getActivity(), b.l(a.a), com.socialin.android.photo.textart.b.m(a.a)));
                    } else
                    {
                        b.b(a.a, new ArrayList());
                        for (int j = ((flag) ? 1 : 0); j < a.a.size(); j++)
                        {
                            b.o(a.a).add(TextArtStyle.getPreviewStyleObj(true, (String)a.a.get(j)));
                        }

                        b.n(a.a).setAdapter(new c(a.a, a.a.getActivity(), b.o(a.a), b.p(a.a)));
                    }
                }
            }
        }
        m.b(a.a.getActivity(), b.q(a.a));
    }

    tStyle(tStyle tstyle)
    {
        a = tstyle;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/textart/b$8

/* anonymous class */
    final class b._cls8 extends Thread
    {

        final ArrayList a;
        final b b;
        private File c;

        public final void run()
        {
            if (com.socialin.android.photo.textart.b.k(b)) goto _L2; else goto _L1
_L1:
            Object obj = new ArrayList(Arrays.asList(c.listFiles()));
_L11:
            int j = ((List) (obj)).size();
            if (j > 200)
            {
                j = 200;
            }
            if (obj == null) goto _L4; else goto _L3
_L3:
            if (com.socialin.android.photo.textart.b.k(b)) goto _L6; else goto _L5
_L5:
            int i = 0;
              goto _L7
_L17:
            int k;
            if (k >= j) goto _L9; else goto _L8
_L8:
            if (((File)((List) (obj)).get(k)).lastModified() > ((File)((List) (obj)).get(i)).lastModified())
            {
                File file = (File)((List) (obj)).get(i);
                ((List) (obj)).set(i, ((List) (obj)).get(k));
                ((List) (obj)).set(k, file);
            }
              goto _L10
_L2:
            obj = f.a(c.getAbsolutePath(), b.o);
              goto _L11
_L18:
            if (i >= j) goto _L4; else goto _L12
_L12:
            boolean flag = ((File)((List) (obj)).get(i)).getName().toLowerCase().contains(".ttf");
            if (!flag) goto _L14; else goto _L13
_L13:
            Typeface typeface = Typeface.createFromFile((File)((List) (obj)).get(i));
_L15:
            if (typeface == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Exception exception1;
            try
            {
                a.add(((File)((List) (obj)).get(i)).getAbsolutePath());
                break; /* Loop/switch isn't completed */
            }
            catch (Exception exception)
            {
                d.b(com.socialin.android.photo.textart.b.d(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
            }
              goto _L4
            exception1;
            d.b(com.socialin.android.photo.textart.b.d(), new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception1.getMessage()).toString()
            });
            exception1 = null;
            if (true) goto _L15; else goto _L14
_L4:
            Activity activity = b.getActivity();
            if (activity == null || activity.isFinishing())
            {
                return;
            } else
            {
                activity.runOnUiThread(new b._cls8._cls1(this));
                return;
            }
_L7:
            if (i >= j) goto _L6; else goto _L16
_L16:
            k = i;
              goto _L17
_L10:
            k++;
              goto _L17
_L9:
            i++;
              goto _L7
_L6:
            i = 0;
              goto _L18
_L14:
            i++;
              goto _L18
        }

            
            {
                b = b1;
                c = file;
                a = arraylist;
                super();
            }
    }

}
