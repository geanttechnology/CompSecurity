// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import apq;
import bbs;
import bda;
import bdg;
import bdk;
import bdl;
import bdm;
import bdn;
import bdo;
import bdz;
import com.instamag.activity.library.model.TResTypeManager;
import com.instamag.common.CollageType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.link.model.TPhotoLinkComposeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LibraryExpandableListView extends ExpandableListView
    implements bdk
{

    public bda imageWorker;
    private bdz lisener;
    bdo mAdapter;
    List mAllInfos;
    CollageType mCollageType;
    int mCountIndex;
    List mFilterCounts;
    public List mFilterInfos;
    InstaMagType mInstaMagType;
    int mInstamagTypeIndex;
    public boolean mIsEdit;
    private boolean mIsFastScrollEnabled;
    private Object mScroller;
    public List mSections;
    bdg mTResType;
    int mTResTypeIndex;

    public LibraryExpandableListView(Context context)
    {
        super(context);
        mScroller = null;
        mIsFastScrollEnabled = false;
        mAllInfos = new ArrayList();
        mFilterInfos = new ArrayList();
        mSections = new ArrayList();
        mFilterCounts = new ArrayList();
        initView();
    }

    public LibraryExpandableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mScroller = null;
        mIsFastScrollEnabled = false;
        mAllInfos = new ArrayList();
        mFilterInfos = new ArrayList();
        mSections = new ArrayList();
        mFilterCounts = new ArrayList();
        initView();
    }

    public LibraryExpandableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mScroller = null;
        mIsFastScrollEnabled = false;
        mAllInfos = new ArrayList();
        mFilterInfos = new ArrayList();
        mSections = new ArrayList();
        mFilterCounts = new ArrayList();
        initView();
    }

    private List getCommonlyUsedInfos()
    {
        List list;
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        new ArrayList();
        if (mTResType.a == TResTypeManager.KRES_ALLTYPE)
        {
            list = apq.c().d().getCommonlyUsedInfos();
        } else
        {
            list = apq.c().d().getCommonlyUsedInfosByCollageTypeResType(CollageType.COLLAGE_MAGZINE, mTResType);
            if (mInstaMagType != InstaMagType.ALL_SIZE_TYPE)
            {
                list = apq.c().d().getCommonlyUsedInfosByCollageTypeResTypeMagType(CollageType.COLLAGE_MAGZINE, mTResType, mInstaMagType);
            }
        }
        if (list == null || list.size() <= 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L5:
        if (i < list.size() && i < 6) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        arraylist.add(list.get(i));
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private List getItemsByCount(String s, List list)
    {
        Object obj = new ArrayList();
        if (!s.equalsIgnoreCase("R")) goto _L2; else goto _L1
_L1:
        s = ((String) (obj));
        if (list != null)
        {
            s = ((String) (obj));
            if (list.size() > 0)
            {
                s = getCommonlyUsedInfos();
            }
        }
_L4:
        Collections.sort(s, new bdn(this));
        return s;
_L2:
        if (s.equalsIgnoreCase("S"))
        {
            s = ((String) (obj));
            if (list != null)
            {
                s = ((String) (obj));
                if (list.size() > 0)
                {
                    s = ((String) (obj));
                    if (mCollageType == CollageType.COLLAGE_MAGZINE)
                    {
                        s = getLinkInfoItems(list);
                    }
                }
            }
        } else
        {
            Iterator iterator = list.iterator();
            for (list = ((List) (obj)); iterator.hasNext(); list = ((List) (obj)))
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
                obj = list;
                if (tphotocomposeinfo.imageCount != Integer.valueOf(s).intValue())
                {
                    continue;
                }
                obj = list;
                if (tphotocomposeinfo instanceof TPhotoLinkComposeInfo)
                {
                    continue;
                }
                obj = list;
                if (list == null)
                {
                    obj = new ArrayList();
                }
                ((List) (obj)).add(tphotocomposeinfo);
            }

            s = list;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ArrayList getLinkInfoItems(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.next();
            if (tphotocomposeinfo instanceof TPhotoLinkComposeInfo)
            {
                arraylist.add(tphotocomposeinfo);
            }
        } while (true);
        return arraylist;
    }

    private ArrayList getRecentDonwloadItems(CollageType collagetype, List list)
    {
        collagetype = null;
        Object obj;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); collagetype = ((CollageType) (obj)))
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            obj = collagetype;
            if (!tphotocomposeinfo.isOnline)
            {
                continue;
            }
            obj = collagetype;
            if (!apq.c().d().isExistedByResId(tphotocomposeinfo.resId))
            {
                continue;
            }
            list = collagetype;
            if (collagetype == null)
            {
                list = new ArrayList();
            }
            obj = list;
            if (list == null)
            {
                continue;
            }
            obj = list;
            if (list.size() < 12)
            {
                list.add(tphotocomposeinfo);
                obj = list;
            }
        }

        return collagetype;
    }

    private void initView()
    {
        setGroupIndicator(null);
        setOnGroupClickListener(new bdl(this));
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

    private boolean isListContainInfo(List list, TPhotoComposeInfo tphotocomposeinfo)
    {
label0:
        {
            if (list == null || list.size() <= 0)
            {
                break label0;
            }
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
            } while (((TPhotoComposeInfo)list.next()).resId != tphotocomposeinfo.resId);
            return true;
        }
        return false;
    }

    private void resetGroupList()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.clear();
        int i = 0;
        while (i < mFilterInfos.size()) 
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)mFilterInfos.get(i);
            if (tphotocomposeinfo instanceof TPhotoLinkComposeInfo)
            {
                if (!isExistCountStringInArrayList(arraylist, "S"))
                {
                    arraylist.add("S");
                }
            } else
            if ((tphotocomposeinfo instanceof TPhotoComposeInfo) && tphotocomposeinfo.imageCount > 0 && !arraylist.contains(String.valueOf(tphotocomposeinfo.imageCount)))
            {
                arraylist.add(String.valueOf(tphotocomposeinfo.imageCount));
            }
            i++;
        }
        if (arraylist.size() > 1)
        {
            Collections.sort(arraylist, new bdm(this));
        }
        for (int j = 0; j < arraylist.size(); j++)
        {
            mSections.add(arraylist.get(j));
            mFilterCounts.add(arraylist.get(j));
        }

        if (mFilterInfos.size() > 0)
        {
            List list = getCommonlyUsedInfos();
            if (list != null && list.size() > 0)
            {
                mSections.add(0, "R");
            }
        }
    }

    public void addOnlineList(List list)
    {
        mAllInfos.clear();
        mAllInfos.addAll(list);
        reloadData();
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (mScroller == null);
    }

    public void expandAllGroup()
    {
        if (mSections != null && mSections.size() > 0)
        {
            for (int i = 0; i < mSections.size(); i++)
            {
                expandGroup(i);
            }

        }
    }

    public List getComposeInfosByResType(bdg bdg1)
    {
        if (bdg1.a == TResTypeManager.KRES_ALLTYPE)
        {
            return mAllInfos;
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mAllInfos.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            if (tphotocomposeinfo.typeId == bdg1.a)
            {
                arraylist.add(tphotocomposeinfo);
            }
        } while (true);
        return arraylist;
    }

    public List getComposeInfosByResTypeAndInstaMagType(bdg bdg1, InstaMagType instamagtype)
    {
        if (bdg1.a == TResTypeManager.KRES_ALLTYPE && instamagtype == InstaMagType.ALL_SIZE_TYPE)
        {
            return mAllInfos;
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mAllInfos.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            if ((bdg1.a == TResTypeManager.KRES_ALLTYPE || tphotocomposeinfo.typeId == bdg1.a) && (TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo) == instamagtype || instamagtype == InstaMagType.ALL_SIZE_TYPE))
            {
                arraylist.add(tphotocomposeinfo);
            }
        } while (true);
        return arraylist;
    }

    public InstaMagType getCurInstaMagType()
    {
        return mInstaMagType;
    }

    public int getCurResCountIndex()
    {
        return mCountIndex;
    }

    public int getCurResStyleIndex()
    {
        return mInstamagTypeIndex;
    }

    public int getCurResTypeIndex()
    {
        return mTResTypeIndex;
    }

    public int getFirstVisiblePosition()
    {
        return 0;
    }

    public List getResCountNameList()
    {
        return mFilterCounts;
    }

    public List getResStyleNameList()
    {
        ArrayList arraylist = new ArrayList();
        List list = getResStyleTypes();
        if (list != null && list.size() > 0)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                InstaMagType instamagtype = (InstaMagType)iterator.next();
                arraylist.add(bbs.b(instamagtype));
                if (mInstaMagType == instamagtype)
                {
                    mInstamagTypeIndex = list.indexOf(instamagtype);
                }
            } while (true);
        }
        return arraylist;
    }

    public List getResStyleTypes()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(InstaMagType.ALL_SIZE_TYPE);
        List list = getComposeInfosByResTypeAndInstaMagType(mTResType, InstaMagType.RECT_LIB_SIZE_TYPE);
        if (list != null && list.size() > 0)
        {
            arraylist.add(InstaMagType.RECT_LIB_SIZE_TYPE);
        }
        list = getComposeInfosByResTypeAndInstaMagType(mTResType, InstaMagType.SQ_LIB_SIZE_TYPE);
        if (list != null && list.size() > 0)
        {
            arraylist.add(InstaMagType.SQ_LIB_SIZE_TYPE);
        }
        list = getComposeInfosByResTypeAndInstaMagType(mTResType, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
        if (list != null && list.size() > 0)
        {
            arraylist.add(InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
        }
        if ((mTResType.a == TResTypeManager.KRES_ALLTYPE || mTResType.a == TResTypeManager.KRES_OTHERTYPE) && mCollageType == CollageType.COLLAGE_MAGZINE)
        {
            arraylist.add(InstaMagType.LINK_LIB_SIZE_TYPE);
        }
        return arraylist;
    }

    public List getResTypeNameList()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(TResTypeManager.instance().getResTypeById(TResTypeManager.KRES_ALLTYPE).a());
        List list = apq.c().d().getInfoTypesSortByInfos(mAllInfos);
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            bdg bdg1 = (bdg)iterator.next();
            arraylist.add(bdg1.a());
            if (bdg1.a == mTResType.a)
            {
                mTResTypeIndex = list.indexOf(bdg1);
            }
        } while (true);
        return arraylist;
    }

    public void initWithCollageType(int i, bda bda)
    {
        mIsEdit = false;
        imageWorker = bda;
        mCollageType = CollageType.COLLAGE_MAGZINE;
        mInstaMagType = InstaMagType.ALL_SIZE_TYPE;
        mInstamagTypeIndex = 0;
        mTResType = TResTypeManager.instance().getResTypeById(i);
        mTResTypeIndex = i;
        mCountIndex = 0;
        mAdapter = new bdo(this);
        mAdapter.a(this);
        setAdapter(mAdapter);
        setFastScrollEnabled(true);
        reloadData();
    }

    public void initWithCollageType(CollageType collagetype, bda bda)
    {
        mIsEdit = false;
        imageWorker = bda;
        mCollageType = collagetype;
        mInstaMagType = InstaMagType.ALL_SIZE_TYPE;
        mInstamagTypeIndex = 0;
        mTResType = TResTypeManager.instance().getResTypeById(TResTypeManager.KRES_ALLTYPE);
        mTResTypeIndex = 0;
        mCountIndex = 0;
        mAllInfos = apq.c().d().getLocalComposeInfos(mCollageType);
        mAllInfos.addAll(apq.c().d().getDownloadedComposeInfos(mCollageType));
        if (mCollageType == CollageType.COLLAGE_MAGZINE)
        {
            mAllInfos.addAll(apq.c().d().getLinkComposeInfos());
        }
        mAdapter = new bdo(this);
        mAdapter.a(this);
        setAdapter(mAdapter);
        setFastScrollEnabled(true);
        reloadData();
    }

    public void onGroupEditChanged(boolean flag)
    {
        mIsEdit = flag;
        reloadData();
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

    public void reloadData()
    {
        mFilterInfos = getComposeInfosByResTypeAndInstaMagType(mTResType, mInstaMagType);
        mSections.clear();
        mFilterCounts.clear();
        mAdapter.notifyDataSetChanged();
        resetGroupList();
        expandAllGroup();
        if (mScroller == null);
        mAdapter.notifyDataSetChanged();
    }

    public void reloadDataWithInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        Iterator iterator = mAllInfos.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        TPhotoComposeInfo tphotocomposeinfo1 = (TPhotoComposeInfo)iterator.next();
        if (tphotocomposeinfo.resId != tphotocomposeinfo1.resId) goto _L4; else goto _L3
_L3:
        tphotocomposeinfo = tphotocomposeinfo1;
_L6:
        mAllInfos.remove(tphotocomposeinfo);
        reloadData();
        return;
_L2:
        tphotocomposeinfo = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setAdapter(ExpandableListAdapter expandablelistadapter)
    {
        super.setAdapter(expandablelistadapter);
    }

    public void setEditMode(boolean flag)
    {
        mIsEdit = flag;
        reloadData();
    }

    public void setFastScrollEnabled(boolean flag)
    {
        for (mIsFastScrollEnabled = flag; mIsFastScrollEnabled || mScroller == null;)
        {
            return;
        }

        mScroller = null;
    }

    public void setItemClickLisener(bdz bdz)
    {
        lisener = bdz;
    }

    public void setResCountSelected(int i)
    {
        int j = i;
        if (i < 0)
        {
            j = 0;
        }
        i = j;
        if (j > mSections.size())
        {
            i = mSections.size() - 1;
        }
        if (mSections.size() != mFilterCounts.size()) goto _L2; else goto _L1
_L1:
        mCountIndex = i;
_L4:
        if (mCountIndex < 0)
        {
            mCountIndex = 0;
        }
        if (mCountIndex > mSections.size())
        {
            mCountIndex = mSections.size() - 1;
        }
        expandGroup(mCountIndex);
        setSelectedGroup(mCountIndex);
        return;
_L2:
        if (i > 0)
        {
            mCountIndex = i - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setResStyleSelected(int i)
    {
        mInstaMagType = (InstaMagType)getResStyleTypes().get(i);
        mCountIndex = 0;
        reloadData();
        setSelectedGroup(mCountIndex);
    }

    public void setResTypeSelected(int i)
    {
        List list = apq.c().d().getInfoTypesSortByInfos(mAllInfos);
        list.add(0, TResTypeManager.instance().getResTypeById(TResTypeManager.KRES_ALLTYPE));
        mTResType = (bdg)list.get(i);
        mInstaMagType = InstaMagType.ALL_SIZE_TYPE;
        mCountIndex = 0;
        reloadData();
        setSelectedGroup(mCountIndex);
    }


}
