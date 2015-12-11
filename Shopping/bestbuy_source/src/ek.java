// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPOverviewDetailListFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.home.ImageType;
import com.bestbuy.android.api.lib.models.pdp.BonusContent;
import com.bestbuy.android.api.lib.models.pdp.Feature;
import com.bestbuy.android.api.lib.models.pdp.IncludedItem;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.SoftWareDetails;
import com.bestbuy.android.api.lib.models.pdp.Specification;
import com.bestbuy.android.api.lib.models.pdp.Track;
import com.bestbuy.android.api.lib.models.pdp.TrackInfo;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CastAndCrew;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CastMember;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CharacterName;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CrewMember;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.Person;
import com.bestbuy.android.api.lib.models.pdp.episodes.Episode;
import com.bestbuy.android.api.lib.models.pdp.games.GameDetails;
import com.bestbuy.android.api.lib.models.pdp.protectionservices.Column;
import com.bestbuy.android.api.lib.models.pdp.protectionservices.Common;
import com.bestbuy.android.api.lib.models.pdp.protectionservices.ConditionalFeature;
import com.bestbuy.android.api.lib.models.pdp.protectionservices.ProtectionServiceMatrix;
import com.bestbuy.android.api.lib.models.pdp.protectionservices.Term;
import com.bestbuy.android.api.lib.models.pdpmovies.MovieDetails;
import com.bestbuy.android.api.lib.models.pdpmovies.MovieLink;
import com.bestbuy.android.api.lib.models.pdpmovies.MovieSpecifications;
import com.bestbuy.android.api.lib.models.pdpmusic.MusicDetails;
import com.bestbuy.android.api.lib.models.pdpmusic.MusicResponse;
import com.bestbuy.android.api.lib.models.pdpmusic.MusicSpecifications;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Descriptions;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.List;

public class ek extends BaseExpandableListAdapter
{

    private ArrayList a;
    private Context b;
    private OverviewResponse c;
    private LayoutInflater d;
    private ExpandableListView e;
    private PDPOverviewDetailListFragment f;
    private int g;

    public ek(PDPOverviewDetailListFragment pdpoverviewdetaillistfragment, ExpandableListView expandablelistview, Context context, OverviewResponse overviewresponse, ArrayList arraylist)
    {
        g = -1;
        f = pdpoverviewdetaillistfragment;
        e = expandablelistview;
        b = context;
        c = overviewresponse;
        a = arraylist;
        d = (LayoutInflater)b.getSystemService("layout_inflater");
    }

    static Context a(ek ek1)
    {
        return ek1.b;
    }

    static void a(ek ek1, String s)
    {
        ek1.a(s);
    }

    private void a(String s)
    {
        MdotWebFragment mdotwebfragment = new MdotWebFragment(true, true);
        Bundle bundle = new Bundle();
        bundle.putString(b.getResources().getString(0x7f080055), s);
        mdotwebfragment.setArguments(bundle);
        ((PDPFragmentContainer)f.getParentFragment()).a(mdotwebfragment, true);
    }

