// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.widget.ListView;
import co.vine.android.api.VineRecipient;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.VineAPI;
import co.vine.android.util.Util;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment, RecipientPickerActivity, PendingRequest, FriendsPickerAdapter

public abstract class BaseRecipientPickerFragment extends BaseCursorListFragment
    implements android.widget.AdapterView.OnItemClickListener
{
    private class RecipientPickerSessionListener extends AppSessionListener
    {

        final BaseRecipientPickerFragment this$0;

        public void onGetFriendsTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
        {
            BaseRecipientPickerFragment.this.onGetFriendsTypeAheadComplete(s2, arraylist);
        }

        public void onGetUsersComplete(Session session, String s, int i, String s1, int j, ArrayList arraylist, int k, 
                int l, long l1)
        {
            session = removeRequest(s);
            if (session != null)
            {
                onGetFriendsComplete(i);
                hideProgress(((PendingRequest) (session)).fetchType);
                switch (i)
                {
                default:
                    hideProgress(3);
                    if (!TextUtils.isEmpty(s1))
                    {
                        Util.showCenteredToast(getActivity(), s1);
                    }
                    break;

                case 200: 
                    break;
                }
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            if (mCursorAdapter instanceof FriendsPickerAdapter)
            {
                ((FriendsPickerAdapter)mCursorAdapter).setUserImages(hashmap);
            }
        }

        private RecipientPickerSessionListener()
        {
            this$0 = BaseRecipientPickerFragment.this;
            super();
        }

    }


    protected static final String ARG_QUERY = "filter";
    public static final String ARG_TAG = "tag";
    protected static final long FILTER_THRESHOLD_MS = 150L;
    protected Uri mContentUri;
    protected String mEncodedQueryString;
    protected Handler mHandler;
    protected String mProjection[];
    protected String mQueryString;
    protected String mSelArgs[];
    protected String mSelection;
    protected String mSortOrder;

    public BaseRecipientPickerFragment()
    {
    }

    protected void addRecipient(VineRecipient vinerecipient)
    {
        RecipientPickerActivity recipientpickeractivity = getCallback();
        if (recipientpickeractivity != null)
        {
            recipientpickeractivity.addRecipient(vinerecipient);
        }
    }

    public RecipientPickerActivity getCallback()
    {
        return (RecipientPickerActivity)super.getActivity();
    }

    protected abstract void handleFocus();

    protected boolean isRecipientSelected(VineRecipient vinerecipient)
    {
        RecipientPickerActivity recipientpickeractivity = getCallback();
        return recipientpickeractivity != null && recipientpickeractivity.isRecipientSelected(vinerecipient);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mListView.setOnItemClickListener(this);
        mListView.setDividerHeight(0);
        mAppSessionListener = new RecipientPickerSessionListener();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mHandler = new Handler(Looper.getMainLooper());
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getActivity(), mContentUri, mProjection, mSelection, mSelArgs, mSortOrder);
    }

    protected void onGetFriendsComplete(int i)
    {
    }

    abstract void onGetFriendsTypeAheadComplete(String s, ArrayList arraylist);

    public void onMoveTo(int i)
    {
        super.onMoveTo(i);
        handleFocus();
    }

    public abstract void onRecipientItemRemoved(VineRecipient vinerecipient);

    public void onResume()
    {
        super.onResume();
        handleFocus();
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        mHandler.removeCallbacksAndMessages(null);
    }

    protected void removeRecipient(VineRecipient vinerecipient)
    {
        RecipientPickerActivity recipientpickeractivity = getCallback();
        if (recipientpickeractivity != null)
        {
            recipientpickeractivity.removeRecipient(vinerecipient);
        }
    }

    public void setQueryText(String s)
    {
        mQueryString = s;
        mEncodedQueryString = VineAPI.encode(s.trim());
    }
}
