// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import com.flurry.android.caching.CachingManager;
import com.flurry.android.caching.ObjectData;
import com.flurry.android.caching.ObjectOperationData;
import com.flurry.android.responses.AppCloudApplyOperationResonseHandler;
import com.flurry.android.responses.AppCloudCommonOperationResponseHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudObserver, r, AppCloudUser, FlurryAppCloud, 
//            fv, gb, fk, fy, 
//            ga, CacheSyncManager, at, az, 
//            ge, gd, fz, AppCloudResponseHandler, 
//            AppCloudValueUpdateHandler

abstract class cx
    implements AppCloudObserver
{

    protected String mCollectionName;
    protected String mEmail;
    protected String mId;
    protected String mUsername;
    protected HashMap paramMap;
    protected String password;

    cx()
    {
        mId = "";
        mCollectionName = "";
        paramMap = new HashMap();
    }

    public boolean containsObserver()
    {
        return r.d(mId);
    }

    protected void createObject(JSONObject jsonobject)
    {
        if (jsonobject.has("_type"))
        {
            mCollectionName = jsonobject.getString("_type");
        }
        if (jsonobject.has("_id"))
        {
            mId = jsonobject.getString("_id");
        }
          goto _L1
_L3:
        int i;
        if (i >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        String s = jsonobject.names().getString(i);
        String s1 = jsonobject.getString(s);
        if (!s.equals("code") || !s.equals("note"))
        {
            paramMap.put(s, s1);
        }
        i++;
        continue; /* Loop/switch isn't completed */
        jsonobject;
        jsonobject.printStackTrace();
        return;
_L1:
        i = 0;
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected void createUser(JSONObject jsonobject)
    {
        if (jsonobject.has("username"))
        {
            mUsername = jsonobject.getString("username");
        }
        if (jsonobject.has("email"))
        {
            mEmail = jsonobject.getString("email");
        }
        if (jsonobject.has("_id"))
        {
            mId = jsonobject.getString("_id");
        }
          goto _L1
_L3:
        int i;
        if (i >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        String s = jsonobject.names().getString(i);
        String s1 = jsonobject.getString(s);
        paramMap.put(s, s1);
        i++;
        continue; /* Loop/switch isn't completed */
        jsonobject;
        jsonobject.printStackTrace();
        return;
_L1:
        i = 0;
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected void decrement(String s, String s1, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
    {
        ObjectOperationData objectoperationdata;
        if (this instanceof AppCloudUser)
        {
            objectoperationdata = new ObjectOperationData(mId);
        } else
        {
            objectoperationdata = new ObjectOperationData(mId, mCollectionName);
        }
        objectoperationdata.addKeyValue(s, s1);
        FlurryAppCloud.C().decrementOperation(objectoperationdata, new fv(this, appcloudcommonoperationresponsehandler));
    }

    protected void delete(AppCloudResponseHandler appcloudresponsehandler)
    {
        boolean flag = this instanceof AppCloudUser;
        ObjectData objectdata;
        if (flag)
        {
            objectdata = new ObjectData(mId);
        } else
        {
            objectdata = new ObjectData(mId, mCollectionName);
        }
        FlurryAppCloud.E().c(objectdata, new gb(this, flag, appcloudresponsehandler));
    }

    public String get(String s)
    {
label0:
        {
            try
            {
                if (!paramMap.containsKey(s))
                {
                    break label0;
                }
                s = (String)paramMap.get(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return s;
        }
        return null;
    }

    public float getFloat(String s)
    {
label0:
        {
            float f;
            try
            {
                if (!paramMap.containsKey(s))
                {
                    break label0;
                }
                f = Float.parseFloat((String)paramMap.get(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return 0.0F;
            }
            return f;
        }
        return 0.0F;
    }

    public String getId()
    {
        return mId;
    }

    public int getInt(String s)
    {
label0:
        {
            int i;
            try
            {
                if (!paramMap.containsKey(s))
                {
                    break label0;
                }
                i = Integer.parseInt((String)paramMap.get(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return 0;
            }
            return i;
        }
        return 0;
    }

    public Vector getKeyValues()
    {
        Vector vector = new Vector();
        Iterator iterator = paramMap.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            if (!s.startsWith("_") && !s.equals("username") && !s.equals("email") && !s.equals("code") && !s.equals("note"))
            {
                vector.add(new BasicNameValuePair(s, (String)entry.getValue()));
            }
        } while (true);
        return vector;
    }

    protected void getObjectOrUser(AppCloudResponseHandler appcloudresponsehandler)
    {
        boolean flag = this instanceof AppCloudUser;
        ObjectData objectdata;
        if (flag)
        {
            objectdata = new ObjectData(mId);
        } else
        {
            objectdata = new ObjectData(mId, mCollectionName);
        }
        try
        {
            FlurryAppCloud.E().d(objectdata, new fy(this, appcloudresponsehandler, flag));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AppCloudResponseHandler appcloudresponsehandler)
        {
            appcloudresponsehandler.printStackTrace();
        }
    }

    protected void increment(String s, String s1, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
    {
        ObjectOperationData objectoperationdata;
        if (this instanceof AppCloudUser)
        {
            objectoperationdata = new ObjectOperationData(mId);
        } else
        {
            objectoperationdata = new ObjectOperationData(mId, mCollectionName);
        }
        objectoperationdata.addKeyValue(s, s1);
        FlurryAppCloud.C().incrementOperation(objectoperationdata, new ga(this, appcloudcommonoperationresponsehandler));
    }

    public boolean isAutoSyncEnabled()
    {
        return r.e(mId);
    }

    final void q(String s)
    {
        boolean flag = false;
        String s1 = null;
        ObjectData objectdata;
        ObjectData objectdata1;
        int i;
        if (FlurryAppCloud.D().getPendingData().x(s))
        {
            objectdata = FlurryAppCloud.D().getPendingData().getObjectById(s);
        } else
        {
            objectdata = null;
        }
        if (FlurryAppCloud.D().getServerData().x(s))
        {
            objectdata1 = FlurryAppCloud.D().getServerData().getObjectById(s);
        } else
        {
            objectdata1 = null;
        }
        if (objectdata != null || objectdata1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (objectdata1 != null)
        {
            s1 = objectdata1.getCollectionName();
        }
        if (TextUtils.isEmpty(s1) && objectdata != null)
        {
            objectdata.getCollectionName();
        }
        setId(s);
        if (objectdata1 != null)
        {
            for (i = 0; i < objectdata1.getKeyValues().size(); i++)
            {
                set(((NameValuePair)objectdata1.getKeyValues().get(i)).getName(), ((NameValuePair)objectdata1.getKeyValues().get(i)).getValue());
            }

        }
        if (objectdata != null)
        {
            i = ((flag) ? 1 : 0);
            while (i < objectdata.getKeyValues().size()) 
            {
                set(((NameValuePair)objectdata.getKeyValues().get(i)).getName(), ((NameValuePair)objectdata.getKeyValues().get(i)).getValue());
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean removeAllObservers()
    {
        if (TextUtils.isEmpty(mId))
        {
            return false;
        } else
        {
            return r.a(mId);
        }
    }

    public boolean removeObserver(AppCloudValueUpdateHandler appcloudvalueupdatehandler)
    {
        if (TextUtils.isEmpty(mId))
        {
            return false;
        } else
        {
            return r.a(mId, appcloudvalueupdatehandler);
        }
    }

    public boolean removeObserverForKey(String s)
    {
        if (TextUtils.isEmpty(mId))
        {
            return false;
        } else
        {
            return r.a(mId, s);
        }
    }

    public void saveOrCreateWithCompletionHandler(AppCloudApplyOperationResonseHandler appcloudapplyoperationresonsehandler)
        throws Exception
    {
        boolean flag = this instanceof AppCloudUser;
        Object obj;
        if (flag)
        {
            ObjectData objectdata = new ObjectData(mId);
            objectdata.setKeyValues(getKeyValues());
            if (mUsername != null && !mUsername.equals(""))
            {
                objectdata.addKeyValue("username", mUsername);
            }
            if (password != null && !password.equals(""))
            {
                objectdata.addKeyValue("password", password);
            }
            obj = objectdata;
            if (mEmail != null)
            {
                obj = objectdata;
                if (!mEmail.equals(""))
                {
                    objectdata.addKeyValue("email", mEmail);
                    obj = objectdata;
                }
            }
        } else
        {
            obj = new ObjectData(mId, mCollectionName);
            ((ObjectData) (obj)).setKeyValues(getKeyValues());
        }
        if (TextUtils.isEmpty(mId))
        {
            if (flag)
            {
                ObjectOperationData objectoperationdata = new ObjectOperationData(null);
                obj = ((ObjectData) (obj)).getKeyValues();
                for (int i = 0; i < ((Vector) (obj)).size(); i++)
                {
                    objectoperationdata.addKeyValue(((NameValuePair)((Vector) (obj)).get(i)).getName(), ((NameValuePair)((Vector) (obj)).get(i)).getValue());
                }

                FlurryAppCloud.C().saveOrCreateOperation(objectoperationdata, new ge(this, appcloudapplyoperationresonsehandler));
                return;
            } else
            {
                FlurryAppCloud.E().a(((ObjectData) (obj)), new gd(this, appcloudapplyoperationresonsehandler));
                return;
            }
        } else
        {
            FlurryAppCloud.E().b(((ObjectData) (obj)), new fz(appcloudapplyoperationresonsehandler));
            return;
        }
    }

    public void saveToCache()
    {
        for (int i = 0; i < getKeyValues().size(); i++)
        {
            String s = ((NameValuePair)getKeyValues().get(i)).getName();
            String s1 = ((NameValuePair)getKeyValues().get(i)).getValue();
            FlurryAppCloud.D().getServerData().b(s, s1, mId, mCollectionName);
        }

    }

    public void set(String s, Object obj)
    {
        if (s.equals("code") || s.equals("note"))
        {
            return;
        }
        if (paramMap.containsKey(s))
        {
            paramMap.remove(s);
            paramMap.put(s, obj.toString());
            return;
        } else
        {
            paramMap.put(s, obj.toString());
            return;
        }
    }

    public boolean setAutoSyncEnabled(boolean flag)
    {
        if (flag)
        {
            return r.b(mId);
        } else
        {
            return r.c(mId);
        }
    }

    protected void setId(String s)
    {
        mId = s;
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("").append("id : ").append(mId).append(" ; ").toString();
        Vector vector = getKeyValues();
        for (int i = 0; i < vector.size(); i++)
        {
            s = (new StringBuilder()).append(s).append("\n( key : value ) = ( ").append(((NameValuePair)vector.get(i)).getName()).append(" : ").append(((NameValuePair)vector.get(i)).getValue()).append(" )").toString();
        }

        return s;
    }
}