    public Object getChild(int i, int j)
    {
        int k = 0;
        Object obj = (String)a.get(i);
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802b8)))
        {
            if (c.getDescriptions() != null && c.getDescriptions().getLongDesc() != null && c.getDescriptions().getLongDesc().length() > 0)
            {
                return Html.fromHtml(c.getDescriptions().getLongDesc()).toString();
            } else
            {
                return Html.fromHtml(c.getDescriptions().getShortDesc()).toString();
            }
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802bf)))
        {
            return c.getDescriptions().getSynopsis();
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802b9)))
        {
            return c.getFeatures().get(j);
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802ba)))
        {
            return c.getIncludedItems().get(j);
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802be)))
        {
            return c.getSpecifications().get(j);
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802bd)))
        {
            if (j < c.getProtectionServiceMatrix().getConditionalFeatures().size() + 1)
            {
                return c.getProtectionServiceMatrix().getConditionalFeatures().get(j - 1);
            }
            if (j < c.getProtectionServiceMatrix().getConditionalFeatures().size() + c.getProtectionServiceMatrix().getCommonFeatures().size() + 2)
            {
                return c.getProtectionServiceMatrix().getCommonFeatures().get(j - c.getProtectionServiceMatrix().getConditionalFeatures().size() - 2);
            }
            if (j < c.getProtectionServiceMatrix().getConditionalFeatures().size() + c.getProtectionServiceMatrix().getCommonFeatures().size() + c.getProtectionServiceMatrix().getTerms().size() + 3)
            {
                return c.getProtectionServiceMatrix().getTerms().get(j - c.getProtectionServiceMatrix().getConditionalFeatures().size() - c.getProtectionServiceMatrix().getCommonFeatures().size() - 3);
            }
        } else
        {
            if (((String) (obj)).equals(b.getResources().getString(0x7f08023b)))
            {
                return c.getMovieDetails().getSpecifications().get(j);
            }
            if (((String) (obj)).equals(b.getResources().getString(0x7f08018f)))
            {
                return c.getEpisodesList().get(j);
            }
            if (((String) (obj)).equals(b.getResources().getString(0x7f08032e)))
            {
                return c.getSpecialFeatures().get(j);
            }
            if (((String) (obj)).equals(b.getResources().getString(0x7f0800ee)))
            {
                Object obj1 = c.getCastAndCrew();
                int l;
                int i1;
                int j1;
                int k1;
                int l1;
                int i2;
                if (obj1 != null)
                {
                    obj = ((CastAndCrew) (obj1)).getCastMembers();
                } else
                {
                    obj = null;
                }
                if (obj1 != null)
                {
                    obj1 = ((CastAndCrew) (obj1)).getCrewMembers();
                } else
                {
                    obj1 = null;
                }
                if (obj != null)
                {
                    i1 = ((List) (obj)).size();
                } else
                {
                    i1 = 0;
                }
                if (obj1 != null && ((CrewMember) (obj1)).getWriters() != null)
                {
                    j1 = ((CrewMember) (obj1)).getWriters().size();
                } else
                {
                    j1 = 0;
                }
                if (obj1 != null && ((CrewMember) (obj1)).getDirectors() != null)
                {
                    k1 = ((CrewMember) (obj1)).getDirectors().size();
                } else
                {
                    k1 = 0;
                }
                if (obj1 != null && ((CrewMember) (obj1)).getOtherCrew() != null)
                {
                    l1 = ((CrewMember) (obj1)).getOtherCrew().size();
                } else
                {
                    l1 = 0;
                }
                i = k;
                if (i1 > 0)
                {
                    i = 1;
                }
                if (j1 > 0)
                {
                    k = i + 1;
                } else
                {
                    k = i;
                }
                if (k1 > 0)
                {
                    l = k + 1;
                } else
                {
                    l = k;
                }
                if (l1 > 0)
                {
                    i2 = l + 1;
                } else
                {
                    i2 = l;
                }
                if (i1 > 0 && j < i1 + i)
                {
                    return c.getCastAndCrew().getCastMembers().get(j - i);
                }
                if (j1 > 0 && j < i1 + j1 + k)
                {
                    return c.getCastAndCrew().getCrewMembers().getWriters().get(j - i1 - k);
                }
                if (k1 > 0 && j < i1 + j1 + k1 + l)
                {
                    return c.getCastAndCrew().getCrewMembers().getDirectors().get(j - i1 - j1 - l);
                }
                if (l1 > 0 && j < i1 + j1 + k1 + l1 + i2)
                {
                    return c.getCastAndCrew().getCrewMembers().getOtherCrew().get(j - i1 - j1 - k1 - i2);
                }
            } else
            {
                if (((String) (obj)).equals(b.getResources().getString(0x7f080241)))
                {
                    return c.getMusicResponse().getMusicDetails().getSpecifications().get(j);
                }
                if (((String) (obj)).equals(b.getResources().getString(0x7f08032a)))
                {
                    if (c != null && c.getTrackInfo() != null && c.getTrackInfo().size() > 0 && ((TrackInfo)c.getTrackInfo().get(0)).getTracks() != null)
                    {
                        return ((TrackInfo)c.getTrackInfo().get(0)).getTracks().get(j);
                    }
                } else
                {
                    if (((String) (obj)).equals(b.getResources().getString(0x7f080327)))
                    {
                        return c.getSoftwareDetails().getSpecifications().get(j);
                    }
                    if (((String) (obj)).equals(b.getResources().getString(0x7f0801b3)))
                    {
                        return c.getGameDetails().getSpecifications().get(j);
                    }
                    if (((String) (obj)).equals(b.getResources().getString(0x7f0801b0)))
                    {
                        return c.getBonusContent().get(j);
                    }
                }
            }
        }
        return null;
    }

    public long getChildId(int i, int j)
    {
        return (long)j;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        Object obj = (String)getGroup(i);
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802b8)))
        {
            view = d.inflate(0x7f03009a, viewgroup, false);
            obj = ((String)getChild(i, j)).replaceAll("[^a-z\\sA-Z0-9!@#$%^&*()-_=:.;{[}]|'?/<,>/\"\\+]", "");
            viewgroup = (WebView)view.findViewById(0x7f0c024d);
            WebSettings websettings = viewgroup.getSettings();
            websettings.setDefaultFontSize(13);
            websettings.setDefaultTextEncodingName("utf-8");
            obj = ((String) (obj)).replaceAll("<a.*?>|</a>", "").replaceAll("<img.*?>", "");
            viewgroup.loadData((new StringBuilder()).append("<html><head><style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/fonts/Roboto-Regular.ttf\")}body {color: #49494A; background-color: #ffffff; font-family: MyFont;font-size: 13;text-align: justify;}</style></head><body>").append(((String) (obj))).append("</body></html>").toString(), "text/html", "UTF-8");
            return view;
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802bf)))
        {
            obj = d.inflate(0x7f03009b, viewgroup, false);
            view = (String)getChild(i, j);
            BBYTextView bbytextview = (BBYTextView)((View) (obj)).findViewById(0x7f0c024c);
            viewgroup = Html.fromHtml(view).toString().replaceAll("[^a-z\\sA-Z0-9!@#$%^&*()-_=:.;{[}]|'?/<,>/\"\\+]", "");
            i = viewgroup.lastIndexOf('.');
            view = viewgroup;
            if (i != -1)
            {
                view = viewgroup.substring(0, i + 1);
            }
            bbytextview.setText(view);
            return ((View) (obj));
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802b9)))
        {
            obj = d.inflate(0x7f030098, viewgroup, false);
            Object obj1 = (Feature)getChild(i, j);
            viewgroup = new String();
            Object obj2;
            BBYTextView bbytextview1;
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            int l1;
            int i2;
            if (((Feature) (obj1)).getTitle() != null)
            {
                view = Html.fromHtml(((Feature) (obj1)).getTitle()).toString();
            } else
            {
                view = "";
            }
            if (((Feature) (obj1)).getDescription() != null)
            {
                viewgroup = Html.fromHtml(((Feature) (obj1)).getDescription()).toString();
            }
            obj2 = (BBYTextView)((View) (obj)).findViewById(0x7f0c0249);
            bbytextview1 = (BBYTextView)((View) (obj)).findViewById(0x7f0c024a);
            if (((Feature) (obj1)).getTitle() != null)
            {
                if (view.length() > 0)
                {
                    ((BBYTextView) (obj2)).setText(view);
                } else
                {
                    ((BBYTextView) (obj2)).setVisibility(8);
                }
            }
            if (((Feature) (obj1)).getDescription() != null)
            {
                if (viewgroup.length() > 0)
                {
                    bbytextview1.setText(viewgroup);
                } else
                {
                    bbytextview1.setVisibility(8);
                }
            }
            return ((View) (obj));
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802ba)))
        {
            view = d.inflate(0x7f030099, viewgroup, false);
            viewgroup = (IncludedItem)getChild(i, j);
            ((BBYTextView)view.findViewById(0x7f0c024c)).setText(Html.fromHtml(viewgroup.getName()).toString());
            return view;
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802be)))
        {
            view = d.inflate(0x7f0300a3, viewgroup, false);
            viewgroup = (Specification)getChild(i, j);
            obj = (BBYTextView)view.findViewById(0x7f0c024c);
            obj1 = (BBYTextView)view.findViewById(0x7f0c024a);
            obj2 = (ImageView)view.findViewById(0x7f0c024f);
            bbytextview1 = (BBYTextView)view.findViewById(0x7f0c0252);
            ((BBYTextView) (obj)).setText(viewgroup.getDisplayName());
            ((BBYTextView) (obj1)).setText(Html.fromHtml(viewgroup.getValue()).toString());
            if (viewgroup.getDefinition() != null && viewgroup.getDefinition().length() > 0)
            {
                ((ImageView) (obj2)).setOnClickListener(new android.view.View.OnClickListener(bbytextview1, viewgroup) {

                    final BBYTextView a;
                    final Specification b;
                    final ek c;

                    public void onClick(View view1)
                    {
                        if (a.isShown())
                        {
                            a.setVisibility(8);
                            return;
                        } else
                        {
                            a.setVisibility(0);
                            a.setText(Html.fromHtml(b.getDefinition()).toString());
                            return;
                        }
                    }

            
            {
                c = ek.this;
                a = bbytextview;
                b = specification;
                super();
            }
                });
                ((ImageView) (obj2)).setVisibility(0);
            }
            return view;
        }
        if (!((String) (obj)).equals(b.getResources().getString(0x7f0802bd))) goto _L2; else goto _L1
