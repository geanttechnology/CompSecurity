// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.utils.UIPresentationUtil;
import com.xfinity.playerlib.image.ProgramDetailArtImageLoader;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.MovieFacade;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.favorite.BookmarkMenuItemDelegate;
import java.util.Map;
import java.util.SortedSet;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment, EpisodeBookmarkCache

public class MovieDetailFragment extends DetailFragment
{

    private AlternateInterfaceListener alternateInterfaceListener;
    private TextView availability;
    private TaskExecutionListener bookmarkListener;
    protected BookmarkMenuItemDelegate bookmarkMenuItemDelegate;
    private TaskExecutor bookmarkProvider;
    private TextView castText;
    private TextView descriptionText;
    private ImageView detailArtView;
    private Task dibicResourceCache;
    private TextView duration;
    private TextView errorText;
    private CheckBox favoriteIndicator;
    private TextView infoTitle;
    private LayoutInflater layoutInflator;
    private TaskFactory movieCacheMap;
    private MovieFacade movieFacade;
    private VideoFavorite movieFavorite;
    private View newIndicator;
    private ViewGroup newReleaseYearContainer;
    private TextView releaseYearText;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;
    private TaskExecutorFactory taskExecutorFactory;
    private Task videoEntitlementCache;
    private ViewGroup videoItemContainer;

    public MovieDetailFragment()
    {
        movieFacade = null;
        taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
        videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();
        movieCacheMap = PlayerContainer.getInstance().getMovieCacheMap();
        dibicResourceCache = PlayerContainer.getInstance().getDibicCombinedCache();
        bookmarkMenuItemDelegate = new BookmarkMenuItemDelegate(PlayerContainer.getInstance().getBookmarkUtils());
    }

    public int getDetailLayoutId()
    {
        if (instanceState.showPanelFittedLayout)
        {
            return com.xfinity.playerlib.R.layout.movie_detail;
        } else
        {
            return com.xfinity.playerlib.R.layout.layout_movie_entity_view;
        }
    }

    public ViewGroup getVideoItemViewContainer()
    {
        return videoItemContainer;
    }

    public void loadScreenInfo()
    {
        Object obj;
        if (instanceState.useDownloadAsSource())
        {
            obj = new NonCachingBaseTask() {

                final MovieDetailFragment this$0;

                public HalMovieConsumable execute()
                {
                    Object obj1 = downloadManager.findFileWithVideoId(instanceState.watchableKey.getVideoId());
                    if (obj1 != null)
                    {
                        obj1 = downloadManager.getStoredEntity(((PlayerDownloadFile) (obj1)).getUuid());
                        if (obj1 != null)
                        {
                            return (HalMovieConsumable)((Either) (obj1)).e1;
                        }
                    }
                    return (HalMovieConsumable)movieCacheMap.get(instanceState.merlinId).execute();
                }

                public volatile Object execute()
                {
                    return execute();
                }

            
            {
                this$0 = MovieDetailFragment.this;
                super();
            }
            };
        } else
        {
            obj = movieCacheMap.get(instanceState.merlinId);
        }
        taskExecutor = taskExecutorFactory.create(videoEntitlementCache, ((Task) (obj)), dibicResourceCache);
        taskExecutionListener = new DefaultTaskExecutionListener() {

            final MovieDetailFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                onLoadingFailed();
            }

            public void onPostExecute(Tuple3 tuple3)
            {
                errorText.setVisibility(8);
                final VideoEntitlement entitlement = (VideoEntitlement)tuple3.e1;
                HalMovieConsumable halmovieconsumable = (HalMovieConsumable)tuple3.e2;
                dibicResource = (DibicResource)tuple3.e3;
                if (instanceState.showPanelFittedLayout)
                {
                    int i = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.detail_art_land_2x_width);
                    int j = getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.detail_art_land_2x_height);
                    programDetailArtImageLoader.loadDetailProgramArt(halmovieconsumable.getMerlinEntityId(), detailArtView, i, j);
                } else
                {
                    programDetailArtImageLoader.loadDetailProgramArt(halmovieconsumable.getMerlinEntityId(), detailArtView);
                }
                tuple3 = dibicResource.getProgramByMerlinId(halmovieconsumable.getMerlinEntityId());
                if (tuple3 != null)
                {
                    try
                    {
                        movieFacade = new MovieFacade(halmovieconsumable);
                        bookmarkProvider = taskExecutorFactory.create(new EpisodeBookmarkCache(bookmarkDAO, movieFacade));
                        bookmarkListener = bookmarkProvider.execute(tuple3. new DefaultTaskExecutionListener() {

                            final _cls2 this$1;
                            final DibicProgram val$dibicMovie;
                            final VideoEntitlement val$entitlement;

                            public void onError(TaskExecutionException taskexecutionexception)
                            {
                                onLoadingFailed();
                            }

                            public volatile void onPostExecute(Object obj)
                            {
                                onPostExecute((Map)obj);
                            }

                            public void onPostExecute(Map map)
                            {
                                presentConsumableMovie(map, entitlement, dibicMovie);
                                onLoadingFinished();
                                detailArtView.setVisibility(0);
                            }

            
            {
                this$1 = final__pcls2;
                entitlement = videoentitlement;
                dibicMovie = DibicProgram.this;
                super();
            }
                        });
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Tuple3 tuple3)
                    {
                        showFailureState(tuple3);
                    }
                    break MISSING_BLOCK_LABEL_259;
                }
                showFailureState(null);
                return;
                
// JavaClassFileOutputException: get_constant: invalid tag

