// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV11, AppCompatDelegateImplV7, AppCompatCallback, ActionBar

public abstract class AppCompatDelegate
{

    static final String TAG = "AppCompatDelegate";

    AppCompatDelegate()
    {
    }

    public static AppCompatDelegate create(Activity activity, AppCompatCallback appcompatcallback)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return new AppCompatDelegateImplV11(activity, activity.getWindow(), appcompatcallback);
        } else
        {
            return new AppCompatDelegateImplV7(activity, activity.getWindow(), appcompatcallback);
        }
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback appcompatcallback)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return new AppCompatDelegateImplV11(dialog.getContext(), dialog.getWindow(), appcompatcallback);
        } else
        {
            return new AppCompatDelegateImplV7(dialog.getContext(), dialog.getWindow(), appcompatcallback);
        }
    }

    public abstract void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract View createView(View view, String s, Context context, AttributeSet attributeset);

    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charsequence);

    public abstract ActionMode startSupportActionMode(android.support.v7.view.ActionMode.Callback callback);
}
