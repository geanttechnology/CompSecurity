// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.IndexedItemPostPhoto;
import e.j;
import retrofit.RetrofitError;

// Referenced classes of package com.offerup.android.activities:
//            NewPostActivity

final class em extends j
{

    private NewPostActivity a;

    private em(NewPostActivity newpostactivity)
    {
        a = newpostactivity;
        super();
    }

    em(NewPostActivity newpostactivity, byte byte0)
    {
        this(newpostactivity);
    }

    public final void a()
    {
        NewPostActivity.f(a);
    }

    public final volatile void a(Object obj)
    {
        obj = (IndexedItemPostPhoto)obj;
        NewPostActivity.a(a, ((IndexedItemPostPhoto) (obj)));
    }

    public final void a(Throwable throwable)
    {
        if (throwable instanceof RetrofitError)
        {
            NewPostActivity.a(a, (RetrofitError)throwable);
            return;
        } else
        {
            NewPostActivity.a(a, throwable);
            return;
        }
    }
}
