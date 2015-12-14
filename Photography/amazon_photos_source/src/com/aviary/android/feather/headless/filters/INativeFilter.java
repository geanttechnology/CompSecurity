// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import android.graphics.Bitmap;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaResult;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.headless.filters:
//            IFilter

public interface INativeFilter
    extends IFilter
{

    public abstract Bitmap execute(Bitmap bitmap, Bitmap bitmap1, int i, int j)
        throws JSONException;

    public abstract void executeInPlace(Bitmap bitmap)
        throws JSONException;

    public abstract MoaActionList getActions();

    public abstract MoaResult prepare(Bitmap bitmap, Bitmap bitmap1, int i, int j)
        throws JSONException;
}
