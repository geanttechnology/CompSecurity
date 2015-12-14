// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.view.View;
import com.bumptech.glide.request.d;

final class h
    implements d
{

    private int a;
    private View b;

    public h(int i, View view)
    {
        a = i;
        b = view;
    }

    public final boolean a(Object obj)
    {
        b.getLayoutParams().width = a;
        b.getLayoutParams().height = a;
        return false;
    }
}
