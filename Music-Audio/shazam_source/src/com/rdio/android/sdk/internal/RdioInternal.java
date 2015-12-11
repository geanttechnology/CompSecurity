// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.google.a.d.e;
import com.google.api.a.a.a.i;
import com.google.b.b;
import com.google.b.b.d;
import com.google.b.f;
import com.google.b.g;
import com.rdio.android.core.AndroidOAuth2Session;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.SharedAsyncEventBus;
import com.rdio.android.core.events.LoadModelsEvent;
import com.rdio.android.core.events.ModelLoaderErrorEvent;
import com.rdio.android.core.events.ModelsLoadedEvent;
import com.rdio.android.core.managers.PlaybackSequenceManager;
import com.rdio.android.core.pubsub.PubSubConnection;
import com.rdio.android.core.remote.RemoteClientStatusChangedEvent;
import com.rdio.android.core.reporting.PlaybackEventReporter;
import com.rdio.android.core.sequencing.SequencerUnit;
import com.rdio.android.core.stations.StationGenerator;
import com.rdio.android.core.util.AndroidLogging;
import com.rdio.android.core.util.Logging;
import com.rdio.android.sdk.OAuth2Credential;
import com.rdio.android.sdk.PlayerManager;
import com.rdio.android.sdk.RdioApiCallback;
import com.rdio.android.sdk.RdioListener;
import com.rdio.android.sdk.RdioResponseListener;
import com.rdio.android.sdk.RdioService;
import com.rdio.android.sdk.internal.sequencing.ExclusionAnnotationStrategy;
import com.rdio.android.sdk.internal.sequencing.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.spec.IvParameterSpec;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.sdk.internal:
//            Crypto, PlayerManagerInternal, RdioFullService, PlaybackStateChangedEvent, 
//            SdkRemoteClientManager, KeyParser, PlayTrackKeyEvent, EventUploader, 
//            PositionTracker, LightStationGenerator

public class RdioInternal
{

    protected static final byte ENCRYPTED_INTERNAL_ID[] = {
        -68, 113, 82, -59, 5, 10, 60, -38, -104, -38, 
        67, -88, 0, -16, -127, -17, -29, 53, -9, 67, 
        -41, 97, -96, -113, 92, 42, -82, -78, -62, -29, 
        15, -108
    };
    protected static final byte ENCRYPTED_INTERNAL_SECRET[] = {
        57, -122, -15, 10, 39, 0, -78, 78, -109, 4, 
        -54, -123, 103, -67, -34, 41, -122, -98, -41, -21, 
        113, -8, 72, 13, 88, 64, 10, 92, 57, -13, 
        64, -45
    };
    private static final String KEY = "Why are you reading this? The time it will take to decrypt is worth more than a one year Rdio subscription. If you want to steal music stick with BitTorrent.";
    private static byte KEY_PHASE_2[] = "adf7b618-afc6-4912-a4ca-0c74048d526f".getBytes();
    private String API_VERSION;
    private String LOG_NAME;
    private RdioService appService;
    private Context context;
    private String developerClientId;
    private String developerClientSecret;
    private e eventBus;
    private EventUploader eventUploader;
    private f gson;
    private boolean hasReturnedAppService;
    private RdioListener listener;
    private Handler mHandler;
    private PlayerManagerInternal manager;
    private SdkRemoteClientManager masterManager;
    private boolean pendingPrepareForPlayback;
    private PlaybackEventReporter playbackEventReporter;
    private String playbackToken;
    private final String playerName = (new StringBuilder("android-api-")).append(Math.random()).toString();
    private PositionTracker positionTracker;
    private PubSubConnection pubSubConnection;
    private RdioFullService rdioService;
    private OAuth2Credential savedCredential;
    private PlaybackSequenceManager sequenceManager;
    private boolean servicesAreReady;
    private StationGenerator stationGenerator;

    public RdioInternal(String s, String s1, OAuth2Credential oauth2credential, Context context1, RdioListener rdiolistener)
    {
        API_VERSION = "20150324";
        LOG_NAME = "rdio";
        playbackToken = null;
        servicesAreReady = true;
        pendingPrepareForPlayback = false;
        hasReturnedAppService = false;
        developerClientId = s;
        developerClientSecret = s1;
        savedCredential = oauth2credential;
        eventBus = new SharedAsyncEventBus(new AndroidLogging());
        listener = rdiolistener;
        context = context1;
        mHandler = new Handler(Looper.getMainLooper());
    }

