// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbayCategoryNode;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.categoryservice.GetCategoryPathRequest;
import com.ebay.nautilus.domain.net.api.categoryservice.GetCategoryPathResponse;
import com.ebay.nautilus.domain.net.api.categoryservice.GetChildrenCategoriesRequest;
import com.ebay.nautilus.domain.net.api.categoryservice.GetChildrenCategoriesResponse;
import com.ebay.nautilus.domain.net.api.categoryservice.GetTopLevelCategoriesRequest;
import com.ebay.nautilus.domain.net.api.categoryservice.GetTopLevelCategoriesResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.NumberUtil;
import java.util.LinkedList;
import java.util.List;

public final class CategoryServiceDataManager extends DataManager
{
    protected final class GetCategoryPathTask extends CategoryServiceTask
    {

        final CategoryServiceDataManager this$0;

        private EbayCategoryNode map(com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.CategoryPathNode categorypathnode, String s, String s1)
        {
            Object obj = null;
            if (categorypathnode.categoryNodeDetail == null)
            {
                return null;
            }
            EbayCategory ebaycategory;
            boolean flag;
            if (s == null)
            {
                s = categorypathnode.categoryNodeDetail.categoryId;
            } else
            {
                s = (new StringBuilder()).append(s).append(":").append(categorypathnode.categoryNodeDetail.categoryId).toString();
            }
            if (s1 == null)
            {
                s1 = categorypathnode.categoryNodeDetail.name;
            } else
            {
                s1 = (new StringBuilder()).append(s1).append(":").append(categorypathnode.categoryNodeDetail.name).toString();
            }
            ebaycategory = new EbayCategory(NumberUtil.safeParseLong(categorypathnode.categoryNodeDetail.categoryId, -1L), categorypathnode.categoryNodeDetail.name);
            ebaycategory.level = categorypathnode.categoryNodeDetail.level;
            if (categorypathnode.immediateChildCategory == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ebaycategory.isLeaf = flag;
            ebaycategory.idPath = s;
            ebaycategory.namePath = s1;
            ebaycategory.parentId = NumberUtil.safeParseLong(categorypathnode.categoryNodeDetail.parentCategoryId, -1L);
            if (categorypathnode.immediateChildCategory == null)
            {
                categorypathnode = obj;
            } else
            {
                categorypathnode = map(categorypathnode.immediateChildCategory, s, s1);
            }
            return new EbayCategoryNode(ebaycategory, new EbayCategoryNode[] {
                categorypathnode
            });
        }

        protected transient Content doInBackground(Void avoid[])
        {
            Object obj;
            try
            {
                avoid = (EbayCategoryNode)cacheManager.get((new StringBuilder()).append("categoryPath-").append(categoryId).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                if (!isCancelled())
                {
                    cancel(false);
                }
                return null;
            }
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_49;
            }
            return new Content(avoid);
            avoid = new GetCategoryPathRequest(categoryId, null, ebaySite);
            obj = (GetCategoryPathResponse)sendRequest(avoid);
            avoid = ((GetCategoryPathResponse) (obj)).getResultStatus();
            if (avoid.hasError() || ((GetCategoryPathResponse) (obj)).data == null || ((GetCategoryPathResponse) (obj)).data.categoryNodes == null || ((GetCategoryPathResponse) (obj)).data.categoryNodes.isEmpty())
            {
                break MISSING_BLOCK_LABEL_232;
            }
            obj = (com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.CategoryPathNode)((GetCategoryPathResponse) (obj)).data.categoryNodes.get(0);
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_232;
            }
            avoid = map(((com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.CategoryPathNode) (obj)), null, null);
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_205;
            }
            if (!TextUtils.isEmpty(((com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.CategoryPathNode) (obj)).categoryNodeDetail.categoryId))
            {
                cacheManager.put((new StringBuilder()).append("categoryPath-").append(((com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.CategoryPathNode) (obj)).categoryNodeDetail.categoryId).toString(), avoid);
            }
            avoid = new Content(avoid);
            return avoid;
            avoid = new Content(avoid);
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public GetCategoryPathTask(long l, EbaySite ebaysite)
        {
            this$0 = CategoryServiceDataManager.this;
            super(l, ebaysite);
        }
    }

    protected final class GetChildCategoriesTask extends CategoryServiceTask
    {

        private final int categoryLevel;
        final CategoryServiceDataManager this$0;

