// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aci
    implements android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
{

    private acd a;

    aci(acd acd1)
    {
        a = acd1;
        super();
    }

    public final void onAccessibilityStateChanged(boolean flag)
    {
        a.f.a(flag);
    }
}
