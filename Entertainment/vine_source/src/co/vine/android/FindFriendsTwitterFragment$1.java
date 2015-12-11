// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;


// Referenced classes of package co.vine.android:
//            FindFriendsTwitterFragment

class this._cls0
    implements Runnable
{

    final FindFriendsTwitterFragment this$0;

    public void run()
    {
        if (!FindFriendsTwitterFragment.access$000(FindFriendsTwitterFragment.this))
        {
            initLoader(1);
            FindFriendsTwitterFragment.access$002(FindFriendsTwitterFragment.this, true);
            return;
        } else
        {
            restartLoader(1);
            return;
        }
    }

    ()
    {
        this$0 = FindFriendsTwitterFragment.this;
        super();
    }
}
