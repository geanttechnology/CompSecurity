// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.utils.UserSavedState;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.view:
//            ItemEditorView

public class d extends UserSavedState
{

    public static final android.os.itorView.SavedState.d CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new ItemEditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new ItemEditorView.SavedState[i];
        }

    };
    private List b;
    private int c;
    private boolean d;

    static List a(d d1)
    {
        return d1.b;
    }

    static int b(b b1)
    {
        return b1.c;
    }

    static boolean c(c c1)
    {
        return c1.d;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelableArray((Parcelable[])b.toArray(new Item[b.size()]), i);
        parcel.writeInt(c);
        if (d)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        Parcelable aparcelable[] = parcel.readParcelableArray(com/picsart/studio/editor/item/Item.getClassLoader());
        boolean flag;
        if (aparcelable == null || aparcelable.length == 0)
        {
            b = new ArrayList();
        } else
        {
            b = new ArrayList(aparcelable.length);
            int j = aparcelable.length;
            int i = 0;
            while (i < j) 
            {
                Parcelable parcelable = aparcelable[i];
                b.add((Item)parcelable);
                i++;
            }
        }
        c = parcel.readInt();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }

    public d(Parcelable parcelable, ItemEditorView itemeditorview)
    {
        super(parcelable);
        b = itemeditorview.i;
        c = itemeditorview.i.indexOf(itemeditorview.j);
        d = ItemEditorView.c(itemeditorview);
    }
}
