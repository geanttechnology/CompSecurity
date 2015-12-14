// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

class apk
    implements android.view.View.OnClickListener
{

    final aph a;
    final api b;

    apk(api api1, aph aph1)
    {
        b = api1;
        a = aph1;
        super();
    }

    public void onClick(View view)
    {
        api.b(b).onClick(a, -2);
        a.hide();
    }
}
