// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.CollageLayout;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.e;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.i;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.o;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ah

class a
    implements i
{

    final a a;

    public void a()
    {
        m.e("rendering", "onCancel");
        ah.f(a.a).a();
        ah.a(a.a, null);
    }

    public void a(Bitmap bitmap)
    {
        ah.f(a.a).a();
        ah.a(a.a, bitmap);
    }

    public void a(String s)
    {
        m.e("rendering", (new StringBuilder()).append("onError: ").append(s).toString());
        ah.f(a.a).a();
        ah.a(a.a, null);
    }

    e(e e)
    {
        a = e;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ah$10

/* anonymous class */
    class ah._cls10 extends AsyncTask
    {

        final ah a;

        protected transient Boolean a(Void avoid[])
        {
            float f1 = 1.0F;
            avoid = Globals.d().e();
            float f = f1;
            if (avoid != null)
            {
                f = f1;
                if (avoid.intValue() < 0xc3500)
                {
                    f = 0.66F;
                    avoid = ah.f(a).getTemplate();
                    if (avoid != null)
                    {
                        f = 1024F / (float)((o) (avoid)).i;
                        float f2 = 1024F / (float)((o) (avoid)).j;
                        if (f >= f2)
                        {
                            f = f2;
                        }
                    }
                }
            }
            try
            {
                e.a().a(a.getActivity(), ah.f(a), f, new ah._cls10.a(this));
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                m.b("SaveMyLookDialog", "generateCollageThumb", avoid);
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(true);
        }

        protected void a(Boolean boolean1)
        {
            if (!boolean1.booleanValue())
            {
                ah.f(a).a();
                ah.a(a, null);
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Boolean)obj);
        }

            
            {
                a = ah1;
                super();
            }
    }

}
