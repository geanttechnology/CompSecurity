.class Lcom/poshmark/webcommands/WebCommandsManager$11;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->signOut(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$viewCount:I


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;I)V
    .locals 0

    .prologue
    .line 699
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$11;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$11;->val$viewCount:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 3
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x1

    .line 702
    iget v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$11;->val$viewCount:I

    if-le v0, v2, :cond_0

    .line 703
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$11;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    iget v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$11;->val$viewCount:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/PMActivity;->popTopNFragments(IZ)V

    .line 705
    :cond_0
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$11;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->onBackPressed()V

    .line 706
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->logout(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 707
    const-string v0, "com.poshmark.intents.INITIATE_LOGOUT"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 708
    return-void
.end method
