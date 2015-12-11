// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.android.accessibility.AlternateInterfaceUtil;
import com.comcast.cim.android.accessibility.SpeechActions;
import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.android.accessibility.SpeechRecognizer;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.container.PlayerContainer;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.browseprograms.SortPolicy;
import com.xfinity.playerlib.view.common.UpsellDialog;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class PlayerSpeechRecognizer extends SpeechRecognizer
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener
{

    private SortPolicy sortPolicy;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;

    public PlayerSpeechRecognizer()
    {
        taskExecutor = PlayerContainer.getInstance().getProgramsAndTagsAndEntitlementTaskExecutor();
    }

    public void attemptSearch(final String terms[], final SpeechPresentationMode presentationMode)
    {
        taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

            final PlayerSpeechRecognizer this$0;
            final SpeechPresentationMode val$presentationMode;
            final String val$terms[];

            public void onError(TaskExecutionException taskexecutionexception)
            {
                SpeechRecognizer.this.onError(0);
            }

            public void onPostExecute(Tuple3 tuple3)
            {
                Object obj = (DibicResource)tuple3.e1;
                tuple3 = (VideoEntitlement)tuple3.e3;
                obj = ((DibicResource) (obj)).getProgramsMatchingTitleFilter(StringUtils.join(terms, " "));
                if (((List) (obj)).size() == 1 && !presentationMode.equals(SpeechPresentationMode.SEARCH))
                {
                    obj = (DibicProgram)((List) (obj)).get(0);
                    if (presentationMode.equals(SpeechPresentationMode.PLAY) && ((DibicProgram) (obj)).isMovie())
                    {
                        if (tuple3.isEntitled(((DibicProgram) (obj))))
                        {
                            playVideo(((DibicProgram) (obj)).getMerlinId(), ((DibicProgram) (obj)).getParentMerlinIdIfApplicable());
                            return;
                        } else
                        {
                            closeWithNotEntitledDibicProgram(((DibicProgram) (obj)), com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK);
                            return;
                        }
                    } else
                    {
                        showVideoDetails(((DibicProgram) (obj)));
                        return;
                    }
                } else
                {
                    createSearchIntent(terms);
                    return;
                }
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((Tuple3)obj);
            }

            
            {
                this$0 = PlayerSpeechRecognizer.this;
                terms = as;
                presentationMode = speechpresentationmode;
                super();
            }
        });
    }

    protected boolean checkTitleMatch(String s, String s1)
    {
        return s.toLowerCase().contains(s1);
    }

    protected void closeWithAction(SpeechActions speechactions)
    {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_ACTION", (new StringBuilder()).append(speechactions).append("").toString());
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    protected void closeWithIgnore()
    {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_ACTION", (new StringBuilder()).append(SpeechActions.IGNORE_REENTRY).append("").toString());
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    protected void closeWithNotEntitledDibicProgram(DibicProgram dibicprogram, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType upselltype)
    {
        android.app.FragmentManager fragmentmanager = getFragmentManager();
        dibicprogram = UpsellDialog.newInstance(upselltype, dibicprogram);
        dibicprogram.show(fragmentmanager, "upsell_dialog");
        dibicprogram.setOnCancelListener(this);
        dibicprogram.setOnDismissListener(this);
    }

    protected void createSearchIntent(String as[])
    {
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putStringArray("KEY_TERMS", as);
        bundle.putString("KEY_ACTION", (new StringBuilder()).append(SpeechActions.SEARCH).append("").toString());
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    protected SortPolicy getSortPolicy()
    {
        return sortPolicy;
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        return taskExecutionListener;
    }

    protected TaskExecutor getTaskExecutor()
    {
        return taskExecutor;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        closeWithIgnore();
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        closeWithIgnore();
    }

    protected void onStop()
    {
        super.onStop();
        if (getTaskExecutor() != null)
        {
            getTaskExecutor().cancelNotificationsFor(getTaskExecutionListener());
        }
    }

    protected void playLiveStream(String s, HalLiveStreamResource hallivestreamresource, VideoEntitlement videoentitlement)
    {
        hallivestreamresource = hallivestreamresource.getLiveStream(s);
        List list = hallivestreamresource.getProviderCodes();
        if (videoentitlement.isEntitledToList((String[])list.toArray(new String[list.size()])))
        {
            startActivity(VideoPlayerActivity.createIntentForPlayer(s));
            closeWithIgnore();
            return;
        } else
        {
            s = getFragmentManager();
            hallivestreamresource = UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAY_FROM_HISTORY, hallivestreamresource);
            hallivestreamresource.show(s, "upsell_dialog");
            hallivestreamresource.setOnCancelListener(this);
            hallivestreamresource.setOnDismissListener(this);
            return;
        }
    }

    protected boolean playOrShowIfEpisodeMatches(String s, SpeechPresentationMode speechpresentationmode, VideoBookmark videobookmark, DibicProgram dibicprogram, VideoEntitlement videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType upselltype)
    {
        if (!videobookmark.isMovie() && (videobookmark.getTitle().toLowerCase().contains(s) || dibicprogram.getTitle().toLowerCase().contains(s)))
        {
            if (speechpresentationmode.equals(SpeechPresentationMode.PLAY))
            {
                if (videoentitlement.isEntitled(dibicprogram))
                {
                    playVideo(videobookmark.getMerlinId(), videobookmark.getParentMerlinIdIfApplicable());
                } else
                {
                    closeWithNotEntitledDibicProgram(dibicprogram, upselltype);
                }
            } else
            {
                showSeriesFromVideoBookmark(videobookmark);
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean playOrShowIfProgramMatches(String s, EditorialProgram editorialprogram, DibicResource dibicresource, SpeechPresentationMode speechpresentationmode, VideoEntitlement videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType upselltype)
    {
        if (editorialprogram.getTitle().toLowerCase().contains(s))
        {
            if (editorialprogram.isMovie())
            {
                s = editorialprogram.getMerlinId();
            } else
            {
                s = editorialprogram.getParentMerlinIdIfApplicable();
            }
            playOrShowVideo(dibicresource.getProgramByMerlinId(s), speechpresentationmode, videoentitlement, upselltype);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean playOrShowIfValidListNumber(List list, String as[], SpeechPresentationMode speechpresentationmode, VideoEntitlement videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType upselltype)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (as.length == 1)
        {
            int i = alternateInterfaceUtil.interpretIfNumber(as[0]);
            flag = flag1;
            if (i > -1)
            {
                if (i <= list.size())
                {
                    playOrShowVideo((DibicProgram)list.get(i - 1), speechpresentationmode, videoentitlement, upselltype);
                } else
                {
                    getTalkDelegate().speak(getString(com.xfinity.playerlib.R.string.list_number_invalid, new Object[] {
                        Integer.valueOf(i), Integer.valueOf(list.size())
                    }));
                }
                flag = true;
            }
        }
        return flag;
    }

    protected boolean playOrShowIfVideoMatches(String s, DibicProgram dibicprogram, SpeechPresentationMode speechpresentationmode, VideoEntitlement videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType upselltype)
    {
        if (checkTitleMatch(dibicprogram.getTitle(), s))
        {
            playOrShowVideo(dibicprogram, speechpresentationmode, videoentitlement, upselltype);
            return true;
        } else
        {
            return false;
        }
    }

    protected void playOrShowVideo(DibicProgram dibicprogram, SpeechPresentationMode speechpresentationmode, VideoEntitlement videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType upselltype)
    {
        if (videoentitlement.isEntitled(dibicprogram))
        {
            if (speechpresentationmode.equals(SpeechPresentationMode.PLAY) && dibicprogram.isMovie())
            {
                playVideo(dibicprogram.getMerlinId(), dibicprogram.getParentMerlinIdIfApplicable());
                return;
            } else
            {
                showVideoDetails(dibicprogram.getMerlinId(), dibicprogram.isMovie());
                return;
            }
        } else
        {
            closeWithNotEntitledDibicProgram(dibicprogram, upselltype);
            return;
        }
    }

    protected void playVideo(MerlinId merlinid, MerlinId merlinid1)
    {
        Intent intent = new Intent(this, com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
        intent.putExtras(VideoPlayerActivity.createBundle(merlinid, merlinid1, 0L, 0L));
        startActivity(intent);
        startActivity(intent);
        closeWithIgnore();
    }

    protected void showSeriesFromVideoBookmark(VideoBookmark videobookmark)
    {
        videobookmark = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(videobookmark)).loadAsActivity(true).build().getIntent(getBaseContext());
        videobookmark.putExtra("KEY_ANNOUNCE_EPISODES", true);
        startActivity(videobookmark);
        closeWithIgnore();
    }

    protected void showVideoDetails(MerlinId merlinid, boolean flag)
    {
        merlinid = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(merlinid)).build().getIntent(this);
        if (!flag && isAccessibilityEnabled())
        {
            merlinid.putExtra("KEY_ANNOUNCE_EPISODES", true);
        }
        startActivity(merlinid);
        closeWithIgnore();
    }

    protected void showVideoDetails(DibicProgram dibicprogram)
    {
        Intent intent = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(dibicprogram)).build().getIntent(this);
        if (!dibicprogram.isMovie() && isAccessibilityEnabled())
        {
            intent.putExtra("KEY_ANNOUNCE_EPISODES", true);
        }
        startActivity(intent);
        closeWithIgnore();
    }

    protected List sortList(List list)
    {
        SortPolicy sortpolicy = getSortPolicy();
        if (sortpolicy.getCurrentSortComparator() != null)
        {
            list = Lists.newArrayList(list);
            Collections.sort(list, sortpolicy.getCurrentSortComparator());
            return list;
        } else
        {
            return list;
        }
    }

}
