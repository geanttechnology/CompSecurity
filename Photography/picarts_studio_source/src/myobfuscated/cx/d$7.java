// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package myobfuscated.cx:
//            d

final class it>
    implements android.widget.terView.OnItemClickListener
{

    private d a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        d.a(a, i);
    }

    erView(d d1)
    {
        a = d1;
        super();
    }
}
