// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.widget.Filter;
import com.mixerbox.mixerbox3b.utils.MixerBoxConstants;
import java.util.ArrayList;
import java.util.Locale;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls1 extends Filter
{

    final _cls1 this$1;

    protected android.widget.dapter._cls1 performFiltering(CharSequence charsequence)
    {
        android.widget.dapter dapter;
        ArrayList arraylist;
        String as[];
        String as1[];
        int i;
        boolean flag;
        flag = false;
        dapter = new android.widget.dapter();
        if (charsequence == null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        cess._mth902(this._cls1.this, new ArrayList());
        arraylist = new ArrayList();
        as = MixerBoxConstants.ARTISTS;
        as1 = MixerBoxConstants.ARTIST_THUMBNAIL;
        i = 0;
_L5:
        if (i >= as.length) goto _L2; else goto _L1
_L1:
        if (!as[i].toLowerCase(Locale.ENGLISH).startsWith(charsequence.toString().toLowerCase())) goto _L4; else goto _L3
_L3:
        arraylist.add(as[i]);
        cess._mth900(this._cls1.this).add(as1[i]);
_L6:
        i++;
          goto _L5
_L4:
        String as2[];
        int k;
        as2 = as[i].split(" ");
        k = 0;
_L7:
        if (k < as2.length)
        {
label0:
            {
                if (!as2[k].toLowerCase(Locale.ENGLISH).startsWith(charsequence.toString().toLowerCase()))
                {
                    break label0;
                }
                arraylist.add(as[i]);
                cess._mth900(this._cls1.this).add(as1[i]);
            }
        }
          goto _L6
        k++;
          goto _L7
_L2:
        new ArrayList();
        ArrayList arraylist1 = MainPage.access$1000(_fld0, charsequence.toString());
        for (int j = ((flag) ? 1 : 0); j < arraylist1.size(); j++)
        {
            arraylist.add(arraylist1.get(j));
            cess._mth900(this._cls1.this).add("");
        }

        if (arraylist.size() == 0)
        {
            arraylist.add(charsequence.toString());
            cess._mth900(this._cls1.this).add("");
        }
        dapter.dapter = arraylist;
        dapter.dapter = arraylist.size();
        return dapter;
          goto _L6
    }

    protected void publishResults(CharSequence charsequence, final android.widget.dapter._cls1 results)
    {
        class _cls1
            implements Runnable
        {

            final MainPage.MixerBoxSearchAutoCompleteAdapter._cls1 this$2;
            final android.widget.Filter.FilterResults val$results;

            public void run()
            {
                MainPage.MixerBoxSearchAutoCompleteAdapter.access$1102(this$1, (ArrayList)results.values);
                if (results != null && results.count > 0)
                {
                    notifyDataSetChanged();
                    return;
                } else
                {
                    notifyDataSetInvalidated();
                    return;
                }
            }

            _cls1()
            {
                this$2 = MainPage.MixerBoxSearchAutoCompleteAdapter._cls1.this;
                results = filterresults;
                super();
            }
        }

        runOnUiThread(new _cls1());
    }

    _cls1()
    {
        this$1 = this._cls1.this;
        super();
    }
}
