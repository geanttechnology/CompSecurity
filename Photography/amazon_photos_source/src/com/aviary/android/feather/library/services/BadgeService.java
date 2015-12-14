// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import com.aviary.android.feather.common.utils.DateTimeUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, IAviaryController, PreferenceService, ThreadPoolService

public class BadgeService extends BaseContextService
{
    public static interface OnToolBadgesUpdateListener
    {

        public abstract void onToolBadgeSingleUpdate(BadgeService badgeservice, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools);

        public abstract void onToolBadgesUpdate(BadgeService badgeservice);
    }


    static final String BADGE_ITEM_PREFIX = "badge.item.";
    private boolean mEnabled;
    private final ContentObserver mObserver = new ContentObserver(new Handler()) {

        final BadgeService this$0;

        public void onChange(boolean flag)
        {
            onChange(flag, null);
        }

        public void onChange(boolean flag, Uri uri)
        {
            updateToolBadges();
        }

            
            {
                this$0 = BadgeService.this;
                super(handler);
            }
    };
    private final List mToolBadgesUpdateListeners = new LinkedList();
    private final Set mToolsBadges = Collections.synchronizedSet(new HashSet());

    public BadgeService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
        mEnabled = true;
        registerToExternalUpdates();
    }

    private void dispatchToolBadgeSingleUpdate(final com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools type)
    {
        List list = mToolBadgesUpdateListeners;
        list;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList(mToolBadgesUpdateListeners.size());
        for (Iterator iterator1 = mToolBadgesUpdateListeners.iterator(); iterator1.hasNext(); arraylist.add((OnToolBadgesUpdateListener)iterator1.next())) { }
        break MISSING_BLOCK_LABEL_68;
        type;
        list;
        JVM INSTR monitorexit ;
        throw type;
        list;
        JVM INSTR monitorexit ;
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            final OnToolBadgesUpdateListener l = (OnToolBadgesUpdateListener)iterator.next();
            if (l != null)
            {
                mHandler.post(new Runnable() {

                    final BadgeService this$0;
                    final OnToolBadgesUpdateListener val$l;
                    final com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools val$type;

                    public void run()
                    {
                        l.onToolBadgeSingleUpdate(BadgeService.this, type);
                    }

            
            {
                this$0 = BadgeService.this;
                l = ontoolbadgesupdatelistener;
                type = tools;
                super();
            }
                });
            }
        } while (true);
        return;
    }

    private void dispatchToolBadgesUpdate()
    {
        if (isActive() && isEnabled()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        List list = mToolBadgesUpdateListeners;
        list;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ArrayList(mToolBadgesUpdateListeners.size());
        for (Iterator iterator1 = mToolBadgesUpdateListeners.iterator(); iterator1.hasNext(); ((ArrayList) (obj)).add((OnToolBadgesUpdateListener)iterator1.next())) { }
        break MISSING_BLOCK_LABEL_80;
        obj;
        list;
        JVM INSTR monitorexit ;
        throw obj;
        list;
        JVM INSTR monitorexit ;
        Iterator iterator = ((ArrayList) (obj)).iterator();
        while (iterator.hasNext()) 
        {
            OnToolBadgesUpdateListener ontoolbadgesupdatelistener = (OnToolBadgesUpdateListener)iterator.next();
            if (ontoolbadgesupdatelistener != null)
            {
                ontoolbadgesupdatelistener.onToolBadgesUpdate(this);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private Context getBaseContext()
    {
        if (getContext() != null)
        {
            return getContext().getBaseContext();
        } else
        {
            return null;
        }
    }

    private void registerToExternalUpdates()
    {
        Context context = getBaseContext();
        if (context != null)
        {
            context.getContentResolver().registerContentObserver(PackageManagerUtils.getCDSProviderContentUri(context, "service/finished"), false, mObserver);
            updateToolBadges();
        }
    }

    private boolean updateFromList(IAviaryController iaviarycontroller, PreferenceService preferenceservice, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools, String s)
    {
        if (iaviarycontroller == null || iaviarycontroller.getBaseContext() == null || !isActive())
        {
            return false;
        }
        iaviarycontroller = iaviarycontroller.getBaseContext();
        iaviarycontroller = iaviarycontroller.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(iaviarycontroller, (new StringBuilder()).append("pack/type/").append(s).append("/content/available/list").toString()), new String[] {
            "pack_creationDate"
        }, null, null, "pack_id DESC");
        if (iaviarycontroller == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        if (!iaviarycontroller.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_154;
        }
        preferenceservice = new Date(preferenceservice.getToolLastReadDate(tools));
        tools = DateTimeUtils.fromSqlDateTime(iaviarycontroller.getString(0), true);
        long l;
        long l1;
        l = tools.getTime();
        l1 = preferenceservice.getTime();
        if (l > l1)
        {
            IOUtils.closeSilently(iaviarycontroller);
            return true;
        }
        break MISSING_BLOCK_LABEL_154;
        preferenceservice;
        preferenceservice.printStackTrace();
        IOUtils.closeSilently(iaviarycontroller);
        return false;
        IOUtils.closeSilently(iaviarycontroller);
        return false;
        preferenceservice;
        IOUtils.closeSilently(iaviarycontroller);
        throw preferenceservice;
    }

    private void updateToolBadges()
    {
        ThreadPoolService threadpoolservice;
        if (isActive() && isEnabled() && getContext() != null)
        {
            if ((threadpoolservice = (ThreadPoolService)getContext().getService(com/aviary/android/feather/library/services/ThreadPoolService)) != null)
            {
                threadpoolservice.submit(new com.aviary.android.feather.common.threading.ThreadPool.Job() {

                    final BadgeService this$0;

                    public volatile Object run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Object aobj[])
                        throws Exception
                    {
                        return run(worker, (Integer[])aobj);
                    }

                    public transient Set run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Integer ainteger[])
                        throws Exception
                    {
                        IAviaryController iaviarycontroller = getContext();
                        if (iaviarycontroller == null)
                        {
                            worker = null;
                        } else
                        {
                            ainteger = new HashSet();
                            PreferenceService preferenceservice = (PreferenceService)iaviarycontroller.getService(com/aviary/android/feather/library/services/PreferenceService);
                            if (preferenceservice == null)
                            {
                                return null;
                            }
                            if (updateFromList(iaviarycontroller, preferenceservice, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.EFFECTS, "effect"))
                            {
                                ainteger.add(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.EFFECTS);
                            }
                            if (updateFromList(iaviarycontroller, preferenceservice, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FRAMES, "frame"))
                            {
                                ainteger.add(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FRAMES);
                            }
                            if (updateFromList(iaviarycontroller, preferenceservice, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.STICKERS, "sticker"))
                            {
                                ainteger.add(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.STICKERS);
                            }
                            worker = ainteger;
                            if (updateFromList(iaviarycontroller, preferenceservice, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.OVERLAYS, "overlay"))
                            {
                                ainteger.add(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.OVERLAYS);
                                return ainteger;
                            }
                        }
                        return worker;
                    }

            
            {
                this$0 = BadgeService.this;
                super();
            }
                }, new FutureListener() {

                    final BadgeService this$0;

                    public void onFutureDone(Future future)
                    {
label0:
                        {
                            Object obj = null;
                            if (future != null)
                            {
                                try
                                {
                                    future = (Set)future.get();
                                }
                                // Misplaced declaration of an exception variable
                                catch (Future future)
                                {
                                    future.printStackTrace();
                                    future = obj;
                                }
                                if (future != null)
                                {
                                    int i = mToolsBadges.size();
                                    mToolsBadges.addAll(future);
                                    if (mToolsBadges.size() != i && mHandler != null)
                                    {
                                        break label0;
                                    }
                                }
                            }
                            return;
                        }
                        mHandler.post(new Runnable() {

                            final _cls3 this$1;

                            public void run()
                            {
                                dispatchToolBadgesUpdate();
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                    }

            
            {
                this$0 = BadgeService.this;
                super();
            }
                }, new Integer[] {
                    Integer.valueOf(0)
                });
                return;
            }
        }
    }

    public void dispose()
    {
        mToolsBadges.clear();
        mToolBadgesUpdateListeners.clear();
        Context context = getBaseContext();
        if (context != null)
        {
            context.getContentResolver().unregisterContentObserver(mObserver);
        }
    }

    public boolean getIsActive(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        return mToolsBadges.contains(tools);
    }

    public boolean getIsActive(String s)
    {
        PreferenceService preferenceservice;
        if (isActive() && isEnabled() && s != null)
        {
            if ((preferenceservice = (PreferenceService)getContext().getService(com/aviary/android/feather/library/services/PreferenceService)) != null && !preferenceservice.containsValue((new StringBuilder()).append("badge.item.").append(s).toString()))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isEnabled()
    {
        return mEnabled;
    }

    public void markAsRead(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        while (!isActive() || !isEnabled() || !mToolsBadges.remove(tools)) 
        {
            return;
        }
        PreferenceService preferenceservice = (PreferenceService)getContext().getService(com/aviary/android/feather/library/services/PreferenceService);
        if (preferenceservice != null)
        {
            preferenceservice.markToolAsRead(tools);
        }
        dispatchToolBadgeSingleUpdate(tools);
    }

    public void markAsRead(String s)
    {
        PreferenceService preferenceservice;
        if (isActive() && isEnabled() && s != null)
        {
            if ((preferenceservice = (PreferenceService)getContext().getService(com/aviary/android/feather/library/services/PreferenceService)) != null)
            {
                preferenceservice.putInt((new StringBuilder()).append("badge.item.").append(s).toString(), 1);
                return;
            }
        }
    }

    public void registerOnToolBadgesUpdateListener(OnToolBadgesUpdateListener ontoolbadgesupdatelistener)
    {
        if (!isActive() || !isEnabled())
        {
            return;
        }
        synchronized (mToolBadgesUpdateListeners)
        {
            if (!mToolBadgesUpdateListeners.contains(ontoolbadgesupdatelistener))
            {
                mToolBadgesUpdateListeners.add(ontoolbadgesupdatelistener);
            }
        }
        return;
        ontoolbadgesupdatelistener;
        list;
        JVM INSTR monitorexit ;
        throw ontoolbadgesupdatelistener;
    }

    public void removeOnToolBadgesUpdateListener(OnToolBadgesUpdateListener ontoolbadgesupdatelistener)
    {
        if (isActive())
        {
            return;
        }
        synchronized (mToolBadgesUpdateListeners)
        {
            if (mToolBadgesUpdateListeners.contains(ontoolbadgesupdatelistener))
            {
                mToolBadgesUpdateListeners.remove(ontoolbadgesupdatelistener);
            }
        }
        return;
        ontoolbadgesupdatelistener;
        list;
        JVM INSTR monitorexit ;
        throw ontoolbadgesupdatelistener;
    }




}
