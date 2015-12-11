.class public Lcom/xfinity/playerlib/view/videoplay/RemoteControlReceiver;
.super Landroid/content/BroadcastReceiver;
.source "RemoteControlReceiver.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/xfinity/playerlib/view/videoplay/RemoteControlReceiver;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/RemoteControlReceiver;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 17
    const-string v2, "android.intent.action.MEDIA_BUTTON"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 18
    const-string v2, "android.intent.extra.KEY_EVENT"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/view/KeyEvent;

    .line 19
    .local v0, "event":Landroid/view/KeyEvent;
    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.xfinity.playerlib.videoplay.KEY_PRESSED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 20
    .local v1, "i":Landroid/content/Intent;
    const-string v2, "android.intent.extra.KEY_EVENT"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 21
    invoke-virtual {p1, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 23
    .end local v0    # "event":Landroid/view/KeyEvent;
    .end local v1    # "i":Landroid/content/Intent;
    :cond_0
    return-void
.end method