    private void fetchPlaybackToken()
    {
        appService.getPlaybackToken(new RdioResponseListener() {

            final RdioInternal this$0;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                if (!rdioapiresponse.isSuccess())
                {
                    Log.e(LOG_NAME, "The playback token response failed");
                    postOnError(com.rdio.android.sdk.Rdio.RdioError.PLAYBACK_TOKEN, "The playback token response failed");
                    return;
                }
                try
                {
                    playbackToken = ((JSONObject)rdioapiresponse.getResult()).getString("result");
                }
                // Misplaced declaration of an exception variable
                catch (RdioApiResponse rdioapiresponse)
                {
                    Log.e(LOG_NAME, (new StringBuilder("There was an error parsing the playbackToken ")).append(rdioapiresponse).toString());
                    postOnError(com.rdio.android.sdk.Rdio.RdioError.PLAYBACK_TOKEN, "There was a problem parsing the playback token request");
                    return;
                }
                eventUploader.setPlaybackToken(playbackToken);
                manager.setPlaybackToken(playbackToken);
                pubSubConnection.disconnect();
                pubSubConnection.connect();
                mHandler.post(new Runnable() {

                    final _cls10 this$1;

                    public void run()
                    {
                        listener.onRdioReadyForPlayback();
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                });
            }

            
            {
                this$0 = RdioInternal.this;
                super();
            }
        });
    }

    private String[] getSecrets()
    {
        String s;
        Object obj;
        try
        {
            if (KEY_PHASE_2.length > 32)
            {
                KEY_PHASE_2 = Crypto.md5Bytes("Why are you reading this? The time it will take to decrypt is worth more than a one year Rdio subscription. If you want to steal music stick with BitTorrent.".getBytes());
            }
            obj = new IvParameterSpec(Crypto.AES_IV);
            javax.crypto.SecretKey secretkey = Crypto.makeKey(KEY_PHASE_2);
            byte abyte0[] = Crypto.runCipher(secretkey, ((IvParameterSpec) (obj)), 2, ENCRYPTED_INTERNAL_ID, true);
            byte abyte1[] = Crypto.runCipher(secretkey, ((IvParameterSpec) (obj)), 2, ENCRYPTED_INTERNAL_SECRET, true);
            s = new String(abyte0);
            abyte1 = new String(abyte1);
        }
        catch (Exception exception)
        {
            Log.e(LOG_NAME, (new StringBuilder("API Error: ")).append(exception).toString());
            return null;
        }
        return (new String[] {
            s, abyte1
        });
    }

    private void hookUpEventBus()
    {
        eventBus.register(this);
        eventBus.register(manager);
        eventBus.register(masterManager);
        eventBus.register(positionTracker);
        eventBus.register(playbackEventReporter);
    }

