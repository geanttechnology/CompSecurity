// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.support;

import roboguice.util.Ln;

// Referenced classes of package com.groupon.models.support:
//            ParcelableCreator

class FailureListener
    implements FailureListener
{

    public void onFailure(Exception exception)
    {
        Ln.d("Parcelable unmarshaller", new Object[] {
            "Unmarshalling error:", exception
        });
    }

    FailureListener()
    {
    }
}