_L1:
        if (j != 0) goto _L4; else goto _L3
_L3:
        view = d.inflate(0x7f03009e, viewgroup, false);
        obj = (BBYTextView)view.findViewById(0x7f0c0248);
        viewgroup = (BBYTextView)view.findViewById(0x7f0c024e);
        viewgroup.setTextColor(0x7f0b0008);
        ((BBYTextView) (obj)).setText(b.getResources().getString(0x7f0802c2));
        viewgroup.setVisibility(0);
        if (c.getProtectionServiceMatrix() == null || c.getProtectionServiceMatrix().getConditionalFeatures() == null || ((ConditionalFeature)c.getProtectionServiceMatrix().getConditionalFeatures().get(0)).getColumns() == null) goto _L6; else goto _L5
_L5:
        obj = ((Column)((ConditionalFeature)c.getProtectionServiceMatrix().getConditionalFeatures().get(0)).getColumns().get(0)).getPlanType();
        if (obj == null || !((String) (obj)).equalsIgnoreCase("GSP-R")) goto _L8; else goto _L7
_L7:
        viewgroup.setText("Replacement Plan");
_L6:
        return view;
_L8:
        if (obj != null && ((String) (obj)).equalsIgnoreCase("GSP"))
        {
            viewgroup.setText("Standard Protection Plan");
        } else
        if (obj != null && ((String) (obj)).equalsIgnoreCase("ADH"))
        {
            viewgroup.setText(b.getResources().getString(0x7f080095));
        }
        if (true) goto _L6; else goto _L4