    public void apiCall(final String method, List list, final RdioApiCallback callback)
    {
        ArrayList arraylist = new ArrayList();
        NameValuePair namevaluepair;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new RdioApiRequestArg(namevaluepair.getName(), namevaluepair.getValue())))
        {
            namevaluepair = (NameValuePair)list.next();
        }

        arraylist.add(new RdioApiRequestArg("method", method));
        method = new RdioResponseListener() {

            final RdioInternal this$0;
            final RdioApiCallback val$callback;
            final String val$method;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                if (rdioapiresponse.isSuccess())
                {
                    rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
                    callback.onApiSuccess(rdioapiresponse);
                    return;
                } else
                {
                    callback.onApiFailure(method, null);
                    return;
                }
            }

            
            {
                this$0 = RdioInternal.this;
                callback = rdioapicallback;
                method = s;
                super();
            }
        };
        appService.postRequest((RdioApiRequestArg[])(RdioApiRequestArg[])arraylist.toArray(), method);
    }

    public void cleanup()
    {
        manager.cleanUp();
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
        eventBus.unregister(this);
        eventBus.unregister(manager);
        eventBus.unregister(masterManager);
        eventBus.unregister(positionTracker);
        eventBus.unregister(playbackEventReporter);
        eventBus.unregister(stationGenerator);
        eventBus.unregister(sequenceManager);
        pubSubConnection.disconnect();
        manager = null;
        rdioService = null;
        appService = null;
        listener = null;
        eventBus = null;
    }

    public String getAuthUrl(String s)
    {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        return appService.beginAuthorizeUser("foo", s, null, null, new com.rdio.android.core.OAuth2Session.OAuth2ClientCredentialsListener() {

            final RdioInternal this$0;

            public void onCredentialRefreshed(i j)
            {
                postRdioAuthorized(new OAuth2Credential(j.a(), j.b(), j.c()));
            }

            public void onError(String s1)
            {
                Log.e(LOG_NAME, (new StringBuilder("Error authorizing user! ")).append(s1).toString());
                postOnError(com.rdio.android.sdk.Rdio.RdioError.AUTHORIZATION, s1);
            }

            public void onReceivedCredentials(i j)
            {
                postRdioAuthorized(new OAuth2Credential(j.a(), j.b(), j.c()));
            }

            
            {
                this$0 = RdioInternal.this;
                super();
            }
        });
    }

    public f getGson()
    {
        if (gson == null)
        {
            g g1 = new g();
            ExclusionAnnotationStrategy exclusionannotationstrategy = new ExclusionAnnotationStrategy();
            for (int i = 0; i <= 0; i++)
            {
                b b1 = (new b[] {
                    exclusionannotationstrategy
                })[0];
                d d1 = g1.a;
                d d2 = d1.a();
                d2.f = new ArrayList(d1.f);
                d2.f.add(b1);
                d2.g = new ArrayList(d1.g);
                d2.g.add(b1);
                g1.a = d2;
            }

            gson = g1.a();
        }
        return gson;
    }

    public PlayerManager getPlayerManager()
    {
        return manager;
    }

    public boolean isReady()
    {
        return playbackToken != null;
    }

    public void onLoadModels(final LoadModelsEvent event)
    {
        com.rdio.android.core.RdioService_Api.ResponseListener responselistener = new com.rdio.android.core.RdioService_Api.ResponseListener() {

            final RdioInternal this$0;
            final LoadModelsEvent val$event;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                if (!rdioapiresponse.isSuccess())
                {
                    rdioapiresponse = new ModelLoaderErrorEvent("onLoadModels: Response unsuccessful.", event, event.getRequester(), event.getEventId());
                    eventBus.post(rdioapiresponse);
                    return;
                }
                ArrayList arraylist = new ArrayList();
                rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
                for (Iterator iterator = rdioapiresponse.keys(); iterator.hasNext();)
                {
                    String s = (String)iterator.next();
                    try
                    {
                        arraylist.add(Utils.createNewModel(getGson(), s, rdioapiresponse.getJSONObject(s)));
                    }
                    catch (JSONException jsonexception)
                    {
                        ModelLoaderErrorEvent modelloadererrorevent = new ModelLoaderErrorEvent("onLoadModels: Error parsing JSON", event, event.getRequester(), event.getEventId());
                        eventBus.post(modelloadererrorevent);
                    }
                }

                rdioapiresponse = new ModelsLoadedEvent(arraylist, event.getKeys(), arraylist.size(), false, false, event.getRequester(), event.getEventId());
                eventBus.post(rdioapiresponse);
            }

            
            {
                this$0 = RdioInternal.this;
                event = loadmodelsevent;
                super();
            }
        };
        rdioService.get(event.getKeys(), null, event.getExtras(), false, event, responselistener);
    }

    public void onMasterStatusChange(RemoteClientStatusChangedEvent remoteclientstatuschangedevent)
    {
        if (remoteclientstatuschangedevent.getStatus() == com.rdio.android.core.remote.RemoteClientManager.Status.Elsewhere && manager.isPlaying())
        {
            manager.pause();
            mHandler.post(new Runnable() {

                final RdioInternal this$0;

                public void run()
                {
                    listener.onRdioUserPlayingElsewhere();
                }

            
            {
                this$0 = RdioInternal.this;
                super();
            }
            });
        }
    }

    public void onPlaybackStateChanged(PlaybackStateChangedEvent playbackstatechangedevent)
    {
        boolean flag;
        if (playbackstatechangedevent.getState() == PlaybackStateChangedEvent.State.Playing)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        masterManager.setPlayState(flag);
        if (flag && masterManager.getStatus() != com.rdio.android.core.remote.RemoteClientManager.Status.Master)
        {
            masterManager.publishMasterPlayer();
        }
    }

    public void playTrack(String s, String s1, boolean flag)
    {
        if (s1 != null && !KeyParser.isAlbumKey(s1) && !KeyParser.isPlaylistKey(s1) && !KeyParser.isTrackKey(s1))
        {
            throw new com.rdio.android.sdk.Rdio.InvalidKeyException((new StringBuilder("Source key is not a valid type: ")).append(s1).toString());
        } else
        {
            manager.onPlayAudio(new PlayTrackKeyEvent(s, s1, flag, 0));
            return;
        }
    }

    public void postApiServiceReady()
    {
        mHandler.post(new Runnable() {

            final RdioInternal this$0;

            public void run()
            {
                listener.onApiServiceReady(appService);
            }

            
            {
                this$0 = RdioInternal.this;
                super();
            }
        });
    }

    public void postOnError(final com.rdio.android.sdk.Rdio.RdioError error, final String msg)
    {
        mHandler.post(new Runnable() {

            final RdioInternal this$0;
            final com.rdio.android.sdk.Rdio.RdioError val$error;
            final String val$msg;

            public void run()
            {
                listener.onError(error, msg);
            }

            
            {
                this$0 = RdioInternal.this;
                error = rdioerror;
                msg = s;
                super();
            }
        });
    }

    public void postRdioAuthorized(final OAuth2Credential credential)
    {
        mHandler.post(new Runnable() {

            final RdioInternal this$0;
            final OAuth2Credential val$credential;

            public void run()
            {
                listener.onRdioAuthorised(credential);
            }

            
            {
                this$0 = RdioInternal.this;
                credential = oauth2credential;
                super();
            }
        });
    }

    public void prepareForPlayback()
    {
        if (servicesAreReady)
        {
            fetchPlaybackToken();
            return;
        } else
        {
            pendingPrepareForPlayback = true;
            return;
        }
    }

    public void requestApiService(String s)
    {
        if (rdioService != null && appService != null)
        {
            postApiServiceReady();
            return;
        }
        String as[] = getSecrets();
        rdioService = new RdioFullService(API_VERSION, context, new AndroidOAuth2Session(as[0], as[1], null, null, null));
        rdioService.authorizeClient(new com.rdio.android.core.OAuth2RdioService.ClientAuthorizedListener() {

            final RdioInternal this$0;

            public void onAuthorized(i i)
            {
            }

            public void onError(String s2)
            {
                postOnError(com.rdio.android.sdk.Rdio.RdioError.AUTHORIZATION, s2);
            }

            
            {
                this$0 = RdioInternal.this;
                super();
            }
        });
        Object obj;
        String s1;
        Long long1;
        if (savedCredential != null)
        {
            obj = savedCredential.accessToken;
        } else
        {
            obj = null;
        }
        if (savedCredential != null)
        {
            s1 = savedCredential.refreshToken;
        } else
        {
            s1 = null;
        }
        if (savedCredential != null)
        {
            long1 = savedCredential.expirationTimeMSec;
        } else
        {
            long1 = null;
        }
        obj = new AndroidOAuth2Session(developerClientId, developerClientSecret, ((String) (obj)), s1, long1);
        appService = new RdioService(s, context, ((com.rdio.android.core.OAuth2Session) (obj)));
        appService.authorizeClient(new com.rdio.android.core.OAuth2RdioService.ClientAuthorizedListener() {

            final RdioInternal this$0;

            public void onAuthorized(i j)
            {
                servicesAreReady = true;
                if (!hasReturnedAppService)
                {
                    hasReturnedAppService = true;
                    postApiServiceReady();
                }
                postRdioAuthorized(new OAuth2Credential(j.a(), j.b(), j.c()));
                if (pendingPrepareForPlayback)
                {
                    fetchPlaybackToken();
                    pendingPrepareForPlayback = false;
                }
            }

            public void onError(String s2)
            {
                postOnError(com.rdio.android.sdk.Rdio.RdioError.AUTHORIZATION, s2);
            }

            
            {
                this$0 = RdioInternal.this;
                super();
            }
        });
        try
        {
            manager = new PlayerManagerInternal(context, playerName, rdioService, eventBus, listener, mHandler);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            postOnError(com.rdio.android.sdk.Rdio.RdioError.INITIALIZATION, (new StringBuilder("There was an initialization error : ")).append(s).toString());
        }
        eventUploader = new EventUploader(rdioService, eventBus, new AndroidLogging());
        playbackEventReporter = new PlaybackEventReporter(1, eventUploader, eventBus, new AndroidLogging());
        positionTracker = new PositionTracker(eventBus, manager);
        masterManager = new SdkRemoteClientManager(playerName, appService, eventBus, new AndroidLogging());
        pubSubConnection = new PubSubConnection(playerName, false, appService, eventBus, new AndroidLogging());
        stationGenerator = new LightStationGenerator(rdioService, eventBus, getGson());
        sequenceManager = new PlaybackSequenceManager(eventBus, new AndroidLogging()) {

            final RdioInternal this$0;

            public boolean canGoNext()
            {
                return true;
            }

            public boolean canGoPrev()
            {
                return true;
            }

            public SequencerUnit instantiateSequenceUnit(Class class1)
            {
                return (SequencerUnit)class1.newInstance();
            }

            
            {
                this$0 = RdioInternal.this;
                super(e1, logging);
            }
        };
        hookUpEventBus();
    }








/*
    static boolean access$202(RdioInternal rdiointernal, boolean flag)
    {
        rdiointernal.servicesAreReady = flag;
        return flag;
    }

*/



/*
    static boolean access$302(RdioInternal rdiointernal, boolean flag)
    {
        rdiointernal.hasReturnedAppService = flag;
        return flag;
    }

*/



/*
    static boolean access$402(RdioInternal rdiointernal, boolean flag)
    {
        rdiointernal.pendingPrepareForPlayback = flag;
        return flag;
    }

*/





/*
    static String access$702(RdioInternal rdiointernal, String s)
    {
        rdiointernal.playbackToken = s;
        return s;
    }

*/


}
