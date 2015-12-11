// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adobe.mobile:
//            VisitorIDService, MobileConfig, StaticMethods, RequestHandler, 
//            WearableFunctionBridge

class val.dpidsCopy
    implements Runnable
{

    final VisitorIDService this$0;
    final HashMap val$dpidsCopy;
    final HashMap val$identifiersCopy;

    public void run()
    {
        if (MobileConfig.getInstance().getVisitorIdServiceEnabled()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        boolean flag2;
        Object obj1 = MobileConfig.getInstance().getMarketingCloudOrganizationId();
        java.util.vice vice;
        boolean flag;
        boolean flag1;
        if (StaticMethods.getTimeSince1970() - VisitorIDService.access$400(VisitorIDService.this) > VisitorIDService.access$300(VisitorIDService.this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (val$identifiersCopy != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (val$dpidsCopy != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (VisitorIDService.access$000(VisitorIDService.this) != null && !flag1 && !flag2 && !flag) goto _L1; else goto _L3
_L3:
        if (MobileConfig.getInstance().getSSL())
        {
            obj = "https";
        } else
        {
            obj = "http";
        }
        obj = new StringBuilder(((String) (obj)));
        ((StringBuilder) (obj)).append("://");
        ((StringBuilder) (obj)).append("dpm.demdex.net");
        ((StringBuilder) (obj)).append("/id?d_ver=2&d_orgid=");
        ((StringBuilder) (obj)).append(((String) (obj1)));
        if (VisitorIDService.access$000(VisitorIDService.this) != null)
        {
            ((StringBuilder) (obj)).append("&");
            ((StringBuilder) (obj)).append("d_mid");
            ((StringBuilder) (obj)).append("=");
            ((StringBuilder) (obj)).append(VisitorIDService.access$000(VisitorIDService.this));
        }
        if (VisitorIDService.access$200(VisitorIDService.this) != null)
        {
            ((StringBuilder) (obj)).append("&");
            ((StringBuilder) (obj)).append("d_blob");
            ((StringBuilder) (obj)).append("=");
            ((StringBuilder) (obj)).append(VisitorIDService.access$200(VisitorIDService.this));
        }
        if (VisitorIDService.access$100(VisitorIDService.this) != null)
        {
            ((StringBuilder) (obj)).append("&");
            ((StringBuilder) (obj)).append("dcs_region");
            ((StringBuilder) (obj)).append("=");
            ((StringBuilder) (obj)).append(VisitorIDService.access$100(VisitorIDService.this));
        }
        if (flag1)
        {
            for (obj1 = val$identifiersCopy.entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuilder) (obj)).append(StaticMethods.URLEncode((String)vice.URLEncode())))
            {
                vice = (java.util.s.URLEncode)((Iterator) (obj1)).next();
                ((StringBuilder) (obj)).append("&d_cid_ic=");
                ((StringBuilder) (obj)).append(StaticMethods.URLEncode((String)vice.URLEncode()));
                ((StringBuilder) (obj)).append("%01");
            }

        }
        if (flag2)
        {
            java.util.vice vice1;
            for (Iterator iterator = val$dpidsCopy.entrySet().iterator(); iterator.hasNext(); ((StringBuilder) (obj)).append(StaticMethods.URLEncode((String)vice1.URLEncode())))
            {
                vice1 = (java.util.s.URLEncode)iterator.next();
                ((StringBuilder) (obj)).append("&d_cid=");
                ((StringBuilder) (obj)).append(StaticMethods.URLEncode((String)vice1.URLEncode()));
                ((StringBuilder) (obj)).append("%01");
            }

        }
        obj = ((StringBuilder) (obj)).toString();
        StaticMethods.logDebugFormat("ID Service - Sending id sync call (%s)", new Object[] {
            obj
        });
        byte abyte0[] = RequestHandler.retrieveData(((String) (obj)), null, 2000, "ID Service");
        abyte0 = parseResponse(abyte0);
        if (abyte0 == null || !abyte0.has("d_mid") || abyte0.has("error_msg")) goto _L5; else goto _L4
_L4:
        try
        {
            VisitorIDService.access$002(VisitorIDService.this, abyte0.getString("d_mid"));
            if (abyte0.has("d_blob"))
            {
                VisitorIDService.access$202(VisitorIDService.this, abyte0.getString("d_blob"));
            }
            if (abyte0.has("dcs_region"))
            {
                VisitorIDService.access$102(VisitorIDService.this, abyte0.getString("dcs_region"));
            }
            if (abyte0.has("id_sync_ttl"))
            {
                VisitorIDService.access$302(VisitorIDService.this, abyte0.getInt("id_sync_ttl"));
            }
            StaticMethods.logDebugFormat("ID Service - Got ID Response (mid: %s, blob: %s, hint: %s, ttl: %d)", new Object[] {
                VisitorIDService.access$000(VisitorIDService.this), VisitorIDService.access$200(VisitorIDService.this), VisitorIDService.access$100(VisitorIDService.this), Long.valueOf(VisitorIDService.access$300(VisitorIDService.this))
            });
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            StaticMethods.logDebugFormat("ID Service - Error parsing response (%s)", new Object[] {
                abyte0.getLocalizedMessage()
            });
        }
_L7:
        VisitorIDService.access$402(VisitorIDService.this, StaticMethods.getTimeSince1970());
        WearableFunctionBridge.syncVidServiceToWearable(VisitorIDService.access$000(VisitorIDService.this), VisitorIDService.access$100(VisitorIDService.this), VisitorIDService.access$200(VisitorIDService.this), VisitorIDService.access$300(VisitorIDService.this), VisitorIDService.access$400(VisitorIDService.this));
        try
        {
            abyte0 = StaticMethods.getSharedPreferencesEditor();
            abyte0.putString("ADBMOBILE_PERSISTED_MID", VisitorIDService.access$000(VisitorIDService.this));
            abyte0.putString("ADBMOBILE_PERSISTED_MID_HINT", VisitorIDService.access$100(VisitorIDService.this));
            abyte0.putString("ADBMOBILE_PERSISTED_MID_BLOB", VisitorIDService.access$200(VisitorIDService.this));
            abyte0.putLong("ADBMOBILE_VISITORID_TTL", VisitorIDService.access$300(VisitorIDService.this));
            abyte0.putLong("ADBMOBILE_VISITORID_SYNC", VisitorIDService.access$400(VisitorIDService.this));
            abyte0.commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            StaticMethods.logErrorFormat("ID Service - Unable to persist identifiers to shared preferences(%s)", new Object[] {
                abyte0.getLocalizedMessage()
            });
        }
        return;
_L5:
        if (abyte0 != null && abyte0.has("error_msg"))
        {
            try
            {
                StaticMethods.logErrorFormat("ID Service - Service returned error (%s)", new Object[] {
                    abyte0.getString("error_msg")
                });
            }
            catch (JSONException jsonexception)
            {
                StaticMethods.logErrorFormat("ID Service - Unable to read error condition(%s)", new Object[] {
                    jsonexception.getLocalizedMessage()
                });
            }
        }
        if (VisitorIDService.access$000(VisitorIDService.this) == null)
        {
            VisitorIDService.access$002(VisitorIDService.this, VisitorIDService.access$500(VisitorIDService.this));
            VisitorIDService.access$202(VisitorIDService.this, null);
            VisitorIDService.access$102(VisitorIDService.this, null);
            VisitorIDService.access$302(VisitorIDService.this, 600L);
            StaticMethods.logDebugFormat("ID Service - Did not return an ID, generating one locally (mid: %s, ttl: %d)", new Object[] {
                VisitorIDService.access$000(VisitorIDService.this), Long.valueOf(VisitorIDService.access$300(VisitorIDService.this))
            });
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    ontextException()
    {
        this$0 = final_visitoridservice;
        val$identifiersCopy = hashmap;
        val$dpidsCopy = HashMap.this;
        super();
    }
}
