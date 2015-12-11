// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.country.Country;
import com.groupon.models.markused.MarkUsed;
import com.groupon.models.markused.RedemptionStamp;
import com.groupon.network.HttpResponseException;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LoginService, LocationService

public class MarkUsedManager
{

    private static final String MARKUSED = "markUsed";
    private static final String REDEMPTION_STAMP_DATA = "redemptionStampData";
    private Application application;
    private CurrentCountryManager currentCountryManager;
    private LocationService locationService;
    private LoginService loginService;
    private List markUsedList;
    private ArraySharedPreferences prefs;
    private List redemptionStampList;

    public MarkUsedManager()
    {
    }

    private void init()
        throws IOException
    {
        markUsedList = prefs.getListObject("markUsed", com/groupon/models/markused/MarkUsed, new ArrayList());
        redemptionStampList = prefs.getListObject("redemptionStampData", com/groupon/models/markused/RedemptionStamp, new ArrayList());
    }

    private void removeFromList(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        int i = markUsedList.size() - 1;
_L2:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        MarkUsed markused = (MarkUsed)markUsedList.get(i);
        if (!Strings.equals(markused.id, s) || !Strings.equals(markused.userId, s1))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        markUsedList.remove(i);
        saveMarkUsedList();
_L3:
        i--;
        if (true) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        break MISSING_BLOCK_LABEL_103;
        ioexception;
        Ln.e(ioexception, "Impossible to save mark used in shared prefs", new Object[0]);
          goto _L3
        s;
        throw s;
    }

    private void saveMarkUsedList()
        throws IOException
    {
        prefs.edit().putListObject("markUsed", com/groupon/models/markused/MarkUsed, markUsedList).apply();
    }

    private void saveRedemptionStampList()
        throws IOException
    {
        prefs.edit().putListObject("redemptionStampData", com/groupon/models/markused/RedemptionStamp, redemptionStampList).apply();
    }

    public boolean isCachedForGroupons(String s)
    {
        for (Iterator iterator = markUsedList.iterator(); iterator.hasNext();)
        {
            if (Strings.equals(((MarkUsed)iterator.next()).id, s))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isQueued(String s)
    {
        for (Iterator iterator = markUsedList.iterator(); iterator.hasNext();)
        {
            if (Strings.equals(((MarkUsed)iterator.next()).id, s))
            {
                return true;
            }
        }

        return false;
    }

    public void markUsed(String s, String s1)
    {
        MarkUsed markused;
        RedemptionStamp redemptionstamp;
        markused = new MarkUsed();
        markused.id = s;
        markused.userId = loginService.getUserId();
        redemptionstamp = new RedemptionStamp();
        redemptionstamp.id = s;
        redemptionstamp.time = s1;
        com/groupon/service/MarkUsedManager;
        JVM INSTR monitorenter ;
        markUsedList.add(markused);
        saveMarkUsedList();
        redemptionStampList.add(redemptionstamp);
        saveRedemptionStampList();
        com/groupon/service/MarkUsedManager;
        JVM INSTR monitorexit ;
        processQueue();
        return;
        s;
        com/groupon/service/MarkUsedManager;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }

    public void markUsedImmediately(String s, Function1 function1, Function1 function1_1, Function0 function0)
    {
        if (!currentCountryManager.getCurrentCountry().requiresMarkViewedBeforeShowingBarcode())
        {
            Ln.d("BARCODE: markUsedImmediately not supported", new Object[0]);
            return;
        } else
        {
            Ln.d("BARCODE: calling PUT /groupons/%s!", new Object[] {
                s
            });
            (new Http(new Object[] {
                "viewed", Boolean.valueOf(true)
            }, function1, function1_1, function0) {

                final MarkUsedManager this$0;
                final Function1 val$errorCallback;
                final Function0 val$finallyCallback;
                final Function1 val$successCallback;

                protected void onException(Exception exception)
                {
                    Ln.d("BARCODE: fail: %s!", new Object[] {
                        exception.getMessage()
                    });
                    if (errorCallback != null)
                    {
                        errorCallback.execute(exception);
                    }
                }

                protected void onFinally()
                {
                    if (finallyCallback != null)
                    {
                        finallyCallback.execute();
                    }
                }

                protected void onSuccess(com.groupon.models.MarkUsedData.Wrapper wrapper)
                {
                    Ln.d("BARCODE: success!", new Object[0]);
                    if (successCallback != null)
                    {
                        successCallback.execute(wrapper.groupon);
                    }
                }

                protected volatile void onSuccess(Object obj)
                    throws Exception
                {
                    onSuccess((com.groupon.models.MarkUsedData.Wrapper)obj);
                }

            transient 
            {
                this$0 = MarkUsedManager.this;
                successCallback = function1;
                errorCallback = function1_1;
                finallyCallback = function0;
                super(final_context, final_class1, final_s, aobj);
            }
            }).method("PUT").execute();
            return;
        }
    }

    public void processQueue()
    {
        if (markUsedList.isEmpty())
        {
            Ln.d("Mark Used queue is empty", new Object[0]);
        } else
        {
            Iterator iterator = markUsedList.iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (MarkUsed)iterator.next();
                String s = ((MarkUsed) (obj)).id;
                obj = ((MarkUsed) (obj)).userId;
                Location location = locationService.getLocation();
                Ln.i("Attempting to mark voucher %s as used", new Object[] {
                    s
                });
                ArrayList arraylist = new ArrayList();
                arraylist.addAll(Arrays.asList(new Serializable[] {
                    "redeemed_by_merchant", Boolean.valueOf(true)
                }));
                arraylist.addAll(ApiRequestUtil.generatePUTGrouponsParameters());
                if (location != null)
                {
                    arraylist.addAll(Arrays.asList(new Serializable[] {
                        "lat", Double.valueOf(location.getLatitude()), "lng", Double.valueOf(location.getLongitude())
                    }));
                }
                (new Http(String.format("https:/users/%s/groupons/%s", new Object[] {
                    obj, s
                }), arraylist.toArray(), s, ((String) (obj))) {

                    final MarkUsedManager this$0;
                    final String val$id;
                    final String val$username;

                    protected void onException(Exception exception)
                    {
                        if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 400)
                        {
                            Ln.d("Voucher %s was already redeemed so removing from retry queue", new Object[] {
                                id
                            });
                            removeFromList(id, username);
                        }
                        Ln.d("Failed to mark voucher %s as used", new Object[] {
                            id
                        });
                    }

                    protected volatile void onSuccess(Object obj1)
                        throws Exception
                    {
                        onSuccess((Void)obj1);
                    }

                    protected void onSuccess(Void void1)
                        throws Exception
                    {
                        removeFromList(id, username);
                        Ln.d("Voucher %s marked as used", new Object[] {
                            id
                        });
                    }

            transient 
            {
                this$0 = MarkUsedManager.this;
                id = s1;
                username = s2;
                super(final_context, final_class1, s, aobj);
            }
                }).method("PUT").execute();
            }
        }
    }

