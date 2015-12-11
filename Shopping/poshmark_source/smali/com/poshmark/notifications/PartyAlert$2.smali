.class final Lcom/poshmark/notifications/PartyAlert$2;
.super Ljava/lang/Object;
.source "PartyAlert.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/notifications/PartyAlert;->showAlert(Lcom/poshmark/ui/PMActivity;Landroid/os/Bundle;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$bundle:Landroid/os/Bundle;

.field final synthetic val$topActivity:Lcom/poshmark/ui/PMActivity;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/PMActivity;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/poshmark/notifications/PartyAlert$2;->val$topActivity:Lcom/poshmark/ui/PMActivity;

    iput-object p2, p0, Lcom/poshmark/notifications/PartyAlert$2;->val$bundle:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    const/4 v3, 0x0

    .line 37
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "party"

    const-string v2, "join_party_notification_clicked"

    invoke-virtual {v0, v3, v1, v2, v3}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    iget-object v0, p0, Lcom/poshmark/notifications/PartyAlert$2;->val$topActivity:Lcom/poshmark/ui/PMActivity;

    iget-object v1, p0, Lcom/poshmark/notifications/PartyAlert$2;->val$bundle:Landroid/os/Bundle;

    const-class v2, Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 40
    return-void
.end method
