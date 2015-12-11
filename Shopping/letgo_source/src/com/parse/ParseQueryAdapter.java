// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v7.cs;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.parse:
//            ParseObject, ParseImageView, ParseQuery, ParseFile, 
//            FindCallback, ParseException, Parse

public class ParseQueryAdapter extends BaseAdapter
{
    public static interface OnQueryLoadListener
    {

        public abstract void onLoaded(List list, Exception exception);

        public abstract void onLoading();
    }

    public static interface QueryFactory
    {

        public abstract ParseQuery create();
    }


    private static final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_NEXT_PAGE = 1;
    private boolean autoload;
    private Context context;
    private int currentPage;
    private WeakHashMap dataSetObservers;
    private boolean hasNextPage;
    private String imageKey;
    private WeakHashMap imageViewSet;
    private Integer itemResourceId;
    private List objectPages;
    private List objects;
    private int objectsPerPage;
    private List onQueryLoadListeners;
    private boolean paginationEnabled;
    private Drawable placeholder;
    private QueryFactory queryFactory;
    private String textKey;

    public ParseQueryAdapter(Context context1, QueryFactory queryfactory)
    {
        this(context1, queryfactory, ((Integer) (null)));
    }

    public ParseQueryAdapter(Context context1, QueryFactory queryfactory, int i)
    {
        this(context1, queryfactory, Integer.valueOf(i));
    }

    private ParseQueryAdapter(Context context1, QueryFactory queryfactory, Integer integer)
    {
        objectsPerPage = 25;
        paginationEnabled = true;
        imageViewSet = new WeakHashMap();
        dataSetObservers = new WeakHashMap();
        autoload = true;
        objects = new ArrayList();
        objectPages = new ArrayList();
        currentPage = 0;
        hasNextPage = true;
        onQueryLoadListeners = new ArrayList();
        context = context1;
        queryFactory = queryfactory;
        itemResourceId = integer;
    }

    public ParseQueryAdapter(Context context1, Class class1)
    {
        this(context1, ParseObject.getClassName(class1));
    }

    public ParseQueryAdapter(Context context1, Class class1, int i)
    {
        this(context1, ParseObject.getClassName(class1), i);
    }

    public ParseQueryAdapter(Context context1, final String className)
    {
        this(context1, new QueryFactory() {

            final String val$className;

            public ParseQuery create()
            {
                ParseQuery parsequery = ParseQuery.getQuery(className);
                parsequery.orderByDescending("createdAt");
                return parsequery;
            }

            
            {
                className = s;
                super();
            }
        });
        if (className == null)
        {
            throw new RuntimeException("You need to specify a className for the ParseQueryAdapter");
        } else
        {
            return;
        }
    }

    public ParseQueryAdapter(Context context1, final String className, int i)
    {
        this(context1, new QueryFactory() {

            final String val$className;

            public ParseQuery create()
            {
                ParseQuery parsequery = ParseQuery.getQuery(className);
                parsequery.orderByDescending("createdAt");
                return parsequery;
            }

            
            {
                className = s;
                super();
            }
        }, i);
        if (className == null)
        {
            throw new RuntimeException("You need to specify a className for the ParseQueryAdapter");
        } else
        {
            return;
        }
    }

    private View getDefaultView(Context context1)
    {
        if (itemResourceId != null)
        {
            return View.inflate(context1, itemResourceId.intValue(), null);
        } else
        {
            LinearLayout linearlayout = new LinearLayout(context1);
            linearlayout.setPadding(8, 4, 8, 4);
            ParseImageView parseimageview = new ParseImageView(context1);
            parseimageview.setId(0x1020006);
            parseimageview.setLayoutParams(new android.widget.LinearLayout.LayoutParams(50, 50));
            linearlayout.addView(parseimageview);
            context1 = new TextView(context1);
            context1.setId(0x1020014);
            context1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            context1.setPadding(8, 0, 0, 0);
            linearlayout.addView(context1);
            return linearlayout;
        }
    }

    private int getPaginationCellRow()
    {
        return objects.size();
    }

