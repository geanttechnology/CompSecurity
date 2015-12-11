// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.classes.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class resultList extends ArrayAdapter
    implements Filterable
{

    private ArrayList img;
    private ArrayList resultList;
    final MainPage this$0;

    public int getCount()
    {
        if (resultList != null)
        {
            return resultList.size();
        } else
        {
            return 0;
        }
    }

    public Filter getFilter()
    {
        class _cls1 extends Filter
        {

            final MainPage.MixerBoxSearchAutoCompleteAdapter this$1;

            protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
            {
                android.widget.Filter.FilterResults filterresults;
                ArrayList arraylist;
                String as[];
                String as1[];
                int i;
                boolean flag;
                flag = false;
                filterresults = new android.widget.Filter.FilterResults();
                if (charsequence == null)
                {
                    break MISSING_BLOCK_LABEL_317;
                }
                img = new ArrayList();
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
                img.add(as1[i]);
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
                        img.add(as1[i]);
                    }
                }
                  goto _L6
                k++;
                  goto _L7
_L2:
                new ArrayList();
                ArrayList arraylist1 = MainPage.access$1000(this$0, charsequence.toString());
                for (int j = ((flag) ? 1 : 0); j < arraylist1.size(); j++)
                {
                    arraylist.add(arraylist1.get(j));
                    img.add("");
                }

                if (arraylist.size() == 0)
                {
                    arraylist.add(charsequence.toString());
                    img.add("");
                }
                filterresults.values = arraylist;
                filterresults.count = arraylist.size();
                return filterresults;
                  goto _L6
            }

            protected void publishResults(CharSequence charsequence, final android.widget.Filter.FilterResults results)
            {
                class _cls1
                    implements Runnable
                {

                    final _cls1 this$2;
                    final android.widget.Filter.FilterResults val$results;

                    public void run()
                    {
                        resultList = (ArrayList)results.values;
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
                            this$2 = _cls1.this;
                            results = filterresults;
                            super();
                        }
                }

                runOnUiThread(new _cls1());
            }

            _cls1()
            {
                this$1 = MainPage.MixerBoxSearchAutoCompleteAdapter.this;
                super();
            }
        }

        return new _cls1();
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public String getItem(int i)
    {
        if (resultList != null && resultList.size() > i)
        {
            return (String)resultList.get(i);
        } else
        {
            return "";
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        class ViewHolder
        {

            public ImageView iv;
            final MainPage.MixerBoxSearchAutoCompleteAdapter this$1;
            public TextView tv;

            private ViewHolder()
            {
                this$1 = MainPage.MixerBoxSearchAutoCompleteAdapter.this;
                super();
            }

            ViewHolder(MainPage._cls1 _pcls1)
            {
                this();
            }
        }

        if (view == null)
        {
            view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03004e, null);
            viewgroup = new ViewHolder(null);
            viewgroup.tv = (TextView)view.findViewById(0x7f070102);
            viewgroup.iv = (ImageView)view.findViewById(0x7f070100);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        if (img.size() <= i || ((String)img.get(i)).length() != 0)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        ((ViewHolder) (viewgroup)).tv.setText(getItem(i));
        ((ViewHolder) (viewgroup)).iv.setVisibility(8);
        return view;
        if (img.size() <= i)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        ((ViewHolder) (viewgroup)).iv.setVisibility(0);
        ((ViewHolder) (viewgroup)).tv.setText(getItem(i));
        com.nostra13.universalimageloader.core.DisplayImageOptions displayimageoptions = (new com.nostra13.universalimageloader.core.t>()).t>(true).t>(true).t>(new CircleBitmapDisplayer()).t>();
        ImageLoader.getInstance().displayImage((String)img.get(i), ((ViewHolder) (viewgroup)).iv, displayimageoptions);
        return view;
        try
        {
            ((ViewHolder) (viewgroup)).iv.setVisibility(8);
            ((ViewHolder) (viewgroup)).tv.setText(getItem(i));
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            return view;
        }
        return view;
    }


/*
    static ArrayList access$1102(ViewHolder viewholder, ArrayList arraylist)
    {
        viewholder.resultList = arraylist;
        return arraylist;
    }

*/



/*
    static ArrayList access$902(resultList resultlist, ArrayList arraylist)
    {
        resultlist.img = arraylist;
        return arraylist;
    }

*/

    public img(Context context, int i)
    {
        this$0 = MainPage.this;
        super(context, i);
        resultList = new ArrayList();
    }
}
