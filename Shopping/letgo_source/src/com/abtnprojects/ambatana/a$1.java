// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.abtnprojects.ambatana:
//            a

class a
    implements android.support.v7.
{

    final a a;

    public void a()
    {
    }

    public void a(int i)
    {
        com.abtnprojects.ambatana.a.a(a, i);
        Intent intent = new Intent();
        intent.setAction(a.toString());
        intent.putExtra(a.toString(), i);
        com.abtnprojects.ambatana.a.a(a).sendBroadcast(intent);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
