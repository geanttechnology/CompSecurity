// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.LayoutInflater;

// Referenced classes of package android.support.v4.view:
//            o

class n
{

    static void a(LayoutInflater layoutinflater, o o)
    {
        if (o != null)
        {
            o = new m.a(o);
        } else
        {
            o = null;
        }
        layoutinflater.setFactory2(o);
    }
}
