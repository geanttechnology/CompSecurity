// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorDescriptionParser, InvalidSubAuthenticatorDefinitionException, SubAuthenticatorDescription

public class SubAuthenticatorRegistry
{
    private static class DMSPackageInfo
    {

        private String mPackageName;
        private XmlResourceParser mParser;

        public String getPackageName()
        {
            return mPackageName;
        }

        public XmlResourceParser getParser()
        {
            return mParser;
        }

        public DMSPackageInfo(String s, XmlResourceParser xmlresourceparser)
        {
            mPackageName = s;
            mParser = xmlresourceparser;
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/SubAuthenticatorRegistry.getName();
    private final SubAuthenticatorDescriptionParser mDescriptionParser;
    private final Object mGuard;
    private final MAPApplicationInformationQueryer mMapInformationQueryer;
    private List mSubAuthenticators;
    private int mSubAuthenticatorsVersion;
    private final TrustedPackageManager mTrustedPackageManager;

    public SubAuthenticatorRegistry(Context context)
    {
        this(new SubAuthenticatorDescriptionParser(), new TrustedPackageManager(context), MAPApplicationInformationQueryer.getInstance(context));
    }

    public SubAuthenticatorRegistry(SubAuthenticatorDescriptionParser subauthenticatordescriptionparser, TrustedPackageManager trustedpackagemanager, MAPApplicationInformationQueryer mapapplicationinformationqueryer)
    {
        mGuard = ((Object) (new Object[0]));
        mSubAuthenticatorsVersion = 0;
        mTrustedPackageManager = trustedpackagemanager;
        mMapInformationQueryer = mapapplicationinformationqueryer;
        mDescriptionParser = subauthenticatordescriptionparser;
    }

    private List getAppsWithSubAuthenticator()
    {
        ArrayList arraylist;
        Object obj;
        arraylist = new ArrayList();
        obj = new Intent("com.amazon.dcp.sso.AccountSubAuthenticator");
        obj = mTrustedPackageManager.queryIntentServices(((Intent) (obj)), 128).iterator();
_L2:
        ResolveInfo resolveinfo;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        resolveinfo = (ResolveInfo)((Iterator) (obj)).next();
        Object obj1;
        XmlResourceParser xmlresourceparser;
        obj1 = resolveinfo.serviceInfo;
        xmlresourceparser = mTrustedPackageManager.getParserForPackage$6d908fab(((PackageItemInfo) (obj1)));
        if (xmlresourceparser == null)
        {
            try
            {
                throw new InvalidSubAuthenticatorDefinitionException(String.format("%s does not have a valid sub authenticator metadata file", new Object[] {
                    ((PackageItemInfo) (obj1)).packageName
                }));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                MAPLog.e(TAG, String.format("Ignored invalid sub authenticator from package %s: %s", new Object[] {
                    resolveinfo.serviceInfo.packageName, ((InvalidSubAuthenticatorDefinitionException) (obj1)).toString()
                }));
            }
            continue; /* Loop/switch isn't completed */
        }
        obj1 = mDescriptionParser.parse(((PackageItemInfo) (obj1)).packageName, ((PackageItemInfo) (obj1)).name, xmlresourceparser);
        arraylist.add(obj1);
        String.format("Detected sub-authenticator: %s/%s", new Object[] {
            ((SubAuthenticatorDescription) (obj1)).packageName, ((SubAuthenticatorDescription) (obj1)).className
        });
        String.format(" Supports token types:", new Object[0]);
        obj1 = ((SubAuthenticatorDescription) (obj1)).tokenTypes.iterator();
        while (((Iterator) (obj1)).hasNext()) 
        {
            String.format("  %s", new Object[] {
                (String)((Iterator) (obj1)).next()
            });
        }
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    private List getDMSApps()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = getDmsPackageInfos().iterator(); iterator.hasNext();)
        {
            Object obj = (DMSPackageInfo)iterator.next();
            String s = ((DMSPackageInfo) (obj)).getPackageName();
            obj = ((DMSPackageInfo) (obj)).getParser();
            try
            {
                obj = mDescriptionParser.parse(s, null, ((XmlResourceParser) (obj)));
                arraylist.add(obj);
                String.format("Detected DMS sub-authenticator: %s/%s", new Object[] {
                    ((SubAuthenticatorDescription) (obj)).packageName, ((SubAuthenticatorDescription) (obj)).className
                });
                String.format(" Supports token types:", new Object[0]);
                obj = ((SubAuthenticatorDescription) (obj)).tokenTypes.iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    String.format("  %s", new Object[] {
                        (String)((Iterator) (obj)).next()
                    });
                }
            }
            catch (InvalidSubAuthenticatorDefinitionException invalidsubauthenticatordefinitionexception)
            {
                MAPLog.e(TAG, String.format("Ignored invalid sub authenticator from package %s: %s", new Object[] {
                    s, invalidsubauthenticatordefinitionexception.toString()
                }));
            }
        }

