// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.localytics.android:
//            SessionHandler, DatapointHelper, Constants, ReflectionUtils

public class LocalyticsSession
{
    static final class ProfileDbAction extends Enum
    {

        private static final ProfileDbAction $VALUES[];
        public static final ProfileDbAction SET_ATTRIBUTE;

        public static ProfileDbAction valueOf(String s)
        {
            return (ProfileDbAction)Enum.valueOf(com/localytics/android/LocalyticsSession$ProfileDbAction, s);
        }

        public static ProfileDbAction[] values()
        {
            return (ProfileDbAction[])$VALUES.clone();
        }

        static 
        {
            SET_ATTRIBUTE = new ProfileDbAction("SET_ATTRIBUTE", 0);
            $VALUES = (new ProfileDbAction[] {
                SET_ATTRIBUTE
            });
        }

        private ProfileDbAction(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Map sLocalyticsSessionHandlerMap = new HashMap();
    private static final Object sLocalyticsSessionIntrinsicLock[] = new Object[0];
    protected static final HandlerThread sSessionHandlerThread = getHandlerThread(com/localytics/android/SessionHandler.getSimpleName());
    protected final Context mContext;
    private final SessionHandler mSessionHandler;

    public LocalyticsSession(Context context)
    {
        this(context, null);
    }

    public LocalyticsSession(Context context, String s)
    {
        this(context, s, null);
    }

    LocalyticsSession(Context context, String s, String s1)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context cannot be null");
        }
        Object obj = s;
        s = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s = DatapointHelper.getLocalyticsAppKeyOrNull(context);
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("key cannot be null or empty");
        }
        if ("com.localytics.android".equals(context.getPackageName()) && !context.getClass().getName().equals("android.test.IsolatedContext") && !context.getClass().getName().equals("android.test.RenamingDelegatingContext"))
        {
            throw new IllegalArgumentException(String.format("context.getPackageName() returned %s", new Object[] {
                context.getPackageName()
            }));
        }
        obj = context;
        if (!context.getClass().getName().equals("android.test.RenamingDelegatingContext"))
        {
            obj = context;
            if (Constants.CURRENT_API_LEVEL >= 8)
            {
                obj = context.getApplicationContext();
            }
        }
        mContext = ((Context) (obj));
        Object aobj[] = sLocalyticsSessionIntrinsicLock;
        aobj;
        JVM INSTR monitorenter ;
        SessionHandler sessionhandler = (SessionHandler)sLocalyticsSessionHandlerMap.get(s);
        context = sessionhandler;
        if (sessionhandler != null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        context = createSessionHandler(mContext, s, sSessionHandlerThread.getLooper());
        sLocalyticsSessionHandlerMap.put(s, context);
        context.sendMessage(context.obtainMessage(0, s1));
        mSessionHandler = context;
        aobj;
        JVM INSTR monitorexit ;
        return;
        context;
        aobj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static Map convertDimensionsToAttributes(List list)
    {
        TreeMap treemap = new TreeMap();
        if (list != null)
        {
            int i = 0;
            list = list.iterator();
            while (list.hasNext()) 
            {
                String s = (String)list.next();
                if (i == 0)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1, s);
                } else
                if (1 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2, s);
                } else
                if (2 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3, s);
                } else
                if (3 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4, s);
                } else
                if (4 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5, s);
                } else
                if (5 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6, s);
                } else
                if (6 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7, s);
                } else
                if (7 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8, s);
                } else
                if (8 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9, s);
                } else
                if (9 == i)
                {
                    treemap.put(LocalyticsProvider.AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10, s);
                }
                i++;
            }
        }
        return treemap;
    }

    private static HandlerThread getHandlerThread(String s)
    {
        s = new HandlerThread(s, 10);
        s.start();
        return s;
    }

    public void close()
    {
        close(null);
    }

    public void close(List list)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            if (list.isEmpty() && Constants.IS_LOGGABLE)
            {
                Log.w("Localytics", "customDimensions is empty.  Did the caller make an error?");
            }
            if (list.size() > 10 && Constants.IS_LOGGABLE)
            {
                Log.w("Localytics", String.format("customDimensions size is %d, exceeding the maximum size of %d.  Did the caller make an error?", new Object[] {
                    Integer.valueOf(list.size()), Integer.valueOf(10)
                }));
            }
            Iterator iterator = list.iterator();
            String s;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                s = (String)iterator.next();
                if (s == null)
                {
                    throw new IllegalArgumentException("customDimensions cannot contain null elements");
                }
            } while (s.length() != 0);
            throw new IllegalArgumentException("customDimensions cannot contain empty elements");
        }
        if (list == null || list.isEmpty())
        {
            mSessionHandler.sendEmptyMessage(2);
            return;
        } else
        {
            mSessionHandler.sendMessage(mSessionHandler.obtainMessage(2, new TreeMap(convertDimensionsToAttributes(list))));
            return;
        }
    }

    protected SessionHandler createSessionHandler(Context context, String s, Looper looper)
    {
        SessionHandler sessionhandler;
        Object obj;
        obj = null;
        sessionhandler = null;
        SessionHandler sessionhandler1 = (SessionHandler)ReflectionUtils.tryInvokeConstructor("com.localytics.android.AmpSessionHandler", new Class[] {
            android/content/Context, java/lang/String, android/os/Looper
        }, new Object[] {
            context, s, looper
        });
        if (sessionhandler1 != null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        sessionhandler = sessionhandler1;
        obj = sessionhandler1;
        try
        {
            throw new Exception();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        context = new SessionHandler(context, s, looper);
        return context;
        return sessionhandler1;
_L2:
        return ((SessionHandler) (obj));
        context;
        obj = sessionhandler;
        if (true) goto _L2; else goto _L1
_L1:
    }

    SessionHandler getSessionHandler()
    {
        return mSessionHandler;
    }

    public void handleNotificationReceived(Intent intent)
    {
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(21, intent));
    }

    public void handleRegistration(Intent intent)
    {
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(20, intent));
    }

    public void open()
    {
        open(null);
    }

    public void open(List list)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            if (list.isEmpty() && Constants.IS_LOGGABLE)
            {
                Log.w("Localytics", "customDimensions is empty.  Did the caller make an error?");
            }
            if (list.size() > 10 && Constants.IS_LOGGABLE)
            {
                Log.w("Localytics", String.format("customDimensions size is %d, exceeding the maximum size of %d.  Did the caller make an error?", new Object[] {
                    Integer.valueOf(list.size()), Integer.valueOf(10)
                }));
            }
            Iterator iterator = list.iterator();
            String s;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                s = (String)iterator.next();
                if (s == null)
                {
                    throw new IllegalArgumentException("customDimensions cannot contain null elements");
                }
            } while (s.length() != 0);
            throw new IllegalArgumentException("customDimensions cannot contain empty elements");
        }
        if (list == null || list.isEmpty())
        {
            mSessionHandler.sendEmptyMessage(1);
            return;
        } else
        {
            mSessionHandler.sendMessage(mSessionHandler.obtainMessage(1, new TreeMap(convertDimensionsToAttributes(list))));
            return;
        }
    }

    public void tagEvent(String s, Map map, List list)
    {
        tagEvent(s, map, list, 0L);
    }

    public void tagEvent(String s, Map map, List list, long l)
    {
label0:
        {
            if (s == null)
            {
                throw new IllegalArgumentException("event cannot be null");
            }
            if (s.length() == 0)
            {
                throw new IllegalArgumentException("event cannot be empty");
            }
            if (map == null)
            {
                break label0;
            }
            if (map.isEmpty() && Constants.IS_LOGGABLE)
            {
                Log.w("Localytics", "attributes is empty.  Did the caller make an error?");
            }
            if (map.size() > 50 && Constants.IS_LOGGABLE)
            {
                Log.w("Localytics", String.format("attributes size is %d, exceeding the maximum size of %d.  Did the caller make an error?", new Object[] {
                    Integer.valueOf(map.size()), Integer.valueOf(50)
                }));
            }
            Iterator iterator = map.entrySet().iterator();
            Object obj;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj = (java.util.Map.Entry)iterator.next();
                String s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
                if (s1 == null)
                {
                    throw new IllegalArgumentException("attributes cannot contain null keys");
                }
                if (obj == null)
                {
                    throw new IllegalArgumentException("attributes cannot contain null values");
                }
                if (s1.length() == 0)
                {
                    throw new IllegalArgumentException("attributes cannot contain empty keys");
                }
            } while (((String) (obj)).length() != 0);
            throw new IllegalArgumentException("attributes cannot contain empty values");
        }
