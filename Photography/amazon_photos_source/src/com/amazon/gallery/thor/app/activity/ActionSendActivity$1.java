// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.net.Uri;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ActionSendActivity

class val.uris extends Thread
{

    final ActionSendActivity this$0;
    final List val$uris;

    public void run()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = val$uris.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (Uri)iterator.next();
            obj = ActionSendActivity.access$000(ActionSendActivity.this, ((Uri) (obj)));
            if (obj != null && ((MediaItem) (obj)).getLocalPath() != null)
            {
                arraylist.add(obj);
            }
        } while (true);
        ActionSendActivity.access$100(ActionSendActivity.this, arraylist);
    }

    ()
    {
        this$0 = final_actionsendactivity;
        val$uris = List.this;
        super();
    }
}
