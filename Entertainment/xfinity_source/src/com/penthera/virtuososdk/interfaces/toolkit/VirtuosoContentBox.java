// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.penthera.virtuososdk.client.IDownloadedObserver;
import com.penthera.virtuososdk.client.IEngineObserver;
import com.penthera.virtuososdk.client.IQueueObserver;
import com.penthera.virtuososdk.client.IServiceConnectedCallback;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoHLSFile;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import com.penthera.virtuososdk.client.ServiceException;
import com.penthera.virtuososdk.database.impl.provider.RegistryInstance;
import com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback;
import com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback;
import com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback;
import com.penthera.virtuososdk.interfaces.IVirtuosoService;
import com.penthera.virtuososdk.internal.interfaces.IEngVCollection;
import com.penthera.virtuososdk.internal.interfaces.IEngVFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVHLSFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVIdentifier;
import com.penthera.virtuososdk.internal.interfaces.InternalInterfaceFactory;
import com.penthera.virtuososdk.manager.FileManager;
import com.penthera.virtuososdk.service.VirtuosoService;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoHLSFile, VirtuosoFile, VirtuosoFolderCollection, VirtuosoContainerCollection

public class VirtuosoContentBox
{
    public final class TestInterface
    {
    }


    static String FULL_PROJECTION[] = {
        "_id", "uuid", "parentUuid", "assetId", "assetUrl", "creationTime", "currentSize", "description", "errorType", "expectedSize", 
        "fileHash", "filePath", "mimeType", "modifyTime", "completeTime", "errorCount", "hashState", "pending", "addedToQueue", "contentType", 
        "clientAuthority", "hlsFragmentCompletedCount", "hlsFragmentCount", "contentState"
    };
    private static final String LOG_TAG = com/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox.getName();
    static Context iApplicationContext = null;
    private boolean iBound;
    String iCurrentAuthority;
    private Object iDownloadLock;
    private IVirtuosoDownloadedCallback iDownloadedCallbackHandler;
    private List iDownloadedObservers;
    private IVirtuosoEngineCallback iEngineCallbackHandler;
    private Object iEngineLock;
    private List iEngineObservers;
    FileManager iFileManager;
    private IVirtuosoDownloadQueueCallback iQueueCallbackHandler;
    private Object iQueueLock;
    private List iQueueObservers;
    private short iRegisteredCallbacks;
    RegistryInstance iRegistry;
    private IVirtuosoService iService;
    private ComponentName iServiceComponent;
    private IServiceConnectedCallback iServiceConnectedCallback;
    private ServiceConnection iServiceConnection;
    private TestInterface iTestWrapper;

    public VirtuosoContentBox(Context context, IServiceConnectedCallback iserviceconnectedcallback, ComponentName componentname)
    {
        iServiceConnectedCallback = null;
        iService = null;
        iBound = false;
        iServiceConnection = null;
        iEngineLock = new Object();
        iDownloadLock = new Object();
        iQueueLock = new Object();
        iRegisteredCallbacks = 0;
        iQueueObservers = new ArrayList();
        iEngineObservers = new ArrayList();
        iDownloadedObservers = new ArrayList();
        iQueueCallbackHandler = new com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback.Stub() {

            final VirtuosoContentBox this$0;

            public void collectionsComplete(IVirtuosoIdentifier aivirtuosoidentifier[])
                throws RemoteException
            {
            }

            public void collectionsProgressUpdated(IVirtuosoIdentifier aivirtuosoidentifier[])
                throws RemoteException
            {
            }

            public void downloadEngineDidFinishDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier)
                throws RemoteException
            {
                Iterator iterator = iQueueObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IQueueObserver)iterator.next()).downloadEngineDidFinishDownloadingFile(ivirtuosoidentifier);
                } while (true);
            }

            public void downloadEngineDidFinishDownloadingFileMin(String s, int i, double d, double d1, int j)
                throws RemoteException
            {
                s = getFileWithMinData(s, i, d, d1, j);
                if (s == null)
                {
                    return;
                } else
                {
                    downloadEngineDidFinishDownloadingFile(s);
                    return;
                }
            }

            public void downloadEngineDidStartDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier)
                throws RemoteException
            {
                Iterator iterator = iQueueObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IQueueObserver)iterator.next()).downloadEngineDidStartDownloadingFile(ivirtuosoidentifier);
                } while (true);
            }

            public void downloadEngineDidStartDownloadingFileMin(String s, int i, double d, double d1, int j)
                throws RemoteException
            {
                s = getFileWithMinData(s, i, d, d1, j);
                if (s == null)
                {
                    return;
                } else
                {
                    downloadEngineDidStartDownloadingFile(s);
                    return;
                }
            }

            public void downloadEngineFileWithError(IVirtuosoIdentifier ivirtuosoidentifier)
                throws RemoteException
            {
                Iterator iterator = iQueueObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IQueueObserver)iterator.next()).downloadEngineFileWithError(ivirtuosoidentifier);
                } while (true);
            }

            public void downloadEngineFileWithErrorMin(String s, int i, double d, double d1, int j)
                throws RemoteException
            {
                s = getFileWithMinData(s, i, d, d1, j);
                if (s == null)
                {
                    return;
                } else
                {
                    downloadEngineFileWithError(s);
                    return;
                }
            }

            public void downloadEngineProgressUpdatedForFile(IVirtuosoIdentifier ivirtuosoidentifier)
                throws RemoteException
            {
                Iterator iterator = iQueueObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IQueueObserver)iterator.next()).downloadEngineProgressUpdatedForFile(ivirtuosoidentifier);
                } while (true);
            }

            public void downloadEngineProgressUpdatedForFileMin(String s, int i, double d, double d1, int j)
                throws RemoteException
            {
                s = getFileWithMinData(s, i, d, d1, j);
                if (s == null)
                {
                    return;
                } else
                {
                    downloadEngineProgressUpdatedForFile(s);
                    return;
                }
            }

            public void engineContentInQueuedList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
                throws RemoteException
            {
            }

            public void engineDownloadQueueChanged()
                throws RemoteException
            {
                Iterator iterator = iQueueObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IQueueObserver)iterator.next()).engineDownloadQueueChanged();
                } while (true);
            }

            public void fragmentComplete(IVirtuosoIdentifier ivirtuosoidentifier)
                throws RemoteException
            {
                Iterator iterator = iQueueObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IQueueObserver)iterator.next()).fragmentComplete(ivirtuosoidentifier);
                } while (true);
            }

            public void fragmentCompleteMin(String s, int i, double d, double d1, int j)
                throws RemoteException
            {
                s = getFileWithMinData(s, i, d, d1, j);
                if (s == null)
                {
                    return;
                } else
                {
                    fragmentComplete(s);
                    return;
                }
            }

            
            {
                this$0 = VirtuosoContentBox.this;
                super();
            }
        };
        iEngineCallbackHandler = new com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback.Stub() {

            final VirtuosoContentBox this$0;

            public void collectionsChanged(IVirtuosoIdentifier aivirtuosoidentifier[])
                throws RemoteException
            {
            }

            public void collectionsDeleted(String as[])
                throws RemoteException
            {
            }

            public void downloadEngineStatusDidChange(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
                throws RemoteException
            {
                Iterator iterator = iEngineObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IEngineObserver)iterator.next()).downloadEngineStatusDidChange(ivirtuosodownloadenginestatus);
                } while (true);
            }

            public void engineContentInList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
                throws RemoteException
            {
            }

            public void engineListChanged()
                throws RemoteException
            {
            }

            public void itemUpdated(IVirtuosoIdentifier ivirtuosoidentifier)
                throws RemoteException
            {
            }

            public void settingChanged(int i)
                throws RemoteException
            {
                Iterator iterator = iEngineObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IEngineObserver)iterator.next()).settingChanged(i);
                } while (true);
            }

            
            {
                this$0 = VirtuosoContentBox.this;
                super();
            }
        };
        iDownloadedCallbackHandler = new com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback.Stub() {

            final VirtuosoContentBox this$0;

            public void engineContentInDownloadedList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
                throws RemoteException
            {
            }

            public void engineDownloadedListChanged()
                throws RemoteException
            {
                Iterator iterator = iDownloadedObservers.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    ((IDownloadedObserver)iterator.next()).engineDownloadedListChanged();
                } while (true);
            }

            
            {
                this$0 = VirtuosoContentBox.this;
                super();
            }
        };
        iTestWrapper = null;
        if (context == null)
        {
            throw new IllegalArgumentException("Context is invalid");
        }
        if (iApplicationContext == null)
        {
            iApplicationContext = context.getApplicationContext();
        }
        try
        {
            iCurrentAuthority = iApplicationContext.getPackageManager().getApplicationInfo(iApplicationContext.getPackageName(), 128).metaData.getString("com.penthera.virtuososdk.client.pckg");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException("cannot retrieve authority", context);
        }
        if (TextUtils.isEmpty(iCurrentAuthority))
        {
            throw new RuntimeException("cannot retrieve authority. was the metadata for com.penthera.virtuososdk.client.pckg specified in the manifest under application?");
        }
        iServiceComponent = componentname;
        if (iServiceComponent != null)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Component Logging");
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Component CN ")).append(iServiceComponent.getClassName()).toString());
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Component PN ")).append(iServiceComponent.getPackageName()).toString());
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Component SCN ")).append(iServiceComponent.getShortClassName()).toString());
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Component FSS ")).append(iServiceComponent.flattenToShortString()).toString());
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Component FS ")).append(iServiceComponent.flattenToString()).toString());
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Component SS ")).append(iServiceComponent.toShortString()).toString());
        }
        com.penthera.virtuososdk.utility.CommonUtil.Directory.createRoot(iApplicationContext);
        com.penthera.virtuososdk.utility.CommonUtil.Directory.createMediaRoot(iApplicationContext);
        iServiceConnectedCallback = iserviceconnectedcallback;
        initService();
        iRegistry = new RegistryInstance(iApplicationContext.getContentResolver(), iCurrentAuthority);
        if (TextUtils.isEmpty(iRegistry.get("root_destination_path")))
        {
            iRegistry.set("root_destination_path", com.penthera.virtuososdk.utility.CommonUtil.Directory.getMediaRoot(iApplicationContext));
        }
        iFileManager = new FileManager();
    }

    public static double appDiskUsage(ContentResolver contentresolver, String s)
    {
        double d;
        double d2;
        Object obj;
        Object obj1;
        d2 = 0.0D;
        obj1 = null;
        obj = null;
        d = d2;
        Cursor cursor = contentresolver.query(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(s), new String[] {
            "currentSize"
        }, "contentType=1", null, null);
        double d1 = d2;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        d1 = d2;
        obj = cursor;
        d = d2;
        obj1 = cursor;
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        obj = cursor;
        d = d2;
        obj1 = cursor;
        d1 = d2 + (double)cursor.getLong(0);
        d2 = d1;
        obj = cursor;
        d = d1;
        obj1 = cursor;
        if (cursor.moveToNext()) goto _L3; else goto _L2
_L2:
        obj1 = cursor;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        obj = cursor;
        d = d1;
        obj1 = cursor;
        cursor.close();
        obj1 = null;
        obj = obj1;
        d = d1;
        contentresolver = contentresolver.query(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(s), new String[] {
            "currentSize"
        }, null, null, null);
        s = contentresolver;
        d2 = d1;
        if (contentresolver == null)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        s = contentresolver;
        d2 = d1;
        obj = contentresolver;
        d = d1;
        obj1 = contentresolver;
        if (!contentresolver.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_273;
        }
_L5:
        obj = contentresolver;
        d = d1;
        obj1 = contentresolver;
        d2 = d1 + (double)contentresolver.getLong(0);
        d1 = d2;
        obj = contentresolver;
        d = d2;
        obj1 = contentresolver;
        if (contentresolver.moveToNext()) goto _L5; else goto _L4
_L4:
        obj = contentresolver;
        d = d2;
        obj1 = contentresolver;
        contentresolver.close();
        s = null;
        d1 = d2;
        if (s != null)
        {
            s.close();
            d1 = d2;
        }
_L7:
        return d1;
        contentresolver;
        obj1 = obj;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("Caught exception while fetching total disk usage size: ")).append(contentresolver).toString());
        d1 = d;
        if (obj == null) goto _L7; else goto _L6
