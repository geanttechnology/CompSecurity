// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;


// Referenced classes of package android.support.v7.app:
//            ActionBarActivityDelegate, ActionBar

private class <init>
    implements android.support.v4.app.<init>, <init>
{

    final ActionBarActivityDelegate this$0;

    public void setActionBarDescription(int i)
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            actionbar.setHomeActionContentDescription(i);
        }
    }

    private ()
    {
        this$0 = ActionBarActivityDelegate.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
