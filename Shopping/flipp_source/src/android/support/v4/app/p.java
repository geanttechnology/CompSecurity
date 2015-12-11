// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v4.app:
//            o

final class p extends SharedElementCallback
{

    private o a;

    public p(o o1)
    {
        a = o1;
    }

    public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectf)
    {
        return a.a(view, matrix, rectf);
    }

    public final View onCreateSnapshotView(Context context, Parcelable parcelable)
    {
        return a.a(context, parcelable);
    }

    public final void onMapSharedElements(List list, Map map)
    {
    }

    public final void onRejectSharedElements(List list)
    {
    }

    public final void onSharedElementEnd(List list, List list1, List list2)
    {
    }

    public final void onSharedElementStart(List list, List list1, List list2)
    {
    }
}