        return arraylist;
    }

    private List getDmsPackageInfos()
    {
        ArrayList arraylist;
        Object obj;
        obj = mTrustedPackageManager.getTrustedInstalledPackages();
        arraylist = new ArrayList();
        obj = ((Set) (obj)).iterator();
_L2:
        String s;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)((Iterator) (obj)).next();
        Resources resources = mTrustedPackageManager.getResourcesForApplication(s);
        if (resources == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int i = resources.getIdentifier("dms_sub_authenticator", "xml", s);
        if (i != 0)
        {
            try
            {
                arraylist.add(new DMSPackageInfo(s, resources.getXml(i)));
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                (new StringBuilder("Cannot get resources for applicatoin. ")).append(s).append(" not found");
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    private List getSubAuthenticatorList()
    {
        int i;
label0:
        {
            List list;
            synchronized (mGuard)
            {
                i = mSubAuthenticatorsVersion;
                if (mSubAuthenticators == null)
                {
                    break label0;
                }
                list = mSubAuthenticators;
            }
            return list;
        }
        obj;
        JVM INSTR monitorexit ;
        Object obj3;
        Object obj4 = getAppsWithSubAuthenticator();
        obj3 = getDMSApps();
        obj = new ArrayList();
        obj2 = new HashSet();
        SubAuthenticatorDescription subauthenticatordescription1;
        for (obj4 = ((List) (obj4)).iterator(); ((Iterator) (obj4)).hasNext(); ((List) (obj)).add(subauthenticatordescription1))
        {
            subauthenticatordescription1 = (SubAuthenticatorDescription)((Iterator) (obj4)).next();
            ((HashSet) (obj2)).add(subauthenticatordescription1.packageName);
        }

        break MISSING_BLOCK_LABEL_116;
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
        for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext();)
        {
            SubAuthenticatorDescription subauthenticatordescription = (SubAuthenticatorDescription)((Iterator) (obj3)).next();
            if (!((HashSet) (obj2)).contains(subauthenticatordescription.packageName))
            {
                ((List) (obj)).add(subauthenticatordescription);
            } else
            {
                (new StringBuilder("Deduped sub-authenticator")).append(subauthenticatordescription.packageName);
            }
        }

        List list1 = Collections.unmodifiableList(removeMAPR5Applications(((List) (obj))));
        synchronized (mGuard)
        {
            if (i == mSubAuthenticatorsVersion)
            {
                mSubAuthenticators = list1;
            }
        }
        return list1;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private List removeMAPR5Applications(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            SubAuthenticatorDescription subauthenticatordescription = (SubAuthenticatorDescription)list.next();
            String s = subauthenticatordescription.packageName;
            if (mMapInformationQueryer.getAppInfo(s) == null)
            {
                arraylist.add(subauthenticatordescription);
            }
        } while (true);
        return arraylist;
    }

    public List getSubAuthenticators()
    {
        return getSubAuthenticatorList();
    }

}
