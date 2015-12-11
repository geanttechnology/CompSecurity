// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import butterknife.ButterKnife;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.BitshopPack;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.services.BitshopGooglePlayService;
import com.bitstrips.imoji.ui.adapters.PackAdapter;
import com.bitstrips.imoji.ui.adapters.PolyAdapter;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.ui:
//            IntentCreatorService

public class BitshopActivity extends AppCompatActivity
    implements com.bitstrips.imoji.services.BitshopGooglePlayService.PacksListener
{

    private static final String TAG = "BitshopActivity";
    AnalyticsService analytics;
    BitshopGooglePlayService bitshopGooglePlayService;
    FacebookService facebookService;
    IntentCreatorService intentCreatorService;
    private PackAdapter mAdapter;
    private LinkedList mItemList;
    RecyclerView mPackListView;
    TemplatesManager templatesManager;
    Toolbar toolbar;

    public BitshopActivity()
    {
    }

    private LinkedList createAdapterList()
    {
        LinkedList linkedlist = new LinkedList();
        boolean flag = true;
        Iterator iterator = templatesManager.getPacks().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BitshopPack bitshoppack = (BitshopPack)iterator.next();
            if (bitshoppack != null)
            {
                linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem(bitshoppack.getName(), bitshoppack, 1));
                for (Iterator iterator1 = bitshoppack.getTemplates().iterator(); iterator1.hasNext();)
                {
                    Object obj = (Imoji)iterator1.next();
                    boolean flag1 = flag;
                    if (flag)
                    {
                        flag1 = false;
                    }
                    obj = new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("THEME PACKS", ((Imoji) (obj)), 2, "#purchased");
                    ((com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem) (obj)).setPack(bitshoppack);
                    linkedlist.add(obj);
                    flag = flag1;
                }

                linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem(bitshoppack.getName(), bitshoppack, 5));
            }
        } while (true);
        if (flag)
        {
            linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("THEME PACKS", 4));
        }
        return linkedlist;
    }

    private void createBitshopPackListView()
    {
        mPackListView.setHasFixedSize(true);
        mItemList = createAdapterList();
        mAdapter = new PackAdapter(this, mItemList);
        mAdapter.setPackClickListener(new com.bitstrips.imoji.ui.adapters.PackAdapter.PackClickListener() {

            final BitshopActivity this$0;

            public void onPackClick(BitshopPack bitshoppack)
            {
                purchasePack(bitshoppack);
            }

            
            {
                this$0 = BitshopActivity.this;
                super();
            }
        });
        mPackListView.setAdapter(mAdapter);
        mPackListView.setLayoutManager(createLayoutManager(mAdapter));
    }

    private GridLayoutManager createLayoutManager(final PolyAdapter adapter)
    {
        GridLayoutManager gridlayoutmanager = new GridLayoutManager(this, 3, 1, false);
        gridlayoutmanager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

            final BitshopActivity this$0;
            final PolyAdapter val$adapter;

            public int getSpanSize(int i)
            {
                return adapter.getSpanSizeForItem(i);
            }

            
            {
                this$0 = BitshopActivity.this;
                adapter = polyadapter;
                super();
            }
        });
        return gridlayoutmanager;
    }

    private void refreshPackAdapter()
    {
        if (mAdapter != null)
        {
            mAdapter.setDataList(createAdapterList());
            mAdapter.notifyDataSetChanged();
        }
    }

    private void scrollToPack()
    {
        int j = getIntent().getIntExtra("universal_pack_id", 0);
        if (j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        byte byte0 = -1;
        Iterator iterator = mItemList.iterator();
        com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem polyimojiitem;
        BitshopPack bitshoppack;
        do
        {
            i = byte0;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            polyimojiitem = (com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem)iterator.next();
            bitshoppack = polyimojiitem.getPack();
        } while (bitshoppack == null || bitshoppack.getUniversalPackId() != j);
        i = mItemList.indexOf(polyimojiitem);
        if (i == -1) goto _L1; else goto _L3
_L3:
        mPackListView.smoothScrollToPosition(i);
        return;
    }

    public void displayAlertDialog(String s)
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(null).setMessage(s).setNeutralButton(0x104000a, null).show();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 1001)
        {
            bitshopGooglePlayService.processIABResponse(j, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        setContentView(0x7f03001c);
        ButterKnife.bind(this);
        Fabric.with(this, new Kit[] {
            new Crashlytics()
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(0x7f020045);
        getSupportActionBar().setTitle("");
        createBitshopPackListView();
        analytics.sendEvent(Category.BITSHOP, Action.BITSHOP_OPENED, null);
        bitshopGooglePlayService.addListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0e0001, menu);
        return true;
    }

    public void onDestroy()
    {
        super.onDestroy();
        bitshopGooglePlayService.removeListener(this);
    }

    public void onErrorConnectingToGooglePlay()
    {
        findViewById(0x7f0b0086).setVisibility(0);
        mPackListView.setVisibility(8);
    }

    public void onErrorPurchasingPack(int i)
    {
        displayAlertDialog(getString(i));
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            return true;

        case 2131427602: 
            intentCreatorService.goToSupportPage(this);
            break;
        }
        return true;
    }

    public void onPacksSynced()
    {
        refreshPackAdapter();
        scrollToPack();
    }

    protected void onPause()
    {
        super.onPause();
        facebookService.logDeactivate(this);
    }

    public void onResume()
    {
        super.onResume();
        facebookService.logActivate(this);
    }

    protected void onStart()
    {
        super.onStart();
        analytics.reportStart(this);
    }

    protected void onStop()
    {
        analytics.reportStop(this);
        super.onStop();
    }

    public void purchasePack(BitshopPack bitshoppack)
    {
        if (bitshoppack == null)
        {
            return;
        } else
        {
            bitshopGooglePlayService.startPackPurchase(this, bitshoppack);
            return;
        }
    }
}