_L4:
        if (c.getProtectionServiceMatrix().getConditionalFeatures().size() + 1 == j)
        {
            view = d.inflate(0x7f03009e, viewgroup, false);
            viewgroup = (BBYTextView)view.findViewById(0x7f0c0248);
            viewgroup.setText(b.getResources().getString(0x7f0802a2));
            viewgroup.setTextColor(0x7f0b0008);
            return view;
        }
        if (c.getProtectionServiceMatrix().getConditionalFeatures().size() + c.getProtectionServiceMatrix().getCommonFeatures().size() + 2 == j)
        {
            view = d.inflate(0x7f03009e, viewgroup, false);
            viewgroup = (BBYTextView)view.findViewById(0x7f0c0248);
            viewgroup.setText(b.getResources().getString(0x7f0800bf));
            viewgroup.setTextColor(0x7f0b0008);
            return view;
        }
        if (j >= c.getProtectionServiceMatrix().getConditionalFeatures().size() + 1) goto _L10; else goto _L9
_L9:
        viewgroup = d.inflate(0x7f03009f, viewgroup, false);
        obj = (ConditionalFeature)getChild(i, j);
        ((BBYTextView)viewgroup.findViewById(0x7f0c024c)).setText(((ConditionalFeature) (obj)).getTitle());
        view = (ImageView)viewgroup.findViewById(0x7f0c0250);
        bbytextview1 = (BBYTextView)viewgroup.findViewById(0x7f0c024a);
        obj1 = (ImageView)viewgroup.findViewById(0x7f0c024f);
        obj2 = (BBYTextView)viewgroup.findViewById(0x7f0c0252);
        if (((ConditionalFeature) (obj)).getTitle() != null && ((ConditionalFeature) (obj)).getTitle().length() > 0 && ((ConditionalFeature) (obj)).getColumns() != null && ((ConditionalFeature) (obj)).getColumns().size() > 0 && ((Column)((ConditionalFeature) (obj)).getColumns().get(0)).getServiceInFeature() != null && ((Column)((ConditionalFeature) (obj)).getColumns().get(0)).getServiceInFeature().equalsIgnoreCase("true"))
        {
            view.setVisibility(0);
        } else
        {
            bbytextview1.setVisibility(0);
        }
        view = viewgroup;
        if (((ConditionalFeature) (obj)).getDescription() != null)
        {
            view = viewgroup;
            if (((ConditionalFeature) (obj)).getDescription().length() > 0)
            {
                ((ImageView) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((BBYTextView) (obj2)), ((ConditionalFeature) (obj))) {

                    final BBYTextView a;
                    final ConditionalFeature b;
                    final ek c;

                    public void onClick(View view1)
                    {
                        if (a.isShown())
                        {
                            a.setVisibility(8);
                            return;
                        } else
                        {
                            a.setVisibility(0);
                            a.setText(Html.fromHtml(b.getDescription()).toString());
                            return;
                        }
                    }

            
            {
                c = ek.this;
                a = bbytextview;
                b = conditionalfeature;
                super();
            }
                });
                ((ImageView) (obj1)).setVisibility(0);
                view = viewgroup;
            }
        }
_L11:
        if (j + 1 == c.getProtectionServiceMatrix().getConditionalFeatures().size() + c.getProtectionServiceMatrix().getCommonFeatures().size() + c.getProtectionServiceMatrix().getTerms().size() + 3)
        {
            viewgroup = (BBYTextView)view.findViewById(0x7f0c0251);
            viewgroup.setText(0x7f08016e);
            viewgroup.setVisibility(0);
        }
        return view;
