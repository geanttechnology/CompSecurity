// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.provider.VineDatabaseHelper;

// Referenced classes of package co.vine.android:
//            UserSearchFragment

class this._cls0
    implements Runnable
{

    final UserSearchFragment this$0;

    public void run()
    {
        mDbHelper.cleanUserSearchResults();
    }

    Helper()
    {
        this$0 = UserSearchFragment.this;
        super();
    }
}
