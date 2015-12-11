// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import co.vine.android.client.AppSessionListener;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            ConversationFragment, ConversationAdapter

private class <init> extends AppSessionListener
{

    final ConversationFragment this$0;

    public void onGetConversationComplete(String s, int i, String s1, long l, int j, boolean flag)
    {
        if (removeRequest(s) != null && l == ConversationFragment.access$700(ConversationFragment.this))
        {
            hideProgress(3);
            if (flag)
            {
                showSadface(true, false);
            } else
            {
                showSadface(false);
            }
            s = (ConversationAdapter)mCursorAdapter;
            if (ConversationFragment.access$1300(ConversationFragment.this) && (s.atLastPage() || flag || s.isEmpty()))
            {
                ConversationFragment.access$1400(ConversationFragment.this).setVisibility(8);
            }
            if (j == 4)
            {
                ConversationFragment.access$1400(ConversationFragment.this).setVisibility(0);
            }
        }
    }

    public void onGetConversationRemoteIdComplete(long l)
    {
        ConversationFragment.access$1502(ConversationFragment.this, l);
        if (l <= 0L)
        {
            ConversationFragment.access$1400(ConversationFragment.this).setVisibility(8);
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        ((ConversationAdapter)mCursorAdapter).setImages(hashmap);
    }

    public void onVideoPathObtained(HashMap hashmap)
    {
        ((ConversationAdapter)mCursorAdapter).onVideoPathObtained(hashmap);
    }

    private ()
    {
        this$0 = ConversationFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
