// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.net.api.cart.SetShippingAddressNetLoader;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.util.EbaySettings;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.checkout.AddressEditActivity;
import com.ebay.mobile.checkout.CheckoutError;
import com.ebay.mobile.util.EbayPhoneNumberUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.ShippingLabelContact;
import com.ebay.nautilus.domain.data.ShippingLabelDetails;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.api.addressbook.AddressResponseData;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity

public class ShipsFromAddressFragment extends ShippingLabelBaseFragment
    implements android.view.View.OnClickListener
{

    private static final String EXTRA_CANDIDATE = "candidate";
    private static final String EXTRA_CONTEXT_MENU_ITEM_INDEX = "context_menu_item_index";
    public static final String EXTRA_COUNTRY_CHANGED = "country_changed";
    private static final String EXTRA_SELECTED_ADDRESS_ID = "selected_address_id";
    private static final String EXTRA_SHIPPING_ADDRESS_CHANGED = "shipping_address_changed";
    public static final String EXTRA_SHOW_REFINEMENT_POSTAL_CODE_NOTICE = "refinement_postal_code";
    private static final int MENU_ITEM_DELETE = 2;
    private static final int MENU_ITEM_EDIT = 1;
    private static final int MENU_ITEM_MAKE_PRIMARY = 0;
    private static final int REQUEST_ADD_EDIT_ADDRESS = 1;
    private ColorStateList addressTextColorNormal;
    private ColorStateList addressTextColorSelected;
    private int candidate;
    private int contextMenuItemIndex;
    protected DialogManager dialogManager;
    private LayoutInflater inflater;
    private com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operationPendingOnDataManager;
    private boolean pendingCandidateAddressToSelect;
    private int primaryAddressId;
    private int selected;
    private String selectedAddressId;
    private boolean shippingAddressChanged;
    private List shippingAddresses;
    protected String updateAddressRequestId;
    protected String updateAddressResponseId;

    public ShipsFromAddressFragment()
    {
        pendingCandidateAddressToSelect = false;
        selectedAddressId = null;
    }

    private void appendLayout(ViewGroup viewgroup, Address address, int i, boolean flag, boolean flag1)
    {
        int j = 0;
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f030020, viewgroup, false);
        Object obj = (TextView)viewgroup1.findViewById(0x7f1000b0);
        if (!TextUtils.isEmpty(address.addressFields.name))
        {
            ((TextView) (obj)).setText(address.addressFields.name);
            setTextColorForAddressText(((TextView) (obj)), flag1);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (TextView)viewgroup1.findViewById(0x7f1000b1);
        if (!TextUtils.isEmpty(address.addressFields.street1))
        {
            ((TextView) (obj)).setText(address.addressFields.street1);
            setTextColorForAddressText(((TextView) (obj)), flag1);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (TextView)viewgroup1.findViewById(0x7f1000b2);
        if (!TextUtils.isEmpty(address.addressFields.street2))
        {
            ((TextView) (obj)).setText(address.addressFields.street2);
            setTextColorForAddressText(((TextView) (obj)), flag1);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (TextView)viewgroup1.findViewById(0x7f1000b3);
        ((TextView) (obj)).setText(address.addressFields.getCityStatePostalString());
        setTextColorForAddressText(((TextView) (obj)), flag1);
        obj = (TextView)viewgroup1.findViewById(0x7f1000b4);
        if (!TextUtils.isEmpty(address.addressFields.phone))
        {
            ((TextView) (obj)).setText(EbayPhoneNumberUtil.formatPhoneNumber(address.addressFields.phone, address.addressFields.country));
            setTextColorForAddressText(((TextView) (obj)), flag1);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        if (flag)
        {
            primaryAddressId = i;
        } else
        {
            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)viewgroup1.getLayoutParams();
            layoutparams.bottomMargin = 0;
            viewgroup1.setLayoutParams(layoutparams);
        }
        viewgroup1.findViewById(0x7f1000b7).setVisibility(8);
        obj = (ImageView)viewgroup1.findViewById(0x7f1000b5);
        if (!flag1)
        {
            j = 8;
        }
        ((ImageView) (obj)).setVisibility(j);
        viewgroup1.findViewById(0x7f1000b8).setVisibility(8);
        obj = viewgroup1.findViewById(0x7f1000ba);
        ((View) (obj)).setTag(Integer.valueOf(i));
        registerForContextMenu(((View) (obj)));
        ((View) (obj)).setOnClickListener(this);
        if (!address.getAddressId().equals(selectedAddressId))
        {
            viewgroup1.setOnClickListener(this);
        }
        viewgroup1.setTag(Integer.valueOf(i));
        viewgroup.addView(viewgroup1);
    }

    private void handleAddressErrors(ResultStatus resultstatus)
    {
        Activity activity = getActivity();
        Object obj = resultstatus.getMessages();
        if (!checkForIafTokenFailure(((List) (obj))))
        {
            resultstatus = (new StringBuilder()).append(getString(0x7f070beb)).append("\n");
            if (obj != null)
            {
                com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getFwActivity().getEbayContext();
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)((Iterator) (obj)).next();
                    CheckoutError checkouterror = CheckoutError.mapCheckoutError(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.ADDRESS_DATA_MANAGER, message.getShortMessage(ebaycontext));
                    if (resultstatus.length() > 0)
                    {
                        resultstatus.append("\n");
                    }
                    if (checkouterror != null)
                    {
                        resultstatus.append(checkouterror.getMappedErrorString(activity));
                    } else
                    {
                        resultstatus.append(message.getShortMessage(ebaycontext));
                    }
                }

            }
            if (resultstatus.length() > 0)
            {
                dialogManager.showDynamicAlertDialog(null, resultstatus.toString(), false);
                updateUI();
                return;
            }
        }
    }

    private boolean isEqualAddresses(ShippingLabelContact shippinglabelcontact, Address address)
    {
        while (selectedAddressId != null && selectedAddressId.equals(address.getAddressId()) || selectedAddressId == null && address.addressFields.name.equals(shippinglabelcontact.fullName) && address.addressFields.street1.equals(shippinglabelcontact.location.address.addressLine1) && (TextUtils.isEmpty(address.addressFields.street2) && TextUtils.isEmpty(shippinglabelcontact.location.address.addressLine2) || !TextUtils.isEmpty(address.addressFields.street2) && address.addressFields.street2.equals(shippinglabelcontact.location.address.addressLine2)) && address.addressFields.city.equals(shippinglabelcontact.location.address.city) && address.addressFields.stateOrProvince.equals(shippinglabelcontact.location.address.stateOrProvince) && address.addressFields.country.equals(shippinglabelcontact.location.address.country) && address.addressFields.postalCode.length() > 4 && shippinglabelcontact.location.address.postalCode.length() > 4 && address.addressFields.postalCode.substring(0, 5).equals(shippinglabelcontact.location.address.postalCode.substring(0, 5))) 
        {
            return true;
        }
        return false;
    }

    private void selectAddress(Address address)
    {
        selectedAddressId = ((Address)getShippingAddresses().get(candidate)).getAddressId();
        shippingAddressChanged = true;
        updateUI();
    }

    private void setTextColorForAddressText(TextView textview, boolean flag)
    {
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

    protected void apiRefreshAddresses()
    {
        operationPendingOnDataManager = com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.REFRESH_ADDRESSES;
        ((ShippingLabelActivity)getActivity()).addressDataManager.forceReloadData();
    }

    protected boolean checkForIafTokenFailure(List list)
    {
        if (EbayErrorUtil.userNotLoggedIn(list) && MyApp.getPrefs().isSignedIn())
        {
            MyApp.signOutForIafTokenFailure(getActivity());
            getActivity().finish();
            return true;
        } else
        {
            return false;
        }
    }

    protected List getShippingAddresses()
    {
        if (shippingAddresses == null)
        {
            return new ArrayList();
        } else
        {
            return shippingAddresses;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onCreate(bundle);
        dialogManager = (DialogManager)((ShippingLabelActivity)getActivity()).getShim(com/ebay/common/view/util/DialogManager);
        if (bundle != null)
        {
            shippingAddressChanged = bundle.getBoolean("shipping_address_changed");
            candidate = bundle.getInt("candidate");
            contextMenuItemIndex = bundle.getInt("context_menu_item_index");
            selectedAddressId = bundle.getString("selected_address_id");
        } else
        {
            shippingAddressChanged = false;
            contextMenuItemIndex = 0;
        }
        addressTextColorNormal = ThemeUtil.resolveThemeColorStateList(getResources(), getActivity().getTheme(), 0x1010036);
        addressTextColorSelected = ThemeUtil.resolveThemeColorStateList(getResources(), getActivity().getTheme(), 0x1010212);
        if (((ShippingLabelActivity)getActivity()).shippingAddresses != null)
        {
            shippingAddresses = ((ShippingLabelActivity)getActivity()).shippingAddresses;
            updateUI();
            return;
        } else
        {
            getView().setVisibility(8);
            ((ShippingLabelActivity)getActivity()).showProgress();
            return;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
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
            apiRefreshAddresses();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onAddressDeleted(AddressDataManager addressdatamanager, Content content)
    {
        if (getActivity().isFinishing())
        {
            return;
        }
        addressdatamanager = content.getStatus();
        if (!addressdatamanager.hasError())
        {
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
        if (getActivity().isFinishing())
        {
            return;
        }
        addressdatamanager = content.getStatus();
        if (!addressdatamanager.hasError())
        {
            apiRefreshAddresses();
            return;
        } else
        {
            handleAddressErrors(addressdatamanager);
            return;
        }
    }

    public void onAddressUpdated(AddressDataManager addressdatamanager, Content content)
    {
        addressdatamanager = (AddressResponseData)content.getData();
        if (addressdatamanager != null)
        {
            updateAddressResponseId = ((AddressResponseData) (addressdatamanager)).addressId;
        }
    }

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        addressdatamanager = content.getStatus();
        if (addressdatamanager.hasError())
        {
            if (checkForIafTokenFailure(addressdatamanager.getMessages()))
            {
                return;
            }
            addressdatamanager = null;
        } else
        {
            addressdatamanager = (List)content.getData();
        }
        setShippingAddresses(addressdatamanager);
        if (operationPendingOnDataManager != null)
        {
            if (addressdatamanager != null)
            {
                onSuccess(operationPendingOnDataManager);
            }
            operationPendingOnDataManager = null;
        }
        updateUI();
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
            int i = ((Integer)view.getTag()).intValue();
            if (i >= 0 && i < getShippingAddresses().size())
            {
                candidate = i;
                selectAddress((Address)getShippingAddresses().get(candidate));
                return;
            }
            break;

        case 2131755194: 
            view.showContextMenu();
            return;

        case 2131756890: 
            view = new Intent(getActivity(), com/ebay/mobile/checkout/AddressEditActivity);
            view.putExtra("address_type", "Shipment_From");
            startActivityForResult(view, 1);
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
            ((ShippingLabelActivity)getActivity()).showProgress();
            getView().setVisibility(8);
            ((ShippingLabelActivity)getActivity()).addressDataManager.setPrimaryAddress(((Address)getShippingAddresses().get(contextMenuItemIndex)).getAddressId());
            return true;

        case 1: // '\001'
            menuitem = new Intent(getActivity(), com/ebay/mobile/checkout/AddressEditActivity);
            menuitem.putExtra("address_to_edit", (Parcelable)getShippingAddresses().get(contextMenuItemIndex));
            startActivityForResult(menuitem, 1);
            return true;

        case 2: // '\002'
            ((ShippingLabelActivity)getActivity()).showProgress();
            break;
        }
        getView().setVisibility(8);
        ((ShippingLabelActivity)getActivity()).addressDataManager.deleteAddress(((Address)getShippingAddresses().get(contextMenuItemIndex)).getAddressId());
        return true;
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
        if (contextMenuItemIndex == primaryAddressId)
        {
            contextmenu.findItem(0).setEnabled(false);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        inflater = layoutinflater;
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030232, viewgroup, false);
        layoutinflater.findViewById(0x7f10075a).setOnClickListener(this);
        return layoutinflater;
    }

    public void onError(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
        if (getActivity().isFinishing())
        {
            return;
        }
        operation = dialogManager;
        String s = getString(0x7f070130);
        ioexception = CheckoutError.getConnectionError(getResources(), flag, ioexception);
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        operation.showDynamicAlertDialog(s, ioexception, flag);
        pendingCandidateAddressToSelect = false;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("shipping_address_changed", shippingAddressChanged);
        bundle.putInt("candidate", candidate);
        bundle.putInt("context_menu_item_index", contextMenuItemIndex);
        bundle.putString("selected_address_id", selectedAddressId);
    }

    public void onSuccess(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation)
    {
label0:
        {
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.SET_DEFAULT_SHIPPING_ADDRESS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.SET_SHIPPING_ADDRESS.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.GET_ADDRESSES.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.REFRESH_ADDRESSES.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
            {
            default:
                return;

            case 2: // '\002'
                selectedAddressId = ((Address)getShippingAddresses().get(candidate)).getAddressId();
                shippingAddressChanged = true;
                updateUI();
                return;

            case 3: // '\003'
                updateUI();
                return;

            case 4: // '\004'
                break;
            }
            if (selectedAddressId == null || !selectedAddressId.equals(updateAddressRequestId))
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
        updateUI();
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (!isDetached() && !isRemoving() && isAdded())
        {
            com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation = com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.values()[i];
            EbaySimpleNetLoader ebaysimplenetloader = (EbaySimpleNetLoader)fwloader;
            if (ebaysimplenetloader.isError())
            {
                onError(operation, ebaysimplenetloader.isConnectionError(), ebaysimplenetloader.getException());
                return;
            }
            switch (_cls1..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
            case 2: // '\002'
                break;
            }
            if (((com.ebay.common.net.api.cart.SetShippingAddress.SetShippingAddressResponse)((SetShippingAddressNetLoader)fwloader).getResponse()).ackCode == 1)
            {
                onSuccess(operation);
                return;
            }
        }
    }

    public void sendUpdates()
    {
        Object obj = getShippingAddresses();
        if (obj != null && ((List) (obj)).size() != 0)
        {
            ShippingLabelDraft shippinglabeldraft = ((ShippingLabelActivity)getActivity()).shippingLabelDraft;
            obj = (Address)((List) (obj)).get(selected);
            if (obj != null)
            {
                ShippingLabelContact shippinglabelcontact = shippinglabeldraft.labelDetails.from;
                shippinglabelcontact.updateContact(((Address) (obj)));
                ((ShippingLabelActivity)getActivity()).shippingLabelDraftDataManager.updateDraftAddress(shippinglabelcontact, com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingAddressType.SHIP_FROM, shippinglabeldraft.draftLabelId, ApiSettings.getUrl(EbaySettings.printShippingLabelUrl));
                return;
            }
        }
    }

    public void setActionBarState()
    {
        super.setActionBarState();
        setToolbarTitle(0x7f07086f);
    }

    protected void setShippingAddresses(List list)
    {
        if (list == null)
        {
            list = new ArrayList();
        }
        shippingAddresses = list;
    }

    public void updateUI()
    {
        Object obj = (ShippingLabelActivity)getActivity();
        View view = getView();
        if (((ShippingLabelActivity) (obj)).isFinishing())
        {
            return;
        }
        ViewGroup viewgroup;
        if (((ShippingLabelActivity) (obj)).shippingAddresses != null)
        {
            shippingAddresses = ((ShippingLabelActivity) (obj)).shippingAddresses;
            getView().setVisibility(0);
            viewgroup = (ViewGroup)view.findViewById(0x7f100759);
            ViewGroup viewgroup1 = (ViewGroup)view.findViewById(0x7f100757);
            viewgroup1.removeAllViews();
            viewgroup.removeAllViews();
            ShippingLabelContact shippinglabelcontact = ((ShippingLabelActivity)getActivity()).shippingLabelDraft.labelDetails.from;
            int i = 0;
            while (i < getShippingAddresses().size()) 
            {
                Address address = (Address)getShippingAddresses().get(i);
                boolean flag = false;
                if (isEqualAddresses(shippinglabelcontact, address))
                {
                    flag = true;
                    selected = i;
                    selectedAddressId = address.getAddressId();
                }
                boolean flag1 = address.isDefault();
                if (flag1)
                {
                    obj = viewgroup1;
                } else
                {
                    obj = viewgroup;
                }
                appendLayout(((ViewGroup) (obj)), address, i, flag1, flag);
                i++;
            }
        } else
        {
            view.setVisibility(8);
            ((ShippingLabelActivity) (obj)).showProgress();
            return;
        }
        if (viewgroup.getChildCount() == 0)
        {
            view.findViewById(0x7f100758).setVisibility(8);
            return;
        } else
        {
            view.findViewById(0x7f100758).setVisibility(0);
            return;
        }
    }
}
