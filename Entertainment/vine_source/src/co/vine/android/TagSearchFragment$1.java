// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.provider.VineDatabaseHelper;

// Referenced classes of package co.vine.android:
//            TagSearchFragment

class this._cls0
    implements Runnable
{

    final TagSearchFragment this$0;

    public void run()
    {
        mDbHelper.cleanTagSearchResults();
    }

    eHelper()
    {
        this$0 = TagSearchFragment.this;
        super();
    }
}
