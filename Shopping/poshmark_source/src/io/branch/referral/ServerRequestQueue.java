// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package io.branch.referral:
//            ServerRequest, ServerRequestRegisterInstall, ServerRequestRegisterOpen, PrefHelper

class ServerRequestQueue
{

    private static final int MAX_ITEMS = 25;
    private static final String PREF_KEY = "BNCServerRequestQueue";
    private static ServerRequestQueue SharedInstance;
    private android.content.SharedPreferences.Editor editor;
    private final List queue;
    private SharedPreferences sharedPref;

    private ServerRequestQueue(Context context)
    {
        sharedPref = context.getSharedPreferences("BNC_Server_Request_Queue", 0);
        editor = sharedPref.edit();
        queue = retrieve(context);
    }

    public static ServerRequestQueue getInstance(Context context)
    {
        if (SharedInstance != null) goto _L2; else goto _L1
_L1:
        io/branch/referral/ServerRequestQueue;
        JVM INSTR monitorenter ;
        if (SharedInstance == null)
        {
            SharedInstance = new ServerRequestQueue(context);
        }
        io/branch/referral/ServerRequestQueue;
        JVM INSTR monitorexit ;
_L2:
        return SharedInstance;
        context;
        io/branch/referral/ServerRequestQueue;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void persist()
    {
        (new Thread(new Runnable() {

            final ServerRequestQueue this$0;

            public void run()
            {
                JSONArray jsonarray = new JSONArray();
                List list = queue;
                list;
                JVM INSTR monitorenter ;
                Object obj = queue.iterator();
_L2:
                Object obj2;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break MISSING_BLOCK_LABEL_74;
                    }
                    obj2 = ((ServerRequest)((Iterator) (obj)).next()).toJSON();
                } while (obj2 == null);
                jsonarray.put(obj2);
                if (true) goto _L2; else goto _L1
_L1:
                Object obj1;
                obj1;
                list;
                JVM INSTR monitorexit ;
                throw obj1;
                obj2 = editor;
                if (jsonarray instanceof JSONArray) goto _L4; else goto _L3
_L3:
                obj1 = jsonarray.toString();
_L7:
                ((android.content.SharedPreferences.Editor) (obj2)).putString("BNCServerRequestQueue", ((String) (obj1))).commit();
                obj2 = editor;
                if (jsonarray instanceof JSONArray) goto _L6; else goto _L5
_L5:
                obj1 = jsonarray.toString();
_L8:
                ((android.content.SharedPreferences.Editor) (obj2)).putString("BNCServerRequestQueue", ((String) (obj1))).commit();
_L11:
                list;
                JVM INSTR monitorexit ;
                return;
_L4:
                obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                  goto _L7
_L6:
                obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                  goto _L8
                obj1;
                if (jsonarray instanceof JSONArray) goto _L10; else goto _L9
_L9:
                obj1 = jsonarray.toString();
_L12:
                PrefHelper.Debug("Persisting Queue: ", ((String) (obj1)));
                obj2 = editor;
                if (jsonarray instanceof JSONArray)
                {
                    break MISSING_BLOCK_LABEL_247;
                }
                obj1 = jsonarray.toString();
_L13:
                ((android.content.SharedPreferences.Editor) (obj2)).putString("BNCServerRequestQueue", ((String) (obj1))).commit();
                  goto _L11
                obj1;
                  goto _L11
_L10:
                obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                  goto _L12
                obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                  goto _L13
                Exception exception;
                exception;
                android.content.SharedPreferences.Editor editor1 = editor;
                if (jsonarray instanceof JSONArray) goto _L15; else goto _L14
_L14:
                obj1 = jsonarray.toString();
_L16:
                editor1.putString("BNCServerRequestQueue", ((String) (obj1))).commit();
_L17:
                throw exception;
_L15:
                obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                  goto _L16
                obj1;
                  goto _L17
                obj1;
                  goto _L11
            }

            
            {
                this$0 = ServerRequestQueue.this;
                super();
            }
        })).start();
    }

    private List retrieve(Context context)
    {
        List list;
        Object obj;
        list = Collections.synchronizedList(new LinkedList());
        obj = sharedPref.getString("BNCServerRequestQueue", null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = JSONArrayInstrumentation.init(((String) (obj)));
        int i = 0;
_L1:
        ServerRequest serverrequest;
        if (i >= Math.min(((JSONArray) (obj)).length(), 25))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        serverrequest = ServerRequest.fromJSON(((JSONArray) (obj)).getJSONObject(i), context);
        if (serverrequest == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        list.add(serverrequest);
        i++;
          goto _L1
        context;
        return list;
    }

    public void clear()
    {
        try
        {
            queue.clear();
            persist();
            return;
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            return;
        }
    }

    public boolean containsClose()
    {
        List list = queue;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = queue.iterator();
_L2:
        ServerRequest serverrequest;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_60;
            }
            serverrequest = (ServerRequest)iterator.next();
        } while (serverrequest == null);
        if (!serverrequest.getRequestPath().equals(Defines.RequestPath.RegisterClose.getPath())) goto _L2; else goto _L1
_L1:
        list;
        JVM INSTR monitorexit ;
        return true;
        list;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean containsInstallOrOpen()
    {
        List list = queue;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = queue.iterator();
_L2:
        ServerRequest serverrequest;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_58;
            }
            serverrequest = (ServerRequest)iterator.next();
        } while (serverrequest == null);
        if (!(serverrequest instanceof ServerRequestRegisterInstall) && !(serverrequest instanceof ServerRequestRegisterOpen)) goto _L2; else goto _L1
