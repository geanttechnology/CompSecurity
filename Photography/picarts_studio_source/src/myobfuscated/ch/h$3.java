// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.view.View;
import android.widget.Spinner;

// Referenced classes of package myobfuscated.ch:
//            h

final class it>
    implements android.view..OnClickListener
{

    private Spinner a;

    public final void onClick(View view)
    {
        a.performClick();
    }

    er(Spinner spinner)
    {
        a = spinner;
        super();
    }
}
