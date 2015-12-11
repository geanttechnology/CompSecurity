// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.tasks.GetImojiImageTask;
import com.bitstrips.imoji.ui.views.ImojiView;
import java.io.File;

// Referenced classes of package com.bitstrips.imoji.ui:
//            InviteActivity, ImageLoader

class ager extends GetImojiImageTask
{

    final InviteActivity this$0;
    final Activity val$activity;
    final Imoji val$imojiToShare;
    final ImojiView val$imojiView;

    protected void onPostExecute(File file)
    {
        ((istener.ImojiClickListener)val$activity).onClick(file, val$imojiToShare, val$imojiView.getId());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((File)obj);
    }

    ager(Activity activity2, Imoji imoji, ImojiView imojiview)
    {
        this$0 = final_inviteactivity;
        val$activity = activity2;
        val$imojiToShare = imoji;
        val$imojiView = imojiview;
        super(final_activity1, final_imageloader, TemplatesManager.this);
    }
}
