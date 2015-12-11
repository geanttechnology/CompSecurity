// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.mixerbox.mixerbox3b.classes.MyItem;
import java.util.List;

public class VectorAdapter extends ArrayAdapter
{

    private List array;
    private LayoutInflater mInflater;

    public VectorAdapter(Context context, LayoutInflater layoutinflater, List list)
    {
        super(context, 0, list);
        array = list;
        mInflater = layoutinflater;
    }

    public int getItemViewType(int i)
    {
        return ((MyItem)array.get(i)).getViewType();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return ((MyItem)array.get(i)).getView(mInflater, view);
    }

    public int getViewTypeCount()
    {
        return RowType.values().length;
    }

    private class RowType extends Enum
    {

        private static final RowType $VALUES[];
        public static final RowType DIVIDER_ITEM;
        public static final RowType DJ_INFO_ITEM;
        public static final RowType DJ_ITEM;
        public static final RowType EMPTY_ITEM;
        public static final RowType GENERAL_ITEM;
        public static final RowType MORE_ITEM;
        public static final RowType MUSIC_ITEM;
        public static final RowType PLAYLIST_ITEM;
        public static final RowType VECTOR_ITEM;

        public static RowType valueOf(String s)
        {
            return (RowType)Enum.valueOf(com/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType, s);
        }

        public static RowType[] values()
        {
            return (RowType[])$VALUES.clone();
        }

        static 
        {
            VECTOR_ITEM = new RowType("VECTOR_ITEM", 0);
            DIVIDER_ITEM = new RowType("DIVIDER_ITEM", 1);
            MORE_ITEM = new RowType("MORE_ITEM", 2);
            DJ_ITEM = new RowType("DJ_ITEM", 3);
            PLAYLIST_ITEM = new RowType("PLAYLIST_ITEM", 4);
            MUSIC_ITEM = new RowType("MUSIC_ITEM", 5);
            GENERAL_ITEM = new RowType("GENERAL_ITEM", 6);
            EMPTY_ITEM = new RowType("EMPTY_ITEM", 7);
            DJ_INFO_ITEM = new RowType("DJ_INFO_ITEM", 8);
            $VALUES = (new RowType[] {
                VECTOR_ITEM, DIVIDER_ITEM, MORE_ITEM, DJ_ITEM, PLAYLIST_ITEM, MUSIC_ITEM, GENERAL_ITEM, EMPTY_ITEM, DJ_INFO_ITEM
            });
        }

        private RowType(String s, int i)
        {
            super(s, i);
        }
    }

}
