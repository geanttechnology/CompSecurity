// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


// Referenced classes of package com.offerup.android.dto:
//            ItemPostPhoto

public class IndexedItemPostPhoto
{

    private final int index;
    private final ItemPostPhoto itemPostPhoto;

    public IndexedItemPostPhoto(int i, ItemPostPhoto itempostphoto)
    {
        index = i;
        itemPostPhoto = itempostphoto;
    }

    public int getIndex()
    {
        return index;
    }

    public ItemPostPhoto getItemPostPhoto()
    {
        return itemPostPhoto;
    }
}
