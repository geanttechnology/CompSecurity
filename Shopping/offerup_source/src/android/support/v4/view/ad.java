// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.LayoutInflater;

// Referenced classes of package android.support.v4.view:
//            ac, af, ag

final class ad extends ac
{

    ad()
    {
    }

    public final void a(LayoutInflater layoutinflater, ag ag)
    {
        if (ag != null)
        {
            ag = new af(ag);
        } else
        {
            ag = null;
        }
        layoutinflater.setFactory2(ag);
    }
}