        private EbayCategoryNode persistCategoryNodes(com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.ChildCategoryNode childcategorynode, String s, String s1)
        {
            if (childcategorynode != null && childcategorynode.categoryNodeDetail != null)
            {
                String s2 = s;
                EbayCategory ebaycategory;
                int i;
                boolean flag3;
                if (s == null)
                {
                    if (childcategorynode.categoryNodeDetail.categoryId == null)
                    {
                        s2 = Long.toString(-1L);
                    } else
                    {
                        s2 = childcategorynode.categoryNodeDetail.categoryId;
                    }
                }
                s = s1;
                if (s1 == null)
                {
                    if (childcategorynode.categoryNodeDetail.name == null)
                    {
                        s = "";
                    } else
                    {
                        s = childcategorynode.categoryNodeDetail.name;
                    }
                }
                ebaycategory = new EbayCategory(NumberUtil.safeParseLong(childcategorynode.categoryNodeDetail.categoryId, -1L), childcategorynode.categoryNodeDetail.name);
                ebaycategory.level = childcategorynode.categoryNodeDetail.level;
                if (childcategorynode.immediateChildCategories == null || childcategorynode.immediateChildCategories.isEmpty())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                ebaycategory.isLeaf = flag3;
                ebaycategory.idPath = s2;
                ebaycategory.namePath = s;
                ebaycategory.parentId = NumberUtil.safeParseLong(childcategorynode.categoryNodeDetail.parentCategoryId, -1L);
                if (childcategorynode.immediateChildCategories == null)
                {
                    i = 0;
                } else
                {
                    i = childcategorynode.immediateChildCategories.size();
                }
                s1 = new EbayCategoryNode[i];
                for (int j = 0; j < i; j++)
                {
                    com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.ChildCategoryNode childcategorynode1 = (com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.ChildCategoryNode)childcategorynode.immediateChildCategories.get(j);
                    s1[j] = persistCategoryNodes(childcategorynode1, (new StringBuilder()).append(s2).append(":").append(childcategorynode1.categoryNodeDetail.categoryId).toString(), (new StringBuilder()).append(s).append(":").append(childcategorynode1.categoryNodeDetail.name).toString());
                }

                s = new EbayCategoryNode(ebaycategory, s1);
                boolean flag;
                boolean flag1;
                boolean flag2;
                if (childcategorynode.categoryNodeDetail.level == categoryLevel)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (categoryLevel == -1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (s1.length > 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if ((flag || flag1 && flag2) && !TextUtils.isEmpty(childcategorynode.categoryNodeDetail.categoryId))
                {
                    cacheManager.put((new StringBuilder()).append("childrenFor-").append(childcategorynode.categoryNodeDetail.categoryId).toString(), s);
                }
                return s;
            } else
            {
                return null;
            }
        }

        protected transient Content doInBackground(Void avoid[])
        {
            ResultStatus resultstatus;
            long l;
            try
            {
                avoid = (EbayCategoryNode)cacheManager.get((new StringBuilder()).append("childrenFor-").append(categoryId).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                if (!isCancelled())
                {
                    cancel(false);
                }
                return null;
            }
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_49;
            }
            return new Content(avoid);
            l = categoryId;
            if (categoryLevel <= -1)
            {
                break MISSING_BLOCK_LABEL_192;
            }
            avoid = Integer.valueOf(categoryLevel + 2);
_L1:
            avoid = new GetChildrenCategoriesRequest(l, avoid, null, null, ebaySite);
            avoid = (GetChildrenCategoriesResponse)sendRequest(avoid);
            resultstatus = avoid.getResultStatus();
            if (resultstatus.hasError() || ((GetChildrenCategoriesResponse) (avoid)).data == null || ((GetChildrenCategoriesResponse) (avoid)).data.categoryNodes == null || ((GetChildrenCategoriesResponse) (avoid)).data.categoryNodes.isEmpty())
            {
                break MISSING_BLOCK_LABEL_197;
            }
            avoid = new Content(persistCategoryNodes((com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.ChildCategoryNode)((GetChildrenCategoriesResponse) (avoid)).data.categoryNodes.get(0), null, null));
            return avoid;
            avoid = null;
              goto _L1
            avoid = new Content(resultstatus);
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public GetChildCategoriesTask(long l, int i, EbaySite ebaysite)
        {
            this$0 = CategoryServiceDataManager.this;
            super(l, ebaysite);
            categoryLevel = i;
        }
    }

    protected final class GetTopLevelCategoriesTask extends CategoryServiceTask
    {

        private final boolean needsMotors;
        final CategoryServiceDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            int i;
            Object obj;
            LinkedList linkedlist;
            com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.CategoryNodeDetail categorynodedetail;
            int j;
            long l;
            try
            {
                avoid = (EbayCategoryNode)cacheManager.get("topLevel");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                if (!isCancelled())
                {
                    cancel(false);
                }
                return null;
            }
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            return new Content(avoid);
            avoid = new GetTopLevelCategoriesRequest(null, ebaySite);
            obj = (GetTopLevelCategoriesResponse)sendRequest(avoid);
            avoid = ((GetTopLevelCategoriesResponse) (obj)).getResultStatus();
            if (avoid.hasError() || ((GetTopLevelCategoriesResponse) (obj)).data == null) goto _L2; else goto _L1
_L1:
            obj = ((GetTopLevelCategoriesResponse) (obj)).data;
            if (((com.ebay.nautilus.domain.net.api.categoryservice.GetTopLevelCategoriesResponse.Payload) (obj)).categoryNodeDetails == null) goto _L2; else goto _L3
_L3:
            j = ((com.ebay.nautilus.domain.net.api.categoryservice.GetTopLevelCategoriesResponse.Payload) (obj)).categoryNodeDetails.size();
            linkedlist = new LinkedList();
            i = 0;
_L12:
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_234;
            }
            categorynodedetail = (com.ebay.nautilus.domain.net.api.categoryservice.CategoryServiceResponse.CategoryNodeDetail)((com.ebay.nautilus.domain.net.api.categoryservice.GetTopLevelCategoriesResponse.Payload) (obj)).categoryNodeDetails.get(i);
            l = NumberUtil.safeParseLong(categorynodedetail.categoryId, -1L);
            if (categorynodedetail.name != null)
            {
                break MISSING_BLOCK_LABEL_225;
            }
            avoid = "";
_L4:
            avoid = new EbayCategory(l, avoid);
            avoid.level = categorynodedetail.level;
            avoid.isLeaf = false;
            avoid.idPath = categorynodedetail.categoryId;
            avoid.namePath = categorynodedetail.name;
            linkedlist.add(new EbayCategoryNode(avoid, new EbayCategoryNode[0]));
            i++;
            continue; /* Loop/switch isn't completed */
            avoid = categorynodedetail.name;
              goto _L4
            if (!needsMotors) goto _L6; else goto _L5
_L5:
            avoid = new EbayCategory(6000L, "eBay Motors");
            avoid.level = 1;
            avoid.isLeaf = false;
            avoid.idPath = Long.toString(6000L);
            avoid.namePath = "eBay Motors";
            j = linkedlist.size();
            i = 0;
_L10:
            if (i >= j) goto _L6; else goto _L7
_L7:
            if ("eBay Motors".compareToIgnoreCase(((EbayCategoryNode)linkedlist.get(i)).category.name) >= 0) goto _L9; else goto _L8
_L8:
            linkedlist.add(i, new EbayCategoryNode(avoid, new EbayCategoryNode[0]));
_L6:
            avoid = new EbayCategoryNode(new EbayCategory(-1L, ""), (EbayCategoryNode[])linkedlist.toArray(new EbayCategoryNode[linkedlist.size()]));
            cacheManager.put("topLevel", avoid);
            avoid = new Content(avoid);
            return avoid;
_L9:
            i++;
            if (true) goto _L10; else goto _L2
_L2:
            avoid = new Content(avoid);
            return avoid;
            if (true) goto _L12; else goto _L11
_L11:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public GetTopLevelCategoriesTask(EbaySite ebaysite)
        {
            this$0 = CategoryServiceDataManager.this;
            super(-1L, ebaysite);
            boolean flag;
            if (ebaysite == EbaySite.US)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            needsMotors = flag;
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
    {

        public final EbaySite ebaySite;

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public CategoryServiceDataManager createManager(EbayContext ebaycontext)
        {
            return new CategoryServiceDataManager(ebaycontext, this);
        }

        public boolean equals(Object obj)
        {
            return obj == this || (obj instanceof KeyParams) && ebaySite.equals(((KeyParams)obj).ebaySite);
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + ebaySite.hashCode();
        }

        public KeyParams(EbaySite ebaysite)
        {
            if (ebaysite == null)
            {
                throw new IllegalArgumentException("EbaySite must be non-null!");
            } else
            {
                ebaySite = ebaysite;
                return;
            }
        }
    }

    public static interface Observer
    {

        public abstract void onCategoriesChanged(CategoryServiceDataManager categoryservicedatamanager, long l, Content content);

        public abstract void onCategoriesLoading(CategoryServiceDataManager categoryservicedatamanager, long l);
    }


    private static final String CACHE_DIRECTORY_PREFIX = "categoryService-";
    public static final String CATEGORY_PATH_CACHE_KEY_PREFIX = "categoryPath-";
    public static final String CHILD_NODE_CACHE_KEY_PREFIX = "childrenFor-";
    public static final long EBAY_MOTORS_CATEGORY_ID = 6000L;
    public static final String EBAY_MOTORS_CATEGORY_NAME = "eBay Motors";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo LOGGER = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CategoryServiceDM", 3, "DataManager for CategoryService API");
    public static final int NO_LEVEL = -1;
    public static final String TOP_LEVEL_CACHE_KEY = "topLevel";
    protected final CacheManager cacheManager = initializeCacheManager();
    private final KeyParams keyParams;
    protected final LongSparseArray tasksInFlight = new LongSparseArray();

    protected CategoryServiceDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/CategoryServiceDataManager$Observer);
        keyParams = keyparams;
    }

    private CacheManager initializeCacheManager()
    {
        Object obj = getEbayContext();
        EbaySite ebaysite = getParams().ebaySite;
        CacheManager cachemanager = (CacheManager)((EbayContext) (obj)).getExtension(com/ebay/nautilus/kernel/cachemanager/CacheManager);
        obj = cachemanager;
        if (cachemanager == null)
        {
            obj = DeviceConfiguration.getAsync();
            obj = new CacheManager(getContext(), JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/nautilus/domain/data/EbayCategoryNode, (new StringBuilder()).append("categoryService-").append(ebaysite.idString).toString(), ((DeviceConfiguration) (obj)).get(com.ebay.nautilus.domain.dcs.DcsDomain.Verticals.I.categoryServiceInflatedCacheSize), ((DeviceConfiguration) (obj)).get(com.ebay.nautilus.domain.dcs.DcsDomain.Verticals.I.categoryServiceFlatCacheSize), ((DeviceConfiguration) (obj)).get(com.ebay.nautilus.domain.dcs.DcsDomain.Verticals.I.categoryServiceDiskCacheSize), ((DeviceConfiguration) (obj)).get(com.ebay.nautilus.domain.dcs.DcsDomain.Verticals.L.categoryServiceMaxCacheTtl), false);
        }
        return ((CacheManager) (obj));
    }

    public KeyParams getParams()
    {
        return keyParams;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void getPathToCategory(long l, Observer observer)
    {
        if (LOGGER.isLoggable)
        {
            FwLog.logMethod(LOGGER, new Object[] {
                Long.valueOf(l), observer
            });
        }
        NautilusKernel.verifyMain();
        if (tasksInFlight.get(l) == null)
        {
            EbayCategoryNode ebaycategorynode = (EbayCategoryNode)cacheManager.getInMemory((new StringBuilder()).append("categoryPath-").append(l).toString());
            if (ebaycategorynode != null)
            {
                if (observer != null)
                {
                    observer.onCategoriesChanged(this, l, new Content(ebaycategorynode));
                    return;
                }
            } else
            {
                tasksInFlight.put(l, executeOnThreadPool(new GetCategoryPathTask(l, getParams().ebaySite), new Void[0]));
                return;
            }
        }
    }

    public void loadData(long l, int i, Observer observer)
    {
        if (LOGGER.isLoggable)
        {
            FwLog.logMethod(LOGGER, new Object[] {
                Long.valueOf(l), observer
            });
        }
        NautilusKernel.verifyMain();
        if (tasksInFlight.get(l) == null)
        {
            EbayCategoryNode ebaycategorynode = (EbayCategoryNode)cacheManager.getInMemory((new StringBuilder()).append("childrenFor-").append(l).toString());
            if (ebaycategorynode != null)
            {
                if (observer != null)
                {
                    observer.onCategoriesChanged(this, l, new Content(ebaycategorynode));
                    return;
                }
            } else
            {
                tasksInFlight.put(l, executeOnThreadPool(new GetChildCategoriesTask(l, i, getParams().ebaySite), new Void[0]));
                return;
            }
        }
    }

    public void loadData(Observer observer)
    {
        if (LOGGER.isLoggable)
        {
            FwLog.logMethod(LOGGER, new Object[] {
                observer
            });
        }
        NautilusKernel.verifyMain();
        if (tasksInFlight.get(-1L) == null)
        {
            EbayCategoryNode ebaycategorynode = (EbayCategoryNode)cacheManager.getInMemory("topLevel");
            if (ebaycategorynode != null)
            {
                if (observer != null)
                {
                    observer.onCategoriesChanged(this, -1L, new Content(ebaycategorynode));
                    return;
                }
            } else
            {
                tasksInFlight.put(-1L, executeOnThreadPool(new GetTopLevelCategoriesTask(getParams().ebaySite), new Void[0]));
                return;
            }
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    protected void onLastObserverUnregistered()
    {
        int j = tasksInFlight.size();
        if (j > 0)
        {
            for (int i = 0; i < j; i++)
            {
                ((AsyncTask)tasksInFlight.valueAt(i)).cancel(true);
            }

            tasksInFlight.clear();
        }
    }






}