_L6:
        ((Cursor) (obj)).close();
        return d;
        contentresolver;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw contentresolver;
    }

    private void bind()
    {
        if (!iBound || iService == null)
        {
            Intent intent = new Intent();
            intent.setComponent(iServiceComponent);
            (new Bundle()).putString("com.penthera.virtuososdk.client.pckg", iCurrentAuthority);
            iBound = iApplicationContext.bindService(intent, iServiceConnection, 1);
        }
    }

    private void create(IEngVIdentifier iengvidentifier)
    {
        ContentResolver contentresolver;
        iengvidentifier.setClientProviderAuth(iCurrentAuthority);
        contentresolver = iApplicationContext.getContentResolver();
        if (iengvidentifier.type() != 4) goto _L2; else goto _L1
_L1:
        ((IEngVHLSFile)iengvidentifier).setLocalBaseDir(generateFilePath((IVirtuosoAsset)iengvidentifier, contentresolver, iCurrentAuthority, iApplicationContext));
_L4:
        iengvidentifier.setId(save(iengvidentifier, 3, contentresolver, iCurrentAuthority));
        return;
_L2:
        if (iengvidentifier.type() == 1)
        {
            ((IEngVFile)iengvidentifier).setFilePath(generateFilePath((IVirtuosoAsset)iengvidentifier, contentresolver, iCurrentAuthority, iApplicationContext));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String generateFilePath(IVirtuosoAsset ivirtuosoasset, ContentResolver contentresolver, String s, Context context)
    {
label0:
        {
label1:
            {
                context = null;
                if (ivirtuosoasset == null)
                {
                    break label0;
                }
                context = null;
                if (ivirtuosoasset.type() != 4)
                {
                    int i = ivirtuosoasset.assetURL().lastIndexOf(".");
                    String s1;
                    RegistryInstance registryinstance;
                    if (i >= 0)
                    {
                        context = ivirtuosoasset.assetURL().substring(i);
                    } else
                    {
                        context = null;
                    }
                }
                registryinstance = new RegistryInstance(contentresolver, s);
                s1 = registryinstance.get("root_destination_path");
                s = registryinstance.get("destination_path_override");
                if (s != null)
                {
                    contentresolver = s;
                    if (s.trim().length() != 0)
                    {
                        break label1;
                    }
                }
                contentresolver = registryinstance.get("destination_path");
            }
            s = contentresolver;
            if (contentresolver == null)
            {
                s = "/";
            }
            contentresolver = s;
            if (!s.startsWith("/"))
            {
                contentresolver = s;
                if (!s1.endsWith("/"))
                {
                    contentresolver = (new StringBuilder("/")).append(s).toString();
                }
            }
            if (contentresolver.startsWith("/") && s1.endsWith("/"))
            {
                contentresolver.replaceFirst("/", "");
            }
            s = contentresolver;
            if (!contentresolver.endsWith("/"))
            {
                s = (new StringBuilder(String.valueOf(contentresolver))).append("/").toString();
            }
            contentresolver = new StringBuffer();
            contentresolver.append(s1);
            contentresolver.append(s);
            if (ivirtuosoasset.type() == 4)
            {
                contentresolver.append((new StringBuilder(String.valueOf(ivirtuosoasset.uuid()))).append("/").toString());
            }
            s = new File(contentresolver.toString());
            if (!s.exists())
            {
                s.mkdirs();
            }
            if (ivirtuosoasset.type() != 4)
            {
                contentresolver.append(ivirtuosoasset.uuid());
                if (context != null && context.length() < 6)
                {
                    contentresolver.append(context);
                }
            }
            context = contentresolver.toString();
        }
        return context;
    }

    private IVirtuosoIdentifier getFileWithMinData(String s, int i, double d, double d1, int j)
    {
        IVirtuosoIdentifier ivirtuosoidentifier;
label0:
        {
label1:
            {
                ivirtuosoidentifier = getItem(iApplicationContext, s);
                s = ivirtuosoidentifier;
                if (ivirtuosoidentifier != null)
                {
                    switch (ivirtuosoidentifier.type())
                    {
                    case 2: // '\002'
                    case 3: // '\003'
                    default:
                        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("UNSUPPORTED IDENTIFIER TYPE ")).append(ivirtuosoidentifier.type()).toString());
                        s = null;
                        break;

                    case 1: // '\001'
                        break label0;

                    case 4: // '\004'
                        break label1;
                    }
                }
                return s;
            }
            s = (VirtuosoHLSFile)ivirtuosoidentifier;
            s.setCompletedCount(j);
            s.setExpectedSize(d);
            s.setCurrentSize(d1);
            s.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.values()[i]);
            return ivirtuosoidentifier;
        }
        s = (VirtuosoFile)ivirtuosoidentifier;
        s.setCurrentSize(d1);
        s.setExpectedSize(d);
        s.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.values()[i]);
        return ivirtuosoidentifier;
    }

    static List getFiles(int i, String s, String s1)
    {
        return getFiles(iApplicationContext, i, s, s1);
    }

    static List getFiles(Context context, int i, String s, String s1)
    {
        Object obj;
        Context context1;
        Object obj1;
        ArrayList arraylist;
        String as1[];
        Object obj2;
        ContentResolver contentresolver;
        String s2;
        int j;
        arraylist = new ArrayList();
        context1 = null;
        obj2 = null;
        contentresolver = context.getContentResolver();
        context = "";
        String as[];
        Cursor cursor;
        if ((i & 0xe) != 14)
        {
            if ((i & 2) == 2)
            {
                context = (new StringBuilder("pending=1 AND errorType != ")).append(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Not_Pending.ordinal()).append(" AND ").toString();
            } else
            if ((i & 4) == 4)
            {
                context = "pending=0 AND ";
            } else
            {
                context = (new StringBuilder("pending=1 AND errorType = ")).append(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Not_Pending.ordinal()).append(" AND ").toString();
            }
        }
        obj = "creationTime LIMIT ";
        obj1 = obj;
        if ((i & 4) == 4)
        {
            obj1 = obj;
            if ((i & 0xe) != 14)
            {
                obj1 = "completeTime LIMIT ";
            }
        }
        if ((i & 0x10) != 16)
        {
            context = (new StringBuilder(String.valueOf(context))).append("contentState = 0 AND ").toString();
        } else
        {
            context = (new StringBuilder(String.valueOf(context))).append("contentState = 1 AND ").toString();
        }
        as = (String[])null;
        if (TextUtils.isEmpty(s))
        {
            as = (new StringBuilder(String.valueOf("clientAuthority =? AND parentUuid"))).append(" IS NULL").toString();
            as1 = new String[1];
            as1[0] = s1;
        } else
        {
            as = (new StringBuilder(String.valueOf("clientAuthority =? AND parentUuid"))).append(" =?").toString();
            as1 = new String[2];
            as1[0] = s1;
            as1[1] = s;
        }
        s2 = (new StringBuilder(String.valueOf(context))).append(as).toString();
        j = 0;
        context = (new StringBuilder()).append(0).append(", ").append(250).toString();
        as = ((String []) (obj2));
        cursor = contentresolver.query(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(s1), null, s2, as1, (new StringBuilder(String.valueOf(obj1))).append(context).toString());
        obj2 = context;
        context = cursor;
_L16:
        if (context == null) goto _L2; else goto _L1
_L1:
        as = context;
        context1 = context;
        if (context.getCount() > 0) goto _L3; else goto _L2
_L2:
        as = arraylist;
        if ((i & 1) != 1) goto _L5; else goto _L4
_L4:
        obj1 = null;
        if ((i & 2) != 2) goto _L7; else goto _L6
_L6:
        as = context;
        context1 = context;
        as1 = new RegistryInstance(contentresolver, s1);
        as = context;
        context1 = context;
        obj1 = as1.pendingQueue(s);
        as = context;
        context1 = context;
        ((List) (obj1)).addAll(as1.errorQueue(s));
_L11:
        as = context;
        context1 = context;
        s = orderedList(arraylist, ((List) (obj1)), contentresolver, s1);
        as = s;
_L5:
        s = as;
        if (context != null)
        {
            s = as;
            if (!context.isClosed())
            {
                context.close();
                s = as;
            }
        }
_L13:
        return s;
_L3:
        as = context;
        context1 = context;
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("retrieving paged results: [")).append(context.getCount()).append(", ").append(((String) (obj2))).append("]").toString());
        as = context;
        context1 = context;
        if (!context.moveToFirst()) goto _L9; else goto _L8
