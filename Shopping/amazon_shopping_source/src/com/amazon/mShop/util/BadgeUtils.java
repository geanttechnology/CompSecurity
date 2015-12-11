// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.rio.j2me.client.services.mShop.Badge;
import com.amazon.rio.j2me.client.services.mShop.BadgeInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.RichMessage;
import com.amazon.rio.j2me.client.services.mShop.TextAttributes;
import com.amazon.rio.j2me.client.services.mShop.UniversalLink;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.util:
//            Util, UIUtils

public class BadgeUtils
{

    private static Map sBadgeImagesMap = new HashMap();

    public BadgeUtils()
    {
    }

    public static void addBadgeBitampToCache(String s, Bitmap bitmap)
    {
        sBadgeImagesMap.put(s, bitmap);
    }

    public static void clearCachedBadge()
    {
        sBadgeImagesMap.clear();
    }

    public static String getBadgeImageUrl(Badge badge)
    {
        if (badge != null && hasBadgeUrl(badge))
        {
            return badge.getMeta().getImageLink().getUrl();
        } else
        {
            return null;
        }
    }

    public static Bitmap getCachedBadge(String s)
    {
        if (!Util.isEmpty(s))
        {
            return (Bitmap)sBadgeImagesMap.get(s);
        } else
        {
            return null;
        }
    }

    public static String getUrlLinkFromRichMessage(RichMessage richmessage)
    {
label0:
        {
            if (richmessage == null)
            {
                break label0;
            }
            richmessage = richmessage.getMessages();
            if (Util.isEmpty(richmessage))
            {
                break label0;
            }
            richmessage = richmessage.iterator();
            HyperText hypertext;
            do
            {
                if (!richmessage.hasNext())
                {
                    break label0;
                }
                hypertext = (HyperText)richmessage.next();
            } while (hypertext.getAttributes() == null || hypertext.getAttributes().getLinkUrl() == null);
            return hypertext.getAttributes().getLinkUrl();
        }
        return null;
    }

    public static boolean hasBadgeDefaultHyperText(Badge badge)
    {
        return badge != null && badge.getMeta() != null && !Util.isEmpty(badge.getMeta().getMessages());
    }

    public static boolean hasBadgeUrl(Badge badge)
    {
        return badge != null && badge.getMeta() != null && badge.getMeta().getImageLink() != null && !Util.isEmpty(badge.getMeta().getImageLink().getUrl());
    }

    public static boolean isContainedBadge(BasicOfferListing basicofferlisting)
    {
        return basicofferlisting != null && basicofferlisting.getBadgeInfo() != null && basicofferlisting.getBadgeInfo().getBadge() != null && basicofferlisting.getBadgeInfo().getBadge().getMeta() != null;
    }

    public static void setBadgeItemSpan(SpannableStringBuilder spannablestringbuilder, RichMessage richmessage, AmazonActivity amazonactivity)
    {
        if (spannablestringbuilder != null && richmessage != null)
        {
            ArrayList arraylist = new ArrayList();
            Integer integer = richmessage.getBackgroundColor();
            if (integer != null)
            {
                arraylist.add(integer);
            }
            spannablestringbuilder.append(" ");
            UIUtils.setSpanFromHyperTexts(amazonactivity, spannablestringbuilder, richmessage.getMessages(), arraylist);
        }
    }

