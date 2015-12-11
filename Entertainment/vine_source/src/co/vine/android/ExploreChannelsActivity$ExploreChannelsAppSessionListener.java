// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.text.TextUtils;
import co.vine.android.api.VineChannel;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;
import co.vine.android.util.image.UrlImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            ExploreChannelsActivity

class this._cls0 extends AppSessionListener
{

    final ExploreChannelsActivity this$0;

    public void onGetChannelsComplete(String s, int i, String s1, ArrayList arraylist)
    {
        if (i == 200 && !TextUtils.isEmpty(ExploreChannelsActivity.access$200(ExploreChannelsActivity.this)))
        {
            long l = Long.valueOf(ExploreChannelsActivity.access$200(ExploreChannelsActivity.this)).longValue();
            s1 = arraylist.iterator();
            do
            {
                if (!s1.hasNext())
                {
                    break;
                }
                s = (VineChannel)s1.next();
                if (l == ((VineChannel) (s)).channelId)
                {
                    boolean flag = Util.isHighRes(ExploreChannelsActivity.this);
                    arraylist = ExploreChannelsActivity.this;
                    if (flag)
                    {
                        s = ((VineChannel) (s)).retinaIconFullUrl;
                    } else
                    {
                        s = ((VineChannel) (s)).iconFullUrl;
                    }
                    ExploreChannelsActivity.access$300(arraylist, s);
                }
            } while (true);
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        if (!hashmap.isEmpty() && ExploreChannelsActivity.access$000(ExploreChannelsActivity.this) != null)
        {
            hashmap = (UrlImage)hashmap.get(ExploreChannelsActivity.access$000(ExploreChannelsActivity.this));
            if (hashmap != null && hashmap.isValid() && ((UrlImage) (hashmap)).bitmap != null)
            {
                ExploreChannelsActivity.access$100(ExploreChannelsActivity.this, ((UrlImage) (hashmap)).bitmap);
            }
        }
    }

    ()
    {
        this$0 = ExploreChannelsActivity.this;
        super();
    }
}
