// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.k;
import com.abtnprojects.ambatana.ui.fragments.safetytips.TipFragment;

public class hy extends k
{

    public hy(i i)
    {
        super(i);
    }

    public Fragment a(int i)
    {
        if (i == 0)
        {
            return TipFragment.a(-1, 0x7f090053);
        }
        if (i == 1)
        {
            return TipFragment.a(-1, 0x7f090054);
        }
        if (i == 2)
        {
            return TipFragment.a(-1, 0x7f090055);
        } else
        {
            return null;
        }
    }

    public int b()
    {
        return 3;
    }
}
