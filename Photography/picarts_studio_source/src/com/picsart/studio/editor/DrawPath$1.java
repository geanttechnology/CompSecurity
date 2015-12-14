// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import android.os.Parcel;

// Referenced classes of package com.picsart.studio.editor:
//            DrawPath

final class 
    implements android.os.Creator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new DrawPath(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new DrawPath[i];
    }

    ()
    {
    }
}
