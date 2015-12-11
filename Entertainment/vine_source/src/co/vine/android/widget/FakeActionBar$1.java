// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package co.vine.android.widget:
//            FakeActionBar

class val.item
    implements android.view.ener
{

    final FakeActionBar this$0;
    final MenuItem val$item;

    public void onClick(View view)
    {
        FakeActionBar.access$000(FakeActionBar.this).onOptionsItemSelected(val$item);
    }

    y()
    {
        this$0 = final_fakeactionbar;
        val$item = MenuItem.this;
        super();
    }
}
