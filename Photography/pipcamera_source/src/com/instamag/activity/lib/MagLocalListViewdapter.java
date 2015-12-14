// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import com.instamag.activity.link.model.TPhotoLinkComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.CollageType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.TResInfo;
import ew;
import fq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import qn;
import qq;

// Referenced classes of package com.instamag.activity.lib:
//            MagLibCellItemView

public class MagLocalListViewdapter extends BaseAdapter
    implements SectionIndexer
{

    private static String TAG = "MagListViewdapter";
    private final int CELL_COLUMNS = 3;
    private int TYPE_ITEM;
    private int TYPE_SECTION;
    private Context mContext;
    final fq mImageWorker;
    private ArrayList mIndexs;
    private ArrayList mItems;
    private ArrayList mSections;
    qn magLibCellClicedLisener;

    public MagLocalListViewdapter(Context context, ArrayList arraylist, fq fq)
    {
        TYPE_ITEM = 0;
        TYPE_SECTION = 1;
        mSections = new ArrayList();
        mIndexs = new ArrayList();
        magLibCellClicedLisener = null;
        mContext = context;
        mImageWorker = fq;
        mItems = new ArrayList();
        buildIndexByInfos(arraylist);
        buildMagViewCellItemsByInfos(arraylist);
    }

    private void buildIndexByInfos(ArrayList arraylist)
    {
        mIndexs.clear();
        mSections.clear();
        ArrayList arraylist1 = new ArrayList(0);
        int i = 0;
        while (i < arraylist.size()) 
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)arraylist.get(i);
            if (tphotocomposeinfo instanceof TPhotoLinkComposeInfo)
            {
                if (!isExistCountStringInArrayList(arraylist1, "S"))
                {
                    arraylist1.add("S");
                }
            } else
            if ((tphotocomposeinfo instanceof TPhotoComposeInfo) && tphotocomposeinfo.imageCount > 0 && !isExistCountStringInArrayList(arraylist1, String.valueOf(tphotocomposeinfo.imageCount)))
            {
                arraylist1.add(String.valueOf(tphotocomposeinfo.imageCount));
            }
            i++;
        }
        if (arraylist1.size() > 0)
        {
            Collections.sort(arraylist1, new Comparator() {

                final MagLocalListViewdapter a;

                public int compare(Object obj, Object obj1)
                {
                    int l = 0x7fffffff;
                    if ((obj instanceof String) && (obj1 instanceof String))
                    {
                        obj = (String)obj;
                        obj1 = (String)obj1;
                        int k;
                        if (((String) (obj)).equalsIgnoreCase("S"))
                        {
                            k = 0x7fffffff;
                        } else
                        {
                            k = Integer.valueOf(((String) (obj))).intValue();
                        }
                        if (!((String) (obj1)).equalsIgnoreCase("S"))
                        {
                            l = Integer.valueOf(((String) (obj1))).intValue();
                        }
                        if (k > l)
                        {
                            return 1;
                        }
                        return k != l ? -1 : 0;
                    } else
                    {
                        return 0;
                    }
                }

            
            {
                a = MagLocalListViewdapter.this;
                super();
            }
            });
        }
        for (int j = 0; j < arraylist1.size(); j++)
        {
            String s = (String)arraylist1.get(j);
            mIndexs.add(s);
            mSections.add(s);
        }

        if (arraylist.size() > 0)
        {
            arraylist = getRecentDonwloadItems(((TResInfo)arraylist.get(0)).getInfoCollageType(), arraylist);
            if (arraylist != null && arraylist.size() > 0)
            {
                mIndexs.add(0, "R");
                mSections.add(0, "R");
            }
        }
    }

    private void buildMagViewCellItemsByInfos(ArrayList arraylist)
    {
        mItems.clear();
label0:
        for (int i = 0; i < mIndexs.size(); i++)
        {
            String s = (String)mIndexs.get(i);
            Object obj;
            ArrayList arraylist1;
            qq qq1;
            int j;
            int l;
            if (s.equalsIgnoreCase("R"))
            {
                if (arraylist != null && arraylist.size() > 0)
                {
                    arraylist1 = getRecentDonwloadItems(((TResInfo)arraylist.get(0)).getInfoCollageType(), arraylist);
                } else
                {
                    arraylist1 = null;
                }
            } else
            {
                arraylist1 = getItemsByCount(s, arraylist);
            }
            if (arraylist1 == null || arraylist1.size() <= 0)
            {
                continue;
            }
            l = (int)Math.ceil((float)arraylist1.size() / 3F);
            qq1 = new qq();
            qq1.a = TYPE_SECTION;
            qq1.b = s;
            if (s.equalsIgnoreCase("R"))
            {
                int k;
                int i1;
                if (ew.b())
                {
                    obj = "\u6700\u8FD1\u4E0B\u8F7D";
                } else
                if (ew.c())
                {
                    obj = "\u6700\u8FD1\u4E0B\u8F09";
                } else
                {
                    obj = "Recent Downloads";
                }
                qq1.c = ((String) (obj));
            } else
            if (s.equalsIgnoreCase("S"))
            {
                if (ew.b())
                {
                    obj = "\u62FC\u63A5";
                } else
                if (ew.c())
                {
                    obj = "\u62FC\u63A5";
                } else
                {
                    obj = "Strips";
                }
                qq1.c = ((String) (obj));
            } else
            {
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (ew.b())
                {
                    obj = "\u5F20";
                } else
                if (ew.c())
                {
                    obj = "\u5F35";
                } else
                if (Integer.valueOf(s).intValue() > 1)
                {
                    obj = " Frames";
                } else
                {
                    obj = " Frame";
                }
                qq1.c = stringbuilder.append(((String) (obj))).toString();
            }
            mItems.add(qq1);
            j = 0;
            do
            {
                if (j >= l)
                {
                    continue label0;
                }
                obj = new qq();
                obj.a = TYPE_ITEM;
                obj.d = new ArrayList();
                for (k = 0; k < 3; k++)
                {
                    i1 = j * 3 + k;
                    if (i1 < arraylist1.size())
                    {
                        ((qq) (obj)).d.add(arraylist1.get(i1));
                    }
                }

                obj.b = s;
                mItems.add(obj);
                j++;
            } while (true);
        }

    }

    private ArrayList getItemsByCount(String s, ArrayList arraylist)
    {
        Object obj = null;
        Iterator iterator = arraylist.iterator();
        arraylist = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            if (!s.equalsIgnoreCase("S"))
            {
                if (tphotocomposeinfo.imageCount == Integer.valueOf(s).intValue() && !(tphotocomposeinfo instanceof TPhotoLinkComposeInfo))
                {
                    ArrayList arraylist1 = arraylist;
                    if (arraylist == null)
                    {
                        arraylist1 = new ArrayList();
                    }
                    arraylist1.add(tphotocomposeinfo);
                    arraylist = arraylist1;
                }
            } else
            if (tphotocomposeinfo instanceof TPhotoLinkComposeInfo)
            {
                ArrayList arraylist2 = arraylist;
                if (arraylist == null)
                {
                    arraylist2 = new ArrayList();
                }
                arraylist2.add(tphotocomposeinfo);
                arraylist = arraylist2;
            }
        } while (true);
        return arraylist;
    }

    private ArrayList getRecentDonwloadItems(CollageType collagetype, ArrayList arraylist)
    {
        Object obj = null;
        Iterator iterator = arraylist.iterator();
        ArrayList arraylist2;
        for (arraylist = obj; iterator.hasNext(); arraylist = arraylist2)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            arraylist2 = arraylist;
            if (!tphotocomposeinfo.isOnline)
            {
                continue;
            }
            arraylist2 = arraylist;
            if (tphotocomposeinfo.getInfoCollageType() != collagetype)
            {
                continue;
            }
            ArrayList arraylist1 = arraylist;
            if (arraylist == null)
            {
                arraylist1 = new ArrayList();
            }
            arraylist2 = arraylist1;
            if (arraylist1 == null)
            {
                continue;
            }
            arraylist2 = arraylist1;
            if (arraylist1.size() < 12)
            {
                arraylist1.add(tphotocomposeinfo);
                arraylist2 = arraylist1;
            }
        }

        return arraylist;
    }

    private boolean isExistCountStringInArrayList(List list, String s)
    {
        if (s != null && list != null && list != null && list.size() > 0)
        {
            int i = 0;
            while (i < list.size()) 
            {
                if (((String)list.get(i)).equalsIgnoreCase(s))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public int getCount()
    {
        if (mItems == null)
        {
            return 0;
        } else
        {
            return mItems.size();
        }
    }

    public int getIndexsCount()
    {
        return mIndexs.size();
    }

    public Object getItem(int i)
    {
        return mItems.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return ((qq)mItems.get(i)).a;
    }

    public int getPositionForSection(int i)
    {
        if (mItems != null && mSections != null && i < mSections.size() && i != 0 && i != 0)
        {
            int j = 0;
            int k = 0;
            while (j < mItems.size()) 
            {
                int l = k;
                if (((qq)mItems.get(j)).a == TYPE_SECTION)
                {
                    if (k == i)
                    {
                        return j;
                    }
                    l = k + 1;
                }
                j++;
                k = l;
            }
        }
        return 0;
    }

    public int getSectionForPosition(int i)
    {
        return 0;
    }

    public Object[] getSections()
    {
        String as[] = new String[mSections.size()];
        for (int i = 0; i < mSections.size(); i++)
        {
            as[i] = (String)mSections.get(i);
        }

        return as;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j = getItemViewType(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        if (j == TYPE_SECTION)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f03004c, viewgroup, false);
            viewgroup = (TextView)view.findViewById(0x7f0c015b);
            viewgroup.setText(((qq)mItems.get(i)).c);
            view.setClickable(false);
            view.setFocusable(false);
            viewgroup.setTextColor(0xff000000);
        }
        if (j != TYPE_ITEM)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        viewgroup = new MagLibCellItemView(mContext);
        ((MagLibCellItemView)viewgroup).SetDataItem((qq)mItems.get(i), mImageWorker);
        ((MagLibCellItemView)viewgroup).setMagLibCellClickedLisener(magLibCellClicedLisener);
_L4:
        return viewgroup;
_L2:
        View view1 = view;
        if (view instanceof MagLibCellItemView)
        {
            view1 = view;
            if (j == TYPE_SECTION)
            {
                view1 = LayoutInflater.from(mContext).inflate(0x7f03004c, viewgroup, false);
                view = (TextView)view1.findViewById(0x7f0c015b);
                view.setText(((qq)mItems.get(i)).c);
                view1.setClickable(false);
                view1.setFocusable(false);
                view.setTextColor(0xff000000);
            }
        }
        if ((view1 instanceof LinearLayout) && j == TYPE_ITEM)
        {
            view = new MagLibCellItemView(mContext);
            ((MagLibCellItemView)view).SetDataItem((qq)mItems.get(i), mImageWorker);
            ((MagLibCellItemView)view).setMagLibCellClickedLisener(magLibCellClicedLisener);
        } else
        {
            view = view1;
        }
        if ((view instanceof MagLibCellItemView) && j == TYPE_ITEM)
        {
            ((MagLibCellItemView)view).SetDataItem((qq)mItems.get(i), mImageWorker);
            ((MagLibCellItemView)view).setMagLibCellClickedLisener(magLibCellClicedLisener);
        }
        viewgroup = view;
        if (!(view instanceof LinearLayout)) goto _L4; else goto _L3
_L3:
        viewgroup = view;
        if (j != TYPE_SECTION) goto _L4; else goto _L5
_L5:
        ((TextView)view.findViewById(0x7f0c015b)).setText(((qq)mItems.get(i)).c);
        return view;
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public void setItemList(ArrayList arraylist)
    {
        buildIndexByInfos(arraylist);
        if (arraylist != null)
        {
            Log.v(TAG, (new StringBuilder()).append(TAG).append(" resItems count :").append(arraylist.size()).toString());
        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" indexs :").append(mIndexs).toString());
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" sections :").append(mSections).toString());
        buildMagViewCellItemsByInfos(arraylist);
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" mItemSizeCount :").append(mItems.size()).toString());
        notifyDataSetChanged();
    }

    public void setItemNativeAd(FotoNativeIcon fotonativeicon)
    {
        Iterator iterator = mItems.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            qq qq1 = (qq)iterator.next();
            if (qq1.d != null && qq1.d.size() > 0)
            {
                qq1.e = fotonativeicon.nativeItem;
            }
        } while (true);
    }

    public void setMagLibCellClickedLisener(qn qn)
    {
        magLibCellClicedLisener = qn;
    }

}