_L8:
        as = context;
        context1 = context;
        arraylist.add(hydrate(context));
        as = context;
        context1 = context;
        if (context.moveToNext()) goto _L8; else goto _L9
_L9:
        j += 250;
        as = context;
        context1 = context;
        obj2 = (new StringBuilder()).append(j).append(", ").append(250).toString();
        as = context;
        context1 = context;
        context.close();
        context1 = null;
        as = null;
        try
        {
            context = contentresolver.query(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(s1), null, s2, as1, (new StringBuilder(String.valueOf(obj1))).append(((String) (obj2))).toString());
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            s = arraylist;
        }
        finally
        {
            if (context1 != null && !context1.isClosed())
            {
                context1.close();
            }
            throw context;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if ((i & 8) != 8) goto _L11; else goto _L10
_L10:
        as = context;
        context1 = context;
        obj1 = (new RegistryInstance(contentresolver, s1)).unqueuedQueue(s);
          goto _L11
        if (as == null) goto _L13; else goto _L12
_L12:
        s = arraylist;
        if (as.isClosed()) goto _L13; else goto _L14
_L14:
        as.close();
        return arraylist;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public static IVirtuosoIdentifier getItem(ContentResolver contentresolver, String s, String s1)
    {
        String s2;
        String s3;
        ContentResolver contentresolver1;
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        s3 = null;
        s2 = null;
        contentresolver1 = obj;
        s1 = contentresolver.query(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(s1), FULL_PROJECTION, "uuid =?", new String[] {
            s
        }, null);
        contentresolver = obj1;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        contentresolver = obj1;
        s2 = s1;
        contentresolver1 = obj;
        s3 = s1;
        if (!s1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        s2 = s1;
        contentresolver1 = obj;
        s3 = s1;
        contentresolver = hydrate(s1);
        s2 = s1;
        contentresolver1 = contentresolver;
        s3 = s1;
        s1.close();
        s1 = null;
        obj = null;
        if (contentresolver == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        s2 = obj;
        contentresolver1 = contentresolver;
        s3 = s1;
        if (contentresolver.type() != 4)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        s2 = obj;
        contentresolver1 = contentresolver;
        s3 = s1;
        s1 = (VirtuosoHLSFile)contentresolver;
        if (false)
        {
            throw new NullPointerException();
        }
_L2:
        return contentresolver;
        contentresolver;
        s3 = s2;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("Caught exception while fetching uuid : ")).append(s).append(", ").append(contentresolver).toString());
        contentresolver = contentresolver1;
        if (s2 == null) goto _L2; else goto _L1
_L1:
        contentresolver = contentresolver1;
        if (s2.isClosed()) goto _L2; else goto _L3
_L3:
        s2.close();
        return contentresolver1;
        contentresolver;
        if (s3 != null && !s3.isClosed())
        {
            s3.close();
        }
        throw contentresolver;
    }

    private static IVirtuosoIdentifier hydrate(Cursor cursor)
    {
        int i = cursor.getInt(cursor.getColumnIndex("contentType"));
        if (i == 2 || i == 3)
        {
            if (i == 2)
            {
                return new VirtuosoFolderCollection(cursor);
            } else
            {
                return new VirtuosoContainerCollection(cursor);
            }
        }
        if (i == 1)
        {
            return new VirtuosoFile(cursor);
        }
        if (i == 4)
        {
            return new VirtuosoHLSFile(cursor);
        } else
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("Unknown identifier type ")).append(i).toString());
            return null;
        }
    }

    private void initService()
    {
        iServiceConnection = new ServiceConnection() {

            final VirtuosoContentBox this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoContentBox.LOG_TAG, (new StringBuilder("Service Connected: ")).append(componentname.getClassName()).toString());
                if (com/penthera/virtuososdk/service/VirtuosoService.getName().equals(componentname.getClassName()))
                {
                    iService = com.penthera.virtuososdk.interfaces.IVirtuosoService.Stub.asInterface(ibinder);
                    registerCallbackHandlers();
                    if (iServiceConnectedCallback != null)
                    {
                        iServiceConnectedCallback.connected();
                    }
                }
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoContentBox.LOG_TAG, (new StringBuilder("Service Disconnected: ")).append(componentname.getClassName()).toString());
                iService = null;
                iBound = false;
                iRegisteredCallbacks = 0;
            }

            
            {
                this$0 = VirtuosoContentBox.this;
                super();
            }
        };
    }

    private boolean markForDelete(IVirtuosoIdentifier ivirtuosoidentifier)
    {
        IVirtuosoAsset ivirtuosoasset;
        ContentResolver contentresolver;
        ContentValues contentvalues;
        int i;
        boolean flag = false;
        i = 0;
        if (ivirtuosoidentifier == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Marking ")).append(ivirtuosoidentifier.uuid()).append(" for deletion").toString());
        ivirtuosoasset = (IVirtuosoAsset)ivirtuosoidentifier;
        contentresolver = iApplicationContext.getContentResolver();
        contentvalues = new ContentValues();
        contentvalues.put("modifyTime", Long.valueOf((new Date()).getTime()));
        contentvalues.put("contentState", Integer.valueOf(1));
        i = ((flag) ? 1 : 0);
        int j = contentresolver.update(ContentUris.withAppendedId(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(iCurrentAuthority), ivirtuosoasset.id()), contentvalues, null, null);
        i = j;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Marking ")).append(ivirtuosoidentifier.uuid()).append(" for deletion updated ").append(j).toString());
        i = j;
_L1:
        Exception exception;
        return i > 0;
        exception;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Marking ")).append(ivirtuosoidentifier.uuid()).append(" for deletion FAILED").toString());
        exception.printStackTrace();
          goto _L1
    }

    private static List orderedList(List list, List list1, ContentResolver contentresolver, String s)
    {
        int i;
        if (list1 != null && list.size() > 0)
        {
            contentresolver = new RegistryInstance(contentresolver, s);
            i = 0;
            break MISSING_BLOCK_LABEL_26;
        }
_L2:
        return list;
_L4:
        if (i >= list1.size() || i >= list.size()) goto _L2; else goto _L1
_L1:
        s = (String)list1.get(i);
        IVirtuosoIdentifier ivirtuosoidentifier = (IVirtuosoIdentifier)list.get(i);
        if (!list1.contains(ivirtuosoidentifier.uuid()))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e("TestRunner", (new StringBuilder(String.valueOf(ivirtuosoidentifier.uuid()))).append(" NOT A REGISTERED ITEM").toString());
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder(String.valueOf(ivirtuosoidentifier.uuid()))).append(" NOT A REGISTERED ITEM").toString());
        }
        if (!ivirtuosoidentifier.uuid().equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
_L5:
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        int j;
        boolean flag;
        flag = false;
        j = i;
_L6:
        if (j >= list.size())
        {
            j = ((flag) ? 1 : 0);
        } else
        {
label0:
            {
                IVirtuosoIdentifier ivirtuosoidentifier1 = (IVirtuosoIdentifier)list.get(j);
                if (!ivirtuosoidentifier1.uuid().equals(s))
                {
                    break label0;
                }
                j = 1;
                list.remove(ivirtuosoidentifier1);
                list.add(i, ivirtuosoidentifier1);
            }
        }
        if (j == 0)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder(String.valueOf(s))).append(" IN QUEUE NOT FOUND").toString());
            List list2 = contentresolver.pendingQueue(null);
            List list3 = contentresolver.errorQueue(null);
            if (list2.remove(s))
            {
                contentresolver.savePendingQueue(null, list2);
            }
            if (list3.remove(s))
            {
                contentresolver.saveErrorQueue(null, list3);
            }
        }
          goto _L5
        j++;
          goto _L6
    }

    private void overrideDoubleSetting(String s, double d)
        throws ServiceException
    {
        Bundle bundle = new Bundle();
        bundle.putDouble(s, d);
        overrideSetting(bundle);
    }

    private void overrideSetting(Bundle bundle)
        throws ServiceException
    {
        signalSettingChanged(performSettingsOverride(bundle));
    }

    private void registerCallback(int i)
    {
        if (iService == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if ((i & 4) == 4)
        {
            try
            {
                if ((iRegisteredCallbacks & 4) != 4)
                {
                    iService.registerQueueCallbackHandler(iQueueCallbackHandler, iCurrentAuthority);
                    iRegisteredCallbacks = (short)(iRegisteredCallbacks | 4);
                }
            }
            catch (RemoteException remoteexception)
            {
                remoteexception.printStackTrace();
                return;
            }
        }
        if ((i & 1) != 1)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if ((iRegisteredCallbacks & 1) != 1)
        {
            iService.registerEngineCallbackHandler(iEngineCallbackHandler, iCurrentAuthority);
            iRegisteredCallbacks = (short)(iRegisteredCallbacks | 1);
        }
        if ((i & 2) != 2)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if ((iRegisteredCallbacks & 2) != 2)
        {
            iService.registerDownloadCallbackHandler(iDownloadedCallbackHandler, iCurrentAuthority);
            iRegisteredCallbacks = (short)(iRegisteredCallbacks | 2);
        }
    }

    private void registerCallbackHandlers()
    {
        synchronized (iQueueLock)
        {
            if (iQueueObservers.size() > 0 && (iRegisteredCallbacks & 4) != 4)
            {
                registerCallback(4);
            }
        }
        synchronized (iEngineLock)
        {
            if (iEngineObservers.size() > 0 && (iRegisteredCallbacks & 1) != 1)
            {
                registerCallback(1);
            }
        }
        synchronized (iDownloadLock)
        {
            if (iDownloadedObservers.size() > 0 && (iRegisteredCallbacks & 2) != 2)
            {
                registerCallback(2);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    private void remove(IVirtuosoIdentifier ivirtuosoidentifier)
    {
        remove(ivirtuosoidentifier, iApplicationContext, iCurrentAuthority);
    }

    public static void remove(final IVirtuosoIdentifier vi, final Context context, final String authority)
    {
        (new Thread(new Runnable() {

            private final String val$authority;
            private final Context val$context;
            private final IVirtuosoIdentifier val$vi;

            public void run()
            {
                ContentResolver contentresolver = context.getContentResolver();
                try
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoContentBox.LOG_TAG, (new StringBuilder("attempting to delete ")).append(vi.uuid()).toString());
                    String as[] = new String[1];
                    as[0] = vi.uuid();
                    int i = contentresolver.delete(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(authority), "uuid =?", as);
                    com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoContentBox.LOG_TAG, (new StringBuilder("deleted ")).append(i).append("items from the db.").toString());
                    if (vi.type() == 4)
                    {
                        com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoContentBox.LOG_TAG, (new StringBuilder("attempting to delete fragments for")).append(vi.uuid()).toString());
                        int j = contentresolver.delete(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(authority), "parentUuid=?", as);
                        com.penthera.virtuososdk.utility.CommonUtil.Log.d(VirtuosoContentBox.LOG_TAG, (new StringBuilder("deleted ")).append(j).append("fragments from the db.").toString());
                    }
                    return;
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(VirtuosoContentBox.LOG_TAG, "remove(): delete issue ", illegalargumentexception);
                }
            }

            
            {
                context = context1;
                vi = ivirtuosoidentifier;
                authority = s;
                super();
            }
        })).start();
    }

    private void removeAllButItem(IVirtuosoIdentifier ivirtuosoidentifier, int i)
    {
        ContentResolver contentresolver = iApplicationContext.getContentResolver();
        String s1 = "";
        String s = s1;
        if (i != 14)
        {
            s = s1;
            if ((i & 2) == 2)
            {
                s = (new StringBuilder("pending=1 AND errorType != ")).append(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Not_Pending.ordinal()).append(" AND ").toString();
            }
        }
        s1 = s;
        if (ivirtuosoidentifier != null)
        {
            s1 = (new StringBuilder(String.valueOf(s))).append("uuid !=? AND ").toString();
        }
        String as[] = (String[])null;
        if (ivirtuosoidentifier == null)
        {
            ivirtuosoidentifier = new String[1];
            ivirtuosoidentifier[0] = iCurrentAuthority;
        } else
        {
            String as1[] = new String[2];
            as1[0] = ivirtuosoidentifier.uuid();
            as1[1] = iCurrentAuthority;
            ivirtuosoidentifier = as1;
        }
        as = (new StringBuilder(String.valueOf(s1))).append("clientAuthority =?").toString();
        try
        {
            contentresolver.delete(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(iCurrentAuthority), as, ivirtuosoidentifier);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IVirtuosoIdentifier ivirtuosoidentifier)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "problem with remove all but ", ivirtuosoidentifier);
        }
    }

    private void removeAllFragmentsButChildOf(IVirtuosoIdentifier ivirtuosoidentifier)
    {
        String s = null;
        String as[] = (String[])null;
        if (ivirtuosoidentifier != null)
        {
            s = "parentUuid =?";
            as = new String[1];
            as[0] = ivirtuosoidentifier.uuid();
        }
        try
        {
            iApplicationContext.getContentResolver().delete(com.penthera.virtuososdk.database.impl.provider.FileFragment.FragmentColumns.CONTENT_URI(iCurrentAuthority), s, as);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IVirtuosoIdentifier ivirtuosoidentifier)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "problem with removeFragmentsForParents ", ivirtuosoidentifier);
        }
    }

    private static int save(IVirtuosoIdentifier ivirtuosoidentifier, int i, ContentResolver contentresolver, String s)
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        ContentValues contentvalues;
        int k;
        k = -1;
        contentvalues = null;
        cursor2 = null;
        cursor1 = cursor2;
        cursor = contentvalues;
        Object obj = com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(s);
        cursor1 = cursor2;
        cursor = contentvalues;
        String s1 = ivirtuosoidentifier.uuid();
        cursor1 = cursor2;
        cursor = contentvalues;
        cursor2 = contentresolver.query(((Uri) (obj)), new String[] {
            "uuid", "_id"
        }, "uuid =?", new String[] {
            s1
        }, null);
        cursor1 = cursor2;
        cursor = cursor2;
        contentvalues = unhydrate(ivirtuosoidentifier, i);
        cursor1 = cursor2;
        cursor = cursor2;
        obj = new Date();
        cursor1 = cursor2;
        cursor = cursor2;
        contentvalues.put("modifyTime", Long.valueOf(((Date) (obj)).getTime()));
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor1 = cursor2;
        cursor = cursor2;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("updating db:  ")).append(ivirtuosoidentifier.uuid()).toString());
        cursor1 = cursor2;
        cursor = cursor2;
        contentresolver.update(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(s), contentvalues, "uuid =?", new String[] {
            ivirtuosoidentifier.uuid()
        });
        cursor1 = cursor2;
        cursor = cursor2;
        int j = cursor2.getInt(cursor2.getColumnIndex("_id"));
