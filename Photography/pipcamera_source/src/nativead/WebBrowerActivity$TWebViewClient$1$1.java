// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package nativead;


// Referenced classes of package nativead:
//            WebBrowerActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        WebBrowerActivity.e(a.a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class nativead/WebBrowerActivity$TWebViewClient$1

/* anonymous class */
    class WebBrowerActivity.TWebViewClient._cls1
        implements Runnable
    {

        final String a;
        final String b;
        final String c;
        final String d;
        final String e;
        final WebBrowerActivity.TWebViewClient f;

        public void run()
        {
            try
            {
                f.callOcFuc(a, b, c, d, e);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            f.b.runOnUiThread(new WebBrowerActivity.TWebViewClient._cls1._cls1(this));
        }

            
            {
                f = twebviewclient;
                a = s;
                b = s1;
                c = s2;
                d = s3;
                e = s4;
                super();
            }
    }

}
