.class public Lcom/xfinity/playerlib/view/videoplay/VideoTracker;
.super Ljava/lang/Object;
.source "VideoTracker.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final sharedPreferencesProvider:Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const-class v0, Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoTracker;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;)V
    .locals 0
    .param p1, "sharedPreferencesProvider"    # Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTracker;->sharedPreferencesProvider:Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;

    .line 14
    return-void
.end method


# virtual methods
.method public getPosition(J)I
    .locals 3
    .param p1, "videoId"    # J

    .prologue
    .line 17
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoTracker;->sharedPreferencesProvider:Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;->getSharedPreferencesForCurrentUser()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    const/4 v2, -0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method
