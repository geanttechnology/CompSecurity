// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.LayoutInflater;

// Referenced classes of package android.support.v4.view:
//            ae, ag

class ab
{

    ab()
    {
    }

    public void a(LayoutInflater layoutinflater, ag ag)
    {
        if (ag != null)
        {
            ag = new ae(ag);
        } else
        {
            ag = null;
        }
        layoutinflater.setFactory(ag);
    }
}
