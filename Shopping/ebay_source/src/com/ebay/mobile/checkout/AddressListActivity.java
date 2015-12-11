// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.util.EbayPhoneNumberUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity, CheckoutError, AddressEditActivity

public class AddressListActivity extends BaseCheckoutActivity
    implements android.view.View.OnClickListener
{

    private static final String EXTRA_ADDRESSES_MODIFIED = "addresses_modified";
    private static final String EXTRA_CANDIDATE = "candidate";
    private static final String EXTRA_CONTEXT_MENU_ITEM_INDEX = "context_menu_item_index";
    public static final String EXTRA_COUNTRY_CHANGED = "country_changed";
    private static final String EXTRA_REFRESH_ADDRESSES = "refresh_addresses";
    private static final String EXTRA_SELECTED_ADDRESS_ID = "selected_address_id";
    private static final String EXTRA_SHIPPING_ADDRESS_CHANGED = "shipping_address_changed";
    public static final String EXTRA_SHOW_REFINEMENT_POSTAL_CODE_NOTICE = "refinement_postal_code";
    private static final int MENU_ITEM_DELETE = 2;
    private static final int MENU_ITEM_EDIT = 1;
    private static final int MENU_ITEM_MAKE_PRIMARY = 0;
    private static final int REQUEST_ADD_EDIT_ADDRESS = 1;
    private final boolean aborted = false;
    private ColorStateList addressTextColorNormal;
    private ColorStateList addressTextColorNotShippable;
    private ColorStateList addressTextColorSelected;
    private boolean addressesModified;
    private int candidate;
    private int contextMenuItemIndex;
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private LayoutInflater inflater;
    private boolean isSelectingShippingAddress;
    private boolean pendingCandidateAddressToSelect;
    private boolean refreshAddresses;
    private int selected;
    private String selectedAddressId;
    private boolean shippingAddressChanged;
    private boolean showRefinementPostalCodeNotice;

    public AddressListActivity()
    {
        pendingCandidateAddressToSelect = false;
        selectedAddressId = null;
    }

    private final void allDone()
    {
        Intent intent = new Intent();
        intent.putExtra("country_changed", countryChanged);
        byte byte0;
        if (shippingAddressChanged || addressesModified)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        setCheckoutResult(byte0, intent);
        finish();
    }

    private void appendLayout(ViewGroup viewgroup, Address address, int i, boolean flag, boolean flag1, boolean flag2)
    {
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f030020, viewgroup, false);
        Object obj = (TextView)viewgroup1.findViewById(0x7f1000b0);
        DeviceConfiguration deviceconfiguration;
        int j;
        if (!TextUtils.isEmpty(address.addressFields.name))
        {
            ((TextView) (obj)).setText(address.addressFields.name);
            setTextColorForAddressText(((TextView) (obj)), flag1, flag2);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (TextView)viewgroup1.findViewById(0x7f1000b1);
        if (!TextUtils.isEmpty(address.addressFields.street1))
        {
            ((TextView) (obj)).setText(address.addressFields.street1);
            setTextColorForAddressText(((TextView) (obj)), flag1, flag2);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (TextView)viewgroup1.findViewById(0x7f1000b2);
        if (!TextUtils.isEmpty(address.addressFields.street2))
        {
            ((TextView) (obj)).setText(address.addressFields.street2);
            setTextColorForAddressText(((TextView) (obj)), flag1, flag2);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (TextView)viewgroup1.findViewById(0x7f1000b3);
        ((TextView) (obj)).setText(address.addressFields.getCityStatePostalString());
        setTextColorForAddressText(((TextView) (obj)), flag1, flag2);
        obj = (TextView)viewgroup1.findViewById(0x7f1000b4);
        if (!TextUtils.isEmpty(address.addressFields.phone))
        {
            ((TextView) (obj)).setText(EbayPhoneNumberUtil.formatPhoneNumber(address.addressFields.phone, address.addressFields.country));
            setTextColorForAddressText(((TextView) (obj)), flag1, flag2);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        if (flag)
        {
            viewgroup1.findViewById(0x7f1000b7).setVisibility(0);
        } else
        {
            viewgroup1.findViewById(0x7f1000b7).setVisibility(8);
        }
        if (flag2)
        {
            viewgroup1.findViewById(0x7f1000b8).setVisibility(8);
        } else
        {
            viewgroup1.findViewById(0x7f1000b8).setVisibility(0);
        }
        obj = (TextView)viewgroup1.findViewById(0x7f1000b9);
        deviceconfiguration = DeviceConfiguration.getAsync();
        if (isSelectingShippingAddress && deviceconfiguration.get(DcsBoolean.eBayNow) && !TextUtils.isEmpty(refinedPostalCode) && TextUtils.equals(address.addressFields.postalCode, refinedPostalCode))
        {
            ((TextView) (obj)).setText(Html.fromHtml(getString(0x7f070bf8)));
            ((TextView) (obj)).setVisibility(0);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (ImageView)viewgroup1.findViewById(0x7f1000b5);
        if (isSelectingShippingAddress)
        {
            if (flag1)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            ((ImageView) (obj)).setVisibility(j);
        } else
        {
            ((ImageView) (obj)).setVisibility(8);
        }
        if (android.os.Build.VERSION.SDK_INT < 13)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        obj = (TextView)viewgroup1.findViewById(0x7f1000bb);
        if (j != 0)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((TextView) (obj)).setVisibility(j);
        obj = viewgroup1.findViewById(0x7f1000ba);
        ((View) (obj)).setTag(Integer.valueOf(i));
        registerForContextMenu(((View) (obj)));
        ((View) (obj)).setOnClickListener(this);
        if (isSelectingShippingAddress && !address.getAddressId().equals(selectedAddressId))
        {
            viewgroup1.setOnClickListener(this);
        }
        viewgroup1.setTag(Integer.valueOf(i));
        viewgroup.addView(viewgroup1);
    }

    private void createUi()
    {
        setContentView(0x7f03001f);
        findViewById(0x7f1000ae).setOnClickListener(this);
        findViewById(0x7f1000ac).setOnClickListener(this);
        setTitle(0x7f070c70);
        hideCloseButton();
        showBackButton();
    }

    private void handleAddressErrors(ResultStatus resultstatus)
    {
        Object obj = resultstatus.getMessages();
        if (!checkForIafTokenFailure(((List) (obj))))
        {
            resultstatus = (new StringBuilder()).append(getString(0x7f070beb)).append("\n");
            if (obj != null)
            {
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)((Iterator) (obj)).next();
                    CheckoutError checkouterror = CheckoutError.mapCheckoutError(BaseCheckoutActivity.Operation.ADDRESS_DATA_MANAGER, message.getShortMessage(getEbayContext()));
                    if (resultstatus.length() > 0)
                    {
                        resultstatus.append("\n");
                    }
                    if (checkouterror != null)
                    {
                        resultstatus.append(checkouterror.getMappedErrorString(this));
                    } else
                    {
                        resultstatus.append(message.getShortMessage(getEbayContext()));
                    }
                }

            }
            if (resultstatus.length() > 0)
            {
                dialogManager.showDynamicAlertDialog(null, resultstatus.toString(), false);
                updateUi(true);
                return;
            }
        }
    }

    private boolean isAddressShippableWithCart(Address address, Cart cart, boolean flag)
    {
        cart = cart.lineItems.iterator();
_L6:
        com.ebay.common.model.cart.Cart.LineItem lineitem;
        do
        {
            if (!cart.hasNext())
            {
                break MISSING_BLOCK_LABEL_159;
            }
            lineitem = (com.ebay.common.model.cart.Cart.LineItem)cart.next();
        } while (lineitem.isLocalPickupSelected());
        if (!lineitem.isPOBoxAddressExcluded() || !address.isPOBox()) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            dialogManager.showDynamicAlertDialog(null, getString(0x7f070bfe), false);
        }
_L4:
        return false;
_L2:
        if (!lineitem.isPhoneNumberRequired() || !TextUtils.isEmpty(address.addressFields.phone))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        dialogManager.showDynamicAlertDialog(null, getString(0x7f070bfd), false);
        return false;
        if (!isUnshippable(String.valueOf(lineitem.ebayItemId), address.getAddressId())) goto _L6; else goto _L5
_L5:
        if (!flag) goto _L4; else goto _L7
_L7:
        dialogManager.showDynamicAlertDialog(null, getString(0x7f070bfc), false);
        return false;
        return true;
    }

    private boolean isCartShippableWithAddress(Address address, List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            com.ebay.common.model.cart.Cart.LineItem lineitem = (com.ebay.common.model.cart.Cart.LineItem)list.next();
            if (lineitem != null && !lineitem.isLocalPickupSelected())
            {
                while (isUnshippable(String.valueOf(lineitem.ebayItemId), address.getAddressId()) || lineitem.isPOBoxAddressExcluded() && address.isPOBox()) 
                {
                    return false;
                }
                if (lineitem.isPhoneNumberRequired() && TextUtils.isEmpty(address.addressFields.phone))
                {
                    return false;
                }
            }
        }

        return true;
    }

    private void selectAddress(Address address)
    {
        apiSetShippingAddress(BaseCheckoutActivity.Operation.SET_SHIPPING_ADDRESS, address);
        pendingCandidateAddressToSelect = true;
    }

    private void setTextColorForAddressText(TextView textview, boolean flag, boolean flag1)
    {
        if (!isSelectingShippingAddress)
        {
            return;
        }
        if (!flag1)
        {
            textview.setTextColor(addressTextColorNotShippable);
            return;
        }
        if (flag)
        {
            textview.setTextColor(addressTextColorSelected);
            return;
        } else
        {
            textview.setTextColor(addressTextColorNormal);
            return;
        }
    }

    private void updateUi(boolean flag)
    {
        if (isFinishing())
        {
            return;
        }
        Object obj = getShippingAddresses();
        if (isSelectingShippingAddress && obj != null && ((List) (obj)).size() > candidate)
        {
            obj = (Address)((List) (obj)).get(candidate);
            Iterator iterator = cart.lineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.ebay.common.model.cart.Cart.LineItem lineitem = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
                if (!lineitem.isShippable(((Address) (obj))))
                {
                    addUnshippable(String.valueOf(lineitem.ebayItemId), ((Address) (obj)).getAddressId());
                }
            } while (true);
            if (pendingCandidateAddressToSelect)
            {
                isAddressShippableWithCart(((Address) (obj)), cart, true);
                pendingCandidateAddressToSelect = false;
            }
        }
        obj = (ViewGroup)findViewById(0x7f1000ad);
        ((ViewGroup) (obj)).removeAllViews();
        boolean flag1 = false;
        int i = 0;
        while (i < getShippingAddresses().size()) 
        {
            Address address = (Address)getShippingAddresses().get(i);
            if (TextUtils.equals(address.addressFields.postalCode, refinedPostalCode))
            {
                flag1 = true;
            }
            boolean flag2;
            boolean flag3;
            boolean flag4;
            if (isSelectingShippingAddress)
            {
                flag2 = isCartShippableWithAddress(address, cart.lineItems);
            } else
            {
                flag2 = true;
            }
            flag4 = false;
            flag3 = flag4;
            if (isSelectingShippingAddress)
            {
                flag3 = flag4;
                if (cart.getBuyerShippingAddress() != null)
                {
                    flag3 = flag4;
                    if (address.getAddressId().equals(selectedAddressId))
                    {
                        flag3 = true;
                        selected = i;
                    }
                }
            }
            appendLayout(((ViewGroup) (obj)), address, i, address.isDefault(), flag3, flag2);
            i++;
        }
        obj = (TextView)findViewById(0x7f1000aa);
        if (isSelectingShippingAddress && showRefinementPostalCodeNotice && !flag1)
        {
            ((TextView) (obj)).setText(Html.fromHtml(getString(0x7f070bf9, new Object[] {
                refinedPostalCode
            })));
            ((TextView) (obj)).setVisibility(0);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        if (flag)
        {
            enableProgressDialog(false, false);
        }
        findViewById(0x7f1000ac).requestFocus();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            addressesModified = true;
            apiRefreshAddresses();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onAddressDeleted(AddressDataManager addressdatamanager, Content content)
    {
        if (isFinishing())
        {
            return;
        }
        addressdatamanager = content.getStatus();
        if (!addressdatamanager.hasError())
        {
            addressesModified = true;
            apiRefreshAddresses();
            return;
        } else
        {
            handleAddressErrors(addressdatamanager);
            return;
        }
    }

    public void onAddressPrimary(AddressDataManager addressdatamanager, Content content)
    {
        if (isFinishing())
        {
            return;
        }
        addressdatamanager = content.getStatus();
        if (!addressdatamanager.hasError())
        {
            if (isSelectingShippingAddress)
            {
                addressdatamanager = (String)content.getData();
                content = getShippingAddresses();
                if (addressdatamanager != null && content != null)
                {
                    candidate = 0;
                    for (content = content.iterator(); content.hasNext();)
                    {
                        Address address = (Address)content.next();
                        if (addressdatamanager.equals(address.getAddressId()) && isAddressShippableWithCart(address, cart, true))
                        {
                            selectAddress((Address)getShippingAddresses().get(candidate));
                            refreshAddresses = true;
                            return;
                        }
                        candidate = candidate + 1;
                    }

                }
            }
            apiRefreshAddresses();
            return;
        } else
        {
            handleAddressErrors(addressdatamanager);
            return;
        }
    }

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        super.onAddressesChanged(addressdatamanager, content, flag);
        updateUi(true);
    }

    public void onClick(View view)
    {
        if (!pendingCandidateAddressToSelect) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (view.getId())
        {
        default:
            if (isSelectingShippingAddress)
            {
                int i = ((Integer)view.getTag()).intValue();
                if (i >= 0 && i < getShippingAddresses().size())
                {
                    candidate = i;
                    if (isAddressShippableWithCart((Address)getShippingAddresses().get(candidate), cart, true))
                    {
                        selectAddress((Address)getShippingAddresses().get(candidate));
                        return;
                    }
                }
            }
            break;

        case 2131755180: 
            startActivityForResult(new Intent(this, com/ebay/mobile/checkout/AddressEditActivity), 1);
            return;

        case 2131755194: 
            view.showContextMenu();
            return;

        case 2131755182: 
            allDone();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 0: // '\0'
            enableProgressDialog(true, false);
            updateProgressDialog(0x7f070c6c);
            addressDataManager.setPrimaryAddress(((Address)getShippingAddresses().get(contextMenuItemIndex)).getAddressId());
            return true;

        case 1: // '\001'
            menuitem = new Intent(this, com/ebay/mobile/checkout/AddressEditActivity);
            menuitem.putExtra("address_to_edit", (Parcelable)getShippingAddresses().get(contextMenuItemIndex));
            startActivityForResult(menuitem, 1);
            return true;

        case 2: // '\002'
            enableProgressDialog(true, false);
            break;
        }
        updateProgressDialog(0x7f070c61);
        addressDataManager.deleteAddress(((Address)getShippingAddresses().get(contextMenuItemIndex)).getAddressId());
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        Intent intent = getIntent();
        boolean flag;
        if (!intent.getAction().equals("android.intent.action.EDIT"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSelectingShippingAddress = flag;
        showRefinementPostalCodeNotice = intent.getBooleanExtra("refinement_postal_code", false);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        shippingAddressChanged = bundle.getBoolean("shipping_address_changed");
        addressesModified = bundle.getBoolean("addresses_modified");
        candidate = bundle.getInt("candidate");
        contextMenuItemIndex = bundle.getInt("context_menu_item_index");
        selectedAddressId = bundle.getString("selected_address_id");
        refreshAddresses = bundle.getBoolean("refresh_addresses");
_L4:
        addressTextColorNormal = ThemeUtil.resolveThemeColorStateList(getResources(), getTheme(), 0x1010036);
        addressTextColorNotShippable = ThemeUtil.resolveThemeColorStateList(getResources(), getTheme(), 0x1010038);
        addressTextColorSelected = ThemeUtil.resolveThemeColorStateList(getResources(), getTheme(), 0x1010212);
        createUi();
        updateUi(true);
        return;
_L2:
        Iterator iterator;
        shippingAddressChanged = false;
        addressesModified = false;
        contextMenuItemIndex = 0;
        refreshAddresses = false;
        if (!isSelectingShippingAddress)
        {
            continue; /* Loop/switch isn't completed */
        }
        candidate = 0;
        bundle = getShippingAddresses();
        iterator = bundle.iterator();
_L5:
label0:
        {
            if (iterator.hasNext())
            {
                if (!((Address)iterator.next()).equals(cart.getBuyerShippingAddress()))
                {
                    break label0;
                }
                selectedAddressId = cart.getBuyerShippingAddress().getAddressId();
            }
            if (candidate >= bundle.size())
            {
                candidate = 0;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        candidate = candidate + 1;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        contextmenu.clearHeader();
        contextmenu.clear();
        contextMenuItemIndex = ((Integer)view.getTag()).intValue();
        contextmenu.add(0, 0, 0, getString(0x7f070c46));
        contextmenu.add(0, 1, 1, getString(0x7f070c45));
        contextmenu.add(0, 2, 2, getString(0x7f070c44));
        if (contextMenuItemIndex == selected)
        {
            contextmenu.findItem(2).setEnabled(false);
        }
        if (contextMenuItemIndex == 0)
        {
            contextmenu.findItem(0).setEnabled(false);
        }
    }

    public void onError(BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
        if (isFinishing())
        {
            return;
        }
        enableProgressDialog(false, false);
        operation = dialogManager;
        String s = getString(0x7f070130);
        ioexception = CheckoutError.getConnectionError(getResources(), flag, ioexception);
        if (flag)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        operation.showDynamicAlertDialog(s, ioexception, flag);
        pendingCandidateAddressToSelect = false;
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            allDone();
        }
        return super.onKeyDown(i, keyevent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        allDone();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onPartialFailure(BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
        Object obj = null;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

            static 
            {
                $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[BaseCheckoutActivity.Operation.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.SET_SHIPPING_ADDRESS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.GET_ADDRESSES.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.REFRESH_ADDRESSES.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 68;
           goto _L1 _L2
_L1:
        onSuccess(operation);
        jsonmodel = obj;
_L4:
        jsonmodel = CheckoutError.mapCheckoutError(operation, jsonmodel);
        if (jsonmodel != null)
        {
            dialogManager.showDynamicAlertDialog(null, jsonmodel.getErrorString(this), jsonmodel.shouldAbortOnError());
        }
        onSuccess(operation);
        return;
_L2:
        if (jsonmodel.errors != null && !cart.hasEbayNowAvailable() && DeviceConfiguration.getAsync().get(DcsBoolean.eBayNow))
        {
            Iterator iterator = jsonmodel.errors.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (TextUtils.equals("901", ((com.ebay.common.model.cart.JsonModel.OperationError)iterator.next()).errorId))
                {
                    lineItemsWithShippingChanges.add(jsonmodel.getValueForErrorParamater("cartLineItemIdentifier"));
                }
            } while (true);
        }
        jsonmodel = jsonmodel.getValueForErrorParamater("shippingErrorCode");
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData("ChangeChangeShippingAddress", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("shipping_address_changed", shippingAddressChanged);
        bundle.putBoolean("addresses_modified", addressesModified);
        bundle.putInt("candidate", candidate);
        bundle.putInt("context_menu_item_index", contextMenuItemIndex);
        bundle.putString("selected_address_id", selectedAddressId);
        bundle.putBoolean("refresh_addresses", refreshAddresses);
    }

    public void onSuccess(BaseCheckoutActivity.Operation operation)
    {
        _cls1..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 87
    //                   3 93;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        selectedAddressId = ((Address)getShippingAddresses().get(candidate)).getAddressId();
        shippingAddressChanged = true;
        updateUi(true);
        if (refreshAddresses)
        {
            refreshAddresses = false;
            apiRefreshAddresses();
            return;
        }
          goto _L1
_L3:
        updateUi(true);
        return;
_L4:
label0:
        {
            if (!isSelectingShippingAddress || selectedAddressId == null || !selectedAddressId.equals(updateAddressRequestId))
            {
                break label0;
            }
            operation = getShippingAddresses();
            if (operation == null)
            {
                break label0;
            }
            operation = operation.iterator();
            Address address;
            do
            {
                if (!operation.hasNext())
                {
                    break label0;
                }
                address = (Address)operation.next();
            } while (!address.getAddressId().equals(updateAddressResponseId));
            selectAddress(address);
            return;
        }
        updateUi(true);
        return;
    }
}
