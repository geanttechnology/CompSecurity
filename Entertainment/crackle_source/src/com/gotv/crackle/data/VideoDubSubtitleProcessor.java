// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.model.FolderItem;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.MediaListItem;
import com.gotv.crackle.model.PlayListItem;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest, MediaDetailsRequest, ChannelFolderList

public class VideoDubSubtitleProcessor extends DataRequest
    implements DataRequest.DataRequestListener
{

    public static final String TAG = "VideoDubSubtitleProcessor";
    private String currentCaptions;
    private String currentLanguage;
    private ChannelFolderList mChannelFoldersList;
    private MediaDetailsItem mCurrentItem;
    private MediaDetailsItem mDubbedItem;
    private MediaDetailsRequest mMediaDetailsRequest;
    private String mMediaID;
    private MediaDetailsItem mSubbedItem;

    public VideoDubSubtitleProcessor()
    {
        mState = DataRequest.RequestState.IDLE;
    }

    public String getCurrentCaptions()
    {
        return currentCaptions;
    }

    public MediaDetailsItem getCurrentItem()
    {
        return mCurrentItem;
    }

    public String getCurrentLanguage()
    {
        return currentLanguage;
    }

    public void getData(DataRequest.DataRequestListener datarequestlistener, String s)
    {
        mDubbedItem = null;
        mSubbedItem = null;
        mDataRequestListener = datarequestlistener;
        mMediaID = s;
        mState = DataRequest.RequestState.RUNNING;
        mMediaDetailsRequest = new MediaDetailsRequest(this, s);
    }

    public MediaDetailsItem getDubbedItem()
    {
        return mDubbedItem;
    }

    public MediaDetailsItem getSubbedItem()
    {
        return mSubbedItem;
    }

    public void onDataFailed(String s, String s1)
    {
        mState = DataRequest.RequestState.FAILED;
        mDataRequestListener.onDataFailed("VideoDubSubtitleProcessor", s1);
    }

    public void onDataSuccess(String s)
    {
        if (!s.equalsIgnoreCase("MediaDetails")) goto _L2; else goto _L1
_L1:
        s = mMediaDetailsRequest.getItem();
        if (s.IsDubbed())
        {
            mDubbedItem = s;
        } else
        {
            mSubbedItem = s;
        }
        if (!s.getID().equalsIgnoreCase(mMediaID)) goto _L4; else goto _L3
_L3:
        mCurrentItem = s;
        if (s.getMPMNumber().isEmpty()) goto _L6; else goto _L5
_L5:
        mChannelFoldersList = new ChannelFolderList(this, s.getParentChannelID());
_L8:
        return;
_L6:
        mState = DataRequest.RequestState.COMPLETE;
        mDataRequestListener.onDataSuccess("VideoDubSubtitleProcessor");
        return;
_L4:
        mState = DataRequest.RequestState.COMPLETE;
        mDataRequestListener.onDataSuccess("VideoDubSubtitleProcessor");
        return;
_L2:
        if (!s.equalsIgnoreCase("ChannelFolderList")) goto _L8; else goto _L7
_L7:
        s = mChannelFoldersList.getItems().iterator();
_L10:
        Iterator iterator;
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_325;
        }
        iterator = ((FolderItem)s.next()).getPlayLists().iterator();
_L12:
        if (!iterator.hasNext()) goto _L10; else goto _L9
_L9:
        Iterator iterator1 = ((PlayListItem)iterator.next()).getMediaList().iterator();
_L14:
        MediaListItem medialistitem;
        do
        {
            if (!iterator1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            medialistitem = (MediaListItem)iterator1.next();
            if (mDubbedItem == null)
            {
                continue; /* Loop/switch isn't completed */
            }
        } while (!medialistitem.getMPMNumber().equalsIgnoreCase(mDubbedItem.getMPMNumber()) || medialistitem.IsDubbed().booleanValue());
        break; /* Loop/switch isn't completed */
        if (true) goto _L12; else goto _L11
_L11:
        mMediaDetailsRequest = new MediaDetailsRequest(this, medialistitem.getID());
        return;
        if (mSubbedItem == null || !medialistitem.getMPMNumber().equalsIgnoreCase(mSubbedItem.getMPMNumber()) || !medialistitem.IsDubbed().booleanValue()) goto _L14; else goto _L13
_L13:
        mMediaDetailsRequest = new MediaDetailsRequest(this, medialistitem.getID());
        return;
        mState = DataRequest.RequestState.COMPLETE;
        mDataRequestListener.onDataSuccess("VideoDubSubtitleProcessor");
        return;
    }

    public void setCurrentCaptions(String s)
    {
        currentCaptions = s;
    }

    public void setCurrentItem(MediaDetailsItem mediadetailsitem)
    {
        mCurrentItem = mediadetailsitem;
    }

    public void setCurrentLanguage(String s)
    {
        currentLanguage = s;
    }
}