_L10:
        if (j < c.getProtectionServiceMatrix().getConditionalFeatures().size() + c.getProtectionServiceMatrix().getCommonFeatures().size() + 2)
        {
            viewgroup = d.inflate(0x7f03009f, viewgroup, false);
            obj = (Common)getChild(i, j);
            ((BBYTextView)viewgroup.findViewById(0x7f0c024c)).setText(((Common) (obj)).getTitle());
            view = (ImageView)viewgroup.findViewById(0x7f0c0250);
            bbytextview1 = (BBYTextView)viewgroup.findViewById(0x7f0c024a);
            obj1 = (ImageView)viewgroup.findViewById(0x7f0c024f);
            obj2 = (BBYTextView)viewgroup.findViewById(0x7f0c0252);
            if (((Common) (obj)).getTitle() != null && ((Common) (obj)).getTitle().length() > 0 && ((Common) (obj)).getColumns() != null && ((Common) (obj)).getColumns().size() > 0 && ((Column)((Common) (obj)).getColumns().get(0)).getServiceInFeature() != null && ((Column)((Common) (obj)).getColumns().get(0)).getServiceInFeature().equalsIgnoreCase("true"))
            {
                view.setVisibility(0);
            } else
            {
                bbytextview1.setVisibility(0);
            }
            view = viewgroup;
            if (((Common) (obj)).getDescription() != null)
            {
                view = viewgroup;
                if (((Common) (obj)).getDescription().length() > 0)
                {
                    ((ImageView) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((BBYTextView) (obj2)), ((Common) (obj))) {

                        final BBYTextView a;
                        final Common b;
                        final ek c;

                        public void onClick(View view1)
                        {
                            if (a.isShown())
                            {
                                a.setVisibility(8);
                                return;
                            } else
                            {
                                a.setVisibility(0);
                                a.setText(Html.fromHtml(b.getDescription()).toString());
                                return;
                            }
                        }

            
            {
                c = ek.this;
                a = bbytextview;
                b = common;
                super();
            }
                    });
                    ((ImageView) (obj1)).setVisibility(0);
                    view = viewgroup;
                }
            }
        } else
        if (j < c.getProtectionServiceMatrix().getConditionalFeatures().size() + c.getProtectionServiceMatrix().getCommonFeatures().size() + c.getProtectionServiceMatrix().getTerms().size() + 3)
        {
            view = d.inflate(0x7f03009f, viewgroup, false);
            viewgroup = (Term)getChild(i, j);
            ((BBYTextView)view.findViewById(0x7f0c024c)).setText(viewgroup.getTerm());
            obj = (ImageView)view.findViewById(0x7f0c0250);
            obj1 = (BBYTextView)view.findViewById(0x7f0c024a);
            obj2 = (ImageView)view.findViewById(0x7f0c024f);
            obj2 = (BBYTextView)view.findViewById(0x7f0c0252);
            if (viewgroup.getTerm() != null && viewgroup.getTerm().length() > 0 && viewgroup.getColumns() != null && viewgroup.getColumns().size() > 0 && ((Column)viewgroup.getColumns().get(0)).getServiceInFeature() != null && ((Column)viewgroup.getColumns().get(0)).getServiceInFeature().equalsIgnoreCase("true"))
            {
                ((ImageView) (obj)).setVisibility(0);
            } else
            {
                ((BBYTextView) (obj1)).setText((new StringBuilder()).append("$").append(((Column)viewgroup.getColumns().get(0)).getPrice()).toString());
                ((BBYTextView) (obj1)).setVisibility(0);
            }
        }
        if (true) goto _L11; else goto _L2
