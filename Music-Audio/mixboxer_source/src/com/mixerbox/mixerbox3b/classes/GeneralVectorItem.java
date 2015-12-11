// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyItem, VectorOnClickListener

public class GeneralVectorItem
    implements MyItem
{

    private Context ctx;
    private JSONObject item;
    private JSONObject jOb;

    public GeneralVectorItem(Context context, JSONObject jsonobject)
    {
        ctx = context;
        jOb = jsonobject;
        item = jsonobject;
    }

    public JSONObject getMyJSONObject()
    {
        return jOb;
    }

    public View getView(LayoutInflater layoutinflater, View view)
    {
        JSONObject jsonobject;
        Object obj;
        int i;
        boolean flag;
        if (view == null)
        {
            view = layoutinflater.inflate(0x7f03004a, null);
            layoutinflater = new ViewHolder(null);
            layoutinflater.ll = (LinearLayout)view.findViewById(0x7f070073);
            layoutinflater.rlHeader = (RelativeLayout)view.findViewById(0x7f070103);
            layoutinflater.rlImage = (RelativeLayout)view.findViewById(0x7f070111);
            layoutinflater.rlMain = (RelativeLayout)view.findViewById(0x7f070108);
            layoutinflater.llFooter = (LinearLayout)view.findViewById(0x7f070117);
            layoutinflater.ivH = (ImageView)view.findViewById(0x7f070104);
            layoutinflater.tvMainH = (TextView)view.findViewById(0x7f070106);
            layoutinflater.tvSubH = (TextView)view.findViewById(0x7f070107);
            layoutinflater.tvMainM = (TextView)view.findViewById(0x7f07010e);
            layoutinflater.tvSubM = (TextView)view.findViewById(0x7f07010f);
            layoutinflater.tvSideM = (TextView)view.findViewById(0x7f07010b);
            layoutinflater.llSub = (LinearLayout)view.findViewById(0x7f07010c);
            layoutinflater.ivM = (ImageView)view.findViewById(0x7f070109);
            layoutinflater.ivQM = (ImageView)view.findViewById(0x7f07010a);
            layoutinflater.ivB = (ImageView)view.findViewById(0x7f070112);
            layoutinflater.ivQB = (ImageView)view.findViewById(0x7f070113);
            layoutinflater.tvMain = (TextView)view.findViewById(0x7f070114);
            layoutinflater.tvSub = (TextView)view.findViewById(0x7f070115);
            layoutinflater.llMusic = (LinearLayout)view.findViewById(0x7f070110);
            view.setTag(layoutinflater);
        } else
        {
            layoutinflater = (ViewHolder)view.getTag();
        }
        if (item.isNull("margin")) goto _L2; else goto _L1
_L1:
        flag = item.getBoolean("margin");
_L93:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        view.setPadding(0, 0, 0, 0);
        ((ViewHolder) (layoutinflater)).ll.setBackgroundResource(0x7f060018);
        obj = item.getJSONObject("views");
        jsonobject = new JSONObject();
        if (!((JSONObject) (obj)).isNull("main") && !((JSONObject) (obj)).getJSONObject("main").isNull("mainLink"))
        {
            jsonobject = ((JSONObject) (obj)).getJSONObject("main").getJSONObject("mainLink");
        }
        if (((JSONObject) (obj)).isNull("header")) goto _L4; else goto _L3
_L3:
        ((ViewHolder) (layoutinflater)).rlHeader.setVisibility(0);
        if (!flag) goto _L6; else goto _L5
_L5:
        if (((JSONObject) (obj)).getJSONObject("header").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("header").getBoolean("bgColor") || !((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("main")) goto _L8; else goto _L7
_L7:
        ((ViewHolder) (layoutinflater)).rlHeader.setBackgroundResource(0x7f0200c0);
_L42:
        if (((JSONObject) (obj)).getJSONObject("header").isNull("imageUrl")) goto _L10; else goto _L9
_L9:
        ((ViewHolder) (layoutinflater)).ivH.setVisibility(0);
        ImageLoader.getInstance().displayImage(((JSONObject) (obj)).getJSONObject("header").getString("imageUrl"), ((ViewHolder) (layoutinflater)).ivH);
_L43:
        ((ViewHolder) (layoutinflater)).tvMainH.setText("");
        if (!((JSONObject) (obj)).getJSONObject("header").isNull("object1"))
        {
            Object obj1 = ((JSONObject) (obj)).getJSONObject("header").getJSONObject("object1");
            JSONObject jsonobject2 = ((JSONObject) (obj)).getJSONObject("header");
            jsonobject2.put("obj1IsSwitch", false);
            obj1 = MixerBoxUtils.makeLinkSpan(((JSONObject) (obj)).getJSONObject("header").getJSONObject("object1").getString("title"), new VectorOnClickListener(ctx, ((JSONObject) (obj1)), jsonobject, jsonobject2), ctx);
            ((ViewHolder) (layoutinflater)).tvMainH.append(((CharSequence) (obj1)));
            MixerBoxUtils.makeLinksFocusable(((ViewHolder) (layoutinflater)).tvMainH);
            ((ViewHolder) (layoutinflater)).tvMainH.append(" ");
        }
        if (((JSONObject) (obj)).getJSONObject("header").isNull("mainText")) goto _L12; else goto _L11
_L11:
        ((ViewHolder) (layoutinflater)).tvMainH.setVisibility(0);
        ((ViewHolder) (layoutinflater)).tvMainH.append(((JSONObject) (obj)).getJSONObject("header").getString("mainText"));
_L45:
        if (!((JSONObject) (obj)).getJSONObject("header").isNull("object2"))
        {
            ((ViewHolder) (layoutinflater)).tvMainH.append(" ");
            Object obj2 = ((JSONObject) (obj)).getJSONObject("header");
            ((JSONObject) (obj2)).put("obj2IsSwitch", false);
            JSONObject jsonobject3 = ((JSONObject) (obj)).getJSONObject("header").getJSONObject("object2");
            obj2 = MixerBoxUtils.makeLinkSpan(((JSONObject) (obj)).getJSONObject("header").getJSONObject("object2").getString("title"), new VectorOnClickListener(ctx, jsonobject3, jsonobject, ((JSONObject) (obj2))), ctx);
            ((ViewHolder) (layoutinflater)).tvMainH.append(((CharSequence) (obj2)));
            MixerBoxUtils.makeLinksFocusable(((ViewHolder) (layoutinflater)).tvMainH);
        }
        if (((JSONObject) (obj)).getJSONObject("header").isNull("subText")) goto _L14; else goto _L13
_L13:
        ((ViewHolder) (layoutinflater)).tvSubH.setVisibility(0);
        ((ViewHolder) (layoutinflater)).tvSubH.setText(((JSONObject) (obj)).getJSONObject("header").getString("subText"));
_L46:
        if (((JSONObject) (obj)).isNull("main")) goto _L16; else goto _L15
_L15:
        if (!((JSONObject) (obj)).getJSONObject("main").isNull("thumbnail") && !((JSONObject) (obj)).getJSONObject("main").getJSONObject("thumbnail").isNull("style") && !((JSONObject) (obj)).getJSONObject("main").getJSONObject("thumbnail").getString("style").equals("square")) goto _L18; else goto _L17
_L17:
        ((ViewHolder) (layoutinflater)).rlImage.setVisibility(8);
        ((ViewHolder) (layoutinflater)).rlMain.setVisibility(0);
        if (!flag) goto _L20; else goto _L19
_L19:
        if (((JSONObject) (obj)).getJSONObject("main").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("main").getBoolean("bgColor")) goto _L22; else goto _L21
_L21:
        if (!((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("header")) goto _L24; else goto _L23
_L23:
        ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200c0);
_L47:
        if (!((JSONObject) (obj)).getJSONObject("main").isNull("mainLink"))
        {
            JSONObject jsonobject1 = ((JSONObject) (obj)).getJSONObject("main").getJSONObject("mainLink");
            ((ViewHolder) (layoutinflater)).rlMain.setOnClickListener(new VectorOnClickListener(ctx, jsonobject1, jsonobject, null));
        }
        if (!((JSONObject) (obj)).getJSONObject("main").isNull("thumbnail")) goto _L26; else goto _L25
_L25:
        ((ViewHolder) (layoutinflater)).ivM.setVisibility(8);
        ((ViewHolder) (layoutinflater)).ivQM.setVisibility(8);
_L48:
        if (!((JSONObject) (obj)).getJSONObject("main").isNull("mainLink") && !((JSONObject) (obj)).getJSONObject("main").getJSONObject("mainLink").isNull("type") && (((JSONObject) (obj)).getJSONObject("main").getJSONObject("mainLink").getString("type").equals("music") || ((JSONObject) (obj)).getJSONObject("main").getJSONObject("mainLink").getString("type").equals("playlist"))) goto _L28; else goto _L27
_L27:
        ((ViewHolder) (layoutinflater)).ivQM.setVisibility(8);
_L49:
        if (!((JSONObject) (obj)).getJSONObject("main").isNull("subLinks")) goto _L30; else goto _L29
_L29:
        ((ViewHolder) (layoutinflater)).llSub.setVisibility(8);
_L53:
        if (((JSONObject) (obj)).getJSONObject("main").isNull("mainText")) goto _L32; else goto _L31
_L31:
        ((ViewHolder) (layoutinflater)).tvMainM.setText(((JSONObject) (obj)).getJSONObject("main").getString("mainText"));
_L60:
        if (((JSONObject) (obj)).getJSONObject("main").isNull("subText") || ((JSONObject) (obj)).getJSONObject("main").getString("subText").length() <= 0) goto _L34; else goto _L33
_L33:
        ((ViewHolder) (layoutinflater)).tvSubM.setText(((JSONObject) (obj)).getJSONObject("main").getString("subText"));
        ((ViewHolder) (layoutinflater)).tvSubM.setVisibility(0);
_L62:
        if (((JSONObject) (obj)).getJSONObject("main").isNull("sideText")) goto _L36; else goto _L35
_L35:
        ((ViewHolder) (layoutinflater)).tvSideM.setVisibility(0);
        ((ViewHolder) (layoutinflater)).tvSideM.setText(((JSONObject) (obj)).getJSONObject("main").getString("sideText"));
_L63:
        if (((ViewHolder) (layoutinflater)).tvMainM.getVisibility() != 8 || ((ViewHolder) (layoutinflater)).tvSubM.getVisibility() != 8) goto _L38; else goto _L37
_L37:
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        ((ViewHolder) (layoutinflater)).llSub.setLayoutParams(layoutparams);
        i = 0;
_L39:
        if (i >= ((ViewHolder) (layoutinflater)).llSub.getChildCount())
        {
            break; /* Loop/switch isn't completed */
        }
        android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(new android.widget.LinearLayout.LayoutParams(0, -2));
        layoutparams1.weight = 1.0F;
        ((ViewHolder) (layoutinflater)).llSub.getChildAt(i).setPadding(20, 2, 20, 2);
        ((ViewHolder) (layoutinflater)).llSub.getChildAt(i).setLayoutParams(layoutparams1);
        i++;
        if (true) goto _L39; else goto _L38
_L8:
        if (((JSONObject) (obj)).getJSONObject("header").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("header").getBoolean("bgColor")) goto _L41; else goto _L40
_L40:
        ((ViewHolder) (layoutinflater)).rlHeader.setBackgroundResource(0x7f0200c3);
          goto _L42
_L77:
        return view;
_L41:
label0:
        {
            if (!((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("main"))
            {
                break label0;
            }
            ((ViewHolder) (layoutinflater)).rlHeader.setBackgroundResource(0x7f0200c5);
        }
          goto _L42
        ((ViewHolder) (layoutinflater)).rlHeader.setBackgroundResource(0x7f0200c4);
          goto _L42
_L6:
label1:
        {
            if (((JSONObject) (obj)).getJSONObject("header").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("header").getBoolean("bgColor"))
            {
                break label1;
            }
            ((ViewHolder) (layoutinflater)).rlHeader.setBackgroundResource(0x7f0200c1);
        }
          goto _L42
        ((ViewHolder) (layoutinflater)).rlHeader.setBackgroundResource(0x7f0200c2);
          goto _L42
_L10:
        ((ViewHolder) (layoutinflater)).ivH.setVisibility(8);
          goto _L43
_L12:
        if (!((JSONObject) (obj)).getJSONObject("header").isNull("object2") || !((JSONObject) (obj)).getJSONObject("header").isNull("object1")) goto _L45; else goto _L44
_L44:
        ((ViewHolder) (layoutinflater)).tvMainH.setVisibility(8);
          goto _L45
_L14:
        ((ViewHolder) (layoutinflater)).tvSubH.setVisibility(8);
          goto _L46
_L4:
        ((ViewHolder) (layoutinflater)).rlHeader.setVisibility(8);
          goto _L46
_L24:
label2:
        {
            if (((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("header"))
            {
                break label2;
            }
            ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200c3);
        }
          goto _L47
label3:
        {
            if (!((JSONObject) (obj)).isNull("footer") || ((JSONObject) (obj)).isNull("header"))
            {
                break label3;
            }
            ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200be);
        }
          goto _L47
        ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200c1);
          goto _L47
_L22:
label4:
        {
            if (!((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("header"))
            {
                break label4;
            }
            ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200c5);
        }
          goto _L47
label5:
        {
            if (((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("header"))
            {
                break label5;
            }
            ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200c4);
        }
          goto _L47
label6:
        {
            if (!((JSONObject) (obj)).isNull("footer") || ((JSONObject) (obj)).isNull("header"))
            {
                break label6;
            }
            ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200bf);
        }
          goto _L47
        ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200c2);
          goto _L47
_L20:
label7:
        {
            if (((JSONObject) (obj)).getJSONObject("main").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("main").getBoolean("bgColor"))
            {
                break label7;
            }
            ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200c1);
        }
          goto _L47
        ((ViewHolder) (layoutinflater)).rlMain.setBackgroundResource(0x7f0200c2);
          goto _L47
_L26:
        ((ViewHolder) (layoutinflater)).ivM.setVisibility(0);
        ((ViewHolder) (layoutinflater)).ivQM.setVisibility(0);
        ImageLoader.getInstance().displayImage(((JSONObject) (obj)).getJSONObject("main").getJSONObject("thumbnail").getString("url"), ((ViewHolder) (layoutinflater)).ivM);
          goto _L48
_L28:
        ((ViewHolder) (layoutinflater)).ivQM.setVisibility(0);
          goto _L49
_L30:
        Object obj3;
        obj3 = ((JSONObject) (obj)).getJSONObject("main").getJSONArray("subLinks");
        ((ViewHolder) (layoutinflater)).llSub.removeAllViews();
        ((ViewHolder) (layoutinflater)).llSub.setVisibility(0);
        if (((JSONArray) (obj3)).length() <= 1) goto _L51; else goto _L50
_L50:
        i = 0;
_L94:
        if (i >= 3) goto _L53; else goto _L52
_L52:
        TextView textview;
        textview = new TextView(ctx);
        android.widget.LinearLayout.LayoutParams layoutparams4 = new android.widget.LinearLayout.LayoutParams(new android.widget.LinearLayout.LayoutParams(0, -2));
        layoutparams4.weight = 1.0F;
        textview.setPadding(20, 2, 20, 2);
        textview.setLayoutParams(layoutparams4);
        if (((JSONArray) (obj3)).length() > i) goto _L55; else goto _L54
_L54:
        ((ViewHolder) (layoutinflater)).llSub.addView(textview);
          goto _L56
_L55:
        JSONObject jsonobject5 = ((JSONArray) (obj3)).getJSONObject(i);
        if (!jsonobject5.isNull("title"))
        {
            textview.setText(jsonobject5.getString("title"));
        }
        textview.setTextColor(ctx.getResources().getColor(0x7f060015));
        textview.setTextSize(13F);
        textview.setGravity(1);
        textview.setTypeface(null, 1);
        textview.setOnClickListener(new VectorOnClickListener(ctx, jsonobject5, jsonobject, null));
        ((ViewHolder) (layoutinflater)).llSub.addView(textview);
          goto _L56
_L51:
        obj3 = ((JSONArray) (obj3)).getJSONObject(0);
        i = 0;
        if (!((JSONObject) (obj3)).isNull("align"))
        {
            i = ((JSONObject) (obj3)).getInt("align");
        }
        textview = new TextView(ctx);
        if (i != 1) goto _L58; else goto _L57
_L57:
        textview.setGravity(3);
_L59:
        android.widget.LinearLayout.LayoutParams layoutparams5 = new android.widget.LinearLayout.LayoutParams(new android.widget.LinearLayout.LayoutParams(0, -2));
        layoutparams5.weight = 1.0F;
        textview.setPadding(20, 2, 20, 2);
        textview.setLayoutParams(layoutparams5);
        if (!((JSONObject) (obj3)).isNull("title"))
        {
            textview.setText(((JSONObject) (obj3)).getString("title"));
        }
        textview.setTextColor(ctx.getResources().getColor(0x7f060015));
        textview.setTextSize(13F);
        textview.setTypeface(null, 1);
        textview.setOnClickListener(new VectorOnClickListener(ctx, ((JSONObject) (obj3)), jsonobject, null));
        ((ViewHolder) (layoutinflater)).llSub.addView(textview);
          goto _L53
_L58:
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_2429;
        }
        textview.setGravity(5);
          goto _L59
        textview.setGravity(1);
          goto _L59
_L32:
        ((ViewHolder) (layoutinflater)).tvMainM.setWidth(0);
        obj3 = new android.widget.RelativeLayout.LayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(1, 0);
        if (((JSONObject) (obj)).getJSONObject("main").isNull("thumbnail"))
        {
            break MISSING_BLOCK_LABEL_2514;
        }
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(1, 0x7f070109);
_L61:
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(15);
        ((ViewHolder) (layoutinflater)).llSub.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
          goto _L60
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(9);
          goto _L61
_L34:
        ((ViewHolder) (layoutinflater)).tvSubM.setVisibility(8);
          goto _L62
_L36:
        ((ViewHolder) (layoutinflater)).tvSideM.setVisibility(4);
          goto _L63
_L38:
        if (((JSONObject) (obj)).getJSONObject("main").isNull("snippet")) goto _L65; else goto _L64
_L64:
        ((ViewHolder) (layoutinflater)).llMusic.setVisibility(0);
        ((ViewHolder) (layoutinflater)).tvMainM.setText("");
        ((ViewHolder) (layoutinflater)).tvSubM.setText("");
        ((ViewHolder) (layoutinflater)).tvSideM.setText("");
        obj3 = ((JSONObject) (obj)).getJSONObject("main").getJSONArray("snippet");
        ((ViewHolder) (layoutinflater)).llMusic.removeAllViews();
        i = 0;
_L67:
        if (i >= ((JSONArray) (obj3)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        View view1 = ((LayoutInflater)ctx.getSystemService("layout_inflater")).inflate(0x7f03004d, null);
        TextView textview1 = (TextView)view1.findViewById(0x7f070120);
        TextView textview2 = (TextView)view1.findViewById(0x7f070121);
        ((ImageView)view1.findViewById(0x7f07011e)).setVisibility(8);
        textview1.setVisibility(8);
        textview2.setText((new StringBuilder()).append(i + 1).append(". ").append(((JSONArray) (obj3)).getJSONObject(i).getString("text")).toString());
        if (i == ((JSONArray) (obj3)).length() - 1)
        {
            view1.findViewById(0x7f07011f).setVisibility(8);
        }
        ((ViewHolder) (layoutinflater)).llMusic.addView(view1);
        i++;
        if (true) goto _L67; else goto _L66
_L65:
        ((ViewHolder) (layoutinflater)).llMusic.setVisibility(8);
_L66:
        if (((JSONObject) (obj)).isNull("footer")) goto _L69; else goto _L68
_L68:
        obj3 = ((JSONObject) (obj)).getJSONObject("footer").getJSONArray("links");
        ((ViewHolder) (layoutinflater)).llFooter.setVisibility(0);
        if (!flag) goto _L71; else goto _L70
_L70:
        if (((JSONObject) (obj)).getJSONObject("footer").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("footer").getBoolean("bgColor") || !((JSONObject) (obj)).isNull("header") || !((JSONObject) (obj)).isNull("main")) goto _L73; else goto _L72
_L72:
        ((ViewHolder) (layoutinflater)).llFooter.setBackgroundResource(0x7f0200c0);
_L89:
        ((ViewHolder) (layoutinflater)).llFooter.removeAllViews();
        if (((JSONArray) (obj3)).length() <= 1) goto _L75; else goto _L74
_L74:
        i = 0;
_L95:
        if (i >= 3) goto _L77; else goto _L76
_L18:
        ((ViewHolder) (layoutinflater)).rlImage.setVisibility(0);
        ((ViewHolder) (layoutinflater)).rlMain.setVisibility(8);
        if (!flag) goto _L79; else goto _L78
_L78:
        if (((JSONObject) (obj)).getJSONObject("main").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("main").getBoolean("bgColor")) goto _L81; else goto _L80
_L80:
        if (!((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("header")) goto _L83; else goto _L82
_L82:
        ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200c0);
_L86:
        if (!((JSONObject) (obj)).getJSONObject("main").isNull("mainLink"))
        {
            obj3 = ((JSONObject) (obj)).getJSONObject("main").getJSONObject("mainLink");
            ((ViewHolder) (layoutinflater)).rlImage.setOnClickListener(new VectorOnClickListener(ctx, ((JSONObject) (obj3)), jsonobject, null));
        }
        ImageLoader.getInstance().displayImage(((JSONObject) (obj)).getJSONObject("main").getJSONObject("thumbnail").getString("url"), ((ViewHolder) (layoutinflater)).ivB);
        if (!((JSONObject) (obj)).getJSONObject("main").isNull("mainLink") && !((JSONObject) (obj)).getJSONObject("main").getJSONObject("mainLink").isNull("type") && ((JSONObject) (obj)).getJSONObject("main").getJSONObject("mainLink").getString("type").equals("music")) goto _L85; else goto _L84
_L84:
        ((ViewHolder) (layoutinflater)).ivQB.setVisibility(8);
_L87:
        if (((JSONObject) (obj)).getJSONObject("main").isNull("mainText"))
        {
            break MISSING_BLOCK_LABEL_3583;
        }
        ((ViewHolder) (layoutinflater)).tvMain.setVisibility(0);
        ((ViewHolder) (layoutinflater)).tvMain.setText(((JSONObject) (obj)).getJSONObject("main").getString("mainText"));
_L88:
        if (((JSONObject) (obj)).getJSONObject("main").isNull("subText"))
        {
            break MISSING_BLOCK_LABEL_3595;
        }
        ((ViewHolder) (layoutinflater)).tvSub.setVisibility(0);
        ((ViewHolder) (layoutinflater)).tvSub.setText(((JSONObject) (obj)).getJSONObject("main").getString("subText"));
          goto _L66
_L83:
label8:
        {
            if (((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("header"))
            {
                break label8;
            }
            ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200c3);
        }
          goto _L86
label9:
        {
            if (!((JSONObject) (obj)).isNull("footer") || ((JSONObject) (obj)).isNull("header"))
            {
                break label9;
            }
            ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200be);
        }
          goto _L86
        ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200c1);
          goto _L86
_L81:
label10:
        {
            if (!((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("header"))
            {
                break label10;
            }
            ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200c5);
        }
          goto _L86
label11:
        {
            if (((JSONObject) (obj)).isNull("footer") || !((JSONObject) (obj)).isNull("header"))
            {
                break label11;
            }
            ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200c4);
        }
          goto _L86
label12:
        {
            if (!((JSONObject) (obj)).isNull("footer") || ((JSONObject) (obj)).isNull("header"))
            {
                break label12;
            }
            ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200bf);
        }
          goto _L86
        ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200c2);
          goto _L86
_L79:
label13:
        {
            if (((JSONObject) (obj)).getJSONObject("main").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("main").getBoolean("bgColor"))
            {
                break label13;
            }
            ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200c1);
        }
          goto _L86
        ((ViewHolder) (layoutinflater)).rlImage.setBackgroundResource(0x7f0200c2);
          goto _L86
_L85:
        ((ViewHolder) (layoutinflater)).ivQB.setVisibility(0);
          goto _L87
        ((ViewHolder) (layoutinflater)).tvMain.setVisibility(8);
          goto _L88
        ((ViewHolder) (layoutinflater)).tvSub.setVisibility(8);
          goto _L66
_L16:
        ((ViewHolder) (layoutinflater)).rlImage.setVisibility(8);
        ((ViewHolder) (layoutinflater)).rlMain.setVisibility(8);
          goto _L66
_L73:
label14:
        {
            if (((JSONObject) (obj)).getJSONObject("footer").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("footer").getBoolean("bgColor"))
            {
                break label14;
            }
            ((ViewHolder) (layoutinflater)).llFooter.setBackgroundResource(0x7f0200be);
        }
          goto _L89
label15:
        {
            if (!((JSONObject) (obj)).isNull("header") || !((JSONObject) (obj)).isNull("main"))
            {
                break label15;
            }
            ((ViewHolder) (layoutinflater)).llFooter.setBackgroundResource(0x7f0200c5);
        }
          goto _L89
        ((ViewHolder) (layoutinflater)).llFooter.setBackgroundResource(0x7f0200bf);
          goto _L89
_L71:
label16:
        {
            if (((JSONObject) (obj)).getJSONObject("footer").isNull("bgColor") || !((JSONObject) (obj)).getJSONObject("footer").getBoolean("bgColor"))
            {
                break label16;
            }
            ((ViewHolder) (layoutinflater)).llFooter.setBackgroundResource(0x7f0200c1);
        }
          goto _L89
        ((ViewHolder) (layoutinflater)).llFooter.setBackgroundResource(0x7f0200c2);
          goto _L89
_L76:
        obj = new TextView(ctx);
        ((TextView) (obj)).setGravity(1);
        android.widget.LinearLayout.LayoutParams layoutparams2 = new android.widget.LinearLayout.LayoutParams(new android.widget.LinearLayout.LayoutParams(0, -2));
        layoutparams2.weight = 1.0F;
        ((TextView) (obj)).setPadding(20, 2, 20, 2);
        ((TextView) (obj)).setLayoutParams(layoutparams2);
        if (i >= ((JSONArray) (obj3)).length())
        {
            ((ViewHolder) (layoutinflater)).llFooter.addView(((View) (obj)));
            break MISSING_BLOCK_LABEL_4108;
        }
        try
        {
            JSONObject jsonobject4 = ((JSONArray) (obj3)).getJSONObject(i);
            if (!jsonobject4.isNull("title"))
            {
                ((TextView) (obj)).setText(jsonobject4.getString("title"));
            }
            ((TextView) (obj)).setTextColor(ctx.getResources().getColor(0x7f06001e));
            ((TextView) (obj)).setTextSize(13F);
            ((TextView) (obj)).setTypeface(null, 1);
            ((TextView) (obj)).setOnClickListener(new VectorOnClickListener(ctx, jsonobject4, jsonobject, null));
            ((ViewHolder) (layoutinflater)).llFooter.addView(((View) (obj)));
            break MISSING_BLOCK_LABEL_4108;
        }
        // Misplaced declaration of an exception variable
        catch (LayoutInflater layoutinflater)
        {
            layoutinflater.printStackTrace();
        }
          goto _L77
_L75:
        obj = ((JSONArray) (obj3)).getJSONObject(0);
        i = 0;
        if (!((JSONObject) (obj)).isNull("align"))
        {
            i = ((JSONObject) (obj)).getInt("align");
        }
        obj3 = new TextView(ctx);
        if (i != 1) goto _L91; else goto _L90
_L90:
        ((TextView) (obj3)).setGravity(3);
_L92:
        android.widget.LinearLayout.LayoutParams layoutparams3 = new android.widget.LinearLayout.LayoutParams(new android.widget.LinearLayout.LayoutParams(0, -2));
        layoutparams3.weight = 1.0F;
        ((TextView) (obj3)).setPadding(20, 2, 20, 2);
        ((TextView) (obj3)).setLayoutParams(layoutparams3);
        if (!((JSONObject) (obj)).isNull("title"))
        {
            ((TextView) (obj3)).setText(((JSONObject) (obj)).getString("title"));
        }
        ((TextView) (obj3)).setTextColor(ctx.getResources().getColor(0x7f06001e));
        ((TextView) (obj3)).setTextSize(13F);
        ((TextView) (obj3)).setTypeface(null, 1);
        ((TextView) (obj3)).setOnClickListener(new VectorOnClickListener(ctx, ((JSONObject) (obj)), jsonobject, null));
        ((ViewHolder) (layoutinflater)).llFooter.addView(((View) (obj3)));
        return view;
_L91:
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_4070;
        }
        ((TextView) (obj3)).setGravity(5);
          goto _L92
        ((TextView) (obj3)).setGravity(1);
          goto _L92
_L69:
        ((ViewHolder) (layoutinflater)).llFooter.setVisibility(8);
        return view;
_L2:
        flag = false;
          goto _L93
_L56:
        i++;
          goto _L94
        i++;
          goto _L95
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.GENERAL_ITEM.ordinal();
    }

    private class ViewHolder
    {

        public ImageView ivB;
        public ImageView ivH;
        public ImageView ivM;
        public ImageView ivQB;
        public ImageView ivQM;
        public LinearLayout ll;
        public LinearLayout llFooter;
        public LinearLayout llMusic;
        public LinearLayout llSub;
        public RelativeLayout rlHeader;
        public RelativeLayout rlImage;
        public RelativeLayout rlMain;
        public TextView tvMain;
        public TextView tvMainH;
        public TextView tvMainM;
        public TextView tvSideM;
        public TextView tvSub;
        public TextView tvSubH;
        public TextView tvSubM;

        private ViewHolder()
        {
        }

        ViewHolder(_cls1 _pcls1)
        {
            this();
        }
    }

}
