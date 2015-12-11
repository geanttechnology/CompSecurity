.class Lcom/poshmark/webcommands/WebCommandsManager$13;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->postNotification(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$listingId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 762
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$13;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$13;->val$listingId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 2
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 765
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$13;->val$listingId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingEditedMessage(Ljava/lang/String;)V

    .line 766
    return-void
.end method
