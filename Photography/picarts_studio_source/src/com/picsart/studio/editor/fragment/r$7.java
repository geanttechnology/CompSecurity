// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.SharedPreferences;
import android.widget.ImageButton;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            r

final class a
    implements Runnable
{

    private ImageButton a;
    private r b;

    public final void run()
    {
        r.b(b, a);
        r.d(b).edit().putString(e.a().e.a, "1").apply();
    }

    r(r r1, ImageButton imagebutton)
    {
        b = r1;
        a = imagebutton;
        super();
    }
}
