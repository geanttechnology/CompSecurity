// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.client.AppSessionListener;

// Referenced classes of package co.vine.android:
//            FindFriendsNUXActivity, StartActivity

private class <init> extends AppSessionListener
{

    final FindFriendsNUXActivity this$0;

    public void onBulkFollowComplete(String s, int i, String s1)
    {
        dismissDialog();
        StartActivity.toStart(FindFriendsNUXActivity.this, true);
        finish();
    }

    private ()
    {
        this$0 = FindFriendsNUXActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
