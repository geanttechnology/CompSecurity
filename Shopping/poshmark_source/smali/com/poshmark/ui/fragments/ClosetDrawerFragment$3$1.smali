.class Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3$1;
.super Ljava/lang/Object;
.source "ClosetDrawerFragment.java"

# interfaces
.implements Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3$1;->this$1:Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public reasonPicked(Ljava/lang/String;)V
    .locals 4
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    .line 152
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 153
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "PARENT_ID"

    new-instance v2, Landroid/os/ParcelUuid;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3$1;->this$1:Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ClosetDrawerFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->parentFragmentId:Ljava/util/UUID;

    invoke-direct {v2, v3}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 154
    const-string v1, "REPORT_REASON"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    const-string v1, "com.poshmark.intents.REPORT_USER_ACTION"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 156
    return-void
.end method
