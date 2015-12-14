// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.Intent;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            v

final class a
    implements Runnable
{

    private Intent a;
    private v b;

    public final void run()
    {
        v.a(b, a);
    }

    (v v1, Intent intent)
    {
        b = v1;
        a = intent;
        super();
    }
}
