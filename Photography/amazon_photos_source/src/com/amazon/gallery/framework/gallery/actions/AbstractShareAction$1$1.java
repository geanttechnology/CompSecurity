// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.amazon.gallery.foundation.utils.async.CancellableBlockingProgressDialog;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            AbstractShareAction, PrepareMediaItemsHelper, PostShareAction

class this._cls1
    implements ProgressNotifier
{

    final blishProgress this$1;

    public void update(int i, int j)
    {
        blishProgress(new Integer[] {
            Integer.valueOf(i)
        });
    }

    Dialog()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/gallery/actions/AbstractShareAction$1

/* anonymous class */
    class AbstractShareAction._cls1 extends CancellableBlockingProgressDialog
    {

        final AbstractShareAction this$0;
        final Intent val$shareIntent;
        final List val$shareList;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((MediaItem[])aobj);
        }

        protected transient Void doInBackground(MediaItem amediaitem[])
        {
            prepareHelper.setProgressNotifier(new AbstractShareAction._cls1._cls1());
            amediaitem = amediaitem[0];
            if (amediaitem.getType() != MediaType.VIDEO || !MediaItemUtil.isCloudMediaItem(amediaitem)) goto _L2; else goto _L1
_L1:
            prepareHelper.setUriPreference(PrepareMediaItemsHelper.UriPreference.CLOUD);
            amediaitem = prepareHelper.prepareItems(shareList);
            if (!amediaitem.isEmpty())
            {
                shareIntent.putExtra("android.intent.extra.TEXT", ((Uri)amediaitem.get(0)).toString());
            }
_L4:
            return null;
_L2:
            prepareHelper.setUriPreference(PrepareMediaItemsHelper.UriPreference.FILE);
            amediaitem = prepareHelper.prepareItems(shareList);
            if (amediaitem.size() == 1)
            {
                shareIntent.putExtra("android.intent.extra.STREAM", (Parcelable)amediaitem.get(0));
            } else
            if (!amediaitem.isEmpty())
            {
                shareIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", amediaitem);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if (!shareIntent.hasExtra("android.intent.extra.STREAM") && !shareIntent.hasExtra("android.intent.extra.TEXT"))
            {
                break MISSING_BLOCK_LABEL_121;
            }
            GlobalMessagingBus.post(new ActionCompleteEvent());
            startActivity(shareIntent);
            if (AbstractShareAction.access$100(AbstractShareAction.this) != null)
            {
                AbstractShareAction.access$100(AbstractShareAction.this).onShareSuccess();
            }
            trackEvent(shareList);
_L2:
            return;
            void1;
            GLogger.w(AbstractShareAction.access$200(), "Target activity not found, do nothing", new Object[0]);
            if (AbstractShareAction.access$100(AbstractShareAction.this) == null) goto _L2; else goto _L1
_L1:
            AbstractShareAction.access$100(AbstractShareAction.this).onShareFailed(void1);
            return;
            GLogger.e(AbstractShareAction.access$200(), "Tried to share, but intent didn't fire.", new Object[0]);
            return;
        }


            
            {
                this$0 = final_abstractshareaction;
                shareList = list;
                shareIntent = intent;
                super(final_context, I.this);
            }
    }

}
