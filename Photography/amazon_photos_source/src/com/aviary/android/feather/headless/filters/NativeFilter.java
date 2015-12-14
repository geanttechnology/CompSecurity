// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import android.graphics.Bitmap;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import com.aviary.android.feather.headless.moa.MoaResult;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.headless.filters:
//            INativeFilter, NativeFilterProxy

public class NativeFilter
    implements INativeFilter
{

    public static final String ORIGINAL = "undefined";
    public static final int SEED = (int)System.currentTimeMillis();
    protected MoaActionList mActions;
    protected MoaResult mResult;

    NativeFilter(String s)
    {
        mActions = MoaActionFactory.actionList();
        mActions.add(MoaActionFactory.action(s));
    }

    public transient NativeFilter(String as[])
    {
        mActions = MoaActionFactory.actionList(as);
    }

    public Bitmap execute(Bitmap bitmap, Bitmap bitmap1, int i, int j)
        throws JSONException
    {
        mResult = NativeFilterProxy.prepareActions(mActions, bitmap, bitmap1, i, j);
        mResult.execute();
        bitmap = mResult.outputBitmap;
        mResult = null;
        return bitmap;
    }

    public void executeInPlace(Bitmap bitmap)
        throws JSONException
    {
        mResult = NativeFilterProxy.prepareActions(mActions, bitmap);
        mResult.execute();
        mResult = null;
    }

    public MoaActionList getActions()
    {
        return mActions;
    }

    public MoaResult prepare(Bitmap bitmap, Bitmap bitmap1, int i, int j)
        throws JSONException
    {
        return NativeFilterProxy.prepareActions(mActions, bitmap, bitmap1, i, j);
    }

    public void setPreviewSize(int i, int j)
    {
        mActions.get(0).setValue("previewsize", new MoaPointParameter(i, j));
    }

    public void setSeed(int i)
    {
        mActions.get(0).setValue("seed", i);
    }

    public boolean stop()
    {
        boolean flag = false;
        if (mResult != null)
        {
            mResult.active = 0;
            flag = true;
        }
        return flag;
    }

}
