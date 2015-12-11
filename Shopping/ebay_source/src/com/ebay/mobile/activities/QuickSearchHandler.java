// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.view.util.BarcodeScanUtil;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.recents.RecentsDataManager;
import com.ebay.mobile.search.SearchResultFragmentActivity;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.search.SellerOfferResultFragmentActivity;
import com.ebay.mobile.util.ScanResult;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity, eBay, AreYouSureDialogActivity

public class QuickSearchHandler extends CoreActivity
{
    class _cls1Listener
        implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnClickListener
    {

        final QuickSearchHandler this$0;

        public void onCancel(DialogInterface dialoginterface)
        {
            finish();
        }

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls1Listener()
        {
            this$0 = QuickSearchHandler.this;
            super();
        }
    }


    public static final String QUERY_PARAM_REFERRER = "referrer";
    private static final int SEARCH_QUERY_TOO_SHORT = 0;
    public static final String SELLER_SEARCH_PREFIX = "seller:";

    public QuickSearchHandler()
    {
    }

    private static Intent addNavUp(Intent intent, Intent intent1)
    {
        return intent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName("com.ebay.mobile", com/ebay/mobile/activities/eBay.getName()));
    }

    private void addUserQueryToTargetIntent(Intent intent, Intent intent1, SourceIdentification sourceidentification)
    {
label0:
        {
            if (sourceidentification != null && intent != null && intent.getExtras() != null)
            {
                sourceidentification = sourceidentification.getLink();
                if ("acwc".equals(sourceidentification) || "ac".equals(sourceidentification))
                {
                    intent = ((Intent) (intent.getExtras().get("user_query")));
                    if (!(intent instanceof SpannableString))
                    {
                        break label0;
                    }
                    intent1.putExtra("user_query", ((SpannableString)intent).toString());
                }
            }
            return;
        }
        try
        {
            intent1.putExtra("user_query", intent.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
    }

    private final void directAndClose(Intent intent)
    {
        if (!"android.intent.action.SEARCH".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        Object obj2 = intent.getStringExtra("query");
        if (TextUtils.isEmpty(((CharSequence) (obj2)))) goto _L4; else goto _L3
_L3:
        if (!((String) (obj2)).equals(getString(0x7f070949))) goto _L6; else goto _L5
_L5:
        startActivity((new Intent(this, com/ebay/mobile/activities/eBay)).addFlags(0x4000000));
        intent = ActivityStarter.getSavedSearchIntent(this, getEbayContext(), null, null);
        intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("EnterSearch", "sm", "ss"));
        startActivity(intent);
        finish();
_L2:
        return;
_L6:
        if (((String) (obj2)).equals(getString(0x7f07094f)))
        {
            Intent intent1 = ScanResult.getScanActivityIntent(this);
            if (intent1 != null)
            {
                intent1.putExtra("qrcode", true);
                MimsUtil.useProvider(MimsUtil.PROVIDER_ID_REDLASER);
                startActivityForResult(intent1, 58);
                return;
            }
        }
_L4:
        Bundle bundle = intent.getBundleExtra("app_data");
        Object obj;
        Object obj1;
        String s;
        String s1;
        SourceIdentification sourceidentification;
        if (bundle != null)
        {
            s = bundle.getString("referrer");
        } else
        {
            s = null;
        }
        sourceidentification = getSourceIdentification(intent);
        obj = null;
        s1 = null;
        if (bundle != null)
        {
            obj = (SearchParameters)bundle.getParcelable("search_param");
            s1 = bundle.getString("saved_search_id");
        }
        obj1 = obj2;
        if (obj2 != null)
        {
            if (((String) (obj2)).length() < 2)
            {
                obj1 = null;
                showDialog(0);
            } else
            {
                obj2 = ((String) (obj2)).trim();
                obj1 = obj2;
                if (isItemId(((String) (obj2))))
                {
                    rememberSearchQuery(((String) (obj2)));
                    obj = new Intent(this, com/ebay/mobile/viewitem/ItemViewActivity);
                    if (s != null)
                    {
                        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.Referrer", s);
                    }
                    if (sourceidentification != null)
                    {
                        ((Intent) (obj)).putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                        addUserQueryToTargetIntent(intent, ((Intent) (obj)), sourceidentification);
                    }
                    ((Intent) (obj)).putExtra("item_view_id", Long.parseLong(((String) (obj2))));
                    ((Intent) (obj)).putExtra("item_view_kind", com.ebay.common.ConstantsCommon.ItemKind.Found.toString());
                    if (bundle != null)
                    {
                        ((Intent) (obj)).putExtras(bundle);
                    }
                    ((Intent) (obj)).setFlags(0x4000000);
                    addNavUp(((Intent) (obj)), intent);
                    intent = MyApp.getPrefs().getAuthentication();
                    if (intent != null)
                    {
                        ((RecentsDataManager)DataManager.get(getEbayContext(), new com.ebay.mobile.recents.RecentsDataManager.KeyParams(((Authentication) (intent)).iafToken))).addRecentSearch(((String) (obj2)), false, 0L, 1, true, null);
                    }
                    finish();
                    startActivity(((Intent) (obj)));
                    return;
                }
            }
        }
        if (obj1 != null || obj != null && ((SearchParameters) (obj)).getSearchType() != 0)
        {
label0:
            {
                Object obj4;
                int i;
                boolean flag;
label1:
                {
                    flag = true;
                    obj2 = obj;
                    if (obj == null)
                    {
                        if (bundle != null)
                        {
                            obj2 = (SearchParameters)bundle.getParcelable("cat_histogram");
                            obj = obj2;
                            if (obj2 != null)
                            {
                                obj2.keywords = ((String) (obj1));
                                obj = obj2;
                            }
                        }
                        obj2 = obj;
                        if (obj == null)
                        {
                            obj2 = eBayDictionaryProvider.getLockedSearchParameters(this, ((String) (obj1)));
                        }
                    }
                    i = ((flag) ? 1 : 0);
                    if (obj2 == null)
                    {
                        break label0;
                    }
                    String s2;
                    if (BarcodeScanUtil.isProductQuery(((String) (obj1))))
                    {
                        obj = new ScanResult(((String) (obj1)));
                        obj2.productIdType = ((ScanResult) (obj)).productIdType;
                        obj2.productId = ((ScanResult) (obj)).productId;
                        obj2.aspectHistogram = null;
                        obj2.category = null;
                        obj2.keywords = null;
                        obj2.descriptionSearch = false;
                    } else
                    {
                        obj2.keywords = ((String) (obj1));
                        i = "seller:".length();
                        if (((SearchParameters) (obj2)).keywords.regionMatches(true, 0, "seller:", 0, i))
                        {
                            obj = null;
                            obj4 = ((SearchParameters) (obj2)).keywords.substring(i);
                            i = ((String) (obj4)).indexOf(' ');
                            Object obj3 = obj4;
                            if (i != -1)
                            {
                                obj = ((String) (obj4)).substring(i + 1);
                                obj3 = ((String) (obj4)).substring(0, i);
                            }
                            if (TextUtils.isEmpty(((CharSequence) (obj))))
                            {
                                obj = null;
                            }
                            obj2.keywords = ((String) (obj));
                            obj2.sellerId = ((String) (obj3)).toLowerCase(Locale.US);
                        }
                    }
                    obj = com/ebay/mobile/search/SearchResultFragmentActivity;
                    if (!TextUtils.isEmpty(((SearchParameters) (obj2)).sellerId))
                    {
                        obj = com/ebay/mobile/search/SearchResultFragmentActivity$SellerItemsActivity;
                    } else
                    if (((SearchParameters) (obj2)).sellerOffer != null)
                    {
                        obj = com/ebay/mobile/search/SellerOfferResultFragmentActivity;
                    }
                    obj4 = new Intent(this, ((Class) (obj)));
                    addNavUp(((Intent) (obj4)), intent);
                    if (bundle != null)
                    {
                        ((Intent) (obj4)).putExtras(bundle);
                    }
                    s2 = intent.getStringExtra("intent_extra_data_key");
                    if (!"recent".equals(s2))
                    {
                        obj = s2;
                        if (!"ebayNoCategory".equals(s2))
                        {
                            break label1;
                        }
                    }
                    obj = null;
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    obj = ((String) (obj)).split("[|]");
                    obj2.category = new EbayCategorySummary(Long.parseLong(obj[1]), obj[0]);
                }
                if (DeviceConfiguration.getAsync().get(DcsNautilusBoolean.QA_ENABLED) && "4f37292d53e41eb687dc617e4a021a7cd01f91ed".equals(SearchUtil.toSHA1(((SearchParameters) (obj2)).keywords)))
                {
                    i = 0;
                    MyApp.getPrefs().setGlobalPref(true, "developerOptions");
                    DeviceConfiguration.getNoSync().developerOptionsEnabled(true);
                } else
                {
                    ((Intent) (obj4)).putExtra("search_param", ((android.os.Parcelable) (obj2)));
                    ((Intent) (obj4)).putExtra("saved_search_id", s1);
                    ((Intent) (obj4)).putExtra("com.ebay.mobile.tracking.Referrer", s);
                    ((Intent) (obj4)).setFlags(0x24000000);
                    if (sourceidentification != null)
                    {
                        ((Intent) (obj4)).putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                        addUserQueryToTargetIntent(intent, ((Intent) (obj4)), sourceidentification);
                    }
                    startActivity(((Intent) (obj4)));
                    i = ((flag) ? 1 : 0);
                }
            }
            if (i != 0)
            {
                rememberSearchQuery(((String) (obj1)));
            }
            finish();
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    private SourceIdentification getSourceIdentification(Intent intent)
    {
        Object obj = null;
        if (intent == null)
        {
            return null;
        }
        Bundle bundle = intent.getExtras();
        intent = obj;
        if (bundle != null)
        {
            SourceIdentification sourceidentification = (SourceIdentification)bundle.getParcelable("com.ebay.mobile.analytics.sid");
            intent = sourceidentification;
            if (sourceidentification == null)
            {
                intent = new SourceIdentification("EnterSearch", "sm", "utq");
            }
        }
        return intent;
    }

    private static boolean isItemId(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int j;
        return false;
_L2:
        if ((j = s.length()) >= 10 && j <= 19)
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= j)
                    {
                        break label1;
                    }
                    if (!Character.isDigit(s.charAt(i)))
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private void launchBrowserForQrcode(Intent intent)
    {
        intent = new Intent("android.intent.action.VIEW", Uri.parse(intent.getStringExtra("productid")));
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setFlags(0x10000000);
        try
        {
            startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent = Toast.makeText(this, 0x7f070159, 1);
        }
        intent.setGravity(16, 0, 0);
        intent.show();
    }

    private void onBarcodeSearch(Intent intent)
    {
        intent = new ScanResult(intent.getStringExtra("productid"), intent.getStringExtra("productidtype"));
        if ("QRC".equals(((ScanResult) (intent)).productIdType))
        {
            try
            {
                new URL(((ScanResult) (intent)).productId);
                Bundle bundle = new Bundle();
                bundle.putString("productid", ((ScanResult) (intent)).productId);
                AreYouSureDialogActivity.StartActivity(this, null, getString(0x7f0708c3), 57, true, AreYouSureDialogActivity.DEFAULT_BUTTONS.YES_NO, bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                finish();
            }
            return;
        } else
        {
            eBayDictionaryProvider.saveRecentQuery(this, intent.toString());
            SearchParameters searchparameters = eBayDictionaryProvider.getLockedSearchParameters(this, null);
            searchparameters.productId = ((ScanResult) (intent)).productId;
            searchparameters.productIdType = ((ScanResult) (intent)).productIdType;
            intent = new Intent(this, com/ebay/mobile/search/SearchResultFragmentActivity);
            intent.putExtra("search_param", searchparameters);
            intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("EnterSearch", "sm", "scan"));
            intent.setFlags(0x4000000);
            startActivity(intent);
            finish();
            return;
        }
    }

    private void rememberSearchQuery(String s)
    {
        MyApp.getPrefs().setUserPref(s, "searchLastKeywords");
        eBayDictionaryProvider.saveRecentQuery(this, s);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        switch (i)
        {
        default:
            return;

        case 58: // ':'
            if (j == -1)
            {
                onBarcodeSearch(intent);
            } else
            {
                finish();
            }
            MimsUtil.releaseProvider(MimsUtil.PROVIDER_ID_REDLASER);
            return;

        case 57: // '9'
            break;
        }
        if (j == -1)
        {
            launchBrowserForQrcode(intent);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030093);
        if (bundle != null)
        {
            return;
        } else
        {
            directAndClose(getIntent());
            return;
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        _cls1Listener _lcls1listener;
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            _lcls1listener = new _cls1Listener();
            break;
        }
        return (new android.support.v7.app.AlertDialog.Builder(this)).setTitle(0x7f070146).setNegativeButton(0x7f070738, _lcls1listener).setOnCancelListener(_lcls1listener).setMessage(0x7f070145).create();
    }
}
