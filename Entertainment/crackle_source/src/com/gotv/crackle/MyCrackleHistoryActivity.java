// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.gotv.crackle.adapters.HistoryListAdapter;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.dialogs.ConfirmationDialogFragment;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.helpers.MyCrackleViewHelper;
import com.gotv.crackle.model.BrowseModel;
import java.util.List;

// Referenced classes of package com.gotv.crackle:
//            Application, DetailsActivityResolver

public class MyCrackleHistoryActivity extends BaseActivity
    implements com.gotv.crackle.dialogs.ConfirmationDialogFragment.ConfirmationDialogFragmentListener
{

    private QueueManager mHistoryManager;
    private android.view.View.OnClickListener mItemClickListener;
    private ListView mListView;
    private android.view.View.OnClickListener mPlayItemListener;
    private ProgressBar mProgressBar;

    public MyCrackleHistoryActivity()
    {
        mItemClickListener = new android.view.View.OnClickListener() {

            final MyCrackleHistoryActivity this$0;

            public void onClick(View view)
            {
                launchMediaDetails(view);
            }

            
            {
                this$0 = MyCrackleHistoryActivity.this;
                super();
            }
        };
        mPlayItemListener = new android.view.View.OnClickListener() {

            final MyCrackleHistoryActivity this$0;

            public void onClick(View view)
            {
                view = (BrowseModel)view.getTag();
                playMediaItem(view.getID());
            }

            
            {
                this$0 = MyCrackleHistoryActivity.this;
                super();
            }
        };
    }

    public void clearHistory()
    {
        String s = CrackleAccountManager.getUserID();
        if (s != null)
        {
            mHistoryManager = new QueueManager(this, s);
            mHistoryManager.clearUserHistory();
        }
    }

    public void clearList()
    {
        if (mListView != null)
        {
            mListView.setAdapter(null);
        }
    }

    public void fetchHistoryData()
    {
        String s = CrackleAccountManager.getUserID();
        if (s != null)
        {
            mHistoryManager = new QueueManager(this, s);
            mHistoryManager.getUserHistory();
        }
    }

    public void init()
    {
        if (Application.isLeanBack())
        {
            mRootView = findViewById(0x1020002);
            mRootView.setPadding(Application.getDisplayIndependantPixelSize(20), mRootView.getPaddingTop(), Application.getDisplayIndependantPixelSize(20), Application.getDisplayIndependantPixelSize(20));
            mRootView.setBackgroundColor(getResources().getColor(0x106000c));
        }
        setActionBarTitle(getResources().getString(0x7f0b0119));
        mProgressBar = (ProgressBar)findViewById(0x7f0a00a2);
        mListView = (ListView)findViewById(0x7f0a0071);
    }

    protected void launchMediaDetails(View view)
    {
        String s = ((BrowseModel)view.getTag()).getID();
        view = ((BrowseModel)view.getTag()).getRootChannelID();
        Intent intent = new Intent(this, com/gotv/crackle/DetailsActivityResolver);
        intent.putExtra("MEDIA_ITEM_ID", s);
        intent.putExtra("ROOT_CHANNEL", view);
        startActivity(intent);
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004b);
        init();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0f0001, menu);
        mChromeCastHelper.setupMenuItem(menu);
        return true;
    }

    public void onDataSuccess(String s)
    {
        if (s.compareTo("HISTORY_WATCHLIST") == 0)
        {
            runOnUiThread(new Runnable() {

                final MyCrackleHistoryActivity this$0;

                public void run()
                {
                    mListView.setAdapter(new HistoryListAdapter(MyCrackleHistoryActivity.this, mHistoryManager.getItems(), mItemClickListener, mPlayItemListener));
                    mProgressBar.setVisibility(4);
                    if (mHistoryManager.getItems().size() == 0)
                    {
                        Toast.makeText(MyCrackleHistoryActivity.this, getResources().getString(0x7f0b0103), 0).show();
                    }
                }

            
            {
                this$0 = MyCrackleHistoryActivity.this;
                super();
            }
            });
            return;
        }
        if (s.compareTo("GENERAL_QUEUE") == 0)
        {
            runOnUiThread(new Runnable() {

                final MyCrackleHistoryActivity this$0;

                public void run()
                {
                    clearList();
                }

            
            {
                this$0 = MyCrackleHistoryActivity.this;
                super();
            }
            });
            return;
        } else
        {
            super.onDataSuccess(s);
            return;
        }
    }

    public void onNegativeClick()
    {
        clearHistory();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x7f0a01b7)
        {
            sMyCrackleHelper.showSigInOut(this, menuitem);
        } else
        {
            performMenuAction(i);
        }
        return true;
    }

    public void onPositiveClick()
    {
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem = menu.findItem(0x7f0a01b4);
        MyCrackleViewHelper mycrackleviewhelper = sMyCrackleHelper;
        if (!MyCrackleViewHelper.isEnableSessionM())
        {
            menuitem.setVisible(false);
        }
        menu = menu.findItem(0x7f0a01b7);
        if (CrackleAccountManager.isLoggedIn())
        {
            menu.setTitle(getResources().getString(0x7f0b0066));
        } else
        {
            menu.setTitle(getResources().getString(0x7f0b0065));
        }
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        fetchHistoryData();
    }

    protected void performMenuAction(int i)
    {
        if (i == 0x102002c)
        {
            finish();
        } else
        {
            if (i == 0x7f0a01b2)
            {
                ConfirmationDialogFragment confirmationdialogfragment = ConfirmationDialogFragment.newInstance(0x7f0b0101, 0x7f0b0102);
                confirmationdialogfragment.setOnConfirmationDialogClickListener(this);
                confirmationdialogfragment.show(getSupportFragmentManager(), null);
                return;
            }
            if (i == 0x7f0a01b3)
            {
                sMyCrackleHelper.showSettings(this);
                return;
            }
            if (i == 0x7f0a01b4)
            {
                sMyCrackleHelper.showSessionMPortal();
                return;
            }
            if (i == 0x7f0a01b5)
            {
                sMyCrackleHelper.showGiveFeedback(this);
                return;
            }
            if (i == 0x7f0a01b6)
            {
                sMyCrackleHelper.showAboutCrackle(this);
                return;
            }
        }
    }





}
