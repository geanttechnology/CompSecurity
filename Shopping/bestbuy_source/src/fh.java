// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class fh extends ArrayAdapter
{

    private ArrayList a;
    private ArrayList b;
    private Context c;
    private LayoutInflater d;
    private nb e;

    public fh(Context context, int i, ArrayList arraylist, ArrayList arraylist1, nb nb)
    {
        super(context, i, arraylist);
        a = arraylist;
        b = arraylist1;
        c = context;
        e = nb;
        if (context != null)
        {
            d = LayoutInflater.from(context);
        }
    }

    static Context a(fh fh1)
    {
        return fh1.c;
    }

    private String a(String s)
    {
        String s1;
        try
        {
            double d1 = Double.parseDouble(s);
            s1 = (new DecimalFormat("###,###,###.##")).format(Double.valueOf(d1));
        }
        catch (Exception exception)
        {
            return s;
        }
        return s1;
    }

    private void a(Uri uri, String s)
    {
        (new kw(c, uri, s)).show();
    }

    static void a(fh fh1, Uri uri, String s)
    {
        fh1.a(uri, s);
    }

    static nb b(fh fh1)
    {
        return fh1.e;
    }

    public int a(BBYProduct bbyproduct)
    {
        return a.indexOf(bbyproduct);
    }

    public int getCount()
    {
        return a.size();
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public int getPosition(Object obj)
    {
        return a((BBYProduct)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
label0:
        {
label1:
            {
label2:
                {
                    float f;
                    float f1;
                    fi fi1;
                    View view1;
                    Summary summary;
                    Object obj;
                    String s;
                    if (view == null)
                    {
                        fi1 = new fi();
                        view1 = d.inflate(0x7f030031, viewgroup, false);
                        fi1.a = (BBYTextView)view1.findViewById(0x7f0c00c9);
                        fi1.b = (ImageView)view1.findViewById(0x7f0c00c8);
                        fi1.c = (RatingBar)view1.findViewById(0x7f0c00cb);
                        fi1.d = (BBYTextView)view1.findViewById(0x7f0c00cc);
                        fi1.g = (BBYTextView)view1.findViewById(0x7f0c00d8);
                        fi1.h = (BBYTextView)view1.findViewById(0x7f0c00d1);
                        fi1.j = (BBYTextView)view1.findViewById(0x7f0c00d9);
                        fi1.k = (BBYTextView)view1.findViewById(0x7f0c00ce);
                        fi1.l = (ImageView)view1.findViewById(0x7f0c00d0);
                        fi1.m = (BBYTextView)view1.findViewById(0x7f0c00d3);
                        fi1.n = (RelativeLayout)view1.findViewById(0x7f0c00cf);
                        fi1.o = (BBYTextView)view1.findViewById(0x7f0c00d2);
                        fi1.f = (BBYTextView)view1.findViewById(0x7f0c00d4);
                        fi1.e = (LinearLayout)view1.findViewById(0x7f0c00d6);
                        fi1.i = (BBYTextView)view1.findViewById(0x7f0c00d5);
                        fi1.p = (BBYTextView)view1.findViewById(0x7f0c00d7);
                        view1.setTag(fi1);
                    } else
                    {
                        fi1 = (fi)view.getTag();
                        view1 = view;
                    }
                    obj = new DecimalFormat("0.00");
                    view = (BBYProduct)a.get(i);
                    viewgroup = (DNMProduct)b.get(i);
                    summary = view.getSummary();
                    if (view == null)
                    {
                        break label0;
                    }
                    s = summary.getNames().getShortName();
                    try
                    {
                        lt.a(c, fi1.a, s, 1000, 0x7f080024);
                    }
                    catch (Exception exception2)
                    {
                        exception2.printStackTrace();
                        fi1.a.setText(s);
                    }
                    if (viewgroup.getDistance() == 0.0D)
                    {
                        fi1.o.setVisibility(8);
                    } else
                    {
                        fi1.o.setVisibility(0);
                        fi1.o.setText((new StringBuilder()).append(viewgroup.getDistance()).append(" Miles Away").toString());
                        fi1.o.setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

                            final DNMProduct a;
                            final fh b;

                            public void onClick(View view2)
                            {
                                view2 = (new StringBuilder()).append(a.getStoreCity()).append(",").append(a.getStoreState()).append(" ").append(a.getStoreZipCode()).toString();
                                view2 = (new StringBuilder()).append(a.getStoreAddress1()).append(",").append(view2).toString();
                                Uri uri = Uri.parse((new StringBuilder()).append(fh.a(b).getResources().getString(0x7f0801d0)).append(fh.b(b).y()).append(",").append(fh.b(b).z()).append("&daddr=").append(view2).append("&hl=en").toString());
                                fh.a(b, uri, view2);
                            }

            
            {
                b = fh.this;
                a = dnmproduct;
                super();
            }
                        });
                    }
                    fi1.c.setNumStars(5);
                    f1 = 0.0F;
                    f = f1;
                    if (summary.getCustomerRatings() != null)
                    {
                        f = f1;
                        if (summary.getCustomerRatings().getAverageRating() != null)
                        {
                            f = (float)summary.getCustomerRatings().getAverageRating().getScore();
                        }
                    }
                    if (summary.getCustomerRatings() != null)
                    {
                        fi1.c.setRating(f);
                        summary.getCustomerRatings().getTotalCount();
                        i = summary.getCustomerRatings().getTotalCount();
                        if (i == 1)
                        {
                            fi1.d.setText((new StringBuilder()).append("(").append(i).append(" ").append(c.getString(0x7f0802df)).toString());
                        } else
                        {
                            fi1.d.setText((new StringBuilder()).append("(").append(i).append(" ").append(c.getString(0x7f0802e0)).toString());
                        }
                    }
                    fi1.i.setVisibility(8);
                    if (viewgroup.isICRPrice())
                    {
                        fi1.f.setVisibility(0);
                        fi1.e.setVisibility(8);
                        fi1.f.setText(c.getString(0x7f0802af));
                    } else
                    if (viewgroup.isICRStrike())
                    {
                        fi1.f.setVisibility(0);
                        fi1.f.setText(c.getString(0x7f0802af));
                        fi1.g.setText((new StringBuilder()).append("$").append(a(Double.toString(viewgroup.getClearancePrice()))).toString());
                        fi1.g.setPaintFlags(fi1.g.getPaintFlags() | 0x10);
                        fi1.j.setVisibility(8);
                    } else
                    if (viewgroup.isMapFlag())
                    {
                        fi1.f.setVisibility(0);
                        fi1.e.setVisibility(8);
                        fi1.f.setText("See Price in Cart");
                        fi1.i.setVisibility(0);
                        fi1.i.setText((new StringBuilder()).append("Reg.Price: $").append(a(Double.toString(viewgroup.getSkuPermRegPrice()))).toString());
                    } else
                    {
                        fi1.f.setVisibility(8);
                        fi1.e.setVisibility(0);
                        fi1.j.setVisibility(0);
                        fi1.g.setPaintFlags(fi1.g.getPaintFlags() & 0xffffffef);
                        fi1.g.setText((new StringBuilder()).append("$").append(a(Double.toString(viewgroup.getClearancePrice()))).toString());
                        String s1 = String.valueOf(String.format("%.2f", new Object[] {
                            Double.valueOf(viewgroup.getSaveAmt())
                        }));
                        try
                        {
                            if (viewgroup.getSaveAmt() > 1.0D)
                            {
                                s1.replace(s1.substring(s1.indexOf("."), s1.length()), "");
                            }
                        }
                        catch (Exception exception1)
                        {
                            exception1.printStackTrace();
                        }
                        obj = ((DecimalFormat) (obj)).format(viewgroup.getSkuPermRegPrice());
                        s1 = (new StringBuilder()).append("").append(Math.round(viewgroup.getSaveAmt())).toString();
                        obj = (new StringBuilder()).append("<span class='bold'>SAVE $").append(a(s1)).append("</span> (Reg. $").append(a(((String) (obj)))).append(")").toString();
                        try
                        {
                            lt.a(c, fi1.j, ((String) (obj)), 300, Color.rgb(216, 37, 38));
                        }
                        catch (Exception exception)
                        {
                            kf.a("", (new StringBuilder()).append("Error Text: ").append(exception.getLocalizedMessage()).toString());
                        }
                    }
                    if (viewgroup.getDnmType().equals(c.getString(0x7f08012a)))
                    {
                        fi1.h.setVisibility(8);
                        fi1.l.setVisibility(8);
                        if (viewgroup.getNoOfStoresItemAvlbl() <= 1)
                        {
                            fi1.m.setVisibility(8);
                            fi1.p.setVisibility(8);
                            fi1.o.setVisibility(0);
                        } else
                        {
                            fi1.m.setText(c.getResources().getString(0x7f080128));
                            fi1.m.setVisibility(0);
                            fi1.k.setVisibility(8);
                            if (viewgroup.getIcrMapPriceValue().equals("1") || viewgroup.getIcrMapPriceValue().equals("2"))
                            {
                                fi1.f.setVisibility(8);
                                fi1.i.setVisibility(8);
                            } else
                            {
                                fi1.p.setVisibility(0);
                            }
                            fi1.o.setVisibility(8);
                        }
                    } else
                    if (viewgroup.getNoOfStoresItemAvlbl() <= 1)
                    {
                        fi1.n.setVisibility(0);
                        fi1.m.setVisibility(8);
                        fi1.p.setVisibility(8);
                        fi1.h.setVisibility(0);
                        fi1.h.setText((new StringBuilder()).append(viewgroup.getOpenBoxCondition()).append(" Condition").toString());
                    } else
                    {
                        fi1.m.setText(c.getResources().getString(0x7f080282));
                        fi1.n.setVisibility(8);
                        fi1.h.setVisibility(8);
                        if (viewgroup.getIcrMapPriceValue().equals("1") || viewgroup.getIcrMapPriceValue().equals("2"))
                        {
                            fi1.f.setVisibility(8);
                            fi1.i.setVisibility(8);
                        } else
                        {
                            fi1.p.setVisibility(0);
                        }
                        fi1.m.setVisibility(0);
                    }
                    fi1.f.setOnClickListener(new android.view.View.OnClickListener(viewgroup, view) {

                        final DNMProduct a;
                        final BBYProduct b;
                        final fh c;

                        public void onClick(View view2)
                        {
                            boolean flag = true;
                            if (!a.getIcrMapPriceValue().equals("1") && !a.getIcrMapPriceValue().equals("2")) goto _L2; else goto _L1
_L1:
                            view2 = new lb(fh.a(c), 0x7f0801e4, 0x7f0801e1, 0x7f0801e5, 0x7f0801e2, 0x7f0801e3);
_L10:
                            if (view2 != null)
                            {
                                view2.show();
                            }
                            return;
_L2:
                            if (!a.isMapFlag()) goto _L4; else goto _L3
_L3:
                            if (a.getSkuTypeCode() == null || a.getSkuTypeCode().equals(fh.a(c).getString(0x7f080068))) goto _L6; else goto _L5
_L5:
                            if (!a.getSkuTypeCode().equals(fh.a(c).getString(0x7f08003a))) goto _L8; else goto _L7
_L7:
                            view2 = new lb(fh.a(c), 0x7f080224, 0x7f080222, 0x7f080225, 0x7f080223, flag, a, b);
                            continue; /* Loop/switch isn't completed */
_L8:
                            if (a.getSkuDisplayable() != null)
                            {
                                if (!a.getSkuDisplayable().equals("1"))
                                {
                                    flag = false;
                                }
                            } else
                            {
                                flag = false;
                            }
                            continue; /* Loop/switch isn't completed */
_L6:
                            flag = false;
                            if (true) goto _L7; else goto _L4
_L4:
                            view2 = null;
                            if (true) goto _L10; else goto _L9
_L9:
                        }

            
            {
                c = fh.this;
                a = dnmproduct;
                b = bbyproduct;
                super();
            }
                    });
                    view = "";
                    viewgroup = view;
                    if (summary.getMedia() == null)
                    {
                        break label1;
                    }
                    viewgroup = view;
                    if (summary.getMedia().getPrimaryImage() != null)
                    {
                        viewgroup = summary.getMedia().getPrimaryImage().getUrl();
                    }
                    if (!viewgroup.isEmpty())
                    {
                        view = viewgroup;
                        if (!viewgroup.equals(c.getString(0x7f080068)))
                        {
                            break label2;
                        }
                    }
                    view = viewgroup;
                    if (summary.getMedia().getListImage() != null)
                    {
                        view = summary.getMedia().getListImage().getUrl();
                    }
                }
                if (!view.isEmpty())
                {
                    viewgroup = view;
                    if (!view.equals(c.getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                viewgroup = view;
                if (summary.getMedia().getThumbnailImage() != null)
                {
                    viewgroup = summary.getMedia().getThumbnailImage().getUrl();
                }
            }
            ng.a(viewgroup, fi1.b, false);
        }
        return view1;
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
