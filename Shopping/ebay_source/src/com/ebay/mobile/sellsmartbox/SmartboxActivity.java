// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ebay.app.ModalProgressFragment;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.RlProductInfoDataManager;
import com.ebay.common.model.EbaySuggestedCategory;
import com.ebay.common.net.AsyncList;
import com.ebay.common.net.api.catalog.MatchProductLoader;
import com.ebay.common.net.api.finding.PagedList;
import com.ebay.common.net.api.product.GetProductDetailsLoader;
import com.ebay.common.net.api.product.GetProductDetailsReponse;
import com.ebay.common.net.api.trading.GetSuggestedCategoriesNetLoader;
import com.ebay.common.net.api.trading.GetSuggestedCategoriesResponse;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.sell.CategoryDialogFragment;
import com.ebay.mobile.sell.ListingFragmentActivity;
import com.ebay.mobile.sellsmartbox.widget.SmartEditBox;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ScanResult;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.lds.ListingCategoryFilters;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            SmartboxResultsAdapter, ProductsPagedListLoader, KeywordSuggestionAdapter

public class SmartboxActivity extends BaseActivity
    implements com.ebay.common.content.dm.RlProductInfoDataManager.Observer, com.ebay.common.net.AsyncList.NetworkListObserver, com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogHost, com.ebay.mobile.util.ContentSyncManager.ContentSync
{
    public class SmartboxCell
        implements android.content.DialogInterface.OnCancelListener, android.view.View.OnClickListener, android.view.View.OnKeyListener, android.widget.AbsListView.OnScrollListener, android.widget.AdapterView.OnItemClickListener, com.ebay.mobile.sellsmartbox.widget.SmartEditBox.OnSoftKeyDismissListener
    {

        private boolean canScanBarcode;
        private Drawable cancelDrawable;
        public View progress;
        private ListView resultsList;
        public View scanButton;
        private Drawable searchDrawable;
        private AutoCompleteTextView smartbox;
        protected TextWatcher textWatcher;
        private boolean textWatcherRegistered;
        final SmartboxActivity this$0;

        protected void addTextWatcher()
        {
            if (textWatcherRegistered)
            {
                return;
            } else
            {
                smartbox.addTextChangedListener(textWatcher);
                textWatcherRegistered = true;
                return;
            }
        }

        public void closeAndFinish()
        {
            smartbox.clearFocus();
            Util.hideSoftInput(SmartboxActivity.this, smartbox);
            finish();
        }

        public SmartboxResultsAdapter.SmartboxResult getResult(int i)
        {
            return (SmartboxResultsAdapter.SmartboxResult)resultsList.getAdapter().getItem(i);
        }

        public String getSmartboxText()
        {
            return smartbox.getText().toString();
        }

        public void hideSuggestions()
        {
            (new Handler()).post(new Runnable() {

                final SmartboxCell this$1;

                public void run()
                {
                    smartbox.dismissDropDown();
                }

            
            {
                this$1 = SmartboxCell.this;
                super();
            }
            });
        }

        public void onCancel(DialogInterface dialoginterface)
        {
            dialoginterface = getFwLoaderManager().getRunningLoader(1);
            if (dialoginterface != null)
            {
                dialoginterface.cancel(true);
            }
            ModalProgressFragment.hide(getFragmentManager());
        }

        public void onClick(View view)
        {
            switch (view.getId())
            {
            default:
                return;

            case 2131755947: 
                closeAndFinish();
                return;

            case 2131756814: 
                emitTracking = false;
                break;
            }
            view = ScanResult.getScanActivityIntent(SmartboxActivity.this);
            startActivityForResult(view, 4);
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (adapterview.getAdapter() instanceof SmartboxResultsAdapter)
            {
                if (((SmartboxResultsAdapter)adapterview.getAdapter()).isCategoryItem(i))
                {
                    launchSuggestedCategories();
                } else
                {
                    if (((SmartboxResultsAdapter)adapterview.getAdapter()).isContinueItem(i))
                    {
                        continueToForm();
                        return;
                    }
                    view = cell.getResult(i);
                    if (view != null)
                    {
                        Intent intent = new Intent(SmartboxActivity.this, com/ebay/mobile/sell/ListingFragmentActivity);
                        if (ListingCategoryFilters.isMotorsCategoryPath(selectedCategoryIdPath))
                        {
                            adapterview = EbaySite.MOTOR;
                        } else
                        {
                            adapterview = MyApp.getPrefs().getCurrentSite();
                        }
                        intent.putExtra("site", adapterview);
                        intent.putExtra("epid", ((SmartboxResultsAdapter.SmartboxResult) (view)).epid);
                        startActivity(intent);
                        finish();
                        return;
                    }
                }
            }
        }

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            if (i != 66 || keyevent.getAction() != 1 || TextUtils.isEmpty(((AutoCompleteTextView)view).getText().toString()))
            {
                break MISSING_BLOCK_LABEL_176;
            }
            if (!NautilusKernel.isQaMode()) goto _L2; else goto _L1
_L1:
            view = null;
            keyevent = getSmartboxText();
            if (!keyevent.equalsIgnoreCase("qateguarantee")) goto _L4; else goto _L3
_L3:
            view = "53895546";
_L5:
            if (view != null)
            {
                keyevent = new Intent(SmartboxActivity.this, com/ebay/mobile/sell/ListingFragmentActivity);
                keyevent.putExtra("site", MyApp.getPrefs().getCurrentSite());
                keyevent.putExtra("epid", view);
                startActivity(keyevent);
                finish();
                return true;
            }
            break; /* Loop/switch isn't completed */
_L4:
            if (keyevent.equalsIgnoreCase("qateguarantee2"))
            {
                view = "49986037";
            } else
            if (keyevent.equalsIgnoreCase("qatefixed"))
            {
                view = "106654612";
            } else
            if (keyevent.equalsIgnoreCase("qatefixed2"))
            {
                view = "50017407";
            }
            if (true) goto _L5; else goto _L2
_L2:
            getSuggestedCategory();
            return true;
            return false;
        }

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(abslistview.getWindowToken(), 2);
        }

        public void onSoftKeyDismiss()
        {
            if (TextUtils.isEmpty(getSmartboxText()))
            {
                closeAndFinish();
            }
        }

        protected void removeTextWatcher()
        {
            if (textWatcherRegistered)
            {
                smartbox.removeTextChangedListener(textWatcher);
                textWatcherRegistered = false;
            }
        }

        public void resultsChanged()
        {
            resultsList.invalidateViews();
        }

        public void setSmartboxText(String s)
        {
            smartbox.setThreshold(1000);
            smartbox.setText(s);
            smartbox.setThreshold(1);
            smartbox.setSelection(smartbox.getText().length());
        }

        public void startProgress()
        {
            progress.setVisibility(0);
            resultsList.setVisibility(8);
            smartbox.clearFocus();
            smartbox.setEnabled(false);
        }

        protected void updateSmartboxButton()
        {
            Drawable drawable;
            if (!TextUtils.isEmpty(getSmartboxText()))
            {
                drawable = cancelDrawable;
            } else
            {
                drawable = null;
            }
            smartbox.setCompoundDrawablesWithIntrinsicBounds(searchDrawable, null, drawable, null);
        }

        public void updateWithResults(SmartboxResultsAdapter smartboxresultsadapter, int i)
        {
            progress.setVisibility(8);
            smartbox.setEnabled(true);
            if (smartboxresultsadapter == null)
            {
                resultsList.setVisibility(8);
                return;
            } else
            {
                resultsList.setAdapter(smartboxresultsadapter);
                resultsList.setVisibility(0);
                resultsList.setOnScrollListener(null);
                return;
            }
        }


        public SmartboxCell()
        {
            int i = 0;
            this$0 = SmartboxActivity.this;
            super();
            textWatcher = new _cls2();
            resultsList = (ListView)findViewById(0x102000a);
            resultsList.setOnItemClickListener(this);
            resultsList.setOnScrollListener(this);
            progress = findViewById(0x1020004);
            findViewById(0x7f1003ab).setOnClickListener(this);
            smartbox = (AutoCompleteTextView)findViewById(0x7f10070d);
            smartbox.setFilters(new InputFilter[] {
                new android.text.InputFilter.LengthFilter(80)
            });
            smartbox.setThreshold(1);
            smartbox.setOnKeyListener(this);
            smartbox.setAdapter(new KeywordSuggestionAdapter(SmartboxActivity.this, 0x7f030209, MyApp.getPrefs().getCurrentCountry()));
            smartbox.setOnItemClickListener(this);
            ((SmartEditBox)smartbox).setOnSoftKeyDismissListener(this);
            boolean flag;
            if (ScanResult.getScanActivityIntent(SmartboxActivity.this) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            canScanBarcode = flag;
            cancelDrawable = getResources().getDrawable(0x7f02023c);
            searchDrawable = getResources().getDrawable(0x7f02023b);
            scanButton = findViewById(0x7f10070e);
            scanButton.setOnClickListener(this);
            smartboxactivity = scanButton;
            if (!canScanBarcode)
            {
                i = 8;
            }
            setVisibility(i);
        }
    }


    public static final String EXTRA_CATEGORY_ID = "category_id";
    public static final String EXTRA_CATEGORY_ID_PATH = "category_id_path";
    public static final String EXTRA_CATEGORY_NAME_PATH = "category_name_path";
    private static final int GET_PRODUCTS = 4;
    private static final int GET_PRODUCT_DETAILS = 1;
    private static final int GET_PRODUCT_MATCHES = 5;
    private static final int GET_SUGGESTED_CATEGORIES_DETAILS = 3;
    private static final int REQUEST_SCAN_PRODUCT = 4;
    private static final int REQUEST_SELECT_CATEGORY = 2;
    private static final String STATE_BARCODE = "barcode";
    private static final String STATE_CATEGORY_ID = "category_id";
    private static final String STATE_EMIT_TRACKING = "tracking";
    private String barcode;
    protected SmartboxCell cell;
    private com.ebay.common.content.dm.RlProductInfoDataManager.ProdInfoQuery currentProdInfoQuery;
    protected boolean emitTracking;
    private AsyncList list;
    private RlProductInfoDataManager productInfoDataManager;
    private String selectedCategoryId;
    protected String selectedCategoryIdPath;
    private String selectedCategoryNamePath;

    public SmartboxActivity()
    {
        list = null;
        currentProdInfoQuery = null;
        selectedCategoryId = null;
        selectedCategoryIdPath = null;
        selectedCategoryNamePath = null;
    }

    private void OnGetProductDetailsComplete(GetProductDetailsLoader getproductdetailsloader)
    {
        ModalProgressFragment.hide(getFragmentManager());
        onGetProductDetailsComplete(getproductdetailsloader, true);
    }

    private void onGetProductDetailsComplete(GetProductDetailsLoader getproductdetailsloader, boolean flag)
    {
        if (getproductdetailsloader.isError() || getproductdetailsloader.getResponse() == null)
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            if (getproductdetailsloader.getBarcodeType() != null && flag && deviceconfiguration.get(DcsBoolean.RLKeywordFallback))
            {
                currentProdInfoQuery = new com.ebay.common.content.dm.RlProductInfoDataManager.ProdInfoQuery(MyApp.getPrefs().getCurrentSite(), getproductdetailsloader.getBarcode(), getproductdetailsloader.getBarcodeType());
                productInfoDataManager.getProductInfo(MyApp.getPrefs().getCurrentSite(), getproductdetailsloader.getBarcode(), getproductdetailsloader.getBarcodeType(), this);
                return;
            }
            if (EbayErrorUtil.productIdInvalid(getproductdetailsloader.getServiceErrorsAndWarnings()))
            {
                getproductdetailsloader = String.format(getString(0x7f070152), new Object[] {
                    barcode
                });
                ((DialogManager)getShim(com/ebay/common/view/util/DialogManager)).showDynamicAlertDialog(getString(0x7f070154), getproductdetailsloader, false);
                return;
            } else
            {
                showNetworkErrorToast();
                return;
            }
        } else
        {
            Object obj = new TrackingData("BarcodeScanningList", TrackingType.EVENT);
            ((TrackingData) (obj)).addKeyValuePair("bcd", getproductdetailsloader.getBarcode());
            ((TrackingData) (obj)).addKeyValuePair("bct", getproductdetailsloader.getBarcodeType());
            ((TrackingData) (obj)).addKeyValuePair("mfls", "SF");
            ((TrackingData) (obj)).send(this);
            obj = new Intent(this, com/ebay/mobile/sell/ListingFragmentActivity);
            ((Intent) (obj)).putExtra("site", MyApp.getPrefs().getCurrentSite());
            ((Intent) (obj)).putExtra("epid", ((GetProductDetailsReponse)getproductdetailsloader.getResponse()).epid);
            startActivity(((Intent) (obj)));
            finish();
            return;
        }
    }

    private void onGetProductMatchesComplete(MatchProductLoader matchproductloader)
    {
        if (matchproductloader.results == null || matchproductloader.results.isEmpty())
        {
            matchproductloader = new SmartboxResultsAdapter(this, 0x7f030222, new ArrayList(), matchproductloader.keywords, selectedCategoryNamePath);
            cell.updateWithResults(matchproductloader, 0);
            return;
        }
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = matchproductloader.results.iterator(); iterator.hasNext(); arraylist.add(ProductsPagedListLoader.convertProduct((com.ebay.common.net.api.findproduct.FindProductsResponse.ProductResult)iterator.next()))) { }
        matchproductloader = new SmartboxResultsAdapter(this, 0x7f030222, arraylist, matchproductloader.keywords, selectedCategoryNamePath);
        cell.updateWithResults(matchproductloader, arraylist.size());
    }

    private void onGetProductsComplete(ProductsPagedListLoader productspagedlistloader)
    {
        if (productspagedlistloader.list != null)
        {
            Object obj = new SmartboxResultsAdapter(this, 0x7f030222, productspagedlistloader.list, productspagedlistloader.keywords, selectedCategoryNamePath);
            if (productspagedlistloader.list.isEmpty())
            {
                if (productspagedlistloader.keywords.split(" ").length >= 3)
                {
                    boolean flag = ListingCategoryFilters.isMotorsCategoryPath(selectedCategoryIdPath);
                    com.ebay.common.net.api.catalog.CatalogMatchProductService catalogmatchproductservice;
                    if (flag)
                    {
                        obj = EbaySite.MOTOR;
                    } else
                    {
                        obj = MyApp.getPrefs().getCurrentSite();
                    }
                    catalogmatchproductservice = EbayApiUtil.getMatchProductService(this, ((EbaySite) (obj)));
                    if (flag)
                    {
                        obj = EbaySite.MOTOR;
                    } else
                    {
                        obj = MyApp.getPrefs().getCurrentSite();
                    }
                    obj = EbayApiUtil.getFindProductService(this, ((EbaySite) (obj)));
                    productspagedlistloader = new MatchProductLoader(getEbayContext(), catalogmatchproductservice, ((com.ebay.common.net.api.findproduct.FindProductService) (obj)), selectedCategoryId, productspagedlistloader.keywords);
                    getFwLoaderManager().start(5, productspagedlistloader, true);
                    return;
                } else
                {
                    productspagedlistloader = new SmartboxResultsAdapter(this, 0x7f030222, new ArrayList(), productspagedlistloader.keywords, selectedCategoryNamePath);
                    cell.updateWithResults(productspagedlistloader, 0);
                    return;
                }
            } else
            {
                cell.updateWithResults(((SmartboxResultsAdapter) (obj)), productspagedlistloader.list.size());
                registerListObserver(productspagedlistloader.list);
                return;
            }
        } else
        {
            cell.updateWithResults(null, 0);
            unregisterListObserver();
            return;
        }
    }

    private void onGetSuggestedCategoriesComplete(GetSuggestedCategoriesNetLoader getsuggestedcategoriesnetloader)
    {
        Object obj = null;
        if (getsuggestedcategoriesnetloader.isError() || getsuggestedcategoriesnetloader.getResponse() == null)
        {
            cell.updateWithResults(null, 0);
            List list1 = getsuggestedcategoriesnetloader.getServiceErrorsAndWarnings();
            getsuggestedcategoriesnetloader = obj;
            if (list1 != null)
            {
                getsuggestedcategoriesnetloader = obj;
                if (list1.size() > 0)
                {
                    getsuggestedcategoriesnetloader = ((EbayResponseError)list1.get(0)).longMessage;
                }
            }
            if (TextUtils.isEmpty(getsuggestedcategoriesnetloader))
            {
                showNetworkErrorToast();
                return;
            } else
            {
                showErrorToast(getsuggestedcategoriesnetloader);
                return;
            }
        }
        Object obj1 = ((GetSuggestedCategoriesResponse)getsuggestedcategoriesnetloader.getResponse()).suggestions;
        obj = null;
        if (((ArrayList) (obj1)).size() == 1)
        {
            getsuggestedcategoriesnetloader = (EbaySuggestedCategory)((ArrayList) (obj1)).get(0);
        } else
        {
            getsuggestedcategoriesnetloader = obj;
            if (((ArrayList) (obj1)).size() >= 2)
            {
                EbaySuggestedCategory ebaysuggestedcategory = (EbaySuggestedCategory)((ArrayList) (obj1)).get(0);
                obj1 = (EbaySuggestedCategory)((ArrayList) (obj1)).get(1);
                getsuggestedcategoriesnetloader = obj;
                if (ebaysuggestedcategory.percentItemFound - ((EbaySuggestedCategory) (obj1)).percentItemFound > 30L)
                {
                    getsuggestedcategoriesnetloader = ebaysuggestedcategory;
                }
            }
        }
        if (getsuggestedcategoriesnetloader == null || !ListingCategoryFilters.categoryOkForNewListing(MyApp.getPrefs().getCurrentSite().id, getsuggestedcategoriesnetloader.getCategoryIdPath()))
        {
            cell.updateWithResults(null, 0);
            launchSuggestedCategories();
            return;
        } else
        {
            searchWithCategory(String.valueOf(((EbaySuggestedCategory) (getsuggestedcategoriesnetloader)).id), getsuggestedcategoriesnetloader.getCategoryIdPath(), getsuggestedcategoriesnetloader.getCategoryNamePath());
            return;
        }
    }

    private void registerListObserver(AsyncList asynclist)
    {
        unregisterListObserver();
        if (asynclist != null)
        {
            asynclist.registerObserver(this);
            list = asynclist;
        }
    }

    private void searchWithCategory(String s, String s1, String s2)
    {
        cell.startProgress();
        selectedCategoryId = s;
        selectedCategoryIdPath = s1;
        selectedCategoryNamePath = s2.replace(":", " > ");
        if (ListingCategoryFilters.isMotorsCategoryPath(selectedCategoryIdPath))
        {
            s = EbaySite.MOTOR;
        } else
        {
            s = MyApp.getPrefs().getCurrentSite();
        }
        s = EbayApiUtil.getFindProductService(this, s);
        s = new ProductsPagedListLoader(getEbayContext(), s, selectedCategoryId, cell.getSmartboxText());
        getFwLoaderManager().start(4, s, true);
    }

    private void unregisterListObserver()
    {
        if (list != null)
        {
            list.unregisterObserver(this);
            if (isFinishing())
            {
                list.clear();
            }
        }
    }

    protected void continueToForm()
    {
        Intent intent = new Intent(this, com/ebay/mobile/sell/ListingFragmentActivity);
        EbaySite ebaysite;
        if (ListingCategoryFilters.isMotorsCategoryPath(selectedCategoryIdPath))
        {
            ebaysite = EbaySite.MOTOR;
        } else
        {
            ebaysite = MyApp.getPrefs().getCurrentSite();
        }
        intent.putExtra("site", ebaysite);
        intent.putExtra("title", cell.getSmartboxText());
        intent.putExtra("category_id", selectedCategoryId);
        startActivity(intent);
        finish();
    }

    public void detachCategoryDialog()
    {
        if (TextUtils.isEmpty(selectedCategoryId))
        {
            finish();
        }
    }

    public String getSelectedCategoryId()
    {
        return selectedCategoryId;
    }

    protected void getSuggestedCategory()
    {
        Object obj = cell.getSmartboxText();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            cell.hideSuggestions();
            cell.startProgress();
            obj = new GetSuggestedCategoriesNetLoader(getEbayContext(), EbayApiUtil.getTradingApi(this, MyApp.getPrefs().getAuthentication()), ((String) (obj)));
            getFwLoaderManager().start(3, ((FwLoader) (obj)), true);
        }
    }

    public String getTrackingEventName()
    {
        return "SmartSelling";
    }

    public boolean isDataAvailable()
    {
        return true;
    }

    public String keywordsForSuggestions()
    {
        return cell.getSmartboxText();
    }

    protected void launchSuggestedCategories()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("site", MyApp.getPrefs().getCurrentSite());
        CategoryDialogFragment categorydialogfragment = new CategoryDialogFragment();
        categorydialogfragment.setArguments(bundle);
        categorydialogfragment.show(getFragmentManager(), "categoryDialog");
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   2: 44
    //                   4: 83
    //                   65: 182;
           goto _L1 _L2 _L3 _L4
