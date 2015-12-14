// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package nativead;


// Referenced classes of package nativead:
//            WebBrowerActivity

class e
    implements Runnable
{

    final String a;
    final String b;
    final String c;
    final String d;
    final String e;
    final f f;

    public void run()
    {
        try
        {
            f.llOcFuc(a, b, c, d, e);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        f.f.runOnUiThread(new Runnable() {

            final WebBrowerActivity.TWebViewClient._cls1 a;

            public void run()
            {
                WebBrowerActivity.e(a.f.b);
            }

            
            {
                a = WebBrowerActivity.TWebViewClient._cls1.this;
                super();
            }
        });
    }

    _cls1.a(_cls1.a a1, String s, String s1, String s2, String s3, String s4)
    {
        f = a1;
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        super();
    }
}