_L2:
        if (((String) (obj)).equals(b.getResources().getString(0x7f08023b)))
        {
            view = d.inflate(0x7f03009c, viewgroup, false);
            viewgroup = (MovieSpecifications)getChild(i, j);
            obj = (BBYTextView)view.findViewById(0x7f0c024c);
            obj1 = (BBYTextView)view.findViewById(0x7f0c024a);
            if (viewgroup != null && viewgroup.getLink() != null && viewgroup.getLink().getUrl() != null && viewgroup.getLink().getUrl().length() > 0)
            {
                ((BBYTextView) (obj)).setText(viewgroup.getDisplayName());
                ((BBYTextView) (obj1)).setText(viewgroup.getValue());
                ((BBYTextView) (obj1)).setTextColor(b.getResources().getColor(0x7f0b0000));
                ((BBYTextView) (obj1)).setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

                    final MovieSpecifications a;
                    final ek b;

                    public void onClick(View view1)
                    {
                        ek.a(b, (new StringBuilder()).append("http://www.bestbuy.com").append(a.getLink().getUrl()).toString());
                    }

            
            {
                b = ek.this;
                a = moviespecifications;
                super();
            }
                });
            } else
            {
                ((BBYTextView) (obj)).setText(viewgroup.getDisplayName());
                ((BBYTextView) (obj1)).setText(Html.fromHtml(viewgroup.getValue()).toString());
            }
            return view;
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f08018f)))
        {
            view = d.inflate(0x7f0300a6, viewgroup, false);
            viewgroup = (Episode)getChild(i, j);
            ((BBYTextView)view.findViewById(0x7f0c024c)).setText(viewgroup.getDisplayName());
            return view;
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f08032e)))
        {
            view = d.inflate(0x7f0300a2, viewgroup, false);
            viewgroup = ((Specification)getChild(i, j)).getValue();
            ((BBYTextView)view.findViewById(0x7f0c024c)).setText(Html.fromHtml(viewgroup).toString());
            return view;
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0800ee)))
        {
            obj = c.getCastAndCrew();
            if (obj != null)
            {
                view = ((CastAndCrew) (obj)).getCastMembers();
            } else
            {
                view = null;
            }
            if (obj != null)
            {
                obj = ((CastAndCrew) (obj)).getCrewMembers();
            } else
            {
                obj = null;
            }
            if (view != null)
            {
                i1 = view.size();
            } else
            {
                i1 = 0;
            }
            if (obj != null && ((CrewMember) (obj)).getWriters() != null)
            {
                j1 = ((CrewMember) (obj)).getWriters().size();
            } else
            {
                j1 = 0;
            }
            if (obj != null && ((CrewMember) (obj)).getDirectors() != null)
            {
                k1 = ((CrewMember) (obj)).getDirectors().size();
            } else
            {
                k1 = 0;
            }
            if (obj != null && ((CrewMember) (obj)).getOtherCrew() != null)
            {
                l1 = ((CrewMember) (obj)).getOtherCrew().size();
            } else
            {
                l1 = 0;
            }
            if (i1 > 0)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (j1 > 0)
            {
                l = k + 1;
            } else
            {
                l = k;
            }
            if (k1 > 0)
            {
                i2 = l + 1;
            } else
            {
                i2 = l;
            }
            if (i1 > 0 && j == 0)
            {
                view = d.inflate(0x7f030097, viewgroup, false);
                ((BBYTextView)view.findViewById(0x7f0c0248)).setText("Cast Member");
                return view;
            }
            if (j1 > 0 && i1 + k == j)
            {
                view = d.inflate(0x7f030097, viewgroup, false);
                ((BBYTextView)view.findViewById(0x7f0c0248)).setText("Writers");
                return view;
            }
            if (k1 > 0 && i1 + j1 + l == j)
            {
                view = d.inflate(0x7f030097, viewgroup, false);
                ((BBYTextView)view.findViewById(0x7f0c0248)).setText("Director");
                return view;
            }
            if (l1 > 0 && i1 + j1 + k1 + i2 == j)
            {
                view = d.inflate(0x7f030097, viewgroup, false);
                ((BBYTextView)view.findViewById(0x7f0c0248)).setText("Other Crew");
                return view;
            }
            view = d.inflate(0x7f030096, viewgroup, false);
            if (i1 > 0 && j < k + i1)
            {
                viewgroup = (CastMember)getChild(i, j);
                obj = (BBYTextView)view.findViewById(0x7f0c0245);
                obj1 = (BBYTextView)view.findViewById(0x7f0c0246);
                obj2 = (ImageView)view.findViewById(0x7f0c0247);
                if (viewgroup.getHeadshotImage() != null && viewgroup.getHeadshotImage().getUrl() != null)
                {
                    ng.a(viewgroup.getHeadshotImage().getUrl(), ((ImageView) (obj2)), false);
                    ((ImageView) (obj2)).setVisibility(0);
                }
                ((BBYTextView) (obj)).setText(viewgroup.getDisplayName());
                if (viewgroup.getCharacterNames() != null && viewgroup.getCharacterNames().size() > 0)
                {
                    ((BBYTextView) (obj1)).setText(((CharacterName)viewgroup.getCharacterNames().get(0)).getDisplayName());
                    ((BBYTextView) (obj1)).setVisibility(0);
                }
                if (viewgroup.getCharacterNames() != null && viewgroup.getCharacterNames().size() > 0 && ((CharacterName)viewgroup.getCharacterNames().get(0)).getDisplayName().equalsIgnoreCase("no char name"))
                {
                    ((BBYTextView) (obj1)).setVisibility(8);
                }
                return view;
            }
            if (j1 > 0 && j < l + (i1 + j1))
            {
                viewgroup = (Person)getChild(i, j);
                ((BBYTextView)view.findViewById(0x7f0c0245)).setText(viewgroup.getDisplayName());
                return view;
            }
            if (k1 > 0 && j < i1 + j1 + k1 + i2)
            {
                viewgroup = (Person)getChild(i, j);
                ((BBYTextView)view.findViewById(0x7f0c0245)).setText(viewgroup.getDisplayName());
                return view;
            }
            if (l1 > 0 && j <= i2 + (i1 + j1 + k1 + l1))
            {
                viewgroup = (Person)getChild(i, j);
                ((BBYTextView)view.findViewById(0x7f0c0245)).setText(viewgroup.getDisplayName());
                if (viewgroup.getRole() != null && viewgroup.getRole().length() > 0)
                {
                    obj = (BBYTextView)view.findViewById(0x7f0c0246);
                    ((BBYTextView) (obj)).setText(viewgroup.getRole());
                    ((BBYTextView) (obj)).setVisibility(0);
                }
            }
            return view;
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f080241)))
        {
            view = d.inflate(0x7f03009d, viewgroup, false);
            viewgroup = (MusicSpecifications)getChild(i, j);
            obj = (BBYTextView)view.findViewById(0x7f0c024c);
            obj1 = (BBYTextView)view.findViewById(0x7f0c024a);
            ((BBYTextView) (obj)).setText(viewgroup.getDisplayName());
            ((BBYTextView) (obj1)).setText(viewgroup.getValue());
            ((BBYTextView) (obj1)).setVisibility(0);
            return view;
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f08032a)))
        {
            view = d.inflate(0x7f03009d, viewgroup, false);
            viewgroup = (Track)getChild(i, j);
            obj = (ImageView)view.findViewById(0x7f0c00c8);
            if (viewgroup.getPlayURL() != null && viewgroup.getPlayURL().length() > 0)
            {
                ((ImageView) (obj)).setVisibility(0);
            }
            obj = (BBYTextView)view.findViewById(0x7f0c024c);
            ((BBYTextView) (obj)).getLayoutParams().width = -2;
            ((BBYTextView) (obj)).setText(viewgroup.getDisplayName());
            view.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

                final Track a;
                final ek b;

                public void onClick(View view1)
                {
                    if (a.getPlayURL() != null && a.getPlayURL().length() > 0)
                    {
                        view1 = Uri.parse(a.getPlayURL());
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(view1, "audio/*");
                        ek.a(b).startActivity(intent);
                    }
                }

            
            {
                b = ek.this;
                a = track;
                super();
            }
            });
            return view;
        }
        if (!((String) (obj)).equals(b.getResources().getString(0x7f080327))) goto _L13; else goto _L12