_L1:
        super.onActivityResult(i, j, intent);
        return;
_L2:
        if (j == -1)
        {
            searchWithCategory(intent.getExtras().getString("category_id"), intent.getExtras().getString("category_id_path"), intent.getExtras().getString("category_name_path"));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == -1)
        {
            Object obj = new ScanResult(intent.getStringExtra("productid"), intent.getStringExtra("productidtype"));
            barcode = ((ScanResult) (obj)).productId;
            ModalProgressFragment.show(getFragmentManager(), cell);
            com.ebay.common.net.api.product.EbayProductApi ebayproductapi = EbayApiUtil.getProductApi(this, MyApp.getPrefs().getCurrentSite());
            obj = new GetProductDetailsLoader(getEbayContext(), ebayproductapi, ((ScanResult) (obj)).productId, ((ScanResult) (obj)).productIdType);
            getFwLoaderManager().start(1, ((FwLoader) (obj)), true);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j == 0)
        {
            (new Handler()).post(new Runnable() {

                final SmartboxActivity this$0;

                public void run()
                {
                    cell.closeAndFinish();
                }

            
            {
                this$0 = SmartboxActivity.this;
                super();
            }
            });
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onChanged()
    {
        cell.progress.setVisibility(8);
        cell.resultsChanged();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030221);
        cell = new SmartboxCell();
        cell.addTextWatcher();
        if (bundle == null)
        {
            emitTracking = true;
        } else
        {
            emitTracking = bundle.getBoolean("tracking");
            barcode = bundle.getString("barcode");
            selectedCategoryId = bundle.getString("category_id");
        }
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
        }
        initDataManagers();
        ContentSyncManager.register(this, new String[] {
            com/ebay/mobile/sell/CategoryDialogFragment$CategoryDialogClick.getName()
        });
    }

    protected void onDestroy()
    {
        super.onDestroy();
        unregisterListObserver();
        ContentSyncManager.unregister(this, new String[] {
            com/ebay/mobile/sell/CategoryDialogFragment$CategoryDialogClick.getName()
        });
        cell.removeTextWatcher();
    }

    public void onGetNotReady()
    {
        cell.progress.setVisibility(0);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        productInfoDataManager = (RlProductInfoDataManager)datamanagercontainer.initialize(RlProductInfoDataManager.KEY, this);
    }

    public void onNetworkError(IOException ioexception)
    {
        cell.progress.setVisibility(8);
        showDialog(0x7f070151);
    }

    public void onProdInfoQueryStarted(com.ebay.common.content.dm.RlProductInfoDataManager.ProdInfoQuery prodinfoquery)
    {
    }

    public void onProductInfoRetrieved(com.ebay.common.content.dm.RlProductInfoDataManager.ProdInfoQuery prodinfoquery, com.ebay.common.content.dm.RlProductInfoDataManager.RlProductInfo rlproductinfo)
    {
        if (!prodinfoquery.equals(currentProdInfoQuery))
        {
            return;
        }
        currentProdInfoQuery = null;
        String s = null;
        if (rlproductinfo != null)
        {
            s = rlproductinfo.getKeywordQueryString();
        }
        if (!TextUtils.isEmpty(s))
        {
            rlproductinfo = new TrackingData("BarcodeScanningList", TrackingType.EVENT);
            rlproductinfo.addKeyValuePair("bcd", barcode);
            rlproductinfo.addKeyValuePair("bct", prodinfoquery.barcodeType);
            rlproductinfo.addKeyValuePair("mfls", "RLFB");
            rlproductinfo.send(this);
            cell.setSmartboxText(s);
            getSuggestedCategory();
            return;
        } else
        {
            rlproductinfo = new TrackingData("BarcodeScanningList", TrackingType.EVENT);
            rlproductinfo.addKeyValuePair("bcd", barcode);
            rlproductinfo.addKeyValuePair("bct", prodinfoquery.barcodeType);
            rlproductinfo.addKeyValuePair("mfls", "SN");
            rlproductinfo.send(this);
            prodinfoquery = String.format(getString(0x7f070152), new Object[] {
                barcode
            });
            ((DialogManager)getShim(com/ebay/common/view/util/DialogManager)).showDynamicAlertDialog(getString(0x7f070154), prodinfoquery, false);
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (emitTracking)
        {
            (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
            return;
        } else
        {
            emitTracking = true;
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("category_id", selectedCategoryId);
        bundle.putString("barcode", barcode);
        bundle.putBoolean("tracking", emitTracking);
        super.onSaveInstanceState(bundle);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (isFinishing()) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 5: default 44
    //                   1 72
    //                   2 44
    //                   3 45
    //                   4 54
    //                   5 63;
           goto _L2 _L3 _L2 _L4 _L5 _L6
_L2:
        return;
_L4:
        onGetSuggestedCategoriesComplete((GetSuggestedCategoriesNetLoader)fwloader);
        return;
_L5:
        onGetProductsComplete((ProductsPagedListLoader)fwloader);
        return;
_L6:
        onGetProductMatchesComplete((MatchProductLoader)fwloader);
        return;
_L3:
        OnGetProductDetailsComplete((GetProductDetailsLoader)fwloader);
        return;
    }

    public boolean showMotorsWithUsCats()
    {
        return true;
    }

    public void updateContent(String s, Object obj)
    {
        if (com/ebay/mobile/sell/CategoryDialogFragment$CategoryDialogClick.getName().equals(s))
        {
            s = (com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick)obj;
            if (((com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick) (s)).category != null)
            {
                searchWithCategory(Long.toString(((com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick) (s)).category.id), ((com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick) (s)).category.idPath, ((com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick) (s)).category.namePath);
            } else
            if (((com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick) (s)).suggestion != null)
            {
                searchWithCategory(Long.toString(((com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick) (s)).suggestion.id), ((com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick) (s)).suggestion.getCategoryIdPath(), ((com.ebay.mobile.sell.CategoryDialogFragment.CategoryDialogClick) (s)).suggestion.getCategoryNamePath());
                return;
            }
        }
    }


    // Unreferenced inner class com/ebay/mobile/sellsmartbox/SmartboxActivity$SmartboxCell$2

/* anonymous class */
    class SmartboxCell._cls2
        implements TextWatcher
    {

        final SmartboxCell this$1;

        public void afterTextChanged(Editable editable)
        {
            updateSmartboxButton();
            updateWithResults(null, 0);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

            
            {
                this$1 = SmartboxCell.this;
                super();
            }
    }

}