            public volatile void onPostExecute(Object obj1)
            {
                onPostExecute((Tuple3)obj1);
            }

            public void onPreAsynchronousExecute()
            {
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
            }

            
            {
                this$0 = MovieDetailFragment.this;
                super();
            }
        };
        taskExecutor.execute(taskExecutionListener);
    }

    public void onAttach(Activity activity)
    {
        onAttach(activity);
        playPressedListener = (DetailFragment.PlayPressedListener)activity;
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        onCreateOptionsMenu(menu, menuinflater);
        bookmarkMenuItemDelegate.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = onCreateView(layoutinflater, viewgroup, bundle);
        layoutInflator = layoutinflater;
        detailArtView = (ImageView)viewgroup.findViewById(com.xfinity.playerlib.R.id.detail_image);
        infoTitle = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.info_title);
        newReleaseYearContainer = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.new_release_year_container);
        newIndicator = newReleaseYearContainer.findViewById(com.xfinity.playerlib.R.id.new_indicator);
        releaseYearText = (TextView)newReleaseYearContainer.findViewById(com.xfinity.playerlib.R.id.release_year);
        availability = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.availability);
        duration = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.duration);
        videoItemContainer = (LinearLayout)viewgroup.findViewById(com.xfinity.playerlib.R.id.video_item_container);
        castText = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.cast);
        descriptionText = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.description);
        favoriteIndicator = (CheckBox)viewgroup.findViewById(com.xfinity.playerlib.R.id.favorite_indicator);
        setupReviews(viewgroup);
        errorText = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.movie_detail_error_text);
        if (isFullScreen)
        {
            setHasOptionsMenu(true);
        }
        return viewgroup;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return bookmarkMenuItemDelegate.onOptionsItemSelected(menuitem, this, movieFavorite);
    }

    public void onPause()
    {
        onPause();
        if (taskExecutor != null)
        {
            taskExecutor.cancelNotificationsFor(taskExecutionListener);
        }
        if (bookmarkProvider != null)
        {
            bookmarkProvider.cancelNotificationsFor(bookmarkListener);
        }
    }

    public void onStartInternal()
    {
        onStartInternal();
        errorText.setVisibility(8);
    }

    public void onStop()
    {
        onStop();
        if (taskExecutor != null)
        {
            taskExecutor.cancelNotificationsFor(taskExecutionListener);
        }
        if (bookmarkProvider != null)
        {
            bookmarkProvider.cancelNotificationsFor(bookmarkListener);
        }
    }

    public void presentConsumableMovie(Map map, VideoEntitlement videoentitlement, DibicProgram dibicprogram)
    {
        SortedSet sortedset = getSortedVideos(videoentitlement, movieFacade);
        setDisplayTitle(movieFacade.getDisplayTitle(), infoTitle);
        movieFavorite = new VideoFavorite(movieFacade.getMerlinId(), movieFacade.getDisplayTitle(), dibicprogram.isAdult());
        bookmarkMenuItemDelegate.setupFavorite(this, isFullScreen, favoriteIndicator, movieFavorite);
        if (movieFacade.isNew() || movieFacade.getReleaseYear() != null)
        {
            if (movieFacade.isNew())
            {
                newIndicator.setVisibility(0);
            } else
            {
                newIndicator.setVisibility(8);
            }
            dibicprogram = movieFacade.getReleaseYear();
            if (dibicprogram != null)
            {
                dibicprogram = getResources().getString(com.xfinity.playerlib.R.string.release_year, new Object[] {
                    dibicprogram
                });
                releaseYearText.setText(dibicprogram);
                releaseYearText.setContentDescription(dibicprogram);
            } else
            {
                newReleaseYearContainer.setVisibility(8);
            }
            newReleaseYearContainer.setVisibility(0);
        } else
        {
            newReleaseYearContainer.setVisibility(8);
        }
        if (movieFacade.getExpiresDate() != null)
        {
            availability.setVisibility(0);
            dibicprogram = formatAvailability(movieFacade.getExpiresDate());
            availability.setText(dibicprogram);
            availability.setContentDescription((new StringBuilder()).append(dibicprogram).append(".").toString());
        } else
        {
            availability.setVisibility(8);
        }
        if (!sortedset.isEmpty())
        {
            duration.setVisibility(0);
            duration.setText(UIPresentationUtil.getDuration(getActivity(), ((VideoFacade)sortedset.first()).getDurationInSeconds()));
            duration.setContentDescription(UIPresentationUtil.getDurationSpoken(getActivity(), ((VideoFacade)sortedset.first()).getDurationInSeconds()));
        } else
        {
            duration.setVisibility(8);
        }
        addVideoItems(map, videoentitlement, movieFacade, sortedset, videoItemContainer, layoutInflator, playPressedListener, instanceState.currentlyPlayingVideoId);
        map = movieFacade.getCast();
        if (map != null && !map.isEmpty())
        {
            castText.setVisibility(0);
            castText.setText(map);
            castText.setContentDescription(getResources().getString(com.xfinity.playerlib.R.string.content_description_cast, new Object[] {
                map
            }));
        } else
        {
            castText.setVisibility(8);
        }
        descriptionText.setText(movieFacade.getDescription());
        descriptionText.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_description, new Object[] {
            movieFacade.getDescription()
        }));
        presentReviews(movieFacade.getReviews());
    }

    protected void setDisplayTitle(String s, TextView textview)
    {
        setDisplayTitle(s, textview);
        alternateInterfaceListener.getTalkDelegate().setTitle(getString(com.xfinity.playerlib.R.string.content_description_detail_title, new Object[] {
            "movie", s
        }));
    }

    public void showFailureState(CimException cimexception)
    {
        onLoadingFinished();
        bodyContainer.setVisibility(8);
        detailArtView.setVisibility(8);
        errorText.setVisibility(0);
    }







/*
    static MovieFacade access$402(MovieDetailFragment moviedetailfragment, MovieFacade moviefacade)
    {
        moviedetailfragment.movieFacade = moviefacade;
        return moviefacade;
    }

*/



/*
    static TaskExecutor access$502(MovieDetailFragment moviedetailfragment, TaskExecutor taskexecutor)
    {
        moviedetailfragment.bookmarkProvider = taskexecutor;
        return taskexecutor;
    }

*/



/*
    static TaskExecutionListener access$702(MovieDetailFragment moviedetailfragment, TaskExecutionListener taskexecutionlistener)
    {
        moviedetailfragment.bookmarkListener = taskexecutionlistener;
        return taskexecutionlistener;
    }

*/

}
