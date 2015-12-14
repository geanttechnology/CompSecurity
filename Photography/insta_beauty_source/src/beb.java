// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewGroup;
import java.util.Observable;

public abstract class beb extends Observable
{

    private int a;

    public beb()
    {
        a = 0;
    }

    public abstract int a();

    public abstract View a(View view, ViewGroup viewgroup, int i);

    public int b()
    {
        return a;
    }

    public void c()
    {
        a = 0;
        notifyObservers();
    }

    public boolean hasChanged()
    {
        return true;
    }
}
