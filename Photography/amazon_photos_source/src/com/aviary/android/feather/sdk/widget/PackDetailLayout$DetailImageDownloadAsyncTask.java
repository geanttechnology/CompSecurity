// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.widget.ViewAnimator;
import com.aviary.android.feather.cds.AviaryCdsDownloaderFactory;
import com.aviary.android.feather.common.utils.SystemUtils;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import it.sephiroth.android.library.picasso.Callback;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.RequestCreator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PackDetailLayout

class packId extends AviaryAsyncTask
{

    private final long delay;
    private final long packId;
    final PackDetailLayout this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Context[])aobj);
    }

    protected transient String doInBackground(Context acontext[])
    {
        PackDetailLayout.logger.doInBackground("DetailImageDownloadAsyncTask::doInBackground");
        for (acontext = acontext[0]; !isValidContext() || acontext == null || getPack() == null || packId != getPackId();)
        {
            return null;
        }

        if (delay > 0L)
        {
            SystemUtils.trySleep(delay);
        }
        com.aviary.android.feather.cds.ncTask nctask = AviaryCdsDownloaderFactory.create(com.aviary.android.feather.cds.ncTask.delay);
        try
        {
            acontext = nctask.(acontext, packId);
        }
        // Misplaced declaration of an exception variable
        catch (Context acontext[])
        {
            acontext.printStackTrace();
            return null;
        }
        return acontext;
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((String)obj);
    }

    protected void doPostExecute(String s)
    {
        PackDetailLayout.logger.doPostExecute("DetailImageDownloadAsyncTask::doPostExecute");
        if (!isValidContext() || getPack() == null || mPicasso == null || packId != getPackId())
        {
            PackDetailLayout.logger.packId("isValidContext: %b", new Object[] {
                Boolean.valueOf(isValidContext())
            });
            s = PackDetailLayout.logger;
            boolean flag;
            if (getPack() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s.packId("pack != null: %b", new Object[] {
                Boolean.valueOf(flag)
            });
            s = PackDetailLayout.logger;
            if (mPicasso != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s.packId("picasso != null: %b", new Object[] {
                Boolean.valueOf(flag)
            });
            PackDetailLayout.logger.packId("packId != mPackId: %d/%d", new Object[] {
                Long.valueOf(packId), Long.valueOf(getPackId())
            });
            return;
        } else
        {
            s = mPicasso.load(s);
            s.noFade();
            s.config(android.graphics.).fit(true).skipMemoryCache().into(PackDetailLayout.access$100(PackDetailLayout.this), new Callback() {

                final PackDetailLayout.DetailImageDownloadAsyncTask this$1;

                public void onError()
                {
                    PackDetailLayout.logger.warn("onError");
                }

                public void onSuccess()
                {
                    if (isValidContext() && packId == getPackId() && PackDetailLayout.access$000(this$0).getDisplayedChild() == 1)
                    {
                        if (isChildVisible(this$0))
                        {
                            PackDetailLayout.access$000(this$0).setInAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_detail_banner_fade_in);
                            PackDetailLayout.access$000(this$0).setOutAnimation(getContext(), com.aviary.android.feather.sdk.R.anim.aviary_detail_banner_fade_out);
                        } else
                        {
                            PackDetailLayout.logger.warn("downloadDetailImage, skip animation..");
                            PackDetailLayout.access$000(this$0).setInAnimation(null);
                            PackDetailLayout.access$000(this$0).setOutAnimation(null);
                        }
                        PackDetailLayout.access$000(this$0).setDisplayedChild(2);
                    }
                }

            
            {
                this$1 = PackDetailLayout.DetailImageDownloadAsyncTask.this;
                super();
            }
            });
            return;
        }
    }

    protected void doPreExecute()
    {
    }


    _cls1.this._cls1(long l, long l1)
    {
        this$0 = PackDetailLayout.this;
        super();
        delay = l1;
        packId = l;
    }
}