    private void loadObjects(int i, final boolean shouldClear)
    {
        final ParseQuery query = queryFactory.create();
        if (objectsPerPage > 0 && paginationEnabled)
        {
            setPageOnQuery(i, query);
        }
        notifyOnLoadingListeners();
        if (i >= objectPages.size())
        {
            objectPages.add(i, new ArrayList());
        }
        query.findInBackground(new FindCallback() {

            final ParseQueryAdapter this$0;
            final cs val$firstCallBack;
            final int val$page;
            final ParseQuery val$query;
            final boolean val$shouldClear;

            public volatile void done(Object obj, Throwable throwable)
            {
                done((List)obj, (ParseException)throwable);
            }

            public void done(List list, ParseException parseexception)
            {
                if (!Parse.isLocalDatastoreEnabled() && query.getCachePolicy() == ParseQuery.CachePolicy.CACHE_ONLY && parseexception != null && parseexception.getCode() == 120)
                {
                    return;
                }
                if (parseexception == null || parseexception.getCode() != 100 && parseexception.getCode() == 120) goto _L2; else goto _L1
_L1:
                hasNextPage = true;
_L4:
                notifyOnLoadedListeners(list, parseexception);
                return;
_L2:
                if (list != null)
                {
                    if (shouldClear && ((Boolean)firstCallBack.a()).booleanValue())
                    {
                        objectPages.clear();
                        objectPages.add(new ArrayList());
                        currentPage = page;
                        firstCallBack.a(Boolean.valueOf(false));
                    }
                    if (page >= currentPage)
                    {
                        currentPage = page;
                        Object obj = ParseQueryAdapter.this;
                        boolean flag;
                        if (list.size() > objectsPerPage)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        obj.hasNextPage = flag;
                    }
                    if (paginationEnabled && list.size() > objectsPerPage)
                    {
                        list.remove(objectsPerPage);
                    }
                    obj = (List)objectPages.get(page);
                    ((List) (obj)).clear();
                    ((List) (obj)).addAll(list);
                    syncObjectsWithPages();
                    notifyDataSetChanged();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = ParseQueryAdapter.this;
                query = parsequery;
                shouldClear = flag;
                firstCallBack = cs1;
                page = i;
                super();
            }
        });
    }

    private void notifyOnLoadedListeners(List list, Exception exception)
    {
        for (Iterator iterator = onQueryLoadListeners.iterator(); iterator.hasNext(); ((OnQueryLoadListener)iterator.next()).onLoaded(list, exception)) { }
    }

    private void notifyOnLoadingListeners()
    {
        for (Iterator iterator = onQueryLoadListeners.iterator(); iterator.hasNext(); ((OnQueryLoadListener)iterator.next()).onLoading()) { }
    }

    private boolean shouldShowPaginationCell()
    {
        return paginationEnabled && objects.size() > 0 && hasNextPage;
    }

    private void syncObjectsWithPages()
    {
        objects.clear();
        List list;
        for (Iterator iterator = objectPages.iterator(); iterator.hasNext(); objects.addAll(list))
        {
            list = (List)iterator.next();
        }

    }

    public void addOnQueryLoadListener(OnQueryLoadListener onqueryloadlistener)
    {
        onQueryLoadListeners.add(onqueryloadlistener);
    }

    public void clear()
    {
        objectPages.clear();
        syncObjectsWithPages();
        notifyDataSetChanged();
        currentPage = 0;
    }

    public Context getContext()
    {
        return context;
    }

    public int getCount()
    {
        int j = objects.size();
        int i = j;
        if (shouldShowPaginationCell())
        {
            i = j + 1;
        }
        return i;
    }

    public ParseObject getItem(int i)
    {
        if (i == getPaginationCellRow())
        {
            return null;
        } else
        {
            return (ParseObject)objects.get(i);
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

    public View getItemView(ParseObject parseobject, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = getDefaultView(context);
        }
        try
        {
            view = (TextView)viewgroup.findViewById(0x1020014);
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject parseobject)
        {
            throw new IllegalStateException("Your object views must have a TextView whose id attribute is 'android.R.id.text1'", parseobject);
        }
        if (view != null)
        {
            if (textKey == null)
            {
                view.setText(parseobject.getObjectId());
            } else
            if (parseobject.get(textKey) != null)
            {
                view.setText(parseobject.get(textKey).toString());
            } else
            {
                view.setText(null);
            }
        }
        if (imageKey != null)
        {
            try
            {
                view = (ParseImageView)viewgroup.findViewById(0x1020006);
            }
            // Misplaced declaration of an exception variable
            catch (ParseObject parseobject)
            {
                throw new IllegalStateException("Your object views must have a ParseImageView whose id attribute is 'android.R.id.icon'", parseobject);
            }
            if (view == null)
            {
                throw new IllegalStateException("Your object views must have a ParseImageView whose id attribute is 'android.R.id.icon' if an imageKey is specified");
            }
            if (!imageViewSet.containsKey(view))
            {
                imageViewSet.put(view, null);
            }
            view.setPlaceholder(placeholder);
            view.setParseFile((ParseFile)parseobject.get(imageKey));
            view.loadInBackground();
        }
        return viewgroup;
    }

    public int getItemViewType(int i)
    {
        return i != getPaginationCellRow() ? 0 : 1;
    }

    public View getNextPageView(View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = getDefaultView(context);
        }
        ((TextView)viewgroup.findViewById(0x1020014)).setText("Load more...");
        return viewgroup;
    }

    public int getObjectsPerPage()
    {
        return objectsPerPage;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (getItemViewType(i) == 1)
        {
            view = getNextPageView(view, viewgroup);
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final ParseQueryAdapter this$0;

                public void onClick(View view1)
                {
                    loadNextPage();
                }

            
            {
                this$0 = ParseQueryAdapter.this;
                super();
            }
            });
            return view;
        } else
        {
            return getItemView(getItem(i), view, viewgroup);
        }
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public void loadNextPage()
    {
        loadObjects(currentPage + 1, false);
    }

