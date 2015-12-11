// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

// Referenced classes of package io.realm:
//            RealmResults, Realm, RealmChangeListener, RealmObject

public abstract class RealmBaseAdapter extends BaseAdapter
{

    protected Context context;
    protected LayoutInflater inflater;
    private final RealmChangeListener listener;
    protected RealmResults realmResults;

    public RealmBaseAdapter(Context context1, RealmResults realmresults, boolean flag)
    {
        if (context1 == null)
        {
            throw new IllegalArgumentException("Context cannot be null");
        }
        context = context1;
        realmResults = realmresults;
        inflater = LayoutInflater.from(context1);
        if (!flag)
        {
            context1 = null;
        } else
        {
            context1 = new RealmChangeListener() {

                final RealmBaseAdapter this$0;

                public void onChange()
                {
                    notifyDataSetChanged();
                }

            
            {
                this$0 = RealmBaseAdapter.this;
                super();
            }
            };
        }
        listener = context1;
        if (listener != null && realmresults != null)
        {
            realmresults.getRealm().addChangeListener(listener);
        }
    }

    public int getCount()
    {
        if (realmResults == null)
        {
            return 0;
        } else
        {
            return realmResults.size();
        }
    }

    public RealmObject getItem(int i)
    {
        if (realmResults == null)
        {
            return null;
        } else
        {
            return realmResults.get(i);
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public void updateRealmResults(RealmResults realmresults)
    {
        if (listener != null)
        {
            if (realmResults != null)
            {
                realmResults.getRealm().removeChangeListener(listener);
            }
            if (realmresults != null)
            {
                realmresults.getRealm().addChangeListener(listener);
            }
        }
        realmResults = realmresults;
        notifyDataSetChanged();
    }
}
