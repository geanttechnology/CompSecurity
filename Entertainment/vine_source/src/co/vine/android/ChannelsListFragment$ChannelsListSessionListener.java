// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.client.AppSessionListener;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            ChannelsListFragment

public class this._cls0 extends AppSessionListener
{

    final ChannelsListFragment this$0;

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        ((this._cls0)mCursorAdapter).ages(hashmap);
    }

    public ()
    {
        this$0 = ChannelsListFragment.this;
        super();
    }
}
