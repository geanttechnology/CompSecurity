// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import co.vine.android.api.VineUpload;
import co.vine.android.recorder.ProgressView;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.Util;
import co.vine.android.widgets.PromptDialogSupportFragment;
import com.edisonwang.android.slog.SLog;
import java.io.IOException;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment, PostActivity, PendingRequestHelper, UploadsAdapter, 
//            PendingCaptchaRequest

public class UploadsListFragment extends BaseCursorListFragment
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemLongClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{
    public class UploadListPendingRequestHelper extends BaseAdapterFragment.BasePendingRequestHelper
    {

        final UploadsListFragment this$0;

        public void handleFailedCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
        {
            if (mListView != null && mListView.getChildCount() > mListView.getHeaderViewsCount())
            {
                pendingcaptcharequest = mListView.getChildAt(mListView.getHeaderViewsCount());
                if (pendingcaptcharequest != null)
                {
                    ProgressBar progressbar = (ProgressBar)pendingcaptcharequest.findViewById(0x7f0a0030);
                    if (progressbar != null)
                    {
                        progressbar.setVisibility(8);
                    }
                    pendingcaptcharequest = (ImageView)pendingcaptcharequest.findViewById(0x7f0a0229);
                    if (pendingcaptcharequest != null)
                    {
                        pendingcaptcharequest.setVisibility(0);
                    }
                }
            }
        }

        public void handleRetryCaptchaRequest(PendingCaptchaRequest pendingcaptcharequest)
        {
            pendingcaptcharequest = mCursorAdapter.getCursor();
            if (pendingcaptcharequest.moveToFirst())
            {
                handleRetryPost(pendingcaptcharequest, true);
            }
        }

        public volatile void hideProgress(int i)
        {
            super.hideProgress(i);
        }

        public volatile void showProgress(int i)
        {
            super.showProgress(i);
        }

        public UploadListPendingRequestHelper()
        {
            this$0 = UploadsListFragment.this;
            super(UploadsListFragment.this);
        }
    }

    private class UploadProgressHandler extends Handler
    {

        final UploadsListFragment this$0;

        public void handleMessage(Message message)
        {
            int i;
            i = message.what;
            message = (Bundle)message.obj;
            SLog.dWithTag("UploadsListFragment", (new StringBuilder()).append("Message received, what=").append(i).toString());
            i;
            JVM INSTR tableswitch 6 7: default 64
        //                       6 65
        //                       7 184;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            if (mStatusMessage != null && mProgressView != null)
            {
                double d = message.getDouble("upload_progress");
                SLog.dWithTag("UploadsListFragment", (new StringBuilder()).append("Upload progress changed to p=").append(d).toString());
                if (mProgressViewWidth == 0)
                {
                    mProgressViewWidth = mProgressView.getMeasuredWidth();
                }
                mProgressView.setProgressRatio((float)((0.97999999999999998D * d) / 100D));
                mStatusMessage.setText(getString(0x7f0e0260));
                return;
            }
              goto _L1
_L3:
            boolean flag = message.getBoolean("success");
            SLog.dWithTag("UploadsListFragment", (new StringBuilder()).append("Post completed, success=").append(flag).toString());
            sendMessage(Message.obtain(null, 2));
            if (flag)
            {
                mStatusMessage.setText(getString(0x7f0e025f));
                return;
            } else
            {
                resetFailedUpload();
                return;
            }
        }

        private UploadProgressHandler()
        {
            this$0 = UploadsListFragment.this;
            super();
        }

    }


    private static final int DIALOG_CONFIRM_DELETE = 1;
    private static final String TAG = "UploadsListFragment";
    private boolean mBound;
    private ServiceConnection mConnection;
    private Messenger mIncomingMessenger;
    private String mPath;
    private ProgressView mProgressView;
    private int mProgressViewWidth;
    private String mReference;
    private ImageView mRefreshIcon;
    private Messenger mServiceMessenger;
    private TextView mStatusMessage;
    private RecordSessionVersion mVersions[];

    public UploadsListFragment()
    {
        mProgressViewWidth = 0;
    }

    private void handleRetryPost(Cursor cursor, boolean flag)
    {
        mPath = cursor.getString(1);
        int i = cursor.getInt(3);
        cursor = VineUpload.fromCursor(mPath, cursor);
        if (i == 0)
        {
            cursor = VineUploadService.getUploadIntent(getActivity(), ((VineUpload) (cursor)).path, ((VineUpload) (cursor)).hash, ((VineUpload) (cursor)).thumbnailPath, ((VineUpload) (cursor)).reference, false, -1L);
            getActivity().startService(cursor);
            return;
        }
        if (TextUtils.isEmpty(((VineUpload) (cursor)).postInfo))
        {
            cursor = PostActivity.getIntent(getActivity(), ((VineUpload) (cursor)).path, ((VineUpload) (cursor)).thumbnailPath, null, true, false);
            getActivity().startActivityForResult(cursor, 0);
            return;
        }
        if (TextUtils.isEmpty(((VineUpload) (cursor)).captchaUrl) || flag)
        {
            cursor = VineUploadService.getPostIntent(getActivity(), cursor, true);
            getActivity().startService(cursor);
            return;
        } else
        {
            mPendingRequestHelper.onCaptchaRequired(getActivity(), mPath, 0, null, ((VineUpload) (cursor)).captchaUrl);
            return;
        }
    }

    private void resetFailedUpload()
    {
        if (mStatusMessage != null && mRefreshIcon != null && mProgressView != null)
        {
            mStatusMessage.setText(getString(0x7f0e025e));
            mRefreshIcon.setVisibility(0);
            mProgressView.setProgressRatio(0.0F);
        }
    }

    private void sendMessage(Message message)
    {
        try
        {
            mServiceMessenger.send(message);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return;
        }
    }

    protected PendingRequestHelper createPendingRequestHelper()
    {
        return new UploadListPendingRequestHelper();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        if (mCursorAdapter == null)
        {
            mCursorAdapter = new UploadsAdapter(bundle, mAppController, 0);
        }
        ListView listview;
        try
        {
            mVersions = RecordSessionVersion.getValuesWithManagers(bundle);
        }
        catch (IOException ioexception)
        {
            Util.showCenteredToast(bundle, 0x7f0e0231);
            bundle.finish();
        }
        bundle = LayoutInflater.from(bundle).inflate(0x7f03009e, mListView, false);
        ((TextView)bundle.findViewById(0x7f0a004a)).setText(0x7f0e025b);
        listview = mListView;
        listview.addHeaderView(bundle, null, false);
        listview.setBackgroundColor(getResources().getColor(0x7f090093));
        listview.setDividerHeight(0);
        listview.setOnItemLongClickListener(this);
        listview.setAdapter(mCursorAdapter);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (!mPendingRequestHelper.onActivityResult(i, j, intent) && j == 0)
        {
            resetFailedUpload();
        }
    }

    public void onClick(View view)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mIncomingMessenger = new Messenger(new UploadProgressHandler());
        mBound = false;
        mConnection = new ServiceConnection() {

            final UploadsListFragment this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                SLog.dWithTag("UploadsListFragment", "Bind VineUploadService successful!");
                mServiceMessenger = new Messenger(ibinder);
                mBound = true;
                componentname = Message.obtain(null, 1);
                componentname.replyTo = mIncomingMessenger;
                sendMessage(componentname);
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                SLog.dWithTag("UploadsListFragment", "Connection to VineUploadService lost unexpectedly!");
                mServiceMessenger = null;
                mBound = false;
            }

            
            {
                this$0 = UploadsListFragment.this;
                super();
            }
        };
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getActivity(), co.vine.android.provider.VineUploads.Uploads.CONTENT_URI, co.vine.android.provider.VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, "status=? AND is_private=?", new String[] {
            String.valueOf(2), "0"
        }, "_id ASC");
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        switch (i)
        {
        case 1: // '\001'
            switch (j)
            {
            default:
                return;

            case -1: 
                dialoginterface = getActivity().getApplicationContext();
                try
                {
                    if (!TextUtils.isEmpty(mReference))
                    {
                        RecordSessionVersion.deleteSessionWithName(dialoginterface, mReference);
                    }
                }
                catch (IOException ioexception)
                {
                    SLog.e("Failed to delete session.");
                }
                getActivity().startService(VineUploadService.getDiscardIntent(dialoginterface, mPath));
                return;

            case -2: 
                break;
            }
            break;
        }
        while (true) 
        {
            return;
        }
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        view = mCursorAdapter.getCursor();
        if (view.moveToPosition(i - ((ListView)adapterview).getHeaderViewsCount()))
        {
            mPath = view.getString(1);
            mReference = view.getString(11);
            adapterview = PromptDialogSupportFragment.newInstance(1);
            adapterview.setListener(this);
            adapterview.setMessage(0x7f0e00af);
            adapterview.setPositiveButton(0x7f0e0288);
            adapterview.setNegativeButton(0x7f0e0057);
            adapterview.show(getChildFragmentManager());
            return true;
        } else
        {
            return false;
        }
    }

    public void onListItemClick(ListView listview, View view, int i, long l)
    {
        Cursor cursor = mCursorAdapter.getCursor();
        if (i - listview.getHeaderViewsCount() == 0 && cursor.moveToFirst())
        {
            mPath = cursor.getString(1);
            mProgressView = (ProgressView)view.findViewById(0x7f0a00c6);
            listview = (ImageView)view.findViewById(0x7f0a0229);
            listview.setVisibility(8);
            mRefreshIcon = listview;
            listview = (TextView)view.findViewById(0x7f0a0228);
            listview.setText(getString(0x7f0e0261).toUpperCase());
            mStatusMessage = listview;
            handleRetryPost(cursor, false);
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        super.onLoadFinished(loader, cursor);
        hideProgress(3);
        if (isEmpty())
        {
            showSadface(true, false);
            getActivity().startService(VineUploadService.getClearNotificationsIntent(getActivity()));
            return;
        } else
        {
            showSadface(false);
            return;
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onPause()
    {
        super.onPause();
        if (mBound)
        {
            SLog.dWithTag("UploadsListFragment", "Will unbind from VineUploadService now");
            sendMessage(Message.obtain(null, 2));
            getActivity().unbindService(mConnection);
            mBound = false;
        }
    }

    public void onResume()
    {
        super.onResume();
        if (mCursorAdapter.getCursor() == null)
        {
            initLoader();
        }
        if (!mBound)
        {
            SLog.dWithTag("UploadsListFragment", "Will bind to VineUploadService now");
            Intent intent = new Intent(getActivity(), co/vine/android/service/VineUploadService);
            getActivity().bindService(intent, mConnection, 1);
        }
    }


/*
    static Messenger access$102(UploadsListFragment uploadslistfragment, Messenger messenger)
    {
        uploadslistfragment.mServiceMessenger = messenger;
        return messenger;
    }

*/


/*
    static boolean access$202(UploadsListFragment uploadslistfragment, boolean flag)
    {
        uploadslistfragment.mBound = flag;
        return flag;
    }

*/







/*
    static int access$702(UploadsListFragment uploadslistfragment, int i)
    {
        uploadslistfragment.mProgressViewWidth = i;
        return i;
    }

*/


}
