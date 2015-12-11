// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.manager;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.api.TemplatesService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.models.AnnouncerData;
import com.bitstrips.imoji.models.Announcers;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.models.OutfitBuilderCatalogs;
import com.bitstrips.imoji.models.Templates;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.util.FileUtil;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.bitstrips.outfitbuilder.models.OBAvatarData;
import com.bitstrips.outfitbuilder.models.OBCatalog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

public class TemplatesManager
{
    public static interface FailureCallback
    {

        public abstract void failure(RetrofitError retrofiterror);
    }

    public static interface SuccessCallback
    {

        public abstract void success(Object obj, Response response);
    }


    private static final String TAG = "TemplatesManager";
    B4MService b4MService;
    private boolean bitshopEnabled;
    private Context context;
    FacebookService facebookService;
    FileUtil fileUtil;
    private Map friendmojiTagMap;
    PreferenceUtils preferenceUtils;
    private Map tagMap;
    private Templates templates;
    TemplatesService templatesService;

    public TemplatesManager(Context context1)
    {
        context = context1;
        ((InjectorApplication)context).inject(this);
        bitshopEnabled = context1.getResources().getBoolean(0x7f080007);
        tagMap = null;
        friendmojiTagMap = null;
    }

    private String getETag(Response response)
    {
        for (response = response.getHeaders().iterator(); response.hasNext();)
        {
            Header header = (Header)response.next();
            if (!TextUtils.isEmpty(header.getName()) && "etag".equals(header.getName().toLowerCase()))
            {
                return header.getValue();
            }
        }

        return null;
    }

    private void requestTemplates(String s, final SuccessCallback successCallback, final FailureCallback failureCallback)
    {
        String s1 = context.getString(0x7f060017);
        String s2 = facebookService.getToken();
        String s3 = preferenceUtils.getString(0x7f06003a, "");
        templatesService.getTemplates(s, s1, context.getString(0x7f0600b8), s2, s3, new Callback() {

            final TemplatesManager this$0;
            final FailureCallback val$failureCallback;
            final SuccessCallback val$successCallback;

            public void failure(RetrofitError retrofiterror)
            {
                failureCallback.failure(retrofiterror);
            }

            public void success(Templates templates1, Response response)
            {
                setTemplates(templates1);
                preferenceUtils.putString(0x7f0600e7, getETag(response));
                successCallback.success(templates1, response);
            }

            public volatile void success(Object obj, Response response)
            {
                success((Templates)obj, response);
            }

            
            {
                this$0 = TemplatesManager.this;
                successCallback = successcallback;
                failureCallback = failurecallback;
                super();
            }
        });
    }

    private void setTemplates(Templates templates1)
    {
        templates = templates1;
        fileUtil.saveTemplatesToFile(templates1);
        tagMap = null;
        friendmojiTagMap = null;
    }

    public OBCatalog getCatalogForData(OBAvatarData obavatardata)
    {
        return templates.getOutfitBuilderData().getCatalogForData(obavatardata);
    }

    public AnnouncerData getFashionAnnouncerData()
    {
        Announcers announcers;
        if (templates != null)
        {
            if ((announcers = templates.getAnnouncers()) != null)
            {
                return announcers.getFashionAnnouncerData();
            }
        }
        return null;
    }

    public List getFriendmojiListForTag(String s)
    {
        if (friendmojiTagMap == null)
        {
            friendmojiTagMap = templates.getFriendmojiSuperTagMap();
        }
        List list = (List)friendmojiTagMap.get(s);
        s = list;
        if (list == null)
        {
            s = new ArrayList();
        }
        return s;
    }

    public String getImageUrlFromImoji(Imoji imoji, String s)
    {
        if (imoji.isFriendmoji())
        {
            return imoji.getFriendmojiUrl(s, b4MService.getFriendAvatarId(imoji.getTemplateId()));
        } else
        {
            return imoji.getUrl(s);
        }
    }

    public List getListForTag(String s)
    {
        if (tagMap == null)
        {
            tagMap = templates.getSuperTagMap(bitshopEnabled);
        }
        List list = (List)tagMap.get(s);
        s = list;
        if (list == null)
        {
            s = new ArrayList();
        }
        return s;
    }

    public List getPacks()
    {
        return templates.getPacks();
    }

    public Templates getTemplates()
    {
        if (templates == null)
        {
            templates = fileUtil.readTemplatesFromFile();
        }
        return templates;
    }

    public void initTemplates(SuccessCallback successcallback, FailureCallback failurecallback)
    {
        if (getTemplates() != null)
        {
            successcallback.success(getTemplates(), null);
            return;
        } else
        {
            requestTemplates(null, successcallback, failurecallback);
            return;
        }
    }

    public void resetAllImojisCachedImageUrl()
    {
        if (templates == null)
        {
            return;
        }
        for (Iterator iterator = templates.getImoji().iterator(); iterator.hasNext(); ((Imoji)iterator.next()).resetImojiImageUrl()) { }
        resetFriendmojisCachedImageUrl();
    }

    public void resetFriendmojisCachedImageUrl()
    {
        if (templates != null && templates.getFriendmojis() != null)
        {
            Iterator iterator = templates.getFriendmojis().iterator();
            while (iterator.hasNext()) 
            {
                ((Imoji)iterator.next()).resetImojiImageUrl();
            }
        }
    }

    public void setAnnouncerSeen(AnnouncerData announcerdata, boolean flag)
    {
        if (announcerdata == null)
        {
            return;
        } else
        {
            preferenceUtils.putBoolean(announcerdata.getPreferenceString(), flag);
            return;
        }
    }

    public void updateTemplates(SuccessCallback successcallback)
    {
        requestTemplates(preferenceUtils.getString(0x7f0600e7, null), successcallback, new FailureCallback() {

            final TemplatesManager this$0;

            public void failure(RetrofitError retrofiterror)
            {
                if (retrofiterror.getResponse() != null)
                {
                    if (retrofiterror.getResponse().getStatus() != 304);
                }
            }

            
            {
                this$0 = TemplatesManager.this;
                super();
            }
        });
    }


}