    public void processQueueSync()
    {
        if (markUsedList.isEmpty())
        {
            Ln.d("Mark Used queue is empty", new Object[0]);
        } else
        {
            Iterator iterator = markUsedList.iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (MarkUsed)iterator.next();
                String s = ((MarkUsed) (obj)).id;
                obj = ((MarkUsed) (obj)).userId;
                Location location = locationService.getLocation();
                Ln.i("Attempting to mark voucher %s as used", new Object[] {
                    s
                });
                ArrayList arraylist = new ArrayList();
                arraylist.addAll(Arrays.asList(new Serializable[] {
                    "redeemed_by_merchant", Boolean.valueOf(true)
                }));
                arraylist.addAll(ApiRequestUtil.generatePUTGrouponsParameters());
                if (location != null)
                {
                    arraylist.addAll(Arrays.asList(new Serializable[] {
                        "lat", Double.valueOf(location.getLatitude()), "lng", Double.valueOf(location.getLongitude())
                    }));
                }
                try
                {
                    (new SyncHttp(application, java/lang/Void, String.format("https:/users/%s/groupons/%s", new Object[] {
                        obj, s
                    }), arraylist.toArray())).method("PUT").call();
                    removeFromList(s, ((String) (obj)));
                    Ln.d("Voucher %s marked as used", new Object[] {
                        s
                    });
                }
                catch (Exception exception)
                {
                    if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 400)
                    {
                        Ln.d("Voucher %s was already redeemed so removing from retry queue", new Object[] {
                            s
                        });
                        removeFromList(s, ((String) (obj)));
                    }
                    Ln.d("Failed to mark voucher %s as used", new Object[] {
                        s
                    });
                }
            }
        }
    }

    public void removeMarkedUsedForGroupons(String s)
    {
        com/groupon/service/MarkUsedManager;
        JVM INSTR monitorenter ;
        int i = markUsedList.size() - 1;
_L2:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!Strings.equals(((MarkUsed)markUsedList.get(i)).id, s))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        redemptionStampList.remove(i);
        saveRedemptionStampList();
_L3:
        i--;
        if (true) goto _L2; else goto _L1
        IOException ioexception;
        ioexception;
        Ln.e(ioexception, "Impossible to save redemption stamp list to shared prefs.", new Object[0]);
          goto _L3
        s;
        com/groupon/service/MarkUsedManager;
        JVM INSTR monitorexit ;
        throw s;
_L1:
        com/groupon/service/MarkUsedManager;
        JVM INSTR monitorexit ;
    }

}
