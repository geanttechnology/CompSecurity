// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model.parsers;

import com.socialin.android.apiv3.IntrospectiveArrayList;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.BannerItem;
import com.socialin.android.apiv3.model.CardCollectionResponse;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Tag;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.model.card.Card;
import com.socialin.android.c;
import com.socialin.gson.Gson;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.model.parsers:
//            IStreamParser, StringParser

public class ResponseParserFactory
{

    public ResponseParserFactory()
    {
    }

    public static IStreamParser createCardResponseParser(final boolean loadDataForTabletLandscape)
    {
        return new IStreamParser() {

            final boolean val$loadDataForTabletLandscape;

            private int getMaxPhotosCount(String s, int i, int j)
            {
                if (!loadDataForTabletLandscape) goto _L2; else goto _L1
_L1:
                if (!"line".equals(s)) goto _L4; else goto _L3
_L3:
                j = 10;
_L6:
                return j;
_L4:
                if ("grid".equals(s))
                {
                    return 20;
                }
                if ("collage".equals(s))
                {
                    return 12;
                }
_L2:
                if (!"grid".equals(s))
                {
                    return i;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public final CardCollectionResponse parse(InputStream inputstream)
            {
                Object obj;
                int l;
                obj = new JSONObject(StringParser.instance().parse(inputstream));
                inputstream = new CardCollectionResponse();
                inputstream.status = ((JSONObject) (obj)).optString("status");
                inputstream.items = new ArrayList();
                obj = ((JSONObject) (obj)).optJSONArray("response");
                if (obj == null)
                {
                    return inputstream;
                }
                l = 0;
_L2:
                Object obj1;
                Card card;
                Object obj2;
                {
                    if (l >= ((JSONArray) (obj)).length())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    JSONArray jsonarray;
                    int i;
                    try
                    {
                        obj2 = ((JSONArray) (obj)).getJSONObject(l);
                        break MISSING_BLOCK_LABEL_77;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        ((JSONException) (obj1)).printStackTrace();
                    }
                }
_L4:
                l++;
                if (true) goto _L2; else goto _L1
                obj1 = ((JSONObject) (obj2)).optString("type");
                if (!Card.SUPPORTED_CARDS.contains(obj1))
                {
                    break MISSING_BLOCK_LABEL_400;
                }
                card = new Card();
                ((CardCollectionResponse) (inputstream)).items.add(card);
                card.type = ((String) (obj1));
                card.title = ((JSONObject) (obj2)).optString("title");
                card.id = ((JSONObject) (obj2)).optString("id");
                card.index = ((JSONObject) (obj2)).optString("index");
                card.subtitle = ((JSONObject) (obj2)).optString("subtitle");
                card.key = ((JSONObject) (obj2)).optString("key");
                card.renderType = ((JSONObject) (obj2)).optString("render_type");
                card.icon = ((JSONObject) (obj2)).optString("icon");
                card.footerTitle = ((JSONObject) (obj2)).optString("footer_title");
                card.action = ((JSONObject) (obj2)).optString("action");
                card.content = ((JSONObject) (obj2)).optString("content");
                card.messageTitle = ((JSONObject) (obj2)).optString("message_title");
                card.message = ((JSONObject) (obj2)).optString("message");
                card.contentUrl = ((JSONObject) (obj2)).optString("content_url");
                card.proportion = ((JSONObject) (obj2)).optDouble("proportion", 0.5D);
                card.rows = ((JSONObject) (obj2)).optInt("rows");
                card.messageTitleRows = ((JSONObject) (obj2)).optInt("message_title_rows");
                card.full_screen = ((JSONObject) (obj2)).optBoolean("full_screen");
                jsonarray = ((JSONObject) (obj2)).optJSONArray("tags");
                if (jsonarray != null)
                {
                    card.card_tags = new String[jsonarray.length()];
                    i = 0;
                    while (i < jsonarray.length()) 
                    {
                        try
                        {
                            card.card_tags[i] = jsonarray.getString(i);
                        }
                        catch (JSONException jsonexception)
                        {
                            jsonexception.printStackTrace();
                        }
                        i++;
                    }
                }
                obj2 = ((JSONObject) (obj2)).optJSONArray("data");
                if (obj2 == null) goto _L4; else goto _L3
_L3:
                int i1;
                int j1;
                i1 = ((JSONArray) (obj2)).length();
                if (i1 > 3 && ("user_card".equals(obj1) || "tag_card".equals(obj1)))
                {
                    i1 = 3;
                }
                j1 = 0;
_L16:
                if (j1 >= i1) goto _L4; else goto _L5
_L5:
                Object obj3 = ((JSONArray) (obj2)).getJSONObject(j1);
                byte byte0 = -1;
                ((String) (obj1)).hashCode();
                JVM INSTR lookupswitch 4: default 536
            //                           -1907339197: 632
            //                           -764337003: 617
            //                           -508099331: 587
            //                           339013380: 602;
                   goto _L6 _L7 _L8 _L9 _L10
_L6:
                byte0;
                JVM INSTR tableswitch 0 3: default 568
            //                           0 647
            //                           1 712
            //                           2 835
            //                           3 959;
                   goto _L11 _L12 _L13 _L14 _L15
_L11:
                j1++;
                  goto _L16
                obj3;
                ((JSONException) (obj3)).printStackTrace();
                  goto _L11
_L9:
                if (((String) (obj1)).equals("photo_card"))
                {
                    byte0 = 0;
                }
                  goto _L6
_L10:
                if (((String) (obj1)).equals("user_card"))
                {
                    byte0 = 1;
                }
                  goto _L6
_L8:
                if (((String) (obj1)).equals("tag_card"))
                {
                    byte0 = 2;
                }
                  goto _L6
_L7:
                if (((String) (obj1)).equals("banner_card"))
                {
                    byte0 = 3;
                }
                  goto _L6
_L12:
                if (j1 >= getMaxPhotosCount(card.renderType, 15, 16)) goto _L4; else goto _L17
_L17:
                obj3 = (ImageItem)c.a().fromJson(((JSONObject) (obj3)).toString(), com/socialin/android/apiv3/model/ImageItem);
                card.photos.add(obj3);
                card.data.add(obj3);
                  goto _L11
_L13:
                obj3 = (ViewerUser)c.a().fromJson(((JSONObject) (obj3)).toString(), com/socialin/android/apiv3/model/ViewerUser);
                if (((ViewerUser) (obj3)).photos != null)
                {
                    Iterator iterator = ((ViewerUser) (obj3)).photos.iterator();
                    int j = 0;
                    while (iterator.hasNext()) 
                    {
                        iterator.next();
                        if (j >= getMaxPhotosCount(card.renderType, 10, 10))
                        {
                            iterator.remove();
                        } else
                        {
                            j++;
                        }
                    }
                }
                card.users.add(obj3);
                card.data.add(obj3);
                  goto _L11
_L14:
                obj3 = (Tag)c.a().fromJson(((JSONObject) (obj3)).toString(), com/socialin/android/apiv3/model/Tag);
                if (((Tag) (obj3)).items != null)
                {
                    Iterator iterator1 = ((Tag) (obj3)).items.iterator();
                    int k = 0;
                    while (iterator1.hasNext()) 
                    {
                        iterator1.next();
                        if (k >= getMaxPhotosCount(card.renderType, 15, 16))
                        {
                            iterator1.remove();
                        } else
                        {
                            k++;
                        }
                    }
                }
                card.tags.add(obj3);
                card.data.add(obj3);
                  goto _L11
_L15:
                obj3 = (BannerItem)c.a().fromJson(((JSONObject) (obj3)).toString(), com/socialin/android/apiv3/model/BannerItem);
                card.banners.add(obj3);
                card.data.add(obj3);
                  goto _L11
_L1:
                return inputstream;
                  goto _L6
            }

            public final volatile Object parse(InputStream inputstream)
            {
                return parse(inputstream);
            }

            
            {
                loadDataForTabletLandscape = flag;
                super();
            }
        };
    }

    public static IStreamParser createSimpleResponseParser(final Class clazz)
    {
        return new IStreamParser() {

            final Class val$clazz;

            public final Object parse(InputStream inputstream)
            {
                Object obj = "";
                try
                {
                    inputstream = (new Scanner(inputstream, "UTF-8")).useDelimiter("\\A").next();
                }
                // Misplaced declaration of an exception variable
                catch (InputStream inputstream)
                {
                    ExceptionReportService.sendStackTrace("http://t27.socialin.com/services/exception.php", "SocialInGames2011", "", "", "", android.os.Build.VERSION.RELEASE, inputstream.getMessage(), true, ((String) (obj)));
                    throw new Exception((new StringBuilder("Unable to deserialize class ")).append(clazz.getName()).append("  ").append(inputstream.getMessage()).toString());
                }
                obj = inputstream;
                inputstream = ((InputStream) (c.a().fromJson(inputstream, clazz)));
                return inputstream;
            }

            
            {
                clazz = class1;
                super();
            }
        };
    }
}