_L12:
        obj = (Specification)getChild(i, j);
        if (((Specification) (obj)).getValue().length() == 0)
        {
            view = d.inflate(0x7f0300a0, viewgroup, false);
            ((BBYTextView)view.findViewById(0x7f0c0253)).setText(((Specification) (obj)).getDisplayName());
            return view;
        }
        view = d.inflate(0x7f0300a1, viewgroup, false);
        viewgroup = (BBYTextView)view.findViewById(0x7f0c0254);
        obj1 = (BBYTextView)view.findViewById(0x7f0c0255);
        viewgroup.setText(((Specification) (obj)).getDisplayName());
        ((BBYTextView) (obj1)).setText(Html.fromHtml(((Specification) (obj)).getValue()).toString());
_L15:
        return view;
_L13:
        if (!((String) (obj)).equals(b.getResources().getString(0x7f0801b3)))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Specification)getChild(i, j);
        if (((Specification) (obj)).getValue().length() == 0)
        {
            view = d.inflate(0x7f0300a0, viewgroup, false);
            ((BBYTextView)view.findViewById(0x7f0c0253)).setText(((Specification) (obj)).getDisplayName());
            return view;
        }
        view = d.inflate(0x7f0300a1, viewgroup, false);
        viewgroup = (BBYTextView)view.findViewById(0x7f0c0254);
        obj1 = (BBYTextView)view.findViewById(0x7f0c0255);
        viewgroup.setText(((Specification) (obj)).getDisplayName());
        ((BBYTextView) (obj1)).setText(Html.fromHtml(((Specification) (obj)).getValue()).toString());
        if (true) goto _L15; else goto _L14
