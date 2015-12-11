// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.groupon.adapter.GuestsPickerAdapter;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.view:
//            GrouponDrawerDialog, FixedPositionListView

public class GuestsPickerDialog extends GrouponDrawerDialog
{

    private static final int LIST_OFFSET = 1;
    private int adults;
    private FixedPositionListView adultsList;
    private LinearLayout ageSpinnerContainer;
    private List ageSpinners;
    private View childAgesContainer;
    private int children;
    private List childrenAges;
    private FixedPositionListView childrenList;
    private String hotelId;
    private Logger logger;
    private Bundle resultBundle;

    public GuestsPickerDialog()
    {
        ageSpinners = new ArrayList();
    }

    public GuestsPickerDialog(int i, int j, List list)
    {
        ageSpinners = new ArrayList();
        adults = i;
        children = j;
        childrenAges = list;
    }

    public GuestsPickerDialog(int i, int j, List list, String s)
    {
        this(i, j, list);
        hotelId = s;
    }

    public static GuestsPickerDialog newInstance(int i, int j, List list, String s)
    {
        return new GuestsPickerDialog(i, j, list, s);
    }

    private void setDefaultSelections()
    {
        int i = ((GuestsPickerAdapter)adultsList.getAdapter()).getPosition(Integer.valueOf(adults));
        int k = ((GuestsPickerAdapter)childrenList.getAdapter()).getPosition(Integer.valueOf(children));
        adults = 0;
        children = 0;
        adultsList.setSelectionFromTop(i, 0);
        childrenList.setSelectionFromTop(k, 0);
        ((GuestsPickerAdapter)adultsList.getAdapter()).setSelectedPosition(i);
        ((GuestsPickerAdapter)childrenList.getAdapter()).setSelectedPosition(k);
        if (childrenAges != null && ageSpinners != null && childrenAges.size() == ageSpinners.size())
        {
            for (int j = 0; j < childrenAges.size(); j++)
            {
                ((Spinner)ageSpinners.get(j)).setSelection(((Integer)childrenAges.get(j)).intValue());
            }

        }
    }

