// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ti extends android.view.accessibility.CaptioningManager.CaptioningChangeListener
{

    private sz a;

    ti(sz sz1)
    {
        a = sz1;
        super();
    }

    public final void onFontScaleChanged(float f)
    {
        super.onFontScaleChanged(f);
        if (sz.a(a) != null)
        {
            sz.a(a).a(f);
        }
    }

    public final void onUserStyleChanged(android.view.accessibility.CaptioningManager.CaptionStyle captionstyle)
    {
        super.onUserStyleChanged(captionstyle);
        if (sz.a(a) != null)
        {
            sz.a(a).a(new cyi(captionstyle, sz.b(a).a()));
        }
    }
}
