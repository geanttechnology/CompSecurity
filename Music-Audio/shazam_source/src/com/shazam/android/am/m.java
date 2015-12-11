// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import android.content.res.Resources;
import com.google.api.services.now.model.Action;
import com.google.api.services.now.model.Button;
import com.google.api.services.now.model.Card;
import com.google.api.services.now.model.CardContent;
import com.google.api.services.now.model.Image;
import com.google.api.services.now.model.ListCard;
import com.google.api.services.now.model.ListItem;
import com.google.api.services.now.model.TemplatedString;
import com.shazam.android.aq.c;
import com.shazam.b.a.e;
import com.shazam.b.b.b;
import com.shazam.b.e.a;
import com.shazam.c.g;
import com.shazam.model.myshazam.MyShazamTag;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSettings;
import com.shazam.server.response.config.GoogleNowAmpSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.shazam.android.am:
//            j

public final class m
    implements j
{

    private final g a;
    private final Resources b;
    private final c c;
    private final String d;

    public m(g g1, Resources resources, c c1, String s)
    {
        a = g1;
        b = resources;
        c = c1;
        d = s;
    }

    public final Card a(List list)
    {
        Object obj = com.shazam.b.b.b.a(list, new e() {

            final m a;

            public final boolean apply(Object obj3)
            {
                obj3 = (MyShazamTag)obj3;
                return obj3 != null && System.currentTimeMillis() - ((MyShazamTag) (obj3)).a().longValue() <= TimeUnit.DAYS.toMillis(7L);
            }

            
            {
                a = m.this;
                super();
            }
        });
        list = new ArrayList();
        obj = ((Iterable) (obj)).iterator();
        for (int i = 0; ((Iterator) (obj)).hasNext() && i < 3; i++)
        {
            list.add(((Iterator) (obj)).next());
        }

        obj = b.getString(0x7f090170);
        Object obj1 = (new StringBuilder("android-app://")).append(d).append("/http/www.shazam.com/myshazam?screenorigin=googlenow").toString();
        Object obj2 = c.a().getSettings().getGoogleNow().getIcon();
        obj1 = (new ListCard()).setTitle((new TemplatedString()).setDisplayString(((String) (obj)))).setLogo((new Image()).setUrl(((String) (obj2)))).setButton((new Button()).setName(b.getString(0x7f09015a)).setTapAction((new Action()).setUrls(Collections.singletonList(obj1))).setIcon("viewMore"));
        obj = new ArrayList();
        obj2 = list.iterator();
        while (((Iterator) (obj2)).hasNext()) 
        {
            MyShazamTag myshazamtag = (MyShazamTag)((Iterator) (obj2)).next();
            String s = myshazamtag.trackTitle;
            String s1 = myshazamtag.artUrl;
            String s2 = a.a(myshazamtag.a());
            String s3 = myshazamtag.artistsDescription;
            list = myshazamtag.trackKey;
            if (!com.shazam.b.e.a.c(list))
            {
                list = myshazamtag.trackId;
            }
            list = (new StringBuilder("android-app://")).append(d).append("/http/www.shazam.com/discover/track/").append(list).append("?screenorigin=googlenow").toString();
            ((List) (obj)).add((new ListItem()).setTitle((new TemplatedString()).setDisplayString(s)).setImage((new Image()).setUrl(s1)).setDetails(Collections.singletonList((new TemplatedString()).setDisplayString(s2))).setSubtitle((new TemplatedString()).setDisplayString(s3)).setTapAction((new Action()).setUrls(Collections.singletonList(list))));
        }
        ((ListCard) (obj1)).setListItems(((List) (obj)));
        list = (new CardContent()).setListCard(((ListCard) (obj1))).setLocales(Collections.singletonList(Locale.getDefault().toString()));
        obj1 = new TemplatedString();
        obj2 = b;
        int k;
        if (((List) (obj)).size() > 1)
        {
            k = 0x7f09016d;
        } else
        {
            k = 0x7f09016e;
        }
        list = list.setJustification(((TemplatedString) (obj1)).setDisplayString(((Resources) (obj2)).getString(k)));
        return (new Card()).setContent(list);
    }
}
