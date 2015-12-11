// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.db.models.DealSummary;
import com.groupon.http.Http;
import com.groupon.models.dealtype.DealTypes;
import com.groupon.service.core.UserManager;
import com.groupon.util.Function1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            LoginService

public class DealTypeService
{

    private static final String DEAL_TYPES = "ns:dealTypes";
    private static HashMap dealTypes;
    private Context context;
    private LoginService loginService;
    private UserManager userManager;

    public DealTypeService()
    {
    }

    private String getDealTypesUri()
    {
        return String.format("https:/users/%s/deal_types", new Object[] {
            loginService.getUserId()
        });
    }

    private void invokeCallback(Function1 function1, boolean flag)
    {
        if (function1 != null)
        {
            function1.execute(Boolean.valueOf(flag));
        }
    }

    private HashMap parseDealTypes(List list)
    {
        HashMap hashmap = new HashMap();
        DealTypes dealtypes;
        for (list = list.iterator(); list.hasNext(); hashmap.put(dealtypes.id, dealtypes.name))
        {
            dealtypes = (DealTypes)list.next();
        }

        return hashmap;
    }

    public void addFavoriteDealTypeForCurrentUser(String s, boolean flag, Function1 function1)
    {
        if (!loginService.isLoggedIn())
        {
            return;
        } else
        {
            (new Http(new Object[] {
                "id", s
            }, s, function1, flag) {

                final DealTypeService this$0;
                final boolean val$allowRetriesOnExceptions;
                final Function1 val$callback;
                final String val$dealType;

                protected void onException(Exception exception)
                {
                    super.onException(exception);
                    invokeCallback(callback, false);
                }

                protected volatile void onSuccess(Object obj)
                    throws Exception
                {
                    onSuccess((Void)obj);
                }

                protected void onSuccess(Void void1)
                    throws Exception
                {
                    super.onSuccess(void1);
                    userManager.addFavoriteDealType(dealType);
                    invokeCallback(callback, true);
                }

                protected boolean shouldRetry()
                {
                    return allowRetriesOnExceptions || super.shouldRetry();
                }

            transient 
            {
                this$0 = DealTypeService.this;
                dealType = s1;
                callback = function1;
                allowRetriesOnExceptions = flag;
                super(final_context1, final_class1, final_s, aobj);
            }
            }).method("POST").execute();
            return;
        }
    }

    public boolean doesUserHaveDealTypeInFavoriteList(String s)
    {
        return loginService.isLoggedIn() && getFavoriteDealTypesForCurrentUser().contains(s);
    }

    public void getAllDealTypes(final Function1 callback)
    {
        callback = new Runnable() {

            final DealTypeService this$0;
            final Function1 val$callback;

            public void run()
            {
                if (callback != null)
                {
                    callback.execute(DealTypeService.dealTypes);
                }
            }

            
            {
                this$0 = DealTypeService.this;
                callback = function1;
                super();
            }
        };
        Http http = new Http(com/groupon/models/dealtype/DealTypes$ListWrapper, String.format("https:/deal_types", new Object[0]), callback) {

            final DealTypeService this$0;
            final Runnable val$r;

            protected void onException(Exception exception)
            {
            }

            protected void onSuccess(com.groupon.models.dealtype.DealTypes.ListWrapper listwrapper)
                throws Exception
            {
                if (listwrapper != null)
                {
                    listwrapper = parseDealTypes(listwrapper.dealTypes);
                } else
                {
                    listwrapper = null;
                }
                DealTypeService.dealTypes = listwrapper;
                Ln.d("DEALTYPES: cache response: %s", new Object[] {
                    DealTypeService.dealTypes
                });
                r.run();
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((com.groupon.models.dealtype.DealTypes.ListWrapper)obj);
            }

            
            {
                this$0 = DealTypeService.this;
                r = runnable;
                super(final_context1, class1, s);
            }
        };
        Ln.d("DEALTYPES1: hash = %s", new Object[] {
            dealTypes
        });
        if (dealTypes != null)
        {
            Ln.d("DEALTYPES1: using in-memory cached list", new Object[0]);
            callback.run();
            return;
        } else
        {
            Ln.d("DEALTYPES1: no cache, download list now", new Object[0]);
            http.execute();
            return;
        }
    }

    public Set getFavoriteDealTypesForCurrentUser()
    {
        if (!loginService.isLoggedIn())
        {
            return null;
        } else
        {
            return userManager.getFavoriteDealTypes();
        }
    }

    public int getSuccessTooltipCount()
    {
        return userManager.getDealTypeSuccessTooltipCount();
    }

    public void preProcessDealListNew(Iterable iterable)
    {
        Ln.d("DEALTYPES: preProcessDealList", new Object[0]);
        if (loginService.isLoggedIn())
        {
            Set set = getFavoriteDealTypesForCurrentUser();
            int i;
            if (set != null && set.size() > 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                i = set.size();
            } else
            {
                i = 0;
            }
            Ln.d("DEALTYPES: preProcessDealList, userTypes = %d, %s", new Object[] {
                Integer.valueOf(i), set
            });
            for (iterable = iterable.iterator(); iterable.hasNext(); ((DealSummary)iterable.next()).removeAttr("ns:dealTypes")) { }
        }
    }

    public void removeFavoriteDealTypeForCurrentUser(String s, boolean flag, Function1 function1)
    {
        if (!loginService.isLoggedIn())
        {
            return;
        } else
        {
            (new Http(s, function1, flag) {

                final DealTypeService this$0;
                final boolean val$allowRetriesOnExceptions;
                final Function1 val$callback;
                final String val$dealType;

                protected void onException(Exception exception)
                {
                    super.onException(exception);
                    invokeCallback(callback, false);
                }

                protected volatile void onSuccess(Object obj)
                    throws Exception
                {
                    onSuccess((Void)obj);
                }

                protected void onSuccess(Void void1)
                    throws Exception
                {
                    super.onSuccess(void1);
                    userManager.removeFavoriteDealType(dealType);
                    invokeCallback(callback, true);
                }

                protected boolean shouldRetry()
                {
                    return allowRetriesOnExceptions || super.shouldRetry();
                }

            
            {
                this$0 = DealTypeService.this;
                dealType = s1;
                callback = function1;
                allowRetriesOnExceptions = flag;
                super(final_context1, final_class1, final_s);
            }
            }).method("DELETE").execute();
            return;
        }
    }

    public void setSuccessTooltipCount(int i)
    {
        userManager.setDealTypeSuccessTooltipCount(i);
    }





/*
    static HashMap access$202(HashMap hashmap)
    {
        dealTypes = hashmap;
        return hashmap;
    }

*/

}
