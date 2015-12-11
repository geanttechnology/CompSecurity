// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.l;
import com.abtnprojects.ambatana.ui.fragments.a;
import java.util.ArrayList;

public class hs extends l
{

    private final ArrayList a;

    public hs(i i, ArrayList arraylist)
    {
        super(i);
        a = arraylist;
    }

    public Fragment a(int i)
    {
        return com.abtnprojects.ambatana.ui.fragments.a.a((String)a.get(i));
    }

    public int b()
    {
        if (a == null)
        {
            return 0;
        } else
        {
            return a.size();
        }
    }
}
