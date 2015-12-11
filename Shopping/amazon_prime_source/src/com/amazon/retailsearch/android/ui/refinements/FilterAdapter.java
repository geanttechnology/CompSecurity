// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.RefinementFilter;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupAdapter, RefinementGroupType

public class FilterAdapter extends RefinementGroupAdapter
{

    public static final String FILTER_TYPE_ADDRESS = "Address";
    private static final String FILTER_TYPE_MULTI_AND = "MultiSelectAND";
    private static final String FILTER_TYPE_MULTI_OR = "MultiSelectOR";
    private RefinementFilter filter;
    private int filterSize;
    private ResultLayoutType resultLayoutType;
    private String selectedFilterText;

    public FilterAdapter(Context context, RefinementFilter refinementfilter, ResultLayoutType resultlayouttype)
    {
        super(context);
        selectedFilterText = null;
        filterSize = -1;
        filter = refinementfilter;
        resultLayoutType = resultlayouttype;
    }

    public static SpannableStringBuilder getFilterMessage(Context context, ResultLayoutType resultlayouttype, RefinementLink refinementlink)
    {
        context = new StyledSpannableString(resultlayouttype, context);
        if (refinementlink != null)
        {
            resultlayouttype = refinementlink.getStyleText();
            if (resultlayouttype == null || resultlayouttype.size() <= 0)
            {
                continue;
            }
            int i;
            if (resultlayouttype.size() > 1)
            {
                i = com.amazon.retailsearch.R.style.Rs_Refinement_ChildPanel_Header_MultiText;
            } else
            {
                i = com.amazon.retailsearch.R.style.Rs_Refinement_ChildPanel_Header;
            }
            resultlayouttype = resultlayouttype.iterator();
            while (resultlayouttype.hasNext()) 
            {
                refinementlink = (StyledText)resultlayouttype.next();
                context.append(refinementlink, i);
                if ("NEWLINE".equals(refinementlink.getStyle()))
                {
                    i = com.amazon.retailsearch.R.style.Rs_Refinement_ChildPanel_SubHeader;
                }
            }
        }
        do
        {
            return context;
        } while (TextUtils.isEmpty(refinementlink.getText()));
        context.append(refinementlink.getText());
        return context;
    }

