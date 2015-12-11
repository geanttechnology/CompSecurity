// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.managers.bbyscan.ViewfinderView;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

final class mg
    implements ResultPointCallback
{

    private final ViewfinderView a;

    mg(ViewfinderView viewfinderview)
    {
        a = viewfinderview;
    }

    public void foundPossibleResultPoint(ResultPoint resultpoint)
    {
        a.a(resultpoint);
    }
}