_L7:
        k = j;
        if (cursor2 != null)
        {
            cursor2.close();
            k = j;
        }
_L5:
        return k;
_L2:
        j = k;
        if ((i & 4) == 4)
        {
            continue; /* Loop/switch isn't completed */
        }
        cursor1 = cursor2;
        cursor = cursor2;
        contentvalues.put("creationTime", Long.valueOf(((Date) (obj)).getTime()));
        cursor1 = cursor2;
        cursor = cursor2;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("inserting into db:  ")).append(ivirtuosoidentifier.uuid()).toString());
        cursor1 = cursor2;
        cursor = cursor2;
        try
        {
            j = Integer.parseInt((String)contentresolver.insert(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(s), contentvalues).getPathSegments().get(1));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (IVirtuosoIdentifier ivirtuosoidentifier)
        {
            cursor = cursor1;
        }
        finally
        {
            if (cursor != null)
            {
                cursor.close();
            }
            throw ivirtuosoidentifier;
        }
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "save(): delete issue ", ivirtuosoidentifier);
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        return -1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void saveFileState(ContentResolver contentresolver, IEngVIdentifier iengvidentifier, int i)
    {
        save(iengvidentifier, i, contentresolver, iengvidentifier.clientProviderAuth());
    }

    private void signalDownloadedChange()
        throws ServiceException
    {
        (new Thread(new Runnable() {

            final VirtuosoContentBox this$0;

            public void run()
            {
                try
                {
                    iDownloadedCallbackHandler.engineDownloadedListChanged();
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(VirtuosoContentBox.LOG_TAG, "failed to signal downloaded list change", remoteexception);
                }
            }

            
            {
                this$0 = VirtuosoContentBox.this;
                super();
            }
        })).start();
    }

    private void signalQueueChange(boolean flag)
        throws ServiceException
    {
        try
        {
            iService.signalQueueChange(iCurrentAuthority, flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            remoteexception.printStackTrace();
            throw new ServiceException(remoteexception.getMessage(), remoteexception);
        }
        catch (NullPointerException nullpointerexception)
        {
            throw new ServiceException("Service is not connected", nullpointerexception);
        }
    }

    private void signalSettingChanged(int i)
        throws ServiceException
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "doInterruptOnSettingChange");
        try
        {
            iService.signalDownloadSettingChange(iCurrentAuthority, i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            remoteexception.printStackTrace();
            throw new ServiceException(remoteexception.getMessage(), remoteexception);
        }
        catch (NullPointerException nullpointerexception)
        {
            throw new ServiceException("Service is not connected", nullpointerexception);
        }
    }

    private double toBytes(double d)
    {
        if (d < 0.0D)
        {
            return -1D;
        } else
        {
            return d * 1024D * 1024D;
        }
    }

    private static ContentValues unhydrate(IVirtuosoIdentifier ivirtuosoidentifier, int i)
    {
        switch (ivirtuosoidentifier.type())
        {
        default:
            return null;

        case 2: // '\002'
        case 3: // '\003'
            return unhydrateCollection((IEngVCollection)ivirtuosoidentifier, i);

        case 1: // '\001'
            return unhydrateFile((IEngVFile)ivirtuosoidentifier, i);

        case 4: // '\004'
            return unhydrateHLSFile((IEngVHLSFile)ivirtuosoidentifier, i);
        }
    }

    private static ContentValues unhydrateCollection(IEngVCollection iengvcollection, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("assetId", iengvcollection.assetId());
        contentvalues.put("assetUrl", iengvcollection.assetURL());
        if ((i & 1) == 1)
        {
            contentvalues.put("description", iengvcollection.metadata());
        }
        contentvalues.put("uuid", iengvcollection.uuid());
        contentvalues.put("parentUuid", iengvcollection.parentUuid());
        contentvalues.put("errorType", Integer.valueOf(iengvcollection.downloadStatus().ordinal()));
        contentvalues.put("addedToQueue", Boolean.valueOf(iengvcollection.isAdded()));
        contentvalues.put("contentType", Integer.valueOf(iengvcollection.type()));
        contentvalues.put("completeTime", Long.valueOf(iengvcollection.completionTime()));
        contentvalues.put("clientAuthority", iengvcollection.clientProviderAuth());
        return contentvalues;
    }

    private static ContentValues unhydrateFile(IEngVFile iengvfile, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("assetId", iengvfile.assetId());
        contentvalues.put("assetUrl", iengvfile.assetURL());
        contentvalues.put("currentSize", Double.valueOf(iengvfile.currentSize()));
        if ((i & 1) == 1)
        {
            contentvalues.put("description", iengvfile.metadata());
        }
        contentvalues.put("errorType", Integer.valueOf(iengvfile.downloadStatus().ordinal()));
        contentvalues.put("expectedSize", Double.valueOf(iengvfile.expectedSize()));
        contentvalues.put("fileHash", iengvfile.fileMD5());
        contentvalues.put("filePath", iengvfile.filePath());
        contentvalues.put("mimeType", iengvfile.mimeType());
        contentvalues.put("uuid", iengvfile.uuid());
        contentvalues.put("errorCount", Long.valueOf(iengvfile.errorCount()));
        contentvalues.put("pending", Boolean.valueOf(iengvfile.isPending()));
        contentvalues.put("contentType", Integer.valueOf(iengvfile.type()));
        contentvalues.put("completeTime", Long.valueOf(iengvfile.completionTime()));
        contentvalues.put("parentUuid", iengvfile.parentUuid());
        if ((i & 2) == 2)
        {
            contentvalues.put("hashState", iengvfile.md5StateAsByteArray());
        }
        contentvalues.put("clientAuthority", iengvfile.clientProviderAuth());
        return contentvalues;
    }

    private static ContentValues unhydrateHLSFile(IEngVHLSFile iengvhlsfile, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("assetId", iengvhlsfile.assetId());
        contentvalues.put("assetUrl", iengvhlsfile.assetURL());
        contentvalues.put("currentSize", Double.valueOf(iengvhlsfile.currentSize()));
        if ((i & 1) == 1)
        {
            contentvalues.put("description", iengvhlsfile.metadata());
        }
        contentvalues.put("errorType", Integer.valueOf(iengvhlsfile.downloadStatus().ordinal()));
        contentvalues.put("expectedSize", Double.valueOf(iengvhlsfile.expectedSize()));
        contentvalues.put("filePath", iengvhlsfile.localBaseDir());
        contentvalues.put("uuid", iengvhlsfile.uuid());
        contentvalues.put("pending", Boolean.valueOf(iengvhlsfile.isPending()));
        contentvalues.put("contentType", Integer.valueOf(iengvhlsfile.type()));
        contentvalues.put("completeTime", Long.valueOf(iengvhlsfile.completionTime()));
        contentvalues.put("parentUuid", iengvhlsfile.parentUuid());
        contentvalues.put("clientAuthority", iengvhlsfile.clientProviderAuth());
        contentvalues.put("hlsFragmentCompletedCount", Integer.valueOf(iengvhlsfile.totalFragmentsComplete()));
        contentvalues.put("hlsFragmentCount", Integer.valueOf(iengvhlsfile.totalFragments()));
        return contentvalues;
    }

    public void addDownloadedObserver(IDownloadedObserver idownloadedobserver)
    {
        if (idownloadedobserver == null)
        {
            return;
        }
        synchronized (iDownloadLock)
        {
            if (!iDownloadedObservers.contains(idownloadedobserver))
            {
                iDownloadedObservers.add(idownloadedobserver);
            }
            if (iDownloadedObservers.size() > 0 && (iRegisteredCallbacks & 2) != 2)
            {
                registerCallback(2);
            }
        }
        return;
        idownloadedobserver;
        obj;
        JVM INSTR monitorexit ;
        throw idownloadedobserver;
    }

    public void addEngineObserver(IEngineObserver iengineobserver)
    {
        if (iengineobserver == null)
        {
            return;
        }
        synchronized (iEngineLock)
        {
            if (!iEngineObservers.contains(iengineobserver))
            {
                iEngineObservers.add(iengineobserver);
            }
            if (iEngineObservers.size() > 0 && (iRegisteredCallbacks & 1) != 1)
            {
                registerCallback(1);
            }
        }
        return;
        iengineobserver;
        obj;
        JVM INSTR monitorexit ;
        throw iengineobserver;
    }

    public void addQueueObserver(IQueueObserver iqueueobserver)
    {
        if (iqueueobserver == null)
        {
            return;
        }
        synchronized (iQueueLock)
        {
            if (!iQueueObservers.contains(iqueueobserver))
            {
                iQueueObservers.add(iqueueobserver);
            }
            if (iQueueObservers.size() > 0 && (iRegisteredCallbacks & 4) != 4)
            {
                registerCallback(4);
            }
        }
        return;
        iqueueobserver;
        obj;
        JVM INSTR monitorexit ;
        throw iqueueobserver;
    }

    void addToCollection(IVirtuosoIdentifier ivirtuosoidentifier, IVirtuosoIdentifier ivirtuosoidentifier1)
        throws ServiceException
    {
        if (ivirtuosoidentifier1 != null)
        {
            String s = null;
            if (ivirtuosoidentifier != null)
            {
                s = ivirtuosoidentifier.uuid();
            }
            ivirtuosoidentifier = iRegistry.pendingQueue(s);
            if (!iRegistry.errorQueue(s).contains(ivirtuosoidentifier1.uuid()) && !ivirtuosoidentifier.contains(ivirtuosoidentifier1.uuid()))
            {
                ivirtuosoidentifier.add(ivirtuosoidentifier1.uuid());
                iRegistry.savePendingQueue(s, ivirtuosoidentifier);
                ((IEngVIdentifier)ivirtuosoidentifier1).setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending);
                save(ivirtuosoidentifier1, 0, iApplicationContext.getContentResolver(), iCurrentAuthority);
                boolean flag;
                if (ivirtuosoidentifier.size() == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                signalQueueChange(flag);
                return;
            }
        }
    }

    public void addToQueue(IVirtuosoIdentifier ivirtuosoidentifier)
        throws ServiceException
    {
        addToCollection(null, ivirtuosoidentifier);
    }

    public void configure(Bundle bundle, int i, int j)
        throws ServiceException
    {
        try
        {
            iService.configure(bundle, i, j, iCurrentAuthority);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new ServiceException("Service is not connected", bundle);
        }
        throw new ServiceException(bundle.getMessage(), bundle);
    }

    public void delete(IVirtuosoIdentifier ivirtuosoidentifier)
        throws ServiceException
    {
        if (ivirtuosoidentifier != null)
        {
            Object obj = null;
            if (!TextUtils.isEmpty(ivirtuosoidentifier.parentUuid()))
            {
                obj = getItem(iApplicationContext, ivirtuosoidentifier.parentUuid());
            }
            String s = null;
            if (obj != null)
            {
                s = ((IVirtuosoIdentifier) (obj)).uuid();
            }
            obj = iRegistry.pendingQueue(s);
            List list = iRegistry.errorQueue(s);
            boolean flag;
            boolean flag1;
            if (((List) (obj)).size() > 0 && ((String)((List) (obj)).get(0)).equals(ivirtuosoidentifier.uuid()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!((List) (obj)).contains(ivirtuosoidentifier.uuid()) && !list.contains(ivirtuosoidentifier.uuid()))
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            ((List) (obj)).remove(ivirtuosoidentifier.uuid());
            list.remove(ivirtuosoidentifier.uuid());
            iRegistry.saveErrorQueue(s, list);
            iRegistry.savePendingQueue(s, ((List) (obj)));
            s = null;
            if (ivirtuosoidentifier.type() == 4)
            {
                s = ((IEngVHLSFile)ivirtuosoidentifier).localBaseDir();
            } else
            if (ivirtuosoidentifier.type() == 1)
            {
                s = ((IEngVFile)ivirtuosoidentifier).filePath();
            }
            markForDelete(ivirtuosoidentifier);
            if (flag)
            {
                try
                {
                    iService.signalDelete(iCurrentAuthority, ivirtuosoidentifier);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (IVirtuosoIdentifier ivirtuosoidentifier)
                {
                    ivirtuosoidentifier.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (IVirtuosoIdentifier ivirtuosoidentifier)
                {
                    throw new ServiceException("Service is not connected", ivirtuosoidentifier);
                }
                throw new ServiceException(ivirtuosoidentifier.getMessage(), ivirtuosoidentifier);
            }
            iFileManager.remove(s);
            remove(ivirtuosoidentifier);
            if (ivirtuosoidentifier.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.KvDE_Download_Complete)
            {
                signalDownloadedChange();
            }
            if (flag1)
            {
                signalQueueChange(false);
                return;
            }
        }
    }

    public void deleteAllFiles()
        throws ServiceException
    {
        String s = null;
        Object obj = iRegistry.pendingQueue(null);
        List list = iRegistry.errorQueue(null);
        ((List) (obj)).addAll(list);
        if (((List) (obj)).size() > 0)
        {
            s = (String)((List) (obj)).get(0);
        }
        int i = ((List) (obj)).size() + list.size();
        ((List) (obj)).clear();
        list.clear();
        iRegistry.savePendingQueue(null, list);
        iRegistry.saveErrorQueue(null, list);
        ArrayList arraylist = new ArrayList();
        List list1 = getFiles(14, null, iCurrentAuthority);
        obj = null;
        Iterator iterator = list1.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                removeAllButItem(((IVirtuosoIdentifier) (obj)), 14);
                removeAllFragmentsButChildOf(((IVirtuosoIdentifier) (obj)));
                if (arraylist.size() > 0)
                {
                    iFileManager.remove((String[])arraylist.toArray(new String[0]));
                }
                IVirtuosoIdentifier ivirtuosoidentifier;
                if (obj != null)
                {
                    try
                    {
                        iService.signalDelete(iCurrentAuthority, ((IVirtuosoIdentifier) (obj)));
                    }
                    catch (RemoteException remoteexception)
                    {
                        remoteexception.printStackTrace();
                        throw new ServiceException(remoteexception.getMessage(), remoteexception);
                    }
                    catch (NullPointerException nullpointerexception)
                    {
                        throw new ServiceException("Service is not connected", nullpointerexception);
                    }
                } else
                if (i > 0)
                {
                    signalQueueChange(false);
                }
                if (list1.size() - i > 0)
                {
                    signalDownloadedChange();
                }
                return;
            }
            ivirtuosoidentifier = (IVirtuosoIdentifier)iterator.next();
            if (!ivirtuosoidentifier.uuid().equals(s))
            {
                if (ivirtuosoidentifier.type() == 4)
                {
                    arraylist.add(((IEngVHLSFile)ivirtuosoidentifier).localBaseDir());
                } else
                if (ivirtuosoidentifier.type() == 1)
                {
                    arraylist.add(((IEngVFile)ivirtuosoidentifier).filePath());
                }
            } else
            {
                obj = ivirtuosoidentifier;
            }
        } while (true);
    }

    public List downloadedRootList()
    {
        return getFiles(4, null, iCurrentAuthority);
    }

    public void expire(IVirtuosoIdentifier ivirtuosoidentifier)
        throws ServiceException
    {
        if (ivirtuosoidentifier != null)
        {
            Object obj = null;
            if (!TextUtils.isEmpty(ivirtuosoidentifier.parentUuid()))
            {
                obj = getItem(iApplicationContext, ivirtuosoidentifier.parentUuid());
            }
            String s = null;
            if (obj != null)
            {
                s = ((IVirtuosoIdentifier) (obj)).uuid();
            }
            obj = iRegistry.pendingQueue(s);
            List list = iRegistry.errorQueue(s);
            boolean flag;
            boolean flag1;
            if (((List) (obj)).size() > 0 && ((String)((List) (obj)).get(0)).equals(ivirtuosoidentifier.uuid()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!((List) (obj)).contains(ivirtuosoidentifier.uuid()) && !list.contains(ivirtuosoidentifier.uuid()))
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            ((List) (obj)).remove(ivirtuosoidentifier.uuid());
            list.remove(ivirtuosoidentifier.uuid());
            iRegistry.saveErrorQueue(s, list);
            iRegistry.savePendingQueue(s, ((List) (obj)));
            s = null;
            if (ivirtuosoidentifier.type() == 4)
            {
                s = ((IEngVHLSFile)ivirtuosoidentifier).localBaseDir();
                ((IEngVHLSFile)ivirtuosoidentifier).setPending(false);
            } else
            if (ivirtuosoidentifier.type() == 1)
            {
                s = ((IEngVFile)ivirtuosoidentifier).filePath();
                ((IEngVFile)ivirtuosoidentifier).setPending(false);
                ((IEngVFile)ivirtuosoidentifier).setCurrentSize(0.0D);
            }
            obj = (IEngVIdentifier)ivirtuosoidentifier;
            ((IEngVIdentifier) (obj)).setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired);
            ((IEngVIdentifier) (obj)).setCompletionTime((new Date()).getTime());
            save(((IVirtuosoIdentifier) (obj)), 0, iApplicationContext.getContentResolver(), iCurrentAuthority);
            if (flag)
            {
                try
                {
                    iService.signalExpire(iCurrentAuthority, ivirtuosoidentifier);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (IVirtuosoIdentifier ivirtuosoidentifier)
                {
                    ivirtuosoidentifier.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (IVirtuosoIdentifier ivirtuosoidentifier)
                {
                    throw new ServiceException("Service is not connected", ivirtuosoidentifier);
                }
                throw new ServiceException(ivirtuosoidentifier.getMessage(), ivirtuosoidentifier);
            }
            iFileManager.remove(s);
            signalDownloadedChange();
            if (flag1)
            {
                signalQueueChange(false);
                return;
            }
        }
    }

    IVirtuosoIdentifier getItem(Context context, String s)
    {
        return getItem(context.getContentResolver(), s, iCurrentAuthority);
    }

    public void move(IVirtuosoIdentifier ivirtuosoidentifier, int i)
        throws ServiceException
    {
        if (ivirtuosoidentifier != null)
        {
            Object obj = null;
            if (!TextUtils.isEmpty(ivirtuosoidentifier.parentUuid()))
            {
                obj = getItem(iApplicationContext, ivirtuosoidentifier.parentUuid());
            }
            String s = null;
            if (obj != null)
            {
                s = ((IVirtuosoIdentifier) (obj)).uuid();
            }
            obj = iRegistry.pendingQueue(s);
            List list = iRegistry.errorQueue(s);
            boolean flag = ((List) (obj)).contains(ivirtuosoidentifier.uuid());
            boolean flag1 = list.contains(ivirtuosoidentifier.uuid());
            if (flag || flag1)
            {
                ArrayList arraylist = new ArrayList(((java.util.Collection) (obj)));
                arraylist.addAll(list);
                int j = arraylist.indexOf(ivirtuosoidentifier.uuid());
                boolean flag2 = false;
                if (flag)
                {
                    if (list.size() > 0 && i >= ((List) (obj)).size())
                    {
                        if (j == 0 && i > 0)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            getItem(iApplicationContext, (String)arraylist.get(0));
                        }
                        arraylist.remove(ivirtuosoidentifier.uuid());
                        i = Math.min(Math.max(i, 0), arraylist.size());
                        arraylist.add(i, ivirtuosoidentifier.uuid());
                        obj = arraylist.subList(0, Math.min(i + 1, arraylist.size()));
                        list = arraylist.subList(Math.min(i + 1, arraylist.size()), arraylist.size());
                        if (arraylist.indexOf(ivirtuosoidentifier.uuid()) != j)
                        {
                            i = 1;
                            ivirtuosoidentifier = list;
                        } else
                        {
                            i = 0;
                            ivirtuosoidentifier = list;
                        }
                    } else
                    {
                        if (j == 0 && i > 0 && ((List) (obj)).size() > 1)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        flag2 = flag;
                        if (!flag)
                        {
                            flag2 = flag;
                            if (j > 0)
                            {
                                flag2 = flag;
                                if (i <= 0)
                                {
                                    flag2 = true;
                                }
                            }
                        }
                        if (flag2)
                        {
                            getItem(iApplicationContext, (String)arraylist.get(0));
                        }
                        ((List) (obj)).remove(ivirtuosoidentifier.uuid());
                        ((List) (obj)).add(Math.min(Math.max(i, 0), ((List) (obj)).size()), ivirtuosoidentifier.uuid());
                        arraylist.clear();
                        arraylist.addAll(((java.util.Collection) (obj)));
                        arraylist.addAll(list);
                        if (arraylist.indexOf(ivirtuosoidentifier.uuid()) != j)
                        {
                            i = 1;
                        } else
                        {
                            i = 0;
                        }
                        ivirtuosoidentifier = list;
                        flag = flag2;
                    }
                } else
                if (i < ((List) (obj)).size() || i == 0)
                {
                    j = ((List) (obj)).size();
                    if (i <= 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (j > 0 && flag)
                    {
                        getItem(iApplicationContext, (String)arraylist.get(0));
                    }
                    arraylist.remove(ivirtuosoidentifier.uuid());
                    arraylist.add(Math.min(Math.max(i, 0), arraylist.size()), ivirtuosoidentifier.uuid());
                    i = j + 1;
                    obj = arraylist.subList(0, Math.min(i, arraylist.size()));
                    ivirtuosoidentifier = arraylist.subList(Math.min(i, arraylist.size()), arraylist.size());
                    i = 1;
                } else
                {
                    list.remove(ivirtuosoidentifier.uuid());
                    list.add(Math.min(Math.max(i - ((List) (obj)).size(), 0), list.size()), ivirtuosoidentifier.uuid());
                    flag = flag2;
                    if (j == 0)
                    {
                        flag = flag2;
                        if (list.indexOf(ivirtuosoidentifier.uuid()) != 0)
                        {
                            flag = true;
                            ((List) (obj)).add((String)list.remove(0));
                        }
                    }
                    arraylist.clear();
                    arraylist.addAll(((java.util.Collection) (obj)));
                    arraylist.addAll(list);
                    if (arraylist.indexOf(ivirtuosoidentifier.uuid()) == j && !flag)
                    {
                        i = 0;
                    } else
                    {
                        i = 1;
                    }
                    ivirtuosoidentifier = list;
                }
                iRegistry.saveErrorQueue(s, ivirtuosoidentifier);
                iRegistry.savePendingQueue(s, ((List) (obj)));
                if (i != 0)
                {
                    signalQueueChange(flag);
                    return;
                }
            }
        }
    }

    public void onResume()
    {
        bind();
    }

    public void overrideBatteryThreshold(double d)
        throws ServiceException
    {
        if (com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD == com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD_TYPE.EGold)
        {
            double d1 = d;
            if (d < 0.0D)
            {
                d1 = 0.0D;
            }
            overrideDoubleSetting("battery_threshold_override", d1);
        }
    }

    public void overrideCellularDataQuota(double d)
        throws ServiceException
    {
        if (com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD == com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD_TYPE.EGold)
        {
            double d1 = d;
            if (d < 0.0D)
            {
                d1 = -1D;
            }
            overrideDoubleSetting("cell_data_quota_override", d1);
        }
    }

    public void overrideHeadroom(double d)
        throws ServiceException
    {
        if (com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD == com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD_TYPE.EGold)
        {
            double d1 = d;
            if (d < 0.0D)
            {
                d1 = 0.0D;
            }
            overrideDoubleSetting("headroom_override", toBytes(d1));
        }
    }

    public void overrideMaxStorageAllowed(double d)
        throws ServiceException
    {
        if (com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD == com.penthera.virtuososdk.utility.CommonUtil.Config.BUILD_TYPE.EGold)
        {
            double d1 = d;
            if (d < 0.0D)
            {
                d1 = -1D;
            }
            overrideDoubleSetting("max_storage_override", toBytes(d1));
        }
    }

    public void pauseDownloads()
        throws ServiceException
    {
        try
        {
            iService.pauseDownloads(iCurrentAuthority);
            return;
        }
        catch (RemoteException remoteexception)
        {
            remoteexception.printStackTrace();
            throw new ServiceException(remoteexception.getMessage(), remoteexception);
        }
        catch (NullPointerException nullpointerexception)
        {
            throw new ServiceException("Service is not connected", nullpointerexception);
        }
    }

    int performSettingsOverride(Bundle bundle)
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "SettingsOverride Callback");
        int j = 0;
        int i = j;
        if (bundle.containsKey("destination_path_override"))
        {
            i = j;
            if (iRegistry.get("destination_path_override") != bundle.getString("destination_path_override"))
            {
                i = 0 | 0x200;
            }
        }
        j = i;
        if (bundle.containsKey("headroom_override"))
        {
            j = i;
            if (iRegistry.get("headroom_override") != bundle.get("headroom_override").toString())
            {
                j = i | 0x20;
            }
        }
        i = j;
        if (bundle.containsKey("max_storage_override"))
        {
            i = j;
            if (iRegistry.get("max_storage_override") != bundle.get("max_storage_override").toString())
            {
                i = j | 0x10;
            }
        }
        j = i;
        if (bundle.containsKey("cell_data_quota_override"))
        {
            j = i;
            if (iRegistry.get("cell_data_quota_override") != bundle.get("cell_data_quota_override").toString())
            {
                j = i | 0x80;
            }
        }
        i = j;
        if (bundle.containsKey("battery_threshold_override"))
        {
            i = j;
            if (iRegistry.get("battery_threshold_override") != bundle.get("battery_threshold_override").toString())
            {
                i = j | 0x100;
            }
        }
        j = i;
        if (bundle.containsKey("client_configuration_fragment_rate"))
        {
            j = i;
            if (iRegistry.get("client_configuration_fragment_rate") != bundle.get("client_configuration_fragment_rate").toString())
            {
                j = i | 0x400;
            }
        }
        iRegistry.updateRegistry(bundle);
        return j;
    }

    public List queuedRootList()
    {
        return getFiles(3, null, iCurrentAuthority);
    }

    public void resumeDownloads()
        throws ServiceException
    {
        try
        {
            iService.resumeDownloads(iCurrentAuthority);
            return;
        }
        catch (RemoteException remoteexception)
        {
            remoteexception.printStackTrace();
            throw new ServiceException(remoteexception.getMessage(), remoteexception);
        }
        catch (NullPointerException nullpointerexception)
        {
            throw new ServiceException("Service is not connected", nullpointerexception);
        }
    }

    public IVirtuosoDownloadEngineStatus status()
        throws ServiceException
    {
        IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus;
        try
        {
            ivirtuosodownloadenginestatus = iService.status(iCurrentAuthority);
        }
        catch (RemoteException remoteexception)
        {
            remoteexception.printStackTrace();
            throw new ServiceException(remoteexception.getMessage(), remoteexception);
        }
        catch (NullPointerException nullpointerexception)
        {
            throw new ServiceException("Service is not connected", nullpointerexception);
        }
        return ivirtuosodownloadenginestatus;
    }

    public boolean update(IVirtuosoIdentifier ivirtuosoidentifier)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (ivirtuosoidentifier != null)
        {
            ivirtuosoidentifier = (IVirtuosoAsset)ivirtuosoidentifier;
            ContentResolver contentresolver = iApplicationContext.getContentResolver();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("modifyTime", Long.valueOf((new Date()).getTime()));
            contentvalues.put("description", ivirtuosoidentifier.metadata());
            try
            {
                i = contentresolver.update(ContentUris.withAppendedId(com.penthera.virtuososdk.database.impl.provider.File.FileColumns.CONTENT_URI(iCurrentAuthority), ivirtuosoidentifier.id()), contentvalues, null, null);
            }
            // Misplaced declaration of an exception variable
            catch (IVirtuosoIdentifier ivirtuosoidentifier)
            {
                ivirtuosoidentifier.printStackTrace();
                i = ((flag) ? 1 : 0);
            }
        }
        return i > 0;
    }

    public IVirtuosoHLSFile virtuosoHLSFile(String s, String s1)
        throws ServiceException
    {
        s = InternalInterfaceFactory.virtuosoHLSFile(s, s1);
        create((IEngVIdentifier)s);
        return s;
    }












}
