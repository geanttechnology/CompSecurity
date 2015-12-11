// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

public class kc extends ActionBarDrawerToggle
{

    public kc(Activity activity, DrawerLayout drawerlayout, int i, int j, int k)
    {
        super(activity, drawerlayout, i, j, k);
    }

    public void onDrawerSlide(View view, float f)
    {
        super.onDrawerSlide(view, 0.0F);
    }
}
