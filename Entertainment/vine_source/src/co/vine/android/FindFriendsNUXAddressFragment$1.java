// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;


// Referenced classes of package co.vine.android:
//            FindFriendsNUXAddressFragment

class this._cls0
    implements Runnable
{

    final FindFriendsNUXAddressFragment this$0;

    public void run()
    {
        if (!FindFriendsNUXAddressFragment.access$100(FindFriendsNUXAddressFragment.this))
        {
            initLoader(1);
            FindFriendsNUXAddressFragment.access$102(FindFriendsNUXAddressFragment.this, true);
            return;
        } else
        {
            restartLoader(1);
            return;
        }
    }

    ()
    {
        this$0 = FindFriendsNUXAddressFragment.this;
        super();
    }
}
