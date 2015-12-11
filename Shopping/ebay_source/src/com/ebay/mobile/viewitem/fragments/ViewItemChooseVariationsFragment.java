// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.ebay.android.widget.EbaySpinner;
import com.ebay.android.widget.ImageViewPager;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.Item;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.Variation;
import com.ebay.nautilus.domain.data.VariationPictureSet;
import com.ebay.nautilus.domain.dcs.DcsNautilusString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment, MultiSkuCallback

public class ViewItemChooseVariationsFragment extends ViewItemBaseFragment
    implements android.view.View.OnClickListener, com.ebay.android.widget.EbaySpinner.OnUserSelectionChanged
{
    private class MySpinnerAdapter extends ArrayAdapter
    {

        private final boolean itemsHaveImages;
        final ViewItemChooseVariationsFragment this$0;
        private final com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlRewriterType;

        private View getConsolidatedView(int i, View view, ViewGroup viewgroup, boolean flag)
        {
            SpinnerItem spinneritem = (SpinnerItem)getItem(i);
            View view1 = view;
            byte byte0;
            if (view != null)
            {
                view = (ViewHolder)view.getTag();
            } else
            {
                view1 = inflater.inflate(0x7f03028b, viewgroup, false);
                view = new ViewHolder();
                view.image = (RemoteImageView)view1.findViewById(0x7f10005b);
                ((ViewHolder) (view)).image.setUrlRewriter(urlRewriterType);
                view.text = (TextView)view1.findViewById(0x7f100618);
                view.noSelectionText = (TextView)view1.findViewById(0x7f1008ab);
                view.noSelectionLayout = view1.findViewById(0x7f1008aa);
                view1.setTag(view);
            }
            byte0 = 8;
            i = byte0;
            if (itemsHaveImages)
            {
                if (flag && !TextUtils.isEmpty(spinneritem.url))
                {
                    ((ViewHolder) (view)).image.setRemoteImageUrl(spinneritem.url);
                    i = 0;
                } else
                {
                    i = byte0;
                    if (flag)
                    {
                        i = byte0;
                        if (spinneritem.isHint)
                        {
                            i = 4;
                        }
                    }
                }
            }
            ((ViewHolder) (view)).image.setVisibility(i);
            if (i == 0)
            {
                ((ViewHolder) (view)).image.setRemoteImageUrl(spinneritem.url);
            } else
            {
                ((ViewHolder) (view)).image.setRemoteImageUrl(null);
            }
            if (spinneritem.isHint && !flag)
            {
                ((ViewHolder) (view)).text.setText(condensedHintTextString);
            } else
            if (spinneritem.isHint)
            {
                ((ViewHolder) (view)).noSelectionText.setText(spinneritem.text);
                ((ViewHolder) (view)).noSelectionLayout.setVisibility(0);
                ((ViewHolder) (view)).text.setVisibility(8);
            } else
            {
                ((ViewHolder) (view)).text.setText(spinneritem.text);
                ((ViewHolder) (view)).noSelectionLayout.setVisibility(8);
                ((ViewHolder) (view)).text.setVisibility(0);
            }
            if (flag)
            {
                view1.setMinimumHeight(dialogRowMinHeight);
            }
            return view1;
        }

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            return getConsolidatedView(i, view, viewgroup, true);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            return getConsolidatedView(i, view, viewgroup, false);
        }

        public MySpinnerAdapter(Context context, int i, int j, List list, boolean flag, com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlrewritertype)
        {
            this$0 = ViewItemChooseVariationsFragment.this;
            super(context, i, j, list);
            itemsHaveImages = flag;
            urlRewriterType = urlrewritertype;
        }
    }

    private class SpinnerItem
    {

        public final boolean isHint;
        public final String optionName;
        public final String text;
        final ViewItemChooseVariationsFragment this$0;
        public final String url;

        public SpinnerItem(String s, String s1, boolean flag, String s2)
        {
            this$0 = ViewItemChooseVariationsFragment.this;
            super();
            url = s;
            text = s1;
            isHint = flag;
            optionName = s2;
        }
    }

    private class ViewHolder
    {

        public RemoteImageView image;
        public View noSelectionLayout;
        public TextView noSelectionText;
        public TextView text;
        final ViewItemChooseVariationsFragment this$0;

        private ViewHolder()
        {
            this$0 = ViewItemChooseVariationsFragment.this;
            super();
        }

    }


    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("VIPVariations", 3, "Log VIP Variations");
    private String condensedHintTextString;
    private int dialogRowMinHeight;
    private ImageViewPager imageViewPager;
    private LayoutInflater inflater;
    private final Map spinnerMap = new HashMap();

    public ViewItemChooseVariationsFragment()
    {
    }

    private void createUI()
    {
        refreshSpinners();
        if ((fullExpansion || imageViewPager != null) && imageViewPager == null)
        {
            imageViewPager = (ImageViewPager)view.findViewById(0x7f1002f8);
        }
    }

    private ArrayList getChoices(String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = item.variations.iterator();
label0:
        do
        {
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                Variation variation = (Variation)iterator.next();
                if (!flag && variation.getQuantity() <= variation.getQuantitySold())
                {
                    continue;
                }
                NameValue namevalue = getMatchingNameValue(variation.getNameValueList(), s);
                if (namevalue == null)
                {
                    continue;
                }
                String s1 = namevalue.getValue();
                if (arraylist.contains(s1))
                {
                    continue;
                }
                boolean flag2 = true;
                boolean flag1 = flag2;
                if (viewData.nameValueList.size() <= 1)
                {
                    break label1;
                }
                Iterator iterator1 = viewData.nameValueList.iterator();
                do
                {
                    Object obj1;
                    do
                    {
                        flag1 = flag2;
                        if (!iterator1.hasNext())
                        {
                            break label1;
                        }
                        obj1 = (NameValue)iterator1.next();
                    } while (s.equals(((NameValue) (obj1)).getName()));
                    Object obj = getMatchingNameValue(variation.getNameValueList(), ((NameValue) (obj1)).getName());
                    obj1 = ((NameValue) (obj1)).getValue();
                    if (obj != null)
                    {
                        obj = ((NameValue) (obj)).getValue();
                    } else
                    {
                        obj = "";
                    }
                } while (isEmpty(((String) (obj1))) || TextUtils.equals(((CharSequence) (obj1)), ((CharSequence) (obj))));
                flag1 = false;
            }
            if (flag1)
            {
                arraylist.add(s1);
            }
        } while (true);
        return sortChoices(s, arraylist);
    }

    private NameValue getMatchingNameValue(List list, String s)
    {
        Object obj = null;
        Iterator iterator = list.iterator();
        do
        {
            list = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            list = (NameValue)iterator.next();
        } while (!s.equalsIgnoreCase(list.getName()));
        return list;
    }

    private ArrayList getOptionNames()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = ((Variation)item.variations.get(0)).getNameValueList().iterator(); iterator.hasNext(); arraylist.add(((NameValue)iterator.next()).getName())) { }
        return arraylist;
    }

    private String getVariationPhotoUrl(String s, String s1)
    {
        Object obj1 = null;
        Iterator iterator = item.variationPictureSets.iterator();
        Object obj;
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (VariationPictureSet)iterator.next();
            if (!s.equals(item.variationPicturesSpecificName) || !((VariationPictureSet) (obj)).specificName.equals(s1) || ((VariationPictureSet) (obj)).pictureUrls == null || ((VariationPictureSet) (obj)).pictureUrls.size() <= 0)
            {
                continue;
            }
            obj = (String)((VariationPictureSet) (obj)).pictureUrls.get(0);
            break;
        } while (true);
        return ((String) (obj));
    }

    private boolean isEmpty(String s)
    {
        boolean flag1 = false;
        String as[] = Item.getNotSelectedStrings(getActivity());
        int j = as.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!as[i].equals(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private void refreshSpinners()
    {
        setupSpinners((ViewGroup)view.findViewById(0x7f100910));
    }

    private void setupSpinner(ViewGroup viewgroup, int i, String s, String s1)
    {
        EbaySpinner ebayspinner1;
        ViewGroup viewgroup1;
        viewgroup1 = null;
        EbaySpinner ebayspinner = (EbaySpinner)spinnerMap.get(s);
        ebayspinner1 = ebayspinner;
        if (ebayspinner == null)
        {
            viewgroup1 = (ViewGroup)inflater.inflate(0x7f03003c, viewgroup, false);
            TextView textview = (TextView)viewgroup1.findViewById(0x7f1000ec);
            textview.setText(s);
            textview.setContentDescription(s);
            ebayspinner1 = (EbaySpinner)viewgroup1.findViewById(0x7f1000ed);
            ebayspinner1.setPrompt(s);
            ebayspinner1.setTag(s);
            spinnerMap.put(s, ebayspinner1);
        }
        if (ebayspinner1 == null) goto _L2; else goto _L1
_L1:
        Object obj;
        ArrayList arraylist;
        Activity activity;
        int j;
        activity = getActivity();
        arraylist = null;
        Iterator iterator;
        String s2;
        String as[];
        String s3;
        int k;
        boolean flag;
        boolean flag2;
        if (item.isTransacted)
        {
            NameValue namevalue = getMatchingNameValue(item.mskuSelections, s);
            obj = arraylist;
            if (namevalue != null)
            {
                obj = arraylist;
                if (namevalue.getValue() != null)
                {
                    obj = new ArrayList();
                    ((List) (obj)).add(namevalue.getValue());
                }
            }
        } else
        {
            obj = getChoices(s, item.ignoreQuantity);
        }
        arraylist = new ArrayList();
        j = 0;
        i = 0;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        iterator = ((List) (obj)).iterator();
_L4:
        j = i;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_361;
        }
        s2 = (String)iterator.next();
        flag2 = false;
        as = Item.getNotSelectedStrings(activity);
        k = as.length;
        j = 0;
        do
        {
label0:
            {
                flag = flag2;
                if (j < k)
                {
                    if (!as[j].equals(s2))
                    {
                        break label0;
                    }
                    flag = true;
                }
                s3 = getVariationPhotoUrl(s, s2);
                j = i;
                if (s3 != null)
                {
                    j = i + 1;
                }
                arraylist.add(new SpinnerItem(s3, s2, flag, s));
                i = j;
            }
            if (true)
            {
                break MISSING_BLOCK_LABEL_214;
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlrewritertype = com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType.from(DeviceConfiguration.getAsync().get(DcsNautilusString.ViewItemImageRewriterType));
        boolean flag1;
        if (obj == null)
        {
            i = -1;
        } else
        {
            i = ((List) (obj)).size() - 1;
        }
        if (j == i)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj = new MySpinnerAdapter(activity, 0x1090008, 0x1020014, arraylist, flag1, urlrewritertype);
        ((MySpinnerAdapter) (obj)).setDropDownViewResource(0x1090009);
        ((MySpinnerAdapter) (obj)).setNotifyOnChange(false);
        ebayspinner1.setAdapter(((SpinnerAdapter) (obj)));
        if (logTag.isLoggable)
        {
            logTag.log((new StringBuilder()).append("setupSpinner name=").append(s).append(";value=").append(s1).toString());
        }
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_695;
        }
        i = 0;
_L8:
        if (i >= arraylist.size()) goto _L2; else goto _L5
_L5:
        s = (SpinnerItem)arraylist.get(i);
        if (logTag.isLoggable)
        {
            logTag.log((new StringBuilder()).append("i=").append(i).append(";obj.text=").append(((SpinnerItem) (s)).text).append(";value=").append(s1).toString());
        }
        if (!s1.equals(((SpinnerItem) (s)).text)) goto _L7; else goto _L6
_L6:
        if (logTag.isLoggable)
        {
            logTag.log((new StringBuilder()).append("found match i=").append(i).append(";obj.text=").append(((SpinnerItem) (s)).text).toString());
        }
        ebayspinner1.setSelection(i, true);
_L2:
        if (viewgroup1 != null)
        {
            if (item.isMultiSkuSelectable)
            {
                ebayspinner1.setChangeListener(this);
            } else
            {
                ebayspinner1.setEnabled(false);
            }
            viewgroup.addView(viewgroup1);
        }
        return;
_L7:
        i++;
          goto _L8
        if (logTag.isLoggable)
        {
            logTag.log("no match");
        }
        ebayspinner1.setSelection(ebayspinner1.getAdapter().getCount() - 1);
          goto _L2
    }

    private void setupSpinners(ViewGroup viewgroup)
    {
        ArrayList arraylist = getOptionNames();
        int i = 0;
        while (i < arraylist.size()) 
        {
            String s = (String)arraylist.get(i);
            Object obj = getMatchingNameValue(viewData.nameValueList, s);
            if (obj != null && ((NameValue) (obj)).getValue().length() > 0)
            {
                obj = ((NameValue) (obj)).getValue();
            } else
            {
                obj = getString(0x7f070682);
            }
            setupSpinner(viewgroup, i, s, ((String) (obj)));
            i++;
        }
    }

    private ArrayList sortChoices(String s, ArrayList arraylist)
    {
        ArrayList arraylist1;
        int i;
        arraylist1 = new ArrayList();
        if (item.variationSpecifics.size() <= 1)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        i = 0;
_L6:
        Object obj = arraylist1;
        if (i >= item.variationSpecifics.size()) goto _L2; else goto _L1
_L1:
        obj = (NameValue)item.variationSpecifics.get(i);
        if (!s.equals(((NameValue) (obj)).getName())) goto _L4; else goto _L3
_L3:
        obj = ((NameValue) (obj)).getValues().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s1 = (String)((Iterator) (obj)).next();
            if (arraylist.contains(s1))
            {
                arraylist1.add(s1);
            }
        } while (true);
        if (arraylist1.isEmpty()) goto _L4; else goto _L5
_L5:
        obj = arraylist1;
_L2:
        ((ArrayList) (obj)).add(getString(0x7f070682));
        return ((ArrayList) (obj));
_L4:
        i++;
          goto _L6
        obj = arraylist;
          goto _L2
    }

    public boolean areAllOptionsSelected()
    {
        return item.hasMultiSkuValues(viewData.nameValueList);
    }

    public int getSelectedQuantity()
    {
        int i;
        byte byte0;
        byte0 = -1;
        i = byte0;
        if (!areAllOptionsSelected()) goto _L2; else goto _L1
_L1:
        Iterator iterator = item.variations.iterator();
_L5:
        i = byte0;
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        Variation variation;
        ArrayList arraylist;
        boolean flag1;
        int j;
        variation = (Variation)iterator.next();
        arraylist = variation.getNameValueList();
        j = Math.min(viewData.nameValueList.size(), arraylist.size());
        flag1 = true;
        i = 0;
_L6:
        boolean flag;
        flag = flag1;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (TextUtils.equals(((NameValue)viewData.nameValueList.get(i)).getValue(), ((NameValue)arraylist.get(i)).getValue()))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        flag = false;
        if (!flag) goto _L5; else goto _L4
_L4:
        i = variation.getQuantity();
_L2:
        return i;
        i++;
          goto _L6
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        inflater = (LayoutInflater)bundle.getSystemService("layout_inflater");
        condensedHintTextString = bundle.getString(0x7f07099b);
        TypedValue typedvalue = new TypedValue();
        bundle.getTheme().resolveAttribute(0x101004d, typedvalue, true);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)bundle.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        dialogRowMinHeight = (int)typedvalue.getDimension(displaymetrics);
    }

    public void onChange(int i, Object obj)
    {
        obj = (SpinnerItem)obj;
        String s = ((SpinnerItem) (obj)).text;
        obj = ((SpinnerItem) (obj)).optionName;
        NameValue namevalue = getMatchingNameValue(viewData.nameValueList, ((String) (obj)));
        obj = null;
        if (namevalue != null)
        {
            obj = namevalue.getValue();
            namevalue.setValue(s);
        }
        if (!s.equals(obj))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            if (getActivity() instanceof MultiSkuCallback)
            {
                ((MultiSkuCallback)getActivity()).onVariationsSelected(viewData);
            }
            refreshSpinners();
        }
    }

    public void onClick(View view)
    {
        int i = view.getId();
        if (!fullExpansion) goto _L2; else goto _L1
_L1:
        boolean flag = true;
        i;
        JVM INSTR tableswitch 2131755455 2131755456: default 36
    //                   2131755455 94
    //                   2131755456 50;
           goto _L3 _L4 _L5
_L3:
        flag = false;
_L7:
        if (flag)
        {
            getActivity().finish();
        }
_L2:
        return;
_L5:
        view = new Intent();
        view.putExtra("view_item_view_data", viewData);
        view.putExtra("paramQty", getSelectedQuantity());
        getActivity().setResult(-1, view);
        continue; /* Loop/switch isn't completed */
_L4:
        getActivity().setResult(0, null);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f0302a6, viewgroup, false);
        setupFragment(view);
        return view;
    }

    protected void render(Item item, ViewItemViewData viewitemviewdata, ViewItemBaseFragment.ExpandState expandstate)
    {
        super.render(item, viewitemviewdata, expandstate);
        if (viewitemviewdata.nameValueList == null)
        {
            viewitemviewdata.nameValueList = new ArrayList();
        }
        if (viewitemviewdata.nameValueList.isEmpty())
        {
            for (item = ((Variation)item.variations.get(0)).getNameValueList().iterator(); item.hasNext(); viewitemviewdata.nameValueList.add(new NameValue(expandstate.getName(), getString(0x7f070682))))
            {
                expandstate = (NameValue)item.next();
            }

        }
        createUI();
    }

    public void setGalleryPager(ImageViewPager imageviewpager)
    {
        imageViewPager = imageviewpager;
    }




}