label1:
        {
            if (list == null)
            {
                break label1;
            }
            if (list.isEmpty() && Constants.IS_LOGGABLE)
            {
                Log.w("Localytics", "customDimensions is empty.  Did the caller make an error?");
            }
            if (list.size() > 10 && Constants.IS_LOGGABLE)
            {
                Log.w("Localytics", String.format("customDimensions size is %d, exceeding the maximum size of %d.  Did the caller make an error?", new Object[] {
                    Integer.valueOf(list.size()), Integer.valueOf(10)
                }));
            }
            Iterator iterator1 = list.iterator();
            String s2;
            do
            {
                if (!iterator1.hasNext())
                {
                    break label1;
                }
                s2 = (String)iterator1.next();
                if (s2 == null)
                {
                    throw new IllegalArgumentException("customDimensions cannot contain null elements");
                }
            } while (s2.length() != 0);
            throw new IllegalArgumentException("customDimensions cannot contain empty elements");
        }
        s = String.format("%s:%s", new Object[] {
            mContext.getPackageName(), s
        });
        if (map == null && list == null)
        {
            mSessionHandler.sendMessage(mSessionHandler.obtainMessage(3, ((Object) (new Object[] {
                s, null, Long.valueOf(l)
            }))));
            return;
        }
        TreeMap treemap = new TreeMap();
        if (map != null)
        {
            String s3 = mContext.getPackageName();
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); treemap.put(String.format("%s:%s", new Object[] {
    s3, entry.getKey()
}), entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        if (list != null)
        {
            treemap.putAll(convertDimensionsToAttributes(list));
        }
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(3, ((Object) (new Object[] {
            s, new TreeMap(treemap), Long.valueOf(l)
        }))));
    }

    public void upload()
    {
        uploadAnalytics();
        uploadProfile();
    }

    protected void uploadAnalytics()
    {
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(4, null));
    }

    protected void uploadProfile()
    {
        mSessionHandler.sendMessage(mSessionHandler.obtainMessage(17, null));
    }

}
