// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.fotoable.beautyui.newui.MNewFindFaceFragment;

public class ts
    implements yb
{

    final MNewFindFaceFragment a;

    public ts(MNewFindFaceFragment mnewfindfacefragment)
    {
        a = mnewfindfacefragment;
        super();
    }

    public void a(Matrix matrix, PointF pointf)
    {
    }

    public void a(RectF rectf)
    {
        MNewFindFaceFragment.a(a, rectf);
        MNewFindFaceFragment.a(a, rectf, MNewFindFaceFragment.a(a), MNewFindFaceFragment.b(a));
    }
}
