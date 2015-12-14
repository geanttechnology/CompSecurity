// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.widget.Filter;
import com.amazon.gallery.framework.model.tags.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumPickerAdapter

private class <init> extends Filter
{

    final AlbumPickerAdapter this$0;

    protected android.widget..TagLabelFilter performFiltering(CharSequence charsequence)
    {
        android.widget. ;
        List list;
        ArrayList arraylist;
        int i;
        int k;
         = new android.widget.();
        if (charsequence == null || charsequence.length() == 0)
        {
            charsequence = new ArrayList(AlbumPickerAdapter.access$500(AlbumPickerAdapter.this));
            . = charsequence;
            . = charsequence.size();
            return ;
        }
        charsequence = charsequence.toString().toLowerCase();
        list = AlbumPickerAdapter.access$500(AlbumPickerAdapter.this);
        k = list.size();
        arraylist = new ArrayList(k);
        i = 0;
_L2:
        Tag tag;
        String s;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        tag = (Tag)list.get(i);
        s = tag.getLabel().toLowerCase();
        if (!s.equals(charsequence) && !s.startsWith(charsequence))
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(tag);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String as[];
        int j;
        int l;
        as = s.split(" ");
        l = as.length;
        j = 0;
_L4:
        if (j < l)
        {
label0:
            {
                if (!as[j].startsWith(charsequence))
                {
                    break label0;
                }
                arraylist.add(tag);
            }
        }
          goto _L3
        j++;
          goto _L4
        .bel = arraylist;
        .bel = arraylist.size();
        return ;
          goto _L3
    }

    protected void publishResults(CharSequence charsequence, android.widget..TagLabelFilter taglabelfilter)
    {
        charsequence = (List)taglabelfilter.TagLabelFilter;
        clear();
        for (charsequence = charsequence.iterator(); charsequence.hasNext(); add(taglabelfilter))
        {
            taglabelfilter = (Tag)charsequence.next();
        }

        notifyDataSetChanged();
        notifyDataSetInvalidated();
    }

    private ()
    {
        this$0 = AlbumPickerAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
