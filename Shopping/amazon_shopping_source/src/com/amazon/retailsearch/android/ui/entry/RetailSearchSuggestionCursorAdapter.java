// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            ActionViewBuilder, SuggestionsItemListener

public class RetailSearchSuggestionCursorAdapter extends CursorAdapter
{

    private SuggestionsItemListener listener;
    private Context mContext;
    private Cursor mCursor;
    private Pattern mPattern;
    private String mSearchTerm;
    private QuerySubmitListener querySubmitListener;

    public RetailSearchSuggestionCursorAdapter(Context context, Cursor cursor, boolean flag, String s, SuggestionsItemListener suggestionsitemlistener, QuerySubmitListener querysubmitlistener)
    {
        super(context, cursor, flag);
        RetailSearchDaggerGraphController.inject(this);
        mContext = context;
        updateSearchTerm(s);
        mCursor = cursor;
        listener = suggestionsitemlistener;
        querySubmitListener = querysubmitlistener;
    }

    public static boolean isActionRow(Cursor cursor)
    {
        return Integer.parseInt(cursor.getString(cursor.getColumnIndex("suggest_icon_1"))) > -1;
    }

    private void setSuggestionBold(TextView textview, String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        int i;
        byte byte0;
        obj = textview.getText().toString();
        String s1 = SearchConfiguration.getConfiguration().getRealm().getLocale();
        byte0 = -1;
        if (!Locale.CHINA.toString().equals(s1) && !Locale.JAPAN.toString().equals(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        i = ((String) (obj)).toLowerCase().indexOf(s.toLowerCase());
_L4:
        if (i > -1)
        {
            obj = new SpannableString(((CharSequence) (obj)));
            ((SpannableString) (obj)).setSpan(new StyleSpan(1), i, s.length() + i, 18);
            textview.setText(((CharSequence) (obj)));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        i = byte0;
        if (mPattern != null)
        {
            Matcher matcher = mPattern.matcher(((String) (obj)).toLowerCase());
            i = byte0;
            if (matcher.find())
            {
                i = matcher.end(1);
            }
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void updateActionView(Context context, Cursor cursor, LinearLayout linearlayout)
    {
        boolean flag1 = true;
        ((LinearLayout)linearlayout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_suggestions)).setVisibility(8);
        context = (LinearLayout)linearlayout.findViewById(com.amazon.retailsearch.R.id.rs_entry_action);
        context.setVisibility(0);
        int i = Integer.parseInt(cursor.getString(cursor.getColumnIndex("suggest_icon_1")));
        context = new ActionViewBuilder(context, querySubmitListener);
        boolean flag;
        if ((i & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.showVoice = flag;
        if ((i & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.showScan = flag;
        if ((i & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.showSnap = flag;
        if ((i & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.showFlow = flag;
        if ((i & 0x10) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        context.showVisualScan = flag;
        context.build();
    }

    private View updateItemView(Context context, Cursor cursor, LinearLayout linearlayout)
    {
        if (android.os.Build.VERSION.SDK_INT > 10)
        {
            linearlayout.setAlpha(1.0F);
        } else
        {
            linearlayout.setVisibility(0);
        }
        if (isActionRow(cursor))
        {
            updateActionView(context, cursor, linearlayout);
            return linearlayout;
        } else
        {
            updateSuggestionItemView(context, cursor, linearlayout);
            return linearlayout;
        }
    }

    private void updateSuggestionItemView(final Context id, Cursor cursor, final LinearLayout layout)
    {
        ((LinearLayout)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_suggestions)).setVisibility(0);
        ((LinearLayout)layout.findViewById(com.amazon.retailsearch.R.id.rs_entry_action)).setVisibility(8);
        final String searchSuggestion = cursor.getString(cursor.getColumnIndex("suggest_text_1"));
        final Object deleteURL = (TextView)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_text);
        ((TextView) (deleteURL)).setText(searchSuggestion);
        setSuggestionBold(((TextView) (deleteURL)), mSearchTerm);
        String s = cursor.getString(cursor.getColumnIndex("suggest_intent_extra_data"));
        ImageView imageview = (ImageView)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_clear);
        int i;
        if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.PAST_SEARCHES.name().equals(s) || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.name().equals(s))
        {
            ((TextView) (deleteURL)).setTextColor(id.getResources().getColor(com.amazon.retailsearch.R.color.rs_search_iss_pastsearches));
            id = cursor.getString(cursor.getColumnIndex("intent_extra_data_key"));
            deleteURL = cursor.getString(cursor.getColumnIndex("suggest_text_2_url"));
            imageview.setVisibility(0);
            imageview.setOnClickListener(new android.view.View.OnClickListener() {

                final RetailSearchSuggestionCursorAdapter this$0;
                final String val$deleteURL;
                final String val$id;
                final LinearLayout val$layout;

                public void onClick(View view)
                {
                    if (listener != null)
                    {
                        listener.onDeletePastSearchesClick(id, deleteURL);
                    }
                    if (android.os.Build.VERSION.SDK_INT > 10)
                    {
                        view = new AlphaAnimation(1.0F, 0.0F);
                        view.setDuration(500L);
                        view.setRepeatCount(0);
                        view.setFillAfter(true);
                        layout.startAnimation(view);
                        return;
                    } else
                    {
                        layout.setVisibility(8);
                        return;
                    }
                }

            
            {
                this$0 = RetailSearchSuggestionCursorAdapter.this;
                id = s;
                deleteURL = s1;
                layout = linearlayout;
                super();
            }
            });
        } else
        {
            ((TextView) (deleteURL)).setTextColor(id.getResources().getColor(0x106000c));
            imageview.setVisibility(8);
            if (listener != null)
            {
                listener.onA9SuggestionShow();
            }
        }
        i = cursor.getColumnIndex("suggest_text_2");
        id = (TextView)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_department);
        cursor = cursor.getString(i);
        if (!TextUtils.isEmpty(cursor))
        {
            cursor = mContext.getResources().getString(com.amazon.retailsearch.R.string.rs_search_suggestions_department_text, new Object[] {
                cursor
            });
            id.setVisibility(0);
            id.setText(cursor);
        } else
        {
            id.setVisibility(8);
        }
        id = (ImageView)layout.findViewById(com.amazon.retailsearch.R.id.rs_search_dropdown_item_query_builder);
        id.setVisibility(0);
        id.setOnClickListener(new android.view.View.OnClickListener() {

            final RetailSearchSuggestionCursorAdapter this$0;
            final String val$searchSuggestion;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    listener.onQueryBuilderClick(searchSuggestion);
                }
            }

            
            {
                this$0 = RetailSearchSuggestionCursorAdapter.this;
                searchSuggestion = s;
                super();
            }
        });
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        updateItemView(context, cursor, (LinearLayout)view);
    }

    public CharSequence convertToString(Cursor cursor)
    {
        return cursor.getString(cursor.getColumnIndex("suggest_text_1"));
    }

    public int getCount()
    {
        if (mCursor == null)
        {
            return 0;
        } else
        {
            return mCursor.getCount();
        }
    }

    public Cursor getCursor()
    {
        return mCursor;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return updateItemView(context, cursor, (LinearLayout)LayoutInflater.from(context).inflate(com.amazon.retailsearch.R.layout.rs_search_dropdown_item, viewgroup, false));
    }

    public void updateContent(String s, Cursor cursor)
    {
        updateSearchTerm(s);
        swapCursor(cursor);
        mCursor = cursor;
    }

    public void updateSearchTerm(String s)
    {
        mSearchTerm = s;
        if (!TextUtils.isEmpty(s))
        {
            mPattern = Pattern.compile((new StringBuilder()).append("(^|(?:\\s))").append(Pattern.quote(mSearchTerm.toLowerCase())).toString());
        }
    }

}