    public static void updateAddOnMessage(RichMessage richmessage, TextView textview, AmazonActivity amazonactivity, boolean flag)
    {
        if (richmessage != null && textview != null)
        {
            List list = richmessage.getMessages();
            Object obj = getUrlLinkFromRichMessage(richmessage);
            if (!Util.isEmpty(((String) (obj))))
            {
                textview.setOnClickListener(new android.view.View.OnClickListener(richmessage, amazonactivity, ((String) (obj))) {

                    final AmazonActivity val$activity;
                    final String val$linkUrl;
                    final RichMessage val$richMessage;

                    public void onClick(View view)
                    {
                        view = (HyperText)richMessage.getMessages().get(0);
                        if (view != null)
                        {
                            activity.pushView(new AmazonBrandedWebView(activity, linkUrl, view.getText()));
                            return;
                        } else
                        {
                            activity.pushView(new AmazonBrandedWebView(activity, linkUrl, null));
                            return;
                        }
                    }

            
            {
                richMessage = richmessage;
                activity = amazonactivity;
                linkUrl = s;
                super();
            }
                });
            }
            if (richmessage.getMessages().size() > 2)
            {
                richmessage.getMessages().remove(richmessage.getMessages().size() - 1);
            }
            for (obj = list.iterator(); ((Iterator) (obj)).hasNext(); ((HyperText)((Iterator) (obj)).next()).setLineBreak(true)) { }
            obj = amazonactivity.getResources();
            StateListDrawable statelistdrawable = new StateListDrawable();
            Drawable drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.orange_outline_sharp_corner);
            statelistdrawable.addState(new int[] {
                0x10100a7
            }, drawable);
            drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.orange_outline_sharp_corner);
            statelistdrawable.addState(new int[] {
                0x101009c
            }, drawable);
            drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.orange_outline_sharp_corner);
            statelistdrawable.addState(new int[] {
                0x10100a1
            }, drawable);
            richmessage = richmessage.getBackgroundColor();
            if (richmessage != null)
            {
                richmessage = new ColorDrawable(Integer.valueOf(richmessage.intValue() | 0xff000000).intValue());
                statelistdrawable.addState(new int[0], richmessage);
            }
            richmessage = new StateListDrawable();
            int i;
            if (flag)
            {
                drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_normal);
                richmessage.addState(new int[] {
                    0xfefeff63, 0x101009e
                }, drawable);
            } else
            {
                Drawable drawable1 = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_addon);
                richmessage.addState(new int[] {
                    0xfefeff63, 0x101009e
                }, drawable1);
            }
            drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_disabled);
            richmessage.addState(new int[] {
                0xfefeff63, 0xfefeff62
            }, drawable);
            drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_selected);
            richmessage.addState(new int[] {
                0x10100a7
            }, drawable);
            drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_selected);
            richmessage.addState(new int[] {
                0x101009c, 0x101009e
            }, drawable);
            if (flag)
            {
                drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_normal);
                richmessage.addState(new int[] {
                    0x101009e
                }, drawable);
            } else
            {
                Drawable drawable2 = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_addon);
                richmessage.addState(new int[] {
                    0x101009e
                }, drawable2);
            }
            drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_disabled);
            richmessage.addState(new int[] {
                0x101009c
            }, drawable);
            drawable = ((Resources) (obj)).getDrawable(com.amazon.mShop.android.lib.R.drawable.arrow_right_disabled);
            richmessage.addState(new int[0], drawable);
            UIUtils.setHyperTexts(textview, amazonactivity, list);
            textview.setBackgroundDrawable(new LayerDrawable(new Drawable[] {
                statelistdrawable, richmessage
            }));
            i = ((Resources) (obj)).getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding);
            textview.setPadding(i, i, ((Resources) (obj)).getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding_icon_selector_right), i);
        }
    }

    public static void updateAddOnMessageBlocks(ViewGroup viewgroup, BasicOfferListing basicofferlisting, AmazonActivity amazonactivity)
    {
        updateDetailedAddOnMessage(viewgroup, basicofferlisting, amazonactivity);
        updateProminentAddOnMessage(viewgroup, basicofferlisting, amazonactivity);
    }

    public static void updateAddOnProminentMessageTextColor(TextView textview)
    {
        if (textview != null)
        {
            android.content.res.ColorStateList colorstatelist = textview.getResources().getColorStateList(com.amazon.mShop.android.lib.R.color.add_on_prominent_message_text_selector);
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(textview.getText());
            spannablestringbuilder.setSpan(new TextAppearanceSpan(null, 0, 0, colorstatelist, colorstatelist), 0, spannablestringbuilder.length(), 33);
            textview.setText(spannablestringbuilder);
        }
    }

    public static void updateDetailedAddOnMessage(ViewGroup viewgroup, BasicOfferListing basicofferlisting, AmazonActivity amazonactivity)
    {
        TextView textview;
        textview = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.add_on_detailed_message);
        viewgroup = viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.add_on_detailed_message_block_separator);
        if (!ProductController.isEligibleForAddOnItem(basicofferlisting)) goto _L2; else goto _L1
_L1:
        basicofferlisting = basicofferlisting.getBadgeInfo().getDetailedMessage();
        if (basicofferlisting == null) goto _L4; else goto _L3
_L3:
        updateAddOnMessage(basicofferlisting, textview, amazonactivity, true);
        textview.setVisibility(0);
        if (viewgroup != null)
        {
            viewgroup.setVisibility(0);
        }
_L6:
        return;
_L4:
        textview.setVisibility(8);
        viewgroup.setVisibility(8);
        return;
_L2:
        textview.setVisibility(8);
        if (viewgroup != null)
        {
            viewgroup.setVisibility(8);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void updateProminentAddOnMessage(ViewGroup viewgroup, BasicOfferListing basicofferlisting, AmazonActivity amazonactivity)
    {
        viewgroup = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.add_on_prominent_message);
        if (ProductController.isEligibleForAddOnItem(basicofferlisting))
        {
            basicofferlisting = basicofferlisting.getBadgeInfo().getProminentMessage();
            if (basicofferlisting != null)
            {
                updateAddOnMessage(basicofferlisting, viewgroup, amazonactivity, false);
                updateAddOnProminentMessageTextColor(viewgroup);
                viewgroup.setVisibility(0);
                return;
            } else
            {
                viewgroup.setVisibility(8);
                return;
            }
        } else
        {
            viewgroup.setVisibility(8);
            return;
        }
    }

}