_L14:
        if (((String) (obj)).equals(b.getResources().getString(0x7f0801b0)))
        {
            viewgroup = d.inflate(0x7f0300a8, viewgroup, false);
            obj = (BonusContent)getChild(i, j);
            view = (BBYTextView)viewgroup.findViewById(0x7f0c0280);
            obj1 = (BBYTextView)viewgroup.findViewById(0x7f0c0281);
            obj2 = (BBYTextView)viewgroup.findViewById(0x7f0c0282);
            view.setText(((BonusContent) (obj)).getDisplayName());
            ((BBYTextView) (obj1)).setText(((BonusContent) (obj)).getDescription());
            ((BBYTextView) (obj2)).setText(((BonusContent) (obj)).getAvailabilityMessage());
            view = viewgroup;
            if (((BonusContent) (obj)).getPrimaryImage() != null)
            {
                view = viewgroup;
                if (((BonusContent) (obj)).getPrimaryImage().getUrl() != null)
                {
                    view = (ImageView)viewgroup.findViewById(0x7f0c027f);
                    ng.a(((BonusContent) (obj)).getPrimaryImage().getUrl(), view, false);
                    view.setVisibility(0);
                    view = viewgroup;
                }
            }
        }
        return view;
    }

    public int getChildrenCount(int i)
    {
        Object obj;
        CrewMember crewmember;
        int j;
        int k;
        boolean flag;
        crewmember = null;
        k = 0;
        flag = false;
        j = 0;
        obj = (String)a.get(i);
        if (!((String) (obj)).equals(b.getResources().getString(0x7f0802b8))) goto _L2; else goto _L1
_L1:
        i = 1;
_L4:
        return i;
_L2:
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802bf)))
        {
            return 1;
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802b9)))
        {
            return c.getFeatures().size();
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802ba)))
        {
            return c.getIncludedItems().size();
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0802be)))
        {
            return c.getSpecifications().size();
        }
        if (!((String) (obj)).equals(b.getResources().getString(0x7f0802bd)))
        {
            break MISSING_BLOCK_LABEL_351;
        }
        i = j;
        if (c.getProtectionServiceMatrix() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (c.getProtectionServiceMatrix().getCommonFeatures() != null || c.getProtectionServiceMatrix().getConditionalFeatures() != null)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (c.getProtectionServiceMatrix().getTerms() == null) goto _L4; else goto _L3
_L3:
        if (c.getProtectionServiceMatrix().getCommonFeatures() != null)
        {
            i = c.getProtectionServiceMatrix().getCommonFeatures().size() + 1;
        } else
        {
            i = 0;
        }
        if (c.getProtectionServiceMatrix().getConditionalFeatures() != null)
        {
            j = c.getProtectionServiceMatrix().getConditionalFeatures().size() + 1;
        } else
        {
            j = 0;
        }
        if (c.getProtectionServiceMatrix().getTerms() != null)
        {
            k = c.getProtectionServiceMatrix().getTerms().size() + 1;
        }
        return k + (i + j);
        if (!((String) (obj)).equals(b.getResources().getString(0x7f08023b)))
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (c.getMovieDetails() != null)
        {
            i = j;
            if (c.getMovieDetails().getSpecifications() != null)
            {
                return c.getMovieDetails().getSpecifications().size();
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (!((String) (obj)).equals(b.getResources().getString(0x7f08018f)))
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (c.getEpisodesList() != null)
        {
            return c.getEpisodesList().size();
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (!((String) (obj)).equals(b.getResources().getString(0x7f08032e)))
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (c.getSpecialFeatures() != null)
        {
            return c.getSpecialFeatures().size();
        }
        if (true) goto _L4; else goto _L7
_L7:
        if (!((String) (obj)).equals(b.getResources().getString(0x7f0800ee)))
        {
            break; /* Loop/switch isn't completed */
        }
        CastAndCrew castandcrew = c.getCastAndCrew();
        if (castandcrew != null)
        {
            obj = castandcrew.getCastMembers();
        } else
        {
            obj = null;
        }
        if (castandcrew != null)
        {
            crewmember = castandcrew.getCrewMembers();
        }
        i = j;
        if (castandcrew != null)
        {
            int l;
            int i1;
            if (obj != null)
            {
                i = ((List) (obj)).size() + 1;
            } else
            {
                i = 0;
            }
            if (crewmember != null && crewmember.getWriters() != null)
            {
                j = crewmember.getWriters().size() + 1;
            } else
            {
                j = 0;
            }
            if (crewmember != null && crewmember.getDirectors() != null)
            {
                l = crewmember.getDirectors().size() + 1;
            } else
            {
                l = 0;
            }
            i1 = ((flag) ? 1 : 0);
            if (crewmember != null)
            {
                i1 = ((flag) ? 1 : 0);
                if (crewmember.getOtherCrew() != null)
                {
                    i1 = crewmember.getOtherCrew().size() + 1;
                }
            }
            return i1 + (l + (i + j));
        }
        if (true) goto _L4; else goto _L8
_L8:
        if (((String) (obj)).equals(b.getResources().getString(0x7f080241)))
        {
            return c.getMusicResponse().getMusicDetails().getSpecifications().size();
        }
        if (!((String) (obj)).equals(b.getResources().getString(0x7f08032a)))
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (c != null)
        {
            i = j;
            if (c.getTrackInfo() != null)
            {
                i = j;
                if (c.getTrackInfo().size() > 0)
                {
                    i = j;
                    if (((TrackInfo)c.getTrackInfo().get(0)).getTracks() != null)
                    {
                        return ((TrackInfo)c.getTrackInfo().get(0)).getTracks().size();
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L9
_L9:
        if (((String) (obj)).equals(b.getResources().getString(0x7f080327)))
        {
            return c.getSoftwareDetails().getSpecifications().size();
        }
        if (((String) (obj)).equals(b.getResources().getString(0x7f0801b3)))
        {
            return c.getGameDetails().getSpecifications().size();
        }
        i = j;
        if (((String) (obj)).equals(b.getResources().getString(0x7f0801b0)))
        {
            return c.getBonusContent().size();
        }
        if (true) goto _L4; else goto _L10
_L10:
    }

    public Object getGroup(int i)
    {
        return a.get(i);
    }

    public int getGroupCount()
    {
        return a.size();
    }

    public long getGroupId(int i)
    {
        return (long)i;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            el el1 = new el();
            view = d.inflate(0x7f0300a5, viewgroup, false);
            el1.a = (BBYTextView)view.findViewById(0x7f0c0258);
            el1.b = (ImageView)view.findViewById(0x7f0c0259);
            view.setTag(el1);
            viewgroup = el1;
        } else
        {
            viewgroup = (el)view.getTag();
        }
        ((el) (viewgroup)).a.setText((String)getGroup(i));
        if (flag)
        {
            ((el) (viewgroup)).b.setImageResource(0x7f020082);
            return view;
        } else
        {
            ((el) (viewgroup)).b.setImageResource(0x7f0200c7);
            return view;
        }
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return false;
    }

    public void onGroupCollapsed(int i)
    {
        if (g == i)
        {
            g = -1;
        }
        e.setDivider(b.getResources().getDrawable(0x7f0b0009));
        e.setChildDivider(b.getResources().getDrawable(0x7f0b0009));
        e.setDividerHeight(1);
    }

    public void onGroupExpanded(int i)
    {
        if (g == -1)
        {
            g = i;
        } else
        {
            e.collapseGroup(g);
            g = i;
        }
        if (((String)a.get(i)).equals(b.getResources().getString(0x7f0802b9)) || ((String)a.get(i)).equals(b.getResources().getString(0x7f0802ba)) || ((String)a.get(i)).equals(b.getResources().getString(0x7f08032e)) || ((String)a.get(i)).equals(b.getResources().getString(0x7f0801b0)))
        {
            e.setDivider(b.getResources().getDrawable(0x7f0b0009));
            e.setChildDivider(b.getResources().getDrawable(0x7f0b004f));
            e.setDividerHeight(1);
            return;
        } else
        {
            e.setDivider(b.getResources().getDrawable(0x7f0b0009));
            e.setChildDivider(b.getResources().getDrawable(0x7f0b0009));
            e.setDividerHeight(1);
            return;
        }
    }
}