    private String getSelectedFilterText()
    {
        if (selectedFilterText != null)
        {
            return selectedFilterText;
        }
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = false;
        boolean flag1 = false;
        if (filter.getAncestry() != null)
        {
            Iterator iterator = filter.getAncestry().iterator();
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break;
                }
                RefinementLink refinementlink = (RefinementLink)iterator.next();
                if (refinementlink != null)
                {
                    flag = true;
                    flag1 = flag;
                    if (!TextUtils.isEmpty(refinementlink.getText()))
                    {
                        if (stringbuilder.length() > 0)
                        {
                            stringbuilder.append(", ");
                        }
                        stringbuilder.append(refinementlink.getText());
                        flag1 = flag;
                    }
                }
            } while (true);
        }
        flag1 = flag;
        if (filter.getValues() != null)
        {
            Iterator iterator1 = filter.getValues().iterator();
            do
            {
                flag1 = flag;
                if (!iterator1.hasNext())
                {
                    break;
                }
                RefinementLink refinementlink1 = (RefinementLink)iterator1.next();
                if (refinementlink1 != null && refinementlink1.getSelected())
                {
                    flag1 = true;
                    flag = flag1;
                    if (!TextUtils.isEmpty(refinementlink1.getText()))
                    {
                        if (stringbuilder.length() > 0)
                        {
                            stringbuilder.append(", ");
                        }
                        stringbuilder.append(refinementlink1.getText());
                        flag = flag1;
                    }
                }
            } while (true);
        }
        if (flag1 && stringbuilder.length() < 1)
        {
            selectedFilterText = resources.getString(com.amazon.retailsearch.R.string.refine_selected);
        } else
        {
            selectedFilterText = stringbuilder.toString().trim();
        }
        return selectedFilterText;
    }

    private boolean isChildSelected(int i)
    {
        RefinementLink refinementlink = getChild(i);
        if (refinementlink.equals(filter.getClearLink()))
        {
            return false;
        }
        if (!Utils.isEmpty(filter.getAncestry()) && filter.getAncestry().contains(refinementlink))
        {
            return true;
        } else
        {
            return refinementlink.getSelected();
        }
    }

    public boolean containsChild(String s)
    {
        return getChildPosition(s) != -1;
    }

    public RefinementLink getChild(int i)
    {
        int j = i;
        i = j;
        if (filter.getClearLink() != null)
        {
            i = j - 1;
        }
        if (i == -1)
        {
            return filter.getClearLink();
        }
        j = i;
        if (!Utils.isEmpty(filter.getAncestry()))
        {
            if (i < filter.getAncestry().size())
            {
                return (RefinementLink)filter.getAncestry().get(i);
            }
            j = i - filter.getAncestry().size();
        }
        return (RefinementLink)filter.getValues().get(j);
    }

    public volatile Object getChild(int i)
    {
        return getChild(i);
    }

    public int getChildPosition(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        return i;
_L2:
        i = 0;
        boolean flag = false;
        if (filter.getClearLink() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (s.equals(filter.getClearLink().getId()))
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 0 + 1;
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        int k = i;
        if (!Utils.isEmpty(filter.getAncestry()))
        {
            Iterator iterator = filter.getAncestry().iterator();
            int j = i;
            do
            {
                k = j;
                if (!iterator.hasNext())
                {
                    break;
                }
                i = j;
                if (s.equals(((RefinementLink)iterator.next()).getId()))
                {
                    continue; /* Loop/switch isn't completed */
                }
                j++;
            } while (true);
        }
label0:
        {
            if (Utils.isEmpty(filter.getValues()))
            {
                break label0;
            }
            Iterator iterator1 = filter.getValues().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                i = k;
                if (s.equals(((RefinementLink)iterator1.next()).getId()))
                {
                    break;
                }
                k++;
            } while (true);
        }
        if (true) goto _L4; else goto _L5
_L5:
        return -1;
    }

    public String getChildUrl(int i)
    {
        RefinementLink refinementlink = getChild(i);
        if (refinementlink == null)
        {
            return null;
        } else
        {
            return refinementlink.getUrl();
        }
    }

    public View getChildView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        view = super.getChildView(i, flag, view, viewgroup);
        viewgroup = getChild(i);
        if (viewgroup != null)
        {
            flag = isChildSelected(i);
            childTitle.setText(getFilterMessage(context, resultLayoutType, viewgroup));
            boolean flag1;
            if (filter.getClearLink() == viewgroup)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                childIndicator.setVisibility(8);
            } else
            if ("MultiSelectOR".equals(filter.getType()) || "MultiSelectAND".equals(filter.getType()))
            {
                childIndicator.setVisibility(0);
                viewgroup = childIndicator;
                Resources resources = context.getResources();
                int j;
                if (flag)
                {
                    j = com.amazon.retailsearch.R.drawable.rs_checkbox_filled;
                } else
                {
                    j = com.amazon.retailsearch.R.drawable.rs_checkbox;
                }
                viewgroup.setImageDrawable(resources.getDrawable(j));
            } else
            {
                childIndicator.setVisibility(0);
                viewgroup = childIndicator;
                Resources resources1 = context.getResources();
                int k;
                if (flag)
                {
                    k = com.amazon.retailsearch.R.drawable.rs_radiobox_filled;
                } else
                {
                    k = com.amazon.retailsearch.R.drawable.rs_radiobox;
                }
                viewgroup.setImageDrawable(resources1.getDrawable(k));
            }
            setDefaultChildViewsStyle(flag, isChildEnabled(i), false);
        }
        return view;
    }

    public int getChildrenCount()
    {
        int i;
        if (filterSize > -1)
        {
            i = filterSize;
        } else
        {
            int j = 0;
            i = j;
            if (filter != null)
            {
                i = j;
                if (filter.getValues() != null)
                {
                    i = filter.getValues().size();
                }
            }
            j = i;
            if (filter != null)
            {
                j = i;
                if (filter.getClearLink() != null)
                {
                    j = i + 1;
                }
            }
            i = j;
            if (filter != null)
            {
                i = j;
                if (filter.getAncestry() != null)
                {
                    return j + filter.getAncestry().size();
                }
            }
        }
        return i;
    }

    public Object getData()
    {
        return filter;
    }

    public String getId()
    {
        if (TextUtils.isEmpty(filter.getId()))
        {
            return filter.getLabel();
        } else
        {
            return filter.getId();
        }
    }

    public RefinementGroupType getType()
    {
        return RefinementGroupType.FILTER;
    }

    public View getView(boolean flag, View view, ViewGroup viewgroup)
    {
        view = super.getView(flag, view, viewgroup);
        viewgroup = new StyledSpannableString(context);
        viewgroup.append(filter.getLabel());
        groupTitle.setText(viewgroup);
        setDefaultGroupViewsStyle();
        groupTitle.setVisibility(0);
        viewgroup = getSelectedFilterText();
        if (!TextUtils.isEmpty(viewgroup))
        {
            groupSubTitle.setText(viewgroup);
            groupSubTitle.setTextSize(0, resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_subheader));
            groupSubTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
            groupSubTitle.setVisibility(0);
        }
        if ("Address".equals(filter.getType()))
        {
            groupTitle.setTextSize(0, context.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_address));
            groupTitle.setTextColor(context.getResources().getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
            groupTitle.setTypeface(groupTitle.getTypeface(), 1);
            groupSubTitle.setText(filter.getDetail());
            groupSubTitle.setTextSize(0, context.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_address));
            groupSubTitle.setTextColor(context.getResources().getColor(com.amazon.retailsearch.R.color.rs_refinement_blue));
            groupSubTitle.setVisibility(0);
        }
        setDefaultGroupIndicatorStyle(flag);
        groupContent.setVisibility(0);
        return view;
    }

    public boolean isChildEnabled(int i)
    {
        for (RefinementLink refinementlink = getChild(i); refinementlink == null || TextUtils.isEmpty(refinementlink.getUrl()) || refinementlink.getSelected() && !"MultiSelectOR".equals(filter.getType()) && !"MultiSelectAND".equals(filter.getType());)
        {
            return false;
        }

        return true;
    }

    public boolean isChildSelected(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        RefinementLink refinementlink;
        Iterator iterator = filter.getValues().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            refinementlink = (RefinementLink)iterator.next();
        } while (!s.equals(refinementlink.getId()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return refinementlink.getSelected();
    }

    public boolean isEnabled()
    {
        return !"Address".equals(filter.getType());
    }
}
