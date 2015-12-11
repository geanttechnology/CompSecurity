// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.urbanairship.util.UAStringUtil;
import java.util.concurrent.Executor;

// Referenced classes of package com.urbanairship:
//            UrbanAirshipProvider, PreferenceDataStore, UrbanAirshipResolver, Logger

class registerObserver
{

    private final String key;
    final PreferenceDataStore this$0;
    private String value;

    private void registerObserver()
    {
        class _cls2 extends ContentObserver
        {

            final PreferenceDataStore.Preference this$1;

            public void onChange(boolean flag)
            {
                super.onChange(flag);
                Logger.verbose((new StringBuilder("PreferenceDataStore - Preference updated:")).append(key).toString());
                class _cls1
                    implements Runnable
                {

                    final _cls2 this$2;

                    public void run()
                    {
                        syncValue();
                    }

                        _cls1()
                        {
                            this$2 = _cls2.this;
                            super();
                        }
                }

                executor.execute(new _cls1());
            }

            _cls2(Handler handler)
            {
                this$1 = PreferenceDataStore.Preference.this;
                super(handler);
            }
        }

        _cls2 _lcls2 = new _cls2(null);
        Uri uri = Uri.withAppendedPath(UrbanAirshipProvider.getPreferencesContentUri(), key);
        PreferenceDataStore.access$200(PreferenceDataStore.this).registerContentObserver(uri, true, _lcls2);
    }

    private void setValue(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!UAStringUtil.equals(s, value))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        value = s;
        this;
        JVM INSTR monitorexit ;
        PreferenceDataStore.access$100(PreferenceDataStore.this, key);
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private boolean writeValue(String s)
    {
        boolean flag1 = true;
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        Logger.verbose((new StringBuilder("PreferenceDataStore - Removing preference: ")).append(key).toString());
        ContentValues contentvalues;
        if (PreferenceDataStore.access$200(PreferenceDataStore.this).delete(UrbanAirshipProvider.getPreferencesContentUri(), "_id = ?", new String[] {
    key
}) < 0)
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Logger.verbose((new StringBuilder("PreferenceDataStore - Saving preference: ")).append(key).append(" value: ").append(s).toString());
        contentvalues = new ContentValues();
        contentvalues.put("_id", key);
        contentvalues.put("value", s);
        if (PreferenceDataStore.access$200(PreferenceDataStore.this).insert(UrbanAirshipProvider.getPreferencesContentUri(), contentvalues) != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    String get()
    {
        this;
        JVM INSTR monitorenter ;
        String s = value;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void put(final String value)
    {
        setValue(value);
        class _cls1
            implements Runnable
        {

            final PreferenceDataStore.Preference this$1;
            final String val$value;

            public void run()
            {
                writeValue(value);
            }

            _cls1()
            {
                this$1 = PreferenceDataStore.Preference.this;
                value = s;
                super();
            }
        }

        executor.execute(new _cls1());
    }

    boolean putSync(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!writeValue(s))
        {
            break MISSING_BLOCK_LABEL_19;
        }
        setValue(s);
        return true;
        this;
        JVM INSTR monitorexit ;
        return false;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    void syncValue()
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = PreferenceDataStore.access$200(PreferenceDataStore.this);
        Uri uri = UrbanAirshipProvider.getPreferencesContentUri();
        String s = key;
        obj = ((UrbanAirshipResolver) (obj)).query(uri, new String[] {
            "value"
        }, "_id = ?", new String[] {
            s
        }, null);
        Object obj2 = obj;
        this;
        JVM INSTR monitorexit ;
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj2 = obj1;
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        obj1 = obj;
        obj2 = ((Cursor) (obj)).getString(0);
        obj1 = obj;
        setValue(((String) (obj2)));
_L3:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return;
        obj;
        obj1 = null;
_L5:
        obj2 = obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
_L4:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L2:
        obj1 = obj;
        Logger.debug((new StringBuilder("PreferenceDataStore - Unable to get preference ")).append(key).append(" from database. Falling back to cached value.").toString());
          goto _L3
        obj;
        obj1 = null;
          goto _L4
        obj;
        obj1 = obj2;
          goto _L5
    }



    _cls1(String s, String s1)
    {
        this$0 = PreferenceDataStore.this;
        super();
        key = s;
        value = s1;
        registerObserver();
    }
}
