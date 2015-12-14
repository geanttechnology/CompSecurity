// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkSearch;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity, q, t

abstract class s
{

    protected int b;
    protected int c;
    protected int d;
    final SearchActivity e;

    private s(SearchActivity searchactivity)
    {
        e = searchactivity;
        super();
        b = 0;
        c = 0;
        d = 0;
    }

    s(SearchActivity searchactivity, SearchActivity._cls1 _pcls1)
    {
        this(searchactivity);
    }

    private int a(Object obj)
    {
        if (obj != null)
        {
            obj = obj.getClass();
            if (((Class) (obj)).isAssignableFrom(java/lang/String))
            {
                return SearchActivity.u();
            }
            if (((Class) (obj)).isAssignableFrom(com/cyberlink/beautycircle/model/CircleDetail))
            {
                return SearchActivity.v();
            }
            if (((Class) (obj)).isAssignableFrom(com/cyberlink/beautycircle/model/UserInfo))
            {
                return SearchActivity.w();
            }
        }
        return 0;
    }

    protected View a(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        Object obj;
        obj = SearchActivity.b(e).getItem(i);
        if (view != null && !obj.getClass().equals(view.getTag()))
        {
            view = null;
        }
        view1 = view;
        if (view == null)
        {
            view1 = com.cyberlink.beautycircle.controller.activity.SearchActivity.e(e).inflate(a(obj), viewgroup, false);
            view1.setTag(obj.getClass());
        }
        view = obj.getClass();
        if (!view.isAssignableFrom(java/lang/String)) goto _L2; else goto _L1
_L1:
        view = (String)obj;
        if (view != null)
        {
            ((TextView)view1.findViewById(j.suggestion_text)).setText(view);
        }
_L4:
        return view1;
_L2:
        if (!view.isAssignableFrom(com/cyberlink/beautycircle/model/CircleDetail))
        {
            break; /* Loop/switch isn't completed */
        }
        view = (CircleDetail)obj;
        if (view != null)
        {
            ((TextView)view1.findViewById(j.display_name)).setText(((CircleDetail) (view)).circleName);
            ((UICImageView)view1.findViewById(j.avatar_image)).setImageURI(((CircleDetail) (view)).iconUrl);
            viewgroup = e.getResources().getString(m.bc_search_suggestion_desciption_separator);
            Object obj1 = e.getResources().getString(m.bc_search_suggestion_desciption_circle_creator, new Object[] {
                ((CircleDetail) (view)).creatorName
            });
            obj = e.getResources().getQuantityString(l.bc_search_suggestion_desciption_post_count, ((CircleDetail) (view)).postCount.intValue(), new Object[] {
                ((CircleDetail) (view)).postCount
            });
            obj1 = new StringBuilder(((String) (obj1)));
            if (((StringBuilder) (obj1)).length() > 0 && !((String) (obj)).isEmpty())
            {
                ((StringBuilder) (obj1)).append(viewgroup);
            }
            ((StringBuilder) (obj1)).append(((String) (obj)));
            ((TextView)view1.findViewById(j.display_description)).setText(((CharSequence) (obj1)));
            view1.setTag(view);
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                final s a;

                public void onClick(View view2)
                {
                    view2 = (CircleDetail)view2.getTag();
                    if (view2 == null)
                    {
                        return;
                    } else
                    {
                        com.cyberlink.beautycircle.c.a(a.e, ((CircleDetail) (view2)).circleCreatorId, ((CircleDetail) (view2)).id);
                        return;
                    }
                }

            
            {
                a = s.this;
                super();
            }
            });
            return view1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (view.isAssignableFrom(com/cyberlink/beautycircle/model/UserInfo))
        {
            view = (UserInfo)obj;
            if (view != null)
            {
                ((TextView)view1.findViewById(j.display_name)).setText(((UserInfo) (view)).displayName);
                ((UICImageView)view1.findViewById(j.avatar_image)).setImageURI(((UserInfo) (view)).avatarUrl);
                com.cyberlink.beautycircle.a.a((ImageView)view1.findViewById(j.avatar_crown), ((UserInfo) (view)).userType);
                viewgroup = e.getResources().getString(m.bc_search_suggestion_desciption_separator);
                Object obj2 = e.getResources().getQuantityString(l.bc_search_suggestion_desciption_user_follower_count, ((UserInfo) (view)).followerCount.intValue(), new Object[] {
                    ((UserInfo) (view)).followerCount
                });
                String s1 = e.getResources().getQuantityString(l.bc_search_suggestion_desciption_post_count, ((UserInfo) (view)).postCount.intValue(), new Object[] {
                    ((UserInfo) (view)).postCount
                });
                obj2 = new StringBuilder(((String) (obj2)));
                if (((StringBuilder) (obj2)).length() > 0 && !s1.isEmpty())
                {
                    ((StringBuilder) (obj2)).append(viewgroup);
                }
                ((StringBuilder) (obj2)).append(s1);
                ((TextView)view1.findViewById(j.display_description)).setText(((CharSequence) (obj2)));
                view1.setTag(view);
                view1.setOnClickListener(new android.view.View.OnClickListener() {

                    final s a;

                    public void onClick(View view2)
                    {
                        view2 = (UserInfo)view2.getTag();
                        if (view2 == null)
                        {
                            return;
                        } else
                        {
                            com.cyberlink.beautycircle.c.a(a.e, ((UserInfo) (view2)).id, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                            return;
                        }
                    }

            
            {
                a = s.this;
                super();
            }
                });
                return view1;
            }
        } else
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "Unknown suggestion item type: ", view
            });
            return view1;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected abstract void a();

    protected void a(String s1)
    {
        if (e.o != null)
        {
            e.o.a(true);
            e.o = null;
        }
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(e).a(1);
        SearchActivity.b(e).a();
    }

    protected void a(String s1, String s2)
    {
        if (e.r != null)
        {
            e.r.a(true);
            e.r = null;
        }
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(e).requestFocus();
        e.i();
        SearchActivity.b(e).a();
        SearchActivity.b(e).clear();
        SearchActivity.b(e).notifyDataSetChanged();
        if (AccountManager.c() == null)
        {
            (new com.perfectcorp.utility.j(s2) {

                final String a;
                final s b;

                protected volatile Object a(Object obj)
                {
                    return a((String)obj);
                }

                protected Void a(String s3)
                {
                    SharedPreferences sharedpreferences = Globals.D();
                    com.cyberlink.beautycircle.model.network.NetworkSearch.SuggestionKeywords suggestionkeywords = (com.cyberlink.beautycircle.model.network.NetworkSearch.SuggestionKeywords)Model.a(com/cyberlink/beautycircle/model/network/NetworkSearch$SuggestionKeywords, sharedpreferences.getString((new StringBuilder()).append("LOCAL_RECENT_KEYWORDS_").append(s3).toString(), "{\"totalSize\":0,\"results\":[]}"));
                    if (suggestionkeywords.results.contains(a))
                    {
                        suggestionkeywords.results.remove(a);
                    }
                    suggestionkeywords.results.add(0, a);
                    suggestionkeywords.totalSize = Integer.valueOf(suggestionkeywords.results.size());
                    sharedpreferences.edit().putString((new StringBuilder()).append("LOCAL_RECENT_KEYWORDS_").append(s3).toString(), suggestionkeywords.toString()).commit();
                    return null;
                }

            
            {
                b = s.this;
                a = s2;
                super();
            }
            }).d(s1);
        }
        com.cyberlink.beautycircle.controller.activity.SearchActivity.c(e).setVisibility(8);
    }

    protected abstract void b();

    protected abstract void b(String s1);

    protected void c(String s1)
    {
        if (e.p != null)
        {
            e.p.a(true);
            e.p = null;
        }
        com.cyberlink.beautycircle.controller.activity.SearchActivity.c(e).setVisibility(0);
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(e, false);
        SearchActivity.d(e).setVisibility(0);
        SearchActivity.d(e).requestFocus();
        e.showSoftInput(SearchActivity.d(e));
        SearchActivity.b(e).a();
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(e).a(1);
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(e).setAdapter(SearchActivity.b(e));
        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(e).setOnItemClickListener(SearchActivity.b(e));
        Object obj = AccountManager.c();
        if (obj == null)
        {
            obj = (new com.perfectcorp.utility.j() {

                final s a;

                protected com.cyberlink.beautycircle.model.network.NetworkSearch.SuggestionKeywords a(String s2)
                {
                    return (com.cyberlink.beautycircle.model.network.NetworkSearch.SuggestionKeywords)Model.a(com/cyberlink/beautycircle/model/network/NetworkSearch$SuggestionKeywords, Globals.D().getString((new StringBuilder()).append("LOCAL_RECENT_KEYWORDS_").append(s2).toString(), "{\"totalSize\":0,\"results\":[]}"));
                }

                protected volatile Object a(Object obj1)
                {
                    return a((String)obj1);
                }

            
            {
                a = s.this;
                super();
            }
            }).d(s1);
            ((com.perfectcorp.utility.j) (obj)).a(new t(this, (new StringBuilder()).append("listLocalRecentKeywords:").append(s1).toString(), false));
            s1 = ((String) (obj));
        } else
        {
            obj = NetworkSearch.b(s1, ((Long) (obj)));
            ((com.perfectcorp.utility.j) (obj)).a(new t(this, (new StringBuilder()).append("listRecentKeywordByUserId:").append(s1).toString(), false));
            s1 = ((String) (obj));
        }
        e.p = s1;
    }

    protected void d(String s1)
    {
        if (e.q != null)
        {
            e.q.a(true);
            e.q = null;
        }
        SearchActivity.b(e).a();
        Object obj = AccountManager.c();
        if (obj == null)
        {
            obj = (new com.perfectcorp.utility.j() {

                final s a;

                protected volatile Object a(Object obj1)
                {
                    return a((String)obj1);
                }

                protected Void a(String s2)
                {
                    Globals.D().edit().putString((new StringBuilder()).append("LOCAL_RECENT_KEYWORDS_").append(s2).toString(), "{\"totalSize\":0,\"results\":[]}").commit();
                    return null;
                }

            
            {
                a = s.this;
                super();
            }
            }).d(s1);
            ((com.perfectcorp.utility.j) (obj)).a(new t(this, (new StringBuilder()).append("removeLocalRecentKeywords:").append(s1).toString(), false));
            s1 = ((String) (obj));
        } else
        {
            obj = NetworkSearch.c(s1, ((Long) (obj)));
            ((com.perfectcorp.utility.j) (obj)).a(new t(this, (new StringBuilder()).append("removeRecentKeywordByUserId:").append(s1).toString(), false));
            s1 = ((String) (obj));
        }
        e.p = s1;
    }
}
