// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.poshmark.data_model.adapters.PinterestBoardListAdapter;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.PinterestBoard;
import com.poshmark.utils.meta_data.PinterestBoardList;
import com.poshmark.utils.meta_data.PinterestBoardPickerInfo;
import com.poshmark.utils.meta_data.PinterestSettings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class PinterestBoardPickerFragment extends PMFragment
{

    PinterestBoardListAdapter adapter;
    PinterestBoardPickerInfo data;
    LinearLayout disablePinLayout;
    android.widget.AdapterView.OnItemClickListener itemClickListener;
    ListView lv;
    int mode;
    PinterestSettings pins;

    public PinterestBoardPickerFragment()
    {
        mode = -1;
        itemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final PinterestBoardPickerFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (PinterestBoard)view.getTag();
                adapterview.enabled = true;
                data.currentSelection = adapterview;
                adapter.notifyDataSetChanged();
                postSelectedBoard();
            }

            
            {
                this$0 = PinterestBoardPickerFragment.this;
                super();
            }
        };
    }

    private void postSelectedBoard()
    {
        Map map = data.currentSelection.getBoardHash();
        HashMap hashmap = new HashMap();
        if (2 == mode)
        {
            hashmap.put("self_board", map);
        } else
        {
            hashmap.put("others_board", map);
        }
        showProgressDialogWithMessage(getResources().getString(0x7f060190));
        PMApi.postPinterestBoardsUpdate(hashmap, new PMApiResponseHandler() {

            final PinterestBoardPickerFragment this$0;
            final String val$json;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                Log.d("PinterestBoardPicker", pmapiresponse.responseString);
                pmapiresponse = (PMFragment)getTargetFragment();
                if (pmapiresponse != null)
                {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("DATA_SELECTED", json);
                    intent.putExtra("RETURNED_RESULTS", bundle);
                    pmapiresponse.onActivityResult(mode, -1, intent);
                    pmapiresponse = getActivity();
                    hideProgressDialog();
                    if (pmapiresponse != null)
                    {
                        pmapiresponse.onBackPressed();
                    }
                }
            }

            
            {
                this$0 = PinterestBoardPickerFragment.this;
                json = s;
                super();
            }
        });
    }

    private void setFooterView()
    {
        PMTextView pmtextview = (PMTextView)disablePinLayout.findViewById(0x7f0c0208);
        final ImageView checkMark = (ImageView)disablePinLayout.findViewById(0x7f0c0097);
        pmtextview.setText(0x7f0600be);
        lv.addFooterView(disablePinLayout);
        disablePinLayout.setOnClickListener(new android.view.View.OnClickListener() {

            final PinterestBoardPickerFragment this$0;
            final ImageView val$checkMark;

            public void onClick(View view)
            {
                checkMark.setVisibility(0);
                view = new PinterestBoard();
                view.enabled = false;
                view.name = "";
                view.board_id = "0";
                data.currentSelection = view;
                adapter.notifyDataSetChanged();
                postSelectedBoard();
            }

            
            {
                this$0 = PinterestBoardPickerFragment.this;
                checkMark = imageview;
                super();
            }
        });
        if (!data.currentSelection.isEnabled())
        {
            checkMark.setVisibility(0);
            pmtextview.setTypeface(null, 1);
            pmtextview.setTextColor(getResources().getColor(0x7f09003c));
        }
    }

    private void setupView()
    {
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(itemClickListener);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        showProgressDialogWithMessage(getResources().getString(0x7f060190));
        PMApi.getPinterestBoards(new PMApiResponseHandler() {

            final PinterestBoardPickerFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    Log.d("PinterestBoardPicker", pmapiresponse.responseString);
                    pmapiresponse = (PinterestBoardList)pmapiresponse.data;
                    if (pmapiresponse != null)
                    {
                        pmapiresponse = pmapiresponse.getBoards();
                        data.allboards.clear();
                        data.setAllboards(pmapiresponse);
                        adapter.notifyDataSetChanged();
                        setFooterView();
                    }
                    hideProgressDialog();
                    return;
                } else
                {
                    showAutoHideProgressDialogWithMessage(getString(0x7f06022e), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                        final _cls1 this$1;

                        public void dialogDismissed()
                        {
                            ((PMContainerActivity)getActivity()).popTopNFragments(2, true);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = PinterestBoardPickerFragment.this;
                super();
            }
        });
        setupView();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        data = new PinterestBoardPickerInfo();
        mode = getArguments().getInt("mode");
        pins = (PinterestSettings)getFragmentDataOfType(com/poshmark/utils/meta_data/PinterestSettings);
        if (2 == mode)
        {
            data.currentSelection = pins.self_board;
            viewNameForAnalytics = "my_listings_select_board_screen";
            return;
        } else
        {
            data.currentSelection = pins.others_board;
            viewNameForAnalytics = "my_shares_select_board_screen";
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        viewgroup = layoutinflater.inflate(0x7f03009f, null);
        lv = (ListView)viewgroup.findViewById(0x7f0c025f);
        adapter = new PinterestBoardListAdapter(getActivity(), 0x7f03009d, data);
        disablePinLayout = (LinearLayout)layoutinflater.inflate(0x7f03009e, null);
        return viewgroup;
    }

    public void onPMResume()
    {
        super.onPMResume();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void setViewNameForAnalytics()
    {
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(0x7f06023f);
    }


}
