// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.bitstrips.outfitbuilder.managers.OBUrlsManager;
import com.bitstrips.outfitbuilder.models.OBAvatarData;
import com.bitstrips.outfitbuilder.models.OBBrand;
import com.bitstrips.outfitbuilder.models.OBCatalog;
import com.bitstrips.outfitbuilder.models.OBCatalogItem;
import com.bitstrips.outfitbuilder.models.OBOutfit;
import com.bitstrips.outfitbuilder.models.OBShowcaseItem;
import com.bitstrips.outfitbuilder.models.OBShowcaseItems;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Iterator;

public class OBAssetsPreloaderIntentService extends IntentService
{

    private static final String ACTION_FETCH_AVATAR_DEPENDENT_ASSETS = "com.bitstrips.outfitbuilder.services.action.ACTION_FETCH_AVATAR_DEPENDENT_ASSETS";
    private static final String ACTION_FETCH_CATALOG_ASSETS = "com.bitstrips.outfitbuilder.services.action.ACTION_FETCH_CATALOG_ASSETS";
    private static final String EXTRA_AVATAR_DATA = "com.bitstrips.outfitbuilder.services.extra.AVATAR_DATA";
    private static final String EXTRA_CATALOG = "com.bitstrips.outfitbuilder.services.extra.CATALOG";
    private static final String EXTRA_FEMALE_CATALOG = "com.bitstrips.outfitbuilder.services.extra.FEMALE_CATALOG";
    private static final String EXTRA_MALE_CATALOG = "com.bitstrips.outfitbuilder.services.extra.MALE_CATALOG";

    public OBAssetsPreloaderIntentService()
    {
        super("OutfitBuilderAssetsPreloaderIntentService");
    }

    private void downloadAssetFromQueue(ArrayList arraylist, Picasso picasso)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); picasso.load((String)arraylist.next()).resize(1, 1).fetch()) { }
    }

    private void handleActionFetchAvatarDependentAssets(OBAvatarData obavatardata, OBCatalog obcatalog)
    {
        OBUrlsManager oburlsmanager = OBUrlsManager.getInstance();
        ArrayList arraylist = new ArrayList();
        arraylist.add(oburlsmanager.getNakedOutfit(obavatardata));
        arraylist.add(oburlsmanager.getHeadBackUrl(obavatardata.getId()));
        arraylist.add(oburlsmanager.getHeadFrontUrl(obavatardata.getId()));
        for (obcatalog = obcatalog.getItems().iterator(); obcatalog.hasNext();)
        {
            Iterator iterator = ((OBCatalogItem)obcatalog.next()).getOutfits().iterator();
            while (iterator.hasNext()) 
            {
                int i = ((OBOutfit)iterator.next()).getId();
                arraylist.add(oburlsmanager.getOutfitUrl(i, obavatardata));
                arraylist.add(oburlsmanager.getFloatingOutfitUrl(i, obavatardata));
            }
        }

        downloadAssetFromQueue(arraylist, Picasso.with(getApplicationContext()));
    }

    private void handleActionFetchCatalogAssets(OBCatalog obcatalog, OBCatalog obcatalog1)
    {
        preloadCatalogAssets(obcatalog1);
        preloadCatalogAssets(obcatalog);
    }

    private void preloadCatalogAssets(OBCatalog obcatalog)
    {
        if (obcatalog == null)
        {
            return;
        }
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = obcatalog.getShowcase().iterator(); iterator.hasNext(); arraylist.add(((OBShowcaseItem)iterator.next()).getImageURL())) { }
        for (obcatalog = obcatalog.getItems().iterator(); obcatalog.hasNext();)
        {
            Object obj = (OBCatalogItem)obcatalog.next();
            OBBrand obbrand = ((OBCatalogItem) (obj)).getBrand();
            arraylist.add(obbrand.getHeaderLogo());
            arraylist.add(obbrand.getHeaderBackground());
            arraylist.add(obbrand.getStoreBackground());
            obj = ((OBCatalogItem) (obj)).getOutfits().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                OBOutfit oboutfit = (OBOutfit)((Iterator) (obj)).next();
                arraylist.add(oboutfit.getImageURL());
                arraylist.add(oboutfit.getSublogoURL());
            }
        }

        downloadAssetFromQueue(arraylist, Picasso.with(getApplicationContext()));
    }

    public static void startActionFetchAvatarDependentAssets(Context context, OBAvatarData obavatardata, OBCatalog obcatalog)
    {
        Intent intent = new Intent(context, com/bitstrips/outfitbuilder/services/OBAssetsPreloaderIntentService);
        intent.setAction("com.bitstrips.outfitbuilder.services.action.ACTION_FETCH_AVATAR_DEPENDENT_ASSETS");
        intent.putExtra("com.bitstrips.outfitbuilder.services.extra.AVATAR_DATA", obavatardata);
        intent.putExtra("com.bitstrips.outfitbuilder.services.extra.CATALOG", obcatalog);
        context.startService(intent);
    }

    public static void startActionFetchCatalogAssets(Context context, OBCatalog obcatalog, OBCatalog obcatalog1)
    {
        Intent intent = new Intent(context, com/bitstrips/outfitbuilder/services/OBAssetsPreloaderIntentService);
        intent.setAction("com.bitstrips.outfitbuilder.services.action.ACTION_FETCH_CATALOG_ASSETS");
        intent.putExtra("com.bitstrips.outfitbuilder.services.extra.MALE_CATALOG", obcatalog);
        intent.putExtra("com.bitstrips.outfitbuilder.services.extra.FEMALE_CATALOG", obcatalog1);
        context.startService(intent);
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent != null)
        {
            String s = intent.getAction();
            if ("com.bitstrips.outfitbuilder.services.action.ACTION_FETCH_CATALOG_ASSETS".equals(s))
            {
                handleActionFetchCatalogAssets((OBCatalog)intent.getParcelableExtra("com.bitstrips.outfitbuilder.services.extra.MALE_CATALOG"), (OBCatalog)intent.getParcelableExtra("com.bitstrips.outfitbuilder.services.extra.FEMALE_CATALOG"));
            } else
            if ("com.bitstrips.outfitbuilder.services.action.ACTION_FETCH_AVATAR_DEPENDENT_ASSETS".equals(s))
            {
                handleActionFetchAvatarDependentAssets((OBAvatarData)intent.getParcelableExtra("com.bitstrips.outfitbuilder.services.extra.AVATAR_DATA"), (OBCatalog)intent.getParcelableExtra("com.bitstrips.outfitbuilder.services.extra.CATALOG"));
                return;
            }
        }
    }
}
