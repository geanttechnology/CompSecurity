.class public final Llv;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Landroid/app/Activity;

.field private b:Landroid/media/MediaPlayer;

.field private c:Z

.field private d:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Llv;->a:Landroid/app/Activity;

    .line 28
    const/4 v0, 0x0

    iput-object v0, p0, Llv;->b:Landroid/media/MediaPlayer;

    .line 29
    invoke-virtual {p0}, Llv;->a()V

    .line 30
    return-void
.end method

.method private static a(Landroid/content/Context;)Landroid/media/MediaPlayer;
    .locals 7

    .prologue
    .line 67
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    .line 68
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 69
    new-instance v1, Llv$1;

    invoke-direct {v1}, Llv$1;-><init>()V

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 76
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f070000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->openRawResourceFd(I)Landroid/content/res/AssetFileDescriptor;

    move-result-object v6

    .line 79
    :try_start_0
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v1

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getStartOffset()J

    move-result-wide v2

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getLength()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Landroid/media/MediaPlayer;->setDataSource(Ljava/io/FileDescriptor;JJ)V

    .line 81
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->close()V

    .line 82
    const v1, 0x3dcccccd    # 0.1f

    const v2, 0x3dcccccd    # 0.1f

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaPlayer;->setVolume(FF)V

    .line 83
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->prepare()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    :goto_0
    return-object v0

    .line 84
    :catch_0
    move-exception v0

    .line 85
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static a(Landroid/content/SharedPreferences;Landroid/content/Context;)Z
    .locals 3

    .prologue
    .line 55
    const/4 v1, 0x1

    .line 57
    const-string v0, "audio"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .line 59
    invoke-virtual {v0}, Landroid/media/AudioManager;->getRingerMode()I

    move-result v0

    const/4 v2, 0x2

    if-eq v0, v2, :cond_0

    .line 60
    const/4 v0, 0x0

    .line 63
    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 33
    iget-object v0, p0, Llv;->a:Landroid/app/Activity;

    invoke-static {v0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 35
    iget-object v1, p0, Llv;->a:Landroid/app/Activity;

    invoke-static {v0, v1}, Llv;->a(Landroid/content/SharedPreferences;Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Llv;->c:Z

    .line 36
    const/4 v0, 0x1

    iput-boolean v0, p0, Llv;->d:Z

    .line 37
    iget-boolean v0, p0, Llv;->c:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Llv;->b:Landroid/media/MediaPlayer;

    if-nez v0, :cond_0

    .line 38
    iget-object v0, p0, Llv;->a:Landroid/app/Activity;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setVolumeControlStream(I)V

    .line 39
    iget-object v0, p0, Llv;->a:Landroid/app/Activity;

    invoke-static {v0}, Llv;->a(Landroid/content/Context;)Landroid/media/MediaPlayer;

    move-result-object v0

    iput-object v0, p0, Llv;->b:Landroid/media/MediaPlayer;

    .line 41
    :cond_0
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    .line 44
    iget-boolean v0, p0, Llv;->c:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Llv;->b:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Llv;->b:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 47
    :cond_0
    iget-boolean v0, p0, Llv;->d:Z

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Llv;->a:Landroid/app/Activity;

    const-string v1, "vibrator"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Vibrator;

    .line 50
    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v2, v3}, Landroid/os/Vibrator;->vibrate(J)V

    .line 52
    :cond_1
    return-void
.end method
