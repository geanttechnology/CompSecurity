// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.downloads.DownloadServiceException;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownloadProgressBar extends RelativeLayout
{

    protected final Logger LOG;
    private ImageButton cancelDownloadBtn;
    private ProgressBar downloadProgressBar;
    private TextView downloadProgressText;
    private TextView downloadSizeText;
    private ImageButton hotwireDownloadBtn;
    private LayoutInflater inflator;
    private ImageButton retryDownloadBtn;
    boolean showHotwireButton;
    boolean showSize;

    public DownloadProgressBar(Context context)
    {
        super(context);
        LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/widget/DownloadProgressBar);
        showSize = true;
        showHotwireButton = true;
        initialize(context, null);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/widget/DownloadProgressBar);
        showSize = true;
        showHotwireButton = true;
        initialize(context, attributeset);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/widget/DownloadProgressBar);
        showSize = true;
        showHotwireButton = true;
        initialize(context, attributeset);
    }

    private void initialize(Context context, AttributeSet attributeset)
    {
        if (attributeset != null)
        {
            attributeset = context.obtainStyledAttributes(attributeset, com.xfinity.playerlib.R.styleable.com_xfinity_playerlib_view_widget_DownloadProgressBar);
            showSize = attributeset.getBoolean(com.xfinity.playerlib.R.styleable.com_xfinity_playerlib_view_widget_DownloadProgressBar_showSize, true);
            showHotwireButton = attributeset.getBoolean(com.xfinity.playerlib.R.styleable.com_xfinity_playerlib_view_widget_DownloadProgressBar_showHotwireButton, true);
            attributeset.recycle();
        }
        inflator = (LayoutInflater)context.getSystemService("layout_inflater");
        context = (ViewGroup)inflator.inflate(com.xfinity.playerlib.R.layout.download_progress, this, true);
        downloadProgressText = (TextView)context.findViewById(com.xfinity.playerlib.R.id.download_progress_text);
        downloadProgressBar = (ProgressBar)context.findViewById(com.xfinity.playerlib.R.id.download_progress_bar);
        downloadSizeText = (TextView)context.findViewById(com.xfinity.playerlib.R.id.download_size_text);
        cancelDownloadBtn = (ImageButton)context.findViewById(com.xfinity.playerlib.R.id.cancel_download_button);
        hotwireDownloadBtn = (ImageButton)context.findViewById(com.xfinity.playerlib.R.id.hotwire_download_button);
        retryDownloadBtn = (ImageButton)context.findViewById(com.xfinity.playerlib.R.id.retry_download_button);
        if (!showSize)
        {
            downloadSizeText.setVisibility(8);
        }
    }

    private void setProgressText(int i)
    {
        downloadProgressText.setText(getContext().getResources().getText(i));
        requestLayout();
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final DownloadProgressBar this$0;

            public void onGlobalLayout()
            {
label0:
                {
                    int j = downloadProgressBar.getWidth();
                    int k = downloadProgressText.getWidth();
                    int l = downloadSizeText.getWidth();
                    if (j != 0 && k != 0 && l != 0)
                    {
                        if (j - k >= l)
                        {
                            downloadSizeText.setVisibility(0);
                        } else
                        {
                            downloadSizeText.setVisibility(8);
                        }
                        if (android.os.Build.VERSION.SDK_INT < 16)
                        {
                            break label0;
                        }
                        downloadProgressBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    return;
                }
                downloadProgressBar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }

            
            {
                this$0 = DownloadProgressBar.this;
                super();
            }
        });
    }

    public void setButtonsEnable(boolean flag)
    {
        cancelDownloadBtn.setEnabled(flag);
        if (showHotwireButton)
        {
            hotwireDownloadBtn.setEnabled(flag);
            retryDownloadBtn.setEnabled(flag);
        }
    }

    public void setOnCancelListener(android.view.View.OnClickListener onclicklistener)
    {
        cancelDownloadBtn.setOnClickListener(onclicklistener);
    }

    public void setOnHotwireDownloadClickListener(android.view.View.OnClickListener onclicklistener)
    {
        hotwireDownloadBtn.setOnClickListener(onclicklistener);
    }

    public void setOnRetryDownloadClickListener(android.view.View.OnClickListener onclicklistener)
    {
        retryDownloadBtn.setOnClickListener(onclicklistener);
    }

    public void setProgress(PlayerDownloadFile playerdownloadfile, PlayerDownloadServiceManager playerdownloadservicemanager, InternetConnection internetconnection)
    {
        boolean flag = false;
        downloadSizeText.setText(String.format(Locale.US, getContext().getResources().getString(com.xfinity.playerlib.R.string.download_MB_text), new Object[] {
            Integer.valueOf(playerdownloadfile.getExpectedFileSizeInMb())
        }));
        com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus = playerdownloadfile.getAsset().downloadStatus();
        com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus evirtuosodownloadenginestatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors;
        try
        {
            playerdownloadservicemanager = playerdownloadservicemanager.getDownloadEngineStatus().status();
        }
        // Misplaced declaration of an exception variable
        catch (PlayerDownloadServiceManager playerdownloadservicemanager)
        {
            LOG.error(playerdownloadservicemanager.getMessage(), playerdownloadservicemanager);
            playerdownloadservicemanager = evirtuosodownloadenginestatus;
        }
        if (playerdownloadservicemanager.equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused))
        {
            setProgressText(com.xfinity.playerlib.R.string.state_paused_text);
            if (showHotwireButton)
            {
                hotwireDownloadBtn.setVisibility(4);
                retryDownloadBtn.setVisibility(8);
            }
            cancelDownloadBtn.setVisibility(0);
        } else
        if (playerdownloadservicemanager.equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked) || playerdownloadservicemanager.equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors))
        {
            if (playerdownloadfile.getAsset().downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending)
            {
                setProgressText(com.xfinity.playerlib.R.string.state_interrupted_text);
                if (showHotwireButton)
                {
                    hotwireDownloadBtn.setVisibility(4);
                    retryDownloadBtn.setVisibility(8);
                }
                cancelDownloadBtn.setVisibility(0);
            } else
            {
                if (efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Mime_Mismatch || efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Size_Mismatch || efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Reachability_Error || efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Network_Error && internetconnection.isConnectedOnWiFi())
                {
                    setProgressText(com.xfinity.playerlib.R.string.state_error_text);
                    if (showHotwireButton)
                    {
                        retryDownloadBtn.setVisibility(0);
                        hotwireDownloadBtn.setVisibility(8);
                    }
                } else
                {
                    setProgressText(com.xfinity.playerlib.R.string.state_interrupted_text);
                    if (showHotwireButton)
                    {
                        hotwireDownloadBtn.setVisibility(4);
                        retryDownloadBtn.setVisibility(8);
                    }
                }
                cancelDownloadBtn.setVisibility(0);
            }
        } else
        if (efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading)
        {
            setProgressText(com.xfinity.playerlib.R.string.state_downloading_text);
            if (showHotwireButton)
            {
                hotwireDownloadBtn.setVisibility(4);
                retryDownloadBtn.setVisibility(8);
            }
            cancelDownloadBtn.setVisibility(0);
            flag = true;
        } else
        if (efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Pending || efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Mime_Mismatch || efiledownloadstatus == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Size_Mismatch)
        {
            setProgressText(com.xfinity.playerlib.R.string.state_waiting_text);
            if (showHotwireButton)
            {
                hotwireDownloadBtn.setVisibility(0);
                retryDownloadBtn.setVisibility(8);
            }
            cancelDownloadBtn.setVisibility(0);
        } else
        {
            setProgressText(com.xfinity.playerlib.R.string.state_interrupted_text);
            if (showHotwireButton)
            {
                hotwireDownloadBtn.setVisibility(4);
                retryDownloadBtn.setVisibility(8);
            }
            cancelDownloadBtn.setVisibility(0);
        }
        if (playerdownloadfile != null && playerdownloadfile.getPercentComplete() > 1)
        {
            downloadProgressBar.setProgress(playerdownloadfile.getPercentComplete());
        } else
        {
            playerdownloadservicemanager = downloadProgressBar;
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            playerdownloadservicemanager.setProgress(i);
        }
        downloadProgressBar.setEnabled(flag);
        playerdownloadfile = getContext().getString(com.xfinity.playerlib.R.string.content_description_file_size_megabytes, new Object[] {
            Integer.valueOf(playerdownloadfile.getExpectedFileSizeInMb())
        });
        downloadProgressText.setContentDescription(playerdownloadfile);
    }



}