    public void loadObjects()
    {
        loadObjects(0, true);
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        super.registerDataSetObserver(datasetobserver);
        dataSetObservers.put(datasetobserver, null);
        if (autoload)
        {
            loadObjects();
        }
    }

    public void removeOnQueryLoadListener(OnQueryLoadListener onqueryloadlistener)
    {
        onQueryLoadListeners.remove(onqueryloadlistener);
    }

    public void setAutoload(boolean flag)
    {
        if (autoload != flag)
        {
            autoload = flag;
            if (autoload && !dataSetObservers.isEmpty() && objects.isEmpty())
            {
                loadObjects();
                return;
            }
        }
    }

    public void setImageKey(String s)
    {
        imageKey = s;
    }

    public void setObjectsPerPage(int i)
    {
        objectsPerPage = i;
    }

    protected void setPageOnQuery(int i, ParseQuery parsequery)
    {
        parsequery.setLimit(objectsPerPage + 1);
        parsequery.setSkip(objectsPerPage * i);
    }

    public void setPaginationEnabled(boolean flag)
    {
        paginationEnabled = flag;
    }

    public void setPlaceholder(Drawable drawable)
    {
        if (placeholder != drawable)
        {
            placeholder = drawable;
            drawable = imageViewSet.keySet().iterator();
            while (drawable.hasNext()) 
            {
                ParseImageView parseimageview = (ParseImageView)drawable.next();
                if (parseimageview != null)
                {
                    parseimageview.setPlaceholder(placeholder);
                }
            }
        }
    }

    public void setTextKey(String s)
    {
        textKey = s;
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        super.unregisterDataSetObserver(datasetobserver);
        dataSetObservers.remove(datasetobserver);
    }


/*
    static boolean access$002(ParseQueryAdapter parsequeryadapter, boolean flag)
    {
        parsequeryadapter.hasNextPage = flag;
        return flag;
    }

*/




/*
    static int access$202(ParseQueryAdapter parsequeryadapter, int i)
    {
        parsequeryadapter.currentPage = i;
        return i;
    }

*/




}