    private void updateSelectedData()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            Object obj = getResources();
            String s = ((Resources) (obj)).getQuantityString(0x7f0c0000, adults, new Object[] {
                Integer.valueOf(adults)
            });
            obj = ((Resources) (obj)).getQuantityString(0x7f0c0003, children, new Object[] {
                Integer.valueOf(children)
            });
            updateHeader((new StringBuilder()).append(s).append(", ").append(((String) (obj))).toString(), getString(0x7f08013c));
            return;
        }
    }

    protected void clearSpinners()
    {
        ageSpinners.clear();
    }

    protected List getChildrenAges()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = ageSpinners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            int i = ((Spinner)iterator.next()).getSelectedItemPosition();
            if (i > -1)
            {
                arraylist.add(Integer.valueOf(i));
            }
        } while (true);
        return arraylist;
    }

    protected List getListData(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Integer.valueOf(-1));
        for (; i <= j; i++)
        {
            arraylist.add(Integer.valueOf(i));
        }

        arraylist.add(Integer.valueOf(-1));
        return arraylist;
    }

    protected ArrayAdapter getNewAgeSpinnerAdapter()
    {
        ArrayAdapter arrayadapter = new ArrayAdapter(getActivity().getApplicationContext(), 0x7f030028, getSpinnerData(0, 17));
        arrayadapter.setDropDownViewResource(0x7f030027);
        return arrayadapter;
    }

    protected Bundle getResultBundle()
    {
        return resultBundle;
    }

    protected List getSpinnerData(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        while (i <= j) 
        {
            String s;
            if (i == 0)
            {
                s = getResources().getString(0x7f0804e8);
            } else
            {
                s = getResources().getQuantityString(0x7f0c0026, i, new Object[] {
                    Integer.valueOf(i)
                });
            }
            arraylist.add(s);
            i++;
        }
        return arraylist;
    }

    protected List getSpinnerValues(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(Integer.valueOf(((Spinner)list.next()).getSelectedItemPosition()))) { }
        return arraylist;
    }

    protected String getSubmitButtonText()
    {
        return getString(0x7f08013c);
    }

    protected String getTitle()
    {
        String s = getResources().getQuantityString(0x7f0c0000, adults, new Object[] {
            Integer.valueOf(adults)
        });
        String s1 = getResources().getQuantityString(0x7f0c0003, children, new Object[] {
            Integer.valueOf(children)
        });
        return (new StringBuilder()).append(s).append(", ").append(s1).toString();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755266: 
            break;
        }
        if (children > 0 && getChildrenAges().size() != children)
        {
            Toast.makeText(getActivity().getApplicationContext(), 0x7f080517, 0).show();
            return;
        } else
        {
            resultBundle = new Bundle();
            resultBundle.putInt("adults", adults);
            resultBundle.putInt("children", children);
            resultBundle.putIntegerArrayList("children_ages", (ArrayList)getChildrenAges());
            logger.logClick("", "guest_selection_done", "market_rate", hotelId);
            getDialog().dismiss();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            adults = bundle.getInt("adults");
            children = bundle.getInt("children");
            childrenAges = bundle.getIntegerArrayList("children_ages");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030130, null, false);
        setContentView(layoutinflater);
        setupViews(layoutinflater);
        setupAdapters();
        setSubmitListener(this);
        return viewgroup;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (ageSpinners != null)
        {
            Iterator iterator = ageSpinners.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ViewGroup viewgroup = (ViewGroup)((Spinner)iterator.next()).getParent();
                if (viewgroup != null)
                {
                    viewgroup.removeAllViews();
                }
            } while (true);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (ageSpinners.size() == 0)
        {
            setDefaultSelections();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("adults", adults);
        bundle.putInt("children", children);
        bundle.putIntegerArrayList("children_ages", (ArrayList)getSpinnerValues(ageSpinners));
    }

    protected void removeLastSpinner()
    {
        ageSpinners.remove(ageSpinners.size() - 1);
    }

    protected void setAdapterAndAddSpinner(Spinner spinner, int i)
    {
        spinner.setPrompt(String.format(getString(0x7f0804ce), new Object[] {
            Integer.valueOf(i)
        }));
        spinner.setAdapter(getNewAgeSpinnerAdapter());
        ageSpinners.add(spinner);
    }

    protected void setupAdapters()
    {
        adultsList.setAdapter(new GuestsPickerAdapter(getActivity().getApplicationContext(), getListData(1, 4), com.groupon.adapter.GuestsPickerAdapter.DataType.ADULTS));
        childrenList.setAdapter(new GuestsPickerAdapter(getActivity().getApplicationContext(), getListData(0, 3), com.groupon.adapter.GuestsPickerAdapter.DataType.CHILDREN));
    }

    protected void setupViews(View view)
    {
        childAgesContainer = view.findViewById(0x7f10037d);
        ageSpinnerContainer = (LinearLayout)view.findViewById(0x7f10037e);
        adultsList = (FixedPositionListView)view.findViewById(0x7f10037f);
        childrenList = (FixedPositionListView)view.findViewById(0x7f100380);
        adultsList.setListOffset(1);
        childrenList.setListOffset(1);
        adultsList.setOnPositionChangedListener(new FixedPositionListView.OnPositionChangedListener() {

            final GuestsPickerDialog this$0;

            public void onStartScroll()
            {
                ((GuestsPickerAdapter)adultsList.getAdapter()).setSelectedPosition(-1);
            }

            public void onStopScroll(int i)
            {
                adults = ((Integer)adultsList.getAdapter().getItem(i)).intValue();
                ((GuestsPickerAdapter)adultsList.getAdapter()).setSelectedPosition(i);
                updateSelectedData();
            }

            
            {
                this$0 = GuestsPickerDialog.this;
                super();
            }
        });
        childrenList.setOnPositionChangedListener(new FixedPositionListView.OnPositionChangedListener() {

            final GuestsPickerDialog this$0;

            public void onStartScroll()
            {
                ((GuestsPickerAdapter)childrenList.getAdapter()).setSelectedPosition(-1);
            }

            public void onStopScroll(int i)
            {
                int j = ((Integer)childrenList.getAdapter().getItem(i)).intValue();
                toggleChildAgeSpinners(j);
                children = j;
                ((GuestsPickerAdapter)childrenList.getAdapter()).setSelectedPosition(i);
                updateSelectedData();
            }

            
            {
                this$0 = GuestsPickerDialog.this;
                super();
            }
        });
    }

    protected void toggleChildAgeSpinners(int i)
    {
        int j = children;
        int k = j - i;
        boolean flag;
        boolean flag1;
        if (j % 2 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (k % 2 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (k < 0)
        {
            childAgesContainer.setVisibility(0);
            int l = k * -1;
            i = j;
            k = l;
            if (!flag)
            {
                Spinner spinner = (Spinner)ageSpinnerContainer.getChildAt(ageSpinnerContainer.getChildCount() - 1).findViewById(0x7f1000d9);
                spinner.setVisibility(0);
                i = j + 1;
                setAdapterAndAddSpinner(spinner, i);
                k = l - 1;
            }
            long l1 = Math.round((double)k / 2D);
            j = 0;
            while ((long)j < l1) 
            {
                View view = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f030029, ageSpinnerContainer, false);
                Spinner spinner1 = (Spinner)view.findViewById(0x7f1000d8);
                Spinner spinner2 = (Spinner)view.findViewById(0x7f1000d9);
                i++;
                setAdapterAndAddSpinner(spinner1, i);
                if ((long)j == l1 - 1L && (flag && !flag1 || !flag && flag1))
                {
                    spinner2.setVisibility(4);
                } else
                {
                    i++;
                    setAdapterAndAddSpinner(spinner2, i);
                }
                ageSpinnerContainer.addView(view);
                j++;
            }
        } else
        if (k > 0)
        {
            if (i == 0)
            {
                childAgesContainer.setVisibility(8);
                ageSpinnerContainer.removeAllViews();
                clearSpinners();
            } else
            {
                long l2 = Math.round((double)k / 2D);
                if (!flag && flag1)
                {
                    l2++;
                }
                i = 0;
                while ((long)i < l2) 
                {
                    if ((long)i == l2 - 1L && (flag && !flag1 || !flag && flag1))
                    {
                        ((Spinner)ageSpinnerContainer.getChildAt(ageSpinnerContainer.getChildCount() - 1).findViewById(0x7f1000d9)).setVisibility(4);
                        removeLastSpinner();
                    } else
                    {
                        ageSpinnerContainer.removeViewAt(ageSpinnerContainer.getChildCount() - 1);
                        removeLastSpinner();
                    }
                    i++;
                }
            }
        }
    }


/*
    static int access$002(GuestsPickerDialog guestspickerdialog, int i)
    {
        guestspickerdialog.adults = i;
        return i;
    }

*/





/*
    static int access$402(GuestsPickerDialog guestspickerdialog, int i)
    {
        guestspickerdialog.children = i;
        return i;
    }

*/
}
