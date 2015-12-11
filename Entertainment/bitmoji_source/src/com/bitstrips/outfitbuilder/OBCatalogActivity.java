// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.bitstrips.outfitbuilder.adapters.OBCatalogArrayAdapter;
import com.bitstrips.outfitbuilder.models.OBAvatarData;
import com.bitstrips.outfitbuilder.models.OBCatalog;
import com.bitstrips.outfitbuilder.models.OBOutfit;

// Referenced classes of package com.bitstrips.outfitbuilder:
//            OBFittingRoomActivity

public class OBCatalogActivity extends AppCompatActivity
{

    private static final int FITTING_ROOM_REQUEST_CODE = 5;
    private static final int NUMBER_OF_COLUMNS_IN_GRID = 3;
    private static final String TAG = "OBCatalogActivity";
    OBCatalogArrayAdapter adapter;
    OBAvatarData avatarData;
    OBCatalog catalog;
    private boolean disableBack;
    RecyclerView recyclerView;
    private int scrollPosition;

    public OBCatalogActivity()
    {
        scrollPosition = 0;
    }

    private GridLayoutManager createLayoutManager(final OBCatalogArrayAdapter adapter)
    {
        GridLayoutManager gridlayoutmanager = new GridLayoutManager(this, 3, 1, false);
        gridlayoutmanager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

            final OBCatalogActivity this$0;
            final OBCatalogArrayAdapter val$adapter;

            public int getSpanSize(int i)
            {
                return adapter.getSpanSizeForItem(i, 3);
            }

            
            {
                this$0 = OBCatalogActivity.this;
                adapter = obcatalogarrayadapter;
                super();
            }
        });
        return gridlayoutmanager;
    }

    public void goToFittingRoom(int i)
    {
        Intent intent = new Intent(this, com/bitstrips/outfitbuilder/OBFittingRoomActivity);
        intent.putExtra(OBFittingRoomActivity.INITIAL_OUTFIT_EXTRA, i);
        intent.putExtra("avatarDataExtra", avatarData);
        intent.putExtra("outfitCatalog", catalog);
        startActivityForResult(intent, 5);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 5 && j == -1)
        {
            setResult(-1, intent);
            finish();
        }
    }

    public void onBackPressed()
    {
        if (disableBack)
        {
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_obcatalog);
        avatarData = (OBAvatarData)getIntent().getParcelableExtra("avatarDataExtra");
        catalog = (OBCatalog)getIntent().getParcelableExtra("outfitCatalog");
        disableBack = getIntent().getBooleanExtra("disableBackCatalog", false);
        if (avatarData == null)
        {
            throw new Error("Cannot instantiate outfit builder without avatar id");
        }
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        setTitle(R.string.dress_your_avatar);
        bundle = getSupportActionBar();
        int i;
        boolean flag;
        if (!disableBack)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.setDisplayHomeAsUpEnabled(flag);
        adapter = new OBCatalogArrayAdapter(this, catalog) {

            final OBCatalogActivity this$0;

            public void onOutfitClicked(OBOutfit oboutfit)
            {
                goToFittingRoom(oboutfit.getId());
            }

            
            {
                this$0 = OBCatalogActivity.this;
                super(appcompatactivity, obcatalog);
            }
        };
        bundle = adapter;
        if (avatarData.getGender() == OBAvatarData.FEMALE)
        {
            i = R.drawable.silhouette_female;
        } else
        {
            i = R.drawable.silhouette_male;
        }
        bundle.setOutfitPlaceholder(i);
        recyclerView = (RecyclerView)findViewById(R.id.ob_catalog_recycler_view);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }

    public void onStart()
    {
        super.onStart();
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridlayoutmanager = createLayoutManager(adapter);
        recyclerView.setLayoutManager(gridlayoutmanager);
        recyclerView.scrollToPosition(scrollPosition);
    }

    public void onStop()
    {
        super.onStop();
        scrollPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
        recyclerView.setAdapter(null);
        recyclerView.setLayoutManager(null);
    }
}
