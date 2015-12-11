.class Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;
.super Ljava/util/TimerTask;
.source "EPPlayerTrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Milestoneping"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;


# direct methods
.method private constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)V
    .locals 0

    .prologue
    .line 973
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;)V
    .locals 0

    .prologue
    .line 973
    invoke-direct {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 977
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # invokes: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->milestone()V
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$13(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 981
    :goto_0
    return-void

    .line 978
    :catch_0
    move-exception v0

    .line 979
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Unable to send tracking ping"

    const/4 v2, 0x2

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method
