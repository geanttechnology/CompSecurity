// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.widget.UserThumbnail;
import com.ebay.nautilus.shell.widget.CompositeArrayAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchPrefixType

class SearchLandingPageAdapter extends CompositeArrayAdapter
    implements android.view.View.OnClickListener
{
    public static interface OnClearRecentSearchListener
    {

        public abstract void clearRecentSearches();
    }

    static class RecentsAdapterItem
    {

        final long categoryId;
        final String categoryName;
        final boolean isNewItem;
        final String keywords;
        final String name;
        final String profileImgUrl;
        final String searchId;
        final SearchPrefixType searchtype;
        final ItemType type;

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType = new int[SearchPrefixType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType[SearchPrefixType.EAN.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType[SearchPrefixType.UPC.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType[SearchPrefixType.SELLER.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.ebay.mobile.search.SearchLandingPage.SearchPrefixType[searchtype.ordinal()];
            JVM INSTR tableswitch 1 3: default 44
        //                       1 70
        //                       2 70
        //                       3 85;
               goto _L1 _L2 _L2 _L3
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_85;
_L4:
            String s;
            if (!TextUtils.isEmpty(name))
            {
                s = name;
            } else
            {
                s = keywords;
            }
            stringbuilder.append(s);
            return stringbuilder.toString();
_L2:
            stringbuilder.append(searchtype.getName());
              goto _L4
            if (type == ItemType.RECENT_SEARCH)
            {
                stringbuilder.append(searchtype.getName());
            }
              goto _L4
        }

        RecentsAdapterItem(RecentsAdapterItem recentsadapteritem, String s)
        {
            keywords = recentsadapteritem.keywords;
            type = recentsadapteritem.type;
            searchtype = recentsadapteritem.searchtype;
            isNewItem = recentsadapteritem.isNewItem;
            name = recentsadapteritem.name;
            searchId = recentsadapteritem.searchId;
            categoryName = recentsadapteritem.categoryName;
            categoryId = recentsadapteritem.categoryId;
            profileImgUrl = s;
        }

        RecentsAdapterItem(String s, ItemType itemtype, SearchPrefixType searchprefixtype)
        {
            keywords = s;
            type = itemtype;
            s = searchprefixtype;
            if (searchprefixtype == null)
            {
                s = SearchPrefixType.NORMAL;
            }
            searchtype = s;
            isNewItem = false;
            categoryName = "";
            categoryId = 0L;
            name = "";
            searchId = "";
            profileImgUrl = "";
        }

        RecentsAdapterItem(String s, ItemType itemtype, SearchPrefixType searchprefixtype, Config config)
        {
            keywords = s;
            type = itemtype;
            s = searchprefixtype;
            if (searchprefixtype == null)
            {
                s = SearchPrefixType.NORMAL;
            }
            searchtype = s;
            isNewItem = config.isNewItem;
            name = config.name;
            searchId = config.searchId;
            categoryName = config.categoryName;
            categoryId = config.categoryId;
            profileImgUrl = config.profileImgUrl;
        }
    }

    static class RecentsAdapterItem.Config
    {

        long categoryId;
        String categoryName;
        boolean isNewItem;
        String name;
        String profileImgUrl;
        String searchId;

        RecentsAdapterItem.Config()
        {
            name = "";
            searchId = "";
            categoryName = "";
            categoryId = 0L;
            profileImgUrl = "";
        }
    }

    public static final class RecentsAdapterItem.ItemType extends Enum
    {

        private static final RecentsAdapterItem.ItemType $VALUES[];
        public static final RecentsAdapterItem.ItemType FOLLOWED_MEMBER;
        public static final RecentsAdapterItem.ItemType FOLLOWED_SEARCH;
        public static final RecentsAdapterItem.ItemType RECENT_SEARCH;

        public static RecentsAdapterItem.ItemType valueOf(String s)
        {
            return (RecentsAdapterItem.ItemType)Enum.valueOf(com/ebay/mobile/search/SearchLandingPage/SearchLandingPageAdapter$RecentsAdapterItem$ItemType, s);
        }

        public static RecentsAdapterItem.ItemType[] values()
        {
            return (RecentsAdapterItem.ItemType[])$VALUES.clone();
        }

        static 
        {
            RECENT_SEARCH = new RecentsAdapterItem.ItemType("RECENT_SEARCH", 0);
            FOLLOWED_SEARCH = new RecentsAdapterItem.ItemType("FOLLOWED_SEARCH", 1);
            FOLLOWED_MEMBER = new RecentsAdapterItem.ItemType("FOLLOWED_MEMBER", 2);
            $VALUES = (new RecentsAdapterItem.ItemType[] {
                RECENT_SEARCH, FOLLOWED_SEARCH, FOLLOWED_MEMBER
            });
        }

        private RecentsAdapterItem.ItemType(String s, int i)
        {
            super(s, i);
        }
    }


    static final int LIST_TYPE_FOLLOWED_MEMBERS = 2;
    static final int LIST_TYPE_FOLLOWED_SEARCHES = 1;
    static final int LIST_TYPE_RECENT_SEARCH = 0;
    public static final int MAX_DISPLAY_ITEMS = 5;
    private static final int PAGES_LOADED = 1;
    private static String followedMembersHeaderText = "";
    private static String followedSearchesHeaderText = "";
    private static String recentSearchHeaderText = "";
    private List followedMembers;
    private List followedSearches;
    private boolean isSignedIn;
    private OnClearRecentSearchListener listener;
    private List recentSearches;

    public SearchLandingPageAdapter(Context context, OnClearRecentSearchListener onclearrecentsearchlistener)
    {
        super(context, 0x7f0301d8, 0x7f10057f);
        recentSearches = new ArrayList();
        followedSearches = new ArrayList();
        followedMembers = new ArrayList();
        listener = onclearrecentsearchlistener;
        int i;
        int j;
        boolean flag;
        if (MyApp.getPrefs().getAuthentication() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSignedIn = flag;
        if (isSignedIn)
        {
            i = 0;
        } else
        {
            i = 0x7f0301d6;
        }
        setEmptyViewResource(i);
        setHeaderViewResource(0x7f0301d7);
        setMoreViewResource(0x7f0301d9);
        setLoadingViewResource(0x7f0301d3);
        context = getContext().getResources();
        recentSearchHeaderText = context.getString(0x7f070965);
        followedSearchesHeaderText = context.getString(0x7f070962);
        followedMembersHeaderText = context.getString(0x7f070961);
        context = recentSearchHeaderText;
        onclearrecentsearchlistener = recentSearches;
        j = recentSearches.size();
        if (isSignedIn)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        add(newSection(0, context, onclearrecentsearchlistener, j, 5, i, -1));
        context = followedSearchesHeaderText;
        onclearrecentsearchlistener = followedSearches;
        j = followedSearches.size();
        if (isSignedIn)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        add(newSection(1, context, onclearrecentsearchlistener, j, 5, i, -1));
        if (isSignedIn)
        {
            add(newSection(2, followedMembersHeaderText, followedMembers, followedMembers.size(), 5, 0, -1));
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag;
        int j;
        int k;
        flag = false;
        j = getItemViewType(i);
        k = getSectionFromItemPosition(i).listType;
        viewgroup = super.getView(i, view, viewgroup);
        j;
        JVM INSTR tableswitch 0 3: default 60
    //                   0 297
    //                   1 230
    //                   2 62
    //                   3 468;
           goto _L1 _L2 _L3 _L4 _L5
_L7:
        return viewgroup;
_L4:
        Object obj;
        obj = (TextView)viewgroup.findViewById(0x7f1003df);
        switch (k)
        {
        default:
            return viewgroup;

        case 1: // '\001'
            continue; /* Loop/switch isn't completed */

        case 0: // '\0'
            if (recentSearches == null || recentSearches.size() == 0)
            {
                ((TextView) (obj)).setText("");
                return viewgroup;
            }
            break;

        case 2: // '\002'
            if (followedMembers == null || followedMembers.size() == 0)
            {
                if (isSignedIn)
                {
                    view = "";
                } else
                {
                    view = getContext().getString(0x7f070963);
                }
                ((TextView) (obj)).setText(view);
                return viewgroup;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
        if (followedSearches != null && followedSearches.size() != 0) goto _L7; else goto _L6
_L6:
        if (isSignedIn)
        {
            view = "";
        } else
        {
            view = getContext().getString(0x7f070964);
        }
        ((TextView) (obj)).setText(view);
        return viewgroup;
_L3:
        view = viewgroup.findViewById(0x7f10057c);
        switch (k)
        {
        default:
            view.setVisibility(8);
            return viewgroup;

        case 0: // '\0'
            break;
        }
        if (!recentSearches.isEmpty())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view.setOnClickListener(this);
        return viewgroup;
_L2:
        RecentsAdapterItem recentsadapteritem;
        view = (ImageView)viewgroup.findViewById(0x7f10057d);
        view.setVisibility(4);
        obj = (UserThumbnail)viewgroup.findViewById(0x7f10057e);
        ((UserThumbnail) (obj)).setImageResource(0x7f020240);
        ((UserThumbnail) (obj)).setVisibility(8);
        recentsadapteritem = (RecentsAdapterItem)getItem(i);
        switch (k)
        {
        default:
            return viewgroup;

        case 0: // '\0'
            if (recentsadapteritem.searchtype == SearchPrefixType.SELLER)
            {
                ((UserThumbnail) (obj)).setVisibility(0);
                if (!TextUtils.isEmpty(recentsadapteritem.profileImgUrl))
                {
                    ((UserThumbnail) (obj)).setRemoteImageUrl(recentsadapteritem.profileImgUrl);
                    return viewgroup;
                }
            }
            break;

        case 1: // '\001'
            if (recentsadapteritem.isNewItem)
            {
                view.setImageResource(0x7f020209);
                view.setVisibility(0);
                return viewgroup;
            }
            break;

        case 2: // '\002'
            ((UserThumbnail) (obj)).setVisibility(0);
            continue; /* Loop/switch isn't completed */
        }
_L1:
        if (true) goto _L7; else goto _L8
_L8:
        if (TextUtils.isEmpty(recentsadapteritem.profileImgUrl)) goto _L7; else goto _L9
_L9:
        ((UserThumbnail) (obj)).setRemoteImageUrl(recentsadapteritem.profileImgUrl);
        return viewgroup;
_L5:
        view = (TextView)viewgroup.findViewById(0x7f100580);
        switch (k)
        {
        default:
            return viewgroup;

        case 1: // '\001'
            view.setText(getContext().getString(0x7f070967));
            return viewgroup;

        case 2: // '\002'
            view.setText(getContext().getString(0x7f070966));
            break;
        }
        return viewgroup;
    }

    public boolean isEnabled(int i)
    {
        int j = getSectionFromItemPosition(i).listType;
        getItemViewType(i);
        JVM INSTR tableswitch 1 2: default 36
    //                   1 42
    //                   2 48;
           goto _L1 _L2 _L3
_L1:
        return super.isEnabled(i);
_L2:
        if (j == 0)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!isSignedIn && j == 1)
        {
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131756412 2131756412: default 24
    //                   2131756412 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (listener != null)
        {
            listener.clearRecentSearches();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void updateAdapterData(int i, List list)
    {
        if (list == null) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        Object obj;
        boolean flag;
        if (MyApp.getPrefs().getAuthentication() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSignedIn = flag;
        if (isSignedIn)
        {
            j = 0;
        } else
        {
            j = 0x7f0301d6;
        }
        setEmptyViewResource(j);
        obj = null;
        i;
        JVM INSTR tableswitch 0 2: default 68
    //                   0 121
    //                   1 204
    //                   2 279;
           goto _L3 _L4 _L5 _L6
_L3:
        list = obj;
_L11:
        k = getListCount();
        for (j = 0; j < k && getList(j).listType < i; j++) { }
        break; /* Loop/switch isn't completed */
_L4:
        if (isSignedIn || !list.isEmpty()) goto _L8; else goto _L7
_L7:
        remove(getSectionByType(i));
_L2:
        return;
_L8:
        recentSearches.clear();
        recentSearches.addAll(list);
        j = Math.min(5, recentSearches.size());
        list = newSection(i, recentSearchHeaderText, recentSearches, j, j, 1, -1);
        continue; /* Loop/switch isn't completed */
_L5:
        followedSearches.clear();
        followedSearches.addAll(list);
        j = Math.min(5, followedSearches.size());
        k = Math.max(j + 1, followedSearches.size());
        list = newSection(i, followedSearchesHeaderText, followedSearches, k, j, 1, -1);
        continue; /* Loop/switch isn't completed */
_L6:
        followedMembers.clear();
        followedMembers.addAll(list);
        list = getSectionByType(i);
        if (followedMembers.size() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (list != null)
        {
            remove(list);
            return;
        }
        if (true) goto _L2; else goto _L9
_L9:
        j = Math.min(5, followedMembers.size());
        k = Math.max(j + 1, followedMembers.size());
        list = newSection(i, followedMembersHeaderText, followedMembers, k, j, 1, -1);
        if (true) goto _L11; else goto _L10
_L10:
        if (j >= k)
        {
            add(list);
            return;
        }
        if (getList(j).listType == i)
        {
            setList(j, list);
            return;
        } else
        {
            insert(list, j);
            return;
        }
    }

    public void updateRecentSearchImages(Map map)
    {
        if (map != null && !map.isEmpty())
        {
            Object obj = getSectionByType(0);
            if (obj != null)
            {
                if ((obj = ((com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section) (obj)).list) != null)
                {
                    ArrayList arraylist = new ArrayList();
                    Iterator iterator = ((List) (obj)).iterator();
                    while (iterator.hasNext()) 
                    {
                        RecentsAdapterItem recentsadapteritem = (RecentsAdapterItem)iterator.next();
                        String s;
                        if (!TextUtils.isEmpty(recentsadapteritem.name))
                        {
                            s = recentsadapteritem.name;
                        } else
                        {
                            s = recentsadapteritem.keywords;
                        }
                        arraylist.add(new RecentsAdapterItem(recentsadapteritem, (String)map.get(s)));
                    }
                    if (!arraylist.isEmpty())
                    {
                        updateAdapterData(0, arraylist);
                        return;
                    }
                }
            }
        }
    }

}
