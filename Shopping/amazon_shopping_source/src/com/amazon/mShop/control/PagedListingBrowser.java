// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.ui.ListingSelectionListener;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control:
//            ObjectSubscriber

public abstract class PagedListingBrowser
{

    private final int FINISH_CANCELLED = 2;
    private final int FINISH_ERROR = 1;
    protected final int FINISH_SUCCESS = 0;
    private int availableCount;
    protected int currentIndex;
    protected ServiceCall currentRequest;
    protected int currentRequestPageIndex;
    private boolean hasPendingCancellation;
    protected int lastRequestPageIndex;
    protected final List listingImages = new ArrayList();
    protected List listingIndices;
    protected final List listingObjects = new ArrayList();
    protected final int nextPageTriggerCount;
    protected int nextTriggerObjectIndex;
    protected final int pageSize;
    protected int pendingRequestPageIndex;
    protected ObjectSubscriber primarySubscriber;
    protected ObjectSubscriber secondarySubscriber;
    private ListingSelectionListener selectionListener;

    public PagedListingBrowser(int i, int j)
    {
        nextTriggerObjectIndex = -1;
        listingIndices = new ArrayList();
        currentRequestPageIndex = -1;
        pendingRequestPageIndex = -1;
        lastRequestPageIndex = -1;
        availableCount = 0x7fffffff;
        pageSize = i;
        nextPageTriggerCount = j;
    }

    private Object getCurrentObject(List list)
    {
        if (currentIndex >= list.size() && currentIndex <= listingObjects.size())
        {
            return null;
        } else
        {
            return list.get(currentIndex);
        }
    }

    private void notifyCountReceived()
    {
        if (secondarySubscriber != null)
        {
            secondarySubscriber.onAvailableCountReceived(availableCount);
        }
        if (primarySubscriber != null)
        {
            primarySubscriber.onAvailableCountReceived(availableCount);
        }
        onPrefetchCountReceived(availableCount);
    }

    private void notifyObjectReceived(Object obj, int i)
    {
        if (secondarySubscriber != null)
        {
            secondarySubscriber.onObjectReceived(obj, i);
        }
        if (primarySubscriber != null)
        {
            primarySubscriber.onObjectReceived(obj, i);
        }
        onPrefetchObjReceived(obj, i);
    }

    private void notifyObjectsReceived()
    {
        if (secondarySubscriber != null)
        {
            secondarySubscriber.onObjectsReceived();
        }
        if (primarySubscriber != null)
        {
            primarySubscriber.onObjectsReceived();
        }
        onPrefetchObjsReceived();
    }

