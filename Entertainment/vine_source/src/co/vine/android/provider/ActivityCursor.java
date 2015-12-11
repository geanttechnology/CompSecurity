// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Bundle;

public class ActivityCursor extends MergeCursor
{

    public static final String EXTRA_NUM_REQUESTS = "num_reqs";
    private int mNumFollowRequests;

    public ActivityCursor(Cursor acursor[])
    {
        super(acursor);
    }

    public ActivityCursor(Cursor acursor[], int i)
    {
        super(acursor);
        mNumFollowRequests = i;
    }

    public Bundle getExtras()
    {
        Bundle bundle = new Bundle(super.getExtras());
        bundle.putInt("num_reqs", mNumFollowRequests);
        return bundle;
    }
}
