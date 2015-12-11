// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.View;

// Referenced classes of package android.support.v7:
//            ui, uj

public class uh
{

    public static void a(View view, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        (new ui(view, ongloballayoutlistener)).a();
    }

    public static void a(View view, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
    {
        (new uj(view, onscrollchangedlistener)).a();
    }
}
