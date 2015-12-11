// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.models.Templates;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Provider;

public class ImojisPreloader
{
    public static interface FinishCallback
    {

        public abstract void onImojisPreloaderFinish();
    }


    private static int batchSize = 2;
    private static Object staticLock = new Object();
    B4MService b4MService;
    List imojiBatch;
    List imojiQueue;
    FinishCallback onFinish;
    Provider picassoProvider;
    PreferenceUtils preferenceUtils;
    TemplatesManager templatesManager;

    public ImojisPreloader()
    {
    }

    private void loadNextBatchFromQueue()
    {
label0:
        {
            synchronized (staticLock)
            {
                if (imojiQueue.size() != 0)
                {
                    break label0;
                }
                if (onFinish != null)
                {
                    onFinish.onImojisPreloaderFinish();
                    onFinish = null;
                }
            }
            return;
        }
        List list = imojiQueue;
        if (imojiQueue.size() >= batchSize) goto _L2; else goto _L1
_L1:
        int i = imojiQueue.size();
_L7:
        String s;
        imojiBatch = new ArrayList(list.subList(0, i));
        Collections.reverse(imojiBatch);
        imojiQueue = new ArrayList(imojiQueue.subList(imojiBatch.size(), imojiQueue.size()));
        picasso = (Picasso)picassoProvider.get();
        s = preferenceUtils.getString(0x7f06002a, null);
        i = imojiBatch.size() - 1;
_L8:
        if (i < 0) goto _L4; else goto _L3
_L3:
        final Imoji imoji;
        String s1;
        imoji = (Imoji)imojiBatch.get(i);
        s1 = templatesManager.getImageUrlFromImoji(imoji, s);
        if (s1 == null) goto _L4; else goto _L5
_L5:
        if (!s1.contains("null")) goto _L6; else goto _L4
_L4:
        obj;
        JVM INSTR monitorexit ;
        return;
        picasso;
        obj;
        JVM INSTR monitorexit ;
        throw picasso;
_L2:
        i = batchSize;
          goto _L7
_L6:
        ((Picasso) (picasso)).load(s1).resize(1, 1).fetch(new Callback() {

            final ImojisPreloader this$0;
            final Imoji val$imoji;
            final Picasso val$picasso;

            public void onError()
            {
                onImageLoadFinished(picasso, imoji);
            }

            public void onSuccess()
            {
                onImageLoadFinished(picasso, imoji);
            }

            
            {
                this$0 = ImojisPreloader.this;
                picasso = picasso1;
                imoji = imoji1;
                super();
            }
        });
        i--;
          goto _L8
    }

    private void onImageLoadFinished(Picasso picasso, Imoji imoji)
    {
        synchronized (staticLock)
        {
            imojiBatch.remove(imoji);
            if (imojiBatch.size() == 0)
            {
                loadNextBatchFromQueue();
            }
        }
        return;
        imoji;
        picasso;
        JVM INSTR monitorexit ;
        throw imoji;
    }

    public String getLastPreloadedAvatarId()
    {
        return preferenceUtils.getString(0x7f0600a0, null);
    }

    public void load()
    {
        load(null);
    }

    public void load(FinishCallback finishcallback)
    {
        onFinish = finishcallback;
        finishcallback = templatesManager.getTemplates();
        imojiQueue = new ArrayList();
        if (b4MService.isReplyMode())
        {
            imojiQueue.addAll(finishcallback.getFriendmojis());
        }
        String s = preferenceUtils.getString(0x7f06002a, null);
        preferenceUtils.putString(0x7f0600a0, s);
        imojiQueue.addAll(finishcallback.getImoji());
        loadNextBatchFromQueue();
    }


}