_L1:
        list;
        JVM INSTR monitorexit ;
        return true;
        list;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ServerRequest dequeue()
    {
        Object obj = null;
        ServerRequest serverrequest = null;
        ServerRequest serverrequest1;
        try
        {
            serverrequest1 = (ServerRequest)queue.remove(0);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return ((ServerRequest) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return serverrequest;
        }
        serverrequest = serverrequest1;
        obj = serverrequest1;
        persist();
        return serverrequest1;
    }

    public void enqueue(ServerRequest serverrequest)
    {
        if (serverrequest != null)
        {
            queue.add(serverrequest);
            if (getSize() >= 25)
            {
                queue.remove(1);
            }
            persist();
        }
    }

    public int getSize()
    {
        return queue.size();
    }

    public void insert(ServerRequest serverrequest, int i)
    {
        int j = i;
        try
        {
            if (queue.size() < i)
            {
                j = queue.size();
            }
            queue.add(j, serverrequest);
            persist();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ServerRequest serverrequest)
        {
            return;
        }
    }

    public void moveInstallOrOpenToFront(ServerRequest serverrequest, int i, Branch.BranchReferralInitListener branchreferralinitlistener)
    {
        branchreferralinitlistener = queue;
        branchreferralinitlistener;
        JVM INSTR monitorenter ;
        Iterator iterator = queue.iterator();
_L2:
        ServerRequest serverrequest1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_68;
            }
            serverrequest1 = (ServerRequest)iterator.next();
        } while (serverrequest1 == null);
        if (!(serverrequest1 instanceof ServerRequestRegisterInstall) && !(serverrequest1 instanceof ServerRequestRegisterOpen)) goto _L2; else goto _L1
_L1:
        iterator.remove();
        branchreferralinitlistener;
        JVM INSTR monitorexit ;
        if (i == 0)
        {
            insert(serverrequest, 0);
            return;
        } else
        {
            insert(serverrequest, 1);
            return;
        }
        serverrequest;
        branchreferralinitlistener;
        JVM INSTR monitorexit ;
        throw serverrequest;
    }

    public ServerRequest peek()
    {
        ServerRequest serverrequest;
        try
        {
            serverrequest = (ServerRequest)queue.get(0);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return null;
        }
        catch (NoSuchElementException nosuchelementexception)
        {
            return null;
        }
        return serverrequest;
    }

    public ServerRequest peekAt(int i)
    {
        ServerRequest serverrequest;
        try
        {
            serverrequest = (ServerRequest)queue.get(i);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return null;
        }
        catch (NoSuchElementException nosuchelementexception)
        {
            return null;
        }
        return serverrequest;
    }

    public boolean remove(ServerRequest serverrequest)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            flag1 = queue.remove(serverrequest);
        }
        // Misplaced declaration of an exception variable
        catch (ServerRequest serverrequest)
        {
            return flag;
        }
        flag = flag1;
        persist();
        return flag1;
    }

    public ServerRequest removeAt(int i)
    {
        ServerRequest serverrequest = null;
        ServerRequest serverrequest1;
        try
        {
            serverrequest1 = (ServerRequest)queue.remove(i);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return serverrequest;
        }
        serverrequest = serverrequest1;
        persist();
        return serverrequest1;
    }

    public void setInstallOrOpenCallback(Branch.BranchReferralInitListener branchreferralinitlistener)
    {
        List list = queue;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = queue.iterator();
_L3:
        ServerRequest serverrequest;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_87;
            }
            serverrequest = (ServerRequest)iterator.next();
        } while (serverrequest == null);
        if (!(serverrequest instanceof ServerRequestRegisterInstall)) goto _L2; else goto _L1
_L1:
        ((ServerRequestRegisterInstall)serverrequest).setInitFinishedCallback(branchreferralinitlistener);
          goto _L3
        branchreferralinitlistener;
        list;
        JVM INSTR monitorexit ;
        throw branchreferralinitlistener;
_L2:
        if (!(serverrequest instanceof ServerRequestRegisterOpen)) goto _L3; else goto _L4
_L4:
        ((ServerRequestRegisterOpen)serverrequest).setInitFinishedCallback(branchreferralinitlistener);
          goto _L3
        list;
        JVM INSTR monitorexit ;
    }


}