    public void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall)
    {
    }

    protected void addToListAndNotify(List list, Object obj, int i, ServiceCall servicecall)
    {
label0:
        {
            if (servicecall == currentRequest && !hasPendingCancellation)
            {
                i = currentRequestPageIndex * pageSize + i;
                if (i != list.size())
                {
                    break label0;
                }
                list.add(obj);
                notifyObjectReceived(obj, i);
            }
            return;
        }
        notifyError(new IllegalStateException((new StringBuilder()).append("Object received out of order: ").append(i).append(" instead of ").append(list.size()).toString()), null);
    }

    protected int adjustRequestTriggerIndex(int i)
    {
        return i;
    }

    protected void availableCountReceived(final int availableCount, final ServiceCall serviceCall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final PagedListingBrowser this$0;
            final int val$availableCount;
            final ServiceCall val$serviceCall;

            public void run()
            {
                if (serviceCall == currentRequest && availableCount != PagedListingBrowser.this.availableCount)
                {
                    PagedListingBrowser.this.availableCount = availableCount;
                    notifyCountReceived();
                }
            }

            
            {
                this$0 = PagedListingBrowser.this;
                serviceCall = servicecall;
                availableCount = i;
                super();
            }
        });
    }

    public boolean cancel()
    {
        pendingRequestPageIndex = -1;
        if (currentRequest != null && !hasPendingCancellation)
        {
            hasPendingCancellation = true;
            currentRequest.cancel();
        }
        return hasPendingCancellation;
    }

    public void cancelled(ServiceCall servicecall)
    {
        requestFinished(2, null, servicecall);
    }

    public void completed(ServiceCall servicecall)
    {
        requestFinished(0, null, servicecall);
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        requestFinished(1, exception, servicecall);
    }

    public int getAvailableCount()
    {
        return availableCount;
    }

    public byte[] getCurrentImage()
    {
        return (byte[])(byte[])getCurrentObject(listingImages);
    }

    public int getCurrentIndex()
    {
        return currentIndex;
    }

    public Object getCurrentObject()
    {
        return getCurrentObject(listingObjects);
    }

    public ServiceCall getCurrentServiceCall()
    {
        return currentRequest;
    }

    public byte[] getImageAtIndex(int i)
    {
        if (i >= listingImages.size())
        {
            return null;
        } else
        {
            return (byte[])(byte[])listingImages.get(i);
        }
    }

    public Object getObjectAtIndex(int i)
    {
        if (i >= listingObjects.size())
        {
            return null;
        } else
        {
            return listingObjects.get(i);
        }
    }

    public ObjectSubscriber getPretchSubscriber()
    {
        return null;
    }

    public int getReceivedCount()
    {
        return listingObjects.size();
    }

    protected void imageReceived(final byte image[], final int intraPageIndex, final ServiceCall serviceCall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final PagedListingBrowser this$0;
            final byte val$image[];
            final int val$intraPageIndex;
            final ServiceCall val$serviceCall;

            public void run()
            {
                addToListAndNotify(listingImages, image, intraPageIndex, serviceCall);
            }

            
            {
                this$0 = PagedListingBrowser.this;
                image = abyte0;
                intraPageIndex = i;
                serviceCall = servicecall;
                super();
            }
        });
    }

    protected void notifyError(Exception exception, ServiceCall servicecall)
    {
        onPrefetchError(exception, servicecall);
        if (secondarySubscriber != null)
        {
            secondarySubscriber.onError(exception, servicecall);
        }
        if (primarySubscriber != null)
        {
            primarySubscriber.onError(exception, servicecall);
        }
    }

    protected void notifySelectionListeners(int i, int j)
    {
        if (selectionListener != null)
        {
            selectionListener.selectionChanged(i, j);
        }
    }

    protected void objectReceived(final Object o, final int intraPageIndex, final ServiceCall serviceCall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final PagedListingBrowser this$0;
            final int val$intraPageIndex;
            final Object val$o;
            final ServiceCall val$serviceCall;

            public void run()
            {
                addToListAndNotify(listingObjects, o, intraPageIndex, serviceCall);
            }

            
            {
                this$0 = PagedListingBrowser.this;
                o = obj;
                intraPageIndex = i;
                serviceCall = servicecall;
                super();
            }
        });
    }

    protected void objectsReceived(final List objects, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final PagedListingBrowser this$0;
            final List val$objects;
            final ServiceCall val$sc;

            public void run()
            {
                if (sc == currentRequest && !hasPendingCancellation)
                {
                    listingObjects.addAll(objects);
                    notifyObjectsReceived();
                    requestFinished(0, null, sc);
                }
            }

            
            {
                this$0 = PagedListingBrowser.this;
                sc = servicecall;
                objects = list;
                super();
            }
        });
    }

    protected void objectsReceived(final List objects, final ServiceCall sc, final boolean requestFinished)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final PagedListingBrowser this$0;
            final List val$objects;
            final boolean val$requestFinished;
            final ServiceCall val$sc;

            public void run()
            {
                if (sc == currentRequest && !hasPendingCancellation)
                {
                    if (!Util.isEmpty(objects))
                    {
                        listingObjects.addAll(objects);
                    }
                    notifyObjectsReceived();
                    if (requestFinished)
                    {
                        PagedListingBrowser.this.requestFinished(0, null, sc);
                    }
                }
            }

            
            {
                this$0 = PagedListingBrowser.this;
                sc = servicecall;
                objects = list;
                requestFinished = flag;
                super();
            }
        });
    }

    protected void onPrefetchCancelled()
    {
    }

    protected void onPrefetchCountReceived(int i)
    {
    }

    protected void onPrefetchError(Exception exception, ServiceCall servicecall)
    {
    }

    protected void onPrefetchObjReceived(Object obj, int i)
    {
    }

    protected void onPrefetchObjsReceived()
    {
    }

    protected void onPrefetchSuccess()
    {
    }

    public void replayPageRequest()
    {
        currentRequestPageIndex = lastRequestPageIndex + 1;
        if (currentRequestPageIndex > 0)
        {
            currentRequest = startPageRequest(currentRequestPageIndex);
            return;
        } else
        {
            currentRequest = null;
            startFirstPageRequest(availableCount, null);
            return;
        }
    }

    protected void requestFinished(final int finishState, final Exception error, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final PagedListingBrowser this$0;
            final Exception val$error;
            final int val$finishState;
            final ServiceCall val$sc;

            public void run()
            {
                if (sc == currentRequest)
                {
                    if (hasPendingCancellation)
                    {
                        hasPendingCancellation = false;
                        onPrefetchCancelled();
                        if (secondarySubscriber != null)
                        {
                            secondarySubscriber.onCancelled();
                        }
                        if (primarySubscriber != null)
                        {
                            primarySubscriber.onCancelled();
                        }
                        listingObjects.clear();
                        listingImages.clear();
                        listingIndices.clear();
                    }
                    if (finishState == 0)
                    {
                        lastRequestPageIndex = currentRequestPageIndex;
                    }
                    currentRequestPageIndex = -1;
                    currentRequest = null;
                    if (pendingRequestPageIndex >= 0)
                    {
                        if (finishState != 1)
                        {
                            currentRequestPageIndex = pendingRequestPageIndex;
                            currentRequest = startPageRequest(currentRequestPageIndex);
                        }
                        pendingRequestPageIndex = -1;
                    }
                    if (finishState == 1)
                    {
                        notifyError(error, sc);
                        return;
                    }
                    if (finishState == 0)
                    {
                        onPrefetchSuccess();
                        if (secondarySubscriber != null)
                        {
                            secondarySubscriber.onPageComplete();
                        }
                        if (primarySubscriber != null)
                        {
                            primarySubscriber.onPageComplete();
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = PagedListingBrowser.this;
                sc = servicecall;
                finishState = i;
                error = exception;
                super();
            }
        });
    }

    public void setAvailableCount(int i)
    {
        availableCount = i;
    }

    public void setCurrentIndex(int i)
    {
        if (i < 0 || i > listingObjects.size())
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("PagesListingBrowser.setCurrentIndex ").append(i).append(" is not in (0, ").append(listingObjects.size()).append(")").toString());
        }
        int j = currentIndex;
        currentIndex = i;
        int k = adjustRequestTriggerIndex(i);
        if (nextTriggerObjectIndex >= 0 && k >= nextTriggerObjectIndex)
        {
            startNextPageRequest();
            nextTriggerObjectIndex = nextTriggerObjectIndex + pageSize;
        }
        notifySelectionListeners(i, j);
    }

    public void setPrimarySubscriber(ObjectSubscriber objectsubscriber)
    {
        primarySubscriber = objectsubscriber;
    }

    public void setSecondarySubscriber(ObjectSubscriber objectsubscriber)
    {
        secondarySubscriber = objectsubscriber;
    }

    public void setSelectionListener(ListingSelectionListener listingselectionlistener)
    {
        selectionListener = listingselectionlistener;
    }

    public boolean startFirstPageRequest(int i, List list)
    {
        availableCount = i;
        currentIndex = 0;
        lastRequestPageIndex = -1;
        if (i == 0)
        {
            return hasPendingCancellation;
        }
        nextTriggerObjectIndex = pageSize - nextPageTriggerCount;
        if (list != null && (list.size() == pageSize || list.size() < pageSize && list.size() == i) && currentRequest == null)
        {
            listingObjects.clear();
            listingImages.clear();
            listingIndices.clear();
            currentRequestPageIndex = 0;
            for (i = 0; i < list.size(); i++)
            {
                addToListAndNotify(listingObjects, list.get(i), i, null);
            }

            currentRequestPageIndex = -1;
            lastRequestPageIndex = 0;
        } else
        if (currentRequest != null)
        {
            pendingRequestPageIndex = 0;
            hasPendingCancellation = true;
            listingObjects.clear();
            listingImages.clear();
            listingIndices.clear();
            currentRequest.cancel();
        } else
        {
            listingObjects.clear();
            listingImages.clear();
            listingIndices.clear();
            pendingRequestPageIndex = -1;
            currentRequestPageIndex = 0;
            currentRequest = startPageRequest(currentRequestPageIndex);
        }
        return hasPendingCancellation;
    }

    public boolean startNextPageRequest()
    {
        if (currentRequest == null) goto _L2; else goto _L1
_L1:
        if ((currentRequestPageIndex + 1) * pageSize < availableCount) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        pendingRequestPageIndex = currentRequestPageIndex + 1;
_L6:
        return true;
_L2:
        if ((lastRequestPageIndex + 1) * pageSize >= availableCount)
        {
            continue; /* Loop/switch isn't completed */
        }
        pendingRequestPageIndex = -1;
        currentRequestPageIndex = lastRequestPageIndex + 1;
        currentRequest = startPageRequest(currentRequestPageIndex);
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L3; else goto _L7
_L7:
    }

    protected abstract ServiceCall startPageRequest(int i);



/*
    static boolean access$002(PagedListingBrowser pagedlistingbrowser, boolean flag)
    {
        pagedlistingbrowser.hasPendingCancellation = flag;
        return flag;
    }

*/



/*
    static int access$102(PagedListingBrowser pagedlistingbrowser, int i)
    {
        pagedlistingbrowser.availableCount = i;
        return i;
    }

*/


}
