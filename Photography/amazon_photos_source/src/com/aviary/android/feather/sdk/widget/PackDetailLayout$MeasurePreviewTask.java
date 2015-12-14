// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.DisplayMetrics;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.sdk.utils.CdsUIUtils;
import com.nineoldandroids.view.ViewHelper;
import it.sephiroth.android.library.widget.HListView;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PackDetailLayout

private class previewAspectRatio extends AviaryAsyncTask
{

    private final com.aviary.android.feather.cds.ewTask pack;
    private double previewAspectRatio;
    private String previewPath;
    final PackDetailLayout this$0;

    protected transient Cursor doInBackground(Context acontext[])
    {
        acontext = acontext[0];
        if (acontext == null)
        {
            acontext = null;
        } else
        {
            double ad[] = new double[1];
            ad[0] = 1.0D;
            Cursor cursor = CdsUIUtils.computePreviewAspectRatio(acontext, pack.(), pack.ckType(), previewPath, ad);
            acontext = cursor;
            if (cursor != null)
            {
                acontext = cursor;
                if (cursor.moveToFirst())
                {
                    previewAspectRatio = ad[0];
                    return cursor;
                }
            }
        }
        return acontext;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Context[])aobj);
    }

    protected void doPostExecute(Cursor cursor)
    {
        if (cursor != null && getContext() != null)
        {
            PackDetailLayout.access$602(PackDetailLayout.this, (int)((double)PackDetailLayout.access$700(PackDetailLayout.this) * previewAspectRatio));
            ViewHelper.setTranslationX(PackDetailLayout.access$800(PackDetailLayout.this), 0.0F);
            PackDetailLayout.access$800(PackDetailLayout.this).setDividerWidth(PackDetailLayout.access$900(PackDetailLayout.this));
            DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
            if (!PackDetailLayout.access$1000(PackDetailLayout.this) && cursor != null && cursor.getCount() > 0)
            {
                int j = PackDetailLayout.access$800(PackDetailLayout.this).getWidth();
                PackDetailLayout.logger._mth0("hlistview.getWidth: %d, screen.size: %d", new Object[] {
                    Integer.valueOf(j), Integer.valueOf(displaymetrics.widthPixels)
                });
                if (j > 0)
                {
                    int l = cursor.getCount();
                    int i = PackDetailLayout.access$800(PackDetailLayout.this).getDividerWidth();
                    PackDetailLayout.logger._mth0("preview.width: %d, divider.width: %d", new Object[] {
                        Integer.valueOf(PackDetailLayout.access$600(PackDetailLayout.this)), Integer.valueOf(i)
                    });
                    if (PackDetailLayout.access$600(PackDetailLayout.this) * l + (i * l - 1) < j)
                    {
                        int k = (displaymetrics.widthPixels - PackDetailLayout.access$600(PackDetailLayout.this) * l) / Math.max(1, l + 1);
                        PackDetailLayout.access$800(PackDetailLayout.this).setDividerWidth(k);
                        float f = Math.abs(k - i);
                        PackDetailLayout.logger._mth0("new dividerWidth: %d", new Object[] {
                            Integer.valueOf(k)
                        });
                        PackDetailLayout.logger._mth0("translationX: %f", new Object[] {
                            Float.valueOf(f)
                        });
                        ViewHelper.setTranslationX(PackDetailLayout.access$800(PackDetailLayout.this), f);
                    }
                }
            }
            PackDetailLayout.access$1100(PackDetailLayout.this).setPreviewSize(PackDetailLayout.access$600(PackDetailLayout.this), PackDetailLayout.access$700(PackDetailLayout.this));
            PackDetailLayout.access$1100(PackDetailLayout.this).setPreviewMargin(PackDetailLayout.access$1200(PackDetailLayout.this));
            PackDetailLayout.access$1100(PackDetailLayout.this).setBaseDir(previewPath);
            PackDetailLayout.access$1100(PackDetailLayout.this).changeCursor(cursor, pack.ckType());
            PackDetailLayout.access$800(PackDetailLayout.this).setTag(pack.entifier());
            PackDetailLayout.access$800(PackDetailLayout.this).setSelection(0);
            PackDetailLayout.access$1300(PackDetailLayout.this);
        }
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((Cursor)obj);
    }

    protected void doPreExecute()
    {
    }

    (com.aviary.android.feather.cds.ewTask ewtask, String s)
    {
        this$0 = PackDetailLayout.this;
        super();
        pack = ewtask;
        previewPath = s;
        previewAspectRatio = 1.0D;
    }
}
