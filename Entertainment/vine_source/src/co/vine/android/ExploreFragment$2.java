// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.view.View;

// Referenced classes of package co.vine.android:
//            ExploreFragment, SearchActivity

class this._cls0
    implements android.view.er
{

    final ExploreFragment this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(getActivity(), co/vine/android/SearchActivity));
    }

    ()
    {
        this$0 = ExploreFragment.this;
        super();
    }
}
