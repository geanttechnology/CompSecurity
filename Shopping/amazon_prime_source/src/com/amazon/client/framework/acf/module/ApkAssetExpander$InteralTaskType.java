// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.amazon.client.framework.acf.WeakRegistrar;
import com.amazon.client.framework.androidresparser.AndroidManifest;
import com.amazon.client.framework.androidresparser.BinaryParser;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            ApkAssetExpander, PrivateApk, MultiDex

private class <init> extends AsyncTask
{
    private final class ProgressPart
    {

        private int mMinProgress;
        private float mProgressRange;
        final ApkAssetExpander.InteralTaskType this$1;

        public final void publishProgress(float f)
        {
            int i = Math.round(mProgressRange * f);
            if (i >= 0 && mMinProgress + i <= 100)
            {
                ApkAssetExpander.InteralTaskType.this.publishProgress(new Integer[] {
                    Integer.valueOf(mMinProgress + i), Integer.valueOf(100)
                });
            }
        }

        public final void setPart(int i, int j)
        {
            mMinProgress = i;
            mProgressRange = j - i;
        }

        private ProgressPart()
        {
            this$1 = ApkAssetExpander.InteralTaskType.this;
            super();
        }

        ProgressPart(ApkAssetExpander._cls1 _pcls1)
        {
            this();
        }
    }


    private final ThreadLocal mProgressPart;
    final ApkAssetExpander this$0;

    protected transient ProgressPart.mProgressRange doInBackground(String as[])
    {
        Context context = (Context)ApkAssetExpander.access$300(ApkAssetExpander.this).get();
        if (context != null && !ApkAssetExpander.access$400(ApkAssetExpander.this).isCancelled()) goto _L2; else goto _L1
_L1:
        Object obj = ELLED;
_L12:
        return ((ELLED) (obj));
_L2:
        String as1[];
        String s;
        ProgressPart progresspart;
        int i;
        if (as.length == 0)
        {
            ApkAssetExpander.access$502(ApkAssetExpander.this, new IllegalArgumentException("No asset name provided to execute methods."));
            return RG;
        }
        as1 = as[0].split(":");
        s = as[1];
        progresspart = (ProgressPart)mProgressPart.get();
        obj = mProgressPart;
        i = 0;
_L9:
        as = ((String []) (obj));
        if (i >= as1.length) goto _L4; else goto _L3
_L3:
        if (obj == mProgressPart || obj == NGE) goto _L6; else goto _L5
_L5:
        as = ((String []) (obj));
_L4:
        obj = as;
        if (ApkAssetExpander.access$1200(ApkAssetExpander.this))
        {
            obj = new ArrayList(2);
            if (ApkAssetExpander.access$600(ApkAssetExpander.this) != null)
            {
                ((List) (obj)).add(new File(ApkAssetExpander.access$600(ApkAssetExpander.this).apkpath));
            }
            if (ApkAssetExpander.access$1000(ApkAssetExpander.this) != null)
            {
                ((List) (obj)).add(ApkAssetExpander.access$1000(ApkAssetExpander.this));
            }
            MultiDex.installExpandedDexes(context, new File(ApkAssetExpander.access$600(ApkAssetExpander.this).dexoptpath), ((List) (obj)));
            return as;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        obj = as1[i];
        if (!((String) (obj)).endsWith(".apk"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (ApkAssetExpander.access$600(ApkAssetExpander.this) != null)
        {
            throw new RuntimeException("Asset expander only expands one APK");
        }
        as = BinaryParser.parseManifest(context.getAssets(), ((String) (obj)), true);
        if (as.getPackageName() == null)
        {
            ApkAssetExpander.access$502(ApkAssetExpander.this, new IllegalArgumentException((new StringBuilder()).append(((String) (obj))).append(" Did not contain a valid manifest. It must have a valid package name.").toString()));
            return RG;
        }
        break; /* Loop/switch isn't completed */
        as;
        ApkAssetExpander.access$502(ApkAssetExpander.this, as);
        as = URCE_EXPANSION;
        if (true) goto _L4; else goto _L7
_L7:
        ApkAssetExpander.access$700().lock();
        obj = ApkAssetExpander.access$800(ApkAssetExpander.this, context, progresspart, ((String) (obj)), as, s);
        ApkAssetExpander.access$900(context, s, as.getPackageName());
        ApkAssetExpander.access$700().unlock();
_L10:
        i++;
        if (true) goto _L9; else goto _L8
        obj;
        ApkAssetExpander.access$900(context, s, as.getPackageName());
        ApkAssetExpander.access$700().unlock();
        throw obj;
_L8:
        if (!((String) (obj)).endsWith(".dex"))
        {
            break MISSING_BLOCK_LABEL_477;
        }
        ApkAssetExpander.access$700().lock();
        if (ApkAssetExpander.access$1000(ApkAssetExpander.this) != null)
        {
            throw new RuntimeException("Asset expander only expands one extra DEX.");
        }
        obj = ApkAssetExpander.access$1100(ApkAssetExpander.this, context, progresspart, ((String) (obj)), s);
        ApkAssetExpander.access$700().unlock();
          goto _L10
        as;
        ApkAssetExpander.access$700().unlock();
        throw as;
        ApkAssetExpander.access$502(ApkAssetExpander.this, new IllegalArgumentException((new StringBuilder()).append(((String) (obj))).append(" extension is unsupported.").toString()));
        return RG;
        if (true) goto _L12; else goto _L11
_L11:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected void onPostExecute(doInBackground doinbackground)
    {
        if (ApkAssetExpander.access$500(ApkAssetExpander.this) != null && Log.isLoggable(ApkAssetExpander.access$1300(), 6))
        {
            Log.e(ApkAssetExpander.access$1300(), doinbackground._mth0(), ApkAssetExpander.access$500(ApkAssetExpander.this));
        }
        for (Iterator iterator = ApkAssetExpander.access$200(ApkAssetExpander.this).iterator(); iterator.hasNext(); ((Observer)iterator.next()).onAssetExpansionEnd(ApkAssetExpander.this, doinbackground)) { }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((onPostExecute)obj);
    }

    protected void onPreExecute()
    {
        for (Iterator iterator = ApkAssetExpander.access$200(ApkAssetExpander.this).iterator(); iterator.hasNext(); ((Observer)iterator.next()).onAssetExpansionStart(ApkAssetExpander.this)) { }
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        for (Iterator iterator = ApkAssetExpander.access$200(ApkAssetExpander.this).iterator(); iterator.hasNext(); ((Observer)iterator.next()).onAssetExpansionProgress(ApkAssetExpander.this, ainteger[0].intValue(), ainteger[1].intValue())) { }
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }


    private _cls1.val.this._cls0()
    {
        this.this$0 = ApkAssetExpander.this;
        super();
        mProgressPart = new ThreadLocal() {

            final ApkAssetExpander.InteralTaskType this$1;
            final ApkAssetExpander val$this$0;

            protected ProgressPart initialValue()
            {
                return new ProgressPart(null);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                this$1 = ApkAssetExpander.InteralTaskType.this;
                this$0 = apkassetexpander;
                super();
            }
        };
    }

    _cls1.initialValue(_cls1.initialValue initialvalue)
    {
        this();
    }
}
