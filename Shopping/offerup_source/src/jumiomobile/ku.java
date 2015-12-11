// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            kt, nu, gs, mk

class ku
    implements Runnable
{

    final kt a;

    ku(kt kt1)
    {
        a = kt1;
        super();
    }

    public void run()
    {
        kt.a(a).a(true, false);
        nu nu1 = kt.a(a);
        android.app.Activity activity = a.getActivity();
        String s;
        if (kt.b(a).w())
        {
            s = "infobar_extraction_in_progress";
        } else
        {
            s = "infobar_processing_image";
        }
        nu1.setText(mk.a(activity, s));
        kt.a(a).setShowLoading(true);
        kt.a(a).a(false);
        kt.a(a).setShowHelpButton(false);
    }
}
