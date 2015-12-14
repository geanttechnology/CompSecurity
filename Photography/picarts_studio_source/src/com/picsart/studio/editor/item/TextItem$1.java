// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.os.Parcel;

// Referenced classes of package com.picsart.studio.editor.item:
//            TextItem

final class 
    implements android.os.Creator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new TextItem(parcel, (byte)0);
    }

    public final volatile Object[] newArray(int i)
    {
        return new TextItem[i];
    }

    ()
    {
    }
}
