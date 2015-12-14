// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.os.Parcel;

// Referenced classes of package com.picsart.studio.editor.item:
//            ImageItem

final class 
    implements android.os.reator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new ImageItem(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new ImageItem[i];
    }

    ()
    {
    }
}
